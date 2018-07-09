package com.xero.mcpews.event;

public class CraftingSessionCompletedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("CraftingSessionCompleted", CraftingSessionCompletedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}