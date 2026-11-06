package com.byazt.wb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 426, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo extends pr {
    public static final zo hn = new zo(7500600, "执行成功");
    public static final zo x = new zo(7500601, "入参不符合预期");

    private zo(int i, String str) {
        this.pr = i;
        this.hw = str;
    }
}
