package com.smartdigimkt.i3;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Closeable {
    public final InputStream[] a;

    public e(InputStream[] inputStreamArr) {
        this.a = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (InputStream inputStream : this.a) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
    }
}
