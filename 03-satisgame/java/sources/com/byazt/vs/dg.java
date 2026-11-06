package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1140})
public class dg extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final String n;

    public dg(String str) {
        this.n = str;
    }

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar) {
        cyVar.n("sendAction", (com.byazt.cf.l<?, ?>) new dg(pkVar.h()));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        Object objQ = com.byazt.de.qg.q(this.n, 1);
        if (objQ instanceof JSONArray) {
            ((JSONArray) objQ).put(jSONObject);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            com.byazt.de.qg.n(this.n, 1, jSONArray);
        }
        jSONObject2.put("code", 0);
        return jSONObject2;
    }
}
