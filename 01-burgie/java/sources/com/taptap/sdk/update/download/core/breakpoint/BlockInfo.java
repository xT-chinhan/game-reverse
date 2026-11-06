package com.taptap.sdk.update.download.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class BlockInfo {
    private final long contentLength;
    private final AtomicLong currentOffset;
    private final long startOffset;

    public BlockInfo(long startOffset, long contentLength) {
        this(startOffset, contentLength, 0L);
    }

    public BlockInfo(long startOffset, long contentLength, long currentOffset) {
        if (startOffset < 0 || ((contentLength < 0 && contentLength != -1) || currentOffset < 0)) {
            throw new IllegalArgumentException();
        }
        this.startOffset = startOffset;
        this.contentLength = contentLength;
        this.currentOffset = new AtomicLong(currentOffset);
    }

    public long getCurrentOffset() {
        return this.currentOffset.get();
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public long getRangeLeft() {
        return this.startOffset + this.currentOffset.get();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getRangeRight() {
        return (this.startOffset + this.contentLength) - 1;
    }

    public void increaseCurrentOffset(long increaseLength) {
        this.currentOffset.addAndGet(increaseLength);
    }

    public void resetBlock() {
        this.currentOffset.set(0L);
    }

    public BlockInfo copy() {
        return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset.get());
    }

    public String toString() {
        return "[" + this.startOffset + ", " + getRangeRight() + ")-current:" + this.currentOffset;
    }
}
