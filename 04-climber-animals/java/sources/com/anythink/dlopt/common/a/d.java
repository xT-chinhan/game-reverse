package com.anythink.dlopt.common.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ag;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "d";
    private final Context b;
    private final com.anythink.core.common.e.g c;
    private final com.anythink.core.common.v.b.b d = com.anythink.core.common.v.b.b.a();
    private final ConcurrentHashMap<String, Pair<Integer, Boolean>> e = new ConcurrentHashMap<>();

    public interface a {
        void onCallback(j jVar);
    }

    public interface b {
        void a(List<j> list);
    }

    public d(Context context, com.anythink.core.common.e.g gVar) {
        this.b = context;
        this.c = gVar;
    }

    private void c(b bVar) {
        if (this.c != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(7);
            arrayList.add(4);
            arrayList.add(6);
            a(arrayList, 1, bVar);
        }
    }

    public final void a(final j jVar) {
        if (jVar == null) {
            return;
        }
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c != null) {
                    try {
                        d.this.c.b(d.e(jVar));
                    } catch (Throwable th) {
                        String str = d.a;
                        Object[] objArr = new Object[1];
                        th.getMessage();
                    }
                }
            }
        });
    }

    public final void a(final Runnable runnable) {
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    List<ag> listA = d.this.c.a();
                    if (listA.size() == 0) {
                        String str = d.a;
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                            return;
                        }
                        return;
                    }
                    String str2 = d.a;
                    Object[] objArr = new Object[1];
                    Integer.valueOf(listA.size());
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < listA.size(); i++) {
                        ag agVar = listA.get(i);
                        String strG = agVar.g();
                        File file = new File(strG);
                        if (file.exists()) {
                            arrayList.add(file);
                        }
                        int iH = agVar.h();
                        for (int i2 = 0; i2 < iH; i2++) {
                            if (new File(com.anythink.dlopt.common.c.b.a(strG, i2)).exists()) {
                                arrayList.add(file);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        File file2 = (File) arrayList.get(i3);
                        String str3 = d.a;
                        Object[] objArr2 = new Object[1];
                        file2.getName();
                        file2.delete();
                    }
                    d.this.c.e();
                    Runnable runnable3 = runnable;
                    if (runnable3 != null) {
                        runnable3.run();
                    }
                } catch (Throwable th) {
                    String str4 = d.a;
                    th.getMessage();
                    Runnable runnable4 = runnable;
                    if (runnable4 != null) {
                        runnable4.run();
                    }
                }
            }
        });
    }

    public final void a() {
        this.d.a(new Runnable() { // from class: com.anythink.dlopt.common.a.d.5
            @Override // java.lang.Runnable
            public final void run() {
                List<ag> listB = d.this.c.b();
                if (listB.size() == 0) {
                    String str = d.a;
                    return;
                }
                String str2 = d.a;
                Object[] objArr = new Object[1];
                Integer.valueOf(listB.size());
                String packageName = d.this.b.getPackageName();
                for (int i = 0; i < listB.size(); i++) {
                    ag agVar = listB.get(i);
                    String str3 = d.a;
                    agVar.o();
                    agVar.B();
                    if (com.anythink.dlopt.common.c.a.a(d.this.b, agVar.o())) {
                        com.anythink.core.common.u.e.a(agVar.l(), (x) null, agVar.d(), agVar.f(), agVar.e(), agVar.L(), agVar.m(), agVar.o(), agVar.B() > 0 ? System.currentTimeMillis() - agVar.B() : 0L, 2, TextUtils.equals(packageName, com.anythink.dlopt.common.c.a.b(d.this.b, agVar.o())) ? 2 : 3);
                        agVar.l(1);
                        String str4 = d.a;
                        agVar.o();
                        d.this.c.b(agVar);
                    }
                }
            }
        }, (new Random().nextInt(121) + 60) * 1000, 13);
    }

    public final Pair<Integer, Boolean> a(String str) {
        ConcurrentHashMap<String, Pair<Integer, Boolean>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.e) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final void a(String str, int i, boolean z) {
        ConcurrentHashMap<String, Pair<Integer, Boolean>> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, new Pair<>(Integer.valueOf(i), Boolean.valueOf(z)));
        }
    }

    public final void a(final j jVar, final a aVar) {
        if (jVar == null) {
            return;
        }
        final String str = jVar.b;
        if (TextUtils.isEmpty(str)) {
            aVar.onCallback(jVar);
            return;
        }
        Pair<Integer, Boolean> pairA = a(str);
        if (pairA != null) {
            jVar.h = ((Integer) pairA.first).intValue();
            jVar.a(((Boolean) pairA.second).booleanValue());
            aVar.onCallback(jVar);
            return;
        }
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("HEAD");
                    int contentLength = httpURLConnection.getContentLength();
                    String str2 = d.a;
                    Object[] objArr = new Object[1];
                    Integer.valueOf(contentLength);
                    jVar.h = contentLength;
                    String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
                    if (headerField == null || !headerField.equals("bytes")) {
                        String str3 = d.a;
                        jVar.a(false);
                    } else {
                        jVar.a(true);
                    }
                    d.this.a(str, contentLength, jVar.q());
                } catch (Throwable th) {
                    String str4 = d.a;
                    Object[] objArr2 = new Object[1];
                    th.getMessage();
                }
                aVar.onCallback(jVar);
            }
        });
    }

    public final void a(b bVar) {
        if (bVar == null || this.c == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(2);
        a(arrayList, 0, bVar);
    }

    public final void b(final j jVar) {
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.7
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c != null) {
                    ag agVar = new ag();
                    agVar.f(jVar.o);
                    agVar.c(jVar.g);
                    d.this.c.a(agVar);
                }
            }
        });
    }

    public final void c(final j jVar) {
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.8
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c == null || jVar == null) {
                    return;
                }
                d.this.c.b(jVar.o);
            }
        });
    }

    public final void b(b bVar) {
        if (this.c != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a(arrayList, 0, bVar);
        }
    }

    private void a(final List<Integer> list, final int i, final b bVar) {
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.9
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                List<ag> listA = d.this.c.a(list, i);
                if (listA.size() > 0) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        arrayList.add(d.this.a(listA.get(i2)));
                    }
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(arrayList);
                }
            }
        });
    }

    public final void a(final String str, final a aVar) {
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.10
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c != null) {
                    ag agVarA = d.this.c.a(str);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        if (agVarA != null) {
                            aVar2.onCallback(d.this.a(agVarA));
                            return;
                        } else {
                            aVar2.onCallback(null);
                            return;
                        }
                    }
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.onCallback(null);
                }
            }
        });
    }

    private static ag f(j jVar) {
        Object[] objArr = new Object[1];
        ag agVar = new ag();
        agVar.f(jVar.o);
        agVar.g(jVar.n);
        agVar.h(jVar.a);
        agVar.i(jVar.f);
        agVar.j(jVar.b);
        agVar.k(jVar.e);
        agVar.l(jVar.c);
        com.anythink.core.common.k.b bVar = jVar.m;
        if (bVar != null) {
            agVar.m(bVar.getClass().getName());
        }
        agVar.h(jVar.p ? 1 : 0);
        agVar.d(jVar.r);
        agVar.e(jVar.q);
        w wVar = jVar.j;
        if (wVar != null) {
            agVar.n(wVar.z());
            agVar.i(wVar.b());
            agVar.k(wVar.aa());
            if (wVar instanceof bj) {
                bj bjVar = (bj) wVar;
                agVar.p(bjVar.aK());
                agVar.q(bjVar.aC());
            }
            agVar.s(wVar.y());
            y yVarR = wVar.r();
            if (yVarR != null) {
                agVar.f(yVarR.P());
                agVar.g(yVarR.Q());
                agVar.j(yVarR.aw());
                agVar.m(yVarR.ax());
                agVar.n(yVarR.ay());
                agVar.e(yVarR.K());
            }
        }
        agVar.o(jVar.l);
        agVar.e(jVar.s());
        agVar.c(jVar.r());
        agVar.a(jVar.q());
        agVar.a(jVar.t());
        agVar.b(jVar.u());
        agVar.b(jVar.v());
        agVar.c(jVar.w());
        agVar.d(jVar.x());
        agVar.c(jVar.g);
        agVar.d(jVar.h);
        agVar.a(jVar.z());
        agVar.b(jVar.A());
        agVar.a(jVar.B());
        agVar.r(jVar.C());
        agVar.l(jVar.D());
        Object[] objArr2 = new Object[1];
        return agVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j a(final ag agVar) {
        Object[] objArr = new Object[1];
        j jVar = new j();
        bj bjVar = new bj() { // from class: com.anythink.dlopt.common.a.d.11
            @Override // com.anythink.core.common.h.bj, com.anythink.core.common.h.w
            public final String a() {
                return null;
            }

            @Override // com.anythink.core.common.h.w
            public final int b() {
                return agVar.z();
            }
        };
        y yVar = new y() { // from class: com.anythink.dlopt.common.a.d.2
        };
        jVar.o = agVar.j();
        jVar.n = agVar.k();
        jVar.a = agVar.l();
        jVar.f = agVar.m();
        jVar.b = agVar.n();
        jVar.e = agVar.o();
        jVar.c = agVar.p();
        jVar.p = agVar.x();
        jVar.r = agVar.r();
        jVar.q = agVar.s();
        jVar.l = agVar.w();
        jVar.g = agVar.F();
        jVar.h = agVar.G();
        jVar.a(agVar.g());
        jVar.a(agVar.h());
        jVar.a(agVar.i());
        jVar.b(agVar.d());
        jVar.c(agVar.e());
        jVar.d(agVar.f());
        jVar.c(agVar.a());
        jVar.d(agVar.b());
        jVar.e(agVar.c());
        jVar.f(agVar.M());
        jVar.f(agVar.E());
        long jA = agVar.A();
        if (jA > 0) {
            jVar.a(jA);
        }
        long jB = agVar.B();
        if (jB > 0) {
            jVar.b(jB);
        }
        long jB2 = agVar.B() - agVar.A();
        if (jB2 > 0) {
            jVar.i = jB2;
        }
        yVar.E(agVar.t());
        yVar.F(agVar.u());
        yVar.X(agVar.C());
        yVar.Y(agVar.H());
        yVar.Z(agVar.I());
        yVar.c(agVar.J());
        bjVar.c(yVar);
        bjVar.o(agVar.v());
        bjVar.ag(agVar.K());
        bjVar.x(agVar.o());
        bjVar.k(agVar.m());
        bjVar.aa(agVar.L());
        bjVar.n(agVar.N());
        jVar.j = bjVar;
        try {
            if (!TextUtils.isEmpty(agVar.v())) {
                int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, this.b.getResources().getDisplayMetrics());
                jVar.d = com.anythink.core.common.res.b.a(this.b).a(new com.anythink.core.common.res.e(1, bjVar.z()), iApplyDimension, iApplyDimension);
            }
            String strQ = agVar.q();
            if (!TextUtils.isEmpty(strQ)) {
                jVar.m = (com.anythink.core.common.k.b) Class.forName(strQ).newInstance();
            }
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
        int iD = agVar.D();
        if (iD == 4) {
            jVar.j();
        } else if (iD == 5) {
            jVar.m();
        } else if (iD == 6) {
            jVar.o();
        } else if (iD == 2) {
            jVar.n();
        } else if (iD == 7) {
            jVar.l();
        }
        Object[] objArr3 = new Object[1];
        return jVar;
    }

    private static int a(c.e eVar) {
        if (eVar == c.e.LOADING) {
            return 4;
        }
        if (eVar == c.e.FINISH) {
            return 5;
        }
        if (eVar == c.e.FAIL) {
            return 6;
        }
        if (eVar == c.e.INSTALLED) {
            return 2;
        }
        return (eVar == c.e.PAUSE || eVar == c.e.STOP) ? 7 : 0;
    }

    private static void a(int i, j jVar) {
        if (i == 4) {
            jVar.j();
            return;
        }
        if (i == 5) {
            jVar.m();
            return;
        }
        if (i == 6) {
            jVar.o();
        } else if (i == 2) {
            jVar.n();
        } else if (i == 7) {
            jVar.l();
        }
    }

    public final void a(String str, j jVar) {
        if (jVar == null || this.b == null) {
            Object[] objArr = new Object[2];
            return;
        }
        jVar.f(str);
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.b.getPackageName());
        intent.putExtra(com.anythink.dlopt.common.b.f, jVar.f);
        intent.putExtra(com.anythink.dlopt.common.b.g, jVar.n);
        com.anythink.core.common.l.a(this.b).a(intent);
        Object[] objArr2 = new Object[2];
        String str2 = jVar.o;
    }

    public final void d(final j jVar) {
        if (jVar == null) {
            return;
        }
        b(new Runnable() { // from class: com.anythink.dlopt.common.a.d.3
            @Override // java.lang.Runnable
            public final void run() {
                ag agVarA;
                String strC = jVar.C();
                if (TextUtils.isEmpty(strC) && d.this.c != null && (agVarA = d.this.c.a(jVar.o)) != null) {
                    strC = agVarA.M();
                }
                String str = d.a;
                Object[] objArr = new Object[2];
                String str2 = jVar.o;
                if (TextUtils.isEmpty(strC)) {
                    d.this.a(com.anythink.dlopt.common.b.b, jVar);
                    d.this.a(com.anythink.dlopt.common.b.c, jVar);
                } else if (strC.equals(com.anythink.dlopt.common.b.b)) {
                    d.this.a(com.anythink.dlopt.common.b.c, jVar);
                }
            }
        });
    }

    private void b(Runnable runnable) {
        this.d.c(runnable, 13);
    }

    private static void c(Runnable runnable) {
        t.b().b(runnable);
    }

    static /* synthetic */ ag e(j jVar) {
        Object[] objArr = new Object[1];
        ag agVar = new ag();
        agVar.f(jVar.o);
        agVar.g(jVar.n);
        agVar.h(jVar.a);
        agVar.i(jVar.f);
        agVar.j(jVar.b);
        agVar.k(jVar.e);
        agVar.l(jVar.c);
        com.anythink.core.common.k.b bVar = jVar.m;
        if (bVar != null) {
            agVar.m(bVar.getClass().getName());
        }
        agVar.h(jVar.p ? 1 : 0);
        agVar.d(jVar.r);
        agVar.e(jVar.q);
        w wVar = jVar.j;
        if (wVar != null) {
            agVar.n(wVar.z());
            agVar.i(wVar.b());
            agVar.k(wVar.aa());
            if (wVar instanceof bj) {
                bj bjVar = (bj) wVar;
                agVar.p(bjVar.aK());
                agVar.q(bjVar.aC());
            }
            agVar.s(wVar.y());
            y yVarR = wVar.r();
            if (yVarR != null) {
                agVar.f(yVarR.P());
                agVar.g(yVarR.Q());
                agVar.j(yVarR.aw());
                agVar.m(yVarR.ax());
                agVar.n(yVarR.ay());
                agVar.e(yVarR.K());
            }
        }
        agVar.o(jVar.l);
        agVar.e(jVar.s());
        agVar.c(jVar.r());
        agVar.a(jVar.q());
        agVar.a(jVar.t());
        agVar.b(jVar.u());
        agVar.b(jVar.v());
        agVar.c(jVar.w());
        agVar.d(jVar.x());
        agVar.c(jVar.g);
        agVar.d(jVar.h);
        agVar.a(jVar.z());
        agVar.b(jVar.A());
        agVar.a(jVar.B());
        agVar.r(jVar.C());
        agVar.l(jVar.D());
        Object[] objArr2 = new Object[1];
        return agVar;
    }
}
