package com.xero.mcpews.event;

public class OptionsUpdatedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("OptionsUpdated", OptionsUpdatedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}