package com.xero.mcpews.event;

public class SignInToEduEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("SignInToEdu", SignInToEduEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}