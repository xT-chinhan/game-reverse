package com.taptap.sdk.update.internal;

import android.app.Activity;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TapUpdateInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateInternal$checkForceUpdate$1$1$onFail$1", f = "TapUpdateInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TapUpdateInternal$checkForceUpdate$1$1$onFail$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    TapUpdateInternal$checkForceUpdate$1$1$onFail$1(Continuation<? super TapUpdateInternal$checkForceUpdate$1$1$onFail$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TapUpdateInternal$checkForceUpdate$1$1$onFail$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TapUpdateInternal$checkForceUpdate$1$1$onFail$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Activity topActivity = TapActivityLifecycleTracker.getTopActivity();
                if (topActivity != null) {
                    TapForceUpdateErrorDialog dialog = new TapForceUpdateErrorDialog(topActivity, new Function0<Unit>() { // from class: com.taptap.sdk.update.internal.TapUpdateInternal$checkForceUpdate$1$1$onFail$1$1$dialog$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            TapUpdateInternal.INSTANCE.checkForceUpdate();
                        }
                    });
                    dialog.show();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
