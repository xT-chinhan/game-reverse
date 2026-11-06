package com.byazt.va;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 44, 19})
public abstract class n {
    public Context n;
    public JSONObject q;
    public String s = "";
    public final com.byazt.ahu.n qg = new com.byazt.ahu.n();

    public abstract String qg();

    public abstract String s();

    public n(Context context, JSONObject jSONObject) {
        this.n = context;
        this.q = jSONObject;
    }

    public com.byazt.ahu.n n() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strQg = qg();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.qg.qg(strQg);
            this.qg.n(s());
            this.qg.n(jCurrentTimeMillis2 - jCurrentTimeMillis);
            this.qg.s(q());
            this.qg.s();
            if (this.q.has("index")) {
                this.qg.n(this.q.optInt("index"));
            }
            return this.qg;
        } catch (Exception e) {
            com.byazt.nt.n.qg("__kite" + s() + " doLoad# error " + e.getMessage());
            return this.qg;
        }
    }

    private String q() {
        return this.s;
    }
}
