package com.tapsdk.tapad.internal.download.core.connection;

import com.tapsdk.tapad.internal.download.h;
import com.tapsdk.tapad.internal.download.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.tapsdk.tapad.internal.download.core.connection.a, com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a {
    private static final String f = "DownloadUrlConnection";
    protected URLConnection b;
    private a c;
    private URL d;
    private h e;

    public static class a {
        private Proxy a;
        private Integer b;
        private Integer c;

        public a a(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public a a(Proxy proxy) {
            this.a = proxy;
            return this;
        }

        public a b(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.core.connection.b$b, reason: collision with other inner class name */
    public static class C0606b implements com.tapsdk.tapad.internal.download.core.connection.a.b {
        private final a a;

        public C0606b() {
            this(null);
        }

        public C0606b(a aVar) {
            this.a = aVar;
        }

        @Override // com.tapsdk.tapad.internal.download.core.connection.a.b
        public com.tapsdk.tapad.internal.download.core.connection.a a(String str) throws IOException {
            return new b(str, this.a);
        }

        com.tapsdk.tapad.internal.download.core.connection.a a(URL url) throws IOException {
            return new b(url, this.a);
        }
    }

    static final class c implements h {
        String a;

        c() {
        }

        @Override // com.tapsdk.tapad.internal.download.h
        public String a() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.internal.download.h
        public void a(com.tapsdk.tapad.internal.download.core.connection.a aVar, com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a, Map<String, List<String>> map) throws IOException {
            b bVar = (b) aVar;
            int i = 0;
            for (int iF = interfaceC0605a.f(); j.a(iF); iF = bVar.f()) {
                bVar.d();
                i++;
                if (i > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
                this.a = j.a(interfaceC0605a, iF);
                bVar.d = new URL(this.a);
                bVar.h();
                com.tapsdk.tapad.internal.download.m.c.a(map, bVar);
                bVar.b.connect();
            }
        }
    }

    public b(String str) throws IOException {
        this(str, (a) null);
    }

    public b(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    public b(URL url, a aVar) throws IOException {
        this(url, aVar, new c());
    }

    public b(URL url, a aVar, h hVar) throws IOException {
        this.c = aVar;
        this.d = url;
        this.e = hVar;
        h();
    }

    b(URLConnection uRLConnection) {
        this(uRLConnection, new c());
    }

    b(URLConnection uRLConnection, h hVar) {
        this.b = uRLConnection;
        this.d = uRLConnection.getURL();
        this.e = hVar;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public String a() {
        return this.e.a();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public void a(String str, String str2) {
        this.b.addRequestProperty(str, str2);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public boolean a(String str) throws ProtocolException {
        URLConnection uRLConnection = this.b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public InputStream b() throws IOException {
        return this.b.getInputStream();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public String b(String str) {
        return this.b.getRequestProperty(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public String c(String str) {
        return this.b.getHeaderField(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public Map<String, List<String>> c() {
        return this.b.getRequestProperties();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public void d() {
        try {
            InputStream inputStream = this.b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException | IllegalStateException unused) {
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public Map<String, List<String>> e() {
        return this.b.getHeaderFields();
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a
    public int f() throws IOException {
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.tapsdk.tapad.internal.download.core.connection.a
    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a g() throws IOException {
        Map<String, List<String>> mapC = c();
        this.b.connect();
        this.e.a(this, this, mapC);
        return this;
    }

    void h() throws IOException {
        com.tapsdk.tapad.internal.download.m.c.a(f, "config connection for " + this.d);
        a aVar = this.c;
        this.b = (aVar == null || aVar.a == null) ? this.d.openConnection() : this.d.openConnection(this.c.a);
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        a aVar2 = this.c;
        if (aVar2 != null) {
            if (aVar2.b != null) {
                this.b.setReadTimeout(this.c.b.intValue());
            }
            if (this.c.c != null) {
                this.b.setConnectTimeout(this.c.c.intValue());
            }
        }
    }
}
