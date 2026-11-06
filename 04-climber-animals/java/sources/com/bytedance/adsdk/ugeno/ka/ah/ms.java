package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ka.ch;
import com.bytedance.adsdk.ugeno.ka.hi;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected String ab;
    protected com.bytedance.adsdk.ugeno.ka.c ah;
    protected String c;
    protected Context ch;
    protected com.bytedance.adsdk.ugeno.ka.c.ms d;
    protected Map<String, String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected hi f360ms;
    protected String ny;
    protected String x;
    protected com.bytedance.adsdk.ugeno.xr.ah xr;

    public abstract boolean ms(Object... objArr);

    public ms(Context context) {
        this.ch = context;
    }

    public void c() {
        this.d = this.ah.ms();
        com.bytedance.adsdk.ugeno.ka.c cVar = this.ah;
        if (cVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.ka.c.ms msVarMs = cVar.ms();
        this.d = msVarMs;
        if (msVarMs == null) {
            return;
        }
        this.ka = msVarMs.ah();
        this.c = this.d.xr();
        this.ab = this.d.ms();
        this.x = this.d.d();
        this.ny = this.d.ka();
    }

    public String ab() {
        return this.c;
    }

    public String x() {
        return this.ny;
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.xr = ahVar;
    }

    public void ms(com.bytedance.adsdk.ugeno.ka.c cVar) {
        this.ah = cVar;
    }

    public void ms(hi hiVar) {
        this.f360ms = hiVar;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ka.ah.ms$ms, reason: collision with other inner class name */
    public static class C0194ms {
        public static ms ms(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.ka.c cVarMs;
            com.bytedance.adsdk.ugeno.ka.c.ms msVarMs;
            com.bytedance.adsdk.ugeno.ka.ab abVarMs;
            if (ahVar == null || jSONObject == null || (cVarMs = com.bytedance.adsdk.ugeno.ka.c.ms(jSONObject, jSONObject2)) == null || (msVarMs = cVarMs.ms()) == null) {
                return null;
            }
            String strMs = msVarMs.ms();
            if (TextUtils.equals(strMs, "custom")) {
                xr xrVar = new xr(context);
                xrVar.ms(ahVar);
                xrVar.ms(cVarMs);
                xrVar.c();
                return xrVar;
            }
            if (TextUtils.isEmpty(strMs) || TextUtils.equals(strMs, "global")) {
                abVarMs = ch.ms(msVarMs.xr());
            } else {
                abVarMs = ch.ms(msVarMs.ka());
            }
            if (abVarMs == null) {
                return null;
            }
            ms msVarMs2 = abVarMs.ms(context);
            msVarMs2.ms(ahVar);
            msVarMs2.ms(cVarMs);
            msVarMs2.c();
            return msVarMs2;
        }
    }
}
