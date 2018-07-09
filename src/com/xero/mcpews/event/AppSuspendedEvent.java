package com.xero.mcpews.event;

public class AppSuspendedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AppSuspended", AppSuspendedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}