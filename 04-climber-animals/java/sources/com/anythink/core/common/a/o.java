package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.q;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static volatile o b;
    private long f;
    final String a = "o";
    private volatile boolean e = false;
    private long g = 0;
    private q c = q.a(com.anythink.core.common.e.e.a(t.b().g()));
    private Map<String, Integer> d = new HashMap();

    private o() {
        this.f = 209715200L;
        this.f = t.b().d(4);
    }

    public static o a() {
        if (b == null) {
            synchronized (o.class) {
                if (b == null) {
                    b = new o();
                }
            }
        }
        return b;
    }

    public final void b() {
        if (this.e) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.a.o.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    o.this.e = true;
                    new ArrayList();
                    o oVar = o.this;
                    oVar.g = oVar.c.a();
                    long unused = o.this.g;
                    long unused2 = o.this.f;
                    int i = (o.this.g > o.this.f ? 1 : (o.this.g == o.this.f ? 0 : -1));
                    if (o.this.g > o.this.f) {
                        List<n> listB = o.this.c.b();
                        listB.size();
                        for (n nVar : listB) {
                            try {
                                File file = new File(nVar.b());
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Throwable unused3) {
                            }
                            try {
                                if (!TextUtils.isEmpty(nVar.a())) {
                                    String strA = nVar.a();
                                    o.this.d.remove(strA);
                                    com.anythink.core.common.res.b.c.a().b(strA);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable unused5) {
                }
                o.this.e = false;
            }
        }, 13);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.a.o$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ n a;

        AnonymousClass2(n nVar) {
            this.a = nVar;
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
            o.this.c.c(this.a.a());
        }
    }

    private void a(n nVar) {
        if (nVar == null) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass2(nVar), 2);
    }

    public final void a(String str, String str2, long j, long j2, int i, boolean z) {
        this.d.put(str, Integer.valueOf(i));
        if (z) {
            a(str, str2, j, j2, i);
        }
    }

    public final void a(final String str, final String str2, final long j, final long j2, final int i) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.a.o.3
            @Override // java.lang.Runnable
            public final void run() {
                o.this.c.a(str, str2, j, j2, i);
            }
        }, 13);
    }

    public final n a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.a(str);
    }

    public final synchronized boolean a(String str, int i) {
        return b(str) >= i;
    }

    private synchronized int b(String str) {
        if (this.d.containsKey(str) && this.d.get(str) != null) {
            return this.d.get(str).intValue();
        }
        n nVarA = this.c.a(str);
        if (nVarA == null || nVarA.c() <= 0) {
            return 0;
        }
        File file = new File(nVarA.b());
        if (!file.exists() || file.length() < nVarA.e()) {
            if (nVarA != null) {
                com.anythink.core.common.v.b.b.a().b(new AnonymousClass2(nVarA), 2);
            }
            return 0;
        }
        this.d.put(str, Integer.valueOf(nVarA.c()));
        this.c.b(str);
        return nVarA.c();
    }

    public final long c() {
        return this.f;
    }

    public final long d() {
        return this.g;
    }

    public final void e() {
        this.f = t.b().d(4);
    }
}
