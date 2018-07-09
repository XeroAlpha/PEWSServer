package com.xero.mcpews.event;

public class PerformanceMetricsEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PerformanceMetrics", PerformanceMetricsEvent.class);
    //TODO: add members
    @Override
    public EventType getType() {
        return TYPE;
    }
}