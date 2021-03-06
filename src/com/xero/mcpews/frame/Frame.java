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

package com.xero.mcpews.frame;

import com.google.gson.*;

import java.lang.reflect.Method;

public class Frame {
    private static Gson gson = new GsonBuilder()
            .create();
    private static JsonParser parser = new JsonParser();

    private Header header;
    private Body body;

    public static Frame fromJson(String json) {
        Frame frame = null;
        try {
            frame = new Frame();
            JsonObject obj = parser.parse(json).getAsJsonObject();
            frame.header = gson.fromJson(obj.get("header").getAsJsonObject(), Header.class);
            if (frame.header == null) throw new RuntimeException("Cannot find header.");
            Purpose purpose = frame.header.getPurpose();
            if (purpose == null) {
                throw new RuntimeException("Unknown body: " + frame.header.getMessagePurpose());
            } else {
                Class<? extends Body> clazz = purpose.getBodyClass();
                JsonElement body = obj.get("body");
                try {
                    Method method = clazz.getMethod("fromJson", JsonElement.class, Gson.class);
                    frame.body = (Body) method.invoke(null, body, gson);
                } catch (Exception ex) {
                    frame.body = gson.fromJson(body, clazz);
                }
            }

        } catch (Exception e) {
            frame = new UnknownFrame(e, json);
        }
        return frame;
    }

    public static Frame fromBody(Body body) {
        Frame frame = new Frame();
        frame.header = Header.create(body.getPurpose());
        frame.body = body;
        return frame;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public Purpose getPurpose() {
        return header.getPurpose();
    }
}
