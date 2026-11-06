package com.byazt.edb;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 444, 109})
public class w {
    public static final String pr = w.class.getSimpleName();
    public AtomicReference<k> c;
    public int fw;
    public volatile boolean hn;
    public final x hw;
    public final ArrayList<Object> uc;
    public final AtomicReference<k> x;

    @com.byazt.vzx.pr(pr = {0, 1, 444, 1272})
    private static class pr {
        public static final w pr = new w(null);
    }

    public /* synthetic */ w(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static w pr() {
        return pr.pr;
    }

    private w() {
        this.hw = new x(0.05d);
        this.hn = false;
        this.x = new AtomicReference<>(k.UNKNOWN);
        this.uc = new ArrayList<>();
    }

    public synchronized void pr(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.hw.pr(d);
            k kVarHw = hw();
            if (this.hn) {
                this.fw++;
                if (kVarHw != this.c.get()) {
                    this.hn = false;
                    this.fw = 1;
                }
                if (this.fw >= 5.0d && hn()) {
                    this.hn = false;
                    this.fw = 1;
                    this.x.set(this.c.get());
                    x();
                }
                return;
            }
            if (this.x.get() != kVarHw) {
                this.hn = true;
                this.c = new AtomicReference<>(kVarHw);
            }
        } catch (Throwable th) {
        }
    }

    private boolean hn() {
        if (this.hw == null) {
            return false;
        }
        try {
            double d = 2000.0d;
            double d2 = 550.0d;
            switch (AnonymousClass1.pr[this.x.get().ordinal()]) {
                case 1:
                    d2 = 0.0d;
                    d = 150.0d;
                    break;
                case 2:
                    d = 550.0d;
                    d2 = 150.0d;
                    break;
                case 3:
                    break;
                case 4:
                    d = 3.4028234663852886E38d;
                    d2 = 2000.0d;
                    break;
                default:
                    return true;
            }
            double dPr = this.hw.pr();
            if (dPr > d) {
                if (dPr > d * 1.25d) {
                    return true;
                }
            } else if (dPr < d2 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* JADX INFO: renamed from: com.byazt.edb.w$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 444, 445})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[k.values().length];
            pr = iArr;
            try {
                iArr[k.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[k.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[k.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[k.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public synchronized k hw() {
        x xVar = this.hw;
        if (xVar == null) {
            return k.UNKNOWN;
        }
        try {
            return pr(xVar.pr());
        } catch (Throwable th) {
            return k.UNKNOWN;
        }
    }

    private k pr(double d) {
        if (d < 0.0d) {
            return k.UNKNOWN;
        }
        if (d < 150.0d) {
            return k.POOR;
        }
        if (d < 550.0d) {
            return k.MODERATE;
        }
        if (d < 2000.0d) {
            return k.GOOD;
        }
        return k.EXCELLENT;
    }

    private void x() {
        try {
            int size = this.uc.size();
            for (int i = 0; i < size; i++) {
                this.uc.get(i);
                this.x.get();
            }
        } catch (Throwable th) {
        }
    }
}
