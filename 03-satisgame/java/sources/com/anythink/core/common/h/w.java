package com.anythink.core.common.h;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.h.y;
import java.io.Serializable;
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

    public boolean D() {
        return false;
    }

    public abstract int a();

    public abstract List<String> b(T t);

    public abstract List<String> c(T t);

    public abstract String g();

    protected w() {
    }

    public final String b() {
        return this.M;
    }

    public final void a(String str) {
        this.M = str;
    }

    private int M() {
        return this.X;
    }

    private void d(int i2) {
        this.X = i2;
    }

    private int N() {
        return this.Y;
    }

    private void e(int i2) {
        this.Y = i2;
    }

    public final String c() {
        return this.V;
    }

    private void w(String str) {
        this.V = str;
    }

    public final String d() {
        return this.W;
    }

    private void x(String str) {
        this.W = str;
    }

    private int O() {
        return this.S;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean e() {
        int i2 = this.S;
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            String strValueOf = String.valueOf(this.P.n());
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

    private void f(int i2) {
        this.S = i2;
    }

    private String P() {
        return this.T;
    }

    private void y(String str) {
        this.T = str;
    }

    private String Q() {
        return this.U;
    }

    private void z(String str) {
        this.U = str;
    }

    private String R() {
        return this.Q;
    }

    private void A(String str) {
        this.Q = str;
    }

    public final y f() {
        return this.P;
    }

    public final void a(y yVar) {
        this.P = yVar;
    }

    private String S() {
        return this.N;
    }

    private void B(String str) {
        this.N = str;
    }

    private int T() {
        return this.G;
    }

    private void g(int i2) {
        this.G = i2;
    }

    private String U() {
        return this.H;
    }

    private void C(String str) {
        this.H = str;
    }

    public final String h() {
        return this.m;
    }

    public final void b(String str) {
        this.m = str;
    }

    public final String i() {
        return this.n;
    }

    public final void c(String str) {
        this.n = str;
    }

    public final String j() {
        return this.o;
    }

    public final void d(String str) {
        this.o = str;
    }

    public final String k() {
        return this.p;
    }

    public final void e(String str) {
        this.p = str;
    }

    public final String l() {
        return this.q;
    }

    public final void f(String str) {
        this.q = str;
    }

    private String V() {
        return this.r;
    }

    public final void g(String str) {
        this.r = str;
    }

    public final String m() {
        return this.s;
    }

    public final void h(String str) {
        this.s = str;
    }

    public final String n() {
        return this.t;
    }

    public final void i(String str) {
        this.t = str;
    }

    public final String o() {
        return this.u;
    }

    public final void j(String str) {
        this.u = str;
    }

    public final String p() {
        return this.v;
    }

    public final void k(String str) {
        this.v = str;
    }

    private String W() {
        return this.w;
    }

    public final void l(String str) {
        this.w = str;
    }

    public final String q() {
        return this.x;
    }

    public final void m(String str) {
        this.x = str;
    }

    public final String r() {
        return this.y;
    }

    public final void n(String str) {
        this.y = str;
    }

    public final String s() {
        return this.z;
    }

    public final void o(String str) {
        this.z = str;
    }

    public final int t() {
        return this.A;
    }

    public final void a(int i2) {
        this.A = i2;
    }

    public final int u() {
        return this.D;
    }

    public final void b(int i2) {
        this.D = i2;
    }

    public final boolean v() {
        return !TextUtils.isEmpty(this.v);
    }

    private int X() {
        return this.E;
    }

    public final void c(int i2) {
        this.E = i2;
    }

    private String Y() {
        return this.F;
    }

    private void D(String str) {
        this.F = str;
    }

    public final String w() {
        return this.I;
    }

    public final void p(String str) {
        this.I = str;
    }

    public final String x() {
        return this.J;
    }

    public final void q(String str) {
        this.J = str;
    }

    public final String y() {
        return this.K;
    }

    public final void r(String str) {
        this.K = str;
    }

    public final String z() {
        return this.L;
    }

    public final void s(String str) {
        this.L = str;
    }

    private int Z() {
        return this.af;
    }

    private void h(int i2) {
        this.af = i2;
    }

    public final String A() {
        return this.ag;
    }

    private void E(String str) {
        this.ag = str;
    }

    public final Bitmap B() {
        return this.O;
    }

    public final void a(Bitmap bitmap) {
        this.O = bitmap;
    }

    public final void t(String str) {
        this.b = str;
    }

    public final void u(String str) {
        this.c = str;
    }

    public final void v(String str) {
        this.d = str;
    }

    public final boolean C() {
        return (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.K) || TextUtils.isEmpty(this.L)) ? false : true;
    }

    public final String E() {
        return this.R;
    }

    private void F(String str) {
        this.R = str;
    }

    private boolean G(String str) {
        return TextUtils.equals(this.v, str) && !TextUtils.isEmpty(str);
    }

    public final int F() {
        return this.ac;
    }

    private void i(int i2) {
        this.ac = i2;
    }

    public final int G() {
        return this.ad;
    }

    private void j(int i2) {
        this.ad = i2;
    }

    private long aa() {
        return this.ae;
    }

    private void a(long j2) {
        this.ae = j2;
    }

    private boolean ab() {
        return this.a;
    }

    private void a(boolean z) {
        this.a = z;
    }

    private int ac() {
        return this.Z;
    }

    private void k(int i2) {
        this.Z = i2;
    }

    private int ad() {
        return this.aa;
    }

    private void l(int i2) {
        this.aa = i2;
    }

    private int ae() {
        return this.ab;
    }

    private void m(int i2) {
        this.ab = i2;
    }

    private String af() {
        return this.ah;
    }

    private void H(String str) {
        this.ah = str;
    }

    private boolean ag() {
        return this.D == 4;
    }

    private String ah() {
        return this.ai;
    }

    private void I(String str) {
        this.ai = str;
    }

    private boolean ai() {
        return this.aj;
    }

    private void b(boolean z) {
        this.aj = z;
    }

    private int aj() {
        return this.e;
    }

    private void n(int i2) {
        this.e = i2;
    }

    private int ak() {
        return this.ak;
    }

    private void o(int i2) {
        this.ak = i2;
    }

    private String al() {
        return this.al;
    }

    private void J(String str) {
        this.al = str;
    }

    public final String H() {
        return this.am;
    }

    private void K(String str) {
        this.am = str;
    }

    public final String I() {
        return this.an;
    }

    private void L(String str) {
        this.an = str;
    }

    public final String J() {
        return this.ao;
    }

    private void M(String str) {
        this.ao = str;
    }

    public final String K() {
        y yVar = this.P;
        return yVar != null ? yVar.aa() : "";
    }

    private int am() {
        y yVar = this.P;
        if (yVar != null && yVar.W() == 1 && !TextUtils.isEmpty(this.P.aa())) {
            if ((this.P.n() == 1 && TextUtils.isEmpty(this.v)) ? false : true) {
                return 3;
            }
        }
        return e() ? 2 : 1;
    }

    private String an() {
        return this.ap;
    }

    private void N(String str) {
        this.ap = str;
    }

    private String ao() {
        return this.aq;
    }

    private void O(String str) {
        this.aq = str;
    }

    private String ap() {
        return this.ar;
    }

    private void P(String str) {
        this.ar = str;
    }

    private String aq() {
        return this.as;
    }

    private void Q(String str) {
        this.as = str;
    }

    private String ar() {
        return this.at;
    }

    private void R(String str) {
        this.at = str;
    }

    private JSONArray as() {
        if (TextUtils.isEmpty(this.au)) {
            return null;
        }
        try {
            return new JSONArray(this.au);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String at() {
        return this.au;
    }

    private void S(String str) {
        this.au = str;
    }

    private String au() {
        return this.av;
    }

    private void T(String str) {
        this.av = str;
    }

    public final String L() {
        return this.aw;
    }

    private void U(String str) {
        this.aw = str;
    }

    public String d(T t) {
        return this.s;
    }
}
