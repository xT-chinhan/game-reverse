package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of hn;
    public com.byazt.sd.nl hw;
    public String pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar, com.byazt.hg.of ofVar) {
        ybVar.pr("openNewAdPage", (com.byazt.ee.c<?, ?>) new b("openNewAdPage", nlVar, ofVar));
    }

    public b(String str, com.byazt.sd.nl nlVar, com.byazt.hg.of ofVar) {
        this.pr = str;
        this.hw = nlVar;
        this.hn = ofVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        switch (this.pr) {
            case "openNewAdPage":
                if (this.hw != null) {
                    int iOptInt = jSONObject.optInt("second_page_type", 0);
                    this.hw.c(iOptInt);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
                    com.byazt.tt.hn.pr(this.hn, true, iOptInt);
                    break;
                } else {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "jsObject is null");
                    com.byazt.tt.hn.pr(this.hn, false, 0);
                    break;
                }
            default:
                return jSONObject2;
        }
    }
}
