package com.byazt.has;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.yyw.AbstractEndCardFrameLayout;
import com.byazt.yyw.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 19})
public abstract class n extends qg {
    public com.byazt.re.qg a;
    public com.byazt.ce.s bb;
    public com.byazt.re.l cd;
    public AbstractEndCardFrameLayout cp;
    public boolean cy;
    public String d;
    public com.byazt.ys.w fs;
    public boolean hd;
    public boolean k;
    public int l;
    public com.byazt.re.n m;
    public final TTBaseVideoActivity n;
    public boolean oa;
    public com.byazt.za.x ou;
    public com.byazt.re.q py;
    public float q;
    public pk qg;
    public com.byazt.tkz.qg rv;
    public int s;
    public boolean sz;
    public com.byazt.tkz.l tj;
    public com.byazt.re.w um;
    public int w;
    public com.byazt.za.w wm;
    public int x = -1;
    public int hu = -5;
    public boolean h = false;
    public boolean t = false;
    public int ur = Integer.MIN_VALUE;
    public final com.byazt.za.d ln = new com.byazt.za.d() { // from class: com.byazt.has.n.1
        @Override // com.byazt.za.d
        public void n(int i, String str) {
        }

        @Override // com.byazt.za.d
        public void n(boolean z) {
            if (n.this.oa != z) {
                n.this.oa = z;
                n.this.cd.qg();
            }
        }

        @Override // com.byazt.za.d
        public void w() {
            com.byazt.eji.s.n().q(n.this.qg, "stats_reward_full_click_express_close");
            n.this.cd.n();
        }

        @Override // com.byazt.za.d
        public void x() {
            com.byazt.eji.s.n().q(n.this.qg, "stats_reward_full_click_express_close");
            n.this.n.finish();
        }

        @Override // com.byazt.za.d
        public void n(int i) {
            if (i != 1) {
                if (i == 2) {
                    n.this.um.hu();
                    return;
                }
                if (i == 3) {
                    n.this.um.h();
                    return;
                } else if (i == 4) {
                    n.this.um.x();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (n.this.um.qg() || n.this.um.s() || n.this.um.f()) {
                return;
            }
            n.this.n.qg(0L, false);
        }

        @Override // com.byazt.za.d
        public long n() {
            if (n.this.rv(true)) {
                hashCode();
                return ((long) n.this.t()) * 1000;
            }
            n nVar = n.this;
            nVar.qg(nVar.w(true));
            return n.this.bb.n();
        }

        @Override // com.byazt.za.d
        public void setPauseFromExpressView(boolean z) {
            n.this.n.cy(1);
        }

        @Override // com.byazt.za.d
        public int qg() {
            if (n.this.rv(true)) {
                int i = n.this.n.e() ? 3 : 2;
                if (n.this.n.kc()) {
                    return 5;
                }
                return i;
            }
            if (n.this.tj.qg()) {
                return 4;
            }
            if (n.this.tj.s()) {
                return 5;
            }
            if (n.this.um.q()) {
                return 1;
            }
            if (n.this.um.qg()) {
                return 2;
            }
            n.this.um.s();
            return 3;
        }

        @Override // com.byazt.za.d
        public int s() {
            return n.this.t();
        }

        @Override // com.byazt.za.d
        public void rv() {
            n.this.cd.s();
        }

        @Override // com.byazt.za.d
        public void tj() {
            n.this.n.fs(3);
        }

        @Override // com.byazt.za.d
        public void q(int i) {
            n.this.n.rv(i);
        }

        @Override // com.byazt.za.d
        public void n(float f, float f2, float f3, float f4, int i) {
            n.this.n.n(f, f2, f3, f4, i);
        }

        @Override // com.byazt.za.d
        public void q() {
            n.this.h = true;
        }

        @Override // com.byazt.za.d
        public void qg(int i) {
            if (cx.l(n.this.qg)) {
                n.this.n.q(1);
            } else {
                n.this.n.n(i, false);
            }
        }

        @Override // com.byazt.za.d
        public void l() {
            n.this.h = false;
        }

        @Override // com.byazt.za.d
        public void n(float f) {
            if (n.this.bb != null) {
                n.this.bb.s((int) (1000.0f / f));
            }
            n.this.n.b().n(f);
        }

        @Override // com.byazt.za.d
        public void n(int i, int i2) {
            if (i == 0 && i2 == 0) {
                n.this.t = true;
            }
            n.this.n.n(i, i2);
        }

        @Override // com.byazt.za.d
        public void s(int i) {
            n.this.n.s(i);
        }

        @Override // com.byazt.za.d
        public void n(pk pkVar) {
            if (n.this.a == null || n.this.n == null) {
                return;
            }
            com.byazt.ys.n nVar = new com.byazt.ys.n(n.this.n, pkVar, n.this.d, 7);
            n.this.a.n(pkVar, nVar);
            ((com.byazt.fq.n) nVar.n(com.byazt.fq.n.class)).n(n.this.n.n(pkVar));
        }

        @Override // com.byazt.za.d
        public void fs() {
            n.this.n.cx();
        }
    };

    public void ae() {
    }

    public boolean an() {
        return true;
    }

    public com.byazt.zx.qg f() {
        return null;
    }

    public boolean j() {
        return false;
    }

    public void k() {
    }

    public void m() {
    }

    public void n(int i) {
    }

    public void n(int i, int i2, Intent intent) {
    }

    public void n(View view) {
    }

    public void n(Map<String, Object> map) {
    }

    public void n(JSONObject jSONObject) {
    }

    public void qg(Map<String, Object> map) {
    }

    public void ri() {
    }

    public boolean um() {
        return false;
    }

    public int v() {
        return 0;
    }

    public void wm() {
    }

    public n(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        this.n = tTBaseVideoActivity;
        this.qg = pkVar;
        this.s = pkVar.ys();
        this.q = pkVar.sl();
    }

    public void n(com.byazt.re.l lVar, com.byazt.re.w wVar, com.byazt.re.qg qgVar, com.byazt.re.q qVar, com.byazt.re.n nVar) {
        this.cd = lVar;
        this.um = wVar;
        this.a = qgVar;
        this.py = qVar;
        this.m = nVar;
    }

    public void n(String str, boolean z, boolean z2, com.byazt.ce.s sVar) {
        this.d = str;
        this.oa = z;
        this.sz = z2;
        this.bb = sVar;
    }

    public com.byazt.re.l n() {
        return this.cd;
    }

    public final void n(com.byazt.ys.w wVar) {
        this.fs = wVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.n;
        pk pkVar = this.qg;
        String str = this.d;
        this.ou = new com.byazt.za.x(tTBaseVideoActivity, pkVar, str, com.byazt.vgx.w.q(str)) { // from class: com.byazt.has.n.2
            @Override // com.byazt.za.x, com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, com.byazt.gct.tj tjVar) {
                if (pk.w(this.n)) {
                    return;
                }
                super.n(view, tjVar);
                n.this.n.n(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.n;
        pk pkVar2 = this.qg;
        String str2 = this.d;
        this.wm = new com.byazt.za.w(tTBaseVideoActivity2, pkVar2, str2, com.byazt.vgx.w.q(str2)) { // from class: com.byazt.has.n.3
            @Override // com.byazt.za.w, com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, com.byazt.gct.tj tjVar) {
                if (pk.w(this.n)) {
                    return;
                }
                super.n(view, tjVar);
                com.byazt.dj.qg qgVar = (com.byazt.dj.qg) this.fs.n(com.byazt.dj.qg.class);
                if (qgVar == null || !qgVar.qg(view)) {
                    return;
                }
                n.this.n.n(2);
            }
        };
        this.cp.setClickListener(this.fs);
    }

    private void vb() {
        this.cd.n(false);
        this.rv.w(8);
        this.rv.l(8);
        this.rv.s(8);
        dn();
    }

    public void qg() {
        he();
        if (hf()) {
            cx.n(this.qg, true);
        }
        vb();
        if (yw()) {
            this.a.qg();
        }
        if (w()) {
            l();
        } else {
            this.n.py();
            s();
        }
    }

    @Override // com.byazt.has.qg
    public void s() {
        q();
    }

    public void q() {
        boolean zL = this.tj.l();
        if (!this.a.an() && !zL) {
            cd();
        }
        this.a.n(this.tj.cp());
        if (zL) {
            this.tj.n().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.rv.s(!zL);
        this.tj.q(zL);
        this.cd.n(ic() || !zL);
        this.n.w();
    }

    public void l() {
        this.n.x(0);
        this.cd.n(ic());
        float f = this.l;
        float f2 = this.w;
        float[] fArrPy = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrPy = py();
        }
        this.tj.n(this.qg, com.byazt.vgx.q.n(this.n.t() ? 7 : 8, String.valueOf(com.byazt.vgx.w.cy(this.qg)), fArrPy[0], fArrPy[1], this.qg), this.d, this.oa, this.n.n());
        this.rv.s(false);
        this.tj.q(true);
        this.tj.n(this.ln);
        this.tj.n(new com.byazt.za.n() { // from class: com.byazt.has.n.4
            @Override // com.byazt.za.n
            public void n(View view, int i) {
            }

            @Override // com.byazt.za.n
            public void qg(View view, int i) {
            }

            @Override // com.byazt.za.n
            public void n(View view, String str, int i) {
                if (n.this.a.an()) {
                    return;
                }
                n.this.a.qg();
                n.this.n.py();
                n.this.n.x(8);
                n.this.cd.n(true);
                com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.has.n.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n.um();
                    }
                });
            }

            @Override // com.byazt.za.n
            public void n(View view, float f3, float f4) {
                if (n.this.a.an()) {
                    return;
                }
                n.this.a.qg();
                n.this.n.py();
                n.this.n.x(8);
                n nVar = n.this;
                nVar.x = nVar.tj.fs();
                if (n.this.x == 0) {
                    cx.qg(n.this.qg, true);
                }
                n.this.s();
            }
        });
        ((com.byazt.fq.n) this.ou.n(com.byazt.fq.n.class)).n(this.n.pk());
        ((com.byazt.fq.n) this.wm.n(com.byazt.fq.n.class)).n(this.n.pk());
        this.n.n((com.byazt.fq.s) this.ou.n(com.byazt.fq.s.class));
        this.n.n((com.byazt.fq.s) this.wm.n(com.byazt.fq.s.class));
        this.tj.n(this.ou, this.wm);
        this.tj.x();
    }

    public boolean w() {
        return nf.n(this.qg) == 2;
    }

    public boolean x() {
        com.byazt.tkz.l lVar;
        return w() && (lVar = this.tj) != null && lVar.l();
    }

    public void fs() {
        boolean z;
        if (this.sz) {
            z = false;
        } else {
            boolean z2 = this instanceof tj;
            z = true;
            if (cx.wm(this.qg)) {
                z2 = true;
            }
            if (this.q == 100.0f) {
                z = z2;
            }
        }
        if (z) {
            wo();
        } else {
            this.n.an().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if ((this instanceof tj) || this.q == 100.0f) {
            return;
        }
        try {
            final View decorView = this.n.getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: com.byazt.has.n.5
                @Override // java.lang.Runnable
                public void run() {
                    int iCp = (int) (com.byazt.okk.s.cp((Context) n.this.n) / 2.0f);
                    int paddingLeft = decorView.getPaddingLeft();
                    int paddingRight = decorView.getPaddingRight();
                    int paddingTop = decorView.getPaddingTop();
                    int paddingBottom = decorView.getPaddingBottom();
                    if (n.this.s == 1 && !com.byazt.okk.s.qg()) {
                        paddingTop += iCp;
                        paddingBottom += iCp;
                    }
                    if (n.this.s == 2 && !com.byazt.okk.s.qg()) {
                        paddingLeft += iCp;
                        paddingRight += iCp;
                    }
                    decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public View rv() {
        if (this.q != 100.0f) {
            return e();
        }
        int iOx = this.qg.ox();
        if (iOx == 1) {
            return com.byazt.cb.qg.s(this.n);
        }
        if (iOx == 3) {
            return com.byazt.cb.qg.q(this.n);
        }
        return com.byazt.cb.qg.n(this.n);
    }

    public View tj() {
        if (this.cp == null) {
            this.cp = new CommonEndCardFrameLayout(this.n, this.qg);
        }
        return this.cp;
    }

    public View cp() {
        return com.byazt.cb.qg.l(this.n);
    }

    public com.byazt.tkz.qg n(boolean z) {
        if (this.q != 100.0f) {
            this.rv = new com.byazt.tkz.x(this.n, this.qg, z);
        } else {
            this.rv = new com.byazt.tkz.s(this.n, this.qg, z);
        }
        return this.rv;
    }

    public com.byazt.tkz.l d() {
        com.byazt.tkz.l lVar = new com.byazt.tkz.l(this.n);
        this.tj = lVar;
        return lVar;
    }

    public void oa() {
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.sz();
        }
    }

    public AbstractEndCardFrameLayout sz() {
        return this.cp;
    }

    public void n(int i, int i2) {
        this.l = i;
        this.w = i2;
    }

    public void qg(boolean z) {
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.q();
        }
    }

    private boolean n(pk pkVar) {
        return (pkVar.rv() == 4) && !TextUtils.isEmpty(pkVar.m());
    }

    public void s(boolean z) {
        if (this.qg.sl() != 100.0f) {
            if (com.byazt.nf.rv.qg().rv(com.byazt.vgx.w.cy(this.qg)) || this.sz) {
                if (com.byazt.wif.w.s && com.byazt.wif.w.qg && n(this.qg)) {
                    com.byazt.wif.w.qg = false;
                    com.byazt.wif.w.s = false;
                    this.n.finish();
                } else if (z && !com.byazt.wif.w.s) {
                    this.n.finish();
                } else {
                    if (!this.a.lh() || com.byazt.wif.w.s) {
                        return;
                    }
                    this.n.finish();
                }
            }
        }
    }

    public void cy() {
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.k();
        }
    }

    public void hd() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.cp;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.qg();
        }
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.s(true);
        }
        if (cx() || this.a.an()) {
            return;
        }
        this.a.wm();
    }

    public void cd() {
        this.rv.cy();
        this.cd.qg(this.qg.yv());
        this.cd.l(lq());
        this.rv.w(0);
        this.rv.l(0);
    }

    public FrameLayout a() {
        com.byazt.tkz.l lVar;
        if (cd.q(this.qg)) {
            return this.cp.getVideoArea();
        }
        if (w() && (lVar = this.tj) != null && lVar.l()) {
            return this.tj.n();
        }
        return this.rv.d();
    }

    public void q(boolean z) {
        float f = this.q;
        if (f != 100.0f) {
            int i = (int) (f * 1000.0f);
            if (this.s == 1) {
                if (i == 666 || i == 1000 || i == 1500 || i == 1777) {
                    this.rv.q(8);
                    return;
                } else {
                    this.rv.q(z ? 0 : 8);
                    return;
                }
            }
        } else {
            if (z) {
                if (this.s == 1) {
                    this.rv.q(0);
                }
                if (com.byazt.gks.n.n(this.qg)) {
                    this.rv.w(0);
                    return;
                }
                return;
            }
            if (this.s != 1) {
                return;
            }
        }
        this.rv.q(8);
    }

    public float[] py() {
        TTBaseVideoActivity tTBaseVideoActivity = this.n;
        int iQ = com.byazt.okk.s.q(tTBaseVideoActivity, com.byazt.okk.s.cp((Context) tTBaseVideoActivity));
        float f = this.w;
        float f2 = this.l;
        int i = this.s;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iQ;
        } else {
            f2 -= iQ;
        }
        return new float[]{f2, f};
    }

    public void ou() {
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.n(this.bb);
        }
        if (this.sz) {
            this.rv.qg((int) (this.um.bb() / 1000));
        }
    }

    public void l(boolean z) {
        this.oa = z;
        this.um.s(z);
    }

    public final int hu() {
        return this.x;
    }

    public com.byazt.aqe.qg.n n(pk pkVar, com.byazt.aqe.tj tjVar) {
        return n(pkVar, tjVar, false);
    }

    public final com.byazt.aqe.qg.n n(pk pkVar, final com.byazt.aqe.tj tjVar, boolean z) {
        com.byazt.aqe.s sVar = new com.byazt.aqe.s(this.n, pkVar, z);
        sVar.n(dg());
        sVar.qg(fi());
        sVar.s(this.n.v());
        sVar.q(this.n.j());
        sVar.s(this.h);
        sVar.q(cx.t(pkVar) && !this.n.w.get());
        this.n.dg();
        return sVar.qg(new com.byazt.aqe.tj() { // from class: com.byazt.has.n.6
            @Override // com.byazt.aqe.tj
            public void n() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
                n.this.n.u();
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }

            @Override // com.byazt.aqe.tj
            public void n(int i) {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n(i);
                }
            }

            @Override // com.byazt.aqe.tj
            public void s() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.s();
                }
            }
        });
    }

    public void h() {
        nf();
    }

    public int t() {
        return this.bb.l() + this.bb.qg();
    }

    public int ur() {
        return this.bb.l();
    }

    public int bb() {
        return this.bb.w();
    }

    public void ln() {
        if (this.hu < 0) {
            this.hu = this.a.oj();
        }
        int i = this.hu;
        if (i > 0) {
            this.hu = i - 1;
            this.cd.n(false, this.hu + com.anythink.core.common.s.a, null, true, true);
        } else if (i == 0) {
            this.n.q(0);
            this.cd.n(false, "奖励已领取", null, true, true);
        }
    }

    public void lh() {
        this.k = true;
    }

    public int fi() {
        if (kc()) {
            return t();
        }
        return u() + rf();
    }

    public int w(boolean z) {
        if (ci() && this.a.df()) {
            return this.hu;
        }
        if (kc()) {
            if (rv(false)) {
                return tj(z);
            }
            return Math.max(pk() - t(), 0);
        }
        return x(z);
    }

    private int tj(boolean z) {
        double dMax;
        float fGr = this.qg.gr() / 100.0f;
        if (z) {
            dMax = Math.max(Math.min(ta.x(this.qg) * ((double) fGr), cx.n() / 1000) - ((double) t()), 0.0d);
        } else {
            dMax = Math.max(ta.x(this.qg) - ((double) t()), 0.0d);
        }
        return (int) dMax;
    }

    public int df() {
        int i;
        if (ci() && this.a.df() && (i = this.hu) >= 0) {
            return i;
        }
        if (kc()) {
            float fGr = this.qg.gr() / 100.0f;
            if (rv(false)) {
                return tj(true);
            }
            return (int) Math.max((pk() * fGr) - t(), 0.0f);
        }
        return cp(false);
    }

    public int oj() {
        int i;
        if (ci() && this.a.df() && (i = this.hu) >= 0) {
            return i;
        }
        if (kc()) {
            float fGr = this.qg.gr() / 100.0f;
            if (rv(false)) {
                return tj(true);
            }
            return (int) Math.max((pk() * fGr) - t(), 0.0f);
        }
        return fs(true);
    }

    public int x(boolean z) {
        if (z) {
            return cp(false);
        }
        return fl();
    }

    public int fs(boolean z) {
        return cp(z);
    }

    private int cp(boolean z) {
        long jBb = this.um.bb();
        if (z) {
            long jMax = Math.max(Math.min(cx.n(), (long) ((this.um.t() * 1000.0d) * ((double) (this.qg.gr() / 100.0f)))) - (jBb + (((long) rf()) * 1000)), 0L);
            return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long jMin = Math.min(cx.n(), (long) (this.um.t() * 1000.0d));
        long jRf = ((long) rf()) * 1000;
        long jT = (long) ((this.um.t() % 1.0d) * 1000.0d);
        if (jT > 0) {
            jBb -= 1000 - jT;
        }
        return Math.round((jMin - (jBb + jRf)) / 1000.0f);
    }

    private int fl() {
        long jMax = Math.max(((long) (this.um.t() * 1000.0d)) - this.um.bb(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - rf(), 0);
    }

    public void qg(int i) {
        this.ur = i;
    }

    public int dg() {
        int i = this.ur;
        return i == Integer.MIN_VALUE ? w(true) : i;
    }

    public int u() {
        return (int) (this.um.bb() / 1000);
    }

    public int pk() {
        if (com.byazt.qq.qg.s(this.qg)) {
            return com.byazt.qq.qg.l(this.qg);
        }
        return cx.k(this.qg);
    }

    public void wo() {
        if (this.hd || Build.VERSION.SDK_INT == 26) {
            return;
        }
        Window window = this.n.getWindow();
        if (window != null) {
            this.n.requestWindowFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(-2013265920));
            window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        com.byazt.okk.s.x((Activity) this.n);
        this.hd = true;
    }

    public boolean sh() {
        return !this.sz && this.s == 1 && cx.wm(this.qg) && this.qg.sl() != 100.0f;
    }

    public com.byazt.za.d y() {
        return this.ln;
    }

    public void s(int i) {
        this.bb.n(i);
    }

    public int rf() {
        return this.bb.qg();
    }

    public int dh() {
        return this.bb.s();
    }

    public boolean b() {
        return this.t;
    }

    @Override // com.byazt.has.qg
    public boolean nf() {
        return cx.hd(this.qg) || this.a.df();
    }

    public void pe() {
        com.byazt.tkz.l lVar = this.tj;
        if (lVar != null) {
            lVar.n(this.bb);
        }
        if (ci() && this.a.df()) {
            ln();
        } else {
            z();
        }
    }

    public View e() {
        int i = (int) (this.q * 1000.0f);
        if (this.s == 1) {
            if (i == 666) {
                return com.byazt.cb.qg.m(this.n);
            }
            if (i == 1000) {
                return com.byazt.cb.qg.h(this.n);
            }
            if (i == 1500) {
                return com.byazt.cb.qg.hu(this.n);
            }
            if (i == 1777) {
                return com.byazt.cb.qg.t(this.n);
            }
            return com.byazt.cb.qg.ur(this.n);
        }
        if (i == 562) {
            return com.byazt.cb.qg.lh(this.n);
        }
        if (i == 666) {
            return com.byazt.cb.qg.bb(this.n);
        }
        if (i == 1000) {
            return com.byazt.cb.qg.h(this.n);
        }
        if (i == 1500) {
            return com.byazt.cb.qg.ln(this.n);
        }
        return com.byazt.cb.qg.v(this.n);
    }
}
