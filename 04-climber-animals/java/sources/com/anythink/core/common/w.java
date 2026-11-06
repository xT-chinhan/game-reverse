package com.anythink.core.common;

import android.content.Context;
import android.os.Handler;
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
import com.anythink.core.common.h.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class w {
    public static final String a = "w";
    private static volatile w x;
    private volatile Handler e;
    private com.anythink.core.common.r.g f;
    private List<com.anythink.core.common.r.h> g;
    private Map<String, com.anythink.core.common.r.c> l;
    private Map<String, a> m;
    private int n;
    private ATSharedPlacementConfig o;
    private List<com.anythink.core.common.r.h> p;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final int q = 0;
    private final int r = 1;
    private final int s = 2;
    private final int t = 3;
    private int u = 0;
    private long v = -1;
    private final int w = 30000;
    private final Context b = com.anythink.core.common.d.t.b().g();
    private final Map<String, com.anythink.core.common.r.h> h = new ConcurrentHashMap(4);
    private final Map<String, Boolean> i = new ConcurrentHashMap(4);
    private final Set<String> k = Collections.synchronizedSet(new HashSet());
    private final Set<String> j = Collections.synchronizedSet(new HashSet());
    private final com.anythink.core.common.r.e d = new com.anythink.core.common.r.e();

    static /* synthetic */ int d(w wVar) {
        wVar.u = 3;
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
            List<com.anythink.core.common.r.h> list = this.g;
            if (list != null) {
                for (com.anythink.core.common.r.h hVar : list) {
                    c(hVar.b, String.valueOf(hVar.a));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private class a implements Runnable {
        String a;
        ATAdRequest b;

        public a(String str, ATAdRequest aTAdRequest) {
            this.a = str;
            this.b = aTAdRequest;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (w.this) {
                if (w.this.a(this.a)) {
                    if (this.b == null) {
                        this.b = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
                    }
                    w.this.a((com.anythink.core.common.r.h) w.this.h.get(this.a), 11, this.b);
                }
            }
        }
    }

    public static w a() {
        if (x == null) {
            synchronized (w.class) {
                if (x == null) {
                    x = new w();
                }
            }
        }
        return x;
    }

    private w() {
    }

    private void a(Runnable runnable) {
        a(runnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable, long j) {
        Handler handlerC = c();
        if (handlerC != null) {
            handlerC.postDelayed(runnable, j);
        }
    }

    private void b(Runnable runnable) {
        Handler handlerC = c();
        if (handlerC != null) {
            handlerC.removeCallbacks(runnable);
        }
    }

    private Handler c() {
        if (this.e == null) {
            synchronized (w.class) {
                if (this.e == null) {
                    this.e = com.anythink.core.common.v.b.b.a().a(15);
                }
            }
        }
        return this.e;
    }

    public final boolean a(com.anythink.core.d.l lVar) {
        if (lVar == null) {
            return false;
        }
        if (ATAdxSetting.getInstance().isAdxNetworkMode(lVar.i())) {
            lVar.i();
            return false;
        }
        return a(lVar.u());
    }

    private boolean a(com.anythink.core.common.r.h hVar) {
        boolean z;
        List<ATAdInfo> listA;
        hVar.toString();
        String str = hVar.b;
        f fVarA = a(str) ? a(str, String.valueOf(hVar.a)) : null;
        if (fVarA == null) {
            hVar.toString();
            return false;
        }
        int i = hVar.d;
        double d = hVar.e;
        if (i <= 0 || (listA = fVarA.a(this.b, (ae) null)) == null || listA.size() >= i) {
            z = false;
        } else {
            listA.size();
            hVar.toString();
            z = true;
        }
        if (z) {
            return true;
        }
        if (d > 0.0d) {
            HashMap map = new HashMap();
            ae aeVar = new ae();
            aeVar.a(map);
            com.anythink.core.common.h.c cVarA = fVarA.a(this.b, false, false, aeVar);
            if (cVarA != null && cVarA.n() < d) {
                cVarA.n();
                hVar.toString();
                return true;
            }
        }
        return z;
    }

    public final synchronized void a(final com.anythink.core.common.r.g gVar) {
        if (!b(gVar)) {
            Object[] objArr = new Object[1];
            return;
        }
        if (gVar.a(10)) {
            if (this.u == 0 && this.v == -1) {
                this.v = SystemClock.elapsedRealtime() + gVar.a();
                gVar.a();
            }
            a(new Runnable() { // from class: com.anythink.core.common.w.1
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.e();
                }
            }, 0L);
        }
    }

    private boolean d() {
        boolean z = c() == null;
        if (z) {
            com.anythink.core.common.u.e.b("shared handler error", "thread create failed", com.anythink.core.common.d.t.b().r());
        }
        return z;
    }

    private boolean b(com.anythink.core.common.r.g gVar) {
        boolean z = false;
        if (com.anythink.core.common.d.t.b().z() || d()) {
            this.c.set(false);
            return false;
        }
        if (gVar == null) {
            this.c.set(false);
            return false;
        }
        List<com.anythink.core.common.r.h> listE = gVar.e();
        this.g = listE;
        AtomicBoolean atomicBoolean = this.c;
        if (listE != null && !listE.isEmpty()) {
            z = true;
        }
        atomicBoolean.set(z);
        this.f = gVar;
        this.h.clear();
        this.h.putAll(gVar.d());
        boolean z2 = this.c.get();
        Object[] objArr = new Object[1];
        Boolean.valueOf(z2);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        if (this.u == 0) {
            this.u = 1;
            this.p = Collections.synchronizedList(new ArrayList());
            for (com.anythink.core.common.r.h hVar : this.g) {
                if (this.j.contains(hVar.b)) {
                    String str = hVar.b;
                } else {
                    this.p.add(hVar);
                    b(hVar.b, String.valueOf(hVar.a));
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.v;
            a(new Runnable() { // from class: com.anythink.core.common.w.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (!com.anythink.core.common.d.t.b().z()) {
                        if (w.this.p != null && !w.this.p.isEmpty()) {
                            w.this.f();
                            return;
                        } else {
                            String str2 = w.a;
                            w.d(w.this);
                            return;
                        }
                    }
                    String str3 = w.a;
                    w.this.c.set(false);
                    w.d(w.this);
                }
            }, jElapsedRealtime < j ? j - SystemClock.elapsedRealtime() : 0L);
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator<com.anythink.core.common.r.h> it = this.g.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b);
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
            for (String str2 : arrayList) {
                com.anythink.core.common.r.h hVar2 = this.h.get(str2);
                if (hVar2 != null) {
                    b(hVar2.b, String.valueOf(hVar2.a));
                    if (this.u == 3) {
                        new StringBuilder("handleSharedPlacement, find open placement id: ").append(str2);
                        b(hVar2);
                    } else {
                        hVar2.toString();
                        this.p.add(hVar2);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            for (String str3 : arrayList2) {
                b(str3);
                this.j.remove(str3);
            }
        }
    }

    public final void a(com.anythink.core.common.r.g gVar, com.anythink.core.d.l lVar, final ar arVar) {
        String strU = lVar != null ? lVar.u() : "";
        if (!b(gVar) || TextUtils.isEmpty(strU)) {
            return;
        }
        if (!gVar.a(12)) {
            Object[] objArr = new Object[1];
            return;
        }
        final com.anythink.core.common.r.h hVar = this.h.get(strU);
        if (hVar == null || this.j.contains(strU)) {
            return;
        }
        this.j.add(strU);
        hVar.f = arVar;
        hVar.h = lVar;
        a(new Runnable() { // from class: com.anythink.core.common.w.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (w.this) {
                    w.this.b(hVar.b, String.valueOf(hVar.a));
                    ar arVar2 = arVar;
                    w.a(w.this, hVar, arVar2 != null ? arVar2.b() : null);
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        u.a().a(str, false);
        c(str, str2);
    }

    private void c(String str, String str2) {
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
        if (nativeLocalExtra != null) {
            nativeLocalExtra.toString();
        }
        u.a().a(str, nativeLocalExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        this.u = 2;
        List<com.anythink.core.common.r.h> list = this.p;
        ArrayList arrayList = new ArrayList(3);
        int iMin = Math.min(this.f.b(), list.size());
        for (int i = 0; i < iMin; i++) {
            arrayList.add(list.get(i));
            list.get(i).toString();
        }
        list.removeAll(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b((com.anythink.core.common.r.h) it.next());
        }
    }

    private List<com.anythink.core.common.r.h> a(List<com.anythink.core.common.r.h> list) {
        ArrayList arrayList = new ArrayList(3);
        int iMin = Math.min(this.f.b(), list.size());
        for (int i = 0; i < iMin; i++) {
            arrayList.add(list.get(i));
            list.get(i).toString();
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    private void b(com.anythink.core.common.r.h hVar) {
        a(hVar, 10, new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build());
    }

    private void a(com.anythink.core.common.r.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
        }
        a(hVar, 12, aTAdRequest);
    }

    private void b(com.anythink.core.common.r.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
        }
        a(hVar, 6, aTAdRequest);
    }

    public final void a(final String str, final ATAdRequest aTAdRequest) {
        com.anythink.core.common.r.g gVar = this.f;
        if (gVar == null) {
            return;
        }
        if (gVar.a(6)) {
            a(new Runnable() { // from class: com.anythink.core.common.w.4
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (w.this) {
                        if (w.this.a(str)) {
                            String str2 = w.a;
                            w.b(w.this, (com.anythink.core.common.r.h) w.this.h.get(str), aTAdRequest);
                        } else {
                            String str3 = w.a;
                        }
                    }
                }
            }, 0L);
        } else {
            Object[] objArr = new Object[1];
        }
    }

    public final synchronized void b(final String str, final ATAdRequest aTAdRequest) {
        a(new Runnable() { // from class: com.anythink.core.common.w.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (w.this) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (w.this.k.contains(str)) {
                        if (w.this.m == null || w.this.m.get(str) == null) {
                            String str2 = w.a;
                            w.this.c(str, aTAdRequest);
                        } else {
                            String str3 = w.a;
                        }
                        return;
                    }
                    String str4 = w.a;
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.r.h hVar, int i, ATAdRequest aTAdRequest) {
        Object[] objArr = new Object[1];
        Integer.valueOf(i);
        if (hVar == null) {
            Log.e(a, "loadSharedPlacement: sharedPlaceInfo = null");
            return;
        }
        Object[] objArr2 = new Object[1];
        hVar.toString();
        if (i != 16) {
            this.d.a(hVar);
        }
        b(hVar.b);
        if (Boolean.TRUE.equals(this.i.get(hVar.b))) {
            Object[] objArr3 = new Object[1];
            String str = hVar.b;
            return;
        }
        this.i.put(hVar.b, Boolean.TRUE);
        if (i == 10 || i == 12) {
            if (i == 10) {
                this.n++;
                hVar.toString();
            }
            this.j.add(hVar.b);
        }
        com.anythink.core.common.r.c cVar = new com.anythink.core.common.r.c(hVar.b);
        if (this.l == null) {
            this.l = new ConcurrentHashMap();
        }
        this.l.put(cVar.a(), cVar);
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass6(hVar, i, aTAdRequest, cVar), 2);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.w$6, reason: invalid class name */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ com.anythink.core.common.r.h a;
        final /* synthetic */ int b;
        final /* synthetic */ ATAdRequest c;
        final /* synthetic */ com.anythink.core.common.r.c d;

        AnonymousClass6(com.anythink.core.common.r.h hVar, int i, ATAdRequest aTAdRequest, com.anythink.core.common.r.c cVar) {
            this.a = hVar;
            this.b = i;
            this.c = aTAdRequest;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final com.anythink.core.common.r.b bVar = new com.anythink.core.common.r.b(this.a, this.b, this.c);
            if (this.b == 10) {
                bVar.b();
                bVar.a(w.this.f.c());
            }
            bVar.a(new com.anythink.core.common.r.d() { // from class: com.anythink.core.common.w.6.1
                @Override // com.anythink.core.common.r.d
                public final void a(final String str, final com.anythink.core.common.r.h hVar) {
                    w.this.i.remove(hVar.b);
                    synchronized (w.this) {
                        w.this.a(new Runnable() { // from class: com.anythink.core.common.w.6.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                w.this.a(str, hVar, bVar);
                            }
                        }, 0L);
                    }
                }

                @Override // com.anythink.core.common.r.d
                public final void a(final String str, final com.anythink.core.common.r.h hVar, final AdError adError) {
                    w.this.i.remove(hVar.b);
                    synchronized (w.this) {
                        w.this.a(new Runnable() { // from class: com.anythink.core.common.w.6.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                w.this.a(str, hVar, adError, bVar);
                            }
                        }, 0L);
                    }
                }

                @Override // com.anythink.core.common.r.d
                public final void b(final String str, final com.anythink.core.common.r.h hVar) {
                    w.this.i.remove(hVar.b);
                    synchronized (w.this) {
                        w.this.a(new Runnable() { // from class: com.anythink.core.common.w.6.1.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                w.this.b(str, hVar, bVar);
                            }
                        }, 0L);
                    }
                }
            });
            this.d.a(bVar);
            this.d.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, ATAdRequest aTAdRequest) {
        com.anythink.core.common.r.g gVar = this.f;
        if (!(gVar != null && gVar.a(11))) {
            Object[] objArr = new Object[1];
            return;
        }
        if (a(str)) {
            com.anythink.core.common.r.h hVar = this.h.get(str);
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
            int i2 = hVar.c;
            a aVar = new a(str, aTAdRequest);
            this.m.put(str, aVar);
            a(aVar, i);
        }
    }

    private void b(String str) {
        Map<String, a> map;
        a aVarRemove;
        if (TextUtils.isEmpty(str) || (map = this.m) == null || (aVarRemove = map.remove(str)) == null) {
            return;
        }
        b(aVarRemove);
    }

    public final boolean a(String str) {
        try {
            Object[] objArr = new Object[2];
            if (!this.c.get() || com.anythink.core.common.d.t.b().z() || TextUtils.isEmpty(str)) {
                return false;
            }
            return this.h.containsKey(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, com.anythink.core.common.r.h hVar, com.anythink.core.common.r.b bVar) {
        boolean z;
        List<ATAdInfo> listA;
        hVar.toString();
        this.d.a(hVar);
        com.anythink.core.common.r.c cVarRemove = this.l.remove(str);
        if (cVarRemove != null && bVar != null) {
            hVar.toString();
            String str2 = hVar.b;
            f fVarA = a(str2) ? a(str2, String.valueOf(hVar.a)) : null;
            boolean z2 = false;
            if (fVarA == null) {
                hVar.toString();
            } else {
                int i = hVar.d;
                double d = hVar.e;
                if (i <= 0 || (listA = fVarA.a(this.b, (ae) null)) == null || listA.size() >= i) {
                    z = false;
                } else {
                    listA.size();
                    hVar.toString();
                    z = true;
                }
                if (z) {
                    z2 = true;
                } else {
                    if (d > 0.0d) {
                        HashMap map = new HashMap();
                        ae aeVar = new ae();
                        aeVar.a(map);
                        com.anythink.core.common.h.c cVarA = fVarA.a(this.b, false, false, aeVar);
                        if (cVarA != null && cVarA.n() < d) {
                            cVarA.n();
                            hVar.toString();
                            z2 = true;
                        }
                    }
                    z2 = z;
                }
            }
            if (z2) {
                c(cVarRemove.e(), bVar.a());
            }
            a(cVarRemove, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, com.anythink.core.common.r.h hVar, AdError adError, final com.anythink.core.common.r.b bVar) {
        hVar.toString();
        adError.getFullErrorInfo();
        this.d.a(hVar, c(), new com.anythink.core.common.r.a() { // from class: com.anythink.core.common.w.7
            @Override // com.anythink.core.common.r.a
            public final void a(int i, com.anythink.core.common.r.h hVar2) {
                com.anythink.core.common.r.b bVar2 = bVar;
                w.this.a(hVar2, i, bVar2 != null ? bVar2.a() : null);
            }
        });
        com.anythink.core.common.r.c cVarRemove = this.l.remove(str);
        if (cVarRemove != null && bVar != null) {
            c(cVarRemove.e(), bVar.a());
            a(cVarRemove, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, com.anythink.core.common.r.h hVar, com.anythink.core.common.r.b bVar) {
        hVar.toString();
        com.anythink.core.common.r.c cVar = this.l.get(str);
        if (cVar == null) {
            return;
        }
        a(cVar, bVar);
    }

    private void a(com.anythink.core.common.r.c cVar, com.anythink.core.common.r.b bVar) {
        this.k.add(cVar.e());
        if (cVar.d() == 10 && cVar.b()) {
            this.n--;
            if (this.n >= this.f.b()) {
                return;
            }
            if (!this.p.isEmpty()) {
                com.anythink.core.common.r.h hVarRemove = this.p.remove(0);
                hVarRemove.toString();
                ATAdRequest aTAdRequestA = bVar != null ? bVar.a() : null;
                if (aTAdRequestA == null) {
                    aTAdRequestA = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
                }
                a(hVarRemove, 10, aTAdRequestA);
                return;
            }
            if (this.n == 0) {
                this.u = 3;
            }
        }
    }

    private f d(String str, String str2) {
        if (a(str)) {
            return a(str, str2);
        }
        return null;
    }

    public static f a(String str, String str2) {
        return u.a().a(str, str2);
    }

    public final boolean b() {
        return this.c.get();
    }

    public final void a(com.anythink.core.d.l lVar, final int i, final ar arVar, com.anythink.core.common.h.n nVar) {
        String strU;
        if (lVar != null) {
            try {
                strU = lVar.u();
            } catch (Throwable th) {
                Object[] objArr = new Object[1];
                th.getMessage();
                return;
            }
        } else {
            strU = "";
        }
        String strI = lVar != null ? lVar.i() : "";
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        Object[] objArr2 = new Object[3];
        Integer.valueOf(i);
        if (bVarB != null && !TextUtils.isEmpty(strU) && !strU.equals(strI)) {
            com.anythink.core.common.r.g gVarH = bVarB.h();
            if (b(gVarH)) {
                if (!gVarH.a(i)) {
                    Object[] objArr3 = new Object[3];
                    Integer.valueOf(i);
                    return;
                }
                final com.anythink.core.common.r.h hVar = this.h.get(strU);
                if (hVar == null) {
                    return;
                }
                if (Boolean.TRUE.equals(this.i.get(strU))) {
                    Object[] objArr4 = new Object[1];
                    return;
                }
                hVar.h = lVar;
                hVar.g = nVar;
                hVar.f = arVar;
                this.d.a(hVar);
                a(new Runnable() { // from class: com.anythink.core.common.w.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        ar arVar2 = arVar;
                        w.this.a(hVar, i, arVar2 != null ? arVar2.b() : null);
                    }
                }, i == 15 ? gVarH.f() : 0L);
                return;
            }
            return;
        }
        Object[] objArr5 = new Object[1];
    }

    private static Context g() {
        return com.anythink.core.common.d.t.b().g();
    }

    static /* synthetic */ void a(w wVar, com.anythink.core.common.r.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
        }
        wVar.a(hVar, 12, aTAdRequest);
    }

    static /* synthetic */ void b(w wVar, com.anythink.core.common.r.h hVar, ATAdRequest aTAdRequest) {
        if (aTAdRequest == null) {
            aTAdRequest = new ATAdRequest.Builder().setChannelSource(com.anythink.core.common.d.t.b().E()).build();
        }
        wVar.a(hVar, 6, aTAdRequest);
    }
}
