package com.xero.mcpews.event;

public class PackImportStageEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PackImportStage", PackImportStageEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}