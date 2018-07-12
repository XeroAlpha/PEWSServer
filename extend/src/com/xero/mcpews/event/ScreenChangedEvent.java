package com.xero.mcpews.event;

public class ScreenChangedEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("ScreenChanged", ScreenChangedEvent.class);

    private String PreviousScreenName;
    private String ScreenName;
    private String ScreenVersion;
    private float Seconds;
    private float TimeStamp;

    public String getPreviousScreenName() {
        return PreviousScreenName;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public String getScreenVersion() {
        return ScreenVersion;
    }

    public float getSeconds() {
        return Seconds;
    }

    public float getTimeStamp() {
        return TimeStamp;
    }

    @Override
    public EventType getType() {
        return TYPE;
    }
}