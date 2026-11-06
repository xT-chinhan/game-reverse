package com.smartdigimkt.o0;

import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.i0.y;
import com.smartdigimkt.v0.e0;
import java.io.EOFException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.smartdigimkt.n0.e {
    public static final int D = com.smartdigimkt.z0.u.a("seig");
    public static final byte[] E = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final com.smartdigimkt.i0.s F = new com.smartdigimkt.i0.s(null, null, "application/x-emsg", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, null, null, null);
    public e0[] A;
    public e0[] B;
    public boolean C;
    public final int a;
    public final List b;
    public final SparseArray c;
    public final com.smartdigimkt.z0.m d;
    public final com.smartdigimkt.z0.m e;
    public final com.smartdigimkt.z0.m f;
    public final com.smartdigimkt.z0.m g;
    public final byte[] h;
    public final ArrayDeque i;
    public final ArrayDeque j;
    public int k;
    public int l;
    public long m;
    public int n;
    public com.smartdigimkt.z0.m o;
    public long p;
    public int q;
    public long r;
    public long s;
    public long t;
    public l u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public com.smartdigimkt.n0.f z;

    public m() {
        List listEmptyList = Collections.emptyList();
        this.a = 0;
        this.b = Collections.unmodifiableList(listEmptyList);
        this.g = new com.smartdigimkt.z0.m(16);
        this.d = new com.smartdigimkt.z0.m(com.smartdigimkt.z0.k.a);
        this.e = new com.smartdigimkt.z0.m(5);
        this.f = new com.smartdigimkt.z0.m();
        this.h = new byte[16];
        this.i = new ArrayDeque();
        this.j = new ArrayDeque();
        this.c = new SparseArray();
        this.s = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.k = 0;
        this.n = 0;
    }

    @Override // com.smartdigimkt.n0.e
    public final boolean a(com.smartdigimkt.n0.c cVar) {
        return r.a(cVar, true);
    }

    @Override // com.smartdigimkt.n0.e
    public final void a(com.smartdigimkt.n0.f fVar) {
        this.z = fVar;
    }

    @Override // com.smartdigimkt.n0.e
    public final void a(long j, long j2) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            ((l) this.c.valueAt(i)).a();
        }
        this.j.clear();
        this.q = 0;
        this.r = j2;
        this.i.clear();
        this.k = 0;
        this.n = 0;
    }

    /* JADX WARN: Code duplicated, block: B:97:0x01f1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.smartdigimkt.n0.c] */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.smartdigimkt.n0.c] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.smartdigimkt.z0.m] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.smartdigimkt.z0.m] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.smartdigimkt.v0.e0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.smartdigimkt.n0.e
    public final int a(com.smartdigimkt.n0.c cVar, com.smartdigimkt.n0.i iVar) throws InterruptedException, y, EOFException {
        int i;
        com.smartdigimkt.n0.n nVar;
        int i2;
        ?? r4;
        int iA;
        com.smartdigimkt.z0.m mVar;
        int i3;
        e0[] e0VarArr;
        long jI;
        long jI2;
        ?? r1 = cVar;
        while (true) {
            int i4 = this.k;
            int i5 = 1;
            ?? r7 = 0;
            if (i4 == 0) {
                if (this.n == 0) {
                    if (!r1.a(this.g.a, 0, 8, true)) {
                        return -1;
                    }
                    this.n = 8;
                    this.g.c(0);
                    this.m = this.g.f();
                    this.l = this.g.a();
                }
                long j = this.m;
                if (j == 1) {
                    r1.a(this.g.a, 8, 8, false);
                    this.n += 8;
                    this.m = this.g.i();
                } else if (j == 0) {
                    long j2 = r1.c;
                    if (j2 == -1 && !this.i.isEmpty()) {
                        j2 = ((a) this.i.peek()).P0;
                    }
                    if (j2 != -1) {
                        this.m = (j2 - r1.d) + ((long) this.n);
                    }
                }
                long j3 = this.m;
                long j4 = this.n;
                if (j3 >= j4) {
                    long j5 = r1.d - j4;
                    if (this.l == c.L) {
                        int size = this.c.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            u uVar = ((l) this.c.valueAt(i6)).b;
                            uVar.getClass();
                            uVar.c = j5;
                            uVar.b = j5;
                        }
                    }
                    int i7 = this.l;
                    if (i7 == c.i) {
                        this.u = null;
                        this.p = this.m + j5;
                        if (!this.C) {
                            com.smartdigimkt.v0.i iVar2 = (com.smartdigimkt.v0.i) this.z;
                            iVar2.p = new com.smartdigimkt.n0.k(this.s, j5);
                            iVar2.n.post(iVar2.l);
                            this.C = true;
                        }
                        this.k = 2;
                    } else if (i7 != c.C && i7 != c.E && i7 != c.F && i7 != c.G && i7 != c.H && i7 != c.L && i7 != c.M && i7 != c.N && i7 != c.Q) {
                        if (i7 == c.T || i7 == c.S || i7 == c.D || i7 == c.B || i7 == c.U || i7 == c.x || i7 == c.y || i7 == c.P || i7 == c.z || i7 == c.A || i7 == c.V || i7 == c.d0 || i7 == c.e0 || i7 == c.i0 || i7 == c.h0 || i7 == c.f0 || i7 == c.g0 || i7 == c.R || i7 == c.O || i7 == c.G0) {
                            if (this.n == 8) {
                                long j6 = this.m;
                                if (j6 <= 2147483647L) {
                                    com.smartdigimkt.z0.m mVar2 = new com.smartdigimkt.z0.m((int) j6);
                                    this.o = mVar2;
                                    System.arraycopy(this.g.a, 0, mVar2.a, 0, 8);
                                    this.k = 1;
                                } else {
                                    throw new y("Leaf atom with length > 2147483647 (unsupported).");
                                }
                            } else {
                                throw new y("Leaf atom defines extended atom size (unsupported).");
                            }
                        } else if (this.m <= 2147483647L) {
                            this.o = null;
                            this.k = 1;
                        } else {
                            throw new y("Skipping atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        long j7 = (r1.d + this.m) - 8;
                        this.i.push(new a(this.l, j7));
                        if (this.m == this.n) {
                            a(j7);
                        } else {
                            this.k = 0;
                            this.n = 0;
                        }
                    }
                } else {
                    throw new y("Atom size less than header length (unsupported).");
                }
            } else if (i4 != 1) {
                long j8 = LongCompanionObject.MAX_VALUE;
                if (i4 != 2) {
                    char c = 6;
                    if (i4 == 3) {
                        if (this.u == null) {
                            SparseArray sparseArray = this.c;
                            int size2 = sparseArray.size();
                            l lVar = null;
                            for (int i8 = 0; i8 < size2; i8++) {
                                l lVar2 = (l) sparseArray.valueAt(i8);
                                int i9 = lVar2.g;
                                u uVar2 = lVar2.b;
                                if (i9 != uVar2.d) {
                                    long j9 = uVar2.f[i9];
                                    if (j9 < j8) {
                                        lVar = lVar2;
                                        j8 = j9;
                                    }
                                }
                            }
                            if (lVar == null) {
                                int i10 = (int) (this.p - r1.d);
                                if (i10 >= 0) {
                                    r1.b(i10);
                                    this.k = 0;
                                    this.n = 0;
                                } else {
                                    throw new y("Offset to end of mdat was negative.");
                                }
                            } else {
                                int i11 = (int) (lVar.b.f[lVar.g] - r1.d);
                                if (i11 < 0) {
                                    i11 = 0;
                                }
                                r1.b(i11);
                                this.u = lVar;
                            }
                        }
                        l lVar3 = this.u;
                        int[] iArr = lVar3.b.h;
                        int i12 = lVar3.e;
                        int i13 = iArr[i12];
                        this.v = i13;
                        if (i12 < lVar3.h) {
                            r1.b(i13);
                            l lVar4 = this.u;
                            u uVar3 = lVar4.b;
                            if (uVar3.l) {
                                com.smartdigimkt.z0.m mVar3 = uVar3.p;
                                int i14 = uVar3.a.a;
                                t tVar = uVar3.n;
                                if (tVar == null) {
                                    t[] tVarArr = lVar4.c.k;
                                    tVar = tVarArr == null ? null : tVarArr[i14];
                                }
                                int i15 = tVar.c;
                                if (i15 != 0) {
                                    mVar3.c(mVar3.b + i15);
                                }
                                if (lVar4.b.m[lVar4.e]) {
                                    mVar3.c(mVar3.b + (mVar3.j() * 6));
                                }
                            }
                            l lVar5 = this.u;
                            lVar5.e++;
                            int i16 = lVar5.f + 1;
                            lVar5.f = i16;
                            int[] iArr2 = lVar5.b.g;
                            int i17 = lVar5.g;
                            if (i16 == iArr2[i17]) {
                                lVar5.g = i17 + 1;
                                lVar5.f = 0;
                                this.u = null;
                            }
                            this.k = 3;
                            return 0;
                        }
                        if (lVar3.c.g == 1) {
                            this.v = i13 - 8;
                            r1.b(8);
                        }
                        l lVar6 = this.u;
                        u uVar4 = lVar6.b;
                        if (uVar4.l) {
                            int i18 = uVar4.a.a;
                            t tVar2 = uVar4.n;
                            if (tVar2 == null) {
                                t[] tVarArr2 = lVar6.c.k;
                                tVar2 = tVarArr2 == null ? null : tVarArr2[i18];
                            }
                            int length = tVar2.c;
                            if (length != 0) {
                                mVar = uVar4.p;
                            } else {
                                byte[] bArr = tVar2.d;
                                mVar = lVar6.j;
                                int length2 = bArr.length;
                                mVar.a = bArr;
                                mVar.c = length2;
                                mVar.b = 0;
                                length = bArr.length;
                            }
                            boolean z = uVar4.m[lVar6.e];
                            com.smartdigimkt.z0.m mVar4 = lVar6.i;
                            mVar4.a[0] = (byte) ((z ? 128 : 0) | length);
                            mVar4.c(0);
                            lVar6.a.a(1, lVar6.i);
                            lVar6.a.a(length, mVar);
                            if (z) {
                                com.smartdigimkt.z0.m mVar5 = lVar6.b.p;
                                int iJ = mVar5.j();
                                mVar5.c(mVar5.b - 2);
                                int i19 = (iJ * 6) + 2;
                                lVar6.a.a(i19, mVar5);
                                i3 = length + 1 + i19;
                            } else {
                                i3 = length + 1;
                            }
                        } else {
                            i3 = 0;
                        }
                        this.w = i3;
                        this.v += i3;
                        this.k = 4;
                        this.x = 0;
                    }
                    l lVar7 = this.u;
                    u uVar5 = lVar7.b;
                    s sVar = lVar7.c;
                    ?? r8 = lVar7.a;
                    int i20 = lVar7.e;
                    long j10 = (uVar5.j[i20] + ((long) uVar5.i[i20])) * 1000;
                    int i21 = sVar.j;
                    if (i21 == 0) {
                        while (true) {
                            int i22 = this.w;
                            int i23 = this.v;
                            if (i22 >= i23) {
                                break;
                            }
                            this.w += r8.a(r1, i23 - i22);
                        }
                    } else {
                        byte[] bArr2 = this.e.a;
                        bArr2[0] = 0;
                        bArr2[1] = 0;
                        bArr2[2] = 0;
                        int i24 = i21 + 1;
                        int i25 = 4 - i21;
                        while (this.w < this.v) {
                            int i26 = this.x;
                            if (i26 == 0) {
                                r1.a(bArr2, i25, i24, r7);
                                this.e.c(r7);
                                this.x = this.e.h() - i5;
                                this.d.c(r7);
                                r8.a(4, this.d);
                                r8.a(i5, this.e);
                                if (this.B.length > 0) {
                                    String str = sVar.f.f;
                                    byte b = bArr2[4];
                                    if (("video/avc".equals(str) && (b & 31) == c) || ("video/hevc".equals(str) && ((b & 126) >> i5) == 39)) {
                                        r4 = i5;
                                    } else {
                                        r4 = 0;
                                    }
                                } else {
                                    r4 = 0;
                                }
                                this.y = r4;
                                this.w += 5;
                                this.v += i25;
                                r7 = 0;
                            } else {
                                if (this.y) {
                                    this.f.b(i26);
                                    r1.a(this.f.a, 0, this.x, false);
                                    r8.a(this.x, this.f);
                                    iA = this.x;
                                    com.smartdigimkt.z0.m mVar6 = this.f;
                                    int iA2 = com.smartdigimkt.z0.k.a(mVar6.c, mVar6.a);
                                    this.f.c("video/hevc".equals(sVar.f.f) ? 1 : 0);
                                    com.smartdigimkt.z0.m mVar7 = this.f;
                                    if (iA2 >= 0) {
                                        if (iA2 <= mVar7.a.length) {
                                            mVar7.c = iA2;
                                        }
                                    } else {
                                        mVar7.getClass();
                                    }
                                    throw new IllegalArgumentException();
                                }
                                iA = r8.a(r1, i26);
                                this.w += iA;
                                this.x -= iA;
                                i5 = 1;
                                r7 = 0;
                                c = 6;
                            }
                        }
                    }
                    boolean z2 = uVar5.k[i20];
                    if (uVar5.l) {
                        int i27 = (z2 ? 1 : 0) | C.ENCODING_PCM_32BIT;
                        t tVar3 = uVar5.n;
                        if (tVar3 == null) {
                            int i28 = uVar5.a.a;
                            t[] tVarArr3 = sVar.k;
                            tVar3 = tVarArr3 == null ? null : tVarArr3[i28];
                        }
                        i = i27;
                        nVar = tVar3.b;
                    } else {
                        i = z2 ? 1 : 0;
                        nVar = null;
                    }
                    r8.a(j10, i, this.v, 0, nVar);
                    while (!this.j.isEmpty()) {
                        k kVar = (k) this.j.removeFirst();
                        this.q -= kVar.b;
                        long j11 = kVar.a + j10;
                        for (e0 e0Var : this.A) {
                            e0Var.a(j11, 1, kVar.b, this.q, null);
                        }
                    }
                    l lVar8 = this.u;
                    lVar8.e++;
                    int i29 = lVar8.f + 1;
                    lVar8.f = i29;
                    int[] iArr3 = lVar8.b.g;
                    int i30 = lVar8.g;
                    if (i29 == iArr3[i30]) {
                        lVar8.g = i30 + 1;
                        i2 = 0;
                        lVar8.f = 0;
                        this.u = null;
                    } else {
                        i2 = 0;
                    }
                    this.k = 3;
                    return i2;
                }
                int size3 = this.c.size();
                l lVar9 = null;
                for (int i31 = 0; i31 < size3; i31++) {
                    u uVar6 = ((l) this.c.valueAt(i31)).b;
                    if (uVar6.q) {
                        long j12 = uVar6.c;
                        if (j12 < j8) {
                            lVar9 = (l) this.c.valueAt(i31);
                            j8 = j12;
                        }
                    }
                }
                if (lVar9 == null) {
                    this.k = 3;
                } else {
                    int i32 = (int) (j8 - r1.d);
                    if (i32 >= 0) {
                        r1.b(i32);
                        u uVar7 = lVar9.b;
                        r1.a(uVar7.p.a, 0, uVar7.o, false);
                        uVar7.p.c(0);
                        uVar7.q = false;
                    } else {
                        throw new y("Offset to encryption data was negative.");
                    }
                }
            } else {
                int i33 = ((int) this.m) - this.n;
                com.smartdigimkt.z0.m mVar8 = this.o;
                if (mVar8 != null) {
                    r1.a(mVar8.a, 8, i33, false);
                    int i34 = this.l;
                    com.smartdigimkt.z0.m mVar9 = this.o;
                    b bVar = new b(i34, mVar9);
                    long j13 = r1.d;
                    if (!this.i.isEmpty()) {
                        ((a) this.i.peek()).Q0.add(bVar);
                        r1 = r1;
                    } else {
                        if (i34 == c.B) {
                            mVar9.c(8);
                            int iA3 = (mVar9.a() >> 24) & 255;
                            mVar9.c(mVar9.b + 4);
                            long jF = mVar9.f();
                            if (iA3 == 0) {
                                jI = mVar9.f();
                                jI2 = mVar9.f();
                            } else {
                                jI = mVar9.i();
                                jI2 = mVar9.i();
                            }
                            long j14 = jI2 + j13;
                            long jA = com.smartdigimkt.z0.u.a(jI, C.MICROS_PER_SECOND, jF);
                            mVar9.c(mVar9.b + 2);
                            int iJ2 = mVar9.j();
                            int[] iArr4 = new int[iJ2];
                            long[] jArr = new long[iJ2];
                            long[] jArr2 = new long[iJ2];
                            long[] jArr3 = new long[iJ2];
                            long jA2 = jA;
                            int i35 = 0;
                            while (i35 < iJ2) {
                                int iA4 = mVar9.a();
                                if ((iA4 & Integer.MIN_VALUE) == 0) {
                                    long jF2 = mVar9.f();
                                    iArr4[i35] = iA4 & Integer.MAX_VALUE;
                                    jArr[i35] = j14;
                                    jArr3[i35] = jA2;
                                    long j15 = jI + jF2;
                                    int i36 = i35;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    int i37 = iJ2;
                                    int[] iArr5 = iArr4;
                                    jA2 = com.smartdigimkt.z0.u.a(j15, C.MICROS_PER_SECOND, jF);
                                    jArr4[i36] = jA2 - jArr5[i36];
                                    mVar9.c(mVar9.b + 4);
                                    j14 += (long) iArr5[i36];
                                    i35 = i36 + 1;
                                    jArr = jArr;
                                    jArr2 = jArr4;
                                    jArr3 = jArr5;
                                    iArr4 = iArr5;
                                    iJ2 = i37;
                                    jI = j15;
                                } else {
                                    throw new y("Unhandled indirect reference");
                                }
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jA), new com.smartdigimkt.n0.b(iArr4, jArr, jArr2, jArr3));
                            this.t = ((Long) pairCreate.first).longValue();
                            com.smartdigimkt.v0.i iVar3 = (com.smartdigimkt.v0.i) this.z;
                            iVar3.p = (com.smartdigimkt.n0.l) pairCreate.second;
                            iVar3.n.post(iVar3.l);
                            this.C = true;
                        } else if (i34 == c.G0 && (e0VarArr = this.A) != null && e0VarArr.length != 0) {
                            mVar9.c(12);
                            int i38 = mVar9.c - mVar9.b;
                            mVar9.c();
                            mVar9.c();
                            long jA3 = com.smartdigimkt.z0.u.a(mVar9.f(), C.MICROS_PER_SECOND, mVar9.f());
                            for (e0 e0Var2 : this.A) {
                                mVar9.c(12);
                                e0Var2.a(i38, mVar9);
                            }
                            long j16 = this.t;
                            if (j16 != -9223372036854775807L) {
                                long j17 = j16 + jA3;
                                for (e0 e0Var3 : this.A) {
                                    e0Var3.a(j17, 1, i38, 0, null);
                                }
                            } else {
                                this.j.addLast(new k(i38, jA3));
                                this.q += i38;
                            }
                        }
                        r1 = cVar;
                    }
                } else {
                    r1.b(i33);
                    r1 = r1;
                }
                a(r1.d);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:162:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:165:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:166:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:169:0x03e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:171:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:173:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:174:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:178:0x0403 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:179:0x0405  */
    /* JADX WARN: Code duplicated, block: B:180:0x040a  */
    /* JADX WARN: Code duplicated, block: B:182:0x040e  */
    /* JADX WARN: Code duplicated, block: B:183:0x0423  */
    /* JADX WARN: Code duplicated, block: B:189:0x0449  */
    /* JADX WARN: Code duplicated, block: B:288:0x066a  */
    /* JADX WARN: Code duplicated, block: B:300:0x06b0  */
    public final void a(long j) throws y {
        j jVar;
        j jVar2;
        SparseArray sparseArray;
        m mVar;
        a aVar;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        l lVar;
        int iH;
        int iH2;
        int iH3;
        int iH4;
        byte[] bArr2;
        int i5;
        String str;
        boolean z;
        byte[] bArr3;
        int i6;
        int i7;
        a aVar2;
        long jA;
        int[] iArr;
        int[] iArr2;
        long[] jArr;
        boolean[] zArr;
        boolean z2;
        int i8;
        long j2;
        long j3;
        int i9;
        int iH5;
        int iH6;
        int iA;
        boolean z3;
        m mVar2 = this;
        while (!mVar2.i.isEmpty() && ((a) mVar2.i.peek()).P0 == j) {
            a aVar3 = (a) mVar2.i.pop();
            int i10 = aVar3.a;
            int i11 = 12;
            int i12 = 8;
            int i13 = 1;
            if (i10 == c.C) {
                com.smartdigimkt.m0.d dVarA = a(aVar3.Q0);
                a aVarB = aVar3.b(c.N);
                SparseArray sparseArray2 = new SparseArray();
                int size = aVarB.Q0.size();
                long jF = -9223372036854775807L;
                int i14 = 0;
                while (i14 < size) {
                    b bVar = (b) aVarB.Q0.get(i14);
                    int i15 = bVar.a;
                    if (i15 == c.z) {
                        com.smartdigimkt.z0.m mVar3 = bVar.P0;
                        mVar3.c(i11);
                        Pair pairCreate = Pair.create(Integer.valueOf(mVar3.a()), new j(mVar3.h() - i13, mVar3.h(), mVar3.h(), mVar3.a()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (j) pairCreate.second);
                    } else if (i15 == c.O) {
                        com.smartdigimkt.z0.m mVar4 = bVar.P0;
                        mVar4.c(8);
                        jF = ((mVar4.a() >> 24) & 255) == 0 ? mVar4.f() : mVar4.i();
                    }
                    i14++;
                    i11 = 12;
                    i13 = 1;
                }
                SparseArray sparseArray3 = new SparseArray();
                int size2 = aVar3.R0.size();
                int i16 = 0;
                while (i16 < size2) {
                    a aVar4 = (a) aVar3.R0.get(i16);
                    if (aVar4.a == c.E) {
                        sparseArray = sparseArray2;
                        s sVarA = i.a(aVar4, aVar3.c(c.D), jF, dVarA, (mVar2.a & 16) != 0, false);
                        if (sVarA != null) {
                            sparseArray3.put(sVarA.a, sVarA);
                        }
                    } else {
                        sparseArray = sparseArray2;
                    }
                    i16++;
                    sparseArray2 = sparseArray;
                }
                SparseArray sparseArray4 = sparseArray2;
                int size3 = sparseArray3.size();
                if (mVar2.c.size() == 0) {
                    for (int i17 = 0; i17 < size3; i17++) {
                        s sVar = (s) sparseArray3.valueAt(i17);
                        com.smartdigimkt.n0.f fVar = mVar2.z;
                        int i18 = sVar.b;
                        e0 e0VarC = ((com.smartdigimkt.v0.i) fVar).c(i17);
                        l lVar2 = new l(e0VarC);
                        int i19 = sVar.a;
                        if (sparseArray4.size() == 1) {
                            jVar = (j) sparseArray4.valueAt(0);
                        } else {
                            jVar = (j) sparseArray4.get(i19);
                            jVar.getClass();
                        }
                        lVar2.c = sVar;
                        jVar.getClass();
                        lVar2.d = jVar;
                        e0VarC.a(sVar.f);
                        lVar2.a();
                        mVar2.c.put(sVar.a, lVar2);
                        mVar2.s = Math.max(mVar2.s, sVar.e);
                    }
                    a();
                    com.smartdigimkt.v0.i iVar = (com.smartdigimkt.v0.i) mVar2.z;
                    iVar.s = true;
                    iVar.n.post(iVar.l);
                } else {
                    if (mVar2.c.size() != size3) {
                        throw new IllegalStateException();
                    }
                    for (int i20 = 0; i20 < size3; i20++) {
                        s sVar2 = (s) sparseArray3.valueAt(i20);
                        l lVar3 = (l) mVar2.c.get(sVar2.a);
                        int i21 = sVar2.a;
                        if (sparseArray4.size() == 1) {
                            jVar2 = (j) sparseArray4.valueAt(0);
                        } else {
                            jVar2 = (j) sparseArray4.get(i21);
                            jVar2.getClass();
                        }
                        lVar3.getClass();
                        lVar3.c = sVar2;
                        jVar2.getClass();
                        lVar3.d = jVar2;
                        lVar3.a.a(sVar2.f);
                        lVar3.a();
                    }
                }
            } else {
                if (i10 == c.L) {
                    SparseArray sparseArray5 = mVar2.c;
                    int i22 = mVar2.a;
                    byte[] bArr4 = mVar2.h;
                    int size4 = aVar3.R0.size();
                    int i23 = 0;
                    while (i23 < size4) {
                        a aVar5 = (a) aVar3.R0.get(i23);
                        if (aVar5.a == c.M) {
                            com.smartdigimkt.z0.m mVar5 = aVar5.c(c.y).P0;
                            mVar5.c(i12);
                            int iA2 = mVar5.a();
                            int iA3 = mVar5.a();
                            if (sparseArray5.size() == 1) {
                                lVar = (l) sparseArray5.valueAt(0);
                            } else {
                                lVar = (l) sparseArray5.get(iA3);
                            }
                            if (lVar == null) {
                                lVar = null;
                            } else {
                                if ((iA2 & 1) != 0) {
                                    long jI = mVar5.i();
                                    u uVar = lVar.b;
                                    uVar.b = jI;
                                    uVar.c = jI;
                                }
                                j jVar3 = lVar.d;
                                if ((iA2 & 2) != 0) {
                                    iH = mVar5.h() - 1;
                                } else {
                                    iH = jVar3.a;
                                }
                                if ((iA2 & 8) != 0) {
                                    iH2 = mVar5.h();
                                } else {
                                    iH2 = jVar3.b;
                                }
                                if ((iA2 & 16) != 0) {
                                    iH3 = mVar5.h();
                                } else {
                                    iH3 = jVar3.c;
                                }
                                if ((iA2 & 32) != 0) {
                                    iH4 = mVar5.h();
                                } else {
                                    iH4 = jVar3.d;
                                }
                                lVar.b.a = new j(iH, iH2, iH3, iH4);
                            }
                            if (lVar == null) {
                                aVar = aVar3;
                                i = i22;
                                i2 = size4;
                                i3 = i23;
                                bArr = bArr4;
                                i4 = i12;
                            } else {
                                u uVar2 = lVar.b;
                                long jI2 = uVar2.r;
                                lVar.a();
                                int i24 = c.x;
                                if (aVar5.c(i24) != null && (i22 & 2) == 0) {
                                    com.smartdigimkt.z0.m mVar6 = aVar5.c(i24).P0;
                                    mVar6.c(i12);
                                    jI2 = ((mVar6.a() >> 24) & 255) == 1 ? mVar6.i() : mVar6.f();
                                }
                                ArrayList arrayList = aVar5.Q0;
                                int size5 = arrayList.size();
                                int i25 = 0;
                                int i26 = 0;
                                int i27 = 0;
                                while (i27 < size5) {
                                    int i28 = size4;
                                    b bVar2 = (b) arrayList.get(i27);
                                    long j4 = jI2;
                                    if (bVar2.a == c.A) {
                                        com.smartdigimkt.z0.m mVar7 = bVar2.P0;
                                        mVar7.c(12);
                                        int iH7 = mVar7.h();
                                        if (iH7 > 0) {
                                            i26 += iH7;
                                            i25++;
                                        }
                                    }
                                    i27++;
                                    size4 = i28;
                                    jI2 = j4;
                                }
                                i2 = size4;
                                long j5 = jI2;
                                lVar.g = 0;
                                lVar.f = 0;
                                lVar.e = 0;
                                u uVar3 = lVar.b;
                                uVar3.d = i25;
                                uVar3.e = i26;
                                int[] iArr3 = uVar3.g;
                                if (iArr3 == null || iArr3.length < i25) {
                                    uVar3.f = new long[i25];
                                    uVar3.g = new int[i25];
                                }
                                int[] iArr4 = uVar3.h;
                                if (iArr4 == null || iArr4.length < i26) {
                                    int i29 = (i26 * 125) / 100;
                                    uVar3.h = new int[i29];
                                    uVar3.i = new int[i29];
                                    uVar3.j = new long[i29];
                                    uVar3.k = new boolean[i29];
                                    uVar3.m = new boolean[i29];
                                }
                                int i30 = 0;
                                int i31 = 0;
                                int i32 = 0;
                                while (i30 < size5) {
                                    b bVar3 = (b) arrayList.get(i30);
                                    if (bVar3.a == c.A) {
                                        int i33 = i31 + 1;
                                        com.smartdigimkt.z0.m mVar8 = bVar3.P0;
                                        mVar8.c(8);
                                        int iA4 = mVar8.a();
                                        s sVar3 = lVar.c;
                                        u uVar4 = lVar.b;
                                        j jVar4 = uVar4.a;
                                        uVar4.g[i31] = mVar8.h();
                                        long[] jArr2 = uVar4.f;
                                        long j6 = uVar4.b;
                                        jArr2[i31] = j6;
                                        if ((iA4 & 1) != 0) {
                                            jArr2[i31] = j6 + ((long) mVar8.a());
                                        }
                                        boolean z4 = (iA4 & 4) != 0;
                                        int iH8 = jVar4.d;
                                        if (z4) {
                                            iH8 = mVar8.h();
                                        }
                                        boolean z5 = (iA4 & 256) != 0;
                                        boolean z6 = (iA4 & 512) != 0;
                                        boolean z7 = (iA4 & 1024) != 0;
                                        int i34 = iH8;
                                        boolean z8 = (iA4 & 2048) != 0;
                                        long[] jArr3 = sVar3.h;
                                        if (jArr3 != null) {
                                            aVar2 = aVar5;
                                            if (jArr3.length == 1 && jArr3[0] == 0) {
                                                jA = com.smartdigimkt.z0.u.a(sVar3.i[0], 1000L, sVar3.c);
                                            }
                                            iArr = uVar4.h;
                                            iArr2 = uVar4.i;
                                            jArr = uVar4.j;
                                            zArr = uVar4.k;
                                            if (sVar3.b == 2 || (i22 & 1) == 0) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            i8 = i32 + uVar4.g[i31];
                                            j2 = sVar3.c;
                                            if (i31 > 0) {
                                                j3 = uVar4.r;
                                            } else {
                                                j3 = j5;
                                            }
                                            i9 = i32;
                                            while (i9 < i8) {
                                                if (z5) {
                                                    iH5 = mVar8.h();
                                                } else {
                                                    iH5 = jVar4.b;
                                                }
                                                if (z6) {
                                                    iH6 = mVar8.h();
                                                } else {
                                                    iH6 = jVar4.c;
                                                }
                                                if (i9 != 0 && z4) {
                                                    iA = i34;
                                                } else if (z7) {
                                                    iA = mVar8.a();
                                                } else {
                                                    iA = jVar4.d;
                                                }
                                                if (z8) {
                                                    iArr2[i9] = (int) ((((long) mVar8.a()) * 1000) / j2);
                                                } else {
                                                    iArr2[i9] = 0;
                                                }
                                                jArr[i9] = com.smartdigimkt.z0.u.a(j3, 1000L, j2) - jA;
                                                iArr[i9] = iH6;
                                                if (((iA >> 16) & 1) == 0 || (z2 && i9 != 0)) {
                                                    z3 = false;
                                                } else {
                                                    z3 = true;
                                                }
                                                zArr[i9] = z3;
                                                j3 += (long) iH5;
                                                i9++;
                                                z5 = z5;
                                                z4 = z4;
                                                i22 = i22;
                                                z8 = z8;
                                            }
                                            i7 = i22;
                                            uVar4.r = j3;
                                            i32 = i8;
                                            i31 = i33;
                                        } else {
                                            aVar2 = aVar5;
                                        }
                                        jA = 0;
                                        iArr = uVar4.h;
                                        iArr2 = uVar4.i;
                                        jArr = uVar4.j;
                                        zArr = uVar4.k;
                                        if (sVar3.b == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i8 = i32 + uVar4.g[i31];
                                        j2 = sVar3.c;
                                        if (i31 > 0) {
                                            j3 = uVar4.r;
                                        } else {
                                            j3 = j5;
                                        }
                                        i9 = i32;
                                        while (i9 < i8) {
                                            if (z5) {
                                                iH5 = mVar8.h();
                                            } else {
                                                iH5 = jVar4.b;
                                            }
                                            if (z6) {
                                                iH6 = mVar8.h();
                                            } else {
                                                iH6 = jVar4.c;
                                            }
                                            if (i9 != 0) {
                                                if (z7) {
                                                    iA = mVar8.a();
                                                } else {
                                                    iA = jVar4.d;
                                                }
                                            } else if (z7) {
                                                iA = mVar8.a();
                                            } else {
                                                iA = jVar4.d;
                                            }
                                            if (z8) {
                                                iArr2[i9] = (int) ((((long) mVar8.a()) * 1000) / j2);
                                            } else {
                                                iArr2[i9] = 0;
                                            }
                                            jArr[i9] = com.smartdigimkt.z0.u.a(j3, 1000L, j2) - jA;
                                            iArr[i9] = iH6;
                                            if (((iA >> 16) & 1) == 0) {
                                                z3 = false;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i9] = z3;
                                            j3 += (long) iH5;
                                            i9++;
                                            z5 = z5;
                                            z4 = z4;
                                            i22 = i22;
                                            z8 = z8;
                                        }
                                        i7 = i22;
                                        uVar4.r = j3;
                                        i32 = i8;
                                        i31 = i33;
                                    } else {
                                        i7 = i22;
                                        i23 = i23;
                                        aVar2 = aVar5;
                                    }
                                    i30++;
                                    arrayList = arrayList;
                                    size5 = size5;
                                    aVar3 = aVar3;
                                    i23 = i23;
                                    bArr4 = bArr4;
                                    aVar5 = aVar2;
                                    uVar2 = uVar2;
                                    lVar = lVar;
                                    i22 = i7;
                                }
                                aVar = aVar3;
                                i = i22;
                                byte[] bArr5 = bArr4;
                                u uVar5 = uVar2;
                                i3 = i23;
                                a aVar6 = aVar5;
                                s sVar4 = lVar.c;
                                int i35 = uVar5.a.a;
                                t[] tVarArr = sVar4.k;
                                t tVar = tVarArr == null ? null : tVarArr[i35];
                                b bVarC = aVar6.c(c.d0);
                                if (bVarC != null) {
                                    com.smartdigimkt.z0.m mVar9 = bVarC.P0;
                                    int i36 = tVar.c;
                                    mVar9.c(8);
                                    if ((mVar9.a() & 1) == 1) {
                                        mVar9.c(mVar9.b + 8);
                                    }
                                    int iE = mVar9.e();
                                    int iH9 = mVar9.h();
                                    if (iH9 == uVar5.e) {
                                        if (iE == 0) {
                                            boolean[] zArr2 = uVar5.m;
                                            i6 = 0;
                                            for (int i37 = 0; i37 < iH9; i37++) {
                                                int iE2 = mVar9.e();
                                                i6 += iE2;
                                                zArr2[i37] = iE2 > i36;
                                            }
                                        } else {
                                            i6 = iE * iH9;
                                            Arrays.fill(uVar5.m, 0, iH9, iE > i36);
                                        }
                                        com.smartdigimkt.z0.m mVar10 = uVar5.p;
                                        if (mVar10 == null || mVar10.c < i6) {
                                            uVar5.p = new com.smartdigimkt.z0.m(i6);
                                        }
                                        uVar5.o = i6;
                                        uVar5.l = true;
                                        uVar5.q = true;
                                    } else {
                                        throw new y("Length mismatch: " + iH9 + ", " + uVar5.e);
                                    }
                                }
                                b bVarC2 = aVar6.c(c.e0);
                                if (bVarC2 != null) {
                                    com.smartdigimkt.z0.m mVar11 = bVarC2.P0;
                                    mVar11.c(8);
                                    int iA5 = mVar11.a();
                                    if ((iA5 & 1) == 1) {
                                        mVar11.c(mVar11.b + 8);
                                    }
                                    int iH10 = mVar11.h();
                                    if (iH10 != 1) {
                                        throw new y("Unexpected saio entry count: " + iH10);
                                    }
                                    uVar5.c += ((iA5 >> 24) & 255) == 0 ? mVar11.f() : mVar11.i();
                                }
                                b bVarC3 = aVar6.c(c.i0);
                                if (bVarC3 != null) {
                                    a(bVarC3.P0, 0, uVar5);
                                }
                                b bVarC4 = aVar6.c(c.f0);
                                b bVarC5 = aVar6.c(c.g0);
                                if (bVarC4 != null && bVarC5 != null) {
                                    com.smartdigimkt.z0.m mVar12 = bVarC4.P0;
                                    com.smartdigimkt.z0.m mVar13 = bVarC5.P0;
                                    if (tVar != null) {
                                        str = tVar.a;
                                        i5 = 8;
                                    } else {
                                        i5 = 8;
                                        str = null;
                                    }
                                    mVar12.c(i5);
                                    int iA6 = mVar12.a();
                                    int iA7 = mVar12.a();
                                    int i38 = D;
                                    if (iA7 == i38) {
                                        if (((iA6 >> 24) & 255) == 1) {
                                            mVar12.c(mVar12.b + 4);
                                        }
                                        if (mVar12.a() == 1) {
                                            mVar13.c(8);
                                            int iA8 = mVar13.a();
                                            if (mVar13.a() == i38) {
                                                int i39 = (iA8 >> 24) & 255;
                                                if (i39 == 1) {
                                                    if (mVar13.f() == 0) {
                                                        throw new y("Variable length description in sgpd found (unsupported)");
                                                    }
                                                } else if (i39 >= 2) {
                                                    mVar13.c(mVar13.b + 4);
                                                }
                                                if (mVar13.f() == 1) {
                                                    mVar13.c(mVar13.b + 1);
                                                    int iE3 = mVar13.e();
                                                    int i40 = (iE3 & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) >> 4;
                                                    int i41 = iE3 & 15;
                                                    boolean z9 = mVar13.e() == 1;
                                                    if (z9) {
                                                        int iE4 = mVar13.e();
                                                        byte[] bArr6 = new byte[16];
                                                        mVar13.a(bArr6, 0, 16);
                                                        if (z9 && iE4 == 0) {
                                                            int iE5 = mVar13.e();
                                                            bArr3 = new byte[iE5];
                                                            mVar13.a(bArr3, 0, iE5);
                                                            z = true;
                                                        } else {
                                                            z = true;
                                                            bArr3 = null;
                                                        }
                                                        uVar5.l = z;
                                                        uVar5.n = new t(str, iE4, bArr6, i40, i41, bArr3);
                                                    }
                                                } else {
                                                    throw new y("Entry count in sgpd != 1 (unsupported).");
                                                }
                                            }
                                        } else {
                                            throw new y("Entry count in sbgp != 1 (unsupported).");
                                        }
                                    }
                                }
                                int size6 = aVar6.Q0.size();
                                int i42 = 0;
                                while (i42 < size6) {
                                    b bVar4 = (b) aVar6.Q0.get(i42);
                                    if (bVar4.a == c.h0) {
                                        com.smartdigimkt.z0.m mVar14 = bVar4.P0;
                                        mVar14.c(8);
                                        bArr2 = bArr5;
                                        mVar14.a(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, E)) {
                                            a(mVar14, 16, uVar5);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i42++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                                i4 = 8;
                            }
                        } else {
                            aVar = aVar3;
                            i = i22;
                            i2 = size4;
                            i3 = i23;
                            bArr = bArr4;
                            i4 = i12;
                        }
                        i23 = i3 + 1;
                        i12 = i4;
                        bArr4 = bArr;
                        sparseArray5 = sparseArray5;
                        size4 = i2;
                        aVar3 = aVar;
                        i22 = i;
                    }
                    com.smartdigimkt.m0.d dVarA2 = a(aVar3.Q0);
                    mVar = this;
                    if (dVarA2 != null) {
                        int size7 = mVar.c.size();
                        for (int i43 = 0; i43 < size7; i43++) {
                            l lVar4 = (l) mVar.c.valueAt(i43);
                            s sVar5 = lVar4.c;
                            int i44 = lVar4.b.a.a;
                            t[] tVarArr2 = sVar5.k;
                            t tVar2 = tVarArr2 == null ? null : tVarArr2[i44];
                            String str2 = tVar2 != null ? tVar2.a : null;
                            e0 e0Var = lVar4.a;
                            com.smartdigimkt.i0.s sVar6 = sVar5.f;
                            e0Var.a(new com.smartdigimkt.i0.s(sVar6.a, sVar6.e, sVar6.f, sVar6.c, sVar6.b, sVar6.g, sVar6.k, sVar6.l, sVar6.m, sVar6.n, sVar6.o, sVar6.q, sVar6.p, sVar6.r, sVar6.s, sVar6.t, sVar6.u, sVar6.v, sVar6.w, sVar6.x, sVar6.y, sVar6.z, sVar6.j, sVar6.h, com.smartdigimkt.z0.u.a(dVarA2.c, str2) ? dVarA2 : new com.smartdigimkt.m0.d(str2, dVarA2.a), sVar6.d));
                        }
                    }
                    if (mVar.r != -9223372036854775807L) {
                        int size8 = mVar.c.size();
                        for (int i45 = 0; i45 < size8; i45++) {
                            l lVar5 = (l) mVar.c.valueAt(i45);
                            long j7 = mVar.r;
                            lVar5.getClass();
                            long jB = com.smartdigimkt.i0.b.b(j7);
                            int i46 = lVar5.e;
                            while (true) {
                                u uVar6 = lVar5.b;
                                if (i46 >= uVar6.e || uVar6.j[i46] + ((long) uVar6.i[i46]) >= jB) {
                                    break;
                                }
                                if (uVar6.k[i46]) {
                                    lVar5.h = i46;
                                }
                                i46++;
                            }
                        }
                        mVar.r = -9223372036854775807L;
                    }
                } else {
                    mVar = mVar2;
                    if (!mVar.i.isEmpty()) {
                        ((a) mVar.i.peek()).R0.add(aVar3);
                    }
                }
                mVar2 = mVar;
            }
        }
        m mVar15 = mVar2;
        mVar15.k = 0;
        mVar15.n = 0;
    }

    public final void a() {
        int i;
        if (this.A == null) {
            e0[] e0VarArr = new e0[2];
            this.A = e0VarArr;
            if ((this.a & 4) != 0) {
                e0VarArr[0] = ((com.smartdigimkt.v0.i) this.z).c(this.c.size());
                i = 1;
            } else {
                i = 0;
            }
            e0[] e0VarArr2 = (e0[]) Arrays.copyOf(this.A, i);
            this.A = e0VarArr2;
            for (e0 e0Var : e0VarArr2) {
                e0Var.a(F);
            }
        }
        if (this.B == null) {
            this.B = new e0[this.b.size()];
            for (int i2 = 0; i2 < this.B.length; i2++) {
                e0 e0VarC = ((com.smartdigimkt.v0.i) this.z).c(this.c.size() + 1 + i2);
                e0VarC.a((com.smartdigimkt.i0.s) this.b.get(i2));
                this.B[i2] = e0VarC;
            }
        }
    }

    public static void a(com.smartdigimkt.z0.m mVar, int i, u uVar) throws y {
        mVar.c(i + 8);
        int iA = mVar.a();
        int i2 = c.b;
        if ((iA & 1) == 0) {
            boolean z = (iA & 2) != 0;
            int iH = mVar.h();
            if (iH == uVar.e) {
                Arrays.fill(uVar.m, 0, iH, z);
                int i3 = mVar.c - mVar.b;
                com.smartdigimkt.z0.m mVar2 = uVar.p;
                if (mVar2 == null || mVar2.c < i3) {
                    uVar.p = new com.smartdigimkt.z0.m(i3);
                }
                uVar.o = i3;
                uVar.l = true;
                uVar.q = true;
                mVar.a(uVar.p.a, 0, i3);
                uVar.p.c(0);
                uVar.q = false;
                return;
            }
            throw new y("Length mismatch: " + iH + ", " + uVar.e);
        }
        throw new y("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0077  */
    public static com.smartdigimkt.m0.d a(ArrayList arrayList) {
        q qVar;
        int iA;
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            int i2 = bVar.a;
            int i3 = c.V;
            if (i2 == i3) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.P0.a;
                com.smartdigimkt.z0.m mVar = new com.smartdigimkt.z0.m(bArr);
                if (mVar.c < 32) {
                    qVar = null;
                } else {
                    mVar.c(0);
                    if (mVar.a() == (mVar.c - mVar.b) + 4 && mVar.a() == i3 && (iA = (mVar.a() >> 24) & 255) <= 1) {
                        UUID uuid = new UUID(mVar.b(), mVar.b());
                        if (iA == 1) {
                            mVar.c(mVar.b + (mVar.h() * 16));
                        }
                        int iH = mVar.h();
                        if (iH != mVar.c - mVar.b) {
                            qVar = null;
                        } else {
                            mVar.a(new byte[iH], 0, iH);
                            qVar = new q(uuid);
                        }
                    } else {
                        qVar = null;
                    }
                }
                UUID uuid2 = qVar == null ? null : qVar.a;
                if (uuid2 != null) {
                    arrayList2.add(new com.smartdigimkt.m0.c(uuid2, bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new com.smartdigimkt.m0.d(null, (com.smartdigimkt.m0.c[]) arrayList2.toArray(new com.smartdigimkt.m0.c[arrayList2.size()]));
    }
}
