package com.bytedance.ms.xr.ka.ms;

import android.content.Context;
import android.os.Process;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ub;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    protected com.bytedance.ms.xr.ka ah = x.ms().ah();
    protected xr d;
    protected d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.ms.xr.ah f573ms;
    protected Context xr;

    protected boolean ms() {
        return true;
    }

    protected boolean xr() {
        return true;
    }

    ah(com.bytedance.ms.xr.ah ahVar, Context context, xr xrVar, d dVar) {
        this.f573ms = ahVar;
        this.xr = context;
        this.d = xrVar;
        this.ka = dVar;
    }

    public com.bytedance.ms.xr.ah.ms ms(com.bytedance.ms.xr.ah.ms msVar) {
        if (msVar == null) {
            msVar = new com.bytedance.ms.xr.ah.ms();
        }
        xr(msVar);
        ka(msVar);
        return msVar;
    }

    void xr(com.bytedance.ms.xr.ah.ms msVar) {
        xr xrVar;
        if (xr() && (xrVar = this.d) != null) {
            msVar.ms(xrVar);
        }
        msVar.ms(x.c());
        xr xrVar2 = this.d;
        msVar.ms("is_background", Boolean.valueOf((xrVar2 == null || !xrVar2.ah()) && !com.bytedance.ms.xr.x.ms.ms(this.xr)));
        msVar.ms("pid", Integer.valueOf(Process.myPid()));
        msVar.ms("battery", Integer.valueOf(this.ka.ms()));
        msVar.ms(this.ah.ka());
        msVar.xr(x.ny());
        msVar.ms(x.ch(), x.hi());
        msVar.ms(this.ah.c());
        msVar.ms(ub.ms(this.xr));
        if (ms()) {
            d(msVar);
        }
        msVar.ms(this.ah.d());
        String strAb = x.ab();
        if (strAb != null) {
            msVar.ms("business", strAb);
        }
        if (x.x()) {
            msVar.ms("is_mp", (Object) 1);
        }
        msVar.ah(x.xr().ms());
        msVar.ms("crash_uuid", UUID.randomUUID().toString());
    }

    void ah(com.bytedance.ms.xr.ah.ms msVar) {
        Map<String, Object> mapMs = x.ms().ms();
        if (mapMs == null) {
            return;
        }
        if (mapMs.containsKey("app_version")) {
            msVar.ms("crash_version", mapMs.get("app_version"));
        }
        if (mapMs.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            msVar.ms("app_version", mapMs.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapMs.containsKey("version_code")) {
            try {
                msVar.ms("crash_version_code", Integer.valueOf(Integer.parseInt(mapMs.get("version_code").toString())));
            } catch (Exception unused) {
                msVar.ms("crash_version_code", mapMs.get("version_code"));
            }
        }
        if (mapMs.containsKey("update_version_code")) {
            try {
                msVar.ms("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapMs.get("update_version_code").toString())));
            } catch (Exception unused2) {
                msVar.ms("crash_update_version_code", mapMs.get("update_version_code"));
            }
        }
    }

    private void ka(com.bytedance.ms.xr.ah.ms msVar) {
        List<com.bytedance.ms.xr.ms> listMs = x.xr().ms(this.f573ms);
        if (listMs != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.bytedance.ms.xr.ms> it = listMs.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapMs = it.next().ms(this.f573ms);
                if (mapMs != null) {
                    try {
                        for (String str : mapMs.keySet()) {
                            jSONObject.put(str, mapMs.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            msVar.ms("custom", jSONObject);
        }
    }

    protected void d(com.bytedance.ms.xr.ah.ms msVar) {
        msVar.xr(com.bytedance.ms.xr.ka.d.ms(x.ka().ah(), x.ka().d()));
    }
}
