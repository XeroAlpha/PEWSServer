package com.xero.mcpews.command;

public class CommandResponse<T extends Command> {
    private transient T mSource;

    public T getSource() {
        return mSource;
    }

    public void setSource(T source) {
        if (mSource != null) return;
        mSource = source;
    }
}
