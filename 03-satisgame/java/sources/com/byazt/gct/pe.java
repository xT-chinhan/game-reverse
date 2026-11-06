package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 865})
public class pe {
    public String cp;
    public boolean cy;
    public String d;
    public int fs;
    public int k;
    public int l;
    public boolean n;
    public int oa;
    public int q;
    public int qg;
    public int rv;
    public boolean s;
    public boolean sz;
    public int tj;
    public int w;
    public boolean x;

    public pe(JSONObject jSONObject) {
        this.tj = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.qg = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.q = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 30);
            this.l = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.w = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.x = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.fs = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.rv = jSONObjectOptJSONObject.optInt("tip_time", 0);
            this.tj = jSONObjectOptJSONObject.optInt("show_type", 0);
            this.s = jSONObjectOptJSONObject.optBoolean("single_max_countdown", false);
            this.cp = jSONObjectOptJSONObject.optString("top_template_url");
            this.d = jSONObjectOptJSONObject.optString("top_template_md5");
            this.oa = jSONObjectOptJSONObject.optInt("top_template_timeout");
            this.sz = jSONObjectOptJSONObject.optBoolean("can_cancel");
            this.k = jSONObjectOptJSONObject.optInt("init_status_time", 0);
            this.cy = jSONObjectOptJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.qg = 10;
            this.q = 30;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("group_info");
        if (jSONObjectOptJSONObject2 != null) {
            this.n = !TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("group_id"));
        }
    }

    public void n(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.qg);
            jSONObject2.put("draw_rewarded_play_time", this.q);
            jSONObject2.put("skip_btn_left_style", this.l);
            jSONObject2.put("skip_btn_right_style", this.w);
            jSONObject2.put("auto_slide", this.x);
            jSONObject2.put("show_time_type", this.fs);
            jSONObject2.put("show_type", this.tj);
            jSONObject2.put("tip_time", this.rv);
            jSONObject2.put("single_max_countdown", this.s);
            jSONObject2.put("top_template_url", this.cp);
            jSONObject2.put("top_template_md5", this.d);
            jSONObject2.put("top_template_timeout", this.oa);
            jSONObject2.put("can_cancel", this.sz);
            jSONObject2.put("init_status_time", this.k);
            jSONObject2.put("is_pause_tip_by_express", this.cy);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    private static pe hd(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.ah();
    }

    public static boolean n(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return false;
        }
        return peVarHd.n;
    }

    public static int qg(pk pkVar) {
        int i;
        pe peVarHd = hd(pkVar);
        if (peVarHd != null && (i = peVarHd.qg) > 0) {
            return i;
        }
        return 10;
    }

    public static int s(pk pkVar) {
        int i;
        pe peVarHd = hd(pkVar);
        if (peVarHd != null && (i = peVarHd.q) > 0) {
            return i;
        }
        return 30;
    }

    public static int q(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 0;
        }
        return peVarHd.l;
    }

    public static int l(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 0;
        }
        return peVarHd.w;
    }

    public static boolean w(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return false;
        }
        return peVarHd.x;
    }

    public static int x(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 10;
        }
        if (peVarHd.fs == 1) {
            return Math.min((int) Math.max(ta.x(pkVar), s(pkVar)), 60);
        }
        return s(pkVar);
    }

    public static boolean fs(pk pkVar) {
        pe peVarHd = hd(pkVar);
        return peVarHd != null && n(pkVar) && peVarHd.tj == 1;
    }

    public static int rv(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 25;
        }
        return peVarHd.rv;
    }

    public static boolean tj(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return false;
        }
        return peVarHd.s;
    }

    public static String cp(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return null;
        }
        return peVarHd.cp;
    }

    public static String d(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return null;
        }
        return peVarHd.d;
    }

    public static int oa(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 0;
        }
        return peVarHd.oa;
    }

    public static boolean sz(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return false;
        }
        return peVarHd.sz;
    }

    public static int k(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return 0;
        }
        return peVarHd.k;
    }

    public static boolean cy(pk pkVar) {
        pe peVarHd = hd(pkVar);
        if (peVarHd == null) {
            return false;
        }
        return peVarHd.cy;
    }
}
