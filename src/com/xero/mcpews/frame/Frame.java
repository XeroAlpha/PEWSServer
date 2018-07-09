package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Method;

public class Frame {
    private static Gson gson = new GsonBuilder()
            .create();

    private Header header;
    private Body body;

    public static Frame fromJson(String json) {
        Frame frame = null;
        try {
            frame = new Frame();
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(json).getAsJsonObject();
            frame.header = gson.fromJson(obj.get("header").getAsJsonObject(), Header.class);
            if (frame.header == null) throw new RuntimeException("Cannot find header.");
            Purpose purpose = frame.header.getPurpose();
            if (purpose == null) {
                throw new RuntimeException("Unknown body: " + frame.header.getMessagePurpose());
            } else {
                Class<? extends Body> clazz = purpose.getBodyClass();
                JsonObject body = obj.get("body").getAsJsonObject();
                try {
                    Method method = clazz.getMethod("fromJson", JsonObject.class, Gson.class);
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
