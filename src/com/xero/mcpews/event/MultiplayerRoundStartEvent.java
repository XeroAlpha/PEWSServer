package com.xero.mcpews.event;

public class MultiplayerRoundStartEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("MultiplayerRoundStart", MultiplayerRoundStartEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}