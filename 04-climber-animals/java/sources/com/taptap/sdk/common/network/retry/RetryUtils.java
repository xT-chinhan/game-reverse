package com.taptap.sdk.common.network.retry;

import android.util.Log;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RetryUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002JK\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J?\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/common/network/retry/RetryUtils;", "", "()V", "TAG", "", "requestCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "calculateNextDelay", "", "strategy", "Lcom/taptap/sdk/common/network/retry/RetryStrategy;", "currentDelay", "requestId", "retry", "T", "requestLabel", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/taptap/sdk/common/network/retry/RetryStrategy;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/taptap/sdk/common/network/retry/RetryStrategy;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "error", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RetryUtils {
    private static final String TAG = "RetryUtils";
    public static final RetryUtils INSTANCE = new RetryUtils();
    private static final AtomicInteger requestCounter = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.taptap.sdk.common.network.retry.RetryUtils$retry$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryUtils.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.network.retry.RetryUtils", f = "RetryUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {45, 59}, m = "retry", n = {"this", "strategy", "block", "requestId", "retryCount", "nextDelayInMillis", "this", "strategy", "block", "requestId", "retryCount", "nextDelayInMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0"})
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

    /* JADX WARN: Can't wrap try/catch for region: R(6:12|13|52|58|34|(1:36)) */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:51:0x0131 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x013d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b8, code lost:
    
        r9 = r5;
        r6 = r12;
        r5 = r14;
        r14 = r15;
        r15 = r7;
        r7 = r2;
        r2 = r13;
        r12 = r9;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x012f -> B:13:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object retry(com.taptap.sdk.common.network.retry.RetryStrategy r12, java.lang.String r13, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r14, kotlin.coroutines.Continuation<? super T> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.common.network.retry.RetryUtils.retry(com.taptap.sdk.common.network.retry.RetryStrategy, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
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

    public static /* synthetic */ Object retry$default(RetryUtils retryUtils, RetryStrategy retryStrategy, Function1 function1, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            retryStrategy = new RetryStrategy.Exponential(0L, 0L, 3, null);
        }
        return retryUtils.retry(retryStrategy, function1, continuation);
    }

    public final <T> Object retry(RetryStrategy retryStrategy, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        return retry(retryStrategy, null, function1, continuation);
    }

    private final long calculateNextDelay(RetryStrategy strategy, long currentDelay, String requestId) {
        if (strategy instanceof RetryStrategy.NoRetry) {
            return 0L;
        }
        if (strategy instanceof RetryStrategy.Fixed) {
            return currentDelay;
        }
        if (strategy instanceof RetryStrategy.Exponential) {
            long jCoerceAtMost = RangesKt.coerceAtMost(((long) 2) * currentDelay, ((RetryStrategy.Exponential) strategy).getMaxIntervalMillis());
            Log.d(TAG, "[" + requestId + "] 下次重试延迟计算: " + currentDelay + " ms → " + jCoerceAtMost + " ms");
            return jCoerceAtMost;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean shouldRetry(Throwable error) {
        if (error instanceof TapNetworkException) {
            TapNetworkException tapNetworkException = (TapNetworkException) error;
            int code = tapNetworkException.getErr().getCode();
            if (!(500 <= code && code < 600) && !Intrinsics.areEqual(tapNetworkException.getErr().getApiErr(), ApiErr.INVALID_TIME.INSTANCE)) {
                return false;
            }
        } else if (!(error instanceof SocketTimeoutException) && !(error instanceof UnknownHostException) && !(error instanceof ConnectException) && !(error instanceof SSLHandshakeException) && !(error instanceof SSLException)) {
            return false;
        }
        return true;
    }
}
