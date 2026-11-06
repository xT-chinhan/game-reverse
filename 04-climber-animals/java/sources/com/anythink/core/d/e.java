package com.anythink.core.d;

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
    final String d = "e";
    private Map<String, String> e;

    public final void a(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString("cached");
        Map<String, String> mapBa = ba();
        if (!TextUtils.isEmpty(strOptString) && this.a != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString2 = jSONObject2.optString(next);
                    String str2 = mapBa.get(next);
                    jSONObject.put(next, this.a.opt(next));
                    if (!TextUtils.equals(strOptString2, str2)) {
                        com.anythink.core.common.u.e.a(str, TextUtils.isEmpty(str) ? "1" : "2", next, strOptString2, str2);
                        jSONObject2.put(next, str2);
                    }
                }
                jSONObject.put("cached", jSONObject2.toString());
            } catch (Throwable unused) {
            }
        }
        if (this instanceof b) {
            try {
                if (!TextUtils.isEmpty(((b) this).l()) && ((b) this).o() != null && ((b) this).o().size() > 0 && !TextUtils.equals(((b) this).l(), jSONObject.optString(b.a.h, ""))) {
                    Iterator<String> it = ((b) this).o().iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.v.o.a(it.next()));
                    }
                }
                if (!TextUtils.isEmpty(((b) this).m()) && ((b) this).q() != null && ((b) this).q().size() > 0 && !TextUtils.equals(((b) this).m(), jSONObject.optString(b.a.i, ""))) {
                    Iterator<String> it2 = ((b) this).q().iterator();
                    while (it2.hasNext()) {
                        com.anythink.core.common.res.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.v.o.a(it2.next()));
                    }
                }
                if (TextUtils.isEmpty(((b) this).n()) || ((b) this).p() == null || ((b) this).p().size() <= 0 || TextUtils.equals(((b) this).n(), jSONObject.optString(b.a.j, ""))) {
                    return;
                }
                Iterator<String> it3 = ((b) this).p().iterator();
                while (it3.hasNext()) {
                    com.anythink.core.common.res.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.v.o.a(it3.next()));
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private JSONObject a() {
        return this.a;
    }

    public final void b(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    private Map<String, String> b() {
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

    private Map<String, String> c() {
        return this.c;
    }

    public final boolean aZ() {
        Map<String, String> map = this.c;
        return map == null || map.size() == 0;
    }

    public final void d(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(com.anythink.core.common.m.e.ap);
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

    public final synchronized Map<String, String> ba() {
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
}
