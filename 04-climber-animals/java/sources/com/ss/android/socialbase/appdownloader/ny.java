package com.ss.android.socialbase.appdownloader;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class ny {
    public static int ms(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int ms(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int xr(String str) {
        return ms(com.ss.android.socialbase.downloader.downloader.ah.k(), str);
    }

    public static int ah(String str) {
        try {
            return ms(str, com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int ms(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int d(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int ka(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int c(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.ah.k().getPackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }

    public static int xr(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.ah.k().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return 0;
        }
    }
}
