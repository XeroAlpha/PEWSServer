package com.xero.mcpews.event;

public class SignInToEduEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("SignInToEdu", SignInToEduEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}