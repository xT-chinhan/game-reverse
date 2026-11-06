package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1748})
public class fi {
    public JSONObject n;

    public String toString() {
        JSONObject jSONObject = this.n;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String n() {
        JSONObject jSONObject = this.n;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(ImagesContract.URL) : "";
    }

    public static fi n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static fi n(JSONObject jSONObject) {
        fi fiVar = new fi();
        fiVar.n = jSONObject;
        return fiVar;
    }
}
