package com.anythink.core.common.t.a;

import com.anythink.core.common.d.i;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a;
    private final Map<String, c> b = new HashMap();

    public interface a {
        void a();
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private static class c {
        private String a;
        private long b;
        private int c = 0;
        private Runnable d;
        private ScheduledFuture<?> e;

        public c(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public final long a() {
            int i = this.c;
            if (i == 0) {
                return this.b;
            }
            long jPow = this.b * ((long) Math.pow(2.0d, i));
            if (jPow <= i.l.c) {
                return jPow;
            }
            this.c = 0;
            return this.b;
        }

        public final void b() {
            this.c++;
        }

        public final void c() {
            this.c = 0;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void d() {
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(this.e);
            this.e = null;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a a;
        final /* synthetic */ c b;
        final /* synthetic */ String c;

        AnonymousClass1(a aVar, c cVar, String str) {
            this.a = aVar;
            this.b = cVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();
            this.b.e = com.anythink.core.common.u.b.c.a().b(new d(e.ba + "_" + this.c, this), this.b.a());
        }
    }

    private void a(String str, long j, a aVar) {
        c cVar = new c(str, j);
        cVar.d = new AnonymousClass1(aVar, cVar, str);
        this.b.put(str, cVar);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.b$b, reason: collision with other inner class name */
    public static class C0050b {
        public long a;
        public a b;
        private final long c = 5000;

        public C0050b(long j, a aVar) {
            this.a = j <= 5000 ? 5000L : j;
            this.b = aVar;
        }
    }

    private void c(String str) {
        c cVar = this.b.get(str);
        if (cVar == null || cVar.d == null) {
            return;
        }
        cVar.d();
        cVar.e = com.anythink.core.common.u.b.c.a().b(new d(e.aZ + "_" + str, cVar.d), cVar.b);
    }

    private void d(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            cVar.d();
        }
    }

    private void b() {
        Iterator<c> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void a(String str, long j) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            cVar.a(j);
        }
    }

    public final void a(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void b(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void a(Map<String, C0050b> map) {
        Iterator<c> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        for (Map.Entry<String, C0050b> entry : map.entrySet()) {
            C0050b value = entry.getValue();
            String key = entry.getKey();
            long j = value.a;
            a aVar = value.b;
            c cVar = new c(key, j);
            cVar.d = new AnonymousClass1(aVar, cVar, key);
            this.b.put(key, cVar);
            String key2 = entry.getKey();
            c cVar2 = this.b.get(key2);
            if (cVar2 != null && cVar2.d != null) {
                cVar2.d();
                cVar2.e = com.anythink.core.common.u.b.c.a().b(new d(e.aZ + "_" + key2, cVar2.d), cVar2.b);
            }
        }
    }
}
