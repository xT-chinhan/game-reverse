package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("getSendRewardStatus", (com.byazt.ee.c<?, ?>) new a(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.nl nlVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null && (nlVar = this.pr.get()) != null) {
            jSONObject2.put("isReward", nlVar.fw());
        }
        return jSONObject2;
    }

    public a(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }
}
