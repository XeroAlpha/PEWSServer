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

import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.Origin;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A WebSocket Server which can communicate to Minecraft clients,
 * enabling observing what happened in the Minecraft and executing
 * commands remotely.
 * @author ProjectXero
 */

public class WSServer extends WebSocketServer {
    private MCListenerFactory mFactory;
    private Map<WebSocket, MCClient> mClientMap;
    private Runnable mOnStartListener;

    /**
     * Creates a WSServer that will attempt to bind/listen on the given <var>address</var>.
     * @param address The address (host:port) this server should listen on.
     * @param factory The factory this server use to create listeners.
     */
    public WSServer(InetSocketAddress address, MCListenerFactory factory) {
        super(address);
        if (factory == null) throw new IllegalArgumentException("Factory cannot be null.");
        mFactory = factory;
        mClientMap = new HashMap<>();
        setConnectionLostTimeout(-1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        mClientMap.put(conn, new MCClient(this, conn, mFactory));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        MCClient client = mClientMap.remove(conn);
        client.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onMessage(WebSocket conn, String message) {
        MCClient client = mClientMap.get(conn);
        if (client != null) {
            client.onMessage(message);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onError(WebSocket conn, Exception ex) {
        MCClient client = mClientMap.get(conn);
        if (client != null) {
            client.onError(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart() {
        if (mOnStartListener != null) mOnStartListener.run();
    }

    /**
     * @see WebSocketServer#start()
     * @param callback Callback when server started.
     */
    public void start(Runnable callback) {
        mOnStartListener = callback;
    }

    /**
     * Returns all currently connected client(s).
     * This collection does not allow any modification e.g. removing a client.
     * @return A unmodifiable collection of all currently connected clients
     */
    public Collection<MCClient> getClients(){
        return mClientMap.values();
    }

    /**
     * Request all connected Minecraft clients to execute a command.
     * @param command text the text to send to the endpoints
     */
    public void broadcastCommand(Command command) {
        for (MCClient client : getClients()) client.sendCommand(command);
    }

    /**
     * Request all connected Minecraft clients to execute a command.
     * @param origin the origin to execute the command
     * @param command the command will be executed
     */
    public void broadcastCommand(Origin origin, Command command) {
        for (MCClient client : getClients()) client.sendCommand(origin, command);
    }

    /**
     * Request all connected Minecraft clients to execute a command.
     * @param origin the origin to execute the command
     * @param command the command will be executed
     */
    public void broadcastCommand(Origin origin, String command) {
        for (MCClient client : getClients()) client.sendCommand(origin, command);
    }
}
