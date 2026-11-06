package com.anythink.core.common.h;

import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aw {
    double a;
    bv b;
    ATAdMixBidInfo.BidEntity c;
    private int d;
    private n e;
    private boolean f;
    private String g;
    private int h;
    private double i;
    private String j;
    private String k;
    private Double l;
    private int m;
    private double n;
    private String o;
    private boolean p;
    private String q;
    private int r;
    private int s;
    private int t;
    private double u;
    private double v;

    public aw(int i, bv bvVar, n nVar) {
        this.l = null;
        this.r = 1;
        this.d = i;
        this.b = bvVar;
        this.f = bvVar.am();
        if (nVar != null) {
            n nVarAf = nVar.af();
            this.e = nVarAf;
            com.anythink.core.common.v.aj.a(nVarAf, bvVar, 0, false);
        }
        this.g = "0";
        if (bvVar != null) {
            int iQ = bvVar.q();
            if (iQ == 2) {
                this.g = "2";
            } else if (iQ == 5 || iQ == 6) {
                this.g = "3";
            } else {
                this.g = "1";
            }
            this.h = bvVar.aH();
            if (bvVar.g() == 8) {
                try {
                    this.q = bvVar.l().get("unit_id").toString();
                } catch (Throwable unused) {
                }
            }
            this.r = bvVar.bs();
        }
    }

    public aw(int i, bv bvVar, n nVar, double d) {
        this(i, bvVar, nVar);
        this.a = d;
    }

    public final ATAdMixBidInfo.BidEntity a() {
        return this.c;
    }

    public final void a(ATAdMixBidInfo.BidEntity bidEntity) {
        this.c = bidEntity;
    }

    public final int b() {
        return this.s;
    }

    public final void a(int i) {
        this.s = i;
    }

    public final void a(double d, String str, String str2) {
        this.i = d;
        this.j = str;
        this.k = str2;
    }

    public final double c() {
        return this.i;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.k;
    }

    private void a(bv bvVar) {
        this.g = "0";
        if (bvVar == null) {
            return;
        }
        int iQ = bvVar.q();
        if (iQ == 2) {
            this.g = "2";
        } else if (iQ == 5 || iQ == 6) {
            this.g = "3";
        } else {
            this.g = "1";
        }
        this.h = bvVar.aH();
        if (bvVar.g() == 8) {
            try {
                this.q = bvVar.l().get("unit_id").toString();
            } catch (Throwable unused) {
            }
        }
        this.r = bvVar.bs();
    }

    public final boolean f() {
        return this.f;
    }

    public final double g() {
        return this.a;
    }

    public final int h() {
        return this.d;
    }

    public final String i() {
        n nVar = this.e;
        return nVar != null ? nVar.aJ() : "";
    }

    private String I() {
        n nVar = this.e;
        return nVar != null ? String.valueOf(nVar.Z()) : "";
    }

    private String J() {
        n nVar = this.e;
        return nVar != null ? String.valueOf(nVar.aG()) : "";
    }

    public final String j() {
        n nVar = this.e;
        return nVar != null ? nVar.aI() : "";
    }

    public final int k() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.Y();
        }
        return 0;
    }

    public final String l() {
        n nVar = this.e;
        return nVar != null ? nVar.M() : "";
    }

    public final String m() {
        n nVar = this.e;
        return nVar != null ? nVar.aH() : "";
    }

    public final String n() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.aK();
        }
        return null;
    }

    public final String o() {
        n nVar = this.e;
        return nVar != null ? nVar.aB() : "";
    }

    public final String p() {
        n nVar = this.e;
        return nVar != null ? nVar.aC() : "";
    }

    public final JSONObject q() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.ax();
        }
        return null;
    }

    public final int r() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.k();
        }
        return 0;
    }

    public final String s() {
        return this.g;
    }

    public final int t() {
        return this.h;
    }

    public final boolean u() {
        return this.h == 1;
    }

    public final void a(Double d) {
        this.l = d;
    }

    public final Double v() {
        return this.l;
    }

    public final int w() {
        return this.m;
    }

    public final void b(int i) {
        this.m = i;
    }

    public final double x() {
        return this.n;
    }

    public final void a(double d) {
        this.n = d;
    }

    public final String y() {
        return this.o;
    }

    public final void a(String str) {
        this.o = str;
    }

    public final n z() {
        return this.e;
    }

    public final bv A() {
        return this.b;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final String B() {
        return this.p ? "1" : "0";
    }

    public final String C() {
        return this.q;
    }

    public final int D() {
        return this.r;
    }

    private void d(int i) {
        this.r = i;
    }

    public final void c(int i) {
        this.t = i;
    }

    public final int E() {
        return this.t;
    }

    public final double G() {
        return this.u;
    }

    public final void b(double d) {
        this.u = d;
    }

    public final double H() {
        return this.v;
    }

    public final void c(double d) {
        this.v = d;
    }

    public final MgComparedResult F() {
        n nVar = this.e;
        MgPreLoadAdRequest preLoadInfo = (nVar == null || nVar.a() == null) ? null : nVar.a().getPreLoadInfo();
        if (preLoadInfo != null) {
            return preLoadInfo.getMgComparedResult();
        }
        return null;
    }
}
