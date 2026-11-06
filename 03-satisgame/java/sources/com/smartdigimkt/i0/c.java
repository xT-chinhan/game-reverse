package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final com.smartdigimkt.y0.l a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public int h;
    public boolean i;

    public c() {
        com.smartdigimkt.y0.l lVar = new com.smartdigimkt.y0.l();
        a(2500, 0, "bufferForPlaybackMs", "0");
        a(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(15000, 2500, "minBufferMs", "bufferForPlaybackMs");
        a(15000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(50000, 15000, "maxBufferMs", "minBufferMs");
        this.a = lVar;
        this.b = ((long) 15000) * 1000;
        this.c = ((long) 50000) * 1000;
        this.d = ((long) 2500) * 1000;
        this.e = ((long) 5000) * 1000;
        this.f = -1;
        this.g = true;
    }

    public final void a(boolean z) {
        this.h = 0;
        this.i = false;
        if (z) {
            com.smartdigimkt.y0.l lVar = this.a;
            synchronized (lVar) {
                lVar.a(0);
            }
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        com.smartdigimkt.z0.a.a(str + " cannot be less than " + str2, i >= i2);
    }
}
