package com.xero.mcpews.event;

public class CameraUsedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("CameraUsed", CameraUsedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}