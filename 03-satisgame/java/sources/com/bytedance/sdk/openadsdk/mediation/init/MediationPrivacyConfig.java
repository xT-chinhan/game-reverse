package com.bytedance.sdk.openadsdk.mediation.init;

import com.byazt.cp.n;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 59, 1861})
public abstract class MediationPrivacyConfig implements IMediationPrivacyConfig {
    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isCanUseOaid() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isLimitPersonalAds() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isProgrammaticRecommend() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public List<String> getCustomAppList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public List<String> getCustomDevImeis() {
        return new LinkedList();
    }
}
