package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.common.h.bh;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.u;
import com.anythink.core.common.h.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";
    private static volatile b b;
    private long c = 0;
    private long d = 0;
    private final Map<String, Long> e = new ConcurrentHashMap();
    private final Map<String, bh> f = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public final void a(int i, n nVar) {
        if (c(nVar)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != 4) {
            if (i != 6) {
                return;
            }
            nVar.n(jCurrentTimeMillis);
        } else {
            if (!d(nVar)) {
                this.c = jCurrentTimeMillis;
            }
            nVar.m(jCurrentTimeMillis);
        }
    }

    public final void a(u uVar, n nVar) {
        if (c(nVar)) {
            return;
        }
        String str = uVar.c;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!str.equals("1004634") || d(nVar)) {
            return;
        }
        this.d = jCurrentTimeMillis;
        this.e.put(nVar.aI(), Long.valueOf(jCurrentTimeMillis));
    }

    public final long b() {
        long j = this.d;
        if (j != 0) {
            long j2 = this.c;
            if (j2 != 0) {
                return j2 - j;
            }
        }
        return 0L;
    }

    public final long a(n nVar) {
        if (TextUtils.isEmpty(nVar.aI())) {
            return 0L;
        }
        long jB = nVar.b();
        Long l = this.e.get(nVar.aI());
        if (l == null || l.longValue() == 0 || jB == 0) {
            return 0L;
        }
        return jB - l.longValue();
    }

    public static long b(n nVar) {
        return nVar.c() - nVar.b();
    }

    private static boolean c(n nVar) {
        return nVar == null || TextUtils.isEmpty(nVar.aI()) || TextUtils.isEmpty(nVar.z());
    }

    private boolean d(n nVar) {
        try {
            String strAK = nVar.aK();
            return !TextUtils.isEmpty(strAK) && strAK.equals("0");
        } catch (Throwable th) {
            getClass().getSimpleName();
            th.getMessage();
            return false;
        }
    }

    private static boolean e(n nVar) {
        return nVar.Y() == 66;
    }

    public static String a(x xVar) {
        return xVar.d + "_ " + xVar.c;
    }

    public final bh a(String str) {
        bh bhVar = this.f.get(str);
        if (bhVar == null) {
            synchronized (this.f) {
                if (bhVar == null) {
                    bhVar = new bh();
                    this.f.put(str, bhVar);
                }
            }
        }
        return bhVar;
    }

    private void b(String str, long j) {
        a(str).a = j;
    }

    public final void a(String str, long j) {
        a(str).b = j;
    }

    private void c(String str, long j) {
        a(str).c = j;
    }

    private void d(String str, long j) {
        a(str).d = j;
    }

    private void e(String str, long j) {
        a(str).e = j;
    }

    private void f(String str, long j) {
        a(str).f = j;
    }

    private void g(String str, long j) {
        a(str).g = j;
    }

    public final void b(String str) {
        this.f.remove(str);
    }
}
