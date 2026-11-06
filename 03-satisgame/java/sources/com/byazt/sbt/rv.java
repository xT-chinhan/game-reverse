package com.byazt.sbt;

import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "stateChange";
    }

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        if (c0175n == null) {
            return false;
        }
        Map<String, Object> mapN = c0175n.n();
        if (mapN == null || !mapN.containsKey(e.a.b)) {
            return true;
        }
        Object obj = mapN.get(e.a.b);
        Object obj2 = map == null ? null : map.get(e.a.b);
        if (obj == obj2) {
            return true;
        }
        return (obj == null || obj2 == null || !String.valueOf(obj).equals(String.valueOf(obj2))) ? false : true;
    }
}
