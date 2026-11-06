package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: InternalConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static String[] a = new String[2];

    public static void a(Context context, String str, String str2) {
        a[0] = str;
        a[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static String[] a(Context context) {
        String[] strArrA;
        if (!TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
            return a;
        }
        if (context != null && (strArrA = com.umeng.common.b.a(context).a()) != null) {
            a[0] = strArrA[0];
            a[1] = strArrA[1];
            return a;
        }
        return null;
    }

    public static void b(Context context) {
        a[0] = null;
        a[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }
}
