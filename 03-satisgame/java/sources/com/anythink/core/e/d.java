package com.anythink.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.v;
import com.anythink.core.common.u.ad;
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
    private String h = com.anythink.core.common.d.t.a.k;
    private final r i = new r();
    private final c j = new c();

    public interface a {
        void a();

        void b();
    }

    private static void g() {
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
        return a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
    }

    private Context d() {
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
    public void e() {
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

    public final String a(String str) {
        b bVarB = b(str);
        if (bVarB == null) {
            return "1";
        }
        boolean zJ = bVarB.J();
        boolean zAZ = bVarB.aZ();
        boolean zBi = bVarB.bi();
        Map<String, Object> map = bVarB.c;
        Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
        boolean zEquals = true;
        if (map != null) {
            zEquals = true ^ map.equals(mapM);
        } else if (mapM == null) {
            zEquals = false;
        }
        if (zJ) {
            return "1";
        }
        if (zAZ) {
            return "2";
        }
        if (zEquals) {
            return "3";
        }
        return zBi ? com.anythink.core.common.d.i.ad.n : "";
    }

    public final b b(String str) {
        r rVar;
        if (d == null) {
            synchronized (this) {
                if (d == null) {
                    try {
                        if (this.e == null) {
                            this.e = com.anythink.core.common.d.s.b().g();
                        }
                        d = a(this.e, str);
                    } catch (Throwable unused) {
                    }
                    if (d == null) {
                        Context context = this.e;
                        b bVar = new b();
                        bVar.b = true;
                        bVar.U();
                        bVar.c("0");
                        bVar.a(0L);
                        bVar.aa();
                        bVar.ad();
                        bVar.af();
                        bVar.d("");
                        bVar.ai();
                        bVar.ak();
                        bVar.e("");
                        bVar.T();
                        bVar.N();
                        bVar.F();
                        bVar.H();
                        bVar.b("[\"com.anythink\"]");
                        bVar.B();
                        bVar.o();
                        bVar.b();
                        bVar.l();
                        if (context != null && (rVar = this.i) != null) {
                            b bVarB = rVar.b(com.anythink.core.common.d.s.b().p());
                            if (bVarB != null) {
                                bVar.a(bVarB.g());
                                bVar.c(bVarB.ba());
                                bVar.d(bVarB.bb());
                                bVar.a(bVarB.bc());
                                bVar.a(bVarB.bd());
                            } else {
                                bVar.c(1);
                                bVar.d(2);
                                bVar.a(com.anythink.core.common.b.b.c());
                            }
                        }
                        bVar.aN();
                        bVar.aP();
                        d = bVar;
                    }
                }
            }
        }
        return d;
    }

    public static long b() {
        if (d == null || d.M() == 0) {
            return 204800L;
        }
        return d.M();
    }

    private b c(Context context) {
        r rVar;
        b bVar = new b();
        bVar.b = true;
        bVar.U();
        bVar.c("0");
        bVar.a(0L);
        bVar.aa();
        bVar.ad();
        bVar.af();
        bVar.d("");
        bVar.ai();
        bVar.ak();
        bVar.e("");
        bVar.T();
        bVar.N();
        bVar.F();
        bVar.H();
        bVar.b("[\"com.anythink\"]");
        bVar.B();
        bVar.o();
        bVar.b();
        bVar.l();
        if (context != null && (rVar = this.i) != null) {
            b bVarB = rVar.b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                bVar.a(bVarB.g());
                bVar.c(bVarB.ba());
                bVar.d(bVarB.bb());
                bVar.a(bVarB.bc());
                bVar.a(bVarB.bd());
            } else {
                bVar.c(1);
                bVar.d(2);
                bVar.a(com.anythink.core.common.b.b.c());
            }
        }
        bVar.aN();
        bVar.aP();
        return bVar;
    }

    private b a(Context context, String str) {
        bu buVar;
        List<bu> listA = com.anythink.core.common.f.e.a(com.anythink.core.common.f.d.a(context)).a(str, this.h);
        if (listA != null && listA.size() > 0 && (buVar = listA.get(0)) != null) {
            try {
                b bVarA = b.a(new JSONObject(buVar.d()));
                if (bVarA != null) {
                    bVarA.a(Long.parseLong(buVar.a()));
                    if (bVarA.bj() == 1 && !bVarA.aZ()) {
                        bVarA.e(1);
                    }
                }
                return bVarA;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private b a(int i, final Context context, final String str, final JSONObject jSONObject) {
        try {
            b bVarB = a(context).b(str);
            if (!bVarB.J()) {
                bVarB.a(jSONObject, (String) null);
            }
        } catch (Throwable unused) {
        }
        if (jSONObject != null) {
            try {
                jSONObject.put("strategy_domain_type_key", i != 1 ? 0 : 1);
            } catch (Throwable unused2) {
            }
        }
        final b bVarA = b.a(jSONObject);
        bVarA.a(System.currentTimeMillis());
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.T, new Runnable() { // from class: com.anythink.core.e.d.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.f.e.a(com.anythink.core.common.f.d.a(context)).a(str, jSONObject.toString(), d.this.h);
                ad.a(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.x, bVarA.Y());
                ad.a(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.y, bVarA.Z());
            }
        }));
        return bVarA;
    }

    private boolean f() {
        return this.f;
    }

    public final synchronized void a(final String str, String str2, String str3) {
        if (this.f) {
            return;
        }
        this.f = true;
        v vVar = new v(str, str2);
        vVar.e();
        if (d != null) {
            d.e(0);
            vVar.a(d.bh());
        }
        if (!TextUtils.isEmpty(str3)) {
            vVar.c(str3);
        }
        this.j.a(this.e, vVar, new com.anythink.core.common.l.s() { // from class: com.anythink.core.e.d.2
            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                d.b(d.this);
                d dVar = d.this;
                dVar.a(dVar.e, i, obj, str);
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str4, AdError adError) {
                d.b(d.this);
                d.this.e();
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadCanceled(int i) {
                d.b(d.this);
                d.this.e();
            }
        });
    }

    private static void a(Context context, b bVar) {
        if (bVar == null) {
            return;
        }
        String strQ = bVar.q();
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, strQ), (com.anythink.core.common.res.b.a) null);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectAV;
        try {
            b bVarB = b(com.anythink.core.common.d.s.b().p());
            if (bVarB == null || (jSONObjectAV = bVarB.aV()) == null) {
                return;
            }
            jSONObject.put("a_c", jSONObjectAV);
        } catch (Exception unused) {
        }
    }

    public final void c(String str) {
        com.anythink.core.common.d.s sVarB = com.anythink.core.common.d.s.b();
        final String strP = sVarB.p();
        String strQ = sVarB.q();
        final Context context = this.e;
        if (context == null || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ)) {
            return;
        }
        b bVarB = b(strP);
        Map<String, String> map = new HashMap<>();
        if (!bVarB.b) {
            map = bVarB.bh();
        }
        v vVar = new v(strP, strQ);
        vVar.a(map);
        if (!TextUtils.isEmpty(str)) {
            vVar.b(str);
        }
        vVar.c(com.anythink.core.common.d.i.ad.o);
        c.b(context, vVar, new com.anythink.core.common.l.s() { // from class: com.anythink.core.e.d.3
            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                d.this.a(context, i, obj, strP);
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str2, AdError adError) {
                d.this.e();
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadCanceled(int i) {
                d.this.e();
            }
        });
    }

    public final void a(Context context, Object obj, String str) {
        a(context, 0, obj, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, Object obj, String str) {
        if (obj instanceof JSONObject) {
            b bVarA = a(i, context, str, (JSONObject) obj);
            if (bVarA != null) {
                d = bVarA;
                String strV = bVarA.v();
                if (!TextUtils.isEmpty(strV) && TextUtils.isEmpty(com.anythink.core.common.d.s.b().D())) {
                    com.anythink.core.common.d.s.b().j(strV);
                }
                com.anythink.core.common.t.a.a.a();
                com.anythink.core.common.t.a.a.a(true);
                com.anythink.core.common.q.a(context).a(d);
                a(context, d);
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.S, new Runnable() { // from class: com.anythink.core.e.d.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.core.common.c.b.a().a(d.d.ap());
                        com.anythink.core.common.n.e.a().a(d.d);
                    }
                }));
                com.anythink.core.common.d.s.b();
                com.anythink.core.common.d.s.c(bVarA);
                com.anythink.core.common.v.a().a(d.g());
                com.anythink.core.common.c.a().b(d.i());
                com.anythink.core.common.a.g.a().c();
                com.anythink.core.common.d.s.b();
                com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
                if (rVarC != null) {
                    rVarC.startRefreshes(bVarA.a());
                }
                com.anythink.core.a.b.a(context.getApplicationContext()).a(bVarA.at());
                com.anythink.core.common.d.s.b().H();
                com.anythink.core.common.d.s.b().a(bVarA);
                com.anythink.core.common.u.e.a().a(bVarA.f());
                com.anythink.core.common.d.r rVarC2 = com.anythink.core.common.d.s.b().c();
                if (rVarC2 != null) {
                    rVarC2.uploadAegisData(bVarA);
                }
                com.anythink.core.bridge.a.b.a().a(context.getApplicationContext());
                com.anythink.core.common.l.a(context.getApplicationContext()).a(bVarA.aQ());
            }
            e();
        }
    }

    public final void d(String str) {
        r rVar = this.i;
        if (rVar != null) {
            rVar.a(str);
        }
    }
}
