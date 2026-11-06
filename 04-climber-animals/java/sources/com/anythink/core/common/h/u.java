package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import com.anythink.core.mg.api.MgPreLoadCallbackRegister;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u extends av {
    public static final String a = "send_count";
    public static final int b = 5;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
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
    public JSONObject T;
    public String U;
    public JSONObject Y;
    public String Z;
    public String aa;
    private ATAdRequest ac;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;
    public int m = -1;
    public int n = -1;
    public int V = -1;
    public int W = -1;
    public int X = -1;
    public int ab = com.anythink.core.common.d.t.b().E();

    private u() {
    }

    public u(String str, String str2) {
        this.P = str;
        this.Q = str2;
    }

    public final void a(n nVar) {
        if (nVar != null) {
            this.d = nVar.aJ();
            this.e = nVar.aI();
            this.P = nVar.aK();
            this.o = String.valueOf(nVar.aG());
            this.h = String.valueOf(nVar.Z());
            this.l = String.valueOf(nVar.U());
            this.m = nVar.V();
            this.n = nVar.W();
            this.k = nVar.aH();
            this.R = nVar.aB();
            this.S = nVar.aC();
            this.Z = nVar.az();
            this.aa = nVar.aM();
            a(nVar.a());
        }
    }

    public final void a(x xVar) {
        if (xVar != null) {
            this.d = xVar.d;
            this.e = xVar.b;
            this.h = String.valueOf(xVar.i);
            this.o = String.valueOf(xVar.h);
            this.Z = xVar.s;
            this.aa = xVar.t;
            this.ab = xVar.u;
        }
    }

    public final void a(com.anythink.core.d.l lVar) {
        if (lVar != null) {
            a(lVar.s());
        }
    }

    public final void a(ATAdRequest aTAdRequest) {
        if (aTAdRequest != null) {
            this.ab = aTAdRequest.getChannelSource();
        } else {
            this.ab = com.anythink.core.common.d.t.b().E();
        }
        this.ac = aTAdRequest;
    }

    @Override // com.anythink.core.common.h.av
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.e.f.a.b, this.c);
            jSONObject.put("requestid", this.d);
            jSONObject.put("unitid", this.e);
            jSONObject.put(com.anythink.core.common.d.g.c, this.f);
            jSONObject.put("sessionid", this.g);
            jSONObject.put("groupid", this.h);
            jSONObject.put("unitgroupid", this.i);
            jSONObject.put("timestamp", this.j);
            jSONObject.put("asid", this.k);
            jSONObject.put("refresh", this.l);
            int i = this.m;
            if (i != -1) {
                jSONObject.put("refresh_v2", i);
            }
            int i2 = this.n;
            if (i2 != -1) {
                jSONObject.put("load_mode", i2);
            }
            int i3 = this.X;
            if (i3 != -1) {
                jSONObject.put(com.anythink.core.common.m.e.be, i3);
            }
            jSONObject.put("traffic_group_id", this.o);
            jSONObject.put("msg", this.p);
            jSONObject.put("msg1", this.q);
            jSONObject.put("msg2", this.r);
            jSONObject.put("msg3", this.s);
            jSONObject.put("msg4", this.t);
            jSONObject.put("msg5", this.u);
            jSONObject.put("msg6", this.v);
            jSONObject.put("msg7", this.w);
            jSONObject.put("msg8", this.x);
            jSONObject.put("msg9", this.y);
            jSONObject.put("msg10", this.z);
            jSONObject.put("msg11", this.A);
            jSONObject.put("msg12", this.B);
            jSONObject.put("msg13", this.C);
            jSONObject.put("msg14", this.D);
            jSONObject.put("msg15", this.E);
            jSONObject.put("msg16", this.F);
            jSONObject.put("msg17", this.G);
            jSONObject.put("msg18", this.H);
            jSONObject.put("msg19", this.I);
            jSONObject.put("msg20", this.J);
            jSONObject.put("msg21", this.K);
            jSONObject.put("msg22", this.L);
            jSONObject.put("msg23", this.M);
            jSONObject.put("msg24", this.N);
            jSONObject.put("msg25", this.O);
            jSONObject.put(com.anythink.core.d.l.a.T, this.R);
            jSONObject.put(com.anythink.core.common.m.e.ai, this.S);
            JSONObject jSONObject2 = this.T;
            if (jSONObject2 != null) {
                jSONObject.put(com.anythink.core.d.l.a.aa, jSONObject2);
            }
            jSONObject.put("real_p", this.U);
            int i4 = this.V;
            if (i4 != -1) {
                jSONObject.put("real_g", i4);
            }
            int i5 = this.W;
            if (i5 != -1) {
                jSONObject.put("real_t", i5);
            }
            JSONObject jSONObject3 = this.Y;
            if (jSONObject3 != null) {
                jSONObject.put("adap_c", jSONObject3);
            }
            if (!TextUtils.isEmpty(this.Z)) {
                jSONObject.put("x_c", new JSONArray(this.Z));
            }
            if (!TextUtils.isEmpty(this.aa)) {
                jSONObject.put("o_r", this.aa);
            }
            jSONObject.put(com.anythink.core.common.m.e.bp, this.ab);
            ATAdRequest aTAdRequest = this.ac;
            MgPreLoadAdRequest preLoadInfo = (aTAdRequest == null || aTAdRequest.getPreLoadInfo() == null) ? null : this.ac.getPreLoadInfo();
            if (preLoadInfo != null) {
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
                MgPreLoadCallbackRegister preLoadCallbackRegister = preLoadInfo.getPreLoadCallbackRegister();
                MgAdInfo mgAdInfo = preLoadCallbackRegister != null ? preLoadCallbackRegister.getMgAdInfo() : null;
                double uSDEcpm = mgAdInfo != null ? mgAdInfo.getUSDEcpm() : 0.0d;
                if (uSDEcpm > 0.0d) {
                    jSONObject.put("mmed_price", String.valueOf(uSDEcpm));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static u a(String str) {
        u uVar = new u();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(com.anythink.core.common.e.f.a.b)) {
                    uVar.c = jSONObject.optString(com.anythink.core.common.e.f.a.b, "");
                }
                if (jSONObject.has("requestid")) {
                    uVar.d = jSONObject.optString("requestid", "");
                }
                if (jSONObject.has("unitid")) {
                    uVar.e = jSONObject.optString("unitid", "");
                }
                if (jSONObject.has(com.anythink.core.common.d.g.c)) {
                    uVar.f = jSONObject.optString(com.anythink.core.common.d.g.c, "");
                }
                if (jSONObject.has("sessionid")) {
                    uVar.g = jSONObject.optString("sessionid", "");
                }
                if (jSONObject.has("groupid")) {
                    uVar.h = jSONObject.optString("groupid", "");
                }
                if (jSONObject.has("unitgroupid")) {
                    uVar.i = jSONObject.optString("unitgroupid", "");
                }
                if (jSONObject.has("timestamp")) {
                    uVar.j = jSONObject.optString("timestamp", "");
                }
                if (jSONObject.has("asid")) {
                    uVar.k = jSONObject.optString("asid", "");
                }
                if (jSONObject.has("refresh")) {
                    uVar.l = jSONObject.optString("refresh", "");
                }
                if (jSONObject.has(com.anythink.core.common.m.e.be)) {
                    uVar.X = jSONObject.optInt(com.anythink.core.common.m.e.be, 0);
                }
                if (jSONObject.has("traffic_group_id")) {
                    uVar.o = jSONObject.optString("traffic_group_id", "");
                }
                if (jSONObject.has("msg")) {
                    uVar.p = jSONObject.optString("msg", "");
                }
                if (jSONObject.has("msg1")) {
                    uVar.q = jSONObject.optString("msg1", "");
                }
                if (jSONObject.has("msg2")) {
                    uVar.r = jSONObject.optString("msg2", "");
                }
                if (jSONObject.has("msg3")) {
                    uVar.s = jSONObject.optString("msg3", "");
                }
                if (jSONObject.has("msg4")) {
                    uVar.t = jSONObject.optString("msg4", "");
                }
                if (jSONObject.has("msg5")) {
                    uVar.u = jSONObject.optString("msg5", "");
                }
                if (jSONObject.has("msg6")) {
                    uVar.v = jSONObject.optString("msg6", "");
                }
                if (jSONObject.has("msg7")) {
                    uVar.w = jSONObject.optString("msg7", "");
                }
                if (jSONObject.has("msg8")) {
                    uVar.x = jSONObject.optString("msg8", "");
                }
                if (jSONObject.has("msg9")) {
                    uVar.y = jSONObject.optString("msg9", "");
                }
                if (jSONObject.has("msg10")) {
                    uVar.z = jSONObject.optString("msg10", "");
                }
                if (jSONObject.has("msg11")) {
                    uVar.A = jSONObject.optString("msg11", "");
                }
                if (jSONObject.has("msg12")) {
                    uVar.B = jSONObject.optString("msg12", "");
                }
                if (jSONObject.has("msg13")) {
                    uVar.C = jSONObject.optString("msg13", "");
                }
                if (jSONObject.has("msg14")) {
                    uVar.D = jSONObject.optString("msg14", "");
                }
                if (jSONObject.has("msg15")) {
                    uVar.E = jSONObject.optString("msg15", "");
                }
                if (jSONObject.has(com.anythink.core.d.l.a.T)) {
                    uVar.R = jSONObject.optString(com.anythink.core.d.l.a.T, "");
                }
                if (jSONObject.has(com.anythink.core.common.m.e.ai)) {
                    uVar.S = jSONObject.optString(com.anythink.core.common.m.e.ai, "");
                }
                if (jSONObject.has(com.anythink.core.d.l.a.aa)) {
                    uVar.T = jSONObject.optJSONObject(com.anythink.core.d.l.a.aa);
                }
                if (jSONObject.has("adap_c")) {
                    uVar.Y = jSONObject.optJSONObject("adap_c");
                }
                uVar.U = jSONObject.optString("real_p", "");
                uVar.V = jSONObject.optInt("real_g", -1);
                uVar.W = jSONObject.optInt("real_t", -1);
                if (jSONObject.has("x_c")) {
                    uVar.Z = jSONObject.optString("x_c");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uVar;
    }

    public final void a(bv bvVar) {
        if (bvVar != null) {
            a(bvVar.y);
        }
    }

    public final void a(ae aeVar) {
        if (aeVar != null) {
            a(aeVar.c);
        }
    }
}
