package com.smartdigimkt.y0;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements i {
    public static final Pattern n = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference o = new AtomicReference();
    public final boolean a;
    public final int b;
    public final int c;
    public final String d;
    public final u e;
    public final u f;
    public HttpURLConnection g;
    public InputStream h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public long m;

    public o(String str, int i, int i2, boolean z, u uVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.d = str;
        this.f = new u();
        this.b = i;
        this.c = i2;
        this.a = z;
        this.e = uVar;
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.g;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(k kVar) throws IOException {
        byte[] bArr = null;
        URL url = new URL(kVar.a.toString());
        long j = kVar.c;
        long j2 = -1;
        if (!this.a) {
            return a(url, null, j, -1L, false, true);
        }
        int i = 0;
        URL url2 = url;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
            long j3 = j2;
            URL url3 = url2;
            HttpURLConnection httpURLConnectionA = a(url2, bArr, j, j3, false, false);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                return httpURLConnectionA;
            }
            String headerField = httpURLConnectionA.getHeaderField("Location");
            httpURLConnectionA.disconnect();
            if (headerField == null) {
                throw new ProtocolException("Null location redirect");
            }
            url2 = new URL(url3, headerField);
            String protocol = url2.getProtocol();
            if (!BaseConstants.SCHEME_HTTPS.equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            i = i2;
            bArr = null;
            j2 = -1;
        }
    }

    public final void c() throws IOException {
        if (this.l == this.j) {
            return;
        }
        byte[] bArr = (byte[]) o.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.l;
            long j2 = this.j;
            if (j == j2) {
                o.set(bArr);
                return;
            }
            int i = this.h.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            this.l += (long) i;
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final void close() {
        try {
            if (this.h != null) {
                HttpURLConnection httpURLConnection = this.g;
                long j = this.k;
                if (j != -1) {
                    j -= this.m;
                }
                a(httpURLConnection, j);
                try {
                    this.h.close();
                } catch (IOException e) {
                    throw new s(e);
                }
            }
            this.h = null;
            b();
            if (this.i) {
                this.i = false;
            }
        } catch (Throwable th) {
            this.h = null;
            b();
            if (this.i) {
                this.i = false;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) throws s {
        long j;
        long jMax;
        this.m = 0L;
        this.l = 0L;
        try {
            HttpURLConnection httpURLConnectionB = b(kVar);
            this.g = httpURLConnectionB;
            try {
                int responseCode = httpURLConnectionB.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    this.g.getHeaderFields();
                    b();
                    t tVar = new t(responseCode);
                    if (responseCode != 416) {
                        throw tVar;
                    }
                    tVar.initCause(new j());
                    throw tVar;
                }
                this.g.getContentType();
                if (responseCode == 200) {
                    j = kVar.c;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                this.j = j;
                HttpURLConnection httpURLConnection = this.g;
                String headerField = httpURLConnection.getHeaderField("Content-Length");
                if (TextUtils.isEmpty(headerField)) {
                    jMax = -1;
                } else {
                    try {
                        jMax = Long.parseLong(headerField);
                    } catch (NumberFormatException unused) {
                        jMax = -1;
                    }
                }
                String headerField2 = httpURLConnection.getHeaderField("Content-Range");
                if (!TextUtils.isEmpty(headerField2)) {
                    Matcher matcher = n.matcher(headerField2);
                    if (matcher.find()) {
                        try {
                            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                            if (jMax < 0) {
                                jMax = j2;
                            } else if (jMax != j2) {
                                jMax = Math.max(jMax, j2);
                            }
                        } catch (NumberFormatException unused2) {
                        }
                    }
                }
                this.k = jMax != -1 ? jMax - this.j : -1L;
                try {
                    this.h = this.g.getInputStream();
                    this.i = true;
                    return this.k;
                } catch (IOException e) {
                    b();
                    throw new s(e);
                }
            } catch (IOException e2) {
                b();
                throw new s("Unable to connect to " + kVar.a.toString(), e2);
            }
        } catch (IOException e3) {
            throw new s("Unable to connect to " + kVar.a.toString(), e3);
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.g;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            this.g = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: IOException -> 0x003d, TryCatch #0 {IOException -> 0x003d, blocks: (B:2:0x0000, B:5:0x0007, B:7:0x0010, B:10:0x001a, B:11:0x0020, B:13:0x0028, B:16:0x0030, B:17:0x0035, B:18:0x0036), top: B:23:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0030 A[Catch: IOException -> 0x003d, TryCatch #0 {IOException -> 0x003d, blocks: (B:2:0x0000, B:5:0x0007, B:7:0x0010, B:10:0x001a, B:11:0x0020, B:13:0x0028, B:16:0x0030, B:17:0x0035, B:18:0x0036), top: B:23:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0036 A[Catch: IOException -> 0x003d, TRY_LEAVE, TryCatch #0 {IOException -> 0x003d, blocks: (B:2:0x0000, B:5:0x0007, B:7:0x0010, B:10:0x001a, B:11:0x0020, B:13:0x0028, B:16:0x0030, B:17:0x0035, B:18:0x0036), top: B:23:0x0000 }] */
    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) throws s {
        int i3;
        try {
            c();
            if (i2 == 0) {
                return 0;
            }
            long j = this.k;
            if (j != -1) {
                long j2 = j - this.m;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    i3 = this.h.read(bArr, i, i2);
                    if (i3 == -1) {
                        this.m += (long) i3;
                        return i3;
                    }
                    if (this.k != -1) {
                        throw new EOFException();
                    }
                }
            } else {
                i3 = this.h.read(bArr, i, i2);
                if (i3 == -1) {
                    this.m += (long) i3;
                    return i3;
                }
                if (this.k != -1) {
                    throw new EOFException();
                }
            }
            return -1;
        } catch (IOException e) {
            throw new s(e);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        Map map;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        u uVar = this.e;
        if (uVar != null) {
            synchronized (uVar) {
                if (uVar.b == null) {
                    uVar.b = Collections.unmodifiableMap(new HashMap(uVar.a));
                }
                map = uVar.b;
            }
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Map.Entry entry2 : this.f.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty(RequestParamsUtils.USER_AGENT_KEY, this.d);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(TapHttp.METHOD_POST);
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        int i = com.smartdigimkt.z0.u.a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= com.anythink.china.a.c.l) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }
}
