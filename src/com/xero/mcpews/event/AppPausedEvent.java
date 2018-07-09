package com.xero.mcpews.event;

public class AppPausedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AppPaused", AppPausedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}