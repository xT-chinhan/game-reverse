package com.byazt.vs;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 18})
public class l extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final com.byazt.cf.cy n;

    public l(com.byazt.cf.cy cyVar) {
        this.n = cyVar;
    }

    public static void n(com.byazt.cf.cy cyVar) {
        cyVar.n("canIUse", (com.byazt.cf.l<?, ?>) new l(cyVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("names");
                if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString)) {
                            if (TextUtils.equals(strOptString, "isShow7Factors")) {
                                jSONObject3.put(strOptString, 1);
                            } else {
                                jSONObject3.put(strOptString, this.n.n(strOptString) ? 1 : 0);
                            }
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put(com.anythink.core.common.l.f.R, jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "names is not JsonArray or null");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "params is null");
            }
        } catch (Throwable th) {
            jSONObject2.put("code", 1);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
