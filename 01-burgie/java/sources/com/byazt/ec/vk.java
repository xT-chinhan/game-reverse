package com.byazt.ec;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 50})
public class vk {
    public static final aj pr = new aj();
    public static final Map<String, String> hw = new ConcurrentHashMap();

    public static String pr(String str) throws IllegalArgumentException {
        Map<String, String> map = hw;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strPr = pr.pr(str);
        if (strPr != null) {
            map.put(str, strPr);
        }
        return strPr;
    }
}
