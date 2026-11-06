package com.byazt.izk;

import com.byazt.ee.yb;
import com.byazt.hg.of;
import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<nl> pr;

    public c(nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    public static void pr(yb ybVar, final nl nlVar) {
        ybVar.pr("openPrivacy", new com.byazt.ee.x.hw() { // from class: com.byazt.izk.c.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new c(nlVar);
            }
        });
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        nl nlVar;
        of ofVarZo;
        WeakReference<nl> weakReference = this.pr;
        if (weakReference == null || (nlVar = weakReference.get()) == null || (ofVarZo = nlVar.zo()) == null) {
            return;
        }
        com.byazt.wt.c.pr(ucVar.getContext(), ofVarZo);
        nlVar.s();
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
