package com.xero.mcpews.event;

public class PlayerTransformEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PlayerTransform", PlayerTransformEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}