package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve extends com.byazt.ee.c<JSONObject, JSONObject> {
    public final com.byazt.sd.nl pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("pageFinished", (com.byazt.ee.c<?, ?>) new ve(nlVar));
    }

    public ve(com.byazt.sd.nl nlVar) {
        this.pr = nlVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.sd.nl nlVar = this.pr;
        if (nlVar != null) {
            nlVar.g();
        }
        return jSONObject2;
    }
}
