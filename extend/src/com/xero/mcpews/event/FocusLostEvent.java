package com.xero.mcpews.event;

public class FocusLostEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("FocusLost", FocusLostEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}