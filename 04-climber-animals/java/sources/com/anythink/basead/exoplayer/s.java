package com.anythink.basead.exoplayer;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
final class s {
    private static final int a = 100;
    private final ae.a b = new ae.a();
    private final ae.b c = new ae.b();
    private long d;
    private ae e;
    private int f;
    private boolean g;
    private q h;
    private q i;
    private q j;
    private int k;
    private Object l;
    private long m;

    public final void a(ae aeVar) {
        this.e = aeVar;
    }

    public final boolean a(int i) {
        this.f = i;
        return i();
    }

    public final boolean a(boolean z) {
        this.g = z;
        return i();
    }

    public final boolean a(com.anythink.basead.exoplayer.h.r rVar) {
        q qVar = this.j;
        return qVar != null && qVar.a == rVar;
    }

    public final void a(long j) {
        q qVar = this.j;
        if (qVar == null || !qVar.f) {
            return;
        }
        qVar.a.a_(j - qVar.e);
    }

    public final boolean a() {
        q qVar = this.j;
        if (qVar != null) {
            return !qVar.h.g && this.j.a() && this.j.h.e != -9223372036854775807L && this.k < 100;
        }
        return true;
    }

    public final r a(long j, u uVar) {
        q qVar = this.j;
        if (qVar != null) {
            return a(qVar, j);
        }
        return a(uVar.c, uVar.e, uVar.d);
    }

    public final com.anythink.basead.exoplayer.h.r a(z[] zVarArr, com.anythink.basead.exoplayer.i.h hVar, com.anythink.basead.exoplayer.j.b bVar, com.anythink.basead.exoplayer.h.s sVar, Object obj, r rVar) {
        long j;
        q qVar = this.j;
        if (qVar == null) {
            j = rVar.b;
        } else {
            j = qVar.e + this.j.h.e;
        }
        q qVar2 = new q(zVarArr, j, hVar, bVar, sVar, obj, rVar);
        if (this.j != null) {
            com.anythink.basead.exoplayer.k.a.b(f());
            this.j.i = qVar2;
        }
        this.l = null;
        this.j = qVar2;
        this.k++;
        return qVar2.a;
    }

    public final q b() {
        return this.j;
    }

    public final q c() {
        return this.h;
    }

    public final q d() {
        return this.i;
    }

    public final q e() {
        return f() ? this.h : this.j;
    }

    public final boolean f() {
        return this.h != null;
    }

    public final q g() {
        q qVar = this.i;
        com.anythink.basead.exoplayer.k.a.b((qVar == null || qVar.i == null) ? false : true);
        q qVar2 = this.i.i;
        this.i = qVar2;
        return qVar2;
    }

    public final q h() {
        q qVar = this.h;
        if (qVar != null) {
            if (qVar == this.i) {
                this.i = qVar.i;
            }
            this.h.c();
            int i = this.k - 1;
            this.k = i;
            if (i == 0) {
                this.j = null;
                this.l = this.h.b;
                this.m = this.h.h.a.d;
            }
            this.h = this.h.i;
        } else {
            q qVar2 = this.j;
            this.h = qVar2;
            this.i = qVar2;
        }
        return this.h;
    }

    public final boolean a(q qVar) {
        boolean z = false;
        com.anythink.basead.exoplayer.k.a.b(qVar != null);
        this.j = qVar;
        while (qVar.i != null) {
            qVar = qVar.i;
            if (qVar == this.i) {
                this.i = this.h;
                z = true;
            }
            qVar.c();
            this.k--;
        }
        this.j.i = null;
        return z;
    }

    public final void b(boolean z) {
        q qVarE = e();
        if (qVarE != null) {
            this.l = z ? qVarE.b : null;
            this.m = qVarE.h.a.d;
            qVarE.c();
            a(qVarE);
        } else if (!z) {
            this.l = null;
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
    }

    public final boolean a(com.anythink.basead.exoplayer.h.s.a aVar, long j) {
        int i = aVar.a;
        q qVar = null;
        int iA = i;
        for (q qVarE = e(); qVarE != null; qVarE = qVarE.i) {
            if (qVar == null) {
                qVarE.h = a(qVarE.h, iA);
            } else {
                if (iA == -1 || !qVarE.b.equals(this.e.a(iA, this.b, true).b)) {
                    return !a(qVar);
                }
                r rVarA = a(qVar, j);
                if (rVarA == null) {
                    return !a(qVar);
                }
                qVarE.h = a(qVarE.h, iA);
                r rVar = qVarE.h;
                if (!(rVar.b == rVarA.b && rVar.c == rVarA.c && rVar.a.equals(rVarA.a))) {
                    return !a(qVar);
                }
            }
            if (qVarE.h.f) {
                iA = this.e.a(iA, this.b, this.c, this.f, this.g);
            }
            qVar = qVarE;
        }
        return true;
    }

    public final r a(r rVar, int i) {
        return a(rVar, rVar.a.a(i));
    }

    private com.anythink.basead.exoplayer.h.s.a a(int i, long j, long j2) {
        this.e.a(i, this.b, false);
        int iA = this.b.a(j);
        if (iA == -1) {
            return new com.anythink.basead.exoplayer.h.s.a(i, j2);
        }
        return new com.anythink.basead.exoplayer.h.s.a(i, iA, this.b.b(iA), j2);
    }

    private long b(int i) {
        int iA;
        Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.c;
        Object obj2 = this.l;
        if (obj2 != null && (iA = this.e.a(obj2)) != -1 && this.e.a(iA, this.b, false).c == i2) {
            return this.m;
        }
        for (q qVarE = e(); qVarE != null; qVarE = qVarE.i) {
            if (qVarE.b.equals(obj)) {
                return qVarE.h.a.d;
            }
        }
        for (q qVarE2 = e(); qVarE2 != null; qVarE2 = qVarE2.i) {
            int iA2 = this.e.a(qVarE2.b);
            if (iA2 != -1 && this.e.a(iA2, this.b, false).c == i2) {
                return qVarE2.h.a.d;
            }
        }
        long j = this.d;
        this.d = 1 + j;
        return j;
    }

    private static boolean a(q qVar, r rVar) {
        r rVar2 = qVar.h;
        return rVar2.b == rVar.b && rVar2.c == rVar.c && rVar2.a.equals(rVar.a);
    }

    private boolean i() {
        q qVarE = e();
        if (qVarE == null) {
            return true;
        }
        while (true) {
            int iA = this.e.a(qVarE.h.a.a, this.b, this.c, this.f, this.g);
            while (qVarE.i != null && !qVarE.h.f) {
                qVarE = qVarE.i;
            }
            if (iA == -1 || qVarE.i == null || qVarE.i.h.a.a != iA) {
                break;
            }
            qVarE = qVarE.i;
        }
        boolean zA = a(qVarE);
        qVarE.h = a(qVarE.h, qVarE.h.a);
        return (zA && f()) ? false : true;
    }

    private r a(u uVar) {
        return a(uVar.c, uVar.e, uVar.d);
    }

    private r a(q qVar, long j) {
        int i;
        long j2;
        long j3;
        r rVar = qVar.h;
        if (rVar.f) {
            int iA = this.e.a(rVar.a.a, this.b, this.c, this.f, this.g);
            if (iA == -1) {
                return null;
            }
            int i2 = this.e.a(iA, this.b, true).c;
            Object obj = this.b.b;
            long j4 = rVar.a.d;
            long j5 = 0;
            if (this.e.a(i2, this.c, false).f == iA) {
                Pair<Integer, Long> pairA = this.e.a(this.c, this.b, i2, -9223372036854775807L, Math.max(0L, (qVar.e + rVar.e) - j));
                if (pairA == null) {
                    return null;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                if (qVar.i != null && qVar.i.b.equals(obj)) {
                    j3 = qVar.i.h.a.d;
                } else {
                    j3 = this.d;
                    this.d = 1 + j3;
                }
                j5 = jLongValue;
                j2 = j3;
                i = iIntValue;
            } else {
                i = iA;
                j2 = j4;
            }
            long j6 = j5;
            return a(a(i, j6, j2), j6, j5);
        }
        com.anythink.basead.exoplayer.h.s.a aVar = rVar.a;
        this.e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            int i3 = aVar.b;
            int iD = this.b.d(i3);
            if (iD == -1) {
                return null;
            }
            int iA2 = this.b.a(i3, aVar.c);
            if (iA2 < iD) {
                if (this.b.b(i3, iA2)) {
                    return a(aVar.a, i3, iA2, rVar.d, aVar.d);
                }
                return null;
            }
            return b(aVar.a, rVar.d, aVar.d);
        }
        if (rVar.c != Long.MIN_VALUE) {
            int iA3 = this.b.a(rVar.c);
            if (iA3 == -1) {
                return b(aVar.a, rVar.c, aVar.d);
            }
            int iB = this.b.b(iA3);
            if (this.b.b(iA3, iB)) {
                return a(aVar.a, iA3, iB, rVar.c, aVar.d);
            }
            return null;
        }
        int iC = this.b.c();
        if (iC == 0) {
            return null;
        }
        int i4 = iC - 1;
        if (this.b.a(i4) != Long.MIN_VALUE || this.b.c(i4)) {
            return null;
        }
        int iB2 = this.b.b(i4);
        if (!this.b.b(i4, iB2)) {
            return null;
        }
        return a(aVar.a, i4, iB2, this.b.d, aVar.d);
    }

    private r a(r rVar, com.anythink.basead.exoplayer.h.s.a aVar) {
        long j;
        long jC;
        long j2 = rVar.b;
        long j3 = rVar.c;
        boolean zB = b(aVar, j3);
        boolean zA = a(aVar, zB);
        this.e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            jC = this.b.c(aVar.b, aVar.c);
        } else {
            if (j3 == Long.MIN_VALUE) {
                jC = this.b.d;
            } else {
                j = j3;
            }
            return new r(aVar, j2, j3, rVar.d, j, zB, zA);
        }
        j = jC;
        return new r(aVar, j2, j3, rVar.d, j, zB, zA);
    }

    private r a(com.anythink.basead.exoplayer.h.s.a aVar, long j, long j2) {
        this.e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            if (this.b.b(aVar.b, aVar.c)) {
                return a(aVar.a, aVar.b, aVar.c, j, aVar.d);
            }
            return null;
        }
        return b(aVar.a, j2, aVar.d);
    }

    private r a(int i, int i2, int i3, long j, long j2) {
        com.anythink.basead.exoplayer.h.s.a aVar = new com.anythink.basead.exoplayer.h.s.a(i, i2, i3, j2);
        boolean zB = b(aVar, Long.MIN_VALUE);
        boolean zA = a(aVar, zB);
        return new r(aVar, i3 == this.b.b(i2) ? this.b.d() : 0L, Long.MIN_VALUE, j, this.e.a(aVar.a, this.b, false).c(aVar.b, aVar.c), zB, zA);
    }

    private r b(int i, long j, long j2) {
        com.anythink.basead.exoplayer.h.s.a aVar = new com.anythink.basead.exoplayer.h.s.a(i, j2);
        this.e.a(aVar.a, this.b, false);
        int iB = this.b.b(j);
        long jA = iB == -1 ? Long.MIN_VALUE : this.b.a(iB);
        boolean zB = b(aVar, jA);
        return new r(aVar, j, jA, -9223372036854775807L, jA == Long.MIN_VALUE ? this.b.d : jA, zB, a(aVar, zB));
    }

    private boolean b(com.anythink.basead.exoplayer.h.s.a aVar, long j) {
        int iC = this.e.a(aVar.a, this.b, false).c();
        if (iC == 0) {
            return true;
        }
        int i = iC - 1;
        boolean zA = aVar.a();
        if (this.b.a(i) != Long.MIN_VALUE) {
            return !zA && j == Long.MIN_VALUE;
        }
        int iD = this.b.d(i);
        if (iD == -1) {
            return false;
        }
        return (zA && aVar.b == i && aVar.c == iD + (-1)) || (!zA && this.b.b(i) == iD);
    }

    private boolean a(com.anythink.basead.exoplayer.h.s.a aVar, boolean z) {
        return !this.e.a(this.e.a(aVar.a, this.b, false).c, this.c, false).e && this.e.b(aVar.a, this.b, this.c, this.f, this.g) && z;
    }

    public final com.anythink.basead.exoplayer.h.s.a a(int i, long j) {
        long j2;
        int iA;
        Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.c;
        Object obj2 = this.l;
        if (obj2 != null && (iA = this.e.a(obj2)) != -1 && this.e.a(iA, this.b, false).c == i2) {
            j2 = this.m;
        } else {
            for (q qVarE = e(); qVarE != null; qVarE = qVarE.i) {
                if (qVarE.b.equals(obj)) {
                    j2 = qVarE.h.a.d;
                }
            }
            for (q qVarE2 = e(); qVarE2 != null; qVarE2 = qVarE2.i) {
                int iA2 = this.e.a(qVarE2.b);
                if (iA2 != -1 && this.e.a(iA2, this.b, false).c == i2) {
                    j2 = qVarE2.h.a.d;
                }
            }
            j2 = this.d;
            this.d = 1 + j2;
        }
        return a(i, j, j2);
    }
}
