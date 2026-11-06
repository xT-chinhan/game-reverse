package com.byazt.nzn;

import com.byazt.jv.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 109})
public class w {
    public long c;
    public long fw;
    public long hn;
    public long hw;
    public long pr;
    public long uc;
    public long x;

    public w() {
        this.pr = System.currentTimeMillis();
    }

    public w(Object obj) {
        this.pr = System.currentTimeMillis();
        try {
            if (obj instanceof ve) {
                ve veVar = (ve) obj;
                this.pr = veVar.x();
                this.hw = veVar.vk();
                this.hn = veVar.c();
                this.x = veVar.uc();
                this.c = veVar.fw();
                this.uc = veVar.zo();
                this.fw = veVar.aj();
            }
        } catch (Throwable th) {
        }
    }

    public void pr() {
        this.hn = System.currentTimeMillis();
    }

    public void hw() {
        this.x = System.currentTimeMillis();
    }

    public void hn() {
        this.c = System.currentTimeMillis();
    }

    public void pr(long j) {
        this.uc = j;
    }

    public void hw(long j) {
        this.fw = j;
    }

    public void x() {
        this.hw = System.currentTimeMillis();
    }
}
