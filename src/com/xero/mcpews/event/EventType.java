package com.xero.mcpews.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventType {
    private static Map<String, EventType> mEventMap = new ConcurrentHashMap<>();
    private String mId;
    private Class<? extends Event> mEventClass;

    private EventType(String id, Class<? extends Event> clazz) {
        mId = id;
        mEventClass = clazz;
    }

    public static EventType registerEventType(String id, Class<? extends Event> clazz) {
        EventType eventType = new EventType(id, clazz);
        mEventMap.put(id, eventType);
        return eventType;
    }

    public static EventType fromId(String id) {
        return mEventMap.get(id);
    }

    public String getId() {
        return mId;
    }

    public Class<? extends Event> getEventClass() {
        return mEventClass;
    }
}
