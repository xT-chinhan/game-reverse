package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 5})
public class q extends com.byazt.cf.l<JSONObject, JSONObject> {
    public AtomicBoolean n = new AtomicBoolean(false);
    public AtomicBoolean qg = new AtomicBoolean(false);
    public com.byazt.gcl.s s;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("businessStatusNotify", (com.byazt.cf.l<?, ?>) new q(sVar));
    }

    public q(com.byazt.gcl.s sVar) {
        this.s = sVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null || this.s == null) {
            return jSONObject2;
        }
        int iOptInt = jSONObject.optInt("status", 0);
        if (iOptInt == 0) {
            this.s.qg(0, 0);
        } else if (iOptInt == 1) {
            int iOptInt2 = jSONObject.optInt("completed", 0);
            int iOptInt3 = jSONObject.optInt("finished", 0);
            if (iOptInt2 == 1 && this.n.compareAndSet(false, true)) {
                this.s.qg(1, 1);
            }
            if (iOptInt3 == 1 && this.qg.compareAndSet(false, true)) {
                this.s.qg(1, 2);
            }
        } else if (iOptInt == 2) {
            this.s.qg(2, jSONObject.optInt("callUpStatus", 0));
        }
        return jSONObject2;
    }
}
