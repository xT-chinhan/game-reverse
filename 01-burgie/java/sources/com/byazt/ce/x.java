package com.byazt.ce;

import android.view.animation.Interpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 121})
public class x {
    public static File pr() {
        return com.byazt.mg.hw.hw(com.byazt.bg.pr.pr().hn().getContext());
    }

    public static Interpolator pr(float f, float f2, float f3, float f4) {
        return new com.byazt.jt.pr(f, f2, f3, f4);
    }
}
