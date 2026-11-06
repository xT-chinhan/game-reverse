package com.byazt.gp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.k;
import com.byazt.vy.cy;
import com.byazt.vy.hd;
import com.byazt.vy.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static volatile boolean n = false;
    public static final AtomicLong qg = new AtomicLong(0);
    public static long s;

    public static void n() {
        n = true;
    }

    public static boolean qg() {
        return n;
    }

    public static boolean s() {
        k kVar = (k) com.byazt.qp.q.n("encrypt_service");
        return (com.byazt.qt.qg.n().l() || kVar == null || !kVar.qg()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005b A[Catch: JSONException -> 0x0062, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0062, blocks: (B:7:0x0012, B:8:0x001a, B:10:0x0020, B:11:0x0034, B:13:0x005b), top: B:23:0x0012 }] */
    public static void n(Context context, final qg qgVar, Map<String, Object> map) {
        if (com.byazt.qt.qg.n().t()) {
            final JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("eventIndex", qg.getAndIncrement());
                    jSONObject.put("is_main_process", com.byazt.xc.qg.n());
                    jSONObject.put("is_cypher_v4", s());
                    if (com.byazt.qt.n.d().rv()) {
                        jSONObject.put("e2e_test_flag", "1");
                    }
                } catch (JSONException unused) {
                }
            } else {
                jSONObject.put("eventIndex", qg.getAndIncrement());
                jSONObject.put("is_main_process", com.byazt.xc.qg.n());
                jSONObject.put("is_cypher_v4", s());
                if (com.byazt.qt.n.d().rv()) {
                    jSONObject.put("e2e_test_flag", "1");
                }
            }
            if (qgVar != null) {
                qgVar.n("event_id", UUID.randomUUID().toString());
            }
            if (!n) {
                n.n().n(qgVar, jSONObject);
            } else {
                com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).n(qgVar.n, (byte) 3, new com.byazt.rs.n() { // from class: com.byazt.gp.tj.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject2) throws JSONException {
                        jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, qgVar.n);
                        jSONObject2.putOpt("params", tj.n(qgVar, jSONObject));
                        jSONObject2.putOpt("nt", Integer.valueOf(hd.qg()));
                        com.byazt.nc.s.n(jSONObject2);
                        return null;
                    }
                });
            }
        }
    }

    public static JSONObject n(qg qgVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", cy.n());
            if (qgVar != null) {
                jSONObject2.putOpt("type", qgVar.n);
                jSONObject2.putOpt("link_id", qgVar.qg);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, qgVar.s);
                jSONObject2.putOpt("ad_sdk_version", qgVar.q);
                jSONObject2.putOpt("rit_cpm", qgVar.x);
                if (!TextUtils.isEmpty(qgVar.fs)) {
                    jSONObject2.putOpt("discount", qgVar.fs);
                }
                jSONObject2.putOpt("mediation_rit", qgVar.w);
                jSONObject2.putOpt("adtype", Integer.valueOf(qgVar.cd));
                jSONObject2.putOpt("error_msg", qgVar.d);
                jSONObject2.putOpt("error_code", Integer.valueOf(qgVar.k));
                jSONObject2.putOpt("creative_id", qgVar.oa);
                jSONObject2.putOpt("exchange_rate", qgVar.ou);
                jSONObject2.putOpt("msdk_session_id", com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).qg());
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.byazt.qt.qg.n().qg()));
                String strQg = com.byazt.zs.n.n().qg(com.byazt.qt.qg.n().py());
                if (strQg != null) {
                    jSONObject2.putOpt("app_abtest", strQg);
                }
                qg(jSONObject2, qgVar);
                n(jSONObject2, qgVar);
                qg(qgVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(qgVar.n) && !"adapter_request_fail".equalsIgnoreCase(qgVar.n)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(qgVar.l) ? qgVar.qg + "_" + qgVar.w : qgVar.l);
                }
                jSONObject2.putOpt("country", com.byazt.qt.qg.n().cy());
                com.byazt.ws.n nVarN = com.byazt.qt.qg.n().n(MediationConstant.ADN_PANGLE);
                if (nVarN != null) {
                    jSONObject2.putOpt("app_id", nVarN.qg());
                } else {
                    jSONObject2.putOpt("app_id", com.byazt.qt.n.d().oa());
                }
                if (qgVar.tj != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(qgVar.tj));
                }
                if (!TextUtils.isEmpty(qgVar.cp)) {
                    jSONObject2.putOpt("version", qgVar.cp);
                }
                if (qgVar.wm != null && qgVar.wm.size() > 0) {
                    for (String str : qgVar.wm.keySet()) {
                        Object obj = qgVar.wm.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                String strQg2 = com.byazt.zs.n.n().qg(com.byazt.qt.qg.n().ou());
                if (strQg2 != null) {
                    jSONObject.putOpt("simple_app_abtest", strQg2);
                }
                jSONObject.putOpt("has_server_cache_config", Boolean.valueOf(com.byazt.qt.qg.n().wm()));
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt("app_version", hu.s());
            jSONObject2.putOpt("conn_type", Integer.valueOf(hd.qg()));
            s(jSONObject2, qgVar);
            jSONObject2.putOpt("mediation_sdk_version", com.byazt.sg.qg.n());
            jSONObject2.putOpt(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.sg.qg.s());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q())));
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
            }
        } catch (Throwable th) {
            try {
                n(jSONObject2, th, qgVar);
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    public static void qg(qg qgVar, JSONObject jSONObject) {
        if (qgVar != null) {
            if ("media_request".equals(qgVar.n) || "media_fill".equals(qgVar.n) || "media_fill_fail".equals(qgVar.n) || "get_bidding_adm_to_adn".equals(qgVar.n) || "bidding_adm_load".equals(qgVar.n) || "bidding_adm_load_fail".equals(qgVar.n) || "bidding_win_event".equals(qgVar.n) || "media_show_is_ready".equals(qgVar.n) || "media_will_show".equals(qgVar.n) || "media_show".equals(qgVar.n) || "media_show_fail".equals(qgVar.n) || "media_show_listen".equals(qgVar.n) || "media_show_fail_listen".equals(qgVar.n) || "media_click_listen".equals(qgVar.n) || "sdk_init".equals(qgVar.n) || "sdk_init_end".equals(qgVar.n) || "get_config_start".equals(qgVar.n) || "get_config_final".equals(qgVar.n) || "mediation_request".equals(qgVar.n) || "mediation_fill".equals(qgVar.n) || "mediation_request_end".equals(qgVar.n) || "total_load_fail".equals(qgVar.n)) {
                qgVar.n("grouping_params", com.byazt.ng.q.n(com.byazt.qt.n.d().py()));
                JSONObject jSONObjectQg = com.byazt.ng.q.qg(com.byazt.qt.n.d().py());
                if (jSONObjectQg != null) {
                    qgVar.n("user_defined_grouping_params", jSONObjectQg.toString());
                } else {
                    qgVar.n("user_defined_grouping_params", null);
                }
                com.byazt.cby.q.n(qgVar.rv, qgVar.n, qgVar.cd, jSONObject);
            }
        }
    }

    private static void n(JSONObject jSONObject, qg qgVar) throws JSONException {
        if (jSONObject == null || qgVar == null) {
            return;
        }
        if ("media_fill_fail".equals(qgVar.n) || "media_fill".equals(qgVar.n) || "bidding_adm_load".equals(qgVar.n) || "bidding_adm_load_fail".equals(qgVar.n) || "mediation_fill".equals(qgVar.n) || "mediation_request_end".equals(qgVar.n) || "mediation_video_cached".equals(qgVar.n) || "get_config_final".equals(qgVar.n) || "sdk_init_end".equals(qgVar.n) || "sdk_backstage".equals(qgVar.n) || "mediation_request".equals(qgVar.n) || "rit_map_query".equals(qgVar.n) || "media_reward_verify".equals(qgVar.n) || "dc_pic_url_fail".equals(qgVar.n) || "return_bidding_result".equals(qgVar.n)) {
            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(qgVar.um));
        }
    }

    private static void n(JSONObject jSONObject, Throwable th, qg qgVar) throws JSONException {
        if (jSONObject != null && th != null) {
            String strOptString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (qgVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", qgVar.wm.get("event_id"));
        jSONObject3.putOpt("err_msg_comm", th.toString());
    }

    private static void qg(JSONObject jSONObject, qg qgVar) throws JSONException {
        if (jSONObject == null || qgVar == null) {
            return;
        }
        if (qgVar.a != -1) {
            jSONObject.putOpt("result", Integer.valueOf(qgVar.a));
        }
        if (qgVar.py != -1) {
            jSONObject.putOpt("status_code", Integer.valueOf(qgVar.py));
        }
        if (qgVar.hd != null) {
            jSONObject.putOpt("show_sort", qgVar.hd);
        }
        if (qgVar.cy != null) {
            jSONObject.putOpt("load_sort", qgVar.cy);
        }
        if (qgVar.sz != null) {
            jSONObject.putOpt("req_bidding_type", qgVar.sz);
        }
        jSONObject.putOpt(MediationConstant.KEY_GM_PRIME_RIT, qgVar.rv);
    }

    private static void s(JSONObject jSONObject, qg qgVar) throws JSONException {
        if (jSONObject != null && qgVar != null) {
            if (TextUtils.equals(qgVar.n, "sdk_init")) {
                jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(com.byazt.jp.tj.qg()));
                return;
            }
            if (TextUtils.equals(qgVar.n, "start_up")) {
                jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(com.byazt.jp.tj.s()));
                return;
            } else if (qgVar.n() != -1) {
                jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(qgVar.n()));
                return;
            } else {
                jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
        jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
    }

    public static void n(Context context) {
        try {
            List<n.C0183n> listQg = n.n().qg();
            if (listQg != null) {
                for (n.C0183n c0183n : listQg) {
                    if (c0183n != null) {
                        n(context, c0183n.n(), c0183n.qg());
                    }
                }
            }
            n.n().s();
        } catch (Throwable unused) {
        }
    }

    private static void n(Context context, final qg qgVar, final JSONObject jSONObject) {
        com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).n(qgVar.n, (byte) 3, new com.byazt.rs.n() { // from class: com.byazt.gp.tj.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, qgVar.n);
                jSONObject2.putOpt("params", jSONObject);
                jSONObject2.putOpt("nt", Integer.valueOf(hd.qg()));
                com.byazt.nc.s.n(jSONObject2);
                return null;
            }
        });
    }

    public static void q() {
        com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).n(true);
    }

    public static void l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - s >= 3000) {
            if (qg()) {
                s = jCurrentTimeMillis;
                if (com.byazt.xc.qg.n()) {
                    com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).n(true);
                    return;
                } else {
                    w();
                    return;
                }
            }
            return;
        }
        com.byazt.rb.qg.qg(MediationConstant.TAG, "badkground too frequently ms: " + (jCurrentTimeMillis - s));
    }

    private static void w() {
        if (com.byazt.qt.qg.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(hu.n());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.byazt.qt.qg.getContext().sendBroadcast(intent, com.byazt.it.s.qg.n);
            } catch (Throwable unused) {
            }
        }
    }
}
