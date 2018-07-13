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

package com.xero.mcpews.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents a specific type of Command.
 * @author ProjectXero
 */
public class CommandType {
    private static Map<String, CommandType> mCommandMap = new ConcurrentHashMap<>();
    private String mId;
    private Class<? extends Command> mCommandClass;

    private CommandType(String id, Class<? extends Command> clazz) {
        mId = id;
        mCommandClass = clazz;
    }

    /**
     * Create and register a type of command.
     * @param id name of command
     * @param clazz class of command
     * @return type of command
     */
    public static CommandType registerCommandType(String id, Class<? extends Command> clazz) {
        CommandType commandType = new CommandType(id, clazz);
        mCommandMap.put(id, commandType);
        return commandType;
    }

    /**
     * Return the type of command whose name is <var>id</var>.
     * @param id name of command
     * @return type of command
     */
    public static CommandType fromId(String id) {
        return mCommandMap.get(id);
    }

    /**
     * Return the name of command.
     * @return name of command
     */
    public String getId() {
        return mId;
    }

    /**
     * Return the class of command.
     * @return the class of command
     */
    public Class<? extends Command> getCommandClass() {
        return mCommandClass;
    }
}
