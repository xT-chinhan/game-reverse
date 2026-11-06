package com.byazt.ax;

import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.wt.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 121})
public class x {
    public c c;
    public of hn;
    public final TTBaseVideoActivity hw;
    public boolean pr;
    public boolean uc = false;
    public hw x;

    public x(TTBaseVideoActivity tTBaseVideoActivity) {
        this.hw = tTBaseVideoActivity;
    }

    public void pr(hw hwVar, of ofVar, String str, c cVar) {
        if (this.uc) {
            return;
        }
        this.uc = true;
        this.x = hwVar;
        this.hn = ofVar;
        this.c = cVar;
    }

    public void pr() {
        if (ny.hw(this.hn) && !this.x.e()) {
            x();
        }
    }

    public void pr(boolean z) {
        hw hwVar = this.x;
        if (hwVar == null || !hwVar.gz()) {
            return;
        }
        this.pr = z;
        this.c.x(z);
        this.x.pr(this.pr);
    }

    public void hw() {
        if (!ny.hw(this.hn)) {
            return;
        }
        if (this.x.e() || x()) {
            boolean z = !this.pr;
            this.pr = z;
            this.x.pr(z);
        }
    }

    public void pr(boolean z, boolean z2) {
        this.x.z();
        pr(z);
        hw(z2);
    }

    public void hn() {
        this.x.ve();
        this.c.pr(this.hw.bm().vj());
    }

    public boolean x() {
        hw hwVar = this.x;
        if (hwVar != null) {
            return hwVar.nl();
        }
        return false;
    }

    public boolean c() {
        if (!ny.hn(this.hn)) {
            return false;
        }
        return this.x.n();
    }

    public void hw(boolean z) {
        this.x.uc(z);
    }

    public void pr(int i, int i2) {
        this.x.hw(i, i2);
    }

    public void pr(of ofVar) {
        this.hn = ofVar;
    }

    public boolean uc() {
        return this.pr;
    }
}
