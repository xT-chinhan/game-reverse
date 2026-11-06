package com.byazt.ep;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 121})
public abstract class x {
    public abstract JSONObject hw();

    public abstract String pr();

    public static void pr(x xVar) {
        if (xVar == null) {
            return;
        }
        com.byazt.ba.x.pr(xVar.pr(), xVar.hw());
    }
}
