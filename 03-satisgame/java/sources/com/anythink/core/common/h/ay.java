package com.anythink.core.common.h;

import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ay {
    double a;
    by b;
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
    private boolean w;
    private int x;
    private double y;
    private String z;

    public final int a() {
        return this.x;
    }

    public final void a(int i) {
        this.x = i;
    }

    public ay(int i, by byVar, n nVar) {
        this.l = null;
        this.r = 1;
        this.d = i;
        this.b = byVar;
        this.f = byVar.as();
        this.w = byVar.at();
        if (nVar != null) {
            n nVarAh = nVar.ah();
            this.e = nVarAh;
            com.anythink.core.common.u.ai.a(nVarAh, byVar, 0, false);
        }
        this.g = "0";
        if (byVar != null) {
            int iY = byVar.y();
            if (iY == 2) {
                this.g = "2";
            } else if (iY == 6) {
                this.g = "3";
            } else {
                this.g = "1";
            }
            this.h = byVar.aP();
            if (byVar.n() == 8) {
                try {
                    this.q = byVar.s().get("unit_id").toString();
                } catch (Throwable unused) {
                }
            }
            this.r = byVar.bA();
        }
    }

    public ay(int i, by byVar, n nVar, double d) {
        this(i, byVar, nVar);
        this.a = d;
    }

    public final ATAdMixBidInfo.BidEntity b() {
        return this.c;
    }

    public final void a(ATAdMixBidInfo.BidEntity bidEntity) {
        this.c = bidEntity;
    }

    public final int c() {
        return this.s;
    }

    public final void b(int i) {
        this.s = i;
    }

    public final void a(double d, String str, String str2) {
        this.i = d;
        this.j = str;
        this.k = str2;
    }

    public final double d() {
        return this.i;
    }

    public final String e() {
        return this.j;
    }

    public final String f() {
        return this.k;
    }

    private void a(by byVar) {
        this.g = "0";
        if (byVar == null) {
            return;
        }
        int iY = byVar.y();
        if (iY == 2) {
            this.g = "2";
        } else if (iY == 6) {
            this.g = "3";
        } else {
            this.g = "1";
        }
        this.h = byVar.aP();
        if (byVar.n() == 8) {
            try {
                this.q = byVar.s().get("unit_id").toString();
            } catch (Throwable unused) {
            }
        }
        this.r = byVar.bA();
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.w;
    }

    public final double i() {
        return this.a;
    }

    public final int j() {
        return this.d;
    }

    public final String k() {
        n nVar = this.e;
        return nVar != null ? nVar.aR() : "";
    }

    private String M() {
        n nVar = this.e;
        return nVar != null ? String.valueOf(nVar.aa()) : "";
    }

    private String N() {
        n nVar = this.e;
        return nVar != null ? String.valueOf(nVar.aO()) : "";
    }

    public final String l() {
        n nVar = this.e;
        return nVar != null ? nVar.aQ() : "";
    }

    public final int m() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.Z();
        }
        return 0;
    }

    public final String n() {
        n nVar = this.e;
        return nVar != null ? nVar.N() : "";
    }

    public final String o() {
        n nVar = this.e;
        return nVar != null ? nVar.aP() : "";
    }

    public final String p() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.aS();
        }
        return null;
    }

    public final String q() {
        n nVar = this.e;
        return nVar != null ? nVar.aJ() : "";
    }

    public final String r() {
        n nVar = this.e;
        return nVar != null ? nVar.aK() : "";
    }

    public final JSONObject s() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.aF();
        }
        return null;
    }

    public final int t() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.l();
        }
        return 0;
    }

    public final String u() {
        return this.g;
    }

    public final int v() {
        return this.h;
    }

    public final boolean w() {
        return this.h == 1;
    }

    public final void a(Double d) {
        this.l = d;
    }

    public final Double x() {
        return this.l;
    }

    public final int y() {
        return this.m;
    }

    public final void c(int i) {
        this.m = i;
    }

    public final double z() {
        return this.n;
    }

    public final void a(double d) {
        this.n = d;
    }

    public final String A() {
        return this.o;
    }

    public final void a(String str) {
        this.o = str;
    }

    public final n B() {
        return this.e;
    }

    public final by C() {
        return this.b;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final String D() {
        return this.p ? "1" : "0";
    }

    public final String E() {
        return this.q;
    }

    public final int F() {
        return this.r;
    }

    private void e(int i) {
        this.r = i;
    }

    public final void d(int i) {
        this.t = i;
    }

    public final int G() {
        return this.t;
    }

    public final double I() {
        return this.u;
    }

    public final void b(double d) {
        this.u = d;
    }

    public final double J() {
        return this.v;
    }

    public final void c(double d) {
        this.v = d;
    }

    public final double K() {
        return this.y;
    }

    public final void d(double d) {
        this.y = d;
    }

    public final String L() {
        return this.z;
    }

    public final void b(String str) {
        this.z = str;
    }

    public final MgComparedResult H() {
        n nVar = this.e;
        MgPreLoadAdRequest preLoadInfo = (nVar == null || nVar.b() == null) ? null : nVar.b().getPreLoadInfo();
        if (preLoadInfo != null) {
            return preLoadInfo.getMgComparedResult();
        }
        return null;
    }
}
