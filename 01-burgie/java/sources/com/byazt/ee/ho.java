package com.byazt.ee;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 19})
public final class ho {
    public final Map<String, Object> pr = new ConcurrentHashMap();

    public static ho pr() {
        return new ho();
    }

    private ho() {
    }

    public ho pr(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return this;
        }
        this.pr.put(str, obj);
        return this;
    }

    public String hw() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
