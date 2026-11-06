package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private List<String> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3946ms;
    private AdSlot xr;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.f3946ms = i;
        this.xr = adSlot;
        this.ah = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f3946ms;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.ah;
    }
}
