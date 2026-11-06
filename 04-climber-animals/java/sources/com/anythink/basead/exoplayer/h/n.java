package com.anythink.basead.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class n implements com.anythink.basead.exoplayer.e.g, r, x.b, com.anythink.basead.exoplayer.j.t.a<a>, com.anythink.basead.exoplayer.j.t.d {
    private static final long a = 10000;
    private af A;
    private boolean[] C;
    private boolean[] D;
    private boolean[] E;
    private boolean F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final Uri b;
    private final com.anythink.basead.exoplayer.j.h c;
    private final int d;
    private final t.a e;
    private final c f;
    private final com.anythink.basead.exoplayer.j.b g;
    private final String h;
    private final long i;
    private final b k;
    private r.a p;
    private com.anythink.basead.exoplayer.e.k q;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;
    private final com.anythink.basead.exoplayer.j.t j = new com.anythink.basead.exoplayer.j.t("Loader:ExtractorMediaPeriod");
    private final com.anythink.basead.exoplayer.k.f l = new com.anythink.basead.exoplayer.k.f();
    private final Runnable m = new Runnable() { // from class: com.anythink.basead.exoplayer.h.n.1
        @Override // java.lang.Runnable
        public final void run() {
            n.a(n.this);
        }
    };
    private final Runnable n = new Runnable() { // from class: com.anythink.basead.exoplayer.h.n.2
        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.M) {
                return;
            }
            n.this.p.a(n.this);
        }
    };
    private final Handler o = new Handler();
    private int[] s = new int[0];
    private x[] r = new x[0];
    private long I = -9223372036854775807L;
    private long G = -1;
    private long B = -9223372036854775807L;

    interface c {
        void a(long j, boolean z);
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final void a_(long j) {
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0092 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0093 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0094 A[RETURN] */
    @Override // com.anythink.basead.exoplayer.j.t.a
    public final /* synthetic */ int a(com.anythink.basead.exoplayer.j.t.c cVar, long j, long j2, IOException iOException) {
        boolean z;
        com.anythink.basead.exoplayer.e.k kVar;
        a aVar = (a) cVar;
        boolean z2 = iOException instanceof ag;
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l, iOException, z2);
        a(aVar);
        if (z2) {
            return 3;
        }
        int iM = m();
        boolean z3 = iM > this.K;
        if (this.G != -1 || ((kVar = this.q) != null && kVar.b() != -9223372036854775807L)) {
            this.K = iM;
        } else {
            if (this.u && !j()) {
                this.J = true;
                z = false;
            } else {
                this.x = this.u;
                this.H = 0L;
                this.K = 0;
                for (x xVar : this.r) {
                    xVar.a();
                }
                aVar.a(0L, 0L);
            }
            if (z) {
                return 2;
            }
            if (z3) {
                return 1;
            }
            return 0;
        }
        z = true;
        if (z) {
            return 2;
        }
        if (z3) {
            return 1;
        }
        return 0;
    }

    @Override // com.anythink.basead.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.basead.exoplayer.j.t.c cVar, long j, long j2) {
        a aVar = (a) cVar;
        if (this.B == -9223372036854775807L) {
            long jN = n();
            long j3 = jN == Long.MIN_VALUE ? 0L : jN + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        a(aVar);
        this.L = true;
        this.p.a(this);
    }

    @Override // com.anythink.basead.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.basead.exoplayer.j.t.c cVar, long j, long j2, boolean z) {
        a aVar = (a) cVar;
        this.e.b(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        for (x xVar : this.r) {
            xVar.a();
        }
        if (this.z > 0) {
            this.p.a(this);
        }
    }

    public n(Uri uri, com.anythink.basead.exoplayer.j.h hVar, com.anythink.basead.exoplayer.e.e[] eVarArr, int i, t.a aVar, c cVar, com.anythink.basead.exoplayer.j.b bVar, String str, int i2) {
        this.b = uri;
        this.c = hVar;
        this.d = i;
        this.e = aVar;
        this.f = cVar;
        this.g = bVar;
        this.h = str;
        this.i = i2;
        this.k = new b(eVarArr, this);
        this.v = i == -1 ? 3 : i;
        aVar.a();
    }

    public final void f() {
        if (this.u) {
            for (x xVar : this.r) {
                xVar.j();
            }
        }
        this.j.a(this);
        this.o.removeCallbacksAndMessages(null);
        this.p = null;
        this.M = true;
        this.e.b();
    }

    @Override // com.anythink.basead.exoplayer.j.t.d
    public final void g() {
        for (x xVar : this.r) {
            xVar.a();
        }
        this.k.a();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        this.p = aVar;
        this.l.a();
        l();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a() throws IOException {
        h();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final af b() {
        return this.A;
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long a(com.anythink.basead.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j) {
        com.anythink.basead.exoplayer.i.f fVar;
        com.anythink.basead.exoplayer.k.a.b(this.u);
        int i = this.z;
        int i2 = 0;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            y yVar = yVarArr[i3];
            if (yVar != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) yVar).b;
                com.anythink.basead.exoplayer.k.a.b(this.C[i4]);
                this.z--;
                this.C[i4] = false;
                yVarArr[i3] = null;
            }
        }
        boolean z = !this.w ? j == 0 : i != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (yVarArr[i5] == null && (fVar = fVarArr[i5]) != null) {
                com.anythink.basead.exoplayer.k.a.b(fVar.g() == 1);
                com.anythink.basead.exoplayer.k.a.b(fVar.b(0) == 0);
                int iA = this.A.a(fVar.f());
                com.anythink.basead.exoplayer.k.a.b(!this.C[iA]);
                this.z++;
                this.C[iA] = true;
                yVarArr[i5] = new d(iA);
                zArr2[i5] = true;
                if (!z) {
                    x xVar = this.r[iA];
                    xVar.i();
                    z = xVar.a(j, true) == -1 && xVar.e() != 0;
                }
            }
        }
        if (this.z == 0) {
            this.J = false;
            this.x = false;
            if (this.j.a()) {
                x[] xVarArr = this.r;
                int length = xVarArr.length;
                while (i2 < length) {
                    xVarArr[i2].j();
                    i2++;
                }
                this.j.b();
            } else {
                x[] xVarArr2 = this.r;
                int length2 = xVarArr2.length;
                while (i2 < length2) {
                    xVarArr2[i2].a();
                    i2++;
                }
            }
        } else if (z) {
            j = b(j);
            while (i2 < yVarArr.length) {
                if (yVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.w = true;
        return j;
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a(long j, boolean z) {
        int length = this.r.length;
        for (int i = 0; i < length; i++) {
            this.r[i].a(j, z, this.C[i]);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final boolean c(long j) {
        if (this.L || this.J) {
            return false;
        }
        if (this.u && this.z == 0) {
            return false;
        }
        boolean zA = this.l.a();
        if (this.j.a()) {
            return zA;
        }
        l();
        return true;
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final long e() {
        if (this.z == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long c() {
        if (!this.y) {
            this.e.c();
            this.y = true;
        }
        if (!this.x) {
            return -9223372036854775807L;
        }
        if (!this.L && m() <= this.K) {
            return -9223372036854775807L;
        }
        this.x = false;
        return this.H;
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final long d() {
        long jN;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (o()) {
            return this.I;
        }
        if (this.F) {
            int length = this.r.length;
            jN = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.D[i]) {
                    jN = Math.min(jN, this.r[i].g());
                }
            }
        } else {
            jN = n();
        }
        return jN == Long.MIN_VALUE ? this.H : jN;
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long b(long j) {
        if (!this.q.a()) {
            j = 0;
        }
        this.H = j;
        this.x = false;
        if (!o() && d(j)) {
            return j;
        }
        this.J = false;
        this.I = j;
        this.L = false;
        if (this.j.a()) {
            this.j.b();
        } else {
            for (x xVar : this.r) {
                xVar.a();
            }
        }
        return j;
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long a(long j, com.anythink.basead.exoplayer.ac acVar) {
        if (!this.q.a()) {
            return 0L;
        }
        com.anythink.basead.exoplayer.e.k.a aVarA = this.q.a(j);
        return com.anythink.basead.exoplayer.k.af.a(j, acVar, aVarA.a.b, aVarA.b.b);
    }

    final boolean a(int i) {
        if (j()) {
            return false;
        }
        return this.L || this.r[i].c();
    }

    final void h() throws IOException {
        this.j.a(this.v);
    }

    final int a(int i, com.anythink.basead.exoplayer.n nVar, com.anythink.basead.exoplayer.c.e eVar, boolean z) {
        if (j()) {
            return -3;
        }
        int iA = this.r[i].a(nVar, eVar, z, this.L, this.H);
        if (iA == -4) {
            b(i);
        } else if (iA == -3) {
            c(i);
        }
        return iA;
    }

    final int a(int i, long j) {
        int iK = 0;
        if (j()) {
            return 0;
        }
        x xVar = this.r[i];
        if (this.L && j > xVar.g()) {
            iK = xVar.k();
        } else {
            int iA = xVar.a(j, true);
            if (iA != -1) {
                iK = iA;
            }
        }
        if (iK > 0) {
            b(i);
        } else {
            c(i);
        }
        return iK;
    }

    private void b(int i) {
        if (this.E[i]) {
            return;
        }
        com.anythink.basead.exoplayer.m mVarA = this.A.a(i).a(0);
        this.e.a(com.anythink.basead.exoplayer.k.o.d(mVarA.h), mVarA, 0, (Object) null, this.H);
        this.E[i] = true;
    }

    private void c(int i) {
        if (this.J && this.D[i] && !this.r[i].c()) {
            this.I = 0L;
            this.J = false;
            this.x = true;
            this.H = 0L;
            this.K = 0;
            for (x xVar : this.r) {
                xVar.a();
            }
            this.p.a(this);
        }
    }

    private boolean j() {
        return this.x || o();
    }

    private void a(a aVar, long j, long j2) {
        if (this.B == -9223372036854775807L) {
            long jN = n();
            long j3 = jN == Long.MIN_VALUE ? 0L : jN + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        a(aVar);
        this.L = true;
        this.p.a(this);
    }

    private void a(a aVar, long j, long j2, boolean z) {
        this.e.b(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        for (x xVar : this.r) {
            xVar.a();
        }
        if (this.z > 0) {
            this.p.a(this);
        }
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final com.anythink.basead.exoplayer.e.m a(int i, int i2) {
        int length = this.r.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.s[i3] == i) {
                return this.r[i3];
            }
        }
        x xVar = new x(this.g);
        xVar.a(this);
        int i4 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.s, i4);
        this.s = iArrCopyOf;
        iArrCopyOf[length] = i;
        x[] xVarArr = (x[]) Arrays.copyOf(this.r, i4);
        this.r = xVarArr;
        xVarArr[length] = xVar;
        return xVar;
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final void c_() {
        this.t = true;
        this.o.post(this.m);
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final void a(com.anythink.basead.exoplayer.e.k kVar) {
        this.q = kVar;
        this.o.post(this.m);
    }

    @Override // com.anythink.basead.exoplayer.h.x.b
    public final void i() {
        this.o.post(this.m);
    }

    private void k() {
        if (this.M || this.u || this.q == null || !this.t) {
            return;
        }
        for (x xVar : this.r) {
            if (xVar.f() == null) {
                return;
            }
        }
        this.l.b();
        int length = this.r.length;
        ae[] aeVarArr = new ae[length];
        this.D = new boolean[length];
        this.C = new boolean[length];
        this.E = new boolean[length];
        this.B = this.q.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            com.anythink.basead.exoplayer.m mVarF = this.r[i].f();
            aeVarArr[i] = new ae(mVarF);
            String str = mVarF.h;
            if (!com.anythink.basead.exoplayer.k.o.b(str) && !com.anythink.basead.exoplayer.k.o.a(str)) {
                z = false;
            }
            this.D[i] = z;
            this.F = z | this.F;
            i++;
        }
        this.A = new af(aeVarArr);
        if (this.d == -1 && this.G == -1 && this.q.b() == -9223372036854775807L) {
            this.v = 6;
        }
        this.u = true;
        this.f.a(this.B, this.q.a());
        this.p.a((r) this);
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.k;
        }
    }

    private void l() {
        a aVar = new a(this.b, this.c, this.k, this.l);
        if (this.u) {
            com.anythink.basead.exoplayer.k.a.b(o());
            long j = this.B;
            if (j != -9223372036854775807L && this.I >= j) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            } else {
                aVar.a(this.q.a(this.I).a.c, this.I);
                this.I = -9223372036854775807L;
            }
        }
        this.K = m();
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, this.j.a(aVar, this, this.v));
    }

    private boolean a(a aVar, int i) {
        com.anythink.basead.exoplayer.e.k kVar;
        if (this.G != -1 || ((kVar = this.q) != null && kVar.b() != -9223372036854775807L)) {
            this.K = i;
            return true;
        }
        if (this.u && !j()) {
            this.J = true;
            return false;
        }
        this.x = this.u;
        this.H = 0L;
        this.K = 0;
        for (x xVar : this.r) {
            xVar.a();
        }
        aVar.a(0L, 0L);
        return true;
    }

    private boolean d(long j) {
        int length = this.r.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            x xVar = this.r[i];
            xVar.i();
            if (!(xVar.a(j, false) != -1) && (this.D[i] || !this.F)) {
                return false;
            }
            i++;
        }
    }

    private int m() {
        int iB = 0;
        for (x xVar : this.r) {
            iB += xVar.b();
        }
        return iB;
    }

    private long n() {
        long jMax = Long.MIN_VALUE;
        for (x xVar : this.r) {
            jMax = Math.max(jMax, xVar.g());
        }
        return jMax;
    }

    private boolean o() {
        return this.I != -9223372036854775807L;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof ag;
    }

    private final class d implements y {
        private final int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.anythink.basead.exoplayer.h.y
        public final boolean b() {
            return n.this.a(this.b);
        }

        @Override // com.anythink.basead.exoplayer.h.y
        public final void c() throws IOException {
            n.this.h();
        }

        @Override // com.anythink.basead.exoplayer.h.y
        public final int a(com.anythink.basead.exoplayer.n nVar, com.anythink.basead.exoplayer.c.e eVar, boolean z) {
            return n.this.a(this.b, nVar, eVar, z);
        }

        @Override // com.anythink.basead.exoplayer.h.y
        public final int a(long j) {
            return n.this.a(this.b, j);
        }
    }

    final class a implements com.anythink.basead.exoplayer.j.t.c {
        private final Uri b;
        private final com.anythink.basead.exoplayer.j.h c;
        private final b d;
        private final com.anythink.basead.exoplayer.k.f e;
        private volatile boolean g;
        private long i;
        private com.anythink.basead.exoplayer.j.k j;
        private long l;
        private final com.anythink.basead.exoplayer.e.j f = new com.anythink.basead.exoplayer.e.j();
        private boolean h = true;
        private long k = -1;

        public a(Uri uri, com.anythink.basead.exoplayer.j.h hVar, b bVar, com.anythink.basead.exoplayer.k.f fVar) {
            this.b = (Uri) com.anythink.basead.exoplayer.k.a.a(uri);
            this.c = (com.anythink.basead.exoplayer.j.h) com.anythink.basead.exoplayer.k.a.a(hVar);
            this.d = (b) com.anythink.basead.exoplayer.k.a.a(bVar);
            this.e = fVar;
        }

        public final void a(long j, long j2) {
            this.f.a = j;
            this.i = j2;
            this.h = true;
        }

        @Override // com.anythink.basead.exoplayer.j.t.c
        public final void a() {
            this.g = true;
        }

        @Override // com.anythink.basead.exoplayer.j.t.c
        public final void b() throws Throwable {
            int iA = 0;
            while (iA == 0 && !this.g) {
                com.anythink.basead.exoplayer.e.b bVar = null;
                try {
                    long jC = this.f.a;
                    com.anythink.basead.exoplayer.j.k kVar = new com.anythink.basead.exoplayer.j.k(this.b, jC, n.this.h);
                    this.j = kVar;
                    long jA = this.c.a(kVar);
                    this.k = jA;
                    if (jA != -1) {
                        this.k = jA + jC;
                    }
                    com.anythink.basead.exoplayer.e.b bVar2 = new com.anythink.basead.exoplayer.e.b(this.c, jC, this.k);
                    try {
                        com.anythink.basead.exoplayer.e.e eVarA = this.d.a(bVar2, this.c.a());
                        if (this.h) {
                            eVarA.a(jC, this.i);
                            this.h = false;
                        }
                        while (iA == 0 && !this.g) {
                            this.e.c();
                            iA = eVarA.a(bVar2, this.f);
                            if (bVar2.c() > n.this.i + jC) {
                                jC = bVar2.c();
                                this.e.b();
                                n.this.o.post(n.this.n);
                            }
                        }
                        if (iA == 1) {
                            iA = 0;
                        } else {
                            this.f.a = bVar2.c();
                            this.l = this.f.a - this.j.e;
                        }
                        com.anythink.basead.exoplayer.k.af.a(this.c);
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (iA != 1 && bVar != null) {
                            this.f.a = bVar.c();
                            this.l = this.f.a - this.j.e;
                        }
                        com.anythink.basead.exoplayer.k.af.a(this.c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    private static final class b {
        private final com.anythink.basead.exoplayer.e.e[] a;
        private final com.anythink.basead.exoplayer.e.g b;
        private com.anythink.basead.exoplayer.e.e c;

        public b(com.anythink.basead.exoplayer.e.e[] eVarArr, com.anythink.basead.exoplayer.e.g gVar) {
            this.a = eVarArr;
            this.b = gVar;
        }

        public final com.anythink.basead.exoplayer.e.e a(com.anythink.basead.exoplayer.e.f fVar, Uri uri) throws ag {
            com.anythink.basead.exoplayer.e.e eVar = this.c;
            if (eVar != null) {
                return eVar;
            }
            for (com.anythink.basead.exoplayer.e.e eVar2 : this.a) {
                try {
                    if (eVar2.a(fVar)) {
                        this.c = eVar2;
                        fVar.a();
                        break;
                    }
                    continue;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                fVar.a();
            }
            com.anythink.basead.exoplayer.e.e eVar3 = this.c;
            if (eVar3 == null) {
                throw new ag("None of the available extractors (" + com.anythink.basead.exoplayer.k.af.a(this.a) + ") could read the stream.", uri);
            }
            eVar3.a(this.b);
            return this.c;
        }

        public final void a() {
            if (this.c != null) {
                this.c = null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x008e A[RETURN] */
    private int a(a aVar, long j, long j2, IOException iOException) {
        boolean z;
        com.anythink.basead.exoplayer.e.k kVar;
        boolean z2 = iOException instanceof ag;
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l, iOException, z2);
        a(aVar);
        if (z2) {
            return 3;
        }
        int iM = m();
        boolean z3 = iM > this.K;
        if (this.G != -1 || ((kVar = this.q) != null && kVar.b() != -9223372036854775807L)) {
            this.K = iM;
        } else {
            if (this.u && !j()) {
                this.J = true;
                z = false;
            } else {
                this.x = this.u;
                this.H = 0L;
                this.K = 0;
                for (x xVar : this.r) {
                    xVar.a();
                }
                aVar.a(0L, 0L);
            }
            if (z) {
                return 2;
            }
            if (z3) {
                return 1;
            }
            return 0;
        }
        z = true;
        if (z) {
            return 2;
        }
        if (z3) {
            return 1;
        }
        return 0;
    }

    static /* synthetic */ void a(n nVar) {
        if (nVar.M || nVar.u || nVar.q == null || !nVar.t) {
            return;
        }
        for (x xVar : nVar.r) {
            if (xVar.f() == null) {
                return;
            }
        }
        nVar.l.b();
        int length = nVar.r.length;
        ae[] aeVarArr = new ae[length];
        nVar.D = new boolean[length];
        nVar.C = new boolean[length];
        nVar.E = new boolean[length];
        nVar.B = nVar.q.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            com.anythink.basead.exoplayer.m mVarF = nVar.r[i].f();
            aeVarArr[i] = new ae(mVarF);
            String str = mVarF.h;
            if (!com.anythink.basead.exoplayer.k.o.b(str) && !com.anythink.basead.exoplayer.k.o.a(str)) {
                z = false;
            }
            nVar.D[i] = z;
            nVar.F = z | nVar.F;
            i++;
        }
        nVar.A = new af(aeVarArr);
        if (nVar.d == -1 && nVar.G == -1 && nVar.q.b() == -9223372036854775807L) {
            nVar.v = 6;
        }
        nVar.u = true;
        nVar.f.a(nVar.B, nVar.q.a());
        nVar.p.a((r) nVar);
    }
}
