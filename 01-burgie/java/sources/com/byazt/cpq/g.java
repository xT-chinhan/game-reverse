package com.byazt.cpq;

import android.support.v4.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g {
    public final int[] hw = new int[10];
    public int pr;

    public void pr() {
        this.pr = 0;
        Arrays.fill(this.hw, 0);
    }

    public g pr(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.hw;
            if (i < iArr.length) {
                this.pr = (1 << i) | this.pr;
                iArr[i] = i2;
                return this;
            }
        }
        return this;
    }

    public boolean pr(int i) {
        return ((1 << i) & this.pr) != 0;
    }

    public int hw(int i) {
        return this.hw[i];
    }

    public int hw() {
        return Integer.bitCount(this.pr);
    }

    public int hn() {
        if ((this.pr & 2) != 0) {
            return this.hw[1];
        }
        return -1;
    }

    public int hn(int i) {
        return (this.pr & 16) != 0 ? this.hw[4] : i;
    }

    public int x(int i) {
        return (this.pr & 32) != 0 ? this.hw[5] : i;
    }

    public int x() {
        return (this.pr & 128) != 0 ? this.hw[7] : SupportMenu.USER_MASK;
    }

    public void pr(g gVar) {
        for (int i = 0; i < 10; i++) {
            if (gVar.pr(i)) {
                pr(i, gVar.hw(i));
            }
        }
    }
}
