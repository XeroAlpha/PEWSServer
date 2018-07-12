package com.xero.mcpews.event;

public class BlockPlacedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("BlockPlaced", BlockPlacedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}