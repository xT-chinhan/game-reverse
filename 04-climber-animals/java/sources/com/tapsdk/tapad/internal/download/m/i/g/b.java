package com.tapsdk.tapad.internal.download.m.i.g;

import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.f;
import com.tapsdk.tapad.internal.download.m.i.g.b.c;

/* JADX INFO: loaded from: classes3.dex */
public class b<T extends c> implements d {
    InterfaceC0613b a;
    private a b;
    private final e<T> c;

    public interface a {
        boolean a(f fVar, int i, long j, c cVar);

        boolean a(f fVar, int i, c cVar);

        boolean a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, c cVar2);

        boolean a(f fVar, EndCause endCause, Exception exc, c cVar);
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.i.g.b$b, reason: collision with other inner class name */
    public interface InterfaceC0613b {
        void a(f fVar, int i, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar);

        void a(f fVar, long j);

        void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, c cVar2);

        void a(f fVar, EndCause endCause, Exception exc, c cVar);

        void d(f fVar, int i, long j);
    }

    public static class c implements e.a {
        private final int a;
        com.tapsdk.tapad.internal.download.core.breakpoint.c b;
        long c;
        SparseArray<Long> d;

        public c(int i) {
            this.a = i;
        }

        public long a(int i) {
            return this.d.get(i).longValue();
        }

        public SparseArray<Long> a() {
            return this.d.clone();
        }

        public void a(long j) {
            this.c = j;
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.a
        public void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            this.b = cVar;
            this.c = cVar.i();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int iB = cVar.b();
            for (int i = 0; i < iB; i++) {
                sparseArray.put(i, Long.valueOf(cVar.b(i).c()));
            }
            this.d = sparseArray;
        }

        SparseArray<Long> b() {
            return this.d;
        }

        public long c() {
            return this.c;
        }

        public com.tapsdk.tapad.internal.download.core.breakpoint.c d() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.a
        public int f() {
            return this.a;
        }
    }

    public b(e.b<T> bVar) {
        this.c = new e<>(bVar);
    }

    b(e<T> eVar) {
        this.c = eVar;
    }

    public long a(f fVar) {
        c cVar = (c) this.c.b(fVar, fVar.l());
        if (cVar != null) {
            return cVar.c();
        }
        return 0L;
    }

    public void a(f fVar, int i) {
        InterfaceC0613b interfaceC0613b;
        c cVar = (c) this.c.b(fVar, fVar.l());
        if (cVar == null) {
            return;
        }
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, cVar)) && (interfaceC0613b = this.a) != null) {
            interfaceC0613b.a(fVar, i, cVar.b.b(i));
        }
    }

    public void a(f fVar, int i, long j) {
        InterfaceC0613b interfaceC0613b;
        c cVar = (c) this.c.b(fVar, fVar.l());
        if (cVar == null || cVar.d.get(i) == null) {
            return;
        }
        long jLongValue = cVar.d.get(i).longValue() + j;
        cVar.d.put(i, Long.valueOf(jLongValue));
        cVar.c += j;
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, j, cVar)) && (interfaceC0613b = this.a) != null) {
            interfaceC0613b.d(fVar, i, jLongValue);
            this.a.a(fVar, cVar.c);
        }
    }

    public void a(f fVar, long j) {
        ((c) this.c.a(fVar, fVar.l())).a(j);
    }

    public void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z) {
        InterfaceC0613b interfaceC0613b;
        c cVar2 = (c) this.c.a(fVar, cVar);
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, cVar, z, cVar2)) && (interfaceC0613b = this.a) != null) {
            interfaceC0613b.a(fVar, cVar, z, cVar2);
        }
    }

    public synchronized void a(f fVar, EndCause endCause, Exception exc) {
        c cVar = (c) this.c.c(fVar, fVar.l());
        a aVar = this.b;
        if (aVar == null || !aVar.a(fVar, endCause, exc, cVar)) {
            InterfaceC0613b interfaceC0613b = this.a;
            if (interfaceC0613b != null) {
                interfaceC0613b.a(fVar, endCause, exc, cVar);
            }
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(InterfaceC0613b interfaceC0613b) {
        this.a = interfaceC0613b;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void a(boolean z) {
        this.c.a(z);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public boolean a() {
        return this.c.a();
    }

    public a b() {
        return this.b;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void b(boolean z) {
        this.c.b(z);
    }
}
