package com.anythink.basead.exoplayer.j;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.basead.exoplayer.k.af;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class p implements s {
    public static final int a = 8000;
    public static final int b = 8000;
    private static final String d = "DefaultHttpDataSource";
    private static final int e = 20;
    private static final long f = 2048;
    private static final Pattern g = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> h = new AtomicReference<>();
    private final boolean i;
    private final int j;
    private final int k;
    private final String l;
    private final com.anythink.basead.exoplayer.k.u<String> m;
    private final s.f n;
    private final s.f o;
    private final aa<? super p> p;
    private k q;
    private HttpURLConnection r;
    private InputStream s;
    private boolean t;
    private long u;
    private long v;
    private long w;
    private long x;

    private p(String str, com.anythink.basead.exoplayer.k.u<String> uVar) {
        this(str, uVar, null);
    }

    private p(String str, com.anythink.basead.exoplayer.k.u<String> uVar, aa<? super p> aaVar) {
        this(str, uVar, aaVar, (byte) 0);
    }

    private p(String str, com.anythink.basead.exoplayer.k.u<String> uVar, aa<? super p> aaVar, byte b2) {
        this(str, uVar, aaVar, 8000, 8000, false, null);
    }

    public p(String str, com.anythink.basead.exoplayer.k.u<String> uVar, aa<? super p> aaVar, int i, int i2, boolean z, s.f fVar) {
        if (!TextUtils.isEmpty(str)) {
            this.l = str;
            this.m = uVar;
            this.p = aaVar;
            this.o = new s.f();
            this.j = i;
            this.k = i2;
            this.i = z;
            this.n = fVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.anythink.basead.exoplayer.j.s
    public final Map<String, List<String>> c() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.anythink.basead.exoplayer.j.s
    public final void a(String str, String str2) {
        com.anythink.basead.exoplayer.k.a.a(str);
        com.anythink.basead.exoplayer.k.a.a(str2);
        this.o.a(str, str2);
    }

    @Override // com.anythink.basead.exoplayer.j.s
    public final void a(String str) {
        com.anythink.basead.exoplayer.k.a.a(str);
        this.o.a(str);
    }

    @Override // com.anythink.basead.exoplayer.j.s
    public final void d() {
        this.o.a();
    }

    @Override // com.anythink.basead.exoplayer.j.s, com.anythink.basead.exoplayer.j.h
    public final long a(k kVar) throws s.c {
        HttpURLConnection httpURLConnectionA;
        HttpURLConnection httpURLConnectionA2;
        this.q = kVar;
        long j = 0;
        this.x = 0L;
        this.w = 0L;
        try {
            URL url = new URL(kVar.c.toString());
            byte[] bArr = kVar.d;
            long j2 = kVar.f;
            long j3 = kVar.g;
            boolean zA = kVar.a(1);
            if (this.i) {
                int i = 0;
                URL url2 = url;
                byte[] bArr2 = bArr;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        long j4 = j3;
                        long j5 = j2;
                        httpURLConnectionA = a(url2, bArr2, j2, j3, zA, false);
                        int responseCode = httpURLConnectionA.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        String headerField = httpURLConnectionA.getHeaderField("Location");
                        httpURLConnectionA.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url2 = new URL(url3, headerField);
                        String protocol = url2.getProtocol();
                        if (!"https".equals(protocol) && !"http".equals(protocol)) {
                            throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                        }
                        bArr2 = null;
                        i = i2;
                        j3 = j4;
                        j2 = j5;
                    } else {
                        throw new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i2)));
                    }
                }
                httpURLConnectionA2 = httpURLConnectionA;
            } else {
                httpURLConnectionA2 = a(url, bArr, j2, j3, zA, true);
            }
            this.r = httpURLConnectionA2;
            try {
                int responseCode2 = httpURLConnectionA2.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.r.getHeaderFields();
                    j();
                    s.e eVar = new s.e(responseCode2, headerFields, kVar);
                    if (responseCode2 == 416) {
                        eVar.initCause(new i());
                        throw eVar;
                    }
                    throw eVar;
                }
                String contentType = this.r.getContentType();
                com.anythink.basead.exoplayer.k.u<String> uVar = this.m;
                if (uVar != null && !uVar.a(contentType)) {
                    j();
                    throw new s.d(contentType, kVar);
                }
                if (responseCode2 == 200 && kVar.f != 0) {
                    j = kVar.f;
                }
                this.u = j;
                if (kVar.a(1)) {
                    this.v = kVar.g;
                } else {
                    if (kVar.g != -1) {
                        this.v = kVar.g;
                    } else {
                        long jA = a(this.r);
                        this.v = jA != -1 ? jA - this.u : -1L;
                    }
                }
                try {
                    this.s = this.r.getInputStream();
                    this.t = true;
                    aa<? super p> aaVar = this.p;
                    if (aaVar != null) {
                        aaVar.b();
                    }
                    return this.v;
                } catch (IOException e2) {
                    j();
                    throw new s.c(e2, kVar, 1);
                }
            } catch (IOException e3) {
                j();
                throw new s.c("Unable to connect to " + kVar.c.toString(), e3, kVar);
            }
        } catch (IOException e4) {
            throw new s.c("Unable to connect to " + kVar.c.toString(), e4, kVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[Catch: Exception -> 0x0067, all -> 0x008a, TryCatch #0 {Exception -> 0x0067, blocks: (B:14:0x0020, B:16:0x0028, B:21:0x0036, B:23:0x0046, B:25:0x004e), top: B:45:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004e A[Catch: Exception -> 0x0067, all -> 0x008a, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:14:0x0020, B:16:0x0028, B:21:0x0036, B:23:0x0046, B:25:0x004e), top: B:45:0x0020 }] */
    @Override // com.anythink.basead.exoplayer.j.s, com.anythink.basead.exoplayer.j.h
    public final void b() {
        String name;
        try {
            if (this.s != null) {
                HttpURLConnection httpURLConnection = this.r;
                long j = this.v;
                if (j != -1) {
                    j -= this.x;
                }
                if (af.a == 19 || af.a == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j == -1) {
                            if (inputStream.read() != -1) {
                                name = inputStream.getClass().getName();
                                if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(inputStream, new Object[0]);
                                }
                            }
                        } else if (j > f) {
                            name = inputStream.getClass().getName();
                            if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name)) {
                                Method declaredMethod2 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod2.setAccessible(true);
                                declaredMethod2.invoke(inputStream, new Object[0]);
                            } else {
                                Method declaredMethod3 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod3.setAccessible(true);
                                declaredMethod3.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.s.close();
                } catch (IOException e2) {
                    throw new s.c(e2, this.q, 3);
                }
            }
            this.s = null;
            j();
            if (this.t) {
                this.t = false;
                aa<? super p> aaVar = this.p;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        } catch (Throwable th) {
            this.s = null;
            j();
            if (this.t) {
                this.t = false;
                aa<? super p> aaVar2 = this.p;
                if (aaVar2 != null) {
                    aaVar2.c();
                }
            }
            throw th;
        }
    }

    private HttpURLConnection e() {
        return this.r;
    }

    private long f() {
        return this.w;
    }

    private long g() {
        return this.x;
    }

    private long h() {
        long j = this.v;
        return j == -1 ? j : j - this.x;
    }

    private HttpURLConnection b(k kVar) throws IOException {
        URL url = new URL(kVar.c.toString());
        byte[] bArr = kVar.d;
        long j = kVar.f;
        long j2 = kVar.g;
        boolean zA = kVar.a(1);
        if (!this.i) {
            return a(url, bArr, j, j2, zA, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                HttpURLConnection httpURLConnectionA = a(url, bArr, j, j2, zA, false);
                int responseCode = httpURLConnectionA.getResponseCode();
                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                    return httpURLConnectionA;
                }
                String headerField = httpURLConnectionA.getHeaderField("Location");
                httpURLConnectionA.disconnect();
                if (headerField == null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url2 = new URL(url, headerField);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                }
                bArr = null;
                url = url2;
                i = i2;
            } else {
                throw new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00dc  */
    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.j);
        httpURLConnection.setReadTimeout(this.k);
        s.f fVar = this.n;
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.b().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.o.b().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.l);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            } else {
                httpURLConnection.connect();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws ProtocolException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                Log.e(d, "Unexpected Content-Length [" + headerField + "]");
                j = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = g.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return j2;
            }
            if (j == j2) {
                return j;
            }
            Log.w(d, "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            Log.e(d, "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private void i() throws IOException {
        if (this.w == this.u) {
            return;
        }
        byte[] andSet = h.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.w;
            long j2 = this.u;
            if (j != j2) {
                int i = this.s.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i == -1) {
                    throw new EOFException();
                }
                this.w += (long) i;
                aa<? super p> aaVar = this.p;
                if (aaVar != null) {
                    aaVar.a(i);
                }
            } else {
                h.set(andSet);
                return;
            }
        }
    }

    private int b(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.v;
        if (j != -1) {
            long j2 = j - this.x;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.s.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.v == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.x += (long) i3;
        aa<? super p> aaVar = this.p;
        if (aaVar != null) {
            aaVar.a(i3);
        }
        return i3;
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        if (af.a == 19 || af.a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= f) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void j() {
        HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e(d, "Unexpected error while disconnecting", e2);
            }
            this.r = null;
        }
    }

    @Override // com.anythink.basead.exoplayer.j.s, com.anythink.basead.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) throws s.c {
        try {
            if (this.w != this.u) {
                byte[] andSet = h.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.w;
                    long j2 = this.u;
                    if (j != j2) {
                        int i3 = this.s.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedIOException();
                        }
                        if (i3 == -1) {
                            throw new EOFException();
                        }
                        this.w += (long) i3;
                        aa<? super p> aaVar = this.p;
                        if (aaVar != null) {
                            aaVar.a(i3);
                        }
                    } else {
                        h.set(andSet);
                        break;
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.v;
            if (j3 != -1) {
                long j4 = j3 - this.x;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j4);
            }
            int i4 = this.s.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.v == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.x += (long) i4;
            aa<? super p> aaVar2 = this.p;
            if (aaVar2 != null) {
                aaVar2.a(i4);
            }
            return i4;
        } catch (IOException e2) {
            throw new s.c(e2, this.q, 2);
        }
    }
}
