package com.taptap.sdk.compliance.api;

import com.taptap.sdk.compliance.internal.TapComplianceInternal;
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
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: PaymentApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1$2$1", f = "PaymentApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PaymentApi$submitPayment$1$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TapTapCallback<JsonElement> $callback;
    final /* synthetic */ Throwable $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentApi$submitPayment$1$2$1(Throwable th, TapTapCallback<JsonElement> tapTapCallback, Continuation<? super PaymentApi$submitPayment$1$2$1> continuation) {
        super(1, continuation);
        this.$it = th;
        this.$callback = tapTapCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PaymentApi$submitPayment$1$2$1(this.$it, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((PaymentApi$submitPayment$1$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (NetExtKt.isTokenExpired(this.$it)) {
                    TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                } else {
                    this.$callback.onFail(new TapTapException("submitPayment failed, cause " + this.$it.getMessage()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
