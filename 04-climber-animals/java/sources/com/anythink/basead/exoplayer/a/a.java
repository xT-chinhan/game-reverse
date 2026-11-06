package com.anythink.basead.exoplayer.a;

import android.net.NetworkInfo;
import android.view.Surface;
import com.anythink.basead.exoplayer.ae;
import com.anythink.basead.exoplayer.b.g;
import com.anythink.basead.exoplayer.g.f;
import com.anythink.basead.exoplayer.h.af;
import com.anythink.basead.exoplayer.h.s;
import com.anythink.basead.exoplayer.h.t;
import com.anythink.basead.exoplayer.j.d;
import com.anythink.basead.exoplayer.l.h;
import com.anythink.basead.exoplayer.m;
import com.anythink.basead.exoplayer.v;
import com.anythink.basead.exoplayer.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g, com.anythink.basead.exoplayer.d.c, f, t, d.a, h, w.c {
    private final com.anythink.basead.exoplayer.k.c b;
    private w e;
    private final CopyOnWriteArraySet<com.anythink.basead.exoplayer.a.b> a = new CopyOnWriteArraySet<>();
    private final b d = new b();
    private final ae.b c = new ae.b();

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.a.a$a, reason: collision with other inner class name */
    public static class C0016a {
        public static a a(w wVar, com.anythink.basead.exoplayer.k.c cVar) {
            return new a(wVar, cVar);
        }
    }

    protected a(w wVar, com.anythink.basead.exoplayer.k.c cVar) {
        this.e = wVar;
        this.b = (com.anythink.basead.exoplayer.k.c) com.anythink.basead.exoplayer.k.a.a(cVar);
    }

    public final void a(com.anythink.basead.exoplayer.a.b bVar) {
        this.a.add(bVar);
    }

    public final void b(com.anythink.basead.exoplayer.a.b bVar) {
        this.a.remove(bVar);
    }

    private void a(w wVar) {
        com.anythink.basead.exoplayer.k.a.b(this.e == null);
        this.e = (w) com.anythink.basead.exoplayer.k.a.a(wVar);
    }

    public final void a() {
        if (this.d.e()) {
            return;
        }
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        this.d.g();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI);
        }
    }

    private void a(int i, int i2) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, i, i2);
        }
    }

    private void a(NetworkInfo networkInfo) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, networkInfo);
        }
    }

    public final void b() {
        for (c cVar : new ArrayList(this.d.a)) {
            b(cVar.a, cVar.b);
        }
    }

    @Override // com.anythink.basead.exoplayer.g.f
    public final void a(com.anythink.basead.exoplayer.g.a aVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, aVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void c(com.anythink.basead.exoplayer.c.d dVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarI, 1);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void a(int i) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(aVarJ, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void b(String str, long j, long j2) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 1, str);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void b(m mVar) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 1, mVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void a(int i, long j, long j2) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, i, j, j2);
        }
    }

    @Override // com.anythink.basead.exoplayer.b.g
    public final void d(com.anythink.basead.exoplayer.c.d dVar) {
        com.anythink.basead.exoplayer.a.b.a aVarH = h();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarH, 1);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(com.anythink.basead.exoplayer.c.d dVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarI, 2);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(String str, long j, long j2) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 2, str);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(m mVar) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 2, mVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(int i, long j) {
        com.anythink.basead.exoplayer.a.b.a aVarH = h();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(aVarH, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(int i, int i2, int i3, float f) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarJ, i, i2);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void a(Surface surface) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, surface);
        }
    }

    @Override // com.anythink.basead.exoplayer.l.h
    public final void b(com.anythink.basead.exoplayer.c.d dVar) {
        com.anythink.basead.exoplayer.a.b.a aVarH = h();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarH, 2);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void a(int i, s.a aVar) {
        this.d.a(i, aVar);
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(aVarD);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void b(int i, s.a aVar) {
        this.d.b(i, aVar);
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarD);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void a(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void b(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void c(int i, s.a aVar, t.b bVar, t.c cVar) {
        d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarD, iOException);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void c(int i, s.a aVar) {
        this.d.c(i, aVar);
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarD);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void a(int i, s.a aVar, t.c cVar) {
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarD, cVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.t
    public final void b(int i, s.a aVar, t.c cVar) {
        com.anythink.basead.exoplayer.a.b.a aVarD = d(i, aVar);
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarD, cVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onTimelineChanged(ae aeVar, Object obj, int i) {
        this.d.a(aeVar);
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onTracksChanged(af afVar, com.anythink.basead.exoplayer.i.g gVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, gVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onLoadingChanged(boolean z) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarI, z);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onPlayerStateChanged(boolean z, int i) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, z, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onRepeatModeChanged(int i) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(aVarI, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onShuffleModeEnabledChanged(boolean z) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, z);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onPlayerError(com.anythink.basead.exoplayer.g gVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, gVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onPositionDiscontinuity(int i) {
        this.d.f();
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarI, i);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onPlaybackParametersChanged(v vVar) {
        com.anythink.basead.exoplayer.a.b.a aVarI = i();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, vVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.w.c
    public final void onSeekProcessed() {
        if (this.d.e()) {
            this.d.h();
            com.anythink.basead.exoplayer.a.b.a aVarI = i();
            Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(aVarI);
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.d.c
    public final void d() {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(aVarJ);
        }
    }

    @Override // com.anythink.basead.exoplayer.d.c
    public final void a(Exception exc) {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, exc);
        }
    }

    @Override // com.anythink.basead.exoplayer.d.c
    public final void e() {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(aVarJ);
        }
    }

    @Override // com.anythink.basead.exoplayer.d.c
    public final void f() {
        com.anythink.basead.exoplayer.a.b.a aVarJ = j();
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().h(aVarJ);
        }
    }

    private Set<com.anythink.basead.exoplayer.a.b> g() {
        return Collections.unmodifiableSet(this.a);
    }

    private com.anythink.basead.exoplayer.a.b.a d(int i, s.a aVar) {
        long jA;
        long j;
        com.anythink.basead.exoplayer.k.a.a(this.e);
        long jA2 = this.b.a();
        ae aeVarF = this.e.F();
        long jT = 0;
        if (i == this.e.p()) {
            if (aVar != null && aVar.a()) {
                if (this.e.z() == aVar.b && this.e.A() == aVar.c) {
                    jT = this.e.t();
                }
                j = jT;
            } else {
                jA = this.e.B();
                j = jA;
            }
        } else if (i >= aeVarF.b() || (aVar != null && aVar.a())) {
            j = jT;
        } else {
            jA = com.anythink.basead.exoplayer.b.a(aeVarF.a(i, this.c, false).h);
            j = jA;
        }
        return new com.anythink.basead.exoplayer.a.b.a(jA2, aeVarF, i, aVar, j, this.e.t(), this.e.u() - this.e.B());
    }

    private com.anythink.basead.exoplayer.a.b.a a(c cVar) {
        if (cVar == null) {
            int iP = ((w) com.anythink.basead.exoplayer.k.a.a(this.e)).p();
            return d(iP, this.d.a(iP));
        }
        return d(cVar.a, cVar.b);
    }

    private com.anythink.basead.exoplayer.a.b.a h() {
        return a(this.d.b());
    }

    private com.anythink.basead.exoplayer.a.b.a i() {
        return a(this.d.a());
    }

    private com.anythink.basead.exoplayer.a.b.a j() {
        return a(this.d.c());
    }

    private com.anythink.basead.exoplayer.a.b.a k() {
        return a(this.d.d());
    }

    private static final class b {
        private c c;
        private c d;
        private boolean f;
        private final ArrayList<c> a = new ArrayList<>();
        private final ae.a b = new ae.a();
        private ae e = ae.a;

        public final c a() {
            if (this.a.isEmpty() || this.e.a() || this.f) {
                return null;
            }
            return this.a.get(0);
        }

        public final c b() {
            return this.c;
        }

        public final c c() {
            return this.d;
        }

        public final c d() {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<c> arrayList = this.a;
            return arrayList.get(arrayList.size() - 1);
        }

        public final boolean e() {
            return this.f;
        }

        public final s.a a(int i) {
            ae aeVar = this.e;
            if (aeVar == null) {
                return null;
            }
            int iC = aeVar.c();
            s.a aVar = null;
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                c cVar = this.a.get(i2);
                int i3 = cVar.b.a;
                if (i3 < iC && this.e.a(i3, this.b, false).c == i) {
                    if (aVar != null) {
                        return null;
                    }
                    aVar = cVar.b;
                }
            }
            return aVar;
        }

        public final void f() {
            i();
        }

        public final void a(ae aeVar) {
            for (int i = 0; i < this.a.size(); i++) {
                ArrayList<c> arrayList = this.a;
                arrayList.set(i, a(arrayList.get(i), aeVar));
            }
            c cVar = this.d;
            if (cVar != null) {
                this.d = a(cVar, aeVar);
            }
            this.e = aeVar;
            i();
        }

        public final void g() {
            this.f = true;
        }

        public final void h() {
            this.f = false;
            i();
        }

        public final void a(int i, s.a aVar) {
            this.a.add(new c(i, aVar));
            if (this.a.size() != 1 || this.e.a()) {
                return;
            }
            i();
        }

        public final void b(int i, s.a aVar) {
            c cVar = new c(i, aVar);
            this.a.remove(cVar);
            if (cVar.equals(this.d)) {
                this.d = this.a.isEmpty() ? null : this.a.get(0);
            }
        }

        public final void c(int i, s.a aVar) {
            this.d = new c(i, aVar);
        }

        private void i() {
            if (this.a.isEmpty()) {
                return;
            }
            this.c = this.a.get(0);
        }

        private c a(c cVar, ae aeVar) {
            int iA;
            return (aeVar.a() || this.e.a() || (iA = aeVar.a(this.e.a(cVar.b.a, this.b, true).b)) == -1) ? cVar : new c(aeVar.a(iA, this.b, false).c, cVar.b.a(iA));
        }
    }

    private static final class c {
        public final int a;
        public final s.a b;

        public c(int i, s.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                if (this.a == cVar.a && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }
    }

    @Override // com.anythink.basead.exoplayer.j.d.a
    public final void c() {
        a(this.d.d());
        Iterator<com.anythink.basead.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
