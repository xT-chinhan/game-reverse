package com.taptap.sdk.compliance.api;

import com.taptap.sdk.compliance.bean.RealNameConfig;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConfigApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1$2$1", f = "ConfigApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConfigApi$fetchRealNameConfig$1$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ RealNameConfig $cachedConfig;
    final /* synthetic */ TapTapCallback<RealNameConfig> $callback;
    final /* synthetic */ Throwable $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigApi$fetchRealNameConfig$1$2$1(RealNameConfig realNameConfig, Throwable th, TapTapCallback<RealNameConfig> tapTapCallback, Continuation<? super ConfigApi$fetchRealNameConfig$1$2$1> continuation) {
        super(1, continuation);
        this.$cachedConfig = realNameConfig;
        this.$it = th;
        this.$callback = tapTapCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ConfigApi$fetchRealNameConfig$1$2$1(this.$cachedConfig, this.$it, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ConfigApi$fetchRealNameConfig$1$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$cachedConfig != null && (NetExtKt.isServerError(this.$it) || NetExtKt.isNoHostError(this.$it))) {
                    TapComplianceSettings.INSTANCE.setRealNameConfig(this.$cachedConfig);
                    this.$callback.onSuccess(this.$cachedConfig);
                } else {
                    this.$callback.onFail(new TapTapException(String.valueOf(this.$it.getMessage())));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
