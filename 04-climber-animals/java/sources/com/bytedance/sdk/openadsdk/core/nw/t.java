package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private boolean ab;
    private int ah;
    private int c;
    private int ch;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3097ms;
    private String ny;
    private String x;
    private int xr;

    public t(JSONObject jSONObject) {
        this.xr = 0;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("reward_browse_type", 0);
        this.xr = iOptInt;
        if (iOptInt < 0 || iOptInt > 3) {
            this.xr = 0;
        }
        if (this.xr == 2) {
            this.xr = 3;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (jSONObjectOptJSONObject != null) {
            this.f3097ms = jSONObjectOptJSONObject.optString("direct_landing_url");
            this.ah = jSONObjectOptJSONObject.optInt("display_duration", 0);
            this.d = jSONObjectOptJSONObject.optInt("close_time", 0);
            this.ka = jSONObjectOptJSONObject.optInt("page_type");
            this.c = jSONObjectOptJSONObject.optInt("show_type");
            this.ab = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
            if (jSONObjectOptJSONObject2 != null) {
                this.x = jSONObjectOptJSONObject2.optString("ugen_url");
                this.ny = jSONObjectOptJSONObject2.optString("ugen_md5");
            }
            this.ch = jSONObjectOptJSONObject.optInt("close_btn_position");
        }
    }

    public void ms(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.xr);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.f3097ms);
            jSONObject2.put("display_duration", this.ah);
            jSONObject2.put("close_time", this.d);
            jSONObject2.put("page_type", this.ka);
            jSONObject2.put("show_type", this.c);
            jSONObject2.put("close_btn_position", this.ch);
            jSONObject2.put("is_landing_with_sound", this.ab);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.x);
            jSONObject3.put("ugen_md5", this.ny);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
    }

    public static boolean ms(lm lmVar) {
        t tVarAo = ao(lmVar);
        return (tVarAo == null || x(lmVar) == 0 || TextUtils.isEmpty(tVarAo.f3097ms)) ? false : true;
    }

    public static boolean xr(lm lmVar) {
        if (ms(lmVar)) {
            return ab(lmVar);
        }
        return false;
    }

    public static boolean ah(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo != null && tVarAo.xr == 1 && tVarAo.ka == 1;
    }

    public static boolean d(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo != null && ms(lmVar) && tVarAo.xr == 1 && tVarAo.ka == 2;
    }

    public static boolean ka(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo != null && tVarAo.c == 3;
    }

    public static String c(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo == null ? "" : tVarAo.f3097ms;
    }

    public static boolean ab(lm lmVar) {
        t tVarAo = ao(lmVar);
        if (tVarAo == null) {
            return false;
        }
        return tVarAo.ab;
    }

    public static int x(lm lmVar) {
        t tVarAo = ao(lmVar);
        if (tVarAo == null) {
            return 0;
        }
        return tVarAo.xr;
    }

    private static t ao(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.sa();
    }

    public static int ny(lm lmVar) {
        int i;
        t tVarAo = ao(lmVar);
        if (tVarAo != null && (i = tVarAo.ah) >= 0) {
            return i;
        }
        return 0;
    }

    public static int ch(lm lmVar) {
        int i;
        t tVarAo = ao(lmVar);
        if (tVarAo != null && (i = tVarAo.d) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean hi(lm lmVar) {
        return ao(lmVar) != null && x(lmVar) == 3 && ms(lmVar);
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.c.ms sl(lm lmVar) {
        t tVarAo = ao(lmVar);
        if (tVarAo == null || TextUtils.isEmpty(tVarAo.x)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
        msVar.ah(tVarAo.x);
        msVar.xr(tVarAo.ny);
        msVar.ms(tVarAo.x);
        return msVar;
    }

    public static boolean zb(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo != null && tVarAo.ch == 1;
    }

    public static boolean u(lm lmVar) {
        t tVarAo = ao(lmVar);
        return tVarAo != null && tVarAo.ch == 2;
    }

    public static int ub(lm lmVar) {
        t tVarAo = ao(lmVar);
        if (tVarAo == null) {
            return 0;
        }
        return tVarAo.ch;
    }
}
