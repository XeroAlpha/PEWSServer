package com.xero.mcpews.event;

public class ItemAcquiredEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ItemAcquired", ItemAcquiredEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}