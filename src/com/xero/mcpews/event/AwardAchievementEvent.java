package com.xero.mcpews.event;

public class AwardAchievementEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("AwardAchievement", AwardAchievementEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}