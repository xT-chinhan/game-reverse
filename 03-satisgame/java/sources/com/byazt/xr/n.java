package com.byazt.xr;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.bf.oa;
import com.byazt.cy.cp;
import com.byazt.fvm.l;
import com.byazt.fvm.rv;
import com.byazt.fz.tj;
import com.byazt.gp.w;
import com.byazt.np.x;
import com.byazt.vy.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 685, 19})
public class n extends rv {
    public com.byazt.mi.qg fs;
    public com.byazt.dc.s l;
    public x n;
    public View q;
    public com.byazt.sg.s qg;
    public com.byazt.qn.qg s;
    public com.byazt.dc.n w;
    public com.byazt.wn.n x;

    @Override // com.byazt.fvm.oa
    public String hu() {
        return null;
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.q qVar) {
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.qg qgVar) {
    }

    @Override // com.byazt.fvm.tj
    public void n(com.byazt.wn.qg qgVar) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    public n(x xVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar) {
        this.n = xVar;
        this.qg = sVar;
        this.s = qgVar;
        t();
    }

    private void t() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(new tj() { // from class: com.byazt.xr.n.1
                @Override // com.byazt.fz.tj
                public void n() {
                    if (n.this.x != null) {
                        n.this.x.n(n.this);
                    }
                }

                @Override // com.byazt.fz.tj
                public void qg() {
                    if (n.this.x != null) {
                        n.this.x.qg(n.this);
                    }
                }

                @Override // com.byazt.fz.tj
                public void s() {
                    if (n.this.x != null) {
                        n.this.x.s(n.this);
                    }
                }

                @Override // com.byazt.fz.tj
                public void q() {
                    if (n.this.x != null) {
                        n.this.x.q(n.this);
                    }
                }

                @Override // com.byazt.fz.tj
                public void l() {
                    if (n.this.x != null) {
                        n.this.x.l(n.this);
                    }
                }

                @Override // com.byazt.fz.tj
                public void n(com.byazt.mj.n nVar) {
                    String strQg;
                    long jCurrentTimeMillis;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (d.n(n.this.qg)) {
                        strQg = d.qg();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strQg = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.byazt.gp.s.n(n.this.qg, n.this.s, (com.byazt.mj.n) null, 2, 0, strQg, jCurrentTimeMillis);
                    if (nVar == null || n.this.x == null) {
                        return;
                    }
                    n.this.x.n(nVar.n, -1);
                }

                @Override // com.byazt.fz.tj
                public void n(long j, long j2) {
                    if (n.this.x != null) {
                        n.this.x.n(j, j2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fvm.rv
    public void n(boolean z) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.tj(z);
        }
    }

    @Override // com.byazt.fvm.rv
    public void n(Bitmap bitmap, int i) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(bitmap, i);
        }
    }

    @Override // com.byazt.fvm.rv
    public void n(com.byazt.vd.n nVar) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(nVar);
        }
    }

    @Override // com.byazt.fvm.tj
    public void n(com.byazt.wn.n nVar) {
        this.x = nVar;
    }

    @Override // com.byazt.fvm.tj
    public double n() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.on();
        }
        return 0.0d;
    }

    @Override // com.byazt.fvm.tj
    public com.byazt.slh.n qg() {
        return new com.byazt.co.qg(this.qg);
    }

    @Override // com.byazt.fvm.tj
    public int s() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            if (sVar.kc()) {
                View view = this.q;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.byazt.sg.s sVar2 = this.qg;
            if (sVar2 != null) {
                return sVar2.wf();
            }
        }
        return 0;
    }

    @Override // com.byazt.fvm.tj
    public int q() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            if (sVar.kc()) {
                View view = this.q;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.byazt.sg.s sVar2 = this.qg;
            if (sVar2 != null) {
                return sVar2.lr();
            }
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.d l() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.es();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public Bitmap w() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.dx();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public String x() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.ca();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public String fs() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.tr();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public String rv() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.lg();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public int tj() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return (int) sVar.iz();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public int cp() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.yp();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public int d() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.xb();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public String oa() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.of();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.d sz() {
        com.byazt.sg.s sVar = this.qg;
        return new cp(sVar != null ? sVar.eq() : "");
    }

    @Override // com.byazt.fvm.oa
    public List<com.byazt.fvm.d> k() {
        ArrayList arrayList = new ArrayList();
        com.byazt.sg.s sVar = this.qg;
        List<String> listQh = sVar != null ? sVar.qh() : null;
        com.byazt.sg.s sVar2 = this.qg;
        String strOx = sVar2 != null ? sVar2.ox() : null;
        if (listQh != null) {
            if (listQh.size() != 0) {
                Iterator<String> it = listQh.iterator();
                while (it.hasNext()) {
                    arrayList.add(new cp(it.next()));
                }
            } else if (!TextUtils.isEmpty(strOx)) {
                com.byazt.sg.s sVar3 = this.qg;
                int iXd = sVar3 != null ? sVar3.xd() : 0;
                com.byazt.sg.s sVar4 = this.qg;
                arrayList.add(new cp(strOx, iXd, sVar4 != null ? sVar4.ti() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fvm.oa
    public int cy() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.z();
        }
        return -1;
    }

    @Override // com.byazt.fvm.oa
    public int hd() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.dn();
        }
        return -1;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.q cd() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.qd();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.s um() {
        return new com.byazt.co.n(this.qg);
    }

    @Override // com.byazt.fvm.oa
    public l a() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.ki();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public View py() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return null;
        }
        if (sVar.kc()) {
            com.byazt.gp.s.n(this.s);
            if (this.qg.du() != null) {
                this.qg.du().n();
            }
            View viewRv = this.qg.rv();
            this.q = viewRv;
            w.n(viewRv);
            com.byazt.sg.s sVar2 = this.qg;
            com.byazt.gp.s.n(sVar2, this.s, sVar2.ln(), 0);
            return this.q;
        }
        return this.qg.tj();
    }

    @Override // com.byazt.fvm.oa
    public Map<String, Object> ou() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return null;
        }
        Map<String, Object> mapBb = sVar.bb();
        if (mapBb == null) {
            com.byazt.qn.qg qgVar = this.s;
            mapBb = com.byazt.np.qg.s(qgVar != null ? qgVar.a() : "");
        }
        if (this.qg.pe() && com.byazt.vy.tj.n()) {
            String strN = com.byazt.vy.tj.n(com.byazt.vy.x.n(this.s, this.qg, true));
            if (!TextUtils.isEmpty(strN)) {
                mapBb.put("get_show_ecpm_info", strN);
            }
        }
        return com.byazt.qu.qg.n(mapBb, this.qg.dh());
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.x n(Activity activity) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.n(activity);
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.x n(Dialog dialog, Integer[] numArr) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.qg(dialog, numArr);
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, View view, com.byazt.dc.n nVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        n(viewGroup, (List<View>) null, arrayList, (List<View>) null, (List<View>) null, (View) null, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.dc.n nVar) {
        n(viewGroup, (List<View>) null, list, list2, (List<View>) null, (View) null, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.dc.n nVar) {
        n(viewGroup, (List<View>) null, list, list2, (List<View>) null, view, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.dc.n nVar) {
        n(viewGroup, list, list2, list3, (List<View>) null, view, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4, final View view, com.byazt.dc.n nVar) {
        bb();
        if (this.qg != null) {
            n(nVar);
            n(false, new Handler.Callback() { // from class: com.byazt.xr.n.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (TextUtils.equals(n.this.qg.lq(), MediationConstant.ADN_PANGLE)) {
                        n.this.qg.n(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    n.this.qg.n(null, viewGroup, list2, list3, list4, null, list);
                    return false;
                }
            });
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, com.byazt.dc.n nVar, final com.byazt.he.q qVar) {
        bb();
        if (this.qg != null) {
            n(nVar);
            n(true, new Handler.Callback() { // from class: com.byazt.xr.n.3
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    n.this.qg.n(activity, viewGroup, list, list2, list3, com.byazt.fz.d.n(qVar), null);
                    return false;
                }
            });
        }
    }

    private void bb() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null || !sVar.kc()) {
            return;
        }
        com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.ux.qg.REGISTER_VIEW_TIP);
    }

    private void ln() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null || sVar.kc()) {
            return;
        }
        com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.ux.qg.RENDER_TIP);
    }

    private void n(com.byazt.dc.n nVar) {
        this.w = nVar;
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.mi.s sVar) {
        com.byazt.sg.s sVar2 = this.qg;
        if (sVar2 != null) {
            sVar2.n(sVar);
        }
    }

    @Override // com.byazt.fvm.oa
    public void qg(Activity activity) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.qg(activity);
        }
    }

    @Override // com.byazt.fvm.oa
    public void wm() {
        ln();
        if (this.qg != null) {
            lh();
            this.qg.cp();
            n(this.qg);
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.s sVar) {
        this.l = sVar;
    }

    @Override // com.byazt.fvm.oa
    public void n(Activity activity, com.byazt.lr.n nVar) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null || activity == null) {
            return;
        }
        sVar.n(activity, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void qg(Dialog dialog, Integer[] numArr) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(dialog, numArr);
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(String str) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.f(str);
        }
    }

    @Override // com.byazt.fvm.oa
    public void m() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            try {
                sVar.cd();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.nq.l h() {
        return new com.byazt.cy.tj(new qg(this.n, this.qg, this.s));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        this.fs = qgVar;
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(qgVar);
        }
    }

    private void n(boolean z, Handler.Callback callback) {
        com.byazt.gp.s.n(this.s);
        if (this.qg != null) {
            lh();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.qg.du() != null) {
                this.qg.du().n();
            }
            n(this.qg);
            HashMap map = new HashMap();
            map.put("has_view_binder", Boolean.valueOf(z));
            com.byazt.sg.s sVar = this.qg;
            com.byazt.gp.s.n(sVar, this.s, sVar.ln(), 0, map);
            return;
        }
        com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.s, 0);
    }

    private void lh() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        if (sVar.kc()) {
            this.qg.n((com.byazt.us.n) new com.byazt.us.q() { // from class: com.byazt.xr.n.4
                @Override // com.byazt.us.q
                public void n(View view, String str, int i) {
                    if (n.this.l instanceof com.byazt.he.l) {
                        ((com.byazt.he.l) n.this.l).n(view, str, i);
                    }
                }

                @Override // com.byazt.us.q
                public void n(float f, float f2) {
                    if (n.this.l != null) {
                        n.this.l.n(n.this.q, f, f2, true);
                    }
                }

                @Override // com.byazt.us.n
                public void n(View view) {
                    n.this.n(view);
                }

                @Override // com.byazt.us.n
                public void n() {
                    n.this.v();
                }
            });
        } else {
            this.qg.n(new com.byazt.us.n() { // from class: com.byazt.xr.n.5
                @Override // com.byazt.us.n
                public void n(View view) {
                    n.this.n(view);
                }

                @Override // com.byazt.us.n
                public void n() {
                    n.this.v();
                }
            });
        }
    }

    private void n(com.byazt.sg.s sVar) {
        if (com.byazt.qt.qg.n().wo()) {
            com.byazt.gp.s.n(sVar, this.s, d.n(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        String strQg;
        long jCurrentTimeMillis;
        com.byazt.dc.s sVar = this.l;
        if (sVar instanceof com.byazt.he.l) {
            ((com.byazt.he.l) sVar).n();
        }
        com.byazt.dc.n nVar = this.w;
        if (nVar != null) {
            nVar.n(view, this);
        }
        if (this.qg == null || this.s == null) {
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (d.n(this.qg)) {
            strQg = d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.mv.n.l(this.s.a());
        com.byazt.sg.s sVar2 = this.qg;
        com.byazt.gp.s.n(sVar2, this.s, 0, strQg, jCurrentTimeMillis, sVar2.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.byazt.sg.s sVar;
        String strQg;
        long jCurrentTimeMillis;
        if (this.s == null || (sVar = this.qg) == null) {
            return;
        }
        sVar.w(true);
        com.byazt.dc.s sVar2 = this.l;
        if (sVar2 instanceof com.byazt.he.l) {
            ((com.byazt.he.l) sVar2).qg();
        }
        com.byazt.dc.n nVar = this.w;
        if (nVar != null) {
            nVar.n(this);
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.s.a(), "show_listen") + "adSlotId：" + this.qg.el() + "，广告类型：" + com.byazt.sg.n.n(this.qg.he()));
        oa.n().x(this.s.a());
        oa.n().qg(this.s.a());
        com.byazt.bf.cp.n().qg(this.s.a(), this.qg.el());
        com.byazt.bf.d.n().qg(this.s.a(), this.qg.el());
        com.byazt.bw.s.n(this.qg.ci(), this.s.a(), this.qg.el());
        if (this.qg.du() != null) {
            this.qg.du().n(this.qg);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (d.n(this.qg)) {
            strQg = d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        String str = strQg;
        long j = jCurrentTimeMillis;
        boolean zLh = this.qg.lh();
        if (!zLh) {
            com.byazt.mv.n.x(this.s.a());
            com.byazt.mv.n.s(this.s.a());
            com.byazt.cby.q.n(1, this.s.a(), this.qg.ct(), this.qg.ta());
        }
        com.byazt.sg.s sVar3 = this.qg;
        com.byazt.gp.s.n(sVar3, this.s, 0, str, j, zLh, 1, com.byazt.by.n.n(sVar3, this.q));
        com.byazt.qn.qg qgVar = this.s;
        com.byazt.sq.s.n(qgVar != null ? qgVar.a() : "", this.qg);
    }
}
