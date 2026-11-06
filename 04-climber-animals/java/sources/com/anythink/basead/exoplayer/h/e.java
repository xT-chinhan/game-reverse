package com.anythink.basead.exoplayer.h;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e extends f<Void> {
    private final s a;
    private final long b;
    private final long c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final ArrayList<d> g;
    private final com.anythink.basead.exoplayer.ae.b h;
    private Object i;
    private a j;
    private b k;
    private long l;
    private long m;

    public static final class b extends IOException {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public final int d;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        private static String a(int i) {
            if (i == 0) {
                return "invalid period count";
            }
            if (i != 1) {
                return i != 2 ? "unknown" : "start exceeds end";
            }
            return "not seekable to start";
        }

        public b(int i) {
            super("Illegal clipping: ".concat(i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count"));
            this.d = i;
        }
    }

    private e(s sVar, long j, long j2) {
        this(sVar, j, j2, true, false);
    }

    @Deprecated
    private e(s sVar, long j, long j2, boolean z) {
        this(sVar, j, j2, z, false);
    }

    private e(s sVar, long j) {
        this(sVar, 0L, j, true, true);
    }

    private e(s sVar, long j, long j2, boolean z, boolean z2) {
        com.anythink.basead.exoplayer.k.a.a(j >= 0);
        this.a = (s) com.anythink.basead.exoplayer.k.a.a(sVar);
        this.b = j;
        this.c = j2;
        this.d = z;
        this.e = false;
        this.f = z2;
        this.g = new ArrayList<>();
        this.h = new com.anythink.basead.exoplayer.ae.b();
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((Object) null, this.a);
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.s
    public final void b() throws b {
        b bVar = this.k;
        if (bVar != null) {
            throw bVar;
        }
        super.b();
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        d dVar = new d(this.a.a(aVar, bVar), this.d, this.l, this.m);
        this.g.add(dVar);
        return dVar;
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        com.anythink.basead.exoplayer.k.a.b(this.g.remove(rVar));
        this.a.a(((d) rVar).a);
        if (!this.g.isEmpty() || this.e) {
            return;
        }
        a(this.j.b);
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a() {
        super.a();
        this.k = null;
        this.j = null;
    }

    private void b(com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        if (this.k != null) {
            return;
        }
        this.i = obj;
        a(aeVar);
    }

    private void a(com.anythink.basead.exoplayer.ae aeVar) {
        long j;
        long j2;
        aeVar.a(0, this.h, false);
        long j3 = this.h.j;
        if (this.j == null || this.g.isEmpty() || this.e) {
            long j4 = this.b;
            long j5 = this.c;
            if (this.f) {
                long j6 = this.h.h;
                j4 += j6;
                j5 += j6;
            }
            this.l = j3 + j4;
            this.m = this.c != Long.MIN_VALUE ? j3 + j5 : Long.MIN_VALUE;
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.g.get(i).a(this.l, this.m);
            }
            j = j4;
            j2 = j5;
        } else {
            long j7 = this.l - j3;
            j2 = this.c != Long.MIN_VALUE ? this.m - j3 : Long.MIN_VALUE;
            j = j7;
        }
        try {
            a aVar = new a(aeVar, j, j2);
            this.j = aVar;
            a(aVar, this.i);
        } catch (b e) {
            this.k = e;
        }
    }

    private long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jA = com.anythink.basead.exoplayer.b.a(this.b);
        long jMax = Math.max(0L, j - jA);
        long j2 = this.c;
        return j2 != Long.MIN_VALUE ? Math.min(com.anythink.basead.exoplayer.b.a(j2) - jA, jMax) : jMax;
    }

    private static final class a extends p {
        private final long c;
        private final long d;
        private final long e;
        private final boolean f;

        public a(com.anythink.basead.exoplayer.ae aeVar, long j, long j2) throws b {
            super(aeVar);
            boolean z = false;
            if (aeVar.c() != 1) {
                throw new b(0);
            }
            com.anythink.basead.exoplayer.ae.b bVarA = aeVar.a(0, new com.anythink.basead.exoplayer.ae.b(), false);
            long jMax = Math.max(0L, j);
            long jMax2 = j2 == Long.MIN_VALUE ? bVarA.i : Math.max(0L, j2);
            if (bVarA.i != -9223372036854775807L) {
                jMax2 = jMax2 > bVarA.i ? bVarA.i : jMax2;
                if (jMax != 0 && !bVarA.d) {
                    throw new b(1);
                }
                if (jMax > jMax2) {
                    throw new b(2);
                }
            }
            this.c = jMax;
            this.d = jMax2;
            this.e = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (bVarA.e && (jMax2 == -9223372036854775807L || (bVarA.i != -9223372036854775807L && jMax2 == bVarA.i))) {
                z = true;
            }
            this.f = z;
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final com.anythink.basead.exoplayer.ae.b a(int i, com.anythink.basead.exoplayer.ae.b bVar, boolean z, long j) {
            this.b.a(0, bVar, z, 0L);
            bVar.j += this.c;
            bVar.i = this.e;
            bVar.e = this.f;
            if (bVar.h != -9223372036854775807L) {
                bVar.h = Math.max(bVar.h, this.c);
                bVar.h = this.d == -9223372036854775807L ? bVar.h : Math.min(bVar.h, this.d);
                bVar.h -= this.c;
            }
            long jA = com.anythink.basead.exoplayer.b.a(this.c);
            if (bVar.b != -9223372036854775807L) {
                bVar.b += jA;
            }
            if (bVar.c != -9223372036854775807L) {
                bVar.c += jA;
            }
            return bVar;
        }

        @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
        public final com.anythink.basead.exoplayer.ae.a a(int i, com.anythink.basead.exoplayer.ae.a aVar, boolean z) {
            this.b.a(0, aVar, z);
            long jB = aVar.b() - this.c;
            long j = this.e;
            return aVar.a(aVar.a, aVar.b, j == -9223372036854775807L ? -9223372036854775807L : j - jB, jB);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* synthetic */ long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jA = com.anythink.basead.exoplayer.b.a(this.b);
        long jMax = Math.max(0L, j - jA);
        long j2 = this.c;
        return j2 != Long.MIN_VALUE ? Math.min(com.anythink.basead.exoplayer.b.a(j2) - jA, jMax) : jMax;
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ void a(Void r1, s sVar, com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        if (this.k == null) {
            this.i = obj;
            a(aeVar);
        }
    }
}
