package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 33})
public class um {
    public int a;
    public int cd;
    public int cp;
    public int cy;
    public int d;
    public int fs;
    public int hd;
    public int k;
    public int l;
    public int m;
    public int n;
    public int oa;
    public String ou;
    public int py;
    public int q;
    public int qg;
    public int rv;
    public int s;
    public int sz;
    public int tj;
    public int um;
    public int w;
    public String wm;
    public int x;

    private static um hd(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.D_();
    }

    public static int n(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 0;
        }
        return umVarHd.w();
    }

    public static String qg(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return "close_obm";
        }
        int iW = umVarHd.w();
        String strM = pkVar.m();
        return (iW != 1 || TextUtils.isEmpty(strM)) ? "close_" + iW + "_" + strM : "open";
    }

    public static int s(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 1;
        }
        return umVarHd.x;
    }

    public static int q(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 0;
        }
        return umVarHd.fs;
    }

    public static boolean l(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd != null && umVarHd.rv == 1;
    }

    public static boolean w(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd != null && umVarHd.tj == 1;
    }

    public static int x(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd == null ? TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX : umVarHd.cp;
    }

    public static int fs(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 0;
        }
        return umVarHd.n;
    }

    public static int rv(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 1;
        }
        return umVarHd.qg;
    }

    public static int n(um umVar) {
        if (umVar == null) {
            return 1;
        }
        return umVar.qg;
    }

    public static int tj(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 1;
        }
        return umVarHd.s;
    }

    public static int qg(um umVar) {
        if (umVar == null) {
            return 1;
        }
        return umVar.s;
    }

    public static int s(um umVar) {
        if (umVar == null) {
            return 1;
        }
        return umVar.q;
    }

    public static int q(um umVar) {
        if (umVar == null) {
            return 1;
        }
        return umVar.sz;
    }

    public static int l(um umVar) {
        if (umVar == null) {
            return 31457280;
        }
        return umVar.k * 1048576;
    }

    public static boolean w(um umVar) {
        return umVar != null && umVar.cy == 1;
    }

    public static int cp(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 0;
        }
        return umVarHd.m;
    }

    public static int d(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 1;
        }
        return umVarHd.l;
    }

    public static int oa(pk pkVar) {
        um umVarHd = hd(pkVar);
        if (umVarHd == null) {
            return 0;
        }
        return umVarHd.cd;
    }

    public static String sz(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd == null ? "" : umVarHd.ou;
    }

    public static String k(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd == null ? "" : umVarHd.wm;
    }

    public um(JSONObject jSONObject) {
        this.n = 0;
        this.qg = 1;
        this.s = 1;
        this.q = 1;
        this.l = 1;
        this.w = 0;
        this.x = 1;
        this.fs = 0;
        this.rv = 0;
        this.tj = 0;
        this.cp = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
        this.d = -1;
        this.oa = 1;
        this.sz = 1;
        this.k = 31457280;
        this.cy = 0;
        this.hd = 0;
        this.cd = 0;
        this.um = 0;
        this.a = 0;
        this.py = 0;
        this.m = 0;
        if (jSONObject == null) {
            return;
        }
        this.x = jSONObject.optInt("auto_open", 1);
        this.fs = jSONObject.optInt("download_mode", 0);
        this.rv = jSONObject.optInt("auto_control", 0);
        this.tj = jSONObject.optInt("auto_control_choose", 0);
        this.cp = jSONObject.optInt("auto_control_time", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        this.d = jSONObject.optInt("download_type", -1);
        this.oa = jSONObject.optInt("if_suspend_download", 1);
        this.n = jSONObject.optInt("if_send_click", 0);
        this.qg = jSONObject.optInt("dl_popup", 1);
        this.s = jSONObject.optInt("market_popup", 1);
        this.q = jSONObject.optInt("if_pop_lp", 1);
        this.l = jSONObject.optInt("pop_up_style_id", 1);
        this.sz = jSONObject.optInt("dl_network", 1);
        this.k = jSONObject.optInt("dl_size", 31457280);
        this.cy = jSONObject.optInt("if_toast_market", 0);
        this.hd = jSONObject.optInt("enable_download_opt", 0);
        this.py = jSONObject.optInt("show_7factors_card", 0);
        if (com.byazt.byp.qg.n()) {
            this.cd = 0;
        } else {
            this.cd = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.um = jSONObject.optInt("is_use_obm_convert", 0);
        this.a = jSONObject.optInt("enable_notification", 0);
        this.w = jSONObject.optInt("open_market_in_app", 0);
        this.m = jSONObject.optInt("resume_task", 0);
        this.ou = jSONObject.optString("ugen_url");
        String strOptString = jSONObject.optString("ugen_md5");
        this.wm = strOptString;
        com.byazt.ep.cp.n(this.ou, strOptString, (com.byazt.ep.s) null);
    }

    public int n() {
        return this.qg;
    }

    public int qg() {
        return this.fs;
    }

    public boolean s() {
        return this.py == 1;
    }

    public int q() {
        return this.d;
    }

    public boolean l() {
        return this.oa == 1;
    }

    public int w() {
        return this.um;
    }

    public static boolean cy(pk pkVar) {
        um umVarHd = hd(pkVar);
        return umVarHd != null && umVarHd.w == 1;
    }

    public int x() {
        return this.cd;
    }

    public void n(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.x);
            jSONObject2.put("download_mode", this.fs);
            jSONObject2.put("download_type", this.d);
            jSONObject2.put("auto_control", this.rv);
            jSONObject2.put("auto_control_choose", this.tj);
            jSONObject2.put("auto_control_time", this.cp);
            jSONObject2.put("if_suspend_download", this.oa);
            jSONObject2.put("if_send_click", this.n);
            jSONObject2.put("dl_popup", this.qg);
            jSONObject2.put("market_popup", this.s);
            jSONObject2.put("if_pop_lp", this.q);
            jSONObject2.put("pop_up_style_id", this.l);
            jSONObject2.put("dl_network", this.sz);
            jSONObject2.put("dl_size", this.k);
            jSONObject2.put("if_toast_market", this.cy);
            jSONObject2.put("enable_download_opt", this.hd);
            jSONObject2.put("dl_suspend_popup", this.cd);
            jSONObject2.put("is_use_obm_convert", this.um);
            jSONObject2.put("ugen_url", this.ou);
            jSONObject2.put("ugen_md5", this.wm);
            jSONObject2.put("enable_notification", this.a);
            jSONObject2.put("show_7factors_card", this.py);
            jSONObject2.put("open_market_in_app", this.w);
            jSONObject2.put("resume_task", this.m);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
