package com.byazt.os;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 634, 5})
public class q {
    public String n;
    public String qg;

    public q(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
    }

    public String n() {
        return this.n;
    }

    @com.byazt.cp.n(n = {0, 1, 634, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public String n;
        public String qg;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n qg(String str) {
            this.qg = str;
            return this;
        }

        public q n() {
            return new q(this);
        }
    }
}
