package com.byazt.p000do;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1291, 37})
public class pr {
    public static AbstractC0042pr hw;
    public static int pr = 4;

    /* JADX INFO: renamed from: com.byazt.do.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1291, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static abstract class AbstractC0042pr {
    }

    public static void pr(int i) {
        pr = i;
    }

    public static boolean pr() {
        return pr <= 3;
    }

    public static void pr(String str, String str2) {
        if (str2 != null && hw != null) {
            hw(str);
        }
    }

    public static void pr(String str) {
        hw("DownloaderLogger", str);
    }

    public static String hw(String str) {
        if (!TextUtils.isEmpty(str)) {
            return "Downloader-" + str;
        }
        return "DownloaderLogger";
    }

    public static void hw(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (pr <= 3) {
            hw(str);
        }
        if (hw != null) {
            hw(str);
        }
    }

    public static void pr(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (pr <= 3) {
            hw(str);
        }
        if (hw != null) {
            hw(str);
        }
    }

    public static void hn(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (pr <= 4) {
            hw(str);
        }
        if (hw != null) {
            hw(str);
        }
    }

    public static void hn(String str) {
        x("DownloaderLogger", str);
    }

    public static void x(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (pr <= 5) {
            hw(str);
        }
        if (hw != null) {
            hw(str);
        }
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (pr <= 6) {
            ho.hw(hw(str), str2);
        }
        if (hw != null) {
            hw(str);
        }
    }

    public static void hw(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (pr <= 6) {
            ho.pr(hw(str), str2, th);
        }
        if (hw != null) {
            hw(str);
        }
    }
}
