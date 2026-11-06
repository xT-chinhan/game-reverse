package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.ss.android.download.api.config.ao;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.nw;
import com.ss.android.download.api.config.ub;
import com.ss.android.download.api.config.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hi {
    private static com.ss.android.download.api.config.ny ab;
    private static com.ss.android.download.api.config.ab ah;
    private static nw ao;
    private static y b;
    private static com.ss.android.download.api.config.x c;
    private static com.ss.android.download.api.config.xr ch;
    private static com.ss.android.download.api.config.ah d;
    private static com.ss.android.download.api.config.u h;
    private static com.ss.android.socialbase.appdownloader.ah.x hi;
    private static com.ss.android.download.api.config.sl ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final JSONObject f4415ms = new JSONObject();
    private static h nw;
    private static com.ss.android.download.api.model.ms ny;
    private static com.ss.android.download.api.config.zb qv;
    private static com.ss.android.download.api.config.d sl;
    private static com.ss.android.download.api.xr.ms t;
    private static ub u;
    private static com.ss.android.download.api.config.hi ub;
    private static com.ss.android.download.api.config.ch x;
    private static Context xr;
    private static ao y;
    private static com.ss.android.download.api.config.ka zb;

    public static String u() {
        return "1.7.0";
    }

    public static void ms(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        xr = context.getApplicationContext();
    }

    public static void xr(Context context) {
        if (xr != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        xr = context.getApplicationContext();
    }

    public static Context getContext() {
        Context context = xr;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void ms(com.ss.android.download.api.config.ab abVar) {
        ah = abVar;
    }

    public static void ms(com.ss.android.download.api.config.sl slVar) {
        ka = slVar;
    }

    public static void ms(com.ss.android.download.api.config.x xVar) {
        c = xVar;
    }

    public static void ms(com.ss.android.download.api.config.ny nyVar) {
        ab = nyVar;
    }

    public static void ms(com.ss.android.download.api.config.ch chVar) {
        x = chVar;
    }

    public static void ms(com.ss.android.download.api.model.ms msVar) {
        ny = msVar;
    }

    public static void ms(com.ss.android.download.api.config.xr xrVar) {
        ch = xrVar;
    }

    public static com.ss.android.download.api.config.ab ms() {
        return ah;
    }

    public static com.ss.android.download.api.config.ah xr() {
        if (d == null) {
            d = new com.ss.android.download.api.config.ah() { // from class: com.ss.android.downloadlib.addownload.hi.1
            };
        }
        return d;
    }

    public static com.ss.android.download.api.config.sl ah() {
        if (ka == null) {
            ka = new com.ss.android.download.api.ms.ms();
        }
        return ka;
    }

    public static com.ss.android.download.api.config.x d() {
        return c;
    }

    public static com.ss.android.download.api.config.ny ka() {
        if (ab == null) {
            ab = new com.ss.android.download.api.ms.xr();
        }
        return ab;
    }

    public static com.ss.android.socialbase.appdownloader.ah.x c() {
        if (hi == null) {
            hi = new com.ss.android.socialbase.appdownloader.ah.x() { // from class: com.ss.android.downloadlib.addownload.hi.2
                @Override // com.ss.android.socialbase.appdownloader.ah.x
                public void ms(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return hi;
    }

    public static ub ab() {
        return u;
    }

    public static ao x() {
        if (y == null) {
            y = new ao() { // from class: com.ss.android.downloadlib.addownload.hi.3
            };
        }
        return y;
    }

    public static JSONObject ny() {
        com.ss.android.download.api.config.ch chVar = x;
        if (chVar == null || chVar.ms() == null) {
            return f4415ms;
        }
        return x.ms();
    }

    public static com.ss.android.download.api.model.ms ch() {
        if (ny == null) {
            ny = new com.ss.android.download.api.model.ms.C0530ms().ms();
        }
        return ny;
    }

    public static com.ss.android.download.api.config.zb hi() {
        return qv;
    }

    public static com.ss.android.download.api.config.xr sl() {
        return ch;
    }

    public static com.ss.android.download.api.config.u zb() {
        return h;
    }

    public static void ms(String str) {
        com.ss.android.socialbase.appdownloader.d.ch().ms(str);
    }

    public static com.ss.android.download.api.config.d ub() {
        return sl;
    }

    public static com.ss.android.download.api.config.ka ao() {
        return zb;
    }

    public static com.ss.android.download.api.config.hi h() {
        return ub;
    }

    public static void ms(h hVar) {
        nw = hVar;
    }

    public static h qv() {
        return nw;
    }

    public static nw y() {
        return ao;
    }

    public static void ms(com.ss.android.download.api.xr.ms msVar) {
        t = msVar;
    }

    public static com.ss.android.download.api.xr.ms t() {
        if (t == null) {
            t = new com.ss.android.download.api.xr.ms() { // from class: com.ss.android.downloadlib.addownload.hi.4
                @Override // com.ss.android.download.api.xr.ms
                public void ms(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    public static y nw() {
        if (b == null) {
            b = new y() { // from class: com.ss.android.downloadlib.addownload.hi.5
            };
        }
        return b;
    }

    public static String b() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + ny().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean re() {
        return (ah == null || c == null || x == null || ch == null || nw == null) ? false : true;
    }
}
