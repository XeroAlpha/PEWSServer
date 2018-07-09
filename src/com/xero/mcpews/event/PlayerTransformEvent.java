package com.xero.mcpews.event;

public class PlayerTransformEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerTransform", PlayerTransformEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}