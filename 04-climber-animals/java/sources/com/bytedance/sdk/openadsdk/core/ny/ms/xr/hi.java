package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class hi implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "handle_chain_data")
    private Map<String, Object> ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    private String ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "view")
    private View c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "dpa_tag")
    private String d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "live_saas_interaction_type")
    private int ka = -1;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm f3166ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (!ms()) {
            msVar.xr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.c cVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.c(this.f3166ms, this.xr, this.ah, this.d);
        int i = this.ka;
        if (i != -1) {
            cVar.ms(i);
        }
        cVar.ms(this.c);
        cVar.xr(this.ab);
        if (new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.xr(new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ka(cVar, this.f3166ms, msVar, map2, this.ah), this.xr, this.f3166ms, this.ah, map2, msVar).ms(new HashMap())) {
            msVar.ms(map2);
            return false;
        }
        msVar.xr(map2);
        return false;
    }

    private boolean ms() {
        return (this.f3166ms == null || this.xr == null) ? false : true;
    }
}
