package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;
    public List<JSONObject> qg;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar, List<JSONObject> list) {
        cyVar.n("getAdsData", (com.byazt.cf.l<?, ?>) new oa(pkVar, list));
    }

    public oa(com.byazt.gct.pk pkVar, List<JSONObject> list) {
        this.n = pkVar;
        this.qg = list;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iOptInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (iOptInt < 0) {
            iOptInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.n.pv()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.qg;
        if (list != null && list.size() > 0) {
            if (iOptInt > this.qg.size()) {
                iOptInt = this.qg.size();
            }
            int iMin = Math.min(iOptInt, 3);
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(i, this.qg.get(i));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(com.anythink.core.common.l.f.R, jSONObject2);
        return jSONObject5;
    }
}
