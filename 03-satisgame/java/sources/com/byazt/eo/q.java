package com.byazt.eo;

import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1827, 5})
public class q {
    public static q l = new q();
    public pk n;
    public volatile com.byazt.okm.n q;
    public int qg;
    public int s;

    public static q n() {
        return l;
    }

    private boolean qg() {
        this.q = com.byazt.lq.qg.n;
        return this.q != null;
    }

    public q n(pk pkVar) {
        if (qg()) {
            this.n = pkVar;
        }
        return this;
    }

    public q n(int i) {
        if (qg()) {
            this.qg = i;
        }
        return this;
    }

    public q qg(int i) {
        if (qg()) {
            this.s = i;
        }
        return this;
    }

    public void n(Thread thread, Throwable th) {
        if (qg()) {
            String str = thread != null ? thread.getName() + "-" + thread.getId() : "";
            this.q.n(str, "-------fatal----------");
            this.q.n(str, "last show rit:" + this.s);
            this.q.n(str, "last show adtype:" + this.qg);
            this.q.n(str, s());
            this.q.n(str, th);
            this.q.n(str, "-------finish----------");
            com.byazt.lq.qg.n.n().n();
        }
    }

    private String s() {
        pk pkVar = this.n;
        if (pkVar == null) {
            return "";
        }
        JSONObject jSONObjectPv = pkVar.pv();
        return com.byazt.cl.s.n(jSONObjectPv == null ? null : jSONObjectPv.toString()).toString();
    }
}
