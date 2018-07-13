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

public class UnknownFrame extends Frame {
    private transient Exception exception;
    private transient String json;

    public UnknownFrame(Exception exception, String json) {
        this.exception = exception;
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public Purpose getPurpose() {
        return null;
    }
}
