package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class x implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_url")
    private String ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    private String c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_from_new_click_event")
    private boolean ch;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_app_market_convert")
    private boolean d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "dynamic_download_dialog_type")
    private int hi;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.nw.d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_landing_page")
    protected boolean f3187ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_show_download_dialog")
    private boolean ny = true;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_direct_download")
    private boolean sl;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms zb;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(this.xr, this.ah);
        ahVar.ah(this.sl);
        ahVar.ms(this.ny);
        ahVar.ms(this.hi);
        ahVar.xr(this.ch);
        ahVar.ms(this.zb);
        ahVar.ms(ms());
        if (!ahVar.d(false)) {
            msVar.xr(map2);
            return true;
        }
        ahVar.ms(this.ka, this.c, this.ab, this.x);
        msVar.ms(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.hi.ah.ah.ms ms() {
        if (this.d) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka();
        }
        if (this.f3187ms) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.d();
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.xr();
    }
}
