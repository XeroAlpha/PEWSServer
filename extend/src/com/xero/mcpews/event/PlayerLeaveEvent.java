package com.xero.mcpews.event;

public class PlayerLeaveEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PlayerLeave", PlayerLeaveEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}