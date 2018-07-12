package com.xero.mcpews.event;

public class WorldExportedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("WorldExported", WorldExportedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}