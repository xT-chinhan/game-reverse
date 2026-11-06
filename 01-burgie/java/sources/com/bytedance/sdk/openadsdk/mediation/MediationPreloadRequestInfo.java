package com.bytedance.sdk.openadsdk.mediation;

import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 1274})
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private List<String> hn;
    private AdSlot hw;
    private int pr;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.pr = i;
        this.hw = adSlot;
        this.hn = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.pr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.hw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.hn;
    }
}
