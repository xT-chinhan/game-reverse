package com.bytedance.sdk.openadsdk.core.nw;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class le {
    private int ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3064ms;
    private long xr;

    public static le ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        le leVar = new le();
        leVar.f3064ms = jSONObject.optInt("refresh_control", 0);
        leVar.xr = jSONObject.optLong("refresh_imp_max_time", 0L);
        leVar.ah = jSONObject.optInt("refresh_num", 0);
        leVar.d = jSONObject.optBoolean("is_force_show_skip", false);
        return leVar;
    }

    public void xr(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.f3064ms);
            jSONObject.put("refresh_imp_max_time", this.xr);
            jSONObject.put("refresh_num", this.ah);
            jSONObject.put("is_force_show_skip", this.d);
        } catch (JSONException unused) {
        }
    }

    public static boolean ms(lm lmVar) {
        le leVarFi;
        return (lmVar == null || (leVarFi = lmVar.fi()) == null || leVarFi.ms() != 1) ? false : true;
    }

    public int ms() {
        return this.f3064ms;
    }

    public long xr() {
        return this.xr;
    }

    public int ah() {
        return this.ah;
    }

    public void ms(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.d;
    }

    public static boolean ms(List<lm> list) {
        Iterator<lm> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().ld() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }

    public static boolean xr(lm lmVar) {
        return com.bytedance.sdk.openadsdk.core.re.xr().ao(String.valueOf(com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar))) && ms(lmVar) && !com.bytedance.sdk.openadsdk.core.u.d.ms(String.valueOf(com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar)));
    }
}
