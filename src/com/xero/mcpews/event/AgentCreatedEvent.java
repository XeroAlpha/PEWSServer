package com.xero.mcpews.event;

public class AgentCreatedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AgentCreated", AgentCreatedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}