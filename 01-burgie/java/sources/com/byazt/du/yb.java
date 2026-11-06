package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public final class yb extends uc {
    public final transient int[] fw;
    public final transient byte[][] uc;

    public yb(hn hnVar, int i) {
        super(null);
        cz.pr(hnVar.hw, 0L, i);
        ho hoVar = hnVar.pr;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (hoVar.hn == hoVar.hw) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += hoVar.hn - hoVar.hw;
            i4++;
            hoVar = hoVar.uc;
        }
        this.uc = new byte[i4][];
        this.fw = new int[i4 * 2];
        ho hoVar2 = hnVar.pr;
        int i5 = 0;
        while (i2 < i) {
            this.uc[i5] = hoVar2.pr;
            i2 += hoVar2.hn - hoVar2.hw;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.fw;
            iArr[i5] = i2;
            iArr[this.uc.length + i5] = hoVar2.hw;
            hoVar2.x = true;
            i5++;
            hoVar2 = hoVar2.uc;
        }
    }

    @Override // com.byazt.du.uc
    public String pr() {
        return aj().pr();
    }

    @Override // com.byazt.du.uc
    public String hw() {
        return aj().hw();
    }

    @Override // com.byazt.du.uc
    public String c() {
        return aj().c();
    }

    @Override // com.byazt.du.uc
    public uc uc() {
        return aj().uc();
    }

    @Override // com.byazt.du.uc
    public uc hn() {
        return aj().hn();
    }

    @Override // com.byazt.du.uc
    public uc x() {
        return aj().x();
    }

    @Override // com.byazt.du.uc
    public uc pr(int i, int i2) {
        return aj().pr(i, i2);
    }

    @Override // com.byazt.du.uc
    public byte pr(int i) {
        cz.pr(this.fw[this.uc.length - 1], i, 1L);
        int iHw = hw(i);
        int i2 = iHw == 0 ? 0 : this.fw[iHw - 1];
        int[] iArr = this.fw;
        byte[][] bArr = this.uc;
        return bArr[iHw][(i - i2) + iArr[bArr.length + iHw]];
    }

    private int hw(int i) {
        int iBinarySearch = Arrays.binarySearch(this.fw, 0, this.uc.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.du.uc
    public int fw() {
        return this.fw[this.uc.length - 1];
    }

    @Override // com.byazt.du.uc
    public byte[] zo() {
        int[] iArr = this.fw;
        byte[][] bArr = this.uc;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.fw;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.uc[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.byazt.du.uc
    public void pr(hn hnVar) {
        int length = this.uc.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.fw;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            ho hoVar = new ho(this.uc[i], i3, (i3 + i4) - i2, true, false);
            if (hnVar.pr == null) {
                hoVar.fw = hoVar;
                hoVar.uc = hoVar;
                hnVar.pr = hoVar;
            } else {
                hnVar.pr.fw.pr(hoVar);
            }
            i++;
            i2 = i4;
        }
        hnVar.hw += (long) i2;
    }

    @Override // com.byazt.du.uc
    public boolean pr(int i, uc ucVar, int i2, int i3) {
        if (i < 0 || i > fw() - i3) {
            return false;
        }
        int iHw = hw(i);
        while (i3 > 0) {
            int i4 = iHw == 0 ? 0 : this.fw[iHw - 1];
            int iMin = Math.min(i3, ((this.fw[iHw] - i4) + i4) - i);
            int[] iArr = this.fw;
            byte[][] bArr = this.uc;
            if (!ucVar.pr(i2, bArr[iHw], (i - i4) + iArr[bArr.length + iHw], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHw++;
        }
        return true;
    }

    @Override // com.byazt.du.uc
    public boolean pr(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > fw() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iHw = hw(i);
        while (i3 > 0) {
            int i4 = iHw == 0 ? 0 : this.fw[iHw - 1];
            int iMin = Math.min(i3, ((this.fw[iHw] - i4) + i4) - i);
            int[] iArr = this.fw;
            byte[][] bArr2 = this.uc;
            if (!cz.pr(bArr2[iHw], (i - i4) + iArr[bArr2.length + iHw], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHw++;
        }
        return true;
    }

    private uc aj() {
        return new uc(zo());
    }

    @Override // com.byazt.du.uc
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof uc) {
            uc ucVar = (uc) obj;
            if (ucVar.fw() == fw() && pr(0, ucVar, 0, fw())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.du.uc
    public int hashCode() {
        int i = this.x;
        if (i != 0) {
            return i;
        }
        int length = this.uc.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.uc[i2];
            int[] iArr = this.fw;
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
        this.x = i3;
        return i3;
    }

    @Override // com.byazt.du.uc
    public String toString() {
        return aj().toString();
    }
}
