package com.xero.mcpews;

import com.xero.mcpews.command.CommandResponse;

public interface MCResponseReceiver<T extends CommandResponse> {
    void onReceiveResponse(T response);
}
