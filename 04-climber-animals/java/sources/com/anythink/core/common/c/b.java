package com.anythink.core.common.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.e.l;
import com.anythink.core.common.h.at;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b c = null;
    private static final long k = 86400000;
    Runnable a;
    private long d;
    private boolean j;
    private long l;
    private final String b = getClass().getSimpleName();
    private final Set<String> i = Collections.synchronizedSet(new HashSet());
    private final Object h = new Object();
    private ConcurrentLinkedQueue<f> e = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String, c> f = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, c> g = new ConcurrentHashMap<>();

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public b() {
        com.anythink.core.d.b bVarB;
        this.d = 0L;
        this.d = Math.max(0L, ATSDKGlobalSetting.mInspectInterval);
        this.j = false;
        if (!TextUtils.isEmpty(t.b().p()) && (bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p())) != null && !bVarB.R()) {
            this.d = bVarB.aD();
            this.j = a(bVarB.aI());
        }
        a(new Runnable() { // from class: com.anythink.core.common.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                String unused = b.this.b;
                synchronized (b.this.h) {
                    if (b.this.j) {
                        b.d(b.this);
                    } else {
                        l lVarA = l.a(com.anythink.core.common.e.e.a(t.b().g()));
                        String unused2 = b.this.b;
                        lVarA.a();
                        List<at> listB = lVarA.b();
                        if (listB != null) {
                            for (at atVar : listB) {
                                if (!b.this.g.containsKey(atVar.a())) {
                                    ConcurrentHashMap concurrentHashMap = b.this.g;
                                    String strA = atVar.a();
                                    String strA2 = atVar.a();
                                    long jC = atVar.c();
                                    boolean z = true;
                                    if (atVar.b() != 1) {
                                        z = false;
                                    }
                                    concurrentHashMap.put(strA, new c("", strA2, false, jC, z));
                                    String unused3 = b.this.b;
                                    new StringBuilder("Inspect From DB[").append(Thread.currentThread().getName()).append("]:");
                                    ((c) b.this.g.get(atVar.a())).toString();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public final void a(final List<a> list) {
        if (t.b().c(com.anythink.core.common.m.e.bu)) {
            return;
        }
        list.size();
        Math.max(0L, ATSDKGlobalSetting.mDelayInspectTime);
        if (list.size() > 0) {
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.c.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    Context contextG;
                    String unused = b.this.b;
                    Thread.currentThread().getName();
                    list.size();
                    long j = ATSDKGlobalSetting.mDelayInspectTime;
                    List list2 = list;
                    if (list2 == null || list2.size() <= 0 || (contextG = t.b().g()) == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        a aVar = (a) list.get(i);
                        if (aVar != null) {
                            arrayList.add(new g(contextG, aVar.a(), aVar.b(), af.b(contextG, u.b.a, "det_time_" + aVar.b(), 0L)));
                        }
                    }
                    if (arrayList.size() > 0) {
                        b.a(b.this, arrayList);
                    }
                }
            }, Math.max(0L, ATSDKGlobalSetting.mDelayInspectTime), 17);
        }
    }

    public final void a(final String str, final int i, final long j, final int i2) {
        this.d = j;
        this.j = a(i2);
        if (t.b().c(com.anythink.core.common.m.e.bu) || TextUtils.isEmpty(str)) {
            return;
        }
        a(new Runnable() { // from class: com.anythink.core.common.c.b.3
            @Override // java.lang.Runnable
            public final void run() {
                String strC;
                synchronized (b.this.h) {
                    String unused = b.this.b;
                    Thread.currentThread().getName();
                    try {
                        strC = k.c(str);
                    } catch (Throwable unused2) {
                        com.anythink.core.common.u.e.b("handleUpdateInspectInfo error", "cur offset: " + b.b() + ", error string: " + str, t.b().r());
                        strC = null;
                    }
                    String unused3 = b.this.b;
                    String unused4 = b.this.b;
                    Map<String, Object> mapC = q.c(strC);
                    String unused5 = b.this.b;
                    mapC.size();
                    if (i == 1 || mapC.size() == 0) {
                        String unused6 = b.this.b;
                        af.a(t.b().g(), u.b.a, u.a.B, 0);
                    } else {
                        af.a(t.b().g(), u.b.a, u.a.B, b.b() + mapC.size());
                        String unused7 = b.this.b;
                    }
                    Iterator<Map.Entry<String, Object>> it = mapC.entrySet().iterator();
                    Context contextG = t.b().g();
                    if (contextG != null) {
                        if (b.this.j) {
                            b.d(b.this);
                            if (!b.this.i.isEmpty()) {
                                while (it.hasNext()) {
                                    Map.Entry<String, Object> next = it.next();
                                    String key = next.getKey();
                                    String string = next.getValue().toString();
                                    boolean zContains = b.this.i.contains(string);
                                    String unused8 = b.this.b;
                                    new StringBuilder("check apk install by ApkInspectV2[").append(Thread.currentThread().getName()).append("],result: inspectKey").append(key).append(",packageName:").append(string).append("hasInstall:");
                                    b.this.g.put(key, new c(string, key, true, System.currentTimeMillis(), zContains));
                                    l.a(com.anythink.core.common.e.e.a(contextG)).a(key, zContains);
                                }
                            }
                        } else {
                            ArrayList arrayList = new ArrayList();
                            while (it.hasNext()) {
                                Map.Entry<String, Object> next2 = it.next();
                                try {
                                    String key2 = next2.getKey();
                                    String string2 = next2.getValue().toString();
                                    c cVar = (c) b.this.g.get(key2);
                                    if (cVar != null) {
                                        arrayList.add(new d(contextG, string2, key2, cVar.a(), cVar.b()));
                                    } else {
                                        arrayList.add(new d(contextG, string2, key2, 0L));
                                    }
                                } catch (Throwable unused9) {
                                }
                            }
                            if (arrayList.size() > 0) {
                                b.a(b.this, arrayList);
                            }
                        }
                        com.anythink.core.common.u.e.a(i2, b.this.i.size(), i, j);
                    }
                }
            }
        });
    }

    public final void a(final Context context, final String str, final h.a aVar) {
        a(new Runnable() { // from class: com.anythink.core.common.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(context, str, aVar));
                b.a(b.this, arrayList);
            }
        });
    }

    private void b(List<f> list) {
        synchronized (this.h) {
            if (list != null) {
                if (list.size() > 0) {
                    this.e.addAll(list);
                    e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.h) {
            if (this.d >= 0 && this.e.size() > 0 && this.a == null) {
                f fVarPoll = this.e.poll();
                if (fVarPoll != null) {
                    Runnable runnableA = a(fVarPoll);
                    this.a = runnableA;
                    a(runnableA);
                } else {
                    e();
                }
            }
        }
    }

    private Runnable a(final f fVar) {
        return new Runnable() { // from class: com.anythink.core.common.c.b.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (b.this.h) {
                    try {
                        f fVar2 = fVar;
                        if (fVar2 != null) {
                            c cVarA = fVar2.a();
                            if (cVarA != null) {
                                int iB = fVar.b();
                                if (iB == 1) {
                                    b.this.f.put(cVarA.e(), cVarA);
                                } else if (iB == 2) {
                                    b.this.g.put(cVarA.e(), cVarA);
                                }
                            }
                            if ((cVarA == null || cVarA.d()) && b.this.d > 0) {
                                try {
                                    Thread.sleep(b.this.d);
                                } catch (Throwable unused) {
                                }
                            }
                            String unused2 = b.this.b;
                            Thread.currentThread().getName();
                            long unused3 = b.this.d;
                            if (cVarA != null) {
                                cVarA.toString();
                            }
                        }
                        b.i(b.this);
                        b.this.e();
                    } catch (Throwable th) {
                        com.anythink.core.common.u.e.b("inspect error", "queue size=" + (b.this.e != null ? b.this.e.size() : -1) + " , " + q.a(th.getStackTrace()), t.b().r());
                    }
                }
            }
        };
    }

    private void f() {
        synchronized (this.h) {
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    public static int b() {
        return af.b(t.b().g(), u.b.a, u.a.B, 0);
    }

    public final JSONArray[] c() {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it = this.g.keySet().iterator();
            while (it.hasNext()) {
                c cVar = this.g.get(it.next());
                if (cVar != null && cVar.b()) {
                    jSONArray.put(Long.parseLong(cVar.e()));
                    jSONArray2.put(Math.floor(((System.currentTimeMillis() - cVar.a()) / 1000.0d) / 3600.0d));
                }
            }
            jSONArrayArr[0] = jSONArray;
            jSONArrayArr[1] = jSONArray2;
        } catch (Throwable unused) {
        }
        return jSONArrayArr;
    }

    public final List<c> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f.keySet().iterator();
        while (it.hasNext()) {
            c cVar = this.f.get(it.next());
            if (cVar != null && cVar.b()) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private static void a(Runnable runnable) {
        com.anythink.core.common.v.b.b.a().b(runnable, 17);
    }

    private static void a(Runnable runnable, long j) {
        com.anythink.core.common.v.b.b.a().a(runnable, j, 17);
    }

    private static boolean a(int i) {
        return (i == 1 || t.b().c(com.anythink.core.common.m.e.bv)) ? false : true;
    }

    private boolean g() {
        if (this.j) {
            return this.i.isEmpty() || System.currentTimeMillis() - this.l > 86400000;
        }
        return false;
    }

    private void h() {
        if (this.j && (this.i.isEmpty() || System.currentTimeMillis() - this.l > 86400000)) {
            this.i.clear();
            try {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> listA = y.a(t.b().g(), intent);
                if (listA != null) {
                    for (ResolveInfo resolveInfo : listA) {
                        if (resolveInfo.activityInfo != null) {
                            this.i.add(resolveInfo.activityInfo.packageName);
                        }
                    }
                }
                this.l = System.currentTimeMillis();
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void d(b bVar) {
        if (bVar.j && (bVar.i.isEmpty() || System.currentTimeMillis() - bVar.l > 86400000)) {
            bVar.i.clear();
            try {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> listA = y.a(t.b().g(), intent);
                if (listA != null) {
                    for (ResolveInfo resolveInfo : listA) {
                        if (resolveInfo.activityInfo != null) {
                            bVar.i.add(resolveInfo.activityInfo.packageName);
                        }
                    }
                }
                bVar.l = System.currentTimeMillis();
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void a(b bVar, List list) {
        synchronized (bVar.h) {
            if (list.size() > 0) {
                bVar.e.addAll(list);
                bVar.e();
            }
        }
    }

    static /* synthetic */ void i(b bVar) {
        synchronized (bVar.h) {
            if (bVar.a != null) {
                bVar.a = null;
            }
        }
    }
}
