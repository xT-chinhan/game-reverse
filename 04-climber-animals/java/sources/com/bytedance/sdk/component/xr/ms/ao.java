package com.bytedance.sdk.component.xr.ms;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ao implements Closeable {
    public abstract c ab();

    public abstract int ah();

    public abstract h c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract boolean d();

    public abstract String ka() throws IOException;

    public abstract long ms();

    public abstract String ms(String str);

    public abstract String ms(String str, String str2);

    public abstract hi ny();

    public abstract zb x();

    public abstract long xr();
}
