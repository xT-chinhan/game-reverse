package com.taptap.sdk.okhttp3.internal.connection;

import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.okhttp3.Interceptor;
import com.taptap.sdk.okhttp3.OkHttpClient;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.okhttp3.internal.http.HttpCodec;
import com.taptap.sdk.okhttp3.internal.http.RealInterceptorChain;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient client) {
        this.client = client;
    }

    @Override // com.taptap.sdk.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request();
        StreamAllocation streamAllocation = realChain.streamAllocation();
        boolean doExtensiveHealthChecks = !request.method().equals(TapHttp.METHOD_GET);
        HttpCodec httpCodec = streamAllocation.newStream(this.client, chain, doExtensiveHealthChecks);
        RealConnection connection = streamAllocation.connection();
        return realChain.proceed(request, streamAllocation, httpCodec, connection);
    }
}
