package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class am extends Observable implements x, Runnable {
    protected static final int i = 10240;
    protected static final int j = 10240;
    public static final String k = ".tmp";
    private static final String m = "FileDownloader";
    protected Context a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected x.a f;
    protected int g;
    protected int h;
    protected byte[] l;
    private boolean n;

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.l;
    }

    public am(Context context, URL url, String str, String str2, boolean z) {
        this.a = context;
        this.b = url;
        this.c = str;
        this.n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.d = str2;
        } else {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.e = -1;
        this.f = x.a.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a() {
        a(x.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public int j() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public float k() {
        return Math.abs((this.g / this.e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public x.a l() {
        return this.f;
    }

    protected void a(x.a aVar) {
        this.f = aVar;
        q();
    }

    protected void p() {
        be.a().a(this);
    }

    protected void a(int i2, float f) {
        this.g += i2;
        q();
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String g() {
        return this.c + this.d;
    }

    private void s() {
        a(x.a.ERROR);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        int i2;
        BufferedOutputStream bufferedOutputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        try {
            if (this.b != null && !cr.a().f(this.b.toString())) {
                cr.a().a((HttpURLConnection) null);
                return;
            }
            HttpURLConnection httpURLConnectionA = cr.a().a(this.b);
            try {
                httpURLConnectionA.setConnectTimeout(10000);
                httpURLConnectionA.setInstanceFollowRedirects(true);
                httpURLConnectionA.connect();
                int responseCode = httpURLConnectionA.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnectionA.setInstanceFollowRedirects(false);
                    httpURLConnectionA = a(httpURLConnectionA);
                    responseCode = httpURLConnectionA.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    s();
                }
                int contentLength = httpURLConnectionA.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream());
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(g() + ".tmp"));
                    try {
                        byte[] bArr = new byte[10240];
                        ByteArrayOutputStream byteArrayOutputStream2 = this.n ? new ByteArrayOutputStream() : null;
                        int i3 = 0;
                        while (this.f == x.a.DOWNLOADING && (i2 = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                            bufferedOutputStream2.write(bArr, 0, i2);
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.write(bArr, 0, i2);
                            }
                            i3 += i2;
                            a(i2, i3 / this.e);
                        }
                        bufferedOutputStream2.flush();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.flush();
                        }
                        if (this.f == x.a.DOWNLOADING) {
                            r();
                            a(x.a.COMPLETED);
                        } else {
                            x.a aVar = x.a.ERROR;
                        }
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e2) {
                            bu.a().c(m, e2.getMessage());
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e3) {
                                bu.a().c(m, e3.getMessage());
                            }
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                            bu.a().c(m, e4.getMessage());
                        }
                        cr.a().a(httpURLConnectionA);
                        return;
                    } catch (Exception e5) {
                        e = e5;
                        HttpURLConnection httpURLConnection2 = httpURLConnectionA;
                        byteArrayOutputStream = null;
                        bufferedOutputStream = bufferedOutputStream2;
                        httpURLConnection = httpURLConnection2;
                    } catch (Throwable th2) {
                        th = th2;
                        HttpURLConnection httpURLConnection3 = httpURLConnectionA;
                        byteArrayOutputStream = null;
                        bufferedOutputStream = bufferedOutputStream2;
                        httpURLConnection = httpURLConnection3;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e6) {
                                bu.a().c(m, e6.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e7) {
                                bu.a().c(m, e7.getMessage());
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e8) {
                                bu.a().c(m, e8.getMessage());
                            }
                        }
                        cr.a().a(httpURLConnection);
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    httpURLConnection = httpURLConnectionA;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnectionA;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e10) {
                httpURLConnection = httpURLConnectionA;
                e = e10;
                byteArrayOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                httpURLConnection = httpURLConnectionA;
                th = th4;
                byteArrayOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e11) {
            bufferedInputStream = null;
            httpURLConnection = null;
            e = e11;
            byteArrayOutputStream = null;
        } catch (Throwable th5) {
            bufferedInputStream = null;
            httpURLConnection = null;
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            bu.a().c(m, e.getMessage());
            s();
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e12) {
                    bu.a().c(m, e12.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e13) {
                    bu.a().c(m, e13.getMessage());
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e14) {
                    bu.a().c(m, e14.getMessage());
                }
            }
            cr.a().a(httpURLConnection);
        } catch (Throwable th6) {
            th = th6;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            cr.a().a(httpURLConnection);
            throw th;
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    protected void r() {
        bs.a(this.c + this.d + ".tmp", this.c + this.d);
    }
}
