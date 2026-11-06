package com.byazt.hr;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 108})
public class m {
    public pr hw = new pr();
    public final hw pr;

    interface hw {
        int hw();

        int hw(View view);

        int pr();

        int pr(View view);

        View pr(int i);
    }

    public m(hw hwVar) {
        this.pr = hwVar;
    }

    public View pr(int i, int i2, int i3, int i4) {
        int iPr = this.pr.pr();
        int iHw = this.pr.hw();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewPr = this.pr.pr(i);
            this.hw.pr(iPr, iHw, this.pr.pr(viewPr), this.pr.hw(viewPr));
            if (i3 != 0) {
                this.hw.pr();
                this.hw.pr(i3);
                if (this.hw.hw()) {
                    return viewPr;
                }
            }
            if (i4 != 0) {
                this.hw.pr();
                this.hw.pr(i4);
                if (this.hw.hw()) {
                    view = viewPr;
                }
            }
            i += i5;
        }
        return view;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW})
    static class pr {
        public int c;
        public int hn;
        public int hw;
        public int pr = 0;
        public int x;

        public void pr(int i, int i2, int i3, int i4) {
            this.hw = i;
            this.hn = i2;
            this.x = i3;
            this.c = i4;
        }

        public void pr(int i) {
            this.pr = i | this.pr;
        }

        public void pr() {
            this.pr = 0;
        }

        public int pr(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public boolean hw() {
            int i = this.pr;
            if ((i & 7) != 0 && (i & (pr(this.x, this.hw) << 0)) == 0) {
                return false;
            }
            int i2 = this.pr;
            if ((i2 & 112) != 0 && (i2 & (pr(this.x, this.hn) << 4)) == 0) {
                return false;
            }
            int i3 = this.pr;
            if ((i3 & 1792) != 0 && (i3 & (pr(this.c, this.hw) << 8)) == 0) {
                return false;
            }
            int i4 = this.pr;
            return (i4 & 28672) == 0 || (i4 & (pr(this.c, this.hn) << 12)) != 0;
        }
    }
}
