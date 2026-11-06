package com.byazt.ryy;

import android.content.Context;
import com.byazt.ej.oa;
import com.byazt.qp.q;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, 26})
public class qg implements s {
    public static final HashMap<String, qg> n = new HashMap<>();
    public final l cp;
    public qg d;
    public File l;
    public oa oa;
    public File q;
    public volatile long qg;
    public RandomAccessFile tj;
    public long w;
    public final Object s = new Object();
    public volatile long x = -1;
    public volatile boolean fs = false;
    public volatile boolean rv = false;
    public AtomicBoolean sz = new AtomicBoolean(false);

    public qg(Context context, oa oaVar, l lVar) {
        this.qg = -2147483648L;
        this.w = 0L;
        this.tj = null;
        this.cp = lVar;
        this.oa = oaVar;
        try {
            this.q = com.byazt.udy.s.qg(lVar.l(), lVar.wm());
            this.l = com.byazt.udy.s.s(lVar.l(), lVar.wm());
            if (x()) {
                this.tj = new RandomAccessFile(this.l, "r");
            } else {
                this.tj = new RandomAccessFile(this.q, "rw");
            }
            if (x()) {
                return;
            }
            long length = this.q.length();
            this.w = length;
            if (length == lVar.cy() && this.w != 0) {
                boolean zN = com.byazt.nl.n.n(com.byazt.nl.n.n(this.q), lVar.wm());
                lVar.wm();
                if (zN) {
                    n(this.w);
                    this.qg = this.w;
                    return;
                }
            }
            if (!q()) {
                l();
                return;
            }
            synchronized (qg.class) {
                if (w()) {
                    fs();
                } else {
                    qg qgVar = this.d;
                    if (qgVar != null) {
                        this.qg = qgVar.n();
                    }
                }
            }
        } catch (Throwable unused) {
            Object[] objArr = new Object[3];
            lVar.ou();
        }
    }

    private boolean q() {
        RandomAccessFile randomAccessFile = this.tj;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            if (fileLockTryLock == null) {
                return true;
            }
            try {
                fileLockTryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private String l() {
        l lVar = this.cp;
        return lVar == null ? "" : lVar.wm();
    }

    private boolean w() {
        String strL = l();
        synchronized (qg.class) {
            HashMap<String, qg> map = n;
            qg qgVar = map.get(strL);
            this.d = qgVar;
            if (qgVar != null) {
                return false;
            }
            map.put(strL, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        String strL = l();
        synchronized (qg.class) {
            try {
                if (z) {
                    n.remove(strL);
                } else {
                    HashMap<String, qg> map = n;
                    if (map.get(strL) == this) {
                        map.remove(strL);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long n() {
        return this.qg;
    }

    private boolean x() {
        return this.l.exists() && this.l.length() > 0;
    }

    private void fs() {
        d.n nVar;
        if (com.byazt.iza.qg.s() != null) {
            nVar = com.byazt.iza.qg.s().qg();
        } else {
            nVar = new d.n("v_cache");
        }
        nVar.n(this.cp.hu(), TimeUnit.MILLISECONDS).qg(this.cp.h(), TimeUnit.MILLISECONDS).s(this.cp.t(), TimeUnit.MILLISECONDS);
        d dVarN = nVar.n();
        Object[] objArr = new Object[4];
        Long.valueOf(this.w);
        this.cp.wm();
        dVarN.n(new sz.n().n("RANGE", "bytes=" + this.w + "-").qg(this.cp.ou()).n().qg()).n(new com.byazt.tbt.s() { // from class: com.byazt.ryy.qg.1
            @Override // com.byazt.tbt.s
            public void onFailure(com.byazt.tbt.qg qgVar, IOException iOException) {
                qg.this.rv = false;
                qg.this.qg = -1L;
                qg.this.n(true);
            }

            /* JADX WARN: Code duplicated, block: B:164:0x02da A[Catch: all -> 0x030d, TryCatch #5 {all -> 0x030d, blocks: (B:162:0x02d5, B:164:0x02da, B:166:0x02df, B:167:0x02e2, B:169:0x02f4, B:173:0x0304), top: B:196:0x02d5 }] */
            /* JADX WARN: Code duplicated, block: B:166:0x02df A[Catch: all -> 0x030d, TryCatch #5 {all -> 0x030d, blocks: (B:162:0x02d5, B:164:0x02da, B:166:0x02df, B:167:0x02e2, B:169:0x02f4, B:173:0x0304), top: B:196:0x02d5 }] */
            /* JADX WARN: Code restructure failed: missing block: B:102:0x01c2, code lost:
            
                if (r7 == null) goto L104;
             */
            /* JADX WARN: Code restructure failed: missing block: B:103:0x01c4, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x01c7, code lost:
            
                if (r6 == null) goto L106;
             */
            /* JADX WARN: Code restructure failed: missing block: B:105:0x01c9, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x01cc, code lost:
            
                if (r21 == null) goto L108;
             */
            /* JADX WARN: Code restructure failed: missing block: B:107:0x01ce, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x01d1, code lost:
            
                r2 = r19.n.q.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:109:0x01e1, code lost:
            
                if (r19.n.rv == false) goto L226;
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x01eb, code lost:
            
                if (r2 != r19.n.qg) goto L227;
             */
            /* JADX WARN: Code restructure failed: missing block: B:113:0x01f1, code lost:
            
                if (r2 <= 0) goto L228;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x01f3, code lost:
            
                r0 = r19.n;
                r0.n(r0.qg);
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x01fc, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:226:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:227:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:228:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:229:?, code lost:
            
                return;
             */
            @Override // com.byazt.tbt.s
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.byazt.tbt.qg r20, com.byazt.tbt.cy r21) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 804
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.byazt.ryy.qg.AnonymousClass1.onResponse(com.byazt.tbt.qg, com.byazt.tbt.cy):void");
            }
        });
    }

    private void n(final long j, final long j2, final long j3, final long j4, boolean z, final long j5) {
        com.byazt.sf.s sVar;
        if ((z || this.sz.compareAndSet(false, true)) && (sVar = (com.byazt.sf.s) q.n("ad_log", q.qg(null))) != null) {
            sVar.n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.ryy.qg.2
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("scene", "video_wait");
                    JSONObject jSONObject3 = new JSONObject();
                    if (qg.this.oa != null) {
                        jSONObject3 = qg.this.oa.n();
                    }
                    try {
                        jSONObject3.put("totalLength", j);
                        jSONObject3.put("position", j2);
                        jSONObject3.put("cacheLength", j3);
                        jSONObject3.put("waitTime", j4);
                        if (qg.this.cp != null) {
                            jSONObject3.put("videoUrl", qg.this.cp.ou());
                        }
                        jSONObject3.put("startSaveLength", j5);
                    } catch (Exception unused) {
                    }
                    jSONObject2.putOpt("object", jSONObject3);
                    return jSONObject2;
                }
            });
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:? -> B:36:0x009b). Please report as a decompilation issue!!! */
    @Override // com.byazt.ryy.s
    public int n(long j, byte[] bArr, int i, int i2) throws IOException {
        long j2;
        try {
            if (j == this.qg) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            long j3 = -1;
            while (!this.fs) {
                Object obj = this.s;
                synchronized (obj) {
                    try {
                        long jRv = rv();
                        j2 = j3 == -1 ? jRv : j3;
                        try {
                            if (j < jRv) {
                                this.tj.seek(j);
                                i4 = this.tj.read(bArr, i, i2);
                            } else {
                                Object[] objArr = new Object[4];
                                Long.valueOf(j);
                                Long.valueOf(jRv);
                                i3 += 33;
                                this.s.wait(33L);
                                if (i3 >= 4000) {
                                    n(this.qg, j, jRv, i3, false, j2);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj;
                        throw th;
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    n(this.qg, j, rv(), i3, true, j2);
                    throw new SocketTimeoutException();
                }
                j3 = j2;
            }
            return -1;
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw th3;
            }
            throw new IOException();
        }
    }

    @Override // com.byazt.ryy.s
    public void qg() {
        try {
            if (!this.fs) {
                this.tj.close();
            }
            File file = this.q;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.l;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        n(false);
        synchronized (this.s) {
            this.fs = true;
        }
    }

    private long rv() {
        if (x()) {
            return this.l.length();
        }
        return this.q.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) throws IOException {
        synchronized (this.s) {
            if (this.l.exists() && this.l.length() >= j) {
                Object[] objArr = new Object[3];
                this.cp.ou();
                this.cp.wm();
                return;
            }
            try {
                if (!this.q.renameTo(this.l)) {
                    throw new IOException("Error renaming file " + this.q + " to " + this.l + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.tj;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.fs) {
                    this.tj = new RandomAccessFile(this.l, "rw");
                }
                Object[] objArr2 = new Object[3];
                this.cp.wm();
                this.cp.ou();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.ryy.s
    public long s() throws IOException {
        if (x()) {
            this.qg = this.l.length();
        } else {
            synchronized (this.s) {
                int i = 0;
                do {
                    if (this.qg == -2147483648L) {
                        try {
                            qg qgVar = this.d;
                            if (qgVar != null) {
                                this.qg = qgVar.n();
                            }
                            i += 15;
                            this.s.wait(5L);
                        } catch (InterruptedException unused) {
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        Object[] objArr = new Object[2];
        Long.valueOf(this.qg);
        return this.qg;
    }
}
