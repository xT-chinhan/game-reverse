package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static volatile g b;
    private long f;
    final String a = com.anythink.core.common.q.g.a;
    private volatile boolean e = false;
    private long g = 0;
    private final k c = k.a(com.anythink.core.common.f.d.a(s.b().g()));
    private final Map<String, Integer> d = new HashMap();

    private g() {
        this.f = 209715200L;
        this.f = s.b().e(4);
    }

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    public final void b() {
        if (this.e) {
            return;
        }
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.da, new Runnable() { // from class: com.anythink.core.common.a.g.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    g.this.e = true;
                    new ArrayList();
                    g gVar = g.this;
                    gVar.g = gVar.c.c();
                    if (g.this.g > g.this.f) {
                        for (f fVar : g.this.c.d()) {
                            try {
                                File file = new File(fVar.b());
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Throwable unused) {
                            }
                            try {
                                if (!TextUtils.isEmpty(fVar.a())) {
                                    String strA = fVar.a();
                                    g.this.d.remove(strA);
                                    com.anythink.core.common.res.b.c.a().a(strA);
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
                g.this.e = false;
            }
        }));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.a.g$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ f a;

        AnonymousClass2(f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File file = new File(this.a.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
            g.this.c.c(this.a.a());
        }
    }

    private void a(f fVar) {
        if (fVar == null) {
            return;
        }
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.db, new AnonymousClass2(fVar)));
    }

    public final void a(String str, String str2, long j, long j2, int i, boolean z) {
        this.d.put(str, Integer.valueOf(i));
        if (z) {
            a(str, str2, j, j2, i);
        }
    }

    public final void a(final String str, final String str2, final long j, final long j2, final int i) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dc, new Runnable() { // from class: com.anythink.core.common.a.g.3
            @Override // java.lang.Runnable
            public final void run() {
                g.this.c.a(str, str2, j, j2, i);
            }
        }));
    }

    private f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.a(str);
    }

    private synchronized boolean a(String str, int i) {
        return b(str) >= i;
    }

    private synchronized int b(String str) {
        if (this.d.containsKey(str) && this.d.get(str) != null) {
            return this.d.get(str).intValue();
        }
        f fVarA = this.c.a(str);
        if (fVarA == null || fVarA.c() <= 0) {
            return 0;
        }
        File file = new File(fVarA.b());
        if (!file.exists() || file.length() < fVarA.d()) {
            if (fVarA != null) {
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.db, new AnonymousClass2(fVarA)));
            }
            return 0;
        }
        this.d.put(str, Integer.valueOf(fVarA.c()));
        this.c.b(str);
        return fVarA.c();
    }

    private long d() {
        return this.f;
    }

    private long e() {
        return this.g;
    }

    public final void c() {
        this.f = s.b().e(4);
    }
}
