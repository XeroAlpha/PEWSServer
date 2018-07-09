package com.xero.mcpews.event;

public class EntitySpawnedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("EntitySpawned", EntitySpawnedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}