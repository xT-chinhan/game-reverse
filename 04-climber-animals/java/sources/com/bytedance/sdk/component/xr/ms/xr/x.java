package com.bytedance.sdk.component.xr.ms.xr;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class x extends d {
    final transient byte[][] ab;
    final transient int[] x;

    x(ms msVar, int i) {
        super(null);
        ch.ms(msVar.xr, 0L, i);
        c cVar = msVar.f1629ms;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (cVar.ah == cVar.xr) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += cVar.ah - cVar.xr;
            i4++;
            cVar = cVar.c;
        }
        this.ab = new byte[i4][];
        this.x = new int[i4 * 2];
        c cVar2 = msVar.f1629ms;
        int i5 = 0;
        while (i2 < i) {
            this.ab[i5] = cVar2.f1626ms;
            i2 += cVar2.ah - cVar2.xr;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.x;
            iArr[i5] = i2;
            iArr[this.ab.length + i5] = cVar2.xr;
            cVar2.d = true;
            i5++;
            cVar2 = cVar2.c;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public String ms() {
        return ka().ms();
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public String xr() {
        return ka().xr();
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public d ms(int i, int i2) {
        return ka().ms(i, i2);
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public byte ms(int i) {
        ch.ms(this.x[this.ab.length - 1], i, 1L);
        int iXr = xr(i);
        int i2 = iXr == 0 ? 0 : this.x[iXr - 1];
        int[] iArr = this.x;
        byte[][] bArr = this.ab;
        return bArr[iXr][(i - i2) + iArr[bArr.length + iXr]];
    }

    private int xr(int i) {
        int iBinarySearch = Arrays.binarySearch(this.x, 0, this.ab.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public int ah() {
        return this.x[this.ab.length - 1];
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public byte[] d() {
        int[] iArr = this.x;
        byte[][] bArr = this.ab;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.x;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.ab[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public boolean ms(int i, d dVar, int i2, int i3) {
        if (i < 0 || i > ah() - i3) {
            return false;
        }
        int iXr = xr(i);
        while (i3 > 0) {
            int i4 = iXr == 0 ? 0 : this.x[iXr - 1];
            int iMin = Math.min(i3, ((this.x[iXr] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr = this.ab;
            if (!dVar.ms(i2, bArr[iXr], (i - i4) + iArr[bArr.length + iXr], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iXr++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public boolean ms(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > ah() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iXr = xr(i);
        while (i3 > 0) {
            int i4 = iXr == 0 ? 0 : this.x[iXr - 1];
            int iMin = Math.min(i3, ((this.x[iXr] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr2 = this.ab;
            if (!ch.ms(bArr2[iXr], (i - i4) + iArr[bArr2.length + iXr], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iXr++;
        }
        return true;
    }

    private d ka() {
        return new d(d());
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.ah() == ah() && ms(0, dVar, 0, ah())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public int hashCode() {
        int i = this.ka;
        if (i != 0) {
            return i;
        }
        int length = this.ab.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.ab[i2];
            int[] iArr = this.x;
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
        this.ka = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr.d
    public String toString() {
        return ka().toString();
    }
}
