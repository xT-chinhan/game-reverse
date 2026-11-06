package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
public class qi extends com.byazt.ee.c<JSONObject, JSONObject> {
    public final com.byazt.sd.nl pr;

    public qi(com.byazt.sd.nl nlVar) {
        this.pr = nlVar;
    }

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("sendLog", (com.byazt.ee.c<?, ?>) new qi(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        long j;
        long j2;
        JSONObject jSONObjectM;
        com.byazt.ap.c cVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("category");
                    String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                    String strOptString3 = jSONObjectOptJSONObject.optString("label");
                    if (!this.pr.uc(strOptString3)) {
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "is not reportclickother");
                        return jSONObject2;
                    }
                    com.byazt.hg.of ofVarZo = this.pr.zo();
                    if (com.byazt.hg.s.hw(ofVarZo) && TextUtils.equals(strOptString3, "track")) {
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "track is not send");
                        return jSONObject2;
                    }
                    try {
                        j = Long.parseLong(jSONObjectOptJSONObject.optString(Constants.VALUE_FIELD));
                    } catch (Exception e) {
                        j = 0;
                    }
                    if (j == 0 && ofVarZo != null) {
                        try {
                            j = Long.parseLong(ofVarZo.x());
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        j2 = Long.parseLong(jSONObjectOptJSONObject.optString("ext_value"));
                    } catch (Exception e3) {
                        j2 = 0;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(strOptString4)) {
                        try {
                            jSONObject3 = new JSONObject(strOptString4);
                        } catch (Exception e4) {
                        }
                    }
                    this.pr.pr(strOptString3, jSONObject3);
                    if (!"click".equals(strOptString3)) {
                        jSONObjectM = jSONObject3;
                    } else {
                        jSONObjectM = this.pr.m(jSONObject3);
                        WeakReference<com.byazt.ap.c> weakReferenceVk = this.pr.vk();
                        if (weakReferenceVk != null && (cVar = weakReferenceVk.get()) != null) {
                            cVar.hw();
                        }
                    }
                    String strPr = this.pr.pr(strOptString2, strOptString3);
                    String strOptString5 = jSONObjectM.optString("log_extra");
                    if (ofVarZo != null && strOptString3.contains("sanfang") && TextUtils.isEmpty(strOptString5)) {
                        jSONObjectM.putOpt("log_extra", ofVarZo.B_());
                    }
                    com.byazt.pj.pr.pr(strOptString, strPr, strOptString3, j, j2, jSONObjectM, this.pr.ls());
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
                } else {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "extJson is null");
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
