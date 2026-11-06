package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class nw {
    private int ab;
    private int ah;
    private int ao;
    private int c;
    private int ch;
    private int d;
    private int h;
    private int hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3070ms;
    private int ny;
    private int qv;
    private int sl;
    private String t;
    private int u;
    private int ub;
    private int x;
    private int xr;
    private String y;
    private int zb;

    public static boolean ms(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB != null && nwVarB.ao == 1;
    }

    private static nw b(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.mh();
    }

    public static int xr(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 0;
        }
        return nwVarB.d();
    }

    public static String ah(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return "close_obm";
        }
        int iD = nwVarB.d();
        String strZm = lmVar.zm();
        return (iD != 1 || strZm == null) ? "close_" + iD + "_" + strZm : "open";
    }

    public static int d(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.c;
    }

    public static int ka(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 0;
        }
        return nwVarB.ab;
    }

    public static int c(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return -1;
        }
        return nwVarB.hi;
    }

    public static boolean ab(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB != null && nwVarB.x == 1;
    }

    public static boolean x(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB != null && nwVarB.ny == 1;
    }

    public static int ny(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 300;
        }
        return nwVarB.ch;
    }

    public static boolean ch(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB != null && nwVarB.sl == 1;
    }

    public static int hi(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 0;
        }
        return nwVarB.f3070ms;
    }

    public static int sl(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.xr;
    }

    public static int zb(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.ah;
    }

    public static int u(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.d;
    }

    public static int ub(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.zb;
    }

    public static int ao(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 31457280;
        }
        return nwVarB.u * 1048576;
    }

    public static boolean h(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB != null && nwVarB.ub == 1;
    }

    public static int qv(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 1;
        }
        return nwVarB.ka;
    }

    public static int y(lm lmVar) {
        nw nwVarB = b(lmVar);
        if (nwVarB == null) {
            return 0;
        }
        return nwVarB.h;
    }

    public static String t(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB == null ? "" : nwVarB.y;
    }

    public static String nw(lm lmVar) {
        nw nwVarB = b(lmVar);
        return nwVarB == null ? "" : nwVarB.t;
    }

    public nw(JSONObject jSONObject) {
        this.f3070ms = 0;
        this.xr = 1;
        this.ah = 1;
        this.d = 1;
        this.ka = 1;
        this.c = 1;
        this.ab = 0;
        this.x = 0;
        this.ny = 0;
        this.ch = 300;
        this.hi = -1;
        this.sl = 1;
        this.zb = 1;
        this.u = 31457280;
        this.ub = 0;
        this.ao = 0;
        this.h = 0;
        this.qv = 0;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optInt("auto_open", 1);
        this.ab = jSONObject.optInt("download_mode", 0);
        this.x = jSONObject.optInt("auto_control", 0);
        this.ny = jSONObject.optInt("auto_control_choose", 0);
        this.ch = jSONObject.optInt("auto_control_time", 300);
        this.hi = jSONObject.optInt(com.anythink.core.common.e.g.a.l, -1);
        this.sl = jSONObject.optInt("if_suspend_download", 1);
        this.f3070ms = jSONObject.optInt("if_send_click", 0);
        this.xr = jSONObject.optInt("dl_popup", 1);
        this.ah = jSONObject.optInt("market_popup", 1);
        this.d = jSONObject.optInt("if_pop_lp", 1);
        this.ka = jSONObject.optInt("pop_up_style_id", 1);
        this.zb = jSONObject.optInt("dl_network", 1);
        this.u = jSONObject.optInt("dl_size", 31457280);
        this.ub = jSONObject.optInt("if_toast_market", 0);
        this.ao = jSONObject.optInt("enable_download_opt", 0);
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            this.h = 0;
        } else {
            this.h = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.qv = jSONObject.optInt("is_use_obm_convert", 0);
        this.y = jSONObject.optString("ugen_url");
        String strOptString = jSONObject.optString("ugen_md5");
        this.t = strOptString;
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(this.y, strOptString);
    }

    public int ms() {
        return this.xr;
    }

    public int xr() {
        return this.ab;
    }

    public boolean ah() {
        return this.sl == 1;
    }

    public int d() {
        return this.qv;
    }

    public int ka() {
        return this.h;
    }

    public void ms(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.c);
            jSONObject2.put("download_mode", this.ab);
            jSONObject2.put(com.anythink.core.common.e.g.a.l, this.hi);
            jSONObject2.put("auto_control", this.x);
            jSONObject2.put("auto_control_choose", this.ny);
            jSONObject2.put("auto_control_time", this.ch);
            jSONObject2.put("if_suspend_download", this.sl);
            jSONObject2.put("if_send_click", this.f3070ms);
            jSONObject2.put("dl_popup", this.xr);
            jSONObject2.put("market_popup", this.ah);
            jSONObject2.put("if_pop_lp", this.d);
            jSONObject2.put("pop_up_style_id", this.ka);
            jSONObject2.put("dl_network", this.zb);
            jSONObject2.put("dl_size", this.u);
            jSONObject2.put("if_toast_market", this.ub);
            jSONObject2.put("enable_download_opt", this.ao);
            jSONObject2.put("dl_suspend_popup", this.h);
            jSONObject2.put("is_use_obm_convert", this.qv);
            jSONObject2.put("ugen_url", this.y);
            jSONObject2.put("ugen_md5", this.t);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }
}
