package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 751})
public class lq {
    public boolean n;
    public int q;
    public boolean qg;
    public int s;

    public lq(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.n = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.qg = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.s = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.q = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.n);
            jSONObject2.put("can_click_to_landing", this.qg);
            jSONObject2.put("auto_to_landing_type", this.s);
            jSONObject2.put("auto_to_landing_time", this.q);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.byazt.tk.k.n("parse json:" + e.getMessage());
        }
    }

    public static boolean n(pk pkVar) {
        lq lqVarOu = cx.ou(pkVar);
        if (lqVarOu == null || !lqVarOu.n || nf.n(pkVar) == 1) {
            return false;
        }
        if (nf.n(pkVar) == 2 && nf.s(pkVar) == 3) {
            return false;
        }
        if (nf.n(pkVar) == 2 && nf.s(pkVar) == 7) {
            return false;
        }
        return (pkVar.ge() == 5 || pkVar.ge() == 15) && !TextUtils.isEmpty(l(pkVar));
    }

    public static boolean qg(pk pkVar) {
        lq lqVarOu = cx.ou(pkVar);
        if (lqVarOu == null) {
            return false;
        }
        return lqVarOu.qg;
    }

    public static int s(pk pkVar) {
        lq lqVarOu = cx.ou(pkVar);
        if (lqVarOu == null) {
            return 0;
        }
        return lqVarOu.s;
    }

    public static int q(pk pkVar) {
        lq lqVarOu = cx.ou(pkVar);
        if (lqVarOu == null) {
            return 0;
        }
        return lqVarOu.q;
    }

    public static String l(pk pkVar) {
        return pkVar == null ? "" : pkVar.fs();
    }
}
