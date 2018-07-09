package com.xero.mcpews.event;

public class AdditionalContentLoadedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AdditionalContentLoaded", AdditionalContentLoadedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}