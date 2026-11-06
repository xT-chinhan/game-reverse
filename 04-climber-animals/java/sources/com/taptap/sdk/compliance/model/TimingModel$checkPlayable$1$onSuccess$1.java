package com.taptap.sdk.compliance.model;

import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.model.TimingModel$checkPlayable$1$onSuccess$1", f = "TimingModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TimingModel$checkPlayable$1$onSuccess$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TapTapCallback<Boolean> $callback;
    final /* synthetic */ CheckPlayResult $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimingModel$checkPlayable$1$onSuccess$1(TapTapCallback<Boolean> tapTapCallback, CheckPlayResult checkPlayResult, Continuation<? super TimingModel$checkPlayable$1$onSuccess$1> continuation) {
        super(1, continuation);
        this.$callback = tapTapCallback;
        this.$result = checkPlayResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimingModel$checkPlayable$1$onSuccess$1(this.$callback, this.$result, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimingModel$checkPlayable$1$onSuccess$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$callback.onSuccess(Boxing.boxBoolean(false));
        TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
        TapComplianceSettings tapComplianceSettings = TapComplianceSettings.INSTANCE;
        CheckPlayResult checkPlayResult = this.$result;
        String title = checkPlayResult != null ? checkPlayResult.getTitle() : null;
        CheckPlayResult checkPlayResult2 = this.$result;
        tapComplianceInternal.notifyMessageInternal(1030, tapComplianceSettings.generateAlertMessage(0, title, checkPlayResult2 != null ? checkPlayResult2.getDescription() : null));
        return Unit.INSTANCE;
    }
}
