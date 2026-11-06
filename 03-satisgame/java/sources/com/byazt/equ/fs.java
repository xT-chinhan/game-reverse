package com.byazt.equ;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 101})
public final class fs extends q {
    public final transient int[] fs;
    public final transient byte[][] x;

    public fs(n nVar, int i) {
        super(null);
        tj.n(nVar.qg, 0L, i);
        w wVar = nVar.n;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (wVar.s == wVar.qg) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += wVar.s - wVar.qg;
            i4++;
            wVar = wVar.w;
        }
        this.x = new byte[i4][];
        this.fs = new int[i4 * 2];
        w wVar2 = nVar.n;
        int i5 = 0;
        while (i2 < i) {
            this.x[i5] = wVar2.n;
            i2 += wVar2.s - wVar2.qg;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.fs;
            iArr[i5] = i2;
            iArr[this.x.length + i5] = wVar2.qg;
            wVar2.q = true;
            i5++;
            wVar2 = wVar2.w;
        }
    }

    @Override // com.byazt.equ.q
    public String n() {
        return l().n();
    }

    @Override // com.byazt.equ.q
    public String qg() {
        return l().qg();
    }

    @Override // com.byazt.equ.q
    public q n(int i, int i2) {
        return l().n(i, i2);
    }

    @Override // com.byazt.equ.q
    public byte n(int i) {
        tj.n(this.fs[this.x.length - 1], i, 1L);
        int iQg = qg(i);
        int i2 = iQg == 0 ? 0 : this.fs[iQg - 1];
        int[] iArr = this.fs;
        byte[][] bArr = this.x;
        return bArr[iQg][(i - i2) + iArr[bArr.length + iQg]];
    }

    private int qg(int i) {
        int iBinarySearch = Arrays.binarySearch(this.fs, 0, this.x.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.equ.q
    public int s() {
        return this.fs[this.x.length - 1];
    }

    @Override // com.byazt.equ.q
    public byte[] q() {
        int[] iArr = this.fs;
        byte[][] bArr = this.x;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.fs;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.x[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.byazt.equ.q
    public boolean n(int i, q qVar, int i2, int i3) {
        if (i < 0 || i > s() - i3) {
            return false;
        }
        int iQg = qg(i);
        while (i3 > 0) {
            int i4 = iQg == 0 ? 0 : this.fs[iQg - 1];
            int iMin = Math.min(i3, ((this.fs[iQg] - i4) + i4) - i);
            int[] iArr = this.fs;
            byte[][] bArr = this.x;
            if (!qVar.n(i2, bArr[iQg], (i - i4) + iArr[bArr.length + iQg], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iQg++;
        }
        return true;
    }

    @Override // com.byazt.equ.q
    public boolean n(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > s() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iQg = qg(i);
        while (i3 > 0) {
            int i4 = iQg == 0 ? 0 : this.fs[iQg - 1];
            int iMin = Math.min(i3, ((this.fs[iQg] - i4) + i4) - i);
            int[] iArr = this.fs;
            byte[][] bArr2 = this.x;
            if (!tj.n(bArr2[iQg], (i - i4) + iArr[bArr2.length + iQg], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iQg++;
        }
        return true;
    }

    private q l() {
        return new q(q());
    }

    @Override // com.byazt.equ.q
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (qVar.s() == s() && n(0, qVar, 0, s())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.equ.q
    public int hashCode() {
        int i = this.l;
        if (i != 0) {
            return i;
        }
        int length = this.x.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.x[i2];
            int[] iArr = this.fs;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.l = i3;
        return i3;
    }

    @Override // com.byazt.equ.q
    public String toString() {
        return l().toString();
    }
}
