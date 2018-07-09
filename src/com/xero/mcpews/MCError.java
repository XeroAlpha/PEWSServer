package com.xero.mcpews;

public interface MCError {
    abstract int getStatusCode();

    abstract String getStatusMessage();
}
