package com.byazt.np;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 113})
public class d extends tj implements com.byazt.kt.q {
    public int a;
    public com.byazt.az.n cy;
    public long h;
    public volatile com.byazt.ot.n.qg hu;
    public volatile Runnable m;
    public com.byazt.me.qg n;
    public volatile boolean ou;
    public int py;
    public com.byazt.me.n qg;
    public final com.byazt.kt.s t;
    public boolean um;
    public final com.byazt.kt.qg ur;
    public final Handler wm;

    private int n(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 2147483) {
            return Integer.MAX_VALUE;
        }
        return (int) (j * 1000);
    }

    public d(Context context) {
        super(context);
        this.um = false;
        this.a = -1;
        this.py = 0;
        this.ou = false;
        this.wm = new Handler(Looper.getMainLooper());
        this.t = new com.byazt.kt.s() { // from class: com.byazt.np.d.7
            public final n qg;

            @Override // com.byazt.sr.n
            public void l() {
            }

            @Override // com.byazt.sr.n
            public void q() {
            }

            {
                this.qg = new n();
            }

            @Override // com.byazt.sr.n
            public void n() {
                d.this.um = true;
                this.qg.n();
            }

            @Override // com.byazt.sr.n
            public void n(com.byazt.mj.n nVar) {
                this.qg.n(nVar);
            }

            @Override // com.byazt.sr.n
            public void qg() {
                this.qg.g_();
            }

            @Override // com.byazt.sr.n
            public void s() {
                this.qg.h_();
            }
        };
        this.ur = new n();
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.me.qg qgVar2) {
        n(qgVar);
        this.cy = new com.byazt.az.n(this.l);
        lh();
        ln();
        this.a = -1;
        this.py = 0;
        this.ou = false;
        this.um = false;
        this.n = qgVar2;
        this.rv = this;
        rv();
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.me.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        com.byazt.me.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void fs() {
        com.byazt.me.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.qg();
        }
    }

    public void n(Activity activity, Object obj, String str) {
        n(activity, obj, str, new tj.n() { // from class: com.byazt.np.d.1
            @Override // com.byazt.np.tj.n
            public void n() {
                d.this.s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            }
        });
        if (this.qg == null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        n(this.q);
    }

    public void n(Activity activity) {
        n(activity, (Object) null, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    @Override // com.byazt.np.tj
    public void n(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        if (sVar != null) {
            if (sVar.dg() != 6) {
                if (sVar.dg() == 7) {
                    this.rv = this.ur;
                } else if (sVar.dg() == 8) {
                    this.rv = this.t;
                } else {
                    this.rv = this;
                }
            } else {
                this.rv = this;
            }
        }
        super.n(sVar, activity, obj, str);
    }

    @Override // com.byazt.np.qg
    public com.byazt.mj.s f_() {
        if (this.um) {
            return super.f_();
        }
        return null;
    }

    public void n(com.byazt.me.n nVar) {
        this.qg = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.fd.n nVar, int i, int i2) {
        String strQg;
        long jCurrentTimeMillis;
        int i3;
        int iIntValue;
        String str;
        Map<String, Object> mapQ;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        String str2 = strQg;
        long j = jCurrentTimeMillis;
        if (nVar == null || (mapQ = nVar.q()) == null) {
            i3 = 0;
            iIntValue = 0;
            str = "";
        } else {
            Integer num = (Integer) mapQ.get(MediationConstant.KEY_REASON);
            int iIntValue2 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) mapQ.get(MediationConstant.KEY_ERROR_CODE);
            iIntValue = num2 != null ? num2.intValue() : 0;
            str = (String) mapQ.get(MediationConstant.KEY_ERROR_MSG);
            i3 = iIntValue2;
        }
        com.byazt.gp.s.n(this.q, this.w, i, str2, j, i3, iIntValue, str, i2, this.a, SystemClock.elapsedRealtime() - this.h);
    }

    public static com.byazt.fd.n n(final com.byazt.qn.qg qgVar, final com.byazt.fd.n nVar, final com.byazt.sg.s sVar, final Map<String, Object> map) {
        if (nVar == null) {
            return null;
        }
        return new com.byazt.fd.n() { // from class: com.byazt.np.d.2
            @Override // com.byazt.fd.n
            public boolean n() {
                return nVar.n();
            }

            @Override // com.byazt.fd.n
            public float qg() {
                return nVar.qg();
            }

            @Override // com.byazt.fd.n
            public String s() {
                return nVar.s();
            }

            @Override // com.byazt.fd.n
            public Map<String, Object> q() {
                HashMap map2;
                Map<String, Object> mapQ = nVar.q();
                if (mapQ != null && mapQ.size() > 0) {
                    map2 = new HashMap(mapQ);
                } else {
                    map2 = new HashMap();
                }
                Map map3 = map;
                if (map3 != null && !map3.isEmpty()) {
                    map2.putAll(map);
                }
                com.byazt.mj.s sVarN = com.byazt.vy.x.n(qgVar, sVar, true);
                map2.put(MediationConstant.KEY_ADN_NAME, sVarN != null ? sVarN.d() : "");
                map2.put("ecpm", sVarN != null ? sVarN.oa() : "");
                return map2;
            }
        };
    }

    @Override // com.byazt.np.tj, com.byazt.np.qg
    public void s() {
        lh();
        ln();
        if (this.q == null) {
            com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, this.w.l(), this.q);
        }
        super.s();
        this.cy.s();
        this.n = null;
        this.qg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.qg != null) {
                    d.this.qg.n(nVar);
                }
            }
        });
    }

    private boolean ou() {
        return this.a >= 0;
    }

    private void wm() {
        Map<String, Object> mapAn;
        this.a = -1;
        if (this.q == null || this.w == null) {
            return;
        }
        com.byazt.ir.qg qgVarN = com.byazt.ir.qg.n();
        int iX = qgVarN.x();
        int iQ = q(this.q);
        if (iX < 0 || (qgVarN.fs() & iQ) == 0 || (mapAn = this.w.an()) == null) {
            return;
        }
        Object obj = mapAn.get("gmrvo");
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            this.a = iX;
            Object obj2 = mapAn.get("gmrvt");
            if (obj2 instanceof Number) {
                this.a = n(((Number) obj2).longValue());
            }
        }
    }

    private int q(com.byazt.sg.s sVar) {
        if (sVar.rg()) {
            return 16;
        }
        String strCi = sVar.ci();
        if (MediationConstant.ADN_GDT.equals(strCi)) {
            return 1;
        }
        if (MediationConstant.ADN_KS.equals(strCi)) {
            return 2;
        }
        if ("baidu".equals(strCi)) {
            return 4;
        }
        if (MediationConstant.ADN_SIGMOB.equals(strCi)) {
            return 8;
        }
        return MediationConstant.ADN_PANGLE.equals(strCi) ? 32 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.h = SystemClock.elapsedRealtime();
        lh();
        ln();
        wm();
        this.py = 0;
        ur();
        bb();
    }

    private void ur() {
        com.byazt.ot.n nVarS;
        if (this.a > 0 && (nVarS = com.byazt.vyf.s.cy().s()) != null) {
            this.hu = new com.byazt.ot.n.qg() { // from class: com.byazt.np.d.4
                @Override // com.byazt.ot.n.qg
                public void q() {
                }

                @Override // com.byazt.ot.n.qg
                public void s() {
                }

                @Override // com.byazt.ot.n.qg
                public void n() {
                    d.this.lh();
                }

                @Override // com.byazt.ot.n.qg
                public void qg() {
                    if (d.this.um) {
                        d.this.bb();
                    }
                }
            };
            nVarS.n(this.hu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qg(com.byazt.fd.n nVar) {
        if (this.qg == null) {
            return false;
        }
        if (ou()) {
            if (this.ou) {
                return false;
            }
            this.ou = true;
            lh();
            ln();
        }
        this.qg.n(nVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.a <= 0) {
            return;
        }
        lh();
        if (this.m == null) {
            this.m = new Runnable() { // from class: com.byazt.np.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.py += 1000;
                    if (d.this.py >= d.this.a) {
                        d.this.n(2);
                    } else {
                        d.this.wm.postDelayed(d.this.m, 1000L);
                    }
                }
            };
        }
        this.wm.postDelayed(this.m, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        com.byazt.ot.n nVarS;
        com.byazt.ot.n.qg qgVar = this.hu;
        this.hu = null;
        if (qgVar == null || (nVarS = com.byazt.vyf.s.cy().s()) == null) {
            return;
        }
        nVarS.qg(qgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        this.wm.removeCallbacksAndMessages(null);
    }

    private com.byazt.fd.n v() {
        return n(this.w, new com.byazt.fd.n() { // from class: com.byazt.np.d.6
            @Override // com.byazt.fd.n
            public boolean n() {
                return true;
            }

            @Override // com.byazt.fd.n
            public float qg() {
                if (d.this.w != null) {
                    return d.this.w.t();
                }
                return 0.0f;
            }

            @Override // com.byazt.fd.n
            public String s() {
                return d.this.w != null ? d.this.w.h() : "";
            }

            @Override // com.byazt.fd.n
            public Map<String, Object> q() {
                return new HashMap();
            }
        }, this.q, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(int i) {
        if (ou() && !this.ou) {
            com.byazt.fd.n nVarV = v();
            if (this.cy.n()) {
                this.cy.n(nVarV, this.q);
            }
            if (qg(nVarV)) {
                n((com.byazt.fd.n) null, 0, i);
                return true;
            }
        }
        return false;
    }

    @com.byazt.cp.n(n = {0, 1, 20, 89})
    private class n implements com.byazt.kt.qg {
        public final Handler q;
        public volatile boolean qg;
        public volatile boolean s;

        @Override // com.byazt.pf.n
        public void n(com.byazt.fd.n nVar) {
        }

        private n() {
            this.qg = false;
            this.s = false;
            this.q = new Handler(Looper.getMainLooper());
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0064  */
        @Override // com.byazt.pf.n
        public void n() {
            String strN;
            String str;
            long jCurrentTimeMillis;
            d.this.um = true;
            fs();
            if (!com.byazt.vy.rv.n() || d.this.q == null || !MediationConstant.ADN_PANGLE.equals(d.this.q.lq())) {
                strN = null;
            } else {
                if (!com.byazt.vy.rv.s()) {
                    d.this.n(true);
                    com.byazt.mj.n nVar = new com.byazt.mj.n(40063, com.byazt.mj.n.n(40063));
                    com.byazt.gp.s.n(d.this.q, d.this.w, nVar, 1, 0, (String) null, 0L, com.byazt.vy.d.n());
                    d.this.s(nVar);
                    return;
                }
                if (com.byazt.vy.rv.x()) {
                    strN = com.byazt.vy.d.n();
                } else {
                    strN = null;
                }
            }
            if (d.this.qg != null) {
                d.this.qg.n();
            }
            d.this.m();
            if (d.this.cy.n()) {
                d.this.cy.n(new com.byazt.az.n.qg() { // from class: com.byazt.np.d.n.1
                    @Override // com.byazt.az.n.qg
                    public void n(final com.byazt.fd.n nVar2) {
                        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.d.n.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.this.qg(nVar2)) {
                                    d.this.n(nVar2, 0, 0);
                                }
                            }
                        });
                    }
                });
                d.this.cy.n(d.this.w, d.this.q);
            }
            com.byazt.bf.oa.n().x(d.this.l);
            if (d.this.q != null) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(d.this.l, "show_listen") + "adSlotId：" + d.this.q.el() + "，广告类型：" + com.byazt.sg.n.n(d.this.q.he()));
                com.byazt.bf.cp.n().qg(d.this.l, d.this.q.el());
            }
            d dVar = d.this;
            dVar.n(dVar.s);
            d dVar2 = d.this;
            dVar2.s(dVar2.q);
            if (d.this.q != null) {
                com.byazt.bw.s.n(d.this.q.ci(), d.this.l, d.this.q.el());
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (com.byazt.vy.d.n(d.this.q)) {
                String strQg = com.byazt.vy.d.qg();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                str = strQg;
            } else {
                str = null;
                jCurrentTimeMillis = -1;
            }
            com.byazt.gp.s.n(d.this.q, d.this.w, 0, str, jCurrentTimeMillis, strN, false, d.this.a(), (View) null);
            com.byazt.mv.n.x(d.this.l);
            com.byazt.mv.n.s(d.this.l);
            com.byazt.cby.q.n(1, d.this.w.a(), d.this.q.ct(), d.this.q.ta());
            com.byazt.sq.s.n(d.this.l, d.this.q);
        }

        @Override // com.byazt.pf.n
        public void n(com.byazt.mj.n nVar) {
            String strQg;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (com.byazt.vy.d.n(d.this.q)) {
                strQg = com.byazt.vy.d.qg();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strQg = null;
                jCurrentTimeMillis = -1;
            }
            com.byazt.gp.s.n(d.this.q, d.this.w, nVar, 1, 0, strQg, jCurrentTimeMillis);
            d.this.s(nVar);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0041  */
        @Override // com.byazt.pf.n
        public void g_() {
            String str;
            String str2;
            long jCurrentTimeMillis;
            String strN;
            if (!com.byazt.vy.rv.n()) {
                if (d.this.qg != null) {
                    d.this.qg.i_();
                }
                str = null;
            } else {
                if (d.this.q == null || !MediationConstant.ADN_PANGLE.equals(d.this.q.lq())) {
                    strN = null;
                } else if (!com.byazt.vy.rv.s()) {
                    com.byazt.gp.s.n(d.this.q, d.this.w, 5, 1, 0, com.byazt.vy.d.n());
                    return;
                } else if (com.byazt.vy.rv.fs()) {
                    strN = com.byazt.vy.d.n();
                } else {
                    strN = null;
                }
                if (!d.this.hu() && d.this.qg != null) {
                    d.this.qg.i_();
                }
                str = strN;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (com.byazt.vy.d.n(d.this.q)) {
                String strQg = com.byazt.vy.d.qg();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                str2 = strQg;
            } else {
                str2 = null;
                jCurrentTimeMillis = -1;
            }
            com.byazt.mv.n.l(d.this.l);
            com.byazt.gp.s.n(d.this.q, d.this.w, 0, str2, jCurrentTimeMillis, str, d.this.q.v());
        }

        @Override // com.byazt.pf.n
        public void h_() {
            x();
            d.this.lh();
            d.this.ln();
            this.s = true;
            if (com.byazt.vy.rv.n()) {
                if (d.this.q != null && MediationConstant.ADN_PANGLE.equals(d.this.q.lq())) {
                    if (!com.byazt.vy.rv.s()) {
                        com.byazt.gp.s.n(d.this.q, d.this.w, 2, 1, 0, com.byazt.vy.d.n());
                        return;
                    }
                    com.byazt.gp.s.n(d.this.q, d.this.w, 2, 0, 0, (String) null);
                }
                if (d.this.hu()) {
                    return;
                }
                d.this.h();
                if (d.this.qg != null) {
                    d.this.qg.j_();
                    return;
                }
                return;
            }
            d.this.h();
            if (d.this.qg != null) {
                d.this.qg.j_();
            }
        }

        @Override // com.byazt.pf.n
        public void q() {
            if (com.byazt.vy.rv.n()) {
                if (d.this.q != null && MediationConstant.ADN_PANGLE.equals(d.this.q.lq())) {
                    if (!com.byazt.vy.rv.s()) {
                        com.byazt.gp.s.n(d.this.q, d.this.w, 1, 1, 0, com.byazt.vy.d.n());
                        return;
                    }
                    com.byazt.gp.s.n(d.this.q, d.this.w, 1, 0, 0, (String) null);
                }
                if (d.this.hu()) {
                    return;
                }
                d.this.h();
                if (!d.this.n(1) && d.this.cy.n()) {
                    d.this.cy.l();
                }
                if (d.this.qg != null) {
                    d.this.qg.q();
                    return;
                }
                return;
            }
            d.this.h();
            if (!d.this.n(1) && d.this.cy.n()) {
                d.this.cy.l();
            }
            if (d.this.qg != null) {
                d.this.qg.q();
            }
        }

        @Override // com.byazt.pf.n
        public void l() {
            d.this.l();
        }

        @Override // com.byazt.pf.n
        public void w() {
            x();
            d.this.lh();
            d.this.ln();
            this.qg = true;
            if (com.byazt.vy.rv.n()) {
                if (d.this.q != null && MediationConstant.ADN_PANGLE.equals(d.this.q.lq())) {
                    if (!com.byazt.vy.rv.s()) {
                        com.byazt.gp.s.n(d.this.q, d.this.w, 3, 1, 0, com.byazt.vy.d.n());
                        return;
                    }
                    com.byazt.gp.s.n(d.this.q, d.this.w, 3, 0, 0, (String) null);
                }
                if (d.this.hu()) {
                    return;
                }
                d.this.h();
                if (d.this.cy.n()) {
                    d.this.cy.qg();
                }
                if (d.this.qg != null) {
                    d.this.qg.w();
                    return;
                }
                return;
            }
            d.this.h();
            if (d.this.cy.n()) {
                d.this.cy.qg();
            }
            if (d.this.qg != null) {
                d.this.qg.w();
            }
        }

        private void fs() {
            this.q.postDelayed(new Runnable() { // from class: com.byazt.np.d.n.2
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.s || n.this.qg) {
                        n.this.x();
                        return;
                    }
                    d.this.n(new com.byazt.fd.n() { // from class: com.byazt.np.d.n.2.1
                        @Override // com.byazt.fd.n
                        public boolean n() {
                            return true;
                        }

                        @Override // com.byazt.fd.n
                        public float qg() {
                            if (d.this.w != null) {
                                return d.this.w.t();
                            }
                            return 0.0f;
                        }

                        @Override // com.byazt.fd.n
                        public String s() {
                            return d.this.w != null ? d.this.w.h() : "";
                        }

                        @Override // com.byazt.fd.n
                        public Map<String, Object> q() {
                            return new HashMap();
                        }
                    });
                    n.this.x();
                }
            }, com.byazt.ir.qg.n().w());
        }

        public void x() {
            this.q.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0052  */
    @Override // com.byazt.me.n
    public void n() {
        String strN;
        String str;
        long jCurrentTimeMillis;
        this.um = true;
        if (!com.byazt.vy.rv.n() || this.q == null || !MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
            strN = null;
        } else {
            if (!com.byazt.vy.rv.qg()) {
                n(true);
                com.byazt.mj.n nVar = new com.byazt.mj.n(40063, com.byazt.mj.n.n(40063));
                com.byazt.gp.s.n(this.q, this.w, nVar, 1, 0, (String) null, 0L, com.byazt.vy.d.n());
                s(nVar);
                return;
            }
            if (com.byazt.vy.rv.q()) {
                strN = com.byazt.vy.d.n();
            } else {
                strN = null;
            }
        }
        com.byazt.me.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.n();
        }
        m();
        if (this.cy.n()) {
            this.cy.n(new com.byazt.az.n.qg() { // from class: com.byazt.np.d.8
                @Override // com.byazt.az.n.qg
                public void n(final com.byazt.fd.n nVar3) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.d.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.qg(nVar3)) {
                                d.this.n(nVar3, 0, 0);
                            }
                        }
                    });
                }
            });
            this.cy.n(this.w, this.q);
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
        com.byazt.gp.s.n(this.q, this.w, 0, str, jCurrentTimeMillis, strN, false, a(), (View) null);
        com.byazt.mv.n.x(this.w.a());
        com.byazt.mv.n.s(this.w.a());
        com.byazt.cby.q.n(1, this.w.a(), this.q.ct(), this.q.ta());
        com.byazt.sq.s.n(this.l, this.q);
    }

    @Override // com.byazt.me.n
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
        com.byazt.gp.s.n(this.q, this.w, nVar, 1, 0, strQg, jCurrentTimeMillis);
        s(nVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    @Override // com.byazt.me.n
    public void i_() {
        String str;
        String str2;
        long jCurrentTimeMillis;
        String strN;
        com.byazt.me.n nVar;
        com.byazt.mv.n.l(this.w.a());
        if (com.byazt.vy.rv.n()) {
            if (this.q == null || !MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                strN = null;
            } else if (!com.byazt.vy.rv.qg()) {
                com.byazt.gp.s.n(this.q, this.w, 5, 1, 0, com.byazt.vy.d.n());
                return;
            } else if (com.byazt.vy.rv.l()) {
                strN = com.byazt.vy.d.n();
            } else {
                strN = null;
            }
            if (!hu() && (nVar = this.qg) != null) {
                nVar.i_();
            }
            str = strN;
        } else {
            com.byazt.me.n nVar2 = this.qg;
            if (nVar2 != null) {
                nVar2.i_();
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
        com.byazt.gp.s.n(this.q, this.w, 0, str2, jCurrentTimeMillis, str, this.q.v());
    }

    @Override // com.byazt.me.n
    public void j_() {
        lh();
        ln();
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.qg()) {
                    com.byazt.gp.s.n(this.q, this.w, 2, 1, 0, com.byazt.vy.d.n());
                    return;
                }
                com.byazt.gp.s.n(this.q, this.w, 2, 0, 0, (String) null);
            }
            if (hu()) {
                return;
            }
            h();
            com.byazt.me.n nVar = this.qg;
            if (nVar != null) {
                nVar.j_();
                return;
            }
            return;
        }
        h();
        com.byazt.me.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.j_();
        }
    }

    @Override // com.byazt.me.n
    public void q() {
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.qg()) {
                    com.byazt.gp.s.n(this.q, this.w, 1, 1, 0, com.byazt.vy.d.n());
                    return;
                }
                com.byazt.gp.s.n(this.q, this.w, 1, 0, 0, (String) null);
            }
            if (hu()) {
                return;
            }
            h();
            if (!n(1) && this.cy.n()) {
                this.cy.l();
            }
            com.byazt.me.n nVar = this.qg;
            if (nVar != null) {
                nVar.q();
                return;
            }
            return;
        }
        h();
        if (!n(1) && this.cy.n()) {
            com.byazt.rb.qg.qg("GROMORE_SS_REWARD_VERIFY", "onVideoComplete回调，M客户端调用M服务端激励回调.....");
            this.cy.l();
        }
        com.byazt.me.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.q();
        }
    }

    @Override // com.byazt.me.n
    public void l() {
        String strQg;
        long jCurrentTimeMillis;
        lh();
        ln();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.gp.s.n(this.q, this.w, (com.byazt.mj.n) null, 2, 0, strQg, jCurrentTimeMillis);
        com.byazt.me.n nVar = this.qg;
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // com.byazt.me.n
    public void n(com.byazt.fd.n nVar) {
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.qg()) {
                    com.byazt.gp.s.n(this.q, this.w, 4, 1, 0, com.byazt.vy.d.n());
                    return;
                } else {
                    com.byazt.gp.s.n(this.q, this.w, 4, 0, 0, com.byazt.vy.rv.w() ? com.byazt.vy.d.n() : null);
                }
            }
            if (hu()) {
                return;
            }
            s(nVar);
            return;
        }
        s(nVar);
    }

    private void s(com.byazt.fd.n nVar) {
        if (this.cy.n()) {
            this.cy.n(nVar, this.q);
        } else if (qg(n(this.w, nVar, this.q, (Map<String, Object>) null))) {
            n((com.byazt.fd.n) null, 0, 0);
        }
    }

    @Override // com.byazt.me.n
    public void w() {
        lh();
        ln();
        if (com.byazt.vy.rv.n()) {
            if (this.q != null && MediationConstant.ADN_PANGLE.equals(this.q.lq())) {
                if (!com.byazt.vy.rv.qg()) {
                    com.byazt.gp.s.n(this.q, this.w, 3, 1, 0, com.byazt.vy.d.n());
                    return;
                }
                com.byazt.gp.s.n(this.q, this.w, 3, 0, 0, (String) null);
            }
            if (hu()) {
                return;
            }
            h();
            if (this.cy.n()) {
                this.cy.qg();
            }
            com.byazt.me.n nVar = this.qg;
            if (nVar != null) {
                nVar.w();
                return;
            }
            return;
        }
        h();
        if (this.cy.n()) {
            this.cy.qg();
        }
        com.byazt.me.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.w();
        }
    }
}
