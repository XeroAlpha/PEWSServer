package com.xero.mcpews.event;

public class BlockBrokenEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("BlockBroken", BlockBrokenEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}