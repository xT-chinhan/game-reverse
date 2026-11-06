package com.byazt.du;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface qa extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long pr(hn hnVar, long j) throws IOException;

    a pr();
}
