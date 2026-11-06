package com.byazt.sbt;

import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "tick";
    }

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        if (c0175n == null) {
            return false;
        }
        Map<String, Object> mapN = c0175n.n();
        if (map == null) {
            map = Collections.emptyMap();
        }
        if (mapN != null && !mapN.isEmpty()) {
            Object obj = mapN.get(TapEventParamConstants.PARAM_NAME);
            if (obj != null && !n(obj, map.get(TapEventParamConstants.PARAM_NAME))) {
                return false;
            }
            if (mapN.containsKey(e.a.d) && !n(mapN.get(e.a.d), map.get(e.a.d))) {
                return false;
            }
        }
        return true;
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
