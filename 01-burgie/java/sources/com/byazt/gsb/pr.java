package com.byazt.gsb;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 37})
public class pr extends hn {
    public static volatile pr pr;

    public static pr pr(Context context) {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    Context applicationContext = context != null ? context.getApplicationContext() : null;
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    pr = new pr(context);
                }
            }
        }
        return pr;
    }

    private pr(Context context) {
        super(context);
    }
}
