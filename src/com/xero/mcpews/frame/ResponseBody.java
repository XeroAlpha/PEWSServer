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

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class ResponseBody extends Body {
    private int statusCode;
    private String statusMessage;
    private transient JsonElement originJson;

    public static ResponseBody fromJson(JsonElement obj, Gson gson) {
        ResponseBody body = new ResponseBody();
        body.originJson = obj;
        return body;
    }

    public JsonElement getOriginJson() {
        return originJson;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.COMMAND_RESPONSE;
    }
}
