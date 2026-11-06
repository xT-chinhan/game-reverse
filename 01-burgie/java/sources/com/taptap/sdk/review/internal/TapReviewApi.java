package com.taptap.sdk.review.internal;

import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.review.ReviewCrossAppCodeCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TapReviewApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/review/internal/TapReviewApi;", "", "()V", "fetchCrossAppCode", "Lkotlinx/coroutines/Job;", "callback", "Lcom/taptap/sdk/review/ReviewCrossAppCodeCallback;", "tap-review_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapReviewApi {
    public static final TapReviewApi INSTANCE = new TapReviewApi();

    private TapReviewApi() {
    }

    /* JADX INFO: renamed from: com.taptap.sdk.review.internal.TapReviewApi$fetchCrossAppCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapReviewApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.review.internal.TapReviewApi$fetchCrossAppCode$1", f = "TapReviewApi.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReviewCrossAppCodeCallback $callback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReviewCrossAppCodeCallback reviewCrossAppCodeCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = reviewCrossAppCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0061  */
        /* JADX WARN: Code duplicated, block: B:28:0x006f  */
        /* JADX WARN: Code duplicated, block: B:31:0x0075  */
        /* JADX WARN: Code duplicated, block: B:34:0x007e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Throwable th;
            AnonymousClass1 anonymousClass2;
            Object $result2;
            Throwable it;
            String code;
            ReviewCrossAppCodeCallback reviewCrossAppCodeCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        TapReviewApiService reviewApi = TapReviewApiKt.getReviewApi();
                        anonymousClass1.label = 1;
                        Object objFetchCrossAppCode = reviewApi.fetchCrossAppCode(anonymousClass1);
                        if (objFetchCrossAppCode == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objFetchCrossAppCode;
                        try {
                            $result2 = Result.m534constructorimpl(((TapCrossAppCode) $result).getCode());
                            break;
                        } catch (Throwable th2) {
                            AnonymousClass1 anonymousClass3 = anonymousClass1;
                            th = th2;
                            $result = $result;
                            anonymousClass2 = anonymousClass3;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result2 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            anonymousClass1 = anonymousClass2;
                        }
                        it = Result.m537exceptionOrNullimpl($result2);
                        if (it != null) {
                            TapLoggerKt.logError("fetchCrossAppCode fail", it);
                        }
                        if (Result.m540isFailureimpl($result2)) {
                            $result2 = null;
                        }
                        code = (String) $result2;
                        if (code != null) {
                            TapLoggerKt.logInfo("fetchCrossAppCode success");
                        }
                        reviewCrossAppCodeCallback = anonymousClass1.$callback;
                        if (reviewCrossAppCodeCallback != null) {
                            reviewCrossAppCodeCallback.onCodeResult(code);
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        anonymousClass2 = anonymousClass1;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result2 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        anonymousClass1 = anonymousClass2;
                        it = Result.m537exceptionOrNullimpl($result2);
                        if (it != null) {
                            TapLoggerKt.logError("fetchCrossAppCode fail", it);
                        }
                        if (Result.m540isFailureimpl($result2)) {
                            $result2 = null;
                        }
                        code = (String) $result2;
                        if (code != null) {
                            TapLoggerKt.logInfo("fetchCrossAppCode success");
                        }
                        reviewCrossAppCodeCallback = anonymousClass1.$callback;
                        if (reviewCrossAppCodeCallback != null) {
                            reviewCrossAppCodeCallback.onCodeResult(code);
                        }
                        return Unit.INSTANCE;
                    }
                case 1:
                    anonymousClass2 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = anonymousClass2;
                        $result2 = Result.m534constructorimpl(((TapCrossAppCode) $result).getCode());
                        break;
                    } catch (Throwable th4) {
                        th = th4;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result2 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        anonymousClass1 = anonymousClass2;
                        it = Result.m537exceptionOrNullimpl($result2);
                        if (it != null) {
                            TapLoggerKt.logError("fetchCrossAppCode fail", it);
                        }
                        if (Result.m540isFailureimpl($result2)) {
                            $result2 = null;
                        }
                        code = (String) $result2;
                        if (code != null) {
                            TapLoggerKt.logInfo("fetchCrossAppCode success");
                        }
                        reviewCrossAppCodeCallback = anonymousClass1.$callback;
                        if (reviewCrossAppCodeCallback != null) {
                            reviewCrossAppCodeCallback.onCodeResult(code);
                        }
                        return Unit.INSTANCE;
                    }
                    it = Result.m537exceptionOrNullimpl($result2);
                    if (it != null) {
                        TapLoggerKt.logError("fetchCrossAppCode fail", it);
                    }
                    if (Result.m540isFailureimpl($result2)) {
                        $result2 = null;
                    }
                    code = (String) $result2;
                    if (code != null) {
                        TapLoggerKt.logInfo("fetchCrossAppCode success");
                    }
                    reviewCrossAppCodeCallback = anonymousClass1.$callback;
                    if (reviewCrossAppCodeCallback != null) {
                        reviewCrossAppCodeCallback.onCodeResult(code);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Job fetchCrossAppCode$default(TapReviewApi tapReviewApi, ReviewCrossAppCodeCallback reviewCrossAppCodeCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            reviewCrossAppCodeCallback = null;
        }
        return tapReviewApi.fetchCrossAppCode(reviewCrossAppCodeCallback);
    }

    public final Job fetchCrossAppCode(ReviewCrossAppCodeCallback callback) {
        return BuildersKt__Builders_commonKt.launch$default(TapReviewApiKt.getReviewScope(), Dispatchers.getIO(), null, new AnonymousClass1(callback, null), 2, null);
    }
}
