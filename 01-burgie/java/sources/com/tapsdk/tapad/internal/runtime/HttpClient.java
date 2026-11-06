package com.tapsdk.tapad.internal.runtime;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.tapsdk.tapad.b;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLException;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HttpClient {
    private static final MediaType BINARY = MediaType.parse("application/octet-stream");
    private static final String TAG = "HttpClient";
    private static volatile HttpClient sInstance;
    private ResponseCallback mCallback;
    private volatile OkHttpClient mClient;
    private final OkHttpClient mFireAndForgetClient;
    private final Object mControlledClientLock = new Object();
    private final ConcurrentHashMap<Integer, ActiveCall> mCalls = new ConcurrentHashMap<>();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.HttpClient$3, reason: invalid class name */
    public class AnonymousClass3 implements okhttp3.Callback {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ RequestTiming val$timing;
        final /* synthetic */ String val$url;

        public AnonymousClass3(String str, Callback callback, RequestTiming requestTiming) {
            this.val$url = str;
            this.val$callback = callback;
            this.val$timing = requestTiming;
        }

        static /* synthetic */ void lambda$onFailure$0(Callback callback, IOException iOException, RequestTiming requestTiming) {
            callback.onError(-1, iOException.getMessage());
            requestTiming.log("error", -1, 0, iOException.getMessage());
        }

        static /* synthetic */ void lambda$onResponse$1(Callback callback, byte[] bArr, RequestTiming requestTiming, Response response) {
            callback.onSuccess(bArr);
            requestTiming.log(TrackAction.SUCCESS, response.code(), bArr.length, null);
        }

        static /* synthetic */ void lambda$onResponse$2(Callback callback, Response response, RequestTiming requestTiming) {
            callback.onError(response.code(), response.message());
            requestTiming.log("error", response.code(), 0, response.message());
        }

        static /* synthetic */ void lambda$onResponse$3(Callback callback, IOException iOException, RequestTiming requestTiming) {
            callback.onError(-2, iOException.getMessage());
            requestTiming.log("error", -2, 0, iOException.getMessage());
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            if (this.val$callback != null) {
                Handler handler = HttpClient.this.mMainHandler;
                final Callback callback = this.val$callback;
                final RequestTiming requestTiming = this.val$timing;
                handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient$3$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        HttpClient.AnonymousClass3.lambda$onFailure$0(callback, iOException, requestTiming);
                    }
                });
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, final Response response) {
            try {
                if (response.isSuccessful() && response.body() != null) {
                    long jNanoTime = System.nanoTime();
                    final byte[] bArrBytes = response.body().bytes();
                    this.val$timing.bodyReadMs = HttpClient.elapsedMs(jNanoTime, System.nanoTime());
                    if (this.val$callback != null) {
                        Handler handler = HttpClient.this.mMainHandler;
                        final Callback callback = this.val$callback;
                        final RequestTiming requestTiming = this.val$timing;
                        handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient$3$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                HttpClient.AnonymousClass3.lambda$onResponse$1(callback, bArrBytes, requestTiming, response);
                            }
                        });
                    }
                } else if (this.val$callback != null) {
                    Handler handler2 = HttpClient.this.mMainHandler;
                    final Callback callback2 = this.val$callback;
                    final RequestTiming requestTiming2 = this.val$timing;
                    handler2.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            HttpClient.AnonymousClass3.lambda$onResponse$2(callback2, response, requestTiming2);
                        }
                    });
                }
            } catch (IOException e) {
                if (this.val$callback != null) {
                    Handler handler3 = HttpClient.this.mMainHandler;
                    final Callback callback3 = this.val$callback;
                    final RequestTiming requestTiming3 = this.val$timing;
                    handler3.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient$3$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            HttpClient.AnonymousClass3.lambda$onResponse$3(callback3, e, requestTiming3);
                        }
                    });
                }
            } finally {
                response.close();
            }
        }
    }

    public static final class ActiveCall {
        final Call call;
        final OkHttpClient client;
        final RequestTiming timing;

        public ActiveCall(Call call, OkHttpClient okHttpClient, RequestTiming requestTiming) {
            this.call = call;
            this.client = okHttpClient;
            this.timing = requestTiming;
        }
    }

    public interface Callback {
        void onError(int i, String str);

        void onSuccess(byte[] bArr);
    }

    public static final class RequestTiming {
        volatile long callStartNs;
        volatile long connectStartNs;
        volatile boolean connectionAcquired;
        volatile long dnsStartNs;
        volatile long enqueuedNs;
        volatile long requestBodyEndNs;
        volatile long requestBodyStartNs;
        volatile long requestHeadersEndNs;
        volatile long requestHeadersStartNs;
        final int requestId;
        volatile long responseBodyStartNs;
        volatile long responseHeadersStartNs;
        volatile long secureConnectStartNs;
        final String url;
        volatile long queueMs = -1;
        volatile long dnsMs = -1;
        volatile long connectMs = -1;
        volatile long tlsMs = -1;
        volatile long requestHeadersMs = -1;
        volatile long requestBodyMs = -1;
        volatile long serverWaitMs = -1;
        volatile long responseHeadersMs = -1;
        volatile long responseBodyMs = -1;
        volatile long bodyReadMs = -1;
        volatile long mainDelayMs = -1;
        volatile long callbackDispatchMs = -1;
        volatile long totalCallMs = -1;
        volatile String connectionId = "na";
        volatile String protocol = "na";
        final AtomicBoolean logEmitted = new AtomicBoolean(false);

        public RequestTiming(int i, String str) {
            this.requestId = i;
            this.url = str;
        }

        private void finishInFlightTiming(long j) {
            if (this.totalCallMs < 0) {
                this.totalCallMs = HttpClient.elapsedMs(this.callStartNs, j);
            }
            if (this.responseHeadersStartNs > 0 && this.responseHeadersMs < 0) {
                this.responseHeadersMs = HttpClient.elapsedMs(this.responseHeadersStartNs, j);
                this.serverWaitMs = HttpClient.elapsedMs(this.requestBodyEndNs > 0 ? this.requestBodyEndNs : this.requestHeadersEndNs, j);
                return;
            }
            if (this.requestBodyStartNs > 0 && this.requestBodyMs < 0) {
                this.requestBodyMs = HttpClient.elapsedMs(this.requestBodyStartNs, j);
                return;
            }
            if (this.requestHeadersStartNs > 0 && this.requestHeadersMs < 0) {
                this.requestHeadersMs = HttpClient.elapsedMs(this.requestHeadersStartNs, j);
                return;
            }
            if (this.secureConnectStartNs > 0 && this.tlsMs < 0) {
                this.tlsMs = HttpClient.elapsedMs(this.secureConnectStartNs, j);
                return;
            }
            if (this.connectStartNs > 0 && this.connectMs < 0) {
                this.connectMs = HttpClient.elapsedMs(this.connectStartNs, j);
            } else {
                if (this.dnsStartNs <= 0 || this.dnsMs >= 0) {
                    return;
                }
                this.dnsMs = HttpClient.elapsedMs(this.dnsStartNs, j);
            }
        }

        private String stage() {
            if (this.responseBodyStartNs > 0) {
                return "response_body";
            }
            if (this.responseHeadersStartNs > 0) {
                return "response_headers";
            }
            if (this.requestBodyStartNs > 0) {
                return "request_body";
            }
            if (this.requestHeadersStartNs > 0) {
                return "request_headers";
            }
            if (this.secureConnectStartNs > 0) {
                return LiveConfigKey.TLS;
            }
            if (this.connectStartNs > 0) {
                return "connect";
            }
            if (this.dnsStartNs > 0) {
                return "dns";
            }
            return this.callStartNs > 0 ? NotificationCompat.CATEGORY_CALL : "enqueued";
        }

        public void log(String str, int i, int i2, String str2) {
            if (this.logEmitted.compareAndSet(false, true)) {
                finishInFlightTiming(System.nanoTime());
                HttpClient.ms(this.totalCallMs);
                HttpClient.ms(this.queueMs);
                HttpClient.ms(this.dnsMs);
                HttpClient.ms(this.connectMs);
                HttpClient.ms(this.tlsMs);
                HttpClient.ms(this.requestHeadersMs);
                HttpClient.ms(this.requestBodyMs);
                HttpClient.ms(this.serverWaitMs);
                HttpClient.ms(this.responseHeadersMs);
                HttpClient.ms(this.responseBodyMs);
                HttpClient.ms(this.bodyReadMs);
                HttpClient.ms(this.mainDelayMs);
                HttpClient.ms(this.callbackDispatchMs);
                stage();
                if (str2 != null) {
                    " error=".concat(str2);
                }
            }
        }

        public void logCancelled(String str) {
            log("cancelled", 0, 0, str);
        }

        public void markEnqueued() {
            this.enqueuedNs = System.nanoTime();
        }
    }

    public interface ResponseCallback {
        void onComplete(int i, int i2, int i3, String str, byte[] bArr);
    }

    public static final class TimingEventListener extends EventListener {
        private final RequestTiming timing;

        public TimingEventListener(RequestTiming requestTiming) {
            this.timing = requestTiming;
        }

        @Override // okhttp3.EventListener
        public void callEnd(Call call) {
            RequestTiming requestTiming = this.timing;
            requestTiming.totalCallMs = HttpClient.elapsedMs(requestTiming.callStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void callFailed(Call call, IOException iOException) {
            RequestTiming requestTiming = this.timing;
            requestTiming.totalCallMs = HttpClient.elapsedMs(requestTiming.callStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void callStart(Call call) {
            long jNanoTime = System.nanoTime();
            this.timing.callStartNs = jNanoTime;
            RequestTiming requestTiming = this.timing;
            requestTiming.queueMs = HttpClient.elapsedMs(requestTiming.enqueuedNs, jNanoTime);
        }

        @Override // okhttp3.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            RequestTiming requestTiming = this.timing;
            requestTiming.connectMs = HttpClient.elapsedMs(requestTiming.connectStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            RequestTiming requestTiming = this.timing;
            requestTiming.connectMs = HttpClient.elapsedMs(requestTiming.connectStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            this.timing.connectStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            this.timing.connectionAcquired = true;
            this.timing.connectionId = Integer.toHexString(System.identityHashCode(connection));
            this.timing.protocol = connection.protocol().toString();
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            RequestTiming requestTiming = this.timing;
            requestTiming.dnsMs = HttpClient.elapsedMs(requestTiming.dnsStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void dnsStart(Call call, String str) {
            this.timing.dnsStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void requestBodyEnd(Call call, long j) {
            long jNanoTime = System.nanoTime();
            this.timing.requestBodyEndNs = jNanoTime;
            RequestTiming requestTiming = this.timing;
            requestTiming.requestBodyMs = HttpClient.elapsedMs(requestTiming.requestBodyStartNs, jNanoTime);
        }

        @Override // okhttp3.EventListener
        public void requestBodyStart(Call call) {
            this.timing.requestBodyStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void requestHeadersEnd(Call call, Request request) {
            long jNanoTime = System.nanoTime();
            this.timing.requestHeadersEndNs = jNanoTime;
            RequestTiming requestTiming = this.timing;
            requestTiming.requestHeadersMs = HttpClient.elapsedMs(requestTiming.requestHeadersStartNs, jNanoTime);
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(Call call) {
            this.timing.requestHeadersStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void responseBodyEnd(Call call, long j) {
            RequestTiming requestTiming = this.timing;
            requestTiming.responseBodyMs = HttpClient.elapsedMs(requestTiming.responseBodyStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void responseBodyStart(Call call) {
            this.timing.responseBodyStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(Call call, Response response) {
            long jNanoTime = System.nanoTime();
            this.timing.serverWaitMs = HttpClient.elapsedMs(this.timing.requestBodyEndNs > 0 ? this.timing.requestBodyEndNs : this.timing.requestHeadersEndNs, jNanoTime);
            RequestTiming requestTiming = this.timing;
            requestTiming.responseHeadersMs = HttpClient.elapsedMs(requestTiming.responseHeadersStartNs, jNanoTime);
        }

        @Override // okhttp3.EventListener
        public void responseHeadersStart(Call call) {
            this.timing.responseHeadersStartNs = System.nanoTime();
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
            RequestTiming requestTiming = this.timing;
            requestTiming.tlsMs = HttpClient.elapsedMs(requestTiming.secureConnectStartNs, System.nanoTime());
        }

        @Override // okhttp3.EventListener
        public void secureConnectStart(Call call) {
            this.timing.secureConnectStartNs = System.nanoTime();
        }
    }

    public HttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        OkHttpClient.Builder builderEventListenerFactory = builder.connectionPool(new ConnectionPool(5, 5L, timeUnit)).eventListenerFactory(new EventListener.Factory() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient.1
            @Override // okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                Object objTag = call.request().tag();
                return objTag instanceof RequestTiming ? new TimingEventListener((RequestTiming) objTag) : new EventListener() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient.1.1
                };
            }
        });
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        this.mClient = builderEventListenerFactory.connectTimeout(12L, timeUnit2).readTimeout(25L, timeUnit2).writeTimeout(25L, timeUnit2).retryOnConnectionFailure(false).followRedirects(false).followSslRedirects(false).build();
        this.mFireAndForgetClient = this.mClient.newBuilder().connectionPool(new ConnectionPool(5, 5L, timeUnit)).callTimeout(35L, timeUnit2).retryOnConnectionFailure(true).followRedirects(true).followSslRedirects(true).build();
    }

    private void addHeaders(Request.Builder builder, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                builder.addHeader(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
        }
    }

    private void cancelActiveCall(ActiveCall activeCall, String str) {
        if (activeCall == null) {
            return;
        }
        activeCall.timing.logCancelled(str);
        activeCall.call.cancel();
        evictRetiredClientIfIdle(activeCall.client);
    }

    public static int classifyTransportError(IOException iOException, boolean z) {
        if (z) {
            return 5;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if (cause instanceof SocketTimeoutException) {
                return 2;
            }
            if ((cause instanceof InterruptedIOException) && containsTimeout(cause.getMessage())) {
                return 2;
            }
            if (cause instanceof UnknownHostException) {
                return 3;
            }
            if (cause instanceof SSLException) {
                return 4;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean completePhysicalCall(int i, ActiveCall activeCall) {
        if (shouldDispatchResponse(i)) {
            return activeCall != null && this.mCalls.remove(Integer.valueOf(i), activeCall);
        }
        return true;
    }

    private static boolean containsTimeout(String str) {
        return str != null && str.toLowerCase(Locale.US).contains("timeout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long elapsedMs(long j, long j2) {
        if (j <= 0 || j2 <= 0 || j2 < j) {
            return -1L;
        }
        return TimeUnit.NANOSECONDS.toMillis(j2 - j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evictRetiredClientIfIdle(OkHttpClient okHttpClient) {
        if (okHttpClient == null || okHttpClient == this.mClient) {
            return;
        }
        okHttpClient.connectionPool().evictAll();
    }

    private void executeRequest(final int i, final Request request, final RequestTiming requestTiming) {
        OkHttpClient okHttpClient;
        final ActiveCall activeCall;
        Call callNewCall;
        ActiveCall activeCallRemove;
        OkHttpClient okHttpClientRotateControlledClientLocked;
        Call callNewCall2;
        ActiveCall activeCall2;
        requestTiming.markEnqueued();
        ActiveCall activeCall3 = null;
        if (shouldDispatchResponse(i)) {
            synchronized (this.mControlledClientLock) {
                activeCallRemove = this.mCalls.remove(Integer.valueOf(i));
                okHttpClientRotateControlledClientLocked = activeCallRemove != null ? rotateControlledClientLocked(activeCallRemove.client) : null;
                OkHttpClient okHttpClient2 = this.mClient;
                callNewCall2 = okHttpClient2.newCall(request);
                activeCall2 = new ActiveCall(callNewCall2, okHttpClient2, requestTiming);
                this.mCalls.put(Integer.valueOf(i), activeCall2);
            }
            okHttpClient = okHttpClientRotateControlledClientLocked;
            activeCall3 = activeCallRemove;
            callNewCall = callNewCall2;
            activeCall = activeCall2;
        } else {
            okHttpClient = null;
            activeCall = null;
            callNewCall = this.mFireAndForgetClient.newCall(request);
        }
        if (activeCall3 != null) {
            cancelActiveCall(activeCall3, "superseded_callback_token");
        }
        if (okHttpClient != null) {
            evictRetiredClientIfIdle(okHttpClient);
        }
        callNewCall.enqueue(new okhttp3.Callback() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpClient okHttpClient3 = null;
                try {
                    Objects.toString(request.url());
                    if (HttpClient.this.completePhysicalCall(i, activeCall)) {
                        HttpClient.this.postComplete(i, HttpClient.classifyTransportError(iOException, call.isCanceled()), 0, "", new byte[0], requestTiming, iOException.getMessage());
                    }
                } finally {
                    HttpClient httpClient = HttpClient.this;
                    ActiveCall activeCall4 = activeCall;
                    httpClient.evictRetiredClientIfIdle(activeCall4 != null ? activeCall4.client : null);
                }
            }

            /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    try {
                        int iCode = response.code();
                        if (!HttpClient.shouldDispatchResponse(i)) {
                            response.close();
                            HttpClient httpClient = HttpClient.this;
                            ActiveCall activeCall4 = activeCall;
                            httpClient.evictRetiredClientIfIdle(activeCall4 != null ? activeCall4.client : null);
                            return;
                        }
                        long jNanoTime = System.nanoTime();
                        byte[] bArrBytes = response.body() != null ? response.body().bytes() : new byte[0];
                        requestTiming.bodyReadMs = HttpClient.elapsedMs(jNanoTime, System.nanoTime());
                        if (!HttpClient.this.completePhysicalCall(i, activeCall)) {
                            response.close();
                            HttpClient httpClient2 = HttpClient.this;
                            ActiveCall activeCall5 = activeCall;
                            httpClient2.evictRetiredClientIfIdle(activeCall5 != null ? activeCall5.client : null);
                            return;
                        }
                        HttpClient.this.postComplete(i, 0, iCode, response.header("Location", ""), bArrBytes, requestTiming, null);
                        response.close();
                        HttpClient httpClient3 = HttpClient.this;
                        ActiveCall activeCall6 = activeCall;
                        httpClient3.evictRetiredClientIfIdle(activeCall6 != null ? activeCall6.client : null);
                        return;
                    } catch (IOException e) {
                        if (!HttpClient.this.completePhysicalCall(i, activeCall)) {
                            response.close();
                            HttpClient httpClient4 = HttpClient.this;
                            ActiveCall activeCall7 = activeCall;
                            httpClient4.evictRetiredClientIfIdle(activeCall7 != null ? activeCall7.client : null);
                            return;
                        }
                        HttpClient.this.postComplete(i, HttpClient.classifyTransportError(e, call.isCanceled()), 0, "", new byte[0], requestTiming, e.getMessage());
                        response.close();
                        HttpClient httpClient5 = HttpClient.this;
                        ActiveCall activeCall8 = activeCall;
                        httpClient5.evictRetiredClientIfIdle(activeCall8 != null ? activeCall8.client : null);
                        return;
                    }
                } catch (Throwable th) {
                    response.close();
                    HttpClient httpClient6 = HttpClient.this;
                    ActiveCall activeCall9 = activeCall;
                    httpClient6.evictRetiredClientIfIdle(activeCall9 != null ? activeCall9.client : null);
                    throw th;
                }
                response.close();
                HttpClient httpClient7 = HttpClient.this;
                ActiveCall activeCall10 = activeCall;
                httpClient7.evictRetiredClientIfIdle(activeCall10 != null ? activeCall10.client : null);
                throw th;
            }
        });
    }

    private static String getHeaderValue(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.equalsIgnoreCase(str2)) {
                        return jSONObject.optString(next, null);
                    }
                }
                return null;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static HttpClient getInstance() {
        if (sInstance == null) {
            synchronized (HttpClient.class) {
                if (sInstance == null) {
                    sInstance = new HttpClient();
                }
            }
        }
        return sInstance;
    }

    static /* synthetic */ void lambda$postComplete$0(RequestTiming requestTiming, long j, ResponseCallback responseCallback, int i, int i2, int i3, String str, byte[] bArr, String str2) {
        long jNanoTime = System.nanoTime();
        requestTiming.mainDelayMs = elapsedMs(j, jNanoTime);
        responseCallback.onComplete(i, i2, i3, str != null ? str : "", bArr);
        requestTiming.callbackDispatchMs = elapsedMs(jNanoTime, System.nanoTime());
        requestTiming.log(i2 == 0 ? "response" : "error", i3, bArr.length, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ms(long j) {
        return j >= 0 ? Long.toString(j) : "na";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postComplete(final int i, final int i2, final int i3, final String str, byte[] bArr, final RequestTiming requestTiming, final String str2) {
        final ResponseCallback responseCallback = this.mCallback;
        if (!shouldDispatchResponse(i) || responseCallback == null) {
            return;
        }
        final byte[] bArr2 = bArr != null ? bArr : new byte[0];
        final long jNanoTime = System.nanoTime();
        this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.HttpClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HttpClient.lambda$postComplete$0(requestTiming, jNanoTime, responseCallback, i, i2, i3, str, bArr2, str2);
            }
        });
    }

    private OkHttpClient rotateControlledClientLocked(OkHttpClient okHttpClient) {
        if (okHttpClient == null || okHttpClient != this.mClient) {
            return null;
        }
        OkHttpClient okHttpClient2 = this.mClient;
        this.mClient = okHttpClient2.newBuilder().connectionPool(new ConnectionPool(5, 5L, TimeUnit.MINUTES)).build();
        return okHttpClient2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldDispatchResponse(int i) {
        return i > 0;
    }

    public int cancel(int i) {
        synchronized (this.mControlledClientLock) {
            ActiveCall activeCallRemove = this.mCalls.remove(Integer.valueOf(i));
            if (activeCallRemove == null) {
                return 0;
            }
            OkHttpClient okHttpClientRotateControlledClientLocked = rotateControlledClientLocked(activeCallRemove.client);
            cancelActiveCall(activeCallRemove, "core_cancel");
            evictRetiredClientIfIdle(okHttpClientRotateControlledClientLocked);
            return 1;
        }
    }

    public void cancelAll() {
        ArrayList arrayList;
        synchronized (this.mControlledClientLock) {
            arrayList = new ArrayList(this.mCalls.values());
            this.mCalls.clear();
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            cancelActiveCall((ActiveCall) obj, "client_shutdown");
        }
        this.mClient.dispatcher().cancelAll();
        this.mFireAndForgetClient.dispatcher().cancelAll();
    }

    public void get(int i, String str, String str2) {
        request(i, 0, str, str2, null);
    }

    public void post(int i, String str, String str2, String str3) {
        request(i, 1, str, str2, str3 != null ? str3.getBytes(StandardCharsets.UTF_8) : new byte[0]);
    }

    public void request(int i, int i2, String str, String str2, byte[] bArr) {
        RequestTiming requestTiming = new RequestTiming(i, str);
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            builderUrl.tag(requestTiming);
            if (i2 == 0) {
                builderUrl.get();
            } else {
                if (i2 != 1) {
                    ResponseCallback responseCallback = this.mCallback;
                    if (!shouldDispatchResponse(i) || responseCallback == null) {
                        return;
                    }
                    postComplete(i, 6, 0, "", new byte[0], requestTiming, b.a("Unsupported HTTP method: ", i2));
                    return;
                }
                String headerValue = getHeaderValue(str2, "Content-Type");
                if (headerValue == null || headerValue.isEmpty()) {
                    headerValue = "application/octet-stream";
                }
                MediaType mediaType = MediaType.parse(headerValue);
                if (bArr == null) {
                    bArr = new byte[0];
                }
                builderUrl.post(RequestBody.create(mediaType, bArr));
            }
            addHeaders(builderUrl, str2);
            executeRequest(i, builderUrl.build(), requestTiming);
        } catch (IllegalArgumentException e) {
            postComplete(i, 6, 0, "", new byte[0], requestTiming, e.getMessage());
        }
    }

    public void setCallback(ResponseCallback responseCallback) {
        this.mCallback = responseCallback;
    }

    public void shutdown() {
        cancelAll();
        this.mClient.connectionPool().evictAll();
        this.mFireAndForgetClient.connectionPool().evictAll();
    }

    public void post(String str, byte[] bArr, Callback callback) {
        MediaType mediaType = BINARY;
        if (bArr == null) {
            bArr = new byte[0];
        }
        RequestBody requestBodyCreate = RequestBody.create(mediaType, bArr);
        RequestTiming requestTiming = new RequestTiming(0, str);
        Request requestBuild = new Request.Builder().url(str).post(requestBodyCreate).addHeader("Content-Type", "application/octet-stream").addHeader("Content-Encoding", "tap_cryptor").tag(requestTiming).build();
        requestTiming.markEnqueued();
        this.mFireAndForgetClient.newCall(requestBuild).enqueue(new AnonymousClass3(str, callback, requestTiming));
    }
}
