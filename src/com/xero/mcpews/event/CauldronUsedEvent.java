package com.xero.mcpews.event;

public class CauldronUsedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("CauldronUsed", CauldronUsedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}