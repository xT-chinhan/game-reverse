package com.byazt.ynb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public final com.byazt.eqw.x hn;
    public final com.byazt.eqw.zo hw;
    public final pr pr;
    public final boolean x;

    public enum pr {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public zo(pr prVar, com.byazt.eqw.zo zoVar, com.byazt.eqw.x xVar, boolean z) {
        this.pr = prVar;
        this.hw = zoVar;
        this.hn = xVar;
        this.x = z;
    }

    public pr pr() {
        return this.pr;
    }

    public com.byazt.eqw.zo hw() {
        return this.hw;
    }

    public com.byazt.eqw.x hn() {
        return this.hn;
    }

    public boolean x() {
        return this.x;
    }
}
