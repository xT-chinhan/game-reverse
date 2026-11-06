package com.byazt.eu;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1648, 19})
public abstract class n {
    public l cd;
    public double cp;
    public w cy;
    public boolean d;
    public final double fs;
    public q hd;
    public InterfaceC0171n k;
    public final com.byazt.le.n l;
    public final com.byazt.dg.qg n;
    public int oa;
    public final com.byazt.xx.qg q;
    public final com.byazt.xx.q qg;
    public x rv;
    public final com.byazt.xx.s s;
    public com.byazt.xx.l sz;
    public double tj;
    public final List<com.byazt.xx.l> w;
    public final double x;

    public interface l {
        void n();

        void n(double d, double d2, double d3);

        void n(String str, int i, double d, double d2, double d3, double d4);
    }

    /* JADX INFO: renamed from: com.byazt.eu.n$n, reason: collision with other inner class name */
    public interface InterfaceC0171n {
        void n();

        void n(double d);

        void n(boolean z);
    }

    public interface q {
        void n();

        void n(double d, double d2, double d3, double d4);
    }

    public interface qg {
        int l();

        String n();

        double q();

        double qg();

        double s();
    }

    public interface s {
        List<? extends qg> n();

        double qg();
    }

    public interface w {
        Bitmap n(String str);
    }

    public enum x {
        IDLE,
        RUNNING,
        PAUSED,
        FINISHED
    }

    public boolean cp() {
        return true;
    }

    public void d() {
    }

    public abstract com.byazt.le.n n(com.byazt.dg.qg qgVar, com.byazt.le.n.InterfaceC0236n interfaceC0236n);

    public void n(double d) {
    }

    public void n(double d, com.byazt.dg.qg.C0152qg c0152qg) {
    }

    public void n(com.byazt.xx.l lVar) {
    }

    public void n(String str) {
    }

    public boolean qg(com.byazt.xx.l lVar) {
        return true;
    }

    public void rv() {
    }

    public n(com.byazt.dg.qg qgVar, double d, double d2) {
        com.byazt.xx.q qVar = new com.byazt.xx.q();
        this.qg = qVar;
        this.w = new ArrayList();
        this.rv = x.IDLE;
        this.tj = 0.0d;
        this.cp = 0.0d;
        this.d = false;
        this.oa = 0;
        this.n = qgVar;
        this.x = d;
        this.fs = d2;
        this.s = new com.byazt.xx.s(qgVar);
        this.q = new com.byazt.xx.qg(qgVar.x);
        this.l = n(qgVar, new com.byazt.le.n.InterfaceC0236n() { // from class: com.byazt.eu.n.1
            @Override // com.byazt.le.n.InterfaceC0236n
            public void n(com.byazt.xx.l lVar) {
                if (n.this.cy != null) {
                    lVar.d = n.this.cy.n(lVar.n);
                }
                lVar.cp = n.this.w.size();
                n.this.w.add(lVar);
            }
        });
        qVar.n(new com.byazt.xx.q.n() { // from class: com.byazt.eu.n.2
            @Override // com.byazt.xx.q.n
            public void n(double d3, double d4) {
                if (n.this.k != null) {
                    n.this.k.n(n.this.w());
                }
            }
        });
    }

    public void n(InterfaceC0171n interfaceC0171n) {
        this.k = interfaceC0171n;
    }

    public void n(w wVar) {
        this.cy = wVar;
    }

    public void n(q qVar) {
        this.hd = qVar;
    }

    public void n(l lVar) {
        this.cd = lVar;
    }

    public List<com.byazt.xx.l> O_() {
        return this.w;
    }

    public double P_() {
        return this.tj;
    }

    public x s() {
        return this.rv;
    }

    public com.byazt.dg.qg q() {
        return this.n;
    }

    public int l() {
        return this.oa;
    }

    public double w() {
        com.byazt.dg.qg.C0152qg c0152qgN = this.q.n();
        double d = c0152qgN != null ? c0152qgN.qg : 0.0d;
        if (d <= 0.0d) {
            return 0.0d;
        }
        double dN = this.qg.n() / d;
        if (dN < 0.0d) {
            return 0.0d;
        }
        if (dN > 1.0d) {
            return 1.0d;
        }
        return dN;
    }

    public void n(int i) {
        if (i != Integer.MIN_VALUE) {
            this.q.n(i);
        }
        this.rv = x.RUNNING;
        this.tj = 0.0d;
        this.cp = 0.0d;
        this.d = false;
        tj();
        this.l.n(this.q.n());
        this.q.n();
        InterfaceC0171n interfaceC0171n = this.k;
        if (interfaceC0171n != null) {
            interfaceC0171n.n(w());
        }
    }

    public void qg(int i) {
        if (i != Integer.MIN_VALUE) {
            this.q.n(i);
        }
        this.rv = x.IDLE;
        tj();
    }

    public void x() {
        if (this.rv == x.RUNNING) {
            this.rv = x.PAUSED;
        }
    }

    public void fs() {
        if (this.rv == x.PAUSED) {
            this.rv = x.RUNNING;
        }
    }

    public void s(int i) {
        this.rv = x.IDLE;
        this.w.clear();
        this.qg.qg();
        this.tj = 0.0d;
        this.cp = 0.0d;
        this.d = false;
        this.sz = null;
        if (i == Integer.MIN_VALUE || !this.q.n(i)) {
            this.q.qg();
        }
        rv();
        q qVar = this.hd;
        if (qVar != null) {
            qVar.n();
        }
    }

    public void q(int i) {
        s(i);
        n(i);
    }

    public void tj() {
        com.byazt.dg.qg.q qVar;
        if (cp() && (qVar = this.n.w.get("guide_tip")) != null) {
            d();
            com.byazt.xx.l lVar = new com.byazt.xx.l();
            this.sz = lVar;
            lVar.n = qVar.n;
            this.sz.x = qVar.q;
            this.sz.fs = qVar.l;
            this.sz.qg = qVar.w;
            this.sz.q = qVar.x;
            this.sz.s = qVar.s;
            this.sz.l = qVar.fs > 0.0d ? qVar.fs + (((double) qVar.q) / 2.0d) : this.x / 2.0d;
            if (qVar.d) {
                this.sz.w = (this.fs - qVar.cp) - (((double) qVar.l) / 2.0d);
            } else if (qVar.tj) {
                this.sz.w = qVar.rv + (((double) qVar.l) / 2.0d);
            } else {
                this.sz.w = this.fs * 0.3d;
            }
            this.sz.cp = this.w.size();
            this.w.add(this.sz);
            q qVar2 = this.hd;
            if (qVar2 != null) {
                qVar2.n(this.sz.l, this.sz.w, this.sz.x, this.sz.fs);
            }
        }
    }

    public void oa() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.byazt.xx.l lVar = this.sz;
        if (lVar != null) {
            this.w.remove(lVar);
            this.sz = null;
        }
        q qVar = this.hd;
        if (qVar != null) {
            qVar.n();
        }
        InterfaceC0171n interfaceC0171n = this.k;
        if (interfaceC0171n != null) {
            interfaceC0171n.n();
        }
    }

    public void update(double d) {
        if (this.rv != x.RUNNING) {
            return;
        }
        double d2 = this.tj + d;
        this.tj = d2;
        this.cp += d;
        this.l.update(d2, this.x);
        com.byazt.dg.qg.C0152qg c0152qgN = this.q.n();
        n(d, c0152qgN);
        n(d);
        if (this.s.n(this.qg.n(), c0152qgN)) {
            n(true);
        } else if (this.s.qg(this.cp, c0152qgN)) {
            n(false);
        }
    }

    public void n(com.byazt.xx.n nVar) {
        if (this.rv == x.RUNNING && nVar.n == 0) {
            boolean z = !this.d;
            for (int size = this.w.size() - 1; size >= 0; size--) {
                com.byazt.xx.l lVar = this.w.get(size);
                if (lVar.oa && qg(lVar) && lVar.n(nVar.qg, nVar.s)) {
                    lVar.oa = false;
                    this.qg.n(lVar.q);
                    this.oa++;
                    n(lVar);
                    break;
                }
            }
            if (z) {
                oa();
            }
        }
    }

    public void n(boolean z) {
        this.rv = x.FINISHED;
        this.l.n();
        InterfaceC0171n interfaceC0171n = this.k;
        if (interfaceC0171n != null) {
            interfaceC0171n.n(z);
        }
    }
}
