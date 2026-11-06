package com.byazt.vs;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 990})
public class f extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;
    public long q;
    public com.byazt.gct.pk qg;
    public com.byazt.uv.x s;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar, final com.byazt.gct.pk pkVar) {
        cyVar.n("requestVideoDelayCallback", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.f.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new f(sVar, pkVar);
            }
        });
    }

    public f(com.byazt.gcl.s sVar, com.byazt.gct.pk pkVar) {
        this.n = new WeakReference<>(sVar);
        this.qg = pkVar;
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s sVar = this.n.get();
        if (sVar == null || jSONObject == null) {
            s();
            return;
        }
        this.s = new com.byazt.uv.x() { // from class: com.byazt.vs.f.2
            @Override // com.byazt.uv.x
            public void n() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.vs.f.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            f.this.n(new JSONObject());
                        } catch (Exception e) {
                            com.byazt.tk.k.qg("requestVideoDelay", e.getMessage());
                        }
                    }
                }, f.this.q);
            }
        };
        int iOptInt = jSONObject.optInt("delay", -1);
        if (iOptInt < 0) {
            return;
        }
        this.q = iOptInt;
        if (sVar.s() != null && sVar.s().Q_()) {
            this.s.n();
        } else {
            sVar.n(this.s);
        }
    }
}
