package com.xero.mcpews.event;

public class GameSessionCompleteEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("GameSessionComplete", GameSessionCompleteEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}