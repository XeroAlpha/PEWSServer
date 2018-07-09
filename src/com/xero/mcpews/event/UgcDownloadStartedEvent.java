package com.xero.mcpews.event;

public class UgcDownloadStartedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("UgcDownloadStarted", UgcDownloadStartedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}