package com.smartdigimkt.r4;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        try {
            com.smartdigimkt.k4.c.a().a(context, str).a(Long.valueOf(j), str2);
        } catch (Throwable unused) {
        }
    }

    public static long b(Context context, String str, String str2) {
        if (context == null) {
            return 0L;
        }
        try {
            Long l = (Long) com.smartdigimkt.k4.c.a().a(context, str).b(0L, str2);
            if (l != null) {
                return l.longValue();
            }
        } catch (Throwable unused) {
        }
        return 0L;
    }

    public static String c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            return (String) com.smartdigimkt.k4.c.a().a(context, str).b("", str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            com.smartdigimkt.k4.c.a().a(context, str).a(str3, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        try {
            com.smartdigimkt.k4.c.a().a(context, str).a(Integer.valueOf(i), str2);
        } catch (Throwable unused) {
        }
    }

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        try {
            return ((Integer) com.smartdigimkt.k4.c.a().a(context, str).b(0, str2)).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }
}
