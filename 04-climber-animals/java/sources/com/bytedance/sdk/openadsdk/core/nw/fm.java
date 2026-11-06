package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fm {
    private int ab;
    private int ah;
    private boolean c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3051ms;
    private int x;
    private int xr;

    public fm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.xr = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.ah = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 10);
            this.d = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.ka = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.c = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.ab = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.x = jSONObjectOptJSONObject.optInt("tip_time", 0);
        } else {
            this.xr = 10;
            this.ah = 10;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.umeng.analytics.pro.g.K);
        if (jSONObjectOptJSONObject2 != null) {
            this.f3051ms = !TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("group_id"));
        }
    }

    public void ms(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.xr);
            jSONObject2.put("draw_rewarded_play_time", this.ah);
            jSONObject2.put("skip_btn_left_style", this.d);
            jSONObject2.put("skip_btn_right_style", this.ka);
            jSONObject2.put("auto_slide", this.c);
            jSONObject2.put("show_time_type", this.ab);
            jSONObject2.put("tip_time", this.x);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static fm ny(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.q();
    }

    public static boolean ms(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return false;
        }
        return fmVarNy.f3051ms;
    }

    public static int xr(lm lmVar) {
        int i;
        fm fmVarNy = ny(lmVar);
        if (fmVarNy != null && (i = fmVarNy.xr) > 0) {
            return i;
        }
        return 10;
    }

    public static int ah(lm lmVar) {
        int i;
        fm fmVarNy = ny(lmVar);
        if (fmVarNy != null && (i = fmVarNy.ah) > 0) {
            return i;
        }
        return 10;
    }

    public static int d(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return 0;
        }
        return fmVarNy.d;
    }

    public static int ka(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return 0;
        }
        return fmVarNy.ka;
    }

    public static boolean c(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return false;
        }
        return fmVarNy.c;
    }

    public static int ab(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return 10;
        }
        if (fmVarNy.ab == 1) {
            return Math.min((int) Math.max(qr.c(lmVar), ah(lmVar)), 60);
        }
        return ah(lmVar);
    }

    public static int x(lm lmVar) {
        fm fmVarNy = ny(lmVar);
        if (fmVarNy == null) {
            return 25;
        }
        return fmVarNy.x;
    }
}
