package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static int pr = -1;
    public static int hw = 0;
    public static int hn = 1;
    public static int x = 2;
    public static int c = 3;
    public int uc = pr;
    public long fw = 0;
    public long zo = 0;
    public long aj = 0;
    public final List<uc> vk = new ArrayList();

    public void pr(long j) {
        this.uc = hw;
        this.fw = j;
    }

    public void hw(long j) {
        int i;
        int i2 = this.uc;
        if (i2 == pr || i2 == (i = c)) {
            return;
        }
        this.uc = i;
        this.aj = j;
    }

    public void hn(long j) {
        int i;
        int i2 = this.uc;
        if (i2 == pr || i2 == (i = x) || i2 == c) {
            return;
        }
        this.uc = i;
        this.zo = j;
    }

    public void x(long j) {
        int i = this.uc;
        if (i == pr || i != x) {
            return;
        }
        this.uc = hn;
        this.vk.add(new uc(this.zo, j));
        this.zo = 0L;
    }

    public long pr(long j, long j2) {
        long j3 = this.aj;
        if (j3 != 0 && j > j3) {
            return 0L;
        }
        int iHw = 0;
        for (uc ucVar : this.vk) {
            if (ucVar.hw() > j) {
                if (j < ucVar.pr()) {
                    iHw = (int) (((long) iHw) + (ucVar.hw() - ucVar.pr()));
                } else {
                    iHw = (int) (((long) iHw) + (ucVar.hw() - j));
                }
            }
        }
        long j4 = this.fw;
        if (j4 < j) {
            long j5 = this.zo;
            if (j5 != 0) {
                if (j5 > j) {
                    return (j5 - j) - ((long) iHw);
                }
                return 0L;
            }
            long j6 = this.aj;
            if (j6 != 0) {
                return (j6 - j) - ((long) iHw);
            }
            return (j2 - j) - ((long) iHw);
        }
        long j7 = this.zo;
        if (j7 != 0) {
            if (j7 > j4) {
                return (j7 - j4) - ((long) iHw);
            }
            return 0L;
        }
        long j8 = this.aj;
        if (j8 != 0) {
            return (j8 - j4) - ((long) iHw);
        }
        return (j2 - j4) - ((long) iHw);
    }

    public int pr() {
        return this.uc;
    }
}
