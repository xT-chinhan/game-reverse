package com.anythink.basead.exoplayer.h;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class f<T> extends c {
    private final HashMap<T, b> a = new HashMap<>();
    private com.anythink.basead.exoplayer.h b;
    private Handler c;

    protected int a(T t, int i) {
        return i;
    }

    protected long a(long j) {
        return j;
    }

    protected s.a a(T t, s.a aVar) {
        return aVar;
    }

    protected abstract void a(T t, s sVar, com.anythink.basead.exoplayer.ae aeVar, Object obj);

    protected f() {
    }

    @Override // com.anythink.basead.exoplayer.h.c
    public void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        this.b = hVar;
        this.c = new Handler();
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public void b() {
        Iterator<b> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a.b();
        }
    }

    @Override // com.anythink.basead.exoplayer.h.c
    public void a() {
        for (b bVar : this.a.values()) {
            bVar.a.a(bVar.b);
            bVar.a.a(bVar.c);
        }
        this.a.clear();
        this.b = null;
    }

    protected final void a(final T t, s sVar) {
        com.anythink.basead.exoplayer.k.a.a(!this.a.containsKey(t));
        s.b bVar = new s.b() { // from class: com.anythink.basead.exoplayer.h.f.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.anythink.basead.exoplayer.h.s.b
            public final void a(s sVar2, com.anythink.basead.exoplayer.ae aeVar, Object obj) {
                f.this.a(t, sVar2, aeVar, obj);
            }
        };
        a aVar = new a(t);
        this.a.put(t, new b(sVar, bVar, aVar));
        sVar.a(this.c, aVar);
        sVar.a(this.b, false, bVar);
    }

    protected final void a(T t) {
        b bVarRemove = this.a.remove(t);
        bVarRemove.a.a(bVarRemove.b);
        bVarRemove.a.a(bVarRemove.c);
    }

    private static final class b {
        public final s a;
        public final s.b b;
        public final t c;

        public b(s sVar, s.b bVar, t tVar) {
            this.a = sVar;
            this.b = bVar;
            this.c = tVar;
        }
    }

    private final class a implements t {
        private final T b;
        private t.a c;

        public a(T t) {
            this.c = f.this.a((s.a) null);
            this.b = t;
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.c.a();
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void b(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.c.b();
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.c.a(bVar, a(cVar));
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void b(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.c.b(bVar, a(cVar));
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void c(int i, s.a aVar, t.b bVar, t.c cVar) {
            if (d(i, aVar)) {
                this.c.c(bVar, a(cVar));
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
            if (d(i, aVar)) {
                this.c.a(bVar, a(cVar), iOException, z);
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void c(int i, s.a aVar) {
            if (d(i, aVar)) {
                this.c.c();
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar, t.c cVar) {
            if (d(i, aVar)) {
                this.c.a(a(cVar));
            }
        }

        @Override // com.anythink.basead.exoplayer.h.t
        public final void b(int i, s.a aVar, t.c cVar) {
            if (d(i, aVar)) {
                this.c.b(a(cVar));
            }
        }

        private boolean d(int i, s.a aVar) {
            s.a aVarA;
            if (aVar != null) {
                aVarA = f.this.a(this.b, aVar);
                if (aVarA == null) {
                    return false;
                }
            } else {
                aVarA = null;
            }
            int iA = f.this.a(this.b, i);
            if (this.c.a == iA && com.anythink.basead.exoplayer.k.af.a(this.c.b, aVarA)) {
                return true;
            }
            this.c = f.this.a(iA, aVarA);
            return true;
        }

        private t.c a(t.c cVar) {
            long jA = f.this.a(cVar.f);
            long jA2 = f.this.a(cVar.g);
            return (jA == cVar.f && jA2 == cVar.g) ? cVar : new t.c(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, jA, jA2);
        }
    }
}
