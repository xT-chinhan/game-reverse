package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class sl implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_landing_page")
    private boolean ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "source")
    private int c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    private String d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "wc_miniapp_info")
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm f3184ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (!ms()) {
            msVar.xr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ny nyVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ny(ce.ms(this.ka), this.xr, this.ah, this.d, map2, msVar, this.c);
        nyVar.ms(this.f3184ms);
        if (nyVar.ms(new HashMap())) {
            msVar.ms(map2);
        } else {
            msVar.xr(map2);
        }
        return true;
    }

    private boolean ms() {
        return (this.f3184ms == null || this.xr == null || this.ka == null) ? false : true;
    }
}
