package com.taptap.sdk.compliance.extensions;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.taptap.sdk.compliance.internal.TapComplianceApiKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SystemExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0080@¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a+\u0010\u000b\u001a\u00020\f2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\f2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\r\u001a5\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0014H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0000¨\u0006\u0017"}, d2 = {"dispatchMain", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomString", "", "length", "", "runAsync", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "runOnMain", "runOnMainWithDelay", "delayMillis", "", "(JLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "fixHoloThemeIssue", "Landroid/app/Dialog;", "hideNavBar", "Landroid/view/Window;", "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SystemExtKt {

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.extensions.SystemExtKt$runAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.extensions.SystemExtKt$runAsync$1", f = "SystemExt.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final Job runAsync(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.launch$default(TapComplianceApiKt.getComplianceScope(), Dispatchers.getIO(), null, new AnonymousClass1(block, null), 2, null);
    }

    public static final Job runOnMain(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return runOnMainWithDelay(0L, block);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.extensions.SystemExtKt$runOnMainWithDelay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.extensions.SystemExtKt$runOnMainWithDelay$1", f = "SystemExt.kt", i = {}, l = {21, 22}, m = "invokeSuspend", n = {}, s = {})
    static final class C03081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ long $delayMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03081(long j, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C03081> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03081(this.$delayMillis, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0039 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x003a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03081 c03081;
            Function1<Continuation<? super Unit>, Object> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03081 = this;
                    c03081.label = 1;
                    if (DelayKt.delay(c03081.$delayMillis, c03081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = c03081.$block;
                    c03081.label = 2;
                    if (function1.invoke(c03081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03081 = this;
                    ResultKt.throwOnFailure($result);
                    function1 = c03081.$block;
                    c03081.label = 2;
                    if (function1.invoke(c03081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Job runOnMainWithDelay$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return runOnMainWithDelay(j, function1);
    }

    public static final Job runOnMainWithDelay(long delayMillis, Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.launch$default(TapComplianceApiKt.getComplianceScope(), Dispatchers.getMain(), null, new C03081(delayMillis, block, null), 2, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.extensions.SystemExtKt$dispatchMain$2, reason: invalid class name */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.extensions.SystemExtKt$dispatchMain$2", f = "SystemExt.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object dispatchMain(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(function1, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public static final void hideNavBar(final Window $this$hideNavBar) {
        Intrinsics.checkNotNullParameter($this$hideNavBar, "<this>");
        $this$hideNavBar.getDecorView().setSystemUiVisibility(2);
        $this$hideNavBar.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.taptap.sdk.compliance.extensions.SystemExtKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                SystemExtKt.hideNavBar$lambda$0($this$hideNavBar, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideNavBar$lambda$0(Window this_hideNavBar, int it) {
        Intrinsics.checkNotNullParameter(this_hideNavBar, "$this_hideNavBar");
        int uiOptions = 1798 | 4096;
        this_hideNavBar.getDecorView().setSystemUiVisibility(uiOptions);
    }

    public static final void fixHoloThemeIssue(Dialog $this$fixHoloThemeIssue) {
        Object objM534constructorimpl;
        Intrinsics.checkNotNullParameter($this$fixHoloThemeIssue, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            int dividerID = $this$fixHoloThemeIssue.getContext().getResources().getIdentifier("android:id/titleDivider", null, null);
            View divider = $this$fixHoloThemeIssue.findViewById(dividerID);
            Intrinsics.checkNotNullExpressionValue(divider, "findViewById(dividerID)");
            divider.setBackgroundColor(0);
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            it.printStackTrace();
        }
    }

    public static final String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = Random.INSTANCE.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length());
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(number));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
