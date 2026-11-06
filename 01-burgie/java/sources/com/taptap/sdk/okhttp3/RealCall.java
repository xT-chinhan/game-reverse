package com.taptap.sdk.okhttp3;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.okhttp3.internal.NamedRunnable;
import com.taptap.sdk.okhttp3.internal.cache.CacheInterceptor;
import com.taptap.sdk.okhttp3.internal.connection.ConnectInterceptor;
import com.taptap.sdk.okhttp3.internal.connection.StreamAllocation;
import com.taptap.sdk.okhttp3.internal.http.BridgeInterceptor;
import com.taptap.sdk.okhttp3.internal.http.CallServerInterceptor;
import com.taptap.sdk.okhttp3.internal.http.RealInterceptorChain;
import com.taptap.sdk.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import com.taptap.sdk.okhttp3.internal.platform.Platform;
import com.taptap.sdk.okio.AsyncTimeout;
import com.taptap.sdk.okio.Timeout;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class RealCall implements Call {
    final OkHttpClient client;

    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    private RealCall(OkHttpClient client, Request originalRequest, boolean forWebSocket) {
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = forWebSocket;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(client, forWebSocket);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: com.taptap.sdk.okhttp3.RealCall.1
            @Override // com.taptap.sdk.okio.AsyncTimeout
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient client, Request originalRequest, boolean forWebSocket) {
        RealCall call = new RealCall(client, originalRequest, forWebSocket);
        call.eventListener = client.eventListenerFactory().create(call);
        return call;
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response result = getResponseWithInterceptorChain();
                if (result == null) {
                    throw new IOException("Canceled");
                }
                this.client.dispatcher().finished(this);
                return result;
            } catch (IOException e) {
                IOException e2 = timeoutExit(e);
                this.eventListener.callFailed(this, e2);
                throw e2;
            }
        } catch (Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
        this.client.dispatcher().finished(this);
        throw th;
    }

    @Nullable
    IOException timeoutExit(@Nullable IOException cause) {
        if (!this.timeout.exit()) {
            return cause;
        }
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    private void captureCallStackTrace() {
        Object callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.retryAndFollowUpInterceptor.setCallStackTrace(callStackTrace);
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public void enqueue(Callback responseCallback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(responseCallback));
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public Timeout timeout() {
        return this.timeout;
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // com.taptap.sdk.okhttp3.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // com.taptap.sdk.okhttp3.Call
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RealCall m426clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        AsyncCall(Callback responseCallback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = responseCallback;
        }

        String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        RealCall get() {
            return RealCall.this;
        }

        void executeOn(ExecutorService executorService) {
            boolean success = false;
            try {
                executorService.execute(this);
                success = true;
            } catch (RejectedExecutionException e) {
                InterruptedIOException ioException = new InterruptedIOException("executor rejected");
                ioException.initCause(e);
                RealCall.this.eventListener.callFailed(RealCall.this, ioException);
                this.responseCallback.onFailure(RealCall.this, ioException);
            } finally {
                if (!success) {
                    RealCall.this.client.dispatcher().finished(this);
                }
            }
        }

        @Override // com.taptap.sdk.okhttp3.internal.NamedRunnable
        protected void execute() {
            boolean signalledCallback = false;
            RealCall.this.timeout.enter();
            try {
                Response response = RealCall.this.getResponseWithInterceptorChain();
                if (RealCall.this.retryAndFollowUpInterceptor.isCanceled()) {
                    signalledCallback = true;
                    this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                } else {
                    signalledCallback = true;
                    this.responseCallback.onResponse(RealCall.this, response);
                }
            } catch (IOException e) {
                IOException e2 = RealCall.this.timeoutExit(e);
                if (!signalledCallback) {
                    RealCall.this.eventListener.callFailed(RealCall.this, e2);
                    this.responseCallback.onFailure(RealCall.this, e2);
                } else {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e2);
                }
            } finally {
                RealCall.this.client.dispatcher().finished(this);
            }
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.addAll(this.client.interceptors());
        interceptors.add(this.retryAndFollowUpInterceptor);
        interceptors.add(new BridgeInterceptor(this.client.cookieJar()));
        interceptors.add(new CacheInterceptor(this.client.internalCache()));
        interceptors.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            interceptors.addAll(this.client.networkInterceptors());
        }
        interceptors.add(new CallServerInterceptor(this.forWebSocket));
        Interceptor.Chain chain = new RealInterceptorChain(interceptors, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        return chain.proceed(this.originalRequest);
    }
}
