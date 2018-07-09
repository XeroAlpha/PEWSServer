package com.xero.mcpews.event;

public class PortalBuiltEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PortalBuilt", PortalBuiltEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}