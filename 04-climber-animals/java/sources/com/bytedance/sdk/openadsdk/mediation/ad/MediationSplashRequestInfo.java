package com.bytedance.sdk.openadsdk.mediation.ad;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String ah;
    private String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3954ms;
    private String xr;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f3954ms = str;
        this.xr = str2;
        this.ah = str3;
        this.d = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnName() {
        return this.f3954ms;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnSlotId() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppId() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppkey() {
        return this.d;
    }
}
