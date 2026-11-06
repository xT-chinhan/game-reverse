package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
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
    private int A;
    private final Map<String, Map<String, Object>> B = new HashMap();
    private boolean m;
    private final String n;
    private boolean o;
    private boolean p;
    private by q;
    private by r;
    private by s;
    private int t;
    private double u;
    private boolean v;
    private int w;
    private String x;
    private String y;
    private String z;

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

    public final synchronized void a(by byVar) {
        this.q = byVar;
    }

    public final synchronized void b(by byVar) {
        this.r = byVar;
    }

    public final synchronized void c(by byVar) {
        this.s = byVar;
    }

    public final by a() {
        return this.r;
    }

    public final synchronized by b() {
        return this.q;
    }

    public final synchronized by c() {
        return this.s;
    }

    public final String d() {
        return this.n;
    }

    public final void e() {
        this.o = true;
    }

    public final void f() {
        this.p = true;
    }

    public final boolean g() {
        return this.o;
    }

    public final boolean h() {
        return this.p;
    }

    public String toString() {
        String str = this.m ? ", priceInDisk=" + this.u + ", networkFirmIdInDisk=" + this.t + ", winnerIsHBInDisk=" + this.v + ", adsListTypeInDisk=" + this.w + ", tpBidIdInDisk=" + this.x + ", pmpTypeStringInDisk=" + this.y + ", pmpOrderIdInDisk=" + this.z + ", pmpPriorityInDisk=" + this.A : null;
        StringBuilder sbAppend = new StringBuilder("BiddingRecorder{fromLocalDisk=").append(this.m);
        if (str == null) {
            str = "";
        }
        return sbAppend.append(str).append(", requestId=").append(this.n).append(", hasShow=").append(this.o).append(", hasClick=").append(this.p).append(", loadedMaxPriceUgInMemory=").append(this.q).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public final String i() {
        int i2;
        double d2;
        int i3;
        int iA;
        String str;
        String str2;
        String strU;
        String strT;
        JSONObject jSONObject = new JSONObject();
        try {
            int i4 = 1;
            int iV = 0;
            int i5 = this.o ? 1 : 0;
            if (!this.p) {
                i4 = 0;
            }
            if (this.m) {
                d2 = this.u;
                i3 = this.t;
                iA = a(this.w);
                str = this.x;
                str2 = this.y;
                strU = this.z;
                i2 = this.A;
            } else {
                double dA = com.anythink.core.common.u.o.a(this.q);
                int iN = this.q.n();
                ad adVarY = this.q.Y();
                int iA2 = a(this.q.k());
                String str3 = (adVarY == null || TextUtils.isEmpty(adVarY.g)) ? "" : adVarY.g;
                if (adVarY != null) {
                    if (TextUtils.isEmpty(adVarY.t())) {
                        strT = "";
                    } else {
                        strT = adVarY.t();
                        iV = adVarY.v();
                    }
                    if (TextUtils.isEmpty(adVarY.u())) {
                        str = str3;
                        strU = "";
                        String str4 = strT;
                        i2 = iV;
                        d2 = dA;
                        i3 = iN;
                        iA = iA2;
                        str2 = str4;
                    } else {
                        String str5 = strT;
                        i2 = iV;
                        d2 = dA;
                        i3 = iN;
                        iA = iA2;
                        str2 = str5;
                        String str6 = str3;
                        strU = adVarY.u();
                        str = str6;
                    }
                } else {
                    i2 = 0;
                    d2 = dA;
                    i3 = iN;
                    iA = iA2;
                    str = str3;
                    str2 = "";
                    strU = str2;
                }
            }
            jSONObject.put("price", d2);
            jSONObject.put(e, i3);
            jSONObject.put("demandType", iA);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("tp_bid_id", str);
            }
            jSONObject.put("imp", i5);
            jSONObject.put("click", i4);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(i, str2);
                jSONObject.put(k, i2);
            }
            if (!TextUtils.isEmpty(strU)) {
                jSONObject.put(j, strU);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean m() {
        return this.m;
    }

    public final double j() {
        if (this.m) {
            return this.u;
        }
        by byVar = this.q;
        if (byVar != null) {
            return com.anythink.core.common.u.o.a(byVar);
        }
        return -1.0d;
    }

    public final int k() {
        if (this.m) {
            return this.t;
        }
        by byVar = this.q;
        if (byVar != null) {
            return byVar.n();
        }
        return 0;
    }

    public final boolean l() {
        if (this.m) {
            return this.v;
        }
        by byVar = this.q;
        if (byVar != null) {
            return byVar.w();
        }
        return false;
    }

    public final synchronized Map<String, Object> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.B.get(str);
    }

    public final synchronized void a(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            this.B.put(str, new HashMap(map));
        }
    }
}
