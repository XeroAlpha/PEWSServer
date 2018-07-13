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

import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.Origin;

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
