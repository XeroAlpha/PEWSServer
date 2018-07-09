package com.xero.mcpews.frame;

import com.xero.mcpews.event.EventType;

public class SubscribeBody extends Body {
    private String eventName;

    public static SubscribeBody create(EventType type) {
        SubscribeBody body = new SubscribeBody();
        body.eventName = type.getId();
        return body;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.SUBSCRIBE;
    }
}
