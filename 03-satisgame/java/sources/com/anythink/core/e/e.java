package com.anythink.core.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private JSONObject a;
    private Map<String, String> b;
    private Map<String, String> c;
    final String d = com.anythink.core.common.b.e.a;
    private Map<String, String> e;
    private int f;
    private int g;

    public final void a(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString("cached");
        Map<String, String> mapBh = bh();
        if (TextUtils.isEmpty(strOptString) || this.a == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strOptString);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString2 = jSONObject2.optString(next);
                String str2 = mapBh.get(next);
                jSONObject.put(next, this.a.opt(next));
                if (!TextUtils.equals(strOptString2, str2)) {
                    com.anythink.core.common.t.f.a(str, TextUtils.isEmpty(str) ? "1" : "2", next, strOptString2, str2);
                    jSONObject2.put(next, str2);
                }
            }
            jSONObject.put("cached", jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    public final JSONObject bf() {
        return this.a;
    }

    public final void b(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    private Map<String, String> a() {
        return this.b;
    }

    public final void c(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("cached");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.optString(next));
                }
            } catch (Throwable unused) {
            }
        }
        this.b = map;
    }

    private Map<String, String> b() {
        return this.c;
    }

    public final boolean bg() {
        Map<String, String> map = this.c;
        return map == null || map.size() == 0;
    }

    public final void d(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(com.anythink.core.common.l.f.aq);
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.optString(next));
                }
            } catch (Throwable unused) {
            }
        }
        this.c = map;
    }

    public final synchronized Map<String, String> bh() {
        if (this.e == null) {
            HashMap map = new HashMap();
            this.e = map;
            Map<String, String> map2 = this.b;
            if (map2 != null) {
                map.putAll(map2);
            }
            Map<String, String> map3 = this.c;
            if (map3 != null) {
                this.e.putAll(map3);
            }
        }
        return this.e;
    }

    public final boolean bi() {
        return this.g > 0;
    }

    public final void e(int i) {
        this.g = i;
    }

    public final int bj() {
        return this.f;
    }

    public final void f(int i) {
        this.f = i;
    }
}
