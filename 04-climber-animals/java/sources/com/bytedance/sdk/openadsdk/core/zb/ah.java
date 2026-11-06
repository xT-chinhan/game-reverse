package com.bytedance.sdk.openadsdk.core.zb;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.cv;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.am;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.w.hi;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f3815ms;

    public static void ms(lm lmVar) {
    }

    public static void ms(String str, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.c.ms.ms msVar) {
        new ms.C0332ms().ka(str3).d(str4).ms(str).xr(str2).ms(msVar);
    }

    public static void ms(lm lmVar, String str, String str2, com.bytedance.sdk.openadsdk.c.ms.ms msVar) {
        if (lmVar == null) {
            return;
        }
        new ms.C0332ms().ka(lmVar.df()).d(lmVar.lx()).ms(str).xr(str2).ms(msVar);
    }

    public static void ms(lm lmVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.c.ms.ms msVar) {
        if (lmVar == null) {
            return;
        }
        new ms.C0332ms().ka(lmVar.df()).d(lmVar.lx()).ms(str).xr(str2).ms(jSONObject).ms(msVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ka(lm lmVar, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt;
        if (g.c() && (xrVarRt = lmVar.rt()) != null) {
            String strZb = xrVarRt.zb();
            if (TextUtils.isEmpty(strZb)) {
                return;
            }
            jSONObject.putOpt("media_extra", strZb);
        }
    }

    public static void ms(final lm lmVar, String str, String str2, final JSONObject jSONObject) {
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.1
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject3, lmVar);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                }
            }
        });
    }

    public static void ms(final lm lmVar, String str, String str2, final Map<String, Object> map) {
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.12
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void ms(final lm lmVar, final String str, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.op.ab.ms((Runnable) new ny("repost_show_check") { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.22
            @Override // java.lang.Runnable
            public void run() {
                if (lmVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - f.sl(lmVar)).floatValue();
                ah.ms(lmVar, str, "show_check", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.22.1
                    @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                    public void ms(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.ny.ms(str)).toString());
                        jSONObject2.put("is_cache", lmVar.ii() ? 1 : 0);
                        jSONObject2.put("cache_type", lmVar.ss());
                        jSONObject2.put("correct_action_code", lmVar.ci());
                        jSONObject2.put("correct_result_code", lmVar.ad());
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                        jSONObject2.put("start_type", !nw.xr.get() ? 1 : 0);
                        jSONObject2.put("show_count", ah.f3815ms);
                        jSONObject2.put("can_use_sensor", ch.ub().c());
                        jSONObject2.put("is_shake_ads", ch.ub().h());
                        jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                        ah.ka(lmVar, str, jSONObject2);
                        com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        float f = fFloatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                    }
                });
            }
        });
    }

    public static void ms(final lm lmVar, final String str, final Map<String, Object> map, final Double d) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new ny("report_show") { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.33
            @Override // java.lang.Runnable
            public void run() {
                ah.xr(lmVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    public static void xr(final lm lmVar, final String str, final Map<String, Object> map, final Double d) {
        if (lmVar == null) {
            return;
        }
        cv.xr();
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - f.sl(lmVar)).floatValue();
        final String strMs = com.bytedance.sdk.openadsdk.core.jw.re.ms(str, com.bytedance.sdk.openadsdk.core.jw.ch.xr(), f.ny(lmVar), com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
        f3815ms++;
        ms(lmVar, str, "show", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.35
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.ny.ms(str)).toString());
                jSONObject2.put("is_cache", lmVar.ii() ? 1 : 0);
                jSONObject2.put("cache_type", lmVar.ss());
                jSONObject2.put("correct_action_code", lmVar.ci());
                jSONObject2.put("correct_result_code", lmVar.ad());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - nw.ka);
                jSONObject2.put("start_type", !nw.xr.get() ? 1 : 0);
                jSONObject2.put("show_count", ah.f3815ms);
                String strC = ch.ub().c();
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject2.put("can_use_sensor", strC);
                }
                if (!ch.ub().hi()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!ch.ub().x()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", ch.ub().h());
                jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                ah.ka(lmVar, str, jSONObject2);
                String str2 = strMs;
                if (str2 != null) {
                    ul.ms(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.bytedance.sdk.openadsdk.core.live.xr.ms().ah());
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject2.put("shakeLiSize", com.bytedance.sdk.component.utils.nw.ms(re.getContext()).ms());
                hi.ms(lmVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                String strPt = lmVar.pt();
                if (!TextUtils.isEmpty(strPt)) {
                    try {
                        double d2 = Double.parseDouble(strPt);
                        if (d2 <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        } else {
                            if (g.xr < 4400) {
                                d2 *= 100000.0d;
                            }
                            jSONObject.put("ttdsp_price", d2);
                        }
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        sl.ms(th);
                    }
                }
                ms(lmVar, d, jSONObject);
            }

            public void ms(lm lmVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapOu = lmVar2.ou();
                    if (mapOu == null || (obj = mapOu.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (lmVar2.qu() && (obj2 = mapOu.get("price")) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String strAh = t.ah();
        List<String> listQe = lmVar.qe();
        if (!TextUtils.isEmpty(strAh)) {
            HashMap map2 = new HashMap();
            map2.put("aid", lmVar.cz());
            map2.put("cid", lmVar.df());
            map2.put("req_id", lmVar.eu());
            map2.put("customer_id", f.hi(lmVar));
            com.bytedance.sdk.openadsdk.core.t.xr.ms(strAh, listQe, true, map2, ms(lmVar, str, "show"));
        } else if (listQe != null && listQe.size() != 0) {
            ms(lmVar, listQe, str, "no did", "show");
        }
        if (f3815ms % 5 == 0 && com.bytedance.sdk.openadsdk.ms.ms.ms.ms() != null) {
            com.bytedance.sdk.openadsdk.ms.ms.ms.ms().xr("AdShow" + System.currentTimeMillis());
        }
        if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(lmVar)) {
            com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, lmVar, 0L);
        } else if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, lmVar, 0L);
        }
        f.ah();
        com.bytedance.sdk.openadsdk.ub.xr.xr();
        if (lmVar != null) {
            com.bytedance.sdk.openadsdk.core.live.xr.ms().d();
        }
        ch.ub().d().d();
        com.bytedance.sdk.openadsdk.core.jw.re.ms(f3815ms, 1);
        com.bytedance.sdk.openadsdk.core.d.ms().ah(lmVar.zg());
        com.bytedance.sdk.openadsdk.core.hi.ms.ms(lmVar);
    }

    private static void ms(lm lmVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        ms(str, lmVar.df(), lmVar.lx(), jSONObject);
    }

    public static void ms(final lm lmVar, final String str, final long j) {
        ms(lmVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.36
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.ny.ms(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(final String str, lm lmVar, String str2, final int i) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.37
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("source", Integer.valueOf(i));
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                jSONObject.put("duration", str);
            }
        });
    }

    public static long ms(long j, boolean z, lm lmVar, String str, int i) {
        if (z) {
            return System.currentTimeMillis();
        }
        ms(new StringBuilder().append(System.currentTimeMillis() - j).toString(), lmVar, str, i);
        return 0L;
    }

    public static long ms(long j, lm lmVar, String str, int i) {
        if (j <= 0) {
            return j;
        }
        ms(new StringBuilder().append(System.currentTimeMillis() - j).toString(), lmVar, str, i);
        return 0L;
    }

    public static void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString(TTDownloadField.TT_TAG);
        String strOptString2 = jSONObject.optString("ad_id");
        String strOptString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        ms(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void ms(String str, String str2, String str3, final JSONObject jSONObject) {
        ms(str, "show_url", str2, str3, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.38
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                }
            }
        });
    }

    public static void ms(final lm lmVar, final String str) {
        String strXr;
        if (lmVar == null || str == null || (strXr = f.xr(lmVar)) == null) {
            return;
        }
        ms(lmVar, strXr, "page_on_create", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.39
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(com.umeng.analytics.pro.g.v, str);
                ul.ms(jSONObject2, "");
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void ms(String str, final lm lmVar, final com.bytedance.sdk.openadsdk.core.nw.ch chVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2) {
        if (lmVar == null || z2) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - f.sl(lmVar)).floatValue();
        ms(lmVar, str2, str, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.2
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.core.nw.ch chVar2 = chVar;
                if (chVar2 != null) {
                    JSONObject jSONObjectMs = chVar2.ms();
                    jSONObjectMs.put("device", com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.ny.ms(str2)).toString());
                    jSONObjectMs.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectMs.put("user_behavior_type", i2);
                    }
                    ul.ms(jSONObjectMs, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectMs.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    ah.ka(lmVar, str2, jSONObjectMs);
                    jSONObjectMs.putOpt("obm_convert", com.bytedance.sdk.openadsdk.core.nw.nw.ah(lmVar));
                    jSONObjectMs.put("can_use_sensor", ch.ub().c());
                    if (!ch.ub().hi()) {
                        jSONObjectMs.put("mcod", "0");
                    }
                    if (!ch.ub().x()) {
                        jSONObjectMs.put("od", "0");
                    }
                    jSONObjectMs.put("is_shake_ads", ch.ub().h());
                    jSONObjectMs.put("live_sdk_config", com.bytedance.sdk.openadsdk.core.live.xr.ms().x());
                    jSONObjectMs.put("direction", com.bytedance.sdk.openadsdk.core.op.ms.ms().c());
                    jSONObjectMs.put("is_cache", lmVar.ii() ? 1 : 0);
                    jSONObjectMs.put("cache_type", lmVar.ss());
                    jSONObjectMs.put("correct_action_code", lmVar.ci());
                    jSONObjectMs.put("correct_result_code", lmVar.ad());
                    jSONObjectMs.put("from_uchain", com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObjectMs, lmVar);
                    jSONObject.put("ad_extra_data", jSONObjectMs.toString());
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
            }
        });
        String strAh = t.ah();
        List<String> listUe = lmVar.ue();
        if (!TextUtils.isEmpty(strAh) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", lmVar.cz());
            map2.put("cid", lmVar.df());
            map2.put("req_id", lmVar.eu());
            map2.put("customer_id", f.hi(lmVar));
            com.bytedance.sdk.openadsdk.core.t.xr.ms(strAh, listUe, true, map2, ms(lmVar, str2, "click"));
        } else if (listUe != null && listUe.size() != 0 && "click".equals(str)) {
            ms(lmVar, listUe, str2, "no did", "click");
        }
        if (str == "click") {
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
                com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(LiveMetrics.EVENT_LIVESDK_REC_LIVE_PLAY, lmVar, 0L);
            }
            com.bytedance.sdk.openadsdk.core.live.xr.ms().d(lmVar);
        }
        com.bytedance.sdk.openadsdk.core.jw.re.ms(1, 2);
        if (sl.ah()) {
            sl.ms("AdEvent", str + " " + lmVar.df());
        }
    }

    public static JSONObject ms(lm lmVar, String str, String str2) {
        return ms(lmVar.lx(), lmVar.df(), lmVar.eu(), str, str2);
    }

    public static JSONObject ms(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put("ad_id", str2);
            jSONObject.put("req_id", str3);
            jSONObject.put(TTDownloadField.TT_TAG, str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void xr(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void ms(final lm lmVar, String str, String str2, final long j) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.3
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j);
                jSONObject2.put("rom_new_version", w.ub());
                jSONObject2.put("is_background", ch.ub().ms());
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, com.bytedance.sdk.openadsdk.ao.xr.xr.c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        re.ms().ms(xrVar, arrayList);
        if (sl.ah()) {
            sl.ms("AdEvent", "tt_dislike_icon " + xrVar.ah());
        }
    }

    public static void xr(lm lmVar, String str) {
        if (lmVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.dislike.ah.ah();
            ahVar.ms("0:00");
            ahVar.xr(str);
            ms(lmVar.ca(), ahVar);
        }
    }

    public static void ms(Context context, lm lmVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || lmVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt(com.anythink.core.common.e.f.a.d);
        if (objOpt == null) {
            objOpt = lmVar.df();
        }
        String strOptString = jSONObject.optString("category");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "app_union";
        }
        Object objOpt2 = jSONObject.opt("log_extra");
        if (objOpt2 == null) {
            objOpt2 = lmVar.lx();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(u.ah(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt(TTDownloadField.TT_TAG, "6.9.2.3");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            sl.xr(e.getMessage());
        }
        new ms.C0332ms().ka(objOpt == null ? "" : objOpt.toString()).ah(strOptString).d(objOpt2 != null ? objOpt2.toString() : "").ms(str).ms(jSONObject).xr(str2).ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.4
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void ms(final long j, final lm lmVar) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, "splash_ad", "skip", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.5
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(final lm lmVar, String str, final JSONObject jSONObject) {
        ms(lmVar, f.xr(lmVar), str, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.6
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject3, lmVar);
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            }
        });
    }

    public static void ah(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void d(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void ka(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void ms(final lm lmVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.7
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void ms(final lm lmVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (lmVar == null || jSONObject == null) {
            return;
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.8
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void xr(lm lmVar, String str, String str2, final long j) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.9
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                jSONObject.put("timestamp", j);
            }
        });
    }

    public static void xr(final lm lmVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (lmVar == null || jSONObject == null) {
            return;
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.10
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void ah(final lm lmVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.11
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void c(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void ms(String str, String str2, String str3, String str4) {
        new ms.C0332ms().ms(str3).xr(str4).ka(str).d(str2).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
        if (sl.ah()) {
            sl.ms("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
        }
    }

    public static void ab(lm lmVar, String str, String str2, Map<String, Object> map) {
        ms(lmVar, str, str2, map);
    }

    public static void xr(lm lmVar, String str, String str2) {
        ms(lmVar, str, str2, (com.bytedance.sdk.openadsdk.c.ms.ms) null);
    }

    public static void ah(lm lmVar, String str, String str2) {
        ms(lmVar, str, str2, (com.bytedance.sdk.openadsdk.c.ms.ms) null);
    }

    public static void xr(lm lmVar, String str, String str2, JSONObject jSONObject) {
        ms(lmVar, str, str2, jSONObject);
    }

    public static void ms(lm lmVar, String str, String str2, Throwable th) {
        ce ceVarJs = lmVar.js();
        JSONObject jSONObject = null;
        if (ceVarJs != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", ceVarJs.ka());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        ms(lmVar, str, str2, jSONObject);
    }

    public static void xr(lm lmVar, String str, long j) {
        String str2;
        if (re.xr().vm()) {
            final long jCurrentTimeMillis = System.currentTimeMillis() - j;
            str.hashCode();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.13
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", jCurrentTimeMillis);
                }
            });
        }
    }

    public static void x(lm lmVar, String str, String str2, Map<String, Object> map) {
        ce ceVarJs = lmVar.js();
        if (map == null) {
            map = new HashMap<>();
        }
        if (ceVarJs != null) {
            map.put("wc_type", Integer.valueOf(ceVarJs.ka()));
        }
        map.put("rom_new_version", w.ub());
        map.put("is_background", Boolean.valueOf(ch.ub().ms()));
        map.put("interaction_type", Integer.valueOf(lmVar.jr()));
        ms(lmVar, str, str2, map);
    }

    public static void ms(lm lmVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(TTDownloadField.TT_REFER, str3);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, lmVar);
            }
        } catch (Throwable unused) {
        }
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.14
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject);
            }
        });
    }

    public static void ms(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - f.c(jSONObject.optString("log_extra"))).floatValue();
        new ms.C0332ms().ms(str2).xr(str3).ah(str).ka(String.valueOf(j)).c(String.valueOf(j2)).ms(jSONObject).ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.15
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.ny.ms(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put("ad_extra_data", jSONObject3.toString());
                jSONObject2.put(TTDownloadField.TT_TAG, str2);
                if ("click".equals(str3)) {
                    float f = fFloatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
            }
        });
        if (sl.ah()) {
            sl.ms("AdEvent", "sendJsAdEvent");
        }
    }

    public static void ah(lm lmVar, String str, String str2, JSONObject jSONObject) {
        if (lmVar == null) {
            return;
        }
        new ms.C0332ms().ka(lmVar.df()).d(lmVar.lx()).ms(str).xr(str2).ms(jSONObject).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
    }

    public static void xr(final lm lmVar, String str, String str2, final String str3) {
        ms(lmVar, str, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.16
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(final long j, String str, String str2) {
        lm lmVarMs;
        try {
            lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(str2));
        } catch (Throwable unused) {
            lmVarMs = null;
        }
        if (lmVarMs == null) {
            return;
        }
        ms(lmVarMs, str, "open_appback", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.17
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
            }
        });
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        xrVarMs.ms("save_jump_success_time", 0L);
        xrVarMs.ms("save_jump_success_ad_tag", "");
    }

    public static void xr(final lm lmVar) {
        ms(lmVar, "landingpage", "open_url_h5", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.18
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(j.w.E, "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void ah(final lm lmVar, String str, final long j) {
        ms(lmVar, str, "load", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.19
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(j.w.E, "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(j, 600000L));
            }
        });
    }

    public static void d(lm lmVar, String str, final long j) {
        ms(lmVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.20
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void ms(lm lmVar, String str, final int i, final String str2) {
        ms(lmVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.21
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(lm lmVar, String str, final long j, final String str2) {
        ms(lmVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.23
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(lm lmVar, String str, final int i, final String str2, final String str3) {
        ms(lmVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.24
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(lm lmVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        ms(lmVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.25
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt("ad_extra_data", jSONObject.toString());
                }
                jSONObject2.put("duration", j);
            }
        });
    }

    public static void ms(final lm lmVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (lmVar != null && lmVar.cn() == 1) {
            ms(lmVar, str, "open_live", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.26
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int iKu = lmVar.ku();
                    jSONObject2.put("live_interaction_type", iKu);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", xn.xr(lmVar));
                    jSONObject2.put("is_inner", z);
                    am amVarMg = lmVar.mg();
                    if (amVarMg != null) {
                        jSONObject2.putOpt("saas_info", amVarMg.ms());
                    }
                    h hVarTc = lmVar.tc();
                    if (hVarTc != null) {
                        String strXr = hVarTc.xr();
                        if (hVarTc != null && strXr.length() > 500) {
                            strXr = strXr.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", strXr);
                        if (!strXr.startsWith("snssdk1128") && !strXr.startsWith("snssdk2329") && iKu == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void ms(final lm lmVar, String str, final int i) {
        ms(lmVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.27
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i);
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    sl.ms(e);
                }
            }
        });
    }

    public static void xr(final lm lmVar, String str, final int i) {
        ms(lmVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.28
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i);
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    sl.ms(e);
                }
            }
        });
    }

    public static void xr(lm lmVar, String str, final JSONObject jSONObject) {
        if (lmVar == null || jSONObject == null) {
            return;
        }
        ms(lmVar, str, "cache_correct_details", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.29
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void xr(long j, final lm lmVar) {
        if (lmVar != null && lm.xr(lmVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            ms(lmVar, "splash_ad", "play_duration_sum", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.30
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, lmVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void ms(final int i, String str, final lm lmVar) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.31
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                am amVarMg = lmVar.mg();
                if (amVarMg != null) {
                    jSONObject2.put("saas_auth_type", amVarMg.xr());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ms(String str, lm lmVar) {
        if (lmVar == null) {
            return;
        }
        ms(lmVar, str, "ec_mall_task", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.32
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void ah(lm lmVar, String str, final JSONObject jSONObject) {
        if (lmVar == null || jSONObject == null) {
            return;
        }
        ms(lmVar, str, "splash_ad_showstat", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ah.34
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }
}
