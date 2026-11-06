package com.byazt.np;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 101})
public class fs extends q implements com.byazt.kt.qg {
    public com.byazt.pf.qg n;
    public com.byazt.pf.n qg;
    public boolean um;

    public fs(Context context) {
        super(context);
        this.um = false;
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.pf.qg qgVar2) {
        super.qg(qgVar);
        this.n = qgVar2;
        this.w = qgVar;
        this.rv = this;
        rv();
    }

    public void n(Activity activity) {
        qg(activity, null, null);
    }

    public void qg(Activity activity, Object obj, String str) {
        n(activity, obj, str);
    }

    @Override // com.byazt.np.q
    public void n(Activity activity, Object obj, String str) {
        super.n(activity, obj, str, new tj.n() { // from class: com.byazt.np.fs.1
            @Override // com.byazt.np.tj.n
            public void n() {
                fs.this.s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            }
        });
        if (this.qg == null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        n(this.q);
    }

    @Override // com.byazt.np.qg
    public com.byazt.mj.s f_() {
        if (this.um) {
            return super.f_();
        }
        return null;
    }

    public void n(com.byazt.pf.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.np.tj, com.byazt.np.qg
    public void s() {
        if (this.q == null) {
            com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, cd(), this.q);
        }
        super.s();
        this.qg = null;
        this.n = null;
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        com.byazt.pf.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.pf.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void fs() {
        com.byazt.pf.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.qg();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    @Override // com.byazt.pf.n
    public void n() {
        String strN;
        String str;
        long jCurrentTimeMillis;
        this.um = true;
        ou();
        if (!com.byazt.vy.rv.n() || this.q == null || !MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
            strN = null;
        } else {
            if (!com.byazt.vy.rv.s()) {
                n(true);
                com.byazt.mj.n nVar = new com.byazt.mj.n(40063, com.byazt.mj.n.n(40063));
                com.byazt.gp.s.n(this.q, this.w, nVar, 1, py() ? 1 : 0, (String) null, 0L, com.byazt.vy.d.n());
                s(nVar);
                return;
            }
            if (com.byazt.vy.rv.x()) {
                strN = com.byazt.vy.d.n();
            } else {
                strN = null;
            }
        }
        com.byazt.pf.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.n();
        }
        com.byazt.bf.oa.n().x(this.l);
        if (this.q != null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show_listen") + "adSlotId：" + this.q.el() + "，广告类型：" + com.byazt.sg.n.n(this.q.he()));
            com.byazt.bf.cp.n().qg(this.l, this.q.el());
        }
        n(this.s);
        s(this.q);
        if (this.q != null) {
            com.byazt.bw.s.n(this.q.ci(), this.l, this.q.el());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            String strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str = strQg;
        } else {
            str = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.gp.s.n(this.q, this.w, py() ? 1 : 0, str, jCurrentTimeMillis, strN, false, a(), (View) null);
        com.byazt.mv.n.x(this.w.a());
        com.byazt.mv.n.s(this.w.a());
        com.byazt.cby.q.n(1, this.w.a(), this.q.ct(), this.q.ta());
        com.byazt.sq.s.n(this.l, this.q);
    }

    @Override // com.byazt.pf.n
    public void n(com.byazt.mj.n nVar) {
        String strQg;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.gp.s.n(this.q, this.w, nVar, 1, py() ? 1 : 0, strQg, jCurrentTimeMillis);
        s(nVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    @Override // com.byazt.pf.n
    public void g_() {
        String str;
        String str2;
        long jCurrentTimeMillis;
        String strN;
        com.byazt.pf.n nVar;
        m();
        if (com.byazt.vy.rv.n()) {
            if (this.q == null || !MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                strN = null;
            } else if (!com.byazt.vy.rv.s()) {
                com.byazt.gp.s.n(this.q, this.w, 5, 1, py() ? 1 : 0, com.byazt.vy.d.n());
                return;
            } else if (com.byazt.vy.rv.fs()) {
                strN = com.byazt.vy.d.n();
            } else {
                strN = null;
            }
            if (!hu() && (nVar = this.qg) != null) {
                nVar.g_();
            }
            str = strN;
        } else {
            com.byazt.pf.n nVar2 = this.qg;
            if (nVar2 != null) {
                nVar2.g_();
            }
            str = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            String strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str2 = strQg;
        } else {
            str2 = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.mv.n.l(this.w.a());
        com.byazt.gp.s.n(this.q, this.w, py() ? 1 : 0, str2, jCurrentTimeMillis, str, this.q.v());
    }

    @Override // com.byazt.pf.n
    public void h_() {
        wm();
        if (this.cy) {
            if (com.byazt.vy.rv.n()) {
                if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                    if (!com.byazt.vy.rv.s()) {
                        com.byazt.gp.s.n(this.q, this.w, 2, 1, py() ? 1 : 0, com.byazt.vy.d.n());
                        return;
                    }
                    com.byazt.gp.s.n(this.q, this.w, 2, 0, py() ? 1 : 0, (String) null);
                }
                if (hu()) {
                    return;
                }
                h();
                com.byazt.pf.n nVar = this.qg;
                if (nVar != null) {
                    nVar.h_();
                    return;
                }
                return;
            }
            h();
            com.byazt.pf.n nVar2 = this.qg;
            if (nVar2 != null) {
                nVar2.h_();
            }
        }
    }

    @Override // com.byazt.pf.n
    public void q() {
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.s()) {
                    com.byazt.gp.s.n(this.q, this.w, 1, 1, py() ? 1 : 0, com.byazt.vy.d.n());
                    return;
                }
                com.byazt.gp.s.n(this.q, this.w, 1, 0, py() ? 1 : 0, (String) null);
            }
            if (hu()) {
                return;
            }
            h();
            com.byazt.pf.n nVar = this.qg;
            if (nVar != null) {
                nVar.q();
                return;
            }
            return;
        }
        h();
        com.byazt.pf.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.q();
        }
    }

    @Override // com.byazt.pf.n
    public void l() {
        String strQg;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.gp.s.n(this.q, this.w, (com.byazt.mj.n) null, 2, py() ? 1 : 0, strQg, jCurrentTimeMillis);
        com.byazt.pf.n nVar = this.qg;
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // com.byazt.pf.n
    public void w() {
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.s()) {
                    com.byazt.gp.s.n(this.q, this.w, 3, 1, py() ? 1 : 0, com.byazt.vy.d.n());
                    return;
                }
                com.byazt.gp.s.n(this.q, this.w, 3, 0, py() ? 1 : 0, (String) null);
            }
            if (hu()) {
                return;
            }
            h();
            com.byazt.pf.n nVar = this.qg;
            if (nVar != null) {
                nVar.w();
                return;
            }
            return;
        }
        h();
        com.byazt.pf.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.w();
        }
    }

    @Override // com.byazt.pf.n
    public void n(com.byazt.fd.n nVar) {
        com.byazt.pf.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.n(d.n(this.w, nVar, this.q, (Map<String, Object>) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.fs.2
            @Override // java.lang.Runnable
            public void run() {
                if (fs.this.qg != null) {
                    fs.this.qg.n(nVar);
                }
            }
        });
    }
}
