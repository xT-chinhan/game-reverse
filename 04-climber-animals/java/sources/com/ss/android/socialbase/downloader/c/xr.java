package com.ss.android.socialbase.downloader.c;

/* JADX INFO: loaded from: classes3.dex */
class xr implements ah, d, ka {
    private ms ab;
    private ms c;
    private volatile boolean ch;
    private int hi;
    private ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f4624ms;
    private ms ny;
    private ms x;
    private final int xr;
    private final Object ah = new Object();
    private final Object d = new Object();

    xr(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f4624ms = i;
        this.xr = i2;
    }

    @Override // com.ss.android.socialbase.downloader.c.d
    public ms ms() throws InterruptedException, ao {
        ms msVar;
        ms msVar2 = this.ny;
        if (msVar2 != null) {
            this.ny = msVar2.d;
            msVar2.d = null;
            return msVar2;
        }
        synchronized (this.d) {
            msVar = this.ab;
            while (msVar == null) {
                if (this.ch) {
                    throw new ao("read");
                }
                this.d.wait();
                msVar = this.ab;
            }
            this.ny = msVar.d;
            this.x = null;
            this.ab = null;
            msVar.d = null;
        }
        return msVar;
    }

    @Override // com.ss.android.socialbase.downloader.c.ah
    public void ms(ms msVar) {
        synchronized (this.ah) {
            ms msVar2 = this.c;
            if (msVar2 == null) {
                this.c = msVar;
                this.ka = msVar;
            } else {
                msVar2.d = msVar;
                this.c = msVar;
            }
            this.ah.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.ah
    public ms xr() throws InterruptedException, ao {
        synchronized (this.ah) {
            if (this.ch) {
                throw new ao("obtain");
            }
            ms msVar = this.ka;
            if (msVar == null) {
                int i = this.hi;
                if (i < this.f4624ms) {
                    this.hi = i + 1;
                    return new ms(this.xr);
                }
                do {
                    this.ah.wait();
                    if (this.ch) {
                        throw new ao("obtain");
                    }
                    msVar = this.ka;
                } while (msVar == null);
            }
            this.ka = msVar.d;
            if (msVar == this.c) {
                this.c = null;
            }
            msVar.d = null;
            return msVar;
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.ka
    public void xr(ms msVar) {
        synchronized (this.d) {
            ms msVar2 = this.x;
            if (msVar2 == null) {
                this.x = msVar;
                this.ab = msVar;
                this.d.notify();
            } else {
                msVar2.d = msVar;
                this.x = msVar;
            }
        }
    }

    public void ah() {
        this.ch = true;
        synchronized (this.ah) {
            this.ah.notifyAll();
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }
}
