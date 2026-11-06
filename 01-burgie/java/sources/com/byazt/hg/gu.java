package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 665})
public class gu {
    public String c;
    public int fw;
    public int hn;
    public int hw;
    public boolean pr;
    public boolean uc;
    public String x;

    public gu(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) != null) {
            this.uc = true;
            this.pr = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
            this.hw = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
            this.hn = jSONObjectOptJSONObject.optInt("card_click_area", 2);
            this.c = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
            int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
            this.fw = iOptInt;
            if (iOptInt == 1) {
                this.x = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
            } else {
                this.x = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
            }
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            if (this.uc) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.pr);
                jSONObject2.put("card_stay_count_down", this.hw);
                jSONObject2.put("card_click_area", this.hn);
                jSONObject2.put("card_text", this.c);
                jSONObject2.put("card_top_text", this.x);
                jSONObject2.put("splash_card_style_id", this.fw);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e) {
        }
    }

    public static boolean pr(of ofVar) {
        gu guVarK = k(ofVar);
        if (guVarK == null || ofVar.sh() || ofVar.rf() == 2 || !guVarK.uc || vk(ofVar) >= com.byazt.sd.a.hw().qh() || !w(ofVar)) {
            return false;
        }
        return guVarK.uc;
    }

    public static void hw(of ofVar) {
        gu guVarK = k(ofVar);
        if (guVarK == null || ofVar.sh() || ofVar.rf() == 2 || !guVarK.uc || vk(ofVar) >= com.byazt.sd.a.hw().qh()) {
            return;
        }
        com.byazt.pj.pr.hn(ofVar, "splash_ad", "if_splash_card");
        if (!w(ofVar)) {
            com.byazt.pj.pr.hn(ofVar, "splash_ad", "card_show_fail");
        }
    }

    public static String hn(of ofVar) {
        gu guVarK = k(ofVar);
        return (guVarK == null || TextUtils.isEmpty(guVarK.c)) ? "详情页或第三方应用" : guVarK.c;
    }

    public static String x(of ofVar) {
        gu guVarK = k(ofVar);
        if (guVarK == null) {
            return "点击跳转";
        }
        if (c(ofVar) == 1) {
            return TextUtils.isEmpty(guVarK.x) ? "摇一摇或点击了解更多" : guVarK.x;
        }
        return TextUtils.isEmpty(guVarK.x) ? "点击跳转" : guVarK.x;
    }

    public static int c(of ofVar) {
        gu guVarK = k(ofVar);
        if (guVarK == null) {
            return 0;
        }
        return guVarK.fw;
    }

    public static int uc(of ofVar) {
        int i;
        gu guVarK = k(ofVar);
        if (guVarK == null || (i = guVarK.hw) <= 0 || i > 5) {
            return 5;
        }
        return i;
    }

    public static boolean fw(of ofVar) {
        gu guVarK = k(ofVar);
        return guVarK == null || guVarK.hn == 1;
    }

    public static boolean zo(of ofVar) {
        gu guVarK = k(ofVar);
        if (guVarK == null) {
            return true;
        }
        return guVarK.pr;
    }

    private static gu k(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.qx();
    }

    private static String m(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.yn();
    }

    public static void aj(of ofVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(m(ofVar), "tt_sp");
        int iHw = hnVarPr.hw("splash_card_show_day", -1) == i ? hnVarPr.hw("splash_card_show_count", 0) : 0;
        hnVarPr.pr("splash_card_show_day", i);
        hnVarPr.pr("splash_card_show_count", iHw + 1);
    }

    public static int vk(of ofVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(m(ofVar), "tt_sp");
        int iHw = hnVarPr.hw("splash_card_show_day", -1);
        int iHw2 = hnVarPr.hw("splash_card_show_count", 0);
        if (iHw == i) {
            return iHw2;
        }
        return 0;
    }

    public static boolean w(of ofVar) {
        if (ofVar == null || ofVar.mo() == null || !ofVar.mo().c() || ofVar.de() == null || ofVar.de().isEmpty() || !ofVar.de().get(0).c() || TextUtils.isEmpty(ofVar.A_())) {
            return false;
        }
        if (TextUtils.isEmpty(ofVar.zj())) {
            return (ofVar.ho() == null || TextUtils.isEmpty(ofVar.ho().hn())) ? false : true;
        }
        return true;
    }
}
