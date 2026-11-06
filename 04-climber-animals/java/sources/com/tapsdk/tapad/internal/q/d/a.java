package com.tapsdk.tapad.internal.q.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public class a implements com.tapsdk.tapad.internal.q.d.b {
    private static final String b = "HOST";
    private static final String c = "Content-Length";
    final com.tapsdk.tapad.internal.q.f.a a;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.q.d.a$a, reason: collision with other inner class name */
    class C0629a implements com.tapsdk.tapad.internal.q.g.b.a {
        final /* synthetic */ d a;
        final /* synthetic */ c b;

        C0629a(d dVar, c cVar) {
            this.a = dVar;
            this.b = cVar;
        }

        @Override // com.tapsdk.tapad.internal.q.g.b.a
        public void a(long j) {
            d dVar = this.a;
            dVar.e = j;
            a.this.a.a(this.b, dVar);
        }
    }

    static class b extends ResponseBody {
        final ResponseBody a;
        final BufferedSource b;

        b(ResponseBody responseBody, InputStream inputStream) {
            this.a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.b;
        }
    }

    static class c implements com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a {
        final int a;
        final URL b;
        final String c;
        final long d;
        final String e;
        final RequestBody f;

        c(int i, URL url, String str, long j, String str2, RequestBody requestBody) {
            this.a = i;
            this.b = url;
            this.c = str;
            this.d = j;
            this.e = str2;
            this.f = requestBody;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public int a() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public URL b() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public String c() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public String d() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public long e() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.InterfaceC0630a
        public RequestBody f() {
            return this.f;
        }
    }

    static class d implements com.tapsdk.tapad.internal.q.f.a.b {
        final int a;
        final long b;
        final long c;
        final int d;
        long e;
        final ResponseBody f;

        d(int i, int i2, long j, long j2, long j3, ResponseBody responseBody) {
            this.a = i;
            this.d = i2;
            this.e = j;
            this.b = j2;
            this.c = j3;
            this.f = responseBody;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public int a() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public long b() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public ResponseBody c() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public int d() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public long e() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.internal.q.f.a.b
        public long f() {
            return this.b;
        }
    }

    public a(com.tapsdk.tapad.internal.q.f.a aVar) {
        this.a = aVar;
    }

    @Override // com.tapsdk.tapad.internal.q.d.b
    public Response a(int i, com.tapsdk.tapad.internal.q.a.b bVar, Request request, Response response) throws Exception {
        InputStream inputStreamByteStream;
        ResponseBody responseBodyBody = response.body();
        c cVar = new c(i, request.url().url(), request.method(), com.tapsdk.tapad.internal.q.h.d.a(request.headers()), request.url().host(), request.body());
        d dVar = new d(i, response.code(), com.tapsdk.tapad.internal.q.h.d.a(response.headers()), bVar.a, bVar.b, responseBodyBody);
        if (response.header("Content-Length") != null) {
            this.a.a(cVar, dVar);
            return response;
        }
        if (responseBodyBody != null) {
            try {
                inputStreamByteStream = responseBodyBody.byteStream();
            } catch (Exception e) {
                if (com.tapsdk.tapad.internal.q.h.d.a) {
                    Log.d("Error reading IS : ", e.getMessage());
                }
                this.a.a(cVar, dVar, e);
                throw e;
            }
        } else {
            inputStreamByteStream = null;
        }
        return response.newBuilder().body(new b(responseBodyBody, new com.tapsdk.tapad.internal.q.g.a(inputStreamByteStream, new com.tapsdk.tapad.internal.q.g.b(new C0629a(dVar, cVar))))).build();
    }

    @Override // com.tapsdk.tapad.internal.q.d.b
    public void a(int i, com.tapsdk.tapad.internal.q.a.b bVar, Request request, IOException iOException) {
        if (com.tapsdk.tapad.internal.q.h.d.a) {
            Log.d("Error response: ", iOException.getMessage());
        }
        this.a.a(new c(i, request.url().url(), request.method(), com.tapsdk.tapad.internal.q.h.d.a(request.headers()), request.header(b), request.body()), iOException);
    }
}
