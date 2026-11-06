package com.smartdigimkt.v0;

import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements l, k {
    public final l a;
    public k b;
    public a[] c = new a[0];
    public long d = 0;
    public final long e;

    public b(i iVar, long j) {
        this.a = iVar;
        this.e = j;
    }

    @Override // com.smartdigimkt.v0.l
    public final void a(k kVar, long j) {
        this.b = kVar;
        this.a.a(this, j);
    }

    @Override // com.smartdigimkt.v0.l
    public final void b(long j) {
        this.a.b(j);
    }

    @Override // com.smartdigimkt.v0.l
    public final boolean c(long j) {
        return this.a.c(j);
    }

    @Override // com.smartdigimkt.v0.l
    public final void d(long j) {
        this.a.d(j);
    }

    @Override // com.smartdigimkt.v0.l
    public final void e() {
        this.a.e();
    }

    @Override // com.smartdigimkt.v0.l
    public final long b() {
        long jB = this.a.b();
        if (jB != Long.MIN_VALUE) {
            long j = this.e;
            if (j == Long.MIN_VALUE || jB < j) {
                return jB;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.smartdigimkt.v0.l
    public final long c() {
        long j = this.d;
        if (j != -9223372036854775807L) {
            this.d = -9223372036854775807L;
            long jC = c();
            return jC != -9223372036854775807L ? jC : j;
        }
        long jC2 = this.a.c();
        if (jC2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (jC2 < 0) {
            throw new IllegalStateException();
        }
        long j2 = this.e;
        if (j2 == Long.MIN_VALUE || jC2 <= j2) {
            return jC2;
        }
        throw new IllegalStateException();
    }

    @Override // com.smartdigimkt.v0.l
    public final long d() {
        long jD = this.a.d();
        if (jD != Long.MIN_VALUE) {
            long j = this.e;
            if (j == Long.MIN_VALUE || jD < j) {
                return jD;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.smartdigimkt.v0.l
    public final k0 a() {
        return this.a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r3 > r5) goto L18;
     */
    @Override // com.smartdigimkt.v0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.smartdigimkt.x0.h[] r13, boolean[] r14, com.smartdigimkt.v0.f0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.smartdigimkt.v0.a[] r2 = new com.smartdigimkt.v0.a[r2]
            r0.c = r2
            int r2 = r1.length
            com.smartdigimkt.v0.f0[] r2 = new com.smartdigimkt.v0.f0[r2]
            r10 = 0
            r3 = r10
        Lc:
            int r4 = r1.length
            r11 = 0
            if (r3 >= r4) goto L21
            com.smartdigimkt.v0.a[] r4 = r0.c
            r5 = r1[r3]
            com.smartdigimkt.v0.a r5 = (com.smartdigimkt.v0.a) r5
            r4[r3] = r5
            if (r5 == 0) goto L1c
            com.smartdigimkt.v0.f0 r11 = r5.a
        L1c:
            r2[r3] = r11
            int r3 = r3 + 1
            goto Lc
        L21:
            com.smartdigimkt.v0.l r3 = r0.a
            r4 = r13
            r5 = r14
            r6 = r2
            r7 = r16
            r8 = r17
            long r3 = r3.a(r4, r5, r6, r7, r8)
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.d = r5
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 == 0) goto L52
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L4c
            long r5 = r0.e
            r7 = -9223372036854775808
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L52
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L4c
            goto L52
        L4c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L52:
            int r5 = r1.length
            if (r10 >= r5) goto L7c
            r5 = r2[r10]
            if (r5 != 0) goto L5e
            com.smartdigimkt.v0.a[] r5 = r0.c
            r5[r10] = r11
            goto L73
        L5e:
            r6 = r1[r10]
            if (r6 == 0) goto L6a
            com.smartdigimkt.v0.a[] r6 = r0.c
            r6 = r6[r10]
            com.smartdigimkt.v0.f0 r6 = r6.a
            if (r6 == r5) goto L73
        L6a:
            com.smartdigimkt.v0.a[] r6 = r0.c
            com.smartdigimkt.v0.a r7 = new com.smartdigimkt.v0.a
            r7.<init>(r12, r5)
            r6[r10] = r7
        L73:
            com.smartdigimkt.v0.a[] r5 = r0.c
            r5 = r5[r10]
            r1[r10] = r5
            int r10 = r10 + 1
            goto L52
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.v0.b.a(com.smartdigimkt.x0.h[], boolean[], com.smartdigimkt.v0.f0[], boolean[], long):long");
    }

    @Override // com.smartdigimkt.v0.k
    public final void b(l lVar) {
        this.b.b(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.smartdigimkt.v0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.d = r0
            com.smartdigimkt.v0.a[] r0 = r5.c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L17
            r4 = r0[r3]
            if (r4 == 0) goto L14
            r4.b = r2
        L14:
            int r3 = r3 + 1
            goto Lc
        L17:
            com.smartdigimkt.v0.l r0 = r5.a
            long r0 = r0.a(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L3a
            r6 = 0
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L34
            long r6 = r5.e
            r2 = -9223372036854775808
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 == 0) goto L3a
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L34
            goto L3a
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.v0.b.a(long):long");
    }

    @Override // com.smartdigimkt.v0.k
    public final void a(l lVar) {
        this.b.a(this);
    }

    @Override // com.smartdigimkt.v0.l
    public final long a(long j, com.smartdigimkt.i0.g0 g0Var) {
        if (j == 0) {
            return 0L;
        }
        long j2 = g0Var.a;
        int i = com.smartdigimkt.z0.u.a;
        long jMax = Math.max(0L, Math.min(j2, j));
        long j3 = g0Var.b;
        long j4 = this.e;
        long jMax2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? LongCompanionObject.MAX_VALUE : j4 - j));
        if (jMax != g0Var.a || jMax2 != g0Var.b) {
            g0Var = new com.smartdigimkt.i0.g0(jMax, jMax2);
        }
        return this.a.a(j, g0Var);
    }
}
