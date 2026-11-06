package com.byazt.vs;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;

    public a(com.byazt.gct.pk pkVar) {
        this.n = pkVar;
    }

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar) {
        cyVar.n("getRestMetas", (com.byazt.cf.l<?, ?>) new a(pkVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.n != null) {
                jSONArray = new JSONArray(this.n.hj());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("creatives", jSONArray);
            jSONObject2.put(com.anythink.core.common.l.f.R, jSONObject3);
            jSONObject2.put("code", 0);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "success");
        } catch (Exception e) {
            com.byazt.tk.k.qg("GetRestMetasMethod", "getRestMetas error: " + e.getMessage());
            jSONObject2.put("code", -1);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
        }
        return jSONObject2;
    }
}
