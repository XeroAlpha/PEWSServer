package com.xero.mcpews.event;

public class TextToSpeechToggledEvent extends Event {
    public static final EventType TYPE = EventType.registerEventType("TextToSpeechToggled", TextToSpeechToggledEvent.class);
//TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}