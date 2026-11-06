package com.ss.android.socialbase.downloader.x;

import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.ch;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.ny;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4803ms = "xr";
    private final c ab;
    private com.ss.android.socialbase.downloader.model.xr ah;
    private DownloadInfo c;
    private volatile boolean ch;
    private com.ss.android.socialbase.downloader.downloader.ka d;
    private volatile boolean hi;
    private final DownloadTask ka;
    private ch ny;
    private boolean sl;
    private ny x;
    private com.ss.android.socialbase.downloader.model.xr xr;

    public xr(com.ss.android.socialbase.downloader.model.xr xrVar, DownloadTask downloadTask, c cVar) {
        this.sl = false;
        this.ah = xrVar;
        this.ka = downloadTask;
        if (downloadTask != null) {
            this.c = downloadTask.getDownloadInfo();
        }
        this.ab = cVar;
        this.ny = com.ss.android.socialbase.downloader.downloader.ah.w();
        this.ah.ms(this);
    }

    public xr(com.ss.android.socialbase.downloader.model.xr xrVar, DownloadTask downloadTask, ny nyVar, c cVar) {
        this(xrVar, downloadTask, cVar);
        this.x = nyVar;
    }

    private String ah() {
        return this.c.getConnectionUrl();
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.xr = this.ah;
        while (true) {
            try {
                this.xr.ms(this);
                if (!ms(this.xr)) {
                    this.xr.ms(false);
                    break;
                }
                this.xr.ms(false);
                if (ka()) {
                    break;
                }
                this.xr = this.ab.ms(this.xr.y());
                if (ka() || this.xr == null) {
                    break;
                }
                try {
                    Thread.sleep(50L);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.model.xr xrVar = this.xr;
                if (xrVar != null) {
                    xrVar.ms(false);
                }
                d();
                this.ab.ms(this);
                throw th2;
            }
        }
        com.ss.android.socialbase.downloader.model.xr xrVar2 = this.xr;
        if (xrVar2 != null) {
            xrVar2.ms(false);
        }
        d();
        this.ab.ms(this);
    }

    public void ms(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.ka kaVar = this.d;
        if (kaVar == null) {
            return;
        }
        kaVar.ms(j, j2);
    }

    /* JADX WARN: Code duplicated, block: B:136:0x01d7 A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x01e6 A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x01ee A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ff A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0203 A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x020b A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x021c A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0226 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x0228  */
    /* JADX WARN: Code duplicated, block: B:158:0x0229 A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x023e A[PHI: r21
      0x023e: PHI (r21v1 long) = (r21v0 long), (r21v2 long), (r21v0 long) binds: [B:148:0x01fd, B:158:0x0229, B:157:0x0228] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:166:0x0248 A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x024f A[Catch: all -> 0x029a, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x025d A[Catch: all -> 0x029a, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9 A[Catch: all -> 0x01ae, BaseException -> 0x01ca, TRY_ENTER, TryCatch #15 {BaseException -> 0x01ca, all -> 0x01ae, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:45:0x00cb, B:60:0x00ef, B:64:0x00f9, B:66:0x00fd, B:77:0x012b, B:74:0x0123, B:76:0x012a, B:49:0x00d5, B:51:0x00d9), top: B:209:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fd A[Catch: all -> 0x01ae, BaseException -> 0x01ca, TRY_LEAVE, TryCatch #15 {BaseException -> 0x01ca, all -> 0x01ae, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:45:0x00cb, B:60:0x00ef, B:64:0x00f9, B:66:0x00fd, B:77:0x012b, B:74:0x0123, B:76:0x012a, B:49:0x00d5, B:51:0x00d9), top: B:209:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:70:0x010b  */
    /* JADX WARN: Code duplicated, block: B:71:0x010c A[Catch: all -> 0x0122, BaseException -> 0x0129, TryCatch #16 {BaseException -> 0x0129, all -> 0x0122, blocks: (B:68:0x0101, B:71:0x010c, B:72:0x0121), top: B:207:0x0101 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0141 A[Catch: all -> 0x01a9, BaseException -> 0x01ab, TryCatch #4 {all -> 0x01a9, blocks: (B:79:0x013a, B:81:0x0141, B:85:0x014d, B:86:0x0153, B:87:0x0164, B:93:0x0173, B:94:0x0181, B:102:0x018c, B:104:0x0190, B:112:0x01a5, B:113:0x01a8), top: B:197:0x013a }] */
    private boolean ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        com.ss.android.socialbase.downloader.model.xr xrVarKa;
        boolean z;
        long j;
        long jMs;
        com.ss.android.socialbase.downloader.exception.x xVarMs;
        Throwable th;
        ny nyVar;
        ny nyVar2;
        int iXr;
        long jAh;
        while (true) {
            if (!xrVar.d() || !xrVar.c() || (xrVarKa = xrVar.ka()) == null || xrVarKa.y() != xrVar.y()) {
                xrVarKa = null;
            }
            com.ss.android.socialbase.downloader.model.xr xrVar2 = xrVarKa;
            if (xrVar2 != null && xrVar2.ny()) {
                return true;
            }
            long jU = xrVar.u();
            long jAo = xrVar.ao();
            long jU2 = xrVar.u();
            if (xrVar2 != null) {
                jU2 = xrVar2.u();
                jU = xrVar2.u();
                jAo = xrVar2.ao();
            }
            long j2 = jU;
            long j3 = jAo;
            long jMs2 = 0;
            boolean z2 = false;
            try {
                if (ka()) {
                    d();
                    return false;
                }
                String strAh = ah();
                boolean z3 = this.x != null;
                this.sl = z3;
                xrVar.xr(z3);
                try {
                    if (!this.sl) {
                        List<com.ss.android.socialbase.downloader.model.ah> listMs = com.ss.android.socialbase.downloader.ny.c.ms(this.c.getExtraHeaders(), this.c.geteTag(), j2, j3);
                        listMs.add(new com.ss.android.socialbase.downloader.model.ah("Chunk-Index", String.valueOf(xrVar.y())));
                        com.ss.android.socialbase.downloader.ny.c.ms(listMs, this.c);
                        com.ss.android.socialbase.downloader.ny.c.xr(listMs, this.c);
                        this.x = com.ss.android.socialbase.downloader.downloader.ah.ms(this.c.isNeedDefaultHttpServiceBackUp(), this.c.getMaxBytes(), strAh, listMs);
                    }
                    ny nyVar3 = this.x;
                    if (nyVar3 != null && this.ab != null) {
                        try {
                            int iXr2 = nyVar3.xr();
                            if (iXr2 < 200 || iXr2 >= 300) {
                                this.ab.ms(this.x);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.bytedance.sdk.openadsdk.api.ab.ms(th);
                        }
                    }
                } catch (BaseException e) {
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        nyVar = this.x;
                        if (nyVar != null) {
                            throw th;
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    try {
                        com.ss.android.socialbase.downloader.ny.c.ms(th4, "ChunkRunnableConnection");
                        ny nyVar4 = this.x;
                        if (nyVar4 != null && this.ab != null) {
                            try {
                                int iXr3 = nyVar4.xr();
                                if (iXr3 < 200 || iXr3 >= 300) {
                                    this.ab.ms(this.x);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                            }
                        }
                        if (ka()) {
                            d();
                            return false;
                        }
                        nyVar2 = this.x;
                        if (nyVar2 != null) {
                            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                        }
                        if (!this.sl) {
                            try {
                                iXr = nyVar2.xr();
                                if (com.ss.android.socialbase.downloader.ny.c.d(iXr)) {
                                    throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iXr)));
                                }
                            } catch (BaseException e2) {
                                throw e2;
                            } catch (Throwable th6) {
                                com.ss.android.socialbase.downloader.ny.c.ms(th6, "ChunkRunnableGetResponseCode");
                            }
                        }
                        z = false;
                        j = jU2;
                        try {
                            try {
                                this.d = new com.ss.android.socialbase.downloader.downloader.ka(this.c, strAh, this.x, xrVar, this.ab);
                                if (xrVar2 != null) {
                                    jAh = xrVar2.ah(false);
                                    if (j3 != 0) {
                                        jAh = (j3 - j2) + 1;
                                    }
                                    this.d.ms(xrVar2.u(), xrVar2.ao(), jAh);
                                }
                                try {
                                    this.d.d();
                                    d();
                                    return true;
                                } catch (BaseException e3) {
                                    e = e3;
                                    z2 = true;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                if (ka()) {
                                    d();
                                    return true;
                                }
                                try {
                                    com.ss.android.socialbase.downloader.ny.c.ms(th, "downloadChunkInner");
                                } catch (BaseException e4) {
                                    this.ab.xr(e4);
                                }
                                d();
                                return z;
                            }
                        } catch (BaseException e5) {
                            e = e5;
                            z2 = false;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        th = th;
                        nyVar = this.x;
                        if (nyVar != null || this.ab == null) {
                            throw th;
                        }
                        try {
                            int iXr4 = nyVar.xr();
                            if (iXr4 >= 200 && iXr4 < 300) {
                                throw th;
                            }
                            this.ab.ms(this.x);
                            throw th;
                        } catch (Throwable th9) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(th9);
                            throw th;
                        }
                    }
                    if (ka()) {
                        d();
                        return true;
                    }
                    if (com.ss.android.socialbase.downloader.ny.c.xr(e)) {
                        this.ab.ms(e, z);
                        d();
                        return z;
                    }
                    if (this.ab.ms(e)) {
                        if (this.c.isNeedChunkDowngradeRetry()) {
                        }
                        this.ab.xr(e);
                        d();
                        return z;
                    }
                    if (com.ss.android.socialbase.downloader.ny.c.ms(e)) {
                        this.ab.ms(e, true);
                        d();
                        return z;
                    }
                    if (!z2) {
                        jMs = jMs2;
                    } else {
                        if (this.d != null) {
                            this.ab.xr(e);
                            d();
                            return z;
                        }
                        if (com.ss.android.socialbase.downloader.ny.ms.ms(32)) {
                            jMs = this.d.ms() - this.d.ka();
                            if (jMs > 0) {
                                ms(xrVar, this.d.ka());
                            } else if (jMs < 0) {
                            }
                        } else {
                            jMs2 = this.d.ms() - j;
                            ms(xrVar, j);
                        }
                        jMs = jMs2;
                    }
                    if (com.ss.android.socialbase.downloader.ny.ms.ms(16)) {
                        xVarMs = this.ab.ms(xrVar, e, jMs);
                    } else {
                        xVarMs = this.ab.ms(e, jMs);
                    }
                    if (xVarMs == com.ss.android.socialbase.downloader.exception.x.RETURN) {
                        d();
                        return z;
                    }
                    xrVar.xr(z);
                    d();
                    d();
                }
                if (ka()) {
                    d();
                    return false;
                }
                nyVar2 = this.x;
                if (nyVar2 != null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                if (!this.sl) {
                    iXr = nyVar2.xr();
                    if (com.ss.android.socialbase.downloader.ny.c.d(iXr)) {
                        throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iXr)));
                    }
                }
                z = false;
                j = jU2;
                this.d = new com.ss.android.socialbase.downloader.downloader.ka(this.c, strAh, this.x, xrVar, this.ab);
                if (xrVar2 != null) {
                    jAh = xrVar2.ah(false);
                    if (j3 != 0 && j3 >= j2) {
                        jAh = (j3 - j2) + 1;
                    }
                    this.d.ms(xrVar2.u(), xrVar2.ao(), jAh);
                }
                this.d.d();
                d();
                return true;
            } catch (BaseException e6) {
                e = e6;
                z = false;
                j = jU2;
            } catch (Throwable th10) {
                th = th10;
                z = false;
            }
            try {
                if (ka()) {
                    d();
                    return true;
                }
                if (com.ss.android.socialbase.downloader.ny.c.xr(e)) {
                    this.ab.ms(e, z);
                    d();
                    return z;
                }
                if (this.ab.ms(e)) {
                    if (this.c.isNeedChunkDowngradeRetry() || this.c.isChunkDowngradeRetryUsed() || this.c.getChunkCount() <= 1 || !com.ss.android.socialbase.downloader.ny.c.ms(e, this.c)) {
                        this.ab.xr(e);
                        d();
                        return z;
                    }
                    this.ab.ah(e);
                    d();
                    return z;
                }
                if (com.ss.android.socialbase.downloader.ny.c.ms(e)) {
                    this.ab.ms(e, true);
                    d();
                    return z;
                }
                if (!z2) {
                    jMs = jMs2;
                } else {
                    if (this.d != null) {
                        this.ab.xr(e);
                        d();
                        return z;
                    }
                    if (com.ss.android.socialbase.downloader.ny.ms.ms(32)) {
                        jMs = this.d.ms() - this.d.ka();
                        if (jMs > 0) {
                            ms(xrVar, this.d.ka());
                        } else if (jMs < 0) {
                        }
                    } else {
                        jMs2 = this.d.ms() - j;
                        ms(xrVar, j);
                    }
                    jMs = jMs2;
                }
                if (com.ss.android.socialbase.downloader.ny.ms.ms(16)) {
                    xVarMs = this.ab.ms(xrVar, e, jMs);
                } else {
                    xVarMs = this.ab.ms(e, jMs);
                }
                if (xVarMs == com.ss.android.socialbase.downloader.exception.x.RETURN) {
                    d();
                    return z;
                }
                xrVar.xr(z);
                d();
                d();
            } catch (Throwable th11) {
                d();
                throw th11;
            }
        }
    }

    private void ms(com.ss.android.socialbase.downloader.model.xr xrVar, long j) {
        com.ss.android.socialbase.downloader.model.xr xrVarKa = xrVar.d() ? xrVar.ka() : xrVar;
        if (xrVarKa != null) {
            if (xrVarKa.x()) {
                this.ny.ms(xrVarKa.hi(), xrVarKa.xr(), j);
            }
            xrVarKa.xr(j);
            this.ny.ms(xrVarKa.hi(), xrVarKa.y(), xrVarKa.xr(), j);
            return;
        }
        if (xrVar.d()) {
            this.ny.ms(xrVar.hi(), xrVar.y(), j);
        }
    }

    private void d() {
        ny nyVar = this.x;
        if (nyVar != null) {
            nyVar.d();
            this.x = null;
        }
    }

    private boolean ka() {
        return this.ch || this.hi;
    }

    public void ms() {
        this.ch = true;
        com.ss.android.socialbase.downloader.downloader.ka kaVar = this.d;
        if (kaVar != null) {
            kaVar.xr();
        }
    }

    public void xr() {
        this.hi = true;
        com.ss.android.socialbase.downloader.downloader.ka kaVar = this.d;
        if (kaVar != null) {
            kaVar.ah();
        }
    }
}
