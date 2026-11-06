package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import com.taptap.sdk.update.download.core.Util;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class q5 extends Thread {
    public final r1 a;
    public final String b;
    public final File c;
    public final long d;
    public long e;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;

    public q5(r1 r1Var, String str, File file, long j, long j2) {
        this.b = str;
        this.c = file;
        this.a = r1Var;
        this.d = j;
        this.e = j2;
    }

    public final synchronized boolean a() {
        return this.h;
    }

    public final synchronized boolean b() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        RandomAccessFile randomAccessFile2;
        Throwable th;
        this.h = false;
        InputStream inputStream2 = null;
        randomAccessFile = null;
        randomAccessFile = null;
        RandomAccessFile randomAccessFile3 = null;
        try {
            HashMap map = new HashMap(1);
            map.put(Util.RANGE, "bytes=" + this.e + "-");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnectionA = e7.a(5000, this.b, map);
            if (httpURLConnectionA != null && !this.g) {
                inputStream = httpURLConnectionA.getInputStream();
                try {
                    try {
                        byte[] bArr = new byte[1048576];
                        randomAccessFile2 = new RandomAccessFile(this.c, "rwd");
                        try {
                            try {
                                r9.a("ssp_downloader", this.a.a, " cost:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), ", responseCode = ", Integer.valueOf(httpURLConnectionA.getResponseCode()), ", startPos = ", Long.valueOf(this.e), ", endPos = ", Long.valueOf(this.d), ", Content-Range = ", httpURLConnectionA.getHeaderField(Util.CONTENT_RANGE), ", Content-Length = ", Integer.valueOf(httpURLConnectionA.getContentLength()), ", local file size = ", Long.valueOf(randomAccessFile2.length()));
                                randomAccessFile2.seek(this.e);
                                while (true) {
                                    int i = inputStream.read(bArr, 0, 1048576);
                                    if (i != -1) {
                                        synchronized (this) {
                                            if (this.g) {
                                                this.h = true;
                                                String str = this.a.a;
                                            } else {
                                                randomAccessFile2.write(bArr, 0, i);
                                                long j = i;
                                                this.e += j;
                                                this.a.a(j);
                                            }
                                        }
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e) {
                                            r9.a("ssp_sdk", "ssp_downloader", e);
                                        }
                                        try {
                                            inputStream.close();
                                            return;
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } else {
                                        this.f = true;
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e3) {
                                            r9.a("ssp_sdk", "ssp_downloader", e3);
                                        }
                                        try {
                                            inputStream.close();
                                            return;
                                        } catch (Exception e4) {
                                            e = e4;
                                        }
                                    }
                                    r9.a("ssp_sdk", "ssp_downloader", e);
                                    return;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                randomAccessFile3 = randomAccessFile2;
                                this.h = true;
                                r9.a("ssp_downloader", this.a.a, e);
                                if (randomAccessFile3 != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (Exception e6) {
                                        r9.a("ssp_sdk", "ssp_downloader", e6);
                                    }
                                }
                                if (inputStream == null) {
                                    return;
                                }
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e7) {
                                    e = e7;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception e8) {
                                        r9.a("ssp_sdk", "ssp_downloader", e8);
                                    }
                                }
                                if (inputStream != null) {
                                    throw th;
                                }
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (Exception e9) {
                                    r9.a("ssp_sdk", "ssp_downloader", e9);
                                    throw th;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            randomAccessFile3 = randomAccessFile2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (inputStream != null) {
                                throw th;
                            }
                            inputStream.close();
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = randomAccessFile3;
                    inputStream2 = inputStream;
                    randomAccessFile2 = randomAccessFile;
                    inputStream = inputStream2;
                    th = th;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    if (inputStream != null) {
                        throw th;
                    }
                    inputStream.close();
                    throw th;
                }
            }
            r9.a("ssp_downloader", this.a.a, "network fail or isInterrupt.");
            this.h = true;
        } catch (Exception e12) {
            e = e12;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
            randomAccessFile2 = randomAccessFile;
            inputStream = inputStream2;
            th = th;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            if (inputStream != null) {
                throw th;
            }
            inputStream.close();
            throw th;
        }
    }
}
