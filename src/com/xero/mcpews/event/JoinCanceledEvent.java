package com.xero.mcpews.event;

public class JoinCanceledEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("JoinCanceled", JoinCanceledEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}