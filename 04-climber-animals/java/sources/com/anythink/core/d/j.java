package com.anythink.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private static String m = "ofm_logger";
    private static String n = "ofm_tk_sw";
    private static String o = "ofm_da_sw";
    private static String p = "tk_address";
    private static String q = "tk_max_amount";
    private static String r = "tk_interval";
    private static String s = "da_rt_keys_ft";
    private static String t = "tk_no_t_ft";
    private static String u = "da_not_keys_ft";
    private static String v = "ofm_system";
    private static String w = "ofm_tid";
    private static String x = "ofm_firm_info";
    private static String y = "ofm_st_vt";
    String a = String.valueOf(hashCode());
    public Map<String, Object> b;
    private boolean c;
    private int d;
    private int e;
    private long f;
    private int g;
    private int h;
    private String i;
    private int j;
    private long k;
    private Map<String, String> l;

    private Map<String, Object> b(String str) {
        try {
            Map<String, Object> map = this.b;
            if (map != null) {
                return com.anythink.core.common.v.q.c(map.get(str).toString());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int b() {
        return this.d;
    }

    private int c() {
        return this.e;
    }

    public final long a() {
        return this.f;
    }

    private int d() {
        return this.g;
    }

    private int e() {
        return this.h;
    }

    private String f() {
        return this.i;
    }

    private int g() {
        return this.j;
    }

    private long h() {
        return this.k;
    }

    private Map<String, String> i() {
        return this.l;
    }

    private String j() {
        return this.a;
    }

    private boolean k() {
        return this.c;
    }

    public static j a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            j jVar = new j();
            JSONObject jSONObject = new JSONObject(str);
            jVar.d = jSONObject.optInt(v);
            jVar.e = jSONObject.optInt(w);
            jVar.f = jSONObject.optLong(y);
            jVar.b = com.anythink.core.common.v.q.c(jSONObject.optString(x));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(m);
            if (jSONObjectOptJSONObject != null) {
                jVar.g = jSONObjectOptJSONObject.optInt(n);
                jVar.h = jSONObjectOptJSONObject.optInt(o);
                jVar.i = jSONObjectOptJSONObject.optString(p);
                jVar.j = jSONObjectOptJSONObject.optInt(q);
                jVar.k = jSONObjectOptJSONObject.optLong(r);
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString(t));
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap map = new HashMap();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.optString(next));
                    }
                    jVar.l = map;
                } catch (Throwable unused) {
                }
            }
            return jVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static j c(String str) {
        try {
            j jVar = new j();
            JSONObject jSONObject = new JSONObject(str);
            jVar.c = true;
            jVar.d = jSONObject.optInt(v);
            jVar.b = com.anythink.core.common.v.q.c(jSONObject.optString(x));
            jVar.g = 1;
            jVar.h = 1;
            return jVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
