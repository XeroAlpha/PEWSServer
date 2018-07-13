/*
 * PEWSServer
 * Copyright (C) 2018  ProjectXero
 * E-mail: projectxero@163.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 */

package com.xero.mcpews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.CommandResponse;
import com.xero.mcpews.command.Origin;
import com.xero.mcpews.event.Event;
import com.xero.mcpews.event.EventType;
import com.xero.mcpews.frame.*;
import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a Minecraft client, providing method to interact with remote client.
 * @author ProjectXero
 */

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
        if (mListener != null) mListener.onException(this, ex);
    }

    private void ensureAvailable() {
        if (mIsDestroyed) throw new IllegalStateException("Client has been destroyed.");
    }

    @SuppressWarnings("unchecked")
    private void onReceiveEvent(EventBody body) {
        MCEventReceiver receiver = mReceivers.get(body.getEventName());
        if (receiver != null) {
            try {
                receiver.onReceiveEvent(this, body.getProperties());
            } catch (Exception e) {
                if (mListener != null) mListener.onException(this, e);
            }
        }
    }

    private void onMCError(MCError error) {
        mListener.onError(this, error);
    }

    @SuppressWarnings("unchecked")
    private void onCommandResponse(String requestId, ResponseBody body) {
        Command request = mCommandSessions.remove(requestId);
        CommandResponse response = request.deserializeResponse(body.getOriginJson(), gson);
        MCResponseReceiver receiver = request.getResponseReceiver();
        if (receiver == null) return;
        try {
            response.setSource(request);
            receiver.onReceiveResponse(this, response);
        } catch (Exception e) {
            if (mListener != null) mListener.onException(this, e);
        }
    }

    /**
     * Return whether the client is connected to .
     * @return true if the client is connected.
     */
    public boolean isAvailable() {
        return !mIsDestroyed;
    }

    /**
     * Close this connection.
     */
    public void destroy() {
        ensureAvailable();
        if (!mConnection.isClosing() || !mConnection.isClosed()) {
            mConnection.close();
        }
    }

    /**
     * Register a {@code EventReceiver} in the client and subscribe a specified event.
     * @param type the specified type of event to subscribe
     * @param receiver the receiver to receive events of the specified type
     * @return This MCClient object to allow for chaining of calls to methods
     */
    public MCClient registerReceiver(EventType type, MCEventReceiver receiver) {
        ensureAvailable();
        mReceivers.put(type.getId(), receiver);
        mConnection.send(Frame.fromBody(SubscribeBody.create(type)).toJson());
        return this;
    }

    /**
     * Unregister a {@code EventReceiver} in the client and unsubscribe a specified event.
     * @param type the specified type of event to unsubscribe
     * @return This MCClient object to allow for chaining of calls to methods
     */
    public MCClient unregisterReceiver(EventType type) {
        ensureAvailable();
        mConnection.send(Frame.fromBody(UnsubscribeBody.create(type)).toJson());
        return this;
    }

    /**
     * Register a {@code EventReceiver} in the client and subscribe a specified event.
     * @param type the specified type of event to subscribe
     * @param receiver the receiver to receive events of the specified type
     * @return This MCClient object to allow for chaining of calls to methods
     * @deprecated Using string to specify a type of event is inconvenient and not recommended.
     */
    @Deprecated
    public MCClient registerReceiver(String type, MCEventReceiver<Event.Raw> receiver) {
        ensureAvailable();
        mReceivers.put(type, receiver);
        mConnection.send(Frame.fromBody(SubscribeBody.create(type)).toJson());
        return this;
    }

    /**
     * Unregister a {@code EventReceiver} in the client and unsubscribe a specified event.
     * @param type the specified type of event to unsubscribe
     * @return This MCClient object to allow for chaining of calls to methods
     * @deprecated Using string to specify a type of event is inconvenient and not recommended.
     */
    @Deprecated
    public MCClient unregisterReceiver(String type) {
        ensureAvailable();
        mConnection.send(Frame.fromBody(UnsubscribeBody.create(type)).toJson());
        return this;
    }

    /**
     * Test events of a specified type can be received by any registered {@code EventReceiver}.
     * @param type the specified type of event
     * @return true if the specified type of event has been subscribed
     */
    public boolean canReceiveEvent(EventType type) {
        return !mIsDestroyed || mReceivers.containsKey(type.getId());
    }

    /**
     * Return whether a receiver exists which receives events of a specified type.
     * @param type the specified type of event
     * @return the receiver, or {@code null} if there is no receiver can receive the specified type of event
     */
    public MCEventReceiver getReceiver(EventType type) {
        ensureAvailable();
        return mReceivers.get(type.getId());
    }

    /**
     * Request current Minecraft client to execute a command.
     * @param command the command to be executed
     * @return This MCClient object to allow for chaining of calls to methods
     */
    public MCClient sendCommand(Command command) {
        ensureAvailable();
        sendCommand(Origin.PLAYER, command);
        return this;
    }

    /**
     * Request current Minecraft client to execute a command.
     * @param origin the origin to execute the command
     * @param command the command to be executed
     * @return This MCClient object to allow for chaining of calls to methods
     */
    public MCClient sendCommand(Origin origin, Command command) {
        ensureAvailable();
        Frame frame = Frame.fromBody(CommandBody.create(origin, command));
        mCommandSessions.put(frame.getHeader().getRequestId(), command);
        mConnection.send(frame.toJson());
        return this;
    }

    /**
     * Request current Minecraft client to execute a command.
     * @param origin the origin to execute the command
     * @param command the command to be executed
     * @return This MCClient object to allow for chaining of calls to methods
     */
    public MCClient sendCommand(Origin origin, String command) {
        ensureAvailable();
        Frame frame = Frame.fromBody(CommandBody.create(origin, command));
        mConnection.send(frame.toJson());
        return this;
    }

    /**
     * Request current Minecraft client to execute a command.
     * @param origin the origin to execute the command
     * @param command the command to be executed
     * @param receiver the receiver to receive
     * @return This MCClient object to allow for chaining of calls to methods
     * @deprecated Using string command is not recommend. Please use {@code sendCommand(Origin, Command)} instead.
     */
    @Deprecated
    public MCClient sendCommand(Origin origin, String command, MCResponseReceiver<Command.StringResponse> receiver) {
        ensureAvailable();
        Command cmd = Command.StringCommand.create(command).responseTo(receiver);
        Frame frame = Frame.fromBody(CommandBody.create(origin, command));
        mCommandSessions.put(frame.getHeader().getRequestId(), cmd);
        mConnection.send(frame.toJson());
        return this;
    }
}
