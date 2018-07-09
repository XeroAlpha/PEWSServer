package com.xero.mcpews.event;

public class MultiplayerRoundEndEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("MultiplayerRoundEnd", MultiplayerRoundEndEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}