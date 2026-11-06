package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
public class v {
    public int aj;
    public String c;
    public String fw;
    public int hn;
    public String hw;
    public int k;
    public boolean m;
    public int pr;
    public String uc;
    public int vk;
    public int w;
    public int x;
    public String zo;

    public v(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) != null) {
            this.m = true;
            pr(jSONObjectOptJSONObject.optInt("live_show_time", 60));
            this.hw = jSONObjectOptJSONObject.optString("live_author_nickname");
            this.hn = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
            this.x = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
            this.c = jSONObjectOptJSONObject.optString("live_description");
            this.uc = jSONObjectOptJSONObject.optString("live_feed_url");
            this.fw = jSONObjectOptJSONObject.optString("live_cover_image_url");
            this.zo = jSONObjectOptJSONObject.optString("live_avatar_url");
            this.aj = jSONObjectOptJSONObject.optInt("live_avatar_width");
            this.vk = jSONObjectOptJSONObject.optInt("live_avatar_height");
            this.w = jSONObjectOptJSONObject.optInt("live_cover_width");
            this.k = jSONObjectOptJSONObject.optInt("live_cover_height");
        }
    }

    public boolean pr() {
        return this.m;
    }

    public void pr(JSONObject jSONObject) {
        if (!this.m) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("live_show_time", this.pr);
            jSONObject2.put("live_author_nickname", this.hw);
            jSONObject2.put("live_author_follower_count", this.hn);
            jSONObject2.put("live_watch_count", this.x);
            jSONObject2.put("live_description", this.c);
            jSONObject2.put("live_feed_url", this.uc);
            jSONObject2.put("live_cover_image_url", this.fw);
            jSONObject2.put("live_avatar_url", this.zo);
            jSONObject2.put("live_cover_width", this.w);
            jSONObject2.put("live_cover_height", this.k);
            jSONObject2.put("live_avatar_width", this.aj);
            jSONObject2.put("live_avatar_height", this.vk);
            jSONObject2.put("isValid", this.m);
            jSONObject.put("live_ad", jSONObject2);
        } catch (Exception e) {
        }
    }

    private static v g(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.sf();
    }

    public static boolean pr(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return false;
        }
        return vVarG.m;
    }

    public static int hw(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.pr;
    }

    public void pr(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.pr = i;
    }

    public static String hn(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return "";
        }
        return vVarG.hw;
    }

    public static int x(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.hn;
    }

    public static int c(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.x;
    }

    public static String uc(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return "";
        }
        return vVarG.c;
    }

    public static String fw(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return "";
        }
        return vVarG.uc;
    }

    public static String zo(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return "";
        }
        return vVarG.fw;
    }

    public static String aj(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return "";
        }
        return vVarG.zo;
    }

    public static int vk(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.aj;
    }

    public static int w(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.vk;
    }

    public static int k(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.w;
    }

    public static int m(of ofVar) {
        v vVarG = g(ofVar);
        if (vVarG == null) {
            return 0;
        }
        return vVarG.k;
    }
}
