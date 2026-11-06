package com.taptap.sdk.review.internal;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.base.network.annotation.RequiresAuthorization;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.retrofit2.http.POST;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: TapReviewApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@RequiresAuthorization
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bc\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/review/internal/TapReviewApiService;", "", "fetchCrossAppCode", "Lcom/taptap/sdk/review/internal/TapCrossAppCode;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-review_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = SdkModules.CORE, version = "4.10.9")
interface TapReviewApiService {
    @POST("/sdk-core/v1/cross-app-code")
    Object fetchCrossAppCode(Continuation<? super TapCrossAppCode> continuation);
}
