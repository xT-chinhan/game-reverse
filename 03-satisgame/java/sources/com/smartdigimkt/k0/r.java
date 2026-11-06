package com.smartdigimkt.k0;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final AudioTrack a;
    public final AudioTimestamp b = new AudioTimestamp();
    public long c;
    public long d;
    public long e;

    public r(AudioTrack audioTrack) {
        this.a = audioTrack;
    }

    public final long a() {
        return this.b.nanoTime / 1000;
    }

    public final boolean b() {
        boolean timestamp = this.a.getTimestamp(this.b);
        if (timestamp) {
            long j = this.b.framePosition;
            if (this.d > j) {
                this.c++;
            }
            this.d = j;
            this.e = j + (this.c << 32);
        }
        return timestamp;
    }
}
