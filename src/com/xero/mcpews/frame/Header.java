package com.xero.mcpews.frame;

import java.util.UUID;

public class Header {
    public static final int VERSION = 1;

    private int version;
    private String requestId;
    private String messagePurpose;
    private String messageType;

    public static Header create(Purpose purpose) {
        Header header = new Header();
        header.version = VERSION;
        header.requestId = UUID.randomUUID().toString();
        header.messagePurpose = purpose.getPurposeName();
        header.messageType = "commandRequest";
        return header;
    }

    public int getVersion() {
        return version;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getMessagePurpose() {
        return messagePurpose;
    }

    public Purpose getPurpose() {
        return Purpose.fromString(messagePurpose);
    }

    public String getMessageType() {
        return messageType;
    }
}
