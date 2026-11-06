package com.anythink.core.common;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.common.h.bp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static volatile t a;
    private final ConcurrentHashMap<String, bp> b = new ConcurrentHashMap<>(4);

    private t() {
    }

    public static t a() {
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t();
                }
            }
        }
        return a;
    }

    private synchronized bp d(String str) {
        bp bpVar;
        bpVar = this.b.get(str);
        if (bpVar == null) {
            bpVar = new bp();
            this.b.put(str, bpVar);
        }
        return bpVar;
    }

    private Object e(String str) {
        return d(str).a();
    }

    public final f a(String str, String str2) {
        return d(str).a(str2);
    }

    public final void a(String str, String str2, f fVar) {
        d(str).a(str2, fVar);
    }

    private synchronized void a(String str, Map<String, Object> map) {
        d(str).a(com.anythink.core.common.u.i.a(map));
    }

    private synchronized Map<String, Object> f(String str) {
        HashMap map;
        map = new HashMap(2);
        Map<String, Object> mapB = d(str).b();
        if (mapB != null) {
            map.putAll(mapB);
        }
        return map;
    }

    private void a(String str, ATAdInfo aTAdInfo) {
        d(str).a(aTAdInfo);
    }

    private com.anythink.core.common.h.i g(String str) {
        return d(str).c();
    }

    private void h(String str) {
        d(str).a((ATAdInfo) null);
    }

    private void b(String str, String str2, String str3) {
        d(str).a(str2, str3);
    }

    private String b(String str, String str2) {
        return d(str).b(str2);
    }

    public final boolean a(String str) {
        return d(str).d();
    }

    public final void a(String str, boolean z) {
        d(str).a(z);
    }

    public final void a(String str, Object[] objArr) {
        d(str).a(objArr);
    }

    public final String b(String str) {
        return d(str).e();
    }

    private void a(String str, int i, String str2) {
        d(str).b(String.valueOf(i), str2);
    }

    private String a(String str, int i) {
        return d(str).c(String.valueOf(i));
    }

    public final void a(String str, JSONObject jSONObject) {
        d(str).a(jSONObject);
    }

    public final JSONObject c(String str) {
        return d(str).f();
    }

    private void a(String str, String str2, List<com.anythink.core.common.h.c> list) {
        d(str).a(str2, list);
    }

    public final void a(String str, String str2, String str3) {
        d(str).a(str, str2, str3);
    }
}
