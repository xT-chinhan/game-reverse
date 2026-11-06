package com.anythink.core.common.r;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.r.b.d;
import com.anythink.core.common.r.b.e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int a = 1;
    public static final int b = 1;
    private static final String c = "SPManager";
    private static final long d = 10000;
    private static volatile b e;
    private final Set<String> h;
    private volatile long g = 0;
    private final Map<String, a> f = new ConcurrentHashMap();

    private b() {
        HashSet hashSet = new HashSet();
        this.h = hashSet;
        hashSet.add(t.b.a);
        hashSet.add(t.b.m);
    }

    public static b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    public final a b(Context context, String str) {
        return c(context, str);
    }

    private a c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.anythink.core.common.r.b.b();
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        a aVar = this.f.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVarD = d(context, str);
        this.f.put(str, aVarD);
        return aVarD;
    }

    private static a d(Context context, String str) {
        return d.c(new c.a().a(context).a(str).b(1).a(1).a());
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(t.a.n) || str.endsWith(t.a.m);
    }

    private static boolean b(String str) {
        return !a(str);
    }

    private void a(Context context) {
        String[] strArr = {t.b.a, t.b.c, t.b.g, t.b.h, t.b.i, t.b.j, t.b.k, "anythink_app_pl_cl_retry", t.b.d};
        for (int i = 0; i < 9; i++) {
            a aVarC = c(context, strArr[i]);
            if (aVarC instanceof e) {
                ((e) aVarC).d();
            }
        }
    }

    public final synchronized int b() {
        a value;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - this.g < 10000) {
                return 0;
            }
            int iC = 0;
            for (Map.Entry<String, a> entry : this.f.entrySet()) {
                if (!this.h.contains(entry.getKey()) && (value = entry.getValue()) != null) {
                    try {
                        iC += value.c();
                    } catch (Exception unused) {
                    }
                }
            }
            this.g = jElapsedRealtime;
            return iC;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private int c() {
        return this.f.size();
    }

    private boolean c(String str) {
        return this.h.contains(str);
    }

    public final a a(Context context, String str) {
        return c(context, str);
    }
}
