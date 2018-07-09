package com.xero.mcpews.event;

public class PlayerDiedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerDied", PlayerDiedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}