package com.xero.mcpews.event;

public class PlayerJoinEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerJoin", PlayerJoinEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}