package com.xero.mcpews.event;

public class WorldUnloadedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("WorldUnloaded", WorldUnloadedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}