package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.BaseAd;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bv implements Comparable<bv> {
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 1;
    private int A;
    private String B;
    private int C;
    private int D;
    private String E;
    private Map<String, Object> F;
    private String G;
    private String H;
    private long I;
    private String J;
    private int K;
    private int L;
    private double M;
    private int N;
    private String O;
    private String P;
    private int Q;
    private long R;
    private long S;
    private long T;
    private long U;
    private int V;
    private String W;
    private long X;
    private long Y;
    private long Z;
    int a;
    private int aB;
    private int[] aE;
    private JSONArray aH;
    private int aI;
    private int aK;
    private int aL;
    private int aM;
    private int aN;
    private double aO;
    private double aP;
    private JSONObject aQ;
    private int aR;
    private int aS;
    private Map<String, Object> aT;
    private ap aU;
    private int aW;
    private long aX;
    private aa aY;
    private int aZ;
    private long aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private String af;
    private long ag;
    private long ah;
    private double ai;
    private int aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private ad ap;
    private int aq;
    private int ar;
    private String as;
    private int at;
    private int au;
    private long av;
    private l aw;
    private long ax;
    private long ay;
    private String az;
    private long ba;
    private int bb;
    private int bc;
    private String bd;
    private JSONArray be;
    private JSONArray bf;
    private JSONArray bg;
    private int bh;
    private JSONArray bi;
    private JSONArray bj;
    private int bk;
    private long bl;
    private double bm;
    private long bn;
    private int bo;
    private int bp;
    private int bq;
    private String br;
    private int bs;
    private int bt;
    private ad bu;
    int c;
    int d;
    String e;
    int f;
    int g;
    double h;
    int i;
    double j;
    String k;
    protected int l;
    int m;
    int n;
    int o;
    String s;
    long t;
    ATAdRequest y;
    double z;
    private int aA = 1;
    int b = 0;
    private int aC = -1;
    private ATAdConst.CURRENCY aD = ATAdConst.CURRENCY.USD;
    int p = 2;
    boolean q = false;
    double r = -1.0d;
    private int aF = 1;
    private int aG = 1;
    private int aJ = 1;
    private int aV = 2;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(bv bvVar) {
        return com.anythink.core.common.v.l.a(this, bvVar);
    }

    public final long a() {
        return this.ax;
    }

    public final void a(long j) {
        this.ax = j;
    }

    public final long b() {
        return this.ay;
    }

    public final void b(long j) {
        this.ay = j;
    }

    public final double c() {
        return this.z;
    }

    public final void a(double d) {
        this.z = d;
    }

    private ATAdRequest bw() {
        return this.y;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.y = aTAdRequest;
    }

    public bv(int i) {
        this.au = i;
    }

    public final int d() {
        return this.au;
    }

    public final int e() {
        return this.an;
    }

    public final void f() {
        this.an = -1;
    }

    public final int g() {
        return this.A;
    }

    public final void a(int i) {
        this.A = i;
    }

    public final String h() {
        return this.B;
    }

    public final void a(String str) {
        this.B = str;
    }

    public final int i() {
        return this.C;
    }

    public final void b(int i) {
        this.C = i;
    }

    public final int j() {
        return this.D;
    }

    public final void c(int i) {
        this.D = i;
    }

    public final String k() {
        return this.E;
    }

    public final void b(String str) {
        this.E = str;
    }

    public final Map<String, Object> l() {
        return this.F;
    }

    public final void a(Map<String, Object> map) {
        this.F = map;
    }

    public final String m() {
        return this.G;
    }

    public final void c(String str) {
        this.G = str;
    }

    public final void d(String str) {
        this.H = str;
    }

    public final int n() {
        return this.N;
    }

    public final boolean o() {
        return this.N == 1;
    }

    public final void d(int i) {
        this.N = i;
    }

    public final long p() {
        return this.S;
    }

    public final void c(long j) {
        this.S = j;
    }

    @Deprecated
    public final int q() {
        return this.ao;
    }

    public final void e(int i) {
        this.ao = i;
    }

    public final int r() {
        return this.am;
    }

    public final void f(int i) {
        this.am = i;
    }

    public final long s() {
        return this.aa;
    }

    public final void d(long j) {
        this.aa = j;
    }

    public final int t() {
        return this.Q;
    }

    public final void g(int i) {
        this.Q = i;
    }

    public final long u() {
        long jC = com.anythink.core.common.v.ak.c(this);
        getClass().getSimpleName();
        Object[] objArr = new Object[1];
        Long.valueOf(jC);
        return jC;
    }

    public final long v() {
        return this.T;
    }

    public final void e(long j) {
        this.T = j;
    }

    public final long w() {
        return this.U;
    }

    public final void f(long j) {
        this.U = j;
    }

    public final int x() {
        return this.V;
    }

    public final void h(int i) {
        this.V = i;
    }

    public final long y() {
        return this.I;
    }

    public final void g(long j) {
        this.I = j;
    }

    public final String z() {
        return this.W;
    }

    public final void e(String str) {
        this.W = str;
    }

    public final String A() {
        return this.J;
    }

    public final void f(String str) {
        this.J = str;
    }

    public final int B() {
        return this.K;
    }

    public final void i(int i) {
        this.K = i;
    }

    public final int C() {
        return this.L;
    }

    public final void j(int i) {
        this.L = i;
    }

    public final double D() {
        return this.M;
    }

    public final void b(double d) {
        this.M = d;
    }

    private long bx() {
        return this.X;
    }

    public final void h(long j) {
        this.X = j;
    }

    public final String E() {
        return this.O;
    }

    public final void g(String str) {
        this.O = str;
    }

    public final String F() {
        return this.P;
    }

    public final void h(String str) {
        this.P = str;
    }

    public final void i(long j) {
        this.Y = j;
    }

    public final long G() {
        return this.Y;
    }

    public final void j(long j) {
        this.Z = j;
    }

    public final long H() {
        return this.Z;
    }

    public final int I() {
        return this.ab;
    }

    public final void k(int i) {
        this.ab = i;
    }

    public final int J() {
        return this.ac;
    }

    public final void l(int i) {
        this.ac = i;
    }

    private int by() {
        return this.ad;
    }

    private void ac(int i) {
        this.ad = i;
    }

    public final int K() {
        return this.ae;
    }

    public final void m(int i) {
        this.ae = i;
    }

    public final String L() {
        return this.af;
    }

    public final void i(String str) {
        this.af = str;
    }

    public final void k(long j) {
        this.ag = j;
    }

    public final long M() {
        return this.ag;
    }

    public final long N() {
        return this.ah;
    }

    public final void l(long j) {
        this.ah = j;
    }

    public final double O() {
        return this.ai;
    }

    public final void c(double d) {
        this.ai = d;
    }

    private int bz() {
        return this.aj;
    }

    public final void n(int i) {
        this.aj = i;
    }

    public final int P() {
        return this.ak;
    }

    public final void o(int i) {
        this.ak = i;
    }

    public final boolean Q() {
        return this.al == 2;
    }

    public final void p(int i) {
        this.al = i;
    }

    public final ad R() {
        return this.ap;
    }

    private void b(ad adVar) {
        this.ap = adVar;
    }

    public final ad S() {
        return this.bu;
    }

    public final void a(ad adVar) {
        this.bu = adVar;
    }

    public final int T() {
        return this.aq;
    }

    private void ad(int i) {
        this.aq = i;
    }

    public final int U() {
        return this.ar;
    }

    public final void V() {
        this.ar = 1;
    }

    public final String W() {
        return this.as;
    }

    private void p(String str) {
        this.as = str;
    }

    public final long X() {
        return this.av;
    }

    public final void m(long j) {
        this.av = j;
    }

    public final String Y() {
        return this.az;
    }

    public final void j(String str) {
        this.az = str;
    }

    private int bA() {
        return this.aB;
    }

    public final void q(int i) {
        this.aB = i;
    }

    public final void r(int i) {
        this.b = i;
    }

    public final int Z() {
        int i = this.b;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final void s(int i) {
        this.c = i;
    }

    public final int aa() {
        return this.c;
    }

    public final int ab() {
        return this.d;
    }

    public final void t(int i) {
        this.d = i;
    }

    public final String ac() {
        return this.e;
    }

    public final void k(String str) {
        this.e = str;
    }

    public final int ad() {
        return this.a;
    }

    public final void u(int i) {
        this.a = i;
    }

    public final int ae() {
        return this.aC;
    }

    public final void v(int i) {
        this.aC = i;
    }

    public final int af() {
        ad adVar = this.ap;
        if (adVar != null && adVar.n != 0) {
            return this.ap.n;
        }
        return this.f;
    }

    public final void w(int i) {
        this.f = i;
    }

    public final int ag() {
        return this.bo;
    }

    public final void x(int i) {
        this.bo = i;
    }

    public final int ah() {
        return this.bp;
    }

    public final void y(int i) {
        this.bp = i;
    }

    public final int ai() {
        return this.bq;
    }

    public final void z(int i) {
        this.bq = i;
    }

    public final String aj() {
        return this.br;
    }

    public final void l(String str) {
        this.br = str;
    }

    public final int ak() {
        return this.bs;
    }

    public final void A(int i) {
        this.bs = i;
    }

    public final int al() {
        return this.bt;
    }

    public final void B(int i) {
        this.bt = i;
    }

    private int a(bv bvVar) {
        return com.anythink.core.common.v.l.a(this, bvVar);
    }

    public final synchronized void a(bv bvVar, int i, int i2, int i3) {
        if (bvVar.W.equals(this.W)) {
            this.M = bvVar.M;
            this.j = bvVar.j;
            this.z = bvVar.z;
            this.aD = bvVar.aD;
            this.Q = i2;
            this.O = bvVar.O;
            this.as = bvVar.as;
            this.an = 0;
            if (i == 0) {
                this.aq = bvVar.aq;
            } else {
                this.aq = i;
            }
            this.P = bvVar.P;
            this.ap = bvVar.ap;
            this.ar = i3;
            this.aU = bvVar.aU;
        }
    }

    public final boolean an() {
        return this.A == 1 && this.ao == 1;
    }

    public final int ao() {
        return this.at;
    }

    public final void C(int i) {
        this.at = i;
    }

    public final ATAdConst.CURRENCY ap() {
        return this.aD;
    }

    public final void a(ATAdConst.CURRENCY currency) {
        this.aD = currency;
    }

    public final int aq() {
        return this.g;
    }

    public final void D(int i) {
        this.g = i;
    }

    public final double ar() {
        return this.h;
    }

    public final void d(double d) {
        this.h = d;
    }

    public final int as() {
        return this.i;
    }

    public final void E(int i) {
        this.i = i;
    }

    public final double at() {
        return this.j;
    }

    public final void e(double d) {
        this.j = d;
    }

    public final String au() {
        return this.k;
    }

    public final void m(String str) {
        this.k = str;
    }

    public final int av() {
        return this.l;
    }

    public final void F(int i) {
        this.l = i;
    }

    public final int aw() {
        return this.m;
    }

    public final void G(int i) {
        this.m = i;
    }

    public final int ax() {
        return this.n;
    }

    public final void H(int i) {
        this.n = i;
    }

    public final int ay() {
        int i = this.o;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final void I(int i) {
        this.o = i;
    }

    public final int az() {
        return this.p;
    }

    public final void J(int i) {
        this.p = i;
    }

    public final boolean aA() {
        return this.q;
    }

    public final void aB() {
        this.q = true;
    }

    public final double aC() {
        return this.r;
    }

    public final void f(double d) {
        this.r = d;
    }

    public final String aD() {
        return this.s;
    }

    public final void n(String str) {
        this.s = str;
    }

    public final long aE() {
        return this.t;
    }

    public final void n(long j) {
        this.t = j;
    }

    public String toString() {
        return super.toString();
    }

    public final void a(int[] iArr) {
        this.aE = iArr;
    }

    public final int[] aF() {
        return this.aE;
    }

    public final int aG() {
        return this.aF;
    }

    public final void K(int i) {
        this.aF = i;
    }

    public final int aH() {
        return this.aG;
    }

    public final void L(int i) {
        this.aG = i;
    }

    private boolean bB() {
        return this.aG == 1;
    }

    public final JSONArray aI() {
        return this.aH;
    }

    public final void a(JSONArray jSONArray) {
        this.aH = jSONArray;
    }

    public final int aJ() {
        return this.aI;
    }

    public final void M(int i) {
        this.aI = i;
    }

    public final int aK() {
        return this.aJ;
    }

    public final void N(int i) {
        this.aJ = i;
    }

    public final int aL() {
        return this.aK;
    }

    public final void O(int i) {
        this.aK = i;
    }

    public final int aM() {
        return this.aL;
    }

    public final void P(int i) {
        this.aL = i;
    }

    public final int aN() {
        return this.aM;
    }

    public final void Q(int i) {
        this.aM = i;
    }

    public final int aO() {
        return this.aN;
    }

    public final void R(int i) {
        this.aN = i;
    }

    public final double aP() {
        return this.aO;
    }

    public final void g(double d) {
        this.aO = d;
    }

    public final double aQ() {
        return this.aP;
    }

    public final void h(double d) {
        this.aP = d;
    }

    public final JSONObject aR() {
        return this.aQ;
    }

    public final void a(JSONObject jSONObject) {
        this.aQ = jSONObject;
    }

    public final int aS() {
        return this.aR;
    }

    public final void S(int i) {
        this.aR = i;
    }

    public final int aT() {
        return this.aS;
    }

    public final void T(int i) {
        this.aS = i;
    }

    public final boolean aU() {
        return com.anythink.core.common.v.p.b(this.au);
    }

    public final boolean aV() {
        return com.anythink.core.common.v.p.c(this.au);
    }

    private boolean bC() {
        return com.anythink.core.common.v.p.d(this.au);
    }

    public final ap aW() {
        return this.aU;
    }

    public final void a(ap apVar) {
        this.aU = apVar;
    }

    public final Map<String, Object> aX() {
        return this.aT;
    }

    public final void a(BaseAd baseAd) {
        int nativeAdInteractionType;
        String str;
        String appPackageName;
        int i = 0;
        String descriptionText = "";
        if (baseAd != null) {
            String title = baseAd.getTitle();
            nativeAdInteractionType = baseAd.getNativeAdInteractionType();
            ATAdAppInfo adAppInfo = baseAd.getAdAppInfo();
            if (adAppInfo != null) {
                descriptionText = adAppInfo.getPublisher();
                appPackageName = adAppInfo.getAppPackageName();
            } else {
                appPackageName = "";
            }
            if (TextUtils.isEmpty(descriptionText)) {
                descriptionText = baseAd.getDescriptionText();
            }
            if (TextUtils.equals(baseAd.getAdType(), "1")) {
                i = baseAd.getVideoWidth() > baseAd.getVideoHeight() ? 3 : 4;
            } else if (TextUtils.equals(baseAd.getAdType(), "2")) {
                if (baseAd.getImageUrlList() != null && baseAd.getImageUrlList().size() > 1) {
                    i = 5;
                } else if (baseAd.getMainImageWidth() > baseAd.getMainImageHeight()) {
                    str = descriptionText;
                    descriptionText = title;
                    i = 1;
                } else {
                    i = 2;
                }
            }
            str = descriptionText;
            descriptionText = title;
        } else {
            nativeAdInteractionType = 0;
            str = "";
            appPackageName = str;
        }
        HashMap map = new HashMap();
        this.aT = map;
        map.put(com.anythink.core.common.d.j.w.z, Integer.valueOf(i));
        this.aT.put(com.anythink.core.common.d.j.w.A, descriptionText);
        this.aT.put(com.anythink.core.common.d.j.w.B, str);
        this.aT.put(com.anythink.core.common.d.j.w.C, appPackageName);
        this.aT.put(com.anythink.core.common.d.j.w.D, Integer.valueOf(nativeAdInteractionType));
    }

    public final int aY() {
        return this.aV;
    }

    public final void U(int i) {
        this.aV = i;
    }

    public final int aZ() {
        return this.aW;
    }

    public final void V(int i) {
        this.aW = i;
    }

    public final void o(long j) {
        this.aX = j;
    }

    public final long ba() {
        return this.aX;
    }

    public final aa bb() {
        return this.aY;
    }

    public final void a(aa aaVar) {
        this.aY = aaVar;
    }

    public final boolean bc() {
        if (this.aZ != 2 || this.ba <= 0 || this.bb != 4) {
            return false;
        }
        int i = this.aC;
        return i == -1 || i == 4;
    }

    public final void W(int i) {
        this.aZ = i;
    }

    public final int bd() {
        return this.aZ;
    }

    public final long be() {
        return this.ba;
    }

    public final void p(long j) {
        this.ba = j;
    }

    public final void X(int i) {
        this.bb = i;
    }

    public final int bf() {
        return this.bb;
    }

    public final int bg() {
        return this.bc;
    }

    public final void Y(int i) {
        this.bc = i;
    }

    private String bD() {
        return this.bd;
    }

    public final void o(String str) {
        this.bd = str;
    }

    public final JSONArray bh() {
        return this.bf;
    }

    public final void b(JSONArray jSONArray) {
        this.bf = jSONArray;
    }

    public final JSONArray bi() {
        return this.bg;
    }

    public final void c(JSONArray jSONArray) {
        this.bg = jSONArray;
    }

    public final int bj() {
        return this.bh;
    }

    public final void Z(int i) {
        this.bh = i;
    }

    public final JSONArray bk() {
        return this.bi;
    }

    public final void d(JSONArray jSONArray) {
        this.bi = jSONArray;
    }

    public final JSONArray bl() {
        return this.bj;
    }

    public final void e(JSONArray jSONArray) {
        this.bj = jSONArray;
    }

    public final JSONArray bm() {
        return this.be;
    }

    public final void f(JSONArray jSONArray) {
        this.be = jSONArray;
    }

    public final int bn() {
        return this.bk;
    }

    public final void aa(int i) {
        this.bk = i;
    }

    public final long bo() {
        return this.bl;
    }

    public final void q(long j) {
        this.bl = j;
    }

    public final double bp() {
        return this.bm;
    }

    public final void i(double d) {
        this.bm = d;
    }

    public final long bq() {
        return this.bn;
    }

    public final void r(long j) {
        this.bn = j;
    }

    public final boolean br() {
        ad adVar = this.ap;
        if (adVar != null) {
            return adVar.s();
        }
        return false;
    }

    public final int bs() {
        return this.aA;
    }

    public final void ab(int i) {
        this.aA = i;
    }

    public final String bt() {
        ad adVar = this.ap;
        return adVar != null ? adVar.x() : "";
    }

    public final String bu() {
        ad adVar = this.ap;
        return adVar != null ? adVar.getOriginRequestId() : "";
    }

    public final void a(l lVar) {
        this.aw = lVar;
    }

    public final l bv() {
        return this.aw;
    }

    public final boolean am() {
        int i = this.A;
        return i == 66 || i == 67;
    }

    public final void a(ad adVar, int i, int i2, int i3) {
        this.Q = i2;
        this.M = adVar.getPrice();
        this.j = adVar.getSortPrice();
        this.z = adVar.getRmbPrice();
        this.aD = adVar.getCurrency();
        this.O = adVar.token;
        this.as = adVar.m;
        this.an = 0;
        this.aq = i;
        this.ap = adVar;
        this.ar = i3;
        if (i3 == 1) {
            this.P = "";
        }
        if (this.aU != null) {
            String strM = adVar.m();
            int iO = adVar.o();
            String strN = adVar.n();
            this.aU.b(strM);
            this.aU.d(strN);
            this.aU.a(iO);
        }
    }
}
