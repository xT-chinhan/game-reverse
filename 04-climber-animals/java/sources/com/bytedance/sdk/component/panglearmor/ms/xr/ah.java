package com.bytedance.sdk.component.panglearmor.ms.xr;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public static xr ms(RandomAccessFile randomAccessFile, long j, long j2) {
        return ms(randomAccessFile.getChannel(), j, j2);
    }

    public static xr ms(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new d(fileChannel, j, j2);
    }
}
