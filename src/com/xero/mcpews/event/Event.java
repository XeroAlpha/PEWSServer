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

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * This class is the base class of every event.
 * @author ProjectXero
 */

public abstract class Event {
    /**
     * Return the EventType this Event is created by.
     * @return the type of Event
     */
    public abstract EventType getType();

    /**
     * Assign the {@code measurements} part into this object.
     *
     * You can override this method to process {@code measurements} part.
     * @param json measurements part
     */
    public void assignMeasurements(JsonElement json) {}

    /**
     * This class represents a Event which can be any type.
     *
     * It will be constructed after receive a event of unknown type.
     */
    public static class Raw extends Event {
        private transient String mEventName;
        private transient JsonElement mProperties, mMeasurements;

        /**
         * Construct a raw event from JSON data.
         * @param name name of this type of Event
         * @param json {@code properties} part of this event
         * @param gson a reusable GSON instance
         * @return new instance of raw event
         */
        public static Raw fromJson(String name, JsonElement json, Gson gson) {
            Raw event = new Raw();
            event.mEventName = name;
            event.mProperties = json;
            return event;
        }

        /**
         * Return the name of its type
         * @return name of this type of Event
         */
        public String getEventName() {
            return mEventName;
        }

        /**
         * Return the {@code properties} part of its type
         * @return {@code properties} part
         */
        public JsonElement getProperties() {
            return mProperties;
        }

        /**
         * Return the {@code measurements} part of its type
         * @return {@code measurements} part
         */
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
