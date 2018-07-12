package com.xero.mcpews.event;

public class CauldronUsedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("CauldronUsed", CauldronUsedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}