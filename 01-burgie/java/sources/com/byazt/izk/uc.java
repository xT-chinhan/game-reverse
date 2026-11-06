package com.byazt.izk;

import com.byazt.ee.yb;
import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 5})
public class uc extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<nl> pr;

    public static void pr(yb ybVar, nl nlVar) {
        ybVar.pr("startVideoTransform", (com.byazt.ee.c<?, ?>) new uc(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        nl nlVar;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<nl> weakReference = this.pr;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (nlVar = this.pr.get()) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        nlVar.pr((float) jSONObjectOptJSONObject.optDouble("toX"), (float) jSONObjectOptJSONObject.optDouble("toY"), (float) jSONObjectOptJSONObject.optDouble("pivotX"), (float) jSONObjectOptJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        return jSONObject2;
    }

    public uc(nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }
}
