package com.bytedance.sdk.component.ah.ms;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface y extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long ms(ah ahVar, long j) throws IOException;

    t ms();
}
