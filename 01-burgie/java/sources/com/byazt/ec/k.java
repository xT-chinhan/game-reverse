package com.byazt.ec;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 250})
public class k {
    public final String c;
    public final String fw;
    public final String[] hn;
    public final String[] hw;
    public final String pr;
    public final String uc;
    public final String x;

    private k(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
        this.fw = prVar.fw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 785})
    public static class pr {
        public String c;
        public String fw;
        public String[] hn;
        public String[] hw;
        public String pr;
        public String uc;
        public String x;

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr pr(String[] strArr) {
            this.hw = strArr;
            return this;
        }

        public pr hw(String[] strArr) {
            this.hn = strArr;
            return this;
        }

        public pr hw(String str) {
            this.x = str;
            return this;
        }

        public pr hn(String str) {
            this.c = str;
            return this;
        }

        public pr x(String str) {
            this.fw = str;
            return this;
        }

        public k pr() {
            return new k(this);
        }
    }

    public String pr() {
        return this.pr;
    }

    public String[] hw() {
        return this.hw;
    }

    public String hn() {
        return this.x;
    }

    public String x() {
        return this.c;
    }

    public static k pr(int i) {
        return m.pr(i);
    }
}
