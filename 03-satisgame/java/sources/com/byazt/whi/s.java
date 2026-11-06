package com.byazt.whi;

import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 953, 8})
public final class s {
    public static com.byazt.dc.qg n(final com.byazt.dc.q qVar) {
        Function function = null;
        if (qVar == null) {
            return null;
        }
        return new com.byazt.dc.qg(function) { // from class: com.byazt.whi.s.1
            @Override // com.byazt.dc.qg
            public JSONObject n() {
                return null;
            }

            @Override // com.byazt.dc.qg
            public void n(JSONObject jSONObject) {
                qVar.n(jSONObject);
            }

            @Override // com.byazt.dc.qg
            public void qg(JSONObject jSONObject) {
                qVar.qg(jSONObject);
            }

            @Override // com.byazt.dc.qg
            public void s(JSONObject jSONObject) {
                qVar.s(jSONObject);
            }

            @Override // com.byazt.dc.qg
            public void qg() {
                qVar.n();
            }
        };
    }
}
