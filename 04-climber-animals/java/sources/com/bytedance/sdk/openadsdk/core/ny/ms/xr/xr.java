package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class xr implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "deny_event")
    private String ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "ad_id")
    private String ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "confirm_event")
    private String c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "function_desc_popup_listener")
    private com.bytedance.sdk.openadsdk.core.jw.c.ms d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "app_manage_model")
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context f3188ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "cancel_event")
    private String x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.ah, ms());
        TTDelegateActivity.ah(this.f3188ms, this.ah, this.ka);
        msVar.ms(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.jw.c.ms ms() {
        return new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                if (xr.this.d == null) {
                    return;
                }
                xr.this.d.ms();
                xr xrVar = xr.this;
                xrVar.ms(xrVar.c);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (xr.this.d == null) {
                    return;
                }
                xr.this.d.xr();
                xr xrVar = xr.this;
                xrVar.ms(xrVar.ab);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (xr.this.d == null) {
                    return;
                }
                xr.this.d.ah();
                xr xrVar = xr.this;
                xrVar.ms(xrVar.x);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str) {
        HashMap map = new HashMap();
        map.put("material_meta", this.xr);
        map.put(g.X, this.f3188ms);
        new com.bytedance.sdk.component.hi.ms.xr.ms(str).ms(this.xr.rm()).ms(map).ms().ms();
    }
}
