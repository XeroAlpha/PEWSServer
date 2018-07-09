package com.xero.mcpews.event;

public class ChunkLoadedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ChunkLoaded", ChunkLoadedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}