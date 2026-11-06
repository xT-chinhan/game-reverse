package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.sdk.openadsdk.core.nw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x implements ub {
    private com.bytedance.sdk.openadsdk.core.widget.ah.ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3572ms;
    private com.bytedance.adsdk.ugeno.xr.ah<View> xr;

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
    }

    public x(Context context) {
        this.f3572ms = context;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.widget.ah.ms msVar) {
        this.ah = msVar;
    }

    public void ms(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(jSONObject, jSONObject2, abVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.xr(jSONObject, jSONObject2, abVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        sl slVar = new sl(this.f3572ms);
        hi hiVar = new hi();
        hiVar.ms(this.f3572ms);
        slVar.ms("ugen_download_dialog", hiVar);
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(jSONObject);
        this.xr = ahVarMs;
        if (ahVarMs != null) {
            slVar.ms(this);
            slVar.xr(jSONObject2);
        }
        if (abVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.xr;
        if (ahVar == null) {
            abVar.ms(-1, "UGenWidget is null");
        } else {
            abVar.ms(ahVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        JSONObject jSONObjectAh;
        if (zbVar == null || this.ah == null) {
            return;
        }
        if (zbVar.xr() != 1 || (jSONObjectAh = zbVar.ah()) == null) {
        }
        String strOptString = jSONObjectAh.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.ah.xr(null);
                break;
            case "openAppFunctionDesc":
                this.ah.ka(null);
                break;
            case "closeDialog":
                this.ah.ah(null);
                break;
            case "downloadEvent":
                this.ah.ms(null);
                break;
            case "openAppPolicy":
                this.ah.d(null);
                break;
        }
    }
}
