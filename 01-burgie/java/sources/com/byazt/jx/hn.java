package com.byazt.jx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 20})
public class hn {
    public JSONObject pr;

    public hn(JSONObject jSONObject) {
        this.pr = jSONObject;
    }

    public boolean pr() {
        JSONObject jSONObject = this.pr;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public boolean hw() {
        JSONObject jSONObject = this.pr;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public boolean hn() {
        JSONObject jSONObject = this.pr;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public long x() {
        JSONObject jSONObject = this.pr;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public long c() {
        JSONObject jSONObject = this.pr;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public int uc() {
        JSONObject jSONObject = this.pr;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public int fw() {
        JSONObject jSONObject = this.pr;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }
}
