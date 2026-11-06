package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 13})
public class w implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "gameResult";
    }

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        if (c0175n == null) {
            return false;
        }
        Map<String, Object> mapN = c0175n.n();
        if (mapN == null || mapN.isEmpty() || !mapN.containsKey("result")) {
            return true;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        return n(mapN.get("result"), map.get("result"));
    }

    private static boolean n(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return String.valueOf(obj).equals(String.valueOf(obj2));
    }
}
