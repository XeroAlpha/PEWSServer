package com.xero.mcpews.event;

public class ItemDestroyedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ItemDestroyed", ItemDestroyedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}