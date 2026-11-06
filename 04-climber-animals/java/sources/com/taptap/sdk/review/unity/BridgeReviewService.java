package com.taptap.sdk.review.unity;

import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeReviewService.kt */
/* JADX INFO: loaded from: classes3.dex */
@EngineBridgeService("BridgeReviewService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/taptap/sdk/review/unity/BridgeReviewService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "openReview", "", "tap-review-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BridgeReviewService extends IEngineBridgeService {
    @EngineBridgeMethod("openReview")
    void openReview();
}
