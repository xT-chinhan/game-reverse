package com.byazt.wt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public static boolean pr() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectFe = com.byazt.sd.a.hw().fe();
        if (jSONObjectFe == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectFe.optLong(TrackAction.START, 1707480000000L) && jCurrentTimeMillis <= jSONObjectFe.optLong("end", 1707498000000L);
    }

    public static boolean hw() {
        JSONObject jSONObjectFe = com.byazt.sd.a.hw().fe();
        return jSONObjectFe != null && pr() && jSONObjectFe.optInt("force_drop", 0) == 1;
    }
}
