package com.byazt.qm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo extends x {
    public final transient byte[][] fw;
    public final transient int[] zo;

    public zo(pr prVar, int i) {
        super(null);
        vk.pr(prVar.hw, 0L, i);
        uc ucVar = prVar.pr;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (ucVar.hn == ucVar.hw) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += ucVar.hn - ucVar.hw;
            i4++;
            ucVar = ucVar.uc;
        }
        this.fw = new byte[i4][];
        this.zo = new int[i4 * 2];
        uc ucVar2 = prVar.pr;
        int i5 = 0;
        while (i2 < i) {
            this.fw[i5] = ucVar2.pr;
            i2 += ucVar2.hn - ucVar2.hw;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.zo;
            iArr[i5] = i2;
            iArr[this.fw.length + i5] = ucVar2.hw;
            ucVar2.x = true;
            i5++;
            ucVar2 = ucVar2.uc;
        }
    }

    @Override // com.byazt.qm.x
    public String pr() {
        return c().pr();
    }

    @Override // com.byazt.qm.x
    public String hw() {
        return c().hw();
    }

    @Override // com.byazt.qm.x
    public x pr(int i, int i2) {
        return c().pr(i, i2);
    }

    @Override // com.byazt.qm.x
    public byte pr(int i) {
        vk.pr(this.zo[this.fw.length - 1], i, 1L);
        int iHw = hw(i);
        int i2 = iHw == 0 ? 0 : this.zo[iHw - 1];
        int[] iArr = this.zo;
        byte[][] bArr = this.fw;
        return bArr[iHw][(i - i2) + iArr[bArr.length + iHw]];
    }

    private int hw(int i) {
        int iBinarySearch = Arrays.binarySearch(this.zo, 0, this.fw.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.qm.x
    public int hn() {
        return this.zo[this.fw.length - 1];
    }

    @Override // com.byazt.qm.x
    public byte[] x() {
        int[] iArr = this.zo;
        byte[][] bArr = this.fw;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.zo;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.fw[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.byazt.qm.x
    public boolean pr(int i, x xVar, int i2, int i3) {
        if (i < 0 || i > hn() - i3) {
            return false;
        }
        int iHw = hw(i);
        while (i3 > 0) {
            int i4 = iHw == 0 ? 0 : this.zo[iHw - 1];
            int iMin = Math.min(i3, ((this.zo[iHw] - i4) + i4) - i);
            int[] iArr = this.zo;
            byte[][] bArr = this.fw;
            if (!xVar.pr(i2, bArr[iHw], (i - i4) + iArr[bArr.length + iHw], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHw++;
        }
        return true;
    }

    @Override // com.byazt.qm.x
    public boolean pr(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > hn() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iHw = hw(i);
        while (i3 > 0) {
            int i4 = iHw == 0 ? 0 : this.zo[iHw - 1];
            int iMin = Math.min(i3, ((this.zo[iHw] - i4) + i4) - i);
            int[] iArr = this.zo;
            byte[][] bArr2 = this.fw;
            if (!vk.pr(bArr2[iHw], (i - i4) + iArr[bArr2.length + iHw], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHw++;
        }
        return true;
    }

    private x c() {
        return new x(x());
    }

    @Override // com.byazt.qm.x
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (xVar.hn() == hn() && pr(0, xVar, 0, hn())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.qm.x
    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int length = this.fw.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.fw[i2];
            int[] iArr = this.zo;
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
        this.c = i3;
        return i3;
    }

    @Override // com.byazt.qm.x
    public String toString() {
        return c().toString();
    }
}
