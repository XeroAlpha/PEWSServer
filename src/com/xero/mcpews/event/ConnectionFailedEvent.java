package com.xero.mcpews.event;

public class ConnectionFailedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ConnectionFailed", ConnectionFailedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}