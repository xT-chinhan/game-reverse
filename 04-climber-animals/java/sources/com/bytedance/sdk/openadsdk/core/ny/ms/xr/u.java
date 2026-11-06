package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class u implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_downloader")
    private boolean ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    private String ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_landing_page")
    private boolean c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_tag")
    private String ch;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "deep_link")
    private JSONObject d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xr.xr hi;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "app_info")
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm f3185ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_adapter")
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ny;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_market_covert")
    private boolean x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.x xVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.x(com.bytedance.sdk.openadsdk.core.ms.xr(this.ka), this.xr);
        xVar.ms(this.f3185ms);
        xVar.ms(this.ah);
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah ahVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah(xVar, this.f3185ms, this.ah, new com.bytedance.sdk.openadsdk.core.nw.h(this.d), this.xr);
        ahVar.xr(this.ab);
        ahVar.ms(this.c);
        ahVar.ah(this.x);
        ahVar.ms(this.ny);
        ahVar.ms(this.ch);
        ahVar.ms(this.hi);
        if (ahVar.ms(map2)) {
            msVar.ms(map2);
            return true;
        }
        msVar.xr(map2);
        return true;
    }
}
