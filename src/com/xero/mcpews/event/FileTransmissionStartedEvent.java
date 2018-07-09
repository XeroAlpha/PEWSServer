package com.xero.mcpews.event;

public class FileTransmissionStartedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("FileTransmissionStarted", FileTransmissionStartedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}