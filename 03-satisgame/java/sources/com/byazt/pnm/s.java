package com.byazt.pnm;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 8})
public class s {
    public boolean n = false;
    public boolean qg = true;

    public static s n(String str) {
        s sVar = new s();
        if (TextUtils.isEmpty(str)) {
            return sVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            sVar.n = jSONObject.optBoolean("encrypt", false);
            sVar.qg = jSONObject.optBoolean("wait_io", true);
        } catch (Throwable unused) {
        }
        return sVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.n);
            jSONObject.put("wait_io", this.qg);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
