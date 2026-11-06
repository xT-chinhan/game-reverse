package com.byazt.ji;

import com.byazt.tk.rv;
import com.kwad.sdk.api.loader.ApiSpUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 8})
public class s {
    public boolean l;
    public final w n;
    public final x qg;
    public final n s;
    public com.byazt.ji.n q = com.byazt.ji.n.n();
    public final Runnable w = new Runnable() { // from class: com.byazt.ji.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.qg(ApiSpUtils.SP_INTERVAL);
            if (!s.this.l || !s.this.q.n || !s.this.n.qg()) {
                s.this.l = false;
            } else {
                rv.n().postDelayed(this, s.this.q.x);
            }
        }
    };

    public interface n {
        void n(JSONObject jSONObject);
    }

    public s(w wVar, x xVar, n nVar) {
        this.n = wVar;
        this.qg = xVar;
        this.s = nVar;
    }

    public void n(com.byazt.ji.n nVar) {
        qg("config_update");
        if (nVar == null) {
            nVar = com.byazt.ji.n.n();
        }
        this.q = nVar;
        qg();
        if (this.q.n && this.n.qg()) {
            n();
        }
    }

    public void n() {
        if (this.l) {
            return;
        }
        this.l = true;
        rv.n().postDelayed(this.w, this.q.x);
    }

    public void qg() {
        if (this.l) {
            this.l = false;
            rv.n().removeCallbacks(this.w);
        }
    }

    public void s() {
        if (this.q.n && this.n.qg()) {
            n();
        }
    }

    public void n(String str) {
        qg(str);
    }

    public void qg(String str) {
        if (this.q.n && this.n.qg()) {
            JSONObject jSONObjectN = this.n.n(this.qg, str);
            this.n.n();
            n nVar = this.s;
            if (nVar != null) {
                nVar.n(jSONObjectN);
            }
        }
    }
}
