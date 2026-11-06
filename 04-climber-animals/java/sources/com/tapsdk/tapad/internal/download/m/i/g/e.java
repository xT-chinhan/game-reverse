package com.tapsdk.tapad.internal.download.m.i.g;

import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.f;
import com.tapsdk.tapad.internal.download.m.i.g.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class e<T extends a> implements d {
    volatile T a;
    final SparseArray<T> b = new SparseArray<>();
    private Boolean c;
    private final b<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface a {
        void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar);

        int f();
    }

    public interface b<T extends a> {
        T a(int i);
    }

    e(b<T> bVar) {
        this.d = bVar;
    }

    T a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        T t = (T) this.d.a(fVar.b());
        synchronized (this) {
            if (this.a == null) {
                this.a = t;
            } else {
                this.b.put(fVar.b(), t);
            }
            if (cVar != null) {
                t.a(cVar);
            }
        }
        return t;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void a(boolean z) {
        if (this.c == null) {
            this.c = Boolean.valueOf(z);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public boolean a() {
        Boolean bool = this.c;
        return bool != null && bool.booleanValue();
    }

    T b(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        T t;
        int iB = fVar.b();
        synchronized (this) {
            t = (this.a == null || this.a.f() != iB) ? null : this.a;
        }
        if (t == null) {
            t = this.b.get(iB);
        }
        return (t == null && a()) ? (T) a(fVar, cVar) : t;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void b(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    T c(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        T t;
        int iB = fVar.b();
        synchronized (this) {
            if (this.a == null || this.a.f() != iB) {
                t = this.b.get(iB);
                this.b.remove(iB);
            } else {
                t = this.a;
                this.a = null;
            }
        }
        if (t == null) {
            t = (T) this.d.a(iB);
            if (cVar != null) {
                t.a(cVar);
            }
        }
        return t;
    }
}
