package com.xero.mcpews.event;

public class FileTransmissionCancelledEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("FileTransmissionCancelled", FileTransmissionCancelledEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}