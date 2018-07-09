package com.xero.mcpews.frame;

import com.xero.mcpews.event.EventType;

public class UnsubscribeBody extends Body {
    private String eventName;

    public static UnsubscribeBody create(EventType type) {
        UnsubscribeBody body = new UnsubscribeBody();
        body.eventName = type.getId();
        return body;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.UNSUBSCRIBE;
    }
}
