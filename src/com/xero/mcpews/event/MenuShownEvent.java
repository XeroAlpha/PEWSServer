package com.xero.mcpews.event;

public class MenuShownEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("MenuShown", MenuShownEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}