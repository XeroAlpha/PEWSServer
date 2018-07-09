package com.xero.mcpews.event;

public class WorldFilesListedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("WorldFilesListed", WorldFilesListedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}