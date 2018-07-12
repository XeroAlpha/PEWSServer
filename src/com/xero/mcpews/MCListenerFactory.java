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

package com.xero.mcpews;

import org.java_websocket.WebSocket;

/**
 * A factory that creates listeners for the WSServer.
 * @author ProjectXero
 */

public abstract class MCListenerFactory {
    /**
     * Create and return a new listener which will be bind to the connection {@code conn}.
     * @param conn the connection between WSServer and Minecraft client
     * @return a new listener
     */
    public abstract MCListener create(WebSocket conn);
}
