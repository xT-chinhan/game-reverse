package com.byazt.pj;

import android.os.SystemClock;
import com.byazt.hg.of;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 13})
public class hw {
    public String aj;
    public long c;
    public long fw;
    public long hn;
    public int pr;
    public long uc;
    public long x;
    public of zo;
    public AtomicBoolean hw = new AtomicBoolean(false);
    public AtomicLong vk = new AtomicLong(0);
    public AtomicInteger w = new AtomicInteger(0);
    public AtomicLong k = new AtomicLong(0);
    public volatile boolean m = false;

    public hw(of ofVar, String str) {
        this.zo = ofVar;
        this.aj = str;
    }

    public void pr(boolean z) {
        this.m = z;
    }

    public boolean pr() {
        return this.m;
    }

    private void pr(long j) {
        if (this.hn <= 0) {
            this.hn = j;
        }
    }

    private void hw(long j) {
        if (this.x <= 0) {
            this.x = j;
        }
    }

    private void hn(long j) {
        if (this.c <= 0) {
            this.c = j;
        }
    }

    private void x(long j) {
        if (this.uc <= 0) {
            this.uc = j;
        }
    }

    private void c(long j) {
        if (this.fw <= 0) {
            this.fw = j;
        }
    }

    public void pr(int i) {
        if (x(i)) {
            return;
        }
        int i2 = this.w.get();
        this.pr++;
        if (i2 != 13 && i2 != 15 && this.k.get() != 0) {
            pr(SystemClock.elapsedRealtime(), i);
        } else if (i2 == 14) {
            com.byazt.xk.hw.pr().pr(this.zo, "attach");
        }
    }

    private void hw(int i) {
        this.w.set(i);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime == 0) {
            com.byazt.xk.hw.pr().pr(this.zo, "currentElapsedRealTime");
        }
        switch (i) {
            case 11:
                this.vk.set(jElapsedRealtime);
                this.k.set(jElapsedRealtime);
                break;
            case 12:
                if (this.k.get() != 0) {
                    this.vk.set(jElapsedRealtime);
                }
                break;
            case 13:
                if (this.k.get() != 0) {
                    pr(jElapsedRealtime, i);
                }
                break;
            case 15:
                if (this.vk.get() != 0 && this.w.get() != 14) {
                    pr(jElapsedRealtime, i);
                    break;
                }
                break;
        }
    }

    private void pr(long j, int i) {
        pr.pr(String.valueOf(j - (this.vk.get() == 0 ? this.k : this.vk).get()), this.zo, this.aj, i, hw());
        this.vk.set(0L);
    }

    private boolean hn(int i) {
        return i == 56 || i == 51 || i == 52 || i == 57 || i == 55 || i == 53 || i == 54;
    }

    private boolean x(int i) {
        return !this.m && hn(i);
    }

    public void pr(float f, int i) {
        if (x(i)) {
            return;
        }
        pr(f);
        hw(i);
    }

    public void pr(float f) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f >= 1.0f) {
            pr(jCurrentTimeMillis);
            hw(jCurrentTimeMillis);
            hn(jCurrentTimeMillis);
            x(jCurrentTimeMillis);
            c(jCurrentTimeMillis);
            return;
        }
        double d = f;
        if (d >= 0.75d) {
            pr(jCurrentTimeMillis);
            hw(jCurrentTimeMillis);
            hn(jCurrentTimeMillis);
            x(jCurrentTimeMillis);
            return;
        }
        if (d >= 0.5d) {
            pr(jCurrentTimeMillis);
            hw(jCurrentTimeMillis);
            hn(jCurrentTimeMillis);
        } else if (d >= 0.25d) {
            pr(jCurrentTimeMillis);
            hw(jCurrentTimeMillis);
        } else if (f > 0.0f) {
            pr(jCurrentTimeMillis);
        }
    }

    public Map<String, Long> hw() {
        HashMap map = new HashMap();
        try {
            long j = this.hn;
            if (j > 0) {
                map.put("show_start", Long.valueOf(j));
                long j2 = this.x;
                if (j2 > 0) {
                    map.put("show_firstQuartile", Long.valueOf(j2));
                    long j3 = this.c;
                    if (j3 > 0) {
                        map.put("show_mid", Long.valueOf(j3));
                        long j4 = this.uc;
                        if (j4 > 0) {
                            map.put("show_thirdQuartile", Long.valueOf(j4));
                            long j5 = this.fw;
                            if (j5 > 0) {
                                map.put("show_full", Long.valueOf(j5));
                            } else {
                                return map;
                            }
                        } else {
                            return map;
                        }
                    } else {
                        return map;
                    }
                } else {
                    return map;
                }
            } else {
                return map;
            }
        } catch (Exception e) {
        }
        return map;
    }
}
