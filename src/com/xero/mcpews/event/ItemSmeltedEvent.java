package com.xero.mcpews.event;

public class ItemSmeltedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ItemSmelted", ItemSmeltedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}