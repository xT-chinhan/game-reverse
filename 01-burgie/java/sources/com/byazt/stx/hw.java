package com.byazt.stx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 13})
public class hw implements c, hn, x {
    public pr aj;
    public pr c;
    public pr fw;
    public final int hw;
    public final int pr;
    public pr uc;
    public volatile boolean vk;
    public int w;
    public pr zo;
    public final Object hn = new Object();
    public final Object x = new Object();

    public hw(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.pr = i;
        this.hw = i2;
    }

    @Override // com.byazt.stx.x
    public pr pr() throws InterruptedException, nt {
        pr prVar;
        pr prVar2 = this.aj;
        if (prVar2 != null) {
            this.aj = prVar2.x;
            prVar2.x = null;
            return prVar2;
        }
        synchronized (this.x) {
            prVar = this.fw;
            while (prVar == null) {
                if (this.vk) {
                    throw new nt("read");
                }
                this.x.wait();
                prVar = this.fw;
            }
            this.aj = prVar.x;
            this.zo = null;
            this.fw = null;
            prVar.x = null;
        }
        return prVar;
    }

    @Override // com.byazt.stx.hn
    public void pr(pr prVar) {
        synchronized (this.hn) {
            pr prVar2 = this.uc;
            if (prVar2 == null) {
                this.uc = prVar;
                this.c = prVar;
            } else {
                prVar2.x = prVar;
                this.uc = prVar;
            }
            this.hn.notify();
        }
    }

    @Override // com.byazt.stx.hn
    public pr hw() throws InterruptedException, nt {
        synchronized (this.hn) {
            if (this.vk) {
                throw new nt("obtain");
            }
            pr prVar = this.c;
            if (prVar == null) {
                int i = this.w;
                if (i < this.pr) {
                    this.w = i + 1;
                    return new pr(this.hw);
                }
                do {
                    this.hn.wait();
                    if (this.vk) {
                        throw new nt("obtain");
                    }
                    prVar = this.c;
                } while (prVar == null);
            }
            this.c = prVar.x;
            if (prVar == this.uc) {
                this.uc = null;
            }
            prVar.x = null;
            return prVar;
        }
    }

    @Override // com.byazt.stx.c
    public void hw(pr prVar) {
        synchronized (this.x) {
            pr prVar2 = this.zo;
            if (prVar2 == null) {
                this.zo = prVar;
                this.fw = prVar;
                this.x.notify();
            } else {
                prVar2.x = prVar;
                this.zo = prVar;
            }
        }
    }

    public void hn() {
        this.vk = true;
        synchronized (this.hn) {
            this.hn.notifyAll();
        }
        synchronized (this.x) {
            this.x.notifyAll();
        }
    }
}
