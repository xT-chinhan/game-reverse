package com.byazt.vs;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, AVMDLDataLoader.KeyIsIsTestSpeedVersion})
public class dh extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("showAppDetailOrPrivacyDialog", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.dh.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new dh(sVar);
            }
        });
    }

    public dh(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.vyf.s.cy().pk();
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null) {
            return;
        }
        com.byazt.gcl.s sVar = weakReference.get();
        if (sVar == null) {
            s();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("show_dialog_style");
        if (iOptInt == 1) {
            sVar.h();
        } else if (iOptInt == 2) {
            sVar.hu();
        }
    }
}
