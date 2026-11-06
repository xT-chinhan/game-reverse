package com.bytedance.sdk.component.ah.ms;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class h extends c {
    final transient int[] ab;
    final transient byte[][] c;

    h(ah ahVar, int i) {
        super(null);
        nw.ms(ahVar.xr, 0L, i);
        ub ubVar = ahVar.f1003ms;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (ubVar.ah == ubVar.xr) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += ubVar.ah - ubVar.xr;
            i4++;
            ubVar = ubVar.c;
        }
        this.c = new byte[i4][];
        this.ab = new int[i4 * 2];
        ub ubVar2 = ahVar.f1003ms;
        int i5 = 0;
        while (i2 < i) {
            this.c[i5] = ubVar2.f1020ms;
            i2 += ubVar2.ah - ubVar2.xr;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.ab;
            iArr[i5] = i2;
            iArr[this.c.length + i5] = ubVar2.xr;
            ubVar2.d = true;
            i5++;
            ubVar2 = ubVar2.c;
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public String ms() {
        return ny().ms();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public String xr() {
        return ny().xr();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public String ka() {
        return ny().ka();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public c c() {
        return ny().c();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public c ah() {
        return ny().ah();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public c d() {
        return ny().d();
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public c ms(int i, int i2) {
        return ny().ms(i, i2);
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public byte ms(int i) {
        nw.ms(this.ab[this.c.length - 1], i, 1L);
        int iXr = xr(i);
        int i2 = iXr == 0 ? 0 : this.ab[iXr - 1];
        int[] iArr = this.ab;
        byte[][] bArr = this.c;
        return bArr[iXr][(i - i2) + iArr[bArr.length + iXr]];
    }

    private int xr(int i) {
        int iBinarySearch = Arrays.binarySearch(this.ab, 0, this.c.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public int ab() {
        return this.ab[this.c.length - 1];
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public byte[] x() {
        int[] iArr = this.ab;
        byte[][] bArr = this.c;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.ab;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.c[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    void ms(ah ahVar) {
        int length = this.c.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.ab;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            ub ubVar = new ub(this.c[i], i3, (i3 + i4) - i2, true, false);
            if (ahVar.f1003ms == null) {
                ubVar.ab = ubVar;
                ubVar.c = ubVar;
                ahVar.f1003ms = ubVar;
            } else {
                ahVar.f1003ms.ab.ms(ubVar);
            }
            i++;
            i2 = i4;
        }
        ahVar.xr += (long) i2;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public boolean ms(int i, c cVar, int i2, int i3) {
        if (i < 0 || i > ab() - i3) {
            return false;
        }
        int iXr = xr(i);
        while (i3 > 0) {
            int i4 = iXr == 0 ? 0 : this.ab[iXr - 1];
            int iMin = Math.min(i3, ((this.ab[iXr] - i4) + i4) - i);
            int[] iArr = this.ab;
            byte[][] bArr = this.c;
            if (!cVar.ms(i2, bArr[iXr], (i - i4) + iArr[bArr.length + iXr], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iXr++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public boolean ms(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > ab() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iXr = xr(i);
        while (i3 > 0) {
            int i4 = iXr == 0 ? 0 : this.ab[iXr - 1];
            int iMin = Math.min(i3, ((this.ab[iXr] - i4) + i4) - i);
            int[] iArr = this.ab;
            byte[][] bArr2 = this.c;
            if (!nw.ms(bArr2[iXr], (i - i4) + iArr[bArr2.length + iXr], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iXr++;
        }
        return true;
    }

    private c ny() {
        return new c(x());
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.ab() == ab() && ms(0, cVar, 0, ab())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.c.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.c[i2];
            int[] iArr = this.ab;
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
        this.d = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.ah.ms.c
    public String toString() {
        return ny().toString();
    }
}
