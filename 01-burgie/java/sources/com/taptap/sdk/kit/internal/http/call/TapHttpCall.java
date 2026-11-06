package com.taptap.sdk.kit.internal.http.call;

import android.support.v4.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.utils.TapOpenlogHelper;
import com.taptap.sdk.okhttp3.Call;
import com.taptap.sdk.okhttp3.Callback;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.d;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: TapHttpCall.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0012J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/call/TapHttpCall;", "DataBean", "Lcom/taptap/sdk/kit/internal/http/call/ITapHttpCall;", "param", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "httpParser", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;", "httpRetry", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpRetry;", "(Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpRetry;)V", "getParam", "()Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "enqueue", Constants.DELAY_FIELD, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueInner", "execute", "(J)Ljava/lang/Object;", "executeInner", "onResultFailure", "", NotificationCompat.CATEGORY_CALL, "Lcom/taptap/sdk/okhttp3/Call;", AnalyticsConfig.RTD_START_TIME, "it", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpCall<DataBean> implements ITapHttpCall<DataBean> {
    private final ITapHttpParser<DataBean> httpParser;
    private final ITapHttpRetry httpRetry;
    private final AbsTapHttpParam<?> param;

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapHttpCall.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.http.call.TapHttpCall", f = "TapHttpCall.kt", i = {0}, l = {28, 33}, m = "enqueue", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TapHttpCall<DataBean> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapHttpCall<DataBean> tapHttpCall, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = tapHttpCall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.enqueue(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapHttpCall.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.http.call.TapHttpCall", f = "TapHttpCall.kt", i = {0, 1}, l = {57, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG}, m = "enqueueInner", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C03481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TapHttpCall<DataBean> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03481(TapHttpCall<DataBean> tapHttpCall, Continuation<? super C03481> continuation) {
            super(continuation);
            this.this$0 = tapHttpCall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.enqueueInner(0L, this);
        }
    }

    public TapHttpCall(AbsTapHttpParam<?> param, ITapHttpParser<DataBean> httpParser, ITapHttpRetry httpRetry) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(httpParser, "httpParser");
        Intrinsics.checkNotNullParameter(httpRetry, "httpRetry");
        this.param = param;
        this.httpParser = httpParser;
        this.httpRetry = httpRetry;
    }

    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    /* JADX INFO: renamed from: enqueueResult-gIAlu-s */
    public Object mo415enqueueResultgIAlus(long delay, Continuation<? super Result<? extends DataBean>> continuation) {
        return ITapHttpCall.DefaultImpls.m417enqueueResultgIAlus(this, delay, continuation);
    }

    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    /* JADX INFO: renamed from: executeResult-IoAF18A */
    public Object mo416executeResultIoAF18A(long delay) {
        return ITapHttpCall.DefaultImpls.m419executeResultIoAF18A(this, delay);
    }

    public final AbsTapHttpParam<?> getParam() {
        return this.param;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    public Object enqueue(long j, Continuation<? super DataBean> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        TapHttpCall tapHttpCall;
        long jNextRetryMillis;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object objEnqueueInner = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(objEnqueueInner);
                try {
                    anonymousClass1.L$0 = this;
                    anonymousClass1.label = 1;
                    objEnqueueInner = enqueueInner(j, anonymousClass1);
                    return objEnqueueInner == coroutine_suspended ? coroutine_suspended : objEnqueueInner;
                } catch (Throwable th) {
                    th = th;
                    tapHttpCall = this;
                    jNextRetryMillis = tapHttpCall.httpRetry.nextRetryMillis(th);
                    if (jNextRetryMillis >= 0) {
                        throw th;
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    objEnqueueInner = tapHttpCall.enqueue(jNextRetryMillis, anonymousClass1);
                    if (objEnqueueInner == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            case 1:
                tapHttpCall = (TapHttpCall) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objEnqueueInner);
                } catch (Throwable th2) {
                    th = th2;
                    jNextRetryMillis = tapHttpCall.httpRetry.nextRetryMillis(th);
                    if (jNextRetryMillis >= 0) {
                        throw th;
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    objEnqueueInner = tapHttpCall.enqueue(jNextRetryMillis, anonymousClass1);
                    if (objEnqueueInner == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 2:
                ResultKt.throwOnFailure(objEnqueueInner);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    public DataBean execute(long delay) {
        try {
            return executeInner(delay);
        } catch (Throwable e) {
            long nextBackoffMillis = this.httpRetry.nextRetryMillis(e);
            if (nextBackoffMillis >= 0) {
                return execute(nextBackoffMillis);
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, com.taptap.sdk.okhttp3.Call] */
    public final Object enqueueInner(long delay, Continuation<? super DataBean> continuation) throws Throwable {
        C03481 c03481;
        final TapHttpCall<DataBean> tapHttpCall;
        TapHttpCall<DataBean> tapHttpCall2;
        final CancellableContinuationImpl continuation2;
        final Ref.ObjectRef call;
        final long startTime;
        Call call2;
        Object result;
        if (continuation instanceof C03481) {
            c03481 = (C03481) continuation;
            if ((c03481.label & Integer.MIN_VALUE) != 0) {
                c03481.label -= Integer.MIN_VALUE;
            } else {
                c03481 = new C03481(this, continuation);
            }
        } else {
            c03481 = new C03481(this, continuation);
        }
        C03481 c03482 = c03481;
        Object $result = c03482.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03482.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                tapHttpCall = this;
                if (delay > 0) {
                    c03482.L$0 = tapHttpCall;
                    c03482.label = 1;
                    if (DelayKt.delay(delay, c03482) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tapHttpCall2 = tapHttpCall;
                    tapHttpCall = tapHttpCall2;
                }
                c03482.L$0 = tapHttpCall;
                c03482.label = 2;
                CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c03482), 1);
                cancellable$iv.initCancellability();
                continuation2 = cancellable$iv;
                call = new Ref.ObjectRef();
                try {
                    call.element = tapHttpCall.getParam().newCall$tap_common_release();
                    break;
                } catch (Throwable e) {
                    if (!continuation2.isCompleted()) {
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(e)));
                    }
                }
                continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Call call3 = call.element;
                        if (call3 != null) {
                            call3.cancel();
                        }
                    }
                });
                if (tapHttpCall.getParam().enableTechnicalLog$tap_common_release()) {
                    TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_execute", new Function0<Map<String, ? extends String>>(tapHttpCall) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$2
                        final /* synthetic */ TapHttpCall<DataBean> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.this$0 = tapHttpCall;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Map<String, ? extends String> invoke() {
                            Request request;
                            Request request2;
                            Pair[] pairArr = new Pair[5];
                            pairArr[0] = TuplesKt.to("module_name", this.this$0.getParam().moduleName$tap_common_release());
                            pairArr[1] = TuplesKt.to("version_code", this.this$0.getParam().moduleVersion$tap_common_release());
                            Call call3 = call.element;
                            String strMethod = null;
                            pairArr[2] = TuplesKt.to(BreakpointSQLiteKey.URL, String.valueOf((call3 == null || (request2 = call3.request()) == null) ? null : request2.url()));
                            Call call4 = call.element;
                            if (call4 != null && (request = call4.request()) != null) {
                                strMethod = request.method();
                            }
                            pairArr[3] = TuplesKt.to("method", strMethod);
                            pairArr[4] = TuplesKt.to("param", this.this$0.getParam().getTechnicalLogParam$tap_common_release());
                            return MapsKt.mapOf(pairArr);
                        }
                    });
                }
                startTime = System.currentTimeMillis();
                call2 = (Call) call.element;
                if (call2 != null) {
                    call2.enqueue(new Callback(tapHttpCall) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3
                        final /* synthetic */ TapHttpCall<DataBean> this$0;

                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            this.this$0 = tapHttpCall;
                        }

                        @Override // com.taptap.sdk.okhttp3.Callback
                        public void onResponse(final Call call3, Response response) {
                            Intrinsics.checkNotNullParameter(call3, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            try {
                                Object result2 = ((TapHttpCall) this.this$0).httpParser.mo421parseIoAF18A(response);
                                final TapHttpCall<DataBean> tapHttpCall3 = this.this$0;
                                Continuation continuation3 = continuation2;
                                final long j = startTime;
                                if (Result.m541isSuccessimpl(result2)) {
                                    if (tapHttpCall3.getParam().enableTechnicalLog$tap_common_release()) {
                                        final long endTime = System.currentTimeMillis();
                                        TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Map<String, ? extends String> invoke() {
                                                return MapsKt.mapOf(TuplesKt.to("succeed", "1"), TuplesKt.to("module_name", tapHttpCall3.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall3.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to(d.p, String.valueOf(j)), TuplesKt.to(d.q, String.valueOf(endTime)));
                                            }
                                        });
                                    }
                                    Result.Companion companion2 = Result.INSTANCE;
                                    continuation3.resumeWith(Result.m534constructorimpl(result2));
                                }
                                TapHttpCall<DataBean> tapHttpCall4 = this.this$0;
                                long j2 = startTime;
                                CancellableContinuation<DataBean> cancellableContinuation = continuation2;
                                Throwable it = Result.m537exceptionOrNullimpl(result2);
                                if (it != null) {
                                    tapHttpCall4.onResultFailure(call3, j2, it, cancellableContinuation);
                                }
                            } catch (Throwable t) {
                                if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                                    final long endTime2 = System.currentTimeMillis();
                                    TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                                    final TapHttpCall<DataBean> tapHttpCall5 = this.this$0;
                                    final long j3 = startTime;
                                    tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Map<String, ? extends String> invoke() {
                                            return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall5.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall5.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to("local_error_msg", t.getMessage()), TuplesKt.to(d.p, String.valueOf(j3)), TuplesKt.to(d.q, String.valueOf(endTime2)));
                                        }
                                    });
                                }
                                if (!continuation2.isCompleted()) {
                                    Continuation continuation4 = continuation2;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    continuation4.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(t)));
                                }
                            }
                        }

                        @Override // com.taptap.sdk.okhttp3.Callback
                        public void onFailure(final Call call3, final IOException e2) {
                            Intrinsics.checkNotNullParameter(call3, "call");
                            Intrinsics.checkNotNullParameter(e2, "e");
                            if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                                final long endTime = System.currentTimeMillis();
                                TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                                final TapHttpCall<DataBean> tapHttpCall3 = this.this$0;
                                final long j = startTime;
                                tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onFailure$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Map<String, ? extends String> invoke() {
                                        return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall3.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall3.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to("local_error_msg", e2.getMessage()), TuplesKt.to(d.p, String.valueOf(j)), TuplesKt.to(d.q, String.valueOf(endTime)));
                                    }
                                });
                            }
                            if (!continuation2.isCompleted()) {
                                Continuation continuation3 = continuation2;
                                Result.Companion companion2 = Result.INSTANCE;
                                continuation3.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(e2)));
                            }
                        }
                    });
                }
                result = cancellable$iv.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c03482);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 1:
                tapHttpCall2 = (TapHttpCall) c03482.L$0;
                ResultKt.throwOnFailure($result);
                tapHttpCall = tapHttpCall2;
                c03482.L$0 = tapHttpCall;
                c03482.label = 2;
                CancellableContinuationImpl cancellable$iv2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c03482), 1);
                cancellable$iv2.initCancellability();
                continuation2 = cancellable$iv2;
                call = new Ref.ObjectRef();
                call.element = tapHttpCall.getParam().newCall$tap_common_release();
                continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Call call3 = call.element;
                        if (call3 != null) {
                            call3.cancel();
                        }
                    }
                });
                if (tapHttpCall.getParam().enableTechnicalLog$tap_common_release()) {
                    TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_execute", new Function0<Map<String, ? extends String>>(tapHttpCall) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$2
                        final /* synthetic */ TapHttpCall<DataBean> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.this$0 = tapHttpCall;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Map<String, ? extends String> invoke() {
                            Request request;
                            Request request2;
                            Pair[] pairArr = new Pair[5];
                            pairArr[0] = TuplesKt.to("module_name", this.this$0.getParam().moduleName$tap_common_release());
                            pairArr[1] = TuplesKt.to("version_code", this.this$0.getParam().moduleVersion$tap_common_release());
                            Call call3 = call.element;
                            String strMethod = null;
                            pairArr[2] = TuplesKt.to(BreakpointSQLiteKey.URL, String.valueOf((call3 == null || (request2 = call3.request()) == null) ? null : request2.url()));
                            Call call4 = call.element;
                            if (call4 != null && (request = call4.request()) != null) {
                                strMethod = request.method();
                            }
                            pairArr[3] = TuplesKt.to("method", strMethod);
                            pairArr[4] = TuplesKt.to("param", this.this$0.getParam().getTechnicalLogParam$tap_common_release());
                            return MapsKt.mapOf(pairArr);
                        }
                    });
                }
                startTime = System.currentTimeMillis();
                call2 = (Call) call.element;
                if (call2 != null) {
                    call2.enqueue(new Callback(tapHttpCall) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3
                        final /* synthetic */ TapHttpCall<DataBean> this$0;

                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            this.this$0 = tapHttpCall;
                        }

                        @Override // com.taptap.sdk.okhttp3.Callback
                        public void onResponse(final Call call3, Response response) {
                            Intrinsics.checkNotNullParameter(call3, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            try {
                                Object result2 = ((TapHttpCall) this.this$0).httpParser.mo421parseIoAF18A(response);
                                final TapHttpCall<DataBean> tapHttpCall3 = this.this$0;
                                Continuation continuation3 = continuation2;
                                final long j = startTime;
                                if (Result.m541isSuccessimpl(result2)) {
                                    if (tapHttpCall3.getParam().enableTechnicalLog$tap_common_release()) {
                                        final long endTime = System.currentTimeMillis();
                                        TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Map<String, ? extends String> invoke() {
                                                return MapsKt.mapOf(TuplesKt.to("succeed", "1"), TuplesKt.to("module_name", tapHttpCall3.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall3.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to(d.p, String.valueOf(j)), TuplesKt.to(d.q, String.valueOf(endTime)));
                                            }
                                        });
                                    }
                                    Result.Companion companion2 = Result.INSTANCE;
                                    continuation3.resumeWith(Result.m534constructorimpl(result2));
                                }
                                TapHttpCall<DataBean> tapHttpCall4 = this.this$0;
                                long j2 = startTime;
                                CancellableContinuation<DataBean> cancellableContinuation = continuation2;
                                Throwable it = Result.m537exceptionOrNullimpl(result2);
                                if (it != null) {
                                    tapHttpCall4.onResultFailure(call3, j2, it, cancellableContinuation);
                                }
                            } catch (Throwable t) {
                                if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                                    final long endTime2 = System.currentTimeMillis();
                                    TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                                    final TapHttpCall<DataBean> tapHttpCall5 = this.this$0;
                                    final long j3 = startTime;
                                    tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Map<String, ? extends String> invoke() {
                                            return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall5.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall5.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to("local_error_msg", t.getMessage()), TuplesKt.to(d.p, String.valueOf(j3)), TuplesKt.to(d.q, String.valueOf(endTime2)));
                                        }
                                    });
                                }
                                if (!continuation2.isCompleted()) {
                                    Continuation continuation4 = continuation2;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    continuation4.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(t)));
                                }
                            }
                        }

                        @Override // com.taptap.sdk.okhttp3.Callback
                        public void onFailure(final Call call3, final IOException e2) {
                            Intrinsics.checkNotNullParameter(call3, "call");
                            Intrinsics.checkNotNullParameter(e2, "e");
                            if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                                final long endTime = System.currentTimeMillis();
                                TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                                final TapHttpCall<DataBean> tapHttpCall3 = this.this$0;
                                final long j = startTime;
                                tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onFailure$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Map<String, ? extends String> invoke() {
                                        return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall3.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall3.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call3.request().url().toString()), TuplesKt.to("method", call3.request().method()), TuplesKt.to("local_error_msg", e2.getMessage()), TuplesKt.to(d.p, String.valueOf(j)), TuplesKt.to(d.q, String.valueOf(endTime)));
                                    }
                                });
                            }
                            if (!continuation2.isCompleted()) {
                                Continuation continuation3 = continuation2;
                                Result.Companion companion2 = Result.INSTANCE;
                                continuation3.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(e2)));
                            }
                        }
                    });
                }
                result = cancellable$iv2.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c03482);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResultFailure(final Call call, final long startTime, final Throwable it, CancellableContinuation<? super DataBean> continuation) {
        if (this.param.enableTechnicalLog$tap_common_release()) {
            final long endTime = System.currentTimeMillis();
            TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>(this) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall.onResultFailure.1
                final /* synthetic */ TapHttpCall<DataBean> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends String> invoke() {
                    Map<String, ? extends String> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", this.this$0.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.this$0.getParam().moduleVersion$tap_common_release()), TuplesKt.to(BreakpointSQLiteKey.URL, call.request().url().toString()), TuplesKt.to("method", call.request().method()), TuplesKt.to(d.p, String.valueOf(startTime)), TuplesKt.to(d.q, String.valueOf(endTime)));
                    Throwable th = it;
                    if (th instanceof TapHttpException.ServerError) {
                        mapMutableMapOf.put(TapErrorConstants.ERROR_SERVER_ERROR, ((TapHttpException.ServerError) th).getError().getError());
                        mapMutableMapOf.put("http_code", String.valueOf(((TapHttpException.ServerError) it).getHttpCode()));
                    } else if (th instanceof TapHttpException.NoServerError) {
                        mapMutableMapOf.put("http_code", String.valueOf(((TapHttpException.NoServerError) th).getHttpCode()));
                    } else if (th instanceof TapHttpException.ParseDataError) {
                        mapMutableMapOf.put("http_code", String.valueOf(((TapHttpException.ParseDataError) th).getHttpCode()));
                        mapMutableMapOf.put("local_error_msg", "ParseDataError");
                    } else if (th instanceof TapHttpException.UnknownError) {
                        mapMutableMapOf.put("local_error_msg", "UnknownError");
                    }
                    return mapMutableMapOf;
                }
            });
        }
        if (!continuation.isCompleted()) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m534constructorimpl(ResultKt.createFailure(it)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x0028 A[Catch: all -> 0x0038, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x000a, B:9:0x0028, B:12:0x0030), top: B:17:0x0007 }] */
    private final DataBean executeInner(long delay) throws TapHttpException.UnknownError {
        DataBean databean;
        Throwable thM537exceptionOrNullimpl;
        if (delay > 0) {
            Thread.sleep(delay);
            Response response = this.param.newCall$tap_common_release().execute();
            ITapHttpParser<DataBean> iTapHttpParser = this.httpParser;
            Intrinsics.checkNotNullExpressionValue(response, "response");
            databean = (DataBean) iTapHttpParser.mo421parseIoAF18A(response);
            if (Result.m541isSuccessimpl(databean)) {
                return databean;
            }
            thM537exceptionOrNullimpl = Result.m537exceptionOrNullimpl(databean);
            if (thM537exceptionOrNullimpl != null) {
                throw thM537exceptionOrNullimpl;
            }
            throw new TapHttpException.UnknownError();
        }
        Response response2 = this.param.newCall$tap_common_release().execute();
        ITapHttpParser<DataBean> iTapHttpParser2 = this.httpParser;
        Intrinsics.checkNotNullExpressionValue(response2, "response");
        databean = (DataBean) iTapHttpParser2.mo421parseIoAF18A(response2);
        if (Result.m541isSuccessimpl(databean)) {
            return databean;
        }
        thM537exceptionOrNullimpl = Result.m537exceptionOrNullimpl(databean);
        if (thM537exceptionOrNullimpl != null) {
            throw thM537exceptionOrNullimpl;
        }
        throw new TapHttpException.UnknownError();
        throw th;
    }
}
