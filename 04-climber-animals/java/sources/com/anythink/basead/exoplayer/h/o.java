package com.anythink.basead.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class o extends com.anythink.basead.exoplayer.h.c implements n.c {
    public static final int a = 3;
    public static final int b = 6;
    public static final int c = -1;
    public static final int d = 1048576;
    private final Uri e;
    private final com.anythink.basead.exoplayer.j.h.a f;
    private final com.anythink.basead.exoplayer.e.h g;
    private final int h;
    private final String i;
    private final int j;
    private final Object k;
    private long l;
    private boolean m;

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

    /* synthetic */ o(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.e.h hVar, int i, String str, int i2, Object obj, byte b2) {
        this(uri, aVar, hVar, i, str, i2, obj);
    }

    public static final class c implements com.anythink.basead.exoplayer.h.a.c.e {
        private final com.anythink.basead.exoplayer.j.h.a a;
        private com.anythink.basead.exoplayer.e.h b;
        private String c;
        private Object d;
        private int e = -1;
        private int f = 1048576;
        private boolean g;

        @Override // com.anythink.basead.exoplayer.h.a.c.e
        public final int[] a() {
            return new int[]{3};
        }

        public c(com.anythink.basead.exoplayer.j.h.a aVar) {
            this.a = aVar;
        }

        private c a(com.anythink.basead.exoplayer.e.h hVar) {
            com.anythink.basead.exoplayer.k.a.b(!this.g);
            this.b = hVar;
            return this;
        }

        private c a(String str) {
            com.anythink.basead.exoplayer.k.a.b(!this.g);
            this.c = str;
            return this;
        }

        private c a(Object obj) {
            com.anythink.basead.exoplayer.k.a.b(!this.g);
            this.d = obj;
            return this;
        }

        private c a(int i) {
            com.anythink.basead.exoplayer.k.a.b(!this.g);
            this.e = i;
            return this;
        }

        private c b(int i) {
            com.anythink.basead.exoplayer.k.a.b(!this.g);
            this.f = i;
            return this;
        }

        @Override // com.anythink.basead.exoplayer.h.a.c.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o b(Uri uri) {
            this.g = true;
            if (this.b == null) {
                this.b = new com.anythink.basead.exoplayer.e.c();
            }
            return new o(uri, this.a, this.b, this.e, this.c, this.f, this.d, (byte) 0);
        }

        @Deprecated
        private o a(Uri uri, Handler handler, t tVar) {
            o oVarB = b(uri);
            if (handler != null && tVar != null) {
                oVarB.a(handler, tVar);
            }
            return oVarB;
        }
    }

    @Deprecated
    private o(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.e.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    @Deprecated
    private o(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.e.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, handler, aVar2, str, (byte) 0);
    }

    @Deprecated
    private o(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.e.h hVar, Handler handler, a aVar2, String str, byte b2) {
        this(uri, aVar, hVar, -1, str, 1048576, (Object) null);
        if (aVar2 == null || handler == null) {
            return;
        }
        a(handler, new b(aVar2));
    }

    private o(Uri uri, com.anythink.basead.exoplayer.j.h.a aVar, com.anythink.basead.exoplayer.e.h hVar, int i, String str, int i2, Object obj) {
        this.e = uri;
        this.f = aVar;
        this.g = hVar;
        this.h = i;
        this.i = str;
        this.j = i2;
        this.l = -9223372036854775807L;
        this.k = obj;
    }

    @Override // com.anythink.basead.exoplayer.h.c
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        b(this.l, false);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        com.anythink.basead.exoplayer.k.a.a(aVar.a == 0);
        return new n(this.e, this.f.a(), this.g.a(), this.h, a(aVar), this, bVar, this.i, this.j);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        ((n) rVar).f();
    }

    @Override // com.anythink.basead.exoplayer.h.n.c
    public final void a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.l;
        }
        if (this.l == j && this.m == z) {
            return;
        }
        b(j, z);
    }

    private void b(long j, boolean z) {
        this.l = j;
        this.m = z;
        a(new ab(this.l, this.m, false, this.k), (Object) null);
    }

    private static final class b extends k {
        private final a a;

        @Override // com.anythink.basead.exoplayer.h.k, com.anythink.basead.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
        }

        public b(a aVar) {
            this.a = (a) com.anythink.basead.exoplayer.k.a.a(aVar);
        }
    }
}
