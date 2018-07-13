/*
 * PEWSServer
 * Copyright (C) 2018  ProjectXero
 * E-mail: projectxero@163.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 */

package com.xero.mcpews.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents a specific type of Event.
 * @author ProjectXero
 */

public class EventType {
    private static Map<String, EventType> mEventMap = new ConcurrentHashMap<>();
    private String mId;
    private Class<? extends Event> mEventClass;

    private EventType(String id, Class<? extends Event> clazz) {
        mId = id;
        mEventClass = clazz;
    }

    /**
     * Create and register a type of event.
     * @param id name of event
     * @param clazz class of event
     * @return type of event
     */
    public static EventType registerEventType(String id, Class<? extends Event> clazz) {
        EventType eventType = new EventType(id, clazz);
        mEventMap.put(id, eventType);
        return eventType;
    }

    /**
     * Return the type of event whose name is <var>id</var>.
     * @param id name of event
     * @return type of event
     */
    public static EventType fromId(String id) {
        return mEventMap.get(id);
    }

    /**
     * Return the name of event.
     * @return name of event
     */
    public String getId() {
        return mId;
    }

    /**
     * Return the class of event.
     * @return the class of event
     */
    public Class<? extends Event> getEventClass() {
        return mEventClass;
    }
}
