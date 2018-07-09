package com.xero.mcpews.event;

public class ItemUsedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ItemUsed", ItemUsedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}