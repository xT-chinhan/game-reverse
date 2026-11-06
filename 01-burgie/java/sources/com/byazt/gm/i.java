package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO})
public class i extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("ShowUgenDownloadDialog", (com.byazt.ee.c<?, ?>) new i(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        return hn();
    }

    public i(com.byazt.sd.nl nlVar) {
        this.pr = nlVar;
    }

    public JSONObject hn() {
        JSONObject jSONObject = new JSONObject();
        com.byazt.sd.nl nlVar = this.pr;
        if (nlVar == null) {
            try {
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, -1);
                jSONObject.put("codeMsg", "JsObject is null");
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return nlVar.k();
    }
}
