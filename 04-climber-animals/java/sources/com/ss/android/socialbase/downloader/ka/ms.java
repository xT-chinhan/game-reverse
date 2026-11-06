package com.ss.android.socialbase.downloader.ka;

import android.os.Process;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.c.ao;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.ny.c;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements xr {
    private com.ss.android.socialbase.downloader.c.ms ab;
    private final int ah;
    private int ao;
    private com.ss.android.socialbase.downloader.c.ms c;
    private com.ss.android.socialbase.downloader.c.ms ch;
    private com.ss.android.socialbase.downloader.c.ms hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final InputStream f4706ms;
    private com.ss.android.socialbase.downloader.c.ms ny;
    private volatile boolean sl;
    private volatile Throwable u;
    private volatile Future ub;
    private com.ss.android.socialbase.downloader.c.ms x;
    private final int xr;
    private volatile boolean zb;
    private final Object d = new Object();
    private final Object ka = new Object();
    private final Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.ka.ms.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.c.ms msVarD;
            Process.setThreadPriority(10);
            do {
                try {
                    msVarD = ms.this.d();
                    msVarD.ah = ms.this.f4706ms.read(msVarD.f4619ms);
                    ms.this.ah(msVarD);
                } catch (Throwable th) {
                    try {
                        ms.this.u = th;
                        ab.ms(th);
                        synchronized (ms.this.ka) {
                            ms.this.zb = true;
                            ms.this.ka.notify();
                            c.ms(ms.this.f4706ms);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (ms.this.ka) {
                            ms.this.zb = true;
                            ms.this.ka.notify();
                            c.ms(ms.this.f4706ms);
                            throw th2;
                        }
                    }
                }
            } while (msVarD.ah != -1);
            synchronized (ms.this.ka) {
                ms.this.zb = true;
                ms.this.ka.notify();
            }
            c.ms(ms.this.f4706ms);
        }
    };

    public ms(InputStream inputStream, int i, int i2) throws Throwable {
        this.f4706ms = inputStream;
        this.xr = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.ah = i2;
        ah();
    }

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public com.ss.android.socialbase.downloader.c.ms ms() throws InterruptedException, BaseException {
        return ka();
    }

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public void ms(com.ss.android.socialbase.downloader.c.ms msVar) {
        xr(msVar);
    }

    @Override // com.ss.android.socialbase.downloader.ka.xr
    public void xr() {
        synchronized (this.d) {
            this.sl = true;
            this.d.notify();
        }
        Future future = this.ub;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.ub = null;
        }
    }

    private void ah() throws Throwable {
        this.ub = com.ss.android.socialbase.downloader.downloader.ah.h().submit(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.c.ms d() throws InterruptedException, ao {
        int i;
        com.ss.android.socialbase.downloader.c.ms msVar = this.x;
        if (msVar != null) {
            if (this.sl) {
                throw new ao("");
            }
            this.x = msVar.d;
            msVar.d = null;
            return msVar;
        }
        synchronized (this.d) {
            if (this.sl) {
                throw new ao("");
            }
            com.ss.android.socialbase.downloader.c.ms msVar2 = this.c;
            if (msVar2 == null && (i = this.ao) < this.ah) {
                this.ao = i + 1;
                return new com.ss.android.socialbase.downloader.c.ms(this.xr);
            }
            while (msVar2 == null) {
                this.d.wait();
                if (this.sl) {
                    throw new ao("");
                }
                msVar2 = this.c;
            }
            this.x = msVar2.d;
            this.ab = null;
            this.c = null;
            msVar2.d = null;
            return msVar2;
        }
    }

    private void xr(com.ss.android.socialbase.downloader.c.ms msVar) {
        synchronized (this.d) {
            com.ss.android.socialbase.downloader.c.ms msVar2 = this.ab;
            if (msVar2 == null) {
                this.ab = msVar;
                this.c = msVar;
                this.d.notify();
            } else {
                msVar2.d = msVar;
                this.ab = msVar;
            }
        }
    }

    private com.ss.android.socialbase.downloader.c.ms ka() throws InterruptedException, BaseException {
        com.ss.android.socialbase.downloader.c.ms msVar;
        com.ss.android.socialbase.downloader.c.ms msVar2 = this.hi;
        if (msVar2 != null) {
            this.hi = msVar2.d;
            msVar2.d = null;
            return msVar2;
        }
        synchronized (this.ka) {
            msVar = this.ny;
            if (msVar == null) {
                do {
                    if (this.zb) {
                        c();
                    }
                    this.ka.wait();
                    msVar = this.ny;
                } while (msVar == null);
            }
            this.hi = msVar.d;
            this.ch = null;
            this.ny = null;
            msVar.d = null;
        }
        return msVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(com.ss.android.socialbase.downloader.c.ms msVar) {
        synchronized (this.ka) {
            com.ss.android.socialbase.downloader.c.ms msVar2 = this.ch;
            if (msVar2 == null) {
                this.ch = msVar;
                this.ny = msVar;
                this.ka.notify();
            } else {
                msVar2.d = msVar;
                this.ch = msVar;
            }
        }
    }

    private void c() throws BaseException {
        Throwable th = this.u;
        if (th != null) {
            if (th instanceof ao) {
                throw new BaseException(1068, "async reader closed!");
            }
            c.ms(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }
}
