package com.byazt.hm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.anythink.core.d.b.e;
import com.byazt.gct.ic;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.gct.wv;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.x;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.byazt.wea.fs;
import com.bytedance.JProtect;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 19})
public class n {
    public static int n;
    public static final Set<String> qg;

    static {
        HashSet hashSet = new HashSet();
        qg = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
    }

    public static void n(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONObject jSONObject, final com.byazt.rs.n nVar) {
        if (((cp) com.byazt.qp.q.n("csj_settings", com.byazt.vgx.s.n().n(com.byazt.vyf.s.cy().ou()))).l() && !qg.contains(str)) {
            return;
        }
        com.byazt.ag.qg.n(new x("adevent") { // from class: com.byazt.hm.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sf.s sVarN = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou());
                if (str4 != null) {
                    com.byazt.mvx.n.l().n(str, str5, str6, null, str4);
                    com.byazt.wb.s.x().n(str, str5, str6, (JSONObject) null, str4);
                    com.byazt.rm.qg.n(str, str6, str4);
                }
                sVarN.n(str, str2, str3, str4, str5, str7, jSONObject, new com.byazt.rs.n() { // from class: com.byazt.hm.n.1.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject2) throws JSONException {
                        if (jSONObject2 != null) {
                            jSONObject2.putOpt("plugin_version_name", "7.8.1.4");
                        }
                        JSONObject jSONObjectN = nVar != null ? nVar.n(jSONObject2) : null;
                        if (jSONObjectN == null) {
                            jSONObjectN = new JSONObject();
                        }
                        String strX = com.byazt.wq.qg.n().x();
                        if (!TextUtils.isEmpty(strX)) {
                            jSONObjectN.put("live_plugin_version", strX.replaceAll("\\.", ""));
                        }
                        if (com.byazt.vyf.s.cy().w()) {
                            jSONObjectN.putOpt("first_of_two", 1);
                        }
                        try {
                            jSONObjectN.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q())));
                        } catch (Throwable unused) {
                        }
                        jSONObjectN.put("sdk_boost_type", com.byazt.gv.n.l());
                        jSONObjectN.put("csj_type", com.byazt.vyf.s.cy().oj() ? 1 : 0);
                        if (!TextUtils.isEmpty(com.byazt.vgx.w.rv)) {
                            jSONObjectN.put("wrong_stats_url", com.byazt.vgx.w.rv);
                        }
                        if (!TextUtils.isEmpty(com.byazt.vgx.w.tj)) {
                            jSONObjectN.put("wrong_applog_url", com.byazt.vgx.w.tj);
                        }
                        com.byazt.xf.n.n().n(jSONObjectN);
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN);
                        com.byazt.twu.q.n(str, jSONObject2);
                        try {
                            com.byazt.pnm.w wVarXk = rv.qg().xk();
                            if (wVarXk != null && wVarXk.x() && com.byazt.vzq.s.s()) {
                                ((com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new")).n(str, jSONObject2.toString());
                            }
                        } catch (Throwable th) {
                            k.qg("AdEventManager", "pitaya onAppLogEvent error:" + th.getMessage());
                        }
                        return jSONObjectN;
                    }
                });
            }
        });
    }

    public static void n(String str, String str2, String str3, String str4, com.byazt.rs.n nVar) {
        n(str2, str, (String) null, str4, str3, (String) null, (String) null, (JSONObject) null, nVar);
    }

    public static void n(pk pkVar, String str, String str2, com.byazt.rs.n nVar) {
        if (pkVar == null) {
            return;
        }
        n(str2, str, (String) null, pkVar.F_(), pkVar.q(), pkVar.ou(), (String) null, (JSONObject) null, nVar);
    }

    public static void n(pk pkVar, String str, String str2, JSONObject jSONObject, com.byazt.rs.n nVar) {
        if (pkVar == null) {
            return;
        }
        n(str2, str, (String) null, pkVar.F_(), pkVar.q(), pkVar.ou(), (String) null, jSONObject, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(pk pkVar, String str, JSONObject jSONObject) throws JSONException {
        com.byazt.zq.qg qgVarXd;
        if (tj.fs() && (qgVarXd = pkVar.xd()) != null) {
            String strOa = qgVarXd.oa();
            if (TextUtils.isEmpty(strOa)) {
                return;
            }
            jSONObject.putOpt("media_extra", strOa);
        }
    }

    public static void n(final pk pkVar, String str, String str2, final JSONObject jSONObject) {
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.12
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.aci.n.n(jSONObject3, pkVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void n(final pk pkVar, String str, String str2, final Map<String, Object> map) {
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.22
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                if (map == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(final pk pkVar, final String str, final Map<String, Object> map) {
        com.byazt.ag.qg.n((Runnable) new x("repost_show_check") { // from class: com.byazt.hm.n.33
            @Override // java.lang.Runnable
            public void run() {
                if (pkVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.byazt.vgx.w.um(pkVar)).floatValue();
                n.n(pkVar, str, "show_check", new com.byazt.rs.n() { // from class: com.byazt.hm.n.33.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.byazt.ehw.n.n(rv.getContext(), com.byazt.za.tj.n(str)).toString());
                        jSONObject2.put("is_cache", pkVar.wn() ? 1 : 0);
                        jSONObject2.put("cache_type", pkVar.oa(pkVar.wn()));
                        com.byazt.fxc.s.n(pkVar, jSONObject2, false);
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - com.byazt.vyf.l.l);
                        jSONObject2.put("start_type", !com.byazt.vyf.l.qg.get() ? 1 : 0);
                        jSONObject2.put("show_count", n.n);
                        jSONObject2.put("can_use_sensor", com.byazt.vyf.s.cy().l());
                        jSONObject2.put("is_shake_ads", com.byazt.vyf.s.cy().um());
                        jSONObject2.put("direction", com.byazt.hnb.qg.n().w());
                        n.w(pkVar, str, jSONObject2);
                        com.byazt.aci.n.n(jSONObject2, pkVar);
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

    public static void n(final pk pkVar, final String str, final Map<String, Object> map, final Double d) {
        if (pkVar != null) {
            com.byazt.de.qg.n().n(pkVar.h(), new com.byazt.bok.qg.n() { // from class: com.byazt.hm.n.40
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).cp = 1;
                    }
                }
            });
        }
        com.byazt.ag.qg.n(new x("report_show") { // from class: com.byazt.hm.n.41
            @Override // java.lang.Runnable
            public void run() {
                n.qg(pkVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    @JProtect
    public static void qg(final pk pkVar, final String str, final Map<String, Object> map, final Double d) {
        if (pkVar == null) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.byazt.vgx.w.um(pkVar)).floatValue();
        com.byazt.vf.x xVar = (com.byazt.vf.x) com.byazt.qp.q.n("armor_service");
        final String strN = xVar != null ? xVar.n(str, ((oa) com.byazt.qp.q.n("device_info_new")).v(), com.byazt.vgx.w.cy(pkVar), com.byazt.byp.qg.n()) : null;
        pkVar.kx().s();
        n++;
        n(pkVar, str, "show", new com.byazt.rs.n() { // from class: com.byazt.hm.n.42
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.ehw.n.n(rv.getContext(), com.byazt.za.tj.n(str)).toString());
                jSONObject2.put("is_cache", pkVar.wn() ? 1 : 0);
                pk pkVar2 = pkVar;
                jSONObject2.put("cache_type", pkVar2.oa(pkVar2.wn()));
                com.byazt.fxc.s.n(pkVar, jSONObject2, true);
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - com.byazt.vyf.l.l);
                jSONObject2.put("start_type", !com.byazt.vyf.l.qg.get() ? 1 : 0);
                jSONObject2.put("show_count", n.n);
                String strL = com.byazt.vyf.s.cy().l();
                if (!TextUtils.isEmpty(strL)) {
                    jSONObject2.put("can_use_sensor", strL);
                }
                if (rv.qg().u()) {
                    jSONObject2.put("mcod", "-1");
                } else if (!com.byazt.vyf.s.cy().tj()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!com.byazt.vyf.s.cy().x()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", com.byazt.vyf.s.cy().um());
                jSONObject2.put("direction", com.byazt.hnb.qg.n().w());
                n.w(pkVar, str, jSONObject2);
                String str2 = strN;
                if (str2 != null) {
                    com.byazt.okk.s.n(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.byazt.wq.qg.n().s());
                com.byazt.aci.n.n(jSONObject2, pkVar);
                if (com.byazt.aci.n.q(pkVar) || com.byazt.aci.n.n(pkVar)) {
                    String strRv = com.byazt.aci.n.rv(pkVar);
                    if (com.byazt.ts.qg.n().n(strRv)) {
                        jSONObject2.put("simple_uttie_url", strRv);
                    }
                }
                jSONObject2.put("shakeLiSize", com.byazt.tk.q.n(rv.getContext()).n());
                if (pkVar.hy()) {
                    jSONObject2.put("reward_show_type", pkVar.ev());
                    jSONObject2.put("browse_time", pkVar.ii());
                }
                n.n(jSONObject2);
                pkVar.kx().n(jSONObject2, true);
                JSONObject jSONObjectDc = pkVar.dc();
                if (jSONObjectDc != null) {
                    com.byazt.vgx.w.n(pkVar, jSONObjectDc);
                    jSONObject2.putOpt("applist_info", jSONObjectDc);
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.byazt.wb.s.x().n(pkVar, fFloatValue);
                String strFb = pkVar.fb();
                if (!TextUtils.isEmpty(strFb)) {
                    try {
                        double d2 = Double.parseDouble(strFb);
                        if (d2 <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return jSONObject2;
                        }
                        jSONObject.put("ttdsp_price", d2);
                    } catch (Throwable unused) {
                        jSONObject.put("ttdsp_price", 0);
                    }
                }
                n(pkVar, d, jSONObject);
                return jSONObject2;
            }

            public void n(pk pkVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapWl = pkVar2.wl();
                    if (mapWl == null || (obj = mapWl.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (pkVar2.ax() && (obj2 = mapWl.get(e.a.h)) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String strN2 = com.byazt.ehw.l.n();
        List<String> listDb = pkVar.db();
        if (!TextUtils.isEmpty(strN2)) {
            HashMap map2 = new HashMap();
            map2.put("aid", pkVar.wm());
            map2.put("cid", pkVar.q());
            map2.put("req_id", pkVar.ou());
            map2.put("customer_id", com.byazt.vgx.w.cd(pkVar));
            com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(strN2, listDb, true, map2, n(pkVar, str, "show"));
        } else if (listDb != null && listDb.size() != 0) {
            n(pkVar, listDb, str, "no did", "show");
        }
        if (n % 5 == 0 && com.byazt.orb.n.n() != null) {
            com.byazt.orb.n.n().qg("AdShow" + System.currentTimeMillis());
        }
        if (com.byazt.wq.qg.n().w(pkVar)) {
            com.byazt.eji.s.n().n(pkVar);
            com.byazt.gks.n.n(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, pkVar, 0L);
            q(pkVar, str);
        }
        com.byazt.vgx.w.s();
        com.byazt.hnb.n.n(pkVar.mk());
        if (pkVar != null) {
            com.byazt.wq.qg.n().q();
        }
        com.byazt.vyf.s.cy().s().q();
        com.byazt.cl.s.n(n, 1);
        com.byazt.vyf.qg.n().qg(pkVar);
        com.byazt.wb.s.x().tj();
    }

    private static void q(pk pkVar, String str) {
        if (pkVar == null) {
            return;
        }
        try {
            if (rv.qg().ep()) {
                String strPy = pkVar.py();
                if (TextUtils.isEmpty(strPy)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("union_session_key", strPy);
                com.byazt.uad.n.n(strPy, "ToutiaoJSBridge", "ad_show", jSONObject);
            }
        } catch (Throwable th) {
            k.qg("AdEvent", "dispatchAdShowToWebviewQueueIfNeed error:" + th.getMessage());
        }
    }

    private static void n(pk pkVar, List<String> list, String str, String str2, String str3) {
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
            jSONObject.put(ImagesContract.URL, sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        n(str, pkVar.q(), pkVar.F_(), jSONObject);
    }

    public static void n(final pk pkVar, final String str, final long j) {
        n(pkVar, str, "download_creative_duration", new com.byazt.rs.n() { // from class: com.byazt.hm.n.43
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.ehw.n.n(rv.getContext(), com.byazt.za.tj.n(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(final String str, pk pkVar, String str2, final int i, final Map<String, Long> map) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str2, "ad_show_time", new com.byazt.rs.n() { // from class: com.byazt.hm.n.44
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("source", Integer.valueOf(i));
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        jSONObject2.putOpt((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                jSONObject.put(MediationConstant.EXTRA_DURATION, str);
                return jSONObject2;
            }
        });
    }

    public static void n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("tag");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String strOptString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        n(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void n(String str, String str2, String str3, final JSONObject jSONObject) {
        n(str, "show_url", str2, str3, new com.byazt.rs.n() { // from class: com.byazt.hm.n.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void n(final pk pkVar, final String str) {
        String strQg;
        if (pkVar == null || str == null || (strQg = com.byazt.vgx.w.qg(pkVar)) == null) {
            return;
        }
        n(pkVar, strQg, "page_on_create", new com.byazt.rs.n() { // from class: com.byazt.hm.n.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("page_name", str);
                com.byazt.okk.s.n(jSONObject2, "");
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    @JProtect
    public static void n(String str, final pk pkVar, final com.byazt.gct.rv rvVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2, final boolean z3) {
        if (pkVar == null || z2) {
            return;
        }
        if ("click".equals(str)) {
            com.byazt.de.qg.n().n(pkVar.h(), new com.byazt.bok.qg.n() { // from class: com.byazt.hm.n.4
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).d = 1;
                    }
                }
            });
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.byazt.vgx.w.um(pkVar)).floatValue();
        n(pkVar, str2, str, new com.byazt.rs.n() { // from class: com.byazt.hm.n.5
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObjectN;
                com.byazt.gct.rv rvVar2 = rvVar;
                if (rvVar2 != null) {
                    jSONObjectN = rvVar2.n(pkVar);
                    jSONObjectN.put("device", com.byazt.ehw.n.n(rv.getContext(), com.byazt.za.tj.n(str2)).toString());
                    jSONObjectN.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectN.put("user_behavior_type", i2);
                    }
                    com.byazt.okk.s.n(jSONObjectN, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectN.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    n.w(pkVar, str2, jSONObjectN);
                    jSONObjectN.putOpt("obm_convert", um.qg(pkVar));
                    jSONObjectN.put("can_use_sensor", com.byazt.vyf.s.cy().l());
                    if (rv.qg().u()) {
                        jSONObjectN.put("mcod", "-1");
                    } else if (!com.byazt.vyf.s.cy().tj()) {
                        jSONObjectN.put("mcod", "0");
                    }
                    if (!com.byazt.vyf.s.cy().x()) {
                        jSONObjectN.put("od", "0");
                    }
                    jSONObjectN.put("is_shake_ads", com.byazt.vyf.s.cy().um());
                    jSONObjectN.put("live_sdk_config", com.byazt.wq.qg.n().fs());
                    jSONObjectN.put("direction", com.byazt.hnb.qg.n().w());
                    jSONObjectN.put("is_cache", pkVar.wn() ? 1 : 0);
                    pk pkVar2 = pkVar;
                    jSONObjectN.put("cache_type", pkVar2.oa(pkVar2.wn()));
                    com.byazt.fxc.s.n(pkVar, jSONObjectN, false);
                    jSONObjectN.put("source", z3 ? 1 : 0);
                    com.byazt.aci.n.n(jSONObjectN, pkVar);
                    com.byazt.cd.n.n(jSONObjectN, pkVar);
                    n.n(jSONObjectN);
                    if (pkVar.hy()) {
                        jSONObjectN.put("reward_show_type", pkVar.ev());
                        jSONObjectN.put("browse_time", pkVar.ii());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN.toString());
                } else {
                    jSONObjectN = null;
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                return jSONObjectN;
            }
        });
        String strN = com.byazt.ehw.l.n();
        List<String> listOv = pkVar.ov();
        if (!TextUtils.isEmpty(strN) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", pkVar.wm());
            map2.put("cid", pkVar.q());
            map2.put("req_id", pkVar.ou());
            map2.put("customer_id", com.byazt.vgx.w.cd(pkVar));
            com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(strN, listOv, true, map2, n(pkVar, str2, "click"));
        } else if (listOv != null && listOv.size() != 0 && "click".equals(str)) {
            n(pkVar, listOv, str2, "no did", "click");
        }
        if (TextUtils.equals("click", str)) {
            if (com.byazt.gks.n.n(pkVar)) {
                com.byazt.gks.n.n(LiveMetrics.EVENT_LIVESDK_REC_LIVE_PLAY, pkVar, 0L);
            }
            com.byazt.wq.qg.n().q(pkVar);
        }
        com.byazt.cl.s.n(1, 2);
    }

    public static JSONObject n(pk pkVar, String str, String str2) {
        return n(pkVar.F_(), pkVar.q(), pkVar.ou(), str, str2);
    }

    public static JSONObject n(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void qg(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void n(final pk pkVar, String str, String str2, final long j) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.6
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject2.put("rom_new_version", com.byazt.ehw.rv.sz());
                jSONObject2.put("is_background", com.byazt.vyf.s.cy().n());
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(com.byazt.oj.qg qgVar, com.byazt.fvm.w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        rv.n().n(qgVar, arrayList);
    }

    public static void qg(pk pkVar, String str) {
        if (pkVar != null) {
            com.byazt.oj.s sVar = new com.byazt.oj.s();
            sVar.n("0:00");
            sVar.qg(str);
            com.byazt.wb.s.x().n("skip", pkVar.q(), pkVar.ou(), pkVar.A_(), (String) null);
            n(pkVar.pt(), sVar);
        }
    }

    public static void n(Context context, pk pkVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || pkVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt(com.anythink.core.common.f.e.a.d);
        if (objOpt == null) {
            objOpt = pkVar.q();
        }
        String strOptString = jSONObject.optString("category");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "app_union";
        }
        String str3 = strOptString;
        Object objOpt2 = jSONObject.opt("log_extra");
        if (objOpt2 == null) {
            objOpt2 = pkVar.F_();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(hd.s(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.8.1.4");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            k.n(e.getMessage());
        }
        n(str2, str, str3, objOpt2 != null ? objOpt2.toString() : "", objOpt == null ? "" : objOpt.toString(), (String) null, (String) null, jSONObject, (com.byazt.rs.n) null);
    }

    public static void n(final long j, final pk pkVar) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, "splash_ad", "skip", new com.byazt.rs.n() { // from class: com.byazt.hm.n.7
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(final pk pkVar, String str, final JSONObject jSONObject) {
        n(pkVar, com.byazt.vgx.w.qg(pkVar), str, new com.byazt.rs.n() { // from class: com.byazt.hm.n.8
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.aci.n.n(jSONObject3, pkVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
                return jSONObject;
            }
        });
    }

    public static void qg(pk pkVar, String str, final JSONObject jSONObject) {
        n(pkVar, com.byazt.vgx.w.qg(pkVar), str, new com.byazt.rs.n() { // from class: com.byazt.hm.n.9
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3);
                }
                return jSONObject;
            }
        });
    }

    public static void s(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void q(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void l(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void n(final pk pkVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.10
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject.put("percent", i);
                if (map == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(final pk pkVar, final int i) {
        n(pkVar, com.byazt.vgx.w.qg(pkVar), "reward_callback", new com.byazt.rs.n() { // from class: com.byazt.hm.n.11
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_show_type", pkVar.ev());
                jSONObject2.put("browse_time", pkVar.ii());
                jSONObject2.put("reward_action_type", i);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void qg(final pk pkVar, final int i) {
        if (pkVar.hy()) {
            n(pkVar, com.byazt.vgx.w.qg(pkVar), "reward_task_diff", new com.byazt.rs.n() { // from class: com.byazt.hm.n.13
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("reward_show_type", pkVar.ev());
                    jSONObject2.put("reward_action_type", i);
                    jSONObject2.put("task_action", pkVar.ev() == i ? 0 : 1);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    public static void n(final pk pkVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.14
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.byazt.aci.n.n(jSONObject, pkVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void qg(pk pkVar, String str, String str2, final long j) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.15
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, j);
                return null;
            }
        });
    }

    public static void qg(final pk pkVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.16
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.byazt.aci.n.n(jSONObject, pkVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void s(final pk pkVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.17
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.byazt.aci.n.n(jSONObject, pkVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void w(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void n(String str, String str2, String str3, String str4) {
        n(str4, str3, (String) null, str2, str, (String) null, (String) null, (JSONObject) null, (com.byazt.rs.n) null);
    }

    public static void x(pk pkVar, String str, String str2, Map<String, Object> map) {
        n(pkVar, str, str2, map);
    }

    public static void qg(pk pkVar, String str, String str2) {
        n(pkVar, str, str2, (com.byazt.rs.n) null);
    }

    public static void s(pk pkVar, String str, String str2) {
        n(pkVar, str, str2, (com.byazt.rs.n) null);
    }

    public static void qg(pk pkVar, String str, String str2, JSONObject jSONObject) {
        n(pkVar, str, str2, jSONObject);
    }

    public static void qg(pk pkVar, String str, long j) {
        String str2;
        if (rv.qg().ei()) {
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
            n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.18
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    jSONObject.put(MediationConstant.EXTRA_DURATION, jCurrentTimeMillis);
                    return null;
                }
            });
        }
    }

    public static void fs(pk pkVar, String str, String str2, Map<String, Object> map) {
        wv wvVarJ_ = pkVar.J_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (wvVarJ_ != null) {
            map.put("wc_type", Integer.valueOf(wvVarJ_.l()));
        }
        map.put("rom_new_version", com.byazt.ehw.rv.sz());
        map.put("is_background", Boolean.valueOf(com.byazt.vyf.s.cy().n()));
        map.put("interaction_type", Integer.valueOf(pkVar.rv()));
        map.put("can_query", Boolean.valueOf(com.byazt.vgx.w.h()));
        n(pkVar, str, str2, map);
    }

    public static void rv(pk pkVar, String str, String str2, Map<String, Object> map) {
        wv wvVarJ_ = pkVar.J_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (wvVarJ_ != null) {
            map.put("wc_type", Integer.valueOf(wvVarJ_.l()));
        }
        map.put("rom_new_version", com.byazt.ehw.rv.sz());
        map.put("is_background", Boolean.valueOf(com.byazt.vyf.s.cy().n()));
        map.put("interaction_type", Integer.valueOf(pkVar.rv()));
        map.put("can_query", Boolean.valueOf(com.byazt.vgx.w.h()));
        n(pkVar, str, str2, map);
    }

    public static void n(pk pkVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.byazt.aci.n.n(jSONObject, pkVar);
            }
        } catch (Throwable unused) {
        }
        n(pkVar, str, str2, new com.byazt.rs.n() { // from class: com.byazt.hm.n.19
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                return jSONObject;
            }
        });
    }

    public static void n(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject, final byte b) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.byazt.vgx.w.w(jSONObject.optString("log_extra"))).floatValue();
        n(str3, str2, str, (String) null, String.valueOf(j), (String) null, String.valueOf(j2), jSONObject, new com.byazt.rs.n() { // from class: com.byazt.hm.n.20
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.byazt.ehw.n.n(rv.getContext(), com.byazt.za.tj.n(str2)).toString());
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

    public static void s(pk pkVar, String str, String str2, JSONObject jSONObject) {
        if (pkVar == null) {
            return;
        }
        n(str2, str, (String) null, pkVar.F_(), pkVar.q(), (String) null, (String) null, jSONObject, (com.byazt.rs.n) null);
    }

    public static void n(pk pkVar, String str, Map<String, Object> map, boolean z) {
        if (z) {
            n(pkVar, str, "lp_open_dpl", map);
            return;
        }
        wv wvVarJ_ = pkVar.J_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (wvVarJ_ != null) {
            map.put("wc_type", Integer.valueOf(wvVarJ_.l()));
        }
        map.put("rom_new_version", com.byazt.ehw.rv.sz());
        map.put("is_background", Boolean.valueOf(com.byazt.vyf.s.cy().n()));
        map.put("interaction_type", Integer.valueOf(pkVar.rv()));
        map.put("can_query", Boolean.valueOf(com.byazt.vgx.w.h()));
        n(pkVar, str, "open_url_app", map);
    }

    public static void n(pk pkVar, String str, Throwable th, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                n(pkVar, str, "lp_openurl", th);
                n(pkVar, str, "lp_deeplink_success_realtime", th);
                return;
            } else {
                n(pkVar, str, "deeplink_success_realtime", th);
                return;
            }
        }
        if (z) {
            n(pkVar, str, "lp_openurl_failed", th);
            n(pkVar, str, "lp_deeplink_fail_realtime", th);
        } else {
            n(pkVar, str, "deeplink_fail_realtime", th);
        }
    }

    public static void n(pk pkVar, String str, String str2, Throwable th) {
        wv wvVarJ_ = pkVar.J_();
        JSONObject jSONObject = null;
        if (wvVarJ_ != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", wvVarJ_.l());
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
        n(pkVar, str, str2, jSONObject);
    }

    public static void n(final long j, String str, pk pkVar) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, "open_appback", new com.byazt.rs.n() { // from class: com.byazt.hm.n.21
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                return null;
            }
        });
        com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
        lVarS.n("save_jump_success_time", 0L);
        lVarS.n("save_jump_success_ad_tag", "");
    }

    public static void n(final pk pkVar) {
        n(pkVar, "landingpage", "open_url_h5", new com.byazt.rs.n() { // from class: com.byazt.hm.n.23
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    public static void s(final pk pkVar, String str, final long j) {
        n(pkVar, str, "load", new com.byazt.rs.n() { // from class: com.byazt.hm.n.24
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.aci.n.n(jSONObject2, pkVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put(MediationConstant.EXTRA_DURATION, Math.min(j, 600000L));
                return jSONObject2;
            }
        });
    }

    public static void q(pk pkVar, String str, final long j) {
        n(pkVar, str, "render_live_picture_success", new com.byazt.rs.n() { // from class: com.byazt.hm.n.25
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(pk pkVar, String str, final int i, final String str2) {
        n(pkVar, str, "render_live_picture_fail", new com.byazt.rs.n() { // from class: com.byazt.hm.n.26
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(pk pkVar, String str, final long j, final String str2) {
        n(pkVar, str, "live_play_success", new com.byazt.rs.n() { // from class: com.byazt.hm.n.27
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(f.bo, str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(pk pkVar, String str, final int i, final String str2, final String str3) {
        n(pkVar, str, "live_play_fail", new com.byazt.rs.n() { // from class: com.byazt.hm.n.28
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt(f.bo, str3);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(pk pkVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        n(pkVar, str, "live_play_close", new com.byazt.rs.n() { // from class: com.byazt.hm.n.29
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt(f.bo, str2);
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                return jSONObject;
            }
        });
    }

    public static void n(final pk pkVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (pkVar != null && pkVar.gf() == 1) {
            n(pkVar, str, "open_live", new com.byazt.rs.n() { // from class: com.byazt.hm.n.30
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int iL = pkVar.l();
                    jSONObject2.put("live_interaction_type", iL);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", com.byazt.gct.e.qg(pkVar));
                    jSONObject2.put("is_inner", z);
                    ic icVarL_ = pkVar.L_();
                    if (pkVar.l() == 9 && pkVar.M_() != null) {
                        icVarL_ = pkVar.M_().q();
                    }
                    if (icVarL_ != null) {
                        jSONObject2.putOpt("saas_info", icVarL_.n());
                    }
                    com.byazt.gct.hd hdVarSz = pkVar.sz();
                    if (hdVarSz != null) {
                        String strQg = hdVarSz.qg();
                        if (hdVarSz != null && strQg.length() > 500) {
                            strQg = strQg.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", strQg);
                        if (!strQg.startsWith("snssdk1128") && !strQg.startsWith("snssdk2329") && iL == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    public static void n(final pk pkVar, String str, final int i) {
        n(pkVar, str, "qpon_join", new com.byazt.rs.n() { // from class: com.byazt.hm.n.31
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("join_status", i);
                    com.byazt.aci.n.n(jSONObject2, pkVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void qg(final pk pkVar, String str, final int i) {
        n(pkVar, str, "qpon_apply", new com.byazt.rs.n() { // from class: com.byazt.hm.n.32
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("qpon_apply_status", i);
                    com.byazt.aci.n.n(jSONObject2, pkVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void s(pk pkVar, String str, final JSONObject jSONObject) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        n(pkVar, str, "cache_correct_details", new com.byazt.rs.n() { // from class: com.byazt.hm.n.34
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void qg(long j, final pk pkVar) {
        if (pkVar != null && pk.s(pkVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            n(pkVar, "splash_ad", "play_duration_sum", new com.byazt.rs.n() { // from class: com.byazt.hm.n.35
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.byazt.aci.n.n(jSONObject2, pkVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return jSONObject2;
                }
            });
        }
    }

    public static void n(final int i, String str, final pk pkVar) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, "saas_auth", new com.byazt.rs.n() { // from class: com.byazt.hm.n.36
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                ic icVarL_ = pkVar.L_();
                if (icVarL_ != null) {
                    jSONObject2.put("saas_auth_type", icVarL_.qg());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void n(String str, pk pkVar) {
        if (pkVar == null) {
            return;
        }
        n(pkVar, str, "ec_mall_task", new com.byazt.rs.n() { // from class: com.byazt.hm.n.37
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
    }

    public static void q(pk pkVar, String str, final JSONObject jSONObject) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        n(pkVar, str, "splash_ad_showstat", new com.byazt.rs.n() { // from class: com.byazt.hm.n.38
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                return jSONObject;
            }
        });
    }

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
            jSONObject2.put("isCanUseLocation", rvVarHd.n());
            jSONObject2.put("isCanUsePhoneState", rvVarHd.q());
            jSONObject2.put("isCanUseWifiState", rvVarHd.w());
            jSONObject2.put("isCanUseWriteExternal", rvVarHd.fs());
            jSONObject2.put("alist", rvVarHd.s());
            jSONObject2.put("isCanUseAndroidId", rvVarHd.tj());
            jSONObject2.put("isCanUsePermissionRecordAudio", rvVarHd.sz());
            Map<String, Object> mapD = rvVarHd.d();
            if (mapD != null && !mapD.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : mapD.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (TextUtils.equals(key, "mcod") && rv.qg().u()) {
                        jSONObject3.put(key, "-1");
                    } else {
                        jSONObject3.put(key, value);
                    }
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static void s(final pk pkVar, String str) {
        n(pkVar, str, "cache_ana_upload", new com.byazt.rs.n() { // from class: com.byazt.hm.n.39
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                pkVar.kx().n(jSONObject2, false);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }
}
