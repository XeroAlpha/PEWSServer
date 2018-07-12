package com.xero.mcpews.event;

public class NpcPropertiesUpdatedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("NpcPropertiesUpdated", NpcPropertiesUpdatedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}