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

/**
 * This interface is implemented by a listener to process
 * the connection between Minecraft client and WSServer.
 * @author ProjectXero
 */

public interface MCListener {
    /**
     * Called after a new {@code MCListener} is created and bind to <var>client</var>.
     *
     * Usually we register EventReceiver(s) and make preparations here.
     * @param client the caller client of this method
     */
    void onCreate(MCClient client);

    /**
     * Called after the connection is closed.
     * @param client the caller client of this method
     */
    void onDestroy(MCClient client);

    /**
     * Called when an error occurs in Minecraft client.
     * @param client the caller client of this method
     * @param error some information about the error
     */
    void onError(MCClient client, MCError error);

    /**
     * Called when an exception occurs locally.
     * @param client the caller client of this method
     * @param ex the thrown exception
     */
    void onException(MCClient client, Exception ex);
}
