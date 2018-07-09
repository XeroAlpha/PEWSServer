package com.xero.mcpews.command;

public class CommandResponse<T extends Command> {
    private transient T mSource;

    private int statusCode;
    private String statusMessage;

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public T getSource() {
        return mSource;
    }

    public void setSource(T source) {
        if (mSource != null) return;
        mSource = source;
    }
}
