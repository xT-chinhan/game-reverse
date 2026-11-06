package com.byazt.nj;

import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.vf.fi;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 21})
public final class x {
    public s n(pk pkVar, q qVar) {
        if (pkVar == null || qVar == null) {
            return s.n();
        }
        JSONObject jSONObjectSh = pkVar.sh();
        if (!n(pkVar)) {
            return s.n();
        }
        try {
            fi fiVar = (fi) com.byazt.qp.q.n("strategy");
            if (fiVar == null) {
                return s.n();
            }
            return n(fiVar.n("c_s_a_ad_show_threshold", n(qVar), jSONObjectSh));
        } catch (RuntimeException unused) {
            return s.n();
        }
    }

    public static boolean n(pk pkVar) {
        if (com.byazt.vgx.w.d(pkVar) == 7 && cx.q(pkVar)) {
            return false;
        }
        JSONObject jSONObjectSh = pkVar != null ? pkVar.sh() : null;
        return jSONObjectSh != null && jSONObjectSh.has("c_s_a_ad_show_threshold");
    }

    private JSONObject n(q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_slot_type", qVar.n());
            jSONObject.put("render_sequence", qVar.qg());
            jSONObject.put("render_control", qVar.s());
            jSONObject.put("is_cache", qVar.q());
            jSONObject.put("load_to_show_duration_ms", qVar.l());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public s n(JSONObject jSONObject) {
        int iOptInt = jSONObject != null ? jSONObject.optInt("poll_time", -1) : -1;
        int iOptInt2 = jSONObject != null ? jSONObject.optInt("need_double_check", -1) : -1;
        if (iOptInt <= 0 || (iOptInt2 != 0 && iOptInt2 != 1)) {
            return s.n();
        }
        return s.n(iOptInt, iOptInt2, jSONObject.optInt("s_ab_conf_info"));
    }
}
