package com.anythink.basead.exoplayer.h;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i extends com.anythink.basead.exoplayer.h.f<e> implements com.anythink.basead.exoplayer.x.b {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private final List<e> h;
    private final List<e> i;
    private final e j;
    private final Map<r, e> k;
    private final List<d> l;
    private final boolean m;
    private final com.anythink.basead.exoplayer.ae.b n;
    private com.anythink.basead.exoplayer.h o;
    private boolean p;
    private aa q;
    private int r;
    private int s;

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ int a(e eVar, int i) {
        return i + eVar.e;
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* synthetic */ s.a a(e eVar, s.a aVar) {
        e eVar2 = eVar;
        for (int i = 0; i < eVar2.i.size(); i++) {
            if (eVar2.i.get(i).b.d == aVar.d) {
                return aVar.a(aVar.a + eVar2.f);
            }
        }
        return null;
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* synthetic */ void a(e eVar, s sVar, com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        e eVar2 = eVar;
        if (eVar2 == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar2.c;
        if (bVar.d() != aeVar) {
            int iB = aeVar.b() - bVar.b();
            int iC = aeVar.c() - bVar.c();
            if (iB != 0 || iC != 0) {
                a(eVar2.d + 1, 0, iB, iC);
            }
            eVar2.c = bVar.a(aeVar);
            if (!eVar2.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                long j = this.n.j + this.n.h;
                for (int i = 0; i < eVar2.i.size(); i++) {
                    l lVar = eVar2.i.get(i);
                    lVar.d(j);
                    lVar.f();
                }
                eVar2.g = true;
            }
            a((d) null);
        }
    }

    public i() {
        this(false, (aa) new aa.a());
    }

    private i(boolean z) {
        this(z, new aa.a());
    }

    private i(boolean z, aa aaVar) {
        this(z, aaVar, new s[0]);
    }

    private i(s... sVarArr) {
        this(sVarArr, (byte) 0);
    }

    private i(s[] sVarArr, byte b2) {
        this(false, new aa.a(), sVarArr);
    }

    private i(boolean z, aa aaVar, s... sVarArr) {
        for (s sVar : sVarArr) {
            com.anythink.basead.exoplayer.k.a.a(sVar);
        }
        this.q = aaVar.a() > 0 ? aaVar.d() : aaVar;
        this.k = new IdentityHashMap();
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.j = new e(null);
        this.m = z;
        this.n = new com.anythink.basead.exoplayer.ae.b();
        a(arrayList.size(), Arrays.asList(sVarArr), (Runnable) null);
    }

    private void a(s sVar) {
        a(this.h.size(), sVar, (Runnable) null);
    }

    private void a(s sVar, Runnable runnable) {
        a(this.h.size(), sVar, runnable);
    }

    private void a(int i, s sVar) {
        a(i, sVar, (Runnable) null);
    }

    private void a(int i, s sVar, Runnable runnable) {
        com.anythink.basead.exoplayer.k.a.a(sVar);
        e eVar = new e(sVar);
        this.h.add(i, eVar);
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(0).a(new f(i, eVar, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(Collection<s> collection) {
        a(this.h.size(), collection, (Runnable) null);
    }

    private void a(Collection<s> collection, Runnable runnable) {
        a(this.h.size(), collection, runnable);
    }

    private void a(int i, Collection<s> collection) {
        a(i, collection, (Runnable) null);
    }

    private void a(int i, Collection<s> collection, Runnable runnable) {
        Iterator<s> it = collection.iterator();
        while (it.hasNext()) {
            com.anythink.basead.exoplayer.k.a.a(it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<s> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new e(it2.next()));
        }
        this.h.addAll(i, arrayList);
        if (this.o != null && !collection.isEmpty()) {
            this.o.a((com.anythink.basead.exoplayer.x.b) this).a(1).a(new f(i, arrayList, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, Runnable runnable) {
        this.h.remove(i);
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(2).a(new f(i, null, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, int i2, Runnable runnable) {
        if (i == i2) {
            return;
        }
        List<e> list = this.h;
        list.add(i2, list.remove(i));
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(3).a(new f(i, Integer.valueOf(i2), runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(Runnable runnable) {
        this.h.clear();
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(4).a(runnable != null ? new d(runnable) : null).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private int d() {
        return this.h.size();
    }

    private s b(int i) {
        return this.h.get(i).a;
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        this.o = hVar;
        if (this.h.isEmpty()) {
            e();
            return;
        }
        this.q = this.q.a(0, this.h.size());
        b(0, this.h);
        a((d) null);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        int i;
        int i2 = aVar.a;
        this.j.f = i2;
        int iBinarySearch = Collections.binarySearch(this.i, this.j);
        if (iBinarySearch < 0) {
            i = (-iBinarySearch) - 2;
        } else {
            while (iBinarySearch < this.i.size() - 1) {
                int i3 = iBinarySearch + 1;
                if (this.i.get(i3).f != i2) {
                    break;
                }
                iBinarySearch = i3;
            }
            i = iBinarySearch;
        }
        e eVar = this.i.get(i);
        l lVar = new l(eVar.a, aVar.a(aVar.a - eVar.f), bVar);
        this.k.put(lVar, eVar);
        eVar.i.add(lVar);
        if (eVar.g) {
            lVar.f();
        }
        return lVar;
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        e eVarRemove = this.k.remove(rVar);
        ((l) rVar).g();
        eVarRemove.i.remove(rVar);
        if (eVarRemove.i.isEmpty() && eVarRemove.h) {
            a(eVarRemove);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a() {
        super.a();
        this.i.clear();
        this.o = null;
        this.q = this.q.d();
        this.r = 0;
        this.s = 0;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static s.a a2(e eVar, s.a aVar) {
        for (int i = 0; i < eVar.i.size(); i++) {
            if (eVar.i.get(i).b.d == aVar.d) {
                return aVar.a(aVar.a + eVar.f);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(e eVar, int i) {
        return i + eVar.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.basead.exoplayer.x.b
    public final void a(int i, Object obj) {
        switch (i) {
            case 0:
                f fVar = (f) obj;
                this.q = this.q.a(fVar.a, 1);
                a(fVar.a, (e) fVar.b);
                a(fVar.c);
                return;
            case 1:
                f fVar2 = (f) obj;
                this.q = this.q.a(fVar2.a, ((Collection) fVar2.b).size());
                b(fVar2.a, (Collection<e>) fVar2.b);
                a(fVar2.c);
                return;
            case 2:
                f fVar3 = (f) obj;
                this.q = this.q.c(fVar3.a);
                c(fVar3.a);
                a(fVar3.c);
                return;
            case 3:
                f fVar4 = (f) obj;
                aa aaVarC = this.q.c(fVar4.a);
                this.q = aaVarC;
                this.q = aaVarC.a(((Integer) fVar4.b).intValue(), 1);
                int i2 = fVar4.a;
                int iIntValue = ((Integer) fVar4.b).intValue();
                int iMin = Math.min(i2, iIntValue);
                int iMax = Math.max(i2, iIntValue);
                int iB = this.i.get(iMin).e;
                int iC = this.i.get(iMin).f;
                List<e> list = this.i;
                list.add(iIntValue, list.remove(i2));
                while (iMin <= iMax) {
                    e eVar = this.i.get(iMin);
                    eVar.e = iB;
                    eVar.f = iC;
                    iB += eVar.c.b();
                    iC += eVar.c.c();
                    iMin++;
                }
                a(fVar4.c);
                return;
            case 4:
                for (int size = this.i.size() - 1; size >= 0; size--) {
                    c(size);
                }
                a((d) obj);
                return;
            case 5:
                e();
                return;
            case 6:
                List list2 = (List) obj;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    d dVar = (d) list2.get(i3);
                    dVar.a.post(dVar.b);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    private void a(d dVar) {
        if (!this.p) {
            this.o.a((com.anythink.basead.exoplayer.x.b) this).a(5).i();
            this.p = true;
        }
        if (dVar != null) {
            this.l.add(dVar);
        }
    }

    private void e() {
        List arrayList;
        this.p = false;
        if (this.l.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(this.l);
        }
        this.l.clear();
        a(new a(this.i, this.r, this.s, this.q, this.m), (Object) null);
        if (arrayList.isEmpty()) {
            return;
        }
        this.o.a((com.anythink.basead.exoplayer.x.b) this).a(6).a(arrayList).i();
    }

    private void a(int i, e eVar) {
        if (i > 0) {
            e eVar2 = this.i.get(i - 1);
            eVar.a(i, eVar2.e + eVar2.c.b(), eVar2.f + eVar2.c.c());
        } else {
            eVar.a(i, 0, 0);
        }
        a(i, 1, eVar.c.b(), eVar.c.c());
        this.i.add(i, eVar);
        a(eVar, eVar.a);
    }

    private void b(int i, Collection<e> collection) {
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            a(i, it.next());
            i++;
        }
    }

    private void b(e eVar, com.anythink.basead.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar.c;
        if (bVar.d() == aeVar) {
            return;
        }
        int iB = aeVar.b() - bVar.b();
        int iC = aeVar.c() - bVar.c();
        if (iB != 0 || iC != 0) {
            a(eVar.d + 1, 0, iB, iC);
        }
        eVar.c = bVar.a(aeVar);
        if (!eVar.g && !aeVar.a()) {
            aeVar.a(0, this.n, false);
            long j = this.n.j + this.n.h;
            for (int i = 0; i < eVar.i.size(); i++) {
                l lVar = eVar.i.get(i);
                lVar.d(j);
                lVar.f();
            }
            eVar.g = true;
        }
        a((d) null);
    }

    private void f() {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            c(size);
        }
    }

    private void c(int i) {
        e eVarRemove = this.i.remove(i);
        b bVar = eVarRemove.c;
        a(i, -1, -bVar.b(), -bVar.c());
        eVarRemove.h = true;
        if (eVarRemove.i.isEmpty()) {
            a(eVarRemove);
        }
    }

    private void b(int i, int i2) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        int iB = this.i.get(iMin).e;
        int iC = this.i.get(iMin).f;
        List<e> list = this.i;
        list.add(i2, list.remove(i));
        while (iMin <= iMax) {
            e eVar = this.i.get(iMin);
            eVar.e = iB;
            eVar.f = iC;
            iB += eVar.c.b();
            iC += eVar.c.c();
            iMin++;
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.r += i3;
        this.s += i4;
        while (i < this.i.size()) {
            this.i.get(i).d += i2;
            this.i.get(i).e += i3;
            this.i.get(i).f += i4;
            i++;
        }
    }

    private int d(int i) {
        this.j.f = i;
        int iBinarySearch = Collections.binarySearch(this.i, this.j);
        if (iBinarySearch < 0) {
            return (-iBinarySearch) - 2;
        }
        while (iBinarySearch < this.i.size() - 1) {
            int i2 = iBinarySearch + 1;
            if (this.i.get(i2).f != i) {
                break;
            }
            iBinarySearch = i2;
        }
        return iBinarySearch;
    }

    static final class e implements Comparable<e> {
        public final s a;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public b c = new b();
        public List<l> i = new ArrayList();
        public final Object b = new Object();

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(e eVar) {
            return this.f - eVar.f;
        }

        public e(s sVar) {
            this.a = sVar;
        }

        public final void a(int i, int i2, int i3) {
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = false;
            this.h = false;
            this.i.clear();
        }

        private int a(e eVar) {
            return this.f - eVar.f;
        }
    }

    private static final class d {
        public final Handler a;
        public final Runnable b;

        public d(Runnable runnable) {
            this.b = runnable;
            this.a = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        }

        private void a() {
            this.a.post(this.b);
        }
    }

    private static final class f<T> {
        public final int a;
        public final T b;
        public final d c;

        public f(int i, T t, Runnable runnable) {
            this.a = i;
            this.c = runnable != null ? new d(runnable) : null;
            this.b = t;
        }
    }

    private static final class a extends com.anythink.basead.exoplayer.h.a {
        private final int b;
        private final int c;
        private final int[] d;
        private final int[] e;
        private final com.anythink.basead.exoplayer.ae[] f;
        private final Object[] g;
        private final HashMap<Object, Integer> h;

        public a(Collection<e> collection, int i, int i2, aa aaVar, boolean z) {
            super(z, aaVar);
            this.b = i;
            this.c = i2;
            int size = collection.size();
            this.d = new int[size];
            this.e = new int[size];
            this.f = new com.anythink.basead.exoplayer.ae[size];
            this.g = new Object[size];
            this.h = new HashMap<>();
            int i3 = 0;
            for (e eVar : collection) {
                this.f[i3] = eVar.c;
                this.d[i3] = eVar.f;
                this.e[i3] = eVar.e;
                this.g[i3] = eVar.b;
                this.h.put(this.g[i3], Integer.valueOf(i3));
                i3++;
            }
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int a(int i) {
            return com.anythink.basead.exoplayer.k.af.a(this.d, i + 1);
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int b(int i) {
            return com.anythink.basead.exoplayer.k.af.a(this.e, i + 1);
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int b(Object obj) {
            Integer num = this.h.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final com.anythink.basead.exoplayer.ae c(int i) {
            return this.f[i];
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int d(int i) {
            return this.d[i];
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int e(int i) {
            return this.e[i];
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final Object f(int i) {
            return this.g[i];
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int b() {
            return this.b;
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int c() {
            return this.c;
        }
    }

    private static final class b extends p {
        private static final Object c = new Object();
        private static final com.anythink.basead.exoplayer.ae.a d = new com.anythink.basead.exoplayer.ae.a();
        private static final c e = new c(0);
        private final Object f;

        public b() {
            this(e, null);
        }

        private b(com.anythink.basead.exoplayer.ae aeVar, Object obj) {
            super(aeVar);
            this.f = obj;
        }

        public final b a(com.anythink.basead.exoplayer.ae aeVar) {
            Object obj;
            if (this.f == null && aeVar.c() > 0) {
                obj = aeVar.a(0, d, true).b;
            } else {
                obj = this.f;
            }
            return new b(aeVar, obj);
        }

        public final com.anythink.basead.exoplayer.ae d() {
            return this.b;
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final com.anythink.basead.exoplayer.ae.a a(int i, com.anythink.basead.exoplayer.ae.a aVar, boolean z) {
            this.b.a(i, aVar, z);
            if (com.anythink.basead.exoplayer.k.af.a(aVar.b, this.f)) {
                aVar.b = c;
            }
            return aVar;
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final int a(Object obj) {
            com.anythink.basead.exoplayer.ae aeVar = this.b;
            if (c.equals(obj)) {
                obj = this.f;
            }
            return aeVar.a(obj);
        }
    }

    private static final class c extends com.anythink.basead.exoplayer.ae {
        @Override // com.anythink.basead.exoplayer.ae
        public final int a(Object obj) {
            return obj == null ? 0 : -1;
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int b() {
            return 1;
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int c() {
            return 1;
        }

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final com.anythink.basead.exoplayer.ae.b a(int i, com.anythink.basead.exoplayer.ae.b bVar, boolean z, long j) {
            return bVar.a(null, -9223372036854775807L, -9223372036854775807L, false, true, j > 0 ? -9223372036854775807L : 0L, -9223372036854775807L, 0L);
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final com.anythink.basead.exoplayer.ae.a a(int i, com.anythink.basead.exoplayer.ae.a aVar, boolean z) {
            return aVar.a(null, null, -9223372036854775807L, 0L);
        }
    }

    private void a(int i) {
        this.h.remove(i);
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(2).a(new f(i, null, null)).i();
        }
    }

    private void a(int i, int i2) {
        if (i != i2) {
            List<e> list = this.h;
            list.add(i2, list.remove(i));
            com.anythink.basead.exoplayer.h hVar = this.o;
            if (hVar != null) {
                hVar.a((com.anythink.basead.exoplayer.x.b) this).a(3).a(new f(i, Integer.valueOf(i2), null)).i();
            }
        }
    }

    private void c() {
        this.h.clear();
        com.anythink.basead.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((com.anythink.basead.exoplayer.x.b) this).a(4).a((Object) null).i();
        }
    }

    private void a(e eVar, com.anythink.basead.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar.c;
        if (bVar.d() != aeVar) {
            int iB = aeVar.b() - bVar.b();
            int iC = aeVar.c() - bVar.c();
            if (iB != 0 || iC != 0) {
                a(eVar.d + 1, 0, iB, iC);
            }
            eVar.c = bVar.a(aeVar);
            if (!eVar.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                long j = this.n.j + this.n.h;
                for (int i = 0; i < eVar.i.size(); i++) {
                    l lVar = eVar.i.get(i);
                    lVar.d(j);
                    lVar.f();
                }
                eVar.g = true;
            }
            a((d) null);
        }
    }
}
