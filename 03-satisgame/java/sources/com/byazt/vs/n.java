package com.byazt.vs;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 19})
public class n extends com.byazt.cf.l<JSONObject, JSONObject> {
    public String n;
    public Context qg;

    public static void n(com.byazt.cf.cy cyVar, Context context) {
        cyVar.n("closeView", (com.byazt.cf.l<?, ?>) new n("closeView", context));
    }

    public n(String str, Context context) {
        this.n = str;
        this.qg = context;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.n;
        str.hashCode();
        if (str.equals("closeView")) {
            Context context = this.qg;
            if (context != null) {
                ((Activity) context).finish();
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        }
        return jSONObject2;
    }
}
