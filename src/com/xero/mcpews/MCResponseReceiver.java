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

import com.xero.mcpews.command.CommandResponse;

/**
 * This interface is implemented by a Command Response Receiver that receives
 * the response of a command.
 * @param <T> the specified type of command
 * @author ProjectXero
 */

public interface MCResponseReceiver<T extends CommandResponse> {
    /**
     * A response receiver which does nothing.
     */
    public static final MCResponseReceiver NULL = new MCResponseReceiver() {
        @Override
        public void onReceiveResponse(MCClient client, CommandResponse response) {}
    };

    /**
     * Called after a Command Response was received.
     * @param client the caller client of this method
     * @param response the received response
     */
    void onReceiveResponse(MCClient client, T response);
}
