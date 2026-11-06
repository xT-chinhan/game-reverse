package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
public class y {
    public boolean c;
    public int hn;
    public int hw;
    public String pr;
    public String uc;
    public double x;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public int hw() {
        return this.hw;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public int hn() {
        return this.hn;
    }

    public void hw(int i) {
        this.hn = i;
    }

    public double x() {
        return this.x;
    }

    public void pr(double d) {
        this.x = d;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.pr) && this.hw > 0 && this.hn > 0;
    }

    public boolean uc() {
        return this.c;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public String fw() {
        return this.uc;
    }

    public void hw(String str) {
        this.uc = str;
    }

    public static com.byazt.mr.k pr(y yVar) {
        if (yVar == null || !yVar.c()) {
            return null;
        }
        return new pr(yVar.hn(), yVar.hw(), yVar.pr(), yVar.x());
    }

    public static final com.byazt.mr.k pr(int i, int i2, String str, double d) {
        return new pr(i, i2, str, d);
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 131})
    private static final class pr extends com.byazt.mr.k {
        public String hn;
        public int hw;
        public int pr;
        public double x;

        public pr(int i, int i2, String str, double d) {
            this.x = 0.0d;
            this.pr = i;
            this.hw = i2;
            this.hn = str;
            this.x = d;
        }

        @Override // com.byazt.mr.k
        public int pr() {
            return this.pr;
        }

        @Override // com.byazt.mr.k
        public int hw() {
            return this.hw;
        }

        @Override // com.byazt.mr.k
        public String hn() {
            return this.hn;
        }

        @Override // com.byazt.mr.k
        public double x() {
            return this.x;
        }

        @Override // com.byazt.mr.k
        public boolean c() {
            String str;
            return this.pr > 0 && this.hw > 0 && (str = this.hn) != null && str.length() > 0;
        }
    }
}
