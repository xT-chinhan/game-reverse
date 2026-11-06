package com.byazt.mt;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.jp.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 26})
public class qg {
    public static boolean n(String str) {
        String strS = s();
        return (TextUtils.isEmpty(strS) || TextUtils.isEmpty(str) || strS.compareTo(str) < 0) ? false : true;
    }

    public static String n(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONArray = new JSONArray(str);
                } catch (JSONException unused) {
                    jSONArray = new JSONArray();
                }
            } else {
                jSONArray = new JSONArray();
            }
            boolean z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString(TapEventParamConstants.PARAM_NAME))) {
                    jSONObjectOptJSONObject.put(e.a.d, str3);
                    z = true;
                    break;
                }
            }
            if (!z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TapEventParamConstants.PARAM_NAME, str2);
                jSONObject.put(e.a.d, str3);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception unused2) {
            return str;
        }
    }

    public static double n(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static long n(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long qg(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(MediationConstant.EXTRA_ADID) != null) {
                return ((Long) map.get(MediationConstant.EXTRA_ADID)).longValue();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String s(Map<String, Object> map) {
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static void qg(String str) {
        tj.qg(str);
    }

    public static String n() {
        return tj.w();
    }

    private static Map<String, String> qg() {
        return tj.x();
    }

    private static JSONArray qg(com.byazt.pch.n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.ou())) {
            return null;
        }
        try {
            return new JSONArray(nVar.ou());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray n(com.byazt.pch.n nVar) {
        JSONArray jSONArrayS = s(n());
        try {
            Map<String, String> mapQg = qg();
            if (mapQg != null && mapQg.size() > 0) {
                for (String str : mapQg.keySet()) {
                    String str2 = mapQg.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt(TapEventParamConstants.PARAM_NAME, str);
                        jSONObject.putOpt(e.a.d, str2);
                        jSONArrayS.put(jSONObject);
                    }
                }
            }
            JSONArray jSONArrayQg = qg(nVar);
            if (jSONArrayQg != null) {
                for (int i = 0; i < jSONArrayQg.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayQg.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && !TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                        jSONArrayS.put(jSONObjectOptJSONObject);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONArrayS;
    }

    private static void n(com.byazt.zq.qg.n nVar, String str, String str2, boolean z, com.byazt.pch.n nVar2, Double d) {
        JSONObject jSONObject;
        JSONArray jSONArrayN = n(nVar2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(TapEventParamConstants.PARAM_NAME, "mediation_sdk_version");
            jSONObject2.putOpt(e.a.d, com.byazt.sg.qg.n());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(TapEventParamConstants.PARAM_NAME, "mediation_req_type");
            jSONObject3.putOpt(e.a.d, "1");
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                jSONObject.putOpt(TapEventParamConstants.PARAM_NAME, "waterfall_abtest");
                jSONObject.putOpt(e.a.d, str);
            }
            jSONArrayN.put(jSONObject3);
            jSONArrayN.put(jSONObject2);
            if (jSONObject != null) {
                jSONArrayN.put(jSONObject);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt(TapEventParamConstants.PARAM_NAME, "m_req_id");
                jSONObject4.putOpt(e.a.d, str2);
                jSONArrayN.put(jSONObject4);
            }
            if (d != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("m_e", d);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.putOpt(TapEventParamConstants.PARAM_NAME, "m_temp_info");
                jSONObject6.putOpt(e.a.d, jSONObject5);
                jSONArrayN.put(jSONObject6);
            }
        } catch (Throwable unused) {
        }
        if (!z) {
            n(nVar);
        }
        com.byazt.zo.qg.n(tj.l());
        if (nVar != null) {
            nVar.rv(jSONArrayN.toString());
        }
    }

    public static JSONArray s(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception unused) {
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static void n(com.byazt.zq.qg.n nVar) {
        if (nVar != null && tj.fs()) {
            try {
                String strS = tj.s("tt_pangle_preview_ad_id");
                String strS2 = tj.s("tt_pangle_preview_creative_id");
                String strS3 = tj.s("tt_pangle_preview_ext");
                com.byazt.rb.qg.n(MediationConstant.TAG, "pangle preview adId:" + strS + " creativeId:" + strS2 + " ext" + strS3);
                if (!TextUtils.isEmpty(strS) && !TextUtils.isEmpty(strS2)) {
                    nVar.n(strS).qg(strS2);
                }
                if (TextUtils.isEmpty(strS3)) {
                    return;
                }
                nVar.s(strS3);
            } catch (Throwable unused) {
            }
        }
    }

    public static com.byazt.zq.qg.n n(com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2, boolean z) {
        return n(qgVar, qgVar2.d(), qgVar2.cy(), qgVar2.hd(), qgVar2.hu(), n(qgVar2, z), z);
    }

    public static com.byazt.zq.qg.n n(com.byazt.qn.qg qgVar, String str, String str2, String str3, String str4, boolean z) {
        return n(qgVar, str, str2, str3, str4, null, z);
    }

    public static com.byazt.zq.qg.n n(com.byazt.qn.qg qgVar, String str, String str2, String str3, String str4, Double d, boolean z) {
        com.byazt.pch.n nVarCd = null;
        com.byazt.zq.qg.n nVarS = new com.byazt.zq.qg.n(qgVar == null ? null : qgVar.d()).q(str).s(1);
        if (qgVar != null) {
            nVarS.w(qgVar.qg()).x(qgVar.a()).qg(qgVar.hu());
            nVarCd = qgVar.cd();
            if (nVarCd != null) {
                nVarS.w(nVarCd.sz()).n(nVarCd.l()).q(nVarCd.h()).n(nVarCd.n()).qg(nVarCd.qg()).q(nVarCd.k()).n(nVarCd.wm()).l(nVarCd.oa()).s(nVarCd.s());
                String strUm = nVarCd.um();
                if (!TextUtils.isEmpty(strUm)) {
                    nVarS.x(strUm);
                }
                if (nVarCd.cd() != 0) {
                    nVarS.w(nVarCd.cd());
                }
            }
            int[] iArrN = n(qgVar, nVarCd);
            if (iArrN != null && iArrN.length > 0) {
                nVarS.n(iArrN);
            }
            if (5 == qgVar.um() || 9 == qgVar.um()) {
                nVarS.s(qgVar.m());
            }
        }
        com.byazt.pch.n nVar = nVarCd;
        if (!TextUtils.isEmpty(str4)) {
            nVarS.fs(str4);
        }
        n(nVarS, str2, str3, z, nVar, d);
        return nVarS;
    }

    private static Double n(com.byazt.dd.qg qgVar, boolean z) {
        if (qgVar == null || qgVar.fs() == null || z) {
            return null;
        }
        return Double.valueOf(qgVar.fs().m());
    }

    private static int[] n(com.byazt.qn.qg qgVar, com.byazt.pch.n nVar) {
        if (nVar != null && nVar.hd() != null && nVar.hd().length > 0) {
            return nVar.hd();
        }
        try {
            Map<String, Object> mapAn = qgVar.an();
            if (mapAn != null) {
                return (int[]) mapAn.get(MediationConstant.PANGLE_VID);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String s() {
        try {
            return com.byazt.zo.qg.s();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    public static boolean n(com.byazt.qn.qg qgVar) {
        if (qgVar != null && qgVar.an() != null) {
            Object obj = qgVar.an().get(MediationConstant.BANNER_AUTO_HEIGHT);
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
