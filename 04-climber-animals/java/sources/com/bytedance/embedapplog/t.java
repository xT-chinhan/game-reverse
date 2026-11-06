package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
abstract class t {
    private boolean ah;
    private volatile boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final b f525ms;
    private int xr = 0;

    abstract boolean ah();

    abstract String d();

    abstract long ms();

    abstract long[] xr();

    t(b bVar) {
        this.f525ms = bVar;
    }

    void ka() {
        this.ah = true;
    }

    boolean c() {
        return this.ah;
    }

    final long ab() {
        boolean zAh;
        long jMs;
        long jMs2 = ms();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.d) {
            this.d = false;
            jMs2 = 0;
        }
        if (jMs2 > 1000 + jCurrentTimeMillis) {
            return jMs2 - jCurrentTimeMillis;
        }
        try {
            zAh = ah();
        } catch (Exception e) {
            oh.xr(e);
            zAh = false;
        }
        if (zAh) {
            this.xr = 0;
            jMs = ms() - System.currentTimeMillis();
        } else {
            long[] jArrXr = xr();
            int i = this.xr;
            this.xr = i + 1;
            jMs = jArrXr[i % jArrXr.length];
        }
        oh.d(d() + " worked:" + zAh + " " + jMs, null);
        return jMs;
    }

    void x() {
        oh.ms("setImmediately, " + d());
        this.d = true;
    }
}
