package com.xero.mcpews;

public interface MCListener {
    abstract void onCreate(MCClient client);

    abstract void onDestroy(MCClient client);

    abstract void onError(MCClient client, MCError error);
}
