/*
 * PEWSServer
 * Copyright (C) 2018  ProjectXero
 * E-mail: projectxero@163.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 */

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
