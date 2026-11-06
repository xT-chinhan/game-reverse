package com.byazt.ag;

import com.byazt.nf.tj;
import com.byazt.qit.rv;
import com.byazt.qp.q;
import com.byazt.vf.fi;
import com.byazt.vf.wo;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1760, 19})
public class n {
    public static volatile boolean n = false;
    public static boolean qg = false;

    public static void n() {
        if (qg) {
            return;
        }
        qg = true;
        rv rvVar = rv.qg;
        rvVar.n(11);
        rvVar.q(tj.n());
        rvVar.s(true);
        rvVar.n(true);
        rvVar.qg(true);
    }

    public static void qg() {
        JSONObject jSONObjectR = com.byazt.nf.rv.qg().r();
        fi fiVar = (fi) q.n("strategy");
        if (fiVar == null || (jSONObjectR = n(jSONObjectR, fiVar.n("c_s_s_performance_thread_pool", null))) != null) {
            ((wo) q.n("thread_service")).n(jSONObjectR);
            n = jSONObjectR.optBoolean("can_set_crash", true);
        }
    }

    private static JSONObject n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object objOpt = jSONObject2.opt(next);
                if (objOpt != null) {
                    jSONObject.putOpt(next, objOpt);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
