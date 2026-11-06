package com.byazt.bs;

import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 446, 13})
public final class hw {

    @com.byazt.vzx.pr(pr = {0, 1, 446, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public static final int c;
        public static final int hn;
        public static final int hw;
        public static final float pr;
        public static final int uc;
        public static final int x;

        static {
            float f = a.getContext().getResources().getDisplayMetrics().density;
            pr = f;
            hw = (int) ((228.0f * f) + 0.5f);
            hn = (int) ((160.0f * f) + 0.5f);
            x = (int) ((15.0f * f) + 0.5f);
            c = (int) ((14.0f * f) + 0.5f);
            uc = (int) ((f * 16.0f) + 0.5f);
        }
    }
}
