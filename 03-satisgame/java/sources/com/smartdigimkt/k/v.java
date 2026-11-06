package com.smartdigimkt.k;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends t {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public long e;
    public final int f;
    public final int g;
    public final int h;
    public final w i;
    public final z j;

    public v(int i, String str, String str2, String str3, long j, int i2, int i3, int i4, y yVar, z zVar) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = yVar;
        this.j = zVar;
    }

    public final boolean b() {
        int i = this.j.i;
        if (i == 5) {
            y yVar = (y) this.i;
            yVar.getClass();
            if (yVar.b.incrementAndGet() == 1) {
                c0 c0Var = yVar.k.j;
                if (c0Var != null) {
                    c0Var.a(5);
                }
                yVar.b();
            }
            return true;
        }
        if (i != 4) {
            return false;
        }
        y yVar2 = (y) this.i;
        yVar2.getClass();
        if (yVar2.a.incrementAndGet() == 1) {
            c0 c0Var2 = yVar2.k.j;
            if (c0Var2 != null) {
                c0Var2.a(4);
            }
            yVar2.b();
        }
        return true;
    }

    @Override // com.smartdigimkt.k.t, java.lang.Runnable
    public final void run() {
        w wVar;
        int i;
        super.run();
        if (this.j == null || (wVar = this.i) == null) {
            return;
        }
        int i2 = this.g;
        if ((i2 > 0 && this.f == i2) || ((i = this.h) > 0 && i2 == i)) {
            ((y) wVar).a(this.h);
            ((y) this.i).a();
            return;
        }
        ((y) wVar).a(i);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.b).openConnection();
                    httpURLConnection = null;
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        if (TextUtils.isEmpty(this.d)) {
                            httpURLConnection2.addRequestProperty(RequestParamsUtils.USER_AGENT_KEY, this.d);
                        }
                        String str = "bytes=" + this.f + "-";
                        if (this.g > 0) {
                            str = "bytes=" + this.f + "-" + this.g;
                        }
                        httpURLConnection2.setRequestProperty("Range", str);
                        if (b()) {
                            try {
                                httpURLConnection2.disconnect();
                                return;
                            } catch (Throwable th) {
                                th.getMessage();
                                return;
                            }
                        }
                        long j = 0;
                        if (this.e <= 0) {
                            this.e = 60000L;
                        }
                        httpURLConnection2.setConnectTimeout((int) this.e);
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode != 200 && responseCode != 206) {
                            ((y) this.i).a(1, "statusCode=" + responseCode + " " + httpURLConnection2.getResponseMessage());
                            try {
                                httpURLConnection2.disconnect();
                                return;
                            } catch (Throwable th2) {
                                th2.getMessage();
                                return;
                            }
                        }
                        if (b()) {
                            try {
                                httpURLConnection2.disconnect();
                                return;
                            } catch (Throwable th3) {
                                th3.getMessage();
                                return;
                            }
                        }
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.c, "rws");
                        randomAccessFile.seek(this.h);
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int i3 = bufferedInputStream.read(bArr, 0, 1048576);
                            if (i3 == -1) {
                                randomAccessFile.close();
                                bufferedInputStream.close();
                                ((y) this.i).a();
                                httpURLConnection2.disconnect();
                                break;
                            }
                            if (b()) {
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Throwable th4) {
                                    th4.getMessage();
                                    return;
                                }
                            }
                            randomAccessFile.write(bArr, 0, i3);
                            j += (long) i3;
                            ((y) this.i).a(this.a, this.h, j);
                        }
                    } catch (ConnectException e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(4, "ConnectException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (SocketTimeoutException e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(2, "SocketTimeoutException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(3, "Exception: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(3, "OutOfMemoryError: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (StackOverflowError e5) {
                        e = e5;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(3, "StackOverflowError: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Error e6) {
                        e = e6;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(3, "Error: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (ConnectTimeoutException e7) {
                        e = e7;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(2, "ConnectTimeoutException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnection2;
                        ((y) this.i).a(3, "Throwable: " + th.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                } catch (Throwable th6) {
                    th6.getMessage();
                }
            } catch (OutOfMemoryError e8) {
                e = e8;
            } catch (StackOverflowError e9) {
                e = e9;
            } catch (Error e10) {
                e = e10;
            } catch (ConnectException e11) {
                e = e11;
            } catch (SocketTimeoutException e12) {
                e = e12;
            } catch (ConnectTimeoutException e13) {
                e = e13;
            } catch (Exception e14) {
                e = e14;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    th9.getMessage();
                }
            }
            throw th8;
        }
    }
}
