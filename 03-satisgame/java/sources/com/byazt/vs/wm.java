package com.byazt.vs;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm extends com.byazt.cf.l<JSONObject, JSONObject> {
    public String n;
    public com.byazt.gct.pk q;
    public com.byazt.gcl.s qg;
    public Context s;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar, Context context, com.byazt.gct.pk pkVar) {
        cyVar.n("supportHaptic", (com.byazt.cf.l<?, ?>) new wm("supportHaptic", sVar, context, pkVar));
        cyVar.n("playHaptic", (com.byazt.cf.l<?, ?>) new wm("playHaptic", sVar, context, pkVar));
        cyVar.n("stopHaptic", (com.byazt.cf.l<?, ?>) new wm("stopHaptic", sVar, context, pkVar));
    }

    public wm(String str, com.byazt.gcl.s sVar, Context context, com.byazt.gct.pk pkVar) {
        this.n = str;
        this.qg = sVar;
        this.s = context;
        this.q = pkVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.n;
        str.hashCode();
        switch (str) {
            case "stopHaptic":
                Context context = this.s;
                if (context != null) {
                    com.byazt.bz.s.qg(context);
                }
                return jSONObject2;
            case "supportHaptic":
                Context context2 = this.s;
                jSONObject2.put("supportHaptic", context2 != null ? com.byazt.bz.s.n(context2) : false);
                return jSONObject2;
            case "playHaptic":
                com.byazt.bz.s.n(jSONObject, this.s, this.q);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
