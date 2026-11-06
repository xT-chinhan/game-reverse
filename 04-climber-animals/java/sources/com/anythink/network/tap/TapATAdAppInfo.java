package com.anythink.network.tap;

import com.anythink.core.api.ATAdAppInfo;
import com.tapsdk.tapad.ComplianceInfo;

/* JADX INFO: loaded from: classes.dex */
public class TapATAdAppInfo extends ATAdAppInfo {
    private final ComplianceInfo a;

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return 0L;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getDownloadCount() {
        return "";
    }

    public TapATAdAppInfo(ComplianceInfo complianceInfo) {
        this.a = complianceInfo;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getPublisher() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getDeveloperName() : "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppVersion() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getAppVersion() : "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPrivacyUrl() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getPrivacyUrl() : "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getPermissionUrl() : "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getFunctionUrl() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getFunctionDescUrl() : "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        ComplianceInfo complianceInfo = this.a;
        return complianceInfo != null ? complianceInfo.getAppName() : "";
    }
}
