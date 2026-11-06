package com.smartdigimkt.i0;

import android.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final k0 a = new k0();
    public final l0 b = new l0();
    public long c;
    public m0 d;
    public int e;
    public boolean f;
    public v g;
    public v h;
    public v i;
    public int j;
    public Object k;
    public long l;

    public final v a() {
        v vVar = this.g;
        if (vVar != null) {
            if (vVar == this.h) {
                this.h = vVar.e;
            }
            vVar.a();
            int i = this.j - 1;
            this.j = i;
            if (i == 0) {
                this.i = null;
                v vVar2 = this.g;
                this.k = vVar2.i;
                this.l = vVar2.d.a.d;
            }
            this.g = this.g.e;
        } else {
            v vVar3 = this.i;
            this.g = vVar3;
            this.h = vVar3;
        }
        return this.g;
    }

    public final v b() {
        return c() ? this.g : this.i;
    }

    public final boolean c() {
        return this.g != null;
    }

    public final boolean d() {
        v vVar;
        v vVarB = b();
        if (vVarB == null) {
            return true;
        }
        while (true) {
            int iA = this.d.a(vVarB.d.a.a, this.a, this.b, this.e, this.f);
            while (true) {
                vVar = vVarB.e;
                if (vVar == null || vVarB.d.f) {
                    break;
                }
                vVarB = vVar;
            }
            if (iA == -1 || vVar == null || vVar.d.a.a != iA) {
                break;
            }
            vVarB = vVar;
        }
        boolean zA = a(vVarB);
        w wVar = vVarB.d;
        vVarB.d = a(wVar, wVar.a);
        return (zA && c()) ? false : true;
    }

    public final boolean a(v vVar) {
        if (vVar != null) {
            this.i = vVar;
            boolean z = false;
            while (true) {
                vVar = vVar.e;
                if (vVar != null) {
                    if (vVar == this.h) {
                        this.h = this.g;
                        z = true;
                    }
                    vVar.a();
                    this.j--;
                } else {
                    this.i.e = null;
                    return z;
                }
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final void a(boolean z) {
        v vVarB = b();
        if (vVarB != null) {
            this.k = z ? vVarB.i : null;
            this.l = vVarB.d.a.d;
            vVarB.a();
            a(vVarB);
        } else if (!z) {
            this.k = null;
        }
        this.g = null;
        this.i = null;
        this.h = null;
        this.j = 0;
    }

    public final com.smartdigimkt.v0.m a(int i, long j) {
        long j2;
        int i2;
        int iA;
        Object obj = this.d.a(i, this.a, true).a;
        int i3 = this.a.b;
        Object obj2 = this.k;
        int i4 = 0;
        if (obj2 != null && (iA = this.d.a(obj2)) != -1 && this.d.a(iA, this.a, false).b == i3) {
            j2 = this.l;
        } else {
            v vVarB = b();
            while (true) {
                if (vVarB != null) {
                    if (vVarB.i.equals(obj)) {
                        j2 = vVarB.d.a.d;
                        break;
                    }
                    vVarB = vVarB.e;
                } else {
                    v vVarB2 = b();
                    while (true) {
                        if (vVarB2 != null) {
                            int iA2 = this.d.a(vVarB2.i);
                            if (iA2 != -1 && this.d.a(iA2, this.a, false).b == i3) {
                                j2 = vVarB2.d.a.d;
                                break;
                            }
                            vVarB2 = vVarB2.e;
                        } else {
                            j2 = this.c;
                            this.c = 1 + j2;
                            break;
                        }
                    }
                }
            }
        }
        this.d.a(i, this.a, false);
        int iB = this.a.b(j);
        if (iB == -1) {
            return new com.smartdigimkt.v0.m(i, -1, -1, j2);
        }
        com.smartdigimkt.w0.a aVar = this.a.e.c[iB];
        while (true) {
            int[] iArr = aVar.a;
            if (i4 >= iArr.length || (i2 = iArr[i4]) == 0 || i2 == 1) {
                break;
            }
            i4++;
        }
        return new com.smartdigimkt.v0.m(i, iB, i4, j2);
    }

    public final w a(v vVar, long j) {
        int i;
        int i2;
        long j2;
        long jLongValue;
        com.smartdigimkt.v0.m mVar;
        int i3;
        long j3;
        w wVar = vVar.d;
        int i4 = 0;
        if (wVar.f) {
            int iA = this.d.a(wVar.a.a, this.a, this.b, this.e, this.f);
            if (iA == -1) {
                return null;
            }
            int i5 = this.d.a(iA, this.a, true).b;
            Object obj = this.a.a;
            long j4 = wVar.a.d;
            if (this.d.a(i5, this.b, 0L).c == iA) {
                Pair pairA = this.d.a(this.b, this.a, i5, -9223372036854775807L, Math.max(0L, (vVar.a + wVar.e) - j));
                if (pairA == null) {
                    return null;
                }
                iA = ((Integer) pairA.first).intValue();
                jLongValue = ((Long) pairA.second).longValue();
                v vVar2 = vVar.e;
                if (vVar2 != null && vVar2.i.equals(obj)) {
                    j3 = vVar.e.d.a.d;
                } else {
                    j3 = this.c;
                    this.c = 1 + j3;
                }
                j2 = j3;
            } else {
                j2 = j4;
                jLongValue = 0;
            }
            int i6 = iA;
            this.d.a(i6, this.a, false);
            int iB = this.a.b(jLongValue);
            if (iB == -1) {
                mVar = new com.smartdigimkt.v0.m(i6, -1, -1, j2);
            } else {
                com.smartdigimkt.w0.a aVar = this.a.e.c[iB];
                int i7 = 0;
                while (true) {
                    int[] iArr = aVar.a;
                    if (i7 >= iArr.length || (i3 = iArr[i7]) == 0 || i3 == 1) {
                        break;
                    }
                    i7++;
                }
                mVar = new com.smartdigimkt.v0.m(i6, iB, i7, j2);
            }
            this.d.a(mVar.a, this.a, false);
            if (mVar.a()) {
                this.a.e.c[mVar.b].getClass();
                return null;
            }
            return a(mVar.a, jLongValue, mVar.d);
        }
        com.smartdigimkt.v0.m mVar2 = wVar.a;
        this.d.a(mVar2.a, this.a, false);
        if (mVar2.a()) {
            this.a.e.c[mVar2.b].getClass();
            return null;
        }
        long j5 = wVar.c;
        if (j5 != Long.MIN_VALUE) {
            int iB2 = this.a.b(j5);
            if (iB2 == -1) {
                return a(mVar2.a, wVar.c, mVar2.d);
            }
            com.smartdigimkt.w0.a aVar2 = this.a.e.c[iB2];
            while (true) {
                int[] iArr2 = aVar2.a;
                if (i4 >= iArr2.length || (i2 = iArr2[i4]) == 0 || i2 == 1) {
                    break;
                }
                i4++;
            }
            this.a.e.c[iB2].getClass();
            return null;
        }
        com.smartdigimkt.w0.b bVar = this.a.e;
        int i8 = bVar.a;
        if (i8 == 0) {
            return null;
        }
        int i9 = i8 - 1;
        if (bVar.b[i9] == Long.MIN_VALUE) {
            bVar.c[i9].getClass();
            com.smartdigimkt.w0.a aVar3 = this.a.e.c[i9];
            while (true) {
                int[] iArr3 = aVar3.a;
                if (i4 >= iArr3.length || (i = iArr3[i4]) == 0 || i == 1) {
                    break;
                }
                i4++;
            }
            this.a.e.c[i9].getClass();
        }
        return null;
    }

    public final w a(w wVar, com.smartdigimkt.v0.m mVar) {
        long j;
        long j2;
        long j3 = wVar.b;
        long j4 = wVar.c;
        boolean zA = a(mVar, j4);
        boolean zA2 = a(mVar, zA);
        this.d.a(mVar.a, this.a, false);
        if (mVar.a()) {
            k0 k0Var = this.a;
            k0Var.e.c[mVar.b].getClass();
            j2 = -9223372036854775807L;
        } else {
            if (j4 == Long.MIN_VALUE) {
                j2 = this.a.c;
            } else {
                j = j4;
            }
            return new w(mVar, j3, j4, wVar.d, j, zA, zA2);
        }
        j = j2;
        return new w(mVar, j3, j4, wVar.d, j, zA, zA2);
    }

    public final w a(int i, long j, long j2) {
        com.smartdigimkt.v0.m mVar = new com.smartdigimkt.v0.m(i, -1, -1, j2);
        this.d.a(i, this.a, false);
        int iA = this.a.a(j);
        long j3 = iA == -1 ? Long.MIN_VALUE : this.a.e.b[iA];
        boolean zA = a(mVar, j3);
        return new w(mVar, j, j3, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.a.c : j3, zA, a(mVar, zA));
    }

    public final boolean a(com.smartdigimkt.v0.m mVar, long j) {
        int i = this.d.a(mVar.a, this.a, false).e.a;
        if (i == 0) {
            return true;
        }
        int i2 = i - 1;
        boolean zA = mVar.a();
        com.smartdigimkt.w0.b bVar = this.a.e;
        if (bVar.b[i2] != Long.MIN_VALUE) {
            return !zA && j == Long.MIN_VALUE;
        }
        bVar.c[i2].getClass();
        return false;
    }

    public final boolean a(com.smartdigimkt.v0.m mVar, boolean z) {
        return !this.d.a(this.d.a(mVar.a, this.a, false).b, this.b).b && this.d.a(mVar.a, this.a, this.b, this.e, this.f) == -1 && z;
    }
}
