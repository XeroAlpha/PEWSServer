package com.xero.mcpews.event;

public class StartClientEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("StartClient", StartClientEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}