package com.byazt.pnm;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 18})
public class l {
    public boolean n = true;

    public static l n(String str) {
        l lVar = new l();
        if (TextUtils.isEmpty(str)) {
            return lVar;
        }
        try {
            lVar.n = new JSONObject(str).optBoolean("boost_can_upgrade", true);
        } catch (Throwable unused) {
        }
        return lVar;
    }

    public boolean n() {
        return this.n;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("boost_can_upgrade", this.n);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
