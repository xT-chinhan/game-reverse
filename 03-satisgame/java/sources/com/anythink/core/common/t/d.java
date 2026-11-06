package com.anythink.core.common.t;

import android.text.TextUtils;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.u;
import com.anythink.core.common.h.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static volatile d b;
    private long c = 0;
    private long d = 0;
    private final Map<String, Long> e = new ConcurrentHashMap();
    private final Map<String, bj> f = new ConcurrentHashMap();

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
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
            nVar.o(jCurrentTimeMillis);
        } else {
            if (!d(nVar)) {
                this.c = jCurrentTimeMillis;
            }
            nVar.n(jCurrentTimeMillis);
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
        this.e.put(nVar.aQ(), Long.valueOf(jCurrentTimeMillis));
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
        if (TextUtils.isEmpty(nVar.aQ())) {
            return 0L;
        }
        long jC = nVar.c();
        Long l = this.e.get(nVar.aQ());
        if (l == null || l.longValue() == 0 || jC == 0) {
            return 0L;
        }
        return jC - l.longValue();
    }

    public static long b(n nVar) {
        return nVar.d() - nVar.c();
    }

    private static boolean c(n nVar) {
        return nVar == null || TextUtils.isEmpty(nVar.aQ()) || TextUtils.isEmpty(nVar.A());
    }

    private static boolean d(n nVar) {
        try {
            String strAS = nVar.aS();
            return !TextUtils.isEmpty(strAS) && strAS.equals("0");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e(n nVar) {
        return nVar.Z() == 66;
    }

    private static String a(x xVar) {
        return xVar.f + "_ " + xVar.e;
    }

    private bj a(String str) {
        bj bjVar = this.f.get(str);
        if (bjVar == null) {
            synchronized (this.f) {
                if (bjVar == null) {
                    bjVar = new bj();
                    this.f.put(str, bjVar);
                }
            }
        }
        return bjVar;
    }

    private void a(String str, long j) {
        a(str).a = j;
    }

    private void b(String str, long j) {
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

    private void b(String str) {
        this.f.remove(str);
    }
}
