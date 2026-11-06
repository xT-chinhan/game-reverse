package com.byazt.kl;

import com.byazt.qx.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends BaseException {
    public int n;

    public tj(int i, String str) {
        super(1072, "applyCode=" + i + ", " + str);
        this.n = i;
    }
}
