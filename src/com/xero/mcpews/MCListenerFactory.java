package com.xero.mcpews;

import org.java_websocket.WebSocket;

public abstract class MCListenerFactory {
    public abstract MCListener create(WebSocket conn);
}
