package com.byazt.ewt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1073, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static final Map<Integer, x<?, ?>> pr = new ConcurrentHashMap();

    public static x<?, ?> pr(int i) {
        Map<Integer, x<?, ?>> map = pr;
        x<?, ?> hwVar = map.get(Integer.valueOf(i));
        if (hwVar != null) {
            return hwVar;
        }
        switch (i) {
            case 0:
                hwVar = new com.byazt.dc.hw();
                break;
            case 1:
                hwVar = new com.byazt.dc.hn();
                break;
            case 2:
                hwVar = new com.byazt.dc.x();
                break;
            case 3:
                hwVar = new com.byazt.dc.pr();
                break;
            case 4:
                hwVar = new com.byazt.dc.uc();
                break;
            case 5:
                hwVar = new com.byazt.dc.c();
                break;
            case 6:
                hwVar = new com.byazt.dc.fw();
                break;
        }
        if (hwVar != null) {
            map.put(Integer.valueOf(i), hwVar);
        }
        return hwVar;
    }
}
