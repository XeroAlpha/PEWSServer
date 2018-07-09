package com.xero.mcpews.event;

public class ScreenChangedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ScreenChanged", ScreenChangedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}