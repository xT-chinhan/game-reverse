package com.bytedance.sdk.component.ab;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Context f733ms;

    public static void ms(Context context) {
        if (f733ms == null && context != null) {
            f733ms = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return f733ms;
    }
}
