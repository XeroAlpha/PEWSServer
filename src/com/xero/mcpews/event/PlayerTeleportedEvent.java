package com.xero.mcpews.event;

public class PlayerTeleportedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerTeleported", PlayerTeleportedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}