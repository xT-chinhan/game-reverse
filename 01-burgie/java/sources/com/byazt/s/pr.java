package com.byazt.s;

import android.content.Context;
import android.os.Build;
import com.byazt.o.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 37})
public class pr {
    public static com.byazt.ihe.pr c = null;
    public static int pr = 10;
    public static int hw = 10;
    public static int hn = 10;
    public static int x = 10;

    public static void pr(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            com.byazt.l.pr.pr();
        }
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            pr = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            hw = jSONObject.optInt("reward", 10);
            hn = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            x = iOptInt;
            if (pr < 0) {
                pr = 10;
            }
            if (hw < 0) {
                hw = 10;
            }
            if (hn < 0) {
                hn = 10;
            }
            if (iOptInt < 0) {
                x = 10;
            }
            Object[] objArr = {"splash=", Integer.valueOf(pr), ",reward=", Integer.valueOf(hw), ",brand=", Integer.valueOf(hn), ",other=", Integer.valueOf(x)};
        } catch (Throwable th) {
            hw.pr("MediaConfig", th.getMessage());
        }
    }

    public static void pr(com.byazt.ihe.pr prVar) {
        c = prVar;
    }

    public static void pr() {
        com.byazt.ihe.pr prVar = c;
        if (prVar != null) {
            prVar.c();
        }
    }

    public static int hw() {
        return pr;
    }

    public static int hn() {
        return hw;
    }

    public static int x() {
        return hn;
    }

    public static int c() {
        return x;
    }
}
