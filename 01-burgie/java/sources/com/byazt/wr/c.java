package com.byazt.wr;

import com.byazt.hg.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    @Override // com.byazt.wr.pr
    public boolean hn() {
        this.x = 2;
        int iHw = qa.hw(this.hw.z_());
        if (iHw == 2) {
            return false;
        }
        if (iHw == 0 && x() == -1) {
            return false;
        }
        return true;
    }
}
