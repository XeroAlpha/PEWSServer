package com.xero.mcpews.event;

public class GameSessionCompleteEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("GameSessionComplete", GameSessionCompleteEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}