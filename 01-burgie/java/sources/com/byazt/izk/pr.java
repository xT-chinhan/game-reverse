package com.byazt.izk;

import com.byazt.ca.ho;
import com.byazt.ee.yb;
import com.byazt.sd.nl;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 37})
public class pr extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<nl> pr;

    public static void pr(yb ybVar, final nl nlVar) {
        ybVar.pr("interstitial_webview_close", new com.byazt.ee.x.hw() { // from class: com.byazt.izk.pr.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new pr(nlVar);
            }
        });
    }

    public pr(nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        zo.nt().of();
        ho.hw("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        nl nlVar = this.pr.get();
        if (nlVar == null) {
            ho.hw("DoInterstitialWebViewCloseMethod", "invoke error");
            hn();
        } else {
            nlVar.yb();
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
