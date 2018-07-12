package com.xero.mcpews.event;

public class ApiInitEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ApiInit", ApiInitEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}