package com.xero.mcpews.event;

public class PlayerTravelledEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PlayerTravelled", PlayerTravelledEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}