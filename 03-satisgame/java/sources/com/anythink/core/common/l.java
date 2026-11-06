package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.au;
import com.anythink.core.common.u.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static final String a = "l";
    private static volatile l n;
    Context b;
    volatile ScheduledFuture<?> g;
    volatile long h;
    long j;
    boolean l;
    String c = com.anythink.core.common.d.t.b.n;
    String d = "first_time";
    volatile boolean f = false;
    final long i = com.anythink.core.common.d.i.l.c;
    AtomicBoolean k = new AtomicBoolean(false);
    Runnable m = new Runnable() { // from class: com.anythink.core.common.l.1
        @Override // java.lang.Runnable
        public final void run() {
            if (l.this.k.get() && SystemClock.elapsedRealtime() >= l.this.j) {
                final boolean z = l.this.l;
                l.this.l = false;
                l.this.j = SystemClock.elapsedRealtime() + l.this.h;
                new com.anythink.core.e.h(com.anythink.core.e.d.a(), l.this.e).a(new com.anythink.core.common.l.c() { // from class: com.anythink.core.common.l.1.1
                    @Override // com.anythink.core.common.l.s
                    public final void onLoadFinish(int i, Object obj) {
                        l.a(l.this, true, obj, z);
                    }

                    @Override // com.anythink.core.common.l.s
                    public final void onLoadError(int i, String str, AdError adError) {
                        l.a(l.this, false, (Object) null, z);
                    }
                });
                l.this.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bh, l.this.m), l.this.h);
            }
        }
    };
    List<au> e = new ArrayList();

    public static l a(Context context) {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    n = new l(context);
                }
            }
        }
        return n;
    }

    private l(Context context) {
        this.b = context;
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    public final void a(long j) {
        this.h = Math.max(j, com.anythink.core.common.d.i.l.c);
        if (this.f) {
            return;
        }
        this.f = true;
        this.j = SystemClock.elapsedRealtime();
        com.anythink.core.common.d.s.b().a(new com.anythink.core.common.d.l() { // from class: com.anythink.core.common.l.2
            @Override // com.anythink.core.common.d.l
            public final void a(boolean z) {
                if (z) {
                    l.a(l.this, Math.max(l.this.j - SystemClock.elapsedRealtime(), 0L) + 200);
                } else {
                    l.a(l.this);
                }
            }
        });
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bg, new AnonymousClass3()));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.l$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            au auVarA;
            try {
                Map<String, ?> mapB = ad.b(l.this.b, l.this.c);
                if (mapB != null) {
                    if (!mapB.containsKey(l.this.d)) {
                        l.this.l = true;
                        ad.a(l.this.b, l.this.c, l.this.d, System.currentTimeMillis());
                    }
                    for (Map.Entry<String, ?> entry : mapB.entrySet()) {
                        if (!TextUtils.equals(entry.getKey(), l.this.d)) {
                            Object value = entry.getValue();
                            if ((value instanceof String) && (auVarA = au.a(new JSONObject((String) value))) != null) {
                                l.this.e.add(auVarA);
                            }
                        }
                    }
                } else {
                    l.this.l = true;
                    ad.a(l.this.b, l.this.c, l.this.d, System.currentTimeMillis());
                }
                l lVar = l.this;
                l.a(lVar, (List) lVar.e, true);
            } catch (Throwable unused) {
            }
            l.a(l.this, 0L);
        }
    }

    private void c() {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bg, new AnonymousClass3()));
    }

    private void b(long j) {
        if (this.k.get()) {
            return;
        }
        this.k.set(true);
        if (j > 0) {
            this.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bd, this.m), j);
        } else {
            this.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.be, this.m), 0L);
        }
    }

    private void d() {
        if (this.k.get()) {
            this.k.set(false);
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(this.g);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.l$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Object a;
        final /* synthetic */ boolean b;

        AnonymousClass4(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONArray jSONArrayOptJSONArray;
            au auVarA;
            boolean z;
            try {
                Object obj = this.a;
                if (!(obj instanceof String) || TextUtils.isEmpty(obj.toString())) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.a.toString());
                if (jSONObject.optInt("code", 0) == 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray(com.anythink.core.common.l.f.R)) != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArrayOptJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && (auVarA = au.a(jSONObjectOptJSONObject)) != null) {
                            if (this.b) {
                                auVarA.h();
                            }
                            if (l.this.e.isEmpty()) {
                                z = false;
                                break;
                            }
                            Iterator<au> it = l.this.e.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().a(auVarA)) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            if (!z) {
                                arrayList.add(auVarA);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    l.a(l.this, arrayList);
                    l.b(l.this, arrayList);
                    l.a(l.this, (List) arrayList, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(boolean z, Object obj, boolean z2) {
        if (z) {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bc, new AnonymousClass4(obj, z2)));
        }
    }

    private static String a(au auVar) {
        return String.valueOf(auVar.d());
    }

    private void a(List<au> list) {
        Iterator<au> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(au auVar) {
        JSONObject jSONObjectB;
        if (auVar == null || (jSONObjectB = auVar.b()) == null) {
            return;
        }
        ad.b(this.b, this.c, String.valueOf(auVar.d()), jSONObjectB.toString());
    }

    private void b(List<au> list) {
        List<au> list2 = this.e;
        if (list2 == null) {
            return;
        }
        if (list2.isEmpty()) {
            this.e.addAll(list);
            return;
        }
        Iterator<au> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            int iD = it.next().d();
            for (au auVar : this.e) {
                if (iD == auVar.d()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(auVar);
                }
            }
        }
        if (arrayList != null) {
            this.e.removeAll(arrayList);
        }
        this.e.addAll(list);
    }

    private void a(List<au> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<au> it = list.iterator();
        while (it.hasNext()) {
            au next = it.next();
            if (next.a()) {
                it = it;
            } else {
                String strP = com.anythink.core.common.d.s.b().p();
                String strQ = com.anythink.core.common.d.s.b().q();
                int iD = next.d();
                boolean z2 = false;
                if (iD == 1 || iD == 2) {
                    List<String> listE = next.e();
                    z2 = listE == null || listE.isEmpty();
                    com.anythink.core.common.r.a aVarC = ad.c(this.b, com.anythink.core.common.d.t.b.a);
                    com.anythink.core.common.r.b.c cVarE = aVarC instanceof com.anythink.core.common.r.b.e ? ((com.anythink.core.common.r.b.e) aVarC).e() : null;
                    Map<String, List<String>> mapA = a(cVarE);
                    Set<String> setKeySet = mapA.keySet();
                    next.a(setKeySet);
                    ArrayList arrayList = new ArrayList();
                    if (!mapA.isEmpty()) {
                        if (z2) {
                            arrayList.addAll(setKeySet);
                        } else {
                            for (String str : listE) {
                                if (mapA.containsKey(str)) {
                                    arrayList.add(str);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        z2 = true;
                    } else {
                        boolean zA = iD == 2 ? a(z2, arrayList, cVarE, mapA) : true;
                        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bf, new AnonymousClass5(arrayList.size(), arrayList, com.anythink.core.e.n.a(this.b), iD, strP, strQ)));
                        z2 = zA;
                    }
                } else if (iD == 3 || iD == 4) {
                    z2 = (iD == 4 && com.anythink.core.common.f.e.a(com.anythink.core.common.f.d.a(this.b)).a(strP) == -1) ? false : true;
                    com.anythink.core.e.d.a(this.b).a(strP, strQ, iD == 3 ? com.anythink.core.common.d.i.ad.l : com.anythink.core.common.d.i.ad.m);
                } else if (iD == 5) {
                    if (!ATSDK.isCnSDK()) {
                        com.anythink.core.common.g.c.a().b(this.b);
                    }
                    z2 = true;
                }
                if (z2 || z) {
                    next.h();
                    b(next);
                }
                com.anythink.core.common.t.f.a(next);
            }
            it = it;
        }
    }

    private void a(au auVar, boolean z) {
        String strP = com.anythink.core.common.d.s.b().p();
        String strQ = com.anythink.core.common.d.s.b().q();
        int iD = auVar.d();
        boolean z2 = false;
        if (iD == 1 || iD == 2) {
            List<String> listE = auVar.e();
            z2 = listE == null || listE.isEmpty();
            com.anythink.core.common.r.a aVarC = ad.c(this.b, com.anythink.core.common.d.t.b.a);
            com.anythink.core.common.r.b.c cVarE = aVarC instanceof com.anythink.core.common.r.b.e ? ((com.anythink.core.common.r.b.e) aVarC).e() : null;
            Map<String, List<String>> mapA = a(cVarE);
            Set<String> setKeySet = mapA.keySet();
            auVar.a(setKeySet);
            ArrayList arrayList = new ArrayList();
            if (!mapA.isEmpty()) {
                if (z2) {
                    arrayList.addAll(setKeySet);
                } else {
                    for (String str : listE) {
                        if (mapA.containsKey(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                z2 = true;
            } else {
                boolean zA = iD == 2 ? a(z2, arrayList, cVarE, mapA) : true;
                com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bf, new AnonymousClass5(arrayList.size(), arrayList, com.anythink.core.e.n.a(this.b), iD, strP, strQ)));
                z2 = zA;
            }
        } else if (iD == 3 || iD == 4) {
            z2 = (iD == 4 && com.anythink.core.common.f.e.a(com.anythink.core.common.f.d.a(this.b)).a(strP) == -1) ? false : true;
            com.anythink.core.e.d.a(this.b).a(strP, strQ, iD == 3 ? com.anythink.core.common.d.i.ad.l : com.anythink.core.common.d.i.ad.m);
        } else if (iD == 5) {
            if (!ATSDK.isCnSDK()) {
                com.anythink.core.common.g.c.a().b(this.b);
            }
            z2 = true;
        }
        if (z2 || z) {
            auVar.h();
            b(auVar);
        }
        com.anythink.core.common.t.f.a(auVar);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.l$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ List b;
        final /* synthetic */ com.anythink.core.e.n c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        AnonymousClass5(int i, List list, com.anythink.core.e.n nVar, int i2, String str, String str2) {
            this.a = i;
            this.b = list;
            this.c = nVar;
            this.d = i2;
            this.e = str;
            this.f = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (int i = 0; i < this.a; i++) {
                String str = (String) this.b.get(i);
                this.c.a(this.c.f(str), this.e, this.f, str, null, null, 2, true, null, false, this.d == 1 ? com.anythink.core.common.d.i.ad.j : com.anythink.core.common.d.i.ad.k);
            }
        }
    }

    private static boolean a(boolean z, List<String> list, com.anythink.core.common.r.b.c cVar, Map<String, List<String>> map) {
        try {
            if (z) {
                cVar.b();
                return true;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                List<String> list2 = map.get(it.next());
                if (list2 != null) {
                    Iterator<String> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        cVar.b(it2.next());
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void c(au auVar) {
        auVar.h();
        b(auVar);
    }

    private static Map<String, List<String>> a(com.anythink.core.common.r.b.c cVar) {
        Set<String> setKeySet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (cVar != null) {
            try {
                Map<String, Object> mapA = cVar.a();
                if (mapA != null && (setKeySet = mapA.keySet()) != null) {
                    for (String str : setKeySet) {
                        com.anythink.core.common.r.b.a();
                        if (com.anythink.core.common.r.b.a(str)) {
                            String strReplace = str.replace(com.anythink.core.common.d.s.b().p(), "").replace("_PL_SY_COLD_START", "").replace("_PL_SY", "");
                            if (!TextUtils.isEmpty(strReplace)) {
                                List arrayList = (List) concurrentHashMap.get(strReplace);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(str);
                                concurrentHashMap.put(strReplace, arrayList);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return concurrentHashMap;
    }

    static /* synthetic */ void a(l lVar, boolean z, Object obj, boolean z2) {
        if (z) {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bc, lVar.new AnonymousClass4(obj, z2)));
        }
    }

    static /* synthetic */ void a(l lVar, long j) {
        if (lVar.k.get()) {
            return;
        }
        lVar.k.set(true);
        if (j > 0) {
            lVar.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bd, lVar.m), j);
        } else {
            lVar.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.be, lVar.m), 0L);
        }
    }

    static /* synthetic */ void a(l lVar) {
        if (lVar.k.get()) {
            lVar.k.set(false);
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(lVar.g);
        }
    }

    static /* synthetic */ void a(l lVar, List list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            if (auVar.a()) {
                it = it;
            } else {
                String strP = com.anythink.core.common.d.s.b().p();
                String strQ = com.anythink.core.common.d.s.b().q();
                int iD = auVar.d();
                boolean z2 = false;
                if (iD == 1 || iD == 2) {
                    List<String> listE = auVar.e();
                    z2 = listE == null || listE.isEmpty();
                    com.anythink.core.common.r.a aVarC = ad.c(lVar.b, com.anythink.core.common.d.t.b.a);
                    com.anythink.core.common.r.b.c cVarE = aVarC instanceof com.anythink.core.common.r.b.e ? ((com.anythink.core.common.r.b.e) aVarC).e() : null;
                    Map<String, List<String>> mapA = a(cVarE);
                    Set<String> setKeySet = mapA.keySet();
                    auVar.a(setKeySet);
                    ArrayList arrayList = new ArrayList();
                    if (!mapA.isEmpty()) {
                        if (z2) {
                            arrayList.addAll(setKeySet);
                        } else {
                            for (String str : listE) {
                                if (mapA.containsKey(str)) {
                                    arrayList.add(str);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        z2 = true;
                    } else {
                        boolean zA = iD == 2 ? a(z2, arrayList, cVarE, mapA) : true;
                        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bf, lVar.new AnonymousClass5(arrayList.size(), arrayList, com.anythink.core.e.n.a(lVar.b), iD, strP, strQ)));
                        z2 = zA;
                    }
                } else if (iD == 3 || iD == 4) {
                    z2 = (iD == 4 && com.anythink.core.common.f.e.a(com.anythink.core.common.f.d.a(lVar.b)).a(strP) == -1) ? false : true;
                    com.anythink.core.e.d.a(lVar.b).a(strP, strQ, iD == 3 ? com.anythink.core.common.d.i.ad.l : com.anythink.core.common.d.i.ad.m);
                } else if (iD == 5) {
                    if (!ATSDK.isCnSDK()) {
                        com.anythink.core.common.g.c.a().b(lVar.b);
                    }
                    z2 = true;
                }
                if (z2 || z) {
                    auVar.h();
                    lVar.b(auVar);
                }
                com.anythink.core.common.t.f.a(auVar);
            }
            it = it;
        }
    }

    static /* synthetic */ void a(l lVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            lVar.b((au) it.next());
        }
    }

    static /* synthetic */ void b(l lVar, List list) {
        List<au> list2 = lVar.e;
        if (list2 != null) {
            if (list2.isEmpty()) {
                lVar.e.addAll(list);
                return;
            }
            Iterator it = list.iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                int iD = ((au) it.next()).d();
                for (au auVar : lVar.e) {
                    if (iD == auVar.d()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(auVar);
                    }
                }
            }
            if (arrayList != null) {
                lVar.e.removeAll(arrayList);
            }
            lVar.e.addAll(list);
        }
    }
}
