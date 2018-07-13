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
