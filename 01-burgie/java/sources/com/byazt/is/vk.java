package com.byazt.is;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 50})
public class vk {
    public static int pr() {
        JSONObject jSONObjectSd = a.hw().sd();
        if (jSONObjectSd == null) {
            return 0;
        }
        return jSONObjectSd.optInt("live_max_count", 0);
    }

    public static int hw() {
        JSONObject jSONObjectSd = a.hw().sd();
        if (jSONObjectSd != null && iu.x >= 7200) {
            return jSONObjectSd.optInt("live_init_max_count", 0);
        }
        return 0;
    }

    public static boolean hn() {
        return pr() > 0;
    }

    public static boolean x() {
        return hw() > 0;
    }

    public static int c() {
        JSONObject jSONObjectSd = a.hw().sd();
        if (jSONObjectSd == null) {
            return 0;
        }
        return jSONObjectSd.optInt("pangle_max_count", 0);
    }

    public static boolean uc() {
        return c() > 0;
    }

    public static boolean pr(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return uc();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return hn();
        }
        return false;
    }

    public static int hw(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return c();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return pr();
        }
        return 0;
    }

    public static JSONObject fw() {
        return a.hw().ff();
    }

    public static boolean zo() {
        return fw() != null && fw().optBoolean("enable", false);
    }

    public static JSONObject aj() {
        return a.hw().qr();
    }

    public static boolean vk() {
        return aj() != null && aj().optBoolean("enable", false);
    }

    public static String w() {
        JSONObject jSONObjectAj = aj();
        return jSONObjectAj != null ? jSONObjectAj.optString(BreakpointSQLiteKey.URL, "api-access.pangolin-sdk-toutiao.com") : "api-access.pangolin-sdk-toutiao.com";
    }

    public static JSONObject k() {
        return a.hw().ov();
    }

    public static boolean m() {
        return k() != null && k().optBoolean("enable", false);
    }
}
