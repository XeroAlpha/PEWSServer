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
 * This class represents a error happened in remote Minecraft client.
 * @author ProjectXero
 */

public interface MCError {
    /**
     * Return the status code of the error, from which we can know the type of error.
     * @return the status code
     */
    int getStatusCode();

    /**
     * Return the status message of the error.
     * @return the status message
     */
    String getStatusMessage();
}
