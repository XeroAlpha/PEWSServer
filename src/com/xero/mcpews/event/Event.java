package com.xero.mcpews.event;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class Event {
    public abstract EventType getType();

    public void assignMeasurements(JsonElement json) {}

    public static class Raw extends Event {
        private transient String mEventName;
        private transient JsonElement mProperties, mMeasurements;

        public static Raw fromJson(String name, JsonElement json, Gson gson) {
            Raw event = new Raw();
            event.mEventName = name;
            event.mProperties = json;
            return event;
        }

        public String getEventName() {
            return mEventName;
        }

        public JsonElement getProperties() {
            return mProperties;
        }

        public JsonElement getMeasurements() {
            return mMeasurements;
        }

        @Override
        public EventType getType() {
            throw new RuntimeException("Raw event can be any type");
        }

        @Override
        public void assignMeasurements(JsonElement json) {
            mMeasurements = json;
        }
    }
}
