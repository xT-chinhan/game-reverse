package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public final class hd extends w {
    public final transient byte[][] w;
    public final transient int[] x;

    public hd(s sVar, int i) {
        super(null);
        py.n(sVar.qg, 0L, i);
        k kVar = sVar.n;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (kVar.s == kVar.qg) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += kVar.s - kVar.qg;
            i4++;
            kVar = kVar.w;
        }
        this.w = new byte[i4][];
        this.x = new int[i4 * 2];
        k kVar2 = sVar.n;
        int i5 = 0;
        while (i2 < i) {
            this.w[i5] = kVar2.n;
            i2 += kVar2.s - kVar2.qg;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.x;
            iArr[i5] = i2;
            iArr[this.w.length + i5] = kVar2.qg;
            kVar2.q = true;
            i5++;
            kVar2 = kVar2.w;
        }
    }

    @Override // com.byazt.wa.w
    public String n() {
        return rv().n();
    }

    @Override // com.byazt.wa.w
    public String qg() {
        return rv().qg();
    }

    @Override // com.byazt.wa.w
    public String l() {
        return rv().l();
    }

    @Override // com.byazt.wa.w
    public w w() {
        return rv().w();
    }

    @Override // com.byazt.wa.w
    public w s() {
        return rv().s();
    }

    @Override // com.byazt.wa.w
    public w q() {
        return rv().q();
    }

    @Override // com.byazt.wa.w
    public w n(int i, int i2) {
        return rv().n(i, i2);
    }

    @Override // com.byazt.wa.w
    public byte n(int i) {
        py.n(this.x[this.w.length - 1], i, 1L);
        int iQg = qg(i);
        int i2 = iQg == 0 ? 0 : this.x[iQg - 1];
        int[] iArr = this.x;
        byte[][] bArr = this.w;
        return bArr[iQg][(i - i2) + iArr[bArr.length + iQg]];
    }

    private int qg(int i) {
        int iBinarySearch = Arrays.binarySearch(this.x, 0, this.w.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.wa.w
    public int x() {
        return this.x[this.w.length - 1];
    }

    @Override // com.byazt.wa.w
    public byte[] fs() {
        int[] iArr = this.x;
        byte[][] bArr = this.w;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.x;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.w[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.byazt.wa.w
    public void n(s sVar) {
        int length = this.w.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.x;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            k kVar = new k(this.w[i], i3, (i3 + i4) - i2, true, false);
            if (sVar.n == null) {
                kVar.x = kVar;
                kVar.w = kVar;
                sVar.n = kVar;
            } else {
                sVar.n.x.n(kVar);
            }
            i++;
            i2 = i4;
        }
        sVar.qg += (long) i2;
    }

    @Override // com.byazt.wa.w
    public boolean n(int i, w wVar, int i2, int i3) {
        if (i < 0 || i > x() - i3) {
            return false;
        }
        int iQg = qg(i);
        while (i3 > 0) {
            int i4 = iQg == 0 ? 0 : this.x[iQg - 1];
            int iMin = Math.min(i3, ((this.x[iQg] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr = this.w;
            if (!wVar.n(i2, bArr[iQg], (i - i4) + iArr[bArr.length + iQg], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iQg++;
        }
        return true;
    }

    @Override // com.byazt.wa.w
    public boolean n(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > x() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iQg = qg(i);
        while (i3 > 0) {
            int i4 = iQg == 0 ? 0 : this.x[iQg - 1];
            int iMin = Math.min(i3, ((this.x[iQg] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr2 = this.w;
            if (!py.n(bArr2[iQg], (i - i4) + iArr[bArr2.length + iQg], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iQg++;
        }
        return true;
    }

    private w rv() {
        return new w(fs());
    }

    @Override // com.byazt.wa.w
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (wVar.x() == x() && n(0, wVar, 0, x())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.wa.w
    public int hashCode() {
        int i = this.q;
        if (i != 0) {
            return i;
        }
        int length = this.w.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.w[i2];
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
        this.q = i3;
        return i3;
    }

    @Override // com.byazt.wa.w
    public String toString() {
        return rv().toString();
    }
}
