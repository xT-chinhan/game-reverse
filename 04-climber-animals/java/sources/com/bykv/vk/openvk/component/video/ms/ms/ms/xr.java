package com.bykv.vk.openvk.component.video.ms.ms.ms;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class xr implements ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final HashMap<String, xr> f55ms = new HashMap<>();
    private long c;
    private RandomAccessFile ch;
    private File d;
    private final d hi;
    private File ka;
    private xr sl;
    private volatile long xr;
    private final Object ah = new Object();
    private volatile long ab = -1;
    private volatile boolean x = false;
    private volatile boolean ny = false;

    public xr(Context context, d dVar) {
        this.xr = -2147483648L;
        this.c = 0L;
        this.ch = null;
        this.hi = dVar;
        try {
            this.d = com.bykv.vk.openvk.component.video.ms.ka.ah.xr(dVar.ka(), dVar.h());
            this.ka = com.bykv.vk.openvk.component.video.ms.ka.ah.ah(dVar.ka(), dVar.h());
            if (x()) {
                this.ch = new RandomAccessFile(this.ka, t.k);
            } else {
                this.ch = new RandomAccessFile(this.d, "rw");
            }
            if (x()) {
                return;
            }
            this.c = this.d.length();
            if (!ka()) {
                com.bykv.vk.openvk.component.video.api.c.ah.xr("CSJ_MediaDLPlay", "no process lock, no download " + c());
                return;
            }
            synchronized (xr.class) {
                if (ab()) {
                    xr();
                } else {
                    xr xrVar = this.sl;
                    if (xrVar != null) {
                        this.xr = xrVar.ms();
                    }
                }
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.c.ah.xr("CSJ_MediaDLPlay", "Error using file ", dVar.ao(), " as disc cache");
        }
    }

    private boolean ka() {
        RandomAccessFile randomAccessFile = this.ch;
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

    private String c() {
        d dVar = this.hi;
        return dVar == null ? "" : dVar.h();
    }

    private boolean ab() {
        String strC = c();
        synchronized (xr.class) {
            HashMap<String, xr> map = f55ms;
            xr xrVar = map.get(strC);
            this.sl = xrVar;
            if (xrVar != null) {
                return false;
            }
            map.put(strC, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        String strC = c();
        synchronized (xr.class) {
            try {
                if (z) {
                    f55ms.remove(strC);
                } else {
                    HashMap<String, xr> map = f55ms;
                    if (map.get(strC) == this) {
                        map.remove(strC);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long ms() {
        return this.xr;
    }

    private boolean x() {
        return this.ka.exists() && this.ka.length() > 0;
    }

    public void xr() {
        sl.ms msVar;
        if (com.bykv.vk.openvk.component.video.api.ah.ah() != null) {
            msVar = com.bykv.vk.openvk.component.video.api.ah.ah().xr();
        } else {
            msVar = new sl.ms("v_cache");
        }
        msVar.ms(this.hi.y(), TimeUnit.MILLISECONDS).xr(this.hi.t(), TimeUnit.MILLISECONDS).ah(this.hi.nw(), TimeUnit.MILLISECONDS);
        sl slVarMs = msVar.ms();
        Object[] objArr = new Object[4];
        Long.valueOf(this.c);
        this.hi.h();
        slVarMs.ms(new u.ms().ms("RANGE", "bytes=" + this.c + "-").ms(this.hi.ao()).ms().xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bykv.vk.openvk.component.video.ms.ms.ms.xr.1
            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar, IOException iOException) {
                xr.this.ny = false;
                xr.this.xr = -1L;
                xr.this.ms(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:120:0x025d, code lost:
            
                if (r16 == null) goto L124;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x025f, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0263, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0265, code lost:
            
                if (r7 == null) goto L126;
             */
            /* JADX WARN: Code restructure failed: missing block: B:125:0x0267, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:0x026a, code lost:
            
                if (r21 == null) goto L128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:0x026c, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x026f, code lost:
            
                r2 = r19.f56ms.d.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x027f, code lost:
            
                if (r19.f56ms.ny == false) goto L249;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x0289, code lost:
            
                if (r2 != r19.f56ms.xr) goto L250;
             */
            /* JADX WARN: Code restructure failed: missing block: B:133:0x028f, code lost:
            
                if (r2 <= 0) goto L251;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0291, code lost:
            
                r0 = r19.f56ms;
                r0.ms(r0.xr);
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x029a, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:136:0x029b, code lost:
            
                com.bykv.vk.openvk.component.video.api.c.ah.xr("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x02a2, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:249:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:250:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:251:?, code lost:
            
                return;
             */
            @Override // com.bytedance.sdk.component.xr.ms.ah
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.xr.ms.xr r20, com.bytedance.sdk.component.xr.ms.ao r21) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 1018
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.ms.ms.ms.xr.AnonymousClass1.onResponse(com.bytedance.sdk.component.xr.ms.xr, com.bytedance.sdk.component.xr.ms.ao):void");
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.ms.ms.ms.ah
    public int ms(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.xr) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.x) {
                synchronized (this.ah) {
                    long jNy = ny();
                    if (j < jNy) {
                        this.ch.seek(j);
                        i4 = this.ch.read(bArr, i, i2);
                    } else {
                        Object[] objArr = new Object[4];
                        Long.valueOf(j);
                        Long.valueOf(jNy);
                        i3 += 33;
                        this.ah.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.ms.ms.ah
    public void ah() {
        try {
            if (!this.x) {
                this.ch.close();
            }
            File file = this.d;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.ka;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            try {
                com.bykv.vk.openvk.component.video.api.c.ah.xr("CSJ_MediaDLPlay", "close error", th);
            } catch (Throwable th2) {
                ms(false);
                throw th2;
            }
        }
        ms(false);
        synchronized (this.ah) {
            this.x = true;
        }
    }

    private long ny() {
        if (x()) {
            return this.ka.length();
        }
        return this.d.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j) throws IOException {
        synchronized (this.ah) {
            if (this.ka.exists() && this.ka.length() >= j) {
                Object[] objArr = new Object[3];
                this.hi.ao();
                this.hi.h();
                return;
            }
            try {
                if (!this.d.renameTo(this.ka)) {
                    throw new IOException("Error renaming file " + this.d + " to " + this.ka + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.ch;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.x) {
                    this.ch = new RandomAccessFile(this.ka, "rw");
                }
                Object[] objArr2 = new Object[3];
                this.hi.h();
                this.hi.ao();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.xr("CSJ_MediaDLPlay", "complete error", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.ms.ms.ah
    public long d() throws IOException {
        if (x()) {
            this.xr = this.ka.length();
        } else {
            synchronized (this.ah) {
                int i = 0;
                do {
                    if (this.xr == -2147483648L) {
                        try {
                            xr xrVar = this.sl;
                            if (xrVar != null) {
                                this.xr = xrVar.ms();
                            }
                            i += 15;
                            this.ah.wait(5L);
                        } catch (InterruptedException e) {
                            com.bytedance.sdk.component.utils.sl.ms(e);
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.xr));
        return this.xr;
    }
}
