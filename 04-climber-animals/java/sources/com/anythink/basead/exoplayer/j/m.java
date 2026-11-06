package com.anythink.basead.exoplayer.j;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class m implements aa<Object>, d {
    public static final long a = 1000000;
    public static final int b = 2000;
    private static final int c = 2000;
    private static final int d = 524288;
    private final Handler e;
    private final d.a f;
    private final com.anythink.basead.exoplayer.k.y g;
    private final com.anythink.basead.exoplayer.k.c h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;

    /* synthetic */ m(Handler handler, d.a aVar, long j, int i, com.anythink.basead.exoplayer.k.c cVar, byte b2) {
        this(handler, aVar, j, i, cVar);
    }

    public static final class a {
        private Handler a;
        private d.a b;
        private long c = 1000000;
        private int d = 2000;
        private com.anythink.basead.exoplayer.k.c e = com.anythink.basead.exoplayer.k.c.a;

        private a a(Handler handler, d.a aVar) {
            com.anythink.basead.exoplayer.k.a.a((handler == null || aVar == null) ? false : true);
            this.a = handler;
            this.b = aVar;
            return this;
        }

        private a a(int i) {
            this.d = i;
            return this;
        }

        private a a(long j) {
            this.c = j;
            return this;
        }

        private a a(com.anythink.basead.exoplayer.k.c cVar) {
            this.e = cVar;
            return this;
        }

        private m a() {
            return new m(this.a, this.b, this.c, this.d, this.e, (byte) 0);
        }
    }

    public m() {
        this(null, null, 1000000L, 2000, com.anythink.basead.exoplayer.k.c.a);
    }

    @Deprecated
    private m(Handler handler, d.a aVar) {
        this(handler, aVar, 1000000L, 2000, com.anythink.basead.exoplayer.k.c.a);
    }

    @Deprecated
    private m(Handler handler, d.a aVar, int i) {
        this(handler, aVar, 1000000L, i, com.anythink.basead.exoplayer.k.c.a);
    }

    private m(Handler handler, d.a aVar, long j, int i, com.anythink.basead.exoplayer.k.c cVar) {
        this.e = handler;
        this.f = aVar;
        this.g = new com.anythink.basead.exoplayer.k.y(i);
        this.h = cVar;
        this.n = j;
    }

    @Override // com.anythink.basead.exoplayer.j.d
    public final synchronized long a() {
        return this.n;
    }

    @Override // com.anythink.basead.exoplayer.j.aa
    public final synchronized void b() {
        if (this.i == 0) {
            this.j = this.h.a();
        }
        this.i++;
    }

    @Override // com.anythink.basead.exoplayer.j.aa
    public final synchronized void a(int i) {
        this.k += (long) i;
    }

    @Override // com.anythink.basead.exoplayer.j.aa
    public final synchronized void c() {
        com.anythink.basead.exoplayer.k.a.b(this.i > 0);
        long jA = this.h.a();
        int i = (int) (jA - this.j);
        long j = i;
        this.l += j;
        long j2 = this.m;
        long j3 = this.k;
        this.m = j2 + j3;
        if (i > 0) {
            this.g.a((int) Math.sqrt(j3), (8000 * j3) / j);
            if (this.l >= com.anythink.basead.exoplayer.i.a.f || this.m >= 524288) {
                this.n = (long) this.g.a();
            }
        }
        long j4 = this.k;
        long j5 = this.n;
        Handler handler = this.e;
        if (handler != null && this.f != null) {
            handler.post(new AnonymousClass1(i, j4, j5));
        }
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 > 0) {
            this.j = jA;
        }
        this.k = 0L;
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.j.m$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        AnonymousClass1(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.f.c();
        }
    }

    private void a(int i, long j, long j2) {
        Handler handler = this.e;
        if (handler == null || this.f == null) {
            return;
        }
        handler.post(new AnonymousClass1(i, j, j2));
    }
}
