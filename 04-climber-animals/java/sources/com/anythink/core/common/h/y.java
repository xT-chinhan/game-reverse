package com.anythink.core.common.h;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class y implements Serializable {
    public static final String a = "320x50";
    public static final String b = "320x90";
    public static final String c = "300x250";
    public static final String d = "728x90";
    protected static final int n = 604800000;
    private int A;
    private int B;
    private long C;
    private int D;
    private int E;
    private int K;
    private int L;
    private int O;
    private int P;
    private int Q;
    private int R;
    private long S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int aJ;
    private String aN;
    private long ak;
    private int al;
    private int am;
    private int ap;
    private int aq;
    private long ar;
    private String as;
    private String at;
    private String av;
    private String aw;
    private String ax;
    private String ay;
    private int bL;
    private int bM;
    private List<Double> bN;
    private int bO;
    private String bi;
    private int bk;
    private List<String> bv;
    private int bx;
    private String by;
    protected int e;
    protected int f;
    protected int g;
    protected String h;
    protected long i;
    protected int j;
    protected int k;
    protected int l;
    private int o;
    private int p;
    private int q;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private long x;
    private int y;
    private String z;
    private int r = -1;
    private int F = 1;
    private int G = 0;
    private int H = 2;
    private int I = 0;
    private int J = 1;
    private int M = 2;
    private int N = 1;
    protected int m = -1;
    private int X = 100;
    private int Y = 0;
    private int Z = 2;
    private boolean aa = true;
    private boolean ab = false;
    private int ac = 1;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private long ag = 5000;
    private long ah = 5000;
    private long ai = 5000;
    private long aj = 5000;
    private int an = 2;
    private int ao = 1;
    private int au = 3;
    private int az = 1;
    private int aA = 2;
    private int aB = 1;
    private int aC = 1;
    private int aD = 2;
    private long aE = 0;
    private long aF = com.anythink.basead.exoplayer.i.a.f;
    private long aG = 5000;
    private boolean aH = false;
    private int aI = 2;
    private int aK = 1;
    private boolean aL = false;
    private int aM = 1;
    private int aO = 1;
    private long aP = 0;
    private long aQ = 0;
    private String aR = "";
    private String aS = "";
    private String aT = "";
    private String aU = "";
    private String aV = "";
    private int aW = 1;
    private int aX = 0;
    private int aY = 1;
    private int aZ = 1;
    private String ba = "";
    private String bb = "";
    private String bc = "";
    private String bd = "";
    private String be = "";
    private long bf = 0;
    private long bg = 1;
    private int bh = 1;
    private int bj = 1;
    private int bl = 1;
    private long bm = 5000;
    private long bn = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    private long bo = 5000;
    private int bp = 1;
    private int bq = 1;
    private int br = 1;
    private int bs = 1;
    private double bt = 1.0d;
    private long bu = 50;
    private int bw = 2;
    private int bz = 2;
    private int bA = 2;
    private int bB = 2;
    private int bC = 0;
    private int bD = 1;
    private int bE = 2;
    private long bF = 5000;
    private long bG = com.tapsdk.tapad.e.a.f;
    private int bH = 1;
    private int bI = 1;
    private int bJ = 2;
    private int bK = 2;

    public final int e() {
        return this.au;
    }

    public final void a(int i) {
        this.au = i;
    }

    public final String f() {
        return this.av;
    }

    public final void a(String str) {
        this.av = str;
    }

    public final String g() {
        return this.aw;
    }

    public final void b(String str) {
        this.aw = str;
    }

    public final String h() {
        return this.ax;
    }

    public final void c(String str) {
        this.ax = str;
    }

    public final String i() {
        return this.ay;
    }

    public final void d(String str) {
        this.ay = str;
    }

    public final int j() {
        return this.bK;
    }

    public final void b(int i) {
        this.bK = i;
    }

    public final int k() {
        return this.O;
    }

    public final void c(int i) {
        this.O = i;
    }

    public final int l() {
        return this.P;
    }

    public final void d(int i) {
        this.P = i;
    }

    public final int m() {
        return this.K;
    }

    public final void e(int i) {
        this.K = i;
    }

    public final int n() {
        return this.L;
    }

    public final void f(int i) {
        this.L = i;
    }

    public final long o() {
        long j = this.i;
        if (j <= 0) {
            return 30000L;
        }
        return j;
    }

    public final void a(long j) {
        this.i = j;
    }

    public final int p() {
        return this.j;
    }

    public final void g(int i) {
        this.j = i;
    }

    public final int q() {
        return this.k;
    }

    public final void h(int i) {
        this.k = i;
    }

    public final int r() {
        return this.V;
    }

    public final void i(int i) {
        this.V = i;
    }

    public final int s() {
        return this.W;
    }

    public final void j(int i) {
        this.W = i;
    }

    public final int t() {
        return this.l;
    }

    public final void k(int i) {
        this.l = i;
    }

    public final int u() {
        int i = this.E;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final void l(int i) {
        this.E = i;
    }

    public final int v() {
        int i = this.D;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final void m(int i) {
        this.D = i;
    }

    public final int w() {
        return this.B;
    }

    public final void n(int i) {
        this.B = i;
    }

    public final long x() {
        return this.x;
    }

    public final void b(long j) {
        this.x = j;
    }

    public final int y() {
        return this.v;
    }

    public final void o(int i) {
        this.v = i;
    }

    public final int z() {
        return this.w;
    }

    public final void p(int i) {
        this.w = i;
    }

    public final int A() {
        return this.y;
    }

    public final void q(int i) {
        this.y = i;
    }

    public final String B() {
        return this.z;
    }

    public final void e(String str) {
        this.z = str;
    }

    public final int C() {
        return this.A;
    }

    public final void r(int i) {
        this.A = i;
    }

    public final int D() {
        return this.o;
    }

    public final void s(int i) {
        this.o = i;
    }

    public final int E() {
        return this.p;
    }

    public final void t(int i) {
        this.p = i;
    }

    public final int F() {
        return this.q;
    }

    public final void u(int i) {
        this.q = i;
    }

    public final int G() {
        return this.r;
    }

    public final void v(int i) {
        this.r = i;
    }

    public final int H() {
        return this.s;
    }

    public final void w(int i) {
        this.s = i;
    }

    public final int I() {
        return this.t;
    }

    public final void x(int i) {
        this.t = i;
    }

    public final int J() {
        return this.u;
    }

    public final void y(int i) {
        this.u = i;
    }

    public final long K() {
        return this.C;
    }

    public final void c(long j) {
        this.C = j;
    }

    public final int L() {
        return this.e;
    }

    public final void z(int i) {
        this.e = i;
    }

    public final int M() {
        return this.f;
    }

    public final void A(int i) {
        this.f = i;
    }

    public final int N() {
        return this.g;
    }

    public final void B(int i) {
        this.g = i;
    }

    public final String O() {
        return this.h;
    }

    public final void f(String str) {
        this.h = str;
    }

    private int a() {
        return this.F;
    }

    public final void C(int i) {
        this.F = i;
    }

    private int b() {
        return this.G;
    }

    public final void D(int i) {
        this.G = i;
    }

    public final int P() {
        return this.H;
    }

    public final void E(int i) {
        this.H = i;
    }

    public final int Q() {
        return this.I;
    }

    public final void F(int i) {
        this.I = i;
    }

    public final int R() {
        return this.J;
    }

    public final void G(int i) {
        this.J = i;
    }

    public final int S() {
        return this.M;
    }

    public final void H(int i) {
        this.M = i;
    }

    public final int T() {
        return this.N;
    }

    public final void I(int i) {
        this.N = i;
    }

    public final int U() {
        return this.Q;
    }

    public final void J(int i) {
        this.Q = i;
    }

    public final int V() {
        int i = this.R;
        if (i <= 0) {
            return 10;
        }
        return i;
    }

    public final void K(int i) {
        this.R = i;
    }

    public final long W() {
        long j = this.S;
        if (j <= 0) {
            return 5000L;
        }
        return j;
    }

    public final void d(long j) {
        this.S = j;
    }

    public final int X() {
        return this.T;
    }

    public final void L(int i) {
        this.T = i;
    }

    public final int Y() {
        return this.U;
    }

    public final void M(int i) {
        this.U = i;
    }

    public final int Z() {
        return this.m;
    }

    public final void N(int i) {
        this.m = i;
    }

    public final void O(int i) {
        this.X = i;
    }

    public final int aa() {
        return this.X;
    }

    public final void P(int i) {
        this.Y = i;
    }

    public final int ab() {
        return this.Y;
    }

    public final void Q(int i) {
        this.Z = i;
    }

    public final int ac() {
        return this.Z;
    }

    public final boolean ad() {
        return this.aa;
    }

    public final void a(boolean z) {
        this.aa = z;
    }

    public final boolean ae() {
        return this.ab;
    }

    public final void b(boolean z) {
        this.ab = z;
    }

    public final boolean af() {
        return this.ad;
    }

    public final void c(boolean z) {
        this.ad = z;
    }

    public final boolean ag() {
        return this.ae;
    }

    public final void d(boolean z) {
        this.ae = z;
    }

    public final boolean ah() {
        return this.af;
    }

    public final void e(boolean z) {
        this.af = z;
    }

    public final long ai() {
        return this.ag;
    }

    public final void e(long j) {
        this.ag = j;
    }

    public final long aj() {
        return this.ah;
    }

    public final void f(long j) {
        this.ah = j;
    }

    public final long ak() {
        return this.ai;
    }

    public final void g(long j) {
        this.ai = j;
    }

    public final long al() {
        return this.aj;
    }

    public final void h(long j) {
        this.aj = j;
    }

    public final long am() {
        return this.ak;
    }

    public final void i(long j) {
        this.ak = j;
    }

    public final int an() {
        return this.al;
    }

    public final void R(int i) {
        this.al = i;
    }

    public final int ao() {
        return this.am;
    }

    public final void S(int i) {
        this.am = i;
    }

    public final boolean ap() {
        return this.an == 1;
    }

    public final void T(int i) {
        this.an = i;
    }

    public final boolean aq() {
        return this.ao >= 2;
    }

    public final void U(int i) {
        this.ao = i;
    }

    public final int ar() {
        return this.ap;
    }

    public final void V(int i) {
        this.ap = i;
    }

    public final int as() {
        return this.aq;
    }

    public final void W(int i) {
        this.aq = i;
    }

    public final long at() {
        return this.ar;
    }

    public final void j(long j) {
        this.ar = j;
    }

    public final String au() {
        return this.as;
    }

    public final void g(String str) {
        this.as = str;
    }

    public final String av() {
        return this.at;
    }

    public final void h(String str) {
        this.at = str;
    }

    public final int aw() {
        return this.az;
    }

    public final void X(int i) {
        this.az = i;
    }

    public final int ax() {
        return this.aA;
    }

    public final void Y(int i) {
        this.aA = i;
    }

    public final int ay() {
        return this.aB;
    }

    public final void Z(int i) {
        this.aB = i;
    }

    public final boolean az() {
        return this.aB == 1;
    }

    public final int aA() {
        return this.aK;
    }

    public final void aa(int i) {
        this.aK = i;
    }

    public final long aB() {
        return this.aE;
    }

    public final void k(long j) {
        this.aE = j;
    }

    public final long aC() {
        return this.aF;
    }

    public final void l(long j) {
        this.aF = j;
    }

    public final long aD() {
        return this.aG;
    }

    public final void m(long j) {
        this.aG = j;
    }

    private int c() {
        return this.aD;
    }

    public final void ab(int i) {
        this.aD = i;
    }

    public final boolean aE() {
        return this.aD == 1;
    }

    public final int aF() {
        return this.aC;
    }

    public final void ac(int i) {
        this.aC = i;
    }

    public final boolean aG() {
        return this.aH;
    }

    public final void f(boolean z) {
        this.aH = z;
    }

    public final int aH() {
        return this.aI;
    }

    public final void ad(int i) {
        this.aI = i;
    }

    public final int aI() {
        return this.bL;
    }

    public final void ae(int i) {
        this.bL = i;
    }

    public final int aJ() {
        return this.bM;
    }

    public final void af(int i) {
        this.bM = i;
    }

    public final List<Double> aK() {
        return this.bN;
    }

    public final void a(List<Double> list) {
        this.bN = list;
    }

    public final int aL() {
        return this.bO;
    }

    public final void ag(int i) {
        this.bO = i;
    }

    public final boolean aM() {
        return this.aL;
    }

    public final void g(boolean z) {
        this.aL = z;
    }

    public final int aN() {
        return this.aM;
    }

    public final void ah(int i) {
        this.aM = i;
    }

    public final int aO() {
        return this.aO;
    }

    public final void ai(int i) {
        this.aO = i;
    }

    public final long aP() {
        return this.aP;
    }

    public final void n(long j) {
        this.aP = j;
    }

    public final String aQ() {
        return this.aR;
    }

    public final void i(String str) {
        this.aR = str;
    }

    public final String aR() {
        return this.aS;
    }

    public final void j(String str) {
        this.aS = str;
    }

    public final String aS() {
        return this.aT;
    }

    public final void k(String str) {
        this.aT = str;
    }

    public final String aT() {
        return this.aU;
    }

    public final void l(String str) {
        this.aU = str;
    }

    public final int aU() {
        return this.aW;
    }

    public final void aj(int i) {
        this.aW = i;
    }

    public final int aV() {
        return this.aX;
    }

    public final void ak(int i) {
        this.aX = i;
    }

    public final int aW() {
        return this.aY;
    }

    public final void al(int i) {
        this.aY = i;
    }

    public final String aX() {
        return this.aN;
    }

    public final void m(String str) {
        this.aN = str;
    }

    public final long aY() {
        return this.aQ;
    }

    public final void o(long j) {
        this.aQ = j;
    }

    public final String aZ() {
        return this.ba;
    }

    public final void n(String str) {
        this.ba = str;
    }

    public final String ba() {
        return this.bb;
    }

    public final void o(String str) {
        this.bb = str;
    }

    public final String bb() {
        return this.bc;
    }

    public final void p(String str) {
        this.bc = str;
    }

    public final String bc() {
        return this.bd;
    }

    public final void q(String str) {
        this.bd = str;
    }

    public final String bd() {
        return this.be;
    }

    public final void r(String str) {
        this.be = str;
    }

    public final int be() {
        return this.aZ;
    }

    public final void am(int i) {
        this.aZ = i;
    }

    public final String bf() {
        return this.aV;
    }

    private void u(String str) {
        this.aV = str;
    }

    public final int bg() {
        return this.aJ;
    }

    public final void an(int i) {
        this.aJ = i;
    }

    public final long bh() {
        return this.bf;
    }

    public final void p(long j) {
        this.bf = j;
    }

    public final long bi() {
        return this.bg;
    }

    public final void q(long j) {
        this.bg = j;
    }

    public final int bj() {
        return this.bh;
    }

    public final void ao(int i) {
        this.bh = i;
    }

    public final String bk() {
        return this.bi;
    }

    public final void s(String str) {
        this.bi = str;
    }

    private int d() {
        return this.bj;
    }

    public final void ap(int i) {
        this.bj = i;
    }

    public final int bl() {
        return this.bk;
    }

    public final void aq(int i) {
        this.bk = i;
    }

    public final boolean bm() {
        return this.ac == 1;
    }

    public final int bn() {
        return this.ac;
    }

    public final void ar(int i) {
        this.ac = i;
    }

    public final int bo() {
        return this.bl;
    }

    public final void as(int i) {
        this.bl = i;
    }

    public final long bp() {
        return this.bm;
    }

    public final void r(long j) {
        this.bm = j;
    }

    public final long bq() {
        return this.bn;
    }

    public final void s(long j) {
        this.bn = j;
    }

    public final long br() {
        return this.bo;
    }

    public final void t(long j) {
        this.bo = j;
    }

    public final int bs() {
        return this.bp;
    }

    public final void at(int i) {
        this.bp = i;
    }

    public final int bt() {
        return this.bq;
    }

    public final void au(int i) {
        this.bq = i;
    }

    public final int bu() {
        return this.br;
    }

    public final void av(int i) {
        this.br = i;
    }

    public final int bv() {
        return this.bs;
    }

    public final void aw(int i) {
        this.bs = i;
    }

    public final double bw() {
        return this.bt;
    }

    public final void a(double d2) {
        this.bt = d2;
    }

    public final long bx() {
        return this.bu;
    }

    public final void u(long j) {
        this.bu = j;
    }

    public final List<String> by() {
        return this.bv;
    }

    public final void b(List<String> list) {
        this.bv = list;
    }

    public final int bz() {
        return this.bw;
    }

    public final void ax(int i) {
        this.bw = i;
    }

    public final int bA() {
        return this.bz;
    }

    public final void ay(int i) {
        this.bz = i;
    }

    public final int bB() {
        return this.bA;
    }

    public final void az(int i) {
        this.bA = i;
    }

    public final int bC() {
        return this.bB;
    }

    public final void aA(int i) {
        this.bB = i;
    }

    public final int bD() {
        return this.bx;
    }

    public final void aB(int i) {
        this.bx = i;
    }

    public final String bE() {
        return this.by;
    }

    public final void t(String str) {
        this.by = str;
    }

    public final int bF() {
        return this.bC;
    }

    public final void aC(int i) {
        this.bC = i;
    }

    public final int bG() {
        return this.bD;
    }

    public final void aD(int i) {
        this.bD = i;
    }

    public final int bH() {
        return this.bE;
    }

    public final void aE(int i) {
        this.bE = i;
    }

    public final long bI() {
        return this.bF;
    }

    public final void v(long j) {
        this.bF = j;
    }

    public final long bJ() {
        return this.bG;
    }

    public final void w(long j) {
        this.bG = j;
    }

    public final int bK() {
        return this.bH;
    }

    public final void aF(int i) {
        this.bH = i;
    }

    public final int bL() {
        return this.bI != 2 ? 1 : 2;
    }

    public final void aG(int i) {
        this.bI = i;
    }

    public final int bM() {
        return this.bJ;
    }

    public final void aH(int i) {
        this.bJ = i;
    }
}
