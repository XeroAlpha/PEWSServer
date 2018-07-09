package com.xero.mcpews.event;

public class SignInToXboxLiveEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("SignInToXboxLive", SignInToXboxLiveEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}