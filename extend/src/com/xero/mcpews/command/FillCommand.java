package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class FillCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("fill", FillCommand.class);

    public static final String HANDLING_DESTROY = "destroy";
    public static final String HANDLING_HOLLOW = "hollow";
    public static final String HANDLING_KEEP = "keep";
    public static final String HANDLING_OUTLINE = "outline";
    public static final String HANDLING_REPLACE = "replace";

    protected Position from, to;
    protected String tileName;
    protected int tileData;
    protected String oldBlockHandling;

    public static DefaultOverload createDefault(Position from, Position to, String tileName) {
        return createDefault(from, to, tileName, 0);
    }

    public static DefaultOverload createDefault(Position from, Position to, String tileName, int tileData) {
        return createDefault(from, to, tileName, tileData, "replace");
    }

    public static DefaultOverload createDefault(Position from, Position to, String tileName, int tileData, String oldBlockHandling) {
        return DefaultOverload.create(from, to, tileName, tileData, oldBlockHandling);
    }

    public static ReplaceOverload createReplace(Position from, Position to, String tileName, int tileData, String replaceTileName, int replaceDataValue) {
        return ReplaceOverload.create(from, to, tileName, tileData, replaceTileName, replaceDataValue);
    }

    public Position getFrom() {
        return from;
    }

    public void setFrom(Position from) {
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public void setTo(Position to) {
        this.to = to;
    }

    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public int getTileData() {
        return tileData;
    }

    public void setTileData(int tileData) {
        this.tileData = tileData;
    }

    public String getOldBlockHandling() {
        return oldBlockHandling;
    }

    public void setOldBlockHandling(String oldBlockHandling) {
        this.oldBlockHandling = oldBlockHandling;
    }

    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {
        builder.append(from.toString()).append(PARAM_SPLITER)
                .append(to.toString()).append(PARAM_SPLITER)
                .append(tileName).append(PARAM_SPLITER)
                .append(tileData).append(PARAM_SPLITER)
                .append(getOldBlockHandling());
    }

    @Override
    public CommandResponse serializeResponse(JsonElement json, Gson gson) {
        return gson.fromJson(json, Response.class);
    }

    @Override
    public abstract String getOverload();

    public static class Response extends CommandResponse<FillCommand> {
        private String blockName;
        private int fillCount;

        public String getBlockName() {
            return blockName;
        }

        public int getFillCount() {
            return fillCount;
        }
    }

    public static class DefaultOverload extends FillCommand {
        public static DefaultOverload create(Position from, Position to, String tileName, int tileData, String oldBlockHandling) {
            DefaultOverload command = new DefaultOverload();
            command.from = from;
            command.to = to;
            command.tileName = tileName;
            command.tileData = tileData;
            command.oldBlockHandling = oldBlockHandling;
            return command;
        }

        @Override
        public String getOverload() {
            return "default";
        }
    }

    public static class ReplaceOverload extends FillCommand {
        private String replaceTileName;
        private int replaceDataValue;

        public static ReplaceOverload create(Position from, Position to, String tileName, int tileData, String replaceTileName, int replaceDataValue) {
            ReplaceOverload command = new ReplaceOverload();
            command.from = from;
            command.to = to;
            command.tileName = tileName;
            command.tileData = tileData;
            command.oldBlockHandling = HANDLING_REPLACE;
            command.replaceTileName = replaceTileName;
            command.replaceDataValue = replaceDataValue;
            return command;
        }

        public String getReplaceTileName() {
            return replaceTileName;
        }

        public void setReplaceTileName(String replaceTileName) {
            this.replaceTileName = replaceTileName;
        }

        public int getReplaceDataValue() {
            return replaceDataValue;
        }

        public void setReplaceDataValue(int replaceDataValue) {
            this.replaceDataValue = replaceDataValue;
        }

        @Override
        public String getOldBlockHandling() {
            return "replace";
        }

        @Override
        public void attachParams(StringBuilder builder) {
            super.attachParams(builder);
            builder.append(replaceTileName).append(PARAM_SPLITER)
                    .append(replaceDataValue);
        }

        @Override
        public String getOverload() {
            return "replace";
        }
    }
}