package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2211})
public class dn {
    public String l;
    public boolean n;
    public String q;
    public int qg;
    public int s;
    public boolean w;
    public int x;

    public dn(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.w = true;
        this.n = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
        this.qg = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
        this.s = jSONObjectOptJSONObject.optInt("card_click_area", 2);
        this.l = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
        int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
        this.x = iOptInt;
        if (iOptInt == 1) {
            this.q = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.q = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public void n(JSONObject jSONObject) {
        try {
            if (this.w) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.n);
                jSONObject2.put("card_stay_count_down", this.qg);
                jSONObject2.put("card_click_area", this.s);
                jSONObject2.put("card_text", this.l);
                jSONObject2.put("card_top_text", this.q);
                jSONObject2.put("splash_card_style_id", this.x);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean n(pk pkVar) {
        dn dnVarD = d(pkVar);
        if (dnVarD != null && !pkVar.qf() && pkVar.ys() != 2 && dnVarD.w && tj(pkVar) < com.byazt.nf.rv.qg().wl() && cp(pkVar)) {
            return dnVarD.w;
        }
        return false;
    }

    public static void qg(pk pkVar) {
        dn dnVarD = d(pkVar);
        if (dnVarD == null || pkVar.qf() || pkVar.ys() == 2 || !dnVarD.w || tj(pkVar) >= com.byazt.nf.rv.qg().wl()) {
            return;
        }
        com.byazt.hm.n.s(pkVar, "splash_ad", "if_splash_card");
        if (cp(pkVar)) {
            return;
        }
        com.byazt.hm.n.s(pkVar, "splash_ad", "card_show_fail");
    }

    public static String s(pk pkVar) {
        dn dnVarD = d(pkVar);
        return (dnVarD == null || TextUtils.isEmpty(dnVarD.l)) ? "详情页或第三方应用" : dnVarD.l;
    }

    public static String q(pk pkVar) {
        dn dnVarD = d(pkVar);
        if (dnVarD == null) {
            return "点击跳转";
        }
        if (l(pkVar) == 1) {
            return TextUtils.isEmpty(dnVarD.q) ? "摇一摇或点击了解更多" : dnVarD.q;
        }
        return TextUtils.isEmpty(dnVarD.q) ? "点击跳转" : dnVarD.q;
    }

    public static int l(pk pkVar) {
        dn dnVarD = d(pkVar);
        if (dnVarD == null) {
            return 0;
        }
        return dnVarD.x;
    }

    public static int w(pk pkVar) {
        int i;
        dn dnVarD = d(pkVar);
        if (dnVarD != null && (i = dnVarD.qg) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    public static boolean x(pk pkVar) {
        dn dnVarD = d(pkVar);
        return dnVarD == null || dnVarD.s == 1;
    }

    public static boolean fs(pk pkVar) {
        dn dnVarD = d(pkVar);
        if (dnVarD == null) {
            return true;
        }
        return dnVarD.n;
    }

    private static dn d(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.bz();
    }

    private static String oa(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.mk();
    }

    public static void rv(pk pkVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(oa(pkVar), "tt_sp");
        int iQg = sVarN.qg("splash_card_show_day", -1) == i ? sVarN.qg("splash_card_show_count", 0) : 0;
        sVarN.n("splash_card_show_day", i);
        sVarN.n("splash_card_show_count", iQg + 1);
    }

    public static int tj(pk pkVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(oa(pkVar), "tt_sp");
        int iQg = sVarN.qg("splash_card_show_day", -1);
        int iQg2 = sVarN.qg("splash_card_show_count", 0);
        if (iQg == i) {
            return iQg2;
        }
        return 0;
    }

    public static boolean cp(pk pkVar) {
        if (pkVar == null || pkVar.xu() == null || !pkVar.xu().l() || pkVar.jo() == null || pkVar.jo().isEmpty() || !pkVar.jo().get(0).l() || TextUtils.isEmpty(pkVar.E_())) {
            return false;
        }
        if (TextUtils.isEmpty(pkVar.yr())) {
            return (pkVar.k() == null || TextUtils.isEmpty(pkVar.k().s())) ? false : true;
        }
        return true;
    }
}
