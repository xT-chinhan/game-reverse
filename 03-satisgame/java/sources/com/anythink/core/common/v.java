package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSharedPlacementConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.by;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static final String a = "v";
    private static volatile v x;
    private com.anythink.core.common.q.g f;
    private List<com.anythink.core.common.q.h> g;
    private Map<String, com.anythink.core.common.q.c> l;
    private Map<String, a> m;
    private int n;
    private ATSharedPlacementConfig o;
    private List<com.anythink.core.common.q.h> p;
    private final Map<String, Map<String, b>> b = new ConcurrentHashMap();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final int q = 0;
    private final int r = 1;
    private final int s = 2;
    private final int t = 3;
    private int u = 0;
    private long v = -1;
    private final int w = 30000;
    private final Context c = com.anythink.core.common.d.s.b().g();
    private final Map<String, com.anythink.core.common.q.h> h = new ConcurrentHashMap(4);
    private final Map<String, Boolean> i = new ConcurrentHashMap(4);
    private final Set<String> k = Collections.synchronizedSet(new HashSet());
    private final Set<String> j = Collections.synchronizedSet(new HashSet());
    private final com.anythink.core.common.q.e e = new com.anythink.core.common.q.e();

    public interface b {
        void a(String str, String str2, int i);
    }

    static /* synthetic */ int c(v vVar) {
        vVar.u = 3;
        return 3;
    }

    public final synchronized void a(ATSharedPlacementConfig aTSharedPlacementConfig) {
        try {
            if (aTSharedPlacementConfig == null) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("anythink", "setSharedPlacementConfig: null");
                }
                return;
            }
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("anythink", "setSharedPlacementConfig: " + aTSharedPlacementConfig.toString());
            }
            this.o = aTSharedPlacementConfig;
            List<com.anythink.core.common.q.h> list = this.g;
            if (list != null) {
                for (com.anythink.core.common.q.h hVar : list) {
                    e(hVar.b, String.valueOf(hVar.a));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private class a implements Runnable {
        String a;
        ATAdRequest b;
        volatile ScheduledFuture<?> c;

        public a(String str, ATAdRequest aTAdRequest) {
            this.a = str;
            this.b = aTAdRequest;
        }

        public final void a() {
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(this.c);
            this.c = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (v.this) {
                if (v.this.a(this.a)) {
                    if (this.b == null) {
                        this.b = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
                    }
                    v.this.a((com.anythink.core.common.q.h) v.this.h.get(this.a), 11, this.b);
                }
            }
        }
    }

    public static v a() {
        if (x == null) {
            synchronized (v.class) {
                if (x == null) {
                    x = new v();
                }
            }
        }
        return x;
    }

    private v() {
    }

    public final synchronized void a(String str, String str2, b bVar) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && bVar != null) {
                Map<String, b> map = this.b.get(str2);
                if (map == null) {
                    map = new HashMap<>();
                    this.b.put(str2, map);
                }
                map.put(str, bVar);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void b(String str, String str2, b bVar) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && bVar != null) {
                Map<String, b> map = this.b.get(str2);
                if (map != null && map.get(str) == bVar) {
                    map.remove(str);
                    if (map.isEmpty()) {
                        this.b.remove(str2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, int i) {
        synchronized (this) {
            Map<String, b> map = this.b.get(str);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new HashMap(map).entrySet()) {
                    String str2 = (String) entry.getKey();
                    b bVar = (b) entry.getValue();
                    if (bVar != null) {
                        try {
                            bVar.a(str2, str, i);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cL, runnable), 0L);
    }

    private static ScheduledFuture<?> a(Runnable runnable, long j) {
        return com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cM, runnable), j);
    }

    public final boolean a(com.anythink.core.e.l lVar) {
        if (lVar == null || ATAdxSetting.getInstance().isAdxNetworkMode(lVar.i()) || com.anythink.core.common.b.e.a()) {
            return false;
        }
        return a(lVar.v());
    }

    private boolean a(com.anythink.core.common.q.h hVar) {
        List<ATAdInfo> listA;
        String str = hVar.b;
        f fVarB = a(str) ? b(str, String.valueOf(hVar.a)) : null;
        if (fVarB == null) {
            return false;
        }
        int i = hVar.d;
        double d = hVar.e;
        boolean z = i > 0 && (listA = fVarB.a(this.c, (ae) null)) != null && listA.size() < i;
        if (z) {
            return true;
        }
        if (d > 0.0d) {
            HashMap map = new HashMap();
            ae aeVar = new ae();
            aeVar.a(map);
            com.anythink.core.common.h.c cVarA = fVarB.a(this.c, false, false, aeVar);
            if (cVarA != null && cVarA.n() < d) {
                return true;
            }
        }
        return z;
    }

    public final synchronized void a(final com.anythink.core.common.q.g gVar) {
        if (b(gVar)) {
            if (com.anythink.core.common.b.e.a()) {
                return;
            }
            if (gVar.i()) {
                if (this.u == 0 && this.v == -1) {
                    this.v = SystemClock.elapsedRealtime() + gVar.a();
                }
                b(new Runnable() { // from class: com.anythink.core.common.v.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.c(gVar);
                    }
                });
            }
        }
    }

    private boolean b(com.anythink.core.common.q.g gVar) {
        boolean z = false;
        if (com.anythink.core.common.d.s.b().A()) {
            this.d.set(false);
            return false;
        }
        if (gVar == null) {
            this.d.set(false);
            return false;
        }
        List<com.anythink.core.common.q.h> listE = gVar.e();
        this.g = listE;
        AtomicBoolean atomicBoolean = this.d;
        if (listE != null && !listE.isEmpty()) {
            z = true;
        }
        atomicBoolean.set(z);
        this.f = gVar;
        this.h.clear();
        this.h.putAll(gVar.d());
        return this.d.get();
    }

    public final void a(com.anythink.core.common.q.g gVar, com.anythink.core.e.l lVar, final as asVar) {
        final com.anythink.core.common.q.h hVar;
        String strV = lVar != null ? lVar.v() : "";
        if (!b(gVar) || TextUtils.isEmpty(strV) || com.anythink.core.common.b.e.a() || !gVar.a(12, strV) || (hVar = this.h.get(strV)) == null || this.j.contains(strV)) {
            return;
        }
        this.j.add(strV);
        hVar.f = asVar;
        hVar.h = lVar;
        b(new Runnable() { // from class: com.anythink.core.common.v.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (v.this) {
                    v.this.d(hVar.b, String.valueOf(hVar.a));
                    as asVar2 = asVar;
                    v.a(v.this, hVar, asVar2 != null ? asVar2.b() : null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        t.a().a(str, false);
        e(str, str2);
    }

    private void e(String str, String str2) {
        Map<String, Object> nativeLocalExtra;
        if (this.o == null) {
            return;
        }
        str2.hashCode();
        switch (str2) {
            case "0":
                nativeLocalExtra = this.o.getNativeLocalExtra();
                break;
            case "1":
                nativeLocalExtra = this.o.getRewardVideoLocalExtra();
                break;
            case "2":
                nativeLocalExtra = this.o.getBannerLocalExtra();
                break;
            case "3":
                nativeLocalExtra = this.o.getInterstitialLocalExtra();
                break;
            case "4":
                nativeLocalExtra = this.o.getSplashLocalExtra();
                break;
            default:
                nativeLocalExtra = null;
                break;
        }
        a(str, str2).b(nativeLocalExtra);
    }

    public static f a(String str, String str2) {
        return f.a(com.anythink.core.common.d.s.b().g(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.u = 2;
        List<com.anythink.core.common.q.h> list = this.p;
        ArrayList arrayList = new ArrayList(3);
        int iMin = Math.min(this.f.b(), list.size());
        for (int i = 0; i < iMin; i++) {
            arrayList.add(list.get(i));
        }
        list.removeAll(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b((com.anythink.core.common.q.h) it.next());
        }
    }

    private List<com.anythink.core.common.q.h> a(List<com.anythink.core.common.q.h> list) {
        ArrayList arrayList = new ArrayList(3);
        int iMin = Math.min(this.f.b(), list.size());
        for (int i = 0; i < iMin; i++) {
            arrayList.add(list.get(i));
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    private void b(com.anythink.core.common.q.h hVar) {
        a(hVar, 10, new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build());
    }

    private void a(com.anythink.core.common.q.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
        }
        a(hVar, 12, aTAdRequest);
    }

    private void b(com.anythink.core.common.q.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
        }
        a(hVar, 6, aTAdRequest);
    }

    public final void a(final String str, final ATAdRequest aTAdRequest) {
        if (this.f == null || com.anythink.core.common.b.e.a() || !this.f.a(6, str)) {
            return;
        }
        b(new Runnable() { // from class: com.anythink.core.common.v.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (v.this) {
                    if (v.this.a(str)) {
                        v.b(v.this, (com.anythink.core.common.q.h) v.this.h.get(str), aTAdRequest);
                    }
                }
            }
        });
    }

    public final synchronized void b(final String str, final ATAdRequest aTAdRequest) {
        b(new Runnable() { // from class: com.anythink.core.common.v.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (v.this) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (v.this.k.contains(str)) {
                        if (v.this.m == null || v.this.m.get(str) == null) {
                            v.this.c(str, aTAdRequest);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.q.h hVar, int i, ATAdRequest aTAdRequest) {
        if (hVar == null) {
            Log.e(a, "loadSharedPlacement: sharedPlaceInfo = null");
            return;
        }
        if (i != 16) {
            this.e.a(hVar);
        }
        b(hVar.b);
        if (Boolean.TRUE.equals(this.i.get(hVar.b))) {
            return;
        }
        this.i.put(hVar.b, Boolean.TRUE);
        if (i == 10 || i == 12) {
            if (i == 10) {
                this.n++;
            }
            this.j.add(hVar.b);
        }
        com.anythink.core.common.q.c cVar = new com.anythink.core.common.q.c(hVar.b);
        if (this.l == null) {
            this.l = new ConcurrentHashMap();
        }
        this.l.put(cVar.a(), cVar);
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cK, new AnonymousClass6(hVar, i, aTAdRequest, cVar)));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v$6, reason: invalid class name */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ com.anythink.core.common.q.h a;
        final /* synthetic */ int b;
        final /* synthetic */ ATAdRequest c;
        final /* synthetic */ com.anythink.core.common.q.c d;

        AnonymousClass6(com.anythink.core.common.q.h hVar, int i, ATAdRequest aTAdRequest, com.anythink.core.common.q.c cVar) {
            this.a = hVar;
            this.b = i;
            this.c = aTAdRequest;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final com.anythink.core.common.q.b bVar = new com.anythink.core.common.q.b(this.a, this.b, this.c);
            if (this.b == 10) {
                bVar.b();
                bVar.a(v.this.f.c());
            }
            bVar.a(new com.anythink.core.common.q.d() { // from class: com.anythink.core.common.v.6.1
                @Override // com.anythink.core.common.q.d
                public final void a(final String str, final com.anythink.core.common.q.h hVar) {
                    v.this.i.remove(hVar.b);
                    synchronized (v.this) {
                        v.b(new Runnable() { // from class: com.anythink.core.common.v.6.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                v.this.a(str, hVar, bVar);
                            }
                        });
                    }
                }

                @Override // com.anythink.core.common.q.d
                public final void a(final String str, final com.anythink.core.common.q.h hVar, final AdError adError) {
                    v.this.i.remove(hVar.b);
                    synchronized (v.this) {
                        v.b(new Runnable() { // from class: com.anythink.core.common.v.6.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                v.this.b(str, hVar, bVar);
                            }
                        });
                    }
                }

                @Override // com.anythink.core.common.q.d
                public final void b(final String str, final com.anythink.core.common.q.h hVar) {
                    v.this.i.remove(hVar.b);
                    synchronized (v.this) {
                        v.b(new Runnable() { // from class: com.anythink.core.common.v.6.1.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                v.this.a(str, bVar);
                            }
                        });
                    }
                }
            });
            this.d.a(bVar);
            this.d.c();
        }
    }

    private void b(String str) {
        Map<String, a> map;
        a aVarRemove;
        if (TextUtils.isEmpty(str) || (map = this.m) == null || (aVarRemove = map.remove(str)) == null) {
            return;
        }
        aVarRemove.a();
    }

    public final boolean a(String str) {
        try {
            if (!this.d.get() || com.anythink.core.common.d.s.b().A() || TextUtils.isEmpty(str)) {
                return false;
            }
            return this.h.containsKey(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x006d  */
    public synchronized void a(String str, com.anythink.core.common.q.h hVar, com.anythink.core.common.q.b bVar) {
        boolean z;
        List<ATAdInfo> listA;
        this.e.a(hVar);
        com.anythink.core.common.q.c cVarRemove = this.l.remove(str);
        if (cVarRemove != null && bVar != null) {
            String str2 = hVar.b;
            f fVarB = a(str2) ? b(str2, String.valueOf(hVar.a)) : null;
            if (fVarB == null) {
                z = false;
            } else {
                int i = hVar.d;
                double d = hVar.e;
                z = true;
                boolean z2 = i > 0 && (listA = fVarB.a(this.c, (ae) null)) != null && listA.size() < i;
                if (!z2) {
                    if (d > 0.0d) {
                        HashMap map = new HashMap();
                        ae aeVar = new ae();
                        aeVar.a(map);
                        com.anythink.core.common.h.c cVarA = fVarB.a(this.c, false, false, aeVar);
                        if (cVarA == null || cVarA.n() >= d) {
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                }
            }
            if (z) {
                c(cVarRemove.e(), bVar.a());
            }
            if (cVarRemove.d() == 15) {
                a(hVar.b, hVar.h != null ? hVar.h.z() : 0);
            }
            a(cVarRemove, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, com.anythink.core.common.q.h hVar, final com.anythink.core.common.q.b bVar) {
        this.e.a(hVar, new com.anythink.core.common.q.a() { // from class: com.anythink.core.common.v.7
            @Override // com.anythink.core.common.q.a
            public final void a(int i, com.anythink.core.common.q.h hVar2) {
                com.anythink.core.common.q.b bVar2 = bVar;
                v.this.a(hVar2, i, bVar2 != null ? bVar2.a() : null);
            }
        });
        com.anythink.core.common.q.c cVarRemove = this.l.remove(str);
        if (cVarRemove != null && bVar != null) {
            c(cVarRemove.e(), bVar.a());
            a(cVarRemove, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, com.anythink.core.common.q.b bVar) {
        com.anythink.core.common.q.c cVar = this.l.get(str);
        if (cVar == null) {
            return;
        }
        a(cVar, bVar);
    }

    private void a(com.anythink.core.common.q.c cVar, com.anythink.core.common.q.b bVar) {
        this.k.add(cVar.e());
        if (cVar.d() == 10 && cVar.b()) {
            this.n--;
            if (this.n >= this.f.b()) {
                return;
            }
            if (!this.p.isEmpty()) {
                com.anythink.core.common.q.h hVarRemove = this.p.remove(0);
                ATAdRequest aTAdRequestA = bVar != null ? bVar.a() : null;
                if (aTAdRequestA == null) {
                    aTAdRequestA = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
                }
                a(hVarRemove, 10, aTAdRequestA);
                return;
            }
            if (this.n == 0) {
                this.u = 3;
            }
        }
    }

    private f f(String str, String str2) {
        if (a(str)) {
            return b(str, str2);
        }
        return null;
    }

    public static f b(String str, String str2) {
        return t.a().a(str, str2);
    }

    public static by c(String str, String str2) {
        try {
            f fVarB = b(str, str2);
            if (fVarB == null) {
                return null;
            }
            com.anythink.core.common.h.c cVarA = fVarB.a(com.anythink.core.common.d.s.b().g(), false, false, new ae());
            if (cVarA != null && cVarA.e() != null) {
                return cVarA.e().getUnitGroupInfo();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final boolean b() {
        return this.d.get();
    }

    public final void a(com.anythink.core.e.l lVar, final int i, final as asVar, com.anythink.core.common.h.n nVar) {
        String strV;
        final com.anythink.core.common.q.h hVar;
        if (lVar != null) {
            try {
                strV = lVar.v();
            } catch (Throwable unused) {
                return;
            }
        } else {
            strV = "";
        }
        String strI = lVar != null ? lVar.i() : "";
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null && !TextUtils.isEmpty(strV) && !strV.equals(strI)) {
            com.anythink.core.common.q.g gVarG = bVarB.g();
            if (b(gVarG) && !com.anythink.core.common.b.e.a() && gVarG.a(i, strV) && (hVar = this.h.get(strV)) != null) {
                if (Boolean.TRUE.equals(this.i.get(strV))) {
                    return;
                }
                hVar.h = lVar;
                hVar.g = nVar;
                hVar.f = asVar;
                this.e.a(hVar);
                a(new Runnable() { // from class: com.anythink.core.common.v.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        as asVar2 = asVar;
                        v.this.a(hVar, i, asVar2 != null ? asVar2.b() : null);
                    }
                }, i == 15 ? gVarG.f() : 0L);
            }
        }
    }

    private static Context d() {
        return com.anythink.core.common.d.s.b().g();
    }

    private static boolean e() {
        return com.anythink.core.common.b.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.anythink.core.common.q.g gVar) {
        if (com.anythink.core.common.b.e.a()) {
            return;
        }
        if (this.u == 0) {
            this.u = 1;
            this.p = Collections.synchronizedList(new ArrayList());
            for (com.anythink.core.common.q.h hVar : this.g) {
                if (!this.j.contains(hVar.b)) {
                    if (hVar.k != null) {
                        if (Arrays.asList(hVar.k).contains(10)) {
                            this.p.add(hVar);
                            d(hVar.b, String.valueOf(hVar.a));
                        }
                    } else if (gVar != null && gVar.j()) {
                        this.p.add(hVar);
                        d(hVar.b, String.valueOf(hVar.a));
                    }
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.v;
            a(new Runnable() { // from class: com.anythink.core.common.v.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.anythink.core.common.d.s.b().A()) {
                        v.this.d.set(false);
                        v.c(v.this);
                    } else if (v.this.p != null && !v.this.p.isEmpty()) {
                        v.this.c();
                    } else {
                        v.c(v.this);
                    }
                }
            }, jElapsedRealtime < j ? j - SystemClock.elapsedRealtime() : 0L);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        List<com.anythink.core.common.q.h> list = this.g;
        if (list != null) {
            for (com.anythink.core.common.q.h hVar2 : list) {
                if (hVar2 != null) {
                    if (hVar2.k != null) {
                        if (Arrays.asList(hVar2.k).contains(10)) {
                            arrayList.add(hVar2.b);
                        }
                    } else if (gVar != null && gVar.j()) {
                        arrayList.add(hVar2.b);
                    }
                }
            }
        }
        Set<String> set = this.j;
        if (set != null) {
            arrayList2.addAll(set);
        }
        if (!arrayList2.isEmpty()) {
            arrayList2.removeAll(arrayList);
        }
        Set<String> set2 = this.j;
        if (set2 != null) {
            arrayList.removeAll(set2);
        }
        if (!arrayList.isEmpty()) {
            this.p = Collections.synchronizedList(new ArrayList());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.anythink.core.common.q.h hVar3 = this.h.get((String) it.next());
                if (hVar3 != null) {
                    d(hVar3.b, String.valueOf(hVar3.a));
                    if (this.u == 3) {
                        b(hVar3);
                    } else {
                        this.p.add(hVar3);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            for (String str : arrayList2) {
                b(str);
                this.j.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, ATAdRequest aTAdRequest) {
        if (com.anythink.core.common.b.e.a()) {
            return;
        }
        com.anythink.core.common.q.g gVar = this.f;
        if ((gVar != null && gVar.a(11, str)) && a(str)) {
            com.anythink.core.common.q.h hVar = this.h.get(str);
            if (hVar == null) {
                Log.e(a, "startScheduleLoadTask: sharedPlaceInfo = null");
                return;
            }
            if (this.m == null) {
                this.m = new ConcurrentHashMap(5);
            }
            int i = hVar.c;
            if (i < 30000) {
                i = 30000;
            }
            a aVar = new a(str, aTAdRequest);
            this.m.put(str, aVar);
            aVar.c = a(aVar, i);
        }
    }

    static /* synthetic */ void a(v vVar, com.anythink.core.common.q.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
        }
        vVar.a(hVar, 12, aTAdRequest);
    }

    static /* synthetic */ void b(v vVar, com.anythink.core.common.q.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.s.b().F()).build();
        }
        vVar.a(hVar, 6, aTAdRequest);
    }
}
