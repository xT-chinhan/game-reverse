package com.taptap.sdk.kit.internal.http.call;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
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
import com.umeng.analytics.AnalyticsConfig;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0012J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/call/TapHttpCall;", "DataBean", "Lcom/taptap/sdk/kit/internal/http/call/ITapHttpCall;", "param", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "httpParser", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;", "httpRetry", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpRetry;", "(Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpRetry;)V", "getParam", "()Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "enqueue", "delay", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueInner", "execute", "(J)Ljava/lang/Object;", "executeInner", "onResultFailure", "", NotificationCompat.CATEGORY_CALL, "Lcom/taptap/sdk/okhttp3/Call;", AnalyticsConfig.RTD_START_TIME, "it", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.http.call.TapHttpCall", f = "TapHttpCall.kt", i = {0, 1}, l = {57, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR}, m = "enqueueInner", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C08201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TapHttpCall<DataBean> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08201(TapHttpCall<DataBean> tapHttpCall, Continuation<? super C08201> continuation) {
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
    public Object mo51enqueueResultgIAlus(long j, Continuation<? super Result<? extends DataBean>> continuation) {
        return ITapHttpCall.DefaultImpls.m53enqueueResultgIAlus(this, j, continuation);
    }

    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    /* JADX INFO: renamed from: executeResult-IoAF18A */
    public Object mo52executeResultIoAF18A(long j) {
        return ITapHttpCall.DefaultImpls.m55executeResultIoAF18A(this, j);
    }

    public final AbsTapHttpParam<?> getParam() {
        return this.param;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
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
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objEnqueueInner);
            try {
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                objEnqueueInner = enqueueInner(j, anonymousClass1);
                if (objEnqueueInner == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                th = th;
                tapHttpCall = this;
                jNextRetryMillis = tapHttpCall.httpRetry.nextRetryMillis(th);
                if (jNextRetryMillis >= 0) {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    objEnqueueInner = tapHttpCall.enqueue(jNextRetryMillis, anonymousClass1);
                    if (objEnqueueInner == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw th;
                }
            }
        } else if (i == 1) {
            tapHttpCall = (TapHttpCall) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objEnqueueInner);
            } catch (Throwable th2) {
                th = th2;
                jNextRetryMillis = tapHttpCall.httpRetry.nextRetryMillis(th);
                if (jNextRetryMillis >= 0) {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    objEnqueueInner = tapHttpCall.enqueue(jNextRetryMillis, anonymousClass1);
                    if (objEnqueueInner == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw th;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objEnqueueInner);
        }
        return objEnqueueInner;
    }

    @Override // com.taptap.sdk.kit.internal.http.call.ITapHttpCall
    public DataBean execute(long delay) {
        try {
            return executeInner(delay);
        } catch (Throwable th) {
            long jNextRetryMillis = this.httpRetry.nextRetryMillis(th);
            if (jNextRetryMillis >= 0) {
                return execute(jNextRetryMillis);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r3v11, types: [T, com.taptap.sdk.okhttp3.Call] */
    public final Object enqueueInner(long j, Continuation<? super DataBean> continuation) throws Throwable {
        C08201 c08201;
        final TapHttpCall<DataBean> tapHttpCall;
        final CancellableContinuationImpl cancellableContinuationImpl;
        final Ref.ObjectRef objectRef;
        if (continuation instanceof C08201) {
            c08201 = (C08201) continuation;
            if ((c08201.label & Integer.MIN_VALUE) != 0) {
                c08201.label -= Integer.MIN_VALUE;
            } else {
                c08201 = new C08201(this, continuation);
            }
        } else {
            c08201 = new C08201(this, continuation);
        }
        Object result = c08201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08201.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    tapHttpCall = (TapHttpCall) c08201.L$0;
                    ResultKt.throwOnFailure(result);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(result);
                }
            }
            ResultKt.throwOnFailure(result);
            if (j > 0) {
                c08201.L$0 = this;
                c08201.label = 1;
                if (DelayKt.delay(j, c08201) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapHttpCall = this;
            objectRef.element = tapHttpCall.getParam().newCall$tap_common_release();
        } catch (Throwable th) {
            if (!cancellableContinuationImpl.isCompleted()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m174constructorimpl(ResultKt.createFailure(th)));
            }
        }
        c08201.L$0 = tapHttpCall;
        c08201.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c08201), 1);
        cancellableContinuationImpl2.initCancellability();
        cancellableContinuationImpl = cancellableContinuationImpl2;
        objectRef = new Ref.ObjectRef();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                Call call = objectRef.element;
                if (call != null) {
                    call.cancel();
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
                    Call call = objectRef.element;
                    String strMethod = null;
                    pairArr[2] = TuplesKt.to("url", String.valueOf((call == null || (request2 = call.request()) == null) ? null : request2.url()));
                    Call call2 = objectRef.element;
                    if (call2 != null && (request = call2.request()) != null) {
                        strMethod = request.method();
                    }
                    pairArr[3] = TuplesKt.to("method", strMethod);
                    pairArr[4] = TuplesKt.to("param", this.this$0.getParam().getTechnicalLogParam$tap_common_release());
                    return MapsKt.mapOf(pairArr);
                }
            });
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Call call = (Call) objectRef.element;
        if (call != null) {
            call.enqueue(new Callback(tapHttpCall) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3
                final /* synthetic */ TapHttpCall<DataBean> this$0;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.this$0 = tapHttpCall;
                }

                @Override // com.taptap.sdk.okhttp3.Callback
                public void onResponse(final Call call2, Response response) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        Object objMo57parseIoAF18A = ((TapHttpCall) this.this$0).httpParser.mo57parseIoAF18A(response);
                        final TapHttpCall<DataBean> tapHttpCall2 = this.this$0;
                        Continuation continuation2 = cancellableContinuationImpl;
                        final long j2 = jCurrentTimeMillis;
                        if (Result.m181isSuccessimpl(objMo57parseIoAF18A)) {
                            if (tapHttpCall2.getParam().enableTechnicalLog$tap_common_release()) {
                                final long jCurrentTimeMillis2 = System.currentTimeMillis();
                                TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Map<String, ? extends String> invoke() {
                                        return MapsKt.mapOf(TuplesKt.to("succeed", "1"), TuplesKt.to("module_name", tapHttpCall2.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall2.getParam().moduleVersion$tap_common_release()), TuplesKt.to("url", call2.request().url().toString()), TuplesKt.to("method", call2.request().method()), TuplesKt.to("start_time", String.valueOf(j2)), TuplesKt.to("end_time", String.valueOf(jCurrentTimeMillis2)));
                                    }
                                });
                            }
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation2.resumeWith(Result.m174constructorimpl(objMo57parseIoAF18A));
                        }
                        TapHttpCall<DataBean> tapHttpCall3 = this.this$0;
                        long j3 = jCurrentTimeMillis;
                        CancellableContinuation<DataBean> cancellableContinuation = cancellableContinuationImpl;
                        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objMo57parseIoAF18A);
                        if (thM177exceptionOrNullimpl != null) {
                            tapHttpCall3.onResultFailure(call2, j3, thM177exceptionOrNullimpl, cancellableContinuation);
                        }
                    } catch (Throwable th2) {
                        if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                            final long jCurrentTimeMillis3 = System.currentTimeMillis();
                            TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                            final TapHttpCall<DataBean> tapHttpCall4 = this.this$0;
                            final long j4 = jCurrentTimeMillis;
                            tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onResponse$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Map<String, ? extends String> invoke() {
                                    return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall4.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall4.getParam().moduleVersion$tap_common_release()), TuplesKt.to("url", call2.request().url().toString()), TuplesKt.to("method", call2.request().method()), TuplesKt.to("local_error_msg", th2.getMessage()), TuplesKt.to("start_time", String.valueOf(j4)), TuplesKt.to("end_time", String.valueOf(jCurrentTimeMillis3)));
                                }
                            });
                        }
                        if (cancellableContinuationImpl.isCompleted()) {
                            return;
                        }
                        Continuation continuation3 = cancellableContinuationImpl;
                        Result.Companion companion3 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m174constructorimpl(ResultKt.createFailure(th2)));
                    }
                }

                @Override // com.taptap.sdk.okhttp3.Callback
                public void onFailure(final Call call2, final IOException e) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (this.this$0.getParam().enableTechnicalLog$tap_common_release()) {
                        final long jCurrentTimeMillis2 = System.currentTimeMillis();
                        TapOpenlogHelper tapOpenlogHelper = TapOpenlogHelper.INSTANCE;
                        final TapHttpCall<DataBean> tapHttpCall2 = this.this$0;
                        final long j2 = jCurrentTimeMillis;
                        tapOpenlogHelper.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall$enqueueInner$2$3$onFailure$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Map<String, ? extends String> invoke() {
                                return MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", tapHttpCall2.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, tapHttpCall2.getParam().moduleVersion$tap_common_release()), TuplesKt.to("url", call2.request().url().toString()), TuplesKt.to("method", call2.request().method()), TuplesKt.to("local_error_msg", e.getMessage()), TuplesKt.to("start_time", String.valueOf(j2)), TuplesKt.to("end_time", String.valueOf(jCurrentTimeMillis2)));
                            }
                        });
                    }
                    if (cancellableContinuationImpl.isCompleted()) {
                        return;
                    }
                    Continuation continuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m174constructorimpl(ResultKt.createFailure(e)));
                }
            });
        }
        result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c08201);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResultFailure(final Call call, final long startTime, final Throwable it, CancellableContinuation<? super DataBean> continuation) {
        if (this.param.enableTechnicalLog$tap_common_release()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_performance", new Function0<Map<String, ? extends String>>(this) { // from class: com.taptap.sdk.kit.internal.http.call.TapHttpCall.onResultFailure.1
                final /* synthetic */ TapHttpCall<DataBean> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends String> invoke() {
                    Map<String, ? extends String> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("module_name", this.this$0.getParam().moduleName$tap_common_release()), TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.this$0.getParam().moduleVersion$tap_common_release()), TuplesKt.to("url", call.request().url().toString()), TuplesKt.to("method", call.request().method()), TuplesKt.to("start_time", String.valueOf(startTime)), TuplesKt.to("end_time", String.valueOf(jCurrentTimeMillis)));
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
        if (continuation.isCompleted()) {
            return;
        }
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m174constructorimpl(ResultKt.createFailure(it)));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0006, B:5:0x0009, B:8:0x0025, B:10:0x002b), top: B:15:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0025 A[Catch: all -> 0x0032, TryCatch #0 {, blocks: (B:4:0x0006, B:5:0x0009, B:8:0x0025, B:10:0x002b), top: B:15:0x0006 }] */
    private final DataBean executeInner(long delay) throws TapHttpException.UnknownError {
        DataBean databean;
        Throwable thM177exceptionOrNullimpl;
        if (delay > 0) {
            Thread.sleep(delay);
            Response response = this.param.newCall$tap_common_release().execute();
            ITapHttpParser<DataBean> iTapHttpParser = this.httpParser;
            Intrinsics.checkNotNullExpressionValue(response, "response");
            databean = (DataBean) iTapHttpParser.mo57parseIoAF18A(response);
            if (Result.m181isSuccessimpl(databean)) {
                return databean;
            }
            thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(databean);
            if (thM177exceptionOrNullimpl != null) {
                throw thM177exceptionOrNullimpl;
            }
            throw new TapHttpException.UnknownError();
        }
        Response response2 = this.param.newCall$tap_common_release().execute();
        ITapHttpParser<DataBean> iTapHttpParser2 = this.httpParser;
        Intrinsics.checkNotNullExpressionValue(response2, "response");
        databean = (DataBean) iTapHttpParser2.mo57parseIoAF18A(response2);
        if (Result.m181isSuccessimpl(databean)) {
            return databean;
        }
        thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(databean);
        if (thM177exceptionOrNullimpl != null) {
            throw thM177exceptionOrNullimpl;
        }
        throw new TapHttpException.UnknownError();
        throw th;
    }
}
