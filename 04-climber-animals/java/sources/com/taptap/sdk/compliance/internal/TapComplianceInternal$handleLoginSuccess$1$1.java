package com.taptap.sdk.compliance.internal;

import com.taptap.sdk.compliance.R;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.kit.internal.utils.TapToast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapComplianceInternal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.compliance.internal.TapComplianceInternal$handleLoginSuccess$1$1", f = "TapComplianceInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TapComplianceInternal$handleLoginSuccess$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    TapComplianceInternal$handleLoginSuccess$1$1(Continuation<? super TapComplianceInternal$handleLoginSuccess$1$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TapComplianceInternal$handleLoginSuccess$1$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TapComplianceInternal$handleLoginSuccess$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TapToast tapToast = TapToast.INSTANCE;
        String string = TapTapKit.INSTANCE.getContext().getString(R.string.compliance_realname_success);
        Intrinsics.checkNotNullExpressionValue(string, "TapTapKit.context.getStr…pliance_realname_success)");
        tapToast.showBottomToast(string, UIExtKt.toPx(20.0f));
        return Unit.INSTANCE;
    }
}
