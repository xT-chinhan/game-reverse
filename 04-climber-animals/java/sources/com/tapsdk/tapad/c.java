package com.tapsdk.tapad;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static volatile Context a;

    public static void a(Context context) {
        synchronized (c.class) {
            if (a == null) {
                a = context.getApplicationContext();
            }
        }
    }
}
