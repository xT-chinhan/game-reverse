package com.smartdigimkt.p4;

import android.os.SystemClock;
import com.anythink.core.e.i;
import com.anythink.core.e.l;
import com.smartdigimkt.r4.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {
    public int A;
    public String C;
    public List D;
    public com.smartdigimkt.e3.b E;
    public JSONArray F;
    public Boolean G;
    public List H;
    public g I;
    public final String e;
    public long f;
    public long g;
    public long h;
    public int i;
    public int j;
    public long k;
    public int l;
    public int m;
    public int n;
    public long o;
    public long p;
    public JSONArray q;
    public JSONArray r;
    public double s;
    public int t;
    public int u;
    public long v;
    public JSONObject x;
    public c y;
    public JSONObject z;
    public int w = 0;
    public String B = "";

    public e(String str) {
        this.e = str;
    }

    public static e a(String str, JSONObject jSONObject) {
        long jOptLong;
        e eVar = new e(str);
        System.currentTimeMillis();
        try {
            eVar.a = jSONObject;
            if (jSONObject.isNull(l.a.ac)) {
                eVar.v = 0L;
                jOptLong = 0;
            } else {
                jOptLong = jSONObject.optLong(l.a.ac);
                eVar.v = jOptLong;
            }
            eVar.f = jSONObject.optLong("ps_ct", 0L);
            eVar.g = jSONObject.optLong(l.a.ay, i.f);
            eVar.h = jSONObject.optLong("ps_ct_out", 0L);
            eVar.i = jSONObject.optInt("pucs", 1);
            eVar.j = jSONObject.optInt("ad_delivery_sw", 1);
            jSONObject.optString(com.anythink.core.common.l.f.bo);
            eVar.k = jSONObject.optLong("s_t", 900000L);
            eVar.l = jSONObject.optInt("is_test", 2);
            eVar.m = jSONObject.optInt(com.anythink.core.common.f.a.C0017a.d, 0);
            eVar.n = jSONObject.optInt("auto_refresh", 0);
            eVar.o = jSONObject.optInt("auto_refresh_time", 0);
            eVar.p = jSONObject.optLong(l.a.a, 10000L);
            jSONObject.optString(l.a.b);
            jSONObject.optLong("s_ts");
            eVar.w = jSONObject.optInt(l.a.av, 0);
            eVar.x = jSONObject.optJSONObject(l.a.aa);
            jSONObject.optInt("p_m_o", 0);
            jSONObject.optInt("u_n_f_sw", 0);
            eVar.E = com.smartdigimkt.e3.b.t(jSONObject.optString("m_o_s", ""));
            if (!jSONObject.isNull("m_o")) {
                eVar.D = com.smartdigimkt.e3.a.a(jSONObject.optString("m_o"), jSONObject.optString("m_o_ks"), jOptLong, eVar.E);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(l.a.aB);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                c cVar = new c();
                cVar.a = jSONObject.optString(l.a.aA);
                cVar.c = jSONObjectOptJSONObject.optString(l.a.aC);
                cVar.d = jSONObjectOptJSONObject.optInt(l.a.aD);
                cVar.e = jSONObjectOptJSONObject.optInt("c_id");
                eVar.y = cVar;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(l.a.aR);
            if (jSONObjectOptJSONObject2 != null) {
                eVar.z = jSONObjectOptJSONObject2;
            }
            eVar.A = jSONObject.optInt(l.a.K, 0);
            eVar.B = jSONObject.optString(l.a.S);
            eVar.v = jSONObject.optLong(l.a.ac, 0L);
            eVar.q = jSONObject.optJSONArray(l.a.g);
            eVar.r = jSONObject.optJSONArray(l.a.w);
            eVar.s = jSONObject.optDouble("bid_floor", 0.0d);
            eVar.t = jSONObject.optInt(d.a, 0);
            eVar.u = jSONObject.optInt(l.a.M, 0);
            double dOptDouble = jSONObject.optDouble(l.a.v, 0.1614d);
            n.a = dOptDouble;
            if (dOptDouble > 0.0d) {
                n.b = 1.0d / dOptDouble;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("callback");
            if (jSONObjectOptJSONObject3 != null) {
                jSONObjectOptJSONObject3.optString("currency");
                jSONObjectOptJSONObject3.optString("cc");
                jSONObjectOptJSONObject3.optString("acct_cy");
                jSONObjectOptJSONObject3.optDouble("exch_r");
            }
            eVar.C = jSONObject.optString("asid");
            if (jSONObject.isNull("ug_list")) {
                eVar.F = new JSONArray();
            } else {
                eVar.F = jSONObject.optJSONArray("ug_list");
            }
        } catch (Throwable unused) {
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = eVar.q;
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject4 != null) {
                    g gVarA = com.smartdigimkt.q4.a.a(4, 3, jSONObjectOptJSONObject4, eVar);
                    arrayList2.add(gVarA);
                    concurrentHashMap.put(gVarA.r, gVarA);
                    if (gVarA.b == 35) {
                        arrayList.add(gVarA);
                    }
                    if (gVarA.z <= 0.0d) {
                        double d = eVar.s;
                        if (d > 0.0d) {
                            gVarA.z = d;
                        }
                    }
                    if (eVar.G == null && gVarA.n == 1 && gVarA.G == 1) {
                        eVar.G = Boolean.TRUE;
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (!arrayList2.isEmpty()) {
            eVar.I = (g) arrayList2.get(0);
        }
        ArrayList arrayListA = com.smartdigimkt.q4.a.a(eVar, eVar.F, 0, 1);
        arrayList.clear();
        if (!arrayListA.isEmpty()) {
            for (int i2 = 0; i2 < arrayListA.size(); i2++) {
                if (((g) arrayListA.get(i2)).b == 35) {
                    arrayList.add((g) arrayListA.get(i2));
                }
            }
        }
        eVar.H = arrayList;
        return eVar;
    }

    public final boolean b() {
        int i = this.w;
        if (i != 0) {
            if (i == 1) {
                return false;
            }
            if (i != 2) {
                return true;
            }
        }
        return System.currentTimeMillis() - this.v > this.g;
    }

    public final g a() {
        SystemClock.elapsedRealtime();
        g gVar = this.I;
        if (gVar != null) {
            g gVarA = gVar.a();
            SystemClock.elapsedRealtime();
            return gVarA;
        }
        ArrayList arrayListA = com.smartdigimkt.q4.a.a(this, this.q, 3, 4);
        if (!arrayListA.isEmpty()) {
            g gVarA2 = ((g) arrayListA.get(0)).a();
            SystemClock.elapsedRealtime();
            return gVarA2;
        }
        SystemClock.elapsedRealtime();
        return null;
    }
}
