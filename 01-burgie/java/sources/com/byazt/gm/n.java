package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT})
public class n extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.ea.hw pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.ea.hw hwVar) {
        ybVar.pr("RendUgenDownloadDialogState", (com.byazt.ee.c<?, ?>) new n(hwVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        pr(jSONObject);
        return hn();
    }

    private void pr(JSONObject jSONObject) {
        if (jSONObject == null || this.pr == null) {
            return;
        }
        int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
        if (iOptInt == 200) {
            this.pr.pr();
        } else {
            this.pr.pr(iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }

    public n(com.byazt.ea.hw hwVar) {
        this.pr = hwVar;
    }

    public JSONObject hn() {
        return new JSONObject();
    }
}
