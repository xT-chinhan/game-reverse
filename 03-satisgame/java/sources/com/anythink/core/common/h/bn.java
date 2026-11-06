package com.anythink.core.common.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bn implements Serializable {
    String[] A;
    String[] B;
    String[] C;
    String[] D;
    String[] E;
    String[] F;
    String[] G;
    Map<Integer, String[]> H;
    String[] I;
    String[] J;
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
    String ap;
    String[] aq;
    String ar;
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

    private static bn a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            bn bnVar = new bn();
            bnVar.a = jSONObject.optString(MediationConstant.ADN_KS);
            bnVar.b = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("nurl"));
            bnVar.c = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("lurl"));
            bnVar.d = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("imp"));
            bnVar.e = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("click"));
            bnVar.g = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vstart"));
            bnVar.h = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("v25"));
            bnVar.i = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("v50"));
            bnVar.j = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("v75"));
            bnVar.k = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("v100"));
            bnVar.l = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vpaused"));
            bnVar.m = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vclick"));
            bnVar.n = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vmute"));
            bnVar.o = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vunmute"));
            bnVar.p = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("ec_show"));
            bnVar.q = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("ec_close"));
            bnVar.r = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("apk_dl_star"));
            bnVar.s = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("apk_dl_end"));
            bnVar.t = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("apk_install"));
            bnVar.u = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vresumed"));
            bnVar.v = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vskip"));
            bnVar.w = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vfail"));
            bnVar.x = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("apk_start_install"));
            bnVar.y = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("dp_start"));
            bnVar.z = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("dp_succ"));
            bnVar.A = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("app_install"));
            bnVar.B = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("app_uninstall"));
            bnVar.C = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("app_unknow"));
            bnVar.E = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("dp_inst_fail"));
            bnVar.D = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("dp_uninst_fail"));
            bnVar.F = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vd_succ"));
            bnVar.G = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vrewarded"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (jSONArrayOptJSONArray != null) {
                bnVar.H = new HashMap();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    int iOptInt = jSONObjectOptJSONObject.optInt("play_sec");
                    bnVar.H.put(Integer.valueOf(iOptInt), com.anythink.core.common.u.p.a(jSONObjectOptJSONObject.optJSONArray("list")));
                }
            }
            bnVar.I = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("load_success"));
            bnVar.J = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("load_fail"));
            bnVar.K = jSONObject.optString("tp_nurl");
            bnVar.L = jSONObject.optString("tp_imp");
            bnVar.M = jSONObject.optString("tp_click");
            bnVar.N = jSONObject.optString("tp_vstart");
            bnVar.O = jSONObject.optString("tp_v25");
            bnVar.P = jSONObject.optString("tp_v50");
            bnVar.Q = jSONObject.optString("tp_v75");
            bnVar.R = jSONObject.optString("tp_v100");
            bnVar.S = jSONObject.optString("tp_vpaused");
            bnVar.T = jSONObject.optString("tp_vclick");
            bnVar.U = jSONObject.optString("tp_vmute");
            bnVar.V = jSONObject.optString("tp_vunmute");
            bnVar.W = jSONObject.optString("tp_ec_show");
            bnVar.X = jSONObject.optString("tp_ec_close");
            bnVar.Y = jSONObject.optString("tp_apk_dl_star");
            bnVar.Z = jSONObject.optString("tp_apk_dl_end");
            bnVar.aa = jSONObject.optString("tp_apk_install");
            bnVar.ab = jSONObject.optString("tp_vresumed");
            bnVar.ac = jSONObject.optString("tp_vskip");
            bnVar.ad = jSONObject.optString("tp_vfail");
            bnVar.ae = jSONObject.optString("tp_apk_start_install");
            bnVar.af = jSONObject.optString("tp_dp_start");
            bnVar.ag = jSONObject.optString("tp_dp_succ");
            bnVar.ah = jSONObject.optString("tp_app_install");
            bnVar.ai = jSONObject.optString("tp_app_uninstall");
            bnVar.aj = jSONObject.optString("tp_app_unknow");
            bnVar.al = jSONObject.optString("tp_dp_inst_fail");
            bnVar.ak = jSONObject.optString("tp_dp_uninst_fail");
            bnVar.am = jSONObject.optString("tp_vd_succ");
            bnVar.an = jSONObject.optString("tp_vrewarded");
            bnVar.ao = jSONObject.optString("tp_load_success");
            bnVar.ap = jSONObject.optString("tp_load_fail");
            bnVar.aq = com.anythink.core.common.u.p.a(jSONObject.optJSONArray("vready"));
            bnVar.ar = jSONObject.optString("tp_ready");
            return bnVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void a(String[] strArr) {
        this.f = strArr;
    }

    private void b(String[] strArr) {
        this.r = strArr;
    }

    private void c(String[] strArr) {
        this.s = strArr;
    }

    private void d(String[] strArr) {
        this.t = strArr;
    }

    private String[] a() {
        return this.I;
    }

    private String[] b() {
        return this.J;
    }

    private String c() {
        return this.a;
    }

    private String[] d() {
        return this.b;
    }

    private String[] e() {
        return this.c;
    }

    private String[] f() {
        return this.d;
    }

    private String[] g() {
        String[] strArr = this.e;
        String[] strArr2 = this.f;
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        if (strArr2 == null || strArr2.length == 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    private String[] h() {
        return this.g;
    }

    private String[] i() {
        return this.h;
    }

    private String[] j() {
        return this.i;
    }

    private String[] k() {
        return this.j;
    }

    private String[] l() {
        return this.k;
    }

    private String[] m() {
        return this.l;
    }

    private String[] n() {
        return this.m;
    }

    private String[] o() {
        return this.n;
    }

    private String[] p() {
        return this.o;
    }

    private String[] q() {
        return this.p;
    }

    private String[] r() {
        return this.q;
    }

    private String[] s() {
        return this.r;
    }

    private String[] t() {
        return this.s;
    }

    private String[] u() {
        return this.t;
    }

    private String[] v() {
        return this.D;
    }

    private String[] w() {
        return this.E;
    }

    private String[] x() {
        return this.F;
    }

    private String[] y() {
        return this.G;
    }

    private Map<Integer, String[]> z() {
        return this.H;
    }

    private String A() {
        return this.K;
    }

    private String B() {
        return this.L;
    }

    private String C() {
        return this.M;
    }

    private String D() {
        return this.N;
    }

    private String E() {
        return this.O;
    }

    private String F() {
        return this.P;
    }

    private String G() {
        return this.Q;
    }

    private String H() {
        return this.R;
    }

    private String I() {
        return this.S;
    }

    private String J() {
        return this.T;
    }

    private String K() {
        return this.U;
    }

    private String L() {
        return this.V;
    }

    private String M() {
        return this.W;
    }

    private String N() {
        return this.X;
    }

    private String O() {
        return this.Y;
    }

    private String P() {
        return this.Z;
    }

    private String Q() {
        return this.aa;
    }

    private String[] R() {
        return this.u;
    }

    private String[] S() {
        return this.v;
    }

    private String[] T() {
        return this.w;
    }

    private String[] U() {
        return this.x;
    }

    private String[] V() {
        return this.y;
    }

    private String[] W() {
        return this.z;
    }

    private String[] X() {
        return this.A;
    }

    private String[] Y() {
        return this.B;
    }

    private String[] Z() {
        return this.C;
    }

    private String aa() {
        return this.ab;
    }

    private String ab() {
        return this.ac;
    }

    private String ac() {
        return this.ad;
    }

    private String ad() {
        return this.ae;
    }

    private String ae() {
        return this.af;
    }

    private String af() {
        return this.ag;
    }

    private String ag() {
        return this.ah;
    }

    private String ah() {
        return this.ai;
    }

    private String ai() {
        return this.aj;
    }

    private String aj() {
        return this.ak;
    }

    private String ak() {
        return this.al;
    }

    private String al() {
        return this.am;
    }

    private String am() {
        return this.an;
    }

    private String an() {
        return this.ao;
    }

    private String ao() {
        return this.ap;
    }

    private String[] ap() {
        return this.aq;
    }

    private String aq() {
        return this.ar;
    }

    private void e(String[] strArr) {
        this.b = strArr;
    }

    private void f(String[] strArr) {
        this.c = strArr;
    }

    private void g(String[] strArr) {
        this.d = strArr;
    }

    private void h(String[] strArr) {
        this.e = strArr;
    }

    private void i(String[] strArr) {
        this.g = strArr;
    }

    private void j(String[] strArr) {
        this.h = strArr;
    }

    private void k(String[] strArr) {
        this.i = strArr;
    }

    private void l(String[] strArr) {
        this.j = strArr;
    }

    private void m(String[] strArr) {
        this.k = strArr;
    }

    private void n(String[] strArr) {
        this.l = strArr;
    }

    private void o(String[] strArr) {
        this.m = strArr;
    }

    private void p(String[] strArr) {
        this.n = strArr;
    }

    private void q(String[] strArr) {
        this.o = strArr;
    }

    private void r(String[] strArr) {
        this.p = strArr;
    }

    private void s(String[] strArr) {
        this.q = strArr;
    }

    private void t(String[] strArr) {
        this.u = strArr;
    }

    private void u(String[] strArr) {
        this.v = strArr;
    }

    private void v(String[] strArr) {
        this.w = strArr;
    }

    private void w(String[] strArr) {
        this.x = strArr;
    }

    private void x(String[] strArr) {
        this.y = strArr;
    }

    private void y(String[] strArr) {
        this.z = strArr;
    }

    private void z(String[] strArr) {
        this.A = strArr;
    }

    private void A(String[] strArr) {
        this.B = strArr;
    }

    private void B(String[] strArr) {
        this.C = strArr;
    }

    private void C(String[] strArr) {
        this.D = strArr;
    }

    private void D(String[] strArr) {
        this.E = strArr;
    }

    private void E(String[] strArr) {
        this.F = strArr;
    }

    private void F(String[] strArr) {
        this.G = strArr;
    }

    private void a(Map<Integer, String[]> map) {
        this.H = map;
    }

    private void G(String[] strArr) {
        this.I = strArr;
    }

    private void H(String[] strArr) {
        this.J = strArr;
    }

    private static String[] a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        if (strArr2 == null || strArr2.length == 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }
}
