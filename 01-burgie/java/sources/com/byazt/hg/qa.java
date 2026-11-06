package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 101})
public class qa {
    public int a;
    public int aj;
    public int c;
    public int cz;
    public String fo;
    public int fw;
    public int g;
    public int hn;
    public int ho;
    public int hw;
    public int k;
    public int lb;
    public int m;
    public int nt;
    public String ny;
    public int pr;
    public int qa;
    public int rc;
    public int uc;
    public int vk;
    public int w;
    public int x;
    public int yb;
    public int zo;

    private static qa yb(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.z_();
    }

    public static int pr(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 0;
        }
        return qaVarYb.uc();
    }

    public static String hw(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return "close_obm";
        }
        int iUc = qaVarYb.uc();
        String strRc = ofVar.rc();
        if (iUc == 1 && !TextUtils.isEmpty(strRc)) {
            return "open";
        }
        return "close_" + iUc + "_" + strRc;
    }

    public static int hn(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 1;
        }
        return qaVarYb.fw;
    }

    public static int x(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 0;
        }
        return qaVarYb.zo;
    }

    public static boolean c(of ofVar) {
        qa qaVarYb = yb(ofVar);
        return qaVarYb != null && qaVarYb.aj == 1;
    }

    public static boolean uc(of ofVar) {
        qa qaVarYb = yb(ofVar);
        return qaVarYb != null && qaVarYb.vk == 1;
    }

    public static int fw(of ofVar) {
        qa qaVarYb = yb(ofVar);
        return qaVarYb == null ? TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX : qaVarYb.w;
    }

    public static int zo(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 0;
        }
        return qaVarYb.pr;
    }

    public static int aj(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 1;
        }
        return qaVarYb.hw;
    }

    public static int pr(qa qaVar) {
        if (qaVar == null) {
            return 1;
        }
        return qaVar.hw;
    }

    public static int vk(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 1;
        }
        return qaVarYb.hn;
    }

    public static int hw(qa qaVar) {
        if (qaVar == null) {
            return 1;
        }
        return qaVar.hn;
    }

    public static int hn(qa qaVar) {
        if (qaVar == null) {
            return 1;
        }
        return qaVar.x;
    }

    public static int x(qa qaVar) {
        if (qaVar == null) {
            return 1;
        }
        return qaVar.g;
    }

    public static int c(qa qaVar) {
        if (qaVar == null) {
            return 31457280;
        }
        return qaVar.ho * 1048576;
    }

    public static boolean uc(qa qaVar) {
        return qaVar != null && qaVar.nt == 1;
    }

    public static int w(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 0;
        }
        return qaVarYb.rc;
    }

    public static int k(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 1;
        }
        return qaVarYb.c;
    }

    public static int m(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return 0;
        }
        return qaVarYb.lb;
    }

    public static String g(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return "";
        }
        return qaVarYb.ny;
    }

    public static String ho(of ofVar) {
        qa qaVarYb = yb(ofVar);
        if (qaVarYb == null) {
            return "";
        }
        return qaVarYb.fo;
    }

    public qa(JSONObject jSONObject) {
        this.pr = 0;
        this.hw = 1;
        this.hn = 1;
        this.x = 1;
        this.c = 1;
        this.uc = 0;
        this.fw = 1;
        this.zo = 0;
        this.aj = 0;
        this.vk = 0;
        this.w = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
        this.k = -1;
        this.m = 1;
        this.g = 1;
        this.ho = 31457280;
        this.nt = 0;
        this.yb = 0;
        this.lb = 0;
        this.qa = 0;
        this.a = 0;
        this.cz = 0;
        this.rc = 0;
        if (jSONObject != null) {
            this.fw = jSONObject.optInt("auto_open", 1);
            this.zo = jSONObject.optInt("download_mode", 0);
            this.aj = jSONObject.optInt("auto_control", 0);
            this.vk = jSONObject.optInt("auto_control_choose", 0);
            this.w = jSONObject.optInt("auto_control_time", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
            this.k = jSONObject.optInt("download_type", -1);
            this.m = jSONObject.optInt("if_suspend_download", 1);
            this.pr = jSONObject.optInt("if_send_click", 0);
            this.hw = jSONObject.optInt("dl_popup", 1);
            this.hn = jSONObject.optInt("market_popup", 1);
            this.x = jSONObject.optInt("if_pop_lp", 1);
            this.c = jSONObject.optInt("pop_up_style_id", 1);
            this.g = jSONObject.optInt("dl_network", 1);
            this.ho = jSONObject.optInt("dl_size", 31457280);
            this.nt = jSONObject.optInt("if_toast_market", 0);
            this.yb = jSONObject.optInt("enable_download_opt", 0);
            this.cz = jSONObject.optInt("show_7factors_card", 0);
            if (!com.byazt.iy.hw.pr()) {
                this.lb = jSONObject.optInt("dl_suspend_popup", 0);
            } else {
                this.lb = 0;
            }
            this.qa = jSONObject.optInt("is_use_obm_convert", 0);
            this.a = jSONObject.optInt("enable_notification", 0);
            this.uc = jSONObject.optInt("open_market_in_app", 0);
            this.rc = jSONObject.optInt("resume_task", 0);
            this.ny = jSONObject.optString("ugen_url");
            String strOptString = jSONObject.optString("ugen_md5");
            this.fo = strOptString;
            com.byazt.ea.w.pr(this.ny, strOptString, (com.byazt.ea.hn) null);
        }
    }

    public int pr() {
        return this.hw;
    }

    public int hw() {
        return this.zo;
    }

    public boolean hn() {
        return this.cz == 1;
    }

    public int x() {
        return this.k;
    }

    public boolean c() {
        return this.m == 1;
    }

    public int uc() {
        return this.qa;
    }

    public static boolean nt(of ofVar) {
        qa qaVarYb = yb(ofVar);
        return qaVarYb != null && qaVarYb.uc == 1;
    }

    public int fw() {
        return this.lb;
    }

    public void pr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.fw);
            jSONObject2.put("download_mode", this.zo);
            jSONObject2.put("download_type", this.k);
            jSONObject2.put("auto_control", this.aj);
            jSONObject2.put("auto_control_choose", this.vk);
            jSONObject2.put("auto_control_time", this.w);
            jSONObject2.put("if_suspend_download", this.m);
            jSONObject2.put("if_send_click", this.pr);
            jSONObject2.put("dl_popup", this.hw);
            jSONObject2.put("market_popup", this.hn);
            jSONObject2.put("if_pop_lp", this.x);
            jSONObject2.put("pop_up_style_id", this.c);
            jSONObject2.put("dl_network", this.g);
            jSONObject2.put("dl_size", this.ho);
            jSONObject2.put("if_toast_market", this.nt);
            jSONObject2.put("enable_download_opt", this.yb);
            jSONObject2.put("dl_suspend_popup", this.lb);
            jSONObject2.put("is_use_obm_convert", this.qa);
            jSONObject2.put("ugen_url", this.ny);
            jSONObject2.put("ugen_md5", this.fo);
            jSONObject2.put("enable_notification", this.a);
            jSONObject2.put("show_7factors_card", this.cz);
            jSONObject2.put("open_market_in_app", this.uc);
            jSONObject2.put("resume_task", this.rc);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e) {
        }
    }
}
