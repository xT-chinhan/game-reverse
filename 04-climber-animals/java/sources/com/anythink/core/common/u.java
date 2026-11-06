package com.anythink.core.common;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.common.h.bn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class u {
    private static volatile u a;
    private ConcurrentHashMap<String, bn> b = new ConcurrentHashMap<>(4);

    private u() {
    }

    public static u a() {
        if (a == null) {
            synchronized (u.class) {
                if (a == null) {
                    a = new u();
                }
            }
        }
        return a;
    }

    private synchronized bn h(String str) {
        bn bnVar;
        bnVar = this.b.get(str);
        if (bnVar == null) {
            bnVar = new bn();
            this.b.put(str, bnVar);
        }
        return bnVar;
    }

    public final Object a(String str) {
        return h(str).a();
    }

    public final f a(String str, String str2) {
        return h(str).a(str2);
    }

    public final void a(String str, String str2, f fVar) {
        h(str).a(str2, fVar);
    }

    public final synchronized void a(String str, Map<String, Object> map) {
        h(str).a(com.anythink.core.common.v.j.a(map));
    }

    public final synchronized Map<String, Object> b(String str) {
        HashMap map;
        map = new HashMap(2);
        Map<String, Object> mapB = h(str).b();
        if (mapB != null) {
            map.putAll(mapB);
        }
        return map;
    }

    private synchronized void a(String str, String str2, Object obj) {
        h(str).a(str2, obj);
    }

    public final void a(String str, ATAdInfo aTAdInfo) {
        h(str).a(aTAdInfo);
    }

    public final com.anythink.core.common.h.i c(String str) {
        return h(str).c();
    }

    public final void d(String str) {
        h(str).a((ATAdInfo) null);
    }

    public final void a(String str, String str2, String str3) {
        h(str).a(str2, str3);
    }

    public final String b(String str, String str2) {
        return h(str).b(str2);
    }

    public final boolean e(String str) {
        return h(str).d();
    }

    public final void a(String str, boolean z) {
        h(str).a(z);
    }

    public final void a(String str, Object[] objArr) {
        h(str).a(objArr);
    }

    public final String f(String str) {
        return h(str).e();
    }

    public final void a(String str, int i, String str2) {
        h(str).b(String.valueOf(i), str2);
    }

    public final String a(String str, int i) {
        return h(str).c(String.valueOf(i));
    }

    public final void a(String str, JSONObject jSONObject) {
        h(str).a(jSONObject);
    }

    public final JSONObject g(String str) {
        return h(str).f();
    }

    public final void a(String str, String str2, List<com.anythink.core.common.h.c> list) {
        h(str).a(str2, list);
    }

    public final void b(String str, String str2, String str3) {
        h(str).a(str, str2, str3);
    }
}
