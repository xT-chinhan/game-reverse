package com.byazt.has;

import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.lq;
import com.byazt.gct.pk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 101})
public class fs extends n {
    public final AtomicBoolean ae;
    public final AtomicBoolean an;
    public final com.byazt.zx.qg df;
    public final AtomicBoolean f;
    public com.byazt.toz.n fi;
    public final AtomicBoolean j;
    public final int lh;
    public final AtomicLong ln;
    public long v;

    public static int qg(pk pkVar) {
        return 10;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean hf() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean ic() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return true;
    }

    public fs(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.lh = 4;
        this.v = 4L;
        this.j = new AtomicBoolean(false);
        this.an = new AtomicBoolean(false);
        this.ae = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.ln = new AtomicLong();
        this.df = new com.byazt.zx.qg() { // from class: com.byazt.has.fs.1
            @Override // com.byazt.zx.qg
            public boolean n() {
                if (!fs.this.ae.get() && !lq.qg(fs.this.qg)) {
                    return false;
                }
                fs.this.fl();
                return true;
            }

            @Override // com.byazt.zx.qg
            public void qg() {
                fs.this.ae.set(false);
                fs.this.rv.l(8);
                if (!fs.this.x()) {
                    fs.this.n.u();
                }
                fs.this.n.m();
            }

            @Override // com.byazt.zx.qg
            public void n(long j, long j2) {
                fs.this.um.qg(j);
                fs.this.ou();
                fs.this.ln.set(j);
            }

            @Override // com.byazt.zx.qg
            public void s() {
                fs.this.ae();
                fs.this.f.set(true);
                fs.this.n.oa();
            }

            @Override // com.byazt.zx.qg
            public boolean q() {
                return fs.this.f.get();
            }

            @Override // com.byazt.zx.qg
            public long l() {
                return fs.this.ln.get();
            }

            @Override // com.byazt.zx.qg
            public boolean w() {
                return fs.this.py.w();
            }

            @Override // com.byazt.zx.qg
            public Map<String, Object> x() {
                HashMap map = new HashMap();
                map.put("refer", "in_video");
                return map;
            }

            @Override // com.byazt.zx.qg
            public void fs() {
                fs.this.i();
            }

            @Override // com.byazt.zx.qg
            public void rv() {
                fs.this.n.u();
            }

            @Override // com.byazt.zx.qg
            public void tj() {
                if (fs.this.n != null) {
                    fs.this.n.d();
                }
            }

            @Override // com.byazt.zx.qg
            public int cp() {
                return fs.this.ae.get() ? 1 : 2;
            }
        };
    }

    public static boolean n(pk pkVar) {
        return lq.n(pkVar);
    }

    public void vb() {
        if (this.an.get()) {
            return;
        }
        int iBb = (int) this.um.bb();
        int iA = (int) this.um.a();
        int iS = lq.s(this.qg);
        if (iS == 1) {
            n(lq.q(this.qg), iA, 1000 * ((long) this.bb.l()), false);
        } else if (iS == 2) {
            n((int) (iA * 0.001f * 0.01f * lq.q(this.qg)), iA, iBb, false);
        } else {
            if (iS != 3) {
                return;
            }
            n(oj(), iA, iBb, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl() {
        this.rv.l(0);
        this.n.dg();
        this.fi.s();
        this.n.wm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.j.set(false);
    }

    private void n(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                dw();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            dw();
        }
    }

    private void dw() {
        this.an.set(true);
        this.fi.n();
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.rv.l(8);
        this.rv.w(0);
        this.cd.l(true);
        this.cd.s(true);
        this.cd.qg(true);
        this.cd.n(true);
        this.n.sh();
    }

    @Override // com.byazt.has.qg
    public void he() {
        if (this.wm != null) {
            ((com.byazt.zct.n) this.wm.n(com.byazt.zct.n.class)).n(this.df);
            ((com.byazt.fq.n) this.wm.n(com.byazt.fq.n.class)).n(this.df);
        }
        if (this.fs != null) {
            ((com.byazt.zct.n) this.fs.n(com.byazt.zct.n.class)).n(this.df);
            ((com.byazt.fq.n) this.fs.n(com.byazt.fq.n.class)).n(this.df);
        }
        com.byazt.toz.n nVar = new com.byazt.toz.n(this.n, this.qg, this.df);
        this.fi = nVar;
        nVar.n(this.n.an().getSceneFrameContainer(), this.n.an().getSceneFrame());
        this.j.set(lq.s(this.qg) != 0);
        if (this.j.get()) {
            this.cy = true;
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }

    @Override // com.byazt.has.qg
    public void z() {
        su();
        if (cx.hd(this.qg)) {
            this.n.s(0);
            if (t() > pk() || this.k) {
                com.byazt.rv.s.n = 0;
            }
            qg(w(true));
            com.byazt.rv.s.n = dg();
        }
    }

    private void su() {
        if (this.j.get()) {
            vb();
            ha();
        }
    }

    private void ha() {
        if (this.an.get()) {
            long j = this.v - 1;
            this.v = j;
            if (j != 0) {
                if (j > 0) {
                    this.fi.n(j);
                }
            } else {
                this.fi.n(j);
                this.ae.set(true);
                if (x()) {
                    this.fi.n(this.wm);
                } else {
                    this.fi.n(this.fs);
                }
            }
        }
    }

    @Override // com.byazt.has.n
    public void ou() {
        super.ou();
        this.cy = false;
        boolean z = ((int) (this.um.bb() / 1000)) >= this.bb.s() || this.n.dh();
        if (this.um.lh()) {
            this.cd.n(false, null, "跳过", false, true);
            return;
        }
        int iUr = this.um.ur();
        if (this.um.n()) {
            return;
        }
        this.cd.n(false, iUr + com.anythink.core.common.s.a, z ? "跳过" : "", false, z);
    }

    @Override // com.byazt.has.n
    public void ae() {
        super.ae();
        this.cd.n(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.byazt.has.n
    public void h() {
        super.h();
        this.cd.n(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.byazt.has.qg
    public boolean kc() {
        return cx.hd(this.qg);
    }

    @Override // com.byazt.has.n
    public com.byazt.zx.qg f() {
        return this.df;
    }
}
