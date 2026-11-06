package com.taptap.sdk.common.network.convert;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.common.network.data.response.BaseResponse;
import com.taptap.sdk.common.network.data.response.ErrResponse;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.ResponseBody;
import com.taptap.sdk.okio.Timeout;
import com.taptap.sdk.retrofit2.Call;
import com.taptap.sdk.retrofit2.CallAdapter;
import com.taptap.sdk.retrofit2.Callback;
import com.taptap.sdk.retrofit2.Invocation;
import com.taptap.sdk.retrofit2.Response;
import com.taptap.sdk.retrofit2.Retrofit;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ErrorHandlerCallFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/common/network/convert/ErrorHandlerCallFactory;", "Lcom/taptap/sdk/retrofit2/CallAdapter$Factory;", "()V", "get", "Lcom/taptap/sdk/retrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lcom/taptap/sdk/retrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lcom/taptap/sdk/retrofit2/Retrofit;)Lcom/taptap/sdk/retrofit2/CallAdapter;", "Companion", "ErrorHandlingCall", "ErrorHandlingCallAdapter", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorHandlerCallFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ErrorHandlerCallFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ErrorHandlerCallFactory() {
    }

    @Override // com.taptap.sdk.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Type responseType = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
        Intrinsics.checkNotNullExpressionValue(responseType, "responseType");
        return new ErrorHandlingCallAdapter(responseType);
    }

    /* JADX INFO: compiled from: ErrorHandlerCallFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/common/network/convert/ErrorHandlerCallFactory$ErrorHandlingCallAdapter;", "T", "Lcom/taptap/sdk/retrofit2/CallAdapter;", "Lcom/taptap/sdk/retrofit2/Call;", "responseType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "adapt", NotificationCompat.CATEGORY_CALL, "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ErrorHandlingCallAdapter<T> implements CallAdapter<T, Call<T>> {
        private final Type responseType;

        public ErrorHandlingCallAdapter(Type responseType) {
            Intrinsics.checkNotNullParameter(responseType, "responseType");
            this.responseType = responseType;
        }

        @Override // com.taptap.sdk.retrofit2.CallAdapter
        /* JADX INFO: renamed from: responseType, reason: from getter */
        public Type getResponseType() {
            return this.responseType;
        }

        @Override // com.taptap.sdk.retrofit2.CallAdapter
        /* JADX INFO: renamed from: adapt */
        public Call<T> adapt2(Call<T> call) {
            Intrinsics.checkNotNullParameter(call, "call");
            return new ErrorHandlingCall(call);
        }
    }

    /* JADX INFO: compiled from: ErrorHandlerCallFactory.kt */
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J,\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0018H\u0002J.\u0010)\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.0-H\u0002J.\u0010/\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.0-H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000205H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u00066"}, d2 = {"Lcom/taptap/sdk/common/network/convert/ErrorHandlerCallFactory$ErrorHandlingCall;", "T", "Lcom/taptap/sdk/retrofit2/Call;", "delegate", "(Lcom/taptap/sdk/retrofit2/Call;)V", "activeCall", "callLock", "", "canceled", "", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "Lkotlin/Lazy;", TrackAction.CANCEL, "", "clone", "enqueue", "callToExecute", "callback", "Lcom/taptap/sdk/retrofit2/Callback;", "invalidTimeRetryCount", "", "execute", "Lcom/taptap/sdk/retrofit2/Response;", "getModule", "Lcom/taptap/sdk/base/network/annotation/Module;", "request", "Lcom/taptap/sdk/okhttp3/Request;", "isCanceled", "isExecuted", "parseBaseResponse", "Lcom/taptap/sdk/common/network/data/response/BaseResponse;", "response", "parseServerError", "Lcom/taptap/sdk/common/network/data/response/ErrResponse;", "data", "Lkotlinx/serialization/json/JsonElement;", PluginConstants.KEY_ERROR_CODE, "reportPerformance", AnalyticsConfig.RTD_START_TIME, "", Common.Predefined.PROPERTIES, "", "", "reportTechnicalLog", "action", "safeErrorSummary", "error", "", "timeout", "Lcom/taptap/sdk/okio/Timeout;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ErrorHandlingCall<T> implements Call<T> {
        private volatile Call<T> activeCall;
        private final Object callLock;
        private volatile boolean canceled;
        private final Call<T> delegate;

        /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
        private final Lazy openLogService;

        public ErrorHandlingCall(Call<T> delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
            ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
            this.openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.common.network.convert.ErrorHandlerCallFactory$ErrorHandlingCall$special$$inlined$injectOrNull$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v1, types: [com.taptap.sdk.common.services.OpenLogService, com.taptap.sdk.servicemanager.ServiceManager$Service] */
                @Override // kotlin.jvm.functions.Function0
                public final OpenLogService invoke() {
                    return ServiceManager.INSTANCE.getService(OpenLogService.class);
                }
            });
            this.callLock = new Object();
            this.activeCall = delegate;
        }

        private final OpenLogService getOpenLogService() {
            return (OpenLogService) this.openLogService.getValue();
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public Response<T> execute() {
            throw new UnsupportedOperationException("MyCall does not support synchronous execution");
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            enqueue(this.delegate, callback, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void enqueue(final Call<T> callToExecute, final Callback<T> callback, final int invalidTimeRetryCount) {
            boolean z;
            synchronized (this.callLock) {
                this.activeCall = callToExecute;
                if (this.canceled) {
                    callToExecute.cancel();
                    z = false;
                } else {
                    z = true;
                }
            }
            boolean shouldEnqueue = z;
            if (shouldEnqueue) {
                final long startTime = System.currentTimeMillis();
                Request request = callToExecute.request();
                Intrinsics.checkNotNullExpressionValue(request, "callToExecute.request()");
                Pair[] pairArr = new Pair[3];
                Request request2 = callToExecute.request();
                Intrinsics.checkNotNullExpressionValue(request2, "callToExecute.request()");
                Module module = getModule(request2);
                pairArr[0] = TuplesKt.to("module_name", module != null ? module.name() : null);
                Request request3 = callToExecute.request();
                Intrinsics.checkNotNullExpressionValue(request3, "callToExecute.request()");
                Module module2 = getModule(request3);
                pairArr[1] = TuplesKt.to("version_code", module2 != null ? module2.version() : null);
                pairArr[2] = TuplesKt.to("method", callToExecute.request().method());
                reportTechnicalLog(request, "http_execute", MapsKt.mapOf(pairArr));
                callToExecute.enqueue(new Callback<T>(this) { // from class: com.taptap.sdk.common.network.convert.ErrorHandlerCallFactory$ErrorHandlingCall$enqueue$1
                    final /* synthetic */ ErrorHandlerCallFactory.ErrorHandlingCall<T> this$0;

                    {
                        this.this$0 = this;
                    }

                    /* JADX WARN: Code duplicated, block: B:28:0x0112 A[Catch: all -> 0x017b, TRY_LEAVE, TryCatch #1 {all -> 0x017b, blocks: (B:24:0x00d5, B:26:0x00fc, B:28:0x0112), top: B:53:0x0051 }] */
                    /* JADX WARN: Code duplicated, block: B:32:0x0169 A[Catch: all -> 0x0179, TRY_LEAVE, TryCatch #0 {all -> 0x0179, blocks: (B:30:0x0151, B:32:0x0169), top: B:50:0x0151 }] */
                    /* JADX WARN: Code duplicated, block: B:34:0x0175  */
                    @Override // com.taptap.sdk.retrofit2.Callback
                    public void onResponse(Call<T> call, Response<T> response) {
                        Object obj;
                        Object obj2;
                        TapNetworkException error;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.isCanceled()) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            try {
                                int code = response.code();
                                BaseResponse baseResponse = this.this$0.parseBaseResponse(response);
                                TapTime.INSTANCE.calibrateServerTime(Integer.valueOf(baseResponse.getNow()));
                                ErrResponse serverError = this.this$0.parseServerError(baseResponse.getData(), code);
                                try {
                                    if (serverError.getCode() == 0) {
                                        obj2 = "local_error_msg";
                                        error = new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, code, "invalid server error response", null), null, 2, null);
                                        ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall = this.this$0;
                                        Request request4 = call.request();
                                        Intrinsics.checkNotNullExpressionValue(request4, "call.request()");
                                        long j = startTime;
                                        Pair[] pairArr2 = new Pair[3];
                                        pairArr2[0] = TuplesKt.to("succeed", "0");
                                        pairArr2[1] = TuplesKt.to("http_code", String.valueOf(code));
                                        obj = obj2;
                                        try {
                                            pairArr2[2] = TuplesKt.to(obj, error.getMessage());
                                            errorHandlingCall.reportPerformance(request4, j, MapsKt.mapOf(pairArr2));
                                            if (!this.this$0.isCanceled()) {
                                                callback.onFailure(call, error);
                                            }
                                        } catch (Throwable th) {
                                            e = th;
                                            ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall2 = this.this$0;
                                            Request request5 = call.request();
                                            Intrinsics.checkNotNullExpressionValue(request5, "call.request()");
                                            errorHandlingCall2.reportPerformance(request5, startTime, MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("http_code", String.valueOf(response.code())), TuplesKt.to(obj, this.this$0.safeErrorSummary(e))));
                                            if (!this.this$0.isCanceled()) {
                                                callback.onFailure(call, e);
                                            }
                                        }
                                    } else {
                                        if (!(serverError.getError().length() > 0)) {
                                            obj2 = "local_error_msg";
                                            error = new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, code, "invalid server error response", null), null, 2, null);
                                            ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall3 = this.this$0;
                                            Request request6 = call.request();
                                            Intrinsics.checkNotNullExpressionValue(request6, "call.request()");
                                            long j2 = startTime;
                                            Pair[] pairArr3 = new Pair[3];
                                            pairArr3[0] = TuplesKt.to("succeed", "0");
                                            pairArr3[1] = TuplesKt.to("http_code", String.valueOf(code));
                                            obj = obj2;
                                            pairArr3[2] = TuplesKt.to(obj, error.getMessage());
                                            errorHandlingCall3.reportPerformance(request6, j2, MapsKt.mapOf(pairArr3));
                                            if (!this.this$0.isCanceled()) {
                                                callback.onFailure(call, error);
                                            }
                                        } else {
                                            TapNetworkException.Err err = new TapNetworkException.Err(ApiErr.INSTANCE.from(serverError.getError()), serverError.getCode(), serverError.getMsg(), serverError.getDescription());
                                            if (Intrinsics.areEqual(err.getApiErr(), ApiErr.INVALID_TIME.INSTANCE) && baseResponse.getNow() > 0 && invalidTimeRetryCount == 0) {
                                                TapTime.INSTANCE.calibrateServerTime(Integer.valueOf(baseResponse.getNow()));
                                                ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall4 = this.this$0;
                                                Call<T> callM405clone = callToExecute.m405clone();
                                                Intrinsics.checkNotNullExpressionValue(callM405clone, "callToExecute.clone()");
                                                errorHandlingCall4.enqueue(callM405clone, callback, 1);
                                                return;
                                            }
                                            ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall5 = this.this$0;
                                            Request request7 = call.request();
                                            Intrinsics.checkNotNullExpressionValue(request7, "call.request()");
                                            long j3 = startTime;
                                            Pair[] pairArr4 = new Pair[3];
                                            pairArr4[0] = TuplesKt.to("succeed", "0");
                                            obj2 = "local_error_msg";
                                            pairArr4[1] = TuplesKt.to(TapErrorConstants.ERROR_SERVER_ERROR, serverError.getError());
                                            pairArr4[2] = TuplesKt.to("http_code", String.valueOf(code));
                                            errorHandlingCall5.reportPerformance(request7, j3, MapsKt.mapOf(pairArr4));
                                            if (!this.this$0.isCanceled()) {
                                                callback.onFailure(call, new TapNetworkException(err, null, 2, null));
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    e = th2;
                                    obj = obj2;
                                }
                            } catch (Throwable th3) {
                                e = th3;
                                obj = "local_error_msg";
                            }
                        } else {
                            ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall6 = this.this$0;
                            Request request8 = call.request();
                            Intrinsics.checkNotNullExpressionValue(request8, "call.request()");
                            errorHandlingCall6.reportPerformance(request8, startTime, MapsKt.mapOf(TuplesKt.to("succeed", "1")));
                            if (!this.this$0.isCanceled()) {
                                callback.onResponse(call, response);
                            }
                        }
                    }

                    @Override // com.taptap.sdk.retrofit2.Callback
                    public void onFailure(Call<T> call, Throwable error) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(error, "error");
                        if (this.this$0.isCanceled()) {
                            return;
                        }
                        ErrorHandlerCallFactory.ErrorHandlingCall<T> errorHandlingCall = this.this$0;
                        Request request4 = call.request();
                        Intrinsics.checkNotNullExpressionValue(request4, "call.request()");
                        errorHandlingCall.reportPerformance(request4, startTime, MapsKt.mapOf(TuplesKt.to("succeed", "0"), TuplesKt.to("local_error_msg", this.this$0.safeErrorSummary(error))));
                        if (!this.this$0.isCanceled()) {
                            callback.onFailure(call, error);
                        }
                    }
                });
            }
        }

        private final void reportTechnicalLog(Request request, String action, Map<String, String> properties) {
            OpenLogService openLogService;
            ITapOpenlog iTapOpenlogObtainOpenlog;
            Module module = getModule(request);
            if (module == null || (openLogService = getOpenLogService()) == null || (iTapOpenlogObtainOpenlog = openLogService.obtainOpenlog(module.name(), module.version())) == null) {
                return;
            }
            iTapOpenlogObtainOpenlog.reportTechnicalLog("core__" + action, properties);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void reportPerformance(Request request, long startTime, Map<String, String> properties) {
            Pair[] pairArr = new Pair[5];
            Module module = getModule(request);
            pairArr[0] = TuplesKt.to("module_name", module != null ? module.name() : null);
            Module module2 = getModule(request);
            pairArr[1] = TuplesKt.to(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, module2 != null ? module2.version() : null);
            pairArr[2] = TuplesKt.to("method", request.method());
            pairArr[3] = TuplesKt.to(d.p, String.valueOf(startTime));
            pairArr[4] = TuplesKt.to(d.q, String.valueOf(System.currentTimeMillis()));
            reportTechnicalLog(request, "http_performance", MapsKt.plus(properties, MapsKt.mapOf(pairArr)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String safeErrorSummary(Throwable error) {
            String simpleName = error.getClass().getSimpleName();
            if (simpleName.length() == 0) {
                simpleName = "UnknownError";
            }
            return simpleName;
        }

        private final Module getModule(Request request) {
            Method method;
            Class<?> declaringClass;
            Invocation invocation = (Invocation) request.tag(Invocation.class);
            if (invocation == null || (method = invocation.method()) == null || (declaringClass = method.getDeclaringClass()) == null) {
                return null;
            }
            return (Module) declaringClass.getAnnotation(Module.class);
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public void cancel() {
            synchronized (this.callLock) {
                this.canceled = true;
                this.activeCall.cancel();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public boolean isCanceled() {
            return this.canceled || this.activeCall.isCanceled();
        }

        @Override // com.taptap.sdk.retrofit2.Call
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Call<T> m405clone() {
            Call<T> callM405clone = this.delegate.m405clone();
            Intrinsics.checkNotNullExpressionValue(callM405clone, "delegate.clone()");
            return new ErrorHandlingCall(callM405clone);
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public Request request() {
            Request request = this.delegate.request();
            Intrinsics.checkNotNullExpressionValue(request, "delegate.request()");
            return request;
        }

        @Override // com.taptap.sdk.retrofit2.Call
        public Timeout timeout() {
            Timeout timeout = this.delegate.timeout();
            Intrinsics.checkNotNullExpressionValue(timeout, "delegate.timeout()");
            return timeout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BaseResponse parseBaseResponse(Response<T> response) throws TapNetworkException {
            BaseResponse baseResponse;
            int code = response.code();
            ResponseBody responseBodyErrorBody = response.errorBody();
            String errorBodyStr = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
            if (errorBodyStr == null) {
                errorBodyStr = "";
            }
            try {
                StringFormat $this$decodeFromString$iv = TapJson.INSTANCE.getJson();
                SerializersModule $this$serializer$iv$iv = $this$decodeFromString$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(BaseResponse.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                baseResponse = (BaseResponse) $this$decodeFromString$iv.decodeFromString(kSerializerSerializer, errorBodyStr);
            } catch (Exception e) {
                baseResponse = null;
            }
            BaseResponse baseResponse2 = baseResponse;
            if (!(baseResponse2 == null)) {
                return baseResponse2;
            }
            throw new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, response.code(), "parse errorBody fail, code: " + code, null), null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ErrResponse parseServerError(JsonElement data, int code) throws TapNetworkException {
            ErrResponse errResponse;
            try {
                Json $this$decodeFromJsonElement$iv = TapJson.INSTANCE.getJson();
                SerializersModule $this$serializer$iv$iv = $this$decodeFromJsonElement$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(ErrResponse.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                errResponse = (ErrResponse) $this$decodeFromJsonElement$iv.decodeFromJsonElement(kSerializerSerializer, data);
            } catch (Exception e) {
                errResponse = null;
            }
            ErrResponse serverError = errResponse;
            if (!(serverError == null)) {
                return serverError;
            }
            throw new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, code, "parse BaseResponse.data fail, code: " + code, null), null, 2, null);
        }
    }

    /* JADX INFO: compiled from: ErrorHandlerCallFactory.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/common/network/convert/ErrorHandlerCallFactory$Companion;", "", "()V", "create", "Lcom/taptap/sdk/retrofit2/CallAdapter$Factory;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CallAdapter.Factory create() {
            return new ErrorHandlerCallFactory(null);
        }
    }
}
