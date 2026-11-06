package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ad extends z implements Comparable<ad> {
    public static final String A = "PA";
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final String x = "";
    public static final String y = "PDB";
    public static final String z = "PD";
    private final String F;
    private boolean G;
    private by H;
    private String I;
    private a J;
    private IATAdxHandler K;
    private double L;
    private String M;
    private int N;
    private boolean O;
    private String P;
    private int Q;
    private String R;
    private String S;
    private int T;
    private String U;
    private int V;
    private String W;
    private boolean X;
    public int a;
    public String b;
    public String c;
    public int d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public double l;
    public String m;
    public int n;
    public double o;
    public double p;
    public String q;
    public double r;
    public com.anythink.core.c.c.c s;
    public boolean t;
    public List<ac> u;
    public cg v;
    public JSONObject w;

    public interface a {
        void a();

        void b();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ad adVar) {
        return com.anythink.core.common.u.k.a(this, adVar);
    }

    private ad(boolean z2, double d, String str, String str2, String str3, String str4, String str5) {
        super(z2, d, str, str2, str3, str4, str5, ATAdConst.CURRENCY.USD);
        this.F = getClass().getSimpleName() + ":";
        this.L = 0.0d;
        this.Q = -1;
        this.S = "";
        this.T = 0;
    }

    public ad(boolean z2, double d, double d2, String str, String str2, String str3, String str4, String str5) {
        super(z2, d2, str, str2, str3, str4, str5, ATAdConst.CURRENCY.USD);
        this.F = getClass().getSimpleName() + ":";
        this.L = 0.0d;
        this.Q = -1;
        this.S = "";
        this.T = 0;
        this.sortPrice = d;
    }

    public final boolean a() {
        return this.f < System.currentTimeMillis();
    }

    public final String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.f.i.a.c, this.token);
            jSONObject.put("cur", this.b);
            jSONObject.put("origin_price", this.originPrice);
            jSONObject.put(com.anythink.core.d.b.e.a.h, this.price);
            jSONObject.put("nurl", this.winNoticeUrl);
            jSONObject.put("lurl", this.loseNoticeUrl);
            jSONObject.put("unit_id", this.c);
            jSONObject.put("nw_firm_id", this.d);
            jSONObject.put("is_success", this.isSuccess ? 1 : 0);
            jSONObject.put("err_code", this.a);
            jSONObject.put("err_msg", this.errorMsg);
            jSONObject.put("expire", this.e);
            jSONObject.put("out_data_time", this.f);
            jSONObject.put("is_send_winurl", this.G);
            jSONObject.put("tp_bid_id", this.g);
            jSONObject.put("burl", this.displayNoticeUrl);
            jSONObject.put("ad_source_id", this.k);
            jSONObject.put("cur_rate", this.l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.core.common.k.aj, this.n);
            jSONObject.put("ctrl", jSONObject2);
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("bid_response", this.m);
            }
            jSONObject.put("ecpm_api", this.o);
            jSONObject.put("cny_ecpm_api", this.p);
            jSONObject.put(com.anythink.core.common.k.U, this.q);
            jSONObject.put("second_price", this.r);
            jSONObject.put(com.anythink.core.common.f.h.b.d, this.h);
            jSONObject.put("bd_type", this.useType);
            jSONObject.put(com.anythink.core.common.k.aq, this.sortPrice);
            jSONObject.put("cny_price", this.rmbPrice);
            jSONObject.put("request_id", this.I);
            jSONObject.put("a_r", this.L);
            JSONObject jSONObject3 = this.w;
            if (jSONObject3 != null) {
                jSONObject.put("adx_ctrl", jSONObject3);
            }
            if (!TextUtils.isEmpty(this.M)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(com.anythink.core.common.k.aU, this.M);
                jSONObject4.put("id", this.N);
                if (!TextUtils.isEmpty(this.P)) {
                    jSONObject4.put("cny_e_c", this.P);
                }
                jSONObject.put(com.anythink.core.e.l.a.aB, jSONObject4);
            }
            jSONObject.put("adx_mtg_mix_type", this.Q);
            jSONObject.put("deal_type", this.S);
            jSONObject.put("deal_id", this.U);
            jSONObject.put("deal_pri", this.V);
            jSONObject.put("origin_request_id", getOriginRequestId());
            jSONObject.put("x_c", this.W);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static ad a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ad a(JSONObject jSONObject) {
        try {
            ad adVar = new ad(jSONObject.optInt("is_success") == 1, jSONObject.has(com.anythink.core.d.b.e.a.h) ? jSONObject.optDouble(com.anythink.core.d.b.e.a.h, 0.0d) : 0.0d, jSONObject.optString(com.anythink.core.common.f.i.a.c), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            adVar.b = jSONObject.optString("cur");
            adVar.c = jSONObject.optString("unit_id");
            adVar.d = jSONObject.optInt("nw_firm_id");
            adVar.a = jSONObject.optInt("err_code");
            adVar.e = jSONObject.optLong("expire");
            adVar.f = jSONObject.optLong("out_data_time");
            adVar.G = jSONObject.optBoolean("is_send_winurl");
            adVar.i = jSONObject.optString(com.anythink.core.common.f.i.a.g);
            adVar.g = jSONObject.optString("tp_bid_id");
            adVar.j = jSONObject.optString("burl_win");
            adVar.k = jSONObject.optString("ad_source_id");
            adVar.l = jSONObject.optDouble("cur_rate", 0.0d);
            adVar.m = jSONObject.optString("bid_response");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ctrl");
            if (jSONObjectOptJSONObject != null) {
                adVar.n = jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.aj);
            }
            adVar.o = jSONObject.optDouble("ecpm_api", 0.0d);
            adVar.p = jSONObject.optDouble("cny_ecpm_api", 0.0d);
            adVar.q = jSONObject.optString(com.anythink.core.common.k.U);
            adVar.r = jSONObject.optDouble("second_price", 0.0d);
            adVar.h = jSONObject.optString(com.anythink.core.common.f.h.b.d, "");
            adVar.useType = jSONObject.optInt("bd_type", 1);
            adVar.sortPrice = jSONObject.optDouble(com.anythink.core.common.k.aq, adVar.price);
            adVar.originPrice = jSONObject.optDouble("origin_price", adVar.sortPrice);
            adVar.rmbPrice = jSONObject.optDouble("cny_price", 0.0d);
            if (adVar.d == 1) {
                double d = adVar.o;
                if (d > 0.0d) {
                    adVar.price = d;
                    adVar.sortPrice = adVar.o;
                }
                double d2 = adVar.p;
                if (d2 > 0.0d) {
                    adVar.rmbPrice = d2;
                }
            }
            if (adVar.d == 66) {
                adVar.L = jSONObject.optDouble("a_r", 0.0d);
            }
            Object objOpt = jSONObject.opt("request_id");
            if (objOpt != null) {
                adVar.I = objOpt.toString();
            }
            adVar.w = jSONObject.optJSONObject("adx_ctrl");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.anythink.core.e.l.a.aB);
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                adVar.M = jSONObjectOptJSONObject2.optString(com.anythink.core.common.k.aU);
                adVar.P = jSONObjectOptJSONObject2.optString("cny_e_c");
                adVar.N = jSONObjectOptJSONObject2.optInt("id");
            }
            byte b = -1;
            adVar.Q = jSONObject.optInt("adx_mtg_mix_type", -1);
            String strOptString = jSONObject.optString("deal_type", "");
            adVar.S = strOptString;
            int iHashCode = strOptString.hashCode();
            if (iHashCode != 0) {
                if (iHashCode != 2545) {
                    if (iHashCode != 2548) {
                        if (iHashCode == 79054 && strOptString.equals(y)) {
                            b = 0;
                        }
                    } else if (strOptString.equals(z)) {
                        b = 1;
                    }
                } else if (strOptString.equals(A)) {
                    b = 2;
                }
            } else if (strOptString.equals("")) {
                b = 3;
            }
            if (b == 0) {
                adVar.T = 3;
            } else if (b == 1) {
                adVar.T = 2;
            } else if (b == 2) {
                adVar.T = 1;
            } else {
                adVar.T = 0;
            }
            adVar.U = jSONObject.optString("deal_id", "");
            adVar.V = jSONObject.optInt("deal_pri", 0);
            adVar.setOriginRequestId(jSONObject.optString("origin_request_id", ""));
            adVar.W = jSONObject.optString("x_c", "");
            return adVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int a(ad adVar) {
        return com.anythink.core.common.u.k.a(this, adVar);
    }

    public final void b(String str) {
        this.I = str;
    }

    public final String c() {
        return this.I;
    }

    public final synchronized boolean d() {
        if (this.G) {
            return true;
        }
        this.G = true;
        return false;
    }

    public final synchronized void e() {
        this.biddingNotice = null;
    }

    public final synchronized void a(ac acVar) {
        if (acVar == null) {
            return;
        }
        if (this.u == null) {
            this.u = Collections.synchronizedList(new ArrayList(4));
        }
        if (!this.u.contains(acVar)) {
            this.u.add(acVar);
        }
    }

    public final synchronized by f() {
        by byVar;
        List<ac> list = this.u;
        byVar = null;
        if (list != null) {
            Iterator<ac> it = list.iterator();
            while (it.hasNext()) {
                by byVarB = it.next().b();
                if (byVarB != null && com.anythink.core.common.u.k.a(byVarB, byVar) < 0) {
                    byVar = byVarB;
                }
            }
        }
        return byVar;
    }

    public final synchronized by g() {
        by byVar;
        List<ac> list = this.u;
        byVar = null;
        if (list != null) {
            Iterator<ac> it = list.iterator();
            while (it.hasNext()) {
                by byVarC = it.next().c();
                if (byVarC != null && com.anythink.core.common.u.k.a(byVarC, byVar) < 0) {
                    byVar = byVarC;
                }
            }
        }
        return byVar;
    }

    public final synchronized void h() {
        List<ac> list = this.u;
        if (list != null) {
            list.clear();
        }
    }

    private cg A() {
        return this.v;
    }

    private void a(cg cgVar) {
        this.v = cgVar;
    }

    public final void a(IATAdxHandler iATAdxHandler) {
        this.K = iATAdxHandler;
    }

    public final IATAdxHandler i() {
        return this.K;
    }

    public final double j() {
        return this.L;
    }

    private a B() {
        return this.J;
    }

    private void a(a aVar) {
        this.J = aVar;
    }

    public final by k() {
        return this.H;
    }

    public final void a(by byVar, double d) {
        this.H = byVar;
        this.r = d;
    }

    public final String l() {
        return this.M;
    }

    private void d(String str) {
        this.M = str;
    }

    public final String m() {
        return this.P;
    }

    private void e(String str) {
        this.P = str;
    }

    public final int n() {
        return this.N;
    }

    private void b(int i) {
        this.N = i;
    }

    public final boolean o() {
        return this.O;
    }

    public final void p() {
        this.O = true;
    }

    public final String q() {
        return this.R;
    }

    public final void c(String str) {
        this.R = str;
    }

    public final int a(int i) {
        int i2 = this.Q;
        if (i2 < 0 || i != 4) {
            return -1;
        }
        return i2 == 5 ? 3 : 4;
    }

    private List<ac> C() {
        return this.u;
    }

    public final boolean r() {
        return this.T != 0;
    }

    public final int s() {
        return this.T;
    }

    public final String t() {
        return this.S;
    }

    public final String u() {
        return this.U;
    }

    public final int v() {
        return this.V;
    }

    public final String w() {
        return this.W;
    }

    public final void x() {
        this.X = true;
    }

    public final boolean y() {
        return this.X;
    }

    public final com.anythink.core.bridge.entity.c z() {
        com.anythink.core.bridge.entity.c cVar = new com.anythink.core.bridge.entity.c();
        cVar.a = this.isSuccess;
        cVar.b = this.token;
        cVar.c = Double.valueOf(this.price);
        cVar.d = this.winNoticeUrl;
        cVar.e = this.loseNoticeUrl;
        cVar.g = this.errorMsg;
        cVar.h = this.b;
        cVar.i = this.c;
        cVar.j = this.d;
        cVar.k = this.a;
        cVar.l = this.e;
        cVar.m = this.f;
        cVar.n = this.G;
        cVar.o = this.i;
        cVar.p = this.g;
        cVar.q = this.j;
        cVar.r = this.k;
        cVar.s = this.l;
        cVar.t = this.o;
        cVar.u = this.p;
        cVar.v = this.q;
        cVar.w = this.h;
        cVar.x = this.useType;
        cVar.y = this.sortPrice;
        cVar.z = this.originPrice;
        cVar.A = this.rmbPrice;
        cVar.B = this.L;
        cVar.C = this.I;
        cVar.D = this.Q;
        cVar.E = this.S;
        cVar.F = this.T;
        cVar.G = this.U;
        cVar.H = this.V;
        cVar.I = this.originRequestId;
        cVar.J = this.W;
        cVar.K = this.M;
        cVar.L = this.P;
        cVar.M = this.N;
        return cVar;
    }
}
