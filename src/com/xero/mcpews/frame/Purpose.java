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

import java.util.concurrent.ConcurrentHashMap;

public enum Purpose {
    COMMAND_RESPONSE("commandResponse", ResponseBody.class),
    COMMAND_REQUEST("commandRequest", CommandBody.class),
    ERROR("error", ErrorBody.class),
    EVENT("event", EventBody.class),
    SUBSCRIBE("subscribe", SubscribeBody.class),
    UNSUBSCRIBE("unsubscribe", UnsubscribeBody.class);

    private static ConcurrentHashMap<String, Purpose> mPurposeMap;

    static {
        mPurposeMap = new ConcurrentHashMap<>();
        for (Purpose purpose : values()) {
            mPurposeMap.put(purpose.getPurposeName(), purpose);
        }
    }

    private String purpose;
    private Class<? extends Body> bodyClass;

    Purpose(String purpose, Class<? extends Body> clazz) {
        this.purpose = purpose;
        this.bodyClass = clazz;
    }

    public static Purpose fromString(String purposeName) {
        return mPurposeMap.get(purposeName);
    }

    public String getPurposeName() {
        return purpose;
    }

    public Class<? extends Body> getBodyClass() {
        return bodyClass;
    }
}