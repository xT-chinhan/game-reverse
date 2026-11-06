package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xn {
    private String ah;
    private boolean c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3113ms;
    private int xr;

    public xn(JSONObject jSONObject) {
        this.c = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.c = true;
            xr(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            ah(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            ms(jSONObjectOptJSONObject.optString("reward_live_text"));
            ms(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            d(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    public void ms(JSONObject jSONObject) {
        if (this.c) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.f3113ms);
                jSONObject2.put("reward_live_style", this.xr);
                jSONObject2.put("reward_live_text", this.ah);
                jSONObject2.put("reward_start_time", this.d);
                jSONObject2.put("reward_close_time", this.ka);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }

    public static boolean ms(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        if (xnVarNy == null) {
            return false;
        }
        return xnVarNy.c;
    }

    public static int xr(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        if (xnVarNy == null) {
            return 1;
        }
        return xnVarNy.f3113ms;
    }

    public static boolean ah(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        return xnVarNy == null || !xnVarNy.c || xnVarNy.f3113ms == 1;
    }

    public static boolean d(lm lmVar) {
        int i;
        xn xnVarNy = ny(lmVar);
        return xnVarNy != null && xnVarNy.c && com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(lmVar) && ((i = xnVarNy.f3113ms) == 3 || i == 4);
    }

    private void xr(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.f3113ms = i;
    }

    public static int ka(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        if (xnVarNy == null) {
            return 1;
        }
        return xnVarNy.xr;
    }

    private void ah(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.xr = i;
    }

    public static String c(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        return xnVarNy == null ? "去抖音观看直播\n可提前5s获得奖励哦" : xnVarNy.ah;
    }

    private void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.xr == 3 ? "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦" : "去抖音观看直播\n可提前5s获得奖励哦";
        }
        this.ah = str;
    }

    public static int ab(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        if (xnVarNy == null) {
            return 5;
        }
        return Math.max(xnVarNy.d, 0);
    }

    public void ms(int i) {
        this.d = i;
    }

    public static int x(lm lmVar) {
        xn xnVarNy = ny(lmVar);
        if (xnVarNy == null) {
            return 10;
        }
        return Math.max(xnVarNy.ka, 3);
    }

    private void d(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.ka = i;
    }

    private static xn ny(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.or();
    }
}
