package com.byazt.fhc;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.vkw.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 496, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hw {
    public c(Context context, com.byazt.hh.uc ucVar, com.byazt.hh.hw hwVar, k kVar) {
        super(context, hwVar, ucVar == null ? com.byazt.jwj.pr.hn() : ucVar, kVar);
    }

    @Override // com.byazt.ie.pr
    public boolean pr(com.byazt.hh.pr prVar) {
        return com.byazt.nn.x.fw(prVar);
    }

    @Override // com.byazt.fhc.hw
    public String pr() {
        return "adevent";
    }

    @Override // com.byazt.fhc.hw
    public com.byazt.yt.x pr(JSONObject jSONObject, String str, int i) throws JSONException {
        String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                String strOptString2 = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    jSONObject2.put("retry_count", i);
                    jSONObject2.put("db_rd", System.currentTimeMillis());
                    jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    jSONObject.put("params", jSONObjectOptJSONObject);
                }
            }
        } else {
            JSONObject jSONObject3 = new JSONObject(strOptString);
            jSONObject3.put("retry_count", i);
            jSONObject3.put("db_rd", System.currentTimeMillis());
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
        }
        return pr(str, jSONObject);
    }

    public com.byazt.yt.x pr(String str, JSONObject jSONObject) {
        return new com.byazt.yt.c(str, jSONObject);
    }
}
