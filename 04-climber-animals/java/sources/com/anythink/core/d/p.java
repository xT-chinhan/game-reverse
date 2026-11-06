package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.v.af;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    private static final String a = "PlaceStrategySaver";
    private final Context b;
    private final ConcurrentHashMap<String, l> c = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, l> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, l> e = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap<>();

    public p(Context context) {
        this.b = context;
    }

    public final void a(String str, String str2, l lVar, final JSONObject jSONObject, int i) {
        final boolean z;
        if (this.b == null || lVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        final String str3 = str + str2;
        if (i == 1) {
            this.e.put(str3, lVar);
            return;
        }
        if (i == 2) {
            this.c.put(str3, lVar);
            z = true;
        } else {
            this.d.put(str3, lVar);
            z = false;
        }
        if (lVar.D() == 1 || lVar.br()) {
            if (com.anythink.core.common.d.t.b().P()) {
                Log.e("anythink", "PreInitNetwork may affect DebuggerMode.It is recommended to disable PreInitNetwork first and then setDebuggerMode.");
                return;
            }
            return;
        }
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.d.p.1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject2 = jSONObject;
                af.b(p.this.b, com.anythink.core.common.d.u.b.a, p.b(str3, z), jSONObject2 == null ? "" : jSONObject2.toString());
            }
        });
    }

    public final void a(String str, int i) {
        this.g.put(str, Integer.valueOf(i));
    }

    public final l a(String str, String str2) {
        int i = this.f.get(new StringBuilder().append(str).append(str2).toString()) == null ? 2 : 0;
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        l lVarA = a(str, str2, i);
        if (lVarA == null && i == 2) {
            return a(str, str2, 0);
        }
        return lVarA == null ? a(str, str2, 2) : lVarA;
    }

    public final boolean b(String str, String str2) {
        return this.f.get(new StringBuilder().append(str).append(str2).toString()) == null;
    }

    public final l c(String str, String str2) {
        l lVarA;
        String str3 = str + str2;
        Integer num = this.g.get(str2);
        int iIntValue = num == null ? 0 : num.intValue();
        if (iIntValue == 1 && (lVarA = a(str, str2, 0)) != null) {
            return lVarA;
        }
        Object[] objArr = new Object[2];
        Integer.valueOf(iIntValue);
        return a(str, str2, iIntValue);
    }

    public final l a(String str, String str2, int i) {
        ConcurrentHashMap<String, l> concurrentHashMap;
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        String str3 = str + str2;
        if (i == 1) {
            concurrentHashMap = this.e;
        } else if (i == 2) {
            concurrentHashMap = this.c;
        } else {
            concurrentHashMap = this.d;
        }
        l lVar = concurrentHashMap.get(str3);
        if (lVar != null) {
            return lVar;
        }
        if (i == 1) {
            return null;
        }
        String strC = af.c(this.b, com.anythink.core.common.d.u.b.a, b(str3, i == 2), "");
        if (!TextUtils.isEmpty(strC)) {
            try {
                l lVarA = l.a(str2, new JSONObject(strC));
                if (lVarA != null) {
                    lVarA.a(i);
                    concurrentHashMap.put(str3, lVarA);
                    return lVarA;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final void d(String str, String str2) {
        String str3 = str + str2;
        Integer num = this.f.get(str3);
        if (num == null) {
            this.f.put(str3, 1);
        } else {
            this.f.put(str3, Integer.valueOf(num.intValue() + 1));
        }
        Object[] objArr = new Object[2];
    }

    private boolean f(String str, String str2) {
        return a(str, str2, 0) != null;
    }

    public final void b(String str, String str2, int i) {
        String str3 = str + str2;
        if (i == 1) {
            this.e.remove(str3);
            return;
        }
        if (i == 2) {
            this.c.remove(str3);
        }
        if (i == 0) {
            this.d.remove(str3);
        }
        af.a(this.b, com.anythink.core.common.d.u.b.a, b(str3, i == 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, boolean z) {
        return str + "_" + (z ? com.anythink.core.common.d.u.a.m : com.anythink.core.common.d.u.a.l);
    }

    public final int e(String str, String str2) {
        String str3 = str + str2;
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f;
        Integer num = concurrentHashMap != null ? concurrentHashMap.get(str3) : null;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }
}
