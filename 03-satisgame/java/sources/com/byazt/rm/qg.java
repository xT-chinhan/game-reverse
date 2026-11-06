package com.byazt.rm;

import android.os.Handler;
import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 26})
public class qg {
    public static volatile JSONArray n;
    public static volatile Set<String> qg;

    public static void n(final String str, final String str2, final String str3) {
        if (!TextUtils.isEmpty(str) && n(str)) {
            n(new Runnable() { // from class: com.byazt.rm.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strOptString = str2;
                        int iOptInt = 0;
                        if (!TextUtils.isEmpty(str3)) {
                            JSONObject jSONObject = new JSONObject(str3);
                            iOptInt = jSONObject.optInt("ad_slot_type", 0);
                            if (TextUtils.isEmpty(strOptString)) {
                                strOptString = jSONObject.optString("req_id");
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("event_source", 2);
                        jSONObject2.putOpt("type", str);
                        jSONObject2.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("req_id", strOptString);
                        jSONObject3.putOpt("ad_slot_type", Integer.valueOf(iOptInt));
                        jSONObject2.putOpt("ad_info", jSONObject3);
                        com.byazt.aun.q.n().n(jSONObject2);
                    } catch (Throwable th) {
                        com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
                    }
                }
            });
        }
    }

    public static void n(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n(new Runnable() { // from class: com.byazt.rm.qg.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("event_source", 5);
                    jSONObject2.putOpt("type", str);
                    jSONObject2.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
                    qg.qg(jSONObject2, jSONObject);
                    com.byazt.aun.q.n().n(jSONObject2);
                } catch (Throwable th) {
                    com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
                }
            }
        });
    }

    public static void n(com.byazt.zq.qg qgVar, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("event_source", 3);
            jSONObject.putOpt("type", "device_snapshot");
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("device", com.byazt.kld.n.n());
            com.byazt.aun.q.n().n(jSONObject);
        } catch (Throwable th) {
            com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("event_source", 4);
            jSONObject2.putOpt("type", "runtime_snapshot");
            jSONObject2.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("runtime", qg(qgVar, i));
            com.byazt.aun.q.n().n(jSONObject2);
        } catch (Throwable th2) {
            com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th2);
        }
    }

    private static JSONObject qg(com.byazt.zq.qg qgVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("start_type", Integer.valueOf(com.byazt.vyf.l.qg.get() ? 0 : 1));
            jSONObject.putOpt("session_ad_index", Long.valueOf(DeviceUtils.n.get()));
            if (qgVar != null) {
                jSONObject.putOpt("show_time", Float.valueOf(com.byazt.wb.s.x().n(qgVar.q())));
            }
            jSONObject.putOpt("sdk_init_timestamp", Long.valueOf(com.byazt.wb.s.x().w()));
            jSONObject.putOpt("app_cold_startup_time", Long.valueOf(com.byazt.wb.s.x().l()));
            long jS = com.byazt.wb.n.s();
            jSONObject.putOpt("app_total_7_duration", Long.valueOf(com.byazt.wb.n.q() + jS));
            jSONObject.putOpt("app_use_7_duration", Long.valueOf(jS));
            jSONObject.putOpt("start_session", Integer.valueOf(com.byazt.wb.n.l()));
            jSONObject.putOpt(h.b.c, Integer.valueOf(i));
        } catch (Throwable th) {
            com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                try {
                    jSONObject.putOpt(next, jSONObject2.opt(next));
                } catch (Throwable th) {
                    com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
                }
            }
        }
    }

    private static void n(Runnable runnable) {
        Handler handlerN = q.n();
        if (handlerN == null) {
            return;
        }
        handlerN.post(runnable);
    }

    private static boolean n(String str) {
        try {
            Set<String> setN = n();
            if (setN.contains("*")) {
                return true;
            }
            return setN.contains(str);
        } catch (Throwable th) {
            com.byazt.hm.w.n("s_feature_data_v2", (JSONObject) null, th);
            return true;
        }
    }

    private static Set<String> n() {
        JSONArray jSONArrayXd = rv.qg() != null ? rv.qg().xd() : null;
        if (jSONArrayXd == null) {
            return com.byazt.aun.qg.n;
        }
        Set<String> set = qg;
        if (set != null && n == jSONArrayXd) {
            return set;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArrayXd.length(); i++) {
            String strOptString = jSONArrayXd.optString(i, null);
            if (!TextUtils.isEmpty(strOptString)) {
                hashSet.add(strOptString);
            }
        }
        n = jSONArrayXd;
        qg = hashSet;
        return hashSet;
    }
}
