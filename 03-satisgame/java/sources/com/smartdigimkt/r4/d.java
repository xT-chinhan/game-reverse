package com.smartdigimkt.r4;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static b a(Activity activity, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a(activity, runnable);
        }
        return null;
    }
}
