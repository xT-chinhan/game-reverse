package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1668})
public class wo {
    public static int n = -1;
    public static int qg = -1;
    public static int s = -1;

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        n = -1;
        qg = -1;
        s = -1;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("med_fea_cf")) == null) {
            return;
        }
        n = jSONObjectOptJSONObject2.optInt("avg_hold_time_limit1", -1);
        qg = jSONObjectOptJSONObject2.optInt("avg_hold_time_limit2", -1);
        s = jSONObjectOptJSONObject2.optInt("min_show_limit", -1);
    }

    public static void n(com.byazt.gwu.l lVar) {
        lVar.n("med_fea_cf_avg_hold_time_limit1", n);
        lVar.n("med_fea_cf_avg_hold_time_limit2", qg);
        lVar.n("med_fea_cf_min_show_limit", s);
    }

    public static void qg(com.byazt.gwu.l lVar) {
        n = lVar.qg("med_fea_cf_avg_hold_time_limit1", -1);
        qg = lVar.qg("med_fea_cf_avg_hold_time_limit2", -1);
        s = lVar.qg("med_fea_cf_min_show_limit", -1);
    }

    public static int n() {
        return n;
    }

    public static int qg() {
        return qg;
    }

    public static int s() {
        return s;
    }
}
