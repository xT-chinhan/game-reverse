package com.byazt.vo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.ho;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.c;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.jx.aj;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wt.ww;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 20})
public class hn {
    public static void pr(String str, String str2, of ofVar, JSONObject jSONObject, int i) {
        String strM;
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        if (ofVar == null) {
            pr(true, functionLs, str2, ofVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            pr(true, functionLs, str2, ofVar, jSONObject, str, "", null, i);
            return;
        }
        String strIc = ofVar.ic();
        if (TextUtils.isEmpty(strIc) && ofVar.lb() != null) {
            strM = ofVar.lb().m();
        } else {
            strM = strIc;
        }
        pr(false, functionLs, str2, ofVar, jSONObject, str, "", strM, i);
    }

    public static void pr(String str, of ofVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strX;
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        if (ofVar == null) {
            pr(true, functionLs, str, ofVar, jSONObject, null, null, null, i);
            return;
        }
        c cVarHo = ofVar.ho();
        if (cVarHo == null) {
            str2 = "";
            str3 = str2;
            strX = str3;
        } else {
            String strHw = cVarHo.hw();
            String strHn = cVarHo.hn();
            strX = cVarHo.x();
            str2 = strHw;
            str3 = strHn;
        }
        pr(false, functionLs, str, ofVar, jSONObject, str2, str3, strX, i);
    }

    private static void pr(boolean z, Function<SparseArray<Object>, Object> function, String str, of ofVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        String str5;
        JSONObject jSONObject2;
        String strA_;
        String strHw;
        boolean zPr;
        if (function == null) {
            return;
        }
        if (z) {
            function.apply(com.byazt.xi.hw.pr().pr(23).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i)).pr("mateIsEmpty", Boolean.valueOf(z))).hw());
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("open_ad_sdk_download_extra", hw.pr().pr(str).hw(jSONObject).pr(ofVar).hw());
        } catch (Exception e) {
        }
        long jLongValue = Double.valueOf(ofVar.x()).longValue();
        String strPr = ofVar.mo() == null ? null : ofVar.mo().pr();
        boolean zNl = zo.nt().nl();
        boolean z2 = !zo.nt().nl();
        String strB_ = ofVar.B_();
        JSONObject jSONObjectPr = aj.pr();
        JSONObject jSONObject4 = new JSONObject();
        try {
            int iOptInt = jSONObjectPr.optInt("notification_opt_2", 0);
            if (iOptInt != 1) {
                iOptInt = 0;
            }
            int iM = qa.m(ofVar);
            if (iu.fw()) {
                str5 = "hashCode";
            } else {
                str5 = "hashCode";
                try {
                    jSONObject4.put("cancel_pause_optimise_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_wifi_retain_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_apk_retain_switch", iM);
                    jSONObject4.put("cancel_pause_optimise_download_percent_retain_switch", iM);
                } catch (JSONException e2) {
                    jSONObject2 = jSONObject3;
                }
            }
            jSONObject4.put("show_pause_continue_toast", iM);
            jSONObject2 = jSONObject3;
            try {
                if (iM == 1) {
                    pr(true, i);
                    jSONObject4.put("download_start_toast_text", jSONObjectPr.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
                } else if (a.hw().om()) {
                    pr(true, i);
                    jSONObject4.put("enable_notification_ui", 1);
                    jSONObject4.put("download_start_toast_text", "下载中，可在通知栏暂停或取消");
                }
                jSONObject4.put("notification_opt_2", iOptInt);
                jSONObject4.put("is_use_obm_convert", qa.pr(ofVar));
            } catch (JSONException e3) {
            }
        } catch (JSONException e4) {
            str5 = "hashCode";
        }
        String strZo = "";
        if (ofVar.g() != null) {
            strHw = ofVar.g().hw();
            strA_ = ofVar.A_();
            if (ofVar.g().c() != 2 || of.hn(ofVar)) {
                if (ofVar.g().c() == 1) {
                    strZo = ofVar.g().x();
                } else {
                    strZo = ofVar.zo();
                }
            }
        } else {
            strA_ = "";
            strZo = ofVar.zo();
            strHw = strA_;
        }
        if (iu.x >= 7000 && iu.x < 7300) {
            boolean zPr2 = ((com.byazt.vkw.c) uc.pr("app_process")).pr();
            zPr = a.hw().b();
            if (!zPr2) {
                zPr = com.byazt.iy.hw.pr();
            }
        } else {
            zPr = com.byazt.iy.hw.pr();
        }
        String strPr2 = com.byazt.ri.c.pr(ofVar, str2, false);
        if (!TextUtils.isEmpty(strPr2)) {
            com.byazt.ri.c.pr(qa.w(ofVar), jSONObject4);
        }
        function.apply(com.byazt.xi.hw.pr().pr(23).pr(Void.class).pr(0, new ww().pr("mateIsEmpty", Boolean.FALSE).pr("id", Long.valueOf(jLongValue)).pr("appIcon", strPr).pr("isShowNotification", Boolean.valueOf(zNl)).pr("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).pr("logExtra", strB_).pr("extraJson", jSONObject2).pr("downloadSettings", jSONObject4).pr("filePath", strPr2).pr("appName", str3).pr("downloadUrl", str2).pr(BillingClientConstants.PACKAGE_NAME, str4).pr("isNeedIndependentProcess", Boolean.valueOf(zPr)).pr("openUrl", strHw).pr("webTitle", strA_).pr(str5, Integer.valueOf(i)).pr("webUrl", strZo)).hw());
    }

    public static void pr(of ofVar, int i, boolean z) {
        boolean zHw;
        boolean z2;
        boolean zPr;
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        int iHn = qa.hn(ofVar);
        int iX = qa.x(ofVar);
        if (ofVar != null && (!TextUtils.isEmpty(ofVar.rc()) || z)) {
            iX = 2;
        }
        if (ofVar != null && ofVar.zx() != null) {
            z2 = true;
            zPr = ofVar.zx().pr();
            zHw = ofVar.zx().hw();
        } else {
            zHw = false;
            z2 = false;
            zPr = false;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(25).pr(Void.class).pr(0, new ww().pr("autoOpen", Integer.valueOf(iHn)).pr("downloadMode", Integer.valueOf(iX)).pr("isHaveDownloadSdkConfig", Boolean.valueOf(z2)).pr("hashCode", Integer.valueOf(i)).pr("isEnableAH", Boolean.valueOf(zPr)).pr("isEnableAM", Boolean.valueOf(zHw))).hw());
    }

    public static void pr(int i, int i2) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(26).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i2)).pr("downloadMode", Integer.valueOf(i))).hw());
    }

    public static void pr(boolean z, int i) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(31).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i)).pr("isShowToast", Boolean.valueOf(z))).hw());
    }

    public static int pr(Function<SparseArray<Object>, Object> function, int i) {
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(com.byazt.xi.hw.pr().pr(27).pr(Integer.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i))).hw());
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static void pr(boolean z, com.byazt.qp.hn hnVar, int i) {
        try {
            Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
            if (functionLs == null) {
                return;
            }
            functionLs.apply(com.byazt.xi.hw.pr().pr(28).pr(Void.class).pr(0, new ww().pr("isEnableOppoAutoDownload", Boolean.valueOf(z)).pr("hashCode", Integer.valueOf(i)).pr("downloadMarketInterceptor", hnVar)).hw());
        } catch (Throwable th) {
            ho.pr("xgc_dof", "throwable", th);
        }
    }

    public static void pr(com.byazt.qp.hn hnVar, int i) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i)).pr("downloadMarketInterceptor", hnVar)).hw());
    }

    public static void pr(pr prVar, String str, int i, Bitmap bitmap) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null || prVar == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(160).pr(Void.class).pr(0, new ww().pr("install_app_name", prVar.pr()).pr("install_icon_bitmap", bitmap).pr("install_action_type", str).pr("install_click_type", Integer.valueOf(i)).pr("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && a.hw().nb() > 0)).pr("install_package_name", prVar.hn()).pr("install_tag", prVar.fw()).pr("install_value", prVar.zo()).pr("install_log_extra", prVar.c()).pr("install_download_id", Integer.valueOf(prVar.x()))).hw());
    }

    public static com.byazt.qp.hn pr(com.byazt.af.aj ajVar, final boolean z) {
        if (ajVar == null) {
            return null;
        }
        String strCz = ajVar.cz();
        if (TextUtils.isEmpty(strCz)) {
            return null;
        }
        final String strNy = ajVar.ny();
        final String strFo = ajVar.fo();
        final com.byazt.rkl.hw hwVar = (com.byazt.rkl.hw) cz.pr(strCz, com.byazt.rkl.hw.class);
        if (hwVar == null || TextUtils.isEmpty(ajVar.rc()) || ajVar.z_().uc() != 1) {
            return null;
        }
        return new com.byazt.qp.hn() { // from class: com.byazt.vo.hn.1
            @Override // com.byazt.zv.DownloadMarketInterceptor
            public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                if (map != null) {
                    if (!z) {
                        map.put("is_button", Boolean.FALSE);
                    }
                    Object obj = map.get("is_button");
                    hwVar.pr(100, map);
                    hn.pr(map, obj, strNy, strFo);
                } else {
                    com.byazt.xk.hw hwVarPr = com.byazt.xk.hw.pr();
                    Boolean bool = Boolean.FALSE;
                    hwVarPr.pr(bool, bool, "param is null", strNy, strFo);
                }
                return map;
            }
        };
    }

    public static boolean pr(Uri uri, of ofVar, Context context, String str, int i) {
        if (zo.nt().ls() == null || ofVar == null) {
            return false;
        }
        pr(str, ofVar, (JSONObject) null, i);
        pr(ofVar, i, false);
        pr(str, i);
        ww<String, Object> wwVarPr = new ww().pr("hashCode", Integer.valueOf(i)).pr(TTDownloadField.TT_ACTIVITY, context).pr("open_market_in_app", Boolean.valueOf(qa.nt(ofVar))).pr(ContentProviderManager.PROVIDER_URI, uri);
        com.byazt.wr.hn hnVar = new com.byazt.wr.hn(context, ofVar);
        hnVar.pr(new com.byazt.wr.c());
        if (pr(ofVar, str, wwVarPr, hnVar)) {
            return true;
        }
        hw(wwVarPr, ofVar);
        return true;
    }

    private static boolean pr(final of ofVar, String str, final Map<String, Object> map, com.byazt.wr.hn hnVar) {
        if (!hnVar.x(false)) {
            return false;
        }
        hnVar.pr(str, new com.byazt.rx.hw() { // from class: com.byazt.vo.hn.2
            @Override // com.byazt.rx.hw
            public void pr() {
                hn.hw((Map<String, Object>) map, ofVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final Map<String, Object> map, of ofVar) {
        aj.pr(new Runnable() { // from class: com.byazt.vo.hn.3
            @Override // java.lang.Runnable
            public void run() {
                if (zo.nt().ls() != null) {
                    zo.nt().ls().apply(com.byazt.xi.hw.pr().pr(12).pr(Boolean.class).pr(0, map).hw());
                }
            }
        }, ofVar);
    }

    public static void pr(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            com.byazt.xk.hw.pr().pr(obj, obj2, TrackAction.SUCCESS, str, str2);
            return;
        }
        com.byazt.xk.hw hwVarPr = com.byazt.xk.hw.pr();
        Boolean bool = Boolean.FALSE;
        hwVarPr.pr(bool, bool, "no intercept result", str, str2);
    }

    public static void pr(String str, int i) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(29).pr(Void.class).pr(0, new ww().pr("clickButtonTag", str).pr("clickItemTag", str).pr("hashCode", Integer.valueOf(i)).pr("clickStartLabel", "click_start").pr("clickContinueLabel", "click_continue").pr("clickPauseLabel", "click_pause").pr("storageDenyLabel", "download_failed").pr("clickInstallLabel", "click_install").pr("isEnableClickEvent", Boolean.TRUE).pr("isEnableV3Event", Boolean.FALSE)).hw());
    }

    public static void pr(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs != null && jSONObject != null) {
            functionLs.apply(com.byazt.xi.hw.pr().pr(29).pr(Void.class).pr(0, new ww().pr("clickButtonTag", str).pr("clickItemTag", str2).pr("clickStartLabel", "click_start").pr("clickContinueLabel", "click_continue").pr("clickPauseLabel", "click_pause").pr("storageDenyLabel", "download_failed").pr("clickInstallLabel", "click_install").pr("isEnableClickEvent", Boolean.TRUE).pr("hashCode", Integer.valueOf(i)).pr("isEnableV3Event", Boolean.FALSE).pr("extraEventObject", jSONObject)).hw());
        }
    }

    public static void hw(int i, int i2) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return;
        }
        functionLs.apply(com.byazt.xi.hw.pr().pr(30).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(i2)).pr("downloadScene", Integer.valueOf(i))).hw());
    }

    public static void pr(Map<String, Object> map, com.byazt.qp.pr prVar) {
        if (map == null || prVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", prVar);
    }

    public static boolean pr(String str, String str2, of ofVar, int i) {
        Function<SparseArray<Object>, Object> functionLs = zo.nt().ls();
        if (functionLs == null) {
            return false;
        }
        Object objApply = functionLs.apply(com.byazt.xi.hw.pr().pr(2).pr(Boolean.class).pr(0, new ww().pr("tagIntercept", str).pr("label", str2).pr("hashCode", Integer.valueOf(i)).pr("meta", ofVar.to().toString())).hw());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.equals("mimarket", scheme) || TextUtils.equals(BaseConstants.SCHEME_MARKET, scheme)) {
            return com.byazt.now.c.hn();
        }
        return false;
    }
}
