package com.xero.mcpews.event;

public class GameSessionStartEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("GameSessionStart", GameSessionStartEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}