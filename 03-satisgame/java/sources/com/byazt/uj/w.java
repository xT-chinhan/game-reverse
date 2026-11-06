package com.byazt.uj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 13})
public class w implements com.byazt.mcb.n {
    @Override // com.byazt.mcb.n
    public com.byazt.mcb.n.InterfaceC0244n n(String str) {
        return n.n(str);
    }

    @com.byazt.cp.n(n = {0, 1, 738, 108})
    static class n implements com.byazt.mcb.n.InterfaceC0244n {
        public com.byazt.sz.n n;
        public String qg;

        private n(String str) {
            this.qg = str;
            this.n = com.byazt.sz.n.n(str);
        }

        public static n n(String str) {
            return new n(str);
        }

        @Override // com.byazt.mcb.n.InterfaceC0244n
        public Object n(JSONObject jSONObject) {
            com.byazt.sz.n nVar = this.n;
            if (nVar == null) {
                return this.qg;
            }
            Object objN = nVar.n(jSONObject);
            if (objN instanceof String) {
                return objN;
            }
            if (objN instanceof com.byazt.qy.n) {
                return String.valueOf(hu.n((com.byazt.qy.n) objN));
            }
            if (objN != null && objN.getClass().isArray()) {
                try {
                    return new JSONArray(objN).toString();
                } catch (JSONException unused) {
                    return String.valueOf(objN);
                }
            }
            return String.valueOf(objN);
        }
    }
}
