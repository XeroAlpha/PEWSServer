package com.xero.mcpews.frame;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.CommandType;
import com.xero.mcpews.command.Origin;

import java.lang.reflect.Method;

public class CommandBody extends Body {
    private int version;
    private String commandLine;
    private Origin origin;

    public static CommandBody create(Origin origin, String commandLine) {
        CommandBody body = new CommandBody();
        body.version = 1;
        body.commandLine = commandLine;
        body.origin = origin;
        return body;
    }

    public static CommandBody create(Origin origin, Command command) {
        CommandBody body = new CommandBody();
        StringBuilder builder = new StringBuilder();
        String name = command.getType().getId();
        command.attachParams(builder);
        if (builder.length() > 0 && name.length() > 0) {
            builder.insert(0, " ");
        }
        builder.insert(0, name);
        return create(origin, builder.toString());
    }

    public static CommandBody create(Command command) {
        return create(Origin.PLAYER, command);
    }

    @Override
    public Purpose getPurpose() {
        return Purpose.COMMAND_REQUEST;
    }
}
