package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class u7 {
    public static volatile u7 c;
    public final t7 a;
    public final f5 b;

    public u7(Context context) {
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        this.a = new t7(Math.min(iMaxMemory > 134217728 ? iMaxMemory >> 4 : iMaxMemory >> 5, 8388608));
        f5 f5VarA = null;
        try {
            f5VarA = f5.a(ij.c(context));
        } catch (Throwable th) {
            r9.a("ssp_icp", "open disk cache failed", th);
        }
        this.b = f5VarA;
    }

    public static u7 a(Context context) {
        if (c == null) {
            synchronized (u7.class) {
                if (c == null) {
                    c = new u7(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    public final Bitmap a(String str) {
        return (Bitmap) this.a.get(str);
    }
}
