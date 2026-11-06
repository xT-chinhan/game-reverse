package com.byazt.pj;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.f;
import com.byazt.hg.lv;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.u;
import com.byazt.qx.aj;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.lb;
import com.byazt.sd.y;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.nt;
import com.byazt.wt.rc;
import com.byazt.wt.z;
import com.bytedance.JProtect;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 37})
public class pr {
    public static final Set<String> hw;
    public static int pr = 0;

    static {
        HashSet hashSet = new HashSet();
        hw = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
    }

    public static void pr(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONObject jSONObject, final com.byazt.ttf.pr prVar) {
        if (((k) com.byazt.zs.uc.pr("csj_settings", com.byazt.zb.pr.pr().pr(com.byazt.sd.zo.nt().ny()))).c() && !hw.contains(str)) {
            return;
        }
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("adevent") { // from class: com.byazt.pj.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.fu.hn hnVarPr = com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny());
                if (str4 != null) {
                    com.byazt.mk.hn.fw().pr(str, str5, str6, (JSONObject) null, str4);
                }
                hnVarPr.pr(str, str2, str3, str4, str5, str7, jSONObject, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.1.1
                    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                        if (jSONObject2 != null) {
                            jSONObject2.putOpt("plugin_version_name", "7.7.1.4");
                        }
                        JSONObject jSONObject3 = null;
                        if (prVar != null) {
                            jSONObject3 = prVar.pr(jSONObject2);
                        }
                        if (jSONObject3 == null) {
                            jSONObject3 = new JSONObject();
                        }
                        String strFw = com.byazt.eg.hw.pr().fw();
                        if (!TextUtils.isEmpty(strFw)) {
                            jSONObject3.put("live_plugin_version", strFw.replaceAll("\\.", ""));
                        }
                        if (com.byazt.sd.zo.nt().uc()) {
                            jSONObject3.putOpt("first_of_two", 1);
                        }
                        try {
                            jSONObject3.put("device_score", Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", com.byazt.zb.pr.x())));
                        } catch (Throwable th) {
                        }
                        jSONObject3.put("sdk_boost_type", com.byazt.iq.pr.c());
                        jSONObject3.put("csj_type", com.byazt.sd.zo.nt().v() ? 1 : 0);
                        if (!TextUtils.isEmpty(ls.aj)) {
                            jSONObject3.put("wrong_stats_url", ls.aj);
                        }
                        if (!TextUtils.isEmpty(ls.vk)) {
                            jSONObject3.put("wrong_applog_url", ls.vk);
                        }
                        com.byazt.vq.pr.pr().pr(jSONObject3);
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3);
                        com.byazt.pr.hn.pr(str, jSONObject2);
                        try {
                            if (y.hn()) {
                                ((com.byazt.r.hn) com.byazt.zs.uc.pr("pitaya_new")).pr(str, jSONObject2.toString());
                            }
                        } catch (Throwable th2) {
                            ho.hw("AdEventManager", "pitaya onAppLogEvent error:" + th2.getMessage());
                        }
                        return jSONObject3;
                    }
                });
            }
        });
    }

    public static void pr(String str, String str2, String str3, String str4, com.byazt.ttf.pr prVar) {
        pr(str2, str, (String) null, str4, str3, (String) null, (String) null, (JSONObject) null, prVar);
    }

    public static void pr(of ofVar, String str, String str2, com.byazt.ttf.pr prVar) {
        if (ofVar == null) {
            return;
        }
        pr(str2, str, (String) null, ofVar.B_(), ofVar.x(), ofVar.ny(), (String) null, (JSONObject) null, prVar);
    }

    public static void pr(of ofVar, String str, String str2, JSONObject jSONObject, com.byazt.ttf.pr prVar) {
        if (ofVar == null) {
            return;
        }
        pr(str2, str, (String) null, ofVar.B_(), ofVar.x(), ofVar.ny(), (String) null, jSONObject, prVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uc(of ofVar, String str, JSONObject jSONObject) throws JSONException {
        com.byazt.qe.hw hwVarP;
        if (iu.fw() && (hwVarP = ofVar.p()) != null) {
            String strM = hwVarP.m();
            if (!TextUtils.isEmpty(strM)) {
                jSONObject.putOpt("media_extra", strM);
            }
        }
    }

    public static void pr(final of ofVar, String str, String str2, final JSONObject jSONObject) {
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.12
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.ja.pr.pr(jSONObject3, ofVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void pr(final of ofVar, String str, String str2, final Map<String, Object> map) {
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.22
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                if (map == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final of ofVar, final String str, final Map<String, Object> map) {
        com.byazt.zp.zo.pr((Runnable) new com.byazt.xlm.fw("repost_show_check") { // from class: com.byazt.pj.pr.33
            @Override // java.lang.Runnable
            public void run() {
                if (ofVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ls.nt(ofVar)).floatValue();
                pr.pr(ofVar, str, "show_check", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.33.1
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.byazt.mp.pr.pr(a.getContext(), aj.pr(str)).toString());
                        jSONObject2.put("is_cache", ofVar.ji() ? 1 : 0);
                        jSONObject2.put("cache_type", ofVar.w(ofVar.ji()));
                        com.byazt.xe.hn.pr(ofVar, jSONObject2, false);
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                        jSONObject2.put("start_type", !lb.hw.get() ? 1 : 0);
                        jSONObject2.put("show_count", pr.pr);
                        jSONObject2.put("can_use_sensor", com.byazt.sd.zo.nt().c());
                        jSONObject2.put("is_shake_ads", com.byazt.sd.zo.nt().qa());
                        jSONObject2.put("direction", com.byazt.na.pr.pr().uc());
                        pr.uc(ofVar, str, jSONObject2);
                        com.byazt.ja.pr.pr(jSONObject2, ofVar);
                        jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                        float f = fFloatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                        return jSONObject2;
                    }
                });
            }
        });
    }

    public static void pr(final of ofVar, final String str, final Map<String, Object> map, final Double d) {
        if (ofVar != null) {
            com.byazt.qd.hw.pr().pr(ofVar.z(), new com.byazt.ewt.x.pr() { // from class: com.byazt.pj.pr.40
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).c = 1;
                    }
                }
            });
        }
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("report_show") { // from class: com.byazt.pj.pr.41
            @Override // java.lang.Runnable
            public void run() {
                pr.hw(ofVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    @JProtect
    public static void hw(final of ofVar, final String str, final Map<String, Object> map, final Double d) {
        if (ofVar == null) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ls.nt(ofVar)).floatValue();
        final String strPr = rc.pr(str, ((g) com.byazt.zs.uc.pr("device_info_new")).ww(), ls.m(ofVar), com.byazt.iy.hw.pr());
        ofVar.xh().hn();
        pr++;
        pr(ofVar, str, "show", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.42
            /* JADX WARN: Type inference failed for: r2v47, types: [java.lang.Throwable] */
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.mp.pr.pr(a.getContext(), aj.pr(str)).toString());
                jSONObject2.put("is_cache", ofVar.ji() ? 1 : 0);
                of ofVar2 = ofVar;
                jSONObject2.put("cache_type", ofVar2.w(ofVar2.ji()));
                com.byazt.xe.hn.pr(ofVar, jSONObject2, true);
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - lb.c);
                jSONObject2.put("start_type", !lb.hw.get() ? 1 : 0);
                jSONObject2.put("show_count", pr.pr);
                String strC = com.byazt.sd.zo.nt().c();
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject2.put("can_use_sensor", strC);
                }
                if (a.hw().qi()) {
                    jSONObject2.put("mcod", "-1");
                } else if (!com.byazt.sd.zo.nt().vk()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!com.byazt.sd.zo.nt().fw()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", com.byazt.sd.zo.nt().qa());
                jSONObject2.put("direction", com.byazt.na.pr.pr().uc());
                pr.uc(ofVar, str, jSONObject2);
                String str2 = strPr;
                if (str2 != null) {
                    er.pr(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.byazt.eg.hw.pr().hn());
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject2.put("shakeLiSize", com.byazt.ca.x.pr(a.getContext()).pr());
                if (ofVar.ob()) {
                    jSONObject2.put("reward_show_type", ofVar.gb());
                    jSONObject2.put("browse_time", ofVar.tn());
                }
                pr.pr(jSONObject2);
                ofVar.xh().pr(jSONObject2, true);
                JSONObject jSONObjectIa = ofVar.ia();
                if (jSONObjectIa != null) {
                    ls.pr(ofVar, jSONObjectIa);
                    jSONObject2.putOpt("applist_info", jSONObjectIa);
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.byazt.mk.hn.fw().pr(ofVar, fFloatValue);
                String strUg = ofVar.ug();
                if (!TextUtils.isEmpty(strUg)) {
                    try {
                        double d2 = Double.parseDouble(strUg);
                        if (d2 <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return jSONObject2;
                        }
                        jSONObject.put("ttdsp_price", d2);
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                    }
                }
                pr(ofVar, d, jSONObject);
                return jSONObject2;
            }

            public void pr(of ofVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapZc = ofVar2.zc();
                    if (mapZc == null || (obj = mapZc.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (ofVar2.tk() && (obj2 = mapZc.get(IAction.PurchaseKey.Price)) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable th) {
                }
            }
        });
        String strPr2 = nt.pr();
        List<String> listDf = ofVar.df();
        if (!TextUtils.isEmpty(strPr2)) {
            HashMap map2 = new HashMap();
            map2.put("aid", ofVar.fo());
            map2.put("cid", ofVar.x());
            map2.put("req_id", ofVar.ny());
            map2.put("customer_id", ls.ho(ofVar));
            com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).pr(strPr2, listDf, true, map2, pr(ofVar, str, "show"));
        } else if (listDf != null && listDf.size() != 0) {
            pr(ofVar, listDf, str, "no did", "show");
        }
        if (pr % 5 == 0 && com.byazt.qv.pr.pr() != null) {
            com.byazt.qv.pr.pr().hw("AdShow" + System.currentTimeMillis());
        }
        if (com.byazt.eg.hw.pr().uc(ofVar)) {
            com.byazt.xk.hw.pr().pr(ofVar);
            com.byazt.lpk.pr.pr(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, ofVar, 0L);
        }
        ls.hn();
        com.byazt.igw.hw.pr(ofVar.yn());
        if (ofVar != null) {
            com.byazt.eg.hw.pr().x();
        }
        com.byazt.sd.zo.nt().hn().x();
        rc.pr(pr, 1);
        com.byazt.sd.x.pr().hn(ofVar.td());
        com.byazt.mk.hn.fw().vk();
    }

    private static void pr(of ofVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put(Constants.ERROR_MSG_FIELD, str2);
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
            jSONObject.put(BreakpointSQLiteKey.URL, sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception e) {
        }
        pr(str, ofVar.x(), ofVar.B_(), jSONObject);
    }

    public static void pr(final of ofVar, final String str, final long j) {
        pr(ofVar, str, "download_creative_duration", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.43
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.mp.pr.pr(a.getContext(), aj.pr(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final String str, of ofVar, String str2, final int i, final Map<String, Long> map) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str2, "ad_show_time", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.44
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("source", Integer.valueOf(i));
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        jSONObject2.putOpt((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                jSONObject.put("duration", str);
                return jSONObject2;
            }
        });
    }

    public static void pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("tag");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String strOptString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        pr(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void pr(String str, String str2, String str3, final JSONObject jSONObject) {
        pr(str, "show_url", str2, str3, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void pr(final of ofVar, final String str) {
        String strHw;
        if (ofVar == null || str == null || (strHw = ls.hw(ofVar)) == null) {
            return;
        }
        pr(ofVar, strHw, "page_on_create", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.v, str);
                er.pr(jSONObject2, "");
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    @JProtect
    public static void pr(String str, final of ofVar, final com.byazt.hg.aj ajVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2, final boolean z3) {
        if (ofVar == null || z2) {
            return;
        }
        if ("click".equals(str)) {
            com.byazt.qd.hw.pr().pr(ofVar.z(), new com.byazt.ewt.x.pr() { // from class: com.byazt.pj.pr.4
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).uc = 1;
                    }
                }
            });
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ls.nt(ofVar)).floatValue();
        pr(ofVar, str2, str, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.5
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObjectPr;
                com.byazt.hg.aj ajVar2 = ajVar;
                if (ajVar2 == null) {
                    jSONObjectPr = null;
                } else {
                    jSONObjectPr = ajVar2.pr(ofVar);
                    jSONObjectPr.put("device", com.byazt.mp.pr.pr(a.getContext(), aj.pr(str2)).toString());
                    jSONObjectPr.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectPr.put("user_behavior_type", i2);
                    }
                    er.pr(jSONObjectPr, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectPr.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    pr.uc(ofVar, str2, jSONObjectPr);
                    jSONObjectPr.putOpt("obm_convert", qa.hw(ofVar));
                    jSONObjectPr.put("can_use_sensor", com.byazt.sd.zo.nt().c());
                    if (a.hw().qi()) {
                        jSONObjectPr.put("mcod", "-1");
                    } else if (!com.byazt.sd.zo.nt().vk()) {
                        jSONObjectPr.put("mcod", "0");
                    }
                    if (!com.byazt.sd.zo.nt().fw()) {
                        jSONObjectPr.put("od", "0");
                    }
                    jSONObjectPr.put("is_shake_ads", com.byazt.sd.zo.nt().qa());
                    jSONObjectPr.put("live_sdk_config", com.byazt.eg.hw.pr().zo());
                    jSONObjectPr.put("direction", com.byazt.na.pr.pr().uc());
                    jSONObjectPr.put("is_cache", ofVar.ji() ? 1 : 0);
                    of ofVar2 = ofVar;
                    jSONObjectPr.put("cache_type", ofVar2.w(ofVar2.ji()));
                    com.byazt.xe.hn.pr(ofVar, jSONObjectPr, false);
                    jSONObjectPr.put("source", z3 ? 1 : 0);
                    com.byazt.ja.pr.pr(jSONObjectPr, ofVar);
                    com.byazt.wt.iu.pr(jSONObjectPr, ofVar);
                    pr.pr(jSONObjectPr);
                    if (ofVar.ob()) {
                        jSONObjectPr.put("reward_show_type", ofVar.gb());
                        jSONObjectPr.put("browse_time", ofVar.tn());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr.toString());
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                return jSONObjectPr;
            }
        });
        String strPr = nt.pr();
        List<String> listTt = ofVar.tt();
        if (!TextUtils.isEmpty(strPr) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", ofVar.fo());
            map2.put("cid", ofVar.x());
            map2.put("req_id", ofVar.ny());
            map2.put("customer_id", ls.ho(ofVar));
            com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).pr(strPr, listTt, true, map2, pr(ofVar, str2, "click"));
        } else if (listTt != null && listTt.size() != 0 && "click".equals(str)) {
            pr(ofVar, listTt, str2, "no did", "click");
        }
        if (TextUtils.equals("click", str)) {
            if (com.byazt.lpk.pr.pr(ofVar)) {
                com.byazt.lpk.pr.pr(LiveMetrics.EVENT_LIVESDK_REC_LIVE_PLAY, ofVar, 0L);
            }
            com.byazt.eg.hw.pr().x(ofVar);
        }
        rc.pr(1, 2);
    }

    public static JSONObject pr(of ofVar, String str, String str2) {
        return pr(ofVar.B_(), ofVar.x(), ofVar.ny(), str, str2);
    }

    public static JSONObject pr(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static void hw(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void pr(final of ofVar, String str, String str2, final long j) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.6
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j);
                jSONObject2.put("rom_new_version", z.g());
                jSONObject2.put("is_background", com.byazt.sd.zo.nt().pr());
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(com.byazt.dw.hw hwVar, com.byazt.mr.uc ucVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ucVar);
        a.pr().pr(hwVar, arrayList);
    }

    public static void hw(of ofVar, String str) {
        if (ofVar != null) {
            com.byazt.dw.hn hnVar = new com.byazt.dw.hn();
            hnVar.pr("0:00");
            hnVar.hw(str);
            com.byazt.mk.hn.fw().pr("skip", ofVar.x(), ofVar.ny(), ofVar.v_(), (String) null);
            pr(ofVar.ae(), hnVar);
        }
    }

    public static void pr(Context context, of ofVar, String str, String str2, JSONObject jSONObject) {
        String str3;
        if (TextUtils.isEmpty(str2) || ofVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt(Constants.VALUE_FIELD);
        if (objOpt == null) {
            objOpt = ofVar.x();
        }
        String strOptString = jSONObject.optString("category");
        if (!TextUtils.isEmpty(strOptString)) {
            str3 = strOptString;
        } else {
            str3 = "app_union";
        }
        Object objOpt2 = jSONObject.opt("log_extra");
        if (objOpt2 == null) {
            objOpt2 = ofVar.B_();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(yb.hn(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.7.1.4");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            ho.pr(e.getMessage());
        }
        pr(str2, str, str3, objOpt2 != null ? objOpt2.toString() : "", objOpt == null ? "" : objOpt.toString(), (String) null, (String) null, jSONObject, (com.byazt.ttf.pr) null);
    }

    public static void pr(final long j, final of ofVar) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, "splash_ad", "skip", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.7
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final of ofVar, String str, final JSONObject jSONObject) {
        pr(ofVar, ls.hw(ofVar), str, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.8
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.ja.pr.pr(jSONObject3, ofVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
                return jSONObject;
            }
        });
    }

    public static void hw(of ofVar, String str, final JSONObject jSONObject) {
        pr(ofVar, ls.hw(ofVar), str, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.9
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3);
                }
                return jSONObject;
            }
        });
    }

    public static void hn(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void x(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void c(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void pr(final of ofVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.10
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                if (map == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final of ofVar, final int i) {
        pr(ofVar, ls.hw(ofVar), "reward_callback", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.11
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_show_type", ofVar.gb());
                jSONObject2.put("browse_time", ofVar.tn());
                jSONObject2.put("reward_action_type", i);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void hw(final of ofVar, final int i) {
        if (!ofVar.ob()) {
            return;
        }
        pr(ofVar, ls.hw(ofVar), "reward_task_diff", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.13
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_show_type", ofVar.gb());
                jSONObject2.put("reward_action_type", i);
                jSONObject2.put("task_action", ofVar.gb() == i ? 0 : 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final of ofVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.14
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ja.pr.pr(jSONObject, ofVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void hw(of ofVar, String str, String str2, final long j) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.15
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("timestamp", j);
                return null;
            }
        });
    }

    public static void hw(final of ofVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.16
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ja.pr.pr(jSONObject, ofVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void hn(final of ofVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.17
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ja.pr.pr(jSONObject, ofVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void uc(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void pr(String str, String str2, String str3, String str4) {
        pr(str4, str3, (String) null, str2, str, (String) null, (String) null, (JSONObject) null, (com.byazt.ttf.pr) null);
    }

    public static void fw(of ofVar, String str, String str2, Map<String, Object> map) {
        pr(ofVar, str, str2, map);
    }

    public static void hw(of ofVar, String str, String str2) {
        pr(ofVar, str, str2, (com.byazt.ttf.pr) null);
    }

    public static void hn(of ofVar, String str, String str2) {
        pr(ofVar, str, str2, (com.byazt.ttf.pr) null);
    }

    public static void hw(of ofVar, String str, String str2, JSONObject jSONObject) {
        pr(ofVar, str, str2, jSONObject);
    }

    public static void hw(of ofVar, String str, long j) {
        String str2;
        if (!a.hw().na()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis() - j;
        switch (str) {
            case "banner_ad":
                str2 = "banner_ad_loadtime";
                break;
            case "interaction":
                str2 = "interaction_loadtime";
                break;
            case "embeded_ad":
                str2 = "embeded_ad_loadtime";
                break;
            case "stream":
                str2 = "stream_loadtime";
                break;
            case "rewarded_video":
                str2 = "rewarded_video_loadtime";
                break;
            case "fullscreen_interstitial_ad":
                str2 = "fullscreen_interstitial_ad_loadtime";
                break;
            case "draw_ad":
                str2 = "draw_ad_loadtime";
                break;
            default:
                str2 = "";
                break;
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.18
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", jCurrentTimeMillis);
                return null;
            }
        });
    }

    public static void zo(of ofVar, String str, String str2, Map<String, Object> map) {
        u uVarF_ = ofVar.F_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (uVarF_ != null) {
            map.put("wc_type", Integer.valueOf(uVarF_.c()));
        }
        map.put("rom_new_version", z.g());
        map.put("is_background", Boolean.valueOf(com.byazt.sd.zo.nt().pr()));
        map.put("interaction_type", Integer.valueOf(ofVar.aj()));
        map.put("can_query", Boolean.valueOf(ls.b()));
        pr(ofVar, str, str2, map);
    }

    public static void aj(of ofVar, String str, String str2, Map<String, Object> map) {
        u uVarF_ = ofVar.F_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (uVarF_ != null) {
            map.put("wc_type", Integer.valueOf(uVarF_.c()));
        }
        map.put("rom_new_version", z.g());
        map.put("is_background", Boolean.valueOf(com.byazt.sd.zo.nt().pr()));
        map.put("interaction_type", Integer.valueOf(ofVar.aj()));
        map.put("can_query", Boolean.valueOf(ls.b()));
        pr(ofVar, str, str2, map);
    }

    public static void pr(of ofVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.byazt.ja.pr.pr(jSONObject, ofVar);
            }
        } catch (Throwable th) {
        }
        pr(ofVar, str, str2, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.19
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                return jSONObject;
            }
        });
    }

    public static void pr(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject, final byte b) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ls.uc(jSONObject.optString("log_extra"))).floatValue();
        pr(str3, str2, str, (String) null, String.valueOf(j), (String) null, String.valueOf(j2), jSONObject, new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.20
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.byazt.mp.pr.pr(a.getContext(), aj.pr(str2)).toString());
                jSONObject3.put("js_event", 1);
                byte b2 = b;
                if (b2 != -1) {
                    jSONObject3.put("biz_type", (int) b2);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f = fFloatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
                return jSONObject3;
            }
        });
    }

    public static void hn(of ofVar, String str, String str2, JSONObject jSONObject) {
        if (ofVar == null) {
            return;
        }
        pr(str2, str, (String) null, ofVar.B_(), ofVar.x(), (String) null, (String) null, jSONObject, (com.byazt.ttf.pr) null);
    }

    public static void pr(of ofVar, String str, Map<String, Object> map, boolean z) {
        if (z) {
            pr(ofVar, str, "lp_open_dpl", map);
            return;
        }
        u uVarF_ = ofVar.F_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (uVarF_ != null) {
            map.put("wc_type", Integer.valueOf(uVarF_.c()));
        }
        map.put("rom_new_version", z.g());
        map.put("is_background", Boolean.valueOf(com.byazt.sd.zo.nt().pr()));
        map.put("interaction_type", Integer.valueOf(ofVar.aj()));
        map.put("can_query", Boolean.valueOf(ls.b()));
        pr(ofVar, str, "open_url_app", map);
    }

    public static void pr(of ofVar, String str, Throwable th, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                pr(ofVar, str, "lp_openurl", th);
                pr(ofVar, str, "lp_deeplink_success_realtime", th);
                return;
            } else {
                pr(ofVar, str, "deeplink_success_realtime", th);
                return;
            }
        }
        if (z) {
            pr(ofVar, str, "lp_openurl_failed", th);
            pr(ofVar, str, "lp_deeplink_fail_realtime", th);
        } else {
            pr(ofVar, str, "deeplink_fail_realtime", th);
        }
    }

    public static void pr(of ofVar, String str, String str2, Throwable th) {
        u uVarF_ = ofVar.F_();
        JSONObject jSONObject = null;
        if (uVarF_ != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", uVarF_.c());
                    jSONObject = jSONObject2;
                } catch (Throwable th2) {
                    jSONObject = jSONObject2;
                }
            } catch (Throwable th3) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception e) {
            }
        }
        pr(ofVar, str, str2, jSONObject);
    }

    public static void pr(final long j, String str, of ofVar) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, "open_appback", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.21
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                return null;
            }
        });
        com.byazt.zq.c cVarHn = com.byazt.sd.hw.hn();
        cVarHn.pr("save_jump_success_time", 0L);
        cVarHn.pr("save_jump_success_ad_tag", "");
    }

    public static void pr(final of ofVar) {
        pr(ofVar, "landingpage", "open_url_h5", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.23
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    public static void hn(final of ofVar, String str, final long j) {
        pr(ofVar, str, "load", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.24
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.ja.pr.pr(jSONObject2, ofVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put("duration", Math.min(j, 600000L));
                return jSONObject2;
            }
        });
    }

    public static void x(of ofVar, String str, final long j) {
        pr(ofVar, str, "render_live_picture_success", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.25
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(of ofVar, String str, final int i, final String str2) {
        pr(ofVar, str, "render_live_picture_fail", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.26
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(of ofVar, String str, final long j, final String str2) {
        pr(ofVar, str, "live_play_success", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.27
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(of ofVar, String str, final int i, final String str2, final String str3) {
        pr(ofVar, str, "live_play_fail", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.28
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(of ofVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        pr(ofVar, str, "live_play_close", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.29
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                jSONObject2.put("duration", j);
                return jSONObject;
            }
        });
    }

    public static void pr(final of ofVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (ofVar == null || ofVar.uv() != 1) {
            return;
        }
        pr(ofVar, str, "open_live", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.30
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                int i4 = i3;
                int iC = ofVar.c();
                jSONObject2.put("live_interaction_type", iC);
                jSONObject2.put("client_live_interaction_type", i);
                jSONObject2.put("real_live_interaction_type", i2);
                jSONObject2.put("reward_live_type", f.hw(ofVar));
                jSONObject2.put("is_inner", z);
                lv lvVarH_ = ofVar.H_();
                if (ofVar.c() == 9 && ofVar.I_() != null) {
                    lvVarH_ = ofVar.I_().x();
                }
                if (lvVarH_ != null) {
                    jSONObject2.putOpt("saas_info", lvVarH_.pr());
                }
                com.byazt.hg.yb ybVarG = ofVar.g();
                if (ybVarG != null) {
                    String strHw = ybVarG.hw();
                    if (ybVarG != null && strHw.length() > 500) {
                        strHw = strHw.substring(0, 500);
                    }
                    jSONObject2.put("deep_link", strHw);
                    if (!strHw.startsWith("snssdk1128") && !strHw.startsWith("snssdk2329") && iC == 1 && i4 != 0) {
                        i4 = 2;
                    }
                }
                jSONObject2.put("live_interaction_status", i4);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(final of ofVar, String str, final int i) {
        pr(ofVar, str, "qpon_join", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.31
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("join_status", i);
                    com.byazt.ja.pr.pr(jSONObject2, ofVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                }
                return jSONObject2;
            }
        });
    }

    public static void hw(final of ofVar, String str, final int i) {
        pr(ofVar, str, "qpon_apply", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.32
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("qpon_apply_status", i);
                    com.byazt.ja.pr.pr(jSONObject2, ofVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                }
                return jSONObject2;
            }
        });
    }

    public static void hn(of ofVar, String str, final JSONObject jSONObject) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        pr(ofVar, str, "cache_correct_details", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.34
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void hw(long j, final of ofVar) {
        if (ofVar != null && of.hn(ofVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            pr(ofVar, "splash_ad", "play_duration_sum", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.35
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.byazt.ja.pr.pr(jSONObject2, ofVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    public static void pr(final int i, String str, final of ofVar) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, "saas_auth", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.36
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                lv lvVarH_ = ofVar.H_();
                if (lvVarH_ != null) {
                    jSONObject2.put("saas_auth_type", lvVarH_.hw());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void pr(String str, of ofVar) {
        if (ofVar == null) {
            return;
        }
        pr(ofVar, str, "ec_mall_task", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.37
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void x(of ofVar, String str, final JSONObject jSONObject) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        pr(ofVar, str, "splash_ad_showstat", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.38
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            com.byazt.qam.fw fwVarYb = com.byazt.sd.zo.nt().yb();
            jSONObject2.put("isCanUseLocation", fwVarYb.pr());
            jSONObject2.put("isCanUsePhoneState", fwVarYb.hn());
            jSONObject2.put("isCanUseWifiState", fwVarYb.x());
            jSONObject2.put("isCanUseWriteExternal", fwVarYb.c());
            jSONObject2.put("alist", fwVarYb.hw());
            jSONObject2.put("isCanUseAndroidId", fwVarYb.uc());
            jSONObject2.put("isCanUsePermissionRecordAudio", fwVarYb.fw());
            Map<String, Object> mapNt = fwVarYb.nt();
            if (mapNt != null && !mapNt.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : mapNt.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (TextUtils.equals(key, "mcod") && a.hw().qi()) {
                        jSONObject3.put(key, "-1");
                    } else {
                        jSONObject3.put(key, value);
                    }
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException e) {
        }
    }

    public static void hn(final of ofVar, String str) {
        pr(ofVar, str, "cache_ana_upload", new com.byazt.ttf.pr() { // from class: com.byazt.pj.pr.39
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                ofVar.xh().pr(jSONObject2, false);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }
}
