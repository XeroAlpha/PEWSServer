package com.xero.mcpews.event;

public class VehicleExitedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("VehicleExited", VehicleExitedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}