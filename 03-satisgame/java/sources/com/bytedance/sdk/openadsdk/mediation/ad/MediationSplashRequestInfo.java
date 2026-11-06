package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.cp.n;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 763, 764})
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String n;
    private String q;
    private String qg;
    private String s;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnName() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnSlotId() {
        return this.qg;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppId() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppkey() {
        return this.q;
    }
}
