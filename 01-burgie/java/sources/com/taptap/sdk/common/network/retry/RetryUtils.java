package com.taptap.sdk.common.network.retry;

import android.util.Log;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RetryUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002JH\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0013J<\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/common/network/retry/RetryUtils;", "", "()V", "TAG", "", "requestCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "calculateNextDelay", "", "strategy", "Lcom/taptap/sdk/common/network/retry/RetryStrategy;", "currentDelay", "requestId", "retry", "T", "requestLabel", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/taptap/sdk/common/network/retry/RetryStrategy;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/taptap/sdk/common/network/retry/RetryStrategy;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "error", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RetryUtils {
    private static final String TAG = "RetryUtils";
    public static final RetryUtils INSTANCE = new RetryUtils();
    private static final AtomicInteger requestCounter = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.taptap.sdk.common.network.retry.RetryUtils$retry$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryUtils.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.network.retry.RetryUtils", f = "RetryUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {46, 66}, m = "retry", n = {"this", "strategy", "block", "requestId", "retryCount", "nextDelayInMillis", "this", "strategy", "block", "requestId", "retryCount", "nextDelayInMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetryUtils.this.retry(null, null, null, this);
        }
    }

    private RetryUtils() {
    }

    public static /* synthetic */ Object retry$default(RetryUtils retryUtils, RetryStrategy retryStrategy, String str, Function1 function1, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            retryStrategy = RetryStrategy.NoRetry.INSTANCE;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return retryUtils.retry(retryStrategy, str, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.taptap.sdk.common.network.retry.RetryStrategy] */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [long] */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v11, types: [int] */
    /* JADX WARN: Type inference failed for: r14v12, types: [int] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.taptap.sdk.common.network.retry.RetryStrategy] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.taptap.sdk.common.network.retry.RetryUtils, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.taptap.sdk.common.network.retry.RetryUtils] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x013a -> B:56:0x013d). Please report as a decompilation issue!!! */
    public final <T> Object retry(RetryStrategy retryStrategy, String str, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objInvoke;
        ?? r5;
        ?? r4;
        ?? r3;
        int i;
        long j;
        ?? r6;
        ?? r7;
        ?? r8;
        ?? r2;
        int i2;
        ?? r12;
        ?? r9;
        ?? r10;
        ?? r11;
        ?? r13;
        long initialIntervalMillis;
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
        ?? r14 = anonymousClass2.label;
        try {
            switch (r14) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (str == null) {
                        str = "req_" + requestCounter.incrementAndGet();
                    }
                    if (retryStrategy instanceof RetryStrategy.NoRetry) {
                        initialIntervalMillis = 0;
                    } else if (retryStrategy instanceof RetryStrategy.Fixed) {
                        initialIntervalMillis = ((RetryStrategy.Fixed) retryStrategy).getIntervalMillis();
                    } else if (retryStrategy instanceof RetryStrategy.Exponential) {
                        initialIntervalMillis = ((RetryStrategy.Exponential) retryStrategy).getInitialIntervalMillis();
                    } else {
                        if (!(retryStrategy instanceof RetryStrategy.ExponentialLimited)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        initialIntervalMillis = ((RetryStrategy.ExponentialLimited) retryStrategy).getInitialIntervalMillis();
                    }
                    long j2 = initialIntervalMillis;
                    r7 = retryStrategy;
                    r6 = this;
                    r2 = str;
                    j = j2;
                    r8 = function1;
                    i = (Function1<? super Continuation<? super T>, ? extends Object>) null;
                    anonymousClass2.L$0 = r6;
                    anonymousClass2.L$1 = r7;
                    anonymousClass2.L$2 = r8;
                    anonymousClass2.L$3 = r2;
                    anonymousClass2.I$0 = i;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.label = 1;
                    objInvoke = r8.invoke(anonymousClass2);
                    r14 = r2;
                    r3 = r8;
                    r4 = r7;
                    r5 = r6;
                    retryStrategy = j;
                    function1 = i;
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objInvoke;
                case 1:
                    long j3 = anonymousClass2.J$0;
                    boolean z = (Function1<? super Continuation<? super T>, ? extends Object>) anonymousClass2.I$0;
                    String str2 = (String) anonymousClass2.L$3;
                    Function1 function2 = (Function1) anonymousClass2.L$2;
                    RetryStrategy retryStrategy2 = (RetryStrategy) anonymousClass2.L$1;
                    RetryUtils retryUtils = (RetryUtils) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    objInvoke = obj;
                    r14 = str2;
                    r3 = function2;
                    r4 = retryStrategy2;
                    r5 = retryUtils;
                    retryStrategy = j3;
                    function1 = z;
                    return objInvoke;
                case 2:
                    long j4 = anonymousClass2.J$0;
                    int i3 = (Function1<? super Continuation<? super T>, ? extends Object>) anonymousClass2.I$0;
                    String str3 = (String) anonymousClass2.L$3;
                    Function1 function3 = (Function1) anonymousClass2.L$2;
                    RetryStrategy retryStrategy3 = (RetryStrategy) anonymousClass2.L$1;
                    RetryUtils retryUtils2 = (RetryUtils) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    r13 = str3;
                    r11 = function3;
                    r10 = retryStrategy3;
                    r9 = retryUtils2;
                    r12 = j4;
                    i2 = i3;
                    long jCalculateNextDelay = r9.calculateNextDelay(r10, r12, r13);
                    r2 = r13;
                    r8 = r11;
                    r7 = r10;
                    r6 = r9;
                    j = jCalculateNextDelay;
                    i = i2;
                    anonymousClass2.L$0 = r6;
                    anonymousClass2.L$1 = r7;
                    anonymousClass2.L$2 = r8;
                    anonymousClass2.L$3 = r2;
                    anonymousClass2.I$0 = i;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.label = 1;
                    objInvoke = r8.invoke(anonymousClass2);
                    r14 = r2;
                    r3 = r8;
                    r4 = r7;
                    r5 = r6;
                    retryStrategy = j;
                    function1 = i;
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objInvoke;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            if (!r5.shouldRetry(th)) {
                throw th;
            }
            if ((r4 instanceof RetryStrategy.Fixed) && function1 >= ((RetryStrategy.Fixed) r4).getMaxCount()) {
                throw th;
            }
            if ((r4 instanceof RetryStrategy.ExponentialLimited) && function1 >= ((RetryStrategy.ExponentialLimited) r4).getMaxCount()) {
                throw th;
            }
            int i4 = function1 + 1;
            Log.w(TAG, AbstractJsonLexerKt.BEGIN_LIST + r14 + "] 网络请求失败，进行第 " + i4 + " 次重试，延迟: " + retryStrategy + "ms");
            anonymousClass2.L$0 = r5;
            anonymousClass2.L$1 = r4;
            anonymousClass2.L$2 = r3;
            anonymousClass2.L$3 = r14;
            anonymousClass2.I$0 = i4;
            anonymousClass2.J$0 = retryStrategy;
            anonymousClass2.label = 2;
            Object objDelay = DelayKt.delay(retryStrategy, anonymousClass2);
            r13 = r14;
            r11 = r3;
            r10 = r4;
            r9 = r5;
            r12 = retryStrategy;
            i2 = i4;
            if (objDelay == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
    }

    public static /* synthetic */ Object retry$default(RetryUtils retryUtils, RetryStrategy retryStrategy, Function1 function1, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            retryStrategy = new RetryStrategy.Exponential(0L, 0L, 3, null);
        }
        return retryUtils.retry(retryStrategy, function1, continuation);
    }

    public final <T> Object retry(RetryStrategy strategy, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        return retry(strategy, null, function1, continuation);
    }

    private final long calculateNextDelay(RetryStrategy strategy, long currentDelay, String requestId) {
        if (strategy instanceof RetryStrategy.NoRetry) {
            return 0L;
        }
        if (strategy instanceof RetryStrategy.Fixed) {
            return currentDelay;
        }
        if (strategy instanceof RetryStrategy.Exponential) {
            long nextDelay = ((long) 2) * currentDelay;
            long result = RangesKt.coerceAtMost(nextDelay, ((RetryStrategy.Exponential) strategy).getMaxIntervalMillis());
            Log.d(TAG, AbstractJsonLexerKt.BEGIN_LIST + requestId + "] 下次重试延迟计算: " + currentDelay + " ms → " + result + " ms");
            return result;
        }
        if (strategy instanceof RetryStrategy.ExponentialLimited) {
            long nextDelay2 = ((long) 2) * currentDelay;
            long result2 = RangesKt.coerceAtMost(nextDelay2, ((RetryStrategy.ExponentialLimited) strategy).getMaxIntervalMillis());
            Log.d(TAG, AbstractJsonLexerKt.BEGIN_LIST + requestId + "] 下次重试延迟计算: " + currentDelay + " ms → " + result2 + " ms");
            return result2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean shouldRetry(Throwable error) {
        if (error instanceof CancellationException) {
            return false;
        }
        if (error instanceof TapNetworkException) {
            int code = ((TapNetworkException) error).getErr().getCode();
            return (500 <= code && code < 600) || Intrinsics.areEqual(((TapNetworkException) error).getErr().getApiErr(), ApiErr.INVALID_TIME.INSTANCE);
        }
        if (error instanceof SSLPeerUnverifiedException) {
            return false;
        }
        if (error instanceof SSLHandshakeException) {
            return !(error.getCause() instanceof CertificateException);
        }
        return error instanceof IOException;
    }
}
