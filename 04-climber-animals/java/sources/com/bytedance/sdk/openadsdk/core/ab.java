package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ab f1888ms;

    public static ab ms(Context context) {
        if (f1888ms == null) {
            synchronized (ab.class) {
                if (f1888ms == null) {
                    f1888ms = new ab(context);
                }
            }
        }
        return f1888ms;
    }

    private ab(Context context) {
        super(context);
    }
}
