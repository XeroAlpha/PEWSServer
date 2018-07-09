package com.xero.mcpews.event;

public class FileTransmissionCompletedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("FileTransmissionCompleted", FileTransmissionCompletedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}