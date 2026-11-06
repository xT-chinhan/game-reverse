package com.taptap.sdk.initializer.service;

import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.initializer.TapTapSdkInitializer;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.api.service.InitializerService;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitializerServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\u001a"}, d2 = {"Lcom/taptap/sdk/initializer/service/InitializerServiceImpl;", "Lcom/taptap/sdk/initializer/api/service/InitializerService;", "()V", "checkInitialize", "", "showNotice", "checkInitializeNoticeFor", "", "state", "Lcom/taptap/sdk/initializer/api/TapInitState;", "checkLocalInitialize", "getAchievementUrl", "type", "getAppId", "", "()Ljava/lang/Integer;", "getGatekeeper", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "getLeaderboardUrl", "getRelationActivityLoopInterval", "", "getRelationAddFriendUrl", "getRelationNotificationUrl", "getRelationUrl", "getReviewUrl", "getShareUrl", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        return Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI) ? getGatekeeper().getUrls().getAchievementUrl().getUri() : getGatekeeper().getUrls().getAchievementUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getShareUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getShareUrl().getWebview();
        }
        return Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI) ? getGatekeeper().getUrls().getShareUrl().getUri() : getGatekeeper().getUrls().getShareUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getReviewUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getReviewUrl().getWebview();
        }
        return Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI) ? getGatekeeper().getUrls().getReviewUrl().getUri() : getGatekeeper().getUrls().getReviewUrl().getBrowser();
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public String getRelationUrl(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "webview")) {
            return getGatekeeper().getUrls().getRelationUrl().getWebview();
        }
        return Intrinsics.areEqual(type, ContentProviderManager.PROVIDER_URI) ? getGatekeeper().getUrls().getRelationUrl().getUri() : getGatekeeper().getUrls().getRelationUrl().getBrowser();
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
        TapInitState state = TapTapSdkInitializer.INSTANCE.getInitState();
        if (state instanceof TapInitState.Success) {
            return true;
        }
        if (showNotice) {
            String message = checkInitializeNoticeFor(state);
            SysExtKt.showToast(message);
            TapLogger.loge$default("TapInitializer", message, null, 4, null);
            return false;
        }
        return false;
    }

    @Override // com.taptap.sdk.initializer.api.service.InitializerService
    public boolean checkLocalInitialize(boolean showNotice) {
        TapInitState state = TapTapSdkInitializer.INSTANCE.getInitState();
        if ((state instanceof TapInitState.Success) || (state instanceof TapInitState.InProgress)) {
            return true;
        }
        if (showNotice) {
            String message = checkInitializeNoticeFor(state);
            SysExtKt.showToast(message);
            TapLogger.loge$default("TapInitializer", message, null, 4, null);
            return false;
        }
        return false;
    }

    private final String checkInitializeNoticeFor(TapInitState state) {
        if (state instanceof TapInitState.Failed) {
            return ((TapInitState.Failed) state).getErrorMsg();
        }
        if (state instanceof TapInitState.InProgress) {
            return "SDK 正在初始化中，请稍后再试";
        }
        return "当前应用还未初始化: 请在调用 SDK 业务接口前，先调用 [TapTapSdk.init()] 接口";
    }

    private final GateKeeper getGatekeeper() {
        return TapTapSdkInitializer.INSTANCE.getInstance().getCurrentGateKeeper();
    }
}
