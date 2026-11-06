package com.taptap.sdk.initializer.service;

import com.taptap.sdk.initializer.TapTapSdkInitializer;
import com.taptap.sdk.initializer.api.service.InitializerService;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitializerServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/initializer/service/InitializerServiceImpl;", "Lcom/taptap/sdk/initializer/api/service/InitializerService;", "()V", "checkInitialize", "", "showNotice", "getAchievementUrl", "", "type", "getAppId", "", "()Ljava/lang/Integer;", "getGatekeeper", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "getLeaderboardUrl", "getRelationActivityLoopInterval", "", "getRelationAddFriendUrl", "getRelationNotificationUrl", "getRelationUrl", "getReviewUrl", "getShareUrl", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InitializerServiceImpl implements InitializerService {
    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public Integer getAppId() {
        return getGatekeeper().getTaptapAppId();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getAchievementUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getAchievementUrl().getWebview();
        }
        return Intrinsics.areEqual(type, "uri") ? getGatekeeper().getUrls().getAchievementUrl().getUri() : getGatekeeper().getUrls().getAchievementUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getShareUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getShareUrl().getWebview();
        }
        return Intrinsics.areEqual(type, "uri") ? getGatekeeper().getUrls().getShareUrl().getUri() : getGatekeeper().getUrls().getShareUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getReviewUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getReviewUrl().getWebview();
        }
        return Intrinsics.areEqual(type, "uri") ? getGatekeeper().getUrls().getReviewUrl().getUri() : getGatekeeper().getUrls().getReviewUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getRelationUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getRelationUrl().getWebview();
        }
        return Intrinsics.areEqual(type, "uri") ? getGatekeeper().getUrls().getRelationUrl().getUri() : getGatekeeper().getUrls().getRelationUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getRelationAddFriendUrl() {
        return getGatekeeper().getUrls().getRelationAddFriendUrl().getUri();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getRelationNotificationUrl() {
        return getGatekeeper().getUrls().getRelationNotificationsUrl().getUri();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getLeaderboardUrl() {
        return getGatekeeper().getUrls().getLeaderboardUrl().getWebview();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public long getRelationActivityLoopInterval() {
        return ((long) getGatekeeper().getConfig().getRelation().getActiveStatusPollingInterval()) * 1000;
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public boolean checkInitialize(boolean showNotice) {
        if (!TapTapKit.INSTANCE.isInitialized()) {
            if (!showNotice) {
                return false;
            }
            SysExtKt.showToast("当前应用还未初始化");
            TapLogger.loge$default("TapInitializer", "当前应用还未初始化: 请在调用 SDK 业务接口前，先调用 [TapTapSDK.init()] 接口", null, 4, null);
            return false;
        }
        if (!TapTapSdkInitializer.INSTANCE.isAttached()) {
            return false;
        }
        if (!showNotice || TapTapSdkInitializer.INSTANCE.getInstance().isGatekeeperLoadedSuccessfully()) {
            return true;
        }
        TapTapSdkInitializer.INSTANCE.getInstance().showGatekeeperError();
        return false;
    }

    private final GateKeeper getGatekeeper() {
        return TapTapSdkInitializer.INSTANCE.getInstance().getCurrentGateKeeper();
    }
}
