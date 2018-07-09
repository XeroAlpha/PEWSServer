package com.xero.mcpews.event;

public class SignInToXboxLiveEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("SignInToXboxLive", SignInToXboxLiveEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}