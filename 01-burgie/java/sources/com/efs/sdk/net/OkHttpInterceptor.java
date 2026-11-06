package com.efs.sdk.net;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpInterceptor implements Interceptor {
    private final f a = g.c();

    /* JADX WARN: Code duplicated, block: B:15:0x003c A[Catch: Throwable -> 0x0034, TryCatch #3 {Throwable -> 0x0034, blocks: (B:8:0x0021, B:11:0x0028, B:15:0x003c, B:17:0x005b, B:16:0x0054), top: B:63:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0054 A[Catch: Throwable -> 0x0034, TryCatch #3 {Throwable -> 0x0034, blocks: (B:8:0x0021, B:11:0x0028, B:15:0x003c, B:17:0x005b, B:16:0x0054), top: B:63:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5 A[Catch: Throwable -> 0x00b6, TryCatch #4 {Throwable -> 0x00b6, blocks: (B:30:0x00af, B:36:0x00bb, B:38:0x00c2, B:39:0x00cf, B:41:0x00d5, B:42:0x00dc, B:43:0x00dd, B:45:0x00ef, B:47:0x00fa, B:49:0x00fe, B:50:0x0103, B:52:0x0116), top: B:64:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00dd A[Catch: Throwable -> 0x00b6, TryCatch #4 {Throwable -> 0x00b6, blocks: (B:30:0x00af, B:36:0x00bb, B:38:0x00c2, B:39:0x00cf, B:41:0x00d5, B:42:0x00dc, B:43:0x00dd, B:45:0x00ef, B:47:0x00fa, B:49:0x00fe, B:50:0x0103, B:52:0x0116), top: B:64:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ef A[Catch: Throwable -> 0x00b6, TryCatch #4 {Throwable -> 0x00b6, blocks: (B:30:0x00af, B:36:0x00bb, B:38:0x00c2, B:39:0x00cf, B:41:0x00d5, B:42:0x00dc, B:43:0x00dd, B:45:0x00ef, B:47:0x00fa, B:49:0x00fe, B:50:0x0103, B:52:0x0116), top: B:64:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe A[Catch: Throwable -> 0x00b6, TryCatch #4 {Throwable -> 0x00b6, blocks: (B:30:0x00af, B:36:0x00bb, B:38:0x00c2, B:39:0x00cf, B:41:0x00d5, B:42:0x00dc, B:43:0x00dd, B:45:0x00ef, B:47:0x00fa, B:49:0x00fe, B:50:0x0103, B:52:0x0116), top: B:64:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0116 A[Catch: Throwable -> 0x00b6, TRY_LEAVE, TryCatch #4 {Throwable -> 0x00b6, blocks: (B:30:0x00af, B:36:0x00bb, B:38:0x00c2, B:39:0x00cf, B:41:0x00d5, B:42:0x00dc, B:43:0x00dd, B:45:0x00ef, B:47:0x00fa, B:49:0x00fe, B:50:0x0103, B:52:0x0116), top: B:64:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x003c, please report this as an issue */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        h hVar;
        boolean z;
        String strB;
        boolean zEnableTracer;
        Response responseProceed;
        Connection connection;
        ResponseBody responseBodyBody;
        MediaType mediaTypeContentType;
        InputStream inputStreamByteStream;
        InputStream inputStreamA;
        Request request = chain.request();
        String string = null;
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            zEnableTracer = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
            if (zEnableTracer) {
                if (request != null) {
                    Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                } else {
                    Log.d("NetTrace-Interceptor", "intercept request is null~");
                }
                strB = this.a.b();
                Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                com.efs.sdk.net.a.a.a().a(strB).c = request.url().toString();
                hVar = new h(this.a, strB);
                this.a.a(new b(strB, request, hVar));
            } else {
                try {
                    if (IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                        if (request != null) {
                            Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                        } else {
                            Log.d("NetTrace-Interceptor", "intercept request is null~");
                        }
                        strB = this.a.b();
                        try {
                            Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                            com.efs.sdk.net.a.a.a().a(strB).c = request.url().toString();
                            hVar = new h(this.a, strB);
                            try {
                                this.a.a(new b(strB, request, hVar));
                            } catch (Throwable th) {
                                z = zEnableTracer;
                                str = strB;
                                th = th;
                                th.printStackTrace();
                                strB = str;
                                zEnableTracer = z;
                            }
                        } catch (Throwable th2) {
                            z = zEnableTracer;
                            str = strB;
                            th = th2;
                            hVar = null;
                        }
                    } else {
                        Log.d("NetTrace-Interceptor", "net enable is false~");
                        strB = null;
                        hVar = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    hVar = null;
                    z = zEnableTracer;
                    str = null;
                    th.printStackTrace();
                    strB = str;
                    zEnableTracer = z;
                    responseProceed = chain.proceed(request);
                    if (!zEnableTracer) {
                        try {
                            if (IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                                return responseProceed;
                            }
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                            return responseProceed;
                        }
                    }
                    if (hVar != null) {
                        hVar.b();
                        f fVar = hVar.a;
                        hVar.b.size();
                        fVar.a();
                    }
                    connection = chain.connection();
                    if (connection == null) {
                        throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
                    }
                    this.a.a(new c(strB, request, responseProceed, connection));
                    responseBodyBody = responseProceed.body();
                    if (responseBodyBody != null) {
                        mediaTypeContentType = responseBodyBody.contentType();
                        inputStreamByteStream = responseBodyBody.byteStream();
                    } else {
                        mediaTypeContentType = null;
                        inputStreamByteStream = null;
                    }
                    f fVar2 = this.a;
                    if (mediaTypeContentType != null) {
                        string = mediaTypeContentType.toString();
                    }
                    String strHeader = responseProceed.header("Content-Encoding");
                    new com.efs.sdk.net.a.a.c(this.a, strB);
                    inputStreamA = fVar2.a(strB, string, strHeader, inputStreamByteStream);
                    if (inputStreamA != null) {
                        return responseProceed.newBuilder().body(new a(responseBodyBody, inputStreamA)).build();
                    }
                    return responseProceed;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str = null;
            hVar = null;
            z = false;
        }
        responseProceed = chain.proceed(request);
        if (!zEnableTracer) {
            if (IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                return responseProceed;
            }
        }
        if (hVar != null && hVar.a()) {
            hVar.b();
            f fVar3 = hVar.a;
            hVar.b.size();
            fVar3.a();
        }
        connection = chain.connection();
        if (connection == null) {
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        }
        this.a.a(new c(strB, request, responseProceed, connection));
        responseBodyBody = responseProceed.body();
        if (responseBodyBody != null) {
            mediaTypeContentType = responseBodyBody.contentType();
            inputStreamByteStream = responseBodyBody.byteStream();
        } else {
            mediaTypeContentType = null;
            inputStreamByteStream = null;
        }
        f fVar4 = this.a;
        if (mediaTypeContentType != null) {
            string = mediaTypeContentType.toString();
        }
        String strHeader2 = responseProceed.header("Content-Encoding");
        new com.efs.sdk.net.a.a.c(this.a, strB);
        inputStreamA = fVar4.a(strB, string, strHeader2, inputStreamByteStream);
        if (inputStreamA != null) {
            return responseProceed.newBuilder().body(new a(responseBodyBody, inputStreamA)).build();
        }
        return responseProceed;
    }

    static class b implements f.a {
        private final String a;
        private final Request b;
        private h c;

        public b(String str, Request request, h hVar) {
            this.a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b() {
            return this.b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        @Nullable
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
                inflaterOutputStream = e.a(byteArrayOutputStream);
            } else if ("deflate".equals(strHeader)) {
                inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream);
            } else {
                inflaterOutputStream = byteArrayOutputStream;
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
    }

    static class c implements f.c {
        private final String a;
        private final Request b;
        private final Response c;

        @Nullable
        private final Connection d;

        public c(String str, Request request, Response response, @Nullable Connection connection) {
            this.a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final int b() {
            return this.c.code();
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
