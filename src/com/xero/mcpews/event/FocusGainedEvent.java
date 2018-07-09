package com.xero.mcpews.event;

public class FocusGainedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("FocusGained", FocusGainedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}