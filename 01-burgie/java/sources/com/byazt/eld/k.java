package com.byazt.eld;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.fi.BaseConstants;
import com.byazt.lhc.BaseException;
import com.byazt.zv.a;
import com.byazt.zv.lb;
import com.byazt.zv.nt;
import com.byazt.zv.ny;
import com.byazt.zv.yb;
import com.efs.sdk.base.EfsConstant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 250})
public class k {
    public static com.byazt.pz.pr a;
    public static com.byazt.cxa.pr aj;
    public static com.byazt.zv.m c;
    public static lb cz;
    public static com.byazt.zv.vk fo;
    public static com.byazt.zv.aj fw;
    public static nt g;
    public static com.byazt.zv.fw hn;
    public static com.byazt.zv.k ho;
    public static Context hw;
    public static com.byazt.zv.x k;
    public static com.byazt.zv.g lb;
    public static com.byazt.zv.c m;
    public static ny nt;
    public static a ny;
    public static final JSONObject pr = new JSONObject();
    public static yb qa;
    public static com.byazt.zv.zo uc;
    public static com.byazt.zv.hw vk;
    public static com.byazt.zkm.aj w;
    public static com.byazt.zv.hn x;
    public static com.byazt.zv.ho yb;
    public static com.byazt.zv.w zo;

    public static void pr(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        hw = context.getApplicationContext();
    }

    public static void hw(Context context) {
        if (hw == null && context != null && context.getApplicationContext() != null) {
            hw = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        Context context = hw;
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return context;
    }

    public static void pr(com.byazt.zv.fw fwVar) {
        hn = fwVar;
    }

    public static void pr(com.byazt.zv.hn hnVar) {
        x = hnVar;
    }

    public static void pr(com.byazt.zv.m mVar) {
        c = mVar;
    }

    public static void pr(com.byazt.zv.zo zoVar) {
        uc = zoVar;
    }

    public static void pr(com.byazt.zv.aj ajVar) {
        fw = ajVar;
    }

    public static void pr(com.byazt.zv.w wVar) {
        zo = wVar;
    }

    public static void pr(com.byazt.cxa.pr prVar) {
        aj = prVar;
    }

    public static void pr(com.byazt.zv.hw hwVar) {
        vk = hwVar;
    }

    public static com.byazt.zv.fw pr() {
        return hn;
    }

    public static com.byazt.zv.hn hw() {
        if (x == null) {
            x = new com.byazt.zv.hn() { // from class: com.byazt.eld.k.1
                @Override // com.byazt.zv.hn
                public void pr(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                }
            };
        }
        return x;
    }

    public static com.byazt.zv.m hn() {
        if (c == null) {
            c = new com.byazt.yyh.pr();
        }
        return c;
    }

    public static com.byazt.zv.zo x() {
        return uc;
    }

    public static com.byazt.zv.aj c() {
        if (fw == null) {
            fw = new com.byazt.yyh.hw();
        }
        return fw;
    }

    public static com.byazt.zkm.aj uc() {
        if (w == null) {
            w = new com.byazt.zkm.aj() { // from class: com.byazt.eld.k.2
                @Override // com.byazt.zkm.aj
                public void pr(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return w;
    }

    public static nt fw() {
        return g;
    }

    public static yb zo() {
        if (qa == null) {
            qa = new yb() { // from class: com.byazt.eld.k.3
            };
        }
        return qa;
    }

    public static JSONObject aj() {
        com.byazt.zv.w wVar = zo;
        if (wVar == null || wVar.pr() == null) {
            return pr;
        }
        return zo.pr();
    }

    public static com.byazt.cxa.pr vk() {
        if (aj == null) {
            aj = new com.byazt.cxa.pr.C0037pr().pr();
        }
        return aj;
    }

    public static com.byazt.zv.g w() {
        return lb;
    }

    public static com.byazt.zv.hw k() {
        return vk;
    }

    public static com.byazt.zv.ho m() {
        return yb;
    }

    public static void pr(String str) {
        com.byazt.mdu.x.w().pr(str);
    }

    public static void pr(com.byazt.zkm.hn hnVar) {
        com.byazt.mdu.x.w().pr(hnVar);
    }

    public static String g() {
        return EfsConstant.UM_SDK_VERSION;
    }

    public static com.byazt.zv.x ho() {
        return k;
    }

    public static com.byazt.zv.c nt() {
        return m;
    }

    public static com.byazt.zv.k yb() {
        return ho;
    }

    public static void pr(lb lbVar) {
        cz = lbVar;
    }

    public static lb lb() {
        return cz;
    }

    public static ny qa() {
        return nt;
    }

    public static void pr(com.byazt.pz.pr prVar) {
        a = prVar;
    }

    public static com.byazt.pz.pr a() {
        if (a == null) {
            a = new com.byazt.pz.pr() { // from class: com.byazt.eld.k.4
                @Override // com.byazt.pz.pr
                public void pr(Throwable th, String str) {
                }
            };
        }
        return a;
    }

    public static void pr(a aVar) {
        ny = aVar;
    }

    public static a cz() {
        if (ny == null) {
            ny = new a() { // from class: com.byazt.eld.k.5
                @Override // com.byazt.zv.a
                public void pr(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i) {
                }
            };
        }
        return ny;
    }

    public static void pr(com.byazt.zv.vk vkVar) {
        fo = vkVar;
    }

    public static com.byazt.zv.vk ny() {
        return fo;
    }

    public static String fo() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + aj().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean rc() {
        if (hn == null || uc == null || zo == null || vk == null || cz == null) {
            return false;
        }
        return true;
    }
}
