package com.smartdigimkt.v0;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements f0 {
    public final int a;
    public final /* synthetic */ i b;

    public h(i iVar, int i) {
        this.b = iVar;
        this.a = i;
    }

    @Override // com.smartdigimkt.v0.f0
    public final boolean a() {
        i iVar = this.b;
        return !iVar.w && iVar.H == -9223372036854775807L && (iVar.K || iVar.q[this.a].c.a());
    }

    @Override // com.smartdigimkt.v0.f0
    public final void b() throws IOException {
        i iVar = this.b;
        com.smartdigimkt.y0.a0 a0Var = iVar.i;
        int i = iVar.u;
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

    @Override // com.smartdigimkt.v0.f0
    public final int a(com.smartdigimkt.i0.t tVar, com.smartdigimkt.l0.e eVar, boolean z) {
        int iJ;
        byte b;
        int i;
        int i2;
        i iVar = this.b;
        int i3 = this.a;
        if (iVar.w || iVar.H != -9223372036854775807L) {
            return -3;
        }
        e0 e0Var = iVar.q[i3];
        boolean z2 = iVar.K;
        long j = iVar.G;
        b0 b0Var = e0Var.c;
        com.smartdigimkt.i0.s sVar = e0Var.i;
        a0 a0Var = e0Var.d;
        synchronized (b0Var) {
            iJ = 1;
            if (b0Var.a()) {
                int iC = b0Var.c(b0Var.l);
                if (!z && b0Var.h[iC] == sVar) {
                    if (eVar.b == null && eVar.e == 0) {
                        b = -3;
                    } else {
                        eVar.c = b0Var.f[iC];
                        eVar.a = b0Var.e[iC];
                        a0Var.a = b0Var.d[iC];
                        a0Var.b = b0Var.c[iC];
                        a0Var.c = b0Var.g[iC];
                        b0Var.l++;
                        b = -4;
                    }
                }
                tVar.a = b0Var.h[iC];
                b = -5;
            } else if (z2) {
                eVar.a = 4;
                b = -4;
            } else {
                com.smartdigimkt.i0.s sVar2 = b0Var.q;
                if (sVar2 == null || (!z && sVar2 == sVar)) {
                    b = -3;
                } else {
                    tVar.a = sVar2;
                    b = -5;
                }
            }
        }
        if (b == -5) {
            e0Var.i = tVar.a;
            i = -5;
            i2 = -4;
        } else if (b == -4) {
            if (!eVar.b(4)) {
                if (eVar.c < j) {
                    eVar.a = Integer.MIN_VALUE | eVar.a;
                }
                if (eVar.b(C.ENCODING_PCM_32BIT)) {
                    a0 a0Var2 = e0Var.d;
                    long j2 = a0Var2.b;
                    e0Var.e.b(1);
                    e0Var.a(j2, e0Var.e.a, 1);
                    long j3 = j2 + 1;
                    byte b2 = e0Var.e.a[0];
                    boolean z3 = (b2 & 128) != 0;
                    int i4 = b2 & 127;
                    com.smartdigimkt.l0.c cVar = eVar.d;
                    if (cVar.a == null) {
                        cVar.a = new byte[16];
                    }
                    e0Var.a(j3, cVar.a, i4);
                    long j4 = j3 + ((long) i4);
                    if (z3) {
                        e0Var.e.b(2);
                        e0Var.a(j4, e0Var.e.a, 2);
                        j4 += 2;
                        iJ = e0Var.e.j();
                    }
                    com.smartdigimkt.l0.c cVar2 = eVar.d;
                    int[] iArr = cVar2.b;
                    if (iArr == null || iArr.length < iJ) {
                        iArr = new int[iJ];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = cVar2.c;
                    if (iArr3 == null || iArr3.length < iJ) {
                        iArr3 = new int[iJ];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i5 = iJ * 6;
                        e0Var.e.b(i5);
                        e0Var.a(j4, e0Var.e.a, i5);
                        j4 += (long) i5;
                        e0Var.e.c(0);
                        for (int i6 = 0; i6 < iJ; i6++) {
                            iArr2[i6] = e0Var.e.j();
                            iArr4[i6] = e0Var.e.h();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = a0Var2.a - ((int) (j4 - a0Var2.b));
                    }
                    com.smartdigimkt.n0.n nVar = a0Var2.c;
                    com.smartdigimkt.l0.c cVar3 = eVar.d;
                    cVar3.a(iJ, iArr2, iArr4, nVar.b, cVar3.a, nVar.a, nVar.c, nVar.d);
                    long j5 = a0Var2.b;
                    int i7 = (int) (j4 - j5);
                    a0Var2.b = j5 + ((long) i7);
                    a0Var2.a -= i7;
                }
                int i8 = e0Var.d.a;
                ByteBuffer byteBuffer = eVar.b;
                if (byteBuffer == null) {
                    eVar.b = eVar.a(i8);
                } else {
                    int iCapacity = byteBuffer.capacity();
                    int iPosition = eVar.b.position();
                    int i9 = i8 + iPosition;
                    if (iCapacity < i9) {
                        ByteBuffer byteBufferA = eVar.a(i9);
                        if (iPosition > 0) {
                            eVar.b.position(0);
                            eVar.b.limit(iPosition);
                            byteBufferA.put(eVar.b);
                        }
                        eVar.b = byteBufferA;
                    }
                }
                a0 a0Var3 = e0Var.d;
                long j6 = a0Var3.b;
                ByteBuffer byteBuffer2 = eVar.b;
                int i10 = a0Var3.a;
                while (true) {
                    c0 c0Var = e0Var.g;
                    if (j6 < c0Var.b) {
                        break;
                    }
                    e0Var.g = c0Var.e;
                }
                while (i10 > 0) {
                    int iMin = Math.min(i10, (int) (e0Var.g.b - j6));
                    c0 c0Var2 = e0Var.g;
                    com.smartdigimkt.y0.a aVar = c0Var2.d;
                    byteBuffer2.put(aVar.a, ((int) (j6 - c0Var2.a)) + aVar.b, iMin);
                    i10 -= iMin;
                    j6 += (long) iMin;
                    c0 c0Var3 = e0Var.g;
                    if (j6 == c0Var3.b) {
                        e0Var.g = c0Var3.e;
                    }
                }
            }
            i2 = -4;
            i = -4;
        } else {
            if (b != -3) {
                throw new IllegalStateException();
            }
            i2 = -4;
            i = -3;
        }
        if (i == i2) {
            iVar.a(i3);
        } else if (i == -3) {
            iVar.b(i3);
        }
        return i;
    }

    @Override // com.smartdigimkt.v0.f0
    public final int a(long j) {
        int i;
        i iVar = this.b;
        int i2 = this.a;
        int i3 = 0;
        if (!iVar.w && iVar.H == -9223372036854775807L) {
            e0 e0Var = iVar.q[i2];
            if (iVar.K && j > e0Var.b()) {
                b0 b0Var = e0Var.c;
                synchronized (b0Var) {
                    int i4 = b0Var.i;
                    i = i4 - b0Var.l;
                    b0Var.l = i4;
                }
                i3 = i;
            } else {
                int iA = e0Var.a(j, true);
                if (iA != -1) {
                    i3 = iA;
                }
            }
            if (i3 > 0) {
                iVar.a(i2);
            } else {
                iVar.b(i2);
            }
        }
        return i3;
    }
}
