package com.taptap.sdk.update.internal;

import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.update.TapUpdateApiCallback;
import com.taptap.sdk.update.bean.UpdateResult;
import com.taptap.sdk.update.extension.SystemExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TapUpdateApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/update/internal/TapUpdateApi;", "", "()V", "cachedUpdateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", "requestUpdateInfo", "Lkotlinx/coroutines/Job;", BillingClientConstants.PACKAGE_NAME, "", "versionCode", "", "callback", "Lcom/taptap/sdk/update/TapUpdateApiCallback;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateApi {
    public static final TapUpdateApi INSTANCE = new TapUpdateApi();
    private static UpdateResult cachedUpdateInfo;

    private TapUpdateApi() {
    }

    public static /* synthetic */ Job requestUpdateInfo$default(TapUpdateApi tapUpdateApi, String str, int i, TapUpdateApiCallback tapUpdateApiCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            tapUpdateApiCallback = null;
        }
        return tapUpdateApi.requestUpdateInfo(str, i, tapUpdateApiCallback);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapUpdateApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1", f = "TapUpdateApi.kt", i = {}, l = {42, 50, 58, 68}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapUpdateApiCallback $callback;
        final /* synthetic */ String $packageName;
        final /* synthetic */ int $versionCode;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapUpdateApiCallback tapUpdateApiCallback, String str, int i, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$callback = tapUpdateApiCallback;
            this.$packageName = str;
            this.$versionCode = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$packageName, this.$versionCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3, types: [com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r1v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM534constructorimpl;
            ?? r1;
            TapUpdateApiCallback tapUpdateApiCallback;
            TapUpdateApi$requestUpdateInfo$1$3$1 tapUpdateApi$requestUpdateInfo$1$3$1;
            ?? r2;
            TapUpdateApiCallback tapUpdateApiCallback2;
            Throwable thM537exceptionOrNullimpl;
            TapUpdateApi$requestUpdateInfo$1$4$1 tapUpdateApi$requestUpdateInfo$1$4$1;
            ?? r0;
            Object obj2;
            AnonymousClass1 anonymousClass1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            obj = this.label;
            try {
                switch (obj) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (TapUpdateApi.cachedUpdateInfo != null) {
                            this.label = 1;
                            return SystemExtKt.dispatchMain(new C02751(this.$callback, null), this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        TapUpdateApi tapUpdateApi = TapUpdateApi.INSTANCE;
                        String str = this.$packageName;
                        int i = this.$versionCode;
                        Result.Companion companion = Result.INSTANCE;
                        RetryUtils retryUtils = RetryUtils.INSTANCE;
                        RetryStrategy.Fixed fixed = new RetryStrategy.Fixed(2, 100L);
                        TapUpdateApi$requestUpdateInfo$1$2$1 tapUpdateApi$requestUpdateInfo$1$2$1 = new TapUpdateApi$requestUpdateInfo$1$2$1(str, i, null);
                        this.label = 2;
                        Object objRetry = retryUtils.retry(fixed, tapUpdateApi$requestUpdateInfo$1$2$1, this);
                        if (objRetry == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = objRetry;
                        anonymousClass1 = this;
                        try {
                            objM534constructorimpl = Result.m534constructorimpl((UpdateResult) obj2);
                            r1 = anonymousClass1;
                        } catch (Throwable th) {
                            AnonymousClass1 anonymousClass2 = anonymousClass1;
                            th = th;
                            obj = anonymousClass2;
                            Result.Companion companion2 = Result.INSTANCE;
                            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                            r1 = obj;
                        }
                        tapUpdateApiCallback = r1.$callback;
                        r2 = r1;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            tapUpdateApi$requestUpdateInfo$1$3$1 = new TapUpdateApi$requestUpdateInfo$1$3$1((UpdateResult) objM534constructorimpl, tapUpdateApiCallback, null);
                            r1.L$0 = objM534constructorimpl;
                            r1.label = 3;
                            if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$3$1, r1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = r1;
                        }
                        tapUpdateApiCallback2 = r2.$callback;
                        thM537exceptionOrNullimpl = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (thM537exceptionOrNullimpl != null) {
                            tapUpdateApi$requestUpdateInfo$1$4$1 = new TapUpdateApi$requestUpdateInfo$1$4$1(tapUpdateApiCallback2, thM537exceptionOrNullimpl, null);
                            r2.L$0 = objM534constructorimpl;
                            r2.label = 4;
                            if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$4$1, r2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r0 = r2;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        obj2 = obj;
                        objM534constructorimpl = Result.m534constructorimpl((UpdateResult) obj2);
                        r1 = anonymousClass1;
                        tapUpdateApiCallback = r1.$callback;
                        r2 = r1;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            tapUpdateApi$requestUpdateInfo$1$3$1 = new TapUpdateApi$requestUpdateInfo$1$3$1((UpdateResult) objM534constructorimpl, tapUpdateApiCallback, null);
                            r1.L$0 = objM534constructorimpl;
                            r1.label = 3;
                            if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$3$1, r1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = r1;
                        }
                        tapUpdateApiCallback2 = r2.$callback;
                        thM537exceptionOrNullimpl = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (thM537exceptionOrNullimpl != null) {
                            tapUpdateApi$requestUpdateInfo$1$4$1 = new TapUpdateApi$requestUpdateInfo$1$4$1(tapUpdateApiCallback2, thM537exceptionOrNullimpl, null);
                            r2.L$0 = objM534constructorimpl;
                            r2.label = 4;
                            if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$4$1, r2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r0 = r2;
                        }
                        return Unit.INSTANCE;
                    case 3:
                        AnonymousClass1 anonymousClass3 = this;
                        objM534constructorimpl = anonymousClass3.L$0;
                        ResultKt.throwOnFailure(obj);
                        r2 = anonymousClass3;
                        tapUpdateApiCallback2 = r2.$callback;
                        thM537exceptionOrNullimpl = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (thM537exceptionOrNullimpl != null) {
                            tapUpdateApi$requestUpdateInfo$1$4$1 = new TapUpdateApi$requestUpdateInfo$1$4$1(tapUpdateApiCallback2, thM537exceptionOrNullimpl, null);
                            r2.L$0 = objM534constructorimpl;
                            r2.label = 4;
                            if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$4$1, r2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r0 = r2;
                        }
                        return Unit.INSTANCE;
                    case 4:
                        r0 = this;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TapUpdateApi.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$1", f = "TapUpdateApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02751 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ TapUpdateApiCallback $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02751(TapUpdateApiCallback tapUpdateApiCallback, Continuation<? super C02751> continuation) {
                super(1, continuation);
                this.$callback = tapUpdateApiCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02751(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C02751) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        UpdateResult updateResult = TapUpdateApi.cachedUpdateInfo;
                        if (updateResult != null) {
                            updateResult.updateSessionId();
                        }
                        TapUpdateApiCallback tapUpdateApiCallback = this.$callback;
                        if (tapUpdateApiCallback != null) {
                            tapUpdateApiCallback.onSuccess(TapUpdateApi.cachedUpdateInfo);
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final Job requestUpdateInfo(String packageName, int versionCode, TapUpdateApiCallback callback) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return SystemExtKt.runAsync(new AnonymousClass1(callback, packageName, versionCode, null));
    }
}
