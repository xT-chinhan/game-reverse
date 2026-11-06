package com.anythink.core.common.h;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ac {
    static final String a = "reqId";
    static final String b = "hasShow";
    static final String c = "hasClick";
    static final String d = "price";
    static final String e = "networkFirmId";
    static final String f = "isHB";
    static final String g = "adsListType";
    static final String h = "tpBidId";
    static final String i = "deal_type";
    static final String j = "deal_id";
    static final String k = "deal_pri";
    private static String l = "ac";
    private boolean m;
    private final String n;
    private boolean o;
    private boolean p;
    private bv q;
    private bv r;
    private int s;
    private double t;
    private boolean u;
    private int v;
    private String w;
    private String x;
    private String y;
    private int z;

    private static int a(int i2) {
        if (i2 == 2) {
            return 3;
        }
        if (i2 != 3) {
            if (i2 == 4 || i2 == 5) {
                return 4;
            }
            if (i2 == 7) {
                return 3;
            }
            if (i2 != 8 && i2 != 11) {
                return 1;
            }
        }
        return 2;
    }

    public ac(String str) {
        this.n = str;
    }

    public final synchronized void a(bv bvVar) {
        new StringBuilder("refresh: ").append(bvVar);
        this.q = bvVar;
    }

    public final synchronized void b(bv bvVar) {
        new StringBuilder("refreshSecond: ").append(bvVar);
        this.r = bvVar;
    }

    public final synchronized bv a() {
        return this.q;
    }

    public final synchronized bv b() {
        return this.r;
    }

    public final String c() {
        return this.n;
    }

    public final void d() {
        this.o = true;
    }

    public final void e() {
        this.p = true;
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.p;
    }

    public String toString() {
        String str = this.m ? ", priceInDisk=" + this.t + ", networkFirmIdInDisk=" + this.s + ", winnerIsHBInDisk=" + this.u + ", adsListTypeInDisk=" + this.v + ", tpBidIdInDisk=" + this.w + ", pmpTypeStringInDisk=" + this.x + ", pmpOrderIdInDisk=" + this.y + ", pmpPriorityInDisk=" + this.z : null;
        StringBuilder sbAppend = new StringBuilder("BiddingRecorder{fromLocalDisk=").append(this.m);
        if (str == null) {
            str = "";
        }
        return sbAppend.append(str).append(", requestId=").append(this.n).append(", hasShow=").append(this.o).append(", hasClick=").append(this.p).append(", loadedMaxPriceUgInMemory=").append(this.q).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public final String h() {
        int i2;
        double d2;
        int i3;
        int iA;
        String str;
        String str2;
        String strV;
        String strU;
        JSONObject jSONObject = new JSONObject();
        try {
            int i4 = 1;
            int iW = 0;
            int i5 = this.o ? 1 : 0;
            if (!this.p) {
                i4 = 0;
            }
            if (this.m) {
                d2 = this.t;
                i3 = this.s;
                iA = a(this.v);
                str = this.w;
                str2 = this.x;
                strV = this.y;
                i2 = this.z;
            } else {
                double dA = com.anythink.core.common.v.p.a(this.q);
                int iG = this.q.g();
                ad adVarR = this.q.R();
                int iA2 = a(this.q.d());
                String str3 = (adVarR == null || TextUtils.isEmpty(adVarR.g)) ? "" : adVarR.g;
                if (adVarR != null) {
                    if (TextUtils.isEmpty(adVarR.u())) {
                        strU = "";
                    } else {
                        strU = adVarR.u();
                        iW = adVarR.w();
                    }
                    if (TextUtils.isEmpty(adVarR.v())) {
                        str = str3;
                        strV = "";
                        String str4 = strU;
                        i2 = iW;
                        d2 = dA;
                        i3 = iG;
                        iA = iA2;
                        str2 = str4;
                    } else {
                        String str5 = strU;
                        i2 = iW;
                        d2 = dA;
                        i3 = iG;
                        iA = iA2;
                        str2 = str5;
                        String str6 = str3;
                        strV = adVarR.v();
                        str = str6;
                    }
                } else {
                    i2 = 0;
                    d2 = dA;
                    i3 = iG;
                    iA = iA2;
                    str = str3;
                    str2 = "";
                    strV = str2;
                }
            }
            jSONObject.put("price", d2);
            jSONObject.put(e, i3);
            jSONObject.put("demandType", iA);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("tp_bid_id", str);
            }
            jSONObject.put(com.umeng.analytics.pro.be.c, i5);
            jSONObject.put("click", i4);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(i, str2);
                jSONObject.put(k, i2);
            }
            if (!TextUtils.isEmpty(strV)) {
                jSONObject.put(j, strV);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ac a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ac acVar = new ac(jSONObject.getString(a));
            acVar.m = true;
            acVar.o = jSONObject.optBoolean(b);
            acVar.p = jSONObject.optBoolean(c);
            acVar.t = jSONObject.optDouble("price", -1.0d);
            acVar.s = jSONObject.optInt(e);
            acVar.u = jSONObject.optBoolean(f);
            acVar.v = jSONObject.optInt(g);
            acVar.w = jSONObject.optString(h);
            acVar.x = jSONObject.optString(i, "");
            acVar.y = jSONObject.optString(j, "");
            acVar.z = jSONObject.optInt(k, 0);
            return acVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final synchronized JSONObject i() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.n);
            jSONObject.put(b, this.o);
            jSONObject.put(c, this.p);
            bv bvVar = this.q;
            if (bvVar != null) {
                jSONObject.put("price", com.anythink.core.common.v.p.a(bvVar));
                jSONObject.put(e, this.q.g());
                jSONObject.put(f, this.q.o());
                jSONObject.put(g, this.q.d());
                ad adVarR = this.q.R();
                if (adVarR != null && !TextUtils.isEmpty(adVarR.g)) {
                    jSONObject.put(h, adVarR.g);
                }
                if (adVarR != null) {
                    if (!TextUtils.isEmpty(adVarR.u())) {
                        jSONObject.put(i, adVarR.u());
                        jSONObject.put(k, adVarR.w());
                    }
                    if (!TextUtils.isEmpty(adVarR.v())) {
                        jSONObject.put(j, adVarR.v());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private boolean m() {
        return this.m;
    }

    public final double j() {
        if (this.m) {
            return this.t;
        }
        bv bvVar = this.q;
        if (bvVar != null) {
            return com.anythink.core.common.v.p.a(bvVar);
        }
        return -1.0d;
    }

    public final int k() {
        if (this.m) {
            return this.s;
        }
        bv bvVar = this.q;
        if (bvVar != null) {
            return bvVar.g();
        }
        return 0;
    }

    public final boolean l() {
        if (this.m) {
            return this.u;
        }
        bv bvVar = this.q;
        if (bvVar != null) {
            return bvVar.o();
        }
        return false;
    }
}
