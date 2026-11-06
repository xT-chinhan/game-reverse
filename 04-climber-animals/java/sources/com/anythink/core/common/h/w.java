package com.anythink.core.common.h;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.h.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class w<T extends y> implements Serializable {
    public static final int B = 1;
    public static final int C = 2;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 10;
    protected int A;
    protected int D;
    protected int E;
    protected String F;
    protected int G;
    protected String H;
    protected String I;
    protected String J;
    protected String K;
    protected String L;
    protected String M;
    protected String N;
    protected Bitmap O;
    protected y P;
    protected String Q;
    protected String R;
    protected int S;
    protected String T;
    protected String U;
    protected String V;
    protected String W;
    protected int X;
    protected int Y;
    private boolean a;
    protected int aa;
    protected int ab;
    protected int ac;
    protected int ad;
    protected long ae;
    protected int af;
    protected String ag;
    protected String ah;
    protected String ai;
    private int ak;
    private String al;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    private String at;
    private String au;
    private String av;
    private String aw;
    private String b;
    private String c;
    private String d;
    private int e;
    protected String m;
    protected String n;
    protected String o;
    protected String p;
    protected String q;
    protected String r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;
    protected String z;
    protected int Z = -1;
    protected boolean aj = false;
    private String am = "";
    private String an = "";
    private String ao = "";

    public static class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
    }

    public abstract String a();

    public abstract List<String> a(T t);

    public abstract int b();

    public abstract List<String> b(T t);

    public boolean c() {
        return false;
    }

    protected w() {
    }

    public final String h() {
        return this.M;
    }

    public final void c(String str) {
        this.M = str;
    }

    public final int i() {
        return this.X;
    }

    public final void c(int i2) {
        this.X = i2;
    }

    public final int j() {
        return this.Y;
    }

    public final void d(int i2) {
        this.Y = i2;
    }

    public final String k() {
        return this.V;
    }

    public final void d(String str) {
        this.V = str;
    }

    public final String l() {
        return this.W;
    }

    public final void e(String str) {
        this.W = str;
    }

    public final int m() {
        return this.S;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean n() {
        int i2 = this.S;
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            String strValueOf = String.valueOf(this.P.D());
            strValueOf.hashCode();
            switch (strValueOf) {
                case "0":
                case "2":
                case "4":
                    if (TextUtils.isEmpty(this.v) && !TextUtils.isEmpty(this.T)) {
                        return true;
                    }
                    break;
                case "1":
                case "3":
                    return !TextUtils.isEmpty(this.T);
            }
        }
        return false;
    }

    public final void e(int i2) {
        this.S = i2;
    }

    public final String o() {
        return this.T;
    }

    public final void f(String str) {
        this.T = str;
    }

    public final String p() {
        return this.U;
    }

    public final void g(String str) {
        this.U = str;
    }

    public final String q() {
        return this.Q;
    }

    public final void h(String str) {
        this.Q = str;
    }

    public final y r() {
        return this.P;
    }

    public final void c(y yVar) {
        this.P = yVar;
    }

    public final String s() {
        return this.N;
    }

    public final void i(String str) {
        this.N = str;
    }

    public final int t() {
        return this.G;
    }

    public final void f(int i2) {
        this.G = i2;
    }

    public final String u() {
        return this.H;
    }

    public final void j(String str) {
        this.H = str;
    }

    public final String v() {
        return this.m;
    }

    public final void k(String str) {
        this.m = str;
    }

    public final String w() {
        return this.n;
    }

    public final void l(String str) {
        this.n = str;
    }

    public final String x() {
        return this.o;
    }

    public final void m(String str) {
        this.o = str;
    }

    public final String y() {
        return this.p;
    }

    public final void n(String str) {
        this.p = str;
    }

    public final String z() {
        return this.q;
    }

    public final void o(String str) {
        this.q = str;
    }

    public final String A() {
        return this.r;
    }

    public final void p(String str) {
        this.r = str;
    }

    public final String B() {
        return this.s;
    }

    public final void q(String str) {
        this.s = str;
    }

    public final String C() {
        return this.t;
    }

    public final void r(String str) {
        this.t = str;
    }

    public final String D() {
        return this.u;
    }

    public final void s(String str) {
        this.u = str;
    }

    public final String E() {
        return this.v;
    }

    public final void t(String str) {
        this.v = str;
    }

    public final String F() {
        return this.w;
    }

    public final void u(String str) {
        this.w = str;
    }

    public final String G() {
        return this.x;
    }

    public final void v(String str) {
        this.x = str;
    }

    public final String H() {
        return this.y;
    }

    public final void w(String str) {
        this.y = str;
    }

    public final String I() {
        return this.z;
    }

    public final void x(String str) {
        this.z = str;
    }

    public final int J() {
        return this.A;
    }

    public final void g(int i2) {
        this.A = i2;
    }

    public final int K() {
        return this.D;
    }

    public final void h(int i2) {
        this.D = i2;
    }

    public final boolean L() {
        return !TextUtils.isEmpty(this.v);
    }

    private int d() {
        return this.E;
    }

    public final void i(int i2) {
        this.E = i2;
    }

    private String e() {
        return this.F;
    }

    public final void y(String str) {
        this.F = str;
    }

    public final String M() {
        return this.I;
    }

    public final void z(String str) {
        this.I = str;
    }

    public final String N() {
        return this.J;
    }

    public final void A(String str) {
        this.J = str;
    }

    public final String O() {
        return this.K;
    }

    public final void B(String str) {
        this.K = str;
    }

    public final String P() {
        return this.L;
    }

    public final void C(String str) {
        this.L = str;
    }

    public final int Q() {
        return this.af;
    }

    public final void j(int i2) {
        this.af = i2;
    }

    public final String R() {
        return this.ag;
    }

    public final void D(String str) {
        this.ag = str;
    }

    public final Bitmap S() {
        return this.O;
    }

    public final void a(Bitmap bitmap) {
        this.O = bitmap;
    }

    public final void E(String str) {
        this.b = str;
    }

    public final void F(String str) {
        this.c = str;
    }

    public final void G(String str) {
        this.d = str;
    }

    public final boolean T() {
        return (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.K) || TextUtils.isEmpty(this.L)) ? false : true;
    }

    public final String U() {
        return this.R;
    }

    public final void H(String str) {
        this.R = str;
    }

    public final boolean I(String str) {
        return TextUtils.equals(this.v, str) && !TextUtils.isEmpty(str);
    }

    public final int V() {
        return this.ac;
    }

    public final void k(int i2) {
        this.ac = i2;
    }

    public final int W() {
        return this.ad;
    }

    public final void l(int i2) {
        this.ad = i2;
    }

    public final long X() {
        return this.ae;
    }

    public final void a(long j2) {
        this.ae = j2;
    }

    public final boolean Y() {
        return this.a;
    }

    public final void Z() {
        this.a = true;
    }

    public final int aa() {
        return this.Z;
    }

    public final void m(int i2) {
        this.Z = i2;
    }

    public final int ab() {
        return this.aa;
    }

    public final void n(int i2) {
        this.aa = i2;
    }

    public final int ac() {
        return this.ab;
    }

    public final void o(int i2) {
        this.ab = i2;
    }

    public final String ad() {
        return this.ah;
    }

    public final void J(String str) {
        this.ah = str;
    }

    public final boolean ae() {
        return this.D == 4;
    }

    public final String af() {
        return this.ai;
    }

    public final void K(String str) {
        this.ai = str;
    }

    public final boolean ag() {
        return this.aj;
    }

    public final void ah() {
        this.aj = true;
    }

    private int f() {
        return this.e;
    }

    public final void p(int i2) {
        this.e = i2;
    }

    public final int ai() {
        return this.ak;
    }

    public final void q(int i2) {
        this.ak = i2;
    }

    public final String aj() {
        return this.al;
    }

    public final void L(String str) {
        this.al = str;
    }

    public final String ak() {
        return this.am;
    }

    public final void M(String str) {
        this.am = str;
    }

    public final String al() {
        return this.an;
    }

    public final void N(String str) {
        this.an = str;
    }

    public final String am() {
        return this.ao;
    }

    public final void O(String str) {
        this.ao = str;
    }

    public final String an() {
        y yVar = this.P;
        return yVar != null ? yVar.bE() : "";
    }

    public final int ao() {
        y yVar = this.P;
        if (yVar != null && yVar.bA() == 1 && !TextUtils.isEmpty(this.P.bE())) {
            if ((this.P.D() == 1 && TextUtils.isEmpty(this.v)) ? false : true) {
                return 3;
            }
        }
        return n() ? 2 : 1;
    }

    public final String ap() {
        return this.ap;
    }

    public final void P(String str) {
        this.ap = str;
    }

    public final String aq() {
        return this.aq;
    }

    public final void Q(String str) {
        this.aq = str;
    }

    public final String ar() {
        return this.ar;
    }

    public final void R(String str) {
        this.ar = str;
    }

    public final String as() {
        return this.as;
    }

    public final void S(String str) {
        this.as = str;
    }

    public final String at() {
        return this.at;
    }

    public final void T(String str) {
        this.at = str;
    }

    private JSONArray g() {
        if (TextUtils.isEmpty(this.au)) {
            return null;
        }
        try {
            return new JSONArray(this.au);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String au() {
        return this.au;
    }

    public final void U(String str) {
        this.au = str;
    }

    public final String av() {
        return this.av;
    }

    public final void V(String str) {
        this.av = str;
    }

    public final String aw() {
        return this.aw;
    }

    public final void W(String str) {
        this.aw = str;
    }

    public final List<String> e(T t) {
        HashSet hashSet = new HashSet();
        if (t.as() == 1) {
            com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
        }
        if (t.D() == 1) {
            if (t.aO() == 3) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.a);
            }
            if (t.aO() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            if (t.aO() == 4) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.p);
            }
            if (t.as() == 1) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.f);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.g);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.h);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.k);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.l);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.m);
            }
            if (TextUtils.isEmpty(this.v) && t.ao() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            if (t.s() == 1) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            if (t.bo() == 3) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.k);
            }
            if (t.bo() == 2) {
                if (com.anythink.core.common.v.q.b()) {
                    com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.o);
                } else {
                    com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.n);
                }
            }
        }
        if (t.D() == 3) {
            if (t.aO() == 3) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.a);
            }
            if (t.aO() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            if (t.aO() == 4) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.p);
            }
            if (t.bs() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.b);
            }
            if (t.ar() == 1) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.c);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.d);
            }
            if (t.s() == 1) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
        }
        if (t.D() == 4) {
            if (t.bs() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.b);
            }
            if (t.bs() == 3) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.q);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.s);
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.r);
            }
            if (t.aB() > 0) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.e);
            }
            if (t.s() == 1) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.i);
            }
            boolean z = (b() == 1 && (t instanceof ba) && 2 != ((ba) t).a()) ? false : true;
            if ((b() == 2 || b() == 4) && (this instanceof bj)) {
                z = 1 == ((bj) this).an;
            }
            if (!z && t.bt() == 2) {
                com.anythink.core.common.v.g.a().a(hashSet, com.anythink.core.common.a.b.d.j);
            }
        }
        return new ArrayList(hashSet);
    }

    public String d(T t) {
        return this.s;
    }
}
