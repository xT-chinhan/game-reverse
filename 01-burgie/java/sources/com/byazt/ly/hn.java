package com.byazt.ly;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 406, 20})
public abstract class hn {
    public static hw pr(RandomAccessFile randomAccessFile, long j, long j2) {
        return pr(randomAccessFile.getChannel(), j, j2);
    }

    public static hw pr(FileChannel fileChannel, long j, long j2) {
        if (fileChannel == null) {
            throw new NullPointerException();
        }
        return new x(fileChannel, j, j2);
    }
}
