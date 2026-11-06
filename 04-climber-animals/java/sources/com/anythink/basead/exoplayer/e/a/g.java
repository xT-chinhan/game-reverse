package com.anythink.basead.exoplayer.e.a;

import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.p;
import com.anythink.basead.exoplayer.k.s;
import com.anythink.basead.exoplayer.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.anythink.basead.exoplayer.e.e, com.anythink.basead.exoplayer.e.k {
    public static final int e = 1;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final long j = 262144;
    private static final long k = 10485760;
    private long[][] A;
    private int B;
    private long C;
    private boolean D;
    private final int l;
    private final s m;
    private final s n;
    private final s o;
    private final ArrayDeque<com.anythink.basead.exoplayer.e.a.a.C0023a> p;
    private int q;
    private int r;
    private long s;
    private int t;
    private s u;
    private int v;
    private int w;
    private int x;
    private com.anythink.basead.exoplayer.e.g y;
    private b[] z;
    public static final com.anythink.basead.exoplayer.e.h d = new com.anythink.basead.exoplayer.e.h() { // from class: com.anythink.basead.exoplayer.e.a.g.1
        @Override // com.anythink.basead.exoplayer.e.h
        public final com.anythink.basead.exoplayer.e.e[] a() {
            return new com.anythink.basead.exoplayer.e.e[]{new g()};
        }
    };
    private static final int i = af.f("qt  ");

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface c {
    }

    @Override // com.anythink.basead.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.basead.exoplayer.e.e
    public final void c() {
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        this.l = i2;
        this.o = new s(16);
        this.p = new ArrayDeque<>();
        this.m = new s(p.a);
        this.n = new s(4);
        this.v = -1;
    }

    @Override // com.anythink.basead.exoplayer.e.e
    public final boolean a(com.anythink.basead.exoplayer.e.f fVar) {
        return i.b(fVar);
    }

    @Override // com.anythink.basead.exoplayer.e.e
    public final void a(com.anythink.basead.exoplayer.e.g gVar) {
        this.y = gVar;
    }

    @Override // com.anythink.basead.exoplayer.e.e
    public final void a(long j2, long j3) {
        this.p.clear();
        this.t = 0;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        if (j2 == 0) {
            d();
            return;
        }
        b[] bVarArr = this.z;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                m mVar = bVar.b;
                int iA = mVar.a(j3);
                if (iA == -1) {
                    iA = mVar.b(j3);
                }
                bVar.d = iA;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0226  */
    /* JADX WARN: Code duplicated, block: B:110:0x023b  */
    /* JADX WARN: Code duplicated, block: B:112:0x023f  */
    /* JADX WARN: Code duplicated, block: B:119:0x025f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0273  */
    /* JADX WARN: Code duplicated, block: B:136:0x0290  */
    /* JADX WARN: Code duplicated, block: B:138:0x0293  */
    /* JADX WARN: Code duplicated, block: B:140:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:141:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:143:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:177:0x0302  */
    /* JADX WARN: Code duplicated, block: B:179:0x0305  */
    /* JADX WARN: Code duplicated, block: B:181:0x0309  */
    /* JADX WARN: Code duplicated, block: B:182:0x030b  */
    /* JADX WARN: Code duplicated, block: B:185:0x0318  */
    /* JADX WARN: Code duplicated, block: B:186:0x031a  */
    /* JADX WARN: Code duplicated, block: B:188:0x0338  */
    /* JADX WARN: Code duplicated, block: B:197:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f0  */
    @Override // com.anythink.basead.exoplayer.e.e
    public final int a(com.anythink.basead.exoplayer.e.f fVar, com.anythink.basead.exoplayer.e.j jVar) throws t {
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        long jD;
        int i2;
        boolean z4;
        int i3;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        long jC;
        while (true) {
            int i4 = this.q;
            if (i4 == 0) {
                if (this.t == 0) {
                    z9 = false;
                    if (fVar.a(this.o.a, 0, 8, true)) {
                        this.t = 8;
                        this.o.c(0);
                        this.s = this.o.h();
                        this.r = this.o.i();
                        j2 = this.s;
                        if (j2 == 1) {
                            fVar.b(this.o.a, 8, 8);
                            this.t += 8;
                            this.s = this.o.n();
                        } else if (j2 == 0) {
                            jD = fVar.d();
                            if (jD == -1 && !this.p.isEmpty()) {
                                jD = this.p.peek().aV;
                            }
                            if (jD != -1) {
                                this.s = (jD - fVar.c()) + ((long) this.t);
                            }
                        }
                        if (this.s >= this.t) {
                            throw new t("Atom size less than header length (unsupported).");
                        }
                        i2 = this.r;
                        if (i2 != com.anythink.basead.exoplayer.e.a.a.G || i2 == com.anythink.basead.exoplayer.e.a.a.I || i2 == com.anythink.basead.exoplayer.e.a.a.J || i2 == com.anythink.basead.exoplayer.e.a.a.K || i2 == com.anythink.basead.exoplayer.e.a.a.L || i2 == com.anythink.basead.exoplayer.e.a.a.U) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            jC = (fVar.c() + this.s) - ((long) this.t);
                            this.p.push(new com.anythink.basead.exoplayer.e.a.a.C0023a(this.r, jC));
                            if (this.s == this.t) {
                                b(jC);
                            } else {
                                d();
                            }
                            z6 = true;
                        } else {
                            i3 = this.r;
                            if (i3 != com.anythink.basead.exoplayer.e.a.a.W || i3 == com.anythink.basead.exoplayer.e.a.a.H || i3 == com.anythink.basead.exoplayer.e.a.a.X || i3 == com.anythink.basead.exoplayer.e.a.a.Y || i3 == com.anythink.basead.exoplayer.e.a.a.ar || i3 == com.anythink.basead.exoplayer.e.a.a.as || i3 == com.anythink.basead.exoplayer.e.a.a.at || i3 == com.anythink.basead.exoplayer.e.a.a.V || i3 == com.anythink.basead.exoplayer.e.a.a.au || i3 == com.anythink.basead.exoplayer.e.a.a.av || i3 == com.anythink.basead.exoplayer.e.a.a.aw || i3 == com.anythink.basead.exoplayer.e.a.a.ax || i3 == com.anythink.basead.exoplayer.e.a.a.ay || i3 == com.anythink.basead.exoplayer.e.a.a.T || i3 == com.anythink.basead.exoplayer.e.a.a.f || i3 == com.anythink.basead.exoplayer.e.a.a.aF) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                if (this.t == 8) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                com.anythink.basead.exoplayer.k.a.b(z7);
                                if (this.s <= 2147483647L) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                com.anythink.basead.exoplayer.k.a.b(z8);
                                this.u = new s((int) this.s);
                                System.arraycopy(this.o.a, 0, this.u.a, 0, 8);
                                z6 = true;
                                this.q = 1;
                            } else {
                                z6 = true;
                                this.u = null;
                                this.q = 1;
                            }
                        }
                        z9 = z6;
                    }
                } else {
                    j2 = this.s;
                    if (j2 == 1) {
                        fVar.b(this.o.a, 8, 8);
                        this.t += 8;
                        this.s = this.o.n();
                    } else if (j2 == 0) {
                        jD = fVar.d();
                        if (jD == -1) {
                            jD = this.p.peek().aV;
                        }
                        if (jD != -1) {
                            this.s = (jD - fVar.c()) + ((long) this.t);
                        }
                    }
                    if (this.s >= this.t) {
                        throw new t("Atom size less than header length (unsupported).");
                    }
                    i2 = this.r;
                    if (i2 != com.anythink.basead.exoplayer.e.a.a.G) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        jC = (fVar.c() + this.s) - ((long) this.t);
                        this.p.push(new com.anythink.basead.exoplayer.e.a.a.C0023a(this.r, jC));
                        if (this.s == this.t) {
                            b(jC);
                        } else {
                            d();
                        }
                        z6 = true;
                    } else {
                        i3 = this.r;
                        if (i3 != com.anythink.basead.exoplayer.e.a.a.W) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (z5) {
                            if (this.t == 8) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            com.anythink.basead.exoplayer.k.a.b(z7);
                            if (this.s <= 2147483647L) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            com.anythink.basead.exoplayer.k.a.b(z8);
                            this.u = new s((int) this.s);
                            System.arraycopy(this.o.a, 0, this.u.a, 0, 8);
                            z6 = true;
                            this.q = 1;
                        } else {
                            z6 = true;
                            this.u = null;
                            this.q = 1;
                        }
                    }
                    z9 = z6;
                }
                if (!z9) {
                    return -1;
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException();
                    }
                    long jC2 = fVar.c();
                    if (this.v == -1) {
                        int i5 = -1;
                        int i6 = -1;
                        boolean z10 = true;
                        boolean z11 = true;
                        long j3 = Long.MAX_VALUE;
                        long j4 = Long.MAX_VALUE;
                        long j5 = Long.MAX_VALUE;
                        int i7 = 0;
                        while (true) {
                            b[] bVarArr = this.z;
                            if (i7 >= bVarArr.length) {
                                break;
                            }
                            b bVar = bVarArr[i7];
                            int i8 = bVar.d;
                            if (i8 != bVar.b.b) {
                                long j6 = bVar.b.c[i8];
                                long j7 = this.A[i7][i8];
                                long j8 = j6 - jC2;
                                boolean z12 = j8 < 0 || j8 >= j;
                                if ((!z12 && z11) || (z12 == z11 && j8 < j5)) {
                                    i6 = i7;
                                    z11 = z12;
                                    j5 = j8;
                                    j4 = j7;
                                }
                                if (j7 < j3) {
                                    i5 = i7;
                                    z10 = z12;
                                    j3 = j7;
                                }
                            }
                            i7++;
                        }
                        int i9 = (j3 == Long.MAX_VALUE || !z10 || j4 < j3 + k) ? i6 : i5;
                        this.v = i9;
                        if (i9 == -1) {
                            return -1;
                        }
                    }
                    b bVar2 = this.z[this.v];
                    com.anythink.basead.exoplayer.e.m mVar = bVar2.c;
                    int i10 = bVar2.d;
                    long j9 = bVar2.b.c[i10];
                    int i11 = bVar2.b.d[i10];
                    long j10 = (j9 - jC2) + ((long) this.w);
                    if (j10 < 0 || j10 >= j) {
                        jVar.a = j9;
                        return 1;
                    }
                    if (bVar2.a.i == 1) {
                        j10 += 8;
                        i11 -= 8;
                    }
                    fVar.c((int) j10);
                    if (bVar2.a.l == 0) {
                        while (true) {
                            int i12 = this.w;
                            if (i12 >= i11) {
                                break;
                            }
                            int iA = mVar.a(fVar, i11 - i12, false);
                            this.w += iA;
                            this.x -= iA;
                        }
                    } else {
                        byte[] bArr = this.n.a;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i13 = bVar2.a.l;
                        int i14 = 4 - bVar2.a.l;
                        while (this.w < i11) {
                            int i15 = this.x;
                            if (i15 == 0) {
                                fVar.b(this.n.a, i14, i13);
                                this.n.c(0);
                                this.x = this.n.m();
                                this.m.c(0);
                                mVar.a(this.m, 4);
                                this.w += 4;
                                i11 += i14;
                            } else {
                                int iA2 = mVar.a(fVar, i15, false);
                                this.w += iA2;
                                this.x -= iA2;
                            }
                        }
                    }
                    mVar.a(bVar2.b.f[i10], bVar2.b.g[i10], i11, 0, null);
                    bVar2.d++;
                    this.v = -1;
                    this.w = 0;
                    this.x = 0;
                    return 0;
                }
                long j11 = this.s - ((long) this.t);
                long jC3 = fVar.c() + j11;
                s sVar = this.u;
                if (sVar != null) {
                    fVar.b(sVar.a, this.t, (int) j11);
                    if (this.r == com.anythink.basead.exoplayer.e.a.a.f) {
                        s sVar2 = this.u;
                        sVar2.c(8);
                        if (sVar2.i() != i) {
                            sVar2.d(4);
                            while (true) {
                                if (sVar2.a() <= 0) {
                                    z3 = false;
                                    break;
                                }
                                if (sVar2.i() == i) {
                                    z3 = true;
                                    break;
                                }
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                        this.D = z3;
                    } else if (!this.p.isEmpty()) {
                        this.p.peek().a(new com.anythink.basead.exoplayer.e.a.a.b(this.r, this.u));
                    }
                } else {
                    if (j11 < j) {
                        fVar.c((int) j11);
                    } else {
                        jVar.a = fVar.c() + j11;
                        z = true;
                    }
                    b(jC3);
                    if (z || this.q == 2) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        return 1;
                    }
                }
                z = false;
                b(jC3);
                if (z) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return 1;
                }
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.e.k
    public final long b() {
        return this.C;
    }

    @Override // com.anythink.basead.exoplayer.e.k
    public final com.anythink.basead.exoplayer.e.k.a a(long j2) {
        long j3;
        long j4;
        int iB;
        b[] bVarArr = this.z;
        if (bVarArr.length == 0) {
            return new com.anythink.basead.exoplayer.e.k.a(com.anythink.basead.exoplayer.e.l.a);
        }
        int i2 = this.B;
        long jA = -1;
        if (i2 != -1) {
            m mVar = bVarArr[i2].b;
            int iA = a(mVar, j2);
            if (iA == -1) {
                return new com.anythink.basead.exoplayer.e.k.a(com.anythink.basead.exoplayer.e.l.a);
            }
            long j5 = mVar.f[iA];
            j3 = mVar.c[iA];
            if (j5 >= j2 || iA >= mVar.b - 1 || (iB = mVar.b(j2)) == -1 || iB == iA) {
                j4 = -9223372036854775807L;
            } else {
                j4 = mVar.f[iB];
                jA = mVar.c[iB];
            }
            j2 = j5;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            b[] bVarArr2 = this.z;
            if (i3 >= bVarArr2.length) {
                break;
            }
            if (i3 != this.B) {
                m mVar2 = bVarArr2[i3].b;
                long jA2 = a(mVar2, j2, j3);
                if (j4 != -9223372036854775807L) {
                    jA = a(mVar2, j4, jA);
                }
                j3 = jA2;
            }
            i3++;
        }
        com.anythink.basead.exoplayer.e.l lVar = new com.anythink.basead.exoplayer.e.l(j2, j3);
        if (j4 == -9223372036854775807L) {
            return new com.anythink.basead.exoplayer.e.k.a(lVar);
        }
        return new com.anythink.basead.exoplayer.e.k.a(lVar, new com.anythink.basead.exoplayer.e.l(j4, jA));
    }

    private void d() {
        this.q = 0;
        this.t = 0;
    }

    private boolean b(com.anythink.basead.exoplayer.e.f fVar) throws t {
        if (this.t == 0) {
            if (!fVar.a(this.o.a, 0, 8, true)) {
                return false;
            }
            this.t = 8;
            this.o.c(0);
            this.s = this.o.h();
            this.r = this.o.i();
        }
        long j2 = this.s;
        if (j2 == 1) {
            fVar.b(this.o.a, 8, 8);
            this.t += 8;
            this.s = this.o.n();
        } else if (j2 == 0) {
            long jD = fVar.d();
            if (jD == -1 && !this.p.isEmpty()) {
                jD = this.p.peek().aV;
            }
            if (jD != -1) {
                this.s = (jD - fVar.c()) + ((long) this.t);
            }
        }
        if (this.s < this.t) {
            throw new t("Atom size less than header length (unsupported).");
        }
        int i2 = this.r;
        if (i2 == com.anythink.basead.exoplayer.e.a.a.G || i2 == com.anythink.basead.exoplayer.e.a.a.I || i2 == com.anythink.basead.exoplayer.e.a.a.J || i2 == com.anythink.basead.exoplayer.e.a.a.K || i2 == com.anythink.basead.exoplayer.e.a.a.L || i2 == com.anythink.basead.exoplayer.e.a.a.U) {
            long jC = (fVar.c() + this.s) - ((long) this.t);
            this.p.push(new com.anythink.basead.exoplayer.e.a.a.C0023a(this.r, jC));
            if (this.s == this.t) {
                b(jC);
            } else {
                d();
            }
        } else {
            int i3 = this.r;
            if (i3 == com.anythink.basead.exoplayer.e.a.a.W || i3 == com.anythink.basead.exoplayer.e.a.a.H || i3 == com.anythink.basead.exoplayer.e.a.a.X || i3 == com.anythink.basead.exoplayer.e.a.a.Y || i3 == com.anythink.basead.exoplayer.e.a.a.ar || i3 == com.anythink.basead.exoplayer.e.a.a.as || i3 == com.anythink.basead.exoplayer.e.a.a.at || i3 == com.anythink.basead.exoplayer.e.a.a.V || i3 == com.anythink.basead.exoplayer.e.a.a.au || i3 == com.anythink.basead.exoplayer.e.a.a.av || i3 == com.anythink.basead.exoplayer.e.a.a.aw || i3 == com.anythink.basead.exoplayer.e.a.a.ax || i3 == com.anythink.basead.exoplayer.e.a.a.ay || i3 == com.anythink.basead.exoplayer.e.a.a.T || i3 == com.anythink.basead.exoplayer.e.a.a.f || i3 == com.anythink.basead.exoplayer.e.a.a.aF) {
                com.anythink.basead.exoplayer.k.a.b(this.t == 8);
                com.anythink.basead.exoplayer.k.a.b(this.s <= 2147483647L);
                this.u = new s((int) this.s);
                System.arraycopy(this.o.a, 0, this.u.a, 0, 8);
                this.q = 1;
            } else {
                this.u = null;
                this.q = 1;
            }
        }
        return true;
    }

    private boolean b(com.anythink.basead.exoplayer.e.f fVar, com.anythink.basead.exoplayer.e.j jVar) throws t {
        boolean z;
        boolean z2;
        long j2 = this.s - ((long) this.t);
        long jC = fVar.c() + j2;
        s sVar = this.u;
        if (sVar != null) {
            fVar.b(sVar.a, this.t, (int) j2);
            if (this.r == com.anythink.basead.exoplayer.e.a.a.f) {
                s sVar2 = this.u;
                sVar2.c(8);
                if (sVar2.i() != i) {
                    sVar2.d(4);
                    while (true) {
                        if (sVar2.a() <= 0) {
                            z2 = false;
                            break;
                        }
                        if (sVar2.i() == i) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = true;
                    break;
                }
                this.D = z2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(new com.anythink.basead.exoplayer.e.a.a.b(this.r, this.u));
            }
        } else {
            if (j2 < j) {
                fVar.c((int) j2);
            } else {
                jVar.a = fVar.c() + j2;
                z = true;
            }
            b(jC);
            return (z || this.q == 2) ? false : true;
        }
        z = false;
        b(jC);
        if (z) {
        }
    }

    private void b(long j2) throws t {
        while (!this.p.isEmpty() && this.p.peek().aV == j2) {
            com.anythink.basead.exoplayer.e.a.a.C0023a c0023aPop = this.p.pop();
            if (c0023aPop.aU == com.anythink.basead.exoplayer.e.a.a.G) {
                a(c0023aPop);
                this.p.clear();
                this.q = 2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(c0023aPop);
            }
        }
        if (this.q != 2) {
            d();
        }
    }

    private void a(com.anythink.basead.exoplayer.e.a.a.C0023a c0023a) throws t {
        com.anythink.basead.exoplayer.g.a aVarA;
        ArrayList<m> arrayListA;
        ArrayList arrayList = new ArrayList();
        com.anythink.basead.exoplayer.e.i iVar = new com.anythink.basead.exoplayer.e.i();
        com.anythink.basead.exoplayer.e.a.a.b bVarD = c0023a.d(com.anythink.basead.exoplayer.e.a.a.aF);
        if (bVarD != null) {
            aVarA = com.anythink.basead.exoplayer.e.a.b.a(bVarD, this.D);
            if (aVarA != null) {
                iVar.a(aVarA);
            }
        } else {
            aVarA = null;
        }
        int i2 = 1;
        int i3 = 0;
        try {
            arrayListA = a(c0023a, iVar, (this.l & 1) != 0);
        } catch (com.anythink.basead.exoplayer.e.a.b.g unused) {
            iVar = new com.anythink.basead.exoplayer.e.i();
            arrayListA = a(c0023a, iVar, true);
        }
        int size = arrayListA.size();
        int size2 = -1;
        long jMax = -9223372036854775807L;
        while (i3 < size) {
            m mVar = arrayListA.get(i3);
            j jVar = mVar.a;
            b bVar = new b(jVar, mVar, this.y.a(i3, jVar.d));
            com.anythink.basead.exoplayer.m mVarA = jVar.h.a(mVar.e + 30);
            if (jVar.d == i2) {
                if (iVar.a()) {
                    mVarA = mVarA.a(iVar.b, iVar.c);
                }
                if (aVarA != null) {
                    mVarA = mVarA.a(aVarA);
                }
            }
            bVar.c.a(mVarA);
            jMax = Math.max(jMax, jVar.g != -9223372036854775807L ? jVar.g : mVar.h);
            if (jVar.d == 2 && size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(bVar);
            i3++;
            i2 = 1;
        }
        this.B = size2;
        this.C = jMax;
        b[] bVarArr = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.z = bVarArr;
        this.A = a(bVarArr);
        this.y.c_();
        this.y.a(this);
    }

    private ArrayList<m> a(com.anythink.basead.exoplayer.e.a.a.C0023a c0023a, com.anythink.basead.exoplayer.e.i iVar, boolean z) throws t {
        j jVarA;
        ArrayList<m> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < c0023a.aX.size(); i2++) {
            com.anythink.basead.exoplayer.e.a.a.C0023a c0023a2 = c0023a.aX.get(i2);
            if (c0023a2.aU == com.anythink.basead.exoplayer.e.a.a.I && (jVarA = com.anythink.basead.exoplayer.e.a.b.a(c0023a2, c0023a.d(com.anythink.basead.exoplayer.e.a.a.H), -9223372036854775807L, (com.anythink.basead.exoplayer.d.e) null, z, this.D)) != null) {
                m mVarA = com.anythink.basead.exoplayer.e.a.b.a(jVarA, c0023a2.e(com.anythink.basead.exoplayer.e.a.a.J).e(com.anythink.basead.exoplayer.e.a.a.K).e(com.anythink.basead.exoplayer.e.a.a.L), iVar);
                if (mVarA.b != 0) {
                    arrayList.add(mVarA);
                }
            }
        }
        return arrayList;
    }

    private int c(com.anythink.basead.exoplayer.e.f fVar, com.anythink.basead.exoplayer.e.j jVar) {
        long jC = fVar.c();
        if (this.v == -1) {
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            boolean z = true;
            long j2 = Long.MAX_VALUE;
            boolean z2 = true;
            long j3 = Long.MAX_VALUE;
            long j4 = Long.MAX_VALUE;
            while (true) {
                b[] bVarArr = this.z;
                if (i4 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i4];
                int i5 = bVar.d;
                if (i5 != bVar.b.b) {
                    long j5 = bVar.b.c[i5];
                    long j6 = this.A[i4][i5];
                    long j7 = j5 - jC;
                    boolean z3 = j7 < 0 || j7 >= j;
                    if ((!z3 && z) || (z3 == z && j7 < j4)) {
                        i3 = i4;
                        z = z3;
                        j4 = j7;
                        j3 = j6;
                    }
                    if (j6 < j2) {
                        i2 = i4;
                        z2 = z3;
                        j2 = j6;
                    }
                }
                i4++;
            }
            int i6 = (j2 == Long.MAX_VALUE || !z2 || j3 < j2 + k) ? i3 : i2;
            this.v = i6;
            if (i6 == -1) {
                return -1;
            }
        }
        b bVar2 = this.z[this.v];
        com.anythink.basead.exoplayer.e.m mVar = bVar2.c;
        int i7 = bVar2.d;
        long j8 = bVar2.b.c[i7];
        int i8 = bVar2.b.d[i7];
        long j9 = (j8 - jC) + ((long) this.w);
        if (j9 < 0 || j9 >= j) {
            int i9 = 1;
            jVar.a = j8;
            return i9;
        }
        if (bVar2.a.i == 1) {
            j9 += 8;
            i8 -= 8;
        }
        fVar.c((int) j9);
        if (bVar2.a.l == 0) {
            while (true) {
                int i10 = this.w;
                if (i10 >= i8) {
                    break;
                }
                int iA = mVar.a(fVar, i8 - i10, false);
                this.w += iA;
                this.x -= iA;
            }
        } else {
            byte[] bArr = this.n.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i11 = bVar2.a.l;
            int i12 = 4 - bVar2.a.l;
            while (this.w < i8) {
                int i13 = this.x;
                if (i13 == 0) {
                    fVar.b(this.n.a, i12, i11);
                    this.n.c(0);
                    this.x = this.n.m();
                    this.m.c(0);
                    mVar.a(this.m, 4);
                    this.w += 4;
                    i8 += i12;
                } else {
                    int iA2 = mVar.a(fVar, i13, false);
                    this.w += iA2;
                    this.x -= iA2;
                }
            }
        }
        mVar.a(bVar2.b.f[i7], bVar2.b.g[i7], i8, 0, null);
        bVar2.d++;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        return 0;
    }

    private int c(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z = true;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            b[] bVarArr = this.z;
            if (i4 >= bVarArr.length) {
                break;
            }
            b bVar = bVarArr[i4];
            int i5 = bVar.d;
            if (i5 != bVar.b.b) {
                long j6 = bVar.b.c[i5];
                long j7 = this.A[i4][i5];
                long j8 = j6 - j2;
                boolean z3 = j8 < 0 || j8 >= j;
                if ((!z3 && z2) || (z3 == z2 && j8 < j5)) {
                    z2 = z3;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z = z3;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z || j4 < j3 + k) ? i3 : i2;
    }

    private void d(long j2) {
        for (b bVar : this.z) {
            m mVar = bVar.b;
            int iA = mVar.a(j2);
            if (iA == -1) {
                iA = mVar.b(j2);
            }
            bVar.d = iA;
        }
    }

    private static long[][] a(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            jArr[i2] = new long[bVarArr[i2].b.b];
            jArr2[i2] = bVarArr[i2].b.f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < bVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < bVarArr.length; i5++) {
                if (!zArr[i5]) {
                    long j4 = jArr2[i5];
                    if (j4 <= j3) {
                        i4 = i5;
                        j3 = j4;
                    }
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += (long) bVarArr[i4].b.d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = bVarArr[i4].b.f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private static long a(m mVar, long j2, long j3) {
        int iA = a(mVar, j2);
        return iA == -1 ? j3 : Math.min(mVar.c[iA], j3);
    }

    private static int a(m mVar, long j2) {
        int iA = mVar.a(j2);
        return iA == -1 ? mVar.b(j2) : iA;
    }

    private static boolean a(s sVar) {
        sVar.c(8);
        if (sVar.i() == i) {
            return true;
        }
        sVar.d(4);
        while (sVar.a() > 0) {
            if (sVar.i() == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.basead.exoplayer.e.a.a.W || i2 == com.anythink.basead.exoplayer.e.a.a.H || i2 == com.anythink.basead.exoplayer.e.a.a.X || i2 == com.anythink.basead.exoplayer.e.a.a.Y || i2 == com.anythink.basead.exoplayer.e.a.a.ar || i2 == com.anythink.basead.exoplayer.e.a.a.as || i2 == com.anythink.basead.exoplayer.e.a.a.at || i2 == com.anythink.basead.exoplayer.e.a.a.V || i2 == com.anythink.basead.exoplayer.e.a.a.au || i2 == com.anythink.basead.exoplayer.e.a.a.av || i2 == com.anythink.basead.exoplayer.e.a.a.aw || i2 == com.anythink.basead.exoplayer.e.a.a.ax || i2 == com.anythink.basead.exoplayer.e.a.a.ay || i2 == com.anythink.basead.exoplayer.e.a.a.T || i2 == com.anythink.basead.exoplayer.e.a.a.f || i2 == com.anythink.basead.exoplayer.e.a.a.aF;
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.basead.exoplayer.e.a.a.G || i2 == com.anythink.basead.exoplayer.e.a.a.I || i2 == com.anythink.basead.exoplayer.e.a.a.J || i2 == com.anythink.basead.exoplayer.e.a.a.K || i2 == com.anythink.basead.exoplayer.e.a.a.L || i2 == com.anythink.basead.exoplayer.e.a.a.U;
    }

    private static final class b {
        public final j a;
        public final m b;
        public final com.anythink.basead.exoplayer.e.m c;
        public int d;

        public b(j jVar, m mVar, com.anythink.basead.exoplayer.e.m mVar2) {
            this.a = jVar;
            this.b = mVar;
            this.c = mVar2;
        }
    }
}
