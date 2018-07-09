package com.xero.mcpews.event;

public class HasNewContentEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("HasNewContent", HasNewContentEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}