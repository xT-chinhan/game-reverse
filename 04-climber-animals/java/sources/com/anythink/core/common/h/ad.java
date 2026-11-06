package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    private bv H;
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
    public com.anythink.core.b.c.b s;
    public boolean t;
    public List<ac> u;
    public cd v;
    public JSONObject w;

    public interface a {
        void a(Map<String, Object> map);

        void b(Map<String, Object> map);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ad adVar) {
        return com.anythink.core.common.v.l.a(this, adVar);
    }

    public ad(boolean z2, double d, String str, String str2, String str3, String str4, String str5) {
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
            jSONObject.put(com.anythink.core.common.e.o.a.c, this.token);
            jSONObject.put("cur", this.b);
            jSONObject.put("origin_price", this.originPrice);
            jSONObject.put("price", this.price);
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
            jSONObject2.put(com.anythink.core.common.k.ai, this.n);
            jSONObject.put("ctrl", jSONObject2);
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("bid_response", this.m);
            }
            jSONObject.put("ecpm_api", this.o);
            jSONObject.put("cny_ecpm_api", this.p);
            jSONObject.put(com.anythink.core.common.k.T, this.q);
            jSONObject.put("second_price", this.r);
            jSONObject.put("req_url", this.h);
            jSONObject.put("bd_type", this.useType);
            jSONObject.put(com.anythink.core.common.k.ap, this.sortPrice);
            jSONObject.put("cny_price", this.rmbPrice);
            jSONObject.put("request_id", this.I);
            jSONObject.put("a_r", this.L);
            JSONObject jSONObject3 = this.w;
            if (jSONObject3 != null) {
                jSONObject.put("adx_ctrl", jSONObject3);
            }
            if (!TextUtils.isEmpty(this.M)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(com.anythink.core.common.k.aS, this.M);
                jSONObject4.put("id", this.N);
                if (!TextUtils.isEmpty(this.P)) {
                    jSONObject4.put("cny_e_c", this.P);
                }
                jSONObject.put(com.anythink.core.d.l.a.aB, jSONObject4);
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
            ad adVar = new ad(jSONObject.optInt("is_success") == 1, jSONObject.has("price") ? jSONObject.optDouble("price", 0.0d) : 0.0d, jSONObject.optString(com.anythink.core.common.e.o.a.c), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            adVar.b = jSONObject.optString("cur");
            adVar.c = jSONObject.optString("unit_id");
            adVar.d = jSONObject.optInt("nw_firm_id");
            adVar.a = jSONObject.optInt("err_code");
            adVar.e = jSONObject.optLong("expire");
            adVar.f = jSONObject.optLong("out_data_time");
            adVar.G = jSONObject.optBoolean("is_send_winurl");
            adVar.i = jSONObject.optString("offer_data");
            adVar.g = jSONObject.optString("tp_bid_id");
            adVar.j = jSONObject.optString("burl_win");
            adVar.k = jSONObject.optString("ad_source_id");
            adVar.l = jSONObject.optDouble("cur_rate", 0.0d);
            adVar.m = jSONObject.optString("bid_response");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ctrl");
            if (jSONObjectOptJSONObject != null) {
                adVar.n = jSONObjectOptJSONObject.optInt(com.anythink.core.common.k.ai);
            }
            adVar.o = jSONObject.optDouble("ecpm_api", 0.0d);
            adVar.p = jSONObject.optDouble("cny_ecpm_api", 0.0d);
            adVar.q = jSONObject.optString(com.anythink.core.common.k.T);
            adVar.r = jSONObject.optDouble("second_price", 0.0d);
            adVar.h = jSONObject.optString("req_url", "");
            adVar.useType = jSONObject.optInt("bd_type", 1);
            adVar.sortPrice = jSONObject.optDouble(com.anythink.core.common.k.ap, adVar.price);
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
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.anythink.core.d.l.a.aB);
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                adVar.M = jSONObjectOptJSONObject2.optString(com.anythink.core.common.k.aS);
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
        return com.anythink.core.common.v.l.a(this, adVar);
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

    public final synchronized bv f() {
        bv bvVar;
        List<ac> list = this.u;
        bvVar = null;
        if (list != null) {
            Iterator<ac> it = list.iterator();
            while (it.hasNext()) {
                bv bvVarA = it.next().a();
                if (bvVarA != null && com.anythink.core.common.v.l.a(bvVarA, bvVar) < 0) {
                    bvVar = bvVarA;
                }
            }
        }
        return bvVar;
    }

    public final synchronized bv g() {
        bv bvVar;
        List<ac> list = this.u;
        bvVar = null;
        if (list != null) {
            Iterator<ac> it = list.iterator();
            while (it.hasNext()) {
                bv bvVarB = it.next().b();
                if (bvVarB != null && com.anythink.core.common.v.l.a(bvVarB, bvVar) < 0) {
                    bvVar = bvVarB;
                }
            }
        }
        return bvVar;
    }

    public final synchronized void h() {
        List<ac> list = this.u;
        if (list != null) {
            list.clear();
        }
    }

    private cd y() {
        return this.v;
    }

    private void a(cd cdVar) {
        this.v = cdVar;
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

    public final a k() {
        return this.J;
    }

    public final void a(a aVar) {
        this.J = aVar;
    }

    public final bv l() {
        return this.H;
    }

    public final void a(bv bvVar, double d) {
        this.H = bvVar;
        this.r = d;
    }

    public final String m() {
        return this.M;
    }

    private void d(String str) {
        this.M = str;
    }

    public final String n() {
        return this.P;
    }

    private void e(String str) {
        this.P = str;
    }

    public final int o() {
        return this.N;
    }

    private void b(int i) {
        this.N = i;
    }

    public final boolean p() {
        return this.O;
    }

    public final void q() {
        this.O = true;
    }

    public final String r() {
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

    private List<ac> z() {
        return this.u;
    }

    public final boolean s() {
        return this.T != 0;
    }

    public final int t() {
        return this.T;
    }

    public final String u() {
        return this.S;
    }

    public final String v() {
        return this.U;
    }

    public final int w() {
        return this.V;
    }

    public final String x() {
        return this.W;
    }
}
