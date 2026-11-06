package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 849})
public class ou {
    public static int n;
    public static int qg;

    public static void n(com.byazt.gwu.l lVar) {
        try {
            JSONObject jSONObject = new JSONObject(lVar.qg("dpl_status_counter", ""));
            n = jSONObject.optInt("minute", 0);
            qg = jSONObject.optInt("internal", 0);
            com.byazt.wfe.n.qg();
        } catch (JSONException unused) {
        }
    }

    public static void qg(com.byazt.gwu.l lVar) {
        lVar.n("dpl_status_counter", new JSONObject().toString());
    }

    public static int n() {
        return n;
    }

    public static int qg() {
        return qg;
    }

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("dpl_status_counter");
                if (jSONObjectOptJSONObject2 != null) {
                    n = jSONObjectOptJSONObject2.optInt("minute", 0);
                    qg = jSONObjectOptJSONObject2.optInt("internal", 0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
