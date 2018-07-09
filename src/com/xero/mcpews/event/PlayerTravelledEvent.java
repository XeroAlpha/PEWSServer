package com.xero.mcpews.event;

public class PlayerTravelledEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PlayerTravelled", PlayerTravelledEvent.class);

    private boolean HasRelevantBuff;
    private int MobType;
    private int TravelMethodType;
    private int WorldFeature;

    public boolean hasRelevantBuff() {
        return HasRelevantBuff;
    }

    public int getMobType() {
        return MobType;
    }

    public int getTravelMethodType() {
        return TravelMethodType;
    }

    public int getWorldFeature() {
        return WorldFeature;
    }

    @Override
    public EventType getType() {
        return TYPE;
    }
}