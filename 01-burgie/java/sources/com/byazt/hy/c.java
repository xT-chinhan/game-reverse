package com.byazt.hy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static final x pr = new pr(null);
    public final Map<String, x> hw = new HashMap();

    public c() {
        pr(new hw());
        pr(new hn());
    }

    public synchronized void pr(x xVar) {
        if (xVar != null) {
            if (xVar.pr() != null) {
                this.hw.put(xVar.pr(), xVar);
            }
        }
    }

    public synchronized x pr(String str) {
        x xVar = this.hw.get(str);
        if (xVar != null) {
            return xVar;
        }
        return pr;
    }
}
