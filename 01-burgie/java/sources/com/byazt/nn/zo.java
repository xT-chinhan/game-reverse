package com.byazt.nn;

import android.os.Handler;
import com.byazt.vkw.k;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile zo hw = null;
    public long pr = 3000;

    public static zo pr() {
        if (hw == null) {
            synchronized (zo.class) {
                if (hw == null) {
                    hw = new zo();
                }
            }
        }
        return hw;
    }

    private zo() {
    }

    public Handler hw() {
        return ((qi) com.byazt.zs.uc.pr("thread_service")).x();
    }

    public long pr(k kVar) {
        long jHw = hw(kVar);
        if (jHw <= 0) {
            return 3000L;
        }
        return jHw;
    }

    public long hw(k kVar) {
        JSONObject jSONObjectQa;
        if (kVar == null || (jSONObjectQa = kVar.qa()) == null) {
            return 3000L;
        }
        return jSONObjectQa.optLong("insert_interval", 3000L);
    }
}
