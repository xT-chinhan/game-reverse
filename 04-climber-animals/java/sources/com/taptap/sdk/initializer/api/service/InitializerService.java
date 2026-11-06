package com.taptap.sdk.initializer.api.service;

import com.taptap.sdk.servicemanager.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: InitializerService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/initializer/api/service/InitializerService;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "checkInitialize", "", "showNotice", "getAchievementUrl", "", "type", "getAppId", "", "()Ljava/lang/Integer;", "getLeaderboardUrl", "getRelationActivityLoopInterval", "", "getRelationAddFriendUrl", "getRelationNotificationUrl", "getRelationUrl", "getReviewUrl", "getShareUrl", "tap-initializer-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface InitializerService extends ServiceManager.Service {
    boolean checkInitialize(boolean showNotice);

    String getAchievementUrl(String type);

    Integer getAppId();

    String getLeaderboardUrl();

    long getRelationActivityLoopInterval();

    String getRelationAddFriendUrl();

    String getRelationNotificationUrl();

    String getRelationUrl(String type);

    String getReviewUrl(String type);

    String getShareUrl(String type);
}
