package com.anythink.core.common.h;

import com.anythink.core.api.ATAdInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bn {
    private Map<String, Object> b;
    private i c;
    private Map<String, String> d;
    private boolean f;
    private Map<String, String> h;
    private String g = "";
    final Object a = new Object();
    private JSONObject i = null;
    private as j = null;
    private Map<String, com.anythink.core.common.f> e = new ConcurrentHashMap(1);

    public final Object a() {
        return this.a;
    }

    public final com.anythink.core.common.f a(String str) {
        return this.e.get(str);
    }

    public final void a(String str, com.anythink.core.common.f fVar) {
        this.e.put(str, fVar);
    }

    public final Map<String, Object> b() {
        return this.b;
    }

    public final void a(Map<String, Object> map) {
        this.b = map;
    }

    public final void a(String str, Object obj) {
        if (this.b == null) {
            this.b = new ConcurrentHashMap(2);
        }
        this.b.put(str, obj);
    }

    public final i c() {
        return this.c;
    }

    public final void a(ATAdInfo aTAdInfo) {
        if (aTAdInfo != null) {
            this.c = new i(aTAdInfo.getAdsourceId(), aTAdInfo.getShowId(), aTAdInfo.getNetworkFirmId());
        } else {
            this.c = null;
        }
    }

    public final String b(String str) {
        Map<String, String> map = this.d;
        return map == null ? "" : map.remove(str);
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            if (this.d == null) {
                this.d = new ConcurrentHashMap(2);
            }
        }
        this.d.put(str, str2);
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final boolean d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public final void a(Object[] objArr) {
        this.g = com.anythink.core.common.v.q.a(objArr);
    }

    public final void b(String str, String str2) {
        if (this.h == null) {
            this.h = new ConcurrentHashMap(2);
        }
        this.h.put(str, str2);
    }

    public final String c(String str) {
        Map<String, String> map = this.h;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final JSONObject f() {
        return this.i;
    }

    public final void a(JSONObject jSONObject) {
        this.i = jSONObject;
    }

    public final void a(String str, List<c> list) {
        if (this.j == null) {
            this.j = new as();
        }
        this.j.a(str, list);
    }

    public final void a(String str, String str2, String str3) {
        as asVar = this.j;
        if (asVar != null) {
            asVar.a(str, str2, str3);
        }
    }
}
