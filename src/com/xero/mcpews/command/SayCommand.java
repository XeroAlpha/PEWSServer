package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SayCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("say", SayCommand.class);

    private String message;

    public static SayCommand create(String message) {
        SayCommand command = new SayCommand();
        command.message = message;
        return command;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {
        builder.append(message);
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
