package com.byazt.eji;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, 19})
public class n {
    public final int n;
    public final int[] qg;
    public final Object s = new Object();
    public long q = s();

    public n(int i) {
        this.n = i;
        this.qg = new int[i];
    }

    public void n() {
        long jS = s();
        synchronized (this.s) {
            n(jS);
            int[] iArr = this.qg;
            int i = (int) (jS % ((long) this.n));
            iArr[i] = iArr[i] + 1;
        }
    }

    public int qg() {
        int i;
        long jS = s();
        synchronized (this.s) {
            n(jS);
            i = 0;
            for (int i2 = 0; i2 < this.n; i2++) {
                i += this.qg[i2];
            }
        }
        return i;
    }

    private void n(long j) {
        long j2 = j - this.q;
        if (j2 <= 0) {
            return;
        }
        if (j2 < this.n) {
            int i = 1;
            while (true) {
                long j3 = i;
                if (j3 > j2) {
                    break;
                }
                this.qg[(int) ((this.q + j3) % ((long) this.n))] = 0;
                i++;
            }
        } else {
            for (int i2 = 0; i2 < this.n; i2++) {
                this.qg[i2] = 0;
            }
        }
        this.q = j;
    }

    private long s() {
        return SystemClock.elapsedRealtime() / 1000;
    }
}
