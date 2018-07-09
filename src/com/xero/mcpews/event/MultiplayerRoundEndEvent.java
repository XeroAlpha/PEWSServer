package com.xero.mcpews.event;

public class MultiplayerRoundEndEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("MultiplayerRoundEnd", MultiplayerRoundEndEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}