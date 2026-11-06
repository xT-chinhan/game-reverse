package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bs;
import com.anythink.core.common.h.v;
import com.anythink.core.common.v.af;
import com.anythink.core.common.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "d";
    private static volatile d c;
    private static volatile b d;
    private Context e;
    private Object g = new Object();
    private boolean f = false;
    List<a> b = Collections.synchronizedList(new ArrayList(3));
    private String h = com.anythink.core.common.d.u.a.j;
    private final r i = new r();
    private final c j = new c();

    public interface a {
        void a();

        void b();
    }

    private static void h() {
    }

    static /* synthetic */ boolean b(d dVar) {
        dVar.f = false;
        return false;
    }

    private d(Context context) {
        this.e = context;
    }

    public static d a(Context context) {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(context);
                }
            }
        }
        return c;
    }

    public static b a() {
        return a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
    }

    private Context e() {
        return this.e;
    }

    private void b(Context context) {
        this.e = context;
    }

    private void a(a aVar) {
        synchronized (this.g) {
            if (this.g != null) {
                this.b.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this.g) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.b.clear();
        }
    }

    private void b(a aVar) {
        synchronized (this.g) {
            if (aVar != null) {
                this.b.remove(aVar);
            }
        }
    }

    public final boolean a(String str) {
        boolean z;
        b bVarB = b(str);
        if (bVarB != null) {
            j jVarD = bVarB.d();
            long jAe = bVarB.ae();
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = bVarB.W() + jAe <= jCurrentTimeMillis;
            boolean z3 = jVarD != null && bVarB.W() + jVarD.a() <= jCurrentTimeMillis;
            Map<String, Object> map = bVarB.c;
            Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
            if (map != null) {
                z = !map.equals(mapM);
            } else {
                z = mapM != null;
            }
            if (!z2 && !z3 && !z) {
                return false;
            }
        }
        return true;
    }

    public final b b(String str) {
        r rVar;
        if (d == null) {
            synchronized (this) {
                if (d == null) {
                    try {
                        if (this.e == null) {
                            this.e = com.anythink.core.common.d.t.b().g();
                        }
                        d = a(this.e, str);
                    } catch (Throwable unused) {
                    }
                    if (d == null) {
                        Context context = this.e;
                        b bVar = new b();
                        bVar.b = true;
                        bVar.af();
                        bVar.c("0");
                        bVar.a(0L);
                        bVar.ak();
                        bVar.an();
                        bVar.ap();
                        bVar.d("");
                        bVar.as();
                        bVar.au();
                        bVar.e("");
                        bVar.ad();
                        bVar.V();
                        bVar.N();
                        bVar.P();
                        bVar.b("[\"com.anythink\"]");
                        bVar.J();
                        bVar.w();
                        bVar.b();
                        bVar.s();
                        if (context != null && (rVar = this.i) != null) {
                            b bVarB = rVar.b(com.anythink.core.common.d.t.b().p());
                            Object[] objArr = new Object[3];
                            Long.valueOf(Thread.currentThread().getId());
                            Thread.currentThread().getName();
                            if (bVarB != null) {
                                bVar.a(bVarB.h());
                            }
                        }
                        d = bVar;
                    }
                }
            }
        }
        return d;
    }

    public static long b() {
        if (d == null || d.U() == 0) {
            return 204800L;
        }
        return d.U();
    }

    private b c(Context context) {
        r rVar;
        b bVar = new b();
        bVar.b = true;
        bVar.af();
        bVar.c("0");
        bVar.a(0L);
        bVar.ak();
        bVar.an();
        bVar.ap();
        bVar.d("");
        bVar.as();
        bVar.au();
        bVar.e("");
        bVar.ad();
        bVar.V();
        bVar.N();
        bVar.P();
        bVar.b("[\"com.anythink\"]");
        bVar.J();
        bVar.w();
        bVar.b();
        bVar.s();
        if (context != null && (rVar = this.i) != null) {
            b bVarB = rVar.b(com.anythink.core.common.d.t.b().p());
            Object[] objArr = new Object[3];
            Long.valueOf(Thread.currentThread().getId());
            Thread.currentThread().getName();
            if (bVarB != null) {
                bVar.a(bVarB.h());
            }
        }
        return bVar;
    }

    private b a(Context context, String str) {
        bs bsVar;
        List<bs> listA = com.anythink.core.common.e.f.a(com.anythink.core.common.e.e.a(context)).a(str, this.h);
        if (listA != null && listA.size() > 0 && (bsVar = listA.get(0)) != null) {
            try {
                b bVarA = b.a(new JSONObject(bsVar.d()));
                if (bVarA != null) {
                    bVarA.a(Long.parseLong(bsVar.a()));
                }
                return bVarA;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private b a(final Context context, final String str, final JSONObject jSONObject) {
        try {
            b bVarB = a(context).b(str);
            if (!bVarB.R()) {
                bVarB.a(jSONObject, null);
            }
        } catch (Throwable unused) {
        }
        final b bVarA = b.a(jSONObject);
        bVarA.a(System.currentTimeMillis());
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.d.d.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.f.a(com.anythink.core.common.e.e.a(context)).a(str, jSONObject.toString(), d.this.h);
                af.a(context, com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.w, bVarA.aj());
            }
        });
        return bVarA;
    }

    private boolean g() {
        return this.f;
    }

    public final synchronized void a(final String str, String str2) {
        if (this.f) {
            return;
        }
        this.f = true;
        v vVar = new v(str, str2);
        vVar.f();
        if (d != null) {
            vVar.a(d.ba());
        }
        this.j.a(this.e, vVar, new com.anythink.core.common.m.q() { // from class: com.anythink.core.d.d.2
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                d.b(d.this);
                d dVar = d.this;
                d.a(dVar, dVar.e, obj, str);
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str3, AdError adError) {
                d.b(d.this);
                String str4 = d.a;
                d.this.f();
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                d.b(d.this);
                d.this.f();
            }
        });
    }

    private static void a(Context context, b bVar) {
        if (bVar == null) {
            return;
        }
        String strY = bVar.y();
        if (TextUtils.isEmpty(strY)) {
            return;
        }
        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strY), (com.anythink.core.common.res.b.a) null);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectAU;
        try {
            b bVarB = b(com.anythink.core.common.d.t.b().p());
            if (bVarB == null || (jSONObjectAU = bVarB.aU()) == null) {
                return;
            }
            jSONObject.put("a_c", jSONObjectAU);
        } catch (Exception unused) {
        }
    }

    public final void c() {
        com.anythink.core.common.d.t tVarB = com.anythink.core.common.d.t.b();
        final String strP = tVarB.p();
        String strQ = tVarB.q();
        final Context context = this.e;
        if (context == null || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ)) {
            return;
        }
        b bVarB = b(strP);
        Map<String, String> map = new HashMap<>();
        if (!bVarB.b) {
            map = bVarB.ba();
        }
        v vVar = new v(strP, strQ);
        vVar.a(map);
        c.b(context, vVar, new com.anythink.core.common.m.q() { // from class: com.anythink.core.d.d.3
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                d.a(d.this, context, obj, strP);
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                d.this.f();
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                d.this.f();
            }
        });
    }

    private void a(Context context, Object obj, String str) {
        if (obj instanceof JSONObject) {
            b bVarA = a(context, str, (JSONObject) obj);
            if (bVarA != null) {
                d = bVarA;
                String strD = bVarA.D();
                if (!TextUtils.isEmpty(strD) && TextUtils.isEmpty(com.anythink.core.common.d.t.b().C())) {
                    com.anythink.core.common.d.t.b().j(strD);
                }
                com.anythink.core.common.q.a(context).a(d);
                b bVar = d;
                if (bVar != null) {
                    String strY = bVar.y();
                    if (!TextUtils.isEmpty(strY)) {
                        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strY), (com.anythink.core.common.res.b.a) null);
                    }
                }
                com.anythink.core.common.v.b.b.a().a(new AnonymousClass4());
                w.a().a(d.h());
                com.anythink.core.common.c.a().b(d.j());
                com.anythink.core.common.a.o.a().e();
                com.anythink.core.common.d.t.b();
                com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
                if (sVarC != null) {
                    sVarC.startRefreshes(bVarA.a());
                }
                com.anythink.core.a.b.a(context.getApplicationContext()).a(bVarA.aH());
                com.anythink.core.common.d.t.b().H();
                com.anythink.core.common.d.t.b().a(bVarA);
                com.anythink.core.common.v.e.a().a(bVarA.g());
                com.anythink.core.common.b.a.a().a(bVarA);
            }
            f();
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.d.d$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.c.b.a().a(d.d.u(), d.d.aC(), d.d.aD(), d.d.aI());
            com.anythink.core.common.o.e.a().a(d.d);
        }
    }

    public final void c(String str) {
        r rVar = this.i;
        if (rVar != null) {
            rVar.a(str);
        }
    }

    static /* synthetic */ void a(d dVar, Context context, Object obj, String str) {
        if (obj instanceof JSONObject) {
            b bVarA = dVar.a(context, str, (JSONObject) obj);
            if (bVarA != null) {
                d = bVarA;
                String strD = bVarA.D();
                if (!TextUtils.isEmpty(strD) && TextUtils.isEmpty(com.anythink.core.common.d.t.b().C())) {
                    com.anythink.core.common.d.t.b().j(strD);
                }
                com.anythink.core.common.q.a(context).a(d);
                b bVar = d;
                if (bVar != null) {
                    String strY = bVar.y();
                    if (!TextUtils.isEmpty(strY)) {
                        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strY), (com.anythink.core.common.res.b.a) null);
                    }
                }
                com.anythink.core.common.v.b.b.a().a(dVar.new AnonymousClass4());
                w.a().a(d.h());
                com.anythink.core.common.c.a().b(d.j());
                com.anythink.core.common.a.o.a().e();
                com.anythink.core.common.d.t.b();
                com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
                if (sVarC != null) {
                    sVarC.startRefreshes(bVarA.a());
                }
                com.anythink.core.a.b.a(context.getApplicationContext()).a(bVarA.aH());
                com.anythink.core.common.d.t.b().H();
                com.anythink.core.common.d.t.b().a(bVarA);
                com.anythink.core.common.v.e.a().a(bVarA.g());
                com.anythink.core.common.b.a.a().a(bVarA);
            }
            dVar.f();
        }
    }
}
