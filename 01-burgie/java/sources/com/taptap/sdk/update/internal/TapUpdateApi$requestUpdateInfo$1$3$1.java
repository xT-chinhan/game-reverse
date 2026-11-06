package com.taptap.sdk.update.internal;

import com.taptap.sdk.update.TapUpdateApiCallback;
import com.taptap.sdk.update.bean.UpdateResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TapUpdateApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$3$1", f = "TapUpdateApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TapUpdateApi$requestUpdateInfo$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TapUpdateApiCallback $callback;
    final /* synthetic */ UpdateResult $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapUpdateApi$requestUpdateInfo$1$3$1(UpdateResult updateResult, TapUpdateApiCallback tapUpdateApiCallback, Continuation<? super TapUpdateApi$requestUpdateInfo$1$3$1> continuation) {
        super(1, continuation);
        this.$it = updateResult;
        this.$callback = tapUpdateApiCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TapUpdateApi$requestUpdateInfo$1$3$1(this.$it, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TapUpdateApi$requestUpdateInfo$1$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$it.isDataValid()) {
                    this.$it.updateSessionId();
                    TapUpdateApi tapUpdateApi = TapUpdateApi.INSTANCE;
                    TapUpdateApi.cachedUpdateInfo = this.$it;
                    TapUpdateApiCallback tapUpdateApiCallback = this.$callback;
                    if (tapUpdateApiCallback != null) {
                        tapUpdateApiCallback.onSuccess(this.$it);
                    }
                } else {
                    TapUpdateApiCallback tapUpdateApiCallback2 = this.$callback;
                    if (tapUpdateApiCallback2 != null) {
                        tapUpdateApiCallback2.onError(null);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
