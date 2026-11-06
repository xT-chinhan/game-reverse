package com.byazt.tt;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 13})
public class hw {
    public static hw pr;
    public Map<Integer, Bundle> hw = Collections.synchronizedMap(new HashMap());

    private hw() {
    }

    public static synchronized hw pr() {
        if (pr == null) {
            pr = new hw();
        }
        return pr;
    }

    public void pr(int i, Bundle bundle) {
        this.hw.put(Integer.valueOf(i), bundle);
    }

    public Bundle pr(int i) {
        return this.hw.get(Integer.valueOf(i));
    }

    public void hw(int i) {
        this.hw.remove(Integer.valueOf(i));
    }
}
