package com.bytedance.adsdk.ugeno.c;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f347ms;
    private static Resources xr;

    private static String ms(Context context) {
        if (f347ms == null) {
            f347ms = context.getPackageName();
        }
        return f347ms;
    }

    private static int ms(Context context, String str, String str2) {
        if (xr == null) {
            xr = context.getResources();
        }
        return xr.getIdentifier(str, str2, ms(context));
    }

    public static int ms(Context context, String str) {
        return ms(context, str, "drawable");
    }

    public static int xr(Context context, String str) {
        return ms(context, str, "id");
    }
}
