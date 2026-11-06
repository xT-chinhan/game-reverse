package com.anythink.basead.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ad extends com.anythink.basead.exoplayer.h.c {
    public static final int a = 3;
    private final com.anythink.basead.exoplayer.j.k b;
    private final com.anythink.basead.exoplayer.j.h.a c;
    private final com.anythink.basead.exoplayer.m d;
    private final long e;
    private final int f;
    private final boolean g;
    private final com.anythink.basead.exoplayer.ae h;

    @Deprecated
    public interface a {
        void a();
    }

    @Override // com.anythink.basead.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void b() {
    }

    /* synthetic */ ad(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.m mVar, long j, int i, boolean z, Object obj, byte b2) {
        this(uri, aVar, mVar, j, i, z, obj);
    }

    public static final class c {
        private final com.anythink.basead.exoplayer.j.h.a a;
        private int b = 3;
        private boolean c;
        private boolean d;
        private Object e;

        private c(com.anythink.basead.exoplayer.j.h.a aVar) {
            this.a = (com.anythink.basead.exoplayer.j.h.a) com.anythink.basead.exoplayer.k.a.a(aVar);
        }

        private c a(Object obj) {
            com.anythink.basead.exoplayer.k.a.b(!this.d);
            this.e = obj;
            return this;
        }

        private c a(int i) {
            com.anythink.basead.exoplayer.k.a.b(!this.d);
            this.b = i;
            return this;
        }

        private c a(boolean z) {
            com.anythink.basead.exoplayer.k.a.b(!this.d);
            this.c = z;
            return this;
        }

        private ad a(Uri uri, com.anythink.basead.exoplayer.m mVar, long j) {
            this.d = true;
            return new ad(uri, this.a, mVar, j, this.b, this.c, this.e, (byte) 0);
        }

        @Deprecated
        private ad a(Uri uri, com.anythink.basead.exoplayer.m mVar, long j, Handler handler, t tVar) {
            this.d = true;
            ad adVar = new ad(uri, this.a, mVar, j, this.b, this.c, this.e, (byte) 0);
            if (handler != null && tVar != null) {
                adVar.a(handler, tVar);
            }
            return adVar;
        }
    }

    @Deprecated
    private ad(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.m mVar, long j) {
        this(uri, aVar, mVar, j, (byte) 0);
    }

    @Deprecated
    private ad(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.m mVar, long j, byte b2) {
        this(uri, aVar, mVar, j, 3, false, null);
    }

    @Deprecated
    private ad(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.m mVar, long j, int i, Handler handler, a aVar2, int i2, boolean z) {
        this(uri, aVar, mVar, j, i, z, null);
        if (handler == null || aVar2 == null) {
            return;
        }
        a(handler, new b(aVar2, i2));
    }

    private ad(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.m mVar, long j, int i, boolean z, Object obj) {
        this.c = aVar;
        this.d = mVar;
        this.e = j;
        this.f = i;
        this.g = z;
        this.b = new com.anythink.basead.exoplayer.j.k(uri);
        this.h = new ab(j, true, false, obj);
    }

    @Override // com.anythink.basead.exoplayer.h.c
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        a(this.h, (Object) null);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        com.anythink.basead.exoplayer.k.a.a(aVar.a == 0);
        return new ac(this.b, this.c, this.d, this.e, this.f, a(aVar), this.g);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        ((ac) rVar).f();
    }

    private static final class b extends k {
        private final a a;
        private final int b;

        @Override // com.anythink.basead.exoplayer.h.k, com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
        }

        public b(a aVar, int i) {
            this.a = (a) com.anythink.basead.exoplayer.k.a.a(aVar);
            this.b = i;
        }
    }
}
