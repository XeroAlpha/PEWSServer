package com.xero.mcpews.event;

public class PlayerBouncedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerBounced", PlayerBouncedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}