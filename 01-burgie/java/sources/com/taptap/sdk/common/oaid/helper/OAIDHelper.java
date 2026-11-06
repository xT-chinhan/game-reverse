package com.taptap.sdk.common.oaid.helper;

import android.content.Context;
import android.util.Log;
import com.taptap.sdk.common.oaid.ErrorCode;
import com.taptap.sdk.common.oaid.cert.OAIDCertProvider;
import com.taptap.sdk.common.oaid.exception.OAIDException;
import com.taptap.sdk.common.oaid.strategy.OAIDStrategy;
import com.taptap.sdk.common.oaid.strategy.OAIDStrategy1;
import com.taptap.sdk.common.oaid.strategy.OAIDStrategy2;
import com.taptap.sdk.common.oaid.strategy.OaidStrategy3;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OAIDHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J:\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0082@¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/taptap/sdk/common/oaid/helper/OAIDHelper;", "", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "strategies", "", "Lcom/taptap/sdk/common/oaid/strategy/OAIDStrategy;", "strategy", "initialize", "", "loadNativeSdk", "retry", "T", "maxRetryCount", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectStrategy", "shouldRetry", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tryGetOaidByReflect", "", "certProvider", "Lcom/taptap/sdk/common/oaid/cert/OAIDCertProvider;", "(Lcom/taptap/sdk/common/oaid/cert/OAIDCertProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OAIDHelper {
    private static final String TAG = OAIDHelper.class.getSimpleName();
    public static final long TIMEOUT = 5000;
    private final Context context;
    private final List<OAIDStrategy> strategies;
    private OAIDStrategy strategy;

    /* JADX INFO: compiled from: OAIDHelper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorCode.values().length];
            try {
                iArr[ErrorCode.INIT_INFO_RESULT_OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ErrorCode.INIT_INFO_RESULT_DELAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.common.oaid.helper.OAIDHelper$retry$1, reason: invalid class name */
    /* JADX INFO: compiled from: OAIDHelper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.oaid.helper.OAIDHelper", f = "OAIDHelper.kt", i = {0, 0, 0, 0}, l = {106}, m = "retry", n = {"this", "block", "maxRetryCount", "retryCount"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OAIDHelper.this.retry(0, null, this);
        }
    }

    public OAIDHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.strategies = CollectionsKt.listOf((Object[]) new OAIDStrategy[]{new OAIDStrategy1("com.bun.miitmdid.core.MdidSdkHelper", "com.bun.miitmdid.interfaces.IIdentifierListener", "com.bun.miitmdid.interfaces.IdSupplier"), new OAIDStrategy2("com.bun.miitmdid.core.MdidSdkHelper", "com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier", "com.bun.miitmdid.core.JLibrary"), new OaidStrategy3("com.bun.miitmdid.core.MdidSdkHelper", "com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.core.JLibrary")});
    }

    public final void initialize() {
        loadNativeSdk();
        selectStrategy();
    }

    private final void loadNativeSdk() {
        try {
            System.loadLibrary("msaoaidsec");
        } catch (Throwable th) {
        }
    }

    private final void selectStrategy() {
        Iterable $this$firstOrNull$iv = this.strategies;
        for (Object element$iv : $this$firstOrNull$iv) {
            OAIDStrategy strategy = (OAIDStrategy) element$iv;
            if (strategy.loadClassesByReflect()) {
                this.strategy = (OAIDStrategy) element$iv;
            }
        }
        element$iv = null;
        this.strategy = (OAIDStrategy) element$iv;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.common.oaid.helper.OAIDHelper$tryGetOaidByReflect$2, reason: invalid class name */
    /* JADX INFO: compiled from: OAIDHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.oaid.helper.OAIDHelper$tryGetOaidByReflect$2", f = "OAIDHelper.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ OAIDCertProvider $certProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(OAIDCertProvider oAIDCertProvider, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$certProvider = oAIDCertProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OAIDHelper.this.new AnonymousClass2(this.$certProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass2 anonymousClass2;
            Exception error;
            AnonymousClass2 anonymousClass3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass2 = this;
                    try {
                        OAIDStrategy value = OAIDHelper.this.strategy;
                        if (value == null) {
                            return null;
                        }
                        OAIDHelper oAIDHelper = OAIDHelper.this;
                        OAIDHelper$tryGetOaidByReflect$2$1$1 oAIDHelper$tryGetOaidByReflect$2$1$1 = new OAIDHelper$tryGetOaidByReflect$2$1$1(value, oAIDHelper, anonymousClass2.$certProvider, null);
                        anonymousClass2.label = 1;
                        Object objRetry = oAIDHelper.retry(3, oAIDHelper$tryGetOaidByReflect$2$1$1, anonymousClass2);
                        if (objRetry == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objRetry;
                        try {
                            return (String) $result;
                        } catch (Exception e) {
                            AnonymousClass2 anonymousClass4 = anonymousClass2;
                            error = e;
                            anonymousClass3 = anonymousClass4;
                        }
                    } catch (Exception e2) {
                        error = e2;
                        anonymousClass3 = anonymousClass2;
                    }
                    Log.d(OAIDHelper.TAG, "获取OAID失败: " + error.getMessage(), error);
                    return null;
                case 1:
                    anonymousClass3 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass2 = anonymousClass3;
                        return (String) $result;
                    } catch (Exception e3) {
                        error = e3;
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object tryGetOaidByReflect(OAIDCertProvider certProvider, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(certProvider, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005b -> B:30:0x005e). Please report as a decompilation issue!!! */
    public final <T> Object retry(int i, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        ?? r10;
        OAIDHelper oAIDHelper;
        ?? r2;
        Object objInvoke;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = anonymousClass2.label;
        try {
            switch (r3) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    r10 = i;
                    i = 0;
                    oAIDHelper = this;
                    r2 = function1;
                    anonymousClass2.L$0 = oAIDHelper;
                    anonymousClass2.L$1 = r2;
                    anonymousClass2.I$0 = r10;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.label = 1;
                    objInvoke = r2.invoke(anonymousClass2);
                    r3 = r2;
                    function1 = r10;
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objInvoke;
                case 1:
                    i = anonymousClass2.I$1;
                    boolean z = (Function1<? super Continuation<? super T>, ? extends Object>) anonymousClass2.I$0;
                    Function1 function2 = (Function1) anonymousClass2.L$1;
                    oAIDHelper = (OAIDHelper) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    objInvoke = obj;
                    r3 = function2;
                    function1 = z;
                    return objInvoke;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            if (!oAIDHelper.shouldRetry(e)) {
                throw e;
            }
            if (i >= function1) {
                throw new IllegalArgumentException("请求失败，已达到最大重试次数: " + (function1 == true ? 1 : 0));
            }
            i++;
            r2 = r3;
            r10 = function1;
        }
    }

    private final boolean shouldRetry(Exception error) {
        if (!(error instanceof OAIDException)) {
            return false;
        }
        ErrorCode errorCode = ((OAIDException) error).getErrorCode();
        switch (errorCode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()]) {
            case 1:
            case 2:
                return false;
            default:
                return true;
        }
    }
}
