package com.xero.mcpews.event;

public class UploadSkinEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("UploadSkin", UploadSkinEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}