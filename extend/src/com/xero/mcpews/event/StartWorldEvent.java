package com.xero.mcpews.event;

public class StartWorldEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("StartWorld", StartWorldEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}