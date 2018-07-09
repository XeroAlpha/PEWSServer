package com.xero.mcpews.event;

public class MascotCreatedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("MascotCreated", MascotCreatedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}