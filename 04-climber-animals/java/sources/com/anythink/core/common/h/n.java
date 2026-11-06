package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import com.anythink.core.mg.api.MgPreLoadCallbackRegister;
import com.anythink.network.gdt.GDTATConst;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n extends bu implements Cloneable {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    protected double A;
    String B;
    public int C;
    int D;
    int E;
    public String F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected double K;
    List<Integer> L;
    boolean M;
    int N;
    String O;
    long P;
    long Q;
    String R;
    private int aX;
    private String aY;
    private String aZ;
    private String bA;
    private String bB;
    private String bC;
    private String bD;
    private int bE;
    private String bG;
    private String bH;
    private double bI;
    private String bJ;
    private double bK;
    private double bL;
    private String bM;
    private double bN;
    private String bO;
    private int bP;
    private String bQ;
    private String bR;
    private String bS;
    private String bT;
    private int bU;
    private int bV;
    private String bW;
    private long bX;
    private int bY;
    private int bZ;
    private int ba;
    private int bb;
    private String bc;
    private int bd;
    private int bh;
    private int bi;
    private boolean bj;
    private long bk;
    private long bl;
    private long bm;
    private long bn;
    private long bo;
    private long bp;
    private long bq;
    private long br;
    private long bs;
    private long bt;
    private long bu;
    private long bv;
    private long bw;
    private int bx;
    private int by;
    private long bz;
    private int cB;
    private String cC;
    private long cD;
    private long cE;
    private boolean cF;
    private int cK;
    private double cL;
    private double cM;
    private Map<String, String> cN;
    private String cP;
    private String cR;
    private String cT;
    private String cU;
    private int cV;
    private double cW;
    private int cX;
    private int cY;
    private int cZ;
    private int ca;
    private int cb;
    private int cc;
    private long cd;
    private int cf;
    private int cg;
    private int cj;
    private String ck;
    private int cl;
    private ATRewardInfo cm;
    private Map<String, ATRewardInfo> cn;
    private Map<String, Object> co;
    private Map<String, Object> cp;
    private d cq;
    private Map<String, Object> cr;
    private boolean cs;
    private double ct;
    private double cu;
    private int cv;
    private int cw;
    private int cx;
    private double cy;
    private int cz;
    private long dA;
    private String dC;
    private int da;
    private String dc;
    private int de;
    private int df;
    private aa dg;
    private e dh;
    private ab di;
    private bc dj;
    private int dk;
    private ATCustomContentResult dl;
    private int dm;
    private double dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private long f0do;
    private String du;
    private int dv;
    private ATAdRequest dw;
    private int dz;
    protected int r;
    public int w;
    public String x;
    int y;
    protected double z;
    private int be = -1;
    private int bf = -1;
    private int bg = -1;
    public String s = "";
    public int t = 0;
    public int u = 0;
    public int v = 0;
    private String bF = "unknow";
    private int ce = -1;
    private int ch = 1;
    private int ci = 13;
    private int cA = 1;
    private int cG = 0;
    private int cH = 0;
    private int cI = 0;
    private int cJ = 0;
    private double cO = -1.0d;
    private double cQ = -1.0d;
    private int cS = -1;
    private int db = -2;
    private int dd = 2;
    private int dp = 0;
    private int dq = -1;
    private int dr = 0;
    private int ds = 0;
    private String dt = "";
    private boolean dx = false;
    private boolean dy = false;
    private int dB = -1;

    public final void a(long j2) {
        this.bv = j2;
    }

    public final void b(long j2) {
        this.bw = j2;
    }

    public final void a(int i2) {
        this.bx = i2;
    }

    public final void b(int i2) {
        this.by = i2;
    }

    public final void c(long j2) {
        this.bo = j2;
    }

    public final void d(long j2) {
        this.bu = j2;
    }

    public final void e(long j2) {
        this.bs = j2;
    }

    public final void f(long j2) {
        this.bt = j2;
    }

    public final void g(long j2) {
        this.bp = j2;
    }

    public final void h(long j2) {
        this.bq = j2;
    }

    public final void i(long j2) {
        this.br = j2;
    }

    public final void j(long j2) {
        this.bn = j2;
    }

    public final void k(long j2) {
        this.bl = j2;
    }

    public final void l(long j2) {
        this.bm = j2;
    }

    public final ATAdRequest a() {
        return this.dw;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.dw = aTAdRequest;
    }

    public final void a(double d2) {
        this.cO = d2;
    }

    public final void a(String str) {
        this.cP = str;
    }

    public final void b(double d2) {
        this.cQ = d2;
    }

    public final void b(String str) {
        this.cR = str;
    }

    public final void c(int i2) {
        this.cS = i2;
    }

    public final void c(String str) {
        this.cT = str;
    }

    public final void d(int i2) {
        this.cK = i2;
    }

    public final long b() {
        return this.cD;
    }

    public final void m(long j2) {
        this.cD = j2;
    }

    public final long c() {
        return this.cE;
    }

    public final void n(long j2) {
        this.cE = j2;
    }

    public final void a(int i2, int i3) {
        this.cC = i2 + "_" + i3;
    }

    public final void d() {
        this.cA = 2;
    }

    public final double e() {
        return this.cy;
    }

    public final void c(double d2) {
        this.cy = d2;
    }

    private int aN() {
        return this.cz;
    }

    public final void e(int i2) {
        this.cz = i2;
    }

    public final void a(d dVar) {
        this.cq = dVar;
    }

    public final d f() {
        return this.cq;
    }

    public final String g() {
        d dVar = this.cq;
        return dVar != null ? dVar.a() : "";
    }

    public final Map<String, Object> h() {
        return this.cr;
    }

    public final void a(Map<String, Object> map) {
        this.cr = map;
    }

    public final void d(double d2) {
        this.cu = d2;
    }

    private double aO() {
        return this.ct;
    }

    public final void e(double d2) {
        this.ct = d2;
    }

    private boolean aP() {
        return this.cs;
    }

    public final void a(boolean z) {
        this.cs = z;
    }

    public final int i() {
        return this.cv;
    }

    public final void f(int i2) {
        this.cv = i2;
    }

    public final void b(Map<String, Object> map) {
        this.cp = map;
    }

    public final Map<String, Object> j() {
        return this.cp;
    }

    private double aQ() {
        return this.K;
    }

    public final void f(double d2) {
        this.K = d2;
    }

    public final void d(String str) {
        this.ck = str;
    }

    public final void g(int i2) {
        this.cf = i2;
    }

    public final void h(int i2) {
        this.cg = i2;
    }

    public final void o(long j2) {
        this.cd = j2;
    }

    public final void i(int i2) {
        this.cb = i2;
    }

    public final void j(int i2) {
        this.cc = i2;
    }

    public final int k() {
        return this.cc;
    }

    private int aR() {
        return this.ca;
    }

    public final void k(int i2) {
        this.ca = i2;
    }

    private int aS() {
        return this.bZ;
    }

    public final void l(int i2) {
        this.bZ = i2;
    }

    public final int l() {
        return this.bY;
    }

    public final void m(int i2) {
        this.bY = i2;
    }

    public final void e(String str) {
        this.bW = str;
    }

    public final void p(long j2) {
        this.bX = j2;
    }

    public final void m() {
        this.bV = 1;
    }

    public final void n() {
        if (this.bV != 1) {
            this.bU = 1;
        }
    }

    public final void f(String str) {
        this.bT = str;
    }

    public final String o() {
        return this.bT;
    }

    public final double p() {
        return this.bL;
    }

    public final void g(double d2) {
        this.bL = d2;
    }

    public final double q() {
        return this.bN;
    }

    public final void h(double d2) {
        this.bN = d2;
    }

    public final String r() {
        return this.bM;
    }

    public final void g(String str) {
        this.bM = str;
    }

    public final String s() {
        return this.bO;
    }

    public final void h(String str) {
        this.bO = str;
    }

    public final int t() {
        return this.bP;
    }

    public final void n(int i2) {
        this.bP = i2;
    }

    public final void i(String str) {
        this.bQ = str;
    }

    public final double u() {
        return this.bI;
    }

    public final void i(double d2) {
        this.bI = d2;
    }

    public final String v() {
        return this.bJ;
    }

    public final void j(String str) {
        this.bJ = str;
    }

    public final String w() {
        return this.bR;
    }

    public final void k(String str) {
        this.bR = str;
    }

    public final String x() {
        return this.B;
    }

    public final void l(String str) {
        this.B = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bB = com.anythink.core.common.v.o.b(this.B);
    }

    public final void o(int i2) {
        this.G = i2;
    }

    public final void p(int i2) {
        this.H = i2;
    }

    public final void q(int i2) {
        this.I = i2;
    }

    public final void r(int i2) {
        this.J = i2;
    }

    public final String y() {
        return this.bC;
    }

    public final void m(String str) {
        this.bC = str;
    }

    public final String z() {
        return this.bD;
    }

    public final void n(String str) {
        this.bD = str;
    }

    public final int A() {
        return this.bE;
    }

    public final void s(int i2) {
        this.bE = i2;
    }

    public final String B() {
        return this.bF;
    }

    public final void o(String str) {
        this.bF = str;
    }

    public final String C() {
        return this.bG;
    }

    public final void p(String str) {
        this.bG = str;
    }

    public final String D() {
        return this.bH;
    }

    public final void q(String str) {
        this.bH = str;
    }

    public final Map<String, ATRewardInfo> E() {
        return this.cn;
    }

    public final void c(Map<String, ATRewardInfo> map) {
        this.cn = map;
    }

    public final void t(int i2) {
        this.cl = i2;
    }

    public final ATRewardInfo F() {
        return this.cm;
    }

    public final void a(ATRewardInfo aTRewardInfo) {
        this.cm = aTRewardInfo;
    }

    public final Map<String, Object> G() {
        return this.co;
    }

    public final void d(Map<String, Object> map) {
        this.co = map;
    }

    private String aT() {
        return this.F;
    }

    private void M(String str) {
        this.F = str;
    }

    public final int H() {
        return this.D;
    }

    public final void u(int i2) {
        this.D = i2;
    }

    public final int I() {
        return this.E;
    }

    public final void v(int i2) {
        this.E = i2;
    }

    private int aU() {
        return this.C;
    }

    private void aV() {
        this.C = 1;
    }

    public final int J() {
        return this.y;
    }

    public final boolean K() {
        return this.y == 1;
    }

    public final void w(int i2) {
        this.y = i2;
    }

    public final double L() {
        return this.z;
    }

    public final void j(double d2) {
        this.z = d2;
    }

    private double aW() {
        return this.A;
    }

    public final void k(double d2) {
        this.A = d2;
    }

    private String aX() {
        return this.x;
    }

    private void N(String str) {
        this.x = str;
    }

    public final String M() {
        return this.bA;
    }

    public final void r(String str) {
        this.bA = str;
    }

    private boolean aY() {
        return this.cb == 9;
    }

    public final int N() {
        int i2 = this.cb;
        if (i2 != 8) {
            return i2 != 9 ? 0 : 1;
        }
        return 2;
    }

    private void e(boolean z) {
        this.bj = z;
    }

    public final int O() {
        return this.bh;
    }

    public final void x(int i2) {
        this.bh = i2;
    }

    public final int P() {
        return this.bi;
    }

    public final void y(int i2) {
        this.bi = i2;
    }

    public final int Q() {
        return this.ba;
    }

    public final void z(int i2) {
        this.ba = i2;
    }

    public final int R() {
        return this.bb;
    }

    public final void A(int i2) {
        this.bb = i2;
    }

    public final String S() {
        return this.bc;
    }

    public final void s(String str) {
        this.bc = str;
    }

    public final int T() {
        return this.bd;
    }

    public final void B(int i2) {
        this.bd = i2;
    }

    public final int U() {
        return this.be;
    }

    public final void C(int i2) {
        this.be = i2;
    }

    public final int V() {
        return this.bf;
    }

    public final void D(int i2) {
        this.bf = i2;
    }

    public final int W() {
        return this.bg;
    }

    public final void E(int i2) {
        this.bg = i2;
    }

    public final String X() {
        return this.aZ;
    }

    public final void t(String str) {
        this.aZ = str;
    }

    public final int Y() {
        return this.r;
    }

    public final void F(int i2) {
        this.r = i2;
    }

    private String aZ() {
        return this.aY;
    }

    public final void u(String str) {
        this.aY = str;
    }

    public final int Z() {
        return this.aX;
    }

    public final void G(int i2) {
        this.aX = i2;
    }

    private void aq(int i2) {
        this.t = i2;
    }

    private int ba() {
        return this.t;
    }

    private void ar(int i2) {
        this.u = i2;
    }

    private int bb() {
        return this.u;
    }

    private void as(int i2) {
        this.v = i2;
    }

    public final long aa() {
        return this.bk;
    }

    public final void q(long j2) {
        this.bk = j2;
    }

    public final void r(long j2) {
        this.bz = j2;
    }

    public final long ab() {
        return this.bz;
    }

    private int bc() {
        return this.w;
    }

    private void at(int i2) {
        this.w = i2;
    }

    public final void v(String str) {
        this.bS = str;
    }

    public final int ac() {
        return this.ce;
    }

    public final int ad() {
        int i2 = this.ce;
        return i2 == -1 ? Integer.parseInt(this.aN) : i2;
    }

    public final void H(int i2) {
        this.ce = i2;
    }

    public final void I(int i2) {
        this.ch = i2;
    }

    public final void J(int i2) {
        this.ci = i2;
    }

    public final int ae() {
        return this.cj;
    }

    public final void K(int i2) {
        this.cj = i2;
    }

    public final void a(bv bvVar) {
        if (bvVar != null) {
            this.bA = bvVar.z();
            this.z = bvVar.D();
            this.A = bvVar.z;
            this.cc = bvVar.d();
        }
    }

    private boolean bd() {
        return this.M;
    }

    public final void b(boolean z) {
        this.M = z;
    }

    private int be() {
        return this.N;
    }

    public final void L(int i2) {
        this.N = i2;
    }

    private String bf() {
        return this.O;
    }

    public final void w(String str) {
        this.O = str;
    }

    private int bg() {
        return this.cG;
    }

    public final void M(int i2) {
        this.cG = i2;
    }

    private long bh() {
        return this.P;
    }

    public final void s(long j2) {
        this.P = j2;
    }

    private long bi() {
        return this.Q;
    }

    public final void t(long j2) {
        this.Q = j2;
    }

    private String bj() {
        return this.R;
    }

    public final void x(String str) {
        this.R = str;
    }

    public final void N(int i2) {
        this.dB = i2;
    }

    public final void y(String str) {
        this.dC = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01de A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01e8 A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:121:0x027f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0282 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:125:0x02ad A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:128:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d3 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02f0 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0355 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0500 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:170:0x050f A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:173:0x051a A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0533 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0580 A[Catch: Exception -> 0x0425, TryCatch #12 {Exception -> 0x0425, blocks: (B:165:0x04d8, B:167:0x0500, B:168:0x0507, B:170:0x050f, B:171:0x0516, B:173:0x051a, B:174:0x051f, B:176:0x0533, B:177:0x053a, B:179:0x0580, B:180:0x0587, B:111:0x021a, B:119:0x0244, B:123:0x0289, B:125:0x02ad, B:126:0x02b4, B:130:0x02d6, B:132:0x02f0, B:133:0x02f5, B:129:0x02d3, B:122:0x0282, B:112:0x0222, B:116:0x023b, B:115:0x0234, B:134:0x0308, B:138:0x0351, B:141:0x0358, B:140:0x0355, B:142:0x0368, B:146:0x038e, B:148:0x039d, B:150:0x03ba, B:149:0x03ac, B:145:0x0387, B:151:0x03bf, B:155:0x03c9, B:158:0x042a, B:160:0x0462, B:161:0x0469, B:162:0x0485), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:183:0x05a4 A[Catch: Exception -> 0x0811, TRY_ENTER, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:185:0x05bc A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:192:0x05d1 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:197:0x05e0 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:200:0x05e9 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:203:0x05fa A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0621 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:209:0x063e A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0649 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0652 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:218:0x065c A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:221:0x0665 A[Catch: Exception -> 0x0811, TryCatch #6 {Exception -> 0x0811, blocks: (B:183:0x05a4, B:185:0x05bc, B:187:0x05c4, B:189:0x05c8, B:190:0x05cd, B:192:0x05d1, B:194:0x05d5, B:195:0x05dc, B:197:0x05e0, B:198:0x05e5, B:200:0x05e9, B:201:0x05ee, B:203:0x05fa, B:204:0x05ff, B:206:0x0621, B:207:0x0636, B:209:0x063e, B:210:0x0645, B:212:0x0649, B:213:0x064e, B:215:0x0652, B:216:0x0657, B:218:0x065c, B:219:0x0661, B:221:0x0665, B:222:0x066a, B:223:0x068b, B:224:0x06f0, B:226:0x0750, B:228:0x0754, B:231:0x0780, B:233:0x0784, B:234:0x0789, B:236:0x0796, B:237:0x07ab, B:239:0x07b3, B:240:0x07ba, B:229:0x0763, B:230:0x0772, B:241:0x07c1), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:282:0x0884  */
    /* JADX WARN: Code duplicated, block: B:284:0x0887 A[Catch: Exception -> 0x0890, TryCatch #0 {Exception -> 0x0890, blocks: (B:248:0x081b, B:262:0x0839, B:267:0x0848, B:269:0x084c, B:281:0x0881, B:275:0x086c, B:284:0x0887, B:286:0x088b, B:266:0x0841, B:271:0x085c, B:277:0x0871), top: B:410:0x081b, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0 A[Catch: Exception -> 0x0813, TryCatch #5 {Exception -> 0x0813, blocks: (B:3:0x0010, B:5:0x001c, B:6:0x0021, B:8:0x0025, B:9:0x002a, B:11:0x0039, B:12:0x0040, B:14:0x004a, B:16:0x0054, B:18:0x005e, B:51:0x00c4, B:53:0x00c8, B:54:0x00ee, B:56:0x00f2, B:57:0x00f7, B:59:0x00fb, B:60:0x0100, B:62:0x0104, B:63:0x0109, B:65:0x010d, B:66:0x0112, B:68:0x011d, B:70:0x0134, B:72:0x0138, B:73:0x013d, B:75:0x0145, B:69:0x0127, B:43:0x00a0, B:45:0x00a4, B:47:0x00aa, B:48:0x00b5, B:50:0x00bd, B:32:0x0086), top: B:420:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b5 A[Catch: Exception -> 0x0813, TryCatch #5 {Exception -> 0x0813, blocks: (B:3:0x0010, B:5:0x001c, B:6:0x0021, B:8:0x0025, B:9:0x002a, B:11:0x0039, B:12:0x0040, B:14:0x004a, B:16:0x0054, B:18:0x005e, B:51:0x00c4, B:53:0x00c8, B:54:0x00ee, B:56:0x00f2, B:57:0x00f7, B:59:0x00fb, B:60:0x0100, B:62:0x0104, B:63:0x0109, B:65:0x010d, B:66:0x0112, B:68:0x011d, B:70:0x0134, B:72:0x0138, B:73:0x013d, B:75:0x0145, B:69:0x0127, B:43:0x00a0, B:45:0x00a4, B:47:0x00aa, B:48:0x00b5, B:50:0x00bd, B:32:0x0086), top: B:420:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00bd A[Catch: Exception -> 0x0813, TryCatch #5 {Exception -> 0x0813, blocks: (B:3:0x0010, B:5:0x001c, B:6:0x0021, B:8:0x0025, B:9:0x002a, B:11:0x0039, B:12:0x0040, B:14:0x004a, B:16:0x0054, B:18:0x005e, B:51:0x00c4, B:53:0x00c8, B:54:0x00ee, B:56:0x00f2, B:57:0x00f7, B:59:0x00fb, B:60:0x0100, B:62:0x0104, B:63:0x0109, B:65:0x010d, B:66:0x0112, B:68:0x011d, B:70:0x0134, B:72:0x0138, B:73:0x013d, B:75:0x0145, B:69:0x0127, B:43:0x00a0, B:45:0x00a4, B:47:0x00aa, B:48:0x00b5, B:50:0x00bd, B:32:0x0086), top: B:420:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a8 A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01bf A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01c8 A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01d5 A[Catch: Exception -> 0x01fa, TryCatch #11 {Exception -> 0x01fa, blocks: (B:79:0x0170, B:81:0x0174, B:82:0x0197, B:84:0x019b, B:85:0x01a4, B:87:0x01a8, B:95:0x01cd, B:97:0x01d5, B:98:0x01da, B:100:0x01de, B:101:0x01e3, B:103:0x01e8, B:104:0x01ed, B:89:0x01b5, B:91:0x01bf, B:92:0x01c4, B:94:0x01c8, B:107:0x01fe, B:108:0x0205), top: B:422:0x016a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.anythink.core.common.h.bu, com.anythink.core.common.h.n, java.lang.Object] */
    @Override // com.anythink.core.common.h.bu
    public final JSONObject O(int i2) {
        ?? r10;
        String str;
        ?? r11;
        String str2;
        Throwable th;
        boolean z;
        int i3;
        String str3;
        Object jSONArray;
        int i4;
        int i5;
        String str4;
        double d2;
        String str5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        double d3;
        String str6;
        int i16;
        bc bcVar;
        List<Integer> list;
        JSONObject jSONObjectO = super.O(i2);
        try {
            jSONObjectO.put("nw_ver", this.x);
            int i17 = this.be;
            if (i17 != -1) {
                jSONObjectO.put("refresh", i17);
            }
            int i18 = this.bf;
            if (i18 != -1) {
                jSONObjectO.put("refresh_v2", i18);
            }
            jSONObjectO.put("load_mode", this.bg);
            if (!TextUtils.isEmpty(this.bT)) {
                jSONObjectO.put("tp_bid_id", this.bT);
            }
            if ("4".equals(this.aN) || "2".equals(this.aN) || "3".equals(this.aN) || "1".equals(this.aN)) {
                try {
                    int i19 = this.ce;
                    if (i19 == -1) {
                        i19 = Integer.parseInt(this.aN);
                    }
                    jSONObjectO.put("ad_type", i19);
                } catch (Exception unused) {
                }
            }
            if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13 || i2 == 24) {
                jSONObjectO.put("extra", this.bS);
            }
            if (i2 == 1 || i2 == 2) {
                if (!TextUtils.isEmpty(this.bB)) {
                    jSONObjectO.put("bid_t_m", this.bB);
                }
            } else if (i2 == 4 || i2 == 6 || i2 == 8) {
                list = this.L;
                if (list != null && !list.isEmpty()) {
                    jSONObjectO.put("bid_link", this.L.toString());
                }
                if (!TextUtils.isEmpty(this.bB)) {
                    jSONObjectO.put("bid_t_m", this.bB);
                }
            } else if (i2 == 13) {
                if (!TextUtils.isEmpty(this.bB)) {
                    jSONObjectO.put("bid_t_m", this.bB);
                }
            } else if (i2 == 25) {
                list = this.L;
                if (list != null) {
                    jSONObjectO.put("bid_link", this.L.toString());
                }
                if (!TextUtils.isEmpty(this.bB)) {
                    jSONObjectO.put("bid_t_m", this.bB);
                }
            }
            d dVar = this.cq;
            if (dVar != null) {
                jSONObjectO.put("real_p", dVar.a());
                jSONObjectO.put("real_s", this.F);
                jSONObjectO.put("real_g", this.cq.b());
                jSONObjectO.put("real_t", this.cq.c());
            }
            int i20 = this.cc;
            if (i20 > 0) {
                jSONObjectO.put("ads_list_type", i20);
            }
            if (this.cF) {
                jSONObjectO.put(com.anythink.core.common.m.e.be, 1);
            }
            int i21 = this.de;
            if (i21 > 0) {
                jSONObjectO.put("s_type", i21);
            }
            int i22 = this.df;
            if (i22 > 0) {
                jSONObjectO.put("imp_type", i22);
            }
            jSONObjectO.put("network_pl_id", this.bC);
            ATAdRequest aTAdRequest = this.dw;
            if (aTAdRequest != null) {
                jSONObjectO.put(com.anythink.core.common.m.e.bp, aTAdRequest.getChannelSource());
            } else {
                jSONObjectO.put(com.anythink.core.common.m.e.bp, com.anythink.core.common.d.t.b().E());
            }
            int i23 = this.dB;
            if (i23 != -1) {
                jSONObjectO.put("f_device_pub", i23);
            }
            if (!TextUtils.isEmpty(this.dC)) {
                jSONObjectO.put("b_network_ids", this.dC);
            }
            r10 = "unit_type";
            str = "0";
            String str7 = "aprn_auto_req";
            try {
                try {
                    try {
                        switch (i2) {
                            case 1:
                                r11 = i2;
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put("ad_reqt", this.cd);
                                jSONObjectO.put("unit_type", this.cK);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                e(jSONObjectO);
                                f(jSONObjectO);
                                break;
                            case 2:
                                r11 = i2;
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("status", this.u);
                                jSONObjectO.put("flag", this.v);
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(ATAdConst.KEY.CP_LOAD_MODE, aA());
                                jSONObjectO.put("ft_t", this.bl);
                                jSONObjectO.put("filled_t", this.bm);
                                if (this.cA == 2) {
                                    if (this.cc == 2) {
                                        jSONObjectO.put("filledtime", this.bz);
                                        jSONObjectO.put("data_ft", this.bz);
                                    } else {
                                        jSONObjectO.put("filledtime", this.bk);
                                        jSONObjectO.put("data_ft", this.bk);
                                    }
                                } else {
                                    jSONObjectO.put("filledtime", this.bz);
                                    jSONObjectO.put("data_ft", this.bk);
                                }
                                int i24 = this.cG;
                                if (i24 > 0) {
                                    jSONObjectO.put("material_type", i24);
                                }
                                jSONObjectO.put("unit_type", this.cK);
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                f(jSONObjectO);
                                e(jSONObjectO);
                                break;
                            case 3:
                                r11 = i2;
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("status", this.u);
                                jSONObjectO.put("flag", this.v);
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(ATAdConst.KEY.CP_LOAD_MODE, aA());
                                jSONObjectO.put("unit_type", this.cK);
                                jSONObjectO.put("nw_err_c", this.dc);
                                jSONObjectO.put("report_t", this.dd);
                                f(jSONObjectO);
                                break;
                            case 4:
                                str3 = "unit_type";
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                jSONObjectO.put("cl_imp", this.bU);
                                if (!TextUtils.isEmpty(this.ck)) {
                                    jSONObjectO.put(com.anythink.core.d.l.a.i, this.ck);
                                }
                                if (!TextUtils.isEmpty(this.cC)) {
                                    jSONObjectO.put("render_w_h", this.cC);
                                }
                                i15 = this.cJ;
                                if (i15 > 0) {
                                    jSONObjectO.put("offer_install", i15);
                                }
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                if (this.r == 22) {
                                    jSONObjectO.put(com.anythink.core.common.d.j.w.K, this.dv);
                                }
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN) && this.ce == Integer.parseInt(str) && (i14 = this.cw) > 0) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy && !this.dx) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 5:
                            case 14:
                            case 17:
                            case 21:
                            default:
                                r11 = i2;
                                break;
                            case 6:
                                str3 = "unit_type";
                                str7 = str7;
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN)) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 7:
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("progress", this.w);
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put("unit_type", this.cK);
                                e(jSONObjectO);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                r11 = i2;
                                break;
                            case 8:
                            case 9:
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put("unit_type", this.cK);
                                e(jSONObjectO);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("network_pl_id", this.bC);
                                f(jSONObjectO);
                                r11 = i2;
                                break;
                            case 10:
                                jSONObjectO.put("isload", this.M ? 1 : 0);
                                jSONObjectO.put(MediationConstant.KEY_REASON, this.N);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("req_par", this.cf);
                                jSONObjectO.put("req_par_num", this.cg);
                                jSONObjectO.put("load_start_t", this.bn);
                                jSONObjectO.put("pre_st_t", this.bo);
                                jSONObjectO.put("req_st_t", this.bp);
                                jSONObjectO.put("st_succ_t", this.bq);
                                jSONObjectO.put("dec_st_t", this.br);
                                jSONObjectO.put("filter_st_start_t", this.bs);
                                jSONObjectO.put("filter_st_end_t", this.bt);
                                jSONObjectO.put("adx_cache_t", this.bu);
                                jSONObjectO.put("cache_st_type", this.bx);
                                r11 = i2;
                                break;
                            case 11:
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("bidrequesttime", this.P);
                                jSONObjectO.put("bidresponselist", TextUtils.isEmpty(this.R) ? "[]" : new JSONArray(this.R));
                                jSONObjectO.put("ft_t", this.bl);
                                if (this.cA == 2) {
                                    jSONObjectO.put("bidresponsetime", this.Q);
                                    jSONObjectO.put("data_bidresponsetime", this.Q);
                                } else {
                                    jSONObjectO.put("data_bidresponsetime", this.dA);
                                    jSONObjectO.put("bidresponsetime", this.Q);
                                }
                                f(jSONObjectO);
                                r11 = i2;
                                break;
                            case 12:
                                jSONObjectO.put("loadtime", this.bz);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put("first_hb_fill_t", this.bv);
                                jSONObjectO.put("first_nor_fill_t", this.bw);
                                jSONObjectO.put("load_t", this.bm);
                                jSONObjectO.put("loaded_ad_type", this.by);
                                int i25 = this.N;
                                if (i25 == 5 || i25 == 13) {
                                    jSONObjectO.put(MediationConstant.KEY_REASON, i25);
                                } else {
                                    switch (i25) {
                                        case 9:
                                        case 10:
                                        case 11:
                                            jSONObjectO.put(MediationConstant.KEY_REASON, i25);
                                    }
                                }
                                jSONObjectO.put("req_par", this.cf);
                                jSONObjectO.put("req_par_num", this.cg);
                                r11 = i2;
                                break;
                            case 13:
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                if (TextUtils.isEmpty(this.O)) {
                                    jSONArray = "[]";
                                } else {
                                    jSONArray = new JSONArray(this.O);
                                }
                                jSONObjectO.put("as_result", jSONArray);
                                jSONObjectO.put("new_req_id", this.aM);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put("req_id_match", 0);
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i4 = this.N;
                                if (i4 != 12) {
                                    jSONObjectO.put(MediationConstant.KEY_REASON, i4);
                                }
                                jSONObjectO.put("unit_type", this.cK);
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                i5 = this.dm;
                                if (i5 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i5);
                                }
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                f(jSONObjectO);
                                r11 = i2;
                                break;
                            case 15:
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("bidresponselist", TextUtils.isEmpty(this.R) ? "[]" : new JSONArray(this.R));
                                r11 = i2;
                                break;
                            case 16:
                                jSONObjectO.put("ad_ch_st", this.ca);
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("bidtype", this.y);
                                jSONObjectO.put("bidprice", String.valueOf(this.z));
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                if (TextUtils.isEmpty(this.O)) {
                                    jSONArray = "[]";
                                } else {
                                    jSONArray = new JSONArray(this.O);
                                }
                                jSONObjectO.put("as_result", jSONArray);
                                jSONObjectO.put("new_req_id", this.aM);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put("req_id_match", 0);
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i4 = this.N;
                                if (i4 != 12) {
                                    jSONObjectO.put(MediationConstant.KEY_REASON, i4);
                                }
                                jSONObjectO.put("unit_type", this.cK);
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                i5 = this.dm;
                                if (i5 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i5);
                                }
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                f(jSONObjectO);
                                r11 = i2;
                                break;
                            case 18:
                            case 20:
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("app_nm", this.bW);
                                r11 = i2;
                                break;
                            case 19:
                                jSONObjectO.put("dl_ts", this.bX);
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("app_nm", this.bW);
                                r11 = i2;
                                break;
                            case 22:
                                str4 = "unit_type";
                                d2 = this.cQ;
                                if (d2 != -1.0d) {
                                    jSONObjectO.put("mmb_secprice", d2);
                                }
                                str5 = this.cR;
                                if (str5 != null) {
                                    jSONObjectO.put("mmb_secBidder", str5);
                                }
                                d3 = this.cO;
                                if (d3 != -1.0d) {
                                    jSONObjectO.put("mmb_firstPrice", d3);
                                }
                                str6 = this.cP;
                                if (str6 != null) {
                                    jSONObjectO.put("mmb_firstBidder", str6);
                                }
                                i16 = this.cS;
                                if (i16 != -1) {
                                    jSONObjectO.put("mmb_lossReason", i16);
                                }
                                jSONObjectO.put("mmb_ilrd", this.cT);
                                str3 = str4;
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                jSONObjectO.put("cl_imp", this.bU);
                                if (!TextUtils.isEmpty(this.ck)) {
                                    jSONObjectO.put(com.anythink.core.d.l.a.i, this.ck);
                                }
                                if (!TextUtils.isEmpty(this.cC)) {
                                    jSONObjectO.put("render_w_h", this.cC);
                                }
                                i15 = this.cJ;
                                if (i15 > 0) {
                                    jSONObjectO.put("offer_install", i15);
                                }
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                if (this.r == 22) {
                                    jSONObjectO.put(com.anythink.core.common.d.j.w.K, this.dv);
                                }
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN)) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 23:
                                str4 = "unit_type";
                                d3 = this.cO;
                                if (d3 != -1.0d) {
                                    jSONObjectO.put("mmb_firstPrice", d3);
                                }
                                str6 = this.cP;
                                if (str6 != null) {
                                    jSONObjectO.put("mmb_firstBidder", str6);
                                }
                                i16 = this.cS;
                                if (i16 != -1) {
                                    jSONObjectO.put("mmb_lossReason", i16);
                                }
                                jSONObjectO.put("mmb_ilrd", this.cT);
                                str3 = str4;
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                jSONObjectO.put("cl_imp", this.bU);
                                if (!TextUtils.isEmpty(this.ck)) {
                                    jSONObjectO.put(com.anythink.core.d.l.a.i, this.ck);
                                }
                                if (!TextUtils.isEmpty(this.cC)) {
                                    jSONObjectO.put("render_w_h", this.cC);
                                }
                                i15 = this.cJ;
                                if (i15 > 0) {
                                    jSONObjectO.put("offer_install", i15);
                                }
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                if (this.r == 22) {
                                    jSONObjectO.put(com.anythink.core.common.d.j.w.K, this.dv);
                                }
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN)) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 24:
                                ab abVar = this.di;
                                if (abVar != null) {
                                    jSONObjectO.put("notice", abVar.a());
                                }
                                bcVar = this.dj;
                                if (bcVar != null) {
                                    jSONObjectO.put(Constants.AdTypeName.REWARD, bcVar.a());
                                }
                                str4 = "unit_type";
                                d2 = this.cQ;
                                if (d2 != -1.0d) {
                                    jSONObjectO.put("mmb_secprice", d2);
                                }
                                str5 = this.cR;
                                if (str5 != null) {
                                    jSONObjectO.put("mmb_secBidder", str5);
                                }
                                d3 = this.cO;
                                if (d3 != -1.0d) {
                                    jSONObjectO.put("mmb_firstPrice", d3);
                                }
                                str6 = this.cP;
                                if (str6 != null) {
                                    jSONObjectO.put("mmb_firstBidder", str6);
                                }
                                i16 = this.cS;
                                if (i16 != -1) {
                                    jSONObjectO.put("mmb_lossReason", i16);
                                }
                                jSONObjectO.put("mmb_ilrd", this.cT);
                                str3 = str4;
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                jSONObjectO.put("cl_imp", this.bU);
                                if (!TextUtils.isEmpty(this.ck)) {
                                    jSONObjectO.put(com.anythink.core.d.l.a.i, this.ck);
                                }
                                if (!TextUtils.isEmpty(this.cC)) {
                                    jSONObjectO.put("render_w_h", this.cC);
                                }
                                i15 = this.cJ;
                                if (i15 > 0) {
                                    jSONObjectO.put("offer_install", i15);
                                }
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                if (this.r == 22) {
                                    jSONObjectO.put(com.anythink.core.common.d.j.w.K, this.dv);
                                }
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN)) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 25:
                                bcVar = this.dj;
                                if (bcVar != null) {
                                    jSONObjectO.put(Constants.AdTypeName.REWARD, bcVar.a());
                                }
                                str4 = "unit_type";
                                d2 = this.cQ;
                                if (d2 != -1.0d) {
                                    jSONObjectO.put("mmb_secprice", d2);
                                }
                                str5 = this.cR;
                                if (str5 != null) {
                                    jSONObjectO.put("mmb_secBidder", str5);
                                }
                                d3 = this.cO;
                                if (d3 != -1.0d) {
                                    jSONObjectO.put("mmb_firstPrice", d3);
                                }
                                str6 = this.cP;
                                if (str6 != null) {
                                    jSONObjectO.put("mmb_firstBidder", str6);
                                }
                                i16 = this.cS;
                                if (i16 != -1) {
                                    jSONObjectO.put("mmb_lossReason", i16);
                                }
                                jSONObjectO.put("mmb_ilrd", this.cT);
                                str3 = str4;
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                jSONObjectO.put("cl_imp", this.bU);
                                if (!TextUtils.isEmpty(this.ck)) {
                                    jSONObjectO.put(com.anythink.core.d.l.a.i, this.ck);
                                }
                                if (!TextUtils.isEmpty(this.cC)) {
                                    jSONObjectO.put("render_w_h", this.cC);
                                }
                                i15 = this.cJ;
                                if (i15 > 0) {
                                    jSONObjectO.put("offer_install", i15);
                                }
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                if (this.r == 22) {
                                    jSONObjectO.put(com.anythink.core.common.d.j.w.K, this.dv);
                                }
                                jSONObjectO.put("unit_id", this.bA);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.aX);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put(str7, N());
                                jSONObjectO.put("bidtype", this.y);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.A));
                                jSONObjectO.put(com.anythink.core.common.k.ap, String.valueOf(this.K));
                                jSONObjectO.put("myoffer_showtype", this.C);
                                if (!TextUtils.isEmpty(this.F)) {
                                    jSONObjectO.put("scenario", this.F);
                                }
                                jSONObjectO.put("ads", this.G);
                                jSONObjectO.put("ahs", this.H);
                                jSONObjectO.put("pds", this.I);
                                jSONObjectO.put("phs", this.J);
                                i6 = i2;
                                if (i6 == 6) {
                                    jSONObjectO.put("cl_s_type", this.ch);
                                    jSONObjectO.put("cl_area", this.ci);
                                    if ("3".equals(this.aN)) {
                                        jSONObjectO.put("bn_click_area", i14);
                                    }
                                    if (this.dy) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i7 = this.cl;
                                if (i7 > 0) {
                                    jSONObjectO.put("render_type_video", i7);
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("close_button_m", i8);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put(str3, this.cK);
                                i9 = this.cG;
                                if (i9 > 0) {
                                    jSONObjectO.put("material_type", i9);
                                }
                                e(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dz);
                                jSONObjectO.put("show_custom_ext", this.cU);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.cV));
                                if (!TextUtils.isEmpty(this.bM)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aS, this.bM);
                                    jSONObjectO.put("e_c_key_id", this.bP);
                                    jSONObjectO.put("unique_id", this.bQ);
                                }
                                if (!TextUtils.isEmpty(this.bO)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aT, this.bO);
                                }
                                i10 = this.da;
                                if (i10 > 0) {
                                    jSONObjectO.put("cls_style", i10);
                                }
                                i11 = this.cZ;
                                if (i11 > 0) {
                                    jSONObjectO.put("iv_template_id", i11);
                                }
                                i12 = this.db;
                                if (i12 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i12);
                                }
                                i13 = this.dm;
                                if (i13 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.aZ, i13);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bi, this.f0do);
                                jSONObjectO.put(com.anythink.core.common.k.bj, this.dn);
                                jSONObjectO.put("rotation_order", this.dp);
                                jSONObjectO.put(com.anythink.core.d.l.a.aO, this.dq);
                                r11 = i6;
                                break;
                            case 26:
                                e eVar = this.dh;
                                if (eVar != null) {
                                    jSONObjectO.put("sdk_chif_lt", eVar.d);
                                    jSONObjectO.put("ad_wipl_tp", this.dh.e);
                                    jSONObjectO.put("ad_wipl_if", this.dh.f);
                                    jSONObjectO.put("ad_wipl_time", this.dh.g);
                                }
                                r11 = i2;
                                break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        r11 = r10;
                    }
                } catch (Exception e3) {
                    e = e3;
                    r10 = i2;
                    e.printStackTrace();
                    r11 = r10;
                }
            } catch (Exception e4) {
                e = e4;
                r10 = i2;
                e.printStackTrace();
                r11 = r10;
            }
        } catch (Exception e5) {
            e = e5;
            r10 = i2;
            str = "0";
        }
        try {
            if (TextUtils.equals(this.aN, "2") && (r11 == 1 || r11 == 2 || r11 == 4 || r11 == 13 || r11 == 11 || r11 == 6)) {
                if (this.ce == 0 || r11 == 11) {
                    jSONObjectO.put(com.anythink.core.d.l.a.aq, this.cx);
                }
                Map<String, Object> map = this.cp;
                if (map != null) {
                    Object obj = map.get(ATAdConst.KEY.AD_WIDTH);
                    Object obj2 = this.cp.get(ATAdConst.KEY.AD_HEIGHT);
                    if (obj != null) {
                        try {
                            jSONObjectO.put("bn_width", Integer.parseInt(obj.toString()));
                        } catch (Exception e6) {
                            e6.getMessage();
                        }
                    }
                    if (obj2 != null) {
                        try {
                            jSONObjectO.put("bn_height", Integer.parseInt(obj2.toString()));
                        } catch (Exception e7) {
                            e7.getMessage();
                        }
                        if (r11 == 6 && (i3 = this.cw) > 0) {
                            jSONObjectO.put("bn_click_area", i3);
                        }
                    } else if (r11 == 6) {
                        jSONObjectO.put("bn_click_area", i3);
                    }
                } else if (r11 == 6) {
                    jSONObjectO.put("bn_click_area", i3);
                }
            }
        } catch (Exception unused2) {
        }
        com.anythink.core.common.u.b bVarA = com.anythink.core.common.u.b.a();
        if (r11 != 4) {
            if (r11 == 6) {
                try {
                    if (this.r == 66) {
                        long jB = com.anythink.core.common.u.b.b((n) this);
                        if (jB > 0) {
                            jSONObjectO.put("s_c_interval", jB);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str;
                    th.getMessage();
                }
            }
            str2 = str;
        } else {
            try {
                str2 = str;
                try {
                    if (!str2.equals(this.aN)) {
                        long jA = bVarA.a((n) this);
                        if (jA > 0) {
                            jSONObjectO.put("pl_show_interval", jA);
                        }
                        long jB2 = bVarA.b();
                        if (jB2 > 0) {
                            jSONObjectO.put("bidads_show_interval", jB2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    th.getMessage();
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = str;
            }
        }
        try {
            if (TextUtils.equals(this.aN, str2) && (r11 == 1 || r11 == 4 || r11 == 6)) {
                int i26 = this.cX;
                if (i26 > 0) {
                    jSONObjectO.put(com.anythink.core.common.d.j.w.E, i26);
                }
                int i27 = this.cY;
                if (i27 > 0) {
                    jSONObjectO.put(com.anythink.core.common.d.j.w.F, i27);
                }
            }
        } catch (Exception unused3) {
        }
        ATAdRequest aTAdRequest2 = this.dw;
        MgPreLoadAdRequest preLoadInfo = aTAdRequest2 != null ? aTAdRequest2.getPreLoadInfo() : null;
        if (preLoadInfo != null) {
            try {
                String placementId = preLoadInfo.getPlacementId();
                String psId = preLoadInfo.getPsId();
                String requestId = preLoadInfo.getRequestId();
                if (!TextUtils.isEmpty(placementId)) {
                    jSONObjectO.put("mmed_pl_id", placementId);
                }
                if (!TextUtils.isEmpty(psId)) {
                    jSONObjectO.put("mmed_psid", psId);
                }
                if (!TextUtils.isEmpty(requestId)) {
                    jSONObjectO.put("mmed_req_id", requestId);
                }
                jSONObjectO.put("mmed_wait_price_sw", preLoadInfo.getCpEcpmSwitch());
                jSONObjectO.put("mmed_wait_price_t", preLoadInfo.getCpEcpmTimeout());
                MgComparedResult mgComparedResult = preLoadInfo.getMgComparedResult();
                boolean z2 = !(r11 == 4 || r11 == 6 || r11 == 13) || (mgComparedResult != null ? mgComparedResult.isCompared() : false);
                getClass().getSimpleName();
                Object[] objArr = new Object[2];
                Boolean.valueOf(z2);
                Integer.valueOf(i2);
                if (z2) {
                    MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                    MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
                    double uSDEcpm = mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d;
                    if (uSDEcpm > 0.0d) {
                        jSONObjectO.put("mmed_price", String.valueOf(uSDEcpm));
                    }
                }
            } catch (Throwable unused4) {
                getClass().getSimpleName();
                z = true;
                Object[] objArr2 = new Object[1];
                Integer.valueOf(i2);
            }
        }
        z = true;
        if (this.r == 8 && (r11 == z || r11 == 6)) {
            try {
                Map<String, Object> map2 = this.cp;
                if (map2 != null && !map2.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    Object obj3 = this.cp.get("lng");
                    if (obj3 instanceof String) {
                        jSONObject.put("lng", obj3);
                    }
                    Object obj4 = this.cp.get("lat");
                    if (obj4 instanceof String) {
                        jSONObject.put("lat", obj4);
                    }
                    Object obj5 = this.cp.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                    if (obj5 instanceof String) {
                        jSONObject.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj5);
                    }
                    Object obj6 = this.cp.get(GDTATConst.EXTRA_DATA.WXOPENID);
                    if (obj6 instanceof String) {
                        jSONObject.put(GDTATConst.EXTRA_DATA.WXOPENID, obj6);
                    }
                    if (jSONObject.length() > 0) {
                        jSONObjectO.put("tx_d", jSONObject);
                    }
                }
            } catch (Exception unused5) {
            }
        }
        if (jSONObjectO != null && r11 == 6) {
            try {
                if (this.dx) {
                    this.dy = true;
                    jSONObjectO.put("type", 28);
                }
            } catch (Throwable unused6) {
            }
        }
        return jSONObjectO;
    }

    private void a(JSONObject jSONObject, int i2) {
        ATAdRequest aTAdRequest = this.dw;
        MgPreLoadAdRequest preLoadInfo = aTAdRequest != null ? aTAdRequest.getPreLoadInfo() : null;
        if (preLoadInfo == null) {
            return;
        }
        try {
            String placementId = preLoadInfo.getPlacementId();
            String psId = preLoadInfo.getPsId();
            String requestId = preLoadInfo.getRequestId();
            if (!TextUtils.isEmpty(placementId)) {
                jSONObject.put("mmed_pl_id", placementId);
            }
            if (!TextUtils.isEmpty(psId)) {
                jSONObject.put("mmed_psid", psId);
            }
            if (!TextUtils.isEmpty(requestId)) {
                jSONObject.put("mmed_req_id", requestId);
            }
            jSONObject.put("mmed_wait_price_sw", preLoadInfo.getCpEcpmSwitch());
            jSONObject.put("mmed_wait_price_t", preLoadInfo.getCpEcpmTimeout());
            MgComparedResult mgComparedResult = preLoadInfo.getMgComparedResult();
            boolean z = false;
            boolean zIsCompared = mgComparedResult != null ? mgComparedResult.isCompared() : false;
            if ((i2 != 4 && i2 != 6 && i2 != 13) || zIsCompared) {
                z = true;
            }
            getClass().getSimpleName();
            Object[] objArr = new Object[2];
            Boolean.valueOf(z);
            Integer.valueOf(i2);
            if (z) {
                MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
                double uSDEcpm = mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d;
                if (uSDEcpm > 0.0d) {
                    jSONObject.put("mmed_price", String.valueOf(uSDEcpm));
                }
            }
        } catch (Throwable unused) {
            getClass().getSimpleName();
            Object[] objArr2 = new Object[1];
            Integer.valueOf(i2);
        }
    }

    private void b(JSONObject jSONObject, int i2) {
        if (jSONObject == null || i2 != 6) {
            return;
        }
        try {
            if (this.dx) {
                this.dy = true;
                jSONObject.put("type", 28);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(int i2, MgPreLoadAdRequest mgPreLoadAdRequest) {
        MgComparedResult mgComparedResult = mgPreLoadAdRequest.getMgComparedResult();
        return !(i2 == 4 || i2 == 6 || i2 == 13) || (mgComparedResult != null ? mgComparedResult.isCompared() : false);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        int i2;
        double d2 = this.ct;
        if (d2 > 0.0d) {
            jSONObject.put("bidprice", String.valueOf(d2));
            jSONObject.put("am_bp_type", 3);
            return;
        }
        jSONObject.put("bidprice", String.valueOf(this.z));
        int i3 = 1;
        if (this.dk == 1) {
            double d3 = this.cu;
            if (d3 == -1.0d) {
                i2 = 5;
            } else if (d3 == 0.0d) {
                i2 = 4;
            } else if (this.cs) {
                i2 = 2;
            }
            i3 = i2;
        }
        jSONObject.put("am_bp_type", i3);
    }

    private void d(JSONObject jSONObject) {
        Map<String, Object> map = this.cr;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (this.r == 2 || this.dk == 1) {
            try {
                jSONObject.put("am_ilrd", new JSONObject(this.cr).toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void a(int i2, JSONObject jSONObject) throws JSONException {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13 || i2 == 24) {
            jSONObject.put("extra", this.bS);
        }
    }

    private void b(int i2, JSONObject jSONObject) throws JSONException {
        List<Integer> list;
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 8) {
                list = this.L;
                if (list != null && !list.isEmpty()) {
                    jSONObject.put("bid_link", this.L.toString());
                }
            } else if (i2 != 13) {
                if (i2 != 25) {
                    return;
                }
                list = this.L;
                if (list != null) {
                    jSONObject.put("bid_link", this.L.toString());
                }
            }
        }
        if (TextUtils.isEmpty(this.bB)) {
            return;
        }
        jSONObject.put("bid_t_m", this.bB);
    }

    private JSONObject au(int i2) {
        return super.O(i2);
    }

    public final n af() {
        try {
            n nVar = (n) super.clone();
            nVar.cm = this.cm;
            nVar.cp = this.cp;
            nVar.cn = this.cn;
            nVar.co = this.co;
            nVar.cr = this.cr;
            nVar.cq = this.cq;
            nVar.cA = this.cA;
            nVar.dA = this.dA;
            nVar.dg = this.dg;
            nVar.dw = this.dw;
            return nVar;
        } catch (Throwable unused) {
            return this;
        }
    }

    private int bk() {
        return this.cw;
    }

    public final void P(int i2) {
        this.cw = i2;
    }

    private int bl() {
        return this.cx;
    }

    public final void Q(int i2) {
        this.cx = i2;
    }

    public final int ag() {
        return this.cB;
    }

    public final void R(int i2) {
        this.cB = i2;
    }

    private void c(JSONObject jSONObject, int i2) {
        int i3;
        try {
            if (TextUtils.equals(this.aN, "2")) {
                if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 13 || i2 == 11 || i2 == 6) {
                    if (this.ce == 0 || i2 == 11) {
                        jSONObject.put(com.anythink.core.d.l.a.aq, this.cx);
                    }
                    Map<String, Object> map = this.cp;
                    if (map != null) {
                        Object obj = map.get(ATAdConst.KEY.AD_WIDTH);
                        Object obj2 = this.cp.get(ATAdConst.KEY.AD_HEIGHT);
                        if (obj != null) {
                            try {
                                jSONObject.put("bn_width", Integer.parseInt(obj.toString()));
                            } catch (Exception e2) {
                                e2.getMessage();
                            }
                        }
                        if (obj2 != null) {
                            try {
                                jSONObject.put("bn_height", Integer.parseInt(obj2.toString()));
                            } catch (Exception e3) {
                                e3.getMessage();
                            }
                        }
                    }
                    if (i2 != 6 || (i3 = this.cw) <= 0) {
                        return;
                    }
                    jSONObject.put("bn_click_area", i3);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i2) {
        try {
            if (TextUtils.equals(this.aN, "0")) {
                if (i2 == 1 || i2 == 4 || i2 == 6) {
                    int i3 = this.cX;
                    if (i3 > 0) {
                        jSONObject.put(com.anythink.core.common.d.j.w.E, i3);
                    }
                    int i4 = this.cY;
                    if (i4 > 0) {
                        jSONObject.put(com.anythink.core.common.d.j.w.F, i4);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject, int i2) {
        if (i2 == 1 || i2 == 6) {
            try {
                Map<String, Object> map = this.cp;
                if (map == null || map.isEmpty()) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                Object obj = this.cp.get("lng");
                if (obj instanceof String) {
                    jSONObject2.put("lng", obj);
                }
                Object obj2 = this.cp.get("lat");
                if (obj2 instanceof String) {
                    jSONObject2.put("lat", obj2);
                }
                Object obj3 = this.cp.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                if (obj3 instanceof String) {
                    jSONObject2.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj3);
                }
                Object obj4 = this.cp.get(GDTATConst.EXTRA_DATA.WXOPENID);
                if (obj4 instanceof String) {
                    jSONObject2.put(GDTATConst.EXTRA_DATA.WXOPENID, obj4);
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("tx_d", jSONObject2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void u(long j2) {
        this.dA = j2;
    }

    private void f(JSONObject jSONObject, int i2) {
        com.anythink.core.common.u.b bVarA = com.anythink.core.common.u.b.a();
        try {
            if (i2 == 4) {
                if ("0".equals(this.aN)) {
                    return;
                }
                long jA = bVarA.a(this);
                if (jA > 0) {
                    jSONObject.put("pl_show_interval", jA);
                }
                long jB = bVarA.b();
                if (jB > 0) {
                    jSONObject.put("bidads_show_interval", jB);
                    return;
                }
                return;
            }
            if (i2 == 6 && this.r == 66) {
                long jB2 = com.anythink.core.common.u.b.b(this);
                if (jB2 > 0) {
                    jSONObject.put("s_c_interval", jB2);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void c(boolean z) {
        this.cF = z;
    }

    public final boolean ah() {
        return this.cF;
    }

    public final int ai() {
        return this.cH;
    }

    public final void S(int i2) {
        this.cH = i2;
    }

    public final int aj() {
        return this.cI;
    }

    public final void T(int i2) {
        this.cI = i2;
    }

    private int bm() {
        return this.cJ;
    }

    public final void U(int i2) {
        this.cJ = i2;
    }

    public final void l(double d2) {
        this.cL = d2;
    }

    public final void m(double d2) {
        this.cM = d2;
    }

    private void e(JSONObject jSONObject) {
        try {
            jSONObject.put("dd_ori_price", String.valueOf(this.cM));
            jSONObject.put(com.anythink.core.common.k.aN, String.valueOf(this.cL));
        } catch (Throwable unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(this.dt)) {
                jSONObject.put("deal_type", this.dt);
            }
            if (TextUtils.isEmpty(this.du)) {
                return;
            }
            jSONObject.put("deal_id", this.du);
        } catch (Throwable unused) {
        }
    }

    private int bn() {
        return this.dz;
    }

    public final void V(int i2) {
        this.dz = i2;
    }

    public final String ak() {
        return this.cU;
    }

    public final void z(String str) {
        this.cU = str;
    }

    public final Map<String, String> al() {
        return this.cN;
    }

    public final void e(Map<String, String> map) {
        this.cN = map;
    }

    public final void W(int i2) {
        this.cV = i2;
    }

    public final void X(int i2) {
        this.cX = i2;
    }

    public final void Y(int i2) {
        this.cY = i2;
    }

    private int bo() {
        return this.cZ;
    }

    public final void Z(int i2) {
        this.cZ = i2;
    }

    private int bp() {
        return this.da;
    }

    public final void aa(int i2) {
        this.da = i2;
    }

    public final int am() {
        return this.db;
    }

    public final void ab(int i2) {
        this.db = i2;
    }

    public final void A(String str) {
        this.dc = str;
    }

    private int bq() {
        return this.dd;
    }

    public final void ac(int i2) {
        this.dd = i2;
    }

    public final void ad(int i2) {
        this.de = i2;
    }

    public final int an() {
        return this.de;
    }

    public final void ao() {
        this.df = 1;
    }

    public final aa ap() {
        return this.dg;
    }

    public final void a(aa aaVar) {
        this.dg = aaVar;
    }

    public final void a(ab abVar) {
        this.di = abVar;
    }

    public final void a(bc bcVar) {
        this.dj = bcVar;
    }

    public final void ae(int i2) {
        this.dk = i2;
    }

    public final void a(e eVar) {
        this.dh = eVar;
    }

    public final void a(ATCustomContentResult aTCustomContentResult) {
        this.dl = aTCustomContentResult;
    }

    public final ATCustomContentResult aq() {
        return this.dl;
    }

    public final void af(int i2) {
        this.dm = i2;
    }

    public final void n(double d2) {
        this.dn = d2;
    }

    public final void v(long j2) {
        this.f0do = j2;
    }

    public final int ar() {
        return this.dr;
    }

    public final void ag(int i2) {
        this.dr = i2;
    }

    public final int as() {
        return this.ds;
    }

    public final void ah(int i2) {
        this.ds = i2;
    }

    public final void ai(int i2) {
        this.dp = i2;
    }

    public final void aj(int i2) {
        this.dq = i2;
    }

    public final int at() {
        return this.dp;
    }

    private int br() {
        return this.dq;
    }

    public final String au() {
        return this.dt;
    }

    public final void B(String str) {
        this.dt = str;
    }

    public final String av() {
        return this.du;
    }

    public final void C(String str) {
        this.du = str;
    }

    private int bs() {
        return this.dv;
    }

    public final void ak(int i2) {
        this.dv = i2;
    }

    public final void a(List<Integer> list) {
        this.L = list;
    }

    public final boolean aw() {
        return this.dx;
    }

    public final void d(boolean z) {
        this.dx = z;
    }
}
