package okhttp3.internal.http;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient client, boolean forWebSocket) {
        this.client = client;
        this.forWebSocket = forWebSocket;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object callStackTrace) {
        this.callStackTrace = callStackTrace;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0160  */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realChain;
        Request request = chain.request();
        RealInterceptorChain realChain2 = (RealInterceptorChain) chain;
        Call call = realChain2.call();
        EventListener eventListener = realChain2.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        int followUpCount = 0;
        Request request2 = request;
        StreamAllocation streamAllocation2 = streamAllocation;
        Response priorResponse = null;
        while (!this.canceled) {
            try {
                Response response = realChain2.proceed(request2, streamAllocation2, null, null);
                if (0 != 0) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                }
                Response response2 = priorResponse != null ? response.newBuilder().priorResponse(priorResponse.newBuilder().body(null).build()).build() : response;
                try {
                    Request followUp = followUpRequest(response2, streamAllocation2.route());
                    if (followUp == null) {
                        streamAllocation2.release();
                        return response2;
                    }
                    Util.closeQuietly(response2.body());
                    int followUpCount2 = followUpCount + 1;
                    if (followUpCount2 > 20) {
                        streamAllocation2.release();
                        throw new ProtocolException("Too many follow-up requests: " + followUpCount2);
                    }
                    if (followUp.body() instanceof UnrepeatableRequestBody) {
                        streamAllocation2.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", response2.code());
                    }
                    if (!sameConnection(response2, followUp.url())) {
                        streamAllocation2.release();
                        StreamAllocation streamAllocation3 = new StreamAllocation(this.client.connectionPool(), createAddress(followUp.url()), call, eventListener, this.callStackTrace);
                        this.streamAllocation = streamAllocation3;
                        streamAllocation2 = streamAllocation3;
                    } else if (streamAllocation2.codec() != null) {
                        throw new IllegalStateException("Closing the body of " + response2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    request2 = followUp;
                    priorResponse = response2;
                    followUpCount = followUpCount2;
                    realChain2 = realChain2;
                } catch (IOException e) {
                    streamAllocation2.release();
                    throw e;
                }
            } catch (IOException e2) {
                realChain = realChain2;
                try {
                    boolean requestSendStarted = e2 instanceof ConnectionShutdownException ? false : true;
                    if (!recover(e2, streamAllocation2, requestSendStarted, request2)) {
                        throw e2;
                    }
                    if (0 != 0) {
                        streamAllocation2.streamFailed(null);
                        streamAllocation2.release();
                    }
                    realChain2 = realChain;
                } catch (Throwable th) {
                    e = th;
                    if (1 != 0) {
                        streamAllocation2.streamFailed(null);
                        streamAllocation2.release();
                    }
                    throw e;
                }
            } catch (RouteException e3) {
                realChain = realChain2;
                if (!recover(e3.getLastConnectException(), streamAllocation2, false, request2)) {
                    throw e3.getFirstConnectException();
                }
                if (0 != 0) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                }
                realChain2 = realChain;
            } catch (Throwable th2) {
                e = th2;
                if (1 != 0) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                }
                throw e;
            }
        }
        streamAllocation2.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl url) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (url.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        return new Address(url.host(), url.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(IOException e, StreamAllocation streamAllocation, boolean requestSendStarted, Request userRequest) {
        streamAllocation.streamFailed(e);
        if (this.client.retryOnConnectionFailure()) {
            return !(requestSendStarted && (userRequest.body() instanceof UnrepeatableRequestBody)) && isRecoverable(e, requestSendStarted) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private boolean isRecoverable(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return (e instanceof SocketTimeoutException) && !requestSendStarted;
        }
        return (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private Request followUpRequest(Response userResponse, Route route) throws IOException {
        String location;
        HttpUrl url;
        Proxy selectedProxy;
        if (userResponse == null) {
            throw new IllegalStateException();
        }
        int responseCode = userResponse.code();
        String method = userResponse.request().method();
        switch (responseCode) {
            case TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX /* 300 */:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!method.equals(TapHttp.METHOD_GET) && !method.equals(com.taptap.sdk.update.download.core.Util.METHOD_HEAD)) {
                    return null;
                }
                break;
            case 401:
                return this.client.authenticator().authenticate(route, userResponse);
            case 407:
                if (route != null) {
                    selectedProxy = route.proxy();
                } else {
                    selectedProxy = this.client.proxy();
                }
                if (selectedProxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, userResponse);
            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                if (!this.client.retryOnConnectionFailure() || (userResponse.request().body() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((userResponse.priorResponse() == null || userResponse.priorResponse().code() != 408) && retryAfter(userResponse, 0) <= 0) {
                    return userResponse.request();
                }
                return null;
            case 503:
                if ((userResponse.priorResponse() == null || userResponse.priorResponse().code() != 503) && retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.request();
                }
                return null;
            default:
                return null;
        }
        if (!this.client.followRedirects() || (location = userResponse.header("Location")) == null || (url = userResponse.request().url().resolve(location)) == null) {
            return null;
        }
        boolean sameScheme = url.scheme().equals(userResponse.request().url().scheme());
        if (!sameScheme && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder requestBuilder = userResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            boolean maintainBody = HttpMethod.redirectsWithBody(method);
            if (HttpMethod.redirectsToGet(method)) {
                requestBuilder.method(TapHttp.METHOD_GET, null);
            } else {
                RequestBody requestBody = maintainBody ? userResponse.request().body() : null;
                requestBuilder.method(method, requestBody);
            }
            if (!maintainBody) {
                requestBuilder.removeHeader(com.taptap.sdk.update.download.core.Util.TRANSFER_ENCODING);
                requestBuilder.removeHeader(com.taptap.sdk.update.download.core.Util.CONTENT_LENGTH);
                requestBuilder.removeHeader("Content-Type");
            }
        }
        if (!sameConnection(userResponse, url)) {
            requestBuilder.removeHeader("Authorization");
        }
        return requestBuilder.url(url).build();
    }

    private int retryAfter(Response userResponse, int defaultDelay) {
        String header = userResponse.header("Retry-After");
        if (header == null) {
            return defaultDelay;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl followUp) {
        HttpUrl url = response.request().url();
        return url.host().equals(followUp.host()) && url.port() == followUp.port() && url.scheme().equals(followUp.scheme());
    }
}
