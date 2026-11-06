package com.byazt.m;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 29})
public class cp {
    public static final String n = "cp";
    public AtomicReference<d> l;
    public final AtomicReference<d> q;
    public final q qg;
    public volatile boolean s;
    public final ArrayList<Object> w;
    public int x;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 570})
    private static class n {
        public static final cp n = new cp(null);
    }

    public /* synthetic */ cp(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cp n() {
        return n.n;
    }

    private cp() {
        this.qg = new q(0.05d);
        this.s = false;
        this.q = new AtomicReference<>(d.UNKNOWN);
        this.w = new ArrayList<>();
    }

    public synchronized void n(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.qg.n(d);
            d dVarQg = qg();
            if (this.s) {
                this.x++;
                if (dVarQg != this.l.get()) {
                    this.s = false;
                    this.x = 1;
                }
                if (this.x >= 5.0d && s()) {
                    this.s = false;
                    this.x = 1;
                    this.q.set(this.l.get());
                    q();
                }
                return;
            }
            if (this.q.get() != dVarQg) {
                this.s = true;
                this.l = new AtomicReference<>(dVarQg);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        double d;
        if (this.qg == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.n[this.q.get().ordinal()];
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
            double dN = this.qg.n();
            if (dN > d2) {
                if (dN > d2 * 1.25d) {
                    return true;
                }
            } else if (dN < d * 0.8d) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: com.byazt.m.cp$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, 67})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[d.values().length];
            n = iArr;
            try {
                iArr[d.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[d.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[d.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[d.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public synchronized d qg() {
        q qVar = this.qg;
        if (qVar == null) {
            return d.UNKNOWN;
        }
        try {
            return n(qVar.n());
        } catch (Throwable unused) {
            return d.UNKNOWN;
        }
    }

    private d n(double d) {
        if (d < 0.0d) {
            return d.UNKNOWN;
        }
        if (d < 150.0d) {
            return d.POOR;
        }
        if (d < 550.0d) {
            return d.MODERATE;
        }
        if (d < 2000.0d) {
            return d.GOOD;
        }
        return d.EXCELLENT;
    }

    private void q() {
        try {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                this.w.get(i);
                this.q.get();
            }
        } catch (Throwable unused) {
        }
    }
}
