package com.taptap.sdk.initializer.api.service;

import kotlin.Metadata;

/* JADX INFO: compiled from: InitializerService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/initializer/api/service/InitializerService;", "", "getAchievementUrl", "", "type", "getAppId", "", "()Ljava/lang/Integer;", "getReviewUrl", "getShareUrl", "tap-initializer-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface InitializerService {
    String getAchievementUrl(String type);

    Integer getAppId();

    String getReviewUrl(String type);

    String getShareUrl(String type);
}
