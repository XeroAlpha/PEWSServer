package com.xero.mcpews.event;

public class MobKilledEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("MobKilled", MobKilledEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}