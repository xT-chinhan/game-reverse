package com.anythink.network.adx;

import com.anythink.core.api.ATAdAppInfo;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;

/* JADX INFO: loaded from: classes.dex */
public class AdxAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPrivacyLink;
    public String appVersion;
    public String apppermissionLink;
    public String functionLink;
    public String publisher;

    public AdxAppInfo(SDMNativeAd sDMNativeAd) {
        this.publisher = sDMNativeAd.getPublisher();
        this.appVersion = sDMNativeAd.getAppVersion();
        this.appPrivacyLink = sDMNativeAd.getPrivacyUrl();
        this.apppermissionLink = sDMNativeAd.getPermissionUrl();
        this.appName = sDMNativeAd.getAppName();
        this.functionLink = sDMNativeAd.getFunctionUrl();
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return 0L;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getDownloadCount() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getFunctionUrl() {
        return this.functionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getPublisher() {
        return this.publisher;
    }
}
