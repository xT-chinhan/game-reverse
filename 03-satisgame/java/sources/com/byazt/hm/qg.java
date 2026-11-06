package com.byazt.hm;

import android.os.SystemClock;
import com.byazt.gct.pk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 26})
public class qg {
    public pk fs;
    public long l;
    public int n;
    public long q;
    public String rv;
    public long s;
    public long w;
    public long x;
    public AtomicBoolean qg = new AtomicBoolean(false);
    public AtomicLong tj = new AtomicLong(0);
    public AtomicInteger cp = new AtomicInteger(0);
    public AtomicLong d = new AtomicLong(0);
    public volatile boolean oa = false;

    private boolean s(int i) {
        return i == 56 || i == 51 || i == 52 || i == 57 || i == 55 || i == 53 || i == 54;
    }

    public qg(pk pkVar, String str) {
        this.fs = pkVar;
        this.rv = str;
    }

    public void n(boolean z) {
        this.oa = z;
    }

    public boolean n() {
        return this.oa;
    }

    private void n(long j) {
        if (this.s <= 0) {
            this.s = j;
        }
    }

    private void qg(long j) {
        if (this.q <= 0) {
            this.q = j;
        }
    }

    private void s(long j) {
        if (this.l <= 0) {
            this.l = j;
        }
    }

    private void q(long j) {
        if (this.w <= 0) {
            this.w = j;
        }
    }

    private void l(long j) {
        if (this.x <= 0) {
            this.x = j;
        }
    }

    public void n(int i) {
        if (q(i)) {
            return;
        }
        int i2 = this.cp.get();
        this.n++;
        if (i2 != 13 && i2 != 15 && this.d.get() != 0) {
            n(SystemClock.elapsedRealtime(), i);
        } else if (i2 == 14) {
            com.byazt.eji.s.n().n(this.fs, "attach");
        }
    }

    private void qg(int i) {
        this.cp.set(i);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime == 0) {
            com.byazt.eji.s.n().n(this.fs, "currentElapsedRealTime");
        }
        switch (i) {
            case 11:
                this.tj.set(jElapsedRealtime);
                this.d.set(jElapsedRealtime);
                break;
            case 12:
                if (this.d.get() != 0) {
                    this.tj.set(jElapsedRealtime);
                }
                break;
            case 13:
                if (this.d.get() != 0) {
                    n(jElapsedRealtime, i);
                }
                break;
            case 15:
                if (this.tj.get() != 0 && this.cp.get() != 14) {
                    n(jElapsedRealtime, i);
                    break;
                }
                break;
        }
    }

    private void n(long j, int i) {
        n.n(String.valueOf(j - (this.tj.get() == 0 ? this.d : this.tj).get()), this.fs, this.rv, i, qg());
        this.tj.set(0L);
    }

    private boolean q(int i) {
        return !this.oa && s(i);
    }

    public void n(float f, int i) {
        if (q(i)) {
            return;
        }
        n(f);
        qg(i);
    }

    public void n(float f) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f >= 1.0f) {
            n(jCurrentTimeMillis);
            qg(jCurrentTimeMillis);
            s(jCurrentTimeMillis);
            q(jCurrentTimeMillis);
            l(jCurrentTimeMillis);
            return;
        }
        double d = f;
        if (d >= 0.75d) {
            n(jCurrentTimeMillis);
            qg(jCurrentTimeMillis);
            s(jCurrentTimeMillis);
            q(jCurrentTimeMillis);
            return;
        }
        if (d >= 0.5d) {
            n(jCurrentTimeMillis);
            qg(jCurrentTimeMillis);
            s(jCurrentTimeMillis);
        } else if (d >= 0.25d) {
            n(jCurrentTimeMillis);
            qg(jCurrentTimeMillis);
        } else if (f > 0.0f) {
            n(jCurrentTimeMillis);
        }
    }

    public Map<String, Long> qg() {
        HashMap map = new HashMap();
        try {
            long j = this.s;
            if (j > 0) {
                map.put("show_start", Long.valueOf(j));
                long j2 = this.q;
                if (j2 > 0) {
                    map.put("show_firstQuartile", Long.valueOf(j2));
                    long j3 = this.l;
                    if (j3 > 0) {
                        map.put("show_mid", Long.valueOf(j3));
                        long j4 = this.w;
                        if (j4 > 0) {
                            map.put("show_thirdQuartile", Long.valueOf(j4));
                            long j5 = this.x;
                            if (j5 > 0) {
                                map.put("show_full", Long.valueOf(j5));
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }
}
