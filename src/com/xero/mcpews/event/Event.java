package com.xero.mcpews.event;

import com.google.gson.JsonElement;

public abstract class Event {
    public abstract EventType getType();

    public void assignMeasurements(JsonElement json) {}
}
