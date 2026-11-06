package com.byazt.vs;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 849})
public class ou extends com.byazt.cf.l<JSONObject, JSONObject> {
    public static void n(com.byazt.cf.cy cyVar) {
        cyVar.n("getSettingInfo", (com.byazt.cf.l<?, ?>) new ou());
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        String[] strArrSplit;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
                JSONObject jSONObjectCy = com.byazt.nf.rv.qg().cy();
                if (jSONObjectCy == null) {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "settingsJson is null");
                } else if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split("\\.")) != null) {
                            Object objOpt = null;
                            JSONObject jSONObjectOptJSONObject = jSONObjectCy;
                            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                                String str = strArrSplit[i2];
                                if (str != null && jSONObjectOptJSONObject != null) {
                                    if (i2 != strArrSplit.length - 1) {
                                        jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject(str);
                                    } else {
                                        objOpt = jSONObjectOptJSONObject.opt(str);
                                    }
                                }
                            }
                            jSONObject3.putOpt(strOptString, objOpt);
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put(com.anythink.core.common.l.f.R, jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "keys is not JsonArray or null");
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
