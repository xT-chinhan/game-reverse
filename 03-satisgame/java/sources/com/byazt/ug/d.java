package com.byazt.ug;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.ho.BaseConstants;
import com.byazt.ky.a;
import com.byazt.ky.cd;
import com.byazt.ky.cy;
import com.byazt.ky.hd;
import com.byazt.ky.ou;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 113})
public class d {
    public static com.byazt.my.n a;
    public static com.byazt.ky.sz cd;
    public static com.byazt.z.rv cp;
    public static ou cy;
    public static com.byazt.ky.q d;
    public static com.byazt.ky.cp fs;
    public static com.byazt.ky.k hd;
    public static com.byazt.ky.d k;
    public static com.byazt.ky.oa l;
    public static final JSONObject n = new JSONObject();
    public static com.byazt.ky.l oa;
    public static a ou;
    public static cd py;
    public static com.byazt.ky.s q;
    public static Context qg;
    public static com.byazt.os.n rv;
    public static com.byazt.ky.x s;
    public static cy sz;
    public static com.byazt.ky.qg tj;
    public static hd um;
    public static com.byazt.ky.fs w;
    public static com.byazt.ky.tj wm;
    public static com.byazt.ky.rv x;

    public static String sz() {
        return "1.7.0";
    }

    public static void n(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        qg = context.getApplicationContext();
    }

    public static void qg(Context context) {
        if (qg != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        qg = context.getApplicationContext();
    }

    public static Context getContext() {
        Context context = qg;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void n(com.byazt.ky.x xVar) {
        s = xVar;
    }

    public static void n(com.byazt.ky.s sVar) {
        q = sVar;
    }

    public static void n(com.byazt.ky.oa oaVar) {
        l = oaVar;
    }

    public static void n(com.byazt.ky.fs fsVar) {
        w = fsVar;
    }

    public static void n(com.byazt.ky.rv rvVar) {
        x = rvVar;
    }

    public static void n(com.byazt.ky.cp cpVar) {
        fs = cpVar;
    }

    public static void n(com.byazt.os.n nVar) {
        rv = nVar;
    }

    public static void n(com.byazt.ky.qg qgVar) {
        tj = qgVar;
    }

    public static com.byazt.ky.x n() {
        return s;
    }

    public static com.byazt.ky.s qg() {
        if (q == null) {
            q = new com.byazt.ky.s() { // from class: com.byazt.ug.d.1
                @Override // com.byazt.ky.s
                public void n(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                }
            };
        }
        return q;
    }

    public static com.byazt.ky.oa s() {
        if (l == null) {
            l = new com.byazt.jk.n();
        }
        return l;
    }

    public static com.byazt.ky.fs q() {
        return w;
    }

    public static com.byazt.ky.rv l() {
        if (x == null) {
            x = new com.byazt.jk.qg();
        }
        return x;
    }

    public static com.byazt.z.rv w() {
        if (cp == null) {
            cp = new com.byazt.z.rv() { // from class: com.byazt.ug.d.2
                @Override // com.byazt.z.rv
                public void n(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return cp;
    }

    public static cy x() {
        return sz;
    }

    public static hd fs() {
        if (um == null) {
            um = new hd() { // from class: com.byazt.ug.d.3
            };
        }
        return um;
    }

    public static JSONObject rv() {
        com.byazt.ky.cp cpVar = fs;
        if (cpVar == null || cpVar.n() == null) {
            return n;
        }
        return fs.n();
    }

    public static com.byazt.os.n tj() {
        if (rv == null) {
            rv = new com.byazt.os.n.C0285n().n();
        }
        return rv;
    }

    public static com.byazt.ky.sz cp() {
        return cd;
    }

    public static com.byazt.ky.qg d() {
        return tj;
    }

    public static com.byazt.ky.k oa() {
        return hd;
    }

    public static void n(String str) {
        com.byazt.e.q.cp().n(str);
    }

    public static void n(com.byazt.z.s sVar) {
        com.byazt.e.q.cp().n(sVar);
    }

    public static com.byazt.ky.q k() {
        return d;
    }

    public static com.byazt.ky.l cy() {
        return oa;
    }

    public static com.byazt.ky.d hd() {
        return k;
    }

    public static void n(cd cdVar) {
        py = cdVar;
    }

    public static cd cd() {
        return py;
    }

    public static ou um() {
        return cy;
    }

    public static void n(com.byazt.my.n nVar) {
        a = nVar;
    }

    public static com.byazt.my.n a() {
        if (a == null) {
            a = new com.byazt.my.n() { // from class: com.byazt.ug.d.4
                @Override // com.byazt.my.n
                public void n(Throwable th, String str) {
                }
            };
        }
        return a;
    }

    public static void n(a aVar) {
        ou = aVar;
    }

    public static a py() {
        if (ou == null) {
            ou = new a() { // from class: com.byazt.ug.d.5
                @Override // com.byazt.ky.a
                public void n(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i) {
                }
            };
        }
        return ou;
    }

    public static void n(com.byazt.ky.tj tjVar) {
        wm = tjVar;
    }

    public static com.byazt.ky.tj ou() {
        return wm;
    }

    public static String wm() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + rv().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean m() {
        return (s == null || w == null || fs == null || tj == null || py == null) ? false : true;
    }
}
