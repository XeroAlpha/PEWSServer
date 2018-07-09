package com.xero.mcpews.event;

public class LicenseCensusEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("LicenseCensus", LicenseCensusEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}