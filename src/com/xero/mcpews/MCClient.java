package com.xero.mcpews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.CommandResponse;
import com.xero.mcpews.command.Origin;
import com.xero.mcpews.event.EventType;
import com.xero.mcpews.frame.*;
import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class MCClient {
    public static Gson gson = new GsonBuilder()
            .create();

    private WSServer mServer;
    private WebSocket mConnection;
    private MCListener mListener;
    private boolean mIsDestroyed;

    private Map<String, MCEventReceiver> mReceivers;
    private Map<String, Command> mCommandSessions;

    MCClient(WSServer server, WebSocket conn, MCListenerFactory factory) {
        mIsDestroyed = false;
        mServer = server;
        mConnection = conn;
        mReceivers = new HashMap<>();
        mCommandSessions = new HashMap<>();
        mListener = factory.create(conn);
        mListener.onCreate(this);
    }

    void onDestroy() {
        if (mIsDestroyed) return;
        mListener.onDestroy(this);
        mIsDestroyed = true;
        mServer = null;
        mConnection = null;
        mListener = null;
        mReceivers = null;
    }

    void onMessage(String message) {
        Frame frame = Frame.fromJson(message);
        Purpose purpose = frame.getPurpose();
        if (Purpose.EVENT.equals(purpose)) {
            onReceiveEvent((EventBody) frame.getBody());
        } else if (Purpose.ERROR.equals(purpose)) {
            onMCError((ErrorBody) frame.getBody());
        } else if (Purpose.COMMAND_RESPONSE.equals(purpose)) {
            onCommandResponse(frame.getHeader().getRequestId(), (ResponseBody) frame.getBody());
        } else {
            System.out.println("Warning! Unknown frame: " + message);
        }
    }

    void onError(Exception ex) {
        ex.printStackTrace();
    }

    private void ensureAvailable() {
        if (mIsDestroyed) throw new IllegalStateException("Client has been destroyed.");
    }

    @SuppressWarnings("unchecked")
    private void onReceiveEvent(EventBody body) {
        ensureAvailable();
        MCEventReceiver receiver = mReceivers.get(body.getEventName());
        if (receiver != null) {
            receiver.onReceiveEvent(this, body.getProperties());
        }
    }

    private void onMCError(MCError error) {
        ensureAvailable();
        mListener.onError(this, error);
    }

    @SuppressWarnings("unchecked")
    private void onCommandResponse(String requestId, ResponseBody body) {
        Command request = mCommandSessions.remove(requestId);
        CommandResponse response = request.serializeResponse(body.getOriginJson(), gson);
        MCResponseReceiver receiver = request.getResponseReceiver();
        if (receiver == null) return;
        response.setSource(request);
        receiver.onReceiveResponse(response);
    }

    public boolean isAvailable() {
        return !mIsDestroyed;
    }

    public void destroy() {
        if (!mConnection.isClosing() || !mConnection.isClosed()) {
            mConnection.close();
        }
    }

    public MCEventReceiver registerReceiver(EventType type, MCEventReceiver receiver) {
        ensureAvailable();
        mReceivers.put(type.getId(), receiver);
        mConnection.send(Frame.fromBody(SubscribeBody.create(type)).toJson());
        return receiver;
    }

    public MCEventReceiver unregisterReceiver(EventType type) {
        ensureAvailable();
        mConnection.send(Frame.fromBody(UnsubscribeBody.create(type)).toJson());
        return mReceivers.remove(type.getId());
    }

    public boolean canReceiveEvent(EventType type) {
        return !mIsDestroyed || mReceivers.containsKey(type.getId());
    }

    public MCEventReceiver getReceiver(EventType type) {
        return mReceivers.get(type.getId());
    }

    public void sendCommand(Command command) {
        sendCommand(Origin.PLAYER, command);
    }

    public void sendCommand(Origin origin, Command command) {
        Frame frame = Frame.fromBody(CommandBody.create(command));
        mCommandSessions.put(frame.getHeader().getRequestId(), command);
        mConnection.send(frame.toJson());
    }

    public void sendCommand(Origin origin, String command) {
        Frame frame = Frame.fromBody(CommandBody.create(origin, command));
        mConnection.send(frame.toJson());
    }

    public void sendCommand(Origin origin, String command, MCResponseReceiver<Command.StringResponse> receiver) {
        Command cmd = Command.StringCommand.create(command).responseTo(receiver);
        Frame frame = Frame.fromBody(CommandBody.create(origin, command));
        mCommandSessions.put(frame.getHeader().getRequestId(), cmd);
        mConnection.send(frame.toJson());
    }
}
