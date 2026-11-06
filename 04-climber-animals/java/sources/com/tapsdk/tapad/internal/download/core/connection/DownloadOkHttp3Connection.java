package com.tapsdk.tapad.internal.download.core.connection;

import com.tapsdk.tapad.internal.download.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadOkHttp3Connection implements com.tapsdk.tapad.internal.download.core.connection.a, com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a {
    final OkHttpClient b;
    private final Request.Builder c;
    private Request d;
    Response e;

    public static class a implements com.tapsdk.tapad.internal.download.core.connection.a.b {
        private OkHttpClient.Builder a;
        private volatile OkHttpClient b;

        public a a(OkHttpClient.Builder builder) {
            this.a = builder;
            return this;
        }

        @Override // com.tapsdk.tapad.internal.download.core.connection.a.b
        public com.tapsdk.tapad.internal.download.core.connection.a a(String str) throws IOException {
            if (this.b == null) {
                synchronized (a.class) {
                    if (this.b == null) {
                        OkHttpClient.Builder builder = this.a;
                        this.b = builder != null ? builder.build() : new OkHttpClient();
                        this.a = null;
                    }
                }
            }
            return new DownloadOkHttp3Connection(this.b, str);
        }

        public OkHttpClient.Builder a() {
            if (this.a == null) {
                this.a = new OkHttpClient.Builder();
            }
            return this.a;
        }
    }

    DownloadOkHttp3Connection(OkHttpClient okHttpClient, String str) {
        this(okHttpClient, new Request.Builder().url(str));
    }

    DownloadOkHttp3Connection(OkHttpClient okHttpClient, Request.Builder builder) {
        this.b = okHttpClient;
        this.c = builder;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public String a() {
        Response responsePriorResponse = this.e.priorResponse();
        if (responsePriorResponse != null && this.e.isSuccessful() && j.a(responsePriorResponse.code())) {
            return this.e.request().url().toString();
        }
        return null;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public void a(String str, String str2) {
        this.c.addHeader(str, str2);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public boolean a(String str) throws ProtocolException {
        this.c.method(str, null);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public InputStream b() throws IOException {
        Response response = this.e;
        if (response == null) {
            throw new IOException("Please invoke execute first!");
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody.byteStream();
        }
        throw new IOException("no body found on response!");
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public String b(String str) {
        Request request = this.d;
        return request != null ? request.header(str) : this.c.build().header(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public String c(String str) {
        Response response = this.e;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public Map<String, List<String>> c() {
        Request requestBuild = this.d;
        if (requestBuild == null) {
            requestBuild = this.c.build();
        }
        return requestBuild.headers().toMultimap();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public void d() {
        this.d = null;
        Response response = this.e;
        if (response != null) {
            response.close();
        }
        this.e = null;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public Map<String, List<String>> e() {
        Response response = this.e;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public int f() throws IOException {
        Response response = this.e;
        if (response != null) {
            return response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a g() throws IOException {
        Request requestBuild = this.c.build();
        this.d = requestBuild;
        this.e = this.b.newCall(requestBuild).execute();
        return this;
    }
}
