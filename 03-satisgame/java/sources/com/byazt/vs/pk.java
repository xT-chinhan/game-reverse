package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 36})
public class pk extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar) {
        cyVar.n("sendEventCode", (com.byazt.cf.l<?, ?>) new pk(pkVar));
    }

    public pk(com.byazt.gct.pk pkVar) {
        this.n = pkVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.mi.qg qgVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.gct.pk pkVar = this.n;
        if (pkVar != null && (qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(pkVar.py(), com.byazt.mi.qg.class)) != null) {
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
                qgVar.n(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
