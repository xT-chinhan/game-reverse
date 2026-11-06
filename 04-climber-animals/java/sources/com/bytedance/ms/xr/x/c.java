package com.bytedance.ms.xr.x;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
