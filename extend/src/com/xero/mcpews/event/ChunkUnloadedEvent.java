package com.xero.mcpews.event;

public class ChunkUnloadedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ChunkUnloaded", ChunkUnloadedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}