package com.xero.mcpews.frame;

import java.util.concurrent.ConcurrentHashMap;

public enum Purpose {
    COMMAND_RESPONSE("commandResponse", ResponseBody.class),
    COMMAND_REQUEST("commandRequest", CommandBody.class),
    ERROR("error", ErrorBody.class),
    EVENT("event", EventBody.class),
    SUBSCRIBE("subscribe", SubscribeBody.class),
    UNSUBSCRIBE("unsubscribe", UnsubscribeBody.class);

    private static ConcurrentHashMap<String, Purpose> mPurposeMap;

    static {
        mPurposeMap = new ConcurrentHashMap<>();
        for (Purpose purpose : values()) {
            mPurposeMap.put(purpose.getPurposeName(), purpose);
        }
    }

    private String purpose;
    private Class<? extends Body> bodyClass;

    Purpose(String purpose, Class<? extends Body> clazz) {
        this.purpose = purpose;
        this.bodyClass = clazz;
    }

    public static Purpose fromString(String purposeName) {
        return mPurposeMap.get(purposeName);
    }

    public String getPurposeName() {
        return purpose;
    }

    public Class<? extends Body> getBodyClass() {
        return bodyClass;
    }
}