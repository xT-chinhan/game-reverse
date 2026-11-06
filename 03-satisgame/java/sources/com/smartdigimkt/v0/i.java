package com.smartdigimkt.v0;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements l, com.smartdigimkt.n0.f, com.smartdigimkt.y0.v, com.smartdigimkt.y0.x, d0 {
    public boolean[] B;
    public boolean[] C;
    public boolean[] D;
    public boolean E;
    public long G;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public final Uri a;
    public final com.smartdigimkt.y0.i b;
    public final int c;
    public final x d;
    public final j e;
    public final com.smartdigimkt.y0.b f;
    public final String g;
    public final long h;
    public final g j;
    public k o;
    public com.smartdigimkt.n0.l p;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public k0 z;
    public final com.smartdigimkt.y0.a0 i = new com.smartdigimkt.y0.a0();
    public final com.smartdigimkt.z0.e k = new com.smartdigimkt.z0.e();
    public final d l = new d(this);
    public final e m = new e(this);
    public final Handler n = new Handler();
    public int[] r = new int[0];
    public e0[] q = new e0[0];
    public long H = -9223372036854775807L;
    public long F = -1;
    public long A = -9223372036854775807L;

    public i(Uri uri, com.smartdigimkt.y0.i iVar, com.smartdigimkt.n0.e[] eVarArr, int i, x xVar, j jVar, com.smartdigimkt.y0.l lVar, String str, int i2) {
        this.a = uri;
        this.b = iVar;
        this.c = i;
        this.d = xVar;
        this.e = jVar;
        this.f = lVar;
        this.g = str;
        this.h = i2;
        this.j = new g(eVarArr, this);
        this.u = i == -1 ? 3 : i;
        if (xVar.b == null) {
            throw new IllegalStateException();
        }
        for (w wVar : xVar.c) {
            x.a(wVar.a, new o(xVar, wVar.b));
        }
    }

    @Override // com.smartdigimkt.v0.l
    public final void a(k kVar, long j) {
        this.o = kVar;
        com.smartdigimkt.z0.e eVar = this.k;
        synchronized (eVar) {
            if (!eVar.a) {
                eVar.a = true;
                eVar.notifyAll();
            }
        }
        g();
    }

    @Override // com.smartdigimkt.v0.l
    public final void b(long j) {
        long jA;
        int i;
        int length = this.q.length;
        for (int i2 = 0; i2 < length; i2++) {
            e0 e0Var = this.q[i2];
            boolean z = this.B[i2];
            b0 b0Var = e0Var.c;
            synchronized (b0Var) {
                int i3 = b0Var.i;
                jA = -1;
                if (i3 != 0) {
                    long[] jArr = b0Var.f;
                    int i4 = b0Var.k;
                    if (j >= jArr[i4]) {
                        int iA = b0Var.a(i4, (!z || (i = b0Var.l) == i3) ? i3 : i + 1, j, false);
                        if (iA != -1) {
                            jA = b0Var.a(iA);
                        }
                    }
                }
            }
            e0Var.a(jA);
        }
    }

    @Override // com.smartdigimkt.v0.l
    public final boolean c(long j) {
        boolean z = false;
        if (this.K || this.I || (this.t && this.y == 0)) {
            return false;
        }
        com.smartdigimkt.z0.e eVar = this.k;
        synchronized (eVar) {
            if (!eVar.a) {
                eVar.a = true;
                eVar.notifyAll();
                z = true;
            }
        }
        if (this.i.b != null) {
            return z;
        }
        g();
        return true;
    }

    @Override // com.smartdigimkt.v0.l
    public final void d(long j) {
    }

    @Override // com.smartdigimkt.v0.l
    public final void e() throws IOException {
        com.smartdigimkt.y0.a0 a0Var = this.i;
        int i = this.u;
        IOException iOException = a0Var.c;
        if (iOException != null) {
            throw iOException;
        }
        com.smartdigimkt.y0.w wVar = a0Var.b;
        if (wVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = wVar.a;
            }
            IOException iOException2 = wVar.e;
            if (iOException2 != null && wVar.f > i) {
                throw iOException2;
            }
        }
    }

    public final int f() {
        int i = 0;
        for (e0 e0Var : this.q) {
            b0 b0Var = e0Var.c;
            i += b0Var.j + b0Var.i;
        }
        return i;
    }

    public final void g() {
        f fVar = new f(this, this.a, this.b, this.j, this.k);
        if (this.t) {
            long j = this.H;
            if (j == -9223372036854775807L) {
                throw new IllegalStateException();
            }
            long j2 = this.A;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.K = true;
                this.H = -9223372036854775807L;
                return;
            }
            long j3 = this.p.a(j).a.b;
            long j4 = this.H;
            fVar.e.a = j3;
            fVar.h = j4;
            fVar.g = true;
            this.H = -9223372036854775807L;
        }
        this.J = f();
        com.smartdigimkt.y0.a0 a0Var = this.i;
        int i = this.u;
        a0Var.getClass();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        a0Var.c = null;
        com.smartdigimkt.y0.w wVar = new com.smartdigimkt.y0.w(a0Var, looperMyLooper, fVar, this, i, SystemClock.elapsedRealtime());
        if (a0Var.b != null) {
            throw new IllegalStateException();
        }
        a0Var.b = wVar;
        wVar.e = null;
        a0Var.a.execute(wVar);
        x xVar = this.d;
        long j5 = fVar.h;
        long j6 = this.A;
        y yVar = new y();
        xVar.a(j5);
        xVar.a(j6);
        z zVar = new z();
        for (w wVar2 : xVar.c) {
            x.a(wVar2.a, new q(xVar, wVar2.b, yVar, zVar));
        }
    }

    @Override // com.smartdigimkt.v0.l
    public final long d() {
        long jMin;
        if (this.K) {
            return Long.MIN_VALUE;
        }
        long j = this.H;
        if (j != -9223372036854775807L) {
            return j;
        }
        int i = 0;
        if (this.E) {
            int length = this.q.length;
            jMin = LongCompanionObject.MAX_VALUE;
            while (i < length) {
                if (this.C[i]) {
                    jMin = Math.min(jMin, this.q[i].b());
                }
                i++;
            }
        } else {
            e0[] e0VarArr = this.q;
            int length2 = e0VarArr.length;
            long jMax = Long.MIN_VALUE;
            while (i < length2) {
                jMax = Math.max(jMax, e0VarArr[i].b());
                i++;
            }
            jMin = jMax;
        }
        return jMin == Long.MIN_VALUE ? this.G : jMin;
    }

    @Override // com.smartdigimkt.v0.l
    public final k0 a() {
        return this.z;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    @Override // com.smartdigimkt.v0.l
    public final long a(com.smartdigimkt.x0.h[] hVarArr, boolean[] zArr, f0[] f0VarArr, boolean[] zArr2, long j) {
        com.smartdigimkt.x0.h hVar;
        if (this.t) {
            int i = this.y;
            int i2 = 0;
            for (int i3 = 0; i3 < hVarArr.length; i3++) {
                f0 f0Var = f0VarArr[i3];
                if (f0Var != null && (hVarArr[i3] == null || !zArr[i3])) {
                    int i4 = ((h) f0Var).a;
                    boolean[] zArr3 = this.B;
                    if (zArr3[i4]) {
                        this.y--;
                        zArr3[i4] = false;
                        f0VarArr[i3] = null;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            boolean z = !this.v ? j == 0 : i != 0;
            for (int i5 = 0; i5 < hVarArr.length; i5++) {
                if (f0VarArr[i5] == null && (hVar = hVarArr[i5]) != null) {
                    int[] iArr = hVar.b;
                    if (iArr.length == 1) {
                        if (iArr[0] == 0) {
                            k0 k0Var = this.z;
                            i0 i0Var = hVar.a;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= k0Var.a) {
                                    i6 = -1;
                                    break;
                                }
                                if (k0Var.b[i6] == i0Var) {
                                    break;
                                }
                                i6++;
                            }
                            boolean[] zArr4 = this.B;
                            if (!zArr4[i6]) {
                                this.y++;
                                zArr4[i6] = true;
                                f0VarArr[i5] = new h(this, i6);
                                zArr2[i5] = true;
                                if (z) {
                                    continue;
                                } else {
                                    e0 e0Var = this.q[i6];
                                    b0 b0Var = e0Var.c;
                                    synchronized (b0Var) {
                                        b0Var.l = 0;
                                    }
                                    e0Var.g = e0Var.f;
                                    if (e0Var.a(j, true) == -1) {
                                        b0 b0Var2 = e0Var.c;
                                        if (b0Var2.j + b0Var2.l != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            if (this.y == 0) {
                this.I = false;
                this.w = false;
                if (this.i.b != null) {
                    for (e0 e0Var2 : this.q) {
                        e0Var2.a();
                    }
                    this.i.b.a(false);
                } else {
                    e0[] e0VarArr = this.q;
                    int length = e0VarArr.length;
                    while (i2 < length) {
                        e0VarArr[i2].d();
                        i2++;
                    }
                }
            } else if (z) {
                j = a(j);
                while (i2 < f0VarArr.length) {
                    if (f0VarArr[i2] != null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
            this.v = true;
            return j;
        }
        throw new IllegalStateException();
    }

    @Override // com.smartdigimkt.v0.l
    public final long c() {
        if (!this.x) {
            x xVar = this.d;
            if (xVar.b != null) {
                for (w wVar : xVar.c) {
                    x.a(wVar.a, new u(xVar, wVar.b));
                }
                this.x = true;
            } else {
                throw new IllegalStateException();
            }
        }
        if (!this.w) {
            return -9223372036854775807L;
        }
        if (!this.K && f() <= this.J) {
            return -9223372036854775807L;
        }
        this.w = false;
        return this.G;
    }

    @Override // com.smartdigimkt.v0.l
    public final long b() {
        if (this.y == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final void b(int i) {
        if (this.I && this.C[i] && !this.q[i].c.a()) {
            this.H = 0L;
            this.I = false;
            this.w = true;
            this.G = 0L;
            this.J = 0;
            for (e0 e0Var : this.q) {
                e0Var.d();
            }
            this.o.a(this);
        }
    }

    public final e0 c(int i) {
        int length = this.q.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.r[i2] == i) {
                return this.q[i2];
            }
        }
        e0 e0Var = new e0(this.f);
        e0Var.k = this;
        int i3 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.r, i3);
        this.r = iArrCopyOf;
        iArrCopyOf[length] = i;
        e0[] e0VarArr = (e0[]) Arrays.copyOf(this.q, i3);
        this.q = e0VarArr;
        e0VarArr[length] = e0Var;
        return e0Var;
    }

    @Override // com.smartdigimkt.v0.l
    public final long a(long j) {
        if (!this.p.a()) {
            j = 0;
        }
        this.G = j;
        this.w = false;
        if (this.H == -9223372036854775807L) {
            int length = this.q.length;
            for (int i = 0; i < length; i++) {
                e0 e0Var = this.q[i];
                b0 b0Var = e0Var.c;
                synchronized (b0Var) {
                    b0Var.l = 0;
                }
                e0Var.g = e0Var.f;
                if (e0Var.a(j, false) != -1 || (!this.C[i] && this.E)) {
                }
            }
            return j;
        }
        this.I = false;
        this.H = j;
        this.K = false;
        com.smartdigimkt.y0.w wVar = this.i.b;
        if (wVar != null) {
            wVar.a(false);
        } else {
            for (e0 e0Var2 : this.q) {
                e0Var2.d();
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        if (java.lang.Math.abs(r7 - r18) <= java.lang.Math.abs(r9 - r18)) goto L32;
     */
    @Override // com.smartdigimkt.v0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(long r18, com.smartdigimkt.i0.g0 r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            com.smartdigimkt.n0.l r4 = r0.p
            boolean r4 = r4.a()
            r5 = 0
            if (r4 != 0) goto L11
            return r5
        L11:
            com.smartdigimkt.n0.l r4 = r0.p
            com.smartdigimkt.n0.j r4 = r4.a(r1)
            com.smartdigimkt.n0.m r7 = r4.a
            long r7 = r7.a
            com.smartdigimkt.n0.m r4 = r4.b
            long r9 = r4.a
            int r4 = com.smartdigimkt.z0.u.a
            com.smartdigimkt.i0.g0 r4 = com.smartdigimkt.i0.g0.c
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L2b
            r13 = r1
            goto L7d
        L2b:
            long r11 = r3.a
            long r13 = r1 - r11
            long r11 = r11 ^ r1
            long r15 = r1 ^ r13
            long r11 = r11 & r15
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L39
            r13 = -9223372036854775808
        L39:
            long r3 = r3.b
            long r11 = r1 + r3
            long r15 = r1 ^ r11
            long r3 = r3 ^ r11
            long r3 = r3 & r15
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L4a
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L4a:
            int r3 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r3 > 0) goto L56
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 > 0) goto L56
            r3 = r4
            goto L57
        L56:
            r3 = r5
        L57:
            int r6 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r6 > 0) goto L60
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 > 0) goto L60
            goto L61
        L60:
            r4 = r5
        L61:
            if (r3 == 0) goto L76
            if (r4 == 0) goto L76
            long r3 = r7 - r1
            long r3 = java.lang.Math.abs(r3)
            long r1 = r9 - r1
            long r1 = java.lang.Math.abs(r1)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L7c
            goto L78
        L76:
            if (r3 == 0) goto L7a
        L78:
            r13 = r7
            goto L7d
        L7a:
            if (r4 == 0) goto L7d
        L7c:
            r13 = r9
        L7d:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.v0.i.a(long, com.smartdigimkt.i0.g0):long");
    }

    public final void a(int i) {
        if (this.D[i]) {
            return;
        }
        com.smartdigimkt.i0.s sVar = this.z.b[i].b[0];
        x xVar = this.d;
        String str = sVar.f;
        ArrayList arrayList = com.smartdigimkt.z0.i.a;
        if (!TextUtils.isEmpty(str) && !MediaFormat.KEY_AUDIO.equals(com.smartdigimkt.z0.i.b(str)) && !MediaFormat.KEY_VIDEO.equals(com.smartdigimkt.z0.i.b(str)) && !"text".equals(com.smartdigimkt.z0.i.b(str)) && !"application/cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/x-subrip".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-rawcc".equals(str) && !"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str) && !"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str) && !"application/x-camera-motion".equals(str)) {
            ArrayList arrayList2 = com.smartdigimkt.z0.i.a;
            if (arrayList2.size() > 0) {
                arrayList2.get(0).getClass();
                throw new ClassCastException();
            }
        }
        xVar.a(this.G);
        z zVar = new z();
        for (w wVar : xVar.c) {
            x.a(wVar.a, new v(xVar, wVar.b, zVar));
        }
        this.D[i] = true;
    }

    public final void a(f fVar, long j, long j2) {
        if (this.A == -9223372036854775807L) {
            long jMax = Long.MIN_VALUE;
            for (e0 e0Var : this.q) {
                jMax = Math.max(jMax, e0Var.b());
            }
            long j3 = jMax == Long.MIN_VALUE ? 0L : 10000 + jMax;
            this.A = j3;
            j jVar = this.e;
            boolean zA = this.p.a();
            if (j3 == -9223372036854775807L) {
                j3 = jVar.m;
            }
            if (jVar.m != j3 || jVar.n != zA) {
                jVar.m = j3;
                jVar.n = zA;
                g0 g0Var = new g0(j3, zA, jVar.l);
                jVar.d = g0Var;
                jVar.e = null;
                Iterator it = jVar.a.iterator();
                while (it.hasNext()) {
                    ((com.smartdigimkt.i0.p) ((n) it.next())).f.a.obtainMessage(8, new com.smartdigimkt.i0.m(jVar, g0Var, null)).sendToTarget();
                }
            }
        }
        x xVar = this.d;
        com.smartdigimkt.y0.k kVar = fVar.i;
        long j4 = fVar.h;
        long j5 = this.A;
        y yVar = new y();
        xVar.a(j4);
        xVar.a(j5);
        z zVar = new z();
        for (w wVar : xVar.c) {
            x.a(wVar.a, new r(xVar, wVar.b, yVar, zVar));
        }
        if (this.F == -1) {
            this.F = fVar.j;
        }
        this.K = true;
        this.o.a(this);
    }

    public final void a(f fVar, long j, long j2, boolean z) {
        x xVar = this.d;
        com.smartdigimkt.y0.k kVar = fVar.i;
        long j3 = fVar.h;
        long j4 = this.A;
        y yVar = new y();
        xVar.a(j3);
        xVar.a(j4);
        z zVar = new z();
        for (w wVar : xVar.c) {
            x.a(wVar.a, new s(xVar, wVar.b, yVar, zVar));
        }
        if (z) {
            return;
        }
        if (this.F == -1) {
            this.F = fVar.j;
        }
        for (e0 e0Var : this.q) {
            e0Var.d();
        }
        if (this.y > 0) {
            this.o.a(this);
        }
    }
}
