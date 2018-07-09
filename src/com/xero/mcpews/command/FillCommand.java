package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FillCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("fill", FillCommand.class);
//TODO: add members
    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {

    }

    @Override
    public CommandResponse serializeResponse(JsonObject obj, Gson gson) {
        return null;
    }

    public static class Response extends CommandResponse<FillCommand> {
        
    }
}