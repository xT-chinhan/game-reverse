package com.anythink.basead.exoplayer.h;

/* JADX INFO: loaded from: classes.dex */
public final class ab extends com.anythink.basead.exoplayer.ae {
    private static final Object b = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;
    private final Object k;

    @Override // com.anythink.basead.exoplayer.ae
    public final int b() {
        return 1;
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int c() {
        return 1;
    }

    private ab(long j, boolean z, boolean z2) {
        this(j, z, z2, null);
    }

    public ab(long j, boolean z, boolean z2, Object obj) {
        this(j, j, z, z2, obj, (byte) 0);
    }

    private ab(long j, long j2, boolean z, boolean z2, Object obj, byte b2) {
        this(j, j2, z, z2, obj);
    }

    private ab(long j, long j2, boolean z, boolean z2, Object obj) {
        this.c = -9223372036854775807L;
        this.d = -9223372036854775807L;
        this.e = j;
        this.f = j2;
        this.g = 0L;
        this.h = 0L;
        this.i = z;
        this.j = z2;
        this.k = obj;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f A[PHI: r1
      0x002f: PHI (r1v4 long) = (r1v3 long), (r1v3 long), (r1v6 long) binds: [B:7:0x0013, B:9:0x0019, B:14:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.anythink.basead.exoplayer.ae
    public final com.anythink.basead.exoplayer.ae.b a(int i, com.anythink.basead.exoplayer.ae.b bVar, boolean z, long j) {
        long j2;
        com.anythink.basead.exoplayer.k.a.a(i, 1);
        Object obj = z ? this.k : null;
        long j3 = this.h;
        boolean z2 = this.j;
        if (!z2 || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.f;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 <= j4) {
                    j2 = j3;
                }
            }
            j2 = -9223372036854775807L;
        }
        return bVar.a(obj, this.c, this.d, this.i, z2, j2, this.f, this.g);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final com.anythink.basead.exoplayer.ae.a a(int i, com.anythink.basead.exoplayer.ae.a aVar, boolean z) {
        com.anythink.basead.exoplayer.k.a.a(i, 1);
        return aVar.a(null, z ? b : null, this.e, -this.g);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }
}
