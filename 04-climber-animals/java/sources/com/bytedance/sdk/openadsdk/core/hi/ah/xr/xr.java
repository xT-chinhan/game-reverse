package com.bytedance.sdk.openadsdk.core.hi.ah.xr;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.nw.ka;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(String str, String str2, lm lmVar, JSONObject jSONObject, int i) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        if (lmVar == null) {
            ms(true, bridgeUl, str2, lmVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ms(true, bridgeUl, str2, lmVar, jSONObject, str, "", null, i);
            return;
        }
        String strYw = lmVar.yw();
        if (TextUtils.isEmpty(strYw) && lmVar.ph() != null) {
            strYw = lmVar.ph().zb();
        }
        ms(false, bridgeUl, str2, lmVar, jSONObject, str, "", strYw, i);
    }

    public static void ms(String str, lm lmVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strD;
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        if (lmVar == null) {
            ms(true, bridgeUl, str, lmVar, jSONObject, null, null, null, i);
            return;
        }
        ka kaVarZh = lmVar.zh();
        if (kaVarZh != null) {
            String strXr = kaVarZh.xr();
            String strAh = kaVarZh.ah();
            strD = kaVarZh.d();
            str2 = strXr;
            str3 = strAh;
        } else {
            str2 = "";
            str3 = str2;
            strD = str3;
        }
        ms(false, bridgeUl, str, lmVar, jSONObject, str2, str3, strD, i);
    }

    private static void ms(boolean z, Bridge bridge, String str, lm lmVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        String strIr;
        String strEh;
        if (bridge == null) {
            return;
        }
        if (z) {
            bridge.call(23, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_MATE_IS_EMPTY, Boolean.valueOf(z))).xr(), Void.class);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            try {
                jSONObject2.put("open_ad_sdk_download_extra", ms.ms().ms(str).xr(jSONObject).ms(lmVar).xr());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        long jLongValue = Double.valueOf(lmVar.df()).longValue();
        String strMs = lmVar.qd() == null ? null : lmVar.qd().ms();
        boolean zLe = ch.ub().le();
        boolean z2 = !ch.ub().le();
        String strLx = lmVar.lx();
        JSONObject jSONObjectXr = com.bytedance.sdk.openadsdk.core.hi.ch.xr();
        JSONObject jSONObject3 = new JSONObject();
        try {
            int iOptInt = jSONObjectXr.optInt("notification_opt_2", 0);
            if (iOptInt != 1) {
                iOptInt = 0;
            }
            int iY = nw.y(lmVar);
            if (!g.c()) {
                jSONObject3.put("cancel_pause_optimise_switch", iY);
                jSONObject3.put("cancel_pause_optimise_wifi_retain_switch", iY);
                jSONObject3.put("cancel_pause_optimise_apk_retain_switch", iY);
                jSONObject3.put("cancel_pause_optimise_download_percent_retain_switch", iY);
            }
            jSONObject3.put("show_pause_continue_toast", iY);
            if (iY == 1) {
                try {
                    ms(true, i);
                    jSONObject3.put("download_start_toast_text", jSONObjectXr.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
                } catch (JSONException unused3) {
                }
            }
            jSONObject3.put("notification_opt_2", iOptInt);
            jSONObject3.put("is_use_obm_convert", nw.xr(lmVar));
        } catch (JSONException unused4) {
        }
        String strIr2 = "";
        if (lmVar.tc() != null) {
            String strXr = lmVar.tc().xr();
            strEh = lmVar.eh();
            if (lmVar.tc().ka() != 2 || lm.xr(lmVar)) {
                if (lmVar.tc().ka() == 1) {
                    strIr2 = lmVar.tc().d();
                } else {
                    strIr2 = lmVar.ir();
                }
            }
            String str5 = strIr2;
            strIr2 = strXr;
            strIr = str5;
        } else {
            strIr = lmVar.ir();
            strEh = "";
        }
        bridge.call(23, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_MATE_IS_EMPTY, Boolean.FALSE).ms("id", Long.valueOf(jLongValue)).ms(TTDownloadField.TT_APP_ICON, strMs).ms(TTDownloadField.TT_IS_SHOW_NOTIFICATION, Boolean.valueOf(zLe)).ms(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION, Boolean.valueOf(z2)).ms(TTDownloadField.TT_LOG_EXTRA, strLx).ms(TTDownloadField.TT_EXTRA_JSON, jSONObject2).ms(TTDownloadField.TT_DOWNLOAD_SETTINGS, jSONObject3).ms(TTDownloadField.TT_FILE_PATH, ch.ub().xr()).ms("appName", str3).ms(TTDownloadField.TT_DOWNLOAD_URL, str2).ms("packageName", str4).ms(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS, Boolean.valueOf(com.bytedance.sdk.openadsdk.core.multipro.xr.ah())).ms(TTDownloadField.TT_OPEN_URL, strIr2).ms(TTDownloadField.TT_WEB_TITLE, strEh).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_WEB_URL, strIr)).xr(), Void.class);
    }

    public static void ms(lm lmVar, int i, boolean z) {
        boolean zXr;
        boolean zMs;
        boolean z2;
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        int iD = nw.d(lmVar);
        int iKa = nw.ka(lmVar);
        if (lmVar != null && (!TextUtils.isEmpty(lmVar.zm()) || z)) {
            iKa = 2;
        }
        if (lmVar == null || lmVar.yy() == null) {
            zXr = false;
            zMs = false;
            z2 = false;
        } else {
            zMs = lmVar.yy().ms();
            zXr = lmVar.yy().xr();
            z2 = true;
        }
        bridgeUl.call(25, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_AUTO_OPEN, Integer.valueOf(iD)).ms(TTDownloadField.TT_DOWNLOAD_MODE, Integer.valueOf(iKa)).ms(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG, Boolean.valueOf(z2)).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_IS_ENABLE_AH, Boolean.valueOf(zMs)).ms(TTDownloadField.TT_IS_ENABLE_AM, Boolean.valueOf(zXr))).xr(), Void.class);
    }

    public static void ms(int i, int i2) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        bridgeUl.call(26, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i2)).ms(TTDownloadField.TT_DOWNLOAD_MODE, Integer.valueOf(i))).xr(), Void.class);
    }

    public static void ms(boolean z, int i) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        bridgeUl.call(31, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_IS_SHOW_TOAST, Boolean.valueOf(z))).xr(), Void.class);
    }

    public static int ms(Bridge bridge, int i) {
        if (bridge == null) {
            return 0;
        }
        return ((Integer) bridge.call(27, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i))).xr(), Integer.class)).intValue();
    }

    public static void ms(boolean z, com.bytedance.sdk.openadsdk.core.le.ms.ms.ah ahVar, int i) {
        try {
            Bridge bridgeUl = ch.ub().ul();
            if (bridgeUl == null) {
                return;
            }
            bridgeUl.call(28, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD, Boolean.valueOf(z)).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_DOWNLOAD_MARKET_INTERCEPTOR, ahVar)).xr(), Void.class);
        } catch (Throwable th) {
            sl.ah("xgc_dof", "throwable", th);
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.le.ms.ms.ah ahVar, int i) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        bridgeUl.call(154, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_DOWNLOAD_MARKET_INTERCEPTOR, ahVar)).xr(), Void.class);
    }

    public static com.bytedance.sdk.openadsdk.core.le.ms.ms.ah ms(lm lmVar, final boolean z) {
        if (lmVar == null) {
            return null;
        }
        String strDa = lmVar.da();
        if (!TextUtils.isEmpty(strDa) && g.xr >= 6400) {
            final String strEu = lmVar.eu();
            final String strCz = lmVar.cz();
            final com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(strDa, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
            if (msVar != null && !TextUtils.isEmpty(lmVar.zm()) && lmVar.mh().d() == 1) {
                return new com.bytedance.sdk.openadsdk.core.le.ms.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.1
                    @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.ah
                    protected Map<String, Object> ms(Map<String, Object> map) {
                        if (map != null) {
                            if (!z) {
                                map.put("is_button", Boolean.FALSE);
                            }
                            Object obj = map.get("is_button");
                            msVar.ms(100, map);
                            xr.ms(map, obj, strEu, strCz);
                        } else {
                            u uVarMs = u.ms();
                            Boolean bool = Boolean.FALSE;
                            uVarMs.ms(bool, bool, "param is null", strEu, strCz);
                        }
                        return map;
                    }
                };
            }
            sl.ms("dof", "bridge something invalid");
        }
        return null;
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("market") || str.startsWith("mimarket")) {
            return w.ao();
        }
        return false;
    }

    public static boolean ms(Uri uri, lm lmVar, Context context, String str, int i) {
        if (ch.ub().ul() == null || lmVar == null) {
            return false;
        }
        ms(str, lmVar, (JSONObject) null, i);
        ms(lmVar, i, false);
        ms(str, i);
        of<String, Object> ofVarMs = new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms("uri", uri);
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(context, lmVar);
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka());
        if (ms(lmVar, str, ofVarMs, ahVar)) {
            return true;
        }
        xr(ofVarMs, lmVar);
        return true;
    }

    private static boolean ms(final lm lmVar, String str, final Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar) {
        if (!ahVar.d(false)) {
            return false;
        }
        ahVar.ms(str, new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                xr.xr((Map<String, Object>) map, lmVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final Map<String, Object> map, lm lmVar) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.3
            @Override // java.lang.Runnable
            public void run() {
                if (ch.ub().ul() != null) {
                    ch.ub().ul().call(12, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Boolean.class);
                }
            }
        }, lmVar);
    }

    public static void ms(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            u.ms().ms(obj, obj2, "success", str, str2);
            return;
        }
        u uVarMs = u.ms();
        Boolean bool = Boolean.FALSE;
        uVarMs.ms(bool, bool, "no intercept result", str, str2);
    }

    public static void ms(String str, int i) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        bridgeUl.call(29, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_CLICK_BUTTON_TAG, str).ms(TTDownloadField.TT_CLICK_ITEM_TAG, str).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_LABEL_CLICK_START, "click_start").ms(TTDownloadField.TT_LABEL_CLICK_CONTINUE, "click_continue").ms(TTDownloadField.TT_LABEL_CLICK_PAUSE, "click_pause").ms(TTDownloadField.TT_LABEL_STORAGE_DENY, "download_failed").ms(TTDownloadField.TT_LABEL_CLICK_INSTALL, "click_install").ms(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT, Boolean.TRUE).ms(TTDownloadField.TT_IS_ENABLE_V3_EVENT, Boolean.FALSE)).xr(), Void.class);
    }

    public static void ms(String str, String str2, JSONObject jSONObject, int i) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null || jSONObject == null) {
            return;
        }
        bridgeUl.call(29, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_CLICK_BUTTON_TAG, str).ms(TTDownloadField.TT_CLICK_ITEM_TAG, str2).ms(TTDownloadField.TT_LABEL_CLICK_START, "click_start").ms(TTDownloadField.TT_LABEL_CLICK_CONTINUE, "click_continue").ms(TTDownloadField.TT_LABEL_CLICK_PAUSE, "click_pause").ms(TTDownloadField.TT_LABEL_STORAGE_DENY, "download_failed").ms(TTDownloadField.TT_LABEL_CLICK_INSTALL, "click_install").ms(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT, Boolean.TRUE).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i)).ms(TTDownloadField.TT_IS_ENABLE_V3_EVENT, Boolean.FALSE).ms(TTDownloadField.TT_EXTRA_EVENT_OBJECT, jSONObject)).xr(), Void.class);
    }

    public static void xr(int i, int i2) {
        Bridge bridgeUl = ch.ub().ul();
        if (bridgeUl == null) {
            return;
        }
        bridgeUl.call(30, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(i2)).ms(TTDownloadField.TT_DOWNLOAD_SCENE, Integer.valueOf(i))).xr(), Void.class);
    }

    public static void ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms msVar) {
        if (g.xr < 4400 || map == null || msVar == null || map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER) != null) {
            return;
        }
        map.put(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER, msVar);
    }
}
