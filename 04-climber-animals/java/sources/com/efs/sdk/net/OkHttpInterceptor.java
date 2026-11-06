package com.efs.sdk.net;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import com.efs.sdk.net.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpInterceptor implements Interceptor {
    private final f a = g.b();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        boolean z;
        h hVar;
        h hVar2;
        boolean zEnableTracer;
        String str2;
        MediaType mediaTypeContentType;
        InputStream inputStreamByteStream;
        Request request = chain.request();
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            zEnableTracer = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
            if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                if (request != null) {
                    Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                } else {
                    Log.d("NetTrace-Interceptor", "intercept request is null~");
                }
                com.efs.sdk.net.a.f fVarA = e.a(chain.call());
                str2 = fVarA != null ? fVarA.a : "unknown";
                try {
                    Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(str2)));
                    com.efs.sdk.net.a.a.a().a(str2).c = request.url().toString();
                    hVar2 = new h(this.a, str2);
                    try {
                        this.a.a(new b(str2, request, hVar2));
                    } catch (Throwable th) {
                        boolean z2 = zEnableTracer;
                        hVar = hVar2;
                        th = th;
                        str = str2;
                        z = z2;
                        th.printStackTrace();
                        hVar2 = hVar;
                        zEnableTracer = z;
                        str2 = str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = str2;
                    z = zEnableTracer;
                    hVar = null;
                }
            } else {
                Log.d("NetTrace-Interceptor", "net enable is false~");
                hVar2 = null;
                str2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            z = false;
            hVar = null;
        }
        Response responseProceed = chain.proceed(request);
        if (!zEnableTracer) {
            try {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    return responseProceed;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return responseProceed;
            }
        }
        if (hVar2 != null && hVar2.a()) {
            hVar2.b();
            f fVar = hVar2.a;
            hVar2.b.size();
            fVar.a();
        }
        Connection connection = chain.connection();
        if (connection == null) {
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        }
        this.a.a(new c(str2, request, responseProceed, connection));
        ResponseBody responseBodyBody = responseProceed.body();
        if (responseBodyBody != null) {
            mediaTypeContentType = responseBodyBody.contentType();
            inputStreamByteStream = responseBodyBody.byteStream();
        } else {
            mediaTypeContentType = null;
            inputStreamByteStream = null;
        }
        f fVar2 = this.a;
        String string = mediaTypeContentType != null ? mediaTypeContentType.toString() : null;
        String strHeader = responseProceed.header("Content-Encoding");
        new com.efs.sdk.net.a.a.c(this.a, str2);
        InputStream inputStreamA = fVar2.a(str2, string, strHeader, inputStreamByteStream);
        return inputStreamA != null ? responseProceed.newBuilder().body(new a(responseBodyBody, inputStreamA)).build() : responseProceed;
    }

    static class b implements f.b {
        private final String a;
        private final Request b;
        private h c;

        public b(String str, Request request, h hVar) {
            this.a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.c
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String b() {
            return this.b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final byte[] d() {
            OutputStream inflaterOutputStream;
            RequestBody requestBodyBody = this.b.body();
            if (requestBodyBody == null) {
                return null;
            }
            h hVar = this.c;
            String strHeader = this.b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (Constants.CP_GZIP.equals(strHeader)) {
                inflaterOutputStream = com.efs.sdk.net.a.a.e.a(byteArrayOutputStream);
            } else {
                inflaterOutputStream = "deflate".equals(strHeader) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            }
            hVar.c = new com.efs.sdk.net.a.a.a(inflaterOutputStream);
            hVar.b = byteArrayOutputStream;
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(hVar.c));
            try {
                requestBodyBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.b.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.b.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.b.headers().value(i);
        }
    }

    static class c implements f.d {
        private final String a;
        private final Request b;
        private final Response c;
        private final Connection d;

        public c(String str, Request request, Response response, Connection connection) {
            this.a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final int b() {
            return this.c.code();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.c.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.c.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.c.headers().value(i);
        }
    }

    static class a extends ResponseBody {
        private final ResponseBody a;
        private final BufferedSource b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.b;
        }
    }
}
