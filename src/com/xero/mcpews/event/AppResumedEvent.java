package com.xero.mcpews.event;

public class AppResumedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("AppResumed", AppResumedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}