package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xero.mcpews.event.Event;
import com.xero.mcpews.event.EventType;

import java.lang.reflect.Method;

public class EventBody extends Body {
    private String eventName;
    private Event properties;
    //private ??? measurements;

    public static EventBody create(Event event) {
        EventBody body = new EventBody();
        body.eventName = event.getType().getId();
        body.properties = event;
        return body;
    }

    public static EventBody fromJson(JsonObject obj, Gson gson) {
        EventBody body = new EventBody();
        body.eventName = obj.get("eventName").getAsString();
        EventType type = EventType.fromId(body.eventName);
        if (type == null) {
            throw new RuntimeException("Unknown event: " + body.eventName);
        } else {
            Class<? extends Event> clazz = type.getEventClass();
            JsonObject event = obj.get("properties").getAsJsonObject();
            try {
                Method method = clazz.getMethod("fromJson", JsonObject.class, Gson.class);
                body.properties = (Event) method.invoke(null, event, gson);
            } catch (Exception ex) {
                body.properties = gson.fromJson(event, clazz);
            }
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
