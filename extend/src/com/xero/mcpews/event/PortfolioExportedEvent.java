package com.xero.mcpews.event;

public class PortfolioExportedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PortfolioExported", PortfolioExportedEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}