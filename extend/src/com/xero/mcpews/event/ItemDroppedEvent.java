package com.xero.mcpews.event;

public class ItemDroppedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ItemDropped", ItemDroppedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}