package com.xero.mcpews.event;

public class PotionBrewedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PotionBrewed", PotionBrewedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}