package com.xero.mcpews.event;

public class PortalUsedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PortalUsed", PortalUsedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}