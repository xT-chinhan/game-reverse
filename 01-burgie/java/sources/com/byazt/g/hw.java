package com.byazt.g;

import android.content.Context;
import com.byazt.n.uc;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 13})
public class hw implements hn {
    public static final HashMap<String, hw> pr = new HashMap<>();
    public File c;
    public volatile long hw;
    public hw k;
    public com.byazt.n.hw m;
    public long uc;
    public RandomAccessFile vk;
    public final uc w;
    public File x;
    public final Object hn = new Object();
    public volatile long fw = -1;
    public volatile boolean zo = false;
    public volatile boolean aj = false;
    public AtomicBoolean g = new AtomicBoolean(false);

    public hw(Context context, com.byazt.n.hw hwVar, uc ucVar) {
        this.hw = -2147483648L;
        this.uc = 0L;
        this.vk = null;
        this.w = ucVar;
        this.m = hwVar;
        try {
            this.x = com.byazt.t.hn.hw(ucVar.c(), ucVar.fo());
            this.c = com.byazt.t.hn.hn(ucVar.c(), ucVar.fo());
            if (fw()) {
                this.vk = new RandomAccessFile(this.c, "r");
            } else {
                this.vk = new RandomAccessFile(this.x, "rw");
            }
            if (!fw()) {
                long length = this.x.length();
                this.uc = length;
                if (length == ucVar.nt() && this.uc != 0) {
                    boolean zPr = com.byazt.o.pr.pr(com.byazt.o.pr.pr(this.x), ucVar.fo());
                    ucVar.fo();
                    if (zPr) {
                        pr(this.uc);
                        this.hw = this.uc;
                        return;
                    }
                }
                if (!x()) {
                    c();
                    return;
                }
                synchronized (hw.class) {
                    if (uc()) {
                        zo();
                    } else {
                        hw hwVar2 = this.k;
                        if (hwVar2 != null) {
                            this.hw = hwVar2.pr();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Object[] objArr = {"Error using file ", ucVar.ny(), " as disc cache"};
        }
    }

    private boolean x() {
        RandomAccessFile randomAccessFile = this.vk;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException e) {
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
            } catch (IOException e2) {
                return true;
            }
        } catch (IOException e3) {
            return false;
        }
    }

    private String c() {
        uc ucVar = this.w;
        if (ucVar == null) {
            return "";
        }
        return ucVar.fo();
    }

    private boolean uc() {
        String strC = c();
        synchronized (hw.class) {
            HashMap<String, hw> map = pr;
            hw hwVar = map.get(strC);
            this.k = hwVar;
            if (hwVar != null) {
                return false;
            }
            map.put(strC, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        String strC = c();
        synchronized (hw.class) {
            try {
                if (z) {
                    pr.remove(strC);
                } else {
                    HashMap<String, hw> map = pr;
                    if (map.get(strC) == this) {
                        map.remove(strC);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long pr() {
        return this.hw;
    }

    private boolean fw() {
        return this.c.exists() && this.c.length() > 0;
    }

    private void zo() {
        k.pr prVar;
        if (com.byazt.y.hw.hn() != null) {
            prVar = com.byazt.y.hw.hn().hw();
        } else {
            prVar = new k.pr("v_cache");
        }
        prVar.pr(this.w.z(), TimeUnit.MILLISECONDS).hw(this.w.b(), TimeUnit.MILLISECONDS).hn(this.w.iu(), TimeUnit.MILLISECONDS);
        k kVarPr = prVar.pr();
        Object[] objArr = {"RANGE, bytes=", Long.valueOf(this.uc), " file hash=", this.w.fo()};
        kVarPr.pr(new g.pr().pr("RANGE", "bytes=" + this.uc + "-").pr(this.w.ny()).pr().hw()).pr(new com.byazt.nzn.hn() { // from class: com.byazt.g.hw.1
            @Override // com.byazt.nzn.hn
            public void onFailure(com.byazt.nzn.hw hwVar, IOException iOException) {
                hw.this.aj = false;
                hw.this.hw = -1L;
                hw.this.pr(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:111:0x01c0, code lost:
            
                r5 = 0;
                r12 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x01d7, code lost:
            
                if (r16 == null) goto L118;
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x01d9, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x01df, code lost:
            
                if (r7 == null) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x01e1, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x01e4, code lost:
            
                if (r21 == null) goto L122;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x01e6, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x01e9, code lost:
            
                r2 = r19.pr.x.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x01f9, code lost:
            
                if (r19.pr.aj == false) goto L246;
             */
            /* JADX WARN: Code restructure failed: missing block: B:125:0x0203, code lost:
            
                if (r2 != r19.pr.hw) goto L247;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:0x0209, code lost:
            
                if (r2 <= 0) goto L248;
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x020b, code lost:
            
                r0 = r19.pr;
                r0.pr(r0.hw);
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x0214, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:130:0x0215, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:246:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:248:?, code lost:
            
                return;
             */
            @Override // com.byazt.nzn.hn
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.byazt.nzn.hw r20, com.byazt.nzn.nt r21) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 903
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.byazt.g.hw.AnonymousClass1.onResponse(com.byazt.nzn.hw, com.byazt.nzn.nt):void");
            }
        });
    }

    private void pr(final long j, final long j2, final long j3, final long j4, boolean z, final long j5) {
        if (!z && !this.g.compareAndSet(false, true)) {
            return;
        }
        com.byazt.fu.hn hnVar = (com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null));
        if (hnVar != null) {
            hnVar.pr("exception", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.g.hw.2
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("scene", "video_wait");
                    JSONObject jSONObject3 = new JSONObject();
                    if (hw.this.m != null) {
                        jSONObject3 = hw.this.m.pr();
                    }
                    try {
                        jSONObject3.put("totalLength", j);
                        jSONObject3.put("position", j2);
                        jSONObject3.put("cacheLength", j3);
                        jSONObject3.put("waitTime", j4);
                        if (hw.this.w != null) {
                            jSONObject3.put("videoUrl", hw.this.w.ny());
                        }
                        jSONObject3.put("startSaveLength", j5);
                    } catch (Exception e) {
                    }
                    jSONObject2.putOpt("object", jSONObject3);
                    return jSONObject2;
                }
            });
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:? -> B:37:0x00b8). Please report as a decompilation issue!!! */
    @Override // com.byazt.g.hn
    public int pr(long j, byte[] bArr, int i, int i2) throws IOException {
        long j2;
        try {
            if (j == this.hw) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            long j3 = -1;
            while (!this.zo) {
                Object obj = this.hn;
                synchronized (obj) {
                    try {
                        long jAj = aj();
                        if (j3 != -1) {
                            j2 = j3;
                        } else {
                            j2 = jAj;
                        }
                        if (j < jAj) {
                            this.vk.seek(j);
                            i4 = this.vk.read(bArr, i, i2);
                            obj = obj;
                        } else {
                            Object[] objArr = {"read: wait at ", Long.valueOf(j), "  file size = ", Long.valueOf(jAj)};
                            int i5 = i3 + 33;
                            this.hn.wait(33L);
                            if (i5 >= 4000) {
                                pr(this.hw, j, jAj, i5, false, j2);
                            }
                            i3 = i5;
                        }
                        try {
                            if (i4 > 0) {
                                return i4;
                            }
                            if (i3 >= 10000) {
                                pr(this.hw, j, aj(), i3, true, j2);
                                throw new SocketTimeoutException();
                            }
                            j3 = j2;
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
            }
            return -1;
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw th3;
            }
            throw new IOException();
        }
    }

    @Override // com.byazt.g.hn
    public void hw() {
        try {
            if (!this.zo) {
                this.vk.close();
            }
            File file = this.x;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.c;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
        }
        pr(false);
        synchronized (this.hn) {
            this.zo = true;
        }
    }

    private long aj() {
        if (fw()) {
            return this.c.length();
        }
        return this.x.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j) throws IOException {
        synchronized (this.hn) {
            if (this.c.exists() && this.c.length() >= j) {
                Object[] objArr = {"complete: isCompleted ", this.w.ny(), this.w.fo()};
                return;
            }
            try {
                if (!this.x.renameTo(this.c)) {
                    throw new IOException("Error renaming file " + this.x + " to " + this.c + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.vk;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.zo) {
                    this.vk = new RandomAccessFile(this.c, "rw");
                }
                Object[] objArr2 = {"complete: rename ", this.w.fo(), this.w.ny()};
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.byazt.g.hn
    public long hn() throws IOException {
        if (fw()) {
            this.hw = this.c.length();
        } else {
            synchronized (this.hn) {
                int i = 0;
                do {
                    if (this.hw == -2147483648L) {
                        try {
                            hw hwVar = this.k;
                            if (hwVar != null) {
                                this.hw = hwVar.pr();
                            }
                            i += 15;
                            this.hn.wait(5L);
                        } catch (InterruptedException e) {
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        Object[] objArr = {"totalLength= ", Long.valueOf(this.hw)};
        return this.hw;
    }
}
