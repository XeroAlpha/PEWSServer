package com.xero.mcpews.frame;

public class UnknownFrame extends Frame {
    private transient Exception exception;
    private transient String json;

    public UnknownFrame(Exception exception, String json) {
        this.exception = exception;
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public Purpose getPurpose() {
        return null;
    }
}
