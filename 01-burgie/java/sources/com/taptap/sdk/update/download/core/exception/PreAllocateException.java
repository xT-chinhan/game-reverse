package com.taptap.sdk.update.download.core.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class PreAllocateException extends IOException {
    private final long freeSpace;
    private final long requireSpace;

    public PreAllocateException(long requireSpace, long freeSpace) {
        super("There is Free space less than Require space: " + freeSpace + " < " + requireSpace);
        this.requireSpace = requireSpace;
        this.freeSpace = freeSpace;
    }

    public long getRequireSpace() {
        return this.requireSpace;
    }

    public long getFreeSpace() {
        return this.freeSpace;
    }
}
