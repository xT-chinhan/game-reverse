package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes3.dex */
public class ab {
    private static aa a = null;
    private static boolean b = false;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            if (a != null) {
                try {
                    return a.a(context);
                } catch (Exception e) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (a == null && !b) {
            synchronized (ab.class) {
                if (a == null && !b) {
                    a = ad.a(context);
                    b = true;
                }
            }
        }
    }
}
