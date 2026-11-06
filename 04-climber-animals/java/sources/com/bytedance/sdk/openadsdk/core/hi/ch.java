package com.bytedance.sdk.openadsdk.core.hi;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.hi;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.kuaishou.weapon.p0.bq;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static void ms(String str, lm lmVar) {
        boolean zAb;
        try {
            if (re.getContext() == null || TextUtils.isEmpty(str) || !(zAb = nw.ab(lmVar))) {
                return;
            }
            h hVarTc = lmVar.tc();
            if (hVarTc != null && !TextUtils.isEmpty(hVarTc.xr())) {
                sl.d("TTDownload-Util", "含有deepLink");
                if (nw.d(lmVar) != 0) {
                    sl.d("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + nw.d(lmVar));
                    return;
                }
            }
            if (zAb) {
                if (com.bytedance.sdk.openadsdk.ub.xr.ms(str)) {
                    sl.d("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!nw.x(lmVar)) {
                    xr(lmVar, str);
                } else {
                    ms(re.getContext(), lmVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String ms() {
        String strAh = com.bytedance.sdk.openadsdk.ub.xr.ah();
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = com.bytedance.sdk.openadsdk.core.ch.ub().ao();
        if (kaVarAo == null || kaVarAo.ka()) {
            return strAh;
        }
        try {
            return ka();
        } catch (Throwable unused) {
            return strAh;
        }
    }

    private static String ka() {
        File fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (fileMs == null) {
            return null;
        }
        if (!fileMs.exists()) {
            fileMs.mkdirs();
        }
        if (fileMs.exists()) {
            return fileMs.getAbsolutePath();
        }
        return null;
    }

    private static void xr(final lm lmVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.jw.ms msVarD;
        if (ms(lmVar) || (msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        msVarD.ms(new com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ch.1
            @Override // com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms
            public void ms() {
                if (!ul.ms()) {
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar = msVarD;
                    if (msVar != null) {
                        msVar.ah();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.ub.xr.ms(str)) {
                    ch.xr(lmVar, jCurrentTimeMillis, msVarD, str);
                }
                com.bytedance.sdk.openadsdk.core.jw.ms msVar2 = msVarD;
                if (msVar2 != null) {
                    msVar2.ah();
                }
            }
        });
    }

    private static void ms(Context context, final lm lmVar, final String str) {
        if (context == null || lmVar == null || ms(lmVar)) {
            return;
        }
        final String strAh = lmVar.zh() != null ? lmVar.zh().ah() : "";
        final String str2 = TextUtils.isEmpty(strAh) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.bytedance.sdk.openadsdk.core.jw.ms msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms(new com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ch.2
            @Override // com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms
            public void ms() {
                try {
                    if (!ul.ms()) {
                        com.bytedance.sdk.openadsdk.core.jw.ms msVar = msVarD;
                        if (msVar != null) {
                            msVar.ah();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.ub.xr.ms(str)) {
                        ch.xr(msVarD, lmVar, strAh, str2, str);
                    }
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar2 = msVarD;
                    if (msVar2 != null) {
                        msVar2.ah();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean ms(lm lmVar) {
        if (lmVar == null || !ms(xr())) {
            return false;
        }
        int iJr = lmVar.jr();
        String strZm = lmVar.zm();
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        if ((TextUtils.isEmpty(strZm) || iJr != 4) && !xrVarMs.xr("is_landing_page_open_market", false)) {
            return false;
        }
        xrVarMs.ms("is_landing_page_open_market", false);
        return true;
    }

    public static JSONObject xr() {
        com.bytedance.sdk.openadsdk.core.g.ch chVarXr = re.xr();
        if (chVarXr != null && chVarXr.ti() != null) {
            return chVarXr.ti();
        }
        return new JSONObject();
    }

    private static boolean ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final com.bytedance.sdk.openadsdk.core.jw.ms msVar, final lm lmVar, String str, String str2, final String str3) {
        if (msVar != null && f.ah(re.getContext(), str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strDf = lmVar.df();
            com.bytedance.sdk.openadsdk.core.jw.c.ms(re.getContext(), strDf, str, str2, "立即打开", "退出", new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ch.3
                @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
                public void ms() {
                    ch.ah(lmVar, str3);
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ah();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
                public void xr() {
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ah();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
                public void ah() {
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ah();
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    public static String ms(boolean z) {
        String path;
        File fileMs;
        if (z) {
            try {
                if (ah()) {
                    path = null;
                } else {
                    File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext()), Environment.DIRECTORY_DOWNLOADS);
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
            if ("mounted".equals(com.bytedance.sdk.openadsdk.op.ah.ms()) && (fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext(), Environment.DIRECTORY_DOWNLOADS)) != null) {
                path = fileMs.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        hi.ms();
        return path;
    }

    public static boolean ah() {
        return com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(lm lmVar, String str) {
        if (lmVar == null) {
            return;
        }
        f.ms(re.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(lm lmVar, long j, com.bytedance.sdk.openadsdk.core.jw.ms msVar, String str) {
        if (lmVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) nw.ny(lmVar)) * 1000) {
            String strAh = lmVar.zh() != null ? lmVar.zh().ah() : "";
            xr(msVar, lmVar, strAh, TextUtils.isEmpty(strAh) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
        } else {
            ah(lmVar, str);
        }
    }

    public static void ms(Runnable runnable, lm lmVar) {
        if (lmVar == null || runnable == null) {
            return;
        }
        if (nw.h(lmVar)) {
            com.bytedance.sdk.openadsdk.op.ab.ms((Runnable) new com.bytedance.sdk.component.ch.ny("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.hi.ch.4
                @Override // java.lang.Runnable
                public void run() {
                    op.ms(re.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            com.bytedance.sdk.openadsdk.core.nw.c().postDelayed(runnable, 500L);
        } else {
            com.bytedance.sdk.openadsdk.op.ab.ms(runnable);
        }
    }

    public static String d() {
        try {
            Bridge bridgeUl = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
            return bridgeUl != null ? (String) bridgeUl.call(1, com.bykv.ms.ms.ms.ms.xr.f12ms, String.class) : bq.e;
        } catch (Exception unused) {
            return bq.e;
        }
    }
}
