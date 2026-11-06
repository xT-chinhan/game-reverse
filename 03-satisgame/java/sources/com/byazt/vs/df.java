package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 34})
public final class df extends com.byazt.cf.q<JSONObject, JSONObject> {
    public static WeakReference<n> n;
    public WeakReference<com.byazt.gcl.s> qg;

    public interface n {
        void n();

        void n(int i);
    }

    @Override // com.byazt.cf.q
    public void q() {
    }

    private df(com.byazt.gcl.s sVar) {
        this.qg = new WeakReference<>(sVar);
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("onClickBrowseCloseCallback", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.df.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new df(sVar);
            }
        });
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        WeakReference<n> weakReference = n;
        n nVar = weakReference != null ? weakReference.get() : null;
        if (this.qg == null || jSONObject == null) {
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (nVar != null) {
                nVar.n();
            }
        } else if (nVar != null) {
            nVar.n(iOptInt);
        }
    }

    public static void n(n nVar) {
        n = new WeakReference<>(nVar);
    }
}
