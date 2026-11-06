package com.anythink.basead.exoplayer.i;

import com.anythink.basead.exoplayer.h.ae;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.m;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    public static final int a = 10000;
    public static final int b = 25000;
    public static final int c = 25000;
    public static final float d = 0.75f;
    public static final float e = 0.75f;
    public static final long f = 2000;
    private final com.anythink.basead.exoplayer.j.d j;
    private final long k;
    private final long l;
    private final long m;
    private final float n;
    private final float o;
    private final long p;
    private final com.anythink.basead.exoplayer.k.c q;
    private float r;
    private int s;
    private int t;
    private long u;

    @Override // com.anythink.basead.exoplayer.i.f
    public final Object d() {
        return null;
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.i.a$a, reason: collision with other inner class name */
    public static final class C0033a implements f.a {
        private final com.anythink.basead.exoplayer.j.d a;
        private final int b;
        private final int c;
        private final int d;
        private final float e;
        private final float f;
        private final long g;
        private final com.anythink.basead.exoplayer.k.c h;

        public C0033a(com.anythink.basead.exoplayer.j.d dVar) {
            this(dVar, 10000, 25000, 25000, 0.75f, com.anythink.basead.exoplayer.k.c.a);
        }

        private C0033a(com.anythink.basead.exoplayer.j.d dVar, int i, int i2, int i3, float f) {
            this(dVar, i, i2, i3, f, com.anythink.basead.exoplayer.k.c.a);
        }

        private C0033a(com.anythink.basead.exoplayer.j.d dVar, int i, int i2, int i3, float f, com.anythink.basead.exoplayer.k.c cVar) {
            this.a = dVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = f;
            this.f = 0.75f;
            this.g = a.f;
            this.h = cVar;
        }

        private a b(ae aeVar, int... iArr) {
            return new a(aeVar, iArr, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        @Override // com.anythink.basead.exoplayer.i.f.a
        public final /* synthetic */ f a(ae aeVar, int[] iArr) {
            return new a(aeVar, iArr, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    private a(ae aeVar, int[] iArr, com.anythink.basead.exoplayer.j.d dVar) {
        this(aeVar, iArr, dVar, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 25000L, 25000L, 0.75f, 0.75f, f, com.anythink.basead.exoplayer.k.c.a);
    }

    public a(ae aeVar, int[] iArr, com.anythink.basead.exoplayer.j.d dVar, long j, long j2, long j3, float f2, float f3, long j4, com.anythink.basead.exoplayer.k.c cVar) {
        super(aeVar, iArr);
        this.j = dVar;
        this.k = j * 1000;
        this.l = j2 * 1000;
        this.m = j3 * 1000;
        this.n = f2;
        this.o = f3;
        this.p = j4;
        this.q = cVar;
        this.r = 1.0f;
        this.t = 1;
        this.u = -9223372036854775807L;
        this.s = a(Long.MIN_VALUE);
    }

    @Override // com.anythink.basead.exoplayer.i.b, com.anythink.basead.exoplayer.i.f
    public final void a() {
        this.u = -9223372036854775807L;
    }

    @Override // com.anythink.basead.exoplayer.i.b, com.anythink.basead.exoplayer.i.f
    public final void a(float f2) {
        this.r = f2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    @Override // com.anythink.basead.exoplayer.i.f
    public final void a(long j, long j2) {
        long j3;
        long jA = this.q.a();
        int i = this.s;
        int iA = a(jA);
        this.s = iA;
        if (iA == i) {
            return;
        }
        if (!b(i, jA)) {
            m mVarA = a(i);
            m mVarA2 = a(this.s);
            if (mVarA2.d > mVarA.d) {
                if (j2 != -9223372036854775807L && j2 <= this.k) {
                    j3 = (long) (j2 * this.o);
                } else {
                    j3 = this.k;
                }
                if (j < j3) {
                    this.s = i;
                } else if (mVarA2.d < mVarA.d) {
                    this.s = i;
                }
            } else if (mVarA2.d < mVarA.d && j >= this.l) {
                this.s = i;
            }
        }
        if (this.s != i) {
            this.t = 3;
        }
    }

    @Override // com.anythink.basead.exoplayer.i.f
    public final int b() {
        return this.s;
    }

    @Override // com.anythink.basead.exoplayer.i.f
    public final int c() {
        return this.t;
    }

    @Override // com.anythink.basead.exoplayer.i.b, com.anythink.basead.exoplayer.i.f
    public final int a(long j, List<? extends com.anythink.basead.exoplayer.h.b.i> list) {
        long jA = this.q.a();
        long j2 = this.u;
        if (j2 != -9223372036854775807L && jA - j2 < this.p) {
            return list.size();
        }
        this.u = jA;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (af.b(list.get(size - 1).g - j, this.r) < this.m) {
            return size;
        }
        m mVarA = a(a(jA));
        for (int i = 0; i < size; i++) {
            com.anythink.basead.exoplayer.h.b.i iVar = list.get(i);
            m mVar = iVar.d;
            if (af.b(iVar.g - j, this.r) >= this.m && mVar.d < mVarA.d && mVar.n != -1 && mVar.n < 720 && mVar.m != -1 && mVar.m < 1280 && mVar.n < mVarA.n) {
                return i;
            }
        }
        return size;
    }

    private int a(long j) {
        long jA = (long) (this.j.a() * this.n);
        int i = 0;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (j == Long.MIN_VALUE || !b(i2, j)) {
                if (Math.round(a(i2).d * this.r) <= jA) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long b(long j) {
        if (j != -9223372036854775807L && j <= this.k) {
            return (long) (j * this.o);
        }
        return this.k;
    }
}
