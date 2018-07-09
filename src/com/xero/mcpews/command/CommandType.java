package com.xero.mcpews.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandType {
    private static Map<String, CommandType> mCommandMap = new ConcurrentHashMap<>();
    private String mId;
    private Class<? extends Command> mCommandClass;

    private CommandType(String id, Class<? extends Command> clazz) {
        mId = id;
        mCommandClass = clazz;
    }

    public static CommandType registerCommandType(String id, Class<? extends Command> clazz) {
        CommandType commandType = new CommandType(id, clazz);
        mCommandMap.put(id, commandType);
        return commandType;
    }

    public static CommandType fromId(String id) {
        return mCommandMap.get(id);
    }

    public String getId() {
        return mId;
    }

    public Class<? extends Command> getCommandClass() {
        return mCommandClass;
    }
}
