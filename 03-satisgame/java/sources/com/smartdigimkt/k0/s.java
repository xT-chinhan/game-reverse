package com.smartdigimkt.k0;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public final r a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;

    public s(AudioTrack audioTrack) {
        if (com.smartdigimkt.z0.u.a >= 19) {
            this.a = new r(audioTrack);
            a();
        } else {
            this.a = null;
            a(3);
        }
    }

    public final void a() {
        if (this.a != null) {
            a(0);
        }
    }

    public final void a(int i) {
        this.b = i;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000;
            this.d = 5000L;
            return;
        }
        if (i == 1) {
            this.d = 5000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.d = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.d = 500000L;
        }
    }
}
