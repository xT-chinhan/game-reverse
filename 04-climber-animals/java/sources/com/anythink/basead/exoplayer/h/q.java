package com.anythink.basead.exoplayer.h;

/* JADX INFO: loaded from: classes.dex */
public final class q extends f<Void> {
    private final s a;
    private final int b;
    private int c;

    private q(s sVar) {
        this(sVar, (byte) 0);
    }

    private q(s sVar, byte b2) {
        com.anythink.basead.exoplayer.k.a.a(true);
        this.a = sVar;
        this.b = Integer.MAX_VALUE;
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((Object) null, this.a);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        if (this.b != Integer.MAX_VALUE) {
            return this.a.a(aVar.a(aVar.a % this.c), bVar);
        }
        return this.a.a(aVar, bVar);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        this.a.a(rVar);
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a() {
        super.a();
        this.c = 0;
    }

    private void b(com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        com.anythink.basead.exoplayer.ae aVar;
        this.c = aeVar.c();
        if (this.b != Integer.MAX_VALUE) {
            aVar = new b(aeVar, this.b);
        } else {
            aVar = new a(aeVar);
        }
        a(aVar, obj);
    }

    private static final class b extends com.anythink.basead.exoplayer.h.a {
        private final com.anythink.basead.exoplayer.ae b;
        private final int c;
        private final int d;
        private final int e;

        public b(com.anythink.basead.exoplayer.ae aeVar, int i) {
            super(false, new aa.b(i));
            this.b = aeVar;
            int iC = aeVar.c();
            this.c = iC;
            this.d = aeVar.b();
            this.e = i;
            if (iC > 0) {
                com.anythink.basead.exoplayer.k.a.b(i <= Integer.MAX_VALUE / iC, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int b() {
            return this.d * this.e;
        }

        @Override // com.anythink.basead.exoplayer.ae
        public final int c() {
            return this.c * this.e;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int a(int i) {
            return i / this.c;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int b(int i) {
            return i / this.d;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int b(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final com.anythink.basead.exoplayer.ae c(int i) {
            return this.b;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int d(int i) {
            return i * this.c;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final int e(int i) {
            return i * this.d;
        }

        @Override // com.anythink.basead.exoplayer.h.a
        protected final Object f(int i) {
            return Integer.valueOf(i);
        }
    }

    private static final class a extends p {
        public a(com.anythink.basead.exoplayer.ae aeVar) {
            super(aeVar);
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final int a(int i, int i2, boolean z) {
            int iA = this.b.a(i, i2, z);
            return iA == -1 ? b(z) : iA;
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final int b(int i, int i2, boolean z) {
            int iB = this.b.b(i, i2, z);
            return iB == -1 ? a(z) : iB;
        }
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* synthetic */ void a(Void r1, s sVar, com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        com.anythink.basead.exoplayer.ae aVar;
        this.c = aeVar.c();
        if (this.b != Integer.MAX_VALUE) {
            aVar = new b(aeVar, this.b);
        } else {
            aVar = new a(aeVar);
        }
        a(aVar, obj);
    }
}
