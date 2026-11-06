package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends com.byazt.ee.c<JSONObject, JSONObject> {
    public JSONObject pr;

    public g(JSONObject jSONObject) {
        this.pr = jSONObject;
    }

    public static void pr(com.byazt.ee.yb ybVar, JSONObject jSONObject) {
        ybVar.pr("getData", (com.byazt.ee.c<?, ?>) new g(jSONObject));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        return com.byazt.hc.hw.pr(this.pr, jSONObject);
    }
}
