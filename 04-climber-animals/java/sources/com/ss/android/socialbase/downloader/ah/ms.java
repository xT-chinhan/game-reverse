package com.ss.android.socialbase.downloader.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f4612ms = 4;
    private static AbstractC0548ms xr;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.ah.ms$ms, reason: collision with other inner class name */
    public static abstract class AbstractC0548ms {
    }

    public static void ms(int i) {
        f4612ms = i;
    }

    public static boolean ms() {
        return f4612ms <= 3;
    }

    public static void ms(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f4612ms <= 2) {
            ab.ms(str, str2);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void ms(String str) {
        xr("DownloaderLogger", str);
    }

    public static String xr(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-" + str : "DownloaderLogger";
    }

    public static void xr(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f4612ms <= 3) {
            ab.xr(xr(str), str2);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void ms(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f4612ms <= 3) {
            ab.xr(xr(str), str2, th);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void ah(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f4612ms <= 4) {
            ab.ah(xr(str), str2);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void ah(String str) {
        d("DownloaderLogger", str);
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f4612ms <= 5) {
            ab.d(xr(str), str2);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void ka(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f4612ms <= 6) {
            ab.ka(xr(str), str2);
        }
        if (xr != null) {
            xr(str);
        }
    }

    public static void xr(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f4612ms <= 6) {
            ab.ka(xr(str), str2, th);
        }
        if (xr != null) {
            xr(str);
        }
    }
}
