package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1027})
public class d {
    public int hn;
    public int hw;
    public int pr;

    public int pr() {
        return this.pr;
    }

    public void pr(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.pr = i;
    }

    public int hw() {
        return this.hw;
    }

    public void hw(int i) {
        if (i <= 0 || i >= x()) {
            int i2 = this.pr;
            if (i2 == 1) {
                this.hw = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.hw = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                    return;
                }
                return;
            }
        }
        this.hw = i;
    }

    public int hn() {
        return this.hn;
    }

    public void hn(int i) {
        if (i <= 0 || i >= x()) {
            int i2 = this.pr;
            if (i2 == 1) {
                this.hn = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.hn = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                    return;
                }
                return;
            }
        }
        this.hn = i;
    }

    private int x() {
        return com.byazt.wt.er.x(com.byazt.sd.a.getContext(), com.byazt.wt.er.uc(com.byazt.sd.a.getContext()));
    }
}
