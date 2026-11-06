package com.taptap.sdk.rep.internal.api;

import com.byazt.eyv.AdBaseConstants;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.rep.internal.model.RepResponse;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RepRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/rep/internal/api/RepRepository;", "", "()V", "apiService", "Lcom/taptap/sdk/rep/internal/api/RepApiService;", "getApiService", "()Lcom/taptap/sdk/rep/internal/api/RepApiService;", "apiService$delegate", "Lkotlin/Lazy;", "getRepLink", "Lkotlinx/coroutines/Job;", "openUrl", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/rep/internal/model/RepResponse;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RepRepository {
    public static final RepRepository INSTANCE = new RepRepository();

    /* JADX INFO: renamed from: apiService$delegate, reason: from kotlin metadata */
    private static final Lazy apiService = LazyKt.lazy(new Function0<RepApiService>() { // from class: com.taptap.sdk.rep.internal.api.RepRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RepApiService invoke() {
            return (RepApiService) NetworkClientKt.provideRetrofit$default(NetExtKt.getBaseUrl(), null, 2, null).create(RepApiService.class);
        }
    });

    private RepRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RepApiService getApiService() {
        Object value = apiService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-apiService>(...)");
        return (RepApiService) value;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.rep.internal.api.RepRepository$getRepLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.rep.internal.api.RepRepository$getRepLink$1", f = "RepRepository.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<RepResponse> $callback;
        final /* synthetic */ String $openUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, TapTapCallback<RepResponse> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$openUrl = str;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$openUrl, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Throwable e;
            AnonymousClass1 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    try {
                        Map params = MapsKt.mutableMapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, anonymousClass1.$openUrl));
                        Integer numBoxInt = Boxing.boxInt(SysExtKt.getTapVersionCode());
                        int it = numBoxInt.intValue();
                        if (!(it >= 0)) {
                            numBoxInt = null;
                        }
                        if (numBoxInt != null) {
                            int versionCode = numBoxInt.intValue();
                        }
                        anonymousClass1.label = 1;
                        Object objRetry = RetryUtils.INSTANCE.retry(new RetryStrategy.Fixed(0, 0L, 3, null), new RepRepository$getRepLink$1$result$1(params, null), anonymousClass1);
                        if (objRetry == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objRetry;
                        try {
                            RepResponse result = (RepResponse) $result;
                            anonymousClass1.$callback.onSuccess(result);
                            break;
                        } catch (Throwable th) {
                            AnonymousClass1 anonymousClass3 = anonymousClass1;
                            e = th;
                            $result = $result;
                            anonymousClass2 = anonymousClass3;
                            anonymousClass2.$callback.onFail(new TapTapException(com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(e, "获取Rep链接失败")));
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        e = th2;
                        anonymousClass2 = anonymousClass1;
                        anonymousClass2.$callback.onFail(new TapTapException(com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(e, "获取Rep链接失败")));
                        return Unit.INSTANCE;
                    }
                case 1:
                    anonymousClass2 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = anonymousClass2;
                        RepResponse result2 = (RepResponse) $result;
                        anonymousClass1.$callback.onSuccess(result2);
                        break;
                    } catch (Throwable th3) {
                        e = th3;
                        anonymousClass2.$callback.onFail(new TapTapException(com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(e, "获取Rep链接失败")));
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job getRepLink(String openUrl, TapTapCallback<RepResponse> callback) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return com.taptap.sdk.rep.internal.extensions.SysExtKt.runAsync(new AnonymousClass1(openUrl, callback, null));
    }
}
