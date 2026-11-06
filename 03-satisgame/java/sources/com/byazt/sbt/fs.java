package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 101})
public class fs implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "Lottie://state";
    }

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        Map<String, Object> mapN;
        if (c0175n == null || (mapN = c0175n.n()) == null || mapN.isEmpty()) {
            return false;
        }
        Object obj = mapN.get("id");
        if (obj == null) {
            obj = mapN.get(TapEventParamConstants.PARAM_NAME);
        }
        Object obj2 = mapN.get(WebLoginFragment.QUERY_KEY_ID);
        if (obj == null) {
            return false;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        if (n(obj, map.get("id"))) {
            return obj2 == null || n(obj2, map.get(WebLoginFragment.QUERY_KEY_ID));
        }
        return false;
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
