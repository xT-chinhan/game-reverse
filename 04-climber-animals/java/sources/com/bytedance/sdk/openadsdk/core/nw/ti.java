package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ti {
    private int ab;
    private int ah;
    private boolean c;
    private String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3098ms;
    private int xr;

    public ti(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.c = true;
        this.f3098ms = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
        this.xr = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
        this.ah = jSONObjectOptJSONObject.optInt("card_click_area", 2);
        this.ka = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
        int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
        this.ab = iOptInt;
        if (iOptInt == 1) {
            this.d = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.d = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public void ms(JSONObject jSONObject) {
        try {
            if (this.c) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.f3098ms);
                jSONObject2.put("card_stay_count_down", this.xr);
                jSONObject2.put("card_click_area", this.ah);
                jSONObject2.put("card_text", this.ka);
                jSONObject2.put("card_top_text", this.d);
                jSONObject2.put("splash_card_style_id", this.ab);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static boolean ms(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        if (tiVarCh != null && !lmVar.pn() && lmVar.od() != 2 && tiVarCh.c && xr() < com.bytedance.sdk.openadsdk.core.re.xr().eh() && ny(lmVar)) {
            return tiVarCh.c;
        }
        return false;
    }

    public static void xr(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        if (tiVarCh == null || lmVar.pn() || lmVar.od() == 2 || !tiVarCh.c || xr() >= com.bytedance.sdk.openadsdk.core.re.xr().eh()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ah(lmVar, "splash_ad", "if_splash_card");
        if (ny(lmVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ah(lmVar, "splash_ad", "card_show_fail");
    }

    public static String ah(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        return (tiVarCh == null || TextUtils.isEmpty(tiVarCh.ka)) ? "详情页或第三方应用" : tiVarCh.ka;
    }

    public static String d(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        if (tiVarCh == null) {
            return "点击跳转";
        }
        if (ka(lmVar) == 1) {
            return TextUtils.isEmpty(tiVarCh.d) ? "摇一摇或点击了解更多" : tiVarCh.d;
        }
        return TextUtils.isEmpty(tiVarCh.d) ? "点击跳转" : tiVarCh.d;
    }

    public static int ka(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        if (tiVarCh == null) {
            return 0;
        }
        return tiVarCh.ab;
    }

    public static int c(lm lmVar) {
        int i;
        ti tiVarCh = ch(lmVar);
        if (tiVarCh != null && (i = tiVarCh.xr) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    public static boolean ab(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        return tiVarCh == null || tiVarCh.ah == 1;
    }

    public static boolean x(lm lmVar) {
        ti tiVarCh = ch(lmVar);
        if (tiVarCh == null) {
            return true;
        }
        return tiVarCh.f3098ms;
    }

    private static ti ch(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.tz();
    }

    public static void ms() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.jw.g.ms(null);
        int iXr = xrVarMs.xr("splash_card_show_day", -1) == i ? xrVarMs.xr("splash_card_show_count", 0) : 0;
        xrVarMs.ms("splash_card_show_day", i);
        xrVarMs.ms("splash_card_show_count", iXr + 1);
    }

    public static int xr() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.jw.g.ms(null);
        int iXr = xrVarMs.xr("splash_card_show_day", -1);
        int iXr2 = xrVarMs.xr("splash_card_show_count", 0);
        if (iXr == i) {
            return iXr2;
        }
        return 0;
    }

    public static boolean ny(lm lmVar) {
        if (lmVar == null || lmVar.qd() == null || !lmVar.qd().ka() || lmVar.fk() == null || lmVar.fk().isEmpty() || !lmVar.fk().get(0).ka() || TextUtils.isEmpty(lmVar.eh())) {
            return false;
        }
        if (TextUtils.isEmpty(lmVar.nq())) {
            return (lmVar.zh() == null || TextUtils.isEmpty(lmVar.zh().ah())) ? false : true;
        }
        return true;
    }
}
