package com.byazt.gi;

import android.os.Process;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.edb.aj;
import com.byazt.lhc.BaseException;
import com.byazt.lj.vk;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, 13})
public class hw implements Runnable {
    public static final String pr = hw.class.getSimpleName();
    public vk aj;
    public final DownloadTask c;
    public final uc fw;
    public com.byazt.auw.hw hn;
    public com.byazt.auw.hw hw;
    public boolean k;
    public DownloadInfo uc;
    public volatile boolean vk;
    public volatile boolean w;
    public com.byazt.lj.c x;
    public aj zo;

    public hw(com.byazt.auw.hw hwVar, DownloadTask downloadTask, uc ucVar) {
        this.k = false;
        this.hn = hwVar;
        this.c = downloadTask;
        if (downloadTask != null) {
            this.uc = downloadTask.getDownloadInfo();
        }
        this.fw = ucVar;
        this.aj = com.byazt.lj.hn.z();
        this.hn.pr(this);
    }

    public hw(com.byazt.auw.hw hwVar, DownloadTask downloadTask, aj ajVar, uc ucVar) {
        this(hwVar, downloadTask, ucVar);
        this.zo = ajVar;
    }

    private String hn() {
        return this.uc.getConnectionUrl();
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.hw = this.hn;
        while (true) {
            try {
                this.hw.pr(this);
                if (!pr(this.hw)) {
                    this.hw.pr(false);
                    break;
                }
                this.hw.pr(false);
                if (c()) {
                    break;
                }
                this.hw = this.fw.pr(this.hw.qa());
                if (c() || this.hw == null) {
                    break;
                } else {
                    Thread.sleep(50L);
                }
            } finally {
                com.byazt.auw.hw hwVar = this.hw;
                if (hwVar != null) {
                    hwVar.pr(false);
                }
                x();
                this.fw.pr(this);
            }
        }
    }

    public void pr(long j, long j2) {
        com.byazt.lj.c cVar = this.x;
        if (cVar == null) {
            return;
        }
        cVar.pr(j, j2);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:204:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c9 A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #8 {all -> 0x00d1, blocks: (B:40:0x00c1, B:43:0x00c9, B:53:0x00e1, B:56:0x00e9, B:33:0x0073, B:35:0x0077), top: B:202:0x00c1, inners: #10, #13 }] */
    private boolean pr(com.byazt.auw.hw hwVar) {
        long jG;
        long jNt;
        boolean z;
        long j;
        long jPr;
        int iHw;
        Throwable th;
        aj ajVar;
        aj ajVar2;
        int iHw2;
        com.byazt.auw.hw hwVarC;
        while (true) {
            com.byazt.auw.hw hwVar2 = (hwVar.x() && hwVar.uc() && (hwVarC = hwVar.c()) != null && hwVarC.qa() == hwVar.qa()) ? hwVarC : null;
            if (hwVar2 != null && hwVar2.aj()) {
                return true;
            }
            long jG2 = hwVar.g();
            long jNt2 = hwVar.nt();
            long jG3 = hwVar.g();
            if (hwVar2 != null) {
                jG3 = hwVar2.g();
                jG = hwVar2.g();
                jNt = hwVar2.nt();
            } else {
                jG = jG2;
                jNt = jNt2;
            }
            boolean z2 = false;
            try {
                if (c()) {
                    x();
                    return false;
                }
                String strHn = hn();
                boolean z3 = this.zo != null;
                this.k = z3;
                hwVar.hw(z3);
                try {
                    try {
                        try {
                            if (this.k) {
                                ajVar2 = this.zo;
                                if (ajVar2 != null) {
                                    iHw2 = ajVar2.hw();
                                    if (iHw2 >= 200) {
                                        this.fw.pr(this.zo);
                                    } else {
                                        this.fw.pr(this.zo);
                                    }
                                }
                            } else {
                                List<com.byazt.auw.hn> listPr = com.byazt.tuy.uc.pr(this.uc.getExtraHeaders(), this.uc.geteTag(), jG, jNt);
                                listPr.add(new com.byazt.auw.hn("Chunk-Index", String.valueOf(hwVar.qa())));
                                com.byazt.tuy.uc.pr(listPr, this.uc);
                                com.byazt.tuy.uc.hw(listPr, this.uc);
                                this.zo = com.byazt.lj.hn.pr(this.uc.isNeedDefaultHttpServiceBackUp(), this.uc.getMaxBytes(), strHn, listPr);
                                ajVar2 = this.zo;
                                if (ajVar2 != null && this.fw != null) {
                                    try {
                                        iHw2 = ajVar2.hw();
                                        if (iHw2 >= 200 || iHw2 >= 300) {
                                            this.fw.pr(this.zo);
                                        }
                                    } catch (Throwable th2) {
                                    }
                                }
                            }
                        } catch (BaseException e) {
                            e = e;
                            z2 = z;
                        }
                    } catch (BaseException e2) {
                        try {
                            throw e2;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            ajVar = this.zo;
                            if (ajVar != null) {
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        try {
                            com.byazt.tuy.uc.pr(th4, "ChunkRunnableConnection");
                            aj ajVar3 = this.zo;
                            if (ajVar3 != null && this.fw != null && ((iHw = ajVar3.hw()) < 200 || iHw >= 300)) {
                                this.fw.pr(this.zo);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th = th;
                            ajVar = this.zo;
                            if (ajVar != null || this.fw == null) {
                                throw th;
                            }
                            try {
                                int iHw3 = ajVar.hw();
                                if (iHw3 >= 200 && iHw3 < 300) {
                                    throw th;
                                }
                                this.fw.pr(this.zo);
                                throw th;
                            } catch (Throwable th6) {
                                throw th;
                            }
                        }
                    }
                    if (c()) {
                        x();
                        return false;
                    }
                    aj ajVar4 = this.zo;
                    if (ajVar4 == null) {
                        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                    }
                    if (!this.k) {
                        try {
                            int iHw4 = ajVar4.hw();
                            if (!com.byazt.tuy.uc.x(iHw4)) {
                                throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iHw4)));
                            }
                        } catch (BaseException e3) {
                            throw e3;
                        } catch (Throwable th7) {
                            com.byazt.tuy.uc.pr(th7, "ChunkRunnableGetResponseCode");
                        }
                        e = e;
                        z = false;
                        j = jG3;
                    }
                    z = false;
                    j = jG3;
                    this.x = new com.byazt.lj.c(this.uc, strHn, this.zo, hwVar, this.fw);
                    if (hwVar2 != null) {
                        this.x.pr(hwVar2.g(), hwVar2.nt(), (jNt == 0 || jNt < jG) ? hwVar2.hn(false) : (jNt - jG) + 1);
                    }
                    try {
                        this.x.x();
                        x();
                        return true;
                    } catch (BaseException e4) {
                        e = e4;
                        z2 = true;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    if (c()) {
                        x();
                        return true;
                    }
                    try {
                        com.byazt.tuy.uc.pr(th, "downloadChunkInner");
                    } catch (BaseException e5) {
                        this.fw.hw(e5);
                    }
                    x();
                    return z;
                }
            } catch (BaseException e6) {
                e = e6;
                z = false;
                j = jG3;
            } catch (Throwable th9) {
                th = th9;
                z = false;
                if (c()) {
                    x();
                    return true;
                }
                com.byazt.tuy.uc.pr(th, "downloadChunkInner");
                x();
                return z;
            }
            try {
                if (c()) {
                    x();
                    return true;
                }
                if (com.byazt.tuy.uc.hw(e)) {
                    this.fw.pr(e, z);
                    x();
                    return z;
                }
                if (!this.fw.pr(e)) {
                    if (!this.uc.isNeedChunkDowngradeRetry() || this.uc.isChunkDowngradeRetryUsed() || this.uc.getChunkCount() <= 1 || !com.byazt.tuy.uc.pr(e, this.uc)) {
                        this.fw.hw(e);
                        x();
                        return z;
                    }
                    this.fw.hn(e);
                    x();
                    return z;
                }
                if (com.byazt.tuy.uc.pr(e)) {
                    this.fw.pr(e, true);
                    x();
                    return z;
                }
                if (!z2) {
                    jPr = 0;
                } else {
                    if (this.x == null) {
                        this.fw.hw(e);
                        x();
                        return z;
                    }
                    if (com.byazt.tuy.pr.pr(32)) {
                        jPr = this.x.pr() - this.x.c();
                        if (jPr > 0) {
                            pr(hwVar, this.x.c());
                        } else if (jPr < 0) {
                            jPr = 0;
                        }
                    } else {
                        long jPr2 = this.x.pr() - j;
                        pr(hwVar, j);
                        jPr = jPr2;
                    }
                }
                if ((com.byazt.tuy.pr.pr(16) ? this.fw.pr(hwVar, e, jPr) : this.fw.pr(e, jPr)) == com.byazt.lhc.zo.RETURN) {
                    x();
                    return z;
                }
                hwVar.hw(z);
                x();
                x();
            } catch (Throwable th10) {
                x();
                throw th10;
            }
        }
    }

    private void pr(com.byazt.auw.hw hwVar, long j) {
        com.byazt.auw.hw hwVarC;
        if (hwVar.x()) {
            hwVarC = hwVar.c();
        } else {
            hwVarC = hwVar;
        }
        if (hwVarC != null) {
            if (hwVarC.zo()) {
                this.aj.pr(hwVarC.w(), hwVarC.hw(), j);
            }
            hwVarC.hw(j);
            this.aj.pr(hwVarC.w(), hwVarC.qa(), hwVarC.hw(), j);
            return;
        }
        if (hwVar.x()) {
            this.aj.pr(hwVar.w(), hwVar.qa(), j);
        }
    }

    private void x() {
        aj ajVar = this.zo;
        if (ajVar != null) {
            ajVar.x();
            this.zo = null;
        }
    }

    private boolean c() {
        return this.vk || this.w;
    }

    public void pr() {
        this.vk = true;
        com.byazt.lj.c cVar = this.x;
        if (cVar != null) {
            cVar.hw();
        }
    }

    public void hw() {
        this.w = true;
        com.byazt.lj.c cVar = this.x;
        if (cVar != null) {
            cVar.hn();
        }
    }
}
