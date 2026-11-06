package com.taptap.sdk.common.network.interceptor;

import android.util.Log;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.Interceptor;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.RequestBody;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.okhttp3.ResponseBody;
import com.taptap.sdk.update.download.core.Util;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TapLogInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor;", "Lcom/taptap/sdk/okhttp3/Interceptor;", "enableLog", "", "level", "Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;", "(ZLcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;)V", "intercept", "Lcom/taptap/sdk/okhttp3/Response;", "chain", "Lcom/taptap/sdk/okhttp3/Interceptor$Chain;", "log", "", "message", "", "logException", "request", "Lcom/taptap/sdk/okhttp3/Request;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logRequest", "logResponse", AnalyticsConfig.RTD_START_TIME, "Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$LogTime;", "response", "safeHeaderValue", Common.System.NAME, Constants.VALUE_FIELD, "Companion", "Level", "LogTime", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapLogInterceptor implements Interceptor {
    private static final Set<String> SAFE_HEADER_NAMES = SetsKt.setOf((Object[]) new String[]{"accept", "accept-encoding", "cache-control", "content-length", "content-type", "user-agent"});
    private final boolean enableLog;
    private final Level level;

    /* JADX INFO: compiled from: TapLogInterceptor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;", "", "(Ljava/lang/String;I)V", "BASIC", "HEADERS", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Level {
        BASIC,
        HEADERS
    }

    public TapLogInterceptor(boolean enableLog, Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.enableLog = enableLog;
        this.level = level;
    }

    /* JADX INFO: compiled from: TapLogInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$LogTime;", "", "()V", "startNs", "", "tookMs", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LogTime {
        private final long startNs = System.nanoTime();

        public final long tookMs() {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        }
    }

    @Override // com.taptap.sdk.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Object objM534constructorimpl;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(request, "request");
            logRequest(request);
            Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        LogTime startTime = new LogTime();
        try {
            Response response = chain.proceed(request);
            Intrinsics.checkNotNullExpressionValue(response, "chain.proceed(request)");
            try {
                Result.Companion companion3 = Result.INSTANCE;
                logResponse(startTime, response);
                objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
            if (it != null) {
                TapLogger.logd("TapHttp", "logResponse error: " + it, it);
            }
            return response;
        } catch (Exception e) {
            Intrinsics.checkNotNullExpressionValue(request, "request");
            logException(request, e);
            throw e;
        }
    }

    private final void logException(Request request, Exception e) {
        StringBuilder builder = new StringBuilder("<------ HTTP FAILED: ");
        builder.append(request.method() + ' ').append(request.url().encodedPath());
        builder.append("\n").append(e.getClass().getSimpleName());
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        log(string);
    }

    private final void logRequest(Request request) {
        StringBuilder builder = new StringBuilder("------> ");
        builder.append(request.method() + ' ').append(request.url().encodedPath());
        RequestBody requestBody = request.body();
        boolean z = false;
        boolean hasRequestBody = requestBody != null;
        if (hasRequestBody) {
            builder.append(" (");
            builder.append(requestBody != null ? Long.valueOf(requestBody.contentLength()) : null);
            builder.append("-byte body)");
        }
        if (this.level == Level.BASIC) {
            if (hasRequestBody) {
                if ((requestBody != null ? requestBody.contentType() : null) != null) {
                    builder.append("\n").append("Content-Type: ").append(requestBody.contentType());
                }
                if (requestBody != null && requestBody.contentLength() == -1) {
                    z = true;
                }
                if (!z) {
                    builder.append("\n").append("Content-Length: ").append(requestBody != null ? Long.valueOf(requestBody.contentLength()) : null);
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (!StringsKt.equals("Content-Type", name, true) && !StringsKt.equals(Util.CONTENT_LENGTH, name, true)) {
                    StringBuilder sbAppend = builder.append("\n").append(name).append(": ");
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    String strValue = headers.value(i);
                    Intrinsics.checkNotNullExpressionValue(strValue, "headers.value(int)");
                    sbAppend.append(safeHeaderValue(name, strValue));
                }
            }
            if (hasRequestBody) {
                builder.append("\n------> END " + request.method() + " (" + (requestBody != null ? Long.valueOf(requestBody.contentLength()) : null) + "-byte body omitted)");
            } else {
                builder.append("\n------> END " + request.method());
            }
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        log(string);
    }

    private final void logResponse(LogTime startTime, Response response) {
        Request request = response.request();
        long requestCostMs = startTime.tookMs();
        ResponseBody responseBody = response.body();
        long contentLength = responseBody != null ? responseBody.contentLength() : -1L;
        Headers headers = response.headers();
        StringBuilder $this$logResponse_u24lambda_u243 = new StringBuilder("<------ " + response.code() + ' ' + request.url().encodedPath() + " (" + requestCostMs + "ms)");
        if (this.level == Level.BASIC) {
            int i = 0;
            int size = headers.size();
            while (i < size) {
                String name = headers.name(i);
                StringBuilder sbAppend = $this$logResponse_u24lambda_u243.append("\n").append(name).append(": ");
                Intrinsics.checkNotNullExpressionValue(name, "name");
                String strValue = headers.value(i);
                Intrinsics.checkNotNullExpressionValue(strValue, "headers.value(int)");
                sbAppend.append(safeHeaderValue(name, strValue));
                i++;
                request = request;
            }
        }
        if (this.level == Level.BASIC) {
            if (responseBody != null) {
                $this$logResponse_u24lambda_u243.append("\n<------ END HTTP (" + contentLength + "-byte body omitted)");
            } else {
                $this$logResponse_u24lambda_u243.append("\n<------ END HTTP");
            }
        }
        String string = $this$logResponse_u24lambda_u243.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        log(string);
    }

    private final String safeHeaderValue(String name, String value) {
        Set<String> set = SAFE_HEADER_NAMES;
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return set.contains(lowerCase) ? value : "<redacted>";
    }

    private final void log(String message) {
        if (this.enableLog) {
            Log.d("TapHttp", message);
        }
    }
}
