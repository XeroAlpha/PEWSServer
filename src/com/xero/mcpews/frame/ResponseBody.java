package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xero.mcpews.command.CommandResponse;

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
