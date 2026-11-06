package com.tapsdk.tapad.internal.download.m.i.g;

import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.f;
import com.tapsdk.tapad.internal.download.k;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.tapsdk.tapad.internal.download.m.i.g.b.a, e.b<b> {
    private a a;

    public interface a {
        void a(f fVar, int i, long j, k kVar);

        void a(f fVar, int i, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar, k kVar);

        void a(f fVar, long j, k kVar);

        void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, b bVar);

        void a(f fVar, EndCause endCause, Exception exc, k kVar);
    }

    public static class b extends com.tapsdk.tapad.internal.download.m.i.g.b.c {
        k e;
        SparseArray<k> f;

        public b(int i) {
            super(i);
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.b.c, com.tapsdk.tapad.internal.download.m.i.g.e.a
        public void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            super.a(cVar);
            this.e = new k();
            this.f = new SparseArray<>();
            int iB = cVar.b();
            for (int i = 0; i < iB; i++) {
                this.f.put(i, new k());
            }
        }

        public k b(int i) {
            return this.f.get(i);
        }

        public k e() {
            return this.e;
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.a
    public boolean a(f fVar, int i, long j, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar) {
        b bVar = (b) cVar;
        bVar.f.get(i).a(j);
        bVar.e.a(j);
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.d.get(i).longValue(), bVar.b(i));
        this.a.a(fVar, cVar.c, bVar.e);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.a
    public boolean a(f fVar, int i, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar) {
        b bVar = (b) cVar;
        bVar.f.get(i).b();
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.b.b(i), bVar.b(i));
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.a
    public boolean a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar2) {
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, cVar, z, (b) cVar2);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.a
    public boolean a(f fVar, EndCause endCause, Exception exc, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar) {
        k kVar = ((b) cVar).e;
        if (kVar != null) {
            kVar.b();
        } else {
            kVar = new k();
        }
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, endCause, exc, kVar);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(int i) {
        return new b(i);
    }
}
