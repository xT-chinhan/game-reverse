package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE})
public class e {
    public int l;
    public int n;
    public int q;
    public int qg;
    public String s;
    public boolean w;

    public e(JSONObject jSONObject) {
        this.w = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.w = true;
            qg(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            s(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            n(jSONObjectOptJSONObject.optString("reward_live_text"));
            n(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            q(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    public void n(JSONObject jSONObject) {
        if (this.w) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.n);
                jSONObject2.put("reward_live_style", this.qg);
                jSONObject2.put("reward_live_text", this.s);
                jSONObject2.put("reward_start_time", this.q);
                jSONObject2.put("reward_close_time", this.l);
                jSONObject2.put("isValid", this.w);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public static boolean n(pk pkVar) {
        e eVarRv = rv(pkVar);
        if (eVarRv == null) {
            return false;
        }
        return eVarRv.w;
    }

    public boolean n() {
        return this.w;
    }

    public static int qg(pk pkVar) {
        e eVarRv = rv(pkVar);
        if (eVarRv == null) {
            return 1;
        }
        return eVarRv.n;
    }

    public static boolean s(pk pkVar) {
        e eVarRv = rv(pkVar);
        return eVarRv == null || !eVarRv.w || eVarRv.n == 1;
    }

    public static boolean q(pk pkVar) {
        int i;
        e eVarRv = rv(pkVar);
        return eVarRv != null && eVarRv.w && com.byazt.wq.qg.n().n(pkVar) && ((i = eVarRv.n) == 3 || i == 4);
    }

    private void qg(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.n = i;
    }

    public static int l(pk pkVar) {
        e eVarRv = rv(pkVar);
        if (eVarRv == null) {
            return 1;
        }
        return eVarRv.qg;
    }

    private void s(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.qg = i;
    }

    public static String w(pk pkVar) {
        e eVarRv = rv(pkVar);
        return eVarRv == null ? "去抖音观看直播\n可提前5s获得奖励哦" : eVarRv.s;
    }

    private void n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.qg == 3 ? "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦" : "去抖音观看直播\n可提前5s获得奖励哦";
        }
        this.s = str;
    }

    public static int x(pk pkVar) {
        e eVarRv = rv(pkVar);
        if (eVarRv == null) {
            return 5;
        }
        return Math.max(eVarRv.q, 0);
    }

    public void n(int i) {
        this.q = i;
    }

    public static int fs(pk pkVar) {
        e eVarRv = rv(pkVar);
        if (eVarRv == null) {
            return 10;
        }
        return Math.max(eVarRv.l, 3);
    }

    private void q(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.l = i;
    }

    private static e rv(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.ml();
    }
}
