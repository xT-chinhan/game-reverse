package com.byazt.vs;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd extends com.byazt.cf.l<JSONObject, JSONObject> {
    public static void n(com.byazt.cf.cy cyVar) {
        cyVar.n("getDownloadStatus", (com.byazt.cf.l<?, ?>) new hd());
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return n(jSONObject);
    }

    public static JSONObject n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            n(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                n(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return com.byazt.ll.qg.n.n(strOptString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void n(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
