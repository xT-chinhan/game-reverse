package com.smartdigimkt.i0;

import androidx.core.view.PointerIconCompat;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final int a;
    public static final UUID b;

    static {
        a = com.smartdigimkt.z0.u.a < 23 ? PointerIconCompat.TYPE_GRAB : 6396;
        b = new UUID(0L, 0L);
        new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-2129748144642739255L, 8654423357094679310L);
        new UUID(-1301668207276963122L, -6645017420763422227L);
        new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long b(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }
}
