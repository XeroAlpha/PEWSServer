package com.xero.mcpews.event;

public class EndOfDayEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("EndOfDay", EndOfDayEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}