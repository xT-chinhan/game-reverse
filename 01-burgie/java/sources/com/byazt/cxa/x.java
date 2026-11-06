package com.byazt.cxa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 228, 121})
public class x {
    public String hw;
    public String pr;

    public x(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
    }

    public String pr() {
        return this.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 228, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public String hw;
        public String pr;

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            this.hw = str;
            return this;
        }

        public x pr() {
            return new x(this);
        }
    }
}
