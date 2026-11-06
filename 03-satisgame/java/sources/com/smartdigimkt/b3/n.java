package com.smartdigimkt.b3;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Serializable {
    public String[] A;
    public String[] B;
    public String[] C;
    public String[] D;
    public String[] E;
    public String[] F;
    public HashMap G;
    public String[] H;
    public String[] I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public String a0;
    public String[] b;
    public String b0;
    public String[] c;
    public String c0;
    public String[] d;
    public String d0;
    public String[] e;
    public String e0;
    public String[] f;
    public String f0;
    public String[] g;
    public String g0;
    public String[] h;
    public String h0;
    public String[] i;
    public String i0;
    public String[] j;
    public String j0;
    public String[] k;
    public String k0;
    public String[] l;
    public String l0;
    public String[] m;
    public String m0;
    public String[] n;
    public String n0;
    public String[] o;
    public String o0;
    public String[] p;
    public String[] p0;
    public String[] q;
    public String q0;
    public String[] r;
    public String[] s;
    public String[] t;
    public String[] u;
    public String[] v;
    public String[] w;
    public String[] x;
    public String[] y;
    public String[] z;

    public static final n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            n nVar = new n();
            nVar.a = jSONObject.optString(MediationConstant.ADN_KS);
            nVar.b = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("nurl"));
            nVar.c = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("lurl"));
            nVar.d = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("imp"));
            nVar.e = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("click"));
            nVar.f = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vstart"));
            nVar.g = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("v25"));
            nVar.h = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("v50"));
            nVar.i = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("v75"));
            nVar.j = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("v100"));
            nVar.k = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vpaused"));
            nVar.l = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vclick"));
            nVar.m = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vmute"));
            nVar.n = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vunmute"));
            nVar.o = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("ec_show"));
            nVar.p = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("ec_close"));
            StringBuilder sb = new StringBuilder();
            String str = com.smartdigimkt.r4.o.g;
            nVar.q = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray(sb.append(str).append("_dl_star").toString()));
            nVar.r = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray(str + "_dl_end"));
            nVar.s = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray(str + "_install"));
            nVar.t = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vresumed"));
            nVar.u = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vskip"));
            nVar.v = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vfail"));
            nVar.w = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray(str + "_start_install"));
            nVar.x = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("dp_start"));
            nVar.y = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("dp_succ"));
            nVar.z = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("app_install"));
            nVar.A = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("app_uninstall"));
            nVar.B = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("app_unknow"));
            nVar.D = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("dp_inst_fail"));
            nVar.C = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("dp_uninst_fail"));
            nVar.E = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vd_succ"));
            nVar.F = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vrewarded"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (jSONArrayOptJSONArray != null) {
                nVar.G = new HashMap();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    nVar.G.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("play_sec")), com.smartdigimkt.r4.k.a(jSONObjectOptJSONObject.optJSONArray("list")));
                }
            }
            nVar.H = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("load_success"));
            nVar.I = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("load_fail"));
            nVar.J = jSONObject.optString("tp_nurl");
            nVar.K = jSONObject.optString("tp_imp");
            nVar.L = jSONObject.optString("tp_click");
            nVar.M = jSONObject.optString("tp_vstart");
            nVar.N = jSONObject.optString("tp_v25");
            nVar.O = jSONObject.optString("tp_v50");
            nVar.P = jSONObject.optString("tp_v75");
            nVar.Q = jSONObject.optString("tp_v100");
            nVar.R = jSONObject.optString("tp_vpaused");
            nVar.S = jSONObject.optString("tp_vclick");
            nVar.T = jSONObject.optString("tp_vmute");
            nVar.U = jSONObject.optString("tp_vunmute");
            nVar.V = jSONObject.optString("tp_ec_show");
            nVar.W = jSONObject.optString("tp_ec_close");
            StringBuilder sbAppend = new StringBuilder().append("tp_");
            String str2 = com.smartdigimkt.r4.o.g;
            nVar.X = jSONObject.optString(sbAppend.append(str2).append("_dl_star").toString());
            nVar.Y = jSONObject.optString("tp_" + str2 + "_dl_end");
            nVar.Z = jSONObject.optString("tp_" + str2 + "_install");
            nVar.a0 = jSONObject.optString("tp_vresumed");
            nVar.b0 = jSONObject.optString("tp_vskip");
            nVar.c0 = jSONObject.optString("tp_vfail");
            nVar.d0 = jSONObject.optString("tp_" + str2 + "_start_install");
            nVar.e0 = jSONObject.optString("tp_dp_start");
            nVar.f0 = jSONObject.optString("tp_dp_succ");
            nVar.g0 = jSONObject.optString("tp_app_install");
            nVar.h0 = jSONObject.optString("tp_app_uninstall");
            nVar.i0 = jSONObject.optString("tp_app_unknow");
            nVar.k0 = jSONObject.optString("tp_dp_inst_fail");
            nVar.j0 = jSONObject.optString("tp_dp_uninst_fail");
            nVar.l0 = jSONObject.optString("tp_vd_succ");
            nVar.m0 = jSONObject.optString("tp_vrewarded");
            nVar.n0 = jSONObject.optString("tp_load_success");
            nVar.o0 = jSONObject.optString("tp_load_fail");
            nVar.p0 = com.smartdigimkt.r4.k.a(jSONObject.optJSONArray("vready"));
            nVar.q0 = jSONObject.optString("tp_ready");
            return nVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
