package com.byazt.np;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 13})
public class w extends qg implements com.byazt.kt.n {
    public boolean cy;
    public com.byazt.gl.q hd;
    public com.byazt.gl.n n;
    public com.byazt.gl.qg qg;

    public w(Context context) {
        super(context);
        this.cy = false;
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.gl.qg qgVar2) {
        n(qgVar);
        this.rv = this;
        this.qg = qgVar2;
        rv();
    }

    public void n(com.byazt.gl.q qVar) {
        this.hd = qVar;
    }

    public void n(com.byazt.gl.n nVar) {
        this.n = nVar;
    }

    private View n(Context context, com.byazt.sg.s sVar) {
        this.q = sVar;
        this.s.q(this.q);
        this.q.l(true);
        this.q.n(this.rv);
        if (this.q.vo() && com.byazt.ra.n.n().q(this.l, this.q.el(), this.w.l())) {
            com.byazt.yc.w.n(this.q, this.l, this.q.el());
        }
        n(false);
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show") + "展示的广告类型：" + com.byazt.sg.n.n(this.q.he()) + ",slotId：" + this.q.el() + ",slotType:" + this.q.bz());
        final View viewRv = this.q.rv();
        if (!this.q.rg() && this.q.dg() == 4 && !this.q.kc()) {
            com.byazt.gl.q qVar = this.hd;
            if (qVar != null) {
                try {
                    viewRv = qVar.n(s(this.q));
                    if (viewRv == null) {
                        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable unused) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                }
            } else {
                com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            }
        }
        if (this.q.a() && context != null) {
            this.q.n((Activity) context, new com.byazt.lr.n(null) { // from class: com.byazt.np.w.1
                @Override // com.byazt.lr.n
                public void n(int i, String str, boolean z) {
                    View view = viewRv;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(viewRv);
                        }
                    }
                }
            });
        }
        return viewRv;
    }

    public synchronized View n(Context context) {
        List<com.byazt.ws.tj> listQg;
        View viewN;
        com.byazt.sg.s next;
        List<com.byazt.qa.x> listN;
        com.byazt.sg.s sVar;
        com.byazt.gp.s.n(this.w);
        if (this.d) {
            com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, 0);
            s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            return null;
        }
        int iQg = qg(this.l);
        if (iQg != 0) {
            com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, iQg);
            s(new com.byazt.mj.n(iQg, com.byazt.mj.n.n(iQg)));
            return null;
        }
        List<com.byazt.sg.s> listN2 = this.s.n(true);
        this.s.n(listN2);
        try {
            listQg = qg();
        } catch (Throwable unused) {
            listQg = null;
        }
        if (listQg != null && listQg.size() > 0) {
            HashMap<String, com.byazt.sg.s> mapQg = qg(listN2);
            viewN = null;
            for (com.byazt.ws.tj tjVar : listQg) {
                if (tjVar != null) {
                    String strCd = tjVar.cd();
                    com.byazt.sg.s sVar2 = mapQg.get(strCd);
                    if (sVar2 != null && sVar2.ae(this.l) && !sVar2.nf() && (viewN = n(context, sVar2)) != null) {
                        break;
                    }
                    if (tjVar.a() && com.byazt.ra.n.n().q(this.l, strCd, this.w.l()) && com.byazt.ra.n.n().n(strCd, this.w, false) == 3 && (listN = com.byazt.ra.n.n().n(strCd, this.w, this.w.l())) != null && listN.size() > 0 && (sVar = listN.get(0).n) != null && sVar.ae(this.l) && !sVar.nf()) {
                        qg(sVar);
                        viewN = n(context, sVar);
                        if (viewN != null) {
                            break;
                        }
                    }
                }
            }
        } else {
            viewN = null;
        }
        if (viewN == null && listN2 != null && listN2.size() > 0) {
            Iterator<com.byazt.sg.s> it = listN2.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.ae(this.l) || next.nf() || (viewN = n(context, next)) == null)) {
            }
        }
        if (viewN != null) {
            this.d = true;
            List<com.byazt.sg.s> listN3 = this.s.n(true);
            com.byazt.ra.n.n().n(listN3, this.l, this.w, this.w.l(), this.q);
            if (this.q != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.q);
                com.byazt.em.n.n().n(this.w, com.byazt.em.n.n(this.w, arrayList, listN3));
                n(arrayList);
            }
            com.byazt.gp.s.n(this.q, this.w, false, 0);
            return viewN;
        }
        com.byazt.gp.s.n(listN2, this.w, 0);
        s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
        return null;
    }

    private void n(boolean z) {
        if (this.q != null && this.q.vo() && com.byazt.ra.n.n().q(this.l, this.q.el(), this.w.l())) {
            com.byazt.ra.n.n().n(this.q.el(), this.w, this.s.v(), z, this.s.j(), this.s.fi(), this.fs.get());
        }
    }

    public boolean q() {
        List<com.byazt.ws.tj> listQg;
        try {
            listQg = qg();
        } catch (Throwable unused) {
            listQg = null;
        }
        return com.byazt.vy.x.n(this.s.cp(), this.s.sz(), this.s.d(), this.w, this.d, this.l, this.w.l(), listQg);
    }

    public int l() {
        if (this.q != null) {
            return this.q.dn();
        }
        return 0;
    }

    public void w() {
        if (this.q != null) {
            this.q.hd();
        }
    }

    public void py() {
        if (this.q != null) {
            this.q.cy();
        }
    }

    @Override // com.byazt.np.qg
    public void s() {
        if (!this.d) {
            com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, this.w.l(), this.q);
        }
        super.s();
        this.n = null;
        this.qg = null;
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.gl.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        com.byazt.gl.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    @Override // com.byazt.gl.n
    public void n() {
        com.byazt.gl.n nVar = this.n;
        if (nVar != null) {
            nVar.n();
        }
    }

    @Override // com.byazt.gl.n
    public void n(View view) {
        String strQg;
        long jCurrentTimeMillis;
        com.byazt.gl.n nVar = this.n;
        if (nVar != null) {
            nVar.n(view);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.mv.n.l(this.w.a());
        com.byazt.gp.s.n(this.q, this.w, 0, strQg, jCurrentTimeMillis, this.q.v());
    }

    @Override // com.byazt.gl.n
    public void qg(View view) {
        long jCurrentTimeMillis;
        String str;
        this.cy = true;
        com.byazt.gp.w.n(view);
        if (this.n != null) {
            com.byazt.bf.oa.n().x(this.l);
            com.byazt.bf.oa.n().qg(this.l);
            this.n.qg(view);
        }
        if (this.q != null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show_listen") + "adSlotId：" + this.q.el() + "，广告类型：" + com.byazt.sg.n.n(this.q.he()));
            com.byazt.bf.cp.n().qg(this.l, this.q.el());
            com.byazt.bf.d.n().qg(this.l, this.q.el());
        }
        if (this.q != null) {
            com.byazt.bw.s.n(this.q.ci(), this.l, this.q.el());
        }
        n(true);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            String strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str = strQg;
        } else {
            jCurrentTimeMillis = -1;
            str = null;
        }
        long j = jCurrentTimeMillis;
        View viewRv = this.q != null ? this.q.rv() : null;
        com.byazt.gp.w.n(viewRv);
        com.byazt.gp.s.n(this.q, this.w, 0, str, j, false, a(), viewRv);
        com.byazt.mv.n.x(this.w.a());
        com.byazt.mv.n.s(this.w.a());
        com.byazt.cby.q.n(1, this.w.a(), this.q.ct(), this.q.ta());
        com.byazt.sq.s.n(this.l, this.q);
    }

    @Override // com.byazt.gl.n
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

    private void s(final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.n != null) {
                    w.this.n.n(nVar);
                }
            }
        });
    }

    @Override // com.byazt.np.qg
    public com.byazt.mj.s f_() {
        if (this.cy) {
            return super.f_();
        }
        return null;
    }

    public void n(Activity activity, com.byazt.lr.n nVar) {
        if (this.q != null) {
            this.q.n(activity, nVar);
        }
    }

    public void n(Dialog dialog, Integer[] numArr) {
        if (this.q != null) {
            this.q.n(dialog, numArr);
        }
    }

    public com.byazt.fvm.x n(Activity activity) {
        if (this.q != null) {
            return this.q.n(activity);
        }
        return null;
    }

    public com.byazt.fvm.q ou() {
        if (this.q != null) {
            return this.q.qd();
        }
        return null;
    }

    private com.byazt.gl.s s(final com.byazt.sg.s sVar) {
        return new com.byazt.gl.s() { // from class: com.byazt.np.w.3
            @Override // com.byazt.gl.s
            public String n() {
                return sVar.ca();
            }

            @Override // com.byazt.gl.s
            public String qg() {
                return sVar.eq();
            }

            @Override // com.byazt.gl.s
            public String s() {
                return sVar.ox();
            }

            @Override // com.byazt.gl.s
            public String q() {
                return sVar.lg();
            }

            @Override // com.byazt.gl.s
            public double l() {
                return sVar.iz();
            }

            @Override // com.byazt.gl.s
            public List<String> w() {
                return sVar.qh();
            }

            @Override // com.byazt.gl.s
            public String x() {
                return sVar.of();
            }

            @Override // com.byazt.gl.s
            public int fs() {
                return sVar.dn();
            }

            @Override // com.byazt.gl.s
            public int rv() {
                return sVar.z();
            }

            @Override // com.byazt.gl.s
            public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.fz.d dVar) {
                sVar.n(activity, viewGroup, list, list2, list3, dVar, null);
            }

            @Override // com.byazt.gl.s
            public com.byazt.fz.n tj() {
                if (!sVar.vb()) {
                    return null;
                }
                com.byazt.fz.n nVar = new com.byazt.fz.n();
                nVar.q(sVar.fl());
                nVar.l(sVar.i());
                nVar.n(sVar.dw());
                nVar.w(sVar.su());
                nVar.x(sVar.ha());
                nVar.fs(sVar.g());
                nVar.n(sVar.ry());
                nVar.qg(sVar.ju());
                nVar.s(sVar.sh());
                nVar.n(sVar.pk());
                nVar.qg(sVar.wo());
                return nVar;
            }

            @Override // com.byazt.gl.s
            public boolean cp() {
                return sVar.a();
            }

            @Override // com.byazt.gl.s
            public com.byazt.jp.qg n(Activity activity) {
                return n(activity, (Map<String, Object>) null);
            }

            @Override // com.byazt.gl.s
            public com.byazt.jp.qg n(Activity activity, Map<String, Object> map) {
                final com.byazt.fvm.x xVarN = sVar.n(activity);
                return new com.byazt.jp.qg() { // from class: com.byazt.np.w.3.1
                    @Override // com.byazt.jp.qg
                    public void n() {
                        com.byazt.fvm.x xVar = xVarN;
                        if (xVar != null) {
                            xVar.n();
                        }
                    }

                    @Override // com.byazt.jp.qg
                    public void n(final com.byazt.jp.x xVar) {
                        com.byazt.fvm.x xVar2 = xVarN;
                        if (xVar2 != null) {
                            xVar2.n(new com.byazt.lr.n(null) { // from class: com.byazt.np.w.3.1.1
                                @Override // com.byazt.lr.n
                                public void n() {
                                    com.byazt.jp.x xVar3 = xVar;
                                    if (xVar3 != null) {
                                        xVar3.qg();
                                    }
                                }

                                @Override // com.byazt.lr.n
                                public void n(int i, String str, boolean z) {
                                    com.byazt.jp.x xVar3 = xVar;
                                    if (xVar3 != null) {
                                        xVar3.n(i, str);
                                    }
                                }

                                @Override // com.byazt.lr.n
                                public void qg() {
                                    com.byazt.jp.x xVar3 = xVar;
                                    if (xVar3 != null) {
                                        xVar3.n();
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.byazt.gl.s
            public void n(Activity activity, com.byazt.lr.n nVar) {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(activity, nVar);
                }
            }

            @Override // com.byazt.gl.s
            public void n(Dialog dialog, Integer[] numArr) {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(dialog, numArr);
                }
            }

            @Override // com.byazt.gl.s
            public com.byazt.fvm.x qg(Activity activity) {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 != null) {
                    return sVar2.n(activity);
                }
                return null;
            }

            @Override // com.byazt.gl.s
            public com.byazt.fvm.x qg(Dialog dialog, Integer[] numArr) {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 != null) {
                    return sVar2.qg(dialog, numArr);
                }
                return null;
            }

            @Override // com.byazt.gl.s
            public com.byazt.fvm.q d() {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 != null) {
                    return sVar2.qd();
                }
                return null;
            }
        };
    }

    public void q(String str) {
        if (this.q != null) {
            this.q.f(str);
        }
    }

    public void n(com.byazt.mi.s sVar) {
        if (this.q != null) {
            this.q.n(sVar);
        }
    }

    public void n(com.byazt.fx.s sVar) {
        if (this.q != null) {
            this.q.n(sVar);
        }
    }

    public void qg(com.byazt.mi.qg qgVar) {
        if (this.q != null) {
            this.q.n(qgVar);
        }
    }
}
