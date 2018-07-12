package com.xero.mcpews.event;

public class HasNewContentEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("HasNewContent", HasNewContentEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}