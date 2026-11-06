package com.byazt.mdu;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 37})
public class pr {
    public String c;
    public String hn;
    public int hw = -1;
    public String pr;
    public String x;

    public String pr() {
        return hw().toString();
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        pr(jSONObject);
        return jSONObject;
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.pr);
            jSONObject.put(Constants.ERROR_CODE_FIELD, String.valueOf(this.hw));
            jSONObject.put(Constants.ERROR_MSG_FIELD, this.hn);
            jSONObject.put("real_device_plan", this.x);
            jSONObject.put("device_plans", this.c);
        } catch (Throwable th) {
        }
    }

    public static pr pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        pr prVar = new pr();
        try {
            JSONObject jSONObject = new JSONObject(str);
            prVar.c = jSONObject.optString("device_plans", null);
            prVar.x = jSONObject.optString("real_device_plan", null);
            prVar.hn = jSONObject.optString(Constants.ERROR_MSG_FIELD, null);
            prVar.pr = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString(Constants.ERROR_CODE_FIELD);
            if (TextUtils.isEmpty(strOptString)) {
                prVar.hw = -1;
            } else {
                prVar.hw = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
        }
        return prVar;
    }
}
