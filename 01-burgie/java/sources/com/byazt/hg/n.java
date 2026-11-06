package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT})
public class n {
    public static int pr = 0;
    public static int hw = 0;
    public static int hn = 0;

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        pr = 0;
        hw = 0;
        hn = 0;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("inter_predict_change_type")) != null) {
            pr = pr(jSONObjectOptJSONObject2.optInt(MediationConstant.RIT_TYPE_SPLASH, 0));
            hw = pr(jSONObjectOptJSONObject2.optInt("reward", 0));
            hn = pr(jSONObjectOptJSONObject2.optInt(MediationConstant.RIT_TYPE_INTERSTITIAL, 0));
        }
    }

    public static void pr(com.byazt.zq.c cVar) {
        cVar.pr("inter_predict_change_type_splash", pr);
        cVar.pr("inter_predict_change_type_reward", hw);
        cVar.pr("inter_predict_change_type_interstitial", hn);
    }

    public static void hw(com.byazt.zq.c cVar) {
        pr = pr(cVar.hw("inter_predict_change_type_splash", 0));
        hw = pr(cVar.hw("inter_predict_change_type_reward", 0));
        hn = pr(cVar.hw("inter_predict_change_type_interstitial", 0));
    }

    public static int pr() {
        return pr;
    }

    public static int hw() {
        return hw;
    }

    public static int hn() {
        return hn;
    }

    public static boolean x() {
        return pr(pr, 2);
    }

    public static boolean c() {
        return pr(hw, 1);
    }

    public static boolean uc() {
        return pr(hw, 2);
    }

    public static boolean fw() {
        return pr(hn, 1);
    }

    public static boolean zo() {
        return pr(hn, 2);
    }

    private static boolean pr(int i, int i2) {
        return (i & i2) == i2;
    }

    private static int pr(int i) {
        if (i < 0 || i > 3) {
            return 0;
        }
        return i;
    }
}
