package com.taptap.sdk.compliance.model;

import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.model.TimingModel$timingCallback$1$countTime$1$onSuccess$2", f = "TimingModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TimingModel$timingCallback$1$countTime$1$onSuccess$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckPlayResult $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimingModel$timingCallback$1$countTime$1$onSuccess$2(CheckPlayResult checkPlayResult, Continuation<? super TimingModel$timingCallback$1$countTime$1$onSuccess$2> continuation) {
        super(1, continuation);
        this.$result = checkPlayResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimingModel$timingCallback$1$countTime$1$onSuccess$2(this.$result, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimingModel$timingCallback$1$countTime$1$onSuccess$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                TapLoggerKt.logInfo("count down over, PERIOD_RESTRICT");
                TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
                TapComplianceSettings tapComplianceSettings = TapComplianceSettings.INSTANCE;
                CheckPlayResult checkPlayResult = this.$result;
                String title = checkPlayResult != null ? checkPlayResult.getTitle() : null;
                CheckPlayResult checkPlayResult2 = this.$result;
                tapComplianceInternal.notifyMessageInternal(1030, tapComplianceSettings.generateAlertMessage(0, title, checkPlayResult2 != null ? checkPlayResult2.getDescription() : null));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
