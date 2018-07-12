package com.xero.mcpews.event;

public class PurchaseResolvedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PurchaseResolved", PurchaseResolvedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}