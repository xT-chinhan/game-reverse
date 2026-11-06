package com.byazt.xh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 768, 18})
public class l {
    public byte[] l;
    public String n;
    public boolean q;
    public String qg;
    public boolean s;

    public String n() {
        return this.n;
    }

    public boolean qg() {
        return this.q;
    }

    public byte[] s() {
        return this.l;
    }

    @com.byazt.cp.n(n = {0, 1, 768, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public byte[] l;
        public String n;
        public boolean q;
        public String qg;
        public boolean s;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n n(boolean z) {
            this.q = z;
            return this;
        }

        public n n(byte[] bArr) {
            this.l = bArr;
            return this;
        }

        public l n() {
            l lVar = new l();
            lVar.n = this.n;
            lVar.qg = this.qg;
            lVar.s = this.s;
            lVar.q = this.q;
            lVar.l = this.l;
            return lVar;
        }
    }
}
