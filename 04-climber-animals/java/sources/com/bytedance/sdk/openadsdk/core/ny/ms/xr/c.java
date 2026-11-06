package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class c implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "outer_dislike")
    private Dialog f3159ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "ad_dislike")
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        Dialog dialog = this.f3159ms;
        if (dialog != null) {
            dialog.show();
            msVar.ms(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar2 = this.xr;
        if (msVar2 != null) {
            msVar2.ms();
            msVar.ms(map2);
            return true;
        }
        TTDelegateActivity.ms(this.ah, this.d);
        msVar.ms(map2);
        return true;
    }
}
