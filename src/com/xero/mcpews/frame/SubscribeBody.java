package com.xero.mcpews.frame;

import com.xero.mcpews.event.EventType;

public class SubscribeBody extends Body {
    private String eventName;

    public static SubscribeBody create(EventType type) {
        return create(type.getId());
    }

    public static SubscribeBody create(String type) {
        SubscribeBody body = new SubscribeBody();
        body.eventName = type;
        return body;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.SUBSCRIBE;
    }
}
