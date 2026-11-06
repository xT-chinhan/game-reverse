package com.byazt.vs;

import com.byazt.gct.cx;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final WeakReference<com.byazt.gcl.s> n;
    public final String qg;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("interactiveStart", (com.byazt.cf.l<?, ?>) new m(sVar, "interactiveStart"));
        cyVar.n("interactiveFinish", (com.byazt.cf.l<?, ?>) new m(sVar, "interactiveFinish"));
        cyVar.n("interactiveEnd", (com.byazt.cf.l<?, ?>) new m(sVar, "interactiveEnd"));
    }

    public m(com.byazt.gcl.s sVar, String str) {
        this.n = new WeakReference<>(sVar);
        this.qg = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (this.n.get() == null) {
            return jSONObject2;
        }
        com.byazt.gcl.s sVar = this.n.get();
        com.byazt.gct.pk pkVarFs = sVar.fs();
        String str = this.qg;
        str.hashCode();
        int i = 0;
        boolean z = true;
        switch (str) {
            case "interactiveStart":
                sVar.cd();
                return jSONObject2;
            case "interactiveEnd":
                sVar.um();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iN = n(pkVarFs, jSONObject.optInt("reduce_duration", -1));
                    if (z) {
                        sVar.q(iN);
                    } else {
                        i = -1;
                    }
                    jSONObject2.put("code", i);
                    jSONObject2.put("reduce_duration", iN);
                    break;
                } catch (JSONException unused) {
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int n(com.byazt.gct.pk pkVar, int i) {
        int iQi = pkVar != null ? pkVar.qi() : 0;
        if (i >= 0 && iQi >= 0) {
            i = Math.min(i, iQi);
        } else if (i < 0) {
            i = iQi >= 0 ? iQi : 0;
        }
        if (cx.l(pkVar)) {
            return 0;
        }
        return i;
    }
}
