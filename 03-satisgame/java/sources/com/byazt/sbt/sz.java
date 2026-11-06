package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.loader.ApiSpUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 110})
public class sz implements d {
    @Override // com.byazt.sbt.d
    public String n() {
        return "videoProgress";
    }

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        if (c0175n == null) {
            return false;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        long jN = n(map.get("current"), 0L);
        long jN2 = n(map.get(MediationConstant.EXTRA_DURATION), 0L);
        Map<String, Object> mapN = c0175n.n();
        if (mapN != null && !mapN.isEmpty()) {
            int iN = -1;
            if (mapN.containsKey(ApiSpUtils.SP_INTERVAL)) {
                iN = com.byazt.hb.s.n(String.valueOf(mapN.get(ApiSpUtils.SP_INTERVAL)), -1);
            } else if (mapN.containsKey("seconds")) {
                iN = com.byazt.hb.s.n(String.valueOf(mapN.get("seconds")), -1);
            }
            if (iN >= 0) {
                return jN >= ((long) iN) * 1000;
            }
            if (mapN.containsKey("percent")) {
                float fN = com.byazt.hb.s.n(String.valueOf(mapN.get("percent")), -1.0f);
                if (fN < 0.0f || jN2 <= 0 || (jN * 1.0f) / jN2 < fN) {
                    return false;
                }
            }
        }
        return true;
    }

    private static long n(Object obj, long j) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj == null) {
            return j;
        }
        try {
            return Long.parseLong(String.valueOf(obj));
        } catch (NumberFormatException unused) {
            return j;
        }
    }
}
