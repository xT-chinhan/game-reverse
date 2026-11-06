package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final String aca;
    private final int amZ;
    private final f anW;
    private final int anY;
    private final long anh;
    long ani;
    private final long anj;
    private final com.kwad.framework.filedownloader.b.a ano;
    private final boolean anw;
    private final c aoo;
    private final com.kwad.framework.filedownloader.a.b aop;
    private com.kwad.framework.filedownloader.e.a aoq;
    private volatile long aor;
    private volatile long aos;
    private final long contentLength;
    private volatile boolean nf;

    /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    public final void pause() {
        this.nf = true;
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.aor = 0L;
        this.aos = 0L;
        this.anW = fVar;
        this.aca = str;
        this.aop = bVar;
        this.anw = z;
        this.aoo = cVar;
        this.anY = i2;
        this.amZ = i;
        this.ano = b.yc().ye();
        this.anh = aVar.anh;
        this.anj = aVar.anj;
        this.ani = aVar.ani;
        this.contentLength = aVar.contentLength;
    }

    public final void run() throws Throwable {
        com.kwad.framework.filedownloader.e.a aVarBJ;
        if (this.nf) {
            return;
        }
        long jB = com.kwad.framework.filedownloader.f.f.b(this.anY, this.aop);
        if (jB == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.amZ), Integer.valueOf(this.anY)));
        }
        long j = this.contentLength;
        if (j > 0 && jB != j) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.anj == 0 ? com.kwad.framework.filedownloader.f.f.c("range[%d-)", Long.valueOf(this.ani)) : com.kwad.framework.filedownloader.f.f.c("range[%d-%d)", Long.valueOf(this.ani), Long.valueOf(this.anj)), Long.valueOf(this.contentLength), Long.valueOf(jB), Integer.valueOf(this.amZ), Integer.valueOf(this.anY)));
        }
        long j2 = this.ani;
        try {
            boolean zYg = b.yc().yg();
            if (this.aoo != null && !zYg) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVarBJ = com.kwad.framework.filedownloader.f.f.bJ(this.aca);
            try {
                this.aoq = aVarBJ;
                if (zYg) {
                    aVarBJ.seek(this.ani);
                }
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.anY), Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani));
                }
                InputStream inputStream = this.aop.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.nf) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVarBJ);
                    return;
                }
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    aVarBJ.write(bArr, 0, i);
                    long j3 = i;
                    this.ani += j3;
                    this.anW.onProgress(j3);
                    yF();
                    if (this.nf) {
                        break;
                    } else if (this.anw && com.kwad.framework.filedownloader.f.f.zG()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                }
                if (aVarBJ != null) {
                    sync();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVarBJ);
                long j4 = this.ani - j2;
                if (jB != -1 && jB != j4) {
                    throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j4), Long.valueOf(jB), Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani), Long.valueOf(j2)));
                }
                this.anW.a(this.aoo, this.anh, this.anj);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVarBJ);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            aVarBJ = null;
        }
    }

    private void yF() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.ani - this.aor, jElapsedRealtime - this.aos)) {
            sync();
            this.aor = this.ani;
            this.aos = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aoq.zw();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.aoo != null) {
                this.ano.a(this.amZ, this.anY, this.ani);
            } else {
                this.anW.yo();
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.amZ), Integer.valueOf(this.anY), Long.valueOf(this.ani), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public static class a {
        String aca;
        Boolean anT;
        f anW;
        Integer anf;
        com.kwad.framework.filedownloader.download.a ang;
        Integer aoa;
        com.kwad.framework.filedownloader.a.b aop;
        c aot;

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.aop = bVar;
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.ang = aVar;
            return this;
        }

        public final a b(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a bv(String str) {
            this.aca = str;
            return this;
        }

        public final a bi(boolean z) {
            this.anT = Boolean.valueOf(z);
            return this;
        }

        public final a a(c cVar) {
            this.aot = cVar;
            return this;
        }

        public final a bO(int i) {
            this.aoa = Integer.valueOf(i);
            return this;
        }

        public final a bP(int i) {
            this.anf = Integer.valueOf(i);
            return this;
        }

        public final e yG() {
            if (this.anT == null || this.aop == null || this.ang == null || this.anW == null || this.aca == null || this.anf == null || this.aoa == null) {
                throw new IllegalArgumentException();
            }
            return new e(this.aop, this.ang, this.aot, this.anf.intValue(), this.aoa.intValue(), this.anT.booleanValue(), this.anW, this.aca, (byte) 0);
        }
    }
}
