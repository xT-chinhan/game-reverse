package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN})
public class s {
    public int hw;
    public boolean pr;

    public s(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.pr = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.hw = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    public void pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.pr ? 1 : 0);
            jSONObject2.put("filter_track", this.hw);
        } catch (JSONException e) {
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e2) {
        }
    }

    private static s hn(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.jb();
    }

    public static boolean pr(of ofVar) {
        s sVarHn = hn(ofVar);
        if (sVarHn == null) {
            return false;
        }
        return sVarHn.pr;
    }

    public static boolean hw(of ofVar) {
        s sVarHn = hn(ofVar);
        return sVarHn != null && sVarHn.hw == 1;
    }
}
