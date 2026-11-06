package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE})
public class wt {
    public int hn;
    public int hw;
    public int pr;
    public int x = 1;
    public int c = 0;

    public int pr() {
        return this.pr;
    }

    public void pr(int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            this.pr = 2;
        } else {
            this.pr = i;
        }
    }

    public int hw() {
        return this.hw;
    }

    public void hw(int i) {
        if (i <= 0 || i >= fw()) {
            this.hw = 16;
        } else {
            this.hw = i;
        }
    }

    public int hn() {
        return this.hn;
    }

    public void hn(int i) {
        if (i <= 0 || i >= uc()) {
            int i2 = this.pr;
            if (i2 == 3 || i2 == 4) {
                this.hn = 30;
                return;
            } else {
                this.hn = 16;
                return;
            }
        }
        this.hn = i;
    }

    private int uc() {
        return com.byazt.wt.er.x(com.byazt.sd.a.getContext(), com.byazt.wt.er.uc(com.byazt.sd.a.getContext()));
    }

    private int fw() {
        return com.byazt.wt.er.x(com.byazt.sd.a.getContext(), com.byazt.wt.er.c(com.byazt.sd.a.getContext()));
    }

    public int x() {
        return this.x == 2 ? 2 : 1;
    }

    public void x(int i) {
        this.x = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public static boolean pr(of ofVar) {
        return (ofVar == null || ofVar.ff() == null || ofVar.ff().c() != 1) ? false : true;
    }
}
