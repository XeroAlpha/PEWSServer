package com.xero.mcpews.event;

public class BossKilledEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("BossKilled", BossKilledEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}