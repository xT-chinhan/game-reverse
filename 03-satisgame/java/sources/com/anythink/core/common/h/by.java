package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.AnyThinkBaseAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class by implements Comparable<by> {
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 1;
    public static final int y = 1;
    double A;
    public String B;
    public String C;
    private int D;
    private String E;
    private int F;
    private int G;
    private String H;
    private Map<String, Object> I;
    private String J;
    private String K;
    private String L;
    private long M;
    private String N;
    private int O;
    private int P;
    private double Q;
    private int R;
    private String S;
    private String T;
    private int U;
    private long V;
    private long W;
    private long X;
    private long Y;
    private int Z;
    int a;
    private l aA;
    private long aB;
    private long aC;
    private long aD;
    private String aE;
    private int aG;
    private int[] aJ;
    private JSONArray aM;
    private int aN;
    private int aP;
    private int aQ;
    private int aR;
    private int aS;
    private double aT;
    private double aU;
    private JSONObject aV;
    private int aW;
    private int aX;
    private Map<String, Object> aY;
    private aq aZ;
    private String aa;
    private long ab;
    private long ac;
    private long ad;
    private long ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private String aj;
    private long ak;
    private long al;
    private double am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private ad at;
    private int au;
    private int av;
    private String aw;
    private int ax;
    private int ay;
    private long az;
    private int bA;
    private long bB;
    private int bC;
    private int bD;
    private int bE;
    private int bF;
    private long bG;
    private int bH;
    private AnyThinkBaseAdapter bI;
    private ad bJ;
    private long bK;
    private String bM;
    private double bN;
    private int bb;
    private long bc;
    private aa bd;
    private int be;
    private long bf;
    private int bg;
    private int bh;
    private String bi;
    private JSONArray bj;
    private JSONArray bk;
    private JSONArray bl;
    private int bm;
    private JSONArray bn;
    private JSONArray bo;
    private int bp;
    private long bq;
    private double br;
    private long bs;
    private int bt;
    private int bu;
    private int bv;
    private String bw;
    private int bx;
    private int by;
    private int bz;
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
    ATAdRequest z;
    private int aF = 1;
    int b = 0;
    private int aH = -1;
    private ATAdConst.CURRENCY aI = ATAdConst.CURRENCY.USD;
    int p = 2;
    boolean q = false;
    double r = -1.0d;
    private int aK = 1;
    private int aL = 1;
    private int aO = 1;
    private int ba = 2;
    private int bL = 0;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(by byVar) {
        return com.anythink.core.common.u.k.a(this, byVar);
    }

    public final long a() {
        return this.aB;
    }

    public final void a(long j) {
        this.aB = j;
    }

    public final long b() {
        return this.aC;
    }

    public final void b(long j) {
        this.aC = j;
    }

    public final long c() {
        return this.aD;
    }

    public final void c(long j) {
        this.aD = j;
    }

    public final void a(AnyThinkBaseAdapter anyThinkBaseAdapter) {
        this.bI = anyThinkBaseAdapter;
    }

    public final AnyThinkBaseAdapter d() {
        return this.bI;
    }

    public final int e() {
        return this.bD;
    }

    public final void a(int i) {
        this.bD = i;
    }

    public final int f() {
        return this.bA;
    }

    public final void b(int i) {
        this.bA = i;
    }

    public final int g() {
        return this.bz;
    }

    public final void c(int i) {
        this.bz = i;
    }

    public final long h() {
        return this.bB;
    }

    public final void d(long j) {
        this.bB = j;
    }

    public final int i() {
        return this.bC;
    }

    public final void d(int i) {
        this.bC = i;
    }

    public final double j() {
        return this.A;
    }

    public final void a(double d) {
        this.A = d;
    }

    private ATAdRequest bM() {
        return this.z;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.z = aTAdRequest;
    }

    public by(int i) {
        this.ay = i;
    }

    public final int k() {
        return this.ay;
    }

    public final int l() {
        return this.ar;
    }

    public final void m() {
        this.ar = -1;
    }

    public final int n() {
        return this.D;
    }

    public final void e(int i) {
        this.D = i;
    }

    public final String o() {
        return this.E;
    }

    public final void a(String str) {
        this.E = str;
    }

    public final int p() {
        return this.F;
    }

    public final void f(int i) {
        this.F = i;
    }

    public final int q() {
        return this.G;
    }

    public final void g(int i) {
        this.G = i;
    }

    public final String r() {
        return this.H;
    }

    public final void b(String str) {
        this.H = str;
    }

    public final Map<String, Object> s() {
        return this.I;
    }

    public final void a(Map<String, Object> map) {
        this.I = map;
    }

    public final String t() {
        return this.J;
    }

    public final void c(String str) {
        this.J = str;
    }

    public final String u() {
        if (!TextUtils.isEmpty(this.K)) {
            return this.K;
        }
        return this.J;
    }

    public final void d(String str) {
        this.K = str;
    }

    private String bN() {
        return this.L;
    }

    public final void e(String str) {
        this.L = str;
    }

    public final int v() {
        return this.R;
    }

    public final boolean w() {
        return this.R == 1;
    }

    public final void h(int i) {
        this.R = i;
    }

    public final long x() {
        return this.W;
    }

    public final void e(long j) {
        this.W = j;
    }

    @Deprecated
    public final int y() {
        return this.as;
    }

    public final void i(int i) {
        this.as = i;
    }

    public final int z() {
        return this.aq;
    }

    public final void j(int i) {
        this.aq = i;
    }

    public final long A() {
        return this.ae;
    }

    public final void f(long j) {
        this.ae = j;
    }

    public final int B() {
        return this.U;
    }

    public final void k(int i) {
        this.U = i;
    }

    private long bO() {
        return com.anythink.core.common.u.aj.c(this);
    }

    public final long C() {
        return this.X;
    }

    public final void g(long j) {
        this.X = j;
    }

    public final long D() {
        return this.Y;
    }

    public final void h(long j) {
        this.Y = j;
    }

    public final int E() {
        return this.Z;
    }

    public final void l(int i) {
        this.Z = i;
    }

    public final long F() {
        return this.M;
    }

    public final void i(long j) {
        this.M = j;
    }

    public final String G() {
        return this.aa;
    }

    public final void f(String str) {
        this.aa = str;
    }

    public final String H() {
        return this.N;
    }

    public final void g(String str) {
        this.N = str;
    }

    public final int I() {
        return this.O;
    }

    public final void m(int i) {
        this.O = i;
    }

    public final int J() {
        return this.P;
    }

    public final void n(int i) {
        this.P = i;
    }

    public final double K() {
        return this.Q;
    }

    public final void b(double d) {
        this.Q = d;
    }

    private long bP() {
        return this.ab;
    }

    public final void j(long j) {
        this.ab = j;
    }

    public final String L() {
        return this.S;
    }

    public final void h(String str) {
        this.S = str;
    }

    public final String M() {
        return this.T;
    }

    public final void i(String str) {
        this.T = str;
    }

    public final void k(long j) {
        this.ac = j;
    }

    public final long N() {
        return this.ac;
    }

    public final void l(long j) {
        this.ad = j;
    }

    public final long O() {
        return this.ad;
    }

    public final int P() {
        return this.af;
    }

    public final void o(int i) {
        this.af = i;
    }

    public final int Q() {
        return this.ag;
    }

    public final void p(int i) {
        this.ag = i;
    }

    private int bQ() {
        return this.ah;
    }

    private void ak(int i) {
        this.ah = i;
    }

    public final int R() {
        return this.ai;
    }

    public final void q(int i) {
        this.ai = i;
    }

    public final String S() {
        return this.aj;
    }

    public final void j(String str) {
        this.aj = str;
    }

    public final void m(long j) {
        this.ak = j;
    }

    public final long T() {
        return this.ak;
    }

    public final long U() {
        return this.al;
    }

    public final void n(long j) {
        this.al = j;
    }

    public final double V() {
        return this.am;
    }

    public final void c(double d) {
        this.am = d;
    }

    private int bR() {
        return this.an;
    }

    public final void r(int i) {
        this.an = i;
    }

    public final int W() {
        return this.ao;
    }

    public final void s(int i) {
        this.ao = i;
    }

    public final boolean X() {
        return this.ap == 2;
    }

    public final void t(int i) {
        this.ap = i;
    }

    public final ad Y() {
        return this.at;
    }

    private void b(ad adVar) {
        this.at = adVar;
    }

    public final ad Z() {
        return this.bJ;
    }

    public final void a(ad adVar) {
        this.bJ = adVar;
    }

    public final int aa() {
        return this.au;
    }

    private void al(int i) {
        this.au = i;
    }

    public final int ab() {
        return this.av;
    }

    public final void ac() {
        this.av = 1;
    }

    public final String ad() {
        return this.aw;
    }

    private void r(String str) {
        this.aw = str;
    }

    public final long ae() {
        return this.az;
    }

    public final void o(long j) {
        this.az = j;
    }

    public final String af() {
        return this.aE;
    }

    public final void k(String str) {
        this.aE = str;
    }

    private int bS() {
        return this.aG;
    }

    public final void u(int i) {
        this.aG = i;
    }

    public final void v(int i) {
        this.b = i;
    }

    public final int ag() {
        int i = this.b;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final void w(int i) {
        this.c = i;
    }

    public final int ah() {
        return this.c;
    }

    public final int ai() {
        return this.d;
    }

    public final void x(int i) {
        this.d = i;
    }

    private String bT() {
        return this.e;
    }

    public final void l(String str) {
        this.e = str;
    }

    public final int aj() {
        return this.a;
    }

    public final void y(int i) {
        this.a = i;
    }

    public final int ak() {
        return this.aH;
    }

    public final void z(int i) {
        this.aH = i;
    }

    public final int al() {
        ad adVar = this.at;
        if (adVar != null && adVar.n != 0) {
            return this.at.n;
        }
        return this.f;
    }

    public final void A(int i) {
        this.f = i;
    }

    public final int am() {
        return this.bt;
    }

    public final void B(int i) {
        this.bt = i;
    }

    public final int an() {
        return this.bu;
    }

    public final void C(int i) {
        this.bu = i;
    }

    public final int ao() {
        return this.bv;
    }

    public final void D(int i) {
        this.bv = i;
    }

    public final String ap() {
        return this.bw;
    }

    public final void m(String str) {
        this.bw = str;
    }

    public final int aq() {
        return this.bx;
    }

    public final void E(int i) {
        this.bx = i;
    }

    public final int ar() {
        return this.by;
    }

    public final void F(int i) {
        this.by = i;
    }

    public final boolean at() {
        if (as()) {
            return true;
        }
        return this.bE == 2 && com.anythink.core.common.u.o.c(this.ay);
    }

    public final boolean au() {
        return !as() && this.bE == 2 && com.anythink.core.common.u.o.c(this.ay);
    }

    private int a(by byVar) {
        return com.anythink.core.common.u.k.a(this, byVar);
    }

    public final synchronized void a(by byVar, int i, int i2, int i3) {
        if (byVar.aa.equals(this.aa)) {
            this.Q = byVar.Q;
            this.j = byVar.j;
            this.A = byVar.A;
            this.aI = byVar.aI;
            this.U = i2;
            this.S = byVar.S;
            this.aw = byVar.aw;
            this.ar = 0;
            if (i == 0) {
                this.au = byVar.au;
            } else {
                this.au = i;
            }
            this.T = byVar.T;
            this.at = byVar.at;
            this.av = i3;
            this.aZ = byVar.aZ;
        }
    }

    private void c(ad adVar) {
        this.Q = adVar.getPrice();
        this.j = adVar.getSortPrice();
        this.A = adVar.getRmbPrice();
        this.aI = adVar.getCurrency();
        if (this.aZ != null) {
            String strL = adVar.l();
            int iN = adVar.n();
            String strM = adVar.m();
            this.aZ.b(strL);
            this.aZ.d(strM);
            this.aZ.a(iN);
        }
    }

    public final boolean av() {
        return this.D == 1 && this.as == 1;
    }

    public final int aw() {
        return this.ax;
    }

    public final void G(int i) {
        this.ax = i;
    }

    public final ATAdConst.CURRENCY ax() {
        return this.aI;
    }

    public final void a(ATAdConst.CURRENCY currency) {
        this.aI = currency;
    }

    public final int ay() {
        return this.g;
    }

    public final void H(int i) {
        this.g = i;
    }

    public final double az() {
        return this.h;
    }

    public final void d(double d) {
        this.h = d;
    }

    public final int aA() {
        return this.i;
    }

    public final void I(int i) {
        this.i = i;
    }

    public final double aB() {
        return this.j;
    }

    public final void e(double d) {
        this.j = d;
    }

    public final String aC() {
        return this.k;
    }

    public final void n(String str) {
        this.k = str;
    }

    public final int aD() {
        return this.l;
    }

    public final void J(int i) {
        this.l = i;
    }

    public final int aE() {
        return this.m;
    }

    public final void K(int i) {
        this.m = i;
    }

    public final int aF() {
        return this.n;
    }

    public final void L(int i) {
        this.n = i;
    }

    public final int aG() {
        int i = this.o;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final void M(int i) {
        this.o = i;
    }

    public final int aH() {
        return this.p;
    }

    public final void N(int i) {
        this.p = i;
    }

    public final boolean aI() {
        return this.q;
    }

    public final void aJ() {
        this.q = true;
    }

    public final double aK() {
        return this.r;
    }

    public final void f(double d) {
        this.r = d;
    }

    public final String aL() {
        return this.s;
    }

    public final void o(String str) {
        this.s = str;
    }

    public final long aM() {
        return this.t;
    }

    public final void p(long j) {
        this.t = j;
    }

    public String toString() {
        return super.toString();
    }

    public final void a(int[] iArr) {
        this.aJ = iArr;
    }

    public final int[] aN() {
        return this.aJ;
    }

    public final int aO() {
        return this.aK;
    }

    public final void O(int i) {
        this.aK = i;
    }

    public final int aP() {
        return this.aL;
    }

    public final void P(int i) {
        this.aL = i;
    }

    private boolean bU() {
        return this.aL == 1;
    }

    public final JSONArray aQ() {
        return this.aM;
    }

    public final void a(JSONArray jSONArray) {
        this.aM = jSONArray;
    }

    public final int aR() {
        return this.aN;
    }

    public final void Q(int i) {
        this.aN = i;
    }

    public final int aS() {
        return this.aO;
    }

    public final void R(int i) {
        this.aO = i;
    }

    public final int aT() {
        return this.aP;
    }

    public final void S(int i) {
        this.aP = i;
    }

    public final int aU() {
        return this.aQ;
    }

    public final void T(int i) {
        this.aQ = i;
    }

    public final int aV() {
        return this.aR;
    }

    public final void U(int i) {
        this.aR = i;
    }

    public final int aW() {
        return this.aS;
    }

    public final void V(int i) {
        this.aS = i;
    }

    public final double aX() {
        return this.aT;
    }

    public final void g(double d) {
        this.aT = d;
    }

    public final double aY() {
        return this.aU;
    }

    public final void h(double d) {
        this.aU = d;
    }

    public final JSONObject aZ() {
        return this.aV;
    }

    public final void a(JSONObject jSONObject) {
        this.aV = jSONObject;
    }

    public final int ba() {
        return this.aW;
    }

    public final void W(int i) {
        this.aW = i;
    }

    public final int bb() {
        return this.aX;
    }

    public final void X(int i) {
        this.aX = i;
    }

    public final boolean bc() {
        return com.anythink.core.common.u.o.b(this.ay);
    }

    public final boolean bd() {
        return com.anythink.core.common.u.o.c(this.ay);
    }

    private boolean bV() {
        return com.anythink.core.common.u.o.d(this.ay);
    }

    public final aq be() {
        return this.aZ;
    }

    public final void a(aq aqVar) {
        this.aZ = aqVar;
    }

    public final Map<String, Object> bf() {
        return this.aY;
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
        this.aY = map;
        map.put("native_material_type", Integer.valueOf(i));
        this.aY.put("native_material_tittle", descriptionText);
        this.aY.put("native_material_publisher_name", str);
        this.aY.put("native_material_package_name", appPackageName);
        this.aY.put("native_material_interaction_type", Integer.valueOf(nativeAdInteractionType));
    }

    public final int bg() {
        return this.ba;
    }

    public final void Y(int i) {
        this.ba = i;
    }

    public final int bh() {
        return this.bb;
    }

    public final void Z(int i) {
        this.bb = i;
    }

    public final void q(long j) {
        this.bc = j;
    }

    public final long bi() {
        return this.bc;
    }

    public final aa bj() {
        return this.bd;
    }

    public final void a(aa aaVar) {
        this.bd = aaVar;
    }

    public final boolean bk() {
        if (this.be != 2 || this.bf <= 0 || this.bg != 4) {
            return false;
        }
        int i = this.aH;
        return i == -1 || i == 4;
    }

    public final void aa(int i) {
        this.be = i;
    }

    public final int bl() {
        return this.be;
    }

    public final long bm() {
        return this.bf;
    }

    public final void r(long j) {
        this.bf = j;
    }

    public final void ab(int i) {
        this.bg = i;
    }

    public final int bn() {
        return this.bg;
    }

    public final int bo() {
        return this.bh;
    }

    public final void ac(int i) {
        this.bh = i;
    }

    private String bW() {
        return this.bi;
    }

    public final void p(String str) {
        this.bi = str;
    }

    public final JSONArray bp() {
        return this.bk;
    }

    public final void b(JSONArray jSONArray) {
        this.bk = jSONArray;
    }

    public final JSONArray bq() {
        return this.bl;
    }

    public final void c(JSONArray jSONArray) {
        this.bl = jSONArray;
    }

    public final int br() {
        return this.bm;
    }

    public final void ad(int i) {
        this.bm = i;
    }

    public final JSONArray bs() {
        return this.bn;
    }

    public final void d(JSONArray jSONArray) {
        this.bn = jSONArray;
    }

    public final JSONArray bt() {
        return this.bo;
    }

    public final void e(JSONArray jSONArray) {
        this.bo = jSONArray;
    }

    public final JSONArray bu() {
        return this.bj;
    }

    public final void f(JSONArray jSONArray) {
        this.bj = jSONArray;
    }

    public final int bv() {
        return this.bp;
    }

    public final void ae(int i) {
        this.bp = i;
    }

    public final long bw() {
        return this.bq;
    }

    public final void s(long j) {
        this.bq = j;
    }

    public final double bx() {
        return this.br;
    }

    public final void i(double d) {
        this.br = d;
    }

    public final long by() {
        return this.bs;
    }

    public final void t(long j) {
        this.bs = j;
    }

    public final boolean bz() {
        ad adVar = this.at;
        if (adVar != null) {
            return adVar.r();
        }
        return false;
    }

    public final int bA() {
        return this.aF;
    }

    public final void af(int i) {
        this.aF = i;
    }

    public final String bB() {
        ad adVar = this.at;
        return adVar != null ? adVar.w() : "";
    }

    public final String bC() {
        ad adVar = this.at;
        return adVar != null ? adVar.getOriginRequestId() : "";
    }

    public final void u(long j) {
        this.bK = j;
    }

    public final long bD() {
        return this.bK;
    }

    public final void ag(int i) {
        this.bL = i;
    }

    public final int bE() {
        return this.bL;
    }

    public final double bF() {
        return this.bN;
    }

    public final void j(double d) {
        this.bN = d;
    }

    public final String bG() {
        return this.bM;
    }

    public final void q(String str) {
        this.bM = str;
    }

    private String bX() {
        return this.B;
    }

    private void s(String str) {
        this.B = str;
    }

    private String bY() {
        return this.C;
    }

    private void t(String str) {
        this.C = str;
    }

    public final void a(l lVar) {
        this.aA = lVar;
    }

    public final l bH() {
        return this.aA;
    }

    public final int bI() {
        return this.bE;
    }

    public final void ah(int i) {
        this.bE = i;
    }

    public final boolean bJ() {
        return this.bF == 1;
    }

    public final void ai(int i) {
        this.bF = i;
    }

    public final long bK() {
        return this.bG;
    }

    public final void v(long j) {
        this.bG = j;
    }

    public final int bL() {
        return this.bH;
    }

    public final void aj(int i) {
        this.bH = i;
    }

    public final boolean as() {
        int i = this.D;
        return i == 66 || i == 67;
    }

    public final void a(ad adVar, int i, int i2, int i3) {
        this.U = i2;
        this.Q = adVar.getPrice();
        this.j = adVar.getSortPrice();
        this.A = adVar.getRmbPrice();
        this.aI = adVar.getCurrency();
        this.S = adVar.token;
        this.aw = adVar.m;
        this.ar = 0;
        this.au = i;
        this.at = adVar;
        this.av = i3;
        if (i3 == 1) {
            this.T = "";
        }
        if (this.aZ != null) {
            String strL = adVar.l();
            int iN = adVar.n();
            String strM = adVar.m();
            this.aZ.b(strL);
            this.aZ.d(strM);
            this.aZ.a(iN);
        }
    }
}
