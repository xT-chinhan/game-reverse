package com.byazt.pnj;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 26})
public class qg {
    public static qg n;
    public Map<Integer, Bundle> qg = Collections.synchronizedMap(new HashMap());

    private qg() {
    }

    public static synchronized qg n() {
        if (n == null) {
            n = new qg();
        }
        return n;
    }

    public void n(int i, Bundle bundle) {
        this.qg.put(Integer.valueOf(i), bundle);
    }

    public Bundle n(int i) {
        return this.qg.get(Integer.valueOf(i));
    }

    public void qg(int i) {
        this.qg.remove(Integer.valueOf(i));
    }
}
