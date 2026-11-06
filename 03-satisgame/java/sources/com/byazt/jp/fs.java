package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 101})
public class fs {
    public boolean n;
    public boolean q;
    public String qg;
    public boolean s;

    private fs(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static class n {
        public boolean n = false;
        public String qg = null;
        public boolean s = false;
        public boolean q = false;

        public n n(boolean z) {
            this.n = z;
            return this;
        }

        public n n(String str) {
            this.qg = str;
            return this;
        }

        public n qg(boolean z) {
            this.s = z;
            return this;
        }

        public n s(boolean z) {
            this.q = z;
            return this;
        }

        public fs n() {
            return new fs(this);
        }
    }

    public String n() {
        return this.qg;
    }

    public boolean qg() {
        return this.n;
    }

    public boolean s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }
}
