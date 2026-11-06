package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 745})
public class u extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final String n;
    public com.byazt.gcl.s qg;

    public u(com.byazt.gcl.s sVar, String str) {
        this.qg = sVar;
        this.n = str;
    }

    public static void n(com.byazt.gcl.s sVar, com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar) {
        cyVar.n("sendElement", (com.byazt.cf.l<?, ?>) new u(sVar, pkVar.h()));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (this.qg != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(itKeys.next());
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            if (jSONObjectOptJSONObject.has(com.byazt.af.x.n) && jSONObjectOptJSONObject.has("y")) {
                                jSONObjectOptJSONObject.put(com.byazt.af.x.n, com.byazt.okk.s.s(null, jSONObjectOptJSONObject.optInt(com.byazt.af.x.n)));
                                jSONObjectOptJSONObject.put("y", com.byazt.okk.s.s(null, jSONObjectOptJSONObject.optInt("y")));
                            }
                            if (jSONObjectOptJSONObject.has("width") && jSONObjectOptJSONObject.has("height")) {
                                jSONObjectOptJSONObject.put("width", com.byazt.okk.s.s(null, jSONObjectOptJSONObject.optInt("width")));
                                jSONObjectOptJSONObject.put("height", com.byazt.okk.s.s(null, jSONObjectOptJSONObject.optInt("height")));
                            }
                        }
                    }
                }
            }
            if (!n(jSONObject.optJSONArray(ILivePush.ClickType.CLOSE), false)) {
                n(jSONObject.optJSONArray("skip"), true);
            }
        }
        com.byazt.de.qg.n(this.n, 0, jSONObject);
        jSONObject2.put("code", 0);
        return jSONObject2;
    }

    private boolean n(JSONArray jSONArray, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return false;
        }
        this.qg.n(jSONObjectOptJSONObject.optInt(com.byazt.af.x.n), jSONObjectOptJSONObject.optInt("y"), jSONObjectOptJSONObject.optInt("width"), jSONObjectOptJSONObject.optInt("height"), z);
        return true;
    }
}
