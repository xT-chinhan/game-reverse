package com.byazt.np;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.jp.cy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends qg implements com.byazt.kt.l {
    public com.byazt.vv.qg a;
    public List<WeakReference<View>> cd;
    public View cy;
    public WeakReference<View> hd;
    public boolean n;
    public boolean ou;
    public com.byazt.vv.q py;
    public boolean qg;
    public com.byazt.vv.s um;

    public View w() {
        return null;
    }

    public oa(Context context) {
        super(context);
        this.n = false;
        this.qg = false;
        this.hd = new WeakReference<>(null);
        this.cd = new ArrayList();
        this.ou = false;
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.jp.cp cpVar, com.byazt.vv.s sVar) {
        n(qgVar);
        this.s.n(cpVar);
        this.um = sVar;
        this.rv = this;
        this.s.v().put("ad_load_timeout", Integer.valueOf(qgVar.cy()));
        if (com.byazt.qt.qg.n().u()) {
            com.byazt.jp.tj.n(new cy() { // from class: com.byazt.np.oa.1
                @Override // com.byazt.jp.cy
                public void n() {
                    oa.this.rv();
                }
            });
        } else {
            rv();
        }
    }

    public void n(com.byazt.vv.qg qgVar) {
        this.a = qgVar;
    }

    public void n(com.byazt.vv.q qVar) {
        this.py = qVar;
    }

    public boolean py() {
        List<com.byazt.ws.tj> listQg;
        try {
            listQg = qg();
        } catch (Throwable unused) {
            listQg = null;
        }
        return com.byazt.vy.x.n(this.s.cp(), this.s.sz(), this.s.d(), this.w, this.d, this.l, this.w.l(), listQg);
    }

    public View ou() {
        Context context = this.fs != null ? this.fs.get() : null;
        if (this.cy == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            qg(frameLayout);
            this.cy = frameLayout;
            n(this.q);
        }
        return this.cy;
    }

    public void n(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean zWo = com.byazt.qt.qg.n().wo();
        if (zWo) {
            strArr[0] = com.byazt.vy.d.n();
        }
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.oa.2
            @Override // java.lang.Runnable
            public void run() {
                oa.this.qg(viewGroup);
                if (zWo) {
                    com.byazt.gp.s.n(oa.this.q, oa.this.w, strArr[0], 2);
                }
            }
        });
    }

    public void wm() {
        if (this.q.vo() && com.byazt.ra.n.n().q(this.l, this.q.el(), cd())) {
            com.byazt.ra.n.n().n(this.q.el(), this.w, this.s.v(), true, this.s.j(), this.s.fi(), this.fs.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(ViewGroup viewGroup) {
        boolean z;
        List<com.byazt.qa.x> listN;
        com.byazt.sg.s sVar;
        com.byazt.gp.s.n(this.w);
        List<com.byazt.ws.tj> listQg = null;
        if (this.d) {
            com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, 0);
            s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            return;
        }
        int iQg = qg(this.l);
        if (iQg != 0) {
            com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, iQg);
            s(new com.byazt.mj.n(iQg, com.byazt.mj.n.n(iQg)));
            return;
        }
        List<com.byazt.sg.s> listN2 = this.s.n(true);
        this.s.n(listN2);
        if (viewGroup != null) {
            try {
                listQg = qg();
            } catch (Throwable unused) {
            }
            if (listQg == null || listQg.size() <= 0) {
                z = false;
            } else {
                HashMap<String, com.byazt.sg.s> mapQg = qg(listN2);
                Iterator<com.byazt.ws.tj> it = listQg.iterator();
                while (true) {
                    if (it.hasNext()) {
                        com.byazt.ws.tj next = it.next();
                        if (next != null) {
                            String strCd = next.cd();
                            com.byazt.sg.s sVar2 = mapQg.get(strCd);
                            if (sVar2 != null && sVar2.ae(this.l) && !sVar2.nf()) {
                                n(sVar2, viewGroup);
                            } else if (next.a() && com.byazt.ra.n.n().q(this.l, strCd, cd()) && com.byazt.ra.n.n().n(strCd, this.w, false) == 3 && (listN = com.byazt.ra.n.n().n(strCd, this.w, cd())) != null && listN.size() > 0 && (sVar = listN.get(0).n) != null && sVar.ae(this.l) && !sVar.nf()) {
                                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show") + "adSlotId：" + sVar.el() + "，广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",isReady()：" + sVar.ae(this.l));
                                qg(sVar);
                                n(sVar, viewGroup);
                            }
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                }
            }
            boolean z2 = z;
            if (!z && listN2 != null && listN2.size() > 0) {
                for (com.byazt.sg.s sVar3 : listN2) {
                    if (sVar3 != null && sVar3.ae(this.l) && !sVar3.nf()) {
                        n(sVar3, viewGroup);
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.d = true;
                if (this.q != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.q);
                    com.byazt.em.n.n().n(this.w, com.byazt.em.n.n(this.w, arrayList, listN2));
                    n(arrayList);
                }
                com.byazt.gp.s.n(this.q, this.w, false, 0);
                return;
            }
            com.byazt.gp.s.n(listN2, this.w, 0);
            s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
            return;
        }
        com.byazt.gp.s.n(listN2, this.w, 0);
        s(new com.byazt.mj.n(40052, com.byazt.mj.n.n(40052)));
    }

    private void n(com.byazt.sg.s sVar, ViewGroup viewGroup) {
        this.q = sVar;
        if (this.qg) {
            this.q.ed();
        }
        if (this.oa != null) {
            this.q.n(this.oa);
        }
        if (this.sz != null) {
            this.q.n(this.sz);
        }
        this.s.q(this.q);
        this.q.l(true);
        this.q.n(this.rv);
        this.hd = new WeakReference<>(viewGroup);
        this.cd = com.byazt.gp.w.n(viewGroup);
        if (this.q.vo() && com.byazt.ra.n.n().q(this.l, this.q.el(), cd())) {
            com.byazt.yc.w.n(this.q, this.l, this.q.el());
        }
        com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, cd(), this.q);
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show") + "展示的广告类型：" + com.byazt.sg.n.n(this.q.he()) + ",slotId：" + this.q.el() + ",slotType:" + this.q.bz());
        com.byazt.bf.oa.n().qg(this.l);
        com.byazt.bf.d.n().qg(this.l, this.q.el());
        this.q.n(viewGroup);
    }

    @Override // com.byazt.np.qg
    public void s() {
        if (this.q == null) {
            com.byazt.ra.n.n().n(this.s.n(false), this.l, this.w, this.w.l(), this.q);
        }
        super.s();
    }

    @Override // com.byazt.np.qg
    public com.byazt.mj.s f_() {
        if (this.ou) {
            return super.f_();
        }
        return null;
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.vv.s sVar = this.um;
        if (sVar != null) {
            sVar.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        com.byazt.vv.s sVar = this.um;
        if (sVar != null) {
            sVar.n();
        }
    }

    @Override // com.byazt.kt.l
    public void n() {
        com.byazt.vv.q qVar = this.py;
        if (qVar != null) {
            qVar.n();
        }
    }

    @Override // com.byazt.kt.l
    public void k_() {
        com.byazt.vv.q qVar = this.py;
        if (qVar != null) {
            qVar.qg();
        }
    }

    @Override // com.byazt.kt.l
    public Activity getActivity() {
        com.byazt.vv.q qVar = this.py;
        if (qVar != null) {
            return qVar.getActivity();
        }
        return null;
    }

    @Override // com.byazt.kt.l
    public void l_() {
        com.byazt.vv.q qVar = this.py;
        if (qVar != null) {
            qVar.s();
        }
    }

    @Override // com.byazt.vv.qg
    public void q() {
        String strQg;
        long jCurrentTimeMillis;
        com.byazt.vv.qg qgVar = this.a;
        if (qgVar != null) {
            qgVar.q();
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

    @Override // com.byazt.vv.qg
    public void l() {
        String strQg;
        long jCurrentTimeMillis;
        this.ou = true;
        com.byazt.vv.qg qgVar = this.a;
        if (qgVar != null) {
            qgVar.l();
        }
        com.byazt.bf.oa.n().x(this.l);
        if (this.q != null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show_listen") + "adSlotId：" + this.q.el() + "，广告类型：" + com.byazt.sg.n.n(this.q.he()));
            com.byazt.bf.cp.n().qg(this.l, this.q.el());
        }
        if (this.q != null) {
            com.byazt.bw.s.n(this.q.ci(), this.l, this.q.el());
        }
        wm();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (com.byazt.vy.d.n(this.q)) {
            strQg = com.byazt.vy.d.qg();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strQg = null;
            jCurrentTimeMillis = -1;
        }
        String str = strQg;
        long j = jCurrentTimeMillis;
        View view = this.hd.get();
        if (view instanceof ViewGroup) {
            com.byazt.gp.w.n((ViewGroup) view, this.cd);
        }
        com.byazt.gp.s.n(this.q, this.w, 0, str, j, false, a(), this.hd.get());
        com.byazt.mv.n.x(this.w.a());
        com.byazt.mv.n.s(this.w.a());
        com.byazt.cby.q.n(1, this.w.a(), this.q.ct(), this.q.ta());
        com.byazt.sq.s.n(this.l, this.q);
    }

    @Override // com.byazt.vv.qg
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

    @Override // com.byazt.vv.qg
    public void n(int i) {
        com.byazt.vv.qg qgVar = this.a;
        if (qgVar != null) {
            qgVar.n(1);
        }
        if (this.w == null || !this.w.nf()) {
            com.byazt.qa.q.n().n(this.fs.get(), this.l, cd());
        }
    }

    @Override // com.byazt.vv.qg
    public void qg(int i) {
        com.byazt.vv.qg qgVar = this.a;
        if (qgVar != null) {
            qgVar.qg(i);
        }
        if (this.w == null || !this.w.nf()) {
            com.byazt.qa.q.n().n(this.fs.get(), this.l, cd());
        }
    }

    public void n(ViewGroup viewGroup, Activity activity) {
        if (this.q != null) {
            this.q.n(viewGroup, activity);
        }
    }

    private void s(final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.oa.3
            @Override // java.lang.Runnable
            public void run() {
                if (oa.this.a != null) {
                    oa.this.a.n(nVar);
                }
            }
        });
    }

    public void m() {
        this.qg = true;
    }
}
