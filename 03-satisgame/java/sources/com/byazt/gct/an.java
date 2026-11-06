package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1758})
public class an {
    public static int n;
    public static int qg;
    public static int s;

    private static int n(int i) {
        if (i < 0 || i > 3) {
            return 0;
        }
        return i;
    }

    private static boolean n(int i, int i2) {
        return (i & i2) == i2;
    }

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        n = 0;
        qg = 0;
        s = 0;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("inter_predict_change_type")) == null) {
            return;
        }
        n = n(jSONObjectOptJSONObject2.optInt(MediationConstant.RIT_TYPE_SPLASH, 0));
        qg = n(jSONObjectOptJSONObject2.optInt("reward", 0));
        s = n(jSONObjectOptJSONObject2.optInt(MediationConstant.RIT_TYPE_INTERSTITIAL, 0));
    }

    public static void n(com.byazt.gwu.l lVar) {
        lVar.n("inter_predict_change_type_splash", n);
        lVar.n("inter_predict_change_type_reward", qg);
        lVar.n("inter_predict_change_type_interstitial", s);
    }

    public static void qg(com.byazt.gwu.l lVar) {
        n = n(lVar.qg("inter_predict_change_type_splash", 0));
        qg = n(lVar.qg("inter_predict_change_type_reward", 0));
        s = n(lVar.qg("inter_predict_change_type_interstitial", 0));
    }

    public static int n() {
        return n;
    }

    public static int qg() {
        return qg;
    }

    public static int s() {
        return s;
    }

    public static boolean q() {
        return n(n, 2);
    }

    public static boolean l() {
        return n(qg, 1);
    }

    public static boolean w() {
        return n(qg, 2);
    }

    public static boolean x() {
        return n(s, 1);
    }

    public static boolean fs() {
        return n(s, 2);
    }
}
