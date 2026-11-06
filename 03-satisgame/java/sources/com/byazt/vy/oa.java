package com.byazt.vy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static Map<Integer, Integer> n = new ConcurrentHashMap();

    public static Integer n(int i) {
        Integer num = n.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(i);
        n.put(Integer.valueOf(i), numValueOf);
        return numValueOf;
    }
}
