package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xero.mcpews.MCResponseReceiver;

public abstract class Command {
    public static final String PARAM_SPLITER = " ";

    private transient MCResponseReceiver mReceiver;
    private transient Object mTag;

    public MCResponseReceiver getResponseReceiver() {
        return mReceiver;
    }

    public Command responseTo(MCResponseReceiver receiver) {
        mReceiver = receiver;
        return this;
    }

    public Object getTag() {
        return mTag;
    }

    public void setTag(Object tag) {
        mTag = tag;
    }

    public abstract CommandType getType();

    public abstract void attachParams(StringBuilder builder);

    public abstract CommandResponse serializeResponse(JsonObject obj, Gson gson);

    @Deprecated
    public String getOverload() {
        return "default";
    }

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
        public CommandResponse serializeResponse(JsonObject obj, Gson gson) {
            return StringResponse.create(obj);
        }
    }

    public static class StringResponse extends CommandResponse<StringCommand> {
        private transient JsonObject mJson;

        public static StringResponse create(JsonObject json) {
            StringResponse response = new StringResponse();
            response.mJson = json;
            return response;
        }

        public JsonObject getJson() {
            return mJson;
        }
    }
}
