package com.tapsdk.tapad.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class AppContextHolder {
    public static volatile Context appContext;

    private AppContextHolder() {
    }

    public static Context get() {
        return appContext;
    }

    public static void init(Context context) {
        synchronized (AppContextHolder.class) {
            if (appContext == null) {
                appContext = context.getApplicationContext();
            }
        }
    }
}
