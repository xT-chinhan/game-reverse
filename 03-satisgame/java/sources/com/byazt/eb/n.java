package com.byazt.eb;

import com.byazt.dg.qg;
import com.byazt.xx.l;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2548, 19})
public class n extends com.byazt.eu.n {
    public double a;
    public double ou;
    public double py;
    public l um;
    public boolean wm;

    public n(qg qgVar, double d, double d2) {
        super(qgVar, d, d2);
        this.wm = false;
    }

    @Override // com.byazt.eu.n
    public com.byazt.le.n n(qg qgVar, com.byazt.le.n.InterfaceC0236n interfaceC0236n) {
        return new com.byazt.yk.n(qgVar, interfaceC0236n, this.x, this.fs, n(qgVar));
    }

    private static double n(qg qgVar) {
        if (qgVar == null || qgVar.x == null || qgVar.x.isEmpty()) {
            return 64.0d;
        }
        double d = qgVar.x.get(0).fs;
        if (d > 0.0d) {
            return d;
        }
        return 64.0d;
    }

    @Override // com.byazt.eu.n
    public boolean cp() {
        return !this.wm;
    }

    @Override // com.byazt.eu.n
    public void d() {
        this.wm = true;
    }

    @Override // com.byazt.eu.n
    public boolean qg(l lVar) {
        return (lVar == null || lVar == this.um || "obstacle".equals(lVar.n)) ? false : true;
    }

    @Override // com.byazt.eu.n
    public void n(int i) {
        super.n(i);
        sz();
    }

    @Override // com.byazt.eu.n
    public void rv() {
        this.um = null;
        this.ou = 0.0d;
        if (this.cd != null) {
            this.cd.n();
        }
    }

    private void sz() {
        qg.q qVar = this.n.w.get("runner");
        this.a = this.fs - n(this.n);
        l lVar = new l();
        this.um = lVar;
        lVar.n = "runner";
        if (qVar != null) {
            this.um.x = qVar.q;
            this.um.fs = qVar.l;
            this.um.s = qVar.s;
        } else {
            this.um.x = 96.0d;
            this.um.fs = 96.0d;
        }
        double d = (qVar == null || qVar.fs <= 0.0d) ? 60.0d : qVar.fs;
        l lVar2 = this.um;
        lVar2.l = d + (lVar2.x / 2.0d);
        if (qVar != null && qVar.d) {
            this.py = (this.fs - qVar.cp) - (this.um.fs / 2.0d);
        } else {
            this.py = this.a - (this.um.fs / 2.0d);
        }
        this.um.w = this.py;
        if (this.cd == null || qVar == null) {
            return;
        }
        this.cd.n(qVar.n, qVar.s, this.um.l, this.um.w, this.um.x, this.um.fs);
    }

    @Override // com.byazt.eu.n
    public void n(String str) {
        if (str == null) {
            return;
        }
        str.hashCode();
        if (str.equals("jump")) {
            k();
        }
    }

    private void k() {
        l lVar = this.um;
        if (lVar == null) {
            return;
        }
        if (lVar.w >= this.py - 0.5d) {
            qg.C0152qg c0152qgN = this.q.n();
            this.um.k = -((c0152qgN == null || c0152qgN.rv <= 0.0d) ? 620.0d : c0152qgN.rv);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:94:0x0186  */
    @Override // com.byazt.eu.n
    public void n(double d, qg.C0152qg c0152qg) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        boolean z;
        int i;
        double d7 = d / 1000.0d;
        double d8 = (c0152qg == null || c0152qg.x <= 0.0d) ? 260.0d : c0152qg.x;
        double d9 = (c0152qg == null || c0152qg.tj <= 0.0d) ? 2200.0d : c0152qg.tj;
        double d10 = (c0152qg == null || c0152qg.cp <= 0.0d) ? 1.0d : c0152qg.cp;
        if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        l lVar = this.um;
        if (lVar != null && lVar.k != 0.0d) {
            this.um.k += d9 * d7;
            this.um.w += this.um.k * d7;
            double d11 = this.um.w;
            double d12 = this.py;
            if (d11 >= d12) {
                this.um.w = d12;
                this.um.k = 0.0d;
            }
        }
        if (this.um == null || this.ou <= this.tj) {
            d2 = 1.0d;
        } else {
            d2 = Math.sin((((this.ou - this.tj) / 300.0d) * 3.141592653589793d) * 4.0d) > 0.0d ? 1.0d : 0.35d;
        }
        if (this.um != null && this.cd != null) {
            this.cd.n(this.um.l, this.um.w, d2);
        }
        l lVar2 = this.um;
        double d13 = lVar2 != null ? (lVar2.x / 2.0d) * d10 : 0.0d;
        l lVar3 = this.um;
        double d14 = lVar3 != null ? (lVar3.fs / 2.0d) * d10 : 0.0d;
        l lVar4 = this.um;
        double d15 = lVar4 != null ? lVar4.l - d13 : 0.0d;
        l lVar5 = this.um;
        double d16 = lVar5 != null ? lVar5.l + d13 : 0.0d;
        l lVar6 = this.um;
        double d17 = lVar6 != null ? lVar6.w - d14 : 0.0d;
        l lVar7 = this.um;
        double d18 = d17;
        double d19 = lVar7 != null ? lVar7.w + d14 : 0.0d;
        int size = this.w.size() - 1;
        while (size >= 0) {
            l lVar8 = this.w.get(size);
            if (lVar8 == this.um || lVar8 == this.sz) {
                d3 = d7;
                d4 = d8;
                d5 = d19;
                d6 = d10;
                z = true;
                i = size;
            } else {
                int i2 = size;
                if ("obstacle".equals(lVar8.n)) {
                    d5 = d19;
                    lVar8.l -= d8 * d7;
                    double d20 = (lVar8.x / 2.0d) * d10;
                    d3 = d7;
                    double d21 = (lVar8.fs / 2.0d) * d10;
                    d4 = d8;
                    double d22 = lVar8.l - d20;
                    d6 = d10;
                    double d23 = lVar8.l + d20;
                    if ((this.um != null && d22 < d16 && d23 > d15 && lVar8.w - d21 < d5 && lVar8.w + d21 > d18) && !lVar8.hd) {
                        lVar8.hd = true;
                        if ("blink".equals(this.n.s)) {
                            this.ou = this.tj + 300.0d;
                        }
                    }
                    if (lVar8.cy || d23 >= d15) {
                        z = true;
                    } else {
                        lVar8.cy = true;
                        if (lVar8.hd) {
                            z = true;
                        } else {
                            this.qg.n(lVar8.q > 0.0d ? lVar8.q : 1.0d);
                            z = true;
                            this.oa++;
                            w();
                        }
                    }
                    if (d23 < 0.0d || !lVar8.oa) {
                        i = i2;
                        this.w.remove(i);
                    } else {
                        i = i2;
                    }
                } else {
                    d3 = d7;
                    d4 = d8;
                    d5 = d19;
                    d6 = d10;
                    i = i2;
                    z = true;
                }
            }
            size = i - 1;
            d19 = d5;
            d7 = d3;
            d8 = d4;
            d10 = d6;
        }
    }
}
