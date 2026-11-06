package com.anythink.network.toutiao;

import com.anythink.core.api.ATAdAppInfo;
import com.bytedance.sdk.openadsdk.ComplianceInfo;

/* JADX INFO: loaded from: classes.dex */
public class TTATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPermissionLink;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String functionLink;
    public String publisher;

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getDownloadCount() {
        return "";
    }

    public TTATDownloadAppInfo(ComplianceInfo complianceInfo, long j) {
        this.appPrivacyLink = complianceInfo.getPrivacyUrl();
        this.appPermissionLink = complianceInfo.getPermissionUrl();
        this.appName = complianceInfo.getAppName();
        this.publisher = complianceInfo.getDeveloperName();
        this.appVersion = complianceInfo.getAppVersion();
        this.functionLink = complianceInfo.getFunctionDescUrl();
        this.appSize = j;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getPublisher() {
        return this.publisher;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return this.appPermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getFunctionUrl() {
        return this.functionLink;
    }
}
