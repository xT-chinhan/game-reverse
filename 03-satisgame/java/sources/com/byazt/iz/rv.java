package com.byazt.iz;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.china.b.c;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.tk.h;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static void n(String str, pk pkVar) {
        boolean zL;
        try {
            if (com.byazt.nf.rv.getContext() == null || TextUtils.isEmpty(str) || !(zL = um.l(pkVar))) {
                return;
            }
            hd hdVarSz = pkVar.sz();
            if (hdVarSz != null && !TextUtils.isEmpty(hdVarSz.qg())) {
                k.qg("TTDownload-Util", "含有deepLink");
                if (um.s(pkVar) != 0) {
                    k.qg("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + um.s(pkVar));
                    return;
                }
            }
            if (zL) {
                if (com.byazt.hnb.n.qg(str)) {
                    k.qg("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!um.w(pkVar)) {
                    qg(pkVar, str);
                } else {
                    n(com.byazt.nf.rv.getContext(), pkVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String n(pk pkVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("background", z);
            if (pkVar != null) {
                jSONObject.put("reqId", pkVar.ou());
                jSONObject.put("cid", pkVar.q());
                jSONObject.put("rit", com.byazt.vgx.w.n(pkVar, ""));
            }
            Context context = com.byazt.nf.rv.getContext();
            if (context == null) {
                jSONObject.put("message", "context is null");
                com.byazt.eji.s.n().n("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            File fileQg = com.byazt.hnb.n.qg(context);
            if (fileQg == null) {
                jSONObject.put("message", "file is null");
                com.byazt.eji.s.n().n("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            if (!fileQg.exists() && !fileQg.mkdirs()) {
                jSONObject.put("message", "mkdirs failed");
                com.byazt.eji.s.n().n("dl_path_empty", jSONObject, (Throwable) null);
            }
            return fileQg.exists() ? fileQg.getAbsolutePath() : "";
        } catch (Throwable th) {
            try {
                jSONObject.put("message", "path:".concat(""));
            } catch (JSONException unused) {
            }
            com.byazt.eji.s.n().n("dl_path_empty", jSONObject, th);
            return "";
        }
    }

    private static void qg(final pk pkVar, final String str) {
        final com.byazt.ot.n nVarS;
        if (n(pkVar) || (nVarS = com.byazt.vyf.s.cy().s()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        nVarS.n(new com.byazt.ot.n.s() { // from class: com.byazt.iz.rv.1
            @Override // com.byazt.ot.n.s, com.byazt.ot.n.InterfaceC0287n
            public void n() {
                if (!com.byazt.okk.s.n()) {
                    com.byazt.ot.n nVar = nVarS;
                    if (nVar != null) {
                        nVar.s();
                        return;
                    }
                    return;
                }
                if (!com.byazt.hnb.n.qg(str)) {
                    rv.qg(pkVar, jCurrentTimeMillis, nVarS, str);
                }
                com.byazt.ot.n nVar2 = nVarS;
                if (nVar2 != null) {
                    nVar2.s();
                }
            }
        });
    }

    private static void n(Context context, final pk pkVar, final String str) {
        if (context == null || pkVar == null || n(pkVar)) {
            return;
        }
        final String strS = pkVar.k() != null ? pkVar.k().s() : "";
        final String str2 = TextUtils.isEmpty(strS) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS == null) {
            return;
        }
        nVarS.n(new com.byazt.ot.n.s() { // from class: com.byazt.iz.rv.2
            @Override // com.byazt.ot.n.s, com.byazt.ot.n.InterfaceC0287n
            public void n() {
                try {
                    if (!com.byazt.okk.s.n()) {
                        com.byazt.ot.n nVar = nVarS;
                        if (nVar != null) {
                            nVar.s();
                            return;
                        }
                        return;
                    }
                    if (!com.byazt.hnb.n.qg(str)) {
                        rv.qg(nVarS, pkVar, strS, str2, str);
                    }
                    com.byazt.ot.n nVar2 = nVarS;
                    if (nVar2 != null) {
                        nVar2.s();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean n(pk pkVar) {
        if (pkVar == null || !n(n())) {
            return false;
        }
        int iRv = pkVar.rv();
        String strM = pkVar.m();
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        if ((TextUtils.isEmpty(strM) || iRv != 4) && !sVarN.qg("is_landing_page_open_market", false)) {
            return false;
        }
        sVarN.n("is_landing_page_open_market", false);
        return true;
    }

    public static JSONObject n() {
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        if (wVarQg != null && wVarQg.np() != null) {
            return wVarQg.np();
        }
        return new JSONObject();
    }

    private static boolean n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final com.byazt.ot.n nVar, final pk pkVar, String str, String str2, final String str3) {
        if (nVar != null && com.byazt.vgx.w.qg(str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strQ = pkVar.q();
            com.byazt.okk.n.n(com.byazt.nf.rv.getContext(), strQ, str, str2, "立即打开", "退出", new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.iz.rv.3
                @Override // com.byazt.okk.n.InterfaceC0282n
                public void n() {
                    rv.s(pkVar, str3);
                    com.byazt.ot.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.s();
                    }
                }

                @Override // com.byazt.okk.n.InterfaceC0282n
                public void qg() {
                    com.byazt.ot.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.s();
                    }
                }

                @Override // com.byazt.okk.n.InterfaceC0282n
                public void s() {
                    com.byazt.ot.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.s();
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public static String n(boolean z) {
        String path;
        File fileN;
        if (z) {
            try {
                if (qg()) {
                    path = null;
                } else {
                    File file = new File(com.byazt.tk.w.qg(com.byazt.nf.rv.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    path = file.getPath();
                }
            } catch (Throwable unused) {
                return null;
            }
        } else {
            path = null;
        }
        if (TextUtils.isEmpty(path)) {
            if ("mounted".equals(com.byazt.xu.qg.n()) && (fileN = com.byazt.tk.w.n(com.byazt.nf.rv.getContext(), Environment.DIRECTORY_DOWNLOADS, false, null)) != null) {
                path = fileN.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(com.byazt.tk.w.n(com.byazt.nf.rv.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        com.byazt.ehw.s.n();
        return path;
    }

    public static boolean qg() {
        return com.byazt.af.x.n().n(com.byazt.nf.rv.getContext(), c.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(pk pkVar, String str) {
        if (pkVar == null) {
            return;
        }
        com.byazt.vgx.w.n(com.byazt.nf.rv.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(pk pkVar, long j, com.byazt.ot.n nVar, String str) {
        if (pkVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) um.x(pkVar)) * 1000) {
            String strS = pkVar.k() != null ? pkVar.k().s() : "";
            qg(nVar, pkVar, strS, TextUtils.isEmpty(strS) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
        } else {
            s(pkVar, str);
        }
    }

    public static void n(Runnable runnable, com.byazt.llp.rv rvVar) {
        if (rvVar == null || runnable == null) {
            return;
        }
        if (um.w(rvVar.D_())) {
            com.byazt.ag.qg.n((Runnable) new com.byazt.qit.x("tt_download_toast") { // from class: com.byazt.iz.rv.4
                @Override // java.lang.Runnable
                public void run() {
                    h.n(com.byazt.nf.rv.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            com.byazt.vyf.l.q().postDelayed(runnable, 500L);
        } else {
            com.byazt.ag.qg.n(runnable);
        }
    }

    public static String s() {
        try {
            Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
            if (functionFi == null) {
                return "0.0.0";
            }
            functionFi.apply(com.byazt.of.qg.n().n(1).n(String.class).qg());
            return "0.0.0";
        } catch (Exception unused) {
            return "0.0.0";
        }
    }

    public static void q() {
        if (com.byazt.vyf.s.cy().fi() != null) {
            com.byazt.vyf.s.cy().fi().apply(com.byazt.of.qg.n().n(20).n(Void.class).qg());
        } else {
            k.qg("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }
}
