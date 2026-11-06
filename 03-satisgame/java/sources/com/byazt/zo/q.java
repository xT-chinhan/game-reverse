package com.byazt.zo;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 5})
public class q {
    public static volatile boolean n;
    public static volatile boolean q;
    public static volatile AtomicBoolean qg = new AtomicBoolean(false);
    public static volatile boolean rv = false;
    public static volatile SparseArray<Object> s;
    public long fs;
    public com.byazt.gf.qg l;
    public com.byazt.vyf.n w;
    public long x;

    public void n(Context context, com.byazt.qu.n nVar, com.byazt.gf.qg qgVar, long j, long j2, com.byazt.vyf.n nVar2, long j3, JSONObject jSONObject) {
        this.l = qgVar;
        this.x = j;
        this.fs = j2;
        this.w = nVar2;
        if (nVar != null) {
            com.byazt.qt.n.d().s(nVar.l());
            if (com.byazt.vyf.s.cy().sh()) {
                com.byazt.nc.l.n(nVar);
            }
            com.byazt.rb.qg.q("TMe", "init csjm " + n);
            if (!n) {
                com.byazt.rb.qg.qg("TMe", "init csjm ");
                n = true;
                qg.set(false);
                com.byazt.zs.n.n().qg();
                com.byazt.zs.n.n().n(new com.byazt.zs.qg() { // from class: com.byazt.zo.q.1
                    @Override // com.byazt.zs.qg
                    public void n(JSONObject jSONObject2) {
                        com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                        q.this.n(jSONObject2);
                    }

                    @Override // com.byazt.zs.qg
                    public void n(int i, String str) {
                        com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                        q.this.n(i, str);
                    }
                });
                com.byazt.jp.tj.n(context, n(nVar));
                try {
                    jSONObject.put("0-init", x.w - x.l);
                    jSONObject.put("0-start", x.x - x.l);
                    jSONObject.put("s-csj", j3 - x.x);
                    jSONObject.put("s-m_init_end", SystemClock.elapsedRealtime() - x.x);
                } catch (JSONException unused) {
                }
                com.byazt.jp.tj.n(jSONObject);
                return;
            }
            com.byazt.rb.qg.qg("TMe", "init csjm already");
            if (qgVar != null && rv) {
                rv = false;
                qg.set(false);
                com.byazt.zs.n.n().n(new com.byazt.zs.qg() { // from class: com.byazt.zo.q.2
                    @Override // com.byazt.zs.qg
                    public void n(JSONObject jSONObject2) {
                        com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                        q.this.n(jSONObject2);
                    }

                    @Override // com.byazt.zs.qg
                    public void n(int i, String str) {
                        com.byazt.zs.n.n().n((com.byazt.zs.qg) null);
                        q.this.n(i, str);
                    }
                });
                com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(1);
                return;
            }
            if (qgVar != null && s != null && q) {
                qgVar.n(0, s);
                return;
            } else {
                com.byazt.rb.qg.qg("TMe", "sdk正在初始化....");
                return;
            }
        }
        com.byazt.rb.qg.qg("TMe", "init csjm configValueSet is null");
    }

    public boolean n() {
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        rv = true;
        if (!qg.get()) {
            qg.set(true);
            qg(i, str);
        } else {
            com.byazt.rb.qg.qg("TMe", "通知成功或失败了不在通知");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final JSONObject jSONObject) {
        if (!qg.get()) {
            qg.set(true);
            com.byazt.rb.qg.qg("TMe", "通知成功=----notifySdkSuccess");
            com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.zo.q.3
                @Override // java.lang.Runnable
                public void run() {
                    q.this.qg(jSONObject);
                }
            });
            return;
        }
        com.byazt.rb.qg.qg("TMe", "通知成功或失败了不在通知");
    }

    private void qg(int i, String str) {
        if (i == 40004) {
            com.byazt.rb.qg.qg("TMe", "sdk init call code is 40004 callback success");
            qg(null);
        } else if (this.l != null) {
            com.byazt.rb.qg.qg("TMe", "sdk init call callback fail");
            s = com.byazt.of.s.n().n(false).n(i).n(str).qg();
            this.l.n(0, s);
            com.byazt.it.q.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject) {
        if (this.l != null) {
            q = true;
            if (this.x != 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                x.qg = jElapsedRealtime - this.x;
                x.q = jElapsedRealtime - this.fs;
                x.n(jSONObject, "s-end");
                if (jSONObject != null) {
                    Integer.valueOf(jSONObject.optInt("s-end"));
                }
            }
            com.byazt.rb.qg.q("TMe", "sdk init call callback success");
            com.byazt.of.s sVarN = com.byazt.of.s.n().n(true);
            if (this.w != null && com.byazt.nf.tj.l < 7500) {
                com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
                qgVarN.n(23, this.w.s());
                sVarN.n(qgVarN.qg());
            }
            s = sVarN.qg();
            this.l.n(0, s);
            long j = x.n;
            long j2 = x.qg;
            com.byazt.it.q.s();
            qg();
        }
    }

    private void qg() {
        com.byazt.mh.l.n();
    }

    private com.byazt.jp.n n(com.byazt.qu.n nVar) {
        return new com.byazt.jp.n.C0226n().n(nVar.l()).qg(nVar.w()).n(nVar.q()).s(nVar.k()).qg(nVar.cy()).n(s.n(nVar.hd())).n(nVar.cd()).n(nVar.sz()).s(nVar.um()).n(nVar.a()).q(nVar.d()).n(new com.byazt.jp.d.n().n(nVar.x()).qg(nVar.fs()).n(nVar.rv()).n(nVar.tj()).qg(nVar.cp()).n(nVar.oa()).n(s.n(nVar.cd())).n()).n(new com.byazt.jp.fs.n().n(nVar.ou()).n(nVar.py()).qg(nVar.wm()).s(nVar.m()).n()).n(nVar.qg()).n();
    }
}
