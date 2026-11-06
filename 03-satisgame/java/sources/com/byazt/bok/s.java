package com.byazt.bok;

import com.byazt.id.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 8})
public class s {
    public static final Map<Integer, qg<?, ?>> n = new ConcurrentHashMap();

    public static qg<?, ?> n(int i) {
        Map<Integer, qg<?, ?>> map = n;
        qg<?, ?> qgVar = map.get(Integer.valueOf(i));
        if (qgVar != null) {
            return qgVar;
        }
        switch (i) {
            case 0:
                qgVar = new com.byazt.id.qg();
                break;
            case 1:
                qgVar = new com.byazt.id.s();
                break;
            case 2:
                qgVar = new com.byazt.id.q();
                break;
            case 3:
                qgVar = new com.byazt.id.n();
                break;
            case 4:
                qgVar = new com.byazt.id.w();
                break;
            case 5:
                qgVar = new com.byazt.id.l();
                break;
            case 6:
                qgVar = new x();
                break;
        }
        if (qgVar != null) {
            map.put(Integer.valueOf(i), qgVar);
        }
        return qgVar;
    }
}
