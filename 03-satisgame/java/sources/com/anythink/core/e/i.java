package com.anythink.core.e;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends e {
    public static final int a = 1;
    public static final int b = 3;
    public static final int c = 3;
    public static final int e = 5;
    public static final long f = 604800000;
    private int g;
    private a h;
    private JSONObject i;
    private long j;
    private long k;

    public static class a {
        public int a;
        public int b;
        public int c;
    }

    private long d() {
        return this.k;
    }

    private void a(long j) {
        this.k = j;
    }

    public final int a() {
        return this.g;
    }

    private void a(int i) {
        this.g = i;
    }

    public final a b() {
        return this.h;
    }

    private void a(a aVar) {
        this.h = aVar;
    }

    private JSONObject e() {
        return this.i;
    }

    private void e(JSONObject jSONObject) {
        this.i = jSONObject;
    }

    private long f() {
        return this.j;
    }

    private void b(long j) {
        this.j = j;
    }

    public static class b {
        public static String a = "adap_c";
        public static String b = "updateTime";
        private static String c = "rule";
        private static String d = "group_st";
        private static String e = "num";
        private static String f = "value_times";
        private static String g = "cold_times";
        private static String h = "st_timeout";
    }

    public static i a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        i iVar = new i();
        try {
            iVar.b(jSONObject);
            iVar.c(jSONObject);
            iVar.d(jSONObject);
            iVar.g = jSONObject.optInt(b.c, 1);
            String strOptString = jSONObject.optString(b.d);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    a aVar = new a();
                    aVar.a = jSONObject2.optInt(b.e, 3);
                    aVar.b = jSONObject2.optInt(b.f, 3);
                    aVar.c = jSONObject2.optInt(b.g, 5);
                    iVar.h = aVar;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            iVar.i = jSONObject.optJSONObject(b.a);
            iVar.k = jSONObject.optLong(b.b, 0L);
            iVar.j = jSONObject.optLong(b.h, f);
        } catch (Throwable unused) {
        }
        return iVar;
    }

    public final boolean c() {
        return System.currentTimeMillis() - this.k > this.j;
    }
}
