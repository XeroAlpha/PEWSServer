package com.xero.mcpews.event;

public class PurchaseAttemptEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PurchaseAttempt", PurchaseAttemptEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}