package com.taptap.sdk.rep.internal.extensions;

import android.net.Uri;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
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

/* JADX INFO: compiled from: SysExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a,\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0080@¢\u0006\u0002\u0010\f\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a+\u0010\u0011\u001a\u00020\u00122\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0000¢\u0006\u0002\u0010\u0013\u001a+\u0010\u0014\u001a\u00020\u00122\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0000¢\u0006\u0002\u0010\u0013\u001a5\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0000¢\u0006\u0002\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u000e*\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000eH\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"RelationApiScope", "Lkotlinx/coroutines/CoroutineScope;", "getRelationApiScope", "()Lkotlinx/coroutines/CoroutineScope;", "RelationApiScope$delegate", "Lkotlin/Lazy;", "dispatchMain", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFormatValue", "", Constants.VALUE_FIELD, "", "runAsync", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "runOnMain", "runOnMainWithDelay", "delayMillis", "", "(JLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "appendSessionPlaceholder", "isWebUrl", "", "getErrorMessage", "", "backupErrorMessage", "tap-rep_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SysExtKt {
    private static final Lazy RelationApiScope$delegate = LazyKt.lazy(SysExtKt$RelationApiScope$2.INSTANCE);

    public static final CoroutineScope getRelationApiScope() {
        return (CoroutineScope) RelationApiScope$delegate.getValue();
    }

    /* JADX INFO: renamed from: com.taptap.sdk.rep.internal.extensions.SysExtKt$runAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: SysExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.rep.internal.extensions.SysExtKt$runAsync$1", f = "SysExt.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
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
        return BuildersKt__Builders_commonKt.launch$default(getRelationApiScope(), Dispatchers.getIO(), null, new AnonymousClass1(block, null), 2, null);
    }

    public static final Job runOnMain(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return runOnMainWithDelay(0L, block);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.rep.internal.extensions.SysExtKt$runOnMainWithDelay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SysExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.rep.internal.extensions.SysExtKt$runOnMainWithDelay$1", f = "SysExt.kt", i = {}, l = {31, 32}, m = "invokeSuspend", n = {}, s = {})
    static final class C03511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ long $delayMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03511(long j, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C03511> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03511(this.$delayMillis, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0039 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x003a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03511 c03511;
            Function1<Continuation<? super Unit>, Object> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03511 = this;
                    c03511.label = 1;
                    if (DelayKt.delay(c03511.$delayMillis, c03511) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = c03511.$block;
                    c03511.label = 2;
                    if (function1.invoke(c03511) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03511 = this;
                    ResultKt.throwOnFailure($result);
                    function1 = c03511.$block;
                    c03511.label = 2;
                    if (function1.invoke(c03511) == coroutine_suspended) {
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
        return BuildersKt__Builders_commonKt.launch$default(getRelationApiScope(), Dispatchers.getMain(), null, new C03511(delayMillis, block, null), 2, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.rep.internal.extensions.SysExtKt$dispatchMain$2, reason: invalid class name */
    /* JADX INFO: compiled from: SysExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.rep.internal.extensions.SysExtKt$dispatchMain$2", f = "SysExt.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
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

    private static final String getFormatValue(double value) {
        DecimalFormat format = new DecimalFormat(value > 10.0d ? "#" : "#.#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        String str = format.format(value);
        Intrinsics.checkNotNullExpressionValue(str, "format.format(value)");
        return str;
    }

    public static final String getErrorMessage(Throwable $this$getErrorMessage, String backupErrorMessage) {
        Intrinsics.checkNotNullParameter($this$getErrorMessage, "<this>");
        Intrinsics.checkNotNullParameter(backupErrorMessage, "backupErrorMessage");
        if (!NetworkUtil.isNetworkAvailable(TapTapKit.INSTANCE.getContext())) {
            return "当前无网络连接";
        }
        if (!($this$getErrorMessage instanceof TapNetworkException)) {
            String message = $this$getErrorMessage.getMessage();
            return message == null ? backupErrorMessage : message;
        }
        String msg = ((TapNetworkException) $this$getErrorMessage).getErr().getMsg();
        if (msg.length() == 0) {
            msg = backupErrorMessage;
        }
        return msg;
    }

    public static /* synthetic */ String getErrorMessage$default(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return getErrorMessage(th, str);
    }

    public static /* synthetic */ String appendSessionPlaceholder$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return appendSessionPlaceholder(str, z);
    }

    public static final String appendSessionPlaceholder(String $this$appendSessionPlaceholder, boolean isWebUrl) {
        Intrinsics.checkNotNullParameter($this$appendSessionPlaceholder, "<this>");
        Uri uri = Uri.parse($this$appendSessionPlaceholder);
        String key = isWebUrl ? "utm_sid" : "sess_id";
        Uri.Builder $this$appendSessionPlaceholder_u24lambda_u241 = uri.buildUpon();
        String encodedQuery = uri.getEncodedQuery();
        if (!(encodedQuery == null || encodedQuery.length() == 0)) {
            $this$appendSessionPlaceholder_u24lambda_u241.encodedQuery(uri.getEncodedQuery() + Typography.amp + key + "={SID}");
        } else {
            $this$appendSessionPlaceholder_u24lambda_u241.encodedQuery(key + "={SID}");
        }
        String string = $this$appendSessionPlaceholder_u24lambda_u241.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.buildUpon().apply {\n…\n    }.build().toString()");
        return string;
    }
}
