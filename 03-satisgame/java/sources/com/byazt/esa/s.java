package com.byazt.esa;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.l;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.iz.rv;
import com.byazt.nf.tj;
import com.byazt.qp.q;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1065, 8})
public class s {
    public static void n(String str, String str2, pk pkVar, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        if (pkVar == null) {
            n(true, functionFi, str2, pkVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            n(true, functionFi, str2, pkVar, jSONObject, str, "", null, i);
            return;
        }
        String strEm = pkVar.em();
        if (TextUtils.isEmpty(strEm) && pkVar.cd() != null) {
            strEm = pkVar.cd().oa();
        }
        n(false, functionFi, str2, pkVar, jSONObject, str, "", strEm, i);
    }

    public static void n(String str, pk pkVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strQ;
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        if (pkVar == null) {
            n(true, functionFi, str, pkVar, jSONObject, null, null, null, i);
            return;
        }
        l lVarK = pkVar.k();
        if (lVarK != null) {
            String strQg = lVarK.qg();
            String strS = lVarK.s();
            strQ = lVarK.q();
            str2 = strQg;
            str3 = strS;
        } else {
            str2 = "";
            str3 = str2;
            strQ = str3;
        }
        n(false, functionFi, str, pkVar, jSONObject, str2, str3, strQ, i);
    }

    private static void n(boolean z, Function<SparseArray<Object>, Object> function, String str, pk pkVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        String str5;
        JSONObject jSONObject2;
        String strE_;
        String strQg;
        boolean zN;
        if (function == null) {
            return;
        }
        if (z) {
            function.apply(com.byazt.of.qg.n().n(23).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i)).n("mateIsEmpty", Boolean.valueOf(z))).qg());
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("open_ad_sdk_download_extra", qg.n().n(str).qg(jSONObject).n(pkVar).qg());
        } catch (Exception unused) {
        }
        long jLongValue = Double.valueOf(pkVar.q()).longValue();
        String strN = pkVar.xu() == null ? null : pkVar.xu().n();
        boolean zLn = com.byazt.vyf.s.cy().ln();
        boolean z2 = !com.byazt.vyf.s.cy().ln();
        String strF_ = pkVar.F_();
        JSONObject jSONObjectN = rv.n();
        JSONObject jSONObject4 = new JSONObject();
        try {
            int iOptInt = jSONObjectN.optInt("notification_opt_2", 0);
            if (iOptInt != 1) {
                iOptInt = 0;
            }
            int iOa = um.oa(pkVar);
            if (tj.fs()) {
                jSONObject2 = jSONObject3;
            } else {
                jSONObject2 = jSONObject3;
                try {
                    jSONObject4.put("cancel_pause_optimise_switch", iOa);
                    jSONObject4.put("cancel_pause_optimise_wifi_retain_switch", iOa);
                    jSONObject4.put("cancel_pause_optimise_apk_retain_switch", iOa);
                    jSONObject4.put("cancel_pause_optimise_download_percent_retain_switch", iOa);
                } catch (JSONException unused2) {
                    str5 = strF_;
                }
            }
            jSONObject4.put("show_pause_continue_toast", iOa);
            str5 = strF_;
            try {
                if (iOa == 1) {
                    n(true, i);
                    jSONObject4.put("download_start_toast_text", jSONObjectN.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
                } else if (com.byazt.nf.rv.qg().c()) {
                    n(true, i);
                    jSONObject4.put("enable_notification_ui", 1);
                    jSONObject4.put("download_start_toast_text", "下载中，可在通知栏暂停或取消");
                }
                jSONObject4.put("notification_opt_2", iOptInt);
                jSONObject4.put("is_use_obm_convert", um.n(pkVar));
            } catch (JSONException unused3) {
            }
        } catch (JSONException unused4) {
            str5 = strF_;
            jSONObject2 = jSONObject3;
        }
        String strFs = "";
        if (pkVar.sz() != null) {
            strQg = pkVar.sz().qg();
            strE_ = pkVar.E_();
            if (pkVar.sz().l() != 2 || pk.s(pkVar)) {
                if (pkVar.sz().l() == 1) {
                    strFs = pkVar.sz().q();
                } else {
                    strFs = pkVar.fs();
                }
            }
        } else {
            strE_ = "";
            strFs = pkVar.fs();
            strQg = strE_;
        }
        if (tj.l >= 7000 && tj.l < 7300) {
            boolean zN2 = ((com.byazt.vf.l) q.n("app_process")).n();
            zN = com.byazt.nf.rv.qg().h();
            if (!zN2) {
                zN = com.byazt.byp.qg.n();
            }
        } else {
            zN = com.byazt.byp.qg.n();
        }
        String strN2 = com.byazt.oh.l.n(pkVar, str2, false);
        if (!TextUtils.isEmpty(strN2)) {
            com.byazt.oh.l.n(um.cp(pkVar), jSONObject4);
        }
        function.apply(com.byazt.of.qg.n().n(23).n(Void.class).n(0, new com.byazt.ikv.s().n("mateIsEmpty", Boolean.FALSE).n("id", Long.valueOf(jLongValue)).n("appIcon", strN).n("isShowNotification", Boolean.valueOf(zLn)).n("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).n("logExtra", str5).n("extraJson", jSONObject2).n("downloadSettings", jSONObject4).n("filePath", strN2).n("appName", str3).n("downloadUrl", str2).n(BillingClientConstants.PACKAGE_NAME, str4).n("isNeedIndependentProcess", Boolean.valueOf(zN)).n("openUrl", strQg).n("webTitle", strE_).n("hashCode", Integer.valueOf(i)).n("webUrl", strFs)).qg());
    }

    public static void n(pk pkVar, int i, boolean z) {
        boolean zQg;
        boolean zN;
        boolean z2;
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        int iS = um.s(pkVar);
        int iQ = um.q(pkVar);
        if (pkVar != null && (!TextUtils.isEmpty(pkVar.m()) || z)) {
            iQ = 2;
        }
        if (pkVar == null || pkVar.xs() == null) {
            zQg = false;
            zN = false;
            z2 = false;
        } else {
            zN = pkVar.xs().n();
            zQg = pkVar.xs().qg();
            z2 = true;
        }
        functionFi.apply(com.byazt.of.qg.n().n(25).n(Void.class).n(0, new com.byazt.ikv.s().n("autoOpen", Integer.valueOf(iS)).n("downloadMode", Integer.valueOf(iQ)).n("isHaveDownloadSdkConfig", Boolean.valueOf(z2)).n("hashCode", Integer.valueOf(i)).n("isEnableAH", Boolean.valueOf(zN)).n("isEnableAM", Boolean.valueOf(zQg))).qg());
    }

    public static void n(int i, int i2) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(26).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i2)).n("downloadMode", Integer.valueOf(i))).qg());
    }

    public static void n(boolean z, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(31).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i)).n("isShowToast", Boolean.valueOf(z))).qg());
    }

    public static int n(Function<SparseArray<Object>, Object> function, int i) {
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(com.byazt.of.qg.n().n(27).n(Integer.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i))).qg());
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static void n(boolean z, com.byazt.myr.s sVar, int i) {
        try {
            Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
            if (functionFi == null) {
                return;
            }
            functionFi.apply(com.byazt.of.qg.n().n(28).n(Void.class).n(0, new com.byazt.ikv.s().n("isEnableOppoAutoDownload", Boolean.valueOf(z)).n("hashCode", Integer.valueOf(i)).n("downloadMarketInterceptor", sVar)).qg());
        } catch (Throwable th) {
            k.n("xgc_dof", "throwable", th);
        }
    }

    public static void n(com.byazt.myr.s sVar, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i)).n("downloadMarketInterceptor", sVar)).qg());
    }

    public static void n(n nVar, String str, int i, Bitmap bitmap) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null || nVar == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(160).n(Void.class).n(0, new com.byazt.ikv.s().n("install_app_name", nVar.n()).n("install_icon_bitmap", bitmap).n("install_action_type", str).n("install_click_type", Integer.valueOf(i)).n("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && com.byazt.nf.rv.qg().vx() > 0)).n("install_package_name", nVar.s()).n("install_tag", nVar.x()).n("install_value", nVar.fs()).n("install_log_extra", nVar.l()).n("install_download_id", Integer.valueOf(nVar.q()))).qg());
    }

    public static com.byazt.myr.s n(com.byazt.llp.rv rvVar, final boolean z) {
        if (rvVar == null) {
            return null;
        }
        String strPy = rvVar.py();
        if (TextUtils.isEmpty(strPy)) {
            return null;
        }
        final String strOu = rvVar.ou();
        final String strWm = rvVar.wm();
        final com.byazt.mi.qg qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(strPy, com.byazt.mi.qg.class);
        if (qgVar == null || TextUtils.isEmpty(rvVar.m()) || rvVar.D_().w() != 1) {
            return null;
        }
        return new com.byazt.myr.s() { // from class: com.byazt.esa.s.1
            @Override // com.byazt.ky.DownloadMarketInterceptor
            public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                if (map != null) {
                    if (!z) {
                        map.put("is_button", Boolean.FALSE);
                    }
                    Object obj = map.get("is_button");
                    qgVar.n(100, map);
                    s.n(map, obj, strOu, strWm);
                } else {
                    com.byazt.eji.s sVarN = com.byazt.eji.s.n();
                    Boolean bool = Boolean.FALSE;
                    sVarN.n(bool, bool, "param is null", strOu, strWm);
                }
                return map;
            }
        };
    }

    public static boolean n(Uri uri, pk pkVar, Context context, String str, int i) {
        if (com.byazt.vyf.s.cy().fi() == null || pkVar == null) {
            return false;
        }
        n(str, pkVar, (JSONObject) null, i);
        n(pkVar, i, false);
        n(str, i);
        com.byazt.ikv.s<String, Object> sVarN = new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i)).n("activity", context).n("open_market_in_app", Boolean.valueOf(um.cy(pkVar))).n(ContentProviderManager.PROVIDER_URI, uri);
        com.byazt.wif.s sVar = new com.byazt.wif.s(context, pkVar);
        sVar.n(new com.byazt.wif.l());
        if (n(pkVar, str, sVarN, sVar)) {
            return true;
        }
        qg(sVarN, pkVar);
        return true;
    }

    private static boolean n(final pk pkVar, String str, final Map<String, Object> map, com.byazt.wif.s sVar) {
        if (!sVar.q(false)) {
            return false;
        }
        sVar.n(str, new com.byazt.pma.qg() { // from class: com.byazt.esa.s.2
            @Override // com.byazt.pma.qg
            public void n() {
                s.qg((Map<String, Object>) map, pkVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final Map<String, Object> map, pk pkVar) {
        rv.n(new Runnable() { // from class: com.byazt.esa.s.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.vyf.s.cy().fi() != null) {
                    com.byazt.vyf.s.cy().fi().apply(com.byazt.of.qg.n().n(12).n(Boolean.class).n(0, map).qg());
                }
            }
        }, pkVar);
    }

    public static void n(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            com.byazt.eji.s.n().n(obj, obj2, "success", str, str2);
            return;
        }
        com.byazt.eji.s sVarN = com.byazt.eji.s.n();
        Boolean bool = Boolean.FALSE;
        sVarN.n(bool, bool, "no intercept result", str, str2);
    }

    public static void n(String str, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(29).n(Void.class).n(0, new com.byazt.ikv.s().n("clickButtonTag", str).n("clickItemTag", str).n("hashCode", Integer.valueOf(i)).n("clickStartLabel", "click_start").n("clickContinueLabel", "click_continue").n("clickPauseLabel", "click_pause").n("storageDenyLabel", "download_failed").n("clickInstallLabel", "click_install").n("isEnableClickEvent", Boolean.TRUE).n("isEnableV3Event", Boolean.FALSE)).qg());
    }

    public static void n(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null || jSONObject == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(29).n(Void.class).n(0, new com.byazt.ikv.s().n("clickButtonTag", str).n("clickItemTag", str2).n("clickStartLabel", "click_start").n("clickContinueLabel", "click_continue").n("clickPauseLabel", "click_pause").n("storageDenyLabel", "download_failed").n("clickInstallLabel", "click_install").n("isEnableClickEvent", Boolean.TRUE).n("hashCode", Integer.valueOf(i)).n("isEnableV3Event", Boolean.FALSE).n("extraEventObject", jSONObject)).qg());
    }

    public static void qg(int i, int i2) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return;
        }
        functionFi.apply(com.byazt.of.qg.n().n(30).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(i2)).n("downloadScene", Integer.valueOf(i))).qg());
    }

    public static void n(Map<String, Object> map, com.byazt.myr.n nVar) {
        if (map == null || nVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", nVar);
    }

    public static boolean n(String str, String str2, pk pkVar, int i) {
        Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
        if (functionFi == null) {
            return false;
        }
        Object objApply = functionFi.apply(com.byazt.of.qg.n().n(2).n(Boolean.class).n(0, new com.byazt.ikv.s().n("tagIntercept", str).n("label", str2).n("hashCode", Integer.valueOf(i)).n("meta", pkVar.pv().toString())).qg());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.equals("mimarket", scheme) || TextUtils.equals("market", scheme)) {
            return com.byazt.bk.l.s();
        }
        return false;
    }
}
