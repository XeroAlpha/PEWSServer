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

import com.xero.mcpews.event.Event;

/**
 * This interface is implemented by a Event Receiver that receives specified type of events.
 * @param <T> the specified type of event
 * @author ProjectXero
 */

public interface MCEventReceiver<T extends Event> {
    /**
     * A event receiver which does nothing.
     */
    public static final MCEventReceiver NULL = new MCEventReceiver() {
        @Override
        public void onReceiveEvent(MCClient client, Event event) {}
    };

    /**
     * Called after a Event was received.
     * @param client the caller client of this method
     * @param event the received event
     */
    void onReceiveEvent(MCClient client, T event);
}
