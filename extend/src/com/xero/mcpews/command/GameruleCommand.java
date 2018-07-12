package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class GameruleCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("gamerule", GameruleCommand.class);
//TODO: add members
    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {

    }

    @Override
    public CommandResponse serializeResponse(JsonElement json, Gson gson) {
        return null;
    }

    public static class Response extends CommandResponse<GameruleCommand> {
        
    }
}