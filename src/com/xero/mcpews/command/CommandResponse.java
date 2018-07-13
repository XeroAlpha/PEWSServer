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

/**
 * This class represents a response of Command Execution.
 * @param <T> the type of executed command
 * @author ProjectXero
 */

public class CommandResponse<T extends Command> {
    private transient T mSource;

    private int statusCode;
    private String statusMessage;

    /**
     * Return the status code of the response, from which we can know whether it is executed successfully.
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Return the status message of the error.
     * @return the status message
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Return the origin Command object.
     * @return the source Command
     */
    public T getSource() {
        return mSource;
    }

    public void setSource(T source) {
        if (mSource != null) return;
        mSource = source;
    }
}
