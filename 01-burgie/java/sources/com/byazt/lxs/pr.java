package com.byazt.lxs;

import android.app.Notification;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 37})
public abstract class pr {
    public boolean aj;
    public String c;
    public long fw;
    public long hn;
    public int hw;
    public Notification pr;
    public int uc = 0;
    public long x;
    public int zo;

    public abstract void pr(BaseException baseException, boolean z);

    public pr(int i, String str) {
        this.hw = i;
        this.c = str;
    }

    public void pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.hw = downloadInfo.getId();
        this.c = downloadInfo.getTitle();
    }

    public int pr() {
        return this.hw;
    }

    public long hw() {
        return this.hn;
    }

    public void pr(long j) {
        this.hn = j;
    }

    public long hn() {
        return this.x;
    }

    public void hw(long j) {
        this.x = j;
    }

    public String x() {
        return this.c;
    }

    public int c() {
        return this.uc;
    }

    public void pr(int i, BaseException baseException, boolean z) {
        pr(i, baseException, z, false);
    }

    public void pr(int i, BaseException baseException, boolean z, boolean z2) {
        if (!z2 && this.uc == i) {
            return;
        }
        this.uc = i;
        pr(baseException, z);
    }

    public long uc() {
        if (this.fw == 0) {
            this.fw = System.currentTimeMillis();
        }
        return this.fw;
    }

    public void pr(long j, long j2) {
        this.hn = j;
        this.x = j2;
        this.uc = 4;
        pr((BaseException) null, false);
    }

    public void pr(Notification notification) {
        if (this.hw == 0 || notification == null) {
            return;
        }
        hw.pr().pr(this.hw, this.uc, notification);
    }

    public synchronized void fw() {
        this.zo++;
    }

    public boolean zo() {
        return this.aj;
    }
}
