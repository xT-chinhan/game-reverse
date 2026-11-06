package com.tapsdk.tapad.internal.t;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class e implements Interceptor {
    private final a a;

    public e(a aVar) {
        this.a = aVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String strB;
        Request request = chain.request();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null) {
            return chain.proceed(request);
        }
        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
        if (this.a == null) {
            throw new IllegalArgumentException("No encryption strategy");
        }
        if (request.body() == null || request.body().contentType() == null || !request.body().contentType().toString().equals("application/x-protobuf")) {
            try {
                strB = this.a.b(com.tapsdk.tapad.internal.t.f.b.b(requestBodyBody));
            } catch (Exception unused) {
                throw new RuntimeException("encrypt fail");
            }
        } else {
            mediaType = MediaType.parse("application/x-protobuf");
            try {
                strB = this.a.a(com.tapsdk.tapad.internal.t.f.b.a(requestBodyBody));
            } catch (Exception e) {
                String str = e.getCause() != null ? "" + e.getCause() : "";
                if (e.getMessage() != null) {
                    if (str.length() > 0) {
                        str = str + " ";
                    }
                    str = str + e.getMessage();
                }
                throw new RuntimeException("encrypt fail:" + str);
            }
        }
        RequestBody requestBodyCreate = RequestBody.create(mediaType, strB);
        Request.Builder builderNewBuilder = request.newBuilder();
        ((request.body() == null || request.body().contentType() == null || !request.body().contentType().toString().equals("application/x-protobuf")) ? builderNewBuilder.header("Content-Type", "text/plain; charset=utf-8").header("Content-Length", String.valueOf(requestBodyCreate.contentLength())) : builderNewBuilder.header("Content-Type", "application/x-protobuf").header("Content-Encoding", "tap_cryptor")).method(request.method(), requestBodyCreate);
        return chain.proceed(builderNewBuilder.build());
    }
}
