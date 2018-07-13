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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.xero.mcpews.MCResponseReceiver;

/**
 * This class is the base class of every command.
 * @author ProjectXero
 */
public abstract class Command {
    /**
     * Common parameter delimiter
     */
    public static final String PARAM_DELIMITER = " ";

    private transient MCResponseReceiver mReceiver;
    private transient Object mTag;

    /**
     * Return the response receiver bind to this command.
     * @return the response receiver
     */
    public MCResponseReceiver getResponseReceiver() {
        return mReceiver;
    }

    /**
     * Set the response receiver to <var>receiver</var>.
     * @param receiver the response receiver
     * @return this Command object
     */
    public Command responseTo(MCResponseReceiver receiver) {
        mReceiver = receiver;
        return this;
    }

    /**
     * Return the tag of this Command.
     * @return the tag
     */
    public Object getTag() {
        return mTag;
    }

    /**
     * Set the tag of this Command to <var>tag</var>
     * @param tag the new tag
     */
    public void setTag(Object tag) {
        mTag = tag;
    }

    /**
     * Return the type of this Command.
     * @return the type
     */
    public abstract CommandType getType();

    /**
     * Add parameters to <var>builder</var>. You can join your parameters with the delimiter {@link #PARAM_DELIMITER}.
     * @param builder the StringBuilder to store parameters.
     */
    public abstract void attachParams(StringBuilder builder);

    /**
     * Deserialize the response of this command to a CommandResponse.
     * @param json the response data
     * @param gson a reusable GSON instance
     * @return the response instance
     */
    public abstract CommandResponse deserializeResponse(JsonElement json, Gson gson);

    public String getOverload() {
        return "default";
    }

    @Deprecated
    public static class StringCommand extends Command {
        private static final CommandType TYPE = CommandType.registerCommandType("", StringCommand.class);

        private transient String mCommand;

        public static StringCommand create(String command) {
            StringCommand cmd = new StringCommand();
            cmd.mCommand = command;
            return cmd;
        }

        public String getCommand() {
            return mCommand;
        }

        public void setCommand(String command) {
            mCommand = command;
        }

        @Override
        public CommandType getType() {
            return TYPE;
        }

        @Override
        public void attachParams(StringBuilder builder) {
            builder.append(mCommand);
        }

        @Override
        public CommandResponse deserializeResponse(JsonElement json, Gson gson) {
            return StringResponse.create(json);
        }
    }

    @Deprecated
    public static class StringResponse extends CommandResponse<StringCommand> {
        private transient JsonElement mJson;

        public static StringResponse create(JsonElement json) {
            StringResponse response = new StringResponse();
            response.mJson = json;
            return response;
        }

        public JsonElement getJson() {
            return mJson;
        }
    }
}
