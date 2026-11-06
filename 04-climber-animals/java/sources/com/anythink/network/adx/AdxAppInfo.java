package com.anythink.network.adx;

import com.anythink.basead.f.a;
import com.anythink.core.api.ATAdAppInfo;

/* JADX INFO: loaded from: classes.dex */
public class AdxAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPrivacyLink;
    public String appVersion;
    public String apppermissionLink;
    public String functionLink;
    public String publisher;

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

    public AdxAppInfo(a aVar) {
        this.publisher = aVar.j();
        this.appVersion = aVar.m();
        this.appPrivacyLink = aVar.l();
        this.apppermissionLink = aVar.k();
        this.appName = aVar.i();
        this.functionLink = aVar.n();
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
    public String getFunctionUrl() {
        return this.functionLink;
    }
}
