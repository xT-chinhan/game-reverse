package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class qv implements com.bytedance.sdk.component.hi.ms.ms.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "reward_dialog_callback")
    private com.bytedance.sdk.openadsdk.core.component.reward.ah.ch f3183ms;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar = this.f3183ms;
        if (chVar == null) {
            msVar.xr(map2);
            return true;
        }
        chVar.xr();
        msVar.ms(map2);
        return true;
    }
}
