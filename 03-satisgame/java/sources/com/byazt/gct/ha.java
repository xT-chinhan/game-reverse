package com.byazt.gct;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2230})
public class ha {
    public static int n = 0;
    public static int qg = 0;
    public static int s = 1;

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        n = jSONObjectOptJSONObject.optInt("api", 0);
        qg = jSONObjectOptJSONObject.optInt("size_limit", 0);
        s = jSONObjectOptJSONObject.optInt("zip_level", 1);
    }

    public static int n(int i, int i2) {
        if (n <= 0 || Build.VERSION.SDK_INT > n || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = qg;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, s);
        }
        return 1;
    }
}
