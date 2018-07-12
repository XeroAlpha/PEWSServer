package com.xero.mcpews.event;

public class AgentCommandEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AgentCommand", AgentCommandEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}