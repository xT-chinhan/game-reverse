package com.byazt.tt;

import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 20})
public class hn {
    public static void pr(of ofVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put("second_page_type", i);
        } catch (JSONException e) {
        }
        com.byazt.pj.pr.hw(ofVar, "second_page_jsb_invoke", jSONObject);
    }

    public static void pr(of ofVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", ls.g(ofVar));
            jSONObject.put(Constants.ERROR_CODE_FIELD, i2);
        } catch (JSONException e) {
        }
        com.byazt.pj.pr.hw(ofVar, "second_page_request", jSONObject);
    }

    public static void hw(of ofVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", ls.g(ofVar));
            jSONObject.put(Constants.ERROR_CODE_FIELD, i2);
        } catch (JSONException e) {
        }
        com.byazt.pj.pr.hw(ofVar, "second_page_show", jSONObject);
    }
}
