package com.xero.mcpews.event;

public class ItemCraftedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ItemCrafted", ItemCraftedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}