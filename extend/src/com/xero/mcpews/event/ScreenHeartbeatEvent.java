package com.xero.mcpews.event;

public class ScreenHeartbeatEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ScreenHeartbeat", ScreenHeartbeatEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}