package com.xero.mcpews.event;

public class SignOutOfXboxLiveEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("SignOutOfXboxLive", SignOutOfXboxLiveEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}