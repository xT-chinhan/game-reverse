package com.byazt.km;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static final rv n = new rv();
    public static final Map<String, String> qg = new ConcurrentHashMap();

    public static String n(String str) throws IllegalArgumentException {
        Map<String, String> map = qg;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strN = n.n(str);
        if (strN != null) {
            map.put(str, strN);
        }
        return strN;
    }
}
