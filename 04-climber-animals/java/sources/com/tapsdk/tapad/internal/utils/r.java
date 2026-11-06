package com.tapsdk.tapad.internal.utils;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class r {
    public static boolean a() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    public static String b() {
        return Boolean.toString(a());
    }
}
