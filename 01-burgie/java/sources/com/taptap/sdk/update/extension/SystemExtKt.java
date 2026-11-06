package com.taptap.sdk.update.extension;

import android.net.Uri;
import com.taptap.sdk.update.internal.TapUpdateApiKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SystemExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0080@¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\u00020\b2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\t\u001a+\u0010\n\u001a\u00020\b2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\t\u001a5\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000¢\u0006\u0002\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¨\u0006\u0012"}, d2 = {"dispatchMain", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAsync", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "runOnMain", "runOnMainWithDelay", "delayMillis", "", "(JLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "appendSessionPlaceholder", "", "sessionKey", "tap-update_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SystemExtKt {

    /* JADX INFO: renamed from: com.taptap.sdk.update.extension.SystemExtKt$runAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.extension.SystemExtKt$runAsync$1", f = "SystemExt.kt", i = {}, l = {11}, m = "invokeSuspend", n = {}, s = {})
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
        return BuildersKt__Builders_commonKt.launch$default(TapUpdateApiKt.getUpdateScope(), Dispatchers.getIO(), null, new AnonymousClass1(block, null), 2, null);
    }

    public static final Job runOnMain(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return runOnMainWithDelay(0L, block);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.extension.SystemExtKt$runOnMainWithDelay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.extension.SystemExtKt$runOnMainWithDelay$1", f = "SystemExt.kt", i = {}, l = {17, 18}, m = "invokeSuspend", n = {}, s = {})
    static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ long $delayMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03621(long j, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C03621> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03621(this.$delayMillis, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0039 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x003a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03621 c03621;
            Function1<Continuation<? super Unit>, Object> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03621 = this;
                    c03621.label = 1;
                    if (DelayKt.delay(c03621.$delayMillis, c03621) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = c03621.$block;
                    c03621.label = 2;
                    if (function1.invoke(c03621) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03621 = this;
                    ResultKt.throwOnFailure($result);
                    function1 = c03621.$block;
                    c03621.label = 2;
                    if (function1.invoke(c03621) == coroutine_suspended) {
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
        return BuildersKt__Builders_commonKt.launch$default(TapUpdateApiKt.getUpdateScope(), Dispatchers.getMain(), null, new C03621(delayMillis, block, null), 2, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.extension.SystemExtKt$dispatchMain$2, reason: invalid class name */
    /* JADX INFO: compiled from: SystemExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.extension.SystemExtKt$dispatchMain$2", f = "SystemExt.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
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

    public static final String appendSessionPlaceholder(String $this$appendSessionPlaceholder, String sessionKey) {
        Intrinsics.checkNotNullParameter($this$appendSessionPlaceholder, "<this>");
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        Uri uri = Uri.parse($this$appendSessionPlaceholder);
        Uri.Builder $this$appendSessionPlaceholder_u24lambda_u240 = uri.buildUpon();
        String encodedQuery = uri.getEncodedQuery();
        if (!(encodedQuery == null || encodedQuery.length() == 0)) {
            $this$appendSessionPlaceholder_u24lambda_u240.encodedQuery(uri.getEncodedQuery() + Typography.amp + sessionKey + "={SID}");
        } else {
            $this$appendSessionPlaceholder_u24lambda_u240.encodedQuery(sessionKey + "={SID}");
        }
        String string = $this$appendSessionPlaceholder_u24lambda_u240.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.buildUpon().apply {\n…\n    }.build().toString()");
        return string;
    }
}
