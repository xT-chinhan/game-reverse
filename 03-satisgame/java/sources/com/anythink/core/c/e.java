package com.anythink.core.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.z;
import com.anythink.core.common.l.s;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends d {
    public static final double k = 10000.0d;
    ConcurrentHashMap<String, by> A;
    ConcurrentHashMap<String, by> B;
    Queue<by> C;
    com.anythink.core.common.u.b.d D;
    final String l;
    protected final List<com.anythink.core.c.c.a> m;
    List<by> n;
    List<by> o;
    String p;
    String q;
    String r;
    com.anythink.core.c.b.b s;
    long t;
    long u;
    com.anythink.core.common.b.c v;
    protected AtomicBoolean w;
    protected AtomicBoolean x;
    ConcurrentHashMap<String, by> y;
    ConcurrentHashMap<String, by> z;

    protected abstract void a(List<JSONObject> list, s sVar);

    protected abstract String b();

    static class b {
        long a;
        long b;
        long c = 0;

        public b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        private long a() {
            return this.a;
        }

        private long b() {
            return this.b;
        }

        private long c() {
            return this.c;
        }

        private void a(long j) {
            this.c = j;
        }
    }

    public e(com.anythink.core.common.h.a aVar) {
        super(aVar);
        this.l = getClass().getSimpleName() + ":";
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.y = new ConcurrentHashMap<>();
        this.z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        this.B = new ConcurrentHashMap<>();
        this.D = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dg, new Runnable() { // from class: com.anythink.core.c.e.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.at, new Runnable() { // from class: com.anythink.core.c.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.j();
                    }
                }));
            }
        });
        this.v = this.f.I;
        if (aVar.j != null && aVar.j.size() > 0) {
            c(aVar.j);
            for (by byVar : aVar.j) {
                if (byVar != null) {
                    this.y.put(byVar.G(), byVar);
                    this.A.put(byVar.G(), byVar);
                }
            }
        }
        if (aVar.k != null && aVar.k.size() > 0) {
            for (by byVar2 : aVar.k) {
                this.z.put(byVar2.G(), byVar2);
                this.B.put(byVar2.G(), byVar2);
            }
        }
        if (aVar.r != null) {
            this.m.add(aVar.r);
        }
        this.p = aVar.d;
        this.q = aVar.e;
        this.r = b();
    }

    @Override // com.anythink.core.c.d
    public final void a(boolean z) {
        this.g = z;
    }

    @Override // com.anythink.core.c.d
    protected final void a(com.anythink.core.c.b.b bVar) {
        this.t = SystemClock.elapsedRealtime();
        this.u = System.currentTimeMillis();
        this.s = bVar;
        if (ATSDK.isNetworkLogDebug()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("PlacementId", this.f.e);
                if (this.f.s.al()) {
                    jSONObject.put("isAdxNetworkMode", true);
                }
                jSONObject.put("S2S Start HeadBidding List", a(this.f.j));
                jSONObject.put("S2S Start HeadBidding List(Directly)", b(this.m));
            } catch (Exception unused) {
            }
            aa.a(aa.a, jSONObject.toString(), false);
        }
        if (this.f.j.isEmpty() && (this.f.k == null || this.f.k.isEmpty())) {
            a(new b(this.t, this.u));
            return;
        }
        if (this.f.j.size() == 0 && this.f.k != null && this.f.k.size() > 0) {
            a(new b(this.t, this.u));
            return;
        }
        long jN = this.f.n.n();
        if (jN <= 0) {
            jN = 500;
        }
        com.anythink.core.common.s.c.a().a(this.D, jN);
        g();
    }

    private void g() {
        this.C = new LinkedList(this.f.j);
        com.anythink.core.common.b.c cVar = this.v;
        int iG = cVar != null ? cVar.g() : 0;
        if (iG == 1) {
            h();
            return;
        }
        if (iG == 2) {
            Iterator<Map.Entry<String, by>> it = this.y.entrySet().iterator();
            while (it.hasNext()) {
                b(it.next().getValue());
            }
        } else {
            final long jE = cVar != null ? cVar.e() : 0L;
            Runnable runnable = new Runnable() { // from class: com.anythink.core.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.C.isEmpty()) {
                        return;
                    }
                    e.this.b(e.this.C.poll());
                    if (e.this.C.isEmpty()) {
                        return;
                    }
                    com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aq, this), jE);
                }
            };
            if (this.C.isEmpty()) {
                return;
            }
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ar, runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.v == null || this.C.isEmpty() || this.v.g() != 1) {
            return;
        }
        b(this.C.poll());
    }

    private void c(List<by> list) {
        if (this.v == null) {
            return;
        }
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        int[] iArrD = this.v.d();
        if (iArrD != null && iArrD.length > 0) {
            for (int i = 0; i < iArrD.length; i++) {
                concurrentHashMap.put(Integer.valueOf(iArrD[i]), Integer.valueOf(i));
            }
        }
        Collections.sort(list, new Comparator<by>() { // from class: com.anythink.core.c.e.3
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(by byVar, by byVar2) {
                int iN = byVar.n();
                int iN2 = byVar2.n();
                boolean zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(iN));
                boolean zContainsKey2 = concurrentHashMap.containsKey(Integer.valueOf(iN2));
                if (zContainsKey && zContainsKey2) {
                    return ((Integer) concurrentHashMap.get(Integer.valueOf(iN))).intValue() - ((Integer) concurrentHashMap.get(Integer.valueOf(iN2))).intValue();
                }
                if (zContainsKey) {
                    return -1;
                }
                if (zContainsKey2) {
                    return 1;
                }
                return Integer.compare(iN, iN2);
            }

            private int a(by byVar, by byVar2) {
                int iN = byVar.n();
                int iN2 = byVar2.n();
                boolean zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(iN));
                boolean zContainsKey2 = concurrentHashMap.containsKey(Integer.valueOf(iN2));
                if (zContainsKey && zContainsKey2) {
                    return ((Integer) concurrentHashMap.get(Integer.valueOf(iN))).intValue() - ((Integer) concurrentHashMap.get(Integer.valueOf(iN2))).intValue();
                }
                if (zContainsKey) {
                    return -1;
                }
                if (zContainsKey2) {
                    return 1;
                }
                return Integer.compare(iN, iN2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(by byVar) {
        if (byVar == null) {
            return;
        }
        if (byVar.n() == 66) {
            com.anythink.core.common.a.d.a(this.f.b).a(byVar.G(), System.currentTimeMillis());
        }
        new a(byVar).a();
    }

    private class a implements h.a {
        by a;
        boolean b;
        com.anythink.core.c.c.a c;
        AtomicBoolean d = new AtomicBoolean(false);
        AtomicBoolean e = new AtomicBoolean(false);
        AtomicBoolean f = new AtomicBoolean(false);
        AtomicBoolean g = new AtomicBoolean(false);
        h h;
        com.anythink.core.common.u.b.d i;

        public a(by byVar) {
            this.a = byVar;
            this.b = byVar.bJ();
        }

        public final void a() {
            this.h = new h(e.this.f.e, e.this.f, e.this.t);
            if (this.b) {
                com.anythink.core.c.c.a aVarB = e.this.c() != null ? e.this.c().b(e.this.q, this.a) : null;
                this.c = aVarB;
                if (aVarB != null) {
                    long jBK = this.a.bK();
                    this.i = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dh, new Runnable() { // from class: com.anythink.core.c.e.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.f.set(true);
                            a.this.b();
                        }
                    });
                    com.anythink.core.common.s.c.a().a(this.i, jBK);
                }
            }
            this.h.a(this.a, this);
        }

        @Override // com.anythink.core.c.h.a
        public final void a(by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
            if (e.this.s != null) {
                e.this.s.a(byVar, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.c.h.a
        public final void a(com.anythink.core.c.c.a aVar) {
            if (e.this.h.get() || this.d.getAndSet(true)) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.a.o(jElapsedRealtime - e.this.t);
            this.a.a(jElapsedRealtime);
            this.a.b(System.currentTimeMillis());
            if (this.b) {
                if (this.h != null && this.g.get()) {
                    this.h.g = true;
                    this.h.h = true;
                }
                boolean z = !aVar.c();
                if (!this.f.get() && !this.g.get() && z) {
                    com.anythink.core.common.s.c.a().a(this.i);
                }
            }
            e.this.A.remove(this.a.G());
            e.a(e.this, aVar);
            e.b(e.this, aVar);
            if (this.e.compareAndSet(false, true)) {
                e.this.h();
            }
        }

        @Override // com.anythink.core.c.h.a
        public final void b(com.anythink.core.c.c.a aVar) {
            boolean z;
            if (e.this.h.get()) {
                if (e.this.i.get() || !this.b || this.c == null || !this.g.get()) {
                    return;
                }
                e.this.c(aVar.b());
                return;
            }
            if (!this.b) {
                z = false;
            } else if (this.c != null) {
                if (!this.f.get()) {
                    com.anythink.core.common.s.c.a().a(this.i);
                    b();
                }
                e.this.c(aVar.b());
                z = true;
            } else {
                if (!this.d.get()) {
                    e.this.c(aVar.b());
                }
                z = false;
            }
            if (z) {
                return;
            }
            String strE = aVar.e();
            this.a.o(SystemClock.elapsedRealtime() - e.this.t);
            if (strE == null) {
                strE = "";
            }
            e.this.A.remove(this.a.G());
            e.this.y.remove(this.a.G());
            e.c(e.this, aVar);
            strE.hashCode();
            switch (strE) {
                case "This network don't support header bidding in current TopOn's version.":
                case "Network init error.":
                case "The parameter is abnormal.":
                case "There is no Network Adapter.":
                    e.this.b(this.a, strE, 0L, -9);
                    break;
                case "Request Token or Custom bid info Timeout.":
                case "Network BidToken or Custom bid info is Empty.":
                    e.this.b(this.a, strE, 0L, -2);
                    break;
                default:
                    e.this.b(this.a, "Unknown error: ".concat(String.valueOf(strE)), 0L, -9);
                    break;
            }
            e.b(e.this, (com.anythink.core.c.c.a) null);
            if (this.e.compareAndSet(false, true)) {
                e.this.h();
            }
        }

        private void c(com.anythink.core.c.c.a aVar) {
            if (this.b) {
                if (this.h != null && this.g.get()) {
                    this.h.g = true;
                    this.h.h = true;
                }
                boolean z = !aVar.c();
                if (this.f.get() || this.g.get() || !z) {
                    return;
                }
                com.anythink.core.common.s.c.a().a(this.i);
            }
        }

        private boolean d(com.anythink.core.c.c.a aVar) {
            if (!this.b) {
                return false;
            }
            if (this.c != null) {
                if (!this.f.get()) {
                    com.anythink.core.common.s.c.a().a(this.i);
                    b();
                }
                e.this.c(aVar.b());
                return true;
            }
            if (this.d.get()) {
                return false;
            }
            e.this.c(aVar.b());
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.d.get()) {
                return;
            }
            this.g.set(true);
            f fVarC = e.this.c();
            if (fVarC != null) {
                fVarC.a(e.this.f.e, this.a, this.c);
            }
            this.c.a(this.a);
            a(this.c);
        }
    }

    private void b(long j) {
        com.anythink.core.common.s.c.a().a(this.D, j);
    }

    private void i() {
        com.anythink.core.common.s.c.a().a(this.D);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:17:0x002c, B:18:0x003a, B:21:0x0044, B:23:0x004c, B:31:0x005d, B:32:0x0069), top: B:44:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:17:0x002c, B:18:0x003a, B:21:0x0044, B:23:0x004c, B:31:0x005d, B:32:0x0069), top: B:44:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:34:0x006b A[DONT_GENERATE] */
    private void a(com.anythink.core.c.c.a aVar) {
        boolean z;
        boolean z2;
        JSONObject jSONObjectA = aVar != null ? aVar.a() : null;
        by byVarB = aVar != null ? aVar.b() : null;
        boolean z3 = true;
        if (this.A.size() == 0) {
            i();
            if (this.x.get()) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        synchronized (this) {
            if (jSONObjectA != null && byVarB != null) {
                this.m.add(aVar);
                this.B.put(byVarB.G(), byVarB);
                if (this.m.size() <= 0) {
                    z3 = false;
                } else if (!z) {
                    if (this.w.get()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = false;
                    }
                }
                if (z3) {
                    a(new b(this.t, this.u));
                    return;
                } else if (this.n.size() > 0) {
                    return;
                } else {
                    return;
                }
            }
            if (this.m.size() <= 0) {
                z3 = false;
            } else if (!z) {
                if (this.w.get() || this.x.get()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z3 = false;
                }
            }
            if (z3) {
                a(new b(this.t, this.u));
                return;
            } else {
                if (this.n.size() > 0 || !p()) {
                    return;
                }
                a(null, new b(0L, 0L), "", null, null);
                return;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        if (this.h.get()) {
            return;
        }
        this.w.set(true);
        if (this.m.size() > 0) {
            a(new b(SystemClock.elapsedRealtime(), System.currentTimeMillis()));
        }
    }

    protected synchronized void a(List<JSONObject> list, Map<String, by> map, Map<String, JSONObject> map2) {
        for (com.anythink.core.c.c.a aVar : this.m) {
            JSONObject jSONObjectA = aVar.a();
            list.add(jSONObjectA);
            map2.put(jSONObjectA.optString("ad_source_id"), jSONObjectA);
            by byVarB = aVar.b();
            if (byVarB != null && byVarB.bJ()) {
                f fVarC = c();
                if (fVarC != null) {
                    fVarC.a(this.f.e, byVarB, aVar);
                }
                if (!aVar.c()) {
                    if ((fVarC != null ? fVarC.b(this.f.e, byVarB) : null) == null) {
                        c(byVarB);
                    }
                }
            }
        }
        this.m.clear();
        ConcurrentHashMap<String, by> concurrentHashMap = this.B;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, by>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                by value = it.next().getValue();
                if (value != null) {
                    value.c(SystemClock.elapsedRealtime());
                }
            }
        }
        map.putAll(this.B);
        this.B.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final b bVar) {
        if (this.x.get()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        final ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        a(arrayList, concurrentHashMap, concurrentHashMap2);
        this.x.set(true);
        a(arrayList, new s() { // from class: com.anythink.core.c.e.4
            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        return;
                    }
                    e.this.x.set(false);
                    if (bVar != null) {
                        bVar.c = SystemClock.elapsedRealtime() - bVar.a;
                    }
                    e.this.a(e.a(e.this, obj), bVar, null, concurrentHashMap, concurrentHashMap2);
                    e.this.e();
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str, AdError adError) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        return;
                    }
                    e.this.x.set(false);
                    e.this.e();
                    if (bVar != null) {
                        bVar.c = SystemClock.elapsedRealtime() - bVar.a;
                    }
                    e.this.a(null, bVar, adError != null ? adError.getPlatformMSG() : "", concurrentHashMap, concurrentHashMap2);
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadCanceled(int i) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        return;
                    }
                    e.this.x.set(false);
                    e.this.e();
                    if (bVar != null) {
                        bVar.c = SystemClock.elapsedRealtime() - bVar.a;
                    }
                    e.this.a(null, bVar, "onLoadCanceled.", concurrentHashMap, concurrentHashMap2);
                }
            }
        });
    }

    protected final synchronized void e() {
        if (f()) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.as, new Runnable() { // from class: com.anythink.core.c.e.5
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (e.this) {
                        if (e.this.f()) {
                            e.this.a(new b(SystemClock.elapsedRealtime(), System.currentTimeMillis()));
                        }
                    }
                }
            }));
        }
    }

    protected final boolean f() {
        return !this.x.get() && this.m.size() > 0;
    }

    private boolean k() {
        return this.w.get() && !this.x.get();
    }

    private synchronized void l() {
        this.i.set(true);
        if (!this.h.get()) {
            this.h.set(true);
            i();
            this.A.clear();
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.y);
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.z);
            o();
            n();
            m();
        }
    }

    private void m() {
        com.anythink.core.c.b.b bVar;
        if ((this.o.size() > 0 || this.n.size() > 0) && (bVar = this.s) != null) {
            bVar.a(this.o, this.n);
        }
        this.o.clear();
        this.n.clear();
    }

    private void a(long j, int i, String str, Map<String, by> map) {
        for (by byVar : map.values()) {
            if (a(byVar, str, i)) {
                this.o.add(byVar);
            } else {
                b(byVar, str, j, i);
            }
        }
        map.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<ad> list, b bVar, String str, Map<String, by> map, Map<String, JSONObject> map2) {
        long j;
        aq aqVarBe;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list);
                    for (int i = 0; i < list.size(); i++) {
                        ad adVar = list.get(i);
                        this.y.remove(adVar.k);
                        by byVarRemove = map.remove(adVar.k);
                        if (this.z.containsKey(adVar.k)) {
                            byVarRemove = this.z.remove(adVar.k);
                            this.z.clear();
                        }
                        by byVar = byVarRemove;
                        if (byVar != null) {
                            if (adVar.isSuccessWithUseType()) {
                                int i2 = i + 1;
                                a(byVar.n(), adVar, i2 < list.size() ? list.get(i2).getSortPrice() : 0.0d, adVar.isSamePrice());
                                if (byVar != null && adVar != null && (aqVarBe = byVar.be()) != null) {
                                    aqVarBe.b(adVar.l());
                                    aqVarBe.d(adVar.m());
                                    aqVarBe.a(adVar.n());
                                }
                                JSONObject jSONObject = map2.get(byVar.G());
                                if (jSONObject != null) {
                                    String strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID);
                                    }
                                    adVar.c(strOptString);
                                }
                            }
                            if (bVar != null) {
                                j = bVar.c;
                                byVar.u(bVar.b);
                            } else {
                                j = 0;
                            }
                            a(byVar, adVar, j);
                            if (byVar.n() == 66) {
                                com.anythink.core.common.a.d.a(this.f.b).a(byVar.G(), adVar.w);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2 != null) {
                    this.y.remove(str2);
                }
                if (this.z.containsKey(str2)) {
                    this.z.clear();
                }
            }
        }
        if (map != null) {
            a(bVar != null ? bVar.c : 0L, -4, TextUtils.isEmpty(str) ? "No Response error." : "No Response error." + str, map);
        }
        if (this.o.size() >= 2) {
            Collections.sort(this.o);
        }
        o();
        n();
        m();
    }

    private static void a(Map<String, JSONObject> map, by byVar, ad adVar) {
        JSONObject jSONObject = map.get(byVar.G());
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID);
            }
            adVar.c(strOptString);
        }
    }

    private synchronized void n() {
        if (p()) {
            this.h.set(true);
        }
    }

    private void o() {
        if (ATSDK.isNetworkLogDebug()) {
            if (this.o.size() > 0 || this.n.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("PlacementId", this.f.e);
                    if (this.f.s.al()) {
                        jSONObject.put("isAdxNetworkMode", true);
                    }
                    jSONObject.put("S2S HeadBidding Success List", a(this.o));
                    jSONObject.put("S2S HeadBidding Fail List", a(this.n));
                } catch (Exception unused) {
                }
                aa.a(aa.a, jSONObject.toString(), false);
            }
        }
    }

    private boolean p() {
        return this.y.size() == 0 && this.z.size() == 0 && this.A.size() == 0;
    }

    private List<ad> a(Object obj) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (!(obj instanceof JSONObject) || (jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray(com.anythink.core.common.l.f.R)) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            ad adVarA = ad.a(jSONArrayOptJSONArray.optJSONObject(i));
            if (adVarA != null) {
                adVarA.commonAdManager = this.f != null ? this.f.J : null;
                arrayList.add(adVarA);
            }
        }
        return arrayList;
    }

    private void b(com.anythink.core.c.c.a aVar) {
        by byVarB = aVar.b();
        int iN = byVarB.n();
        f fVarC = c();
        com.anythink.core.common.t.f.a(byVarB, this.f, byVarB.ae(), true, fVarC == null || fVarC.b(iN), aVar.c());
        if (fVarC != null) {
            fVarC.a(iN);
        }
    }

    private void c(com.anythink.core.c.c.a aVar) {
        by byVarB = aVar.b();
        if (aVar.f()) {
            return;
        }
        int iN = byVarB.n();
        f fVarC = c();
        com.anythink.core.common.t.f.a(byVarB, this.f, byVarB.ae(), false, fVarC == null || fVarC.b(iN), aVar.c());
        if (fVarC != null) {
            fVarC.a(iN);
        }
    }

    @Override // com.anythink.core.c.d
    protected void a(by byVar, z zVar, long j) {
        String str;
        int i;
        if (zVar instanceof ad) {
            ad adVar = (ad) zVar;
            boolean zIsSuccessWithUseType = adVar.isSuccessWithUseType();
            boolean zA = a(zIsSuccessWithUseType, byVar, zVar);
            int i2 = 0;
            AdError adErrorA = zIsSuccessWithUseType ? ac.a(0, this.f.s, byVar, zVar) : null;
            boolean z = adErrorA != null;
            if (zIsSuccessWithUseType && !zA && !z) {
                byVar.e(j > 0 ? byVar.ae() + j : 0L);
                this.o.add(byVar);
                if (byVar.y() == 3 || byVar.y() == 7) {
                    adVar.f = adVar.e + System.currentTimeMillis();
                } else {
                    adVar.f = byVar.A() + System.currentTimeMillis();
                }
                a(byVar, adVar);
                return;
            }
            if (zA) {
                b(byVar, ATBidRequestInfo.LESS_THAN_BID_FLOOR_TYPE, j, -11);
                byVar.b(zVar.getPrice());
                byVar.e(zVar.getSortPrice());
                byVar.a(adVar);
                return;
            }
            if (z) {
                b(byVar, adErrorA.getPlatformMSG(), j, -13);
                byVar.b(zVar.getPrice());
                byVar.e(zVar.getSortPrice());
                byVar.a(adVar);
                return;
            }
            if (adVar.useType == 2) {
                byVar.ac();
                str = "filter by s2s bid max count";
                i = 0;
                i2 = 1;
            } else {
                str = "errorCode:[" + adVar.a + "],errorMsg:[" + adVar.errorMsg + "]";
                i = -1;
            }
            if (a(byVar, str, i, i2)) {
                this.o.add(byVar);
            } else {
                b(byVar, str, j, i);
            }
        }
    }

    @Override // com.anythink.core.c.d
    protected final void a() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(by byVar, String str, long j, int i) {
        long jAe = 0;
        if (j > 0) {
            try {
                jAe = byVar.ae() + j;
            } catch (Throwable th) {
                throw th;
            }
        }
        a(byVar, str, jAe, i);
        this.n.add(byVar);
    }

    private static void b(by byVar, ad adVar) {
        aq aqVarBe;
        if (byVar == null || adVar == null || (aqVarBe = byVar.be()) == null) {
            return;
        }
        aqVarBe.b(adVar.l());
        aqVarBe.d(adVar.m());
        aqVarBe.a(adVar.n());
    }

    private void d(com.anythink.core.c.c.a aVar) {
        by byVarB = aVar.b();
        if (byVarB == null || !byVarB.bJ()) {
            return;
        }
        f fVarC = c();
        if (fVarC != null) {
            fVarC.a(this.f.e, byVarB, aVar);
        }
        if (aVar.c()) {
            return;
        }
        if ((fVarC != null ? fVarC.b(this.f.e, byVarB) : null) == null) {
            c(byVarB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(by byVar) {
        h hVar = new h(this.f.e, this.f, SystemClock.elapsedRealtime());
        hVar.g = true;
        hVar.h = true;
        hVar.a(byVar, (h.a) null);
    }

    static /* synthetic */ void a(e eVar, com.anythink.core.c.c.a aVar) {
        by byVarB = aVar.b();
        int iN = byVarB.n();
        f fVarC = eVar.c();
        com.anythink.core.common.t.f.a(byVarB, eVar.f, byVarB.ae(), true, fVarC == null || fVarC.b(iN), aVar.c());
        if (fVarC != null) {
            fVarC.a(iN);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:17:0x002c, B:18:0x003a, B:21:0x0044, B:23:0x004c, B:31:0x005d, B:32:0x0069), top: B:44:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:17:0x002c, B:18:0x003a, B:21:0x0044, B:23:0x004c, B:31:0x005d, B:32:0x0069), top: B:44:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:34:0x006b A[DONT_GENERATE] */
    static /* synthetic */ void b(e eVar, com.anythink.core.c.c.a aVar) {
        boolean z;
        boolean z2;
        JSONObject jSONObjectA = aVar != null ? aVar.a() : null;
        by byVarB = aVar != null ? aVar.b() : null;
        boolean z3 = true;
        if (eVar.A.size() == 0) {
            eVar.i();
            if (eVar.x.get()) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        synchronized (eVar) {
            if (jSONObjectA != null && byVarB != null) {
                eVar.m.add(aVar);
                eVar.B.put(byVarB.G(), byVarB);
                if (eVar.m.size() <= 0) {
                    z3 = false;
                } else if (!z) {
                    if (eVar.w.get()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = false;
                    }
                }
                if (z3) {
                    eVar.a(new b(eVar.t, eVar.u));
                    return;
                } else if (eVar.n.size() > 0) {
                    return;
                } else {
                    return;
                }
            }
            if (eVar.m.size() <= 0) {
                z3 = false;
            } else if (!z) {
                if (eVar.w.get() || eVar.x.get()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z3 = false;
                }
            }
            if (z3) {
                eVar.a(new b(eVar.t, eVar.u));
                return;
            } else {
                if (eVar.n.size() > 0 || !eVar.p()) {
                    return;
                }
                eVar.a(null, new b(0L, 0L), "", null, null);
                return;
            }
            throw th;
        }
    }

    static /* synthetic */ void c(e eVar, com.anythink.core.c.c.a aVar) {
        by byVarB = aVar.b();
        if (aVar.f()) {
            return;
        }
        int iN = byVarB.n();
        f fVarC = eVar.c();
        com.anythink.core.common.t.f.a(byVarB, eVar.f, byVarB.ae(), false, fVarC == null || fVarC.b(iN), aVar.c());
        if (fVarC != null) {
            fVarC.a(iN);
        }
    }

    static /* synthetic */ List a(e eVar, Object obj) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if ((obj instanceof JSONObject) && (jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray(com.anythink.core.common.l.f.R)) != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ad adVarA = ad.a(jSONArrayOptJSONArray.optJSONObject(i));
                if (adVarA != null) {
                    adVarA.commonAdManager = eVar.f != null ? eVar.f.J : null;
                    arrayList.add(adVarA);
                }
            }
        }
        return arrayList;
    }
}
