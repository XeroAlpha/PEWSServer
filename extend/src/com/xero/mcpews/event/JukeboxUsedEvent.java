package com.xero.mcpews.event;

public class JukeboxUsedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("JukeboxUsed", JukeboxUsedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}