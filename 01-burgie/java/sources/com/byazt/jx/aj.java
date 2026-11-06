package com.byazt.jx;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.b;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.yb;
import com.byazt.is.w;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 61})
public class aj {
    public static void pr(String str, of ofVar) {
        boolean zC;
        try {
            if (a.getContext() == null || TextUtils.isEmpty(str) || !(zC = qa.c(ofVar))) {
                return;
            }
            yb ybVarG = ofVar.g();
            if (ybVarG != null && !TextUtils.isEmpty(ybVarG.hw())) {
                ho.hw("TTDownload-Util", "含有deepLink");
                if (qa.hn(ofVar) != 0) {
                    ho.hw("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + qa.hn(ofVar));
                    return;
                }
            }
            if (zC) {
                if (com.byazt.igw.hw.hw(str)) {
                    ho.hw("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!qa.uc(ofVar)) {
                    hw(ofVar, str);
                } else {
                    pr(a.getContext(), ofVar, str);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static String pr(of ofVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("background", z);
            if (ofVar != null) {
                jSONObject.put("reqId", ofVar.ny());
                jSONObject.put("cid", ofVar.x());
                jSONObject.put("rit", ls.pr(ofVar, ""));
            }
            Context context = a.getContext();
            if (context == null) {
                jSONObject.put("message", "context is null");
                com.byazt.xk.hw.pr().pr("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            File fileHw = com.byazt.igw.hw.hw(context);
            if (fileHw == null) {
                jSONObject.put("message", "file is null");
                com.byazt.xk.hw.pr().pr("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            if (!fileHw.exists() && !fileHw.mkdirs()) {
                jSONObject.put("message", "mkdirs failed");
                com.byazt.xk.hw.pr().pr("dl_path_empty", jSONObject, (Throwable) null);
            }
            if (!fileHw.exists()) {
                return "";
            }
            return fileHw.getAbsolutePath();
        } catch (Throwable th) {
            try {
                jSONObject.put("message", "path:".concat(String.valueOf("")));
            } catch (JSONException e) {
            }
            com.byazt.xk.hw.pr().pr("dl_path_empty", jSONObject, th);
            return "";
        }
    }

    private static void hw(final of ofVar, final String str) {
        final com.byazt.wt.pr prVarHn;
        if (pr(ofVar) || (prVarHn = com.byazt.sd.zo.nt().hn()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        prVarHn.pr(new com.byazt.wt.pr.hn() { // from class: com.byazt.jx.aj.1
            @Override // com.byazt.wt.pr.hn, com.byazt.wt.pr.InterfaceC0225pr
            public void pr() {
                if (!er.pr()) {
                    com.byazt.wt.pr prVar = prVarHn;
                    if (prVar != null) {
                        prVar.hn();
                        return;
                    }
                    return;
                }
                if (!com.byazt.igw.hw.hw(str)) {
                    aj.hw(ofVar, jCurrentTimeMillis, prVarHn, str);
                }
                com.byazt.wt.pr prVar2 = prVarHn;
                if (prVar2 != null) {
                    prVar2.hn();
                }
            }
        });
    }

    private static void pr(Context context, final of ofVar, final String str) {
        final String strHn;
        final String str2;
        if (context == null || ofVar == null || pr(ofVar)) {
            return;
        }
        if (ofVar.ho() == null) {
            strHn = "";
        } else {
            strHn = ofVar.ho().hn();
        }
        if (!TextUtils.isEmpty(strHn)) {
            str2 = "安装完成，是否立即打开 ？";
        } else {
            str2 = "应用安装完成，是否立即打开 ？";
        }
        final com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        if (prVarHn == null) {
            return;
        }
        prVarHn.pr(new com.byazt.wt.pr.hn() { // from class: com.byazt.jx.aj.2
            @Override // com.byazt.wt.pr.hn, com.byazt.wt.pr.InterfaceC0225pr
            public void pr() {
                try {
                    if (!er.pr()) {
                        com.byazt.wt.pr prVar = prVarHn;
                        if (prVar != null) {
                            prVar.hn();
                            return;
                        }
                        return;
                    }
                    if (!com.byazt.igw.hw.hw(str)) {
                        aj.hw(prVarHn, ofVar, strHn, str2, str);
                    }
                    com.byazt.wt.pr prVar2 = prVarHn;
                    if (prVar2 != null) {
                        prVar2.hn();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    private static boolean pr(of ofVar) {
        if (ofVar == null || !pr(pr())) {
            return false;
        }
        int iAj = ofVar.aj();
        String strRc = ofVar.rc();
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if ((TextUtils.isEmpty(strRc) || iAj != 4) && !hnVarPr.hw("is_landing_page_open_market", false)) {
            return false;
        }
        hnVarPr.pr("is_landing_page_open_market", false);
        return true;
    }

    public static JSONObject pr() {
        w wVarHw = a.hw();
        if (wVarHw != null && wVarHw.qv() != null) {
            return wVarHw.qv();
        }
        return new JSONObject();
    }

    private static boolean pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.optInt("enable_open_app_dialog") != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final com.byazt.wt.pr prVar, final of ofVar, String str, String str2, final String str3) {
        String str4;
        if (prVar == null || !ls.hw(str3)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str4 = str;
        } else {
            str4 = "";
        }
        com.byazt.wt.c.pr(a.getContext(), ofVar.x(), str4, str2, "立即打开", "退出", new com.byazt.wt.c.pr() { // from class: com.byazt.jx.aj.3
            @Override // com.byazt.wt.c.pr
            public void pr() {
                aj.hn(ofVar, str3);
                com.byazt.wt.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.hn();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                com.byazt.wt.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.hn();
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                com.byazt.wt.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.hn();
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public static String pr(boolean z) {
        String path;
        File filePr;
        if (z) {
            try {
                if (!hw()) {
                    File file = new File(com.byazt.ca.uc.hw(a.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    path = file.getPath();
                } else {
                    path = null;
                }
            } catch (Throwable th) {
                return null;
            }
        } else {
            path = null;
        }
        if (TextUtils.isEmpty(path)) {
            if ("mounted".equals(com.byazt.zp.x.pr()) && (filePr = com.byazt.ca.uc.pr(a.getContext(), Environment.DIRECTORY_DOWNLOADS, false, null)) != null) {
                path = filePr.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(com.byazt.ca.uc.pr(a.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        vk.pr();
        return path;
    }

    public static boolean hw() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(of ofVar, String str) {
        if (ofVar == null) {
            return;
        }
        ls.pr(a.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(of ofVar, long j, com.byazt.wt.pr prVar, String str) {
        String strHn;
        String str2;
        if (ofVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) qa.fw(ofVar)) * 1000) {
            if (ofVar.ho() == null) {
                strHn = "";
            } else {
                strHn = ofVar.ho().hn();
            }
            if (!TextUtils.isEmpty(strHn)) {
                str2 = "安装完成，是否立即打开 ？";
            } else {
                str2 = "应用安装完成，是否立即打开 ？";
            }
            hw(prVar, ofVar, strHn, str2, str);
            return;
        }
        hn(ofVar, str);
    }

    public static void pr(Runnable runnable, com.byazt.af.aj ajVar) {
        if (ajVar == null || runnable == null) {
            return;
        }
        if (qa.uc(ajVar.z_())) {
            com.byazt.zp.zo.pr((Runnable) new com.byazt.xlm.fw("tt_download_toast") { // from class: com.byazt.jx.aj.4
                @Override // java.lang.Runnable
                public void run() {
                    b.pr(a.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            lb.uc().postDelayed(runnable, 500L);
        } else {
            com.byazt.zp.zo.pr(runnable);
        }
    }

    public static String hn() {
        try {
            Function<SparseArray<Object>, Object> functionLs = com.byazt.sd.zo.nt().ls();
            if (functionLs != null) {
                functionLs.apply(com.byazt.xi.hw.pr().pr(1).pr(String.class).hw());
                return "0.0.0";
            }
            return "0.0.0";
        } catch (Exception e) {
            return "0.0.0";
        }
    }

    public static void x() {
        if (com.byazt.sd.zo.nt().ls() != null) {
            com.byazt.sd.zo.nt().ls().apply(com.byazt.xi.hw.pr().pr(20).pr(Void.class).hw());
        } else {
            ho.hw("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }
}
