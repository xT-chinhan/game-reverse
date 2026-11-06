package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ah implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "deny_event")
    private String ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "ad_id")
    private String ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "confirm_event")
    private String c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "permission_popup_listener")
    private com.bytedance.sdk.openadsdk.core.jw.c.ms d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "app_manage_model")
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context f3156ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "cancel_event")
    private String x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.ah, ms());
        TTDelegateActivity.ms(this.f3156ms, this.ah, this.ka);
        msVar.ms(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.jw.c.ms ms() {
        return new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                if (ah.this.d == null) {
                    return;
                }
                ah.this.d.ms();
                ah ahVar = ah.this;
                ahVar.ms(ahVar.c);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (ah.this.d == null) {
                    return;
                }
                ah.this.d.xr();
                ah ahVar = ah.this;
                ahVar.ms(ahVar.ab);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (ah.this.d == null) {
                    return;
                }
                ah.this.d.ah();
                ah ahVar = ah.this;
                ahVar.ms(ahVar.x);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str) {
        if (this.xr == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("material_meta", this.xr);
        map.put(g.X, this.f3156ms);
        new com.bytedance.sdk.component.hi.ms.xr.ms(str).ms(this.xr.rm()).ms(map).ms().ms();
    }
}
