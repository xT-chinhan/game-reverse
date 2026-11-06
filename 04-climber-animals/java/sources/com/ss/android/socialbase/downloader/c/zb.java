package com.ss.android.socialbase.downloader.c;

import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tapsdk.tapad.e.a;
import com.umeng.analytics.pro.be;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
class zb implements Runnable {
    volatile long ab;
    final int ah;
    private com.ss.android.socialbase.downloader.model.d ao;
    private boolean az;
    private volatile long b;
    volatile long c;
    String ch;
    private int cv;
    volatile long d;
    private BaseException f;
    private int g;
    private final c hi;
    private volatile boolean i;
    private boolean jw;
    volatile long ka;
    private volatile boolean le;
    private com.ss.android.socialbase.downloader.ny.ka m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    volatile ny f4625ms;
    String ny;
    private int of;
    private Thread op;
    private long p;
    private int pc;
    private long qv;
    private Future re;
    private final ah sl;
    private volatile long t;
    private final com.ss.android.socialbase.downloader.ab.ms u;
    private com.ss.android.socialbase.downloader.network.ny ub;
    private boolean ul;
    private volatile boolean w;
    String x;
    h xr;
    private volatile long y;
    private volatile boolean yu;
    private final DownloadInfo zb;
    private final List<ny> h = new ArrayList();
    private volatile long nw = -1;

    zb(DownloadInfo downloadInfo, hi hiVar, ah ahVar, h hVar, int i) {
        this.zb = downloadInfo;
        this.hi = hiVar;
        this.sl = ahVar;
        this.u = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
        this.xr = hVar;
        this.ah = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        Process.setThreadPriority(10);
        try {
            this.op = Thread.currentThread();
            this.hi.ms(this);
            this.xr.ms(this);
            while (true) {
                ny nyVarMs = this.hi.ms(this, this.xr);
                if (nyVarMs == null) {
                    com.ss.android.socialbase.downloader.ah.ms.ah("SegmentReader", "no more segment, thread_index = " + this.ah);
                } else {
                    this.f4625ms = nyVarMs;
                    try {
                        try {
                            if (ms(nyVarMs)) {
                                this.h.add(nyVarMs);
                                this.f4625ms = null;
                                cVar2 = this.hi;
                                cVar2.ms(this, nyVarMs);
                            } else {
                                if (!this.i) {
                                    com.ss.android.socialbase.downloader.ah.ms.ka("SegmentReader", "download segment failed, segment = " + nyVarMs + ", thread_index = " + this.ah + ", failedException = " + this.f);
                                }
                                this.f4625ms = null;
                                cVar = this.hi;
                                cVar.ms(this, nyVarMs);
                            }
                        } catch (ch e) {
                            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                            int i = this.cv;
                            if (i >= 50) {
                                com.ss.android.socialbase.downloader.ah.ms.ka("SegmentReader", "segment apply failed " + this.cv + "times, thread_index = " + this.ah);
                                this.f4625ms = null;
                                cVar = this.hi;
                                cVar.ms(this, nyVarMs);
                            } else {
                                this.cv = i + 1;
                                this.f4625ms = null;
                                cVar2 = this.hi;
                            }
                        }
                    } catch (Throwable th) {
                        this.f4625ms = null;
                        this.hi.ms(this, nyVarMs);
                        throw th;
                    }
                }
                try {
                    this.xr.xr(this);
                    this.hi.xr(this);
                } catch (Throwable unused) {
                }
                this.op = null;
                return;
            }
        } catch (Throwable th2) {
            try {
                com.bytedance.sdk.openadsdk.api.ab.ms(th2);
            } finally {
                try {
                    this.xr.xr(this);
                    this.hi.xr(this);
                } catch (Throwable unused2) {
                }
                this.op = null;
            }
        }
    }

    private boolean ms(ny nyVar) throws BaseException {
        hi();
        while (true) {
            try {
                try {
                    xr(nyVar);
                    d(nyVar);
                    ny();
                    return true;
                } catch (ch e) {
                    this.f = e;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.ah.ms.ka("SegmentReader", "download: e = " + th + ", threadIndex = " + this.ah + ", reconnect = " + this.w + ", closed = " + this.i);
                    if (this.i) {
                        ny();
                        return false;
                    }
                    if (this.w) {
                        this.w = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                        }
                        if (this.yu) {
                            this.yu = false;
                            throw new ch(5, "download");
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.ny.c.ms((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !ms(nyVar, e)) {
                            ny();
                            return false;
                        }
                    }
                    ny();
                } catch (Throwable th3) {
                    ny();
                    throw th3;
                }
            }
        }
    }

    private void ny() {
        this.p = this.d;
        this.d = -1L;
        this.ka = -1L;
        this.c = -1L;
        this.ab = -1L;
        ch();
    }

    private void ch() {
        com.ss.android.socialbase.downloader.network.ny nyVar = this.ub;
        if (nyVar != null) {
            try {
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentReader", "closeConnection: thread = " + this.ah);
                nyVar.d();
                nyVar.ah();
            } catch (Throwable unused) {
            }
        }
    }

    private void hi() {
        this.jw = false;
        sl();
    }

    private void sl() {
        this.g = this.xr.d ? this.zb.getRetryCount() : this.zb.getBackUpUrlRetryCount();
        this.of = 0;
    }

    boolean ms(h hVar) {
        int i = this.pc;
        if (i >= 30) {
            return false;
        }
        this.pc = i + 1;
        h hVar2 = this.xr;
        if (hVar2 != null) {
            hVar2.xr(this);
        }
        hVar.ms(this);
        this.xr = hVar;
        sl();
        return true;
    }

    private boolean ms(ny nyVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.ah.ms.ka("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.of + ", retryCount = " + this.g);
        this.f = baseException;
        this.xr.xr();
        this.hi.ms(this, this.xr, nyVar, baseException, this.of, this.g);
        int i = this.of;
        if (i < this.g) {
            this.of = i + 1;
            return true;
        }
        if (ms(baseException)) {
            return true;
        }
        this.hi.ms(this, this.xr, nyVar, baseException);
        return false;
    }

    private boolean ms(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.ny.c.ah(baseException)) {
            return false;
        }
        String str = this.xr.f4615ms;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.zb.isNeedHttpsToHttpRetry() || this.jw) {
            return false;
        }
        this.jw = true;
        sl();
        return true;
    }

    private void xr(ny nyVar) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        ah(nyVar);
        this.hi.ms(this, nyVar, this.xr, this.ao);
        this.xr.ah();
    }

    private void ah(ny nyVar) throws BaseException {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.ka = 0L;
                this.d = jCurrentTimeMillis;
                this.qv = nyVar.ka();
                this.t = nyVar.c();
                if (this.t > 0 && this.qv > this.t) {
                    throw new ch(6, "createConn, ".concat(String.valueOf(nyVar)));
                }
                this.m = new com.ss.android.socialbase.downloader.ny.ka();
                List<com.ss.android.socialbase.downloader.model.ah> listMs = com.ss.android.socialbase.downloader.ny.c.ms(this.zb.getExtraHeaders(), this.zb.geteTag(), this.qv, this.t);
                listMs.add(new com.ss.android.socialbase.downloader.model.ah("Segment-Index", String.valueOf(nyVar.ab())));
                listMs.add(new com.ss.android.socialbase.downloader.model.ah("Thread-Index", String.valueOf(this.ah)));
                com.ss.android.socialbase.downloader.ny.c.ms(listMs, this.zb);
                com.ss.android.socialbase.downloader.ny.c.xr(listMs, this.zb);
                String strReplaceFirst = this.xr.f4615ms;
                if (this.jw && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("https", "http");
                }
                String str = this.xr.xr;
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + nyVar + ", threadIndex = " + this.ah);
                this.x = strReplaceFirst;
                this.ny = str;
                com.ss.android.socialbase.downloader.network.ny nyVarMs = com.ss.android.socialbase.downloader.downloader.ah.ms(this.zb.isNeedDefaultHttpServiceBackUp(), this.zb.getMaxBytes(), strReplaceFirst, str, listMs, 0, jCurrentTimeMillis - this.p > a.f && this.u.xr("monitor_download_connect") > 0, this.zb);
                if (nyVarMs == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.ub = nyVarMs;
                this.ao = new com.ss.android.socialbase.downloader.model.d(strReplaceFirst, nyVarMs);
                if (this.i) {
                    throw new ao("createConn");
                }
                if (nyVarMs instanceof com.ss.android.socialbase.downloader.network.ms) {
                    this.ch = ((com.ss.android.socialbase.downloader.network.ms) nyVarMs).ka();
                }
                com.bytedance.sdk.openadsdk.api.ab.ah("SegmentReader", "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.ch + ", threadIndex = " + this.ah);
                this.ka = System.currentTimeMillis();
            } catch (Throwable th) {
                this.ka = System.currentTimeMillis();
                throw th;
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th2) {
            com.ss.android.socialbase.downloader.ny.c.ms(th2, "createConn");
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x015a */
    /* JADX WARN: Code duplicated, block: B:131:0x0260  */
    /* JADX WARN: Code duplicated, block: B:167:0x02f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x0300 A[PHI: r15
      0x0300: PHI (r15v7 com.ss.android.socialbase.downloader.c.ms) = (r15v6 com.ss.android.socialbase.downloader.c.ms), (r15v9 com.ss.android.socialbase.downloader.c.ms) binds: [B:166:0x02f0, B:213:0x0300] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:173:0x0303  */
    /* JADX WARN: Code duplicated, block: B:176:0x0310  */
    /* JADX WARN: Code duplicated, block: B:178:0x031e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0327  */
    /* JADX WARN: Code duplicated, block: B:200:0x0354  */
    /* JADX WARN: Code duplicated, block: B:203:0x0361  */
    /* JADX WARN: Code duplicated, block: B:209:0x0377  */
    /* JADX WARN: Code duplicated, block: B:217:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x017e A[Catch: all -> 0x0271, BaseException -> 0x0273, TryCatch #22 {BaseException -> 0x0273, all -> 0x0271, blocks: (B:27:0x006e, B:28:0x0072, B:50:0x00da, B:88:0x016c, B:90:0x0177, B:91:0x017e, B:93:0x0184, B:95:0x018a, B:98:0x0193, B:99:0x0197, B:132:0x0262), top: B:239:0x005d }] */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x015b, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.ss.android.socialbase.downloader.c.ny r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 927
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.c.zb.d(com.ss.android.socialbase.downloader.c.ny):void");
    }

    private ms ms(ah ahVar, InputStream inputStream) throws Throwable {
        int i;
        ms msVarXr = ahVar.xr();
        try {
            i = inputStream.read(msVarXr.f4619ms);
            try {
                if (i == -1) {
                    throw new BaseException(1073, be.s);
                }
                msVarXr.ah = i;
                if (i == -1) {
                    ahVar.ms(msVarXr);
                }
                return msVarXr;
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    ahVar.ms(msVarXr);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    private long zb() {
        long j = this.y;
        this.y = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public boolean ms(long j) {
        long j2 = this.t;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.y = j;
        this.le = true;
        return true;
    }

    void ms() {
        h hVar = this.xr;
        try {
            synchronized (this.hi) {
                long jAh = ah();
                if (jAh > 0) {
                    this.b += jAh;
                    hVar.ms(jAh);
                }
                this.nw = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public long xr() {
        long jAh;
        synchronized (this.hi) {
            jAh = this.b + ah();
        }
        return jAh;
    }

    public long ah() {
        synchronized (this.hi) {
            long j = this.nw;
            long j2 = this.qv;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long d() {
        return this.nw;
    }

    public void ka() {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentReader", "close: threadIndex = " + this.ah);
        synchronized (this) {
            this.i = true;
            this.le = true;
        }
        ch();
        Future future = this.re;
        if (future != null) {
            this.re = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
    }

    public void c() {
        ms(false);
    }

    public void ms(boolean z) {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentReader", "reconnect: threadIndex = " + this.ah);
        synchronized (this) {
            this.yu = z;
            this.w = true;
            this.le = true;
        }
        ch();
        Thread thread = this.op;
        if (thread != null) {
            try {
                com.bytedance.sdk.openadsdk.api.ab.ah("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.ah);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    void ms(Future future) {
        this.re = future;
    }

    void xr(boolean z) {
        this.ul = z;
    }

    boolean ab() {
        return this.ul;
    }

    public void ah(boolean z) {
        this.az = z;
    }

    void xr(long j) {
        long j2 = this.nw;
        com.ss.android.socialbase.downloader.ny.ka kaVar = this.m;
        if (j2 < 0 || kaVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.ah);
        kaVar.ms(j2, j);
    }

    long ms(long j, long j2) {
        com.ss.android.socialbase.downloader.ny.ka kaVar = this.m;
        if (kaVar == null) {
            return -1L;
        }
        return kaVar.xr(j, j2);
    }

    long x() {
        return this.qv;
    }
}
