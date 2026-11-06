package com.byazt.tv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1488, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public byte[] c;
    public boolean hn;
    public String hw;
    public String pr;
    public boolean x;

    public String pr() {
        return this.pr;
    }

    public boolean hw() {
        return this.x;
    }

    public byte[] hn() {
        return this.c;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1488, 169})
    public static class pr {
        public byte[] c;
        public boolean hn;
        public String hw;
        public String pr;
        public boolean x;

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr pr(boolean z) {
            this.x = z;
            return this;
        }

        public pr pr(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public c pr() {
            c cVar = new c();
            cVar.pr = this.pr;
            cVar.hw = this.hw;
            cVar.hn = this.hn;
            cVar.x = this.x;
            cVar.c = this.c;
            return cVar;
        }
    }
}
