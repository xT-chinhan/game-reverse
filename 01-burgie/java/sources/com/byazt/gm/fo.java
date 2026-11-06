package com.byazt.gm;

import com.byazt.hg.jn;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo extends com.byazt.ee.c<JSONObject, JSONObject> {
    public final String hw;
    public final WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("interactiveStart", (com.byazt.ee.c<?, ?>) new fo(nlVar, "interactiveStart"));
        ybVar.pr("interactiveFinish", (com.byazt.ee.c<?, ?>) new fo(nlVar, "interactiveFinish"));
        ybVar.pr("interactiveEnd", (com.byazt.ee.c<?, ?>) new fo(nlVar, "interactiveEnd"));
    }

    public fo(com.byazt.sd.nl nlVar, String str) {
        this.pr = new WeakReference<>(nlVar);
        this.hw = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (this.pr.get() == null) {
            return jSONObject2;
        }
        com.byazt.sd.nl nlVar = this.pr.get();
        com.byazt.hg.of ofVarZo = nlVar.zo();
        int i = 0;
        boolean z = true;
        switch (this.hw) {
            case "interactiveStart":
                nlVar.lb();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iPr = pr(ofVarZo, jSONObject.optInt("reduce_duration", -1));
                    if (!z) {
                        i = -1;
                    } else {
                        nlVar.x(iPr);
                    }
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, i);
                    jSONObject2.put("reduce_duration", iPr);
                    break;
                } catch (JSONException e) {
                }
                return jSONObject2;
            case "interactiveEnd":
                nlVar.qa();
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int pr(com.byazt.hg.of ofVar, int i) {
        int iDl;
        if (ofVar == null) {
            iDl = 0;
        } else {
            iDl = ofVar.dl();
        }
        if (i >= 0 && iDl >= 0) {
            i = Math.min(i, iDl);
        } else if (i < 0) {
            if (iDl < 0) {
                i = 0;
            } else {
                i = iDl;
            }
        }
        if (jn.c(ofVar)) {
            return 0;
        }
        return i;
    }
}
