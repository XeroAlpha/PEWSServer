package com.xero.mcpews.command;

public class Origin {
    public static final Origin PLAYER = Origin.get("player");

    private String type;

    public static Origin get(String type) {
        Origin origin = new Origin();
        origin.type = type;
        return origin;
    }
}
