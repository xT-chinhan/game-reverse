package com.taptap.sdk.update.internal;

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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/taptap/sdk/update/bean/UpdateResult;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$2$1", f = "TapUpdateApi.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class TapUpdateApi$requestUpdateInfo$1$2$1 extends SuspendLambda implements Function1<Continuation<? super UpdateResult>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $versionCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapUpdateApi$requestUpdateInfo$1$2$1(String str, int i, Continuation<? super TapUpdateApi$requestUpdateInfo$1$2$1> continuation) {
        super(1, continuation);
        this.$packageName = str;
        this.$versionCode = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TapUpdateApi$requestUpdateInfo$1$2$1(this.$packageName, this.$versionCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super UpdateResult> continuation) {
        return ((TapUpdateApi$requestUpdateInfo$1$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objRequestUpdateInfo = TapUpdateApiKt.getUpdateApi().requestUpdateInfo(this.$packageName, this.$versionCode, UpdateTracker.INSTANCE.getSessionId(), this);
                return objRequestUpdateInfo == coroutine_suspended ? coroutine_suspended : objRequestUpdateInfo;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
