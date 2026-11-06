package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
public class v extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar) {
        ybVar.pr("sendEventCode", (com.byazt.ee.c<?, ?>) new v(ofVar));
    }

    public v(com.byazt.hg.of ofVar) {
        this.pr = ofVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.rkl.hw hwVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.hg.of ofVar = this.pr;
        if (ofVar != null && (hwVar = (com.byazt.rkl.hw) com.byazt.sd.cz.pr(ofVar.cz(), com.byazt.rkl.hw.class)) != null) {
            HashMap map = new HashMap();
            int iOptInt = jSONObject.optInt("event_code", -1);
            if (iOptInt >= 200) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("info");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                hwVar.pr(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
