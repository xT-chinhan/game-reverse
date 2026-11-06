package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 990})
public class f {
    public boolean n;
    public int qg;

    public f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.n = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.qg = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.n ? 1 : 0);
            jSONObject2.put("filter_track", this.qg);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException unused2) {
        }
    }

    private static f s(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.m18do();
    }

    public static boolean n(pk pkVar) {
        f fVarS = s(pkVar);
        if (fVarS == null) {
            return false;
        }
        return fVarS.n;
    }

    public static boolean qg(pk pkVar) {
        f fVarS = s(pkVar);
        return fVarS != null && fVarS.qg == 1;
    }
}
