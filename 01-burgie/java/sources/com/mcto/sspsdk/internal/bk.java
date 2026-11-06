package com.mcto.sspsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bk {
    public static final String[] a = {"et", "q", "req", an.ax, an.av, "g"};
    public static final String[] b = {an.av, "b", an.aF, "d", "r"};
    public static final String[] c = {an.av, an.aE, "b", an.aF, "r", "d", "q"};

    public static q4 a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(com.umeng.analytics.pro.d.ar)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("params")) == null) {
            return null;
        }
        q4 gcVar = "qilinTracking".equals(str) ? new gc() : "adxTracking".equals(str) ? new p0() : new q4();
        gcVar.c = gj.a(jSONObjectOptJSONObject2);
        gcVar.a = jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL, null);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            gcVar.b.add(jSONArrayOptJSONArray.optString(i));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("exts");
        if (jSONObjectOptJSONObject3 != null) {
            gcVar.d = new HashMap(jSONObjectOptJSONObject3.length());
            Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                HashMap mapA = gj.a(jSONObjectOptJSONObject3.optJSONObject(strValueOf));
                if (!mapA.isEmpty()) {
                    gcVar.d.put(strValueOf, mapA);
                }
            }
        }
        return gcVar;
    }

    public static String b(String str) {
        try {
            StringBuilder sb = new StringBuilder("");
            AtomicInteger atomicInteger = gj.a;
            String strA = a(str, "b", sb.append(System.currentTimeMillis() / 1000).toString());
            Pair pairA = a(strA, "cupidTracking");
            return a(a(strA, "ve", (String) pairA.first), an.aB, (String) pairA.second);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        String str2;
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strReplace = str.replace("__timeStamp__", strValueOf).replace("[timestamp]", strValueOf).replace("__TS__", strValueOf).replace("[randnum]", strValueOf).replace("[M_timestamp]", strValueOf);
            if (lj.b(h4.d)) {
                str2 = "https://t7z.cupid.iqiyi.com/dsp_track3";
                h4.d = "https://t7z.cupid.iqiyi.com/dsp_track3";
            } else {
                str2 = h4.d;
            }
            if (!strReplace.contains(Uri.parse(str2).getHost()) && !strReplace.contains(".cupid.")) {
                return strReplace;
            }
            Pair pairA = a(strReplace, "qilinTracking");
            return a(a(strReplace, "fessv", (String) pairA.first), "feckm", (String) pairA.second);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String a(int i, String str, p pVar, mh mhVar) {
        z3 z3Var;
        y4 y4Var = y4.r;
        String strI = y4Var.i();
        String strReplace = str.replace("[QIYI_ID]", strI).replace("[QIYI%5fID]", strI).replace("[IQIYI_FCID]", strI).replace("[IQIYI_HCID]", y4Var.e());
        if (mhVar != null) {
            strReplace = strReplace.replace("[M_ADIP]", mhVar.h).replace("[M%5fADIP]", mhVar.h).replace("__IP__", mhVar.h);
        }
        Object obj = pVar.K.get(v5.KEY_CLICK_AREA);
        if (obj == null || !(obj instanceof z3)) {
            z3Var = null;
        } else {
            z3Var = (z3) obj;
        }
        if (z3Var != null) {
            strReplace = strReplace.replace("CUPID_CLA", z3Var.a);
        }
        if (j.b(4, pVar.S0)) {
            strReplace = strReplace.replace("CUPID_CCN", "20001");
        }
        String strReplace2 = strReplace.replace("[IQIYI_OFFSET]", String.valueOf(pVar.o.get() / 1000)).replace("CUPID_TRS", pVar.a(v5.KEY_TRUEVIEW_TYPE));
        if (!j.b(2, i)) {
            return strReplace2;
        }
        String strReplace3 = strReplace2.replace("__WIDTH__", pVar.a(v5.KEY_CONTAINER_WIDTH)).replace("__HEIGHT__", pVar.a(v5.KEY_CONTAINER_HEIGHT));
        z3 z3Var2 = z3.SHAKE;
        if (z3Var == z3Var2 || z3Var == z3.SHAKE_TEMPLATE || z3Var == z3.TWIST || z3Var == z3.TWIST_TEMPLATE) {
            return strReplace3.replace("__DOWN_X__", "-999").replace("__DOWN_Y__", "-999").replace("__UP_X__", "-999").replace("__UP_Y__", "-999").replace("__SLD__", (z3Var == z3Var2 || z3Var == z3.SHAKE_TEMPLATE) ? "2" : GlobalSetting.REWARD_VIDEO_AD);
        }
        return strReplace3.replace("__SLD__", "0").replace("__DOWN_X__", pVar.a(v5.KEY_TOUCH_START_X)).replace("__DOWN_Y__", pVar.a(v5.KEY_TOUCH_START_Y)).replace("__UP_X__", pVar.a(v5.KEY_TOUCH_END_X)).replace("__UP_Y__", pVar.a(v5.KEY_TOUCH_END_Y));
    }

    public static String a(int i, p pVar, String str) {
        int i2;
        int i3;
        String strValueOf;
        String strValueOf2;
        HashMap map = new HashMap(32);
        String strReplace = str.replace("__IMP_AREA_X1Y1X2Y2__", pVar.a(v5.KEY_VIEW_COORDINATE)).replace("__BUTTON_AREA_X1Y1X2Y2__", pVar.a(v5.KEY_CLICK_VIEW_COORDINATE)).replace("__CLICK_POS_XY__", pVar.a(v5.KEY_CLICK_COORDINATE));
        Map map2 = pVar.C0;
        if (map2 != null) {
            float f = pVar.f();
            if (f > 0.0f) {
                strReplace = strReplace.replace("SETTLEMENT_WATERFALL", gj.f(gj.b("" + f)));
            }
            Object obj = map2.get("fromCache");
            AtomicInteger atomicInteger = gj.a;
            if (obj != null) {
                if (obj instanceof String) {
                    strValueOf = (String) obj;
                } else {
                    try {
                        strValueOf = String.valueOf(obj);
                    } catch (Exception e) {
                        strValueOf = "";
                    }
                }
            } else {
                strValueOf = "";
            }
            strReplace = strReplace.replace("CUPID_FC", strValueOf);
            Object obj2 = map2.get("adSource");
            if (obj2 != null) {
                if (obj2 instanceof String) {
                    strValueOf2 = (String) obj2;
                } else {
                    try {
                        strValueOf2 = String.valueOf(obj2);
                    } catch (Exception e2) {
                        strValueOf2 = "";
                    }
                }
            } else {
                strValueOf2 = "";
            }
            map.put("fe_sads", strValueOf2);
        }
        y4 y4Var = y4.r;
        map.put("otp", y4Var.m);
        map.put("hmv", y4Var.n);
        map.put("hmpm", Integer.valueOf(y4Var.c));
        map.put("devm", th.a().b ? "1" : "0");
        map.put("fe_exp", pVar.t0 == 1 ? "1" : "");
        if (j.b(1, i) || j.b(2, i)) {
            if (j.b(4, pVar.S0) || j.b(3, pVar.S0)) {
                String strOptString = pVar.i().optString("apkName");
                if (TextUtils.isEmpty(strOptString)) {
                    map.put("ais", "-1");
                } else {
                    map.put("ais", e1.c(strOptString) ? "1" : "0");
                }
                map.put("fe_atd", pVar.d0 ? "1" : "0");
            }
            if (j.b(3, pVar.S0) || j.b(2, pVar.S0)) {
                if (pVar.M == 6 && e1.c(pVar.N)) {
                    i2 = pVar.M;
                } else {
                    i2 = pVar.L;
                    if (i2 <= 1) {
                        i2++;
                    }
                }
                map.put("dw", Integer.valueOf(i2));
                StringBuilder sbAppend = new StringBuilder().append(strReplace).append("&dw=");
                if (pVar.M == 6 && e1.c(pVar.N)) {
                    i3 = pVar.M;
                } else {
                    i3 = pVar.L;
                    if (i3 <= 1) {
                        i3++;
                    }
                }
                strReplace = sbAppend.append(i3).toString();
            }
            if (j.b(1, i)) {
                map.put("s_rect", pVar.a(v5.KEY_AD_VIEW_RECT));
                map.put("s_impt", pVar.a(v5.KEY_IMPRESSION_INTERVAL_TIME));
                map.put("s_coor", pVar.a(v5.KEY_TOKEN_VIEW_COORDINATE));
                if (pVar.b && (pVar.O0 || !pVar.D0)) {
                    map.put("fe_fiwf", 1);
                }
            } else {
                Object obj3 = pVar.K.get(v5.KEY_AD_DOWNLOAD_STATE);
                if (obj3 != null) {
                    map.put("fe_ads", obj3);
                }
                map.put("fe_cc", pVar.c(0));
            }
        }
        return strReplace + "&eti=" + gj.f(pVar.z0 + gj.a((Map) map, ";", ":", true));
    }

    public static String a(String str) {
        try {
            StringBuilder sb = new StringBuilder("");
            AtomicInteger atomicInteger = gj.a;
            String strA = a(str, "b", sb.append(System.currentTimeMillis() / 1000).toString());
            Pair pairA = a(strA, "adxTracking");
            return a(a(strA, "ve", (String) pairA.first), an.aB, (String) pairA.second);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static Pair a(String str, String str2) {
        String strA;
        String[] strArrSplit;
        String[] strArrSplit2;
        String str3;
        String str4;
        if ("qilinTracking".equals(str2)) {
            strA = nh.a(jd.a).a("qcm");
        } else if ("adxTracking".equals(str2)) {
            strA = nh.a(jd.a).a("acm");
        } else {
            strA = nh.a(jd.a).a("ccm");
        }
        if (TextUtils.isEmpty(strA)) {
            strArrSplit = null;
        } else {
            strArrSplit = strA.split("_");
        }
        if (strArrSplit != null && strArrSplit.length == 3) {
            str4 = strArrSplit[0];
            strArrSplit2 = strArrSplit[1].split(",");
            str3 = strArrSplit[2];
        } else if (!str2.equals("cupidTracking")) {
            if (!str2.equals("qilinTracking")) {
                strArrSplit2 = c;
                str3 = "qax-track";
                str4 = "1";
            } else {
                strArrSplit2 = a;
                str3 = "qilin";
                str4 = "1";
            }
        } else {
            strArrSplit2 = b;
            str3 = "cupid";
            str4 = "1";
        }
        StringBuilder sb = new StringBuilder();
        Uri uri = Uri.parse(str);
        for (String str5 : strArrSplit2) {
            String queryParameter = uri.getQueryParameter(str5);
            if (!TextUtils.isEmpty(queryParameter)) {
                sb.append(queryParameter);
            }
        }
        sb.append(str3);
        String strD = gj.d(sb.toString());
        if (!"1".equals(str4) || "qilinTracking".equals(str2)) {
            strD = strD.substring(8, 15);
        }
        return new Pair(str4, strD);
    }

    public static String a(String str, String str2, String str3) {
        String strReplaceFirst;
        try {
            int iIndexOf = str.indexOf("#");
            String strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
            Matcher matcher = Pattern.compile("(\\b" + str2 + "=)([^&]*)").matcher(strSubstring);
            if (matcher.find()) {
                strReplaceFirst = matcher.replaceFirst("$1" + gj.f(str3));
            } else {
                strReplaceFirst = strSubstring + (strSubstring.contains("?") ? "&" : "?") + (str2 + "=" + gj.f(str3));
            }
            return iIndexOf != -1 ? strReplaceFirst + str.substring(iIndexOf) : strReplaceFirst;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
