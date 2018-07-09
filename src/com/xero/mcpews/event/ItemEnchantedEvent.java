package com.xero.mcpews.event;

public class ItemEnchantedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ItemEnchanted", ItemEnchantedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}