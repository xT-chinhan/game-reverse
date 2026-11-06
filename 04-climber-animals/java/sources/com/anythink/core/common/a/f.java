package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static volatile f d;
    long b;
    private com.anythink.core.common.e.b e;
    private Map<String, h> f;
    final String a = f.class.getName();
    Object c = new Object();

    private static void c() {
    }

    private f() {
        this.b = 0L;
        if (t.b().g() != null) {
            this.e = com.anythink.core.common.e.b.a(com.anythink.core.common.e.e.a(t.b().g()));
            this.f = new ConcurrentHashMap();
            this.b = f();
            t.b();
            t.c(new AnonymousClass1());
        }
    }

    public static f a() {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f();
                }
            }
        }
        return d;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.a.f$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (f.this.c) {
                f.this.b();
                List<g> listA = f.this.e.a();
                if (listA != null) {
                    for (int i = 0; i < listA.size(); i++) {
                        g gVar = listA.get(i);
                        String strA = gVar.a();
                        if (!TextUtils.isEmpty(strA)) {
                            h hVar = (h) f.this.f.get(strA);
                            if (hVar == null) {
                                hVar = new h();
                                f.this.f.put(strA, hVar);
                            }
                            hVar.a(gVar);
                        }
                    }
                }
            }
        }
    }

    private void d() {
        this.b = f();
        t.b();
        t.c(new AnonymousClass1());
    }

    public final void a(final String str, final w wVar) {
        t.b();
        t.c(new Runnable() { // from class: com.anythink.core.common.a.f.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.c) {
                    f.this.e();
                    h hVar = (h) f.this.f.get(str);
                    if (hVar == null) {
                        hVar = new h();
                        f.this.f.put(str, hVar);
                    }
                    hVar.a(((r) wVar).aC());
                }
                f.a(f.this, 4, str, wVar);
            }
        });
    }

    public final void b(final String str, final w wVar) {
        t.b();
        t.c(new Runnable() { // from class: com.anythink.core.common.a.f.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.c) {
                    f.this.e();
                    h hVar = (h) f.this.f.get(str);
                    if (hVar == null) {
                        hVar = new h();
                        f.this.f.put(str, hVar);
                    }
                    w wVar2 = wVar;
                    if (wVar2 instanceof r) {
                        hVar.b(((r) wVar2).aC());
                    }
                }
                f.a(f.this, 6, str, wVar);
            }
        });
    }

    public final void a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        synchronized (this.c) {
            e();
            h hVar = this.f.get(str);
            if (hVar != null) {
                hVar.a(jSONObject);
            }
        }
    }

    private void a(int i, String str, w wVar) {
        if (TextUtils.isEmpty(str) || !(wVar instanceof r)) {
            return;
        }
        g gVar = new g();
        gVar.a(str);
        gVar.b(((r) wVar).aC());
        gVar.c(wVar.v());
        gVar.a(i);
        gVar.d("");
        this.e.a(gVar);
    }

    public final void b() {
        this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long jF = f();
        if (this.b != jF) {
            this.f.clear();
            this.b = jF;
        }
    }

    private static long f() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    static /* synthetic */ void a(f fVar, int i, String str, w wVar) {
        if (TextUtils.isEmpty(str) || !(wVar instanceof r)) {
            return;
        }
        g gVar = new g();
        gVar.a(str);
        gVar.b(((r) wVar).aC());
        gVar.c(wVar.v());
        gVar.a(i);
        gVar.d("");
        fVar.e.a(gVar);
    }
}
