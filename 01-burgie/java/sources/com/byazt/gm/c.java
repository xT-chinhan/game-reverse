package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.ee.c<JSONObject, JSONObject> {
    public final com.byazt.ee.yb pr;

    public c(com.byazt.ee.yb ybVar) {
        this.pr = ybVar;
    }

    public static void pr(com.byazt.ee.yb ybVar) {
        ybVar.pr("canIUse", (com.byazt.ee.c<?, ?>) new c(ybVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
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
                                jSONObject3.put(strOptString, this.pr.pr(strOptString) ? 1 : 0);
                            }
                        }
                    }
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
                    jSONObject2.put("data", jSONObject3);
                } else {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "names is not JsonArray or null");
                }
            } else {
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "params is null");
            }
        } catch (Throwable th) {
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
