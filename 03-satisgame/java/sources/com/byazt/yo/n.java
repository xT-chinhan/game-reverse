package com.byazt.yo;

import android.app.Dialog;
import com.byazt.fvm.w;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 170, 19})
public class n implements com.byazt.ae.n {
    public final pk n;

    @Override // com.byazt.ae.n
    public boolean n(String str, Dialog dialog) {
        return false;
    }

    public n(pk pkVar) {
        this.n = pkVar;
    }

    @Override // com.byazt.ae.n
    public boolean n(w wVar, String str, Dialog dialog) {
        if (!"7:1".equals(wVar.n())) {
            return false;
        }
        com.byazt.eji.s.n().n("stats_feedback_cannot_close", this.n.ou(), this.n.F_(), new com.byazt.rs.n() { // from class: com.byazt.yo.n.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("render_control", nf.s(n.this.n));
                jSONObject2.put("ad_info", n.this.n.yk());
                jSONObject2.put("render_sequence", nf.s(n.this.n));
                return jSONObject2;
            }
        });
        return true;
    }

    public static void n(com.byazt.wg.qg qgVar, pk pkVar) {
        if (qgVar == null || pkVar == null) {
            return;
        }
        qgVar.n(new n(pkVar));
    }
}
