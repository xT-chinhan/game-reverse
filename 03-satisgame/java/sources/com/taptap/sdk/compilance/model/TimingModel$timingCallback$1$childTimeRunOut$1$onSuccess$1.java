package com.taptap.sdk.compilance.model;

import com.taptap.sdk.compilance.bean.CheckPlayResult;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
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
@DebugMetadata(c = "com.taptap.sdk.compilance.model.TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1", f = "TimingModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckPlayResult $finalResult;
    final /* synthetic */ CheckPlayResult $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1(CheckPlayResult checkPlayResult, CheckPlayResult checkPlayResult2, Continuation<? super TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1> continuation) {
        super(1, continuation);
        this.$result = checkPlayResult;
        this.$finalResult = checkPlayResult2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1(this.$result, this.$finalResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TapComplianceInternal tapComplianceInternal = TapComplianceInternal.INSTANCE;
        TapComplianceSettings tapComplianceSettings = TapComplianceSettings.INSTANCE;
        CheckPlayResult checkPlayResult = this.$result;
        int remainTime = checkPlayResult != null ? checkPlayResult.getRemainTime() : 0;
        CheckPlayResult checkPlayResult2 = this.$finalResult;
        String title = checkPlayResult2 != null ? checkPlayResult2.getTitle() : null;
        CheckPlayResult checkPlayResult3 = this.$finalResult;
        tapComplianceInternal.notifyMessageInternal(1030, tapComplianceSettings.generateAlertMessage(remainTime, title, checkPlayResult3 != null ? checkPlayResult3.getDescription() : null));
        return Unit.INSTANCE;
    }
}
