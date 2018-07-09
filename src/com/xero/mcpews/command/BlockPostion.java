package com.xero.mcpews.command;

public class BlockPostion {
    private int x, y, z;

    public static BlockPostion create(int x, int y, int z) {
        BlockPostion pos = new BlockPostion();
        return pos.setPostion(x, y, z);
    }

    public BlockPostion setPostion(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public BlockPostion setX(int x) {
        this.x = x;
        return this;
    }

    public BlockPostion setY(int y) {
        this.y = y;
        return this;
    }

    public BlockPostion setZ(int z) {
        this.z = z;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(x).append(" ");
        builder.append(y).append(" ");
        builder.append(z).append(" ");
        return builder.toString();
    }
}
