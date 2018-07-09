package com.xero.mcpews.frame;

import com.xero.mcpews.MCError;
import com.xero.mcpews.event.EventType;

public class ErrorBody extends Body implements MCError {
    private int statusCode;
    private String statusMessage;

    public static ErrorBody create(int statusCode, String statusMessage) {
        ErrorBody body = new ErrorBody();
        body.statusCode = statusCode;
        body.statusMessage = statusMessage;
        return body;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.ERROR;
    }
}
