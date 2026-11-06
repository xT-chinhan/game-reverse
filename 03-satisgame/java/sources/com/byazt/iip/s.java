package com.byazt.iip;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 4, 8})
public abstract class s {
    public static qg n(RandomAccessFile randomAccessFile, long j, long j2) {
        return n(randomAccessFile.getChannel(), j, j2);
    }

    public static qg n(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new q(fileChannel, j, j2);
    }
}
