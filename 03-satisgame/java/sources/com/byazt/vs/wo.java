package com.byazt.vs;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1668})
public class wo extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final com.byazt.gcl.s n;

    public wo(com.byazt.gcl.s sVar) {
        this.n = sVar;
    }

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("sendLog", (com.byazt.cf.l<?, ?>) new wo(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        long j;
        JSONObject jSONObjectOa;
        com.byazt.uv.w wVar2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("category");
                    String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                    String strOptString3 = jSONObjectOptJSONObject.optString("label");
                    if (!this.n.w(strOptString3)) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "is not reportclickother");
                        return jSONObject2;
                    }
                    com.byazt.gct.pk pkVarFs = this.n.fs();
                    if (com.byazt.gct.f.qg(pkVarFs) && TextUtils.equals(strOptString3, "track")) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "track is not send");
                        return jSONObject2;
                    }
                    long j2 = 0;
                    try {
                        j = Long.parseLong(jSONObjectOptJSONObject.optString(com.anythink.core.common.f.e.a.d));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    if (j == 0 && pkVarFs != null) {
                        try {
                            j = Long.parseLong(pkVarFs.q());
                        } catch (Exception unused2) {
                        }
                    }
                    try {
                        j2 = Long.parseLong(jSONObjectOptJSONObject.optString("ext_value"));
                    } catch (Exception unused3) {
                    }
                    long j3 = j2;
                    JSONObject jSONObject3 = new JSONObject();
                    String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(strOptString4)) {
                        try {
                            jSONObject3 = new JSONObject(strOptString4);
                        } catch (Exception unused4) {
                        }
                    }
                    this.n.n(strOptString3, jSONObject3);
                    if ("click".equals(strOptString3)) {
                        jSONObjectOa = this.n.oa(jSONObject3);
                        WeakReference<com.byazt.uv.w> weakReferenceTj = this.n.tj();
                        if (weakReferenceTj != null && (wVar2 = weakReferenceTj.get()) != null) {
                            wVar2.qg();
                        }
                    } else {
                        jSONObjectOa = jSONObject3;
                    }
                    String strN = this.n.n(strOptString2, strOptString3);
                    String strOptString5 = jSONObjectOa.optString("log_extra");
                    if (pkVarFs != null && strOptString3.contains("sanfang") && TextUtils.isEmpty(strOptString5)) {
                        jSONObjectOa.putOpt("log_extra", pkVarFs.F_());
                    }
                    com.byazt.hm.n.n(strOptString, strN, strOptString3, j, j3, jSONObjectOa, this.n.f());
                    jSONObject2.put("code", 0);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "extJson is null");
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
