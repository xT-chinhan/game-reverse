package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1257})
public class o {
    public int aj;
    public int c;
    public boolean fw;
    public boolean g;
    public boolean hn;
    public int ho;
    public int hw;
    public String k;
    public int m;
    public boolean nt;
    public boolean pr;
    public int uc;
    public int vk;
    public String w;
    public int x;
    public int zo;

    public o(JSONObject jSONObject) {
        this.vk = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.hw = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.x = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 30);
            this.c = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.uc = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.fw = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.zo = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.aj = jSONObjectOptJSONObject.optInt("tip_time", 0);
            this.vk = jSONObjectOptJSONObject.optInt("show_type", 0);
            this.hn = jSONObjectOptJSONObject.optBoolean("single_max_countdown", false);
            this.w = jSONObjectOptJSONObject.optString("top_template_url");
            this.k = jSONObjectOptJSONObject.optString("top_template_md5");
            this.m = jSONObjectOptJSONObject.optInt("top_template_timeout");
            this.g = jSONObjectOptJSONObject.optBoolean("can_cancel");
            this.ho = jSONObjectOptJSONObject.optInt("init_status_time", 0);
            this.nt = jSONObjectOptJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.hw = 10;
            this.x = 30;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.umeng.analytics.pro.d.K);
        if (jSONObjectOptJSONObject2 != null) {
            this.pr = !TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("group_id"));
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.hw);
            jSONObject2.put("draw_rewarded_play_time", this.x);
            jSONObject2.put("skip_btn_left_style", this.c);
            jSONObject2.put("skip_btn_right_style", this.uc);
            jSONObject2.put("auto_slide", this.fw);
            jSONObject2.put("show_time_type", this.zo);
            jSONObject2.put("show_type", this.vk);
            jSONObject2.put("tip_time", this.aj);
            jSONObject2.put("single_max_countdown", this.hn);
            jSONObject2.put("top_template_url", this.w);
            jSONObject2.put("top_template_md5", this.k);
            jSONObject2.put("top_template_timeout", this.m);
            jSONObject2.put("can_cancel", this.g);
            jSONObject2.put("init_status_time", this.ho);
            jSONObject2.put("is_pause_tip_by_express", this.nt);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e) {
        }
    }

    private static o yb(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.sw();
    }

    public static boolean pr(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return false;
        }
        return oVarYb.pr;
    }

    public static int hw(of ofVar) {
        int i;
        o oVarYb = yb(ofVar);
        if (oVarYb != null && (i = oVarYb.hw) > 0) {
            return i;
        }
        return 10;
    }

    public static int hn(of ofVar) {
        int i;
        o oVarYb = yb(ofVar);
        if (oVarYb != null && (i = oVarYb.x) > 0) {
            return i;
        }
        return 30;
    }

    public static int x(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 0;
        }
        return oVarYb.c;
    }

    public static int c(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 0;
        }
        return oVarYb.uc;
    }

    public static boolean uc(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return false;
        }
        return oVarYb.fw;
    }

    public static int fw(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 10;
        }
        if (oVarYb.zo == 1) {
            return Math.min((int) Math.max(qv.fw(ofVar), hn(ofVar)), 60);
        }
        return hn(ofVar);
    }

    public static boolean zo(of ofVar) {
        o oVarYb = yb(ofVar);
        return oVarYb != null && pr(ofVar) && oVarYb.vk == 1;
    }

    public static int aj(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 25;
        }
        return oVarYb.aj;
    }

    public static boolean vk(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return false;
        }
        return oVarYb.hn;
    }

    public static String w(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return null;
        }
        return oVarYb.w;
    }

    public static String k(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return null;
        }
        return oVarYb.k;
    }

    public static int m(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 0;
        }
        return oVarYb.m;
    }

    public static boolean g(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return false;
        }
        return oVarYb.g;
    }

    public static int ho(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return 0;
        }
        return oVarYb.ho;
    }

    public static boolean nt(of ofVar) {
        o oVarYb = yb(ofVar);
        if (oVarYb == null) {
            return false;
        }
        return oVarYb.nt;
    }
}
