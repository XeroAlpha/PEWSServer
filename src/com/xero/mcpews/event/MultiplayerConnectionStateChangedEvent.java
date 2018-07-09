package com.xero.mcpews.event;

public class MultiplayerConnectionStateChangedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("MultiplayerConnectionStateChanged", MultiplayerConnectionStateChangedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}