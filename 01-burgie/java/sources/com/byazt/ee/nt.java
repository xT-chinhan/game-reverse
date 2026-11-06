package com.byazt.ee;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 74})
public final class nt {
    public final String c;
    public final String fw;
    public final String hn;
    public final String hw;
    public final int pr;
    public final String uc;
    public final String x;
    public final String zo;

    public static pr pr() {
        return new pr();
    }

    public static nt pr(String str, int i) {
        return new nt(str, i);
    }

    private nt(String str, int i) {
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.uc = str;
        this.fw = null;
        this.pr = i;
        this.zo = null;
    }

    private nt(pr prVar) {
        this.hw = prVar.pr;
        this.hn = prVar.hw;
        this.x = prVar.hn;
        this.c = prVar.x;
        this.uc = prVar.c;
        this.fw = prVar.uc;
        this.pr = 1;
        this.zo = prVar.fw;
    }

    public static boolean pr(nt ntVar) {
        return ntVar == null || ntVar.pr != 1 || TextUtils.isEmpty(ntVar.x) || TextUtils.isEmpty(ntVar.c);
    }

    public String toString() {
        return "methodName: " + this.x + ", params: " + this.c + ", callbackId: " + this.uc + ", type: " + this.hn + ", version: " + this.hw + ", ";
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 350})
    public static final class pr {
        public String c;
        public String fw;
        public String hn;
        public String hw;
        public String pr;
        public String uc;
        public String x;

        private pr() {
        }

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            this.hw = str;
            return this;
        }

        public pr hn(String str) {
            this.hn = str;
            return this;
        }

        public pr x(String str) {
            this.x = str;
            return this;
        }

        public pr c(String str) {
            this.c = str;
            return this;
        }

        public pr uc(String str) {
            this.uc = str;
            return this;
        }

        public pr fw(String str) {
            this.fw = str;
            return this;
        }

        public nt pr() {
            return new nt(this);
        }
    }
}
