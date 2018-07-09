package com.xero.mcpews.event;

public class ItemCraftedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ItemCrafted", ItemCraftedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}