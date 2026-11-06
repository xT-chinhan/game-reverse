package com.taptap.sdk.update.network;

import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import com.taptap.sdk.update.extension.SystemExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/update/network/UpdateRepository;", "", "apiService", "Lcom/taptap/sdk/update/network/UpdateApiService;", "(Lcom/taptap/sdk/update/network/UpdateApiService;)V", "checkForceUpdate", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "(Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preprocessResult", "result", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateRepository {
    private final UpdateApiService apiService;

    /* JADX INFO: renamed from: com.taptap.sdk.update.network.UpdateRepository$checkForceUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.network.UpdateRepository", f = "UpdateRepository.kt", i = {0}, l = {18}, m = "checkForceUpdate", n = {"callback"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateRepository.this.checkForceUpdate(null, this);
        }
    }

    public UpdateRepository(UpdateApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0091  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object checkForceUpdate(TapTapCallback<ForceUpdateResult> tapTapCallback, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        TapTapCallback<ForceUpdateResult> tapTapCallback2;
        String message;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String packageName = TapTapKit.INSTANCE.getContext().getPackageName();
                int version = DeviceUtils.getPackageVersionCode(TapTapKit.INSTANCE.getContext());
                try {
                    RetryUtils retryUtils = RetryUtils.INSTANCE;
                    RetryStrategy.Fixed fixed = new RetryStrategy.Fixed(0, 0L, 3, null);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(packageName, version, tapTapCallback, null);
                    anonymousClass1.L$0 = tapTapCallback;
                    anonymousClass1.label = 1;
                    if (retryUtils.retry(fixed, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    e = th;
                    tapTapCallback2 = tapTapCallback;
                    message = e.getMessage();
                    if (message == null) {
                        message = "获取强更配置失败";
                    }
                    tapTapCallback2.onFail(new TapTapException(message));
                }
                break;
            case 1:
                tapTapCallback2 = (TapTapCallback) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (Throwable th2) {
                    e = th2;
                    message = e.getMessage();
                    if (message == null) {
                        message = "获取强更配置失败";
                    }
                    tapTapCallback2.onFail(new TapTapException(message));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.network.UpdateRepository$checkForceUpdate$2, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.network.UpdateRepository$checkForceUpdate$2", f = "UpdateRepository.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<ForceUpdateResult> $callback;
        final /* synthetic */ String $packageName;
        final /* synthetic */ int $version;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, TapTapCallback<ForceUpdateResult> tapTapCallback, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$packageName = str;
            this.$version = i;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return UpdateRepository.this.new AnonymousClass2(this.$packageName, this.$version, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass2 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass2 = this;
                    UpdateApiService updateApiService = UpdateRepository.this.apiService;
                    String packageName = anonymousClass2.$packageName;
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    anonymousClass2.label = 1;
                    Object objCheckForceUpdate = updateApiService.checkForceUpdate(packageName, anonymousClass2.$version, anonymousClass2);
                    if (objCheckForceUpdate == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objCheckForceUpdate;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    anonymousClass2 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ForceUpdateResult result = (ForceUpdateResult) $result;
            UpdateRepository.this.preprocessResult(result);
            anonymousClass2.$callback.onSuccess(result);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preprocessResult(ForceUpdateResult result) {
        result.setUpdateUri(SystemExtKt.appendSessionPlaceholder(result.getUpdateUri(), "sess_id"));
        result.setUpdateUrl(SystemExtKt.appendSessionPlaceholder(result.getUpdateUrl(), "utm_sid"));
        result.getDownload().setUrl(SystemExtKt.appendSessionPlaceholder(result.getDownload().getUrl(), "sid"));
        result.updateSessionId();
    }
}
