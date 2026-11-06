package com.byazt.wr;

import com.byazt.hg.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 13})
public class hw extends pr {
    public boolean uc = false;
    public int fw = 0;
    public int zo = -1;

    public void hn(boolean z) {
        this.uc = z;
    }

    public void pr(int i) {
        this.fw = i;
    }

    @Override // com.byazt.wr.pr
    public boolean hn() {
        this.x = 1;
        boolean z = uc.x;
        int iPr = qa.pr(this.hw.z_());
        if (z) {
            uc.x = false;
            iPr = 0;
        }
        if (this.c) {
            return c();
        }
        if (this.uc) {
            int i = this.fw;
            if (i == 2) {
                return c();
            }
            if (iPr == 2 && i == 1) {
                return c();
            }
        }
        if (iPr != 0) {
            return true;
        }
        return c();
    }

    private boolean c() {
        this.x = x();
        return this.x != -1;
    }
}
