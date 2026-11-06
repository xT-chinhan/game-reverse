package com.smartdigimkt.d3;

import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.anythink.core.common.f.i;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.k;
import com.anythink.core.d.b.e;
import com.anythink.core.e.l;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends a {
    public String A;
    public double B;
    public double C;
    public double D;
    public String E;
    public String F;
    public double G;
    public JSONObject H;
    public String I;
    public int J;
    public String K;
    public int L;
    public String M;
    public int N;
    public String O;
    public int P;
    public String Q;
    public JSONObject R;
    public int m;
    public String n;
    public String o;
    public int p;
    public long q;
    public long r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public volatile boolean w;
    public SDMLossInfo x;
    public String y;
    public String z;

    public b(boolean z, double d, String str, String str2, String str3, String str4, String str5) {
        super(z, d, str, str2, str3, str4, str5, SDMAdConst.CURRENCY.USD);
        this.G = 0.0d;
        this.L = -1;
        this.M = "";
        this.N = 0;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(i.a.c, this.e);
            jSONObject.put("cur", this.n);
            jSONObject.put("origin_price", this.b);
            jSONObject.put(e.a.h, this.c);
            jSONObject.put("nurl", this.g);
            jSONObject.put("lurl", this.h);
            jSONObject.put("unit_id", this.o);
            jSONObject.put("nw_firm_id", this.p);
            jSONObject.put("is_success", this.a ? 1 : 0);
            jSONObject.put("err_code", this.m);
            jSONObject.put("err_msg", this.f);
            jSONObject.put("expire", this.q);
            jSONObject.put("out_data_time", this.r);
            jSONObject.put("is_send_winurl", this.u);
            jSONObject.put("tp_bid_id", this.s);
            jSONObject.put("burl", this.i);
            jSONObject.put("ad_source_id", this.A);
            jSONObject.put("cur_rate", this.B);
            jSONObject.put("ecpm_api", this.C);
            jSONObject.put("cny_ecpm_api", this.D);
            jSONObject.put(k.U, this.E);
            jSONObject.put(h.b.d, this.t);
            jSONObject.put("bd_type", this.k);
            jSONObject.put(k.aq, this.d);
            jSONObject.put("cny_price", this.l);
            jSONObject.put("request_id", this.F);
            jSONObject.put("a_r", this.G);
            Object obj = this.H;
            if (obj != null) {
                jSONObject.put("adx_ctrl", obj);
            }
            if (!TextUtils.isEmpty(this.I)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(k.aU, this.I);
                jSONObject2.put("id", this.J);
                if (!TextUtils.isEmpty(this.K)) {
                    jSONObject2.put("cny_e_c", this.K);
                }
                jSONObject.put(l.a.aB, jSONObject2);
            }
            jSONObject.put("adx_mtg_mix_type", this.L);
            jSONObject.put("deal_type", this.M);
            jSONObject.put("deal_id", this.O);
            jSONObject.put("deal_pri", this.P);
            jSONObject.put("origin_request_id", this.j);
            jSONObject.put("x_c", this.Q);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public b(boolean z, double d, double d2, String str, String str2, String str3, String str4, String str5) {
        super(z, d2, str, str2, str3, str4, str5, SDMAdConst.CURRENCY.USD);
        this.G = 0.0d;
        this.L = -1;
        this.M = "";
        this.N = 0;
        this.d = d;
    }

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c(jSONObject.optInt("is_success") == 1, jSONObject.has(e.a.h) ? jSONObject.optDouble(e.a.h, 0.0d) : 0.0d, jSONObject.optString(i.a.c), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            cVar.n = jSONObject.optString("cur");
            cVar.o = jSONObject.optString("unit_id");
            cVar.p = jSONObject.optInt("nw_firm_id");
            cVar.m = jSONObject.optInt("err_code");
            cVar.q = jSONObject.optLong("expire");
            cVar.r = jSONObject.optLong("out_data_time");
            cVar.u = jSONObject.optBoolean("is_send_winurl");
            cVar.y = jSONObject.optString(i.a.g);
            cVar.s = jSONObject.optString("tp_bid_id");
            cVar.z = jSONObject.optString("burl_win");
            cVar.A = jSONObject.optString("ad_source_id");
            cVar.B = jSONObject.optDouble("cur_rate", 0.0d);
            cVar.C = jSONObject.optDouble("ecpm_api", 0.0d);
            cVar.D = jSONObject.optDouble("cny_ecpm_api", 0.0d);
            cVar.E = jSONObject.optString(k.U);
            cVar.t = jSONObject.optString(h.b.d, "");
            cVar.k = jSONObject.optInt("bd_type", 1);
            double dOptDouble = jSONObject.optDouble(k.aq, cVar.c);
            cVar.d = dOptDouble;
            cVar.b = jSONObject.optDouble("origin_price", dOptDouble);
            cVar.l = jSONObject.optDouble("cny_price", 0.0d);
            int i = cVar.p;
            if (i == 1) {
                double d = cVar.C;
                if (d > 0.0d) {
                    cVar.c = d;
                    cVar.d = d;
                }
                double d2 = cVar.D;
                if (d2 > 0.0d) {
                    cVar.l = d2;
                }
            }
            if (i == 66) {
                cVar.G = jSONObject.optDouble("a_r", 0.0d);
            }
            Object objOpt = jSONObject.opt("request_id");
            if (objOpt != null) {
                cVar.F = objOpt.toString();
            }
            cVar.H = jSONObject.optJSONObject("adx_ctrl");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(l.a.aB);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                cVar.I = jSONObjectOptJSONObject.optString(k.aU);
                cVar.K = jSONObjectOptJSONObject.optString("cny_e_c");
                cVar.J = jSONObjectOptJSONObject.optInt("id");
            }
            byte b = -1;
            cVar.L = jSONObject.optInt("adx_mtg_mix_type", -1);
            String strOptString = jSONObject.optString("deal_type", "");
            cVar.M = strOptString;
            int iHashCode = strOptString.hashCode();
            if (iHashCode != 0) {
                if (iHashCode != 2545) {
                    if (iHashCode != 2548) {
                        if (iHashCode == 79054 && strOptString.equals(ad.y)) {
                            b = 0;
                        }
                    } else if (strOptString.equals(ad.z)) {
                        b = 1;
                    }
                } else if (strOptString.equals(ad.A)) {
                    b = 2;
                }
            } else if (strOptString.equals("")) {
                b = 3;
            }
            if (b == 0) {
                cVar.N = 3;
            } else if (b == 1) {
                cVar.N = 2;
            } else if (b != 2) {
                cVar.N = 0;
            } else {
                cVar.N = 1;
            }
            cVar.O = jSONObject.optString("deal_id", "");
            cVar.P = jSONObject.optInt("deal_pri", 0);
            cVar.j = jSONObject.optString("origin_request_id", "");
            cVar.Q = jSONObject.optString("x_c", "");
            cVar.R = jSONObject.optJSONObject(i.a.g);
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final synchronized boolean a(boolean z, SDMLossInfo sDMLossInfo) {
        if (this.u) {
            return true;
        }
        this.u = true;
        if (z) {
            this.v = true;
        } else {
            this.w = true;
            this.x = sDMLossInfo;
        }
        return false;
    }
}
