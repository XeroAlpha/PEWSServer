package com.xero.mcpews.event;

public class FirstTimeClientOpenEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("FirstTimeClientOpen", FirstTimeClientOpenEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}