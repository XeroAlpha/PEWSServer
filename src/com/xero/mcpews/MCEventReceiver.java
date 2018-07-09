package com.xero.mcpews;

import com.xero.mcpews.event.Event;

public interface MCEventReceiver<T extends Event> {
    void onReceiveEvent(MCClient client, T event);
}
