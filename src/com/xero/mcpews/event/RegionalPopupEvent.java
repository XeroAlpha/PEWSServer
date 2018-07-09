package com.xero.mcpews.event;

public class RegionalPopupEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("RegionalPopup", RegionalPopupEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}