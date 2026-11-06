package com.anythink.dlopt.common.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final String f = ".temp";
    public static final String g = ".log";
    public static final String h = ".apk";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;
    private static final String v = "a";
    protected j a;
    protected String b;
    protected String c;
    protected boolean d;
    protected boolean e;
    public int n = 0;
    protected long o;
    protected long p;
    protected long q;
    protected long r;
    protected long s;
    protected long t;
    protected long u;
    private RandomAccessFile w;
    private InterfaceC0112a x;
    private String y;

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0112a {
        void a(j jVar, long j);

        void a(j jVar, long j, long j2);

        void a(j jVar, long j, long j2, int i);

        void a(j jVar, String str);

        void b(j jVar, long j, long j2);
    }

    private static int j() {
        return 60000;
    }

    private static int k() {
        return 20000;
    }

    protected boolean c() {
        return true;
    }

    public a(j jVar) {
        this.a = jVar;
        this.b = jVar.b;
        this.c = jVar.o;
    }

    public void a(InterfaceC0112a interfaceC0112a) {
        this.x = interfaceC0112a;
        this.d = false;
        com.anythink.dlopt.common.a.a.b.a().a((com.anythink.core.common.v.b.d) new AnonymousClass1());
    }

    public void a() {
        this.d = true;
    }

    public void b() {
        this.e = true;
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a.a$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.v.b.d {
        AnonymousClass1() {
        }

        /* JADX WARN: Code duplicated, block: B:137:0x02ae A[Catch: Exception -> 0x02b2, StackOverflowError -> 0x02cd, OutOfMemoryError -> 0x02cf, TryCatch #14 {Exception -> 0x02b2, OutOfMemoryError -> 0x02cf, StackOverflowError -> 0x02cd, blocks: (B:3:0x000b, B:20:0x00a3, B:29:0x00c6, B:38:0x00f3, B:47:0x0115, B:67:0x01c9, B:91:0x0204, B:101:0x022c, B:111:0x0254, B:121:0x027c, B:127:0x028b, B:133:0x02a7, B:137:0x02ae, B:138:0x02b1), top: B:154:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:150:0x02df  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v25, types: [java.net.HttpURLConnection] */
        @Override // com.anythink.core.common.v.b.d
        public final void a() throws Throwable {
            Throwable th;
            Exception e;
            HttpURLConnection httpURLConnection;
            ConnectTimeoutException e2;
            SocketTimeoutException e3;
            Error e4;
            StackOverflowError e5;
            OutOfMemoryError e6;
            String unused = a.v;
            String str = a.this.b;
            try {
                a.a(a.this);
                ?? r2 = a.this.b;
                a.this.p = System.currentTimeMillis();
                a.this.q = SystemClock.elapsedRealtime();
                try {
                    try {
                        String unused2 = a.v;
                        httpURLConnection = (HttpURLConnection) new URL(r2).openConnection();
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            if (a.this.a.p) {
                                String strI = com.anythink.core.common.v.m.i();
                                if (!TextUtils.isEmpty(strI)) {
                                    httpURLConnection.addRequestProperty("User-Agent", strI);
                                }
                            }
                            if (a.this.o > 0) {
                                String unused3 = a.v;
                                long j = a.this.o;
                                long j2 = a.this.t;
                                httpURLConnection.setRequestProperty("Range", "bytes=" + a.this.o + "-");
                            } else {
                                a.this.t = httpURLConnection.getContentLength();
                            }
                            if (a.this.t <= 0) {
                                String unused4 = a.v;
                                a.this.a(f.a("10000", "downloadSize <= 0"));
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (a.this.d) {
                                if (a.this.a != null) {
                                    a.this.a.k();
                                }
                                a.this.n = 3;
                                a.this.d();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            httpURLConnection.setConnectTimeout(60000);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && responseCode != 206) {
                                String unused5 = a.v;
                                a.this.a(f.a("10001", httpURLConnection.getResponseMessage()));
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (a.this.d) {
                                if (a.this.a != null) {
                                    a.this.a.k();
                                }
                                a.this.n = 3;
                                a.this.d();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            if (a.this.a != null) {
                                a.this.a.j();
                            }
                            a.this.a.h = a.this.t;
                            if (a.this.x != null) {
                                a.this.x.a(a.this.a, a.this.o, a.this.t);
                            }
                            a aVar = a.this;
                            int iA = aVar.a(aVar.c, inputStream);
                            a.this.n = iA;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            a.this.r = System.currentTimeMillis();
                            a.this.s = SystemClock.elapsedRealtime();
                            a.this.a.i = a.this.s - a.this.q;
                            if (iA == 1) {
                                String unused6 = a.v;
                                String str2 = a.this.b;
                                a.this.e();
                            } else if (iA == 2 || iA == 3) {
                                a.this.d();
                            } else {
                                String unused7 = a.v;
                                String str3 = a.this.b;
                                a.this.b(f.a("10000", "Save fail!(" + a.this.y + ")"));
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (OutOfMemoryError e7) {
                            e6 = e7;
                            System.gc();
                            String unused8 = a.v;
                            e6.getMessage();
                            a.this.a(f.a("10000", e6.getMessage() != null ? e6.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (StackOverflowError e8) {
                            e5 = e8;
                            System.gc();
                            String unused9 = a.v;
                            e5.getMessage();
                            a.this.a(f.a("10000", e5.getMessage() != null ? e5.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Error e9) {
                            e4 = e9;
                            System.gc();
                            String unused10 = a.v;
                            e4.getMessage();
                            a.this.a(f.a("10000", e4.getMessage() != null ? e4.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (SocketTimeoutException e10) {
                            e3 = e10;
                            a.this.a(f.a("20001", e3.getMessage()));
                            String unused11 = a.v;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (ConnectTimeoutException e11) {
                            e2 = e11;
                            a.this.a(e2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception e12) {
                            e = e12;
                            String unused12 = a.v;
                            e.getMessage();
                            a.this.a(f.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        throw th;
                    }
                } catch (OutOfMemoryError e13) {
                    e6 = e13;
                    httpURLConnection = null;
                } catch (StackOverflowError e14) {
                    e5 = e14;
                    httpURLConnection = null;
                } catch (Error e15) {
                    e4 = e15;
                    httpURLConnection = null;
                } catch (SocketTimeoutException e16) {
                    e3 = e16;
                    httpURLConnection = null;
                } catch (ConnectTimeoutException e17) {
                    e2 = e17;
                    httpURLConnection = null;
                } catch (Exception e18) {
                    e = e18;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = 0;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e19) {
                String unused13 = a.v;
                e19.getMessage();
                a.this.b(f.a("10000", e19.getMessage() != null ? e19.getMessage() : "Http connect error!"));
            } catch (OutOfMemoryError e20) {
                e = e20;
                System.gc();
                String unused14 = a.v;
                e.getMessage();
                a.this.b(f.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
            } catch (StackOverflowError e21) {
                e = e21;
                System.gc();
                String unused15 = a.v;
                e.getMessage();
                a.this.b(f.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v11, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v53 */
        /* JADX WARN: Type inference failed for: r2v79 */
        /* JADX WARN: Type inference failed for: r2v80 */
        /* JADX WARN: Type inference failed for: r2v81 */
        /* JADX WARN: Type inference failed for: r2v82 */
        /* JADX WARN: Type inference failed for: r2v83 */
        /* JADX WARN: Type inference failed for: r2v9 */
        private void b(String str) throws Throwable {
            Exception e;
            HttpURLConnection httpURLConnection;
            Error e2;
            StackOverflowError e3;
            OutOfMemoryError e4;
            a aVar;
            a aVar2;
            a.this.p = System.currentTimeMillis();
            a.this.q = SystemClock.elapsedRealtime();
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            try {
                try {
                    try {
                        String unused = a.v;
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            if (a.this.a.p) {
                                String strI = com.anythink.core.common.v.m.i();
                                if (!TextUtils.isEmpty(strI)) {
                                    httpURLConnection.addRequestProperty("User-Agent", strI);
                                }
                            }
                            if (a.this.o > 0) {
                                String unused2 = a.v;
                                long j = a.this.o;
                                long j2 = a.this.t;
                                httpURLConnection.setRequestProperty("Range", "bytes=" + a.this.o + "-");
                            } else {
                                a.this.t = httpURLConnection.getContentLength();
                            }
                            if (a.this.t <= 0) {
                                String unused3 = a.v;
                                a.this.a(f.a("10000", "downloadSize <= 0"));
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (a.this.d) {
                                if (a.this.a != null) {
                                    a.this.a.k();
                                }
                                a.this.n = 3;
                                a.this.d();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            httpURLConnection.setConnectTimeout(60000);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && responseCode != 206) {
                                String unused4 = a.v;
                                a.this.a(f.a("10001", httpURLConnection.getResponseMessage()));
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (a.this.d) {
                                if (a.this.a != null) {
                                    a.this.a.k();
                                }
                                a.this.n = 3;
                                a.this.d();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            if (a.this.a != null) {
                                a.this.a.j();
                            }
                            a.this.a.h = a.this.t;
                            if (a.this.x != null) {
                                a.this.x.a(a.this.a, a.this.o, a.this.t);
                            }
                            a aVar3 = a.this;
                            int iA = aVar3.a(aVar3.c, inputStream);
                            a.this.n = iA;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            a.this.r = System.currentTimeMillis();
                            a.this.s = SystemClock.elapsedRealtime();
                            a.this.a.i = a.this.s - a.this.q;
                            if (iA == 1) {
                                String unused5 = a.v;
                                String str2 = a.this.b;
                                aVar = a.this;
                                aVar.e();
                            } else if (iA == 2 || iA == 3) {
                                a aVar4 = a.this;
                                aVar4.d();
                                r2 = aVar4;
                            } else {
                                String unused6 = a.v;
                                String str3 = a.this.b;
                                aVar2 = a.this;
                                aVar2.b(f.a("10000", "Save fail!(" + a.this.y + ")"));
                            }
                            if (httpURLConnection != null) {
                                r2 = aVar;
                                r2 = aVar2;
                                httpURLConnection.disconnect();
                                return;
                            }
                            r2 = aVar;
                            r2 = aVar2;
                        } catch (Exception e5) {
                            e = e5;
                            String unused7 = a.v;
                            e.getMessage();
                            a.this.a(f.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (OutOfMemoryError e6) {
                            e4 = e6;
                            System.gc();
                            String unused8 = a.v;
                            e4.getMessage();
                            a.this.a(f.a("10000", e4.getMessage() != null ? e4.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (StackOverflowError e7) {
                            e3 = e7;
                            System.gc();
                            String unused9 = a.v;
                            e3.getMessage();
                            a.this.a(f.a("10000", e3.getMessage() != null ? e3.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Error e8) {
                            e2 = e8;
                            System.gc();
                            String unused10 = a.v;
                            e2.getMessage();
                            a.this.a(f.a("10000", e2.getMessage() != null ? e2.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (SocketTimeoutException e9) {
                            e = e9;
                            r2 = httpURLConnection;
                            a.this.a(f.a("20001", e.getMessage()));
                            String unused11 = a.v;
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                        } catch (ConnectTimeoutException e10) {
                            e = e10;
                            r2 = httpURLConnection;
                            a.this.a(e);
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = str;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        throw th;
                    }
                } catch (OutOfMemoryError e11) {
                    e4 = e11;
                    httpURLConnection = null;
                } catch (StackOverflowError e12) {
                    e3 = e12;
                    httpURLConnection = null;
                } catch (Error e13) {
                    e2 = e13;
                    httpURLConnection = null;
                } catch (SocketTimeoutException e14) {
                    e = e14;
                } catch (ConnectTimeoutException e15) {
                    e = e15;
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private void g() {
        com.anythink.dlopt.common.a.a.b.a().a((com.anythink.core.common.v.b.d) new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, InputStream inputStream) {
        j jVar;
        String strA = com.anythink.dlopt.common.c.b.a(str);
        if (TextUtils.isEmpty(strA)) {
            return 4;
        }
        File file = new File(strA + f);
        File file2 = new File(strA + g);
        RandomAccessFile randomAccessFile = null;
        this.w = null;
        try {
            if (!file.exists()) {
                boolean zCreateNewFile = file.createNewFile();
                boolean zCreateNewFile2 = file2.createNewFile();
                if (!zCreateNewFile || !zCreateNewFile2) {
                    return 4;
                }
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rws");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file2, "rws");
                this.w = randomAccessFile3;
                int iA = a(inputStream, randomAccessFile2, randomAccessFile3);
                if (iA == 1) {
                    file.renameTo(new File(strA + h));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    j jVar2 = this.a;
                    if (jVar2 != null) {
                        jVar2.m();
                    }
                } else if (iA == 2) {
                    j jVar3 = this.a;
                    if (jVar3 != null) {
                        jVar3.l();
                    }
                } else if (iA == 3) {
                    j jVar4 = this.a;
                    if (jVar4 != null) {
                        jVar4.k();
                    }
                } else if (iA == 4 && (jVar = this.a) != null) {
                    jVar.o();
                }
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return iA;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                try {
                    th.printStackTrace();
                    String str2 = this.y;
                    if (str2 != null) {
                        str2 = this.y + "|" + th.getMessage();
                    }
                    this.y = str2;
                    return 4;
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void h() {
        try {
            RandomAccessFile randomAccessFile = this.w;
            if (randomAccessFile != null) {
                randomAccessFile.setLength(0L);
                this.w.write(com.anythink.dlopt.common.c.b.a(this.u, this.t, this.a.a()).getBytes());
            }
            try {
                RandomAccessFile randomAccessFile2 = this.w;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                try {
                    if (this.w != null) {
                    }
                } catch (IOException e2) {
                }
            } finally {
                try {
                    if (this.w != null) {
                        this.w.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private int a(InputStream inputStream, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) {
        try {
            if (this.o > 0) {
                Log.i(v, "(" + this.a.c + ")  seek to -> " + this.o);
                randomAccessFile.seek(this.o);
            } else {
                Log.i(v, "(" + this.a.c + ")  set temp file size -> " + this.t);
                randomAccessFile.setLength(this.t);
            }
            byte[] bArr = new byte[1048576];
            this.u = this.o;
            while (true) {
                int i2 = inputStream.read(bArr);
                if (-1 == i2) {
                    return 1;
                }
                if (this.e) {
                    return 2;
                }
                if (this.d) {
                    return 3;
                }
                randomAccessFile.write(bArr, 0, i2);
                long j2 = this.u + ((long) i2);
                this.u = j2;
                j jVar = this.a;
                if (jVar != null) {
                    jVar.g = j2;
                }
                randomAccessFile2.setLength(0L);
                randomAccessFile2.write(com.anythink.dlopt.common.c.b.a(this.u, this.t, this.a.a()).getBytes());
                InterfaceC0112a interfaceC0112a = this.x;
                if (interfaceC0112a != null) {
                    interfaceC0112a.b(this.a, this.u, this.t);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.y = th.getMessage();
            return 4;
        }
    }

    private void i() {
        File file = new File(com.anythink.dlopt.common.c.b.a(this.c) + g);
        File file2 = new File(com.anythink.dlopt.common.c.b.a(this.c) + f);
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            String strA = com.anythink.dlopt.common.c.b.a(file);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            String[] strArrSplit = strA.split("\\|");
            if (strArrSplit.length == 1) {
                this.o = Long.parseLong(strA);
            } else {
                this.o = Long.parseLong(strArrSplit[0]);
            }
            if (this.o > file2.length()) {
                this.o = 0L;
            } else {
                this.t = file2.length();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected final void a(ConnectTimeoutException connectTimeoutException) {
        b(f.a("10000", connectTimeoutException.getMessage()));
    }

    protected final void a(e eVar) {
        b(eVar);
    }

    protected final void d() {
        h();
        InterfaceC0112a interfaceC0112a = this.x;
        if (interfaceC0112a != null) {
            interfaceC0112a.a(this.a, this.u, this.t, this.n);
        }
    }

    protected final void e() {
        InterfaceC0112a interfaceC0112a = this.x;
        if (interfaceC0112a != null) {
            j jVar = this.a;
            interfaceC0112a.a(jVar, jVar.i);
        }
    }

    protected final void b(e eVar) {
        h();
        eVar.a();
        this.a.o();
        InterfaceC0112a interfaceC0112a = this.x;
        if (interfaceC0112a != null) {
            interfaceC0112a.a(this.a, eVar.b());
        }
    }

    static /* synthetic */ void a(a aVar) {
        File file = new File(com.anythink.dlopt.common.c.b.a(aVar.c) + g);
        File file2 = new File(com.anythink.dlopt.common.c.b.a(aVar.c) + f);
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            String strA = com.anythink.dlopt.common.c.b.a(file);
            String str = aVar.b;
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            String[] strArrSplit = strA.split("\\|");
            if (strArrSplit.length == 1) {
                aVar.o = Long.parseLong(strA);
            } else {
                aVar.o = Long.parseLong(strArrSplit[0]);
            }
            if (aVar.o > file2.length()) {
                aVar.o = 0L;
            } else {
                aVar.t = file2.length();
            }
            long j2 = aVar.o;
            long j3 = aVar.t;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
