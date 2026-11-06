package com.bytedance.sdk.component.c.ah.ah;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
