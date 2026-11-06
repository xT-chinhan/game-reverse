package com.anythink.core.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b f;
    Runnable a;
    JSONArray[] b;
    private long g;
    private String k;
    private String l;
    private final String c = getClass().getSimpleName();
    private final String d = com.anythink.core.common.l.f.am;
    private final String e = com.anythink.core.common.l.f.bl;
    private final Object j = new Object();
    private final Object m = new Object();
    private ConcurrentLinkedQueue<e> h = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();

    private static void d() {
    }

    public static b a() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    public b() {
        com.anythink.core.e.b bVarB;
        this.g = 0L;
        this.g = Math.max(0L, ATSDKGlobalSetting.mInspectInterval);
        if (!TextUtils.isEmpty(s.b().p()) && (bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p())) != null && !bVarB.J()) {
            this.g = bVarB.ap();
        }
        a(new Runnable() { // from class: com.anythink.core.common.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (b.this.m) {
                    if (b.this.b == null) {
                        b.this.k = ad.c(s.b().g(), t.b.a, com.anythink.core.common.l.f.am, "");
                        b.this.l = ad.c(s.b().g(), t.b.a, com.anythink.core.common.l.f.bl, "");
                        if (!TextUtils.isEmpty(b.this.k) && !TextUtils.isEmpty(b.this.l)) {
                            b.this.b = new JSONArray[2];
                            try {
                                b.this.b[0] = new JSONArray(b.this.k);
                                b.this.b[1] = new JSONArray(b.this.l);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        });
    }

    public final void a(long j) {
        this.g = j;
        s.b().c(com.anythink.core.common.l.f.bG);
    }

    public final void a(final Context context, final String str, final f.a aVar) {
        a(new Runnable() { // from class: com.anythink.core.common.c.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new f(context, str, aVar));
                b.a(b.this, arrayList);
            }
        });
    }

    private void a(List<e> list) {
        synchronized (this.j) {
            if (list != null) {
                if (list.size() > 0) {
                    this.h.addAll(list);
                    e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.j) {
            if (this.g >= 0 && this.h.size() > 0 && this.a == null) {
                e eVarPoll = this.h.poll();
                if (eVarPoll != null) {
                    Runnable runnableA = a(eVarPoll);
                    this.a = runnableA;
                    a(runnableA);
                } else {
                    e();
                }
            }
        }
    }

    private Runnable a(final e eVar) {
        return new Runnable() { // from class: com.anythink.core.common.c.b.3
            @Override // java.lang.Runnable
            public final void run() {
                c cVarB;
                synchronized (b.this.j) {
                    try {
                        e eVar2 = eVar;
                        if (eVar2 != null && (((cVarB = eVar2.b()) == null || cVarB.a()) && b.this.g > 0)) {
                            try {
                                Thread.sleep(b.this.g);
                            } catch (Throwable unused) {
                            }
                        }
                        b.f(b.this);
                        b.this.e();
                    } catch (Throwable th) {
                        com.anythink.core.common.t.f.b("inspect error", "queue size=" + (b.this.h != null ? b.this.h.size() : -1) + " , " + p.a(th.getStackTrace()), s.b().r());
                    }
                }
            }
        };
    }

    private void f() {
        synchronized (this.j) {
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    private static int g() {
        return ad.b(s.b().g(), t.b.a, t.a.E, 0);
    }

    public final JSONArray[] b() {
        JSONArray[] jSONArrayArr;
        synchronized (this.m) {
            jSONArrayArr = this.b;
        }
        return jSONArrayArr;
    }

    public final Map<String, String> c() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        synchronized (this.m) {
            concurrentHashMap = this.i;
        }
        return concurrentHashMap;
    }

    public final void a(Map<String, String> map) {
        synchronized (this.m) {
            if (map == null) {
                return;
            }
            if (map.isEmpty()) {
                return;
            }
            this.i.clear();
            this.i.putAll(map);
        }
    }

    private static void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.M, runnable));
    }

    private static void a(final Runnable runnable, long j) {
        if (j > 0) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.J, new Runnable() { // from class: com.anythink.core.common.c.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(runnable);
                }
            }), j);
        } else {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.L, runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.K, runnable));
    }

    public final void a(final JSONArray[] jSONArrayArr) {
        synchronized (this.m) {
            this.b = jSONArrayArr;
        }
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.N, new Runnable() { // from class: com.anythink.core.common.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                JSONArray[] jSONArrayArr2 = jSONArrayArr;
                if (jSONArrayArr2 == null || jSONArrayArr2.length != 2) {
                    return;
                }
                try {
                    JSONArray jSONArray = jSONArrayArr2[0];
                    if (jSONArray != null) {
                        String string = jSONArray.toString();
                        if (!TextUtils.equals(string, b.this.k)) {
                            b.this.k = string;
                            ad.b(s.b().g(), t.b.a, com.anythink.core.common.l.f.am, b.this.k);
                        }
                    }
                    JSONArray jSONArray2 = jSONArrayArr[1];
                    if (jSONArray2 != null) {
                        String string2 = jSONArray2.toString();
                        if (TextUtils.equals(string2, b.this.l)) {
                            return;
                        }
                        b.this.l = string2;
                        ad.b(s.b().g(), t.b.a, com.anythink.core.common.l.f.bl, b.this.l);
                    }
                } catch (Throwable unused) {
                }
            }
        }));
    }

    static /* synthetic */ void a(b bVar, List list) {
        synchronized (bVar.j) {
            if (list.size() > 0) {
                bVar.h.addAll(list);
                bVar.e();
            }
        }
    }

    static /* synthetic */ void f(b bVar) {
        synchronized (bVar.j) {
            if (bVar.a != null) {
                bVar.a = null;
            }
        }
    }
}
