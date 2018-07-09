package com.xero.mcpews.event;

public class UgcDownloadCompletedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("UgcDownloadCompleted", UgcDownloadCompletedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}