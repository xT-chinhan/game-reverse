package com.byazt.shr;

import com.byazt.gct.pk;
import com.byazt.shr.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 26})
public class qg<T extends q> {
    public boolean l = false;
    public pk n;
    public T q;
    public String qg;
    public JSONObject s;

    public qg(pk pkVar, String str, JSONObject jSONObject, T t) {
        this.n = pkVar;
        this.qg = str;
        this.s = jSONObject;
        this.q = t;
    }

    public pk n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public JSONObject s() {
        if (this.s == null) {
            this.s = new JSONObject();
        }
        return this.s;
    }

    public T q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    public void n(boolean z) {
        this.l = z;
    }
}
