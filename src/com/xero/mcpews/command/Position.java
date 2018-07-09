package com.xero.mcpews.command;

public class Position {
    private float x, y, z;
    private boolean relX, relY, relZ, local;

    public static Position createAbsolute(float x, float y, float z) {
        Position pos = new Position();
        return pos.setAbsolute(x, y, z);
    }

    public static Position createRelative(float relX, float relY, float relZ) {
        Position pos = new Position();
        return pos.setRelative(relX, relY, relZ);
    }

    public static Position createLocal(float relX, float relY, float relZ) {
        Position pos = new Position();
        return pos.setLocal(relX, relY, relZ);
    }

    public Position setAbsolute(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.relX = this.relY = this.relZ = this.local = false;
        return this;
    }

    public Position setRelative(float relX, float relY, float relZ) {
        this.x = relX;
        this.y = relY;
        this.z = relZ;
        this.relX = this.relY = this.relZ = true;
        this.local = false;
        return this;
    }

    public Position setLocal(float relX, float relY, float relZ) {
        this.x = relX;
        this.y = relY;
        this.z = relZ;
        this.relX = this.relY = this.relZ = false;
        this.local = true;
        return this;
    }

    public Position setX(float x, boolean isRelative) {
        this.x = x;
        this.relX = isRelative;
        return this;
    }

    public Position setY(float y, boolean isRelative) {
        this.y = y;
        this.relY = isRelative;
        return this;
    }

    public Position setZ(float z, boolean isRelative) {
        this.z = z;
        this.relZ = isRelative;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (local) {
            builder.append("^").append(x);
            builder.append(" ^").append(y);
            builder.append(" ^").append(z);
        } else {
            if (relX) {
                builder.append("~");
                if (x != 0) builder.append(x);
            } else {
                builder.append(x);
            }
            builder.append(" ");
            if (relY) {
                builder.append("~");
                if (y != 0) builder.append(y);
            } else {
                builder.append(y);
            }
            builder.append(" ");
            if (relZ) {
                builder.append("~");
                if (z != 0) builder.append(z);
            } else {
                builder.append(z);
            }
        }
        return builder.toString();
    }
}
