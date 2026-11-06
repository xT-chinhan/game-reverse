package com.byazt.vs;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1088})
public class ur extends com.byazt.cf.l<JSONObject, JSONObject> {
    public String n;
    public com.byazt.gcl.s qg;
    public com.byazt.gct.pk s;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar, com.byazt.gct.pk pkVar) {
        cyVar.n("openNewAdPage", (com.byazt.cf.l<?, ?>) new ur("openNewAdPage", sVar, pkVar));
    }

    public ur(String str, com.byazt.gcl.s sVar, com.byazt.gct.pk pkVar) {
        this.n = str;
        this.qg = sVar;
        this.s = pkVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.n;
        str.hashCode();
        if (str.equals("openNewAdPage")) {
            if (this.qg != null) {
                int iOptInt = jSONObject.optInt("second_page_type", 0);
                this.qg.l(iOptInt);
                jSONObject2.put("code", 0);
                com.byazt.pnj.s.n(this.s, true, iOptInt);
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "jsObject is null");
                com.byazt.pnj.s.n(this.s, false, 0);
            }
        }
        return jSONObject2;
    }
}
