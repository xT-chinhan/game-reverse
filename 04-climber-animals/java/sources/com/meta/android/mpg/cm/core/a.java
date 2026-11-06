package com.meta.android.mpg.cm.core;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static String a;

    public static String a() {
        return TextUtils.isEmpty(a) ? "" : "com.meta.box.mpg.cm.wrapper";
    }

    public static void a(Context context) {
        if (b.b()) {
            return;
        }
        try {
            a = context.getPackageManager().getApplicationInfo("com.meta.box", 0).packageName;
        } catch (Exception unused) {
        }
    }
}
