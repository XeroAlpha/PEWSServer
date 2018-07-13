package com.xero.mcpews.command;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class EnchantCommand extends Command {
    public static final CommandType TYPE = CommandType.registerCommandType("enchant", EnchantCommand.class);

    protected String player;
    protected int level;

    public static ByNameOverload create(Target player, String enchantmentName) {
        return create(player, enchantmentName, -1);
    }

    public static ByNameOverload create(Target player, String enchantmentName, int level) {
        return ByNameOverload.create(player.toString(), enchantmentName, level);
    }

    public static ByIdOverload create(Target player, int enchantmentId, int level) {
        return ByIdOverload.create(player.toString(), enchantmentId, level);
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setPlayer(Target player) {
        this.player = player.toString();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public CommandType getType() {
        return TYPE;
    }

    @Override
    public void attachParams(StringBuilder builder) {
        builder.append(player).append(PARAM_DELIMITER)
                .append(getEnchantment());
        if (level >= 0) {
            builder.append(PARAM_DELIMITER)
                    .append(level);
        }
    }

    @Override
    public CommandResponse deserializeResponse(JsonElement json, Gson gson) {
        return gson.fromJson(json, Response.class);
    }

    @Override
    public abstract String getOverload();

    protected abstract String getEnchantment();

    public static class Response extends CommandResponse<EnchantCommand> {
        private String[] playerNames, noItemNames, failedNames;

        public String[] getPlayerNames() {
            return playerNames;
        }

        public String[] getNoItemNames() {
            return noItemNames;
        }

        public String[] getFailedNames() {
            return failedNames;
        }
    }

    public static class ByNameOverload extends EnchantCommand {
        private String enchantmentName;

        public static ByNameOverload create(String player, String enchantmentName, int level) {
            ByNameOverload command = new ByNameOverload();
            command.player = player;
            command.enchantmentName = enchantmentName;
            command.level = level;
            return command;
        }

        public String getEnchantmentName() {
            return enchantmentName;
        }

        public void setEnchantmentName(String enchantmentName) {
            this.enchantmentName = enchantmentName;
        }

        @Override
        protected String getEnchantment() {
            return enchantmentName;
        }

        @Override
        public String getOverload() {
            return "byName";
        }
    }

    public static class ByIdOverload extends EnchantCommand {
        private int enchantmentId;

        public static ByIdOverload create(String player, int enchantmentId, int level) {
            ByIdOverload command = new ByIdOverload();
            command.player = player;
            command.enchantmentId = enchantmentId;
            command.level = level;
            return command;
        }

        public int getEnchantmentId() {
            return enchantmentId;
        }

        public void setEnchantmentId(int enchantmentId) {
            this.enchantmentId = enchantmentId;
        }

        @Override
        protected String getEnchantment() {
            return Integer.toString(enchantmentId);
        }

        @Override
        public String getOverload() {
            return "byId";
        }
    }
}