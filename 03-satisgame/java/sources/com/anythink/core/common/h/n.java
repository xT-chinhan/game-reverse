package com.anythink.core.common.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
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
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n extends bx implements Cloneable {
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
    int A;
    protected double B;
    protected double C;
    String D;
    public int E;
    int F;
    int G;
    public String H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected double M;
    List<Integer> N;
    boolean O;
    int P;
    af Q;
    long R;
    long S;
    long T;
    long U;
    long V;
    String W;
    private long bA;
    private long bB;
    private long bC;
    private long bD;
    private long bE;
    private long bF;
    private long bG;
    private long bH;
    private long bI;
    private long bJ;
    private int bK;
    private int bL;
    private long bM;
    private long bN;
    private String bO;
    private String bP;
    private String bQ;
    private String bR;
    private int bS;
    private String bU;
    private String bV;
    private double bW;
    private String bX;
    private double bY;
    private double bZ;
    private int bk;
    private String bl;
    private String bm;
    private int bn;
    private int bo;
    private String bp;
    private int bq;
    private int bu;
    private int bv;
    private boolean bw;
    private long bx;
    private long by;
    private long bz;
    private ATRewardInfo cA;
    private Map<String, ATRewardInfo> cB;
    private Map<String, Object> cC;
    private Map<String, Object> cD;
    private d cE;
    private Map<String, Object> cF;
    private boolean cG;
    private double cH;
    private double cI;
    private int cJ;
    private int cK;
    private int cM;
    private double cO;
    private int cP;
    private int cR;
    private String cS;
    private long cT;
    private long cU;
    private boolean cV;
    private String ca;
    private double cb;
    private String cc;
    private int cd;
    private String ce;
    private String cf;
    private String cg;
    private String ch;
    private int ci;
    private int cj;
    private String ck;
    private long cl;
    private int cm;
    private int cn;
    private int co;
    private int cp;
    private int cq;
    private long cr;
    private int ct;
    private int cu;
    private int cx;
    private String cy;
    private int cz;
    private int dA;
    private ATCustomContentResult dB;
    private int dC;
    private double dD;
    private long dE;
    private String dK;
    private int dL;
    private ATAdRequest dM;
    private com.anythink.core.common.f dP;
    private int dQ;
    private long dR;
    private String dT;
    private String dU;
    private double dV;
    private double dW;
    private int dX;
    private int dY;
    private int dZ;
    private int da;
    private double db;
    private double dc;
    private Map<String, String> dd;
    private String df;
    private String dh;
    private String dj;
    private String dk;
    private int dl;
    private double dm;
    private int dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private int f0do;
    private int dp;
    private int dq;
    private String ds;
    private int du;
    private int dv;
    private aa dw;
    private e dx;
    private ab dy;
    private be dz;
    private int ea;
    protected int r;
    public int w;
    public String x;
    public String y;
    public String z;
    private int br = -1;
    private int bs = -1;
    private int bt = -1;
    public String s = "";
    public int t = 0;
    public int u = 0;
    public int v = 0;
    private String bT = "unknow";
    private int cs = -1;
    private int cv = 1;
    private int cw = 13;
    private int cL = 1;
    private int cN = 1;
    private int cQ = 1;
    private int cW = 0;
    private int cX = 0;
    private int cY = 0;
    private int cZ = 0;
    private double de = -1.0d;
    private double dg = -1.0d;
    private int di = -1;
    private int dr = -2;
    private int dt = 2;
    private int dF = 0;
    private int dG = -1;
    private int dH = 0;
    private int dI = 0;
    private String dJ = "";
    private boolean dN = false;
    private boolean dO = false;
    private int dS = -1;

    public final void a(long j2) {
        this.bM = j2;
    }

    public final void b(long j2) {
        if (this.bI != 0) {
            return;
        }
        this.bI = j2;
    }

    public final void c(long j2) {
        if (this.bJ != 0) {
            return;
        }
        this.bJ = j2;
    }

    public final void a(int i2) {
        this.bK = i2;
    }

    public final void b(int i2) {
        this.bL = i2;
    }

    public final void d(long j2) {
        this.bB = j2;
    }

    public final void e(long j2) {
        this.bH = j2;
    }

    public final void f(long j2) {
        this.bF = j2;
    }

    public final void g(long j2) {
        this.bG = j2;
    }

    public final void h(long j2) {
        this.bC = j2;
    }

    public final void i(long j2) {
        this.bD = j2;
    }

    public final void j(long j2) {
        this.bE = j2;
    }

    public final void k(long j2) {
        this.bA = j2;
    }

    public final void l(long j2) {
        this.by = j2;
    }

    public final void m(long j2) {
        this.bz = j2;
    }

    public final com.anythink.core.common.f a() {
        return this.dP;
    }

    public final void a(com.anythink.core.common.f fVar) {
        this.dP = fVar;
    }

    public final ATAdRequest b() {
        return this.dM;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.dM = aTAdRequest;
    }

    public final void a(double d2) {
        this.de = d2;
    }

    public final void a(String str) {
        this.df = str;
    }

    public final void b(double d2) {
        this.dg = d2;
    }

    public final void b(String str) {
        this.dh = str;
    }

    public final void c(int i2) {
        this.di = i2;
    }

    public final void c(String str) {
        this.dj = str;
    }

    public final void d(int i2) {
        this.da = i2;
    }

    public final long c() {
        return this.cT;
    }

    public final void n(long j2) {
        this.cT = j2;
    }

    public final long d() {
        return this.cU;
    }

    public final void o(long j2) {
        this.cU = j2;
    }

    public final void a(int i2, int i3) {
        this.cS = i2 + "_" + i3;
    }

    public final void e() {
        this.cQ = 2;
    }

    public final double f() {
        return this.cO;
    }

    public final void c(double d2) {
        this.cO = d2;
    }

    private int aV() {
        return this.cP;
    }

    public final void e(int i2) {
        this.cP = i2;
    }

    public final void a(d dVar) {
        this.cE = dVar;
    }

    public final d g() {
        return this.cE;
    }

    public final String h() {
        d dVar = this.cE;
        return dVar != null ? dVar.a() : "";
    }

    public final Map<String, Object> i() {
        return this.cF;
    }

    public final void a(Map<String, Object> map) {
        this.cF = map;
    }

    public final void d(double d2) {
        this.cI = d2;
    }

    private double aW() {
        return this.cH;
    }

    public final void e(double d2) {
        this.cH = d2;
    }

    private boolean aX() {
        return this.cG;
    }

    public final void a(boolean z) {
        this.cG = z;
    }

    public final int j() {
        return this.cJ;
    }

    public final void f(int i2) {
        this.cJ = i2;
    }

    public final void b(Map<String, Object> map) {
        this.cD = map;
    }

    public final Map<String, Object> k() {
        return this.cD;
    }

    private double aY() {
        return this.M;
    }

    public final void f(double d2) {
        this.M = d2;
    }

    public final void d(String str) {
        this.cy = str;
    }

    public final void g(int i2) {
        this.ct = i2;
    }

    public final void h(int i2) {
        this.cu = i2;
    }

    public final void p(long j2) {
        this.cr = j2;
    }

    public final void i(int i2) {
        this.cp = i2;
    }

    public final void j(int i2) {
        this.cq = i2;
    }

    public final int l() {
        return this.cq;
    }

    private int aZ() {
        return this.co;
    }

    public final void k(int i2) {
        this.co = i2;
    }

    private int ba() {
        return this.cn;
    }

    public final void l(int i2) {
        this.cn = i2;
    }

    public final int m() {
        return this.cm;
    }

    public final void m(int i2) {
        this.cm = i2;
    }

    public final void e(String str) {
        this.ck = str;
    }

    public final void q(long j2) {
        this.cl = j2;
    }

    public final void n() {
        this.cj = 1;
    }

    public final void o() {
        if (this.cj != 1) {
            this.ci = 1;
        }
    }

    public final void f(String str) {
        this.ch = str;
    }

    public final String p() {
        return this.ch;
    }

    public final double q() {
        return this.bZ;
    }

    public final void g(double d2) {
        this.bZ = d2;
    }

    public final double r() {
        return this.cb;
    }

    public final void h(double d2) {
        this.cb = d2;
    }

    public final String s() {
        return this.ca;
    }

    public final void g(String str) {
        this.ca = str;
    }

    public final String t() {
        return this.cc;
    }

    public final void h(String str) {
        this.cc = str;
    }

    public final int u() {
        return this.cd;
    }

    public final void n(int i2) {
        this.cd = i2;
    }

    public final void i(String str) {
        this.ce = str;
    }

    public final double v() {
        return this.bW;
    }

    public final void i(double d2) {
        this.bW = d2;
    }

    public final String w() {
        return this.bX;
    }

    public final void j(String str) {
        this.bX = str;
    }

    public final String x() {
        return this.cf;
    }

    public final void k(String str) {
        this.cf = str;
    }

    public final String y() {
        return this.D;
    }

    public final void l(String str) {
        this.D = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bP = com.anythink.core.common.u.n.b(this.D);
    }

    public final void o(int i2) {
        this.I = i2;
    }

    public final void p(int i2) {
        this.J = i2;
    }

    public final void q(int i2) {
        this.K = i2;
    }

    public final void r(int i2) {
        this.L = i2;
    }

    public final String z() {
        return this.bQ;
    }

    public final void m(String str) {
        this.bQ = str;
    }

    public final String A() {
        return this.bR;
    }

    public final void n(String str) {
        this.bR = str;
    }

    public final int B() {
        return this.bS;
    }

    public final void s(int i2) {
        this.bS = i2;
    }

    public final String C() {
        return this.bT;
    }

    public final void o(String str) {
        this.bT = str;
    }

    public final String D() {
        return this.bU;
    }

    public final void p(String str) {
        this.bU = str;
    }

    public final String E() {
        return this.bV;
    }

    public final void q(String str) {
        this.bV = str;
    }

    public final Map<String, ATRewardInfo> F() {
        return this.cB;
    }

    public final void c(Map<String, ATRewardInfo> map) {
        this.cB = map;
    }

    public final void t(int i2) {
        this.cz = i2;
    }

    public final ATRewardInfo G() {
        return this.cA;
    }

    public final void a(ATRewardInfo aTRewardInfo) {
        this.cA = aTRewardInfo;
    }

    public final Map<String, Object> H() {
        return this.cC;
    }

    public final void d(Map<String, Object> map) {
        this.cC = map;
    }

    private String bb() {
        return this.H;
    }

    private void M(String str) {
        this.H = str;
    }

    public final int I() {
        return this.F;
    }

    public final void u(int i2) {
        this.F = i2;
    }

    public final int J() {
        return this.G;
    }

    public final void v(int i2) {
        this.G = i2;
    }

    private int bc() {
        return this.E;
    }

    private void bd() {
        this.E = 1;
    }

    public final int K() {
        return this.A;
    }

    public final boolean L() {
        return this.A == 1;
    }

    public final void w(int i2) {
        this.A = i2;
    }

    public final double M() {
        return this.B;
    }

    public final void j(double d2) {
        this.B = d2;
    }

    private double be() {
        return this.C;
    }

    public final void k(double d2) {
        this.C = d2;
    }

    private String bf() {
        return this.y;
    }

    private void N(String str) {
        this.y = str;
    }

    private String bg() {
        return this.x;
    }

    private void O(String str) {
        this.x = str;
    }

    public final String N() {
        return this.bO;
    }

    public final void r(String str) {
        this.bO = str;
    }

    private boolean bh() {
        return this.cp == 9;
    }

    public final int O() {
        int i2 = this.cp;
        if (i2 != 8) {
            return i2 != 9 ? 0 : 1;
        }
        return 2;
    }

    private void e(boolean z) {
        this.bw = z;
    }

    public final int P() {
        return this.bu;
    }

    public final void x(int i2) {
        this.bu = i2;
    }

    public final int Q() {
        return this.bv;
    }

    public final void y(int i2) {
        this.bv = i2;
    }

    public final int R() {
        return this.bn;
    }

    public final void z(int i2) {
        this.bn = i2;
    }

    public final int S() {
        return this.bo;
    }

    public final void A(int i2) {
        this.bo = i2;
    }

    public final String T() {
        return this.bp;
    }

    public final void s(String str) {
        this.bp = str;
    }

    public final int U() {
        return this.bq;
    }

    public final void B(int i2) {
        this.bq = i2;
    }

    public final int V() {
        return this.br;
    }

    public final void C(int i2) {
        this.br = i2;
    }

    public final int W() {
        return this.bs;
    }

    public final void D(int i2) {
        this.bs = i2;
    }

    public final int X() {
        return this.bt;
    }

    public final void E(int i2) {
        this.bt = i2;
    }

    public final String Y() {
        return this.bm;
    }

    public final void t(String str) {
        this.bm = str;
    }

    public final int Z() {
        return this.r;
    }

    public final void F(int i2) {
        this.r = i2;
    }

    private String bi() {
        return this.bl;
    }

    public final void u(String str) {
        this.bl = str;
    }

    public final int aa() {
        return this.bk;
    }

    public final void G(int i2) {
        this.bk = i2;
    }

    private void P(String str) {
        this.z = str;
    }

    private void av(int i2) {
        this.t = i2;
    }

    private int bj() {
        return this.t;
    }

    private void aw(int i2) {
        this.u = i2;
    }

    private int bk() {
        return this.u;
    }

    private void ax(int i2) {
        this.v = i2;
    }

    public final long ab() {
        return this.bx;
    }

    public final void r(long j2) {
        this.bx = j2;
    }

    public final void s(long j2) {
        this.bN = j2;
    }

    public final long ac() {
        return this.bN;
    }

    private int bl() {
        return this.w;
    }

    private void ay(int i2) {
        this.w = i2;
    }

    public final void v(String str) {
        this.cg = str;
    }

    public final int ad() {
        return this.cs;
    }

    public final int ae() {
        int i2 = this.cs;
        return i2 == -1 ? Integer.parseInt(this.aZ) : i2;
    }

    public final void H(int i2) {
        this.cs = i2;
    }

    public final void I(int i2) {
        this.cv = i2;
    }

    public final void J(int i2) {
        this.cw = i2;
    }

    public final int af() {
        return this.cx;
    }

    public final void K(int i2) {
        this.cx = i2;
    }

    public final void a(by byVar) {
        if (byVar != null) {
            this.bO = byVar.G();
            this.B = byVar.K();
            this.C = byVar.A;
            this.cq = byVar.k();
            this.r = byVar.n();
        }
    }

    private boolean bm() {
        return this.O;
    }

    public final void b(boolean z) {
        this.O = z;
    }

    private int bn() {
        return this.P;
    }

    public final void L(int i2) {
        this.P = i2;
    }

    public final void a(af afVar) {
        this.Q = afVar;
    }

    private int bo() {
        return this.cW;
    }

    public final void M(int i2) {
        this.cW = i2;
    }

    private long bp() {
        return this.V;
    }

    public final void t(long j2) {
        this.V = j2;
    }

    private long bq() {
        return this.R;
    }

    public final void u(long j2) {
        this.R = j2;
    }

    private long br() {
        return this.S;
    }

    public final void v(long j2) {
        this.S = j2;
    }

    private long bs() {
        return this.T;
    }

    public final void w(long j2) {
        this.T = j2;
    }

    private long bt() {
        return this.U;
    }

    public final void x(long j2) {
        this.U = j2;
    }

    private String bu() {
        return this.W;
    }

    public final void w(String str) {
        this.W = str;
    }

    public final void N(int i2) {
        this.dS = i2;
    }

    public final void x(String str) {
        this.dT = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x01d5 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:107:0x01de A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01eb A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01f4 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:116:0x01fe A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0299  */
    /* JADX WARN: Code duplicated, block: B:137:0x029c A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02da A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:159:0x02ed A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0316  */
    /* JADX WARN: Code duplicated, block: B:163:0x0317 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0334 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0353  */
    /* JADX WARN: Code duplicated, block: B:170:0x0356  */
    /* JADX WARN: Code duplicated, block: B:180:0x03c7 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0599 A[Catch: Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:212:0x05a8 A[Catch: Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:215:0x05b3 A[Catch: Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:219:0x05cc A[Catch: Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0619 A[Catch: Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x020c, blocks: (B:102:0x01cd, B:104:0x01d5, B:105:0x01da, B:107:0x01de, B:108:0x01e3, B:110:0x01eb, B:111:0x01f0, B:113:0x01f4, B:114:0x01f9, B:116:0x01fe, B:117:0x0203, B:209:0x0599, B:212:0x05a8, B:215:0x05b3, B:219:0x05cc, B:222:0x0619, B:124:0x0219, B:126:0x0225, B:127:0x0237, B:134:0x0262, B:138:0x02a0, B:145:0x02be, B:147:0x02c2, B:149:0x02c6, B:157:0x02de, B:159:0x02ed, B:160:0x02f4, B:164:0x031c, B:166:0x0334, B:167:0x0339, B:171:0x0358, B:163:0x0317, B:155:0x02d6, B:156:0x02da, B:137:0x029c, B:128:0x0241, B:132:0x025c, B:131:0x0255, B:174:0x036a, B:178:0x03c3, B:181:0x03cc, B:180:0x03c7, B:182:0x03dc, B:186:0x0403, B:188:0x0419, B:190:0x0452, B:189:0x0436, B:185:0x03fc, B:191:0x0457, B:195:0x0462, B:197:0x048e, B:198:0x0493, B:199:0x04c6, B:201:0x04fc, B:202:0x0503, B:203:0x051f), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:226:0x0641 A[Catch: Exception -> 0x01c2, TRY_ENTER, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:228:0x0659 A[Catch: Exception -> 0x01c2, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:235:0x066e A[Catch: Exception -> 0x01c2, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:240:0x067d A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0686 A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:246:0x0697 A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:249:0x06be A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:252:0x06db A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:255:0x06e6 A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:258:0x06ef A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:262:0x06f9 A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:265:0x0702 A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0735 A[Catch: Exception -> 0x0917, TryCatch #2 {Exception -> 0x0917, blocks: (B:268:0x072e, B:270:0x0735, B:272:0x0739, B:280:0x074f, B:283:0x075e, B:287:0x0768, B:289:0x076e, B:293:0x0777, B:294:0x077a, B:281:0x0753, B:282:0x0759, B:299:0x0787, B:300:0x07eb, B:302:0x084a, B:304:0x084e, B:307:0x087a, B:309:0x087e, B:310:0x0883, B:312:0x0890, B:313:0x08a5, B:315:0x08ad, B:316:0x08b4, B:305:0x085d, B:306:0x086c, B:317:0x08be), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:275:0x0740 A[Catch: Exception -> 0x077f, TryCatch #8 {Exception -> 0x077f, blocks: (B:238:0x0679, B:241:0x0682, B:244:0x068b, B:247:0x069c, B:250:0x06d3, B:253:0x06e2, B:256:0x06eb, B:259:0x06f4, B:263:0x06fe, B:266:0x0707, B:273:0x073c, B:275:0x0740, B:277:0x0744), top: B:503:0x0679 }] */
    /* JADX WARN: Code duplicated, block: B:282:0x0759 A[ADDED_TO_REGION, Catch: Exception -> 0x0917, REMOVE, TryCatch #2 {Exception -> 0x0917, blocks: (B:268:0x072e, B:270:0x0735, B:272:0x0739, B:280:0x074f, B:283:0x075e, B:287:0x0768, B:289:0x076e, B:293:0x0777, B:294:0x077a, B:281:0x0753, B:282:0x0759, B:299:0x0787, B:300:0x07eb, B:302:0x084a, B:304:0x084e, B:307:0x087a, B:309:0x087e, B:310:0x0883, B:312:0x0890, B:313:0x08a5, B:315:0x08ad, B:316:0x08b4, B:305:0x085d, B:306:0x086c, B:317:0x08be), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:285:0x0765  */
    /* JADX WARN: Code duplicated, block: B:286:0x0767  */
    /* JADX WARN: Code duplicated, block: B:289:0x076e A[Catch: Exception -> 0x0917, TryCatch #2 {Exception -> 0x0917, blocks: (B:268:0x072e, B:270:0x0735, B:272:0x0739, B:280:0x074f, B:283:0x075e, B:287:0x0768, B:289:0x076e, B:293:0x0777, B:294:0x077a, B:281:0x0753, B:282:0x0759, B:299:0x0787, B:300:0x07eb, B:302:0x084a, B:304:0x084e, B:307:0x087a, B:309:0x087e, B:310:0x0883, B:312:0x0890, B:313:0x08a5, B:315:0x08ad, B:316:0x08b4, B:305:0x085d, B:306:0x086c, B:317:0x08be), top: B:490:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:291:0x0774  */
    /* JADX WARN: Code duplicated, block: B:292:0x0776  */
    /* JADX WARN: Code duplicated, block: B:328:0x092d  */
    /* JADX WARN: Code duplicated, block: B:342:0x0945  */
    /* JADX WARN: Code duplicated, block: B:344:0x0949 A[Catch: Exception -> 0x098c, TryCatch #1 {Exception -> 0x098c, blocks: (B:326:0x0923, B:340:0x0941, B:345:0x0950, B:347:0x0954, B:354:0x0983, B:356:0x0987, B:344:0x0949), top: B:491:0x0923 }] */
    /* JADX WARN: Code duplicated, block: B:347:0x0954 A[Catch: Exception -> 0x098c, TRY_LEAVE, TryCatch #1 {Exception -> 0x098c, blocks: (B:326:0x0923, B:340:0x0941, B:345:0x0950, B:347:0x0954, B:354:0x0983, B:356:0x0987, B:344:0x0949), top: B:491:0x0923 }] */
    /* JADX WARN: Code duplicated, block: B:354:0x0983 A[Catch: Exception -> 0x098c, TRY_ENTER, TryCatch #1 {Exception -> 0x098c, blocks: (B:326:0x0923, B:340:0x0941, B:345:0x0950, B:347:0x0954, B:354:0x0983, B:356:0x0987, B:344:0x0949), top: B:491:0x0923 }] */
    /* JADX WARN: Code duplicated, block: B:359:0x0993  */
    /* JADX WARN: Code duplicated, block: B:362:0x0999 A[Catch: all -> 0x0996, TRY_ENTER, TryCatch #11 {all -> 0x0996, blocks: (B:362:0x0999, B:364:0x099f, B:366:0x09a9, B:367:0x09af), top: B:509:0x0991 }] */
    /* JADX WARN: Code duplicated, block: B:366:0x09a9 A[Catch: all -> 0x0996, TryCatch #11 {all -> 0x0996, blocks: (B:362:0x0999, B:364:0x099f, B:366:0x09a9, B:367:0x09af), top: B:509:0x0991 }] */
    /* JADX WARN: Code duplicated, block: B:367:0x09af A[Catch: all -> 0x0996, TRY_LEAVE, TryCatch #11 {all -> 0x0996, blocks: (B:362:0x0999, B:364:0x099f, B:366:0x09a9, B:367:0x09af), top: B:509:0x0991 }] */
    /* JADX WARN: Code duplicated, block: B:371:0x09b9 A[Catch: all -> 0x09d7, TryCatch #13 {all -> 0x09d7, blocks: (B:369:0x09b3, B:371:0x09b9, B:373:0x09c3, B:374:0x09c8, B:376:0x09d2), top: B:512:0x09b3 }] */
    /* JADX WARN: Code duplicated, block: B:373:0x09c3 A[Catch: all -> 0x09d7, TryCatch #13 {all -> 0x09d7, blocks: (B:369:0x09b3, B:371:0x09b9, B:373:0x09c3, B:374:0x09c8, B:376:0x09d2), top: B:512:0x09b3 }] */
    /* JADX WARN: Code duplicated, block: B:376:0x09d2 A[Catch: all -> 0x09d7, TRY_LEAVE, TryCatch #13 {all -> 0x09d7, blocks: (B:369:0x09b3, B:371:0x09b9, B:373:0x09c3, B:374:0x09c8, B:376:0x09d2), top: B:512:0x09b3 }] */
    /* JADX WARN: Code duplicated, block: B:379:0x09df  */
    /* JADX WARN: Code duplicated, block: B:387:0x09ec A[Catch: Exception -> 0x09fa, TryCatch #12 {Exception -> 0x09fa, blocks: (B:377:0x09d7, B:385:0x09e8, B:387:0x09ec, B:388:0x09f1, B:390:0x09f5), top: B:510:0x09d7 }] */
    /* JADX WARN: Code duplicated, block: B:390:0x09f5 A[Catch: Exception -> 0x09fa, TRY_LEAVE, TryCatch #12 {Exception -> 0x09fa, blocks: (B:377:0x09d7, B:385:0x09e8, B:387:0x09ec, B:388:0x09f1, B:390:0x09f5), top: B:510:0x09d7 }] */
    /* JADX WARN: Code duplicated, block: B:393:0x09fe  */
    /* JADX WARN: Code duplicated, block: B:394:0x0a03  */
    /* JADX WARN: Code duplicated, block: B:398:0x0a28 A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:401:0x0a33 A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:404:0x0a3e A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:407:0x0a5b A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:408:0x0a60  */
    /* JADX WARN: Code duplicated, block: B:411:0x0a64  */
    /* JADX WARN: Code duplicated, block: B:415:0x0a6b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:419:0x0a71 A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:421:0x0a77 A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:422:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:424:0x0a7f A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:425:0x0a84  */
    /* JADX WARN: Code duplicated, block: B:428:0x0a8c A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:430:0x0a97 A[Catch: all -> 0x0aab, TryCatch #5 {all -> 0x0aab, blocks: (B:396:0x0a06, B:398:0x0a28, B:399:0x0a2d, B:401:0x0a33, B:402:0x0a38, B:404:0x0a3e, B:405:0x0a43, B:407:0x0a5b, B:419:0x0a71, B:421:0x0a77, B:424:0x0a7f, B:428:0x0a8c, B:430:0x0a97, B:431:0x0a9c), top: B:497:0x0a06 }] */
    /* JADX WARN: Code duplicated, block: B:434:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:440:0x0abb A[Catch: Exception -> 0x0b15, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:444:0x0ad2 A[Catch: Exception -> 0x0b15, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:447:0x0ae3 A[Catch: Exception -> 0x0b15, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a7 A[Catch: Exception -> 0x0919, TryCatch #14 {Exception -> 0x0919, blocks: (B:3:0x0012, B:5:0x0025, B:6:0x002a, B:8:0x002e, B:9:0x0033, B:11:0x0042, B:12:0x0049, B:15:0x0055, B:17:0x005d, B:19:0x0067, B:52:0x00cb, B:54:0x00cf, B:55:0x00f5, B:57:0x00f9, B:58:0x00fe, B:60:0x0102, B:61:0x0107, B:63:0x010b, B:64:0x0110, B:66:0x0114, B:67:0x0119, B:69:0x0124, B:71:0x013b, B:73:0x013f, B:74:0x0144, B:76:0x014c, B:70:0x012e, B:44:0x00a7, B:46:0x00ab, B:48:0x00b1, B:49:0x00bc, B:51:0x00c4, B:33:0x008d), top: B:514:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:450:0x0af4 A[Catch: Exception -> 0x0b15, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:453:0x0b05 A[Catch: Exception -> 0x0b15, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:456:0x0b10 A[Catch: Exception -> 0x0b15, TRY_LEAVE, TryCatch #4 {Exception -> 0x0b15, blocks: (B:438:0x0ab7, B:440:0x0abb, B:442:0x0ac1, B:444:0x0ad2, B:445:0x0ad7, B:447:0x0ae3, B:448:0x0ae8, B:450:0x0af4, B:451:0x0af9, B:453:0x0b05, B:454:0x0b0a, B:456:0x0b10), top: B:495:0x0ab7 }] */
    /* JADX WARN: Code duplicated, block: B:458:0x0b17  */
    /* JADX WARN: Code duplicated, block: B:463:0x0b1f A[Catch: all -> 0x0b29, TRY_LEAVE, TryCatch #3 {all -> 0x0b29, blocks: (B:461:0x0b1b, B:463:0x0b1f), top: B:493:0x0b1b }] */
    /* JADX WARN: Code duplicated, block: B:465:0x0b2b  */
    /* JADX WARN: Code duplicated, block: B:467:0x0b2e  */
    /* JADX WARN: Code duplicated, block: B:497:0x0a06 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:499:0x0964 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bc A[Catch: Exception -> 0x0919, TryCatch #14 {Exception -> 0x0919, blocks: (B:3:0x0012, B:5:0x0025, B:6:0x002a, B:8:0x002e, B:9:0x0033, B:11:0x0042, B:12:0x0049, B:15:0x0055, B:17:0x005d, B:19:0x0067, B:52:0x00cb, B:54:0x00cf, B:55:0x00f5, B:57:0x00f9, B:58:0x00fe, B:60:0x0102, B:61:0x0107, B:63:0x010b, B:64:0x0110, B:66:0x0114, B:67:0x0119, B:69:0x0124, B:71:0x013b, B:73:0x013f, B:74:0x0144, B:76:0x014c, B:70:0x012e, B:44:0x00a7, B:46:0x00ab, B:48:0x00b1, B:49:0x00bc, B:51:0x00c4, B:33:0x008d), top: B:514:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:501:0x0973 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x0b3f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4 A[Catch: Exception -> 0x0919, TryCatch #14 {Exception -> 0x0919, blocks: (B:3:0x0012, B:5:0x0025, B:6:0x002a, B:8:0x002e, B:9:0x0033, B:11:0x0042, B:12:0x0049, B:15:0x0055, B:17:0x005d, B:19:0x0067, B:52:0x00cb, B:54:0x00cf, B:55:0x00f5, B:57:0x00f9, B:58:0x00fe, B:60:0x0102, B:61:0x0107, B:63:0x010b, B:64:0x0110, B:66:0x0114, B:67:0x0119, B:69:0x0124, B:71:0x013b, B:73:0x013f, B:74:0x0144, B:76:0x014c, B:70:0x012e, B:44:0x00a7, B:46:0x00ab, B:48:0x00b1, B:49:0x00bc, B:51:0x00c4, B:33:0x008d), top: B:514:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b8 A[Catch: Exception -> 0x01c2, TRY_LEAVE, TryCatch #19 {Exception -> 0x01c2, blocks: (B:92:0x01b4, B:94:0x01b8, B:226:0x0641, B:228:0x0659, B:230:0x0661, B:232:0x0665, B:233:0x066a, B:235:0x066e, B:237:0x0672, B:240:0x067d, B:243:0x0686, B:246:0x0697, B:249:0x06be, B:252:0x06db, B:255:0x06e6, B:258:0x06ef, B:262:0x06f9, B:265:0x0702, B:91:0x01ab), top: B:524:0x01ab }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.anythink.core.common.h.bx, com.anythink.core.common.h.n] */
    /* JADX WARN: Type inference failed for: r3v100 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v191 */
    /* JADX WARN: Type inference failed for: r3v193 */
    /* JADX WARN: Type inference failed for: r3v194 */
    /* JADX WARN: Type inference failed for: r3v195 */
    /* JADX WARN: Type inference failed for: r3v196 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.anythink.core.common.h.bx
    public final JSONObject O(int i2) {
        String str;
        CharSequence charSequence;
        Exception exc;
        String str2;
        ?? r3;
        String str3;
        ?? r4;
        com.anythink.core.common.t.d dVarA;
        String str4;
        ATAdRequest aTAdRequest;
        MgPreLoadAdRequest preLoadInfo;
        String placementId;
        String psId;
        String requestId;
        JSONObject mpc;
        MgComparedResult mgComparedResult;
        boolean zIsCompared;
        ?? r5;
        MgPreLoadCallbackRegister preLoadCallbackRegister;
        MgAdInfo mgAdInfo;
        double uSDEcpm;
        Map<String, Object> map;
        JSONObject jSONObject;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int i3;
        int i4;
        long jA;
        long jB;
        long jB2;
        Map<String, Object> map2;
        int i5;
        Object obj5;
        Object obj6;
        String str5;
        String str6;
        String str7;
        af afVar;
        String string;
        int i6;
        int i7;
        CharSequence charSequence2;
        String str8;
        String str9;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z;
        int i15;
        int i16;
        int i17;
        int i18;
        double d2;
        String str10;
        int i19;
        double d3;
        String str11;
        String str12;
        be beVar;
        String str13;
        List<Integer> list;
        int i20 = i2;
        String str14 = "0";
        JSONObject jSONObjectO = super.O(i2);
        try {
            jSONObjectO.put("nw_ver", this.y);
            jSONObjectO.put("adapter_bridge_ver", this.x);
            int i21 = this.br;
            if (i21 != -1) {
                jSONObjectO.put("refresh", i21);
            }
            int i22 = this.bs;
            if (i22 != -1) {
                jSONObjectO.put("refresh_v2", i22);
            }
            jSONObjectO.put("load_mode", this.bt);
            if (!TextUtils.isEmpty(this.ch)) {
                jSONObjectO.put("tp_bid_id", this.ch);
            }
            if ("4".equals(this.aZ) || "2".equals(this.aZ) || "3".equals(this.aZ) || "1".equals(this.aZ)) {
                try {
                    int i23 = this.cs;
                    if (i23 == -1) {
                        i23 = Integer.parseInt(this.aZ);
                    }
                    jSONObjectO.put("ad_type", i23);
                } catch (Exception unused) {
                }
            }
            if (i20 == 1 || i20 == 2 || i20 == 4 || i20 == 6 || i20 == 13 || i20 == 24) {
                jSONObjectO.put("extra", this.cg);
            }
            if (i20 == 1 || i20 == 2) {
                if (!TextUtils.isEmpty(this.bP)) {
                    jSONObjectO.put("bid_t_m", this.bP);
                }
            } else if (i20 == 4 || i20 == 6 || i20 == 8) {
                list = this.N;
                if (list != null && !list.isEmpty()) {
                    jSONObjectO.put("bid_link", this.N.toString());
                }
                if (!TextUtils.isEmpty(this.bP)) {
                    jSONObjectO.put("bid_t_m", this.bP);
                }
            } else if (i20 == 13) {
                if (!TextUtils.isEmpty(this.bP)) {
                    jSONObjectO.put("bid_t_m", this.bP);
                }
            } else if (i20 == 25) {
                list = this.N;
                if (list != null) {
                    jSONObjectO.put("bid_link", this.N.toString());
                }
                if (!TextUtils.isEmpty(this.bP)) {
                    jSONObjectO.put("bid_t_m", this.bP);
                }
            }
            d dVar = this.cE;
            if (dVar != null) {
                jSONObjectO.put("real_p", dVar.a());
                jSONObjectO.put("real_s", this.H);
                jSONObjectO.put("real_g", this.cE.b());
                jSONObjectO.put("real_t", this.cE.c());
            }
            int i24 = this.cq;
            if (i24 > 0) {
                jSONObjectO.put("ads_list_type", i24);
            }
            if (this.cV) {
                jSONObjectO.put(com.anythink.core.common.l.f.bh, 1);
            }
            int i25 = this.du;
            if (i25 > 0) {
                jSONObjectO.put("s_type", i25);
            }
            int i26 = this.dv;
            if (i26 > 0) {
                jSONObjectO.put("imp_type", i26);
            }
            jSONObjectO.put("network_pl_id", this.bQ);
            ATAdRequest aTAdRequest2 = this.dM;
            if (aTAdRequest2 != null) {
                jSONObjectO.put(com.anythink.core.common.l.f.bB, aTAdRequest2.getChannelSource());
            } else {
                jSONObjectO.put(com.anythink.core.common.l.f.bB, com.anythink.core.common.d.s.b().F());
            }
            int i27 = this.dS;
            if (i27 != -1) {
                jSONObjectO.put("f_device_pub", i27);
            }
            if (!TextUtils.isEmpty(this.dT)) {
                jSONObjectO.put("b_network_ids", this.dT);
            }
            charSequence = "2";
            try {
                try {
                    switch (i20) {
                        case 1:
                            str3 = "0";
                            r4 = 0;
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put("ad_reqt", this.cr);
                            jSONObjectO.put("unit_type", this.da);
                            jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                            jSONObjectO.put("req_start_t", this.bM);
                            f(jSONObjectO);
                            g(jSONObjectO);
                            e(jSONObjectO);
                            break;
                        case 2:
                            str3 = "0";
                            r4 = 0;
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("status", this.u);
                            jSONObjectO.put("flag", this.v);
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(ATAdConst.KEY.CP_LOAD_MODE, aI());
                            jSONObjectO.put("ft_t", this.by);
                            jSONObjectO.put("filled_t", this.bz);
                            if (this.cQ == 2) {
                                if (this.cq == 2) {
                                    jSONObjectO.put("filledtime", this.bN);
                                    jSONObjectO.put("data_ft", this.bN);
                                } else {
                                    jSONObjectO.put("filledtime", this.bx);
                                    jSONObjectO.put("data_ft", this.bx);
                                }
                            } else {
                                jSONObjectO.put("filledtime", this.bN);
                                jSONObjectO.put("data_ft", this.bx);
                            }
                            int i28 = this.cW;
                            if (i28 > 0) {
                                jSONObjectO.put("material_type", i28);
                            }
                            jSONObjectO.put("unit_type", this.da);
                            if (!TextUtils.isEmpty(this.ca)) {
                                jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                jSONObjectO.put("e_c_key_id", this.cd);
                                jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                            }
                            if (!TextUtils.isEmpty(this.cc)) {
                                jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                            }
                            g(jSONObjectO);
                            f(jSONObjectO);
                            e(jSONObjectO);
                            break;
                        case 3:
                            str3 = "0";
                            r4 = 0;
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("status", this.u);
                            jSONObjectO.put("flag", this.v);
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(ATAdConst.KEY.CP_LOAD_MODE, aI());
                            jSONObjectO.put("unit_type", this.da);
                            jSONObjectO.put("nw_err_c", this.ds);
                            jSONObjectO.put("report_t", this.dt);
                            g(jSONObjectO);
                            break;
                        case 4:
                            str6 = "0";
                            try {
                                jSONObjectO.put("ads", this.I);
                                jSONObjectO.put("ahs", this.J);
                                jSONObjectO.put("pds", this.K);
                                jSONObjectO.put("phs", this.L);
                                jSONObjectO.put("cl_imp", this.ci);
                                if (!TextUtils.isEmpty(this.cy)) {
                                    jSONObjectO.put(com.anythink.core.e.l.a.i, this.cy);
                                }
                                if (!TextUtils.isEmpty(this.cS)) {
                                    jSONObjectO.put("render_w_h", this.cS);
                                }
                                i18 = this.cZ;
                                if (i18 > 0) {
                                    jSONObjectO.put("offer_install", i18);
                                }
                                jSONObjectO.put("rotation_order", this.dF);
                                jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                                str6 = str6;
                                if (this.r == 22) {
                                    jSONObjectO.put("bd_imp_type", this.dL);
                                    str6 = str6;
                                }
                                jSONObjectO.put("unit_id", this.bO);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.bk);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put("aprn_auto_req", O());
                                jSONObjectO.put("bidtype", this.A);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                                jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                                jSONObjectO.put("myoffer_showtype", this.E);
                                if (!TextUtils.isEmpty(this.H)) {
                                    jSONObjectO.put("scenario", this.H);
                                }
                                jSONObjectO.put("ads", this.I);
                                jSONObjectO.put("ahs", this.J);
                                jSONObjectO.put("pds", this.K);
                                jSONObjectO.put("phs", this.L);
                                i20 = i2;
                                if (i20 == 6) {
                                    jSONObjectO.put("cl_s_type", this.cv);
                                    jSONObjectO.put("cl_area", this.cw);
                                    if ("3".equals(this.aZ) && this.cs == Integer.parseInt(str6) && (i17 = this.cK) > 0) {
                                        jSONObjectO.put("bn_click_area", i17);
                                    }
                                    if (this.dO && !this.dN) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                try {
                                    i8 = this.cz;
                                    if (i8 > 0) {
                                        jSONObjectO.put("render_type_video", i8);
                                    }
                                    i9 = this.cP;
                                    if (i9 > 0) {
                                        jSONObjectO.put("close_button_m", i9);
                                    }
                                    d(jSONObjectO);
                                    jSONObjectO.put("unit_type", this.da);
                                    i10 = this.cW;
                                    if (i10 > 0) {
                                        jSONObjectO.put("material_type", i10);
                                    }
                                    f(jSONObjectO);
                                    jSONObjectO.put("show_spec_nw_ad", this.dQ);
                                    jSONObjectO.put("show_custom_ext", this.dk);
                                    jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                                    if (!TextUtils.isEmpty(this.ca)) {
                                        jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                        jSONObjectO.put("e_c_key_id", this.cd);
                                        jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                                    }
                                    if (!TextUtils.isEmpty(this.cc)) {
                                        jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                                    }
                                    i11 = this.dq;
                                    if (i11 > 0) {
                                        jSONObjectO.put("cls_style", i11);
                                    }
                                    i12 = this.dp;
                                    if (i12 > 0) {
                                        jSONObjectO.put("iv_template_id", i12);
                                    }
                                    i13 = this.dr;
                                    if (i13 >= -1) {
                                        jSONObjectO.put("adx_mix_type", i13);
                                    }
                                    i14 = this.dC;
                                    if (i14 != 0) {
                                        jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                                    }
                                    g(jSONObjectO);
                                    jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                                    jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                                    jSONObjectO.put("rotation_order", this.dF);
                                    jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                                    jSONObjectO.put("new_req_id", this.z);
                                    jSONObjectO.put("req_id_match", 0);
                                    if (this.z == null && this.aY == null) {
                                        jSONObjectO.put("req_id_match", 0);
                                    }
                                    if (this.z == null && this.aY != null && this.z.equals(this.aY)) {
                                        z = false;
                                        jSONObjectO.put("req_id_match", 0);
                                    } else {
                                        z = false;
                                        jSONObjectO.put("req_id_match", 1);
                                    }
                                    if (this.cL == 2) {
                                        i15 = 2;
                                    } else {
                                        i15 = 1;
                                    }
                                    jSONObjectO.put("click_type", i15);
                                    if (i20 == 6) {
                                        if (this.cN == 2) {
                                            i16 = 2;
                                        } else {
                                            i16 = 1;
                                        }
                                        jSONObjectO.put("shk_click_type", i16);
                                    }
                                    e(jSONObjectO);
                                    r4 = z;
                                    str3 = str6;
                                } catch (Exception e2) {
                                    e = e2;
                                    str = str6;
                                    str14 = null;
                                    exc = e;
                                    r3 = str14;
                                    str2 = str;
                                    exc.printStackTrace();
                                    r4 = r3;
                                    str3 = str2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                i20 = i2;
                                str = str6;
                                str14 = null;
                                exc = e;
                                r3 = str14;
                                str2 = str;
                                exc.printStackTrace();
                                r4 = r3;
                                str3 = str2;
                                if (TextUtils.equals(this.aZ, charSequence)) {
                                    if (this.cs != 0) {
                                        jSONObjectO.put(com.anythink.core.e.l.a.aq, this.cM);
                                    } else {
                                        jSONObjectO.put(com.anythink.core.e.l.a.aq, this.cM);
                                    }
                                    map2 = this.cD;
                                    if (map2 != null) {
                                        obj5 = map2.get(ATAdConst.KEY.AD_WIDTH);
                                        obj6 = this.cD.get(ATAdConst.KEY.AD_HEIGHT);
                                        if (obj5 != null) {
                                            try {
                                                jSONObjectO.put("bn_width", Integer.parseInt(obj5.toString()));
                                                break;
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        if (obj6 != null) {
                                            try {
                                                jSONObjectO.put("bn_height", Integer.parseInt(obj6.toString()));
                                                break;
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    }
                                    if (i20 == 6) {
                                        jSONObjectO.put("bn_click_area", i5);
                                    }
                                    break;
                                }
                                dVarA = com.anythink.core.common.t.d.a();
                                if (i20 == 4) {
                                    if (i20 == 6) {
                                        jB2 = com.anythink.core.common.t.d.b((n) this);
                                        if (jB2 > 0) {
                                            jSONObjectO.put("s_c_interval", jB2);
                                        }
                                    }
                                    str4 = str3;
                                } else {
                                    str4 = str3;
                                    try {
                                        if (!str4.equals(this.aZ)) {
                                            jA = dVarA.a((n) this);
                                            if (jA > 0) {
                                                jSONObjectO.put("pl_show_interval", jA);
                                            }
                                            jB = dVarA.b();
                                            if (jB > 0) {
                                                jSONObjectO.put("bidads_show_interval", jB);
                                            }
                                        }
                                        break;
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (TextUtils.equals(this.aZ, str4)) {
                                    i3 = this.dn;
                                    if (i3 > 0) {
                                        jSONObjectO.put("render_type", i3);
                                    }
                                    i4 = this.f0do;
                                    if (i4 > 0) {
                                        jSONObjectO.put("template_type", i4);
                                    }
                                    break;
                                }
                                aTAdRequest = this.dM;
                                if (aTAdRequest != null) {
                                    preLoadInfo = aTAdRequest.getPreLoadInfo();
                                } else {
                                    preLoadInfo = null;
                                }
                                if (preLoadInfo != null) {
                                    try {
                                        placementId = preLoadInfo.getPlacementId();
                                        psId = preLoadInfo.getPsId();
                                        requestId = preLoadInfo.getRequestId();
                                        mpc = preLoadInfo.getMpc();
                                        int segId = preLoadInfo.getSegId();
                                        int abId = preLoadInfo.getAbId();
                                        int abItemId = preLoadInfo.getAbItemId();
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
                                        mgComparedResult = preLoadInfo.getMgComparedResult();
                                        if (mgComparedResult != null) {
                                            zIsCompared = mgComparedResult.isCompared();
                                        } else {
                                            zIsCompared = r4 == true ? 1 : 0;
                                        }
                                        if (i20 == 4) {
                                        }
                                        if (r5 != 0) {
                                            r5 = r4;
                                            preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                                            if (preLoadCallbackRegister != null) {
                                                mgAdInfo = preLoadCallbackRegister.getMgAdInfo();
                                            } else {
                                                mgAdInfo = null;
                                            }
                                            if (mgAdInfo != null) {
                                                uSDEcpm = mgAdInfo.getUSDEcpm();
                                            } else {
                                                uSDEcpm = 0.0d;
                                            }
                                            if (uSDEcpm > 0.0d) {
                                                jSONObjectO.put("mmed_price", String.valueOf(uSDEcpm));
                                            }
                                        }
                                        if (mpc != null) {
                                            jSONObjectO.put("mmed_m_p_c", mpc);
                                        }
                                        jSONObjectO.put("mmed_seg_id", segId);
                                        jSONObjectO.put("mmed_ab_id", abId);
                                        jSONObjectO.put("mmed_ab_item_id", abItemId);
                                        break;
                                    } catch (Throwable unused5) {
                                    }
                                }
                                if (this.r == 8) {
                                    try {
                                        map = this.cD;
                                        if (map != null) {
                                            jSONObject = new JSONObject();
                                            obj = this.cD.get(GDTATConst.EXTRA_DATA.LNG);
                                            if (obj instanceof String) {
                                                jSONObject.put(GDTATConst.EXTRA_DATA.LNG, obj);
                                            }
                                            obj2 = this.cD.get("lat");
                                            if (obj2 instanceof String) {
                                                jSONObject.put("lat", obj2);
                                            }
                                            obj3 = this.cD.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                                            if (obj3 instanceof String) {
                                                jSONObject.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj3);
                                            }
                                            obj4 = this.cD.get(GDTATConst.EXTRA_DATA.WXOPENID);
                                            if (obj4 instanceof String) {
                                                jSONObject.put(GDTATConst.EXTRA_DATA.WXOPENID, obj4);
                                            }
                                            if (jSONObject.length() > 0) {
                                                jSONObjectO.put("tx_d", jSONObject);
                                            }
                                        }
                                        break;
                                    } catch (Exception unused6) {
                                    }
                                }
                                if (jSONObjectO != null) {
                                    try {
                                        if (this.dN) {
                                            this.dO = true;
                                            jSONObjectO.put("type", 28);
                                        }
                                        break;
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (jSONObjectO != null) {
                                    if (i20 != 1) {
                                        try {
                                            jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                                            jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                                            jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                                            jSONObjectO.put("anr_hit_type", this.ea);
                                            break;
                                        } catch (Throwable unused8) {
                                        }
                                    } else {
                                        jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                                        jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                                        jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                                        jSONObjectO.put("anr_hit_type", this.ea);
                                        break;
                                    }
                                }
                                return jSONObjectO;
                            }
                            break;
                        case 5:
                        case 14:
                        case 17:
                        default:
                            str13 = "0";
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 6:
                            str6 = "0";
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            c(jSONObjectO);
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            jSONObjectO.put("myoffer_showtype", this.E);
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            i20 = i2;
                            if (i20 == 6) {
                                jSONObjectO.put("cl_s_type", this.cv);
                                jSONObjectO.put("cl_area", this.cw);
                                if ("3".equals(this.aZ)) {
                                    jSONObjectO.put("bn_click_area", i17);
                                }
                                if (this.dO) {
                                    jSONObjectO.put("tk_x_cl_sent", "1");
                                }
                            }
                            i8 = this.cz;
                            if (i8 > 0) {
                                jSONObjectO.put("render_type_video", i8);
                            }
                            i9 = this.cP;
                            if (i9 > 0) {
                                jSONObjectO.put("close_button_m", i9);
                            }
                            d(jSONObjectO);
                            jSONObjectO.put("unit_type", this.da);
                            i10 = this.cW;
                            if (i10 > 0) {
                                jSONObjectO.put("material_type", i10);
                            }
                            f(jSONObjectO);
                            jSONObjectO.put("show_spec_nw_ad", this.dQ);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                            if (!TextUtils.isEmpty(this.ca)) {
                                jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                jSONObjectO.put("e_c_key_id", this.cd);
                                jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                            }
                            if (!TextUtils.isEmpty(this.cc)) {
                                jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                            }
                            i11 = this.dq;
                            if (i11 > 0) {
                                jSONObjectO.put("cls_style", i11);
                            }
                            i12 = this.dp;
                            if (i12 > 0) {
                                jSONObjectO.put("iv_template_id", i12);
                            }
                            i13 = this.dr;
                            if (i13 >= -1) {
                                jSONObjectO.put("adx_mix_type", i13);
                            }
                            i14 = this.dC;
                            if (i14 != 0) {
                                jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                            }
                            g(jSONObjectO);
                            jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                            jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            jSONObjectO.put("new_req_id", this.z);
                            jSONObjectO.put("req_id_match", 0);
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 0);
                            }
                            if (this.z == null) {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            } else {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            }
                            if (this.cL == 2) {
                                i15 = 2;
                            } else {
                                i15 = 1;
                            }
                            jSONObjectO.put("click_type", i15);
                            if (i20 == 6) {
                                if (this.cN == 2) {
                                    i16 = 2;
                                } else {
                                    i16 = 1;
                                }
                                jSONObjectO.put("shk_click_type", i16);
                            }
                            e(jSONObjectO);
                            r4 = z;
                            str3 = str6;
                            break;
                        case 7:
                            str7 = "0";
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put(NotificationCompat.CATEGORY_PROGRESS, this.w);
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put("unit_type", this.da);
                            f(jSONObjectO);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 8:
                        case 9:
                            str7 = "0";
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            c(jSONObjectO);
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            d(jSONObjectO);
                            jSONObjectO.put("unit_type", this.da);
                            f(jSONObjectO);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            jSONObjectO.put("network_pl_id", this.bQ);
                            g(jSONObjectO);
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 10:
                            str7 = "0";
                            jSONObjectO.put("isload", this.O ? 1 : 0);
                            jSONObjectO.put(MediationConstant.KEY_REASON, this.P);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("req_par", this.ct);
                            jSONObjectO.put("req_par_num", this.cu);
                            jSONObjectO.put("load_start_t", this.bA);
                            long j2 = this.bB;
                            if (j2 > 0) {
                                jSONObjectO.put("pre_st_t", j2);
                            }
                            jSONObjectO.put("req_st_t", this.bC);
                            jSONObjectO.put("st_succ_t", this.bD);
                            jSONObjectO.put("dec_st_t", this.bE);
                            jSONObjectO.put("filter_st_start_t", this.bF);
                            jSONObjectO.put("filter_st_end_t", this.bG);
                            jSONObjectO.put("adx_cache_t", this.bH);
                            jSONObjectO.put("cache_st_type", this.bK);
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 11:
                            str7 = "0";
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("bidrequesttime", this.R);
                            jSONObjectO.put("bidresponselist", TextUtils.isEmpty(this.W) ? "[]" : new JSONArray(this.W));
                            jSONObjectO.put("bid_req_start_t", this.T);
                            jSONObjectO.put("bid_req_api_ts", this.V);
                            if (this.cQ == 2) {
                                jSONObjectO.put("bidresponsetime", this.S);
                                jSONObjectO.put("data_bidresponsetime", this.S);
                                jSONObjectO.put("ft_t", this.by);
                                jSONObjectO.put("filled_t", this.by);
                            } else {
                                jSONObjectO.put("data_bidresponsetime", this.dR);
                                jSONObjectO.put("bidresponsetime", this.S);
                                jSONObjectO.put("ft_t", this.by);
                                jSONObjectO.put("filled_t", this.U);
                            }
                            g(jSONObjectO);
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 12:
                            str7 = "0";
                            jSONObjectO.put("loadtime", this.bN);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put("first_hb_fill_t", this.bI);
                            jSONObjectO.put("first_nor_fill_t", this.bJ);
                            jSONObjectO.put("wf_load_start_t", this.bz - this.bN);
                            jSONObjectO.put("load_t", this.bz);
                            jSONObjectO.put("loaded_ad_type", this.bL);
                            int i29 = this.P;
                            if (i29 == 5 || i29 == 13) {
                                jSONObjectO.put(MediationConstant.KEY_REASON, i29);
                            } else {
                                switch (i29) {
                                    case 9:
                                    case 10:
                                    case 11:
                                        jSONObjectO.put(MediationConstant.KEY_REASON, i29);
                                }
                            }
                            jSONObjectO.put("req_par", this.ct);
                            jSONObjectO.put("req_par_num", this.cu);
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 13:
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            afVar = this.Q;
                            if (afVar == null) {
                                string = "[]";
                            } else {
                                string = afVar.toString();
                            }
                            jSONObjectO.put("as_result", string);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("new_req_id", this.z);
                            boolean z2 = false;
                            try {
                                jSONObjectO.put("req_id_match", 0);
                                if (this.z == null && this.aY == null) {
                                    jSONObjectO.put("req_id_match", 0);
                                }
                                if (this.z == null && this.aY != null) {
                                    if (this.z.equals(this.aY)) {
                                        z2 = false;
                                        jSONObjectO.put("req_id_match", 0);
                                    } else {
                                        jSONObjectO.put("req_id_match", 1);
                                    }
                                } else {
                                    jSONObjectO.put("req_id_match", 1);
                                }
                                jSONObjectO.put("myoffer_showtype", this.E);
                                if (!TextUtils.isEmpty(this.H)) {
                                    jSONObjectO.put("scenario", this.H);
                                }
                                jSONObjectO.put("ads", this.I);
                                jSONObjectO.put("ahs", this.J);
                                jSONObjectO.put("pds", this.K);
                                jSONObjectO.put("phs", this.L);
                                i6 = this.P;
                                if (i6 != 12) {
                                    jSONObjectO.put(MediationConstant.KEY_REASON, i6);
                                }
                                jSONObjectO.put("unit_type", this.da);
                                f(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dQ);
                                jSONObjectO.put("show_custom_ext", this.dk);
                                i7 = this.dC;
                                if (i7 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.bb, i7);
                                }
                                jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                                jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                                if (com.anythink.core.common.d.s.b().W()) {
                                    charSequence2 = "1";
                                } else {
                                    charSequence2 = charSequence;
                                }
                                jSONObjectO.put("is_show_fg", charSequence2);
                                g(jSONObjectO);
                                e(jSONObjectO);
                                str7 = str14;
                                i20 = i2;
                                str13 = str7;
                                r4 = 0;
                                str3 = str13;
                            } catch (Exception e4) {
                                exc = e4;
                                r3 = z2;
                                i20 = i2;
                                str2 = str14;
                                exc.printStackTrace();
                                r4 = r3;
                                str3 = str2;
                            }
                            break;
                        case 15:
                            str7 = "0";
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("bidresponselist", TextUtils.isEmpty(this.W) ? "[]" : new JSONArray(this.W));
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 16:
                            jSONObjectO.put("ad_ch_st", this.co);
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("bidtype", this.A);
                            jSONObjectO.put("bidprice", String.valueOf(this.B));
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            afVar = this.Q;
                            if (afVar == null) {
                                string = "[]";
                            } else {
                                string = afVar.toString();
                            }
                            jSONObjectO.put("as_result", string);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("new_req_id", this.z);
                            boolean z3 = false;
                            jSONObjectO.put("req_id_match", 0);
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 0);
                            }
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 1);
                            } else {
                                jSONObjectO.put("req_id_match", 1);
                            }
                            jSONObjectO.put("myoffer_showtype", this.E);
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            i6 = this.P;
                            if (i6 != 12) {
                                jSONObjectO.put(MediationConstant.KEY_REASON, i6);
                            }
                            jSONObjectO.put("unit_type", this.da);
                            f(jSONObjectO);
                            jSONObjectO.put("show_spec_nw_ad", this.dQ);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            i7 = this.dC;
                            if (i7 != 0) {
                                jSONObjectO.put(com.anythink.core.common.k.bb, i7);
                            }
                            jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            if (com.anythink.core.common.d.s.b().W()) {
                                charSequence2 = "1";
                            } else {
                                charSequence2 = charSequence;
                            }
                            jSONObjectO.put("is_show_fg", charSequence2);
                            g(jSONObjectO);
                            e(jSONObjectO);
                            str7 = str14;
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 18:
                        case 20:
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("app_nm", this.ck);
                            str7 = str14;
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 19:
                            jSONObjectO.put("dl_ts", this.cl);
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("app_nm", this.ck);
                            str7 = str14;
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 21:
                            str7 = "0";
                            i20 = i2;
                            str13 = str7;
                            r4 = 0;
                            str3 = str13;
                            break;
                        case 22:
                            str8 = "0";
                            d3 = this.dg;
                            if (d3 != -1.0d) {
                                jSONObjectO.put("mmb_secprice", d3);
                            }
                            str11 = this.dh;
                            str9 = str8;
                            if (str11 != null) {
                                jSONObjectO.put("mmb_secBidder", str11);
                                str9 = str8;
                            }
                            d2 = this.de;
                            if (d2 != -1.0d) {
                                jSONObjectO.put("mmb_firstPrice", d2);
                            }
                            str10 = this.df;
                            if (str10 != null) {
                                jSONObjectO.put("mmb_firstBidder", str10);
                            }
                            i19 = this.di;
                            if (i19 != -1) {
                                jSONObjectO.put("mmb_lossReason", i19);
                            }
                            jSONObjectO.put("mmb_ilrd", this.dj);
                            str6 = str9;
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            jSONObjectO.put("cl_imp", this.ci);
                            if (!TextUtils.isEmpty(this.cy)) {
                                jSONObjectO.put(com.anythink.core.e.l.a.i, this.cy);
                            }
                            if (!TextUtils.isEmpty(this.cS)) {
                                jSONObjectO.put("render_w_h", this.cS);
                            }
                            i18 = this.cZ;
                            if (i18 > 0) {
                                jSONObjectO.put("offer_install", i18);
                            }
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            str6 = str6;
                            if (this.r == 22) {
                                jSONObjectO.put("bd_imp_type", this.dL);
                                str6 = str6;
                            }
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            c(jSONObjectO);
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            jSONObjectO.put("myoffer_showtype", this.E);
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            i20 = i2;
                            if (i20 == 6) {
                                jSONObjectO.put("cl_s_type", this.cv);
                                jSONObjectO.put("cl_area", this.cw);
                                if ("3".equals(this.aZ)) {
                                    jSONObjectO.put("bn_click_area", i17);
                                }
                                if (this.dO) {
                                    jSONObjectO.put("tk_x_cl_sent", "1");
                                }
                            }
                            i8 = this.cz;
                            if (i8 > 0) {
                                jSONObjectO.put("render_type_video", i8);
                            }
                            i9 = this.cP;
                            if (i9 > 0) {
                                jSONObjectO.put("close_button_m", i9);
                            }
                            d(jSONObjectO);
                            jSONObjectO.put("unit_type", this.da);
                            i10 = this.cW;
                            if (i10 > 0) {
                                jSONObjectO.put("material_type", i10);
                            }
                            f(jSONObjectO);
                            jSONObjectO.put("show_spec_nw_ad", this.dQ);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                            if (!TextUtils.isEmpty(this.ca)) {
                                jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                jSONObjectO.put("e_c_key_id", this.cd);
                                jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                            }
                            if (!TextUtils.isEmpty(this.cc)) {
                                jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                            }
                            i11 = this.dq;
                            if (i11 > 0) {
                                jSONObjectO.put("cls_style", i11);
                            }
                            i12 = this.dp;
                            if (i12 > 0) {
                                jSONObjectO.put("iv_template_id", i12);
                            }
                            i13 = this.dr;
                            if (i13 >= -1) {
                                jSONObjectO.put("adx_mix_type", i13);
                            }
                            i14 = this.dC;
                            if (i14 != 0) {
                                jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                            }
                            g(jSONObjectO);
                            jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                            jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            jSONObjectO.put("new_req_id", this.z);
                            jSONObjectO.put("req_id_match", 0);
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 0);
                            }
                            if (this.z == null) {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            } else {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            }
                            if (this.cL == 2) {
                                i15 = 2;
                            } else {
                                i15 = 1;
                            }
                            jSONObjectO.put("click_type", i15);
                            if (i20 == 6) {
                                if (this.cN == 2) {
                                    i16 = 2;
                                } else {
                                    i16 = 1;
                                }
                                jSONObjectO.put("shk_click_type", i16);
                            }
                            e(jSONObjectO);
                            r4 = z;
                            str3 = str6;
                            break;
                        case 23:
                            str9 = "0";
                            d2 = this.de;
                            if (d2 != -1.0d) {
                                jSONObjectO.put("mmb_firstPrice", d2);
                            }
                            str10 = this.df;
                            if (str10 != null) {
                                jSONObjectO.put("mmb_firstBidder", str10);
                            }
                            i19 = this.di;
                            if (i19 != -1) {
                                jSONObjectO.put("mmb_lossReason", i19);
                            }
                            jSONObjectO.put("mmb_ilrd", this.dj);
                            str6 = str9;
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            jSONObjectO.put("cl_imp", this.ci);
                            if (!TextUtils.isEmpty(this.cy)) {
                                jSONObjectO.put(com.anythink.core.e.l.a.i, this.cy);
                            }
                            if (!TextUtils.isEmpty(this.cS)) {
                                jSONObjectO.put("render_w_h", this.cS);
                            }
                            i18 = this.cZ;
                            if (i18 > 0) {
                                jSONObjectO.put("offer_install", i18);
                            }
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            str6 = str6;
                            if (this.r == 22) {
                                jSONObjectO.put("bd_imp_type", this.dL);
                                str6 = str6;
                            }
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            c(jSONObjectO);
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            jSONObjectO.put("myoffer_showtype", this.E);
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            i20 = i2;
                            if (i20 == 6) {
                                jSONObjectO.put("cl_s_type", this.cv);
                                jSONObjectO.put("cl_area", this.cw);
                                if ("3".equals(this.aZ)) {
                                    jSONObjectO.put("bn_click_area", i17);
                                }
                                if (this.dO) {
                                    jSONObjectO.put("tk_x_cl_sent", "1");
                                }
                            }
                            i8 = this.cz;
                            if (i8 > 0) {
                                jSONObjectO.put("render_type_video", i8);
                            }
                            i9 = this.cP;
                            if (i9 > 0) {
                                jSONObjectO.put("close_button_m", i9);
                            }
                            d(jSONObjectO);
                            jSONObjectO.put("unit_type", this.da);
                            i10 = this.cW;
                            if (i10 > 0) {
                                jSONObjectO.put("material_type", i10);
                            }
                            f(jSONObjectO);
                            jSONObjectO.put("show_spec_nw_ad", this.dQ);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                            if (!TextUtils.isEmpty(this.ca)) {
                                jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                jSONObjectO.put("e_c_key_id", this.cd);
                                jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                            }
                            if (!TextUtils.isEmpty(this.cc)) {
                                jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                            }
                            i11 = this.dq;
                            if (i11 > 0) {
                                jSONObjectO.put("cls_style", i11);
                            }
                            i12 = this.dp;
                            if (i12 > 0) {
                                jSONObjectO.put("iv_template_id", i12);
                            }
                            i13 = this.dr;
                            if (i13 >= -1) {
                                jSONObjectO.put("adx_mix_type", i13);
                            }
                            i14 = this.dC;
                            if (i14 != 0) {
                                jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                            }
                            g(jSONObjectO);
                            jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                            jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            jSONObjectO.put("new_req_id", this.z);
                            jSONObjectO.put("req_id_match", 0);
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 0);
                            }
                            if (this.z == null) {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            } else {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            }
                            if (this.cL == 2) {
                                i15 = 2;
                            } else {
                                i15 = 1;
                            }
                            jSONObjectO.put("click_type", i15);
                            if (i20 == 6) {
                                if (this.cN == 2) {
                                    i16 = 2;
                                } else {
                                    i16 = 1;
                                }
                                jSONObjectO.put("shk_click_type", i16);
                            }
                            e(jSONObjectO);
                            r4 = z;
                            str3 = str6;
                            break;
                        case 24:
                            try {
                                ab abVar = this.dy;
                                if (abVar != null) {
                                    str6 = "0";
                                    try {
                                        jSONObjectO.put("notice", abVar.a());
                                        str12 = str6;
                                    } catch (Exception e5) {
                                        e = e5;
                                        exc = e;
                                        str5 = str6;
                                        r3 = 0;
                                        str2 = str5;
                                        exc.printStackTrace();
                                        r4 = r3;
                                        str3 = str2;
                                    }
                                } else {
                                    str12 = "0";
                                }
                                beVar = this.dz;
                                str8 = str12;
                                if (beVar != null) {
                                    jSONObjectO.put("reward", beVar.a());
                                    str8 = str12;
                                }
                                d3 = this.dg;
                                if (d3 != -1.0d) {
                                    jSONObjectO.put("mmb_secprice", d3);
                                }
                                str11 = this.dh;
                                str9 = str8;
                                if (str11 != null) {
                                    jSONObjectO.put("mmb_secBidder", str11);
                                    str9 = str8;
                                }
                                d2 = this.de;
                                if (d2 != -1.0d) {
                                    jSONObjectO.put("mmb_firstPrice", d2);
                                }
                                str10 = this.df;
                                if (str10 != null) {
                                    jSONObjectO.put("mmb_firstBidder", str10);
                                }
                                i19 = this.di;
                                if (i19 != -1) {
                                    jSONObjectO.put("mmb_lossReason", i19);
                                }
                                jSONObjectO.put("mmb_ilrd", this.dj);
                                str6 = str9;
                                jSONObjectO.put("ads", this.I);
                                jSONObjectO.put("ahs", this.J);
                                jSONObjectO.put("pds", this.K);
                                jSONObjectO.put("phs", this.L);
                                jSONObjectO.put("cl_imp", this.ci);
                                if (!TextUtils.isEmpty(this.cy)) {
                                    jSONObjectO.put(com.anythink.core.e.l.a.i, this.cy);
                                }
                                if (!TextUtils.isEmpty(this.cS)) {
                                    jSONObjectO.put("render_w_h", this.cS);
                                }
                                i18 = this.cZ;
                                if (i18 > 0) {
                                    jSONObjectO.put("offer_install", i18);
                                }
                                jSONObjectO.put("rotation_order", this.dF);
                                jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                                str6 = str6;
                                if (this.r == 22) {
                                    jSONObjectO.put("bd_imp_type", this.dL);
                                    str6 = str6;
                                }
                                jSONObjectO.put("unit_id", this.bO);
                                jSONObjectO.put("nw_firm_id", this.r);
                                jSONObjectO.put("gro_id", this.bk);
                                jSONObjectO.put("auto_req", this.t);
                                jSONObjectO.put("aprn_auto_req", O());
                                jSONObjectO.put("bidtype", this.A);
                                c(jSONObjectO);
                                jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                                jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                                jSONObjectO.put("myoffer_showtype", this.E);
                                if (!TextUtils.isEmpty(this.H)) {
                                    jSONObjectO.put("scenario", this.H);
                                }
                                jSONObjectO.put("ads", this.I);
                                jSONObjectO.put("ahs", this.J);
                                jSONObjectO.put("pds", this.K);
                                jSONObjectO.put("phs", this.L);
                                i20 = i2;
                                if (i20 == 6) {
                                    jSONObjectO.put("cl_s_type", this.cv);
                                    jSONObjectO.put("cl_area", this.cw);
                                    if ("3".equals(this.aZ)) {
                                        jSONObjectO.put("bn_click_area", i17);
                                    }
                                    if (this.dO) {
                                        jSONObjectO.put("tk_x_cl_sent", "1");
                                    }
                                }
                                i8 = this.cz;
                                if (i8 > 0) {
                                    jSONObjectO.put("render_type_video", i8);
                                }
                                i9 = this.cP;
                                if (i9 > 0) {
                                    jSONObjectO.put("close_button_m", i9);
                                }
                                d(jSONObjectO);
                                jSONObjectO.put("unit_type", this.da);
                                i10 = this.cW;
                                if (i10 > 0) {
                                    jSONObjectO.put("material_type", i10);
                                }
                                f(jSONObjectO);
                                jSONObjectO.put("show_spec_nw_ad", this.dQ);
                                jSONObjectO.put("show_custom_ext", this.dk);
                                jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                                if (!TextUtils.isEmpty(this.ca)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                    jSONObjectO.put("e_c_key_id", this.cd);
                                    jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                                }
                                if (!TextUtils.isEmpty(this.cc)) {
                                    jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                                }
                                i11 = this.dq;
                                if (i11 > 0) {
                                    jSONObjectO.put("cls_style", i11);
                                }
                                i12 = this.dp;
                                if (i12 > 0) {
                                    jSONObjectO.put("iv_template_id", i12);
                                }
                                i13 = this.dr;
                                if (i13 >= -1) {
                                    jSONObjectO.put("adx_mix_type", i13);
                                }
                                i14 = this.dC;
                                if (i14 != 0) {
                                    jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                                }
                                g(jSONObjectO);
                                jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                                jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                                jSONObjectO.put("rotation_order", this.dF);
                                jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                                jSONObjectO.put("new_req_id", this.z);
                                jSONObjectO.put("req_id_match", 0);
                                if (this.z == null) {
                                    jSONObjectO.put("req_id_match", 0);
                                }
                                if (this.z == null) {
                                    z = false;
                                    jSONObjectO.put("req_id_match", 1);
                                } else {
                                    z = false;
                                    jSONObjectO.put("req_id_match", 1);
                                }
                                if (this.cL == 2) {
                                    i15 = 2;
                                } else {
                                    i15 = 1;
                                }
                                jSONObjectO.put("click_type", i15);
                                if (i20 == 6) {
                                    if (this.cN == 2) {
                                        i16 = 2;
                                    } else {
                                        i16 = 1;
                                    }
                                    jSONObjectO.put("shk_click_type", i16);
                                }
                                e(jSONObjectO);
                                r4 = z;
                                str3 = str6;
                            } catch (Exception e6) {
                                e = e6;
                                str6 = "0";
                                exc = e;
                                str5 = str6;
                                r3 = 0;
                                str2 = str5;
                                exc.printStackTrace();
                                r4 = r3;
                                str3 = str2;
                            }
                            break;
                        case 25:
                            str12 = "0";
                            beVar = this.dz;
                            str8 = str12;
                            if (beVar != null) {
                                jSONObjectO.put("reward", beVar.a());
                                str8 = str12;
                            }
                            d3 = this.dg;
                            if (d3 != -1.0d) {
                                jSONObjectO.put("mmb_secprice", d3);
                            }
                            str11 = this.dh;
                            str9 = str8;
                            if (str11 != null) {
                                jSONObjectO.put("mmb_secBidder", str11);
                                str9 = str8;
                            }
                            d2 = this.de;
                            if (d2 != -1.0d) {
                                jSONObjectO.put("mmb_firstPrice", d2);
                            }
                            str10 = this.df;
                            if (str10 != null) {
                                jSONObjectO.put("mmb_firstBidder", str10);
                            }
                            i19 = this.di;
                            if (i19 != -1) {
                                jSONObjectO.put("mmb_lossReason", i19);
                            }
                            jSONObjectO.put("mmb_ilrd", this.dj);
                            str6 = str9;
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            jSONObjectO.put("cl_imp", this.ci);
                            if (!TextUtils.isEmpty(this.cy)) {
                                jSONObjectO.put(com.anythink.core.e.l.a.i, this.cy);
                            }
                            if (!TextUtils.isEmpty(this.cS)) {
                                jSONObjectO.put("render_w_h", this.cS);
                            }
                            i18 = this.cZ;
                            if (i18 > 0) {
                                jSONObjectO.put("offer_install", i18);
                            }
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            str6 = str6;
                            if (this.r == 22) {
                                jSONObjectO.put("bd_imp_type", this.dL);
                                str6 = str6;
                            }
                            jSONObjectO.put("unit_id", this.bO);
                            jSONObjectO.put("nw_firm_id", this.r);
                            jSONObjectO.put("gro_id", this.bk);
                            jSONObjectO.put("auto_req", this.t);
                            jSONObjectO.put("aprn_auto_req", O());
                            jSONObjectO.put("bidtype", this.A);
                            c(jSONObjectO);
                            jSONObjectO.put("bidprice_cny", String.valueOf(this.C));
                            jSONObjectO.put(com.anythink.core.common.k.aq, String.valueOf(this.M));
                            jSONObjectO.put("myoffer_showtype", this.E);
                            if (!TextUtils.isEmpty(this.H)) {
                                jSONObjectO.put("scenario", this.H);
                            }
                            jSONObjectO.put("ads", this.I);
                            jSONObjectO.put("ahs", this.J);
                            jSONObjectO.put("pds", this.K);
                            jSONObjectO.put("phs", this.L);
                            i20 = i2;
                            if (i20 == 6) {
                                jSONObjectO.put("cl_s_type", this.cv);
                                jSONObjectO.put("cl_area", this.cw);
                                if ("3".equals(this.aZ)) {
                                    jSONObjectO.put("bn_click_area", i17);
                                }
                                if (this.dO) {
                                    jSONObjectO.put("tk_x_cl_sent", "1");
                                }
                            }
                            i8 = this.cz;
                            if (i8 > 0) {
                                jSONObjectO.put("render_type_video", i8);
                            }
                            i9 = this.cP;
                            if (i9 > 0) {
                                jSONObjectO.put("close_button_m", i9);
                            }
                            d(jSONObjectO);
                            jSONObjectO.put("unit_type", this.da);
                            i10 = this.cW;
                            if (i10 > 0) {
                                jSONObjectO.put("material_type", i10);
                            }
                            f(jSONObjectO);
                            jSONObjectO.put("show_spec_nw_ad", this.dQ);
                            jSONObjectO.put("show_custom_ext", this.dk);
                            jSONObjectO.put("nv_tmpl_id", String.valueOf(this.dl));
                            if (!TextUtils.isEmpty(this.ca)) {
                                jSONObjectO.put(com.anythink.core.common.k.aU, this.ca);
                                jSONObjectO.put("e_c_key_id", this.cd);
                                jSONObjectO.put(com.anythink.core.e.l.a.aA, this.ce);
                            }
                            if (!TextUtils.isEmpty(this.cc)) {
                                jSONObjectO.put(com.anythink.core.common.k.aV, this.cc);
                            }
                            i11 = this.dq;
                            if (i11 > 0) {
                                jSONObjectO.put("cls_style", i11);
                            }
                            i12 = this.dp;
                            if (i12 > 0) {
                                jSONObjectO.put("iv_template_id", i12);
                            }
                            i13 = this.dr;
                            if (i13 >= -1) {
                                jSONObjectO.put("adx_mix_type", i13);
                            }
                            i14 = this.dC;
                            if (i14 != 0) {
                                jSONObjectO.put(com.anythink.core.common.k.bb, i14);
                            }
                            g(jSONObjectO);
                            jSONObjectO.put(com.anythink.core.common.k.bk, this.dE);
                            jSONObjectO.put(com.anythink.core.common.k.bl, this.dD);
                            jSONObjectO.put("rotation_order", this.dF);
                            jSONObjectO.put(com.anythink.core.e.l.a.aO, this.dG);
                            jSONObjectO.put("new_req_id", this.z);
                            jSONObjectO.put("req_id_match", 0);
                            if (this.z == null) {
                                jSONObjectO.put("req_id_match", 0);
                            }
                            if (this.z == null) {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            } else {
                                z = false;
                                jSONObjectO.put("req_id_match", 1);
                            }
                            if (this.cL == 2) {
                                i15 = 2;
                            } else {
                                i15 = 1;
                            }
                            jSONObjectO.put("click_type", i15);
                            if (i20 == 6) {
                                if (this.cN == 2) {
                                    i16 = 2;
                                } else {
                                    i16 = 1;
                                }
                                jSONObjectO.put("shk_click_type", i16);
                            }
                            e(jSONObjectO);
                            r4 = z;
                            str3 = str6;
                            break;
                        case 26:
                            try {
                                e eVar = this.dx;
                                if (eVar != null) {
                                    jSONObjectO.put("sdk_chif_lt", eVar.d);
                                    jSONObjectO.put("ad_wipl_tp", this.dx.e);
                                    jSONObjectO.put("ad_wipl_if", this.dx.f);
                                    jSONObjectO.put("ad_wipl_time", this.dx.g);
                                }
                                str13 = "0";
                                r4 = 0;
                                str3 = str13;
                            } catch (Exception e7) {
                                exc = e7;
                                str5 = "0";
                                r3 = 0;
                                str2 = str5;
                                exc.printStackTrace();
                                r4 = r3;
                                str3 = str2;
                            }
                            break;
                    }
                } catch (Exception e8) {
                    e = e8;
                    i20 = i2;
                }
            } catch (Exception e9) {
                e = e9;
                exc = e;
                r3 = str14;
                str2 = str;
                exc.printStackTrace();
                r4 = r3;
                str3 = str2;
                if (TextUtils.equals(this.aZ, charSequence)) {
                    if (this.cs != 0) {
                        jSONObjectO.put(com.anythink.core.e.l.a.aq, this.cM);
                    } else {
                        jSONObjectO.put(com.anythink.core.e.l.a.aq, this.cM);
                    }
                    map2 = this.cD;
                    if (map2 != null) {
                        obj5 = map2.get(ATAdConst.KEY.AD_WIDTH);
                        obj6 = this.cD.get(ATAdConst.KEY.AD_HEIGHT);
                        if (obj5 != null) {
                            jSONObjectO.put("bn_width", Integer.parseInt(obj5.toString()));
                        }
                        if (obj6 != null) {
                            jSONObjectO.put("bn_height", Integer.parseInt(obj6.toString()));
                        }
                    }
                    if (i20 == 6) {
                        jSONObjectO.put("bn_click_area", i5);
                    }
                }
                dVarA = com.anythink.core.common.t.d.a();
                if (i20 == 4) {
                    if (i20 == 6) {
                        jB2 = com.anythink.core.common.t.d.b((n) this);
                        if (jB2 > 0) {
                            jSONObjectO.put("s_c_interval", jB2);
                        }
                    }
                    str4 = str3;
                } else {
                    str4 = str3;
                    if (!str4.equals(this.aZ)) {
                        jA = dVarA.a((n) this);
                        if (jA > 0) {
                            jSONObjectO.put("pl_show_interval", jA);
                        }
                        jB = dVarA.b();
                        if (jB > 0) {
                            jSONObjectO.put("bidads_show_interval", jB);
                        }
                    }
                }
                if (TextUtils.equals(this.aZ, str4)) {
                    i3 = this.dn;
                    if (i3 > 0) {
                        jSONObjectO.put("render_type", i3);
                    }
                    i4 = this.f0do;
                    if (i4 > 0) {
                        jSONObjectO.put("template_type", i4);
                    }
                }
                aTAdRequest = this.dM;
                if (aTAdRequest != null) {
                    preLoadInfo = aTAdRequest.getPreLoadInfo();
                } else {
                    preLoadInfo = null;
                }
                if (preLoadInfo != null) {
                    placementId = preLoadInfo.getPlacementId();
                    psId = preLoadInfo.getPsId();
                    requestId = preLoadInfo.getRequestId();
                    mpc = preLoadInfo.getMpc();
                    int segId2 = preLoadInfo.getSegId();
                    int abId2 = preLoadInfo.getAbId();
                    int abItemId2 = preLoadInfo.getAbItemId();
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
                    mgComparedResult = preLoadInfo.getMgComparedResult();
                    if (mgComparedResult != null) {
                        zIsCompared = mgComparedResult.isCompared();
                    } else {
                        zIsCompared = r4 == true ? 1 : 0;
                    }
                    if (i20 == 4) {
                    }
                    if (r5 != 0) {
                        r5 = r4;
                        preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                        if (preLoadCallbackRegister != null) {
                            mgAdInfo = preLoadCallbackRegister.getMgAdInfo();
                        } else {
                            mgAdInfo = null;
                        }
                        if (mgAdInfo != null) {
                            uSDEcpm = mgAdInfo.getUSDEcpm();
                        } else {
                            uSDEcpm = 0.0d;
                        }
                        if (uSDEcpm > 0.0d) {
                            jSONObjectO.put("mmed_price", String.valueOf(uSDEcpm));
                        }
                    }
                    if (mpc != null) {
                        jSONObjectO.put("mmed_m_p_c", mpc);
                    }
                    jSONObjectO.put("mmed_seg_id", segId2);
                    jSONObjectO.put("mmed_ab_id", abId2);
                    jSONObjectO.put("mmed_ab_item_id", abItemId2);
                }
                if (this.r == 8) {
                    map = this.cD;
                    if (map != null) {
                        jSONObject = new JSONObject();
                        obj = this.cD.get(GDTATConst.EXTRA_DATA.LNG);
                        if (obj instanceof String) {
                            jSONObject.put(GDTATConst.EXTRA_DATA.LNG, obj);
                        }
                        obj2 = this.cD.get("lat");
                        if (obj2 instanceof String) {
                            jSONObject.put("lat", obj2);
                        }
                        obj3 = this.cD.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                        if (obj3 instanceof String) {
                            jSONObject.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj3);
                        }
                        obj4 = this.cD.get(GDTATConst.EXTRA_DATA.WXOPENID);
                        if (obj4 instanceof String) {
                            jSONObject.put(GDTATConst.EXTRA_DATA.WXOPENID, obj4);
                        }
                        if (jSONObject.length() > 0) {
                            jSONObjectO.put("tx_d", jSONObject);
                        }
                    }
                }
                if (jSONObjectO != null) {
                    if (this.dN) {
                        this.dO = true;
                        jSONObjectO.put("type", 28);
                    }
                }
                if (jSONObjectO != null) {
                    if (i20 != 1) {
                        jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                        jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                        jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                        jSONObjectO.put("anr_hit_type", this.ea);
                    } else {
                        jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                        jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                        jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                        jSONObjectO.put("anr_hit_type", this.ea);
                    }
                }
                return jSONObjectO;
            }
        } catch (Exception e10) {
            e = e10;
            str = "0";
            charSequence = "2";
        }
        try {
            if (TextUtils.equals(this.aZ, charSequence) && (i20 == 1 || i20 == 2 || i20 == 4 || i20 == 13 || i20 == 11 || i20 == 6)) {
                if (this.cs != 0 || i20 == 11) {
                    jSONObjectO.put(com.anythink.core.e.l.a.aq, this.cM);
                }
                map2 = this.cD;
                if (map2 != null) {
                    obj5 = map2.get(ATAdConst.KEY.AD_WIDTH);
                    obj6 = this.cD.get(ATAdConst.KEY.AD_HEIGHT);
                    if (obj5 != null) {
                        jSONObjectO.put("bn_width", Integer.parseInt(obj5.toString()));
                    }
                    if (obj6 != null) {
                        jSONObjectO.put("bn_height", Integer.parseInt(obj6.toString()));
                    }
                }
                if (i20 == 6 && (i5 = this.cK) > 0) {
                    jSONObjectO.put("bn_click_area", i5);
                }
            }
        } catch (Exception unused9) {
        }
        dVarA = com.anythink.core.common.t.d.a();
        try {
            if (i20 == 4) {
                str4 = str3;
                if (!str4.equals(this.aZ)) {
                    jA = dVarA.a((n) this);
                    if (jA > 0) {
                        jSONObjectO.put("pl_show_interval", jA);
                    }
                    jB = dVarA.b();
                    if (jB > 0) {
                        jSONObjectO.put("bidads_show_interval", jB);
                    }
                }
            } else {
                if (i20 == 6 && this.r == 66) {
                    jB2 = com.anythink.core.common.t.d.b((n) this);
                    if (jB2 > 0) {
                        jSONObjectO.put("s_c_interval", jB2);
                    }
                }
                str4 = str3;
            }
        } catch (Throwable unused10) {
        }
        try {
            if (TextUtils.equals(this.aZ, str4) && (i20 == 1 || i20 == 4 || i20 == 6)) {
                i3 = this.dn;
                if (i3 > 0) {
                    jSONObjectO.put("render_type", i3);
                }
                i4 = this.f0do;
                if (i4 > 0) {
                    jSONObjectO.put("template_type", i4);
                }
            }
        } catch (Exception unused11) {
        }
        aTAdRequest = this.dM;
        if (aTAdRequest != null) {
            preLoadInfo = aTAdRequest.getPreLoadInfo();
        } else {
            preLoadInfo = null;
        }
        if (preLoadInfo != null) {
            placementId = preLoadInfo.getPlacementId();
            psId = preLoadInfo.getPsId();
            requestId = preLoadInfo.getRequestId();
            mpc = preLoadInfo.getMpc();
            int segId3 = preLoadInfo.getSegId();
            int abId3 = preLoadInfo.getAbId();
            int abItemId3 = preLoadInfo.getAbItemId();
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
            mgComparedResult = preLoadInfo.getMgComparedResult();
            if (mgComparedResult != null) {
                zIsCompared = mgComparedResult.isCompared();
            } else {
                zIsCompared = r4 == true ? 1 : 0;
            }
            if ((i20 == 4 && i20 != 6 && i20 != 13) || zIsCompared) {
                r5 = 1;
            }
            if (r5 != 0) {
                r5 = r4;
                preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                if (preLoadCallbackRegister != null) {
                    mgAdInfo = preLoadCallbackRegister.getMgAdInfo();
                } else {
                    mgAdInfo = null;
                }
                if (mgAdInfo != null) {
                    uSDEcpm = mgAdInfo.getUSDEcpm();
                } else {
                    uSDEcpm = 0.0d;
                }
                if (uSDEcpm > 0.0d) {
                    jSONObjectO.put("mmed_price", String.valueOf(uSDEcpm));
                }
            }
            if (mpc != null) {
                jSONObjectO.put("mmed_m_p_c", mpc);
            }
            jSONObjectO.put("mmed_seg_id", segId3);
            jSONObjectO.put("mmed_ab_id", abId3);
            jSONObjectO.put("mmed_ab_item_id", abItemId3);
        }
        if (this.r == 8 && (i20 == 1 || i20 == 6)) {
            map = this.cD;
            if (map != null && !map.isEmpty()) {
                jSONObject = new JSONObject();
                obj = this.cD.get(GDTATConst.EXTRA_DATA.LNG);
                if (obj instanceof String) {
                    jSONObject.put(GDTATConst.EXTRA_DATA.LNG, obj);
                }
                obj2 = this.cD.get("lat");
                if (obj2 instanceof String) {
                    jSONObject.put("lat", obj2);
                }
                obj3 = this.cD.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                if (obj3 instanceof String) {
                    jSONObject.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj3);
                }
                obj4 = this.cD.get(GDTATConst.EXTRA_DATA.WXOPENID);
                if (obj4 instanceof String) {
                    jSONObject.put(GDTATConst.EXTRA_DATA.WXOPENID, obj4);
                }
                if (jSONObject.length() > 0) {
                    jSONObjectO.put("tx_d", jSONObject);
                }
            }
        }
        if (jSONObjectO != null && i20 == 6) {
            if (this.dN) {
                this.dO = true;
                jSONObjectO.put("type", 28);
            }
        }
        if (jSONObjectO != null) {
            if (i20 != 1 || i20 == 2 || i20 == 4 || i20 == 6 || i20 == 24) {
                jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                jSONObjectO.put("anr_hit_type", this.ea);
            } else {
                switch (i20) {
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        jSONObjectO.put(com.anythink.core.common.l.f.bV, this.dX);
                        jSONObjectO.put(com.anythink.core.common.l.f.bW, this.dY);
                        jSONObjectO.put(com.anythink.core.common.l.f.bX, this.dZ);
                        jSONObjectO.put("anr_hit_type", this.ea);
                    default:
                        return jSONObjectO;
                }
            }
        }
        return jSONObjectO;
    }

    private void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 6 && i2 != 24) {
            switch (i2) {
            }
            return;
        }
        try {
            jSONObject.put(com.anythink.core.common.l.f.bV, this.dX);
            jSONObject.put(com.anythink.core.common.l.f.bW, this.dY);
            jSONObject.put(com.anythink.core.common.l.f.bX, this.dZ);
            jSONObject.put("anr_hit_type", this.ea);
        } catch (Throwable unused) {
        }
    }

    private void a(JSONObject jSONObject, int i2) {
        ATAdRequest aTAdRequest = this.dM;
        MgPreLoadAdRequest preLoadInfo = aTAdRequest != null ? aTAdRequest.getPreLoadInfo() : null;
        if (preLoadInfo == null) {
            return;
        }
        try {
            String placementId = preLoadInfo.getPlacementId();
            String psId = preLoadInfo.getPsId();
            String requestId = preLoadInfo.getRequestId();
            Object mpc = preLoadInfo.getMpc();
            int segId = preLoadInfo.getSegId();
            int abId = preLoadInfo.getAbId();
            int abItemId = preLoadInfo.getAbItemId();
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
            if (z) {
                MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
                double uSDEcpm = mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d;
                if (uSDEcpm > 0.0d) {
                    jSONObject.put("mmed_price", String.valueOf(uSDEcpm));
                }
            }
            if (mpc != null) {
                jSONObject.put("mmed_m_p_c", mpc);
            }
            jSONObject.put("mmed_seg_id", segId);
            jSONObject.put("mmed_ab_id", abId);
            jSONObject.put("mmed_ab_item_id", abItemId);
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject, int i2) {
        if (jSONObject == null || i2 != 6) {
            return;
        }
        try {
            if (this.dN) {
                this.dO = true;
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
        double d2 = this.cH;
        if (d2 > 0.0d) {
            jSONObject.put("bidprice", String.valueOf(d2));
            jSONObject.put("am_bp_type", 3);
            return;
        }
        jSONObject.put("bidprice", String.valueOf(this.B));
        int i3 = 1;
        if (this.dA == 1) {
            double d3 = this.cI;
            if (d3 == -1.0d) {
                i2 = 5;
            } else if (d3 == 0.0d) {
                i2 = 4;
            } else if (this.cG) {
                i2 = 2;
            }
            i3 = i2;
        }
        jSONObject.put("am_bp_type", i3);
    }

    private void d(JSONObject jSONObject) {
        Map<String, Object> map = this.cF;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (this.r == 2 || this.dA == 1) {
            try {
                jSONObject.put("am_ilrd", new JSONObject(this.cF).toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void e(JSONObject jSONObject) {
        try {
            String strAg = ag();
            if (TextUtils.isEmpty(strAg)) {
                return;
            }
            jSONObject.put("nw_extra_info", strAg);
        } catch (Exception unused) {
        }
    }

    public final String ag() {
        Object obj;
        Map<String, Object> map = this.cF;
        if (map == null || (obj = map.get("nw_extra_info")) == null) {
            return null;
        }
        return obj.toString();
    }

    private void b(int i2, JSONObject jSONObject) throws JSONException {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13 || i2 == 24) {
            jSONObject.put("extra", this.cg);
        }
    }

    private void c(int i2, JSONObject jSONObject) throws JSONException {
        List<Integer> list;
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 8) {
                list = this.N;
                if (list != null && !list.isEmpty()) {
                    jSONObject.put("bid_link", this.N.toString());
                }
            } else if (i2 != 13) {
                if (i2 != 25) {
                    return;
                }
                list = this.N;
                if (list != null) {
                    jSONObject.put("bid_link", this.N.toString());
                }
            }
        }
        if (TextUtils.isEmpty(this.bP)) {
            return;
        }
        jSONObject.put("bid_t_m", this.bP);
    }

    private JSONObject az(int i2) {
        return super.O(i2);
    }

    public final n ah() {
        try {
            n nVar = (n) super.clone();
            nVar.cA = this.cA;
            nVar.cD = this.cD;
            nVar.cB = this.cB;
            nVar.cC = this.cC;
            nVar.cF = this.cF;
            nVar.cE = this.cE;
            nVar.cQ = this.cQ;
            nVar.dR = this.dR;
            nVar.dw = this.dw;
            nVar.dM = this.dM;
            nVar.bi = this.bi;
            nVar.dP = this.dP;
            nVar.Q = this.Q;
            return nVar;
        } catch (Throwable unused) {
            return this;
        }
    }

    private int bv() {
        return this.cK;
    }

    public final void P(int i2) {
        this.cK = i2;
    }

    public final int ai() {
        return this.cL;
    }

    public final void Q(int i2) {
        this.cL = i2;
    }

    private int bw() {
        return this.cN;
    }

    public final void aj() {
        this.cN = 2;
    }

    private int bx() {
        return this.cM;
    }

    public final void R(int i2) {
        this.cM = i2;
    }

    public final int ak() {
        return this.cR;
    }

    public final void S(int i2) {
        this.cR = i2;
    }

    private void c(JSONObject jSONObject, int i2) {
        int i3;
        try {
            if (TextUtils.equals(this.aZ, "2")) {
                if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 13 || i2 == 11 || i2 == 6) {
                    if (this.cs == 0 || i2 == 11) {
                        jSONObject.put(com.anythink.core.e.l.a.aq, this.cM);
                    }
                    Map<String, Object> map = this.cD;
                    if (map != null) {
                        Object obj = map.get(ATAdConst.KEY.AD_WIDTH);
                        Object obj2 = this.cD.get(ATAdConst.KEY.AD_HEIGHT);
                        if (obj != null) {
                            try {
                                jSONObject.put("bn_width", Integer.parseInt(obj.toString()));
                            } catch (Exception unused) {
                            }
                        }
                        if (obj2 != null) {
                            try {
                                jSONObject.put("bn_height", Integer.parseInt(obj2.toString()));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    if (i2 != 6 || (i3 = this.cK) <= 0) {
                        return;
                    }
                    jSONObject.put("bn_click_area", i3);
                }
            }
        } catch (Exception unused3) {
        }
    }

    private void d(JSONObject jSONObject, int i2) {
        try {
            if (TextUtils.equals(this.aZ, "0")) {
                if (i2 == 1 || i2 == 4 || i2 == 6) {
                    int i3 = this.dn;
                    if (i3 > 0) {
                        jSONObject.put("render_type", i3);
                    }
                    int i4 = this.f0do;
                    if (i4 > 0) {
                        jSONObject.put("template_type", i4);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject, int i2) {
        if (i2 == 1 || i2 == 6) {
            try {
                Map<String, Object> map = this.cD;
                if (map == null || map.isEmpty()) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                Object obj = this.cD.get(GDTATConst.EXTRA_DATA.LNG);
                if (obj instanceof String) {
                    jSONObject2.put(GDTATConst.EXTRA_DATA.LNG, obj);
                }
                Object obj2 = this.cD.get("lat");
                if (obj2 instanceof String) {
                    jSONObject2.put("lat", obj2);
                }
                Object obj3 = this.cD.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                if (obj3 instanceof String) {
                    jSONObject2.put(GDTATConst.EXTRA_DATA.LOC_TIME, obj3);
                }
                Object obj4 = this.cD.get(GDTATConst.EXTRA_DATA.WXOPENID);
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

    public final void y(long j2) {
        this.dR = j2;
    }

    private void f(JSONObject jSONObject, int i2) {
        com.anythink.core.common.t.d dVarA = com.anythink.core.common.t.d.a();
        try {
            if (i2 == 4) {
                if ("0".equals(this.aZ)) {
                    return;
                }
                long jA = dVarA.a(this);
                if (jA > 0) {
                    jSONObject.put("pl_show_interval", jA);
                }
                long jB = dVarA.b();
                if (jB > 0) {
                    jSONObject.put("bidads_show_interval", jB);
                    return;
                }
                return;
            }
            if (i2 == 6 && this.r == 66) {
                long jB2 = com.anythink.core.common.t.d.b(this);
                if (jB2 > 0) {
                    jSONObject.put("s_c_interval", jB2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(boolean z) {
        this.cV = z;
    }

    public final boolean al() {
        return this.cV;
    }

    public final int am() {
        return this.cX;
    }

    public final void T(int i2) {
        this.cX = i2;
    }

    public final int an() {
        return this.cY;
    }

    public final void U(int i2) {
        this.cY = i2;
    }

    private int by() {
        return this.cZ;
    }

    public final void V(int i2) {
        this.cZ = i2;
    }

    public final void l(double d2) {
        this.db = d2;
    }

    public final void m(double d2) {
        this.dc = d2;
    }

    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put("dd_ori_price", String.valueOf(this.dc));
            jSONObject.put(com.anythink.core.common.k.aP, String.valueOf(this.db));
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(this.dJ)) {
                jSONObject.put("deal_type", this.dJ);
            }
            if (TextUtils.isEmpty(this.dK)) {
                return;
            }
            jSONObject.put("deal_id", this.dK);
        } catch (Throwable unused) {
        }
    }

    private int bz() {
        return this.dQ;
    }

    public final void W(int i2) {
        this.dQ = i2;
    }

    public final String ao() {
        return this.dk;
    }

    public final void y(String str) {
        this.dk = str;
    }

    public final Map<String, String> ap() {
        return this.dd;
    }

    public final void e(Map<String, String> map) {
        this.dd = map;
    }

    public final void X(int i2) {
        this.dl = i2;
    }

    public final void Y(int i2) {
        this.dn = i2;
    }

    public final void Z(int i2) {
        this.f0do = i2;
    }

    private int bA() {
        return this.dp;
    }

    public final void aa(int i2) {
        this.dp = i2;
    }

    private int bB() {
        return this.dq;
    }

    public final void ab(int i2) {
        this.dq = i2;
    }

    public final int aq() {
        return this.dr;
    }

    public final void ac(int i2) {
        this.dr = i2;
    }

    public final void z(String str) {
        this.ds = str;
    }

    private int bC() {
        return this.dt;
    }

    public final void ad(int i2) {
        this.dt = i2;
    }

    public final void ae(int i2) {
        this.du = i2;
    }

    public final int ar() {
        return this.du;
    }

    public final void as() {
        this.dv = 1;
    }

    public final aa at() {
        return this.dw;
    }

    public final void a(aa aaVar) {
        this.dw = aaVar;
    }

    public final void a(ab abVar) {
        this.dy = abVar;
    }

    public final void a(be beVar) {
        this.dz = beVar;
    }

    public final be au() {
        return this.dz;
    }

    public final void af(int i2) {
        this.dA = i2;
    }

    public final void a(e eVar) {
        this.dx = eVar;
    }

    public final void a(ATCustomContentResult aTCustomContentResult) {
        this.dB = aTCustomContentResult;
    }

    public final ATCustomContentResult av() {
        return this.dB;
    }

    public final void ag(int i2) {
        this.dC = i2;
    }

    public final void n(double d2) {
        this.dD = d2;
    }

    public final void z(long j2) {
        this.dE = j2;
    }

    public final int aw() {
        return this.dH;
    }

    public final void ah(int i2) {
        this.dH = i2;
    }

    public final int ax() {
        return this.dI;
    }

    public final void ai(int i2) {
        this.dI = i2;
    }

    public final void aj(int i2) {
        this.dF = i2;
    }

    public final void ak(int i2) {
        this.dG = i2;
    }

    public final int ay() {
        return this.dF;
    }

    private int bD() {
        return this.dG;
    }

    public final String az() {
        return this.dJ;
    }

    public final void A(String str) {
        this.dJ = str;
    }

    public final String aA() {
        return this.dK;
    }

    public final void B(String str) {
        this.dK = str;
    }

    private int bE() {
        return this.dL;
    }

    public final void al(int i2) {
        this.dL = i2;
    }

    public final void a(List<Integer> list) {
        this.N = list;
    }

    public final boolean aB() {
        return this.dN;
    }

    public final void d(boolean z) {
        this.dN = z;
    }

    public final double aC() {
        return this.dV;
    }

    public final void o(double d2) {
        this.dV = d2;
    }

    public final String aD() {
        return this.dU;
    }

    public final void C(String str) {
        this.dU = str;
    }

    public final double aE() {
        return this.dW;
    }

    public final void p(double d2) {
        this.dW = d2;
    }

    public final void am(int i2) {
        this.dZ = i2;
    }

    public final void an(int i2) {
        this.dY = i2;
    }

    public final void ao(int i2) {
        this.dX = i2;
    }

    public final void ap(int i2) {
        this.ea = i2;
    }
}
