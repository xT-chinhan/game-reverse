package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private static String xr = "ResponseHandler";
    private ch ab;
    private final DownloadInfo ah;
    private long ao;
    private final boolean b;
    private final com.ss.android.socialbase.downloader.network.ny c;
    private com.ss.android.socialbase.downloader.model.ka ch;
    private long cv;
    private final String d;
    private long g;
    private volatile long h;
    private BaseException hi;
    private final long i;
    private final com.ss.android.socialbase.downloader.model.xr ka;
    private long le;
    private final com.ss.android.socialbase.downloader.ms.ms nw;
    private t ny;
    private long op;
    private volatile long qv;
    private final long re;
    private volatile boolean sl;
    private final com.ss.android.socialbase.downloader.ab.ms t;
    private final com.ss.android.socialbase.downloader.x.c u;
    private long ub;
    private final boolean w;
    private com.ss.android.socialbase.downloader.impls.hi x;
    private final boolean y;
    private boolean yu;
    private volatile boolean zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    boolean f4664ms = false;
    private volatile long of = 0;
    private volatile long p = 0;

    private boolean xr(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public ka(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.ny nyVar, com.ss.android.socialbase.downloader.model.xr xrVar, com.ss.android.socialbase.downloader.x.c cVar) {
        this.ah = downloadInfo;
        this.d = str;
        ch chVarW = ah.w();
        this.ab = chVarW;
        if (chVarW instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) chVarW;
            this.x = dVar.ms();
            this.ny = dVar.c();
        }
        this.c = nyVar;
        this.ka = xrVar;
        this.u = cVar;
        long jU = xrVar.u();
        this.ub = jU;
        this.ao = jU;
        if (xrVar.d()) {
            this.qv = xrVar.h();
        } else {
            this.qv = xrVar.ah(false);
        }
        this.h = xrVar.ao();
        this.nw = com.ss.android.socialbase.downloader.ms.ms.ms();
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
        this.t = msVarMs;
        boolean z = msVarMs.ms("sync_strategy", 0) == 1;
        this.b = z;
        if (z) {
            long jMs = msVarMs.ms("sync_interval_ms_fg", 5000);
            long jMs2 = msVarMs.ms("sync_interval_ms_bg", 1000);
            this.re = Math.max(jMs, 500L);
            this.i = Math.max(jMs2, 500L);
        } else {
            this.re = 0L;
            this.i = 0L;
        }
        this.w = msVarMs.xr("monitor_rw") == 1;
        this.y = com.ss.android.socialbase.downloader.ny.ms.ms(65536);
    }

    public long ms() {
        return this.ub;
    }

    private boolean c() {
        return this.sl || this.zb;
    }

    public void xr() {
        if (this.sl) {
            return;
        }
        this.sl = true;
        ab();
    }

    public void ah() {
        if (this.zb) {
            return;
        }
        synchronized (this.u) {
            this.zb = true;
        }
        ab();
    }

    private void ab() {
        ExecutorService executorServiceSl;
        if (this.c == null || (executorServiceSl = ah.sl()) == null) {
            return;
        }
        executorServiceSl.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ka.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ka.this.c.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void ms(long j, long j2, long j3) {
        this.ub = j;
        this.ao = j;
        this.h = j2;
        this.qv = j3;
    }

    public void ms(long j, long j2) {
        this.h = j;
        this.qv = j2;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01c0 A[Catch: all -> 0x0221, BaseException -> 0x0223, TryCatch #36 {BaseException -> 0x0223, all -> 0x0221, blocks: (B:93:0x0193, B:94:0x01a0, B:101:0x01b8, B:103:0x01c0, B:105:0x01c8, B:107:0x01d0, B:109:0x01d8, B:111:0x01e3, B:115:0x01eb, B:119:0x01f7, B:123:0x01fd, B:124:0x0200, B:126:0x0212, B:127:0x0217, B:128:0x0218, B:129:0x021d, B:132:0x0220, B:95:0x01a1, B:97:0x01a5, B:100:0x01b7, B:99:0x01a9), top: B:362:0x0193, inners: #34, #36 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01c8 A[Catch: all -> 0x0221, BaseException -> 0x0223, TryCatch #36 {BaseException -> 0x0223, all -> 0x0221, blocks: (B:93:0x0193, B:94:0x01a0, B:101:0x01b8, B:103:0x01c0, B:105:0x01c8, B:107:0x01d0, B:109:0x01d8, B:111:0x01e3, B:115:0x01eb, B:119:0x01f7, B:123:0x01fd, B:124:0x0200, B:126:0x0212, B:127:0x0217, B:128:0x0218, B:129:0x021d, B:132:0x0220, B:95:0x01a1, B:97:0x01a5, B:100:0x01b7, B:99:0x01a9), top: B:362:0x0193, inners: #34, #36 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0301  */
    /* JADX WARN: Code duplicated, block: B:195:0x0305  */
    /* JADX WARN: Code duplicated, block: B:197:0x030a  */
    /* JADX WARN: Code duplicated, block: B:200:0x0311 A[Catch: all -> 0x0356, TryCatch #30 {all -> 0x0356, blocks: (B:198:0x030d, B:200:0x0311, B:201:0x0313, B:211:0x0328, B:212:0x0329, B:214:0x0332, B:202:0x0314, B:204:0x0318, B:206:0x0321, B:207:0x0324), top: B:355:0x030d, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0318 A[Catch: all -> 0x0326, TryCatch #7 {, blocks: (B:202:0x0314, B:204:0x0318, B:206:0x0321, B:207:0x0324), top: B:338:0x0314, outer: #30 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0321 A[Catch: all -> 0x0326, TryCatch #7 {, blocks: (B:202:0x0314, B:204:0x0318, B:206:0x0321, B:207:0x0324), top: B:338:0x0314, outer: #30 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0329 A[Catch: all -> 0x0356, TryCatch #30 {all -> 0x0356, blocks: (B:198:0x030d, B:200:0x0311, B:201:0x0313, B:211:0x0328, B:212:0x0329, B:214:0x0332, B:202:0x0314, B:204:0x0318, B:206:0x0321, B:207:0x0324), top: B:355:0x030d, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x0332 A[Catch: all -> 0x0356, TRY_LEAVE, TryCatch #30 {all -> 0x0356, blocks: (B:198:0x030d, B:200:0x0311, B:201:0x0313, B:211:0x0328, B:212:0x0329, B:214:0x0332, B:202:0x0314, B:204:0x0318, B:206:0x0321, B:207:0x0324), top: B:355:0x030d, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0363 A[Catch: all -> 0x04e0, TRY_ENTER, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0369 A[Catch: all -> 0x04e0, TRY_LEAVE, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x0375  */
    /* JADX WARN: Code duplicated, block: B:228:0x037a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0381 A[Catch: all -> 0x0451, TryCatch #21 {all -> 0x0451, blocks: (B:229:0x037d, B:231:0x0381, B:232:0x0383, B:242:0x0398, B:243:0x0399, B:245:0x03a2, B:233:0x0384, B:235:0x0388, B:237:0x0391, B:238:0x0394), top: B:348:0x037d, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0388 A[Catch: all -> 0x0396, TryCatch #28 {, blocks: (B:233:0x0384, B:235:0x0388, B:237:0x0391, B:238:0x0394), top: B:351:0x0384, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0391 A[Catch: all -> 0x0396, TryCatch #28 {, blocks: (B:233:0x0384, B:235:0x0388, B:237:0x0391, B:238:0x0394), top: B:351:0x0384, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0399 A[Catch: all -> 0x0451, TryCatch #21 {all -> 0x0451, blocks: (B:229:0x037d, B:231:0x0381, B:232:0x0383, B:242:0x0398, B:243:0x0399, B:245:0x03a2, B:233:0x0384, B:235:0x0388, B:237:0x0391, B:238:0x0394), top: B:348:0x037d, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x03a2 A[Catch: all -> 0x0451, TRY_LEAVE, TryCatch #21 {all -> 0x0451, blocks: (B:229:0x037d, B:231:0x0381, B:232:0x0383, B:242:0x0398, B:243:0x0399, B:245:0x03a2, B:233:0x0384, B:235:0x0388, B:237:0x0391, B:238:0x0394), top: B:348:0x037d, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x03ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:250:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:252:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:259:0x0450 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:301:0x04da A[Catch: all -> 0x04e0, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x0314 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:351:0x0384 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:379:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:380:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:381:0x0212 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0119 A[Catch: all -> 0x0107, BaseException -> 0x010e, TRY_ENTER, TRY_LEAVE, TryCatch #32 {BaseException -> 0x010e, all -> 0x0107, blocks: (B:48:0x0102, B:56:0x0119), top: B:368:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0129 A[Catch: all -> 0x02a2, BaseException -> 0x02a9, TRY_LEAVE, TryCatch #35 {BaseException -> 0x02a9, all -> 0x02a2, blocks: (B:54:0x0113, B:57:0x0125, B:59:0x0129), top: B:363:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0131  */
    /* JADX WARN: Code duplicated, block: B:81:0x0168  */
    /* JADX WARN: Code duplicated, block: B:83:0x016f A[Catch: all -> 0x0176, BaseException -> 0x017a, TRY_LEAVE, TryCatch #30 {BaseException -> 0x017a, all -> 0x0176, blocks: (B:66:0x013a, B:68:0x0141, B:70:0x014e, B:83:0x016f, B:91:0x0187), top: B:372:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0187 A[Catch: all -> 0x0176, BaseException -> 0x017a, TRY_ENTER, TRY_LEAVE, TryCatch #30 {BaseException -> 0x017a, all -> 0x0176, blocks: (B:66:0x013a, B:68:0x0141, B:70:0x014e, B:83:0x016f, B:91:0x0187), top: B:372:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01a9 A[Catch: all -> 0x021e, TryCatch #36 {, blocks: (B:95:0x01a1, B:97:0x01a5, B:100:0x01b7, B:99:0x01a9), top: B:360:0x01a1, outer: #36 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public void d() throws BaseException {
        long j;
        long j2;
        int iMs;
        com.ss.android.socialbase.downloader.ka.xr xrVarMs;
        com.ss.android.socialbase.downloader.network.ny nyVar;
        com.ss.android.socialbase.downloader.ab.ms msVar;
        DownloadInfo downloadInfo;
        String str;
        com.ss.android.socialbase.downloader.network.ny nyVar2;
        boolean z;
        boolean z2;
        BaseException baseException;
        long j3;
        com.ss.android.socialbase.downloader.network.ny nyVar3;
        boolean z3;
        boolean z4;
        com.ss.android.socialbase.downloader.network.ny nyVar4;
        String str2;
        DownloadInfo downloadInfo2;
        com.ss.android.socialbase.downloader.ab.ms msVar2;
        ?? r4;
        ?? r5;
        ?? r6;
        ?? r7;
        long j4;
        boolean z5;
        com.ss.android.socialbase.downloader.c.ms msVarMs;
        int i;
        com.ss.android.socialbase.downloader.ka.xr xrVar;
        com.ss.android.socialbase.downloader.ka.xr xrVar2;
        long j5;
        if (c() || this.ka == null) {
            return;
        }
        long jMs = com.ss.android.socialbase.downloader.ny.c.ms(this.c);
        ?? r8 = 0;
        if (jMs == 0) {
            throw new com.ss.android.socialbase.downloader.exception.c(1004, "the content-length is 0");
        }
        long jSl = this.ka.sl();
        long jNanoTime = System.nanoTime();
        boolean z6 = this.w;
        int i2 = 1;
        try {
            try {
                DownloadInfo downloadInfo3 = this.ah;
                String tempPath = downloadInfo3.getTempPath();
                String tempName = this.ah.getTempName();
                int i3 = -1;
                iMs = this.t.ms("flush_buffer_size_byte", -1);
                com.ss.android.socialbase.downloader.model.ka kaVarMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo3, tempPath, tempName, iMs);
                this.ch = kaVarMs;
                try {
                    try {
                        kaVarMs.ms(this.ub);
                        InputStream inputStreamMs = this.c.ms();
                        if (inputStreamMs == null) {
                            throw new BaseException(1042, new IOException("inputStream is null"));
                        }
                        this.ah.updateRealStartDownloadTime();
                        xrVarMs = ms(inputStreamMs);
                        try {
                            this.ah.setIsRwConcurrent(this.yu);
                            this.f4664ms = this.ah.getOpenLimitSpeed();
                            long j6 = com.ss.android.socialbase.downloader.constants.ka.d;
                            long j7 = com.ss.android.socialbase.downloader.constants.ka.ka;
                            long j8 = j6 / (1000 / j7);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long jNanoTime2 = 0;
                            long j9 = 0;
                            z6 = z6;
                            while (true) {
                                if (c()) {
                                    com.ss.android.socialbase.downloader.network.ny nyVar5 = this.c;
                                    if (nyVar5 != null) {
                                        nyVar5.d();
                                    }
                                    if (xrVarMs != null) {
                                        xrVarMs.xr();
                                    }
                                    try {
                                        if (this.y) {
                                            synchronized (this.u) {
                                                if (!this.zb) {
                                                    ms(this.x);
                                                    if (this.ch != null) {
                                                        x();
                                                    }
                                                }
                                            }
                                        } else {
                                            ms(this.x);
                                            if (this.ch != null) {
                                                x();
                                            }
                                        }
                                        Closeable[] closeableArr = new Closeable[i2];
                                        closeableArr[0] = this.ch;
                                        com.ss.android.socialbase.downloader.ny.c.ms(closeableArr);
                                        this.g = System.nanoTime() - jNanoTime;
                                        msVar2 = this.t;
                                        downloadInfo2 = this.ah;
                                        str2 = this.d;
                                        nyVar4 = this.c;
                                        z4 = this.sl;
                                        boolean z7 = this.zb;
                                        r4 = z6 ? 1 : 0;
                                        z3 = z7;
                                        com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                                    } catch (Throwable th) {
                                        Closeable[] closeableArr2 = new Closeable[i2];
                                        closeableArr2[0] = this.ch;
                                        com.ss.android.socialbase.downloader.ny.c.ms(closeableArr2);
                                        throw th;
                                    }
                                }
                                z5 = z6 ? 1 : 0;
                                if (!z5) {
                                    msVarMs = xrVarMs.ms();
                                    if (z5) {
                                        this.op += System.nanoTime() - jNanoTime2;
                                    }
                                    i = msVarMs.ah;
                                    if (i != i3) {
                                        j = jSl;
                                        j2 = jNanoTime;
                                        xrVar = xrVarMs;
                                        break;
                                    }
                                    if (this.ah.isIgnoreDataVerify()) {
                                        j = jSl;
                                        j2 = jNanoTime;
                                        xrVar2 = xrVarMs;
                                    } else {
                                        j = jSl;
                                        j2 = jNanoTime;
                                        xrVar2 = xrVarMs;
                                        if (this.qv > this.ub - this.ao) {
                                            i = (int) (this.qv - (this.ub - this.ao));
                                        }
                                    }
                                    if (z5) {
                                        jNanoTime2 = System.nanoTime();
                                    }
                                    this.ch.ms(msVarMs.f4619ms, 0, i);
                                    if (z5) {
                                        this.le += System.nanoTime() - jNanoTime2;
                                    }
                                    xrVar = xrVar2;
                                    xrVar.ms(msVarMs);
                                    j5 = i;
                                    this.ub += j5;
                                    j9 += j5;
                                    synchronized (this.u) {
                                        if (this.y) {
                                            boolean zXr = this.u.xr(j5);
                                            ms(this.x);
                                            ms(zXr);
                                        } else {
                                            boolean zXr2 = this.u.xr(j5);
                                            ms(this.x);
                                            ms(zXr2);
                                        }
                                        if (this.ah.isDownloadWithWifiValid()) {
                                            throw new com.ss.android.socialbase.downloader.exception.ah();
                                        }
                                        if (this.ah.isPauseReserveWithWifiValid()) {
                                            throw new com.ss.android.socialbase.downloader.exception.ka();
                                        }
                                        if (this.ah.isIgnoreDataVerify()) {
                                        }
                                        if (!this.f4664ms) {
                                        }
                                        z6 = z5;
                                        xrVarMs = xrVar;
                                        jNanoTime = j2;
                                        jSl = j;
                                        i3 = -1;
                                        i2 = 1;
                                    }
                                } else {
                                    try {
                                        jNanoTime2 = System.nanoTime();
                                        try {
                                            msVarMs = xrVarMs.ms();
                                            if (z5) {
                                                this.op += System.nanoTime() - jNanoTime2;
                                            }
                                            i = msVarMs.ah;
                                            if (i != i3) {
                                                j = jSl;
                                                j2 = jNanoTime;
                                                xrVar = xrVarMs;
                                                break;
                                            }
                                            if (this.ah.isIgnoreDataVerify()) {
                                                j = jSl;
                                                try {
                                                    j2 = jNanoTime;
                                                    try {
                                                        xrVar2 = xrVarMs;
                                                        try {
                                                            if (this.qv > this.ub - this.ao && this.qv < (this.ub - this.ao) + ((long) i)) {
                                                                i = (int) (this.qv - (this.ub - this.ao));
                                                            }
                                                        } catch (BaseException e) {
                                                            e = e;
                                                            xrVarMs = xrVar2;
                                                            r6 = z5;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            xrVarMs = xrVar2;
                                                            r8 = z5;
                                                            com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: e = ".concat(String.valueOf(th)));
                                                            if (c()) {
                                                                nyVar3 = this.c;
                                                                if (nyVar3 != null) {
                                                                    nyVar3.d();
                                                                }
                                                                if (xrVarMs != null) {
                                                                    xrVarMs.xr();
                                                                }
                                                                try {
                                                                    if (this.y) {
                                                                        synchronized (this.u) {
                                                                            if (!this.zb) {
                                                                                ms(this.x);
                                                                                if (this.ch != null) {
                                                                                    x();
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        ms(this.x);
                                                                        if (this.ch != null) {
                                                                            x();
                                                                        }
                                                                    }
                                                                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                                    r5 = r8;
                                                                    this.g = System.nanoTime() - j2;
                                                                    msVar2 = this.t;
                                                                    downloadInfo2 = this.ah;
                                                                    str2 = this.d;
                                                                    nyVar4 = this.c;
                                                                    z4 = this.sl;
                                                                    z3 = this.zb;
                                                                    r4 = r5;
                                                                    com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                                                                } catch (Throwable th3) {
                                                                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                                    throw th3;
                                                                }
                                                            }
                                                            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                                                                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                                            }
                                                            try {
                                                                com.ss.android.socialbase.downloader.ny.c.ms(th, "ResponseHandler");
                                                                nyVar = this.c;
                                                                if (nyVar != null) {
                                                                    nyVar.d();
                                                                }
                                                                if (xrVarMs != null) {
                                                                    xrVarMs.xr();
                                                                }
                                                                try {
                                                                    if (this.y) {
                                                                        synchronized (this.u) {
                                                                            if (!this.zb) {
                                                                                ms(this.x);
                                                                                if (this.ch != null) {
                                                                                    x();
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        ms(this.x);
                                                                        if (this.ch != null) {
                                                                            x();
                                                                        }
                                                                    }
                                                                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                                    this.g = System.nanoTime() - j2;
                                                                    msVar = this.t;
                                                                    downloadInfo = this.ah;
                                                                    str = this.d;
                                                                    nyVar2 = this.c;
                                                                    z = this.sl;
                                                                    z2 = this.zb;
                                                                    baseException = this.hi;
                                                                    j3 = this.ub - this.ao;
                                                                    r7 = r8;
                                                                    com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                                                                    if (this.ah.isIgnoreDataVerify()) {
                                                                        return;
                                                                    }
                                                                    j4 = this.ub - this.ao;
                                                                    if (j4 < 0) {
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                                    throw th4;
                                                                }
                                                            } catch (BaseException e2) {
                                                                this.hi = e2;
                                                                throw e2;
                                                            }
                                                        }
                                                    } catch (BaseException e3) {
                                                        e = e3;
                                                        r6 = z5;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        r8 = z5;
                                                        com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: e = ".concat(String.valueOf(th)));
                                                        if (c()) {
                                                            nyVar3 = this.c;
                                                            if (nyVar3 != null) {
                                                                nyVar3.d();
                                                            }
                                                            if (xrVarMs != null) {
                                                                xrVarMs.xr();
                                                            }
                                                            if (this.y) {
                                                                synchronized (this.u) {
                                                                    if (!this.zb) {
                                                                        ms(this.x);
                                                                        if (this.ch != null) {
                                                                            x();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                ms(this.x);
                                                                if (this.ch != null) {
                                                                    x();
                                                                }
                                                            }
                                                            com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                            r5 = r8;
                                                            this.g = System.nanoTime() - j2;
                                                            msVar2 = this.t;
                                                            downloadInfo2 = this.ah;
                                                            str2 = this.d;
                                                            nyVar4 = this.c;
                                                            z4 = this.sl;
                                                            z3 = this.zb;
                                                            r4 = r5;
                                                            com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                                                        }
                                                        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                                                            com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                                        }
                                                        com.ss.android.socialbase.downloader.ny.c.ms(th, "ResponseHandler");
                                                        nyVar = this.c;
                                                        if (nyVar != null) {
                                                            nyVar.d();
                                                        }
                                                        if (xrVarMs != null) {
                                                            xrVarMs.xr();
                                                        }
                                                        if (this.y) {
                                                            synchronized (this.u) {
                                                                if (!this.zb) {
                                                                    ms(this.x);
                                                                    if (this.ch != null) {
                                                                        x();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            ms(this.x);
                                                            if (this.ch != null) {
                                                                x();
                                                            }
                                                        }
                                                        com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                        this.g = System.nanoTime() - j2;
                                                        msVar = this.t;
                                                        downloadInfo = this.ah;
                                                        str = this.d;
                                                        nyVar2 = this.c;
                                                        z = this.sl;
                                                        z2 = this.zb;
                                                        baseException = this.hi;
                                                        j3 = this.ub - this.ao;
                                                        r7 = r8;
                                                        com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                                                        if (this.ah.isIgnoreDataVerify()) {
                                                            return;
                                                        }
                                                        j4 = this.ub - this.ao;
                                                        if (j4 < 0) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } catch (BaseException e4) {
                                                    e = e4;
                                                    j2 = jNanoTime;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    j2 = jNanoTime;
                                                }
                                            } else {
                                                j = jSl;
                                                j2 = jNanoTime;
                                                xrVar2 = xrVarMs;
                                            }
                                            if (z5) {
                                                jNanoTime2 = System.nanoTime();
                                            }
                                            try {
                                                this.ch.ms(msVarMs.f4619ms, 0, i);
                                                if (z5) {
                                                    this.le += System.nanoTime() - jNanoTime2;
                                                }
                                                xrVar = xrVar2;
                                                try {
                                                    xrVar.ms(msVarMs);
                                                    j5 = i;
                                                    this.ub += j5;
                                                    j9 += j5;
                                                    synchronized (this.u) {
                                                        if (this.y || !this.zb) {
                                                            boolean zXr3 = this.u.xr(j5);
                                                            ms(this.x);
                                                            ms(zXr3);
                                                        }
                                                    }
                                                    if (this.ah.isDownloadWithWifiValid()) {
                                                        throw new com.ss.android.socialbase.downloader.exception.ah();
                                                    }
                                                    if (this.ah.isPauseReserveWithWifiValid()) {
                                                        throw new com.ss.android.socialbase.downloader.exception.ka();
                                                    }
                                                    if (this.ah.isIgnoreDataVerify() && this.qv >= 0 && this.qv <= this.ub - this.ao) {
                                                        break;
                                                    }
                                                    if (!this.f4664ms && j9 > j8) {
                                                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                        if (jCurrentTimeMillis2 < j7) {
                                                            try {
                                                                Thread.sleep(j7 - jCurrentTimeMillis2);
                                                            } catch (InterruptedException e5) {
                                                                com.bytedance.sdk.openadsdk.api.ab.ms(e5);
                                                            }
                                                        }
                                                        jCurrentTimeMillis = System.currentTimeMillis();
                                                        j9 = 0;
                                                    }
                                                    z6 = z5;
                                                    xrVarMs = xrVar;
                                                    jNanoTime = j2;
                                                    jSl = j;
                                                    i3 = -1;
                                                    i2 = 1;
                                                } catch (BaseException e6) {
                                                    e = e6;
                                                    xrVarMs = xrVar;
                                                    r6 = z5;
                                                    com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
                                                    if (this.t.ms("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                                                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                                                    }
                                                    this.hi = e;
                                                    throw e;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    xrVarMs = xrVar;
                                                    r8 = z5;
                                                    com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: e = ".concat(String.valueOf(th)));
                                                    if (c()) {
                                                        nyVar3 = this.c;
                                                        if (nyVar3 != null) {
                                                            nyVar3.d();
                                                        }
                                                        if (xrVarMs != null) {
                                                            xrVarMs.xr();
                                                        }
                                                        if (this.y) {
                                                            synchronized (this.u) {
                                                                if (!this.zb) {
                                                                    ms(this.x);
                                                                    if (this.ch != null) {
                                                                        x();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            ms(this.x);
                                                            if (this.ch != null) {
                                                                x();
                                                            }
                                                        }
                                                        com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                        r5 = r8;
                                                        this.g = System.nanoTime() - j2;
                                                        msVar2 = this.t;
                                                        downloadInfo2 = this.ah;
                                                        str2 = this.d;
                                                        nyVar4 = this.c;
                                                        z4 = this.sl;
                                                        z3 = this.zb;
                                                        r4 = r5;
                                                        com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                                                    }
                                                    if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                                                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                                    }
                                                    com.ss.android.socialbase.downloader.ny.c.ms(th, "ResponseHandler");
                                                    nyVar = this.c;
                                                    if (nyVar != null) {
                                                        nyVar.d();
                                                    }
                                                    if (xrVarMs != null) {
                                                        xrVarMs.xr();
                                                    }
                                                    if (this.y) {
                                                        synchronized (this.u) {
                                                            if (!this.zb) {
                                                                ms(this.x);
                                                                if (this.ch != null) {
                                                                    x();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        ms(this.x);
                                                        if (this.ch != null) {
                                                            x();
                                                        }
                                                    }
                                                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                                    this.g = System.nanoTime() - j2;
                                                    msVar = this.t;
                                                    downloadInfo = this.ah;
                                                    str = this.d;
                                                    nyVar2 = this.c;
                                                    z = this.sl;
                                                    z2 = this.zb;
                                                    baseException = this.hi;
                                                    j3 = this.ub - this.ao;
                                                    r7 = r8;
                                                    com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                                                    if (this.ah.isIgnoreDataVerify()) {
                                                        return;
                                                    }
                                                    j4 = this.ub - this.ao;
                                                    if (j4 < 0) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } catch (BaseException e7) {
                                                e = e7;
                                                xrVar = xrVar2;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                xrVar = xrVar2;
                                            }
                                        } catch (BaseException e8) {
                                            e = e8;
                                            j2 = jNanoTime;
                                            r6 = z5;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            j = jSl;
                                            j2 = jNanoTime;
                                            r8 = z5;
                                        }
                                    } catch (BaseException e9) {
                                        e = e9;
                                        j2 = jNanoTime;
                                        r6 = z5;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        j = jSl;
                                        j2 = jNanoTime;
                                        r8 = z5;
                                        com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: e = ".concat(String.valueOf(th)));
                                        if (c()) {
                                            nyVar3 = this.c;
                                            if (nyVar3 != null) {
                                                nyVar3.d();
                                            }
                                            if (xrVarMs != null) {
                                                xrVarMs.xr();
                                            }
                                            if (this.y) {
                                                synchronized (this.u) {
                                                    if (!this.zb) {
                                                        ms(this.x);
                                                        if (this.ch != null) {
                                                            x();
                                                        }
                                                    }
                                                }
                                            } else {
                                                ms(this.x);
                                                if (this.ch != null) {
                                                    x();
                                                }
                                            }
                                            com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                            r5 = r8;
                                            this.g = System.nanoTime() - j2;
                                            msVar2 = this.t;
                                            downloadInfo2 = this.ah;
                                            str2 = this.d;
                                            nyVar4 = this.c;
                                            z4 = this.sl;
                                            z3 = this.zb;
                                            r4 = r5;
                                            com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                                        }
                                        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                                            com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                        }
                                        com.ss.android.socialbase.downloader.ny.c.ms(th, "ResponseHandler");
                                        nyVar = this.c;
                                        if (nyVar != null) {
                                            nyVar.d();
                                        }
                                        if (xrVarMs != null) {
                                            xrVarMs.xr();
                                        }
                                        if (this.y) {
                                            synchronized (this.u) {
                                                if (!this.zb) {
                                                    ms(this.x);
                                                    if (this.ch != null) {
                                                        x();
                                                    }
                                                }
                                            }
                                        } else {
                                            ms(this.x);
                                            if (this.ch != null) {
                                                x();
                                            }
                                        }
                                        com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                        this.g = System.nanoTime() - j2;
                                        msVar = this.t;
                                        downloadInfo = this.ah;
                                        str = this.d;
                                        nyVar2 = this.c;
                                        z = this.sl;
                                        z2 = this.zb;
                                        baseException = this.hi;
                                        j3 = this.ub - this.ao;
                                        r7 = r8;
                                        com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                                        if (this.ah.isIgnoreDataVerify()) {
                                            return;
                                        }
                                        j4 = this.ub - this.ao;
                                        if (j4 < 0) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                            }
                            com.ss.android.socialbase.downloader.network.ny nyVar6 = this.c;
                            if (nyVar6 != null) {
                                nyVar6.d();
                            }
                            if (xrVar != null) {
                                xrVar.xr();
                            }
                            try {
                                if (this.y) {
                                    synchronized (this.u) {
                                        if (!this.zb) {
                                            ms(this.x);
                                            if (this.ch != null) {
                                                x();
                                            }
                                        }
                                    }
                                } else {
                                    ms(this.x);
                                    if (this.ch != null) {
                                        x();
                                    }
                                }
                                com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                this.g = System.nanoTime() - j2;
                                msVar = this.t;
                                downloadInfo = this.ah;
                                str = this.d;
                                nyVar2 = this.c;
                                z = this.sl;
                                z2 = this.zb;
                                baseException = this.hi;
                                j3 = this.ub - this.ao;
                                r7 = z5;
                            } catch (Throwable th11) {
                                com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                                throw th11;
                            }
                        } catch (BaseException e10) {
                            e = e10;
                            j2 = jNanoTime;
                            r6 = z6;
                        } catch (Throwable th12) {
                            th = th12;
                            j = jSl;
                            j2 = jNanoTime;
                            r8 = z6;
                        }
                        com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                        if (this.ah.isIgnoreDataVerify()) {
                            return;
                        }
                        j4 = this.ub - this.ao;
                        if (j4 < 0 && this.qv >= 0 && this.qv != j4) {
                            throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j4), Long.valueOf(jMs), Long.valueOf(this.qv), Long.valueOf(j), Long.valueOf(this.h), Long.valueOf(this.ub), Long.valueOf(this.ao)));
                        }
                        return;
                    } catch (IOException e11) {
                        throw new BaseException(1054, e11);
                    }
                } catch (BaseException e12) {
                    e = e12;
                    xrVarMs = null;
                    r6 = iMs;
                } catch (Throwable th13) {
                    th = th13;
                    xrVarMs = null;
                    r8 = iMs;
                    com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: e = ".concat(String.valueOf(th)));
                    if (c()) {
                        nyVar3 = this.c;
                        if (nyVar3 != null) {
                            nyVar3.d();
                        }
                        if (xrVarMs != null) {
                            xrVarMs.xr();
                        }
                        if (this.y) {
                            synchronized (this.u) {
                                if (!this.zb) {
                                    ms(this.x);
                                    if (this.ch != null) {
                                        x();
                                    }
                                }
                            }
                        } else {
                            ms(this.x);
                            if (this.ch != null) {
                                x();
                            }
                        }
                        com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                        r5 = r8;
                        this.g = System.nanoTime() - j2;
                        msVar2 = this.t;
                        downloadInfo2 = this.ah;
                        str2 = this.d;
                        nyVar4 = this.c;
                        z4 = this.sl;
                        z3 = this.zb;
                        r4 = r5;
                        com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
                    }
                    if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    com.ss.android.socialbase.downloader.ny.c.ms(th, "ResponseHandler");
                    nyVar = this.c;
                    if (nyVar != null) {
                        nyVar.d();
                    }
                    if (xrVarMs != null) {
                        xrVarMs.xr();
                    }
                    if (this.y) {
                        synchronized (this.u) {
                            if (!this.zb) {
                                ms(this.x);
                                if (this.ch != null) {
                                    x();
                                }
                            }
                        }
                    } else {
                        ms(this.x);
                        if (this.ch != null) {
                            x();
                        }
                    }
                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                    this.g = System.nanoTime() - j2;
                    msVar = this.t;
                    downloadInfo = this.ah;
                    str = this.d;
                    nyVar2 = this.c;
                    z = this.sl;
                    z2 = this.zb;
                    baseException = this.hi;
                    j3 = this.ub - this.ao;
                    r7 = r8;
                    com.ss.android.socialbase.downloader.d.ms.ms(msVar, downloadInfo, str, nyVar2, z, z2, baseException, j3, this.g, r7, this.op, this.le, this.cv, null);
                    if (this.ah.isIgnoreDataVerify()) {
                        return;
                    }
                    j4 = this.ub - this.ao;
                    if (j4 < 0) {
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th14) {
                com.ss.android.socialbase.downloader.network.ny nyVar7 = this.c;
                if (nyVar7 != null) {
                    nyVar7.d();
                }
                if (xrVarMs != null) {
                    xrVarMs.xr();
                }
                try {
                    if (this.y) {
                        synchronized (this.u) {
                            if (!this.zb) {
                                ms(this.x);
                                if (this.ch != null) {
                                    x();
                                }
                            }
                        }
                    } else {
                        ms(this.x);
                        if (this.ch != null) {
                            x();
                        }
                    }
                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                    this.g = System.nanoTime() - j2;
                    com.ss.android.socialbase.downloader.d.ms.ms(this.t, this.ah, this.d, this.c, this.sl, this.zb, this.hi, this.ub - this.ao, this.g, r8, this.op, this.le, this.cv, null);
                    throw th14;
                } catch (Throwable th15) {
                    com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
                    throw th15;
                }
            }
        } catch (BaseException e13) {
            e = e13;
            j2 = jNanoTime;
            iMs = z6 ? 1 : 0;
        } catch (Throwable th16) {
            th = th16;
            j = jSl;
            j2 = jNanoTime;
            iMs = z6 ? 1 : 0;
        }
        xrVarMs = null;
        r6 = iMs;
        com.ss.android.socialbase.downloader.ah.ms.d(xr, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
        if (this.t.ms("ignore_base_ex_on_stop_status") || !c()) {
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            this.hi = e;
            throw e;
        }
        com.ss.android.socialbase.downloader.network.ny nyVar8 = this.c;
        if (nyVar8 != null) {
            nyVar8.d();
        }
        if (xrVarMs != null) {
            xrVarMs.xr();
        }
        try {
            if (this.y) {
                synchronized (this.u) {
                    if (!this.zb) {
                        ms(this.x);
                        if (this.ch != null) {
                            x();
                        }
                    }
                }
            } else {
                ms(this.x);
                if (this.ch != null) {
                    x();
                }
            }
            com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
            r5 = r6;
            this.g = System.nanoTime() - j2;
            msVar2 = this.t;
            downloadInfo2 = this.ah;
            str2 = this.d;
            nyVar4 = this.c;
            z4 = this.sl;
            z3 = this.zb;
            r4 = r5;
            com.ss.android.socialbase.downloader.d.ms.ms(msVar2, downloadInfo2, str2, nyVar4, z4, z3, this.hi, this.ub - this.ao, this.g, r4, this.op, this.le, this.cv, null);
        } catch (Throwable th17) {
            com.ss.android.socialbase.downloader.ny.c.ms(this.ch);
            throw th17;
        }
    }

    private com.ss.android.socialbase.downloader.ka.xr ms(InputStream inputStream) {
        int iF = ah.f();
        if (this.t.ms("rw_concurrent", 0) == 1 && this.ah.getChunkCount() == 1 && this.ah.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.ka.ms msVar = new com.ss.android.socialbase.downloader.ka.ms(inputStream, iF, this.t.ms("rw_concurrent_max_buffer_count", 4));
                this.yu = true;
                return msVar;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        com.ss.android.socialbase.downloader.ka.ah ahVar = new com.ss.android.socialbase.downloader.ka.ah(inputStream, iF);
        this.yu = false;
        return ahVar;
    }

    private void ms(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.p;
        if (this.b) {
            if (j <= (this.nw.xr() ? this.re : this.i)) {
                return;
            }
        } else {
            long j2 = this.ub - this.of;
            if (!z && !xr(j2, j)) {
                return;
            }
        }
        x();
        this.p = jUptimeMillis;
    }

    public long ka() {
        return this.of;
    }

    private void x() {
        boolean z;
        long jNanoTime = this.w ? System.nanoTime() : 0L;
        try {
            this.ch.ms();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.ah.updateRealDownloadTime(true);
            boolean z2 = this.ah.getChunkCount() > 1;
            zb zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(com.ss.android.socialbase.downloader.ny.c.xr());
            if (z2) {
                ms(this.ny);
                if (zbVarMs != null) {
                    zbVarMs.ah(this.ah);
                } else {
                    this.ny.ms(this.ah.getId(), this.ah.getCurBytes());
                }
            } else if (zbVarMs != null) {
                zbVarMs.ah(this.ah);
            } else {
                this.ny.ms(this.ka.hi(), this.ub);
            }
            this.of = this.ub;
        }
        if (this.w) {
            this.cv += System.nanoTime() - jNanoTime;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    private void ms(ch chVar) {
        zb zbVarMs;
        com.ss.android.socialbase.downloader.model.xr xrVarKa;
        boolean z;
        if (chVar == null) {
            return;
        }
        boolean z2 = chVar instanceof com.ss.android.socialbase.downloader.xr.ka;
        if (z2) {
            zbVarMs = com.ss.android.socialbase.downloader.impls.sl.ms(com.ss.android.socialbase.downloader.ny.c.xr());
            if (zbVarMs == null) {
                return;
            }
        } else {
            zbVarMs = null;
        }
        zb zbVar = zbVarMs;
        if (this.ka.d()) {
            xrVarKa = this.ka.ka();
        } else {
            xrVarKa = this.ka;
        }
        com.ss.android.socialbase.downloader.model.xr xrVar = xrVarKa;
        if (xrVar != null) {
            xrVar.xr(this.ub);
            if (z2 && zbVar != null) {
                zbVar.ms(xrVar.hi(), xrVar.y(), xrVar.xr(), this.ub);
            } else {
                chVar.ms(xrVar.hi(), xrVar.y(), xrVar.xr(), this.ub);
            }
            if (xrVar.x()) {
                if (xrVar.ny()) {
                    long jCh = xrVar.ch();
                    if (jCh > this.ub) {
                        if (z2 && zbVar != null) {
                            zbVar.ms(xrVar.hi(), xrVar.xr(), jCh);
                        } else {
                            chVar.ms(xrVar.hi(), xrVar.xr(), jCh);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
                if (z2 && zbVar != null) {
                    zbVar.ms(xrVar.hi(), xrVar.xr(), this.ub);
                    return;
                } else {
                    chVar.ms(xrVar.hi(), xrVar.xr(), this.ub);
                    return;
                }
            }
            return;
        }
        if (this.ka.d()) {
            if (z2 && zbVar != null) {
                zbVar.ms(this.ka.hi(), this.ka.y(), this.ub);
            } else {
                chVar.ms(this.ka.hi(), this.ka.y(), this.ub);
            }
        }
    }
}
