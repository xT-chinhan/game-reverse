package com.byazt.vgx;

import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 21})
public class x {
    public static JSONObject n(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    jSONObject.put(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME), jSONObjectOptJSONObject.opt(e.a.d));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
