package com.xero.mcpews.event;

public class PackImportStageEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("PackImportStage", PackImportStageEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}