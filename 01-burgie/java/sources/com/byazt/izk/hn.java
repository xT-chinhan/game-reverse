package com.byazt.izk;

import com.byazt.ee.yb;
import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 20})
public class hn extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<nl> pr;

    public static void pr(yb ybVar, nl nlVar) {
        ybVar.pr("rewardPlayAgain", (com.byazt.ee.c<?, ?>) new hn(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        nl nlVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<nl> weakReference = this.pr;
        if (weakReference == null || weakReference.get() == null || (nlVar = this.pr.get()) == null) {
            return jSONObject2;
        }
        nlVar.a();
        return jSONObject2;
    }

    public hn(nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }
}
