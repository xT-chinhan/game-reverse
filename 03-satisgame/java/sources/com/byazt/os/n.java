package com.byazt.os;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 634, 19})
public class n {
    public String l;
    public String n;
    public String q;
    public String qg;
    public String s;

    public n(C0285n c0285n) {
        this.qg = "";
        this.n = c0285n.n;
        this.qg = c0285n.qg;
        this.s = c0285n.s;
        this.q = c0285n.q;
        this.l = c0285n.l;
    }

    /* JADX INFO: renamed from: com.byazt.os.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 634, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0285n {
        public String l;
        public String n;
        public String q;
        public String qg;
        public String s;

        public C0285n n(String str) {
            this.n = str;
            return this;
        }

        public C0285n qg(String str) {
            this.qg = str;
            return this;
        }

        public C0285n s(String str) {
            this.q = str;
            return this;
        }

        public C0285n q(String str) {
            this.l = str;
            return this;
        }

        public n n() {
            return new n(this);
        }
    }
}
