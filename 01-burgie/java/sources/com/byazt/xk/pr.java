package com.byazt.xk;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 778, 37})
public class pr {
    public final int[] hw;
    public final int pr;
    public final Object hn = new Object();
    public long x = hn();

    public pr(int i) {
        this.pr = i;
        this.hw = new int[i];
    }

    public void pr() {
        long jHn = hn();
        synchronized (this.hn) {
            pr(jHn);
            int[] iArr = this.hw;
            int i = (int) (jHn % ((long) this.pr));
            iArr[i] = iArr[i] + 1;
        }
    }

    public int hw() {
        int i;
        long jHn = hn();
        synchronized (this.hn) {
            pr(jHn);
            i = 0;
            for (int i2 = 0; i2 < this.pr; i2++) {
                i += this.hw[i2];
            }
        }
        return i;
    }

    private void pr(long j) {
        long j2 = j - this.x;
        if (j2 <= 0) {
            return;
        }
        if (j2 >= this.pr) {
            for (int i = 0; i < this.pr; i++) {
                this.hw[i] = 0;
            }
        } else {
            int i2 = 1;
            while (true) {
                long j3 = i2;
                if (j3 > j2) {
                    break;
                }
                this.hw[(int) ((this.x + j3) % ((long) this.pr))] = 0;
                i2++;
            }
        }
        this.x = j;
    }

    private long hn() {
        return SystemClock.elapsedRealtime() / 1000;
    }
}
