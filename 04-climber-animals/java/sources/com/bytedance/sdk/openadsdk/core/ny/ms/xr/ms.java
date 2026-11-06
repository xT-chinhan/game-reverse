package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ms implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "url")
    private String f3169ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "title")
    private String xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        TTDelegateActivity.d(this.ah, this.f3169ms, this.xr);
        msVar.ms(map2);
        return true;
    }
}
