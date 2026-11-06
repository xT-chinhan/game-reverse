package com.anythink.network.baidu;

import com.anythink.core.api.ATAdAppInfo;
import com.baidu.mobads.sdk.api.NativeResponse;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPackageName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String functionLink;
    public String publisher;

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getDownloadCount() {
        return "";
    }

    public BaiduATDownloadAppInfo(NativeResponse nativeResponse) {
        this.publisher = nativeResponse.getPublisher();
        this.appVersion = nativeResponse.getAppVersion();
        this.appPrivacyLink = nativeResponse.getAppPrivacyLink();
        this.apppermissionLink = nativeResponse.getAppPermissionLink();
        this.appSize = nativeResponse.getAppSize();
        this.appName = nativeResponse.getTitle();
        this.appPackageName = nativeResponse.getAppPackage();
        this.functionLink = nativeResponse.getAppFunctionLink();
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
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return this.appPackageName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getFunctionUrl() {
        return this.functionLink;
    }
}
