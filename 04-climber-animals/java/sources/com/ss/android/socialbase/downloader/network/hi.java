package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4726ms = "hi";
    private int ab;
    private volatile boolean ah;
    private final ArrayList<Object> c;
    private final AtomicReference<sl> d;
    private AtomicReference<sl> ka;
    private final d xr;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static final hi f4728ms = new hi(null);
    }

    /* synthetic */ hi(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static hi ms() {
        return ms.f4728ms;
    }

    private hi() {
        this.xr = new d(0.05d);
        this.ah = false;
        this.d = new AtomicReference<>(sl.UNKNOWN);
        this.c = new ArrayList<>();
    }

    public synchronized void ms(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.xr.ms(d);
            sl slVarXr = xr();
            if (this.ah) {
                this.ab++;
                if (slVarXr != this.ka.get()) {
                    this.ah = false;
                    this.ab = 1;
                }
                if (this.ab >= 5.0d && ah()) {
                    this.ah = false;
                    this.ab = 1;
                    this.d.set(this.ka.get());
                    d();
                }
                return;
            }
            if (this.d.get() != slVarXr) {
                this.ah = true;
                this.ka = new AtomicReference<>(slVarXr);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean ah() {
        double d;
        if (this.xr == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.f4727ms[this.d.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double dMs = this.xr.ms();
            if (dMs > d2) {
                if (dMs > d2 * 1.25d) {
                    return true;
                }
            } else if (dMs < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.hi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f4727ms;

        static {
            int[] iArr = new int[sl.values().length];
            f4727ms = iArr;
            try {
                iArr[sl.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4727ms[sl.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4727ms[sl.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4727ms[sl.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public synchronized sl xr() {
        d dVar = this.xr;
        if (dVar == null) {
            return sl.UNKNOWN;
        }
        try {
            return ms(dVar.ms());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return sl.UNKNOWN;
        }
    }

    private sl ms(double d) {
        if (d < 0.0d) {
            return sl.UNKNOWN;
        }
        if (d < 150.0d) {
            return sl.POOR;
        }
        if (d < 550.0d) {
            return sl.MODERATE;
        }
        if (d < 2000.0d) {
            return sl.GOOD;
        }
        return sl.EXCELLENT;
    }

    private void d() {
        try {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i);
                this.d.get();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }
}
