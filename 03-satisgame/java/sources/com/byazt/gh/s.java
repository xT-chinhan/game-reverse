package com.byazt.gh;

import android.text.TextUtils;
import com.byazt.nf.tj;
import com.byazt.vgx.w;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 758, 8})
public class s implements com.byazt.rr.l {
    @Override // com.byazt.rr.l
    public boolean l() {
        return true;
    }

    @Override // com.byazt.rr.l
    public String n() {
        return "1371";
    }

    @Override // com.byazt.rr.l
    public void n(boolean z, com.byazt.rr.s sVar) {
    }

    @Override // com.byazt.rr.l
    public boolean qg() {
        return true;
    }

    @Override // com.byazt.rr.l
    public void rv() {
    }

    @Override // com.byazt.rr.l
    public int s() {
        return 2;
    }

    @Override // com.byazt.rr.l
    public void n(boolean z, com.byazt.rr.s sVar, JSONObject jSONObject) {
        if (sVar == null) {
            return;
        }
        sVar.qg();
        sVar.n();
        sVar.s();
        sVar.q();
        sVar.l();
    }

    @Override // com.byazt.rr.l
    public String q() {
        com.byazt.sf.s sVar = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.vgx.s.l());
        return sVar != null ? sVar.qg() : "";
    }

    @Override // com.byazt.rr.l
    public String w() {
        return tj.rv;
    }

    @Override // com.byazt.rr.l
    public void n(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (TextUtils.equals(str, "pitaya_feature_engineering")) {
            com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(str, (byte) 0, new com.byazt.rs.n() { // from class: com.byazt.gh.s.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                    com.byazt.twu.q.n(str, jSONObject2);
                    return null;
                }
            });
        } else {
            com.byazt.eji.s.n().qg(str, jSONObject);
        }
    }

    @Override // com.byazt.rr.l
    public String x() {
        String strN = com.byazt.ehw.l.n();
        return strN == null ? "" : strN;
    }

    @Override // com.byazt.rr.l
    public String fs() {
        return String.valueOf(w.l());
    }

    @Override // com.byazt.rr.l
    public com.byazt.vf.n tj() {
        return com.byazt.vgx.s.l();
    }
}
