package com.xero.mcpews.event;

public class HardwareInfoEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("HardwareInfo", HardwareInfoEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}