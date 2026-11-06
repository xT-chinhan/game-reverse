package com.taptap.sdk.initializer.api.service;

import com.taptap.sdk.servicemanager.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: InitializerService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/initializer/api/service/InitializerService;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "checkInitialize", "", "showNotice", "checkLocalInitialize", "getAchievementUrl", "", "type", "getAppId", "", "()Ljava/lang/Integer;", "getLeaderboardUrl", "getRelationActivityLoopInterval", "", "getRelationAddFriendUrl", "getRelationNotificationUrl", "getRelationUrl", "getReviewUrl", "getShareUrl", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface InitializerService extends ServiceManager.Service {
    boolean checkInitialize(boolean showNotice);

    boolean checkLocalInitialize(boolean showNotice);

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
