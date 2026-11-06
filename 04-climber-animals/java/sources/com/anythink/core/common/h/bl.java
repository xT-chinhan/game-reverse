package com.anythink.core.common.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bl implements Serializable {
    String[] A;
    String[] B;
    String[] C;
    String[] D;
    String[] E;
    String[] F;
    Map<Integer, String[]> G;
    String[] H;
    String[] I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    String P;
    String Q;
    String R;
    String S;
    String T;
    String U;
    String V;
    String W;
    String X;
    String Y;
    String Z;
    String a;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    String af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    String al;
    String am;
    String an;
    String ao;
    String[] ap;
    String aq;
    String[] b;
    String[] c;
    String[] d;
    String[] e;
    String[] f;
    String[] g;
    String[] h;
    String[] i;
    String[] j;
    String[] k;
    String[] l;
    String[] m;
    String[] n;
    String[] o;
    String[] p;
    String[] q;
    String[] r;
    String[] s;
    String[] t;
    String[] u;
    String[] v;
    String[] w;
    String[] x;
    String[] y;
    String[] z;

    public static final bl a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            bl blVar = new bl();
            blVar.a = jSONObject.optString(MediationConstant.ADN_KS);
            blVar.b = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("nurl"));
            blVar.c = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("lurl"));
            blVar.d = com.anythink.core.common.v.q.a(jSONObject.optJSONArray(com.umeng.analytics.pro.be.c));
            blVar.e = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("click"));
            blVar.f = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vstart"));
            blVar.g = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("v25"));
            blVar.h = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("v50"));
            blVar.i = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("v75"));
            blVar.j = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("v100"));
            blVar.k = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vpaused"));
            blVar.l = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vclick"));
            blVar.m = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vmute"));
            blVar.n = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vunmute"));
            blVar.o = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("ec_show"));
            blVar.p = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("ec_close"));
            blVar.q = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("apk_dl_star"));
            blVar.r = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("apk_dl_end"));
            blVar.s = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("apk_install"));
            blVar.t = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vresumed"));
            blVar.u = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vskip"));
            blVar.v = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vfail"));
            blVar.w = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("apk_start_install"));
            blVar.x = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("dp_start"));
            blVar.y = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("dp_succ"));
            blVar.z = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("app_install"));
            blVar.A = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("app_uninstall"));
            blVar.B = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("app_unknow"));
            blVar.D = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("dp_inst_fail"));
            blVar.C = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("dp_uninst_fail"));
            blVar.E = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vd_succ"));
            blVar.F = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vrewarded"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (jSONArrayOptJSONArray != null) {
                blVar.G = new HashMap();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    int iOptInt = jSONObjectOptJSONObject.optInt("play_sec");
                    blVar.G.put(Integer.valueOf(iOptInt), com.anythink.core.common.v.q.a(jSONObjectOptJSONObject.optJSONArray("list")));
                }
            }
            blVar.H = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("load_success"));
            blVar.I = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("load_fail"));
            blVar.J = jSONObject.optString("tp_nurl");
            blVar.K = jSONObject.optString("tp_imp");
            blVar.L = jSONObject.optString("tp_click");
            blVar.M = jSONObject.optString("tp_vstart");
            blVar.N = jSONObject.optString("tp_v25");
            blVar.O = jSONObject.optString("tp_v50");
            blVar.P = jSONObject.optString("tp_v75");
            blVar.Q = jSONObject.optString("tp_v100");
            blVar.R = jSONObject.optString("tp_vpaused");
            blVar.S = jSONObject.optString("tp_vclick");
            blVar.T = jSONObject.optString("tp_vmute");
            blVar.U = jSONObject.optString("tp_vunmute");
            blVar.V = jSONObject.optString("tp_ec_show");
            blVar.W = jSONObject.optString("tp_ec_close");
            blVar.X = jSONObject.optString("tp_apk_dl_star");
            blVar.Y = jSONObject.optString("tp_apk_dl_end");
            blVar.Z = jSONObject.optString("tp_apk_install");
            blVar.aa = jSONObject.optString("tp_vresumed");
            blVar.ab = jSONObject.optString("tp_vskip");
            blVar.ac = jSONObject.optString("tp_vfail");
            blVar.ad = jSONObject.optString("tp_apk_start_install");
            blVar.ae = jSONObject.optString("tp_dp_start");
            blVar.af = jSONObject.optString("tp_dp_succ");
            blVar.ag = jSONObject.optString("tp_app_install");
            blVar.ah = jSONObject.optString("tp_app_uninstall");
            blVar.ai = jSONObject.optString("tp_app_unknow");
            blVar.ak = jSONObject.optString("tp_dp_inst_fail");
            blVar.aj = jSONObject.optString("tp_dp_uninst_fail");
            blVar.al = jSONObject.optString("tp_vd_succ");
            blVar.am = jSONObject.optString("tp_vrewarded");
            blVar.an = jSONObject.optString("tp_load_success");
            blVar.ao = jSONObject.optString("tp_load_fail");
            blVar.ap = com.anythink.core.common.v.q.a(jSONObject.optJSONArray("vready"));
            blVar.aq = jSONObject.optString("tp_ready");
            return blVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void a(String[] strArr) {
        this.e = strArr;
    }

    public final void b(String[] strArr) {
        this.q = strArr;
    }

    public final void c(String[] strArr) {
        this.r = strArr;
    }

    public final void d(String[] strArr) {
        this.s = strArr;
    }

    public final String[] a() {
        return this.H;
    }

    public final String[] b() {
        return this.I;
    }

    public final String c() {
        return this.a;
    }

    public final String[] d() {
        return this.b;
    }

    public final String[] e() {
        return this.c;
    }

    public final String[] f() {
        return this.d;
    }

    public final String[] g() {
        return this.e;
    }

    public final String[] h() {
        return this.f;
    }

    public final String[] i() {
        return this.g;
    }

    public final String[] j() {
        return this.h;
    }

    public final String[] k() {
        return this.i;
    }

    public final String[] l() {
        return this.j;
    }

    public final String[] m() {
        return this.k;
    }

    public final String[] n() {
        return this.l;
    }

    public final String[] o() {
        return this.m;
    }

    public final String[] p() {
        return this.n;
    }

    public final String[] q() {
        return this.o;
    }

    public final String[] r() {
        return this.p;
    }

    public final String[] s() {
        return this.q;
    }

    public final String[] t() {
        return this.r;
    }

    public final String[] u() {
        return this.s;
    }

    public final String[] v() {
        return this.C;
    }

    public final String[] w() {
        return this.D;
    }

    public final String[] x() {
        return this.E;
    }

    public final String[] y() {
        return this.F;
    }

    public final Map<Integer, String[]> z() {
        return this.G;
    }

    public final String A() {
        return this.J;
    }

    public final String B() {
        return this.K;
    }

    public final String C() {
        return this.L;
    }

    public final String D() {
        return this.M;
    }

    public final String E() {
        return this.N;
    }

    public final String F() {
        return this.O;
    }

    public final String G() {
        return this.P;
    }

    public final String H() {
        return this.Q;
    }

    public final String I() {
        return this.R;
    }

    public final String J() {
        return this.S;
    }

    public final String K() {
        return this.T;
    }

    public final String L() {
        return this.U;
    }

    public final String M() {
        return this.V;
    }

    public final String N() {
        return this.W;
    }

    public final String O() {
        return this.X;
    }

    public final String P() {
        return this.Y;
    }

    public final String Q() {
        return this.Z;
    }

    public final String[] R() {
        return this.t;
    }

    public final String[] S() {
        return this.u;
    }

    public final String[] T() {
        return this.v;
    }

    public final String[] U() {
        return this.w;
    }

    public final String[] V() {
        return this.x;
    }

    public final String[] W() {
        return this.y;
    }

    public final String[] X() {
        return this.z;
    }

    public final String[] Y() {
        return this.A;
    }

    public final String[] Z() {
        return this.B;
    }

    public final String aa() {
        return this.aa;
    }

    public final String ab() {
        return this.ab;
    }

    public final String ac() {
        return this.ac;
    }

    public final String ad() {
        return this.ad;
    }

    public final String ae() {
        return this.ae;
    }

    public final String af() {
        return this.af;
    }

    public final String ag() {
        return this.ag;
    }

    public final String ah() {
        return this.ah;
    }

    public final String ai() {
        return this.ai;
    }

    public final String aj() {
        return this.aj;
    }

    public final String ak() {
        return this.ak;
    }

    public final String al() {
        return this.al;
    }

    public final String am() {
        return this.am;
    }

    public final String an() {
        return this.an;
    }

    public final String ao() {
        return this.ao;
    }

    public final String[] ap() {
        return this.ap;
    }

    public final String aq() {
        return this.aq;
    }

    private void q(String[] strArr) {
        this.b = strArr;
    }

    private void r(String[] strArr) {
        this.c = strArr;
    }

    public final void e(String[] strArr) {
        this.d = strArr;
    }

    public final void f(String[] strArr) {
        this.e = strArr;
    }

    public final void g(String[] strArr) {
        this.f = strArr;
    }

    public final void h(String[] strArr) {
        this.g = strArr;
    }

    public final void i(String[] strArr) {
        this.h = strArr;
    }

    public final void j(String[] strArr) {
        this.i = strArr;
    }

    public final void k(String[] strArr) {
        this.j = strArr;
    }

    public final void l(String[] strArr) {
        this.k = strArr;
    }

    private void s(String[] strArr) {
        this.l = strArr;
    }

    public final void m(String[] strArr) {
        this.m = strArr;
    }

    public final void n(String[] strArr) {
        this.n = strArr;
    }

    private void t(String[] strArr) {
        this.o = strArr;
    }

    private void u(String[] strArr) {
        this.p = strArr;
    }

    public final void o(String[] strArr) {
        this.t = strArr;
    }

    private void v(String[] strArr) {
        this.u = strArr;
    }

    public final void p(String[] strArr) {
        this.v = strArr;
    }

    private void w(String[] strArr) {
        this.w = strArr;
    }

    private void x(String[] strArr) {
        this.x = strArr;
    }

    private void y(String[] strArr) {
        this.y = strArr;
    }

    private void z(String[] strArr) {
        this.z = strArr;
    }

    private void A(String[] strArr) {
        this.A = strArr;
    }

    private void B(String[] strArr) {
        this.B = strArr;
    }

    private void C(String[] strArr) {
        this.C = strArr;
    }

    private void D(String[] strArr) {
        this.D = strArr;
    }

    private void E(String[] strArr) {
        this.E = strArr;
    }

    private void F(String[] strArr) {
        this.F = strArr;
    }

    private void a(Map<Integer, String[]> map) {
        this.G = map;
    }

    private void G(String[] strArr) {
        this.H = strArr;
    }

    private void H(String[] strArr) {
        this.I = strArr;
    }
}
