package com.xero.mcpews.event;

public class ConfigurationChangedEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("ConfigurationChanged", ConfigurationChangedEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}