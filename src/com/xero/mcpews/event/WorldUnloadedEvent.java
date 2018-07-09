package com.xero.mcpews.event;

public class WorldUnloadedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("WorldUnloaded", WorldUnloadedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}