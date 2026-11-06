package com.byazt.wv;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.km.cp;
import com.byazt.ko.fs;
import com.byazt.ko.rv;
import com.byazt.ni.Collector;
import com.byazt.vf.oj;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 121, 19})
public final class n {
    public static volatile l fs = null;
    public static volatile fs l = null;
    public static rv n = null;
    public static s q = null;
    public static boolean qg = true;
    public static ConcurrentHashMap<String, String> s = new ConcurrentHashMap<>(4);
    public static boolean w = true;
    public static boolean x = false;

    public static boolean fs() {
        return true;
    }

    public static void n(Context context, x xVar) {
        Application application;
        if (l != null) {
            cp.qg(new RuntimeException("Init Twice!"));
            return;
        }
        if (xVar.v() == null) {
            cp.qg(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        } else {
            Context context2 = ((oj) com.byazt.qp.q.n("system_context")).getContext();
            if (context2 instanceof Application) {
                application = (Application) context2;
            } else {
                final String str = "application not found!";
                cp.qg(new RuntimeException("application not found!"));
                ((com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(xVar.ur()))).n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.wv.n.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("exception", str);
                        jSONObject2.putOpt("scene", "applog_init");
                        return jSONObject2;
                    }
                });
                return;
            }
        }
        com.byazt.fo.q qVarL = com.byazt.fo.q.l();
        fs fsVar = new fs(application, xVar);
        l = fsVar;
        rv rvVar = new rv(application, fsVar);
        qVarL.n(application, fsVar, rvVar, new com.byazt.ni.n(xVar.rv()));
        n = rvVar;
        if (l.hd()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        cp.q("Inited", null);
    }

    public static void n(boolean z) {
        qg = z;
    }

    public static void n() {
        rv rvVar;
        if (!qg || (rvVar = n) == null) {
            return;
        }
        rvVar.q();
    }

    public static void qg() {
        com.byazt.fo.q.n();
    }

    public static l s() {
        return fs;
    }

    public static s q() {
        return q;
    }

    public static void n(HashMap<String, Object> map) {
        rv rvVar = n;
        if (rvVar != null) {
            rvVar.n(map);
        }
    }

    public static String l() {
        rv rvVar = n;
        if (rvVar != null) {
            return rvVar.sz();
        }
        return null;
    }

    public static JSONObject w() {
        if (l != null) {
            return l.a();
        }
        return null;
    }

    public static String x() {
        rv rvVar = n;
        return rvVar != null ? rvVar.fs() : "";
    }

    public static <T> T n(String str, T t) {
        rv rvVar = n;
        if (rvVar != null) {
            return (T) rvVar.n(str, t);
        }
        return null;
    }

    public static void n(String str, JSONObject jSONObject) {
        com.byazt.fo.q.n(new com.byazt.yi.l(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void n(String str, JSONObject jSONObject, int i) {
        com.byazt.fo.q.n(new com.byazt.yi.l(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void n(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cp.qg(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        n(str, jSONObject);
    }

    public static void n(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cp.qg(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        n(str, jSONObject, i);
    }

    public static void qg(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            cp.qg("call onEventData with invalid params, return", null);
            return;
        }
        try {
            com.byazt.fo.q.n(new com.byazt.yi.q(str, jSONObject));
        } catch (Exception e) {
            cp.s("call onEventData get exception: ", e);
        }
    }

    public static String rv() {
        rv rvVar = n;
        return rvVar != null ? rvVar.x() : "";
    }

    public static String tj() {
        rv rvVar = n;
        return rvVar != null ? rvVar.tj() : "";
    }

    public static String cp() {
        rv rvVar = n;
        return rvVar != null ? rvVar.cp() : "";
    }

    public static q d() {
        return com.byazt.km.qg.n();
    }

    public static void n(com.byazt.zve.s sVar) {
        com.byazt.yb.x.n(sVar);
    }

    public static void qg(com.byazt.zve.s sVar) {
        com.byazt.yb.x.qg(sVar);
    }

    public static x oa() {
        if (l != null) {
            return l.wo();
        }
        return null;
    }

    public static void sz() {
        com.byazt.fo.q.l().rv();
    }

    public static void k() {
        com.byazt.fo.q.l().tj();
    }
}
