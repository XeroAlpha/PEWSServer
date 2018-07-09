package com.xero.mcpews.event;

public class BoardTextUpdatedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("BoardTextUpdated", BoardTextUpdatedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}