package com.xero.mcpews.event;

public class WorldLoadedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("WorldLoaded", WorldLoadedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}