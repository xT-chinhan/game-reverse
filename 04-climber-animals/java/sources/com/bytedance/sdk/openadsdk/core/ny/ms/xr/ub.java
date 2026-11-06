package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ub implements com.bytedance.sdk.component.hi.ms.ms.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm f3186ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        Context context;
        lm lmVar = this.f3186ms;
        if (lmVar == null || (context = this.xr) == null) {
            msVar.xr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(context, lmVar);
        msVar.ms(map2);
        return true;
    }
}
