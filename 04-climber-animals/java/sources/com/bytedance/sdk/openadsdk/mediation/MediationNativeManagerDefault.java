package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.xr;
import com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d;
import com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeManagerDefault extends d {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public boolean isExpress() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public void setShakeViewListener(xr xrVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d
    public void setUseCustomVideo(boolean z) {
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
