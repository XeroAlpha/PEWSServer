package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xero.mcpews.command.CommandResponse;

public class ResponseBody extends Body {
    private int statusCode;
    private String statusMessage;
    private transient JsonObject originJson;

    public static ResponseBody fromJson(JsonObject obj, Gson gson) {
        ResponseBody body = new ResponseBody();
        body.statusCode = obj.get("statusCode").getAsInt();
        if (obj.has("statusMessage")) body.statusMessage = obj.get("statusMessage").getAsString();
        body.originJson = obj;
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public JsonObject getOriginJson() {
        return originJson;
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.COMMAND_RESPONSE;
    }
}
