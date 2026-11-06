package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends com.byazt.ee.x<JSONObject, JSONObject> {
    public com.byazt.ap.x hn;
    public com.byazt.hg.of hw;
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar, final com.byazt.hg.of ofVar) {
        ybVar.pr("getNetworkData", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.zo.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new zo(nlVar, ofVar);
            }
        });
    }

    public zo(com.byazt.sd.nl nlVar, com.byazt.hg.of ofVar) {
        this.pr = new WeakReference<>(nlVar);
        this.hw = ofVar;
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.nl nlVar = this.pr.get();
        if (nlVar == null) {
            hn();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.hn = new com.byazt.ap.x() { // from class: com.byazt.gm.zo.2
            @Override // com.byazt.ap.x
            public void pr(boolean z, List<com.byazt.hg.of> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        zo.this.pr(jSONObject2);
                    } else {
                        jSONObject2.put("creatives", com.byazt.sd.nl.pr(list));
                        jSONObject2.put("is_cache", z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", jCurrentTimeMillis - com.byazt.sb.hw.pr().hn(zo.this.hw));
                        }
                        zo.this.pr(jSONObject2);
                    }
                    com.byazt.sd.zo.nt().of();
                } catch (Throwable th) {
                    com.byazt.ca.ho.pr("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if (!((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.byazt.sb.hw.pr().pr(this.hw, this.hn))) {
            nlVar.pr(jSONObject, this.hn);
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
