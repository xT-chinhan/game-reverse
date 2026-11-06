package com.byazt.ns;

import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1419, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.eq.hn {
    public nl pr;

    public c(nl nlVar) {
        this.pr = nlVar;
    }

    @Override // com.byazt.eq.hn
    public void pr(String str, JSONObject jSONObject) {
        nl nlVar = this.pr;
        if (nlVar != null) {
            nlVar.hw(str, jSONObject);
        }
    }
}
