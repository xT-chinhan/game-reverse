package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 213})
public class cz extends com.byazt.ee.c<JSONObject, JSONObject> {
    public static void pr(com.byazt.ee.yb ybVar) {
        ybVar.pr("getSettingInfo", (com.byazt.ee.c<?, ?>) new cz());
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        String[] strArrSplit;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
                JSONObject jSONObjectNt = com.byazt.sd.a.hw().nt();
                if (jSONObjectNt != null) {
                    if (jSONArrayOptJSONArray != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i, "");
                            if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split("\\.")) != null) {
                                Object objOpt = null;
                                JSONObject jSONObjectOptJSONObject = jSONObjectNt;
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
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
                        jSONObject2.put("data", jSONObject3);
                    } else {
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "keys is not JsonArray or null");
                    }
                } else {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "settingsJson is null");
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
