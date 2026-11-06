package com.byazt.is;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 5})
public class uc {
    public boolean pr = false;
    public boolean hw = true;

    public static uc pr(String str) {
        uc ucVar = new uc();
        if (TextUtils.isEmpty(str)) {
            return ucVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ucVar.pr = jSONObject.optBoolean("encrypt", false);
            ucVar.hw = jSONObject.optBoolean("wait_io", true);
            return ucVar;
        } catch (Throwable th) {
            return ucVar;
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.pr);
            jSONObject.put("wait_io", this.hw);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
