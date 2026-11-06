package com.byazt.re;

import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.ej.x;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.shr.um;
import com.byazt.tk.k;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 13})
public class w {
    public pk cp;
    public FrameLayout d;
    public long fs;
    public com.byazt.zsl.l k;
    public int l;
    public long oa;
    public long q;
    public com.byazt.ys.n sz;
    public TTBaseVideoActivity tj;
    public boolean w;
    public com.byazt.iag.s x;
    public final int rv = 210;
    public boolean n = false;
    public boolean qg = false;
    public boolean s = false;
    public boolean cy = false;

    public w(TTBaseVideoActivity tTBaseVideoActivity) {
        this.tj = tTBaseVideoActivity;
    }

    public void n(pk pkVar) {
        this.cp = pkVar;
    }

    public void n(FrameLayout frameLayout, boolean z) {
        if (this.cy) {
            return;
        }
        this.cy = true;
        this.d = frameLayout;
        this.w = z;
        if (z) {
            this.x = new com.byazt.qs.qg(this.tj, this.d, this.cp, this.sz);
        } else {
            this.x = new com.byazt.qs.n(this.tj, this.d, this.cp, this.sz);
        }
        this.l = (int) t();
    }

    public boolean n() {
        com.byazt.iag.s sVar = this.x;
        return (sVar == null || sVar.hd() == null || !this.x.hd().k()) ? false : true;
    }

    public boolean qg() {
        com.byazt.iag.s sVar = this.x;
        return (sVar == null || sVar.hd() == null || !this.x.hd().tj()) ? false : true;
    }

    public boolean s() {
        com.byazt.iag.s sVar = this.x;
        return (sVar == null || sVar.hd() == null || !this.x.hd().d()) ? false : true;
    }

    public boolean q() {
        com.byazt.iag.s sVar = this.x;
        return sVar != null && sVar.ou();
    }

    public boolean l() {
        return this.qg;
    }

    public void n(boolean z) {
        this.qg = z;
    }

    public long w() {
        return this.fs;
    }

    public void n(long j) {
        this.fs = j;
    }

    public void qg(boolean z) {
        int i;
        if (this.x == null) {
            return;
        }
        if (z) {
            i = j() ? 2 : 4;
        } else {
            i = j() ? 0 : 1;
        }
        um.n nVar = new um.n();
        nVar.qg(hd());
        nVar.s(1 ^ (j() ? 1 : 0));
        nVar.q(i);
        com.byazt.iag.s sVar = this.x;
        if (!(sVar instanceof com.byazt.zx.n) || ((com.byazt.zx.n) sVar).py.n(128)) {
            return;
        }
        ((com.byazt.zx.n) this.x).py.s(128);
        ((com.byazt.zx.n) this.x).n(nVar);
        com.byazt.gw.s.s(this.x.cd(), nVar);
    }

    private void oj() {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null || sVar.hd() == null) {
            return;
        }
        this.fs = this.x.cp();
        if (this.x.hd().cp() || !this.x.hd().k()) {
            this.x.w();
            this.x.rv();
            this.qg = true;
        }
    }

    public void x() {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null) {
            return;
        }
        sVar.rv();
        this.x = null;
    }

    public void fs() {
        if (this.x != null && qg()) {
            this.x.qg(true);
        }
    }

    public void rv() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            sVar.tj();
        }
    }

    public void n(long j, boolean z) {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null || this.s) {
            return;
        }
        if (j != 0) {
            sVar.n(j);
            this.x.qg(z);
        } else {
            sVar.fs();
        }
    }

    public void n(Map<String, Object> map) {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null || this.s) {
            return;
        }
        sVar.n(map);
    }

    public void tj() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            sVar.qg();
        }
    }

    public boolean cp() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.q();
        }
        return false;
    }

    public boolean d() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.l();
        }
        return false;
    }

    public void qg(Map<String, Object> map) {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            sVar.qg(map);
        }
    }

    public void n(com.byazt.zx.n.InterfaceC0421n interfaceC0421n) {
        com.byazt.iag.s sVar = this.x;
        if (sVar instanceof com.byazt.zx.n) {
            ((com.byazt.zx.n) sVar).n(interfaceC0421n);
        }
    }

    public void s(boolean z) {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            sVar.qg(z);
        }
    }

    public boolean oa() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.um();
        }
        return false;
    }

    public long sz() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.sz();
        }
        return 0L;
    }

    public int k() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.k();
        }
        return 0;
    }

    public long cy() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.cp();
        }
        return this.fs;
    }

    public long hd() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.d();
        }
        return 0L;
    }

    public int cd() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.oa();
        }
        return 0;
    }

    public void um() {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null || sVar.hd() == null) {
            return;
        }
        this.x.hd().x();
    }

    public long a() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.sz();
        }
        return 0L;
    }

    public boolean py() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            if (sVar.hd() != null) {
                x xVarHd = this.x.hd();
                if (xVarHd.d() || xVarHd.oa()) {
                    ((com.byazt.zx.n) this.x).rf();
                    return true;
                }
            } else if (l()) {
                n(false);
                ((com.byazt.zx.n) this.x).rf();
                return true;
            }
        }
        return false;
    }

    public boolean ou() {
        return this.x != null;
    }

    public boolean wm() {
        com.byazt.iag.s sVar = this.x;
        return sVar != null && sVar.hd() == null;
    }

    public boolean n(long j, boolean z, int i) {
        if (this.x == null || ta.k(this.cp) == null) {
            return false;
        }
        com.byazt.zsl.l lVarN = this.k;
        if (lVarN == null) {
            File file = new File(com.byazt.ql.qg.n(this.cp.io()).qg(), ta.fs(this.cp));
            if (file.exists() && file.length() > 0) {
                this.n = true;
            }
            lVarN = ta.n(1, this.cp);
            lVarN.qg(this.cp.q());
            FrameLayout frameLayout = this.d;
            lVarN.qg(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.d;
            lVarN.s(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            lVarN.s(this.cp.F_());
            lVarN.n(j);
            lVarN.qg(z);
            if (com.byazt.ql.s.n(this.cp)) {
                lVarN.n(true);
            }
        }
        return this.x.n(lVarN);
    }

    public void m() {
        x();
    }

    public void hu() {
        try {
            this.tj.sz(1);
        } catch (Throwable th) {
            k.qg("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void h() {
        try {
            this.tj.k(1);
        } catch (Throwable th) {
            k.qg("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void n(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean zQ;
        long jL;
        boolean zW;
        if (z || this.tj.e()) {
            return;
        }
        if (s()) {
            com.byazt.zx.qg qgVarF = this.tj.nf().f();
            if (qgVarF != null) {
                zQ = qgVarF.q();
                jL = qgVarF.l();
                zW = qgVarF.w();
            } else {
                zQ = false;
                jL = 0;
                zW = false;
            }
            if (!zQ) {
                n(jL, zW);
                return;
            }
        }
        oj();
        n(tTBaseVideoActivity);
    }

    public void n(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!py() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.qg(w(), true);
    }

    public double t() {
        double dX = ta.x(this.cp);
        return (ta.k(this.cp) == null || this.cp.sn() <= 0 || dX <= ((double) this.cp.sn())) ? dX : this.cp.sn();
    }

    public int ur() {
        return this.l;
    }

    public long bb() {
        if (cp()) {
            double dW = ta.hd(this.cp).w() * 1000.0d * ((double) ln().sh());
            long j = this.q;
            if (dW - j > 210.0d) {
                long j2 = (long) (j + dW);
                this.oa = j2;
                return j2;
            }
        }
        return Math.max(this.q, this.oa);
    }

    public void qg(long j) {
        this.q = j;
        if (!d() && cp()) {
            this.l = (int) Math.max(0L, Math.round(t() - ((this.q + (ta.hd(this.cp).w() * 1000.0d)) / 1000.0d)));
        } else {
            this.l = Math.max(0, (int) (t() - (this.q / 1000)));
        }
    }

    public com.byazt.zx.n ln() {
        return (com.byazt.zx.n) an();
    }

    public boolean lh() {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null) {
            return false;
        }
        return sVar.s();
    }

    public com.byazt.iag.qg v() {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            return sVar.cd();
        }
        return null;
    }

    public boolean j() {
        com.byazt.iag.s sVar = this.x;
        if (sVar == null || sVar.hd() == null) {
            return false;
        }
        return this.x.hd().fs();
    }

    public void n(int i) {
        com.byazt.iag.s sVar = this.x;
        if (sVar != null) {
            sVar.n(i);
        }
    }

    public com.byazt.iag.s an() {
        return this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ae() {
        boolean zN;
        um.n nVar = new um.n();
        nVar.qg(hd());
        nVar.l(3);
        nVar.w(cd());
        com.byazt.iag.s sVar = this.x;
        if (sVar instanceof com.byazt.zx.n) {
            ((com.byazt.zx.n) sVar).py.s(32);
            ((com.byazt.zx.n) this.x).n(nVar);
            zN = ((com.byazt.zx.n) this.x).py.n(2);
        } else {
            zN = 0;
        }
        com.byazt.gw.s.n(v(), nVar, this.tj.fs(), !zN);
    }

    public boolean f() {
        return this.s;
    }

    public void fi() {
        this.s = true;
    }

    public void df() {
        try {
            com.byazt.iag.s sVar = this.x;
            if (sVar instanceof com.byazt.zx.n) {
                ((com.byazt.zx.n) sVar).pe();
            }
        } catch (Throwable unused) {
        }
    }

    public void n(pk pkVar, com.byazt.iag.s sVar, com.byazt.zsl.l lVar) {
        this.cp = pkVar;
        this.x = sVar;
        this.k = lVar;
    }

    public void n(com.byazt.ys.n nVar) {
        this.sz = nVar;
    }

    public void n(float f) {
        if (this.x.hd() != null) {
            this.x.hd().n(f);
        }
    }
}
