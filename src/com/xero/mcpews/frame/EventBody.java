package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xero.mcpews.event.Event;
import com.xero.mcpews.event.EventType;

import java.lang.reflect.Method;

public class EventBody extends Body {
    private String eventName;
    private Event properties;

    public static EventBody create(Event event) {
        EventBody body = new EventBody();
        body.eventName = event.getType().getId();
        body.properties = event;
        return body;
    }

    public static EventBody fromJson(JsonElement json, Gson gson) {
        JsonObject obj = json.getAsJsonObject();
        EventBody body = new EventBody();
        body.eventName = obj.get("eventName").getAsString();
        JsonElement event = obj.get("properties");
        EventType type = EventType.fromId(body.eventName);
        if (type == null) {
            body.properties = Event.Raw.fromJson(body.eventName, event, gson);
        } else {
            Class<? extends Event> clazz = type.getEventClass();
            try {
                Method method = clazz.getMethod("fromJson", JsonElement.class, Gson.class);
                body.properties = (Event) method.invoke(null, event, gson);
            } catch (Exception ex) {
                body.properties = gson.fromJson(event, clazz);
            }
        }
        if (body.properties != null) {
            JsonElement measurements = obj.get("measurements");
            if (measurements != null) body.properties.assignMeasurements(measurements);
        }
        return body;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.EVENT;
    }

    public String getEventName() {
        return eventName;
    }

    public Event getProperties() {
        return properties;
    }
}
