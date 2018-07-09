package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AgentCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("agent", AgentCommand.class);

    private String params; //No EXTENDED BCS NACOMP

    public static AgentCommand create(String params) {
        AgentCommand command = new AgentCommand();
        command.params = params;
        return command;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {
        builder.append(params);
    }

    @Override
    public CommandResponse serializeResponse(JsonObject obj, Gson gson) {
        return gson.fromJson(obj, Response.class);
    }

    public static class Response extends CommandResponse<SayCommand> {
        private String message;

        public String getMessage() {
            return message;
        }
    }
}
