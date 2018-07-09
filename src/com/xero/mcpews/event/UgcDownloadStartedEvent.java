package com.xero.mcpews.event;

public class UgcDownloadStartedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("UgcDownloadStarted", UgcDownloadStartedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}