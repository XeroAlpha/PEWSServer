package com.xero.mcpews.event;

public class RespondedToAcceptContentEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("RespondedToAcceptContent", RespondedToAcceptContentEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}