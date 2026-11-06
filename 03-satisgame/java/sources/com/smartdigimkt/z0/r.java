package com.smartdigimkt.z0;

import com.bykv.vk.component.ttvideo.player.C;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final long a;
    public long b;
    public volatile long c = -9223372036854775807L;

    public r(long j) {
        synchronized (this) {
            if (this.c != -9223372036854775807L) {
                throw new IllegalStateException();
            }
            this.a = j;
        }
    }

    public final long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            this.c = j;
        } else {
            long j2 = this.a;
            if (j2 != LongCompanionObject.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }

    public final long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            long j2 = (this.c * 90000) / C.MICROS_PER_SECOND;
            long j3 = (4294967296L + j2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - j2) < Math.abs(j - j2)) {
                j = j4;
            }
        }
        return a((j * C.MICROS_PER_SECOND) / 90000);
    }
}
