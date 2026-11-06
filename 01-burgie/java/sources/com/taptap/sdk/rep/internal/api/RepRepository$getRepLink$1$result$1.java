package com.taptap.sdk.rep.internal.api;

import com.taptap.sdk.rep.internal.model.RepResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RepRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/taptap/sdk/rep/internal/model/RepResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.rep.internal.api.RepRepository$getRepLink$1$result$1", f = "RepRepository.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class RepRepository$getRepLink$1$result$1 extends SuspendLambda implements Function1<Continuation<? super RepResponse>, Object> {
    final /* synthetic */ Map<String, String> $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepRepository$getRepLink$1$result$1(Map<String, String> map, Continuation<? super RepRepository$getRepLink$1$result$1> continuation) {
        super(1, continuation);
        this.$params = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RepRepository$getRepLink$1$result$1(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super RepResponse> continuation) {
        return ((RepRepository$getRepLink$1$result$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object repLink = RepRepository.INSTANCE.getApiService().getRepLink(this.$params, this);
                return repLink == coroutine_suspended ? coroutine_suspended : repLink;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
