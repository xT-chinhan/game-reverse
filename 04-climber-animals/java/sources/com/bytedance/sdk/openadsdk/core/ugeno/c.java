package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.sdk.component.utils.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.adsdk.ugeno.ah.xr.d.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private b f3412ms;
    private com.bytedance.adsdk.ugeno.xr.ah xr;

    public c(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.f3412ms = new b(context, 1, com.bytedance.sdk.openadsdk.core.ch.ub().ka());
        this.xr = ahVar;
    }

    private int ah() {
        JSONObject jSONObjectCh;
        com.bytedance.adsdk.ugeno.xr.ah ahVar = this.xr;
        if (ahVar == null || (jSONObjectCh = ahVar.ch()) == null) {
            return 0;
        }
        return jSONObjectCh.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.xr.d.ms
    public void ms() {
        b bVar = this.f3412ms;
        if (bVar != null) {
            bVar.ms(ah());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.xr.d.ms
    public void xr() {
        b bVar = this.f3412ms;
        if (bVar != null) {
            bVar.xr(ah());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.xr.d.ms
    public void ms(float f) {
        b bVar = this.f3412ms;
        if (bVar != null) {
            bVar.ms(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.xr.d.ms
    public void ms(final com.bytedance.adsdk.ugeno.ah.xr.d.xr xrVar) {
        b bVar = this.f3412ms;
        if (bVar != null) {
            bVar.ms(new b.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.1
                @Override // com.bytedance.sdk.component.utils.b.ms
                public void ms(int i) {
                    com.bytedance.adsdk.ugeno.ah.xr.d.xr xrVar2 = xrVar;
                    if (xrVar2 != null) {
                        xrVar2.ms(i);
                    }
                }
            });
        }
    }
}
