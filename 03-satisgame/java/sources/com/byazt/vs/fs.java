package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 101})
public class fs extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;
    public com.byazt.gct.pk qg;
    public com.byazt.uv.q s;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar, final com.byazt.gct.pk pkVar) {
        cyVar.n("getNetworkData", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.fs.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new fs(sVar, pkVar);
            }
        });
    }

    public fs(com.byazt.gcl.s sVar, com.byazt.gct.pk pkVar) {
        this.n = new WeakReference<>(sVar);
        this.qg = pkVar;
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s sVar = this.n.get();
        if (sVar == null) {
            s();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.s = new com.byazt.uv.q() { // from class: com.byazt.vs.fs.2
            @Override // com.byazt.uv.q
            public void n(boolean z, List<com.byazt.gct.pk> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        fs.this.n(jSONObject2);
                    } else {
                        jSONObject2.put("creatives", com.byazt.gcl.s.n(list));
                        jSONObject2.put("is_cache", z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", jCurrentTimeMillis - com.byazt.ltk.n.n().s(fs.this.qg));
                        }
                        fs.this.n(jSONObject2);
                    }
                    com.byazt.vyf.s.cy().pk();
                } catch (Throwable th) {
                    com.byazt.tk.k.n("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if ((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.byazt.ltk.n.n().n(this.qg, this.s)) {
            return;
        }
        sVar.n(jSONObject, this.s);
    }
}
