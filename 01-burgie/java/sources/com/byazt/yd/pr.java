package com.byazt.yd;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, 37})
public class pr {
    public static volatile com.byazt.aq.pr pr;

    public static com.byazt.aq.pr pr(Context context, com.byazt.hh.hw hwVar) {
        if (pr == null) {
            synchronized (com.byazt.aq.pr.class) {
                if (pr == null) {
                    pr = new hw(context, new x(context, hwVar), hwVar);
                }
            }
        }
        return pr;
    }
}
