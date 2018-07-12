package com.xero.mcpews.event;

public class WorldGeneratedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("WorldGenerated", WorldGeneratedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}