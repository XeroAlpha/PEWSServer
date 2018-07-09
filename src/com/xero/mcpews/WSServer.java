package com.xero.mcpews;

import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.Origin;
import com.xero.mcpews.frame.CommandBody;
import com.xero.mcpews.frame.Frame;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WSServer extends WebSocketServer {
    private MCListenerFactory mFactory;
    private Map<WebSocket, MCClient> mClientMap;

    public WSServer(InetSocketAddress address, MCListenerFactory factory) {
        super(address);
        if (factory == null) throw new IllegalArgumentException("Factory cannot be null.");
        mFactory = factory;
        mClientMap = new HashMap<>();
        setConnectionLostTimeout(-1);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        mClientMap.put(conn, new MCClient(this, conn, mFactory));
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        MCClient client = mClientMap.remove(conn);
        client.onDestroy();
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        MCClient client = mClientMap.get(conn);
        if (client != null) {
            client.onMessage(message);
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        MCClient client = mClientMap.get(conn);
        if (client != null) {
            client.onError(ex);
        }
    }

    @Override
    public void onStart() {
        //do nothing
    }

    public Collection<MCClient> getClients(){
        return mClientMap.values();
    }

    public void broadcastCommand(Command command) {
        for (MCClient client : getClients()) client.sendCommand(command);
    }

    public void broadcastCommand(Origin origin, Command command) {
        for (MCClient client : getClients()) client.sendCommand(origin, command);
    }

    @Deprecated
    public void broadcastCommand(Origin origin, String command) {
        for (MCClient client : getClients()) client.sendCommand(origin, command);
    }
}
