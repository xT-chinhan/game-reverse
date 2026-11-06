package com.bytedance.sdk.openadsdk.mediation;

import com.byazt.cp.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 1408})
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private int n;
    private AdSlot qg;
    private List<String> s;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.n = i;
        this.qg = adSlot;
        this.s = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.qg;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.s;
    }
}
