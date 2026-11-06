package com.byazt.np;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 19})
public class n extends q {
    public com.byazt.ig.n a;
    public com.byazt.kt.qg n;
    public boolean py;
    public com.byazt.kt.s qg;
    public com.byazt.ig.qg um;

    public n(Context context) {
        super(context);
        this.py = false;
        this.n = new com.byazt.kt.qg() { // from class: com.byazt.np.n.3
            /* JADX WARN: Code duplicated, block: B:15:0x006b  */
            @Override // com.byazt.pf.n
            public void n() {
                String strN;
                String str;
                long jCurrentTimeMillis;
                n.this.py = true;
                n.this.ou();
                if (!com.byazt.vy.rv.n() || n.this.q == null || !MediationConstant.ADN_PANGLE.equals(n.this.q.lq())) {
                    strN = null;
                } else {
                    if (!com.byazt.vy.rv.s()) {
                        n.this.n(true);
                        com.byazt.mj.n nVar = new com.byazt.mj.n(40063, com.byazt.mj.n.n(40063));
                        com.byazt.gp.s.n(n.this.q, n.this.w, nVar, 1, n.this.py() ? 1 : 0, (String) null, 0L, com.byazt.vy.d.n());
                        n.this.n(nVar);
                        return;
                    }
                    if (com.byazt.vy.rv.x()) {
                        strN = com.byazt.vy.d.n();
                    } else {
                        strN = null;
                    }
                }
                if (n.this.a != null) {
                    n.this.a.n();
                }
                com.byazt.bf.oa.n().x(n.this.l);
                if (n.this.q != null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(n.this.l, "show_listen") + "adSlotId：" + n.this.q.el() + "，广告类型：" + com.byazt.sg.n.n(n.this.q.he()));
                    com.byazt.bf.cp.n().qg(n.this.l, n.this.q.el());
                }
                n nVar2 = n.this;
                nVar2.n(nVar2.s);
                n nVar3 = n.this;
                nVar3.s(nVar3.q);
                if (n.this.q != null) {
                    com.byazt.bw.s.n(n.this.q.ci(), n.this.l, n.this.q.el());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    String strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str = strQg;
                } else {
                    str = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.gp.s.n(n.this.q, n.this.w, n.this.py() ? 1 : 0, str, jCurrentTimeMillis, strN, false, n.this.a(), (View) null);
                com.byazt.mv.n.x(n.this.l);
                com.byazt.mv.n.s(n.this.l);
                com.byazt.cby.q.n(1, n.this.w.a(), n.this.q.ct(), n.this.q.ta());
                com.byazt.sq.s.n(n.this.l, n.this.q);
            }

            @Override // com.byazt.pf.n
            public void n(com.byazt.mj.n nVar) {
                String strQg;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.gp.s.n(n.this.q, n.this.w, nVar, 1, n.this.py() ? 1 : 0, strQg, jCurrentTimeMillis);
                n.this.n(nVar);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x004b  */
            @Override // com.byazt.pf.n
            public void g_() {
                String str;
                String str2;
                long jCurrentTimeMillis;
                String strN;
                n.this.m();
                if (!com.byazt.vy.rv.n()) {
                    if (n.this.a != null) {
                        n.this.a.qg();
                    }
                    str = null;
                } else {
                    if (n.this.q == null || !MediationConstant.ADN_PANGLE.equals(n.this.q.lq())) {
                        strN = null;
                    } else if (!com.byazt.vy.rv.s()) {
                        com.byazt.gp.s.n(n.this.q, n.this.w, 5, 1, n.this.py() ? 1 : 0, com.byazt.vy.d.n());
                        return;
                    } else if (com.byazt.vy.rv.fs()) {
                        strN = com.byazt.vy.d.n();
                    } else {
                        strN = null;
                    }
                    if (!n.this.hu() && n.this.a != null) {
                        n.this.a.qg();
                    }
                    str = strN;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    String strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str2 = strQg;
                } else {
                    str2 = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.mv.n.l(n.this.l);
                com.byazt.gp.s.n(n.this.q, n.this.w, n.this.py() ? 1 : 0, str2, jCurrentTimeMillis, str, n.this.q.v());
            }

            @Override // com.byazt.pf.n
            public void h_() {
                n.this.wm();
                if (n.this.cy) {
                    if (com.byazt.vy.rv.n()) {
                        if (n.this.q != null && MediationConstant.ADN_PANGLE.equals(n.this.q.lq())) {
                            if (!com.byazt.vy.rv.s()) {
                                com.byazt.gp.s.n(n.this.q, n.this.w, 2, 1, n.this.py() ? 1 : 0, com.byazt.vy.d.n());
                                return;
                            }
                            com.byazt.gp.s.n(n.this.q, n.this.w, 2, 0, n.this.py() ? 1 : 0, (String) null);
                        }
                        if (n.this.hu()) {
                            return;
                        }
                        n.this.h();
                        if (n.this.a != null) {
                            n.this.a.s();
                            return;
                        }
                        return;
                    }
                    n.this.h();
                    if (n.this.a != null) {
                        n.this.a.s();
                    }
                }
            }

            @Override // com.byazt.pf.n
            public void q() {
                if (com.byazt.vy.rv.n()) {
                    if (n.this.q != null && MediationConstant.ADN_PANGLE.equals(n.this.q.lq())) {
                        if (!com.byazt.vy.rv.s()) {
                            com.byazt.gp.s.n(n.this.q, n.this.w, 1, 1, n.this.py() ? 1 : 0, com.byazt.vy.d.n());
                            return;
                        }
                        com.byazt.gp.s.n(n.this.q, n.this.w, 1, 0, n.this.py() ? 1 : 0, (String) null);
                    }
                    if (n.this.hu()) {
                        return;
                    }
                    n.this.h();
                    if (n.this.a != null) {
                        n.this.a.q();
                        return;
                    }
                    return;
                }
                n.this.h();
                if (n.this.a != null) {
                    n.this.a.q();
                }
            }

            @Override // com.byazt.pf.n
            public void l() {
                String strQg;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.gp.s.n(n.this.q, n.this.w, (com.byazt.mj.n) null, 2, n.this.py() ? 1 : 0, strQg, jCurrentTimeMillis);
                if (n.this.a != null) {
                    n.this.a.l();
                }
            }

            @Override // com.byazt.pf.n
            public void w() {
                if (com.byazt.vy.rv.n()) {
                    if (n.this.q != null && MediationConstant.ADN_PANGLE.equals(n.this.q.lq())) {
                        if (!com.byazt.vy.rv.s()) {
                            com.byazt.gp.s.n(n.this.q, n.this.w, 3, 1, n.this.py() ? 1 : 0, com.byazt.vy.d.n());
                            return;
                        }
                        com.byazt.gp.s.n(n.this.q, n.this.w, 3, 0, n.this.py() ? 1 : 0, (String) null);
                    }
                    if (n.this.hu()) {
                        return;
                    }
                    n.this.h();
                    if (n.this.a != null) {
                        n.this.a.w();
                        return;
                    }
                    return;
                }
                n.this.h();
                if (n.this.a != null) {
                    n.this.a.w();
                }
            }

            @Override // com.byazt.pf.n
            public void n(com.byazt.fd.n nVar) {
                if (n.this.a != null) {
                    n.this.a.n(d.n(n.this.w, nVar, n.this.q, (Map<String, Object>) null));
                }
            }
        };
        this.qg = new com.byazt.kt.s() { // from class: com.byazt.np.n.4
            @Override // com.byazt.sr.n
            public void n() {
                String strQg;
                long jCurrentTimeMillis;
                n.this.py = true;
                n.this.ou();
                if (n.this.a != null) {
                    n.this.a.n();
                }
                com.byazt.bf.oa.n().x(n.this.l);
                if (n.this.q != null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(n.this.l, "show_listen") + "adSlotId：" + n.this.q.el() + "，广告类型：" + com.byazt.sg.n.n(n.this.q.he()));
                    com.byazt.bf.cp.n().qg(n.this.l, n.this.q.el());
                }
                n nVar = n.this;
                nVar.n(nVar.s);
                n nVar2 = n.this;
                nVar2.s(nVar2.q);
                if (n.this.q != null) {
                    com.byazt.bw.s.n(n.this.q.ci(), n.this.l, n.this.q.el());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.sg.s sVar = n.this.q;
                com.byazt.qn.qg qgVar = n.this.w;
                boolean zPy = n.this.py();
                com.byazt.gp.s.n(sVar, qgVar, zPy ? 1 : 0, strQg, jCurrentTimeMillis, false, n.this.a(), (View) null);
                com.byazt.sq.s.n(n.this.l, n.this.q);
            }

            @Override // com.byazt.sr.n
            public void n(com.byazt.mj.n nVar) {
                String strQg;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.gp.s.n(n.this.q, n.this.w, nVar, 1, n.this.py() ? 1 : 0, strQg, jCurrentTimeMillis);
                n.this.n(nVar);
            }

            @Override // com.byazt.sr.n
            public void qg() {
                String strQg;
                long jCurrentTimeMillis;
                n.this.m();
                if (n.this.a != null) {
                    n.this.a.qg();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (com.byazt.vy.d.n(n.this.q)) {
                    strQg = com.byazt.vy.d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.sg.s sVar = n.this.q;
                com.byazt.qn.qg qgVar = n.this.w;
                boolean zPy = n.this.py();
                boolean zV = n.this.q.v();
                com.byazt.gp.s.n(sVar, qgVar, zPy ? 1 : 0, strQg, jCurrentTimeMillis, zV);
            }

            @Override // com.byazt.sr.n
            public void s() {
                n.this.wm();
                if (n.this.cy) {
                    n.this.h();
                    if (n.this.a != null) {
                        n.this.a.s();
                    }
                }
            }

            @Override // com.byazt.sr.n
            public void q() {
                if (n.this.a != null) {
                    n.this.a.x();
                }
            }

            @Override // com.byazt.sr.n
            public void l() {
                if (n.this.a != null) {
                    n.this.a.fs();
                }
            }
        };
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.ig.qg qgVar2) {
        super.qg(qgVar);
        this.w = qgVar;
        this.um = qgVar2;
        this.rv = this.n;
        rv();
    }

    public void n(Activity activity) {
        n(activity, (Object) null, (String) null);
    }

    @Override // com.byazt.np.q
    public void n(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "activity can not be null !");
        } else {
            qg(activity, obj, str);
            n(this.q);
        }
    }

    private void qg(Activity activity, Object obj, String str) {
        super.n(activity, obj, str, new tj.n() { // from class: com.byazt.np.n.1
            @Override // com.byazt.np.tj.n
            public void n() {
                n.this.n(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            }
        });
    }

    @Override // com.byazt.np.qg
    public com.byazt.mj.s f_() {
        if (this.py) {
            return super.f_();
        }
        return null;
    }

    public void n(com.byazt.ig.n nVar) {
        this.a = nVar;
    }

    @Override // com.byazt.np.tj, com.byazt.np.qg
    public void s() {
        if (this.q == null) {
            com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, cd(), this.q);
        }
        super.s();
        this.a = null;
        this.um = null;
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        com.byazt.ig.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.ig.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void fs() {
        com.byazt.ig.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.qg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.a != null) {
                    n.this.a.n(nVar);
                }
            }
        });
    }

    @Override // com.byazt.np.q, com.byazt.np.tj
    public void n(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        if (sVar != null) {
            if (sVar.dg() == 1) {
                this.rv = this.qg;
            } else if (sVar.dg() == 2) {
                this.rv = this.n;
            }
        }
        super.n(sVar, activity, obj, str);
    }
}
