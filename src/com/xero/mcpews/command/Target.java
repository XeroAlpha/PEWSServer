package com.xero.mcpews.command;

import java.util.ArrayList;
import java.util.List;

public class Target {
    private boolean mIsPlayerName;
    private String mBody;
    private List<Criterion> mCriteria;

    protected Target() {
        mIsPlayerName = false;
        mCriteria = new ArrayList<>();
    }

    public static Target fromPlayerName(String name) {
        Target target = new Target();
        target.mIsPlayerName = true;
        target.mBody = name;
        return target;
    }

    public static Target fromSelector(String name) {
        Target target = new Target();
        target.mBody = "@" + name;
        return target;
    }

    public static Target allPlayers() {
        return fromSelector("a");
    }

    public static Target nearestPlayer() {
        return fromSelector("p");
    }

    public static Target randomPlayer() {
        return fromSelector("r");
    }

    public static Target self() {
        return fromSelector("s");
    }

    public static Target entities() {
        return fromSelector("e");
    }

    public Target addCriterion(String key, String value, boolean isInvert) {
        for (Criterion e : mCriteria) {
            if (e.getKey().equals(key) && !e.isInvert()) return this;
        }
        mCriteria.add(new Criterion(key, value, isInvert));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(mBody);
        if (!mIsPlayerName && mCriteria.size() > 0) {
            builder.append("[");
            for (Criterion e : mCriteria) {
                builder.append(e.toString()).append(",");
            }
            builder.replace(builder.length() - 2, builder.length() - 1, "]");
        }
        return builder.toString();
    }

    public static class Criterion {
        private String mKey, mValue;
        private boolean mInvert;

        public Criterion(String key, String value, boolean isInvert) {
            mKey = key;
            mValue = value;
            mInvert = isInvert;
        }

        public String getKey() {
            return mKey;
        }

        public String getValue() {
            return mValue;
        }

        public boolean isInvert() {
            return mInvert;
        }

        @Override
        public String toString() {
            return mKey + "=" + (mInvert ? "!" : "") + mValue;
        }
    }
}
