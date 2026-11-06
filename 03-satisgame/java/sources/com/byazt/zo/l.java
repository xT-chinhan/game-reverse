package com.byazt.zo;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 18})
public class l {
    public static volatile boolean n;
    public static volatile boolean q;
    public static final AtomicBoolean qg = new AtomicBoolean(false);
    public static volatile boolean s;
    public volatile boolean l = false;
    public sz w;

    public void n(Context context, com.byazt.qu.n nVar, sz szVar, JSONObject jSONObject) {
        this.w = szVar;
        if (nVar == null) {
            com.byazt.rb.qg.qg("TMe", "init csjm parallel configValueSet is null");
            return;
        }
        com.byazt.qt.n.d().s(nVar.l());
        if (com.byazt.vyf.s.cy().sh()) {
            com.byazt.nc.l.n(nVar);
        }
        com.byazt.rb.qg.q("TMe", "init csjm parallel " + n);
        if (!n) {
            com.byazt.rb.qg.qg("TMe", "init csjm parallel");
            n = true;
            qg.set(false);
            q = false;
            this.l = false;
            com.byazt.zs.n.n().qg();
            com.byazt.zs.n.n().n(new com.byazt.zs.qg() { // from class: com.byazt.zo.l.1
                @Override // com.byazt.zs.qg
                public void n(JSONObject jSONObject2) {
                    com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                    l.this.n(jSONObject2);
                }

                @Override // com.byazt.zs.qg
                public void n(int i, String str) {
                    com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                    l.this.n(i, str);
                }
            });
            com.byazt.jp.tj.n(context, n(nVar));
            s(jSONObject);
            com.byazt.jp.tj.n(jSONObject);
            return;
        }
        com.byazt.rb.qg.qg("TMe", "init csjm parallel already");
        if (szVar != null && q) {
            q = false;
            qg.set(false);
            this.l = false;
            com.byazt.zs.n.n().n(new com.byazt.zs.qg() { // from class: com.byazt.zo.l.2
                @Override // com.byazt.zs.qg
                public void n(JSONObject jSONObject2) {
                    com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                    l.this.n(jSONObject2);
                }

                @Override // com.byazt.zs.qg
                public void n(int i, String str) {
                    com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                    l.this.n(i, str);
                }
            });
            com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(1);
            return;
        }
        if (szVar != null && s) {
            szVar.n(jSONObject);
        } else {
            com.byazt.rb.qg.qg("TMe", "parallel sdk is initializing....");
        }
    }

    public boolean n() {
        return s;
    }

    public boolean qg() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        q = true;
        AtomicBoolean atomicBoolean = qg;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            qg(i, str);
        } else {
            com.byazt.rb.qg.qg("TMe", "parallel init result already notified");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        AtomicBoolean atomicBoolean = qg;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            com.byazt.rb.qg.qg("TMe", "parallel notifySdkSuccess");
            qg(jSONObject);
            return;
        }
        com.byazt.rb.qg.qg("TMe", "parallel init result already notified");
    }

    private void qg(int i, String str) {
        if (i == 40004) {
            this.l = true;
            qg(null);
            return;
        }
        s = false;
        SparseArray<Object> sparseArrayQg = com.byazt.of.s.n().n(false).n(i).n(str).qg();
        sz szVar = this.w;
        if (szVar != null) {
            szVar.n(i, str, sparseArrayQg);
        }
        com.byazt.it.q.s();
    }

    private void qg(JSONObject jSONObject) {
        s = true;
        sz szVar = this.w;
        if (szVar != null) {
            szVar.n(jSONObject);
        }
        com.byazt.it.q.s();
    }

    private void s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("0-init", x.w - x.l);
            jSONObject.put("0-start", x.x - x.l);
            jSONObject.put("s-m_init_end", SystemClock.elapsedRealtime() - x.x);
        } catch (JSONException unused) {
        }
    }

    private com.byazt.jp.n n(com.byazt.qu.n nVar) {
        return new com.byazt.jp.n.C0226n().n(nVar.l()).qg(nVar.w()).n(nVar.q()).s(nVar.k()).qg(nVar.cy()).n(s.n(nVar.hd())).n(nVar.cd()).n(nVar.sz()).s(nVar.um()).n(nVar.a()).q(nVar.d()).n(new com.byazt.jp.d.n().n(nVar.x()).qg(nVar.fs()).n(nVar.rv()).n(nVar.tj()).qg(nVar.cp()).n(nVar.oa()).n(s.n(nVar.cd())).n()).n(new com.byazt.jp.fs.n().n(nVar.ou()).n(nVar.py()).qg(nVar.wm()).s(nVar.m()).n()).n(nVar.qg()).n();
    }
}
