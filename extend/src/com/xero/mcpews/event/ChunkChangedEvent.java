package com.xero.mcpews.event;

public class ChunkChangedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ChunkChanged", ChunkChangedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}