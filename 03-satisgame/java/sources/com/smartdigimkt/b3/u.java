package com.smartdigimkt.b3;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Serializable {
    public static final u i = new u(0, "", "", "", 3, 0.0d, 0, 0.0d);
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final double f;
    public final long g;
    public final double h;

    public u(int i2, String str, String str2, String str3, int i3, double d, long j, double d2) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i3;
        this.f = d;
        this.g = j;
        this.h = d2;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3  */
    public static u a(JSONObject jSONObject) {
        r rVar;
        int i2;
        if (jSONObject == null) {
            return i;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interaction");
        if (jSONObjectOptJSONObject == null) {
            return i;
        }
        int iOptInt = (!jSONObjectOptJSONObject.has("a_s_way_n") || jSONObjectOptJSONObject.opt("a_s_way_n") == JSONObject.NULL) ? 0 : jSONObjectOptJSONObject.optInt("a_s_way_n");
        String str = iOptInt == 2 ? "s_s_a_n" : "s_m_a_n";
        if (jSONObjectOptJSONObject.has(str)) {
            Object objOpt = jSONObjectOptJSONObject.opt(str);
            Object obj = JSONObject.NULL;
            if (objOpt != obj) {
                Object objOpt2 = jSONObjectOptJSONObject.opt(str);
                String strValueOf = (objOpt2 == null || objOpt2 == obj) ? "" : String.valueOf(objOpt2);
                if (objOpt2 instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt2;
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        rVar = new r(true, false, strValueOf, 0.0d);
                    } else {
                        double dOptDouble = jSONArray.optDouble(0);
                        rVar = (Double.isNaN(dOptDouble) || dOptDouble <= 0.0d) ? new r(true, false, strValueOf, 0.0d) : new r(true, true, strValueOf, dOptDouble);
                    }
                } else if (objOpt2 instanceof Number) {
                    double dDoubleValue = ((Number) objOpt2).doubleValue();
                    boolean z = dDoubleValue > 0.0d;
                    if (!z) {
                        dDoubleValue = 0.0d;
                    }
                    rVar = new r(true, z, strValueOf, dDoubleValue);
                } else {
                    rVar = new r(true, false, strValueOf, 0.0d);
                }
            } else {
                rVar = r.d;
            }
        } else {
            rVar = r.d;
        }
        s sVarA = a("i_time", jSONObjectOptJSONObject);
        s sVarA2 = a("shk_s_s", jSONObjectOptJSONObject);
        long j = sVarA.c;
        long jMax = j > 0 ? Math.max(500L, j) : 0L;
        if ((iOptInt == 1 || iOptInt == 2) && rVar.a) {
            boolean z2 = sVarA.b;
            if (!z2 && !sVarA2.b) {
                i2 = 1;
            } else if (z2 && sVarA2.b) {
                i2 = 2;
            } else {
                i2 = 3;
            }
        } else {
            i2 = 3;
        }
        t.a(i2);
        return new u(iOptInt, rVar.b, sVarA.a, sVarA2.a, i2, rVar.c, jMax, sVarA2.d);
    }

    public final boolean a() {
        int i2;
        return this.e != 3 && ((i2 = this.a) == 1 || i2 == 2);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:0x003f  */
    public static s a(String str, JSONObject jSONObject) {
        double dDoubleValue;
        double d;
        boolean z;
        if (jSONObject.has(str)) {
            Object objOpt = jSONObject.opt(str);
            Object obj = JSONObject.NULL;
            if (objOpt != obj) {
                Object objOpt2 = jSONObject.opt(str);
                String strValueOf = (objOpt2 == null || objOpt2 == obj) ? "" : String.valueOf(objOpt2);
                if (objOpt2 instanceof Number) {
                    dDoubleValue = ((Number) objOpt2).doubleValue();
                } else {
                    if (objOpt2 instanceof String) {
                        try {
                            dDoubleValue = Double.parseDouble((String) objOpt2);
                        } catch (NumberFormatException unused) {
                            d = 0.0d;
                        }
                    }
                    d = 0.0d;
                    if (d > 0.0d) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return new s(strValueOf, z, (long) d, d);
                }
                d = dDoubleValue;
                if (d > 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                return new s(strValueOf, z, (long) d, d);
            }
        }
        return s.e;
    }
}
