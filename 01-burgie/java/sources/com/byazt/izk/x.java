package com.byazt.izk;

import com.byazt.ee.yb;
import com.byazt.hg.of;
import com.byazt.sd.nl;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 121})
public class x extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<nl> pr;

    public static void pr(yb ybVar, final nl nlVar) {
        ybVar.pr("adInfoDialog", new com.byazt.ee.x.hw() { // from class: com.byazt.izk.x.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new x(nlVar);
            }
        });
    }

    public x(nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        of ofVarZo;
        zo.nt().of();
        nl nlVar = this.pr.get();
        if (nlVar == null || (ofVarZo = nlVar.zo()) == null) {
            return;
        }
        com.byazt.wt.c.pr(ucVar.getContext(), ofVarZo.td());
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
