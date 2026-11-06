package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ah;
import com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationFullScreenManagerDefault extends ah {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ah
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public List<Object> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public List<ms> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public ms getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public List<ms> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public ms getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }
}
