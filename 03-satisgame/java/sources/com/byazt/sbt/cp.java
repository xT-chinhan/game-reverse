package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 29})
public class cp implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "timerState";
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
            if (mapN.containsKey(WebLoginFragment.QUERY_KEY_ID) && !n(mapN.get(WebLoginFragment.QUERY_KEY_ID), map.get(WebLoginFragment.QUERY_KEY_ID))) {
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
