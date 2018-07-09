package com.xero.mcpews.event;

public class RegionalPopupEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("RegionalPopup", RegionalPopupEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}