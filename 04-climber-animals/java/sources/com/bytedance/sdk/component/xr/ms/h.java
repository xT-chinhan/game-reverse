package com.bytedance.sdk.component.xr.ms;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements Closeable {
    public abstract InputStream ah();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract byte[] d();

    public abstract ch ka();

    public abstract long ms();

    public abstract String xr();
}
