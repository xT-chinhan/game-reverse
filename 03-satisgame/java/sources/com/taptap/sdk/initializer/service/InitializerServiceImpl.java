package com.taptap.sdk.initializer.service;

import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.initializer.api.service.InitializerService;
import com.taptap.sdk.initializer.gate.TapGateKeeperUrl;
import com.taptap.sdk.initializer.gate.TapGatekeeperManager;
import com.taptap.sdk.initializer.gate.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitializerServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/initializer/service/InitializerServiceImpl;", "Lcom/taptap/sdk/initializer/api/service/InitializerService;", "()V", "getAchievementUrl", "", "type", "getAppId", "", "()Ljava/lang/Integer;", "getReviewUrl", "getShareUrl", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InitializerServiceImpl implements InitializerService {
    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public Integer getAppId() {
        return TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getAppId();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getAchievementUrl(String type) {
        Url achievementUrl;
        Url achievementUrl2;
        Url achievementUrl3;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            TapGateKeeperUrl urls = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls == null || (achievementUrl3 = urls.getAchievementUrl()) == null) {
                return null;
            }
            return achievementUrl3.getWebViewUrl();
        }
        if (Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI)) {
            TapGateKeeperUrl urls2 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls2 == null || (achievementUrl2 = urls2.getAchievementUrl()) == null) {
                return null;
            }
            return achievementUrl2.getTapUri();
        }
        TapGateKeeperUrl urls3 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
        if (urls3 == null || (achievementUrl = urls3.getAchievementUrl()) == null) {
            return null;
        }
        return achievementUrl.getBrowserUrl();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getShareUrl(String type) {
        Url shareUrl;
        Url shareUrl2;
        Url shareUrl3;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            TapGateKeeperUrl urls = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls == null || (shareUrl3 = urls.getShareUrl()) == null) {
                return null;
            }
            return shareUrl3.getWebViewUrl();
        }
        if (Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI)) {
            TapGateKeeperUrl urls2 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls2 == null || (shareUrl2 = urls2.getShareUrl()) == null) {
                return null;
            }
            return shareUrl2.getTapUri();
        }
        TapGateKeeperUrl urls3 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
        if (urls3 == null || (shareUrl = urls3.getShareUrl()) == null) {
            return null;
        }
        return shareUrl.getBrowserUrl();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getReviewUrl(String type) {
        Url reviewUrl;
        Url reviewUrl2;
        Url reviewUrl3;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            TapGateKeeperUrl urls = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls == null || (reviewUrl3 = urls.getReviewUrl()) == null) {
                return null;
            }
            return reviewUrl3.getWebViewUrl();
        }
        if (Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI)) {
            TapGateKeeperUrl urls2 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
            if (urls2 == null || (reviewUrl2 = urls2.getReviewUrl()) == null) {
                return null;
            }
            return reviewUrl2.getTapUri();
        }
        TapGateKeeperUrl urls3 = TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release().getUrls();
        if (urls3 == null || (reviewUrl = urls3.getReviewUrl()) == null) {
            return null;
        }
        return reviewUrl.getBrowserUrl();
    }
}
