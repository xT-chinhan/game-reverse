package com.taptap.sdk.compliance.api;

import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.compliance.model.UserModel;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.api.ConfigApi$fetchUserAntiConfig$1$2$1", f = "ConfigApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConfigApi$fetchUserAntiConfig$1$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TapTapCallback<UserAntiConfig> $callback;
    final /* synthetic */ Throwable $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigApi$fetchUserAntiConfig$1$2$1(Throwable th, TapTapCallback<UserAntiConfig> tapTapCallback, Continuation<? super ConfigApi$fetchUserAntiConfig$1$2$1> continuation) {
        super(1, continuation);
        this.$it = th;
        this.$callback = tapTapCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ConfigApi$fetchUserAntiConfig$1$2$1(this.$it, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ConfigApi$fetchUserAntiConfig$1$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        UserAntiConfig cachedUserAntiConfig = TapComplianceSettings.INSTANCE.getCachedUserAntiConfig();
        if (NetExtKt.isTokenExpired(this.$it)) {
            TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
        } else if ((NetExtKt.isServerError(this.$it) || NetExtKt.isNoHostError(this.$it)) && cachedUserAntiConfig != null) {
            UserModel.INSTANCE.updateUserAntiConfig(cachedUserAntiConfig);
            this.$callback.onSuccess(cachedUserAntiConfig);
        } else {
            this.$callback.onFail(new TapTapException("fetch user anti config error, detail=" + this.$it));
        }
        return Unit.INSTANCE;
    }
}
