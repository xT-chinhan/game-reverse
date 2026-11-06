package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1642})
public class oj {
    public int cp;
    public int d;
    public String fs;
    public String l;
    public int n;
    public boolean oa;
    public int q;
    public String qg;
    public int rv;
    public int s;
    public int tj;
    public String w;
    public String x;

    public oj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.oa = true;
        n(jSONObjectOptJSONObject.optInt("live_show_time", 60));
        this.qg = jSONObjectOptJSONObject.optString("live_author_nickname");
        this.s = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
        this.q = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
        this.l = jSONObjectOptJSONObject.optString("live_description");
        this.w = jSONObjectOptJSONObject.optString("live_feed_url");
        this.x = jSONObjectOptJSONObject.optString("live_cover_image_url");
        this.fs = jSONObjectOptJSONObject.optString("live_avatar_url");
        this.rv = jSONObjectOptJSONObject.optInt("live_avatar_width");
        this.tj = jSONObjectOptJSONObject.optInt("live_avatar_height");
        this.cp = jSONObjectOptJSONObject.optInt("live_cover_width");
        this.d = jSONObjectOptJSONObject.optInt("live_cover_height");
    }

    public boolean n() {
        return this.oa;
    }

    public void n(JSONObject jSONObject) {
        if (this.oa) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.n);
                jSONObject2.put("live_author_nickname", this.qg);
                jSONObject2.put("live_author_follower_count", this.s);
                jSONObject2.put("live_watch_count", this.q);
                jSONObject2.put("live_description", this.l);
                jSONObject2.put("live_feed_url", this.w);
                jSONObject2.put("live_cover_image_url", this.x);
                jSONObject2.put("live_avatar_url", this.fs);
                jSONObject2.put("live_cover_width", this.cp);
                jSONObject2.put("live_cover_height", this.d);
                jSONObject2.put("live_avatar_width", this.rv);
                jSONObject2.put("live_avatar_height", this.tj);
                jSONObject2.put("isValid", this.oa);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private static oj sz(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.nh();
    }

    public static boolean n(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return false;
        }
        return ojVarSz.oa;
    }

    public static int qg(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.n;
    }

    public void n(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.n = i;
    }

    public static String s(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        return ojVarSz == null ? "" : ojVarSz.qg;
    }

    public static int q(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.s;
    }

    public static int l(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.q;
    }

    public static String w(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        return ojVarSz == null ? "" : ojVarSz.l;
    }

    public static String x(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        return ojVarSz == null ? "" : ojVarSz.w;
    }

    public static String fs(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        return ojVarSz == null ? "" : ojVarSz.x;
    }

    public static String rv(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        return ojVarSz == null ? "" : ojVarSz.fs;
    }

    public static int tj(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.rv;
    }

    public static int cp(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.tj;
    }

    public static int d(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.cp;
    }

    public static int oa(pk pkVar) {
        oj ojVarSz = sz(pkVar);
        if (ojVarSz == null) {
            return 0;
        }
        return ojVarSz.d;
    }
}
