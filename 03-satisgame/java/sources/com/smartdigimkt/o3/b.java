package com.smartdigimkt.o3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public a a;
    public long b = 500;
    public boolean c = true;
    public final long d;
    public long e;

    public b(long j) {
        this.d = j;
        this.e = j;
    }

    public abstract void a();

    public abstract void a(long j);

    public final synchronized void a(long j, long j2) {
        this.e = j;
        this.b = j2;
        if (this.d > 0 && j2 > 0) {
            if (!this.c) {
                c();
            }
            if (this.c) {
                a aVar = new a(this, this.e, this.b);
                this.a = aVar;
                try {
                    aVar.start();
                } catch (Throwable unused) {
                }
                this.c = false;
            }
        }
    }

    public final void b() {
        if (this.c) {
            return;
        }
        try {
            this.a.cancel();
        } catch (Throwable unused) {
        }
        this.c = true;
    }

    public final void c() {
        try {
            this.a.cancel();
        } catch (Throwable unused) {
        }
        this.c = true;
        this.e = this.d;
    }
}
