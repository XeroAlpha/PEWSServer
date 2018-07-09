package com.xero.mcpews.event;

public class UploadSkinEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("UploadSkin", UploadSkinEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}