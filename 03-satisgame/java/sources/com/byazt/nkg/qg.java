package com.byazt.nkg;

import android.content.Context;
import com.anythink.china.a.c;
import com.byazt.ej.k;
import com.byazt.ej.tj;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.hd;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1145, 26})
public class qg {
    public File l;
    public Context n;
    public File q;
    public k qg;
    public volatile boolean s = false;
    public final List<tj.n> w = new ArrayList();
    public volatile boolean x = false;

    public qg(Context context, k kVar) {
        this.q = null;
        this.l = null;
        this.n = context;
        this.qg = kVar;
        this.q = com.byazt.udy.s.qg(kVar.l(), kVar.wm());
        this.l = com.byazt.udy.s.s(kVar.l(), kVar.wm());
    }

    public void n(tj.n nVar) {
        if (this.x) {
            synchronized (tj.n.class) {
                this.w.add(nVar);
            }
            return;
        }
        this.w.add(nVar);
        if (qg()) {
            this.qg.rv(1);
            n(this.qg, 200);
            s.n(this.qg);
        } else {
            this.x = true;
            this.qg.rv(0);
            s();
        }
    }

    private boolean qg() {
        if (this.l.exists()) {
            return true;
        }
        return !this.qg.hd() && this.q.length() >= ((long) this.qg.x());
    }

    private void s() {
        d.n nVar;
        if (com.byazt.iza.qg.s() != null) {
            nVar = com.byazt.iza.qg.s().qg();
        } else {
            nVar = new d.n("v_preload");
        }
        nVar.n(this.qg.hu(), TimeUnit.MILLISECONDS).qg(this.qg.h(), TimeUnit.MILLISECONDS).s(this.qg.t(), TimeUnit.MILLISECONDS);
        d dVarN = nVar.n();
        sz.n nVar2 = new sz.n();
        final long length = this.q.length();
        int iX = this.qg.x();
        if (this.qg.hd()) {
            nVar2.n("RANGE", "bytes=" + length + "-").qg(this.qg.ou()).n().qg();
        } else {
            nVar2.n("RANGE", "bytes=" + length + "-" + iX).qg(this.qg.ou()).n().qg();
        }
        dVarN.n(nVar2.qg()).n(new com.byazt.tbt.s() { // from class: com.byazt.nkg.qg.1
            @Override // com.byazt.tbt.s
            public void onFailure(com.byazt.tbt.qg qgVar, IOException iOException) {
                qg qgVar2 = qg.this;
                qgVar2.n(qgVar2.qg, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                s.n(qg.this.qg);
            }

            /* JADX WARN: Code duplicated, block: B:72:0x016c A[Catch: all -> 0x0187, TryCatch #3 {all -> 0x0187, blocks: (B:70:0x015f, B:72:0x016c, B:73:0x0170), top: B:83:0x015f }] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r14v0 */
            /* JADX WARN: Type inference failed for: r14v1 */
            /* JADX WARN: Type inference failed for: r14v2 */
            /* JADX WARN: Type inference failed for: r14v3 */
            /* JADX WARN: Type inference failed for: r14v4 */
            /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable, java.io.RandomAccessFile] */
            /* JADX WARN: Type inference failed for: r14v6, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r14v7 */
            /* JADX WARN: Type inference failed for: r14v8 */
            /* JADX WARN: Type inference failed for: r14v9 */
            /* JADX WARN: Type inference failed for: r7v10 */
            /* JADX WARN: Type inference failed for: r7v11 */
            /* JADX WARN: Type inference failed for: r7v13 */
            /* JADX WARN: Type inference failed for: r7v14 */
            /* JADX WARN: Type inference failed for: r7v3 */
            /* JADX WARN: Type inference failed for: r7v6 */
            /* JADX WARN: Type inference failed for: r7v7 */
            /* JADX WARN: Type inference failed for: r7v9, types: [java.io.Closeable] */
            @Override // com.byazt.tbt.s
            public void onResponse(com.byazt.tbt.qg qgVar, cy cyVar) throws IOException {
                InputStream inputStreamS;
                ?? r14;
                int iQ;
                hd hdVarX;
                ?? randomAccessFile;
                long jN;
                ?? r15;
                long j = length;
                int i = 4;
                hd hdVar = null;
                ?? r7 = 0;
                hdVar = null;
                 = 0;
                ?? r8 = 0;
                if (cyVar != null) {
                    try {
                        boolean zL = cyVar.l();
                        if (zL) {
                            hdVarX = cyVar.x();
                            try {
                                hdVarX = cyVar.x();
                                if (!zL || hdVarX == null) {
                                    inputStreamS = null;
                                    jN = 0;
                                } else {
                                    jN = length + hdVarX.n();
                                    inputStreamS = hdVarX.s();
                                }
                                try {
                                    if (inputStreamS == null) {
                                        qg qgVar2 = qg.this;
                                        qgVar2.n(qgVar2.qg, cyVar.q(), cyVar.w());
                                        qg.this.n((Closeable) null);
                                    } else {
                                        randomAccessFile = new RandomAccessFile(qg.this.q, "rw");
                                        try {
                                            byte[] bArr = new byte[8192];
                                            long j2 = 0;
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = inputStreamS.read(bArr, i2, 8192 - i2);
                                                if (i3 == -1) {
                                                    if (qg.this.qg.hd() && jN == qg.this.q.length()) {
                                                        qg.this.l();
                                                    }
                                                    qg qgVar3 = qg.this;
                                                    qgVar3.n(qgVar3.qg, cyVar.q());
                                                    r7 = randomAccessFile;
                                                    qg.this.n((Closeable) r7);
                                                    qg.this.n(inputStreamS);
                                                    qg.this.n(hdVarX);
                                                    qg.this.n(cyVar);
                                                    Object[] objArr = new Object[4];
                                                } else if (qg.this.s) {
                                                    qg qgVar4 = qg.this;
                                                    qgVar4.qg(qgVar4.qg, cyVar.q());
                                                    qg.this.n((Closeable) randomAccessFile);
                                                    r8 = i3;
                                                } else {
                                                    i2 += i3;
                                                    j2 += (long) i3;
                                                    if (j2 % c.n == 0 || j2 == jN - length) {
                                                        com.byazt.udy.s.n(randomAccessFile, bArr, j, i2);
                                                        j += (long) i2;
                                                        i2 = 0;
                                                    }
                                                    i = 4;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            hdVar = hdVarX;
                                            r14 = randomAccessFile;
                                            iQ = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                            r15 = r14;
                                            try {
                                                qg.this.q();
                                                qg qgVar5 = qg.this;
                                                k kVar = qgVar5.qg;
                                                if (cyVar != null) {
                                                    iQ = cyVar.q();
                                                }
                                                qgVar5.n(kVar, iQ, th.getMessage());
                                                qg.this.n((Closeable) r15);
                                                qg.this.n(inputStreamS);
                                                qg.this.n(hdVar);
                                            } finally {
                                                qg.this.n((Closeable) r15);
                                                qg.this.n(inputStreamS);
                                                qg.this.n(hdVar);
                                                qg.this.n(cyVar);
                                                Object[] objArr2 = new Object[4];
                                                qg.this.qg.ou();
                                                Integer.valueOf(qg.this.qg.x());
                                                s.n(qg.this.qg);
                                            }
                                        }
                                    }
                                    qg.this.n(inputStreamS);
                                    qg.this.n(hdVarX);
                                } catch (Throwable th2) {
                                    th = th2;
                                    randomAccessFile = r8;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStreamS = null;
                                randomAccessFile = 0;
                            }
                        } else {
                            qg qgVar6 = qg.this;
                            qgVar6.n(qgVar6.qg, cyVar.q(), cyVar.w());
                            qg.this.n((Closeable) null);
                            qg.this.n((Closeable) null);
                            qg.this.n((Closeable) null);
                        }
                        qg.this.n(cyVar);
                        Object[] objArr3 = new Object[i];
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamS = null;
                        r14 = 0;
                    }
                } else {
                    try {
                        qg qgVar7 = qg.this;
                        k kVar2 = qgVar7.qg;
                        iQ = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                        try {
                            qgVar7.n(kVar2, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, "Network link failed.");
                            hdVarX = null;
                            inputStreamS = null;
                            qg.this.n((Closeable) r7);
                            qg.this.n(inputStreamS);
                            qg.this.n(hdVarX);
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamS = null;
                            r15 = 0;
                            qg.this.q();
                            qg qgVar8 = qg.this;
                            k kVar3 = qgVar8.qg;
                            if (cyVar != null) {
                                iQ = cyVar.q();
                            }
                            qgVar8.n(kVar3, iQ, th.getMessage());
                            qg.this.n((Closeable) r15);
                            qg.this.n(inputStreamS);
                            qg.this.n(hdVar);
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        iQ = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                    }
                    qg.this.n(cyVar);
                    Object[] objArr4 = new Object[4];
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public k n() {
        return this.qg;
    }

    public void n(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(k kVar, int i) {
        synchronized (tj.n.class) {
            for (tj.n nVar : this.w) {
                if (nVar != null) {
                    nVar.qg(kVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(k kVar, int i, String str) {
        synchronized (tj.n.class) {
            for (tj.n nVar : this.w) {
                if (nVar != null) {
                    nVar.n(kVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(k kVar, int i) {
        synchronized (tj.n.class) {
            for (tj.n nVar : this.w) {
                if (nVar != null) {
                    nVar.n(kVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            this.l.delete();
            this.q.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            if (this.q.renameTo(this.l)) {
            } else {
                throw new IOException("Error renaming file " + this.q + " to " + this.l + " for completion!");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
