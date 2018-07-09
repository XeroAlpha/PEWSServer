package com.xero.mcpews.event;

public class MobInteractedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("MobInteracted", MobInteractedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}