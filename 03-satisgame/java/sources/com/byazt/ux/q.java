package com.byazt.ux;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.bf.cp;
import com.byazt.bf.oa;
import com.byazt.fvm.sz;
import com.byazt.fz.tj;
import com.byazt.np.rv;
import com.byazt.vy.d;
import com.byazt.vy.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 727, 5})
public class q extends sz {
    public com.byazt.he.qg fs;
    public com.byazt.fx.s l;
    public rv n;
    public View q;
    public com.byazt.sg.s qg;
    public com.byazt.mi.qg rv;
    public com.byazt.qn.qg s;
    public com.byazt.fx.qg w;
    public com.byazt.mi.s x;

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.sz
    public void n(JSONObject jSONObject) {
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.sz
    public String tj() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void x() {
    }

    public q(rv rvVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, com.byazt.he.qg qgVar2) {
        this.n = rvVar;
        this.fs = qgVar2;
        this.qg = sVar;
        if (sVar != null && sVar.dg() == 3) {
            this.qg.x(true);
        }
        this.s = qgVar;
        cp();
    }

    private void cp() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        sVar.n(new tj() { // from class: com.byazt.ux.q.1
            @Override // com.byazt.fz.tj
            public void n() {
                if (q.this.l != null) {
                    q.this.l.n();
                }
            }

            @Override // com.byazt.fz.tj
            public void qg() {
                if (q.this.l != null) {
                    q.this.l.qg();
                }
            }

            @Override // com.byazt.fz.tj
            public void s() {
                if (q.this.l != null) {
                    q.this.l.s();
                }
            }

            @Override // com.byazt.fz.tj
            public void q() {
                if (q.this.l != null) {
                    q.this.l.q();
                }
            }

            @Override // com.byazt.fz.tj
            public void l() {
                if (q.this.l != null) {
                    q.this.l.l();
                }
            }

            @Override // com.byazt.fz.tj
            public void n(com.byazt.mj.n nVar) {
                String strQg;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (d.n(q.this.qg)) {
                    strQg = d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strQg = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.gp.s.n(q.this.qg, q.this.s, (com.byazt.mj.n) null, 2, 0, strQg, jCurrentTimeMillis);
                if (nVar == null || q.this.l == null) {
                    return;
                }
                q.this.l.n(nVar.n, -1);
            }

            @Override // com.byazt.fz.tj
            public void n(long j, long j2) {
                if (q.this.l != null) {
                    q.this.l.n(j, j2);
                }
            }
        });
        this.qg.n(new com.byazt.kv.qg() { // from class: com.byazt.ux.q.2
            @Override // com.byazt.kv.qg
            public void qg() {
            }

            @Override // com.byazt.kv.qg
            public void n() {
                if (q.this.x != null) {
                    q.this.x.n();
                }
            }

            @Override // com.byazt.kv.qg
            public void n(long j, long j2, int i, int i2, String str, String str2) {
                if (q.this.x != null) {
                    q.this.x.n(j, j2, str, str2);
                }
            }

            @Override // com.byazt.kv.qg
            public void n(long j, long j2, String str, String str2) {
                if (q.this.x != null) {
                    q.this.x.qg(j, j2, str, str2);
                }
            }

            @Override // com.byazt.kv.qg
            public void qg(long j, long j2, String str, String str2) {
                if (q.this.x != null) {
                    q.this.x.s(j, j2, str, str2);
                }
            }

            @Override // com.byazt.kv.qg
            public void n(long j, String str, String str2) {
                if (q.this.x != null) {
                    q.this.x.n(j, str, str2);
                }
            }

            @Override // com.byazt.kv.qg
            public void n(String str, String str2) {
                if (q.this.x != null) {
                    q.this.x.n(str, str2);
                }
            }
        });
    }

    @Override // com.byazt.fvm.sz
    public int s() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.z();
        }
        return -1;
    }

    @Override // com.byazt.fvm.sz
    public View n() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            if (sVar.kc()) {
                com.byazt.gp.s.n(this.s);
                if (this.qg.du() != null) {
                    this.qg.du().n();
                }
                View viewRv = this.qg.rv();
                this.q = viewRv;
                com.byazt.gp.w.n(viewRv);
                com.byazt.sg.s sVar2 = this.qg;
                com.byazt.gp.s.n(sVar2, this.s, sVar2.ln(), 0);
                return this.q;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.qg);
            com.byazt.gp.s.n(arrayList, this.s, 0);
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public int qg() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.dn();
        }
        return -1;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.qg qgVar) {
        this.w = qgVar;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.n nVar) {
        this.w = nVar;
    }

    @Override // com.byazt.fvm.sz
    public Map<String, Object> fs() {
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
            String strN = com.byazt.vy.tj.n(x.n(this.s, this.qg, true));
            if (!TextUtils.isEmpty(strN)) {
                mapBb.put("get_show_ecpm_info", strN);
            }
        }
        return com.byazt.qu.qg.n(mapBb, this.qg.dh());
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.mi.s sVar) {
        this.x = sVar;
    }

    @Override // com.byazt.fvm.sz
    public void q() {
        com.byazt.fx.qg qgVar;
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            if (sVar.kc()) {
                hd();
                this.qg.cp();
                n(this.qg);
                if (this.qg.dg() != 3 || (qgVar = this.w) == null) {
                    return;
                }
                qgVar.n((View) null, -1.0f, -2.0f);
                return;
            }
            com.byazt.he.qg qgVar2 = this.fs;
            if (qgVar2 != null) {
                try {
                    View viewN = qgVar2.n(new com.byazt.cy.rv(this.qg) { // from class: com.byazt.ux.q.3
                        @Override // com.byazt.cy.rv, com.byazt.suf.n
                        public void n(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.byazt.he.q qVar) {
                            q.this.n(true, new Handler.Callback() { // from class: com.byazt.ux.q.3.1
                                @Override // android.os.Handler.Callback
                                public boolean handleMessage(Message message) {
                                    if (q.this.qg == null) {
                                        return false;
                                    }
                                    q.this.qg.n(activity, viewGroup, list, list2, list3, com.byazt.fz.d.n(qVar), null);
                                    return false;
                                }
                            });
                        }
                    });
                    this.q = viewN;
                    if (viewN == null) {
                        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()返回null，将无法展示该广告");
                        com.byazt.fx.qg qgVar3 = this.w;
                        if (qgVar3 != null) {
                            qgVar3.n((View) null, "渲染失败", com.anythink.core.common.l.q.o);
                            return;
                        }
                        return;
                    }
                    com.byazt.fx.qg qgVar4 = this.w;
                    if (qgVar4 != null) {
                        qgVar4.n(viewN, 0.0f, 0.0f);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    return;
                }
            }
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 自渲染信息流转模板，开发者未提供MediationNativeToBannerListener，将无法展示该广告");
        }
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.fvm.q w() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.qd();
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.fvm.x n(Activity activity) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            return sVar.n(activity);
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void n(Activity activity, com.byazt.lr.n nVar) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null || activity == null) {
            return;
        }
        sVar.n(activity, nVar);
    }

    @Override // com.byazt.fvm.sz
    public void n(Dialog dialog, Integer[] numArr) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(dialog, numArr);
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(String str) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.f(str);
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(int i) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.wm(i);
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.s sVar) {
        this.l = sVar;
    }

    @Override // com.byazt.fvm.sz
    public void n(boolean z) {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.tj(z);
        }
    }

    @Override // com.byazt.fvm.sz
    public void l() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            try {
                sVar.cd();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.fvm.sz
    public com.byazt.nq.l rv() {
        return new com.byazt.cy.tj(new s(this.n, this.qg, this.s));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        this.rv = qgVar;
        com.byazt.sg.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(qgVar);
        }
    }

    private void d() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        sVar.n((com.byazt.kt.w) new com.byazt.kt.n() { // from class: com.byazt.ux.q.4
            @Override // com.byazt.gl.n
            public void n(com.byazt.mj.n nVar) {
            }

            @Override // com.byazt.gl.n
            public void n() {
                if (q.this.qg.um() != null) {
                    q.this.qg.um().n(0, "banner ad closed", false);
                }
            }

            @Override // com.byazt.gl.n
            public void n(View view) {
                if (q.this.w != null) {
                    q.this.w.n(view, 0);
                }
                q.this.cy();
            }

            @Override // com.byazt.gl.n
            public void qg(View view) {
                q.this.n(view);
            }
        });
    }

    private void sz() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        if (sVar.kc()) {
            this.qg.n((com.byazt.us.n) new com.byazt.us.q() { // from class: com.byazt.ux.q.5
                @Override // com.byazt.us.q
                public void n(View view, String str, int i) {
                    if (q.this.w != null) {
                        q.this.w.n(view, str, i);
                    }
                }

                @Override // com.byazt.us.q
                public void n(float f, float f2) {
                    if (q.this.w != null) {
                        q.this.w.n((View) null, f, f2);
                    }
                }

                @Override // com.byazt.us.n
                public void n(View view) {
                    if (q.this.w != null) {
                        q.this.w.n(view, 0);
                    }
                    q.this.cy();
                }

                @Override // com.byazt.us.n
                public void n() {
                    q.this.n((View) null);
                }
            });
        } else {
            this.qg.n(new com.byazt.us.n() { // from class: com.byazt.ux.q.6
                @Override // com.byazt.us.n
                public void n(View view) {
                    if (q.this.w != null) {
                        q.this.w.n(view, 0);
                    }
                    q.this.cy();
                }

                @Override // com.byazt.us.n
                public void n() {
                    q.this.n((View) null);
                }
            });
        }
    }

    private void k() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        if (sVar.kc()) {
            this.qg.n((com.byazt.fz.qg) new com.byazt.fz.x() { // from class: com.byazt.ux.q.7
                @Override // com.byazt.fz.x
                public void n(View view, String str, int i) {
                    if (q.this.w != null) {
                        q.this.w.n(view, str, i);
                    }
                }

                @Override // com.byazt.fz.x
                public void n(float f, float f2) {
                    if (q.this.w != null) {
                        q.this.w.n((View) null, f, f2);
                    }
                }

                @Override // com.byazt.fz.qg
                public void n(View view) {
                    if (q.this.w != null) {
                        q.this.w.n(view, 0);
                    }
                    q.this.cy();
                }

                @Override // com.byazt.fz.qg
                public void n() {
                    q.this.n((View) null);
                }
            });
        } else {
            this.qg.n((com.byazt.fz.qg) new com.byazt.fz.s() { // from class: com.byazt.ux.q.8
                @Override // com.byazt.fz.qg
                public void n(View view) {
                    if (q.this.w != null) {
                        q.this.w.n(view, 0);
                    }
                    q.this.cy();
                }

                @Override // com.byazt.fz.qg
                public void n() {
                    q.this.n((View) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        String strQg;
        long jCurrentTimeMillis;
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
        com.byazt.sg.s sVar = this.qg;
        com.byazt.gp.s.n(sVar, this.s, 0, strQg, jCurrentTimeMillis, sVar.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        com.byazt.sg.s sVar;
        String strQg;
        long jCurrentTimeMillis;
        if (this.s == null || (sVar = this.qg) == null) {
            return;
        }
        sVar.w(true);
        com.byazt.fx.qg qgVar = this.w;
        if (qgVar != null) {
            qgVar.qg(view, 0);
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.s.a(), "show_listen") + "adSlotId：" + this.qg.el() + "，广告类型：" + com.byazt.sg.n.n(this.qg.he()));
        oa.n().x(this.s.a());
        oa.n().qg(this.s.a());
        cp.n().qg(this.s.a(), this.qg.el());
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
        com.byazt.sg.s sVar2 = this.qg;
        com.byazt.gp.s.n(sVar2, this.s, 0, str, j, zLh, 1, com.byazt.by.n.n(sVar2, this.q));
        com.byazt.sq.s.n(this.s.a(), this.qg);
    }

    private void n(com.byazt.sg.s sVar) {
        if (com.byazt.qt.qg.n().wo()) {
            com.byazt.gp.s.n(sVar, this.s, d.n(), 2);
        }
    }

    private void hd() {
        com.byazt.sg.s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        int iDg = sVar.dg();
        if (iDg != 4) {
            if (iDg == 5) {
                sz();
                return;
            } else if (iDg == 3) {
                d();
                return;
            }
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, Handler.Callback callback) {
        com.byazt.gp.s.n(this.s);
        if (this.qg != null) {
            hd();
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
}
