package com.xero.mcpews.event;

public class SpecialMobBuiltEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("SpecialMobBuilt", SpecialMobBuiltEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}